package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.MTGCsvImporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CsvPreviewDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u000b*\u0001,\b\u0007\u0018\u0000 52\u00020\u0001:\u000245B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\rH\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0016H\u0002J\u0018\u0010 \u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0002J\u0018\u0010$\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0005H\u0002J8\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00162\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070'2\u0006\u0010!\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u0013H\u0002J\u001d\u0010+\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010-J6\u0010.\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070'2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0018\u00100\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0018\u00101\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u00102\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0016H\u0002J\u0010\u00103\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\b\u001a$\u0012\u0004\u0012\u00020\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/studiolaganne/lengendarylens/CsvPreviewDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "parseResult", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$CsvParseResult;", "csvContent", "", "onContinue", "Lkotlin/Function2;", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ImportResult;", "", "", "", "onCancel", "Lkotlin/Function0;", "userMappings", "", "isMappingExpanded", "", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "setupViews", "setupPreviewTable", "result", "getFieldDisplayName", "field", "setupColumnMapping", "setupSetCodeSpinner", "options", "", "setNameMapping", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ColumnMapping;", "hasSetNameMapping", "createSpinnerListener", "com/studiolaganne/lengendarylens/CsvPreviewDialogFragment$createSpinnerListener$1", "(Landroid/view/View;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/CsvPreviewDialogFragment$createSpinnerListener$1;", "setupSpinner", "spinnerId", "setupWarningText", "setupButtons", "updateContinueButton", "handleContinue", "Builder", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CsvPreviewDialogFragment extends DialogFragment {
    public static final String TAG = "CsvPreviewDialogFragment";
    private String csvContent;
    private boolean isMappingExpanded;
    private Function0<Unit> onCancel;
    private Function2<? super MTGCsvImporter.ImportResult, ? super Map<String, Integer>, Unit> onContinue;
    private MTGCsvImporter.CsvParseResult parseResult;
    private Map<String, Integer> userMappings = new LinkedHashMap();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CsvPreviewDialogFragment.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ.\u0010\f\u001a\u00020\u00002&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00120\u000eJ\u0014\u0010\u0013\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/CsvPreviewDialogFragment$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/CsvPreviewDialogFragment;", "setParseResult", "result", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$CsvParseResult;", "setCsvContent", FirebaseAnalytics.Param.CONTENT, "", "setOnContinue", "callback", "Lkotlin/Function2;", "Lcom/studiolaganne/lengendarylens/MTGCsvImporter$ImportResult;", "", "", "", "setOnCancel", "Lkotlin/Function0;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final CsvPreviewDialogFragment dialogFragment = new CsvPreviewDialogFragment();

        public final Builder setCsvContent(String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.dialogFragment.csvContent = content;
            return this;
        }

        public final Builder setOnCancel(Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.dialogFragment.onCancel = callback;
            return this;
        }

        public final Builder setOnContinue(Function2<? super MTGCsvImporter.ImportResult, ? super Map<String, Integer>, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.dialogFragment.onContinue = callback;
            return this;
        }

        public final Builder setParseResult(MTGCsvImporter.CsvParseResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.dialogFragment.parseResult = result;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialogFragment, manager, tag);
        }
    }

    /* JADX INFO: compiled from: CsvPreviewDialogFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MTGCsvImporter.ConfidenceLevel.values().length];
            try {
                iArr[MTGCsvImporter.ConfidenceLevel.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MTGCsvImporter.ConfidenceLevel.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MTGCsvImporter.ConfidenceLevel.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MTGCsvImporter.ConfidenceLevel.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.studiolaganne.lengendarylens.CsvPreviewDialogFragment$createSpinnerListener$1] */
    private final AnonymousClass1 createSpinnerListener(final View view, final String field) {
        return new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.CsvPreviewDialogFragment.createSpinnerListener.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                CsvPreviewDialogFragment csvPreviewDialogFragment = CsvPreviewDialogFragment.this;
                if (position == 0) {
                    csvPreviewDialogFragment.userMappings.remove(field);
                } else {
                    csvPreviewDialogFragment.userMappings.put(field, Integer.valueOf(position - 1));
                }
                CsvPreviewDialogFragment.this.updateContinueButton(view);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final String getFieldDisplayName(String field) {
        switch (field.hashCode()) {
            case -1613589672:
                if (field.equals("language")) {
                    String string = getString(R.string.csv_field_language);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }
                return field;
            case -1285004149:
                if (field.equals(FirebaseAnalytics.Param.QUANTITY)) {
                    String string2 = getString(R.string.csv_field_quantity);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    return string2;
                }
                return field;
            case -1274442605:
                if (field.equals("finish")) {
                    String string3 = getString(R.string.csv_field_finish);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    return string3;
                }
                return field;
            case -861311717:
                if (field.equals("condition")) {
                    String string4 = getString(R.string.csv_field_condition);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    return string4;
                }
                return field;
            case 3373707:
                if (field.equals("name")) {
                    String string5 = getString(R.string.csv_field_name);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    return string5;
                }
                return field;
            case 1415059370:
                if (field.equals("set_code")) {
                    String string6 = getString(R.string.csv_field_set_code);
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    return string6;
                }
                return field;
            case 1415373896:
                if (field.equals("set_name")) {
                    String string7 = getString(R.string.csv_field_set_name);
                    Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                    return string7;
                }
                return field;
            case 1491944251:
                if (field.equals("collector_number")) {
                    String string8 = getString(R.string.csv_field_collector_number);
                    Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                    return string8;
                }
                return field;
            default:
                return field;
        }
    }

    private final void handleContinue(MTGCsvImporter.CsvParseResult result) {
        String str = this.csvContent;
        if (!result.getNeedsUserMapping() || str == null || this.userMappings.isEmpty()) {
            MTGCsvImporter.ImportResult importResult = new MTGCsvImporter.ImportResult(result.getContainers(), result.getErrors());
            Function2<? super MTGCsvImporter.ImportResult, ? super Map<String, Integer>, Unit> function2 = this.onContinue;
            if (function2 != null) {
                function2.invoke(importResult, null);
            }
        } else {
            MTGCsvImporter.ImportResult withUserMappings = new MTGCsvImporter().parseWithUserMappings(str, this.userMappings);
            Function2<? super MTGCsvImporter.ImportResult, ? super Map<String, Integer>, Unit> function22 = this.onContinue;
            if (function22 != null) {
                function22.invoke(withUserMappings, this.userMappings);
            }
        }
        dismiss();
    }

    private final void setupButtons(View view, final MTGCsvImporter.CsvParseResult result) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.cancelButton);
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.continueButton);
        Intrinsics.checkNotNull(materialButton);
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.CsvPreviewDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CsvPreviewDialogFragment.setupButtons$lambda$0(this.f$0);
            }
        });
        Intrinsics.checkNotNull(materialButton2);
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.CsvPreviewDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CsvPreviewDialogFragment.setupButtons$lambda$1(this.f$0, result);
            }
        });
        updateContinueButton(view);
    }

    static final Unit setupButtons$lambda$0(CsvPreviewDialogFragment csvPreviewDialogFragment) {
        Function0<Unit> function0 = csvPreviewDialogFragment.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
        csvPreviewDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit setupButtons$lambda$1(CsvPreviewDialogFragment csvPreviewDialogFragment, MTGCsvImporter.CsvParseResult csvParseResult) {
        csvPreviewDialogFragment.handleContinue(csvParseResult);
        return Unit.INSTANCE;
    }

    private final void setupColumnMapping(View view, MTGCsvImporter.CsvParseResult result) {
        Object obj;
        Object next;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.mappingSection);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.mappingHeader);
        final LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.mappingContent);
        final ImageView imageView = (ImageView) view.findViewById(R.id.mappingExpandIcon);
        TextView textView = (TextView) view.findViewById(R.id.mappingSubtitle);
        Iterator<T> it = result.getColumnMappings().iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                next = it.next();
                if (Intrinsics.areEqual(((MTGCsvImporter.ColumnMapping) next).getField(), "name")) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        MTGCsvImporter.ColumnMapping columnMapping = (MTGCsvImporter.ColumnMapping) next;
        boolean z = columnMapping == null || columnMapping.getColumnIndex() < 0 || result.getConfidence() == MTGCsvImporter.ConfidenceLevel.NONE;
        if (!result.getNeedsUserMapping() && result.getColumnMappings().isEmpty()) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        if (z) {
            textView.setText(getString(R.string.csv_mapping_required_hint));
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.warning_color));
            this.isMappingExpanded = true;
            linearLayout3.setVisibility(0);
            imageView.setRotation(180.0f);
        } else {
            textView.setText(getString(R.string.csv_column_mapping_hint));
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
        }
        Intrinsics.checkNotNull(linearLayout2);
        ViewExtensionsKt.setOnClickWithFade(linearLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.CsvPreviewDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CsvPreviewDialogFragment.setupColumnMapping$lambda$1(this.f$0, linearLayout3, imageView);
            }
        });
        List<String> listMutableListOf = CollectionsKt.mutableListOf(getString(R.string.csv_not_mapped));
        listMutableListOf.addAll(result.getHeaders());
        for (MTGCsvImporter.ColumnMapping columnMapping2 : result.getColumnMappings()) {
            if (columnMapping2.getColumnIndex() >= 0) {
                this.userMappings.put(columnMapping2.getField(), Integer.valueOf(columnMapping2.getColumnIndex()));
            }
        }
        Iterator<T> it2 = result.getColumnMappings().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (Intrinsics.areEqual(((MTGCsvImporter.ColumnMapping) next2).getField(), "set_name")) {
                obj = next2;
                break;
            }
        }
        MTGCsvImporter.ColumnMapping columnMapping3 = (MTGCsvImporter.ColumnMapping) obj;
        boolean z2 = columnMapping3 != null && columnMapping3.getColumnIndex() >= 0;
        setupSpinner(view, R.id.nameSpinner, "name", listMutableListOf, result);
        setupSpinner(view, R.id.quantitySpinner, FirebaseAnalytics.Param.QUANTITY, listMutableListOf, result);
        setupSetCodeSpinner(view, listMutableListOf, result, columnMapping3, z2);
        setupSpinner(view, R.id.collectorNumberSpinner, "collector_number", listMutableListOf, result);
    }

    static final Unit setupColumnMapping$lambda$1(CsvPreviewDialogFragment csvPreviewDialogFragment, LinearLayout linearLayout, ImageView imageView) {
        boolean z = csvPreviewDialogFragment.isMappingExpanded;
        csvPreviewDialogFragment.isMappingExpanded = !z;
        linearLayout.setVisibility(!z ? 0 : 8);
        imageView.animate().rotation(csvPreviewDialogFragment.isMappingExpanded ? 180.0f : 0.0f).setDuration(200L).start();
        return Unit.INSTANCE;
    }

    private final void setupPreviewTable(View view, MTGCsvImporter.CsvParseResult result) {
        Object next;
        int i;
        String str;
        Object next2;
        Integer num;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.previewTableContainer);
        linearLayout.removeAllViews();
        if (result.getHeaders().isEmpty()) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        int color = ContextCompat.getColor(contextRequireContext, R.color.almost_white);
        int color2 = ContextCompat.getColor(contextRequireContext, R.color.text_color);
        int color3 = ContextCompat.getColor(contextRequireContext, R.color.selected_color_new);
        IntRange indices = CollectionsKt.getIndices(result.getHeaders());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(indices, 10));
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            String str2 = result.getHeaders().get(iNextInt);
            Iterator<T> it2 = result.getColumnMappings().iterator();
            while (true) {
                if (it2.hasNext()) {
                    next2 = it2.next();
                    if (((MTGCsvImporter.ColumnMapping) next2).getColumnIndex() == iNextInt) {
                        break;
                    }
                } else {
                    next2 = null;
                    break;
                }
            }
            MTGCsvImporter.ColumnMapping columnMapping = (MTGCsvImporter.ColumnMapping) next2;
            String field = columnMapping != null ? columnMapping.getField() : null;
            if (field != null) {
                str2 = str2 + " (" + getFieldDisplayName(field) + ")";
            }
            Iterator it3 = CollectionsKt.take(result.getSampleRows(), 3).iterator();
            if (it3.hasNext()) {
                String str3 = (String) CollectionsKt.getOrNull((List) it3.next(), iNextInt);
                if (str3 == null) {
                    str3 = "";
                }
                Integer numValueOf = Integer.valueOf(str3.length() > 20 ? 20 : str3.length());
                while (true) {
                    num = numValueOf;
                    while (it3.hasNext()) {
                        String str4 = (String) CollectionsKt.getOrNull((List) it3.next(), iNextInt);
                        if (str4 == null) {
                            str4 = "";
                        }
                        numValueOf = Integer.valueOf(str4.length() > 20 ? 20 : str4.length());
                        if (num.compareTo(numValueOf) < 0) {
                            break;
                        }
                    }
                }
            } else {
                num = null;
            }
            Integer num2 = num;
            arrayList.add(Integer.valueOf(RangesKt.coerceIn((Math.max(str2.length(), num2 != null ? num2.intValue() : 0) * 16) + 32, 80, 200)));
        }
        int i2 = 16;
        ArrayList arrayList2 = arrayList;
        TableLayout tableLayout = new TableLayout(contextRequireContext);
        tableLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        tableLayout.setStretchAllColumns(false);
        TableRow tableRow = new TableRow(contextRequireContext);
        int i3 = 0;
        for (Object obj : result.getHeaders()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str5 = (String) obj;
            Iterator<T> it4 = result.getColumnMappings().iterator();
            while (true) {
                if (it4.hasNext()) {
                    next = it4.next();
                    if (((MTGCsvImporter.ColumnMapping) next).getColumnIndex() == i3) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            MTGCsvImporter.ColumnMapping columnMapping2 = (MTGCsvImporter.ColumnMapping) next;
            String field2 = columnMapping2 != null ? columnMapping2.getField() : null;
            TextView textView = new TextView(contextRequireContext);
            int i5 = color;
            if (field2 != null) {
                i = color3;
                str = str5 + "\n(" + getFieldDisplayName(field2) + ")";
            } else {
                i = color3;
                str = str5;
            }
            textView.setText(str);
            textView.setTextColor(field2 != null ? i : i5);
            textView.setTextSize(10.0f);
            textView.setTypeface(null, 1);
            int i6 = i2;
            textView.setPadding(i6, 6, i6, 6);
            textView.setWidth(((Number) arrayList2.get(i3)).intValue());
            textView.setMaxLines(3);
            tableRow.addView(textView);
            i3 = i4;
            color = i5;
            color3 = i;
            i2 = 16;
        }
        tableLayout.addView(tableRow);
        TableRow tableRow2 = new TableRow(contextRequireContext);
        View view2 = new View(contextRequireContext);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(-1, 1);
        layoutParams.span = result.getHeaders().size();
        layoutParams.topMargin = 4;
        layoutParams.bottomMargin = 4;
        view2.setLayoutParams(layoutParams);
        view2.setBackgroundColor(ContextCompat.getColor(contextRequireContext, R.color.text_color_transparent));
        tableRow2.addView(view2);
        tableLayout.addView(tableRow2);
        for (List list : CollectionsKt.take(result.getSampleRows(), 3)) {
            TableRow tableRow3 = new TableRow(contextRequireContext);
            Iterator<Integer> it5 = CollectionsKt.getIndices(result.getHeaders()).iterator();
            while (it5.hasNext()) {
                int iNextInt2 = ((IntIterator) it5).nextInt();
                String str6 = (String) CollectionsKt.getOrNull(list, iNextInt2);
                if (str6 == null) {
                    str6 = "";
                }
                if (str6.length() > 20) {
                    str6 = StringsKt.take(str6, 18) + "…";
                }
                TextView textView2 = new TextView(contextRequireContext);
                textView2.setText(str6);
                textView2.setTextColor(color2);
                textView2.setTextSize(11.0f);
                textView2.setPadding(16, 6, 16, 6);
                textView2.setWidth(((Number) arrayList2.get(iNextInt2)).intValue());
                textView2.setMaxLines(1);
                tableRow3.addView(textView2);
            }
            tableLayout.addView(tableRow3);
        }
        linearLayout.addView(tableLayout);
        if (result.getTotalRowCount() > 3) {
            TextView textView3 = new TextView(contextRequireContext);
            textView3.setText(getString(R.string.csv_rows_found, Integer.valueOf(result.getTotalRowCount())));
            textView3.setTextColor(color2);
            textView3.setTextSize(11.0f);
            textView3.setPadding(16, 12, 16, 0);
            textView3.setTypeface(null, 2);
            linearLayout.addView(textView3);
        }
    }

    private final void setupSetCodeSpinner(View view, List<String> options, MTGCsvImporter.CsvParseResult result, MTGCsvImporter.ColumnMapping setNameMapping, boolean hasSetNameMapping) {
        Object next;
        Spinner spinner = (Spinner) view.findViewById(R.id.setCodeSpinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, options);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        Iterator<T> it = result.getColumnMappings().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((MTGCsvImporter.ColumnMapping) next).getField(), "set_code")) {
                    break;
                }
            }
        }
        MTGCsvImporter.ColumnMapping columnMapping = (MTGCsvImporter.ColumnMapping) next;
        if (columnMapping != null && columnMapping.getColumnIndex() >= 0) {
            spinner.setSelection(columnMapping.getColumnIndex() + 1);
            spinner.setEnabled(true);
            spinner.setOnItemSelectedListener(createSpinnerListener(view, "set_code"));
        } else if (!hasSetNameMapping || setNameMapping == null) {
            spinner.setSelection(0);
            spinner.setEnabled(true);
            spinner.setOnItemSelectedListener(createSpinnerListener(view, "set_code"));
        } else {
            spinner.setSelection(setNameMapping.getColumnIndex() + 1);
            spinner.setEnabled(false);
            spinner.setAlpha(0.7f);
        }
    }

    private final void setupSpinner(final View view, int spinnerId, final String field, List<String> options, MTGCsvImporter.CsvParseResult result) {
        Object next;
        Spinner spinner = (Spinner) view.findViewById(spinnerId);
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, options);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        Iterator<T> it = result.getColumnMappings().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((MTGCsvImporter.ColumnMapping) next).getField(), field)) {
                    break;
                }
            }
        }
        MTGCsvImporter.ColumnMapping columnMapping = (MTGCsvImporter.ColumnMapping) next;
        if (columnMapping == null || columnMapping.getColumnIndex() < 0) {
            spinner.setSelection(0);
        } else {
            spinner.setSelection(columnMapping.getColumnIndex() + 1);
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.studiolaganne.lengendarylens.CsvPreviewDialogFragment.setupSpinner.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                CsvPreviewDialogFragment csvPreviewDialogFragment = CsvPreviewDialogFragment.this;
                if (position == 0) {
                    csvPreviewDialogFragment.userMappings.remove(field);
                } else {
                    csvPreviewDialogFragment.userMappings.put(field, Integer.valueOf(position - 1));
                }
                CsvPreviewDialogFragment.this.updateContinueButton(view);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private final void setupViews(View view) {
        int iIntValue;
        MTGCsvImporter.CsvParseResult csvParseResult = this.parseResult;
        if (csvParseResult == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.formatValue);
        TextView textView2 = (TextView) view.findViewById(R.id.confidenceBadge);
        TextView textView3 = (TextView) view.findViewById(R.id.statsText);
        textView.setText(csvParseResult.getDetectedFormat());
        int i = WhenMappings.$EnumSwitchMapping$0[csvParseResult.getConfidence().ordinal()];
        if (i == 1) {
            textView2.setText(getString(R.string.csv_confidence_high));
            textView2.setBackgroundResource(R.drawable.confidence_badge_high);
        } else if (i == 2) {
            textView2.setText(getString(R.string.csv_confidence_medium));
            textView2.setBackgroundResource(R.drawable.confidence_badge_medium);
        } else if (i == 3) {
            textView2.setText(getString(R.string.csv_confidence_low));
            textView2.setBackgroundResource(R.drawable.confidence_badge_low);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            textView2.setText(getString(R.string.csv_confidence_none));
            textView2.setBackgroundResource(R.drawable.confidence_badge_none);
        }
        Iterator<T> it = csvParseResult.getContainers().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            List<MTFullCard> cards = ((MTCardContainer) it.next()).getCards();
            if (cards != null) {
                Iterator<T> it2 = cards.iterator();
                iIntValue = 0;
                while (it2.hasNext()) {
                    Integer quantity = ((MTFullCard) it2.next()).getQuantity();
                    iIntValue += quantity != null ? quantity.intValue() : 1;
                }
            } else {
                iIntValue = 0;
            }
            i2 += iIntValue;
        }
        textView3.setText(getString(R.string.csv_cards_preview, Integer.valueOf(i2), Integer.valueOf(csvParseResult.getContainers().size())));
        setupPreviewTable(view, csvParseResult);
        setupColumnMapping(view, csvParseResult);
        setupWarningText(view, csvParseResult);
        setupButtons(view, csvParseResult);
    }

    private final void setupWarningText(View view, MTGCsvImporter.CsvParseResult result) {
        Object next;
        TextView textView = (TextView) view.findViewById(R.id.warningText);
        Iterator<T> it = result.getColumnMappings().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((MTGCsvImporter.ColumnMapping) next).getField(), "name")) {
                    break;
                }
            }
        }
        MTGCsvImporter.ColumnMapping columnMapping = (MTGCsvImporter.ColumnMapping) next;
        if ((columnMapping == null || columnMapping.getColumnIndex() < 0) && result.getConfidence() == MTGCsvImporter.ConfidenceLevel.NONE) {
            textView.setVisibility(0);
            textView.setText(getString(R.string.csv_name_required));
        } else if (result.getErrors().isEmpty()) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(CollectionsKt.joinToString$default(CollectionsKt.take(result.getErrors(), 2), "\n", null, null, 0, null, null, 62, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContinueButton(View view) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.continueButton);
        boolean zContainsKey = this.userMappings.containsKey("name");
        MTGCsvImporter.CsvParseResult csvParseResult = this.parseResult;
        if (csvParseResult == null || !csvParseResult.getNeedsUserMapping()) {
            zContainsKey = true;
        }
        materialButton.setEnabled(zContainsKey);
        materialButton.setAlpha(zContainsKey ? 1.0f : 0.5f);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_csv_preview, container, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.92d), -2);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupViews(view);
    }
}
