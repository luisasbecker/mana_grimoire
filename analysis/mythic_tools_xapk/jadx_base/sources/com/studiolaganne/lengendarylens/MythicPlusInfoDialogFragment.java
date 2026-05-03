package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MythicPlusInfoDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusInfoDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onConfirm", "Lkotlin/Function0;", "", "getOnConfirm", "()Lkotlin/jvm/functions/Function0;", "setOnConfirm", "(Lkotlin/jvm/functions/Function0;)V", "onCancel", "getOnCancel", "setOnCancel", "confirmed", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "onStart", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MythicPlusInfoDialogFragment extends DialogFragment {
    private boolean confirmed;
    private Function0<Unit> onCancel;
    private Function0<Unit> onConfirm;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MythicPlusInfoDialogFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicPlusInfoDialogFragment$Companion;", "", "<init>", "()V", "show", "Lcom/studiolaganne/lengendarylens/MythicPlusInfoDialogFragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", "onConfirm", "Lkotlin/Function0;", "", "onCancel", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MythicPlusInfoDialogFragment show$default(Companion companion, FragmentActivity fragmentActivity, Function0 function0, Function0 function02, int i, Object obj) {
            if ((i & 4) != 0) {
                function02 = null;
            }
            return companion.show(fragmentActivity, function0, function02);
        }

        public final MythicPlusInfoDialogFragment show(FragmentActivity activity, Function0<Unit> onConfirm, Function0<Unit> onCancel) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
            MythicPlusInfoDialogFragment mythicPlusInfoDialogFragment = new MythicPlusInfoDialogFragment();
            mythicPlusInfoDialogFragment.setOnConfirm(onConfirm);
            mythicPlusInfoDialogFragment.setOnCancel(onCancel);
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentExtensionsKt.showSafely(mythicPlusInfoDialogFragment, supportFragmentManager, "MythicPlusInfo");
            return mythicPlusInfoDialogFragment;
        }
    }

    static final Unit onViewCreated$lambda$0(MythicPlusInfoDialogFragment mythicPlusInfoDialogFragment) {
        mythicPlusInfoDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$1(MythicPlusInfoDialogFragment mythicPlusInfoDialogFragment) {
        mythicPlusInfoDialogFragment.confirmed = true;
        mythicPlusInfoDialogFragment.dismiss();
        Function0<Unit> function0 = mythicPlusInfoDialogFragment.onConfirm;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public final Function0<Unit> getOnCancel() {
        return this.onCancel;
    }

    public final Function0<Unit> getOnConfirm() {
        return this.onConfirm;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_mythic_plus_info, container, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.confirmed || (function0 = this.onCancel) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        int i = getResources().getDisplayMetrics().widthPixels;
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        window.setLayout(Math.min((int) (((double) i) * 0.92d), companion.dpToPx(420, contextRequireContext)), -2);
        window.setDimAmount(0.65f);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.mythicPlusInfoCloseImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusInfoDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusInfoDialogFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        View viewFindViewById2 = view.findViewById(R.id.mythicPlusInfoCtaLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.MythicPlusInfoDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MythicPlusInfoDialogFragment.onViewCreated$lambda$1(this.f$0);
            }
        });
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    public final void setOnCancel(Function0<Unit> function0) {
        this.onCancel = function0;
    }

    public final void setOnConfirm(Function0<Unit> function0) {
        this.onConfirm = function0;
    }
}
