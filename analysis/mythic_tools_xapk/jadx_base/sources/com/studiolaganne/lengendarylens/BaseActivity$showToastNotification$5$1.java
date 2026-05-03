package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/studiolaganne/lengendarylens/BaseActivity$showToastNotification$5$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BaseActivity$showToastNotification$5$1 extends AnimatorListenerAdapter {
    final /* synthetic */ View $it;
    final /* synthetic */ BaseActivity this$0;

    BaseActivity$showToastNotification$5$1(BaseActivity baseActivity, View view) {
        this.this$0 = baseActivity;
        this.$it = view;
    }

    static final void onAnimationEnd$lambda$0(final BaseActivity baseActivity, View view) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorTranslationY;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator duration;
        View view2 = baseActivity.toastLayout;
        if (view2 == null || (viewPropertyAnimatorAnimate = view2.animate()) == null || (viewPropertyAnimatorTranslationY = viewPropertyAnimatorAnimate.translationY(-view.getHeight())) == null || (interpolator = viewPropertyAnimatorTranslationY.setInterpolator(new AccelerateInterpolator())) == null || (duration = interpolator.setDuration(300L)) == null) {
            return;
        }
        duration.setListener(new AnimatorListenerAdapter() { // from class: com.studiolaganne.lengendarylens.BaseActivity$showToastNotification$5$1$onAnimationEnd$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                View view3 = baseActivity.toastLayout;
                if (view3 != null) {
                    view3.setVisibility(8);
                }
            }
        });
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        View view = this.this$0.toastLayout;
        if (view != null) {
            final BaseActivity baseActivity = this.this$0;
            final View view2 = this.$it;
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.BaseActivity$showToastNotification$5$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BaseActivity$showToastNotification$5$1.onAnimationEnd$lambda$0(baseActivity, view2);
                }
            }, 3500L);
        }
    }
}
