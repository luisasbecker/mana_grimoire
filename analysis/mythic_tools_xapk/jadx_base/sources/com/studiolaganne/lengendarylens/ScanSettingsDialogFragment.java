package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.studiolaganne.lengendarylens.ScanSettingsDialogFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: ScanSettingsDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003>?@B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u001a\u001a\u00020\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\b\u0010\u001c\u001a\u00020\u0019H\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J \u0010'\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020.H\u0002J\u0018\u00101\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001e2\u0006\u00102\u001a\u00020)H\u0002J(\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\f2\u0006\u00100\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010*\u001a\u00020+H\u0002J \u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020\f2\u0006\u00100\u001a\u0002052\u0006\u0010:\u001a\u000207H\u0002J\u0010\u0010;\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010<\u001a\u00020\u00192\u0006\u00104\u001a\u00020\fH\u0016J\u0010\u0010=\u001a\u00020\u00192\u0006\u00109\u001a\u00020\fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScanSettingsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/studiolaganne/lengendarylens/LanguageClickListener;", "Lcom/studiolaganne/lengendarylens/FinishClickListener;", "<init>", "()V", "languagePopupWindow", "Landroid/widget/PopupWindow;", "finishPopupWindow", "languageOverrideEnabled", "", "selectedLanguage", "", "setOverrideEnabled", "selectedSetCode", "finishOverrideEnabled", "selectedFinish", "highPriceBeepEnabled", "priceThreshold", "", "purchasePriceEnabled", "purchasePriceMode", "fixedPriceValue", "onSettingsSaved", "Lkotlin/Function0;", "", "setOnSettingsSaved", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "setupLanguagePopup", "languageSelectionLayout", "Landroid/widget/LinearLayout;", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "setupSetSelector", "setTextView", "Landroid/widget/AutoCompleteTextView;", "updateClearIcon", "textView", "setupFinishPopup", "finishSelectionLayout", "updateLanguageDisplay", "language", "Landroid/widget/TextView;", "flagImage", "Landroid/widget/ImageView;", "updateFinishDisplay", "finish", "foilImage", "syncSettingsWithServer", "onLanguageClick", "onFinishClick", "Companion", "ContainsFilterArrayAdapter", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScanSettingsDialogFragment extends DialogFragment implements LanguageClickListener, FinishClickListener {
    private boolean finishOverrideEnabled;
    private PopupWindow finishPopupWindow;
    private float fixedPriceValue;
    private boolean highPriceBeepEnabled;
    private boolean languageOverrideEnabled;
    private PopupWindow languagePopupWindow;
    private Function0<Unit> onSettingsSaved;
    private boolean purchasePriceEnabled;
    private boolean setOverrideEnabled;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private String selectedLanguage = "en";
    private String selectedSetCode = "";
    private String selectedFinish = "nonfoil";
    private float priceThreshold = 2.0f;
    private String purchasePriceMode = "current";

    /* JADX INFO: compiled from: ScanSettingsDialogFragment.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScanSettingsDialogFragment$Builder;", "", "<init>", "()V", "onSettingsSaved", "Lkotlin/Function0;", "", "setOnSettingsSaved", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "build", "Lcom/studiolaganne/lengendarylens/ScanSettingsDialogFragment;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private Function0<Unit> onSettingsSaved;

        public final ScanSettingsDialogFragment build() {
            ScanSettingsDialogFragment scanSettingsDialogFragment = new ScanSettingsDialogFragment();
            scanSettingsDialogFragment.onSettingsSaved = this.onSettingsSaved;
            return scanSettingsDialogFragment;
        }

        public final Builder setOnSettingsSaved(Function0<Unit> listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.onSettingsSaved = listener;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    /* JADX INFO: compiled from: ScanSettingsDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScanSettingsDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/ScanSettingsDialogFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ScanSettingsDialogFragment newInstance() {
            return new ScanSettingsDialogFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ScanSettingsDialogFragment.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScanSettingsDialogFragment$ContainsFilterArrayAdapter;", "Landroid/widget/ArrayAdapter;", "", "context", "Landroid/content/Context;", "resource", "", "allItems", "", "<init>", "(Landroid/content/Context;ILjava/util/List;)V", "filteredItems", "", "getCount", "getItem", "position", "getFilter", "Landroid/widget/Filter;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class ContainsFilterArrayAdapter extends ArrayAdapter<String> {
        private final List<String> allItems;
        private final List<String> filteredItems;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContainsFilterArrayAdapter(Context context, int i, List<String> allItems) {
            super(context, i, CollectionsKt.toMutableList((Collection) allItems));
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(allItems, "allItems");
            this.allItems = allItems;
            this.filteredItems = new ArrayList();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.filteredItems.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Filterable
        public Filter getFilter() {
            return new Filter() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$ContainsFilterArrayAdapter$getFilter$1
                @Override // android.widget.Filter
                protected Filter.FilterResults performFiltering(CharSequence constraint) {
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    if (constraint == null || constraint.length() == 0) {
                        filterResults.values = this.this$0.allItems;
                        filterResults.count = this.this$0.allItems.size();
                        return filterResults;
                    }
                    String lowerCase = constraint.toString().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    List list = this.this$0.allItems;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        String lowerCase2 = ((String) obj).toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) lowerCase, false, 2, (Object) null)) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    filterResults.values = arrayList2;
                    filterResults.count = arrayList2.size();
                    return filterResults;
                }

                @Override // android.widget.Filter
                protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
                    this.this$0.filteredItems.clear();
                    List list = this.this$0.filteredItems;
                    Object obj = results != null ? results.values : null;
                    List list2 = obj instanceof List ? (List) obj : null;
                    list.addAll(list2 != null ? list2 : CollectionsKt.emptyList());
                    boolean zIsEmpty = this.this$0.filteredItems.isEmpty();
                    ScanSettingsDialogFragment.ContainsFilterArrayAdapter containsFilterArrayAdapter = this.this$0;
                    if (zIsEmpty) {
                        containsFilterArrayAdapter.notifyDataSetInvalidated();
                    } else {
                        containsFilterArrayAdapter.notifyDataSetChanged();
                    }
                }
            };
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public String getItem(int position) {
            return this.filteredItems.get(position);
        }
    }

    static final void onViewCreated$lambda$0(ScanSettingsDialogFragment scanSettingsDialogFragment, LinearLayout linearLayout, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        scanSettingsDialogFragment.languageOverrideEnabled = z;
        linearLayout.setVisibility(z ? 0 : 8);
    }

    static final void onViewCreated$lambda$1(ScanSettingsDialogFragment scanSettingsDialogFragment, AutoCompleteTextView autoCompleteTextView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        scanSettingsDialogFragment.setOverrideEnabled = z;
        autoCompleteTextView.setVisibility(z ? 0 : 8);
    }

    static final void onViewCreated$lambda$2(ScanSettingsDialogFragment scanSettingsDialogFragment, LinearLayout linearLayout, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        scanSettingsDialogFragment.finishOverrideEnabled = z;
        linearLayout.setVisibility(z ? 0 : 8);
    }

    static final void onViewCreated$lambda$3(ScanSettingsDialogFragment scanSettingsDialogFragment, LinearLayout linearLayout, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        scanSettingsDialogFragment.highPriceBeepEnabled = z;
        linearLayout.setVisibility(z ? 0 : 8);
    }

    static final void onViewCreated$lambda$4(ScanSettingsDialogFragment scanSettingsDialogFragment, LinearLayout linearLayout, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        scanSettingsDialogFragment.purchasePriceEnabled = z;
        linearLayout.setVisibility(z ? 0 : 8);
    }

    static final void onViewCreated$lambda$5(ScanSettingsDialogFragment scanSettingsDialogFragment, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(radioGroup, "<unused var>");
        scanSettingsDialogFragment.purchasePriceMode = i == R.id.radioFixedPrice ? "fixed" : "current";
    }

    static final void onViewCreated$lambda$6(RadioButton radioButton, final ScrollView scrollView, final View view, boolean z) {
        if (z) {
            radioButton.setChecked(true);
            view.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    ScanSettingsDialogFragment.onViewCreated$lambda$6$0(scrollView, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6$0(ScrollView scrollView, View view) {
        if (scrollView != null) {
            scrollView.smoothScrollTo(0, view.getBottom());
        }
    }

    static final Unit onViewCreated$lambda$7(ScanSettingsDialogFragment scanSettingsDialogFragment) {
        scanSettingsDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$8(TextInputEditText textInputEditText, ScanSettingsDialogFragment scanSettingsDialogFragment, TextInputEditText textInputEditText2, MTUserSettings mTUserSettings, PreferencesManager preferencesManager) {
        Float floatOrNull = StringsKt.toFloatOrNull(String.valueOf(textInputEditText.getText()));
        scanSettingsDialogFragment.priceThreshold = floatOrNull != null ? floatOrNull.floatValue() : 2.0f;
        Float floatOrNull2 = StringsKt.toFloatOrNull(String.valueOf(textInputEditText2.getText()));
        preferencesManager.applyMTUserSettings(MTUserSettings.copy$default(mTUserSettings, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(scanSettingsDialogFragment.languageOverrideEnabled), scanSettingsDialogFragment.selectedLanguage, Boolean.valueOf(scanSettingsDialogFragment.setOverrideEnabled), scanSettingsDialogFragment.selectedSetCode, Boolean.valueOf(scanSettingsDialogFragment.finishOverrideEnabled), scanSettingsDialogFragment.selectedFinish, Boolean.valueOf(scanSettingsDialogFragment.highPriceBeepEnabled), Float.valueOf(scanSettingsDialogFragment.priceThreshold), Boolean.valueOf(scanSettingsDialogFragment.purchasePriceEnabled), scanSettingsDialogFragment.purchasePriceMode, Float.valueOf(floatOrNull2 != null ? floatOrNull2.floatValue() : 0.0f), null, null, null, null, null, null, -1, 134217727, 4032, null));
        scanSettingsDialogFragment.syncSettingsWithServer(preferencesManager);
        Function0<Unit> function0 = scanSettingsDialogFragment.onSettingsSaved;
        if (function0 != null) {
            function0.invoke();
        }
        scanSettingsDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    private final void setupFinishPopup(View view, final LinearLayout finishSelectionLayout) {
        View viewInflate = getLayoutInflater().inflate(R.layout.small_popup_language_list, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.language_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        final PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        String string = getResources().getString(R.string.non_foil);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getResources().getString(R.string.foil);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        recyclerView.setAdapter(new FinishAdapter(CollectionsKt.mutableListOf(string, string2), this));
        this.finishPopupWindow = popupWindow;
        ViewExtensionsKt.setOnClickWithFade(finishSelectionLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanSettingsDialogFragment.setupFinishPopup$lambda$0(popupWindow, finishSelectionLayout);
            }
        });
    }

    static final Unit setupFinishPopup$lambda$0(PopupWindow popupWindow, LinearLayout linearLayout) {
        popupWindow.showAsDropDown(linearLayout);
        return Unit.INSTANCE;
    }

    private final void setupLanguagePopup(View view, final LinearLayout languageSelectionLayout, PreferencesManager prefs) {
        View viewInflate = getLayoutInflater().inflate(R.layout.small_popup_language_list, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.language_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        final PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        ArrayList arrayList = new ArrayList();
        for (String str : CollectionsKt.listOf((Object[]) new String[]{"en", "fr", "de", "it", "es", "pt", "ja", "ko", "ru", "zhs", "zht"})) {
            arrayList.add(new LanguageRow(str, prefs.getNameForLanguage(str)));
        }
        recyclerView.setAdapter(new LanguageAdapter(arrayList, this));
        this.languagePopupWindow = popupWindow;
        ViewExtensionsKt.setOnClickWithFade(languageSelectionLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanSettingsDialogFragment.setupLanguagePopup$lambda$0(popupWindow, languageSelectionLayout);
            }
        });
    }

    static final Unit setupLanguagePopup$lambda$0(PopupWindow popupWindow, LinearLayout linearLayout) {
        popupWindow.showAsDropDown(linearLayout);
        return Unit.INSTANCE;
    }

    private final void setupSetSelector(final AutoCompleteTextView setTextView, PreferencesManager prefs) {
        Object next;
        Context context = getContext();
        if (context != null) {
            List<CardSet> listSortedWith = CollectionsKt.sortedWith(CardSetsManager.INSTANCE.getCardSets(), new Comparator() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$setupSetSelector$lambda$0$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((CardSet) t2).getReleased_at(), ((CardSet) t).getReleased_at());
                }
            });
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
            for (CardSet cardSet : listSortedWith) {
                String name = cardSet.getName();
                String upperCase = cardSet.getCode().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                arrayList.add(name + " (" + upperCase + ")");
            }
            setTextView.setAdapter(new ContainsFilterArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, arrayList));
            setTextView.setInputType(524288);
            setTextView.setImportantForAutofill(2);
            setTextView.setThreshold(1);
            setTextView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    setTextView.showDropDown();
                }
            });
            setTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    ScanSettingsDialogFragment.setupSetSelector$lambda$0$3(view, z);
                }
            });
            if (this.selectedSetCode.length() > 0) {
                Iterator it = listSortedWith.iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (StringsKt.equals(((CardSet) next).getCode(), this.selectedSetCode, true)) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                CardSet cardSet2 = (CardSet) next;
                if (cardSet2 != null) {
                    String name2 = cardSet2.getName();
                    String upperCase2 = cardSet2.getCode().toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                    setTextView.setText((CharSequence) (name2 + " (" + upperCase2 + ")"), false);
                }
            }
            setTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda9
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    ScanSettingsDialogFragment.setupSetSelector$lambda$0$6(this.f$0, setTextView, adapterView, view, i, j);
                }
            });
            updateClearIcon(setTextView);
            setTextView.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$setupSetSelector$1$5
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    Editable editable = s;
                    if (editable == null || editable.length() == 0) {
                        this.this$0.selectedSetCode = "";
                    }
                    this.this$0.updateClearIcon(setTextView);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });
            setTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return ScanSettingsDialogFragment.setupSetSelector$lambda$0$7(setTextView, this, view, motionEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSetSelector$lambda$0$3(View view, boolean z) {
        if (z) {
            AutoCompleteTextView autoCompleteTextView = view instanceof AutoCompleteTextView ? (AutoCompleteTextView) view : null;
            if (autoCompleteTextView != null) {
                autoCompleteTextView.showDropDown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSetSelector$lambda$0$6(ScanSettingsDialogFragment scanSettingsDialogFragment, AutoCompleteTextView autoCompleteTextView, AdapterView adapterView, View view, int i, long j) {
        Object itemAtPosition = adapterView.getItemAtPosition(i);
        Intrinsics.checkNotNull(itemAtPosition, "null cannot be cast to non-null type kotlin.String");
        String lowerCase = StringsKt.substringBeforeLast$default(StringsKt.substringAfterLast$default((String) itemAtPosition, "(", (String) null, 2, (Object) null), ")", (String) null, 2, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        scanSettingsDialogFragment.selectedSetCode = lowerCase;
        scanSettingsDialogFragment.updateClearIcon(autoCompleteTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupSetSelector$lambda$0$7(AutoCompleteTextView autoCompleteTextView, ScanSettingsDialogFragment scanSettingsDialogFragment, View view, MotionEvent motionEvent) {
        Drawable drawable;
        if (motionEvent.getAction() != 1 || (drawable = autoCompleteTextView.getCompoundDrawablesRelative()[2]) == null) {
            return false;
        }
        if (motionEvent.getX() < (autoCompleteTextView.getWidth() - autoCompleteTextView.getPaddingEnd()) - drawable.getBounds().width()) {
            return false;
        }
        autoCompleteTextView.setText("");
        scanSettingsDialogFragment.selectedSetCode = "";
        view.performClick();
        return true;
    }

    private final void syncSettingsWithServer(PreferencesManager prefs) {
        MTUser currentUser = prefs.getCurrentUser();
        if (currentUser == null) {
            return;
        }
        MTApiKt.getMtApi().syncSettings(currentUser.getId(), prefs.getMTUserSettings()).enqueue(new Callback<MTSuccessResponse>() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment.syncSettingsWithServer.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTSuccessResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                ScanSettingsDialogFragment.this.getContext();
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTSuccessResponse> call, Response<MTSuccessResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                ScanSettingsDialogFragment.this.getContext();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateClearIcon(AutoCompleteTextView textView) {
        Editable text = textView.getText();
        if (text == null || text.length() == 0) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_clear, 0);
        }
    }

    private final void updateFinishDisplay(String finish, TextView textView, ImageView foilImage) {
        String lowerCase = finish.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, "foil")) {
            textView.setText(getResources().getString(R.string.foil));
            foilImage.setVisibility(0);
        } else {
            textView.setText(getResources().getString(R.string.non_foil));
            foilImage.setVisibility(8);
        }
    }

    private final void updateLanguageDisplay(String language, TextView textView, ImageView flagImage, PreferencesManager prefs) {
        textView.setText(prefs.getNameForLanguage(language));
        Resources resources = getResources();
        String lowerCase = language.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int identifier = resources.getIdentifier("flag_" + lowerCase, "drawable", flagImage.getContext().getPackageName());
        if (identifier != 0) {
            flagImage.setImageResource(identifier);
        } else {
            flagImage.setImageResource(getResources().getIdentifier("flag_default", "drawable", flagImage.getContext().getPackageName()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.scan_settings_dialog, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return viewInflate;
    }

    @Override // com.studiolaganne.lengendarylens.FinishClickListener
    public void onFinishClick(String finish) {
        Intrinsics.checkNotNullParameter(finish, "finish");
        PopupWindow popupWindow = this.finishPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (Intrinsics.areEqual(finish, getResources().getString(R.string.foil))) {
            this.selectedFinish = "foil";
        } else {
            this.selectedFinish = "nonfoil";
        }
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.selectedFinishTextView) : null;
        View view2 = getView();
        ImageView imageView = view2 != null ? (ImageView) view2.findViewById(R.id.foil_image) : null;
        if (textView == null || imageView == null) {
            return;
        }
        updateFinishDisplay(this.selectedFinish, textView, imageView);
    }

    @Override // com.studiolaganne.lengendarylens.LanguageClickListener
    public void onLanguageClick(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        PopupWindow popupWindow = this.languagePopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (Intrinsics.areEqual(this.selectedLanguage, language)) {
            return;
        }
        this.selectedLanguage = language;
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.selectedLanguageTextView) : null;
        View view2 = getView();
        ImageView imageView = view2 != null ? (ImageView) view2.findViewById(R.id.flag_image) : null;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (textView == null || imageView == null) {
            return;
        }
        updateLanguageDisplay(language, textView, imageView, preferencesManager);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
        window.setSoftInputMode(32);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        final MTUserSettings mTUserSettings = preferencesManager.getMTUserSettings();
        Boolean scan_override_language_enabled = mTUserSettings.getScan_override_language_enabled();
        this.languageOverrideEnabled = scan_override_language_enabled != null ? scan_override_language_enabled.booleanValue() : false;
        String scan_override_language = mTUserSettings.getScan_override_language();
        if (scan_override_language == null) {
            scan_override_language = "en";
        }
        this.selectedLanguage = scan_override_language;
        Boolean scan_override_set_enabled = mTUserSettings.getScan_override_set_enabled();
        this.setOverrideEnabled = scan_override_set_enabled != null ? scan_override_set_enabled.booleanValue() : false;
        String scan_override_set = mTUserSettings.getScan_override_set();
        if (scan_override_set == null) {
            scan_override_set = "";
        }
        this.selectedSetCode = scan_override_set;
        Boolean scan_override_finish_enabled = mTUserSettings.getScan_override_finish_enabled();
        this.finishOverrideEnabled = scan_override_finish_enabled != null ? scan_override_finish_enabled.booleanValue() : false;
        String scan_override_finish = mTUserSettings.getScan_override_finish();
        if (scan_override_finish == null) {
            scan_override_finish = "nonfoil";
        }
        this.selectedFinish = scan_override_finish;
        Boolean scan_high_price_beep_enabled = mTUserSettings.getScan_high_price_beep_enabled();
        this.highPriceBeepEnabled = scan_high_price_beep_enabled != null ? scan_high_price_beep_enabled.booleanValue() : false;
        Float scan_high_price_threshold = mTUserSettings.getScan_high_price_threshold();
        this.priceThreshold = scan_high_price_threshold != null ? scan_high_price_threshold.floatValue() : 2.0f;
        Boolean scan_purchase_price_enabled = mTUserSettings.getScan_purchase_price_enabled();
        this.purchasePriceEnabled = scan_purchase_price_enabled != null ? scan_purchase_price_enabled.booleanValue() : false;
        String scan_purchase_price_mode = mTUserSettings.getScan_purchase_price_mode();
        if (scan_purchase_price_mode == null) {
            scan_purchase_price_mode = "current";
        }
        this.purchasePriceMode = scan_purchase_price_mode;
        Float scan_purchase_price_fixed = mTUserSettings.getScan_purchase_price_fixed();
        this.fixedPriceValue = scan_purchase_price_fixed != null ? scan_purchase_price_fixed.floatValue() : 0.0f;
        SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R.id.languageOverrideSwitch);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.languageSelectionLayout);
        TextView textView = (TextView) view.findViewById(R.id.selectedLanguageTextView);
        ImageView imageView = (ImageView) view.findViewById(R.id.flag_image);
        SwitchMaterial switchMaterial2 = (SwitchMaterial) view.findViewById(R.id.setOverrideSwitch);
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.setTextView);
        SwitchMaterial switchMaterial3 = (SwitchMaterial) view.findViewById(R.id.finishOverrideSwitch);
        final LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.finishSelectionLayout);
        TextView textView2 = (TextView) view.findViewById(R.id.selectedFinishTextView);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.foil_image);
        SwitchMaterial switchMaterial4 = (SwitchMaterial) view.findViewById(R.id.highPriceBeepSwitch);
        final LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.priceThresholdLayout);
        final TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.priceThresholdEditText);
        SwitchMaterial switchMaterial5 = (SwitchMaterial) view.findViewById(R.id.purchasePriceSwitch);
        final LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.purchasePriceOptionsLayout);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.purchasePriceRadioGroup);
        RadioButton radioButton = (RadioButton) view.findViewById(R.id.radioCurrentPrice);
        final RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.radioFixedPrice);
        final TextInputEditText textInputEditText2 = (TextInputEditText) view.findViewById(R.id.fixedPriceEditText);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cancelButtonLayout);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.saveButtonLayout);
        switchMaterial.setChecked(this.languageOverrideEnabled);
        linearLayout.setVisibility(this.languageOverrideEnabled ? 0 : 8);
        switchMaterial2.setChecked(this.setOverrideEnabled);
        autoCompleteTextView.setVisibility(this.setOverrideEnabled ? 0 : 8);
        switchMaterial3.setChecked(this.finishOverrideEnabled);
        linearLayout2.setVisibility(this.finishOverrideEnabled ? 0 : 8);
        switchMaterial4.setChecked(this.highPriceBeepEnabled);
        linearLayout3.setVisibility(this.highPriceBeepEnabled ? 0 : 8);
        switchMaterial5.setChecked(this.purchasePriceEnabled);
        linearLayout4.setVisibility(this.purchasePriceEnabled ? 0 : 8);
        if (Intrinsics.areEqual(this.purchasePriceMode, "fixed")) {
            radioButton2.setChecked(true);
        } else {
            radioButton.setChecked(true);
        }
        float f = this.fixedPriceValue;
        if (f > 0.0f) {
            textInputEditText2.setText(String.valueOf(f));
        }
        String str = this.selectedLanguage;
        Intrinsics.checkNotNull(textView);
        Intrinsics.checkNotNull(imageView);
        updateLanguageDisplay(str, textView, imageView, preferencesManager);
        String str2 = this.selectedFinish;
        Intrinsics.checkNotNull(textView2);
        Intrinsics.checkNotNull(imageView2);
        updateFinishDisplay(str2, textView2, imageView2);
        textInputEditText.setText(String.valueOf(this.priceThreshold));
        Intrinsics.checkNotNull(linearLayout);
        setupLanguagePopup(view, linearLayout, preferencesManager);
        Intrinsics.checkNotNull(autoCompleteTextView);
        setupSetSelector(autoCompleteTextView, preferencesManager);
        Intrinsics.checkNotNull(linearLayout2);
        setupFinishPopup(view, linearLayout2);
        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda11
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ScanSettingsDialogFragment.onViewCreated$lambda$0(this.f$0, linearLayout, compoundButton, z);
            }
        });
        switchMaterial2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda12
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ScanSettingsDialogFragment.onViewCreated$lambda$1(this.f$0, autoCompleteTextView, compoundButton, z);
            }
        });
        switchMaterial3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda13
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ScanSettingsDialogFragment.onViewCreated$lambda$2(this.f$0, linearLayout2, compoundButton, z);
            }
        });
        switchMaterial4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ScanSettingsDialogFragment.onViewCreated$lambda$3(this.f$0, linearLayout3, compoundButton, z);
            }
        });
        switchMaterial5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda15
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ScanSettingsDialogFragment.onViewCreated$lambda$4(this.f$0, linearLayout4, compoundButton, z);
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                ScanSettingsDialogFragment.onViewCreated$lambda$5(this.f$0, radioGroup2, i);
            }
        });
        final ScrollView scrollView = (ScrollView) view.findViewById(R.id.settingsScrollView);
        textInputEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z) {
                ScanSettingsDialogFragment.onViewCreated$lambda$6(radioButton2, scrollView, view2, z);
            }
        });
        Intrinsics.checkNotNull(constraintLayout);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanSettingsDialogFragment.onViewCreated$lambda$7(this.f$0);
            }
        });
        Intrinsics.checkNotNull(constraintLayout2);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.ScanSettingsDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScanSettingsDialogFragment.onViewCreated$lambda$8(textInputEditText, this, textInputEditText2, mTUserSettings, preferencesManager);
            }
        });
    }

    public final ScanSettingsDialogFragment setOnSettingsSaved(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onSettingsSaved = listener;
        return this;
    }
}
