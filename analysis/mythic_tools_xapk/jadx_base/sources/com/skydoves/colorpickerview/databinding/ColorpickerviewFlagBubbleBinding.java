package com.skydoves.colorpickerview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.skydoves.colorpickerview.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ColorpickerviewFlagBubbleBinding implements ViewBinding {
    public final AppCompatImageView bubble;
    public final FrameLayout layout;
    private final FrameLayout rootView;

    private ColorpickerviewFlagBubbleBinding(FrameLayout frameLayout, AppCompatImageView appCompatImageView, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.bubble = appCompatImageView;
        this.layout = frameLayout2;
    }

    public static ColorpickerviewFlagBubbleBinding bind(View view) {
        int i = R.id.bubble;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new ColorpickerviewFlagBubbleBinding(frameLayout, appCompatImageView, frameLayout);
    }

    public static ColorpickerviewFlagBubbleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ColorpickerviewFlagBubbleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.colorpickerview_flag_bubble, viewGroup, false);
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
