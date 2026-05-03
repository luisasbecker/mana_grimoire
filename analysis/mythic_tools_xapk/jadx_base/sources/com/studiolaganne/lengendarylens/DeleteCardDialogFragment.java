package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteCardDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0013H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u000e¢\u0006\u0002\n\u0000R[\u0010\r\u001aO\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\t\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeleteCardDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "cardName", "", "maxQuantity", "", "selectedQuantity", "restoreCards", "", "listCardIds", "", "onDeleteConfirmed", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.QUANTITY, "selectedIds", "", "onCancelled", "Lkotlin/Function0;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "updateMinusButtonState", "minusLabel", "Landroid/widget/TextView;", "updatePlusButtonState", "plusLabel", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeleteCardDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private Function0<Unit> onCancelled;
    private Function3<? super Integer, ? super Boolean, ? super List<Integer>, Unit> onDeleteConfirmed;
    private String cardName = "";
    private int maxQuantity = 1;
    private int selectedQuantity = 1;
    private boolean restoreCards = true;
    private List<Integer> listCardIds = CollectionsKt.emptyList();

    /* JADX INFO: compiled from: DeleteCardDialogFragment.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eJY\u0010\u000f\u001a\u00020\u00002Q\u0010\u0010\u001aM\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0012\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0012\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\f\b\u0012\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0011J\u0014\u0010\u0017\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018J\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeleteCardDialogFragment$Builder;", "", "<init>", "()V", "dialog", "Lcom/studiolaganne/lengendarylens/DeleteCardDialogFragment;", "setCardName", "name", "", "setMaxQuantity", FirebaseAnalytics.Param.QUANTITY, "", "setListCardIds", "ids", "", "setOnDeleteConfirmed", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "", "restoreCards", "selectedIds", "", "setOnCancelled", "Lkotlin/Function0;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final DeleteCardDialogFragment dialog = new DeleteCardDialogFragment();

        public final Builder setCardName(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.dialog.cardName = name;
            return this;
        }

        public final Builder setListCardIds(List<Integer> ids) {
            Intrinsics.checkNotNullParameter(ids, "ids");
            this.dialog.listCardIds = ids;
            return this;
        }

        public final Builder setMaxQuantity(int quantity) {
            this.dialog.maxQuantity = quantity;
            return this;
        }

        public final Builder setOnCancelled(Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.dialog.onCancelled = callback;
            return this;
        }

        public final Builder setOnDeleteConfirmed(Function3<? super Integer, ? super Boolean, ? super List<Integer>, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.dialog.onDeleteConfirmed = callback;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialog, manager, tag);
        }
    }

    static final Unit onCreateView$lambda$0(DeleteCardDialogFragment deleteCardDialogFragment, TextView textView, TextView textView2, TextView textView3) {
        int i = deleteCardDialogFragment.selectedQuantity;
        if (i > 1) {
            int i2 = i - 1;
            deleteCardDialogFragment.selectedQuantity = i2;
            textView.setText(String.valueOf(i2));
            Intrinsics.checkNotNull(textView2);
            deleteCardDialogFragment.updateMinusButtonState(textView2);
            Intrinsics.checkNotNull(textView3);
            deleteCardDialogFragment.updatePlusButtonState(textView3);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$1(DeleteCardDialogFragment deleteCardDialogFragment, TextView textView, TextView textView2, TextView textView3) {
        int i = deleteCardDialogFragment.selectedQuantity;
        if (i < deleteCardDialogFragment.maxQuantity) {
            int i2 = i + 1;
            deleteCardDialogFragment.selectedQuantity = i2;
            textView.setText(String.valueOf(i2));
            Intrinsics.checkNotNull(textView2);
            deleteCardDialogFragment.updateMinusButtonState(textView2);
            Intrinsics.checkNotNull(textView3);
            deleteCardDialogFragment.updatePlusButtonState(textView3);
        }
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$2(DeleteCardDialogFragment deleteCardDialogFragment, TextView textView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        deleteCardDialogFragment.restoreCards = z;
        textView.setVisibility(!z ? 0 : 8);
    }

    static final Unit onCreateView$lambda$3(DeleteCardDialogFragment deleteCardDialogFragment) {
        List listTake = CollectionsKt.take(deleteCardDialogFragment.listCardIds, deleteCardDialogFragment.selectedQuantity);
        Function3<? super Integer, ? super Boolean, ? super List<Integer>, Unit> function3 = deleteCardDialogFragment.onDeleteConfirmed;
        if (function3 != null) {
            function3.invoke(Integer.valueOf(deleteCardDialogFragment.selectedQuantity), Boolean.valueOf(deleteCardDialogFragment.restoreCards), listTake);
        }
        deleteCardDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$4(DeleteCardDialogFragment deleteCardDialogFragment) {
        Function0<Unit> function0 = deleteCardDialogFragment.onCancelled;
        if (function0 != null) {
            function0.invoke();
        }
        deleteCardDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    private final void updateMinusButtonState(TextView minusLabel) {
        minusLabel.setAlpha(this.selectedQuantity <= 1 ? 0.3f : 1.0f);
    }

    private final void updatePlusButtonState(TextView plusLabel) {
        plusLabel.setAlpha(this.selectedQuantity >= this.maxQuantity ? 0.3f : 1.0f);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_delete_card, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.title);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.quantityLayout);
        final TextView textView2 = (TextView) viewInflate.findViewById(R.id.minusQtyLabel);
        final TextView textView3 = (TextView) viewInflate.findViewById(R.id.qtyLabel);
        final TextView textView4 = (TextView) viewInflate.findViewById(R.id.plusQtyLabel);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.restoreCardsCheckBox);
        final TextView textView5 = (TextView) viewInflate.findViewById(R.id.warningText);
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.positive_button);
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.negative_button);
        textView.setText(this.cardName);
        int i = this.maxQuantity;
        this.selectedQuantity = i;
        textView3.setText(String.valueOf(i));
        if (this.maxQuantity > 1) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
        Intrinsics.checkNotNull(textView2);
        updateMinusButtonState(textView2);
        Intrinsics.checkNotNull(textView4);
        updatePlusButtonState(textView4);
        ViewExtensionsKt.setOnClickWithFade(textView2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeleteCardDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeleteCardDialogFragment.onCreateView$lambda$0(this.f$0, textView3, textView2, textView4);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(textView4, new Function0() { // from class: com.studiolaganne.lengendarylens.DeleteCardDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeleteCardDialogFragment.onCreateView$lambda$1(this.f$0, textView3, textView2, textView4);
            }
        });
        checkBox.setChecked(this.restoreCards);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.DeleteCardDialogFragment$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DeleteCardDialogFragment.onCreateView$lambda$2(this.f$0, textView5, compoundButton, z);
            }
        });
        Intrinsics.checkNotNull(materialButton);
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.DeleteCardDialogFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeleteCardDialogFragment.onCreateView$lambda$3(this.f$0);
            }
        });
        Intrinsics.checkNotNull(materialButton2);
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.DeleteCardDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeleteCardDialogFragment.onCreateView$lambda$4(this.f$0);
            }
        });
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
