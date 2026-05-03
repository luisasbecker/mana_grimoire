package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DiceDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\rH\u0002J(\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J(\u0010.\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J(\u0010/\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J(\u00100\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J\b\u00101\u001a\u00020\u0010H\u0002J\b\u00102\u001a\u00020\u0010H\u0002J\u0010\u00103\u001a\u0002042\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u00105\u001a\u0002042\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u00106\u001a\u0002042\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u00107\u001a\u0002042\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u00108\u001a\u0002042\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u00109\u001a\u0002042\u0006\u0010 \u001a\u00020\rH\u0002J\b\u0010:\u001a\u00020\u0010H\u0002J\b\u0010;\u001a\u00020\u0010H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/studiolaganne/lengendarylens/DiceDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "sharedViewModel", "Lcom/studiolaganne/lengendarylens/SharedViewModel;", "getSharedViewModel", "()Lcom/studiolaganne/lengendarylens/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "currentDice", "Landroid/widget/TextView;", "currentdNumber", "", "dismissListener", "Lkotlin/Function0;", "", "onTossListener", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "startCoinAnimation", "random", "startd20Animation", "startd12Animation", "startd10Animation", "startd8Animation", "startd6Animation", "startd4Animation", "animateTextViewVariationTopLeft", "newTextView", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "w", "", "h", "animateTextViewVariationBottomLeft", "animateTextViewVariationBottomRight", "animateTextViewVariationTopRight", "showBackAndRerollButtons", "hideBackAndRerollButtons", "textForRandomD20", "", "textForRandomD12", "textForRandomD10", "textForRandomD8", "textForRandomD6", "textForRandomD4", "hideDices", "showDices", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DiceDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private TextView currentDice;
    private int currentdNumber;
    private Function0<Unit> dismissListener;
    private Function0<Unit> onTossListener;

    /* JADX INFO: renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;

    /* JADX INFO: compiled from: DiceDialogFragment.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\n\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/DiceDialogFragment$Builder;", "", "<init>", "()V", "onDismiss", "Lkotlin/Function0;", "", "onToss", "setOnDismissListener", "callback", "setOnTossListener", "build", "Lcom/studiolaganne/lengendarylens/DiceDialogFragment;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private Function0<Unit> onDismiss = new Function0() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
        private Function0<Unit> onToss = new Function0() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$Builder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };

        public final DiceDialogFragment build() {
            DiceDialogFragment diceDialogFragment = new DiceDialogFragment();
            diceDialogFragment.onTossListener = this.onToss;
            diceDialogFragment.dismissListener = this.onDismiss;
            return diceDialogFragment;
        }

        public final Builder setOnDismissListener(Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.onDismiss = callback;
            return this;
        }

        public final Builder setOnTossListener(Function0<Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.onToss = callback;
            return this;
        }

        public final boolean show(FragmentManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            return FragmentExtensionsKt.showSafely(build(), manager, "DialogDialogFragment");
        }
    }

    public DiceDialogFragment() {
        final DiceDialogFragment diceDialogFragment = this;
        final Function0 function0 = null;
        this.sharedViewModel = FragmentViewModelLazyKt.createViewModelLazy(diceDialogFragment, Reflection.getOrCreateKotlinClass(SharedViewModel.class), new Function0<ViewModelStore>() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return diceDialogFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? diceDialogFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return diceDialogFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    private final void animateTextViewVariationBottomLeft(final TextView newTextView, final ConstraintLayout rootLayout, final float w, final float h) {
        newTextView.animate().x((rootLayout.getWidth() / 2.0f) - (w / 2.0f)).y(rootLayout.getHeight() - (h / 2.0f)).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                TextView textView = newTextView;
                ConstraintLayout constraintLayout = rootLayout;
                float f = h;
                textView.animate().x(0.0f).y(((constraintLayout.getHeight() * 3.0f) / 4.0f) - (f / 2.0f)).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        DiceDialogFragment.animateTextViewVariationBottomLeft$lambda$0$0(textView, constraintLayout, f, f, diceDialogFragment);
                    }
                }).start();
            }
        }).start();
        newTextView.animate().rotationBy(1080.0f).setDuration(1000L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                DiceDialogFragment.animateTextViewVariationBottomLeft$lambda$1();
            }
        }).setInterpolator(new DecelerateInterpolator()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationBottomLeft$lambda$0$0(TextView textView, ConstraintLayout constraintLayout, float f, float f2, final DiceDialogFragment diceDialogFragment) {
        textView.animate().x((constraintLayout.getWidth() / 2.0f) - (f / 2.0f)).y((constraintLayout.getHeight() / 2.0f) - (f2 / 2.0f)).setDuration(400L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                DiceDialogFragment.animateTextViewVariationBottomLeft$lambda$0$0$0();
            }
        }).start();
        textView.animate().scaleX(2.0f).scaleY(2.0f).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showBackAndRerollButtons();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationBottomLeft$lambda$0$0$0() {
    }

    static final void animateTextViewVariationBottomLeft$lambda$1() {
    }

    private final void animateTextViewVariationBottomRight(final TextView newTextView, final ConstraintLayout rootLayout, final float w, final float h) {
        newTextView.animate().x((rootLayout.getWidth() / 2.0f) - (w / 2.0f)).y(rootLayout.getHeight() - (h / 2.0f)).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                TextView textView = newTextView;
                ConstraintLayout constraintLayout = rootLayout;
                float f = w;
                float f2 = h;
                textView.animate().x(constraintLayout.getWidth() - (f / 2.0f)).y(((constraintLayout.getHeight() * 3.0f) / 4.0f) - (f2 / 2.0f)).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda20
                    @Override // java.lang.Runnable
                    public final void run() {
                        DiceDialogFragment.animateTextViewVariationBottomRight$lambda$0$0(textView, constraintLayout, f, f2, diceDialogFragment);
                    }
                }).start();
            }
        }).start();
        newTextView.animate().rotationBy(-1080.0f).setDuration(1000L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                DiceDialogFragment.animateTextViewVariationBottomRight$lambda$1();
            }
        }).setInterpolator(new DecelerateInterpolator()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationBottomRight$lambda$0$0(TextView textView, ConstraintLayout constraintLayout, float f, float f2, final DiceDialogFragment diceDialogFragment) {
        textView.animate().x((constraintLayout.getWidth() / 2.0f) - (f / 2.0f)).y((constraintLayout.getHeight() / 2.0f) - (f2 / 2.0f)).setDuration(400L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DiceDialogFragment.animateTextViewVariationBottomRight$lambda$0$0$0();
            }
        }).start();
        textView.animate().scaleX(2.0f).scaleY(2.0f).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showBackAndRerollButtons();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationBottomRight$lambda$0$0$0() {
    }

    static final void animateTextViewVariationBottomRight$lambda$1() {
    }

    private final void animateTextViewVariationTopLeft(final TextView newTextView, final ConstraintLayout rootLayout, final float w, final float h) {
        newTextView.animate().x((rootLayout.getWidth() / 2.0f) - (w / 2.0f)).y(0.0f).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                TextView textView = newTextView;
                ConstraintLayout constraintLayout = rootLayout;
                float f = h;
                textView.animate().x(0.0f).y((constraintLayout.getHeight() / 4.0f) - (f / 2.0f)).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda19
                    @Override // java.lang.Runnable
                    public final void run() {
                        DiceDialogFragment.animateTextViewVariationTopLeft$lambda$0$0(textView, constraintLayout, f, f, diceDialogFragment);
                    }
                }).start();
            }
        }).start();
        newTextView.animate().rotationBy(1080.0f).setDuration(1000L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                DiceDialogFragment.animateTextViewVariationTopLeft$lambda$1();
            }
        }).setInterpolator(new DecelerateInterpolator()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationTopLeft$lambda$0$0(TextView textView, ConstraintLayout constraintLayout, float f, float f2, final DiceDialogFragment diceDialogFragment) {
        textView.animate().x((constraintLayout.getWidth() / 2.0f) - (f / 2.0f)).y((constraintLayout.getHeight() / 2.0f) - (f2 / 2.0f)).setDuration(400L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                DiceDialogFragment.animateTextViewVariationTopLeft$lambda$0$0$0();
            }
        }).start();
        textView.animate().scaleX(2.0f).scaleY(2.0f).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showBackAndRerollButtons();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationTopLeft$lambda$0$0$0() {
    }

    static final void animateTextViewVariationTopLeft$lambda$1() {
    }

    private final void animateTextViewVariationTopRight(final TextView newTextView, final ConstraintLayout rootLayout, final float w, final float h) {
        newTextView.animate().x((rootLayout.getWidth() / 2.0f) - (w / 2.0f)).y(0.0f).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                TextView textView = newTextView;
                ConstraintLayout constraintLayout = rootLayout;
                float f = w;
                float f2 = h;
                textView.animate().x(constraintLayout.getWidth() - (f / 2.0f)).y((constraintLayout.getHeight() / 4.0f) - (f2 / 2.0f)).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda35
                    @Override // java.lang.Runnable
                    public final void run() {
                        DiceDialogFragment.animateTextViewVariationTopRight$lambda$0$0(textView, constraintLayout, f, f2, diceDialogFragment);
                    }
                }).start();
            }
        }).start();
        newTextView.animate().rotationBy(-1080.0f).setDuration(1000L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                DiceDialogFragment.animateTextViewVariationTopRight$lambda$1();
            }
        }).setInterpolator(new DecelerateInterpolator()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationTopRight$lambda$0$0(TextView textView, ConstraintLayout constraintLayout, float f, float f2, final DiceDialogFragment diceDialogFragment) {
        textView.animate().x((constraintLayout.getWidth() / 2.0f) - (f / 2.0f)).y((constraintLayout.getHeight() / 2.0f) - (f2 / 2.0f)).setDuration(400L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                DiceDialogFragment.animateTextViewVariationTopRight$lambda$0$0$0();
            }
        }).start();
        textView.animate().scaleX(2.0f).scaleY(2.0f).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showBackAndRerollButtons();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationTopRight$lambda$0$0$0() {
    }

    static final void animateTextViewVariationTopRight$lambda$1() {
    }

    private final void hideBackAndRerollButtons() {
        View view = getView();
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.backButton);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.rerollButton);
            TextView textView = (TextView) view.findViewById(R.id.rerollLabel);
            imageView.setVisibility(4);
            imageView2.setVisibility(4);
            textView.setVisibility(4);
        }
    }

    private final void hideDices() {
        View view = getView();
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.d20Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.d12Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            final ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.d10Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            final ConstraintLayout constraintLayout3 = (ConstraintLayout) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.d8Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            final ConstraintLayout constraintLayout4 = (ConstraintLayout) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.d6Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            final ConstraintLayout constraintLayout5 = (ConstraintLayout) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.d4Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            final ConstraintLayout constraintLayout6 = (ConstraintLayout) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.coinLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            final ConstraintLayout constraintLayout7 = (ConstraintLayout) viewFindViewById7;
            View viewFindViewById8 = view.findViewById(R.id.playerLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            final ConstraintLayout constraintLayout8 = (ConstraintLayout) viewFindViewById8;
            constraintLayout.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    constraintLayout.setVisibility(4);
                }
            }).start();
            constraintLayout2.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    constraintLayout2.setVisibility(4);
                }
            }).start();
            constraintLayout3.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda24
                @Override // java.lang.Runnable
                public final void run() {
                    constraintLayout3.setVisibility(4);
                }
            }).start();
            constraintLayout4.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda25
                @Override // java.lang.Runnable
                public final void run() {
                    constraintLayout4.setVisibility(4);
                }
            }).start();
            constraintLayout5.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    constraintLayout5.setVisibility(4);
                }
            }).start();
            constraintLayout6.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    constraintLayout6.setVisibility(4);
                }
            }).start();
            constraintLayout7.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    constraintLayout7.setVisibility(4);
                }
            }).start();
            constraintLayout8.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda29
                @Override // java.lang.Runnable
                public final void run() {
                    constraintLayout8.setVisibility(4);
                }
            }).start();
        }
    }

    static final Unit onViewCreated$lambda$0(DiceDialogFragment diceDialogFragment) {
        diceDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$1(DiceDialogFragment diceDialogFragment, View view) {
        TextView textView = diceDialogFragment.currentDice;
        if (textView != null) {
            View viewFindViewById = view.findViewById(R.id.rootLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ((ConstraintLayout) viewFindViewById).removeView(textView);
        }
        diceDialogFragment.currentDice = null;
        diceDialogFragment.showDices();
        diceDialogFragment.hideBackAndRerollButtons();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$10(DiceDialogFragment diceDialogFragment) {
        int iRandom = RangesKt.random(new IntRange(1, 4), Random.INSTANCE);
        diceDialogFragment.currentdNumber = 4;
        diceDialogFragment.startd4Animation(iRandom);
        diceDialogFragment.hideDices();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$2(DiceDialogFragment diceDialogFragment, View view) {
        TextView textView = diceDialogFragment.currentDice;
        if (textView != null) {
            View viewFindViewById = view.findViewById(R.id.rootLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ((ConstraintLayout) viewFindViewById).removeView(textView);
        }
        diceDialogFragment.currentDice = null;
        int i = diceDialogFragment.currentdNumber;
        if (i == 2) {
            diceDialogFragment.startCoinAnimation(RangesKt.random(new IntRange(1, 2), Random.INSTANCE));
        } else if (i == 4) {
            diceDialogFragment.startd4Animation(RangesKt.random(new IntRange(1, 4), Random.INSTANCE));
        } else if (i == 6) {
            diceDialogFragment.startd6Animation(RangesKt.random(new IntRange(1, 6), Random.INSTANCE));
        } else if (i == 8) {
            diceDialogFragment.startd8Animation(RangesKt.random(new IntRange(1, 8), Random.INSTANCE));
        } else if (i == 10) {
            diceDialogFragment.startd10Animation(RangesKt.random(new IntRange(1, 10), Random.INSTANCE));
        } else if (i == 12) {
            diceDialogFragment.startd12Animation(RangesKt.random(new IntRange(1, 12), Random.INSTANCE));
        } else if (i == 20) {
            diceDialogFragment.startd20Animation(RangesKt.random(new IntRange(1, 20), Random.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$3(DiceDialogFragment diceDialogFragment) {
        int iRandom = RangesKt.random(new IntRange(1, 2), Random.INSTANCE);
        diceDialogFragment.currentdNumber = 2;
        diceDialogFragment.startCoinAnimation(iRandom);
        diceDialogFragment.hideDices();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$4(DiceDialogFragment diceDialogFragment) {
        Function0<Unit> function0 = diceDialogFragment.onTossListener;
        if (function0 != null) {
            function0.invoke();
        }
        diceDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$5(DiceDialogFragment diceDialogFragment) {
        int iRandom = RangesKt.random(new IntRange(1, 20), Random.INSTANCE);
        diceDialogFragment.currentdNumber = 20;
        diceDialogFragment.startd20Animation(iRandom);
        diceDialogFragment.hideDices();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$6(DiceDialogFragment diceDialogFragment) {
        int iRandom = RangesKt.random(new IntRange(1, 12), Random.INSTANCE);
        diceDialogFragment.currentdNumber = 12;
        diceDialogFragment.startd12Animation(iRandom);
        diceDialogFragment.hideDices();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$7(DiceDialogFragment diceDialogFragment) {
        int iRandom = RangesKt.random(new IntRange(1, 10), Random.INSTANCE);
        diceDialogFragment.currentdNumber = 10;
        diceDialogFragment.startd10Animation(iRandom);
        diceDialogFragment.hideDices();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$8(DiceDialogFragment diceDialogFragment) {
        int iRandom = RangesKt.random(new IntRange(1, 8), Random.INSTANCE);
        diceDialogFragment.currentdNumber = 8;
        diceDialogFragment.startd8Animation(iRandom);
        diceDialogFragment.hideDices();
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$9(DiceDialogFragment diceDialogFragment) {
        int iRandom = RangesKt.random(new IntRange(1, 6), Random.INSTANCE);
        diceDialogFragment.currentdNumber = 6;
        diceDialogFragment.startd6Animation(iRandom);
        diceDialogFragment.hideDices();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBackAndRerollButtons() {
        View view = getView();
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.backButton);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.rerollButton);
            TextView textView = (TextView) view.findViewById(R.id.rerollLabel);
            imageView.setVisibility(0);
            imageView.setAlpha(0.5f);
            imageView2.setVisibility(0);
            textView.setVisibility(0);
        }
    }

    private final void showDices() {
        View view = getView();
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.coinWin);
            TextView textView2 = (TextView) view.findViewById(R.id.coinLose);
            textView.setVisibility(4);
            textView2.setVisibility(4);
            View viewFindViewById = view.findViewById(R.id.d20Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.d12Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.d10Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            ConstraintLayout constraintLayout3 = (ConstraintLayout) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.d8Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            ConstraintLayout constraintLayout4 = (ConstraintLayout) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.d6Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            ConstraintLayout constraintLayout5 = (ConstraintLayout) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.d4Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            ConstraintLayout constraintLayout6 = (ConstraintLayout) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.coinLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            ConstraintLayout constraintLayout7 = (ConstraintLayout) viewFindViewById7;
            View viewFindViewById8 = view.findViewById(R.id.playerLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            ConstraintLayout constraintLayout8 = (ConstraintLayout) viewFindViewById8;
            constraintLayout.setVisibility(0);
            constraintLayout.setAlpha(0.0f);
            constraintLayout.animate().alpha(1.0f).setDuration(200L).start();
            constraintLayout2.setVisibility(0);
            constraintLayout2.setAlpha(0.0f);
            constraintLayout2.animate().alpha(1.0f).setDuration(200L).start();
            constraintLayout3.setVisibility(0);
            constraintLayout3.setAlpha(0.0f);
            constraintLayout3.animate().alpha(1.0f).setDuration(200L).start();
            constraintLayout4.setVisibility(0);
            constraintLayout4.setAlpha(0.0f);
            constraintLayout4.animate().alpha(1.0f).setDuration(200L).start();
            constraintLayout5.setVisibility(0);
            constraintLayout5.setAlpha(0.0f);
            constraintLayout5.animate().alpha(1.0f).setDuration(200L).start();
            constraintLayout6.setVisibility(0);
            constraintLayout6.setAlpha(0.0f);
            constraintLayout6.animate().alpha(1.0f).setDuration(200L).start();
            constraintLayout7.setVisibility(0);
            constraintLayout7.setAlpha(0.0f);
            constraintLayout7.animate().alpha(1.0f).setDuration(200L).start();
            constraintLayout8.setVisibility(0);
            constraintLayout8.setAlpha(0.0f);
            constraintLayout8.animate().alpha(1.0f).setDuration(200L).start();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v9, types: [T, android.widget.TextView] */
    private final void startCoinAnimation(int random) {
        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.FlipCoin.getValue(), 0, null, random == 1 ? 1 : 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        View view = getView();
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.coinWin);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ?? r2 = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.coinLose);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ?? r1 = (TextView) viewFindViewById2;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = r2;
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = r1;
            if (random == 1) {
                objectRef.element = r2;
                objectRef2.element = r1;
            } else {
                objectRef.element = r1;
                objectRef2.element = r2;
            }
            ((TextView) objectRef.element).setVisibility(0);
            ((TextView) objectRef2.element).setVisibility(4);
            ((TextView) objectRef.element).setScaleX(1.0f);
            ((TextView) objectRef.element).setScaleY(1.0f);
            ((TextView) objectRef2.element).setScaleX(1.0f);
            ((TextView) objectRef2.element).setScaleX(1.0f);
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(objectRef.element, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 0.5f, 1.5f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 0.5f, 1.5f));
            objectAnimatorOfPropertyValuesHolder.setDuration(600L);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
            Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder, "apply(...)");
            ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(objectRef2.element, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 0.5f, 1.5f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 0.5f, 1.5f));
            objectAnimatorOfPropertyValuesHolder2.setDuration(600L);
            objectAnimatorOfPropertyValuesHolder2.setInterpolator(new DecelerateInterpolator());
            Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder2, "apply(...)");
            ObjectAnimator objectAnimatorOfPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(objectRef.element, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.5f, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.5f, 1.0f));
            objectAnimatorOfPropertyValuesHolder3.setDuration(400L);
            objectAnimatorOfPropertyValuesHolder3.setInterpolator(new AccelerateInterpolator());
            Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder3, "apply(...)");
            ObjectAnimator objectAnimatorOfPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(objectRef2.element, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.5f, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.5f, 1.0f));
            objectAnimatorOfPropertyValuesHolder4.setDuration(400L);
            objectAnimatorOfPropertyValuesHolder4.setInterpolator(new AccelerateInterpolator());
            Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder4, "apply(...)");
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(objectRef.element, "rotationX", -180.0f, 360.0f);
            objectAnimatorOfFloat.setDuration(600L);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda15
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DiceDialogFragment.startCoinAnimation$lambda$1$4$0(objectRef, valueAnimator);
                }
            });
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(objectRef2.element, "rotationX", 0.0f, 540.0f);
            objectAnimatorOfFloat2.setDuration(600L);
            objectAnimatorOfFloat2.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda16
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DiceDialogFragment.startCoinAnimation$lambda$1$5$0(objectRef2, valueAnimator);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2, objectAnimatorOfFloat, objectAnimatorOfFloat2);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(objectAnimatorOfPropertyValuesHolder3, objectAnimatorOfPropertyValuesHolder4);
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playSequentially(animatorSet, animatorSet2);
            animatorSet3.addListener(new Animator.AnimatorListener() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$startCoinAnimation$lambda$1$8$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.this$0.showBackAndRerollButtons();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            animatorSet3.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void startCoinAnimation$lambda$1$4$0(Ref.ObjectRef objectRef, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        if ((fFloatValue < -90.0f || fFloatValue >= 180.0f) && fFloatValue < 270.0f) {
            if (((TextView) objectRef.element).getVisibility() == 0) {
                ((TextView) objectRef.element).setVisibility(4);
            }
        } else if (((TextView) objectRef.element).getVisibility() == 4) {
            ((TextView) objectRef.element).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void startCoinAnimation$lambda$1$5$0(Ref.ObjectRef objectRef, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        if ((fFloatValue < 90.0f || fFloatValue >= 270.0f) && fFloatValue < 450.0f) {
            if (((TextView) objectRef.element).getVisibility() == 4) {
                ((TextView) objectRef.element).setVisibility(0);
            }
        } else if (((TextView) objectRef.element).getVisibility() == 0) {
            ((TextView) objectRef.element).setVisibility(4);
        }
    }

    private final void startd10Animation(int random) {
        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.RollD10.getValue(), 0, null, random, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        View view = getView();
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.rootLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.d10Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById2;
            int width = constraintLayout2.getWidth();
            int height = constraintLayout2.getHeight();
            float x = constraintLayout2.getX();
            float y = constraintLayout2.getY();
            TextView textView = new TextView(getContext());
            textView.setText(textForRandomD10(random));
            textView.setX(x);
            float height2 = constraintLayout.getHeight() - y;
            float f = height;
            textView.setY(height2 - f);
            textView.setWidth(width);
            textView.setHeight(height);
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.winner_yellow));
            textView.setTypeface(getResources().getFont(R.font.dicefont));
            textView.setTextSize(80.0f);
            constraintLayout.addView(textView);
            float f2 = width;
            textView.setPivotX(f2 / 2.1f);
            textView.setPivotY(f / 2.5f);
            int iRandom = RangesKt.random(new IntRange(1, 2), Random.INSTANCE);
            if (iRandom == 1) {
                animateTextViewVariationTopRight(textView, constraintLayout, f2, f);
            } else if (iRandom == 2) {
                animateTextViewVariationBottomRight(textView, constraintLayout, f2, f);
            }
            this.currentDice = textView;
        }
    }

    private final void startd12Animation(int random) {
        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.RollD12.getValue(), 0, null, random, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        View view = getView();
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.rootLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.d12Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById2;
            int width = constraintLayout2.getWidth();
            int height = constraintLayout2.getHeight();
            float x = constraintLayout2.getX();
            float y = constraintLayout2.getY();
            TextView textView = new TextView(getContext());
            textView.setText(textForRandomD12(random));
            textView.setX(x);
            float height2 = constraintLayout.getHeight() - y;
            float f = height;
            textView.setY(height2 - f);
            textView.setWidth(width);
            textView.setHeight(height);
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.winner_yellow));
            textView.setTypeface(getResources().getFont(R.font.dicefont));
            textView.setTextSize(80.0f);
            constraintLayout.addView(textView);
            float f2 = width;
            textView.setPivotX(f2 / 2.1f);
            textView.setPivotY(f / 2.5f);
            int iRandom = RangesKt.random(new IntRange(1, 4), Random.INSTANCE);
            if (iRandom == 1) {
                animateTextViewVariationTopLeft(textView, constraintLayout, f2, f);
            } else if (iRandom == 2) {
                animateTextViewVariationBottomLeft(textView, constraintLayout, f2, f);
            } else if (iRandom == 3) {
                animateTextViewVariationTopRight(textView, constraintLayout, f2, f);
            } else if (iRandom == 4) {
                animateTextViewVariationBottomRight(textView, constraintLayout, f2, f);
            }
            this.currentDice = textView;
        }
    }

    private final void startd20Animation(int random) {
        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.RollD20.getValue(), 0, null, random, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        View view = getView();
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.rootLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.d20Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById2;
            int width = constraintLayout2.getWidth();
            int height = constraintLayout2.getHeight();
            float x = constraintLayout2.getX();
            float y = constraintLayout2.getY();
            TextView textView = new TextView(getContext());
            textView.setText(textForRandomD20(random));
            textView.setX(x);
            float height2 = constraintLayout.getHeight() - y;
            float f = height;
            textView.setY(height2 - f);
            textView.setWidth(width);
            textView.setHeight(height);
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.winner_yellow));
            textView.setTypeface(getResources().getFont(R.font.dicefont));
            textView.setTextSize(80.0f);
            constraintLayout.addView(textView);
            float f2 = width;
            textView.setPivotX(f2 / 2.1f);
            textView.setPivotY(f / 2.5f);
            int iRandom = RangesKt.random(new IntRange(1, 2), Random.INSTANCE);
            if (iRandom == 1) {
                animateTextViewVariationTopLeft(textView, constraintLayout, f2, f);
            } else if (iRandom == 2) {
                animateTextViewVariationBottomLeft(textView, constraintLayout, f2, f);
            }
            this.currentDice = textView;
        }
    }

    private final void startd4Animation(int random) {
        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.RollD4.getValue(), 0, null, random, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        View view = getView();
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.rootLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.d4Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById2;
            int width = constraintLayout2.getWidth();
            int height = constraintLayout2.getHeight();
            float x = constraintLayout2.getX();
            float y = constraintLayout2.getY();
            TextView textView = new TextView(getContext());
            textView.setText(textForRandomD4(random));
            textView.setX(x);
            float height2 = constraintLayout.getHeight() - y;
            float f = height;
            textView.setY(height2 - f);
            textView.setWidth(width);
            textView.setHeight(height);
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.winner_yellow));
            textView.setTypeface(getResources().getFont(R.font.dicefont));
            textView.setTextSize(80.0f);
            constraintLayout.addView(textView);
            float f2 = width;
            textView.setPivotX(f2 / 2.1f);
            textView.setPivotY(f / 2.5f);
            int iRandom = RangesKt.random(new IntRange(1, 2), Random.INSTANCE);
            if (iRandom == 1) {
                animateTextViewVariationTopRight(textView, constraintLayout, f2, f);
            } else if (iRandom == 2) {
                animateTextViewVariationBottomRight(textView, constraintLayout, f2, f);
            }
            this.currentDice = textView;
        }
    }

    private final void startd6Animation(int random) {
        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.RollD6.getValue(), 0, null, random, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        View view = getView();
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.rootLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.d6Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById2;
            int width = constraintLayout2.getWidth();
            int height = constraintLayout2.getHeight();
            float x = constraintLayout2.getX();
            float y = constraintLayout2.getY();
            TextView textView = new TextView(getContext());
            textView.setText(textForRandomD6(random));
            textView.setX(x);
            float height2 = constraintLayout.getHeight() - y;
            float f = height;
            textView.setY(height2 - f);
            textView.setWidth(width);
            textView.setHeight(height);
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.winner_yellow));
            textView.setTypeface(getResources().getFont(R.font.dicefont));
            textView.setTextSize(80.0f);
            constraintLayout.addView(textView);
            float f2 = width;
            textView.setPivotX(f2 / 2.1f);
            textView.setPivotY(f / 2.5f);
            int iRandom = RangesKt.random(new IntRange(1, 4), Random.INSTANCE);
            if (iRandom == 1) {
                animateTextViewVariationTopLeft(textView, constraintLayout, f2, f);
            } else if (iRandom == 2) {
                animateTextViewVariationBottomLeft(textView, constraintLayout, f2, f);
            } else if (iRandom == 3) {
                animateTextViewVariationTopRight(textView, constraintLayout, f2, f);
            } else if (iRandom == 4) {
                animateTextViewVariationBottomRight(textView, constraintLayout, f2, f);
            }
            this.currentDice = textView;
        }
    }

    private final void startd8Animation(int random) {
        getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.RollD8.getValue(), 0, null, random, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
        Context context = getContext();
        if (context != null) {
            new PreferencesManager(context).saveCurrentGame(getSharedViewModel().getGameState());
        }
        View view = getView();
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.rootLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.d8Layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById2;
            int width = constraintLayout2.getWidth();
            int height = constraintLayout2.getHeight();
            float x = constraintLayout2.getX();
            float y = constraintLayout2.getY();
            TextView textView = new TextView(getContext());
            textView.setText(textForRandomD8(random));
            textView.setX(x);
            float height2 = constraintLayout.getHeight() - y;
            float f = height;
            textView.setY(height2 - f);
            textView.setWidth(width);
            textView.setHeight(height);
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.winner_yellow));
            textView.setTypeface(getResources().getFont(R.font.dicefont));
            textView.setTextSize(80.0f);
            constraintLayout.addView(textView);
            float f2 = width;
            textView.setPivotX(f2 / 2.1f);
            textView.setPivotY(f / 2.5f);
            int iRandom = RangesKt.random(new IntRange(1, 2), Random.INSTANCE);
            if (iRandom == 1) {
                animateTextViewVariationTopLeft(textView, constraintLayout, f2, f);
            } else if (iRandom == 2) {
                animateTextViewVariationBottomLeft(textView, constraintLayout, f2, f);
            }
            this.currentDice = textView;
        }
    }

    private final String textForRandomD10(int random) {
        switch (random) {
            case 1:
                return "\uf101";
            case 2:
                return "\uf103";
            case 3:
                return "\uf104";
            case 4:
                return "\uf105";
            case 5:
                return "\uf106";
            case 6:
                return "\uf107";
            case 7:
                return "\uf108";
            case 8:
                return "\uf109";
            case 9:
                return "\uf10a";
            case 10:
                return "\uf102";
            default:
                return "Error";
        }
    }

    private final String textForRandomD12(int random) {
        switch (random) {
            case 1:
                return "\uf10b";
            case 2:
                return "\uf10f";
            case 3:
                return "\uf110";
            case 4:
                return "\uf111";
            case 5:
                return "\uf112";
            case 6:
                return "\uf113";
            case 7:
                return "\uf114";
            case 8:
                return "\uf115";
            case 9:
                return "\uf116";
            case 10:
                return "\uf10c";
            case 11:
                return "\uf10d";
            case 12:
                return "\uf10e";
            default:
                return "Error";
        }
    }

    private final String textForRandomD20(int random) {
        switch (random) {
            case 1:
                return "\uf119";
            case 2:
                return "\uf124";
            case 3:
                return "\uf126";
            case 4:
                return "\uf127";
            case 5:
                return "\uf128";
            case 6:
                return "\uf129";
            case 7:
                return "\uf12a";
            case 8:
                return "\uf12b";
            case 9:
                return "\uf12c";
            case 10:
                return "\uf11a";
            case 11:
                return "\uf11b";
            case 12:
                return "\uf11c";
            case 13:
                return "\uf11d";
            case 14:
                return "\uf11e";
            case 15:
                return "\uf11f";
            case 16:
                return "\uf120";
            case 17:
                return "\uf121";
            case 18:
                return "\uf122";
            case 19:
                return "\uf123";
            case 20:
                return "\uf125";
            default:
                return "Error";
        }
    }

    private final String textForRandomD4(int random) {
        return random != 1 ? random != 2 ? random != 3 ? random != 4 ? "Error" : "\uf130" : "\uf12f" : "\uf12e" : "\uf12d";
    }

    private final String textForRandomD6(int random) {
        switch (random) {
            case 1:
                return "\uf131";
            case 2:
                return "\uf132";
            case 3:
                return "\uf133";
            case 4:
                return "\uf134";
            case 5:
                return "\uf135";
            case 6:
                return "\uf136";
            default:
                return "Error";
        }
    }

    private final String textForRandomD8(int random) {
        switch (random) {
            case 1:
                return "\uf137";
            case 2:
                return "\uf138";
            case 3:
                return "\uf139";
            case 4:
                return "\uf13a";
            case 5:
                return "\uf13b";
            case 6:
                return "\uf13c";
            case 7:
                return "\uf13d";
            case 8:
                return "\uf13e";
            default:
                return "Error";
        }
    }

    public final SharedViewModel getSharedViewModel() {
        return (SharedViewModel) this.sharedViewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return inflater.inflate(R.layout.dialog_dice_selection, container, false);
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
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.closeButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ImageView) viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiceDialogFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        View viewFindViewById2 = view.findViewById(R.id.backButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithBounce((ImageView) viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiceDialogFragment.onViewCreated$lambda$1(this.f$0, view);
            }
        });
        View viewFindViewById3 = view.findViewById(R.id.rerollButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithBounce((ImageView) viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiceDialogFragment.onViewCreated$lambda$2(this.f$0, view);
            }
        });
        View viewFindViewById4 = view.findViewById(R.id.coinLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById4, new Function0() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiceDialogFragment.onViewCreated$lambda$3(this.f$0);
            }
        });
        View viewFindViewById5 = view.findViewById(R.id.playerLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById5, new Function0() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiceDialogFragment.onViewCreated$lambda$4(this.f$0);
            }
        });
        View viewFindViewById6 = view.findViewById(R.id.d20Layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        View viewFindViewById7 = view.findViewById(R.id.d12Layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        View viewFindViewById8 = view.findViewById(R.id.d10Layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        View viewFindViewById9 = view.findViewById(R.id.d8Layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        View viewFindViewById10 = view.findViewById(R.id.d6Layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        View viewFindViewById11 = view.findViewById(R.id.d4Layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById6, new Function0() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiceDialogFragment.onViewCreated$lambda$5(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById7, new Function0() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiceDialogFragment.onViewCreated$lambda$6(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById8, new Function0() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiceDialogFragment.onViewCreated$lambda$7(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById9, new Function0() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiceDialogFragment.onViewCreated$lambda$8(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById10, new Function0() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiceDialogFragment.onViewCreated$lambda$9(this.f$0);
            }
        });
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById11, new Function0() { // from class: com.studiolaganne.lengendarylens.DiceDialogFragment$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiceDialogFragment.onViewCreated$lambda$10(this.f$0);
            }
        });
    }
}
