package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
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
import com.facebook.internal.NativeProtocol;
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: ExternalDeckSyncConfirmationDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\rH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\"\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u0010!\u001a\u00020\u001cH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/ExternalDeckSyncConfirmationDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "toAdd", "", "Lcom/studiolaganne/lengendarylens/MTDeckCardToAdd;", "toModify", "Lcom/studiolaganne/lengendarylens/MTDeckCardToModify;", "toRemove", "Lcom/studiolaganne/lengendarylens/MTDeckCardToRemove;", "onConfirm", "Lkotlin/Function0;", "", "onCancel", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupViews", ViewHierarchyConstants.VIEW_KEY, "createSectionHeaderView", "text", "", "createCardViewForSync", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "changeType", NativeProtocol.WEB_DIALOG_ACTION, "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExternalDeckSyncConfirmationDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private Function0<Unit> onCancel;
    private Function0<Unit> onConfirm;
    private List<MTDeckCardToAdd> toAdd = CollectionsKt.emptyList();
    private List<MTDeckCardToModify> toModify = CollectionsKt.emptyList();
    private List<MTDeckCardToRemove> toRemove = CollectionsKt.emptyList();

    /* JADX INFO: compiled from: ExternalDeckSyncConfirmationDialogFragment.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0014\u0010\n\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\bJ\u0014\u0010\f\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\r0\bJ\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0014\u0010\u0012\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/ExternalDeckSyncConfirmationDialogFragment$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/ExternalDeckSyncConfirmationDialogFragment;", "setToAdd", "cards", "", "Lcom/studiolaganne/lengendarylens/MTDeckCardToAdd;", "setToModify", "Lcom/studiolaganne/lengendarylens/MTDeckCardToModify;", "setToRemove", "Lcom/studiolaganne/lengendarylens/MTDeckCardToRemove;", "setOnConfirm", "callback", "Lkotlin/Function0;", "", "setOnCancel", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final ExternalDeckSyncConfirmationDialogFragment dialogFragment = new ExternalDeckSyncConfirmationDialogFragment();

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

        public final Builder setToAdd(List<MTDeckCardToAdd> cards) {
            Intrinsics.checkNotNullParameter(cards, "cards");
            this.dialogFragment.toAdd = cards;
            return this;
        }

        public final Builder setToModify(List<MTDeckCardToModify> cards) {
            Intrinsics.checkNotNullParameter(cards, "cards");
            this.dialogFragment.toModify = cards;
            return this;
        }

        public final Builder setToRemove(List<MTDeckCardToRemove> cards) {
            Intrinsics.checkNotNullParameter(cards, "cards");
            this.dialogFragment.toRemove = cards;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialogFragment, manager, tag);
        }
    }

    private final View createCardViewForSync(MTFullCard card, String changeType, String action) {
        String upperCase;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String string = contextRequireContext.getString(R.string.external_sync_print_modified);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = contextRequireContext.getString(R.string.external_sync_finish_modified);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        TextView textView = new TextView(contextRequireContext);
        String name = card.getName();
        if (name == null) {
            name = "Unknown Card";
        }
        String set_code = card.getSet_code();
        if (set_code != null) {
            upperCase = set_code.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        String collector_number = card.getCollector_number();
        String str = "";
        String str2 = (upperCase == null || collector_number == null) ? upperCase != null ? " (" + upperCase + ")" : collector_number != null ? " #" + collector_number : "" : " (" + upperCase + ") " + collector_number;
        if (Intrinsics.areEqual(action, "modify") && Intrinsics.areEqual(changeType, "printing")) {
            str = " " + string;
        } else if (Intrinsics.areEqual(action, "modify") && Intrinsics.areEqual(changeType, "finish")) {
            str = " " + string2;
        }
        textView.setText(name + str2 + str);
        textView.setTextSize(14.0f);
        textView.setPadding(16, 8, 16, 8);
        textView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.black));
        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
        LinearLayout linearLayout = new LinearLayout(contextRequireContext);
        linearLayout.setOrientation(1);
        linearLayout.addView(textView);
        return linearLayout;
    }

    private final View createSectionHeaderView(String text) {
        TextView textView = new TextView(requireContext());
        textView.setText(text);
        textView.setTextSize(16.0f);
        textView.setTypeface(null, 1);
        textView.setPadding(16, 12, 16, 8);
        textView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.selected_color_accent_semi_transparent));
        textView.setTextColor(-1);
        return textView;
    }

    private final void setupViews(View view) {
        String type;
        TextView textView = (TextView) view.findViewById(R.id.title);
        TextView textView2 = (TextView) view.findViewById(R.id.summary);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.cards_layout);
        final TextView textView3 = (TextView) view.findViewById(R.id.expand_button);
        final ScrollView scrollView = (ScrollView) view.findViewById(R.id.scroll_view);
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.import_button);
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.cancel_button);
        int size = this.toAdd.size();
        int size2 = this.toModify.size();
        int size3 = this.toRemove.size();
        textView.setText(getString(R.string.deck_import_confirmation_title));
        StringBuilder sb = new StringBuilder();
        if (size > 0) {
            sb.append(getString(R.string.external_sync_cards_to_add, Integer.valueOf(size)));
            sb.append("\n");
        }
        if (size2 > 0) {
            sb.append(getString(R.string.external_sync_cards_to_modify, Integer.valueOf(size2)));
            sb.append("\n");
        }
        if (size3 > 0) {
            sb.append(getString(R.string.external_sync_cards_to_remove, Integer.valueOf(size3)));
            sb.append("\n");
        }
        String string = sb.toString();
        if (string.length() == 0) {
            string = getString(R.string.external_sync_no_changes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        textView2.setText(string);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ExternalDeckSyncConfirmationDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExternalDeckSyncConfirmationDialogFragment.setupViews$lambda$2(booleanRef, scrollView, this, textView3, view2);
            }
        });
        if (size > 0) {
            String string2 = getString(R.string.external_sync_section_add);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            linearLayout.addView(createSectionHeaderView(string2));
            Iterator<T> it = this.toAdd.iterator();
            while (it.hasNext()) {
                MTFullCard card = ((MTDeckCardToAdd) it.next()).getCard();
                if (card != null) {
                    linearLayout.addView(createCardViewForSync(card, null, "add"));
                }
            }
        }
        if (size2 > 0) {
            String string3 = getString(R.string.external_sync_section_modify);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            linearLayout.addView(createSectionHeaderView(string3));
            for (MTDeckCardToModify mTDeckCardToModify : this.toModify) {
                MTFullCard card2 = mTDeckCardToModify.getCard();
                if (card2 != null) {
                    MTDeckCardChange change = mTDeckCardToModify.getChange();
                    if (change == null || (type = change.getType()) == null) {
                        type = "";
                    }
                    linearLayout.addView(createCardViewForSync(card2, type, "modify"));
                }
            }
        }
        if (size3 > 0) {
            String string4 = getString(R.string.external_sync_section_remove);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            linearLayout.addView(createSectionHeaderView(string4));
            Iterator<T> it2 = this.toRemove.iterator();
            while (it2.hasNext()) {
                MTFullCard card3 = ((MTDeckCardToRemove) it2.next()).getCard();
                if (card3 != null) {
                    linearLayout.addView(createCardViewForSync(card3, null, "remove"));
                }
            }
        }
        materialButton.setText(getString(R.string.external_sync_apply_modifications));
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ExternalDeckSyncConfirmationDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExternalDeckSyncConfirmationDialogFragment.setupViews$lambda$6(this.f$0, view2);
            }
        });
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ExternalDeckSyncConfirmationDialogFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExternalDeckSyncConfirmationDialogFragment.setupViews$lambda$7(this.f$0, view2);
            }
        });
    }

    static final void setupViews$lambda$2(Ref.BooleanRef booleanRef, ScrollView scrollView, ExternalDeckSyncConfirmationDialogFragment externalDeckSyncConfirmationDialogFragment, TextView textView, View view) {
        booleanRef.element = !booleanRef.element;
        if (!booleanRef.element) {
            scrollView.setVisibility(8);
            textView.setText(externalDeckSyncConfirmationDialogFragment.getString(R.string.deck_import_show_cards));
            return;
        }
        scrollView.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
        layoutParams.height = (int) (((double) externalDeckSyncConfirmationDialogFragment.getResources().getDisplayMetrics().heightPixels) * 0.4d);
        scrollView.setLayoutParams(layoutParams);
        textView.setText(externalDeckSyncConfirmationDialogFragment.getString(R.string.deck_import_hide_cards));
    }

    static final void setupViews$lambda$6(ExternalDeckSyncConfirmationDialogFragment externalDeckSyncConfirmationDialogFragment, View view) {
        Function0<Unit> function0 = externalDeckSyncConfirmationDialogFragment.onConfirm;
        if (function0 != null) {
            function0.invoke();
        }
        externalDeckSyncConfirmationDialogFragment.dismiss();
    }

    static final void setupViews$lambda$7(ExternalDeckSyncConfirmationDialogFragment externalDeckSyncConfirmationDialogFragment, View view) {
        Function0<Unit> function0 = externalDeckSyncConfirmationDialogFragment.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
        externalDeckSyncConfirmationDialogFragment.dismiss();
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
