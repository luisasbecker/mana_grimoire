package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CountersDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/CountersDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "initialValue", "", "valueChangeListener", "Lkotlin/Function1;", "", "dismissListener", "Lkotlin/Function0;", "rotationAngle", "", "isCommanderDamage", "", "energy", "storm", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CountersDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private Function0<Unit> dismissListener;
    private boolean energy;
    private int initialValue;
    private boolean isCommanderDamage;
    private float rotationAngle;
    private boolean storm;
    private Function1<? super Integer, Unit> valueChangeListener;

    /* JADX INFO: compiled from: CountersDialogFragment.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0000J\u0006\u0010\u0014\u001a\u00020\u0000J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eJ\u001a\u0010\u0016\u001a\u00020\u00002\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\u0018\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\nJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/CountersDialogFragment$Builder;", "", "<init>", "()V", "initialValue", "", "onValueChange", "Lkotlin/Function1;", "", "onDismiss", "Lkotlin/Function0;", "rotationAngle", "", "isCommanderDamage", "", "energy", "storm", "setInitialValue", "value", "setEnergy", "setStorm", "setIsCommanderDamage", "setOnValueChangeListener", "callback", "setOnDismissListener", "setRotationAngle", "angle", "build", "Lcom/studiolaganne/lengendarylens/CountersDialogFragment;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private boolean energy;
        private int initialValue;
        private boolean isCommanderDamage;
        private float rotationAngle;
        private boolean storm;
        private Function1<? super Integer, Unit> onValueChange = new Function1() { // from class: com.studiolaganne.lengendarylens.CountersDialogFragment$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ((Integer) obj).intValue();
                return Unit.INSTANCE;
            }
        };
        private Function0<Unit> onDismiss = new Function0() { // from class: com.studiolaganne.lengendarylens.CountersDialogFragment$Builder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };

        public final CountersDialogFragment build() {
            CountersDialogFragment countersDialogFragment = new CountersDialogFragment();
            countersDialogFragment.initialValue = this.initialValue;
            countersDialogFragment.valueChangeListener = this.onValueChange;
            countersDialogFragment.dismissListener = this.onDismiss;
            countersDialogFragment.rotationAngle = this.rotationAngle;
            countersDialogFragment.isCommanderDamage = this.isCommanderDamage;
            countersDialogFragment.energy = this.energy;
            countersDialogFragment.storm = this.storm;
            return countersDialogFragment;
        }

        public final Builder setEnergy() {
            this.energy = true;
            return this;
        }

        public final Builder setInitialValue(int value) {
            this.initialValue = value;
            return this;
        }

        public final Builder setIsCommanderDamage(boolean value) {
            this.isCommanderDamage = value;
            return this;
        }

        public final Builder setOnDismissListener(Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.onDismiss = callback;
            return this;
        }

        public final Builder setOnValueChangeListener(Function1<? super Integer, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.onValueChange = callback;
            return this;
        }

        public final Builder setRotationAngle(int angle) {
            this.rotationAngle = angle;
            return this;
        }

        public final Builder setStorm() {
            this.storm = true;
            return this;
        }

        public final boolean show(FragmentManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            return FragmentExtensionsKt.showSafely(build(), manager, "PhyrexianDialogFragment");
        }
    }

    static final Unit onViewCreated$lambda$0(CountersDialogFragment countersDialogFragment, TextView textView) {
        int i = countersDialogFragment.initialValue + 1;
        countersDialogFragment.initialValue = i;
        textView.setText(String.valueOf(i));
        Function1<? super Integer, Unit> function1 = countersDialogFragment.valueChangeListener;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueChangeListener");
            function1 = null;
        }
        function1.invoke(Integer.valueOf(countersDialogFragment.initialValue));
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$1(CountersDialogFragment countersDialogFragment, TextView textView) {
        int i = countersDialogFragment.initialValue;
        if (i > 0) {
            int i2 = i - 1;
            countersDialogFragment.initialValue = i2;
            textView.setText(String.valueOf(i2));
            Function1<? super Integer, Unit> function1 = countersDialogFragment.valueChangeListener;
            if (function1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueChangeListener");
                function1 = null;
            }
            function1.invoke(Integer.valueOf(countersDialogFragment.initialValue));
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        float f = this.rotationAngle;
        return inflater.inflate(f == 90.0f ? R.layout.dialog_poison_counters_input_90 : f == 180.0f ? R.layout.dialog_poison_counters_input_180 : f == 270.0f ? R.layout.dialog_poison_counters_input_270 : R.layout.dialog_poison_counters_input, container, false);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.dismissListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.phyrexianWhite);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.phyrexianBlack);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ImageView imageView2 = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.poisonCountersText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final TextView textView = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.plus_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        LongPressButton longPressButton = (LongPressButton) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.minus_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        LongPressButton longPressButton2 = (LongPressButton) viewFindViewById5;
        if (this.energy) {
            imageView.setImageResource(R.drawable.energy_off);
            imageView2.setImageResource(R.drawable.energy_black);
        }
        if (this.storm) {
            imageView.setImageResource(R.drawable.storm_off);
            imageView2.setImageResource(R.drawable.storm_black);
        }
        if (this.isCommanderDamage) {
            imageView.setImageResource(R.drawable.cmd_damage_white);
            imageView2.setImageResource(R.drawable.cmd_damage_black);
        }
        textView.setText(String.valueOf(this.initialValue));
        longPressButton.setCustomClickListener(new Function0() { // from class: com.studiolaganne.lengendarylens.CountersDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CountersDialogFragment.onViewCreated$lambda$0(this.f$0, textView);
            }
        });
        longPressButton2.setCustomClickListener(new Function0() { // from class: com.studiolaganne.lengendarylens.CountersDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CountersDialogFragment.onViewCreated$lambda$1(this.f$0, textView);
            }
        });
    }
}
