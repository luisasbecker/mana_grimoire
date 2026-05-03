package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContainerImportConfirmationDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000bH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/ContainerImportConfirmationDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "containerName", "", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "onConfirm", "Lkotlin/Function1;", "", "onCancel", "Lkotlin/Function0;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupViews", ViewHierarchyConstants.VIEW_KEY, "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ContainerImportConfirmationDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private Function0<Unit> onCancel;
    private Function1<? super List<MTFullCard>, Unit> onConfirm;
    private String containerName = "";
    private List<MTFullCard> cards = CollectionsKt.emptyList();

    /* JADX INFO: compiled from: ContainerImportConfirmationDialogFragment.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ \u0010\r\u001a\u00020\u00002\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0014\u0010\u0011\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/ContainerImportConfirmationDialogFragment$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/ContainerImportConfirmationDialogFragment;", "setContainerName", "name", "", "setCards", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "setOnConfirm", "callback", "Lkotlin/Function1;", "", "setOnCancel", "Lkotlin/Function0;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final ContainerImportConfirmationDialogFragment dialogFragment = new ContainerImportConfirmationDialogFragment();

        public final Builder setCards(List<MTFullCard> cards) {
            Intrinsics.checkNotNullParameter(cards, "cards");
            this.dialogFragment.cards = cards;
            return this;
        }

        public final Builder setContainerName(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.dialogFragment.containerName = name;
            return this;
        }

        public final Builder setOnCancel(Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.dialogFragment.onCancel = callback;
            return this;
        }

        public final Builder setOnConfirm(Function1<? super List<MTFullCard>, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.dialogFragment.onConfirm = callback;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialogFragment, manager, tag);
        }
    }

    private final void setupViews(View view) {
        TextView textView = (TextView) view.findViewById(R.id.title);
        TextView textView2 = (TextView) view.findViewById(R.id.summary);
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.positive_button);
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.negative_button);
        textView.setText(getString(R.string.container_import_confirmation_title));
        Iterator<T> it = this.cards.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            Integer quantity = ((MTFullCard) it.next()).getQuantity();
            iIntValue += quantity != null ? quantity.intValue() : 1;
        }
        textView2.setText(getString(R.string.container_import_confirmation_summary, Integer.valueOf(iIntValue), this.containerName));
        Intrinsics.checkNotNull(materialButton);
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.ContainerImportConfirmationDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ContainerImportConfirmationDialogFragment.setupViews$lambda$1(this.f$0);
            }
        });
        Intrinsics.checkNotNull(materialButton2);
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.ContainerImportConfirmationDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ContainerImportConfirmationDialogFragment.setupViews$lambda$2(this.f$0);
            }
        });
    }

    static final Unit setupViews$lambda$1(ContainerImportConfirmationDialogFragment containerImportConfirmationDialogFragment) {
        Function1<? super List<MTFullCard>, Unit> function1 = containerImportConfirmationDialogFragment.onConfirm;
        if (function1 != null) {
            function1.invoke(containerImportConfirmationDialogFragment.cards);
        }
        containerImportConfirmationDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit setupViews$lambda$2(ContainerImportConfirmationDialogFragment containerImportConfirmationDialogFragment) {
        Function0<Unit> function0 = containerImportConfirmationDialogFragment.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
        containerImportConfirmationDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_container_import_confirmation, container, false);
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
        ScrollView scrollView;
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
        }
        View view = getView();
        if (view == null || (scrollView = (ScrollView) view.findViewById(R.id.scroll_view)) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.4d);
        } else {
            layoutParams = null;
        }
        scrollView.setLayoutParams(layoutParams);
    }
}
