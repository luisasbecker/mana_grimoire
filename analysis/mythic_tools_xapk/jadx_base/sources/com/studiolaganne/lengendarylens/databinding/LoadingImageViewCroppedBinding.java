package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;
import com.studiolaganne.lengendarylens.RightFocusedImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class LoadingImageViewCroppedBinding implements ViewBinding {
    public final LottieAnimationView animationView;
    public final RightFocusedImageView imageView;
    public final FrameLayout root;
    private final FrameLayout rootView;

    private LoadingImageViewCroppedBinding(FrameLayout frameLayout, LottieAnimationView lottieAnimationView, RightFocusedImageView rightFocusedImageView, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.animationView = lottieAnimationView;
        this.imageView = rightFocusedImageView;
        this.root = frameLayout2;
    }

    public static LoadingImageViewCroppedBinding bind(View view) {
        int i = R.id.animationView;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
        if (lottieAnimationView != null) {
            i = R.id.imageView;
            RightFocusedImageView rightFocusedImageView = (RightFocusedImageView) ViewBindings.findChildViewById(view, i);
            if (rightFocusedImageView != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                return new LoadingImageViewCroppedBinding(frameLayout, lottieAnimationView, rightFocusedImageView, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LoadingImageViewCroppedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LoadingImageViewCroppedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.loading_image_view_cropped, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
