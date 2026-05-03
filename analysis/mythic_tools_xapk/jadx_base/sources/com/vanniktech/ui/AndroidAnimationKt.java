package com.vanniktech.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidAnimation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006\u001a&\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006\u001a#\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0012\u001a\u00020\u0001*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u001a\u001a\u00020\u0001*\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u001a!\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010 \u001a\u001e\u0010!\u001a\u00020\u0001*\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a.\u0010!\u001a\u00020\u0001*\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u000e\b\u0004\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\"\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, d2 = {"animateToVisible", "", "Landroid/view/View;", TypedValues.TransitionType.S_DURATION, "", "onEnd", "Lkotlin/Function0;", "animateToGone", "animateBackgroundColor", "color", "Lcom/vanniktech/ui/Color;", "speed", "animateBackgroundColor-EFWIcRY", "(Landroid/view/View;IJ)V", "animateTextColor", "Landroid/widget/TextView;", "animateTextColor-EFWIcRY", "(Landroid/widget/TextView;IJ)V", "animateTint", "Landroid/widget/ImageView;", TypedValues.TransitionType.S_TO, "mode", "Landroid/graphics/PorterDuff$Mode;", "animateTint-EH71K70", "(Landroid/widget/ImageView;ILandroid/graphics/PorterDuff$Mode;J)V", "DEFAULT_ANIMATION_DURATION", "animateText", "text", "", "flash", "from", "flash-FUHGC9k", "(Landroid/view/View;II)V", "animate", "Landroid/view/ViewGroup;", "body", "onEndListener", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidAnimationKt {
    public static final long DEFAULT_ANIMATION_DURATION = 300;

    public static final void animate(ViewGroup viewGroup, Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        TransitionManager.endTransitions(viewGroup);
        TransitionManager.beginDelayedTransition(viewGroup);
        body.invoke();
    }

    public static final void animate(ViewGroup viewGroup, Function0<Unit> body, final Function0<Unit> onEndListener) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(onEndListener, "onEndListener");
        TransitionManager.endTransitions(viewGroup);
        TransitionManager.beginDelayedTransition(viewGroup, new AutoTransition().addListener(new Transition.TransitionListener() { // from class: com.vanniktech.ui.AndroidAnimationKt.animate.1
            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
                onEndListener.invoke();
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }
        }));
        body.invoke();
    }

    /* JADX INFO: renamed from: animateBackgroundColor-EFWIcRY, reason: not valid java name */
    public static final void m11310animateBackgroundColorEFWIcRY(View animateBackgroundColor, int i, long j) {
        Intrinsics.checkNotNullParameter(animateBackgroundColor, "$this$animateBackgroundColor");
        Color colorBackgroundColor = AndroidGoodiesKt.backgroundColor(animateBackgroundColor);
        if (colorBackgroundColor == null) {
            AndroidColorKt.m11321setBackgroundColorxAbW3D8(animateBackgroundColor, i);
            return;
        }
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(animateBackgroundColor, "backgroundColor", new android.animation.ArgbEvaluator(), Integer.valueOf(colorBackgroundColor.m11388unboximpl()), Integer.valueOf(i));
        objectAnimatorOfObject.setDuration(j);
        objectAnimatorOfObject.start();
    }

    /* JADX INFO: renamed from: animateBackgroundColor-EFWIcRY$default, reason: not valid java name */
    public static /* synthetic */ void m11311animateBackgroundColorEFWIcRY$default(View view, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 300;
        }
        m11310animateBackgroundColorEFWIcRY(view, i, j);
    }

    public static final void animateText(final TextView textView, final String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        animateToGone$default(textView, 0L, new Function0() { // from class: com.vanniktech.ui.AndroidAnimationKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AndroidAnimationKt.animateText$lambda$4(textView, str);
            }
        }, 1, null);
    }

    static final Unit animateText$lambda$4(TextView this_animateText, String str) {
        Intrinsics.checkNotNullParameter(this_animateText, "$this_animateText");
        this_animateText.setText(str);
        animateToVisible$default(this_animateText, 0L, null, 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: animateTextColor-EFWIcRY, reason: not valid java name */
    public static final void m11312animateTextColorEFWIcRY(TextView animateTextColor, int i, long j) {
        Intrinsics.checkNotNullParameter(animateTextColor, "$this$animateTextColor");
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(animateTextColor, "textColor", new android.animation.ArgbEvaluator(), Integer.valueOf(animateTextColor.getCurrentTextColor()), Integer.valueOf(i));
        objectAnimatorOfObject.setDuration(j);
        objectAnimatorOfObject.start();
    }

    /* JADX INFO: renamed from: animateTextColor-EFWIcRY$default, reason: not valid java name */
    public static /* synthetic */ void m11313animateTextColorEFWIcRY$default(TextView textView, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 300;
        }
        m11312animateTextColorEFWIcRY(textView, i, j);
    }

    /* JADX INFO: renamed from: animateTint-EH71K70, reason: not valid java name */
    public static final void m11314animateTintEH71K70(final ImageView animateTint, int i, final PorterDuff.Mode mode, long j) {
        Intrinsics.checkNotNullParameter(animateTint, "$this$animateTint");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Object tag = animateTint.getTag();
        Color color = tag instanceof Color ? (Color) tag : null;
        animateTint.setTag(Color.m11370boximpl(i));
        if (color == null) {
            AndroidColorKt.m11326tintIconEFWIcRY(animateTint, i, mode);
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(color.m11388unboximpl(), i);
        valueAnimatorOfInt.setEvaluator(new android.animation.ArgbEvaluator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.vanniktech.ui.AndroidAnimationKt$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AndroidAnimationKt.animateTint_EH71K70$lambda$3$lambda$2(animateTint, mode, valueAnimator);
            }
        });
        valueAnimatorOfInt.setDuration(j);
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: renamed from: animateTint-EH71K70$default, reason: not valid java name */
    public static /* synthetic */ void m11315animateTintEH71K70$default(ImageView imageView, int i, PorterDuff.Mode mode, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        if ((i2 & 4) != 0) {
            j = 300;
        }
        m11314animateTintEH71K70(imageView, i, mode, j);
    }

    static final void animateTint_EH71K70$lambda$3$lambda$2(ImageView this_animateTint, PorterDuff.Mode mode, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this_animateTint, "$this_animateTint");
        Intrinsics.checkNotNullParameter(mode, "$mode");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this_animateTint.setColorFilter(((Integer) animatedValue).intValue(), mode);
    }

    public static final void animateToGone(final View view, long j, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getVisibility() != 8) {
            view.setAlpha(1.0f);
            view.animate().setDuration(j).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.vanniktech.ui.AndroidAnimationKt.animateToGone.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    view.setVisibility(8);
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                }
            });
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void animateToGone$default(View view, long j, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 300;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        animateToGone(view, j, function0);
    }

    public static final void animateToVisible(final View view, long j, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getVisibility() == 0) {
            return;
        }
        view.setAlpha(0.0f);
        view.animate().setDuration(j).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.vanniktech.ui.AndroidAnimationKt.animateToVisible.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Function0<Unit> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                view.setVisibility(0);
            }
        });
    }

    public static /* synthetic */ void animateToVisible$default(View view, long j, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 300;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        animateToVisible(view, j, function0);
    }

    /* JADX INFO: renamed from: flash-FUHGC9k, reason: not valid java name */
    public static final void m11316flashFUHGC9k(View flash, int i, int i2) {
        Intrinsics.checkNotNullParameter(flash, "$this$flash");
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(flash, "backgroundColor", i, i2);
        objectAnimatorOfInt.setStartDelay(300L);
        objectAnimatorOfInt.setDuration(1000L);
        objectAnimatorOfInt.setEvaluator(new android.animation.ArgbEvaluator());
        objectAnimatorOfInt.setRepeatMode(2);
        objectAnimatorOfInt.setRepeatCount(1);
        objectAnimatorOfInt.start();
    }
}
