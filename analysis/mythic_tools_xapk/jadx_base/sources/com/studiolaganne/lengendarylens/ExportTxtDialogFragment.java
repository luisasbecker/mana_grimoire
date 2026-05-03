package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.switchmaterial.SwitchMaterial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ExportTxtDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\tH\u0002J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/ExportTxtDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "deckName", "", "lists", "Lcom/studiolaganne/lengendarylens/MTDeckLists;", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "useX", "", "includeSetNumber", "includeFinish", "exportTextView", "Landroid/widget/TextView;", "onStart", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "regenerateExport", "generateExportText", "flattenCards", "groupedCards", "Lcom/studiolaganne/lengendarylens/MTCardGroup;", "formatCardLine", "card", "copyToClipboard", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExportTxtDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private List<MTFullCard> cards;
    private TextView exportTextView;
    private boolean includeFinish;
    private MTDeckLists lists;
    private boolean useX;
    private String deckName = "";
    private boolean includeSetNumber = true;

    /* JADX INFO: compiled from: ExportTxtDialogFragment.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/ExportTxtDialogFragment$Builder;", "", "<init>", "()V", "deckName", "", "lists", "Lcom/studiolaganne/lengendarylens/MTDeckLists;", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "setDeckName", "name", "setLists", "setCards", "build", "Lcom/studiolaganne/lengendarylens/ExportTxtDialogFragment;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private List<MTFullCard> cards;
        private String deckName = "";
        private MTDeckLists lists;

        public final ExportTxtDialogFragment build() {
            ExportTxtDialogFragment exportTxtDialogFragment = new ExportTxtDialogFragment();
            exportTxtDialogFragment.deckName = this.deckName;
            exportTxtDialogFragment.lists = this.lists;
            exportTxtDialogFragment.cards = this.cards;
            return exportTxtDialogFragment;
        }

        public final Builder setCards(List<MTFullCard> cards) {
            Intrinsics.checkNotNullParameter(cards, "cards");
            this.cards = cards;
            return this;
        }

        public final Builder setDeckName(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.deckName = name;
            return this;
        }

        public final Builder setLists(MTDeckLists lists) {
            Intrinsics.checkNotNullParameter(lists, "lists");
            this.lists = lists;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    private final void copyToClipboard() {
        TextView textView;
        CharSequence text;
        String string;
        Context context = getContext();
        if (context == null || (textView = this.exportTextView) == null || (text = textView.getText()) == null || (string = text.toString()) == null) {
            return;
        }
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Deck Export", string));
        Toast.makeText(context, R.string.export_copied_to_clipboard, 0).show();
    }

    private final List<MTFullCard> flattenCards(List<MTCardGroup> groupedCards) {
        ArrayList arrayListEmptyList;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = groupedCards.iterator();
        while (it.hasNext()) {
            List<MTFullCard> cards = ((MTCardGroup) it.next()).getCards();
            if (cards != null) {
                ArrayList arrayList2 = new ArrayList();
                for (MTFullCard mTFullCard : cards) {
                    List<MTFullCard> variants = mTFullCard.getVariants();
                    List<MTFullCard> list = variants;
                    if (list == null || list.isEmpty()) {
                        variants = CollectionsKt.listOf(mTFullCard);
                    }
                    CollectionsKt.addAll(arrayList2, variants);
                }
                arrayListEmptyList = arrayList2;
            } else {
                arrayListEmptyList = CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList, arrayListEmptyList);
        }
        return arrayList;
    }

    private final String formatCardLine(MTFullCard card) {
        String str;
        String lowerCase;
        String str2;
        Integer variant_quantity = card.getVariant_quantity();
        int iIntValue = (variant_quantity == null && (variant_quantity = card.getQuantity()) == null) ? 1 : variant_quantity.intValue();
        String strValueOf = this.useX ? iIntValue + "x" : String.valueOf(iIntValue);
        String name = card.getName();
        String str3 = "";
        if (name == null) {
            name = "";
        }
        String string = StringsKt.trim((CharSequence) CollectionsKt.first(StringsKt.split$default((CharSequence) name, new String[]{"//"}, false, 0, 6, (Object) null))).toString();
        String set_code = card.getSet_code();
        if (!this.includeSetNumber || (str2 = set_code) == null || str2.length() == 0) {
            str = "";
        } else {
            String collector_number = card.getCollector_number();
            if (collector_number == null) {
                collector_number = "";
            }
            String upperCase = set_code.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            str = " (" + upperCase + ") " + collector_number;
        }
        if (this.includeFinish) {
            String finish = card.getFinish();
            if (finish != null) {
                lowerCase = finish.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (Intrinsics.areEqual(lowerCase, "foil")) {
                str3 = " *F*";
            } else if (Intrinsics.areEqual(lowerCase, "etched")) {
                str3 = " *E*";
            }
        }
        return StringsKt.trim((CharSequence) (strValueOf + " " + string + str + str3)).toString();
    }

    private final String generateExportText() {
        MTCardContainer sideboard;
        MTCardContainer main;
        ArrayList arrayList = new ArrayList();
        List<MTFullCard> list = this.cards;
        if (list != null) {
            Iterator<MTFullCard> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(formatCardLine(it.next()));
            }
            return CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null);
        }
        MTDeckLists mTDeckLists = this.lists;
        List<MTCardGroup> grouped_cards = null;
        List<MTCardGroup> grouped_cards2 = (mTDeckLists == null || (main = mTDeckLists.getMain()) == null) ? null : main.getGrouped_cards();
        if (grouped_cards2 != null) {
            Iterator<MTFullCard> it2 = flattenCards(grouped_cards2).iterator();
            while (it2.hasNext()) {
                arrayList.add(formatCardLine(it2.next()));
            }
        }
        MTDeckLists mTDeckLists2 = this.lists;
        if (mTDeckLists2 != null && (sideboard = mTDeckLists2.getSideboard()) != null) {
            grouped_cards = sideboard.getGrouped_cards();
        }
        if (grouped_cards != null && !grouped_cards.isEmpty()) {
            List<MTFullCard> listFlattenCards = flattenCards(grouped_cards);
            if (!listFlattenCards.isEmpty()) {
                arrayList.add("");
                arrayList.add("Sideboard:");
                Iterator<MTFullCard> it3 = listFlattenCards.iterator();
                while (it3.hasNext()) {
                    arrayList.add(formatCardLine(it3.next()));
                }
            }
        }
        return CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null);
    }

    static final void onCreateView$lambda$0(ExportTxtDialogFragment exportTxtDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        exportTxtDialogFragment.useX = z;
        exportTxtDialogFragment.regenerateExport();
    }

    static final void onCreateView$lambda$1(ExportTxtDialogFragment exportTxtDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        exportTxtDialogFragment.includeSetNumber = z;
        exportTxtDialogFragment.regenerateExport();
    }

    static final void onCreateView$lambda$2(ExportTxtDialogFragment exportTxtDialogFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        exportTxtDialogFragment.includeFinish = z;
        exportTxtDialogFragment.regenerateExport();
    }

    static final Unit onCreateView$lambda$3(ExportTxtDialogFragment exportTxtDialogFragment) {
        exportTxtDialogFragment.copyToClipboard();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$4(ExportTxtDialogFragment exportTxtDialogFragment) {
        exportTxtDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    private final void regenerateExport() {
        String strGenerateExportText = generateExportText();
        TextView textView = this.exportTextView;
        if (textView != null) {
            textView.setText(strGenerateExportText);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_export_txt, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.exportTextView = (TextView) viewInflate.findViewById(R.id.exportTextView);
        SwitchMaterial switchMaterial = (SwitchMaterial) viewInflate.findViewById(R.id.useXSwitch);
        SwitchMaterial switchMaterial2 = (SwitchMaterial) viewInflate.findViewById(R.id.includeSetSwitch);
        SwitchMaterial switchMaterial3 = (SwitchMaterial) viewInflate.findViewById(R.id.includeFinishSwitch);
        switchMaterial.setChecked(this.useX);
        switchMaterial2.setChecked(this.includeSetNumber);
        switchMaterial3.setChecked(this.includeFinish);
        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.ExportTxtDialogFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ExportTxtDialogFragment.onCreateView$lambda$0(this.f$0, compoundButton, z);
            }
        });
        switchMaterial2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.ExportTxtDialogFragment$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ExportTxtDialogFragment.onCreateView$lambda$1(this.f$0, compoundButton, z);
            }
        });
        switchMaterial3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.ExportTxtDialogFragment$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ExportTxtDialogFragment.onCreateView$lambda$2(this.f$0, compoundButton, z);
            }
        });
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.copyButtonLayout);
        Intrinsics.checkNotNull(constraintLayout);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ExportTxtDialogFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExportTxtDialogFragment.onCreateView$lambda$3(this.f$0);
            }
        });
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate.findViewById(R.id.closeButtonLayout);
        Intrinsics.checkNotNull(constraintLayout2);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.ExportTxtDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExportTxtDialogFragment.onCreateView$lambda$4(this.f$0);
            }
        });
        regenerateExport();
        return viewInflate;
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
        window.setDimAmount(0.9f);
    }
}
