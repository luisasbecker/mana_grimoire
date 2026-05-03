package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentFullscreenImageBinding implements ViewBinding {
    public final ConstraintLayout banner;
    public final ImageView closeButton;
    public final ImageView fullscreenImageView;
    private final FrameLayout rootView;

    private FragmentFullscreenImageBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2) {
        this.rootView = frameLayout;
        this.banner = constraintLayout;
        this.closeButton = imageView;
        this.fullscreenImageView = imageView2;
    }

    public static FragmentFullscreenImageBinding bind(View view) {
        int i = R.id.banner;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.closeButton;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.fullscreenImageView;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    return new FragmentFullscreenImageBinding((FrameLayout) view, constraintLayout, imageView, imageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentFullscreenImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentFullscreenImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_fullscreen_image, viewGroup, false);
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
