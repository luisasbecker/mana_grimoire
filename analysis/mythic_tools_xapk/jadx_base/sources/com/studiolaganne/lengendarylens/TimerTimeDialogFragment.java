package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.NumberPicker;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.TimerTimeDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimerTimeDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\fH\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f0\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/TimerTimeDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "minutes", "", "getMinutes", "()I", "setMinutes", "(I)V", "positiveButtonCallback", "Lkotlin/Function2;", "", "getPositiveButtonCallback", "()Lkotlin/jvm/functions/Function2;", "setPositiveButtonCallback", "(Lkotlin/jvm/functions/Function2;)V", "negativeButtonCallback", "Lkotlin/Function1;", "getNegativeButtonCallback", "()Lkotlin/jvm/functions/Function1;", "setNegativeButtonCallback", "(Lkotlin/jvm/functions/Function1;)V", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TimerTimeDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private int minutes = 90;
    public Function1<? super TimerTimeDialogFragment, Unit> negativeButtonCallback;
    public Function2<? super Integer, ? super TimerTimeDialogFragment, Unit> positiveButtonCallback;

    /* JADX INFO: compiled from: TimerTimeDialogFragment.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J \u0010\r\u001a\u00020\u00002\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\u001a\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000bJ\u0006\u0010\u0010\u001a\u00020\bJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/TimerTimeDialogFragment$Builder;", "", "<init>", "()V", "minutes", "", "positiveButtonCallback", "Lkotlin/Function2;", "Lcom/studiolaganne/lengendarylens/TimerTimeDialogFragment;", "", "negativeButtonCallback", "Lkotlin/Function1;", "setMinutes", "setPositiveButtonCallback", "callback", "setNegativeButtonCallback", "build", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private int minutes = 90;
        private Function2<? super Integer, ? super TimerTimeDialogFragment, Unit> positiveButtonCallback = new Function2() { // from class: com.studiolaganne.lengendarylens.TimerTimeDialogFragment$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TimerTimeDialogFragment.Builder.positiveButtonCallback$lambda$0(((Integer) obj).intValue(), (TimerTimeDialogFragment) obj2);
            }
        };
        private Function1<? super TimerTimeDialogFragment, Unit> negativeButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.TimerTimeDialogFragment$Builder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimerTimeDialogFragment.Builder.negativeButtonCallback$lambda$0((TimerTimeDialogFragment) obj);
            }
        };

        static final Unit negativeButtonCallback$lambda$0(TimerTimeDialogFragment timerTimeDialogFragment) {
            Intrinsics.checkNotNullParameter(timerTimeDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit positiveButtonCallback$lambda$0(int i, TimerTimeDialogFragment timerTimeDialogFragment) {
            Intrinsics.checkNotNullParameter(timerTimeDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        public final TimerTimeDialogFragment build() {
            TimerTimeDialogFragment timerTimeDialogFragment = new TimerTimeDialogFragment();
            timerTimeDialogFragment.setMinutes(this.minutes);
            timerTimeDialogFragment.setPositiveButtonCallback(this.positiveButtonCallback);
            timerTimeDialogFragment.setNegativeButtonCallback(this.negativeButtonCallback);
            return timerTimeDialogFragment;
        }

        public final Builder setMinutes(int minutes) {
            this.minutes = minutes;
            return this;
        }

        public final Builder setNegativeButtonCallback(Function1<? super TimerTimeDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.negativeButtonCallback = callback;
            return this;
        }

        public final Builder setPositiveButtonCallback(Function2<? super Integer, ? super TimerTimeDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.positiveButtonCallback = callback;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    static final Unit onCreateView$lambda$0(TimerTimeDialogFragment timerTimeDialogFragment, NumberPicker numberPicker, NumberPicker numberPicker2) {
        timerTimeDialogFragment.getPositiveButtonCallback().invoke(Integer.valueOf((numberPicker.getValue() * 60) + numberPicker2.getValue()), timerTimeDialogFragment);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$1(TimerTimeDialogFragment timerTimeDialogFragment) {
        timerTimeDialogFragment.getNegativeButtonCallback().invoke(timerTimeDialogFragment);
        return Unit.INSTANCE;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    public final Function1<TimerTimeDialogFragment, Unit> getNegativeButtonCallback() {
        Function1 function1 = this.negativeButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("negativeButtonCallback");
        return null;
    }

    public final Function2<Integer, TimerTimeDialogFragment, Unit> getPositiveButtonCallback() {
        Function2 function2 = this.positiveButtonCallback;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("positiveButtonCallback");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_pick_timer_time, container, false);
        final NumberPicker numberPicker = (NumberPicker) viewInflate.findViewById(R.id.hr_timepicker);
        final NumberPicker numberPicker2 = (NumberPicker) viewInflate.findViewById(R.id.min_timepicker);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(24);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(59);
        numberPicker.setValue(this.minutes / 60);
        numberPicker2.setValue(this.minutes % 60);
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.positive_button);
        Intrinsics.checkNotNull(materialButton);
        ViewExtensionsKt.setOnClickWithFade(materialButton, new Function0() { // from class: com.studiolaganne.lengendarylens.TimerTimeDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TimerTimeDialogFragment.onCreateView$lambda$0(this.f$0, numberPicker, numberPicker2);
            }
        });
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.negative_button);
        Intrinsics.checkNotNull(materialButton2);
        ViewExtensionsKt.setOnClickWithFade(materialButton2, new Function0() { // from class: com.studiolaganne.lengendarylens.TimerTimeDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TimerTimeDialogFragment.onCreateView$lambda$1(this.f$0);
            }
        });
        setCancelable(true);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
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
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.85d), -2);
    }

    public final void setMinutes(int i) {
        this.minutes = i;
    }

    public final void setNegativeButtonCallback(Function1<? super TimerTimeDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.negativeButtonCallback = function1;
    }

    public final void setPositiveButtonCallback(Function2<? super Integer, ? super TimerTimeDialogFragment, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.positiveButtonCallback = function2;
    }
}
