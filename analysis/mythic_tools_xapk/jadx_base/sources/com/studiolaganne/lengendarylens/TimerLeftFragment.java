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
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimerLeftFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/TimerLeftFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "positiveButtonListener", "Lkotlin/Function1;", "", "onDismiss", "Lkotlin/Function0;", "text", "", "internalRotation", "", "dpToPx", "dp", "context", "Landroid/content/Context;", "onStart", "dialog", "Landroid/content/DialogInterface;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TimerLeftFragment extends DialogFragment {
    public static final int $stable = 8;
    private int internalRotation;
    private Function0<Unit> onDismiss;
    private Function1<? super TimerLeftFragment, Unit> positiveButtonListener;
    private String text = "";

    /* JADX INFO: compiled from: TimerLeftFragment.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bJ\u0014\u0010\n\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/TimerLeftFragment$Builder;", "", "<init>", "()V", "dialogFragment", "Lcom/studiolaganne/lengendarylens/TimerLeftFragment;", "setPositiveButton", "onClick", "Lkotlin/Function1;", "", "setOnDismissListener", "onDismiss", "Lkotlin/Function0;", "setText", "text", "", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "setRotation", Key.ROTATION, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private final TimerLeftFragment dialogFragment = new TimerLeftFragment();

        public final Builder setOnDismissListener(Function0<Unit> onDismiss) {
            Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
            this.dialogFragment.onDismiss = onDismiss;
            return this;
        }

        public final Builder setPositiveButton(Function1<? super TimerLeftFragment, Unit> onClick) {
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.dialogFragment.positiveButtonListener = onClick;
            return this;
        }

        public final Builder setRotation(int rotation) {
            this.dialogFragment.internalRotation = rotation;
            return this;
        }

        public final Builder setText(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.dialogFragment.text = text;
            View view = this.dialogFragment.getView();
            TextView textView = view != null ? (TextView) view.findViewById(R.id.main_text) : null;
            if (textView != null) {
                textView.setText(text);
            }
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(this.dialogFragment, manager, tag);
        }
    }

    static final Unit onCreateView$lambda$2(TimerLeftFragment timerLeftFragment) {
        Function1<? super TimerLeftFragment, Unit> function1 = timerLeftFragment.positiveButtonListener;
        if (function1 != null) {
            function1.invoke(timerLeftFragment);
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$3(TimerLeftFragment timerLeftFragment) {
        Function1<? super TimerLeftFragment, Unit> function1 = timerLeftFragment.positiveButtonListener;
        if (function1 != null) {
            function1.invoke(timerLeftFragment);
        }
        return Unit.INSTANCE;
    }

    public final int dpToPx(int dp, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_timer_left, container, false);
        ((TextView) viewInflate.findViewById(R.id.main_text)).setText(this.text);
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.root_layout);
        constraintLayout.setRotation(this.internalRotation);
        if (this.positiveButtonListener != null) {
            constraintLayout.setVisibility(0);
        } else {
            constraintLayout.setVisibility(4);
        }
        View viewFindViewById = viewInflate.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.TimerLeftFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TimerLeftFragment.onCreateView$lambda$2(this.f$0);
            }
        });
        Intrinsics.checkNotNull(viewInflate);
        ViewExtensionsKt.setOnClickWithFade(viewInflate, new Function0() { // from class: com.studiolaganne.lengendarylens.TimerLeftFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TimerLeftFragment.onCreateView$lambda$3(this.f$0);
            }
        });
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
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
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        int i = (int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.95d);
        window.setLayout(i, i);
        View view = getView();
        if (view != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            int i2 = attributes.y;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            attributes.y = i2 - dpToPx(30, context);
            window.setAttributes(attributes);
        }
    }
}
