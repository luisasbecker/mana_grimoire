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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomDialogFragmentSquare.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/CustomDialogFragmentSquare;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", Constants.GP_IAP_TITLE, "", "body", "positiveButtonText", "negativeButtonText", "thirdButtonText", "positiveButtonListener", "Lkotlin/Function1;", "", "negativeButtonListener", "thirdButtonListener", "onDismiss", "Lkotlin/Function0;", "positiveButtonRed", "", Key.ROTATION, "", "dialog", "Landroid/content/DialogInterface;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomDialogFragmentSquare extends DialogFragment {
    public static final int $stable = 8;
    private Function1<? super CustomDialogFragmentSquare, Unit> negativeButtonListener;
    private Function0<Unit> onDismiss;
    private Function1<? super CustomDialogFragmentSquare, Unit> positiveButtonListener;
    private boolean positiveButtonRed;
    private int rotation;
    private Function1<? super CustomDialogFragmentSquare, Unit> thirdButtonListener;
    private String title = "";
    private String body = "";
    private String positiveButtonText = "";
    private String negativeButtonText = "";
    private String thirdButtonText = "";

    /* JADX INFO: compiled from: CustomDialogFragmentSquare.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bJ\"\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u0010\u0013\u001a\u00020\u0000J\"\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0011J\"\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0011J\u0014\u0010\u0016\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/CustomDialogFragmentSquare$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/CustomDialogFragmentSquare;", "setTitle", Constants.GP_IAP_TITLE, "", "setRotation", Key.ROTATION, "", "setBody", "body", "setPositiveButton", "text", "onClick", "Lkotlin/Function1;", "", "setPositiveButtonRed", "setNegativeButton", "setThirdButton", "setOnDismissListener", "onDismiss", "Lkotlin/Function0;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final CustomDialogFragmentSquare dialogFragment = new CustomDialogFragmentSquare();

        public final Builder setBody(String body) {
            Intrinsics.checkNotNullParameter(body, "body");
            this.dialogFragment.body = body;
            return this;
        }

        public final Builder setNegativeButton(String text, Function1<? super CustomDialogFragmentSquare, Unit> onClick) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.dialogFragment.negativeButtonText = text;
            this.dialogFragment.negativeButtonListener = onClick;
            return this;
        }

        public final Builder setOnDismissListener(Function0<Unit> onDismiss) {
            Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
            this.dialogFragment.onDismiss = onDismiss;
            return this;
        }

        public final Builder setPositiveButton(String text, Function1<? super CustomDialogFragmentSquare, Unit> onClick) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.dialogFragment.positiveButtonText = text;
            this.dialogFragment.positiveButtonListener = onClick;
            return this;
        }

        public final Builder setPositiveButtonRed() {
            this.dialogFragment.positiveButtonRed = true;
            return this;
        }

        public final Builder setRotation(int rotation) {
            this.dialogFragment.rotation = rotation;
            return this;
        }

        public final Builder setThirdButton(String text, Function1<? super CustomDialogFragmentSquare, Unit> onClick) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.dialogFragment.thirdButtonText = text;
            this.dialogFragment.thirdButtonListener = onClick;
            return this;
        }

        public final Builder setTitle(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.dialogFragment.title = title;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialogFragment, manager, tag);
        }
    }

    static final Unit onCreateView$lambda$6(CustomDialogFragmentSquare customDialogFragmentSquare) {
        Function1<? super CustomDialogFragmentSquare, Unit> function1 = customDialogFragmentSquare.positiveButtonListener;
        if (function1 != null) {
            function1.invoke(customDialogFragmentSquare);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$7(CustomDialogFragmentSquare customDialogFragmentSquare) {
        Function1<? super CustomDialogFragmentSquare, Unit> function1 = customDialogFragmentSquare.negativeButtonListener;
        if (function1 != null) {
            function1.invoke(customDialogFragmentSquare);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$8(CustomDialogFragmentSquare customDialogFragmentSquare) {
        Function1<? super CustomDialogFragmentSquare, Unit> function1 = customDialogFragmentSquare.thirdButtonListener;
        if (function1 != null) {
            function1.invoke(customDialogFragmentSquare);
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_custom_square, container, false);
        ((TextView) viewInflate.findViewById(R.id.title)).setText(this.title);
        ((TextView) viewInflate.findViewById(R.id.body)).setText(this.body);
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.positive_button);
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.negative_button);
        MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(R.id.third_button);
        materialButton.setText(this.positiveButtonText);
        materialButton2.setText(this.negativeButtonText);
        materialButton3.setText(this.thirdButtonText);
        ((RelativeLayout) viewInflate.findViewById(R.id.dialog_root)).setRotation(this.rotation);
        if (this.positiveButtonRed) {
            materialButton.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_button_background));
        }
        if (this.positiveButtonListener != null) {
            materialButton.setVisibility(0);
        } else {
            materialButton.setVisibility(4);
        }
        if (this.negativeButtonListener != null) {
            materialButton2.setVisibility(0);
        } else {
            materialButton2.setVisibility(4);
        }
        if (this.thirdButtonListener != null) {
            materialButton3.setVisibility(0);
        } else {
            materialButton3.setVisibility(4);
        }
        View viewFindViewById = viewInflate.findViewById(R.id.positive_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.CustomDialogFragmentSquare$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomDialogFragmentSquare.onCreateView$lambda$6(this.f$0);
            }
        });
        View viewFindViewById2 = viewInflate.findViewById(R.id.negative_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.CustomDialogFragmentSquare$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomDialogFragmentSquare.onCreateView$lambda$7(this.f$0);
            }
        });
        View viewFindViewById3 = viewInflate.findViewById(R.id.third_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.CustomDialogFragmentSquare$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomDialogFragmentSquare.onCreateView$lambda$8(this.f$0);
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        Window window2;
        Window window3;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window3 = dialog.getWindow()) != null) {
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            int iDpToPx = companion.dpToPx(240, contextRequireContext);
            GameUtils companion2 = GameUtils.INSTANCE.getInstance();
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            window3.setLayout(iDpToPx, companion2.dpToPx(240, contextRequireContext2));
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window2 = dialog2.getWindow()) != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        Dialog dialog3 = getDialog();
        if (dialog3 == null || (window = dialog3.getWindow()) == null) {
            return;
        }
        window.setGravity(17);
    }
}
