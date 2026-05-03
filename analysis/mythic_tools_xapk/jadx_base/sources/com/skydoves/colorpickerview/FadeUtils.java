package com.skydoves.colorpickerview;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* JADX INFO: loaded from: classes6.dex */
public class FadeUtils {
    public static void fadeIn(View view) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.colorpickerview_fade_in);
        animationLoadAnimation.setFillAfter(true);
        view.startAnimation(animationLoadAnimation);
    }

    public static void fadeOut(View view) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.colorpickerview_fade_out);
        animationLoadAnimation.setFillAfter(true);
        view.startAnimation(animationLoadAnimation);
    }
}
