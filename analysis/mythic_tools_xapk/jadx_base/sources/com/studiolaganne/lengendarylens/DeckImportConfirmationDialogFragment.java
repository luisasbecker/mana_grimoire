package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.revenuecat.purchases.common.Constants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeckImportConfirmationDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000bH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckImportConfirmationDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "cards", "", "Lcom/studiolaganne/lengendarylens/ParsedCard;", "replaceAll", "", "onConfirm", "Lkotlin/Function0;", "", "onCancel", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupViews", ViewHierarchyConstants.VIEW_KEY, "createCardView", "card", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckImportConfirmationDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private List<ParsedCard> cards = CollectionsKt.emptyList();
    private Function0<Unit> onCancel;
    private Function0<Unit> onConfirm;
    private boolean replaceAll;

    /* JADX INFO: compiled from: DeckImportConfirmationDialogFragment.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0014\u0010\u0011\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckImportConfirmationDialogFragment$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/DeckImportConfirmationDialogFragment;", "setCards", "cards", "", "Lcom/studiolaganne/lengendarylens/ParsedCard;", "setReplaceAll", "replaceAll", "", "setOnConfirm", "callback", "Lkotlin/Function0;", "", "setOnCancel", "show", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final DeckImportConfirmationDialogFragment dialogFragment = new DeckImportConfirmationDialogFragment();

        public final Builder setCards(List<ParsedCard> cards) {
            Intrinsics.checkNotNullParameter(cards, "cards");
            this.dialogFragment.cards = cards;
            return this;
        }

        public final Builder setOnCancel(Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.dialogFragment.onCancel = callback;
            return this;
        }

        public final Builder setOnConfirm(Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.dialogFragment.onConfirm = callback;
            return this;
        }

        public final Builder setReplaceAll(boolean replaceAll) {
            this.dialogFragment.replaceAll = replaceAll;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialogFragment, manager, tag);
        }
    }

    private final View createCardView(ParsedCard card) {
        String str;
        String str2;
        TextView textView = new TextView(requireContext());
        if (card.getQuantity() == 0 && StringsKt.endsWith$default(card.getCardName(), Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, (Object) null)) {
            textView.setText(card.getCardName());
            textView.setTextSize(16.0f);
            textView.setTypeface(null, 1);
            textView.setPadding(16, 12, 16, 8);
            textView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.selected_color_accent_semi_transparent));
            textView.setTextColor(-1);
        } else {
            String finish = card.getFinish();
            String str3 = "";
            String str4 = Intrinsics.areEqual(finish, "foil") ? " (" + getString(R.string.foil) + ")" : Intrinsics.areEqual(finish, "etched") ? " (Etched)" : "";
            String setCode = card.getSetCode();
            if (setCode == null || (str = " [" + setCode + "]") == null) {
                str = "";
            }
            String collectorNumber = card.getCollectorNumber();
            if (collectorNumber != null && (str2 = " #" + collectorNumber) != null) {
                str3 = str2;
            }
            textView.setText(card.getQuantity() + "x " + card.getCardName() + str4 + str + str3);
            textView.setTextSize(14.0f);
            textView.setPadding(16, 8, 16, 8);
            textView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.black));
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
        }
        LinearLayout linearLayout = new LinearLayout(requireContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(textView);
        return linearLayout;
    }

    private final void setupViews(View view) {
        TextView textView = (TextView) view.findViewById(R.id.title);
        TextView textView2 = (TextView) view.findViewById(R.id.summary);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.cards_layout);
        final TextView textView3 = (TextView) view.findViewById(R.id.expand_button);
        final ScrollView scrollView = (ScrollView) view.findViewById(R.id.scroll_view);
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.import_button);
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.cancel_button);
        Iterator<T> it = this.cards.iterator();
        int quantity = 0;
        while (it.hasNext()) {
            quantity += ((ParsedCard) it.next()).getQuantity();
        }
        int size = this.cards.size();
        textView.setText(getString(R.string.deck_import_confirmation_title));
        String string = this.replaceAll ? getString(R.string.deck_import_replace_all) : getString(R.string.deck_import_add_to_existing);
        Intrinsics.checkNotNull(string);
        textView2.setText(getString(R.string.deck_import_confirmation_summary, Integer.valueOf(quantity), Integer.valueOf(size), string));
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckImportConfirmationDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeckImportConfirmationDialogFragment.setupViews$lambda$1(booleanRef, scrollView, this, textView3, view2);
            }
        });
        Iterator<T> it2 = this.cards.iterator();
        while (it2.hasNext()) {
            linearLayout.addView(createCardView((ParsedCard) it2.next()));
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckImportConfirmationDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeckImportConfirmationDialogFragment.setupViews$lambda$3(this.f$0, view2);
            }
        });
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckImportConfirmationDialogFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeckImportConfirmationDialogFragment.setupViews$lambda$4(this.f$0, view2);
            }
        });
    }

    static final void setupViews$lambda$1(Ref.BooleanRef booleanRef, ScrollView scrollView, DeckImportConfirmationDialogFragment deckImportConfirmationDialogFragment, TextView textView, View view) {
        booleanRef.element = !booleanRef.element;
        if (!booleanRef.element) {
            scrollView.setVisibility(8);
            textView.setText(deckImportConfirmationDialogFragment.getString(R.string.deck_import_show_cards));
            return;
        }
        scrollView.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
        layoutParams.height = (int) (((double) deckImportConfirmationDialogFragment.getResources().getDisplayMetrics().heightPixels) * 0.4d);
        scrollView.setLayoutParams(layoutParams);
        textView.setText(deckImportConfirmationDialogFragment.getString(R.string.deck_import_hide_cards));
    }

    static final void setupViews$lambda$3(DeckImportConfirmationDialogFragment deckImportConfirmationDialogFragment, View view) {
        Function0<Unit> function0 = deckImportConfirmationDialogFragment.onConfirm;
        if (function0 != null) {
            function0.invoke();
        }
        deckImportConfirmationDialogFragment.dismiss();
    }

    static final void setupViews$lambda$4(DeckImportConfirmationDialogFragment deckImportConfirmationDialogFragment, View view) {
        Function0<Unit> function0 = deckImportConfirmationDialogFragment.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
        deckImportConfirmationDialogFragment.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_deck_import_confirmation, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Intrinsics.checkNotNull(viewInflate);
        setupViews(viewInflate);
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
    }
}
