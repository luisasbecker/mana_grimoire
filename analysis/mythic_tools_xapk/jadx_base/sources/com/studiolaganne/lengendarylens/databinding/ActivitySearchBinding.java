package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivitySearchBinding implements ViewBinding {
    public final ImageView backImageView;
    public final TextView backLabel;
    public final FragmentContainerView fragmentContainer;
    private final ConstraintLayout rootView;

    private ActivitySearchBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, FragmentContainerView fragmentContainerView) {
        this.rootView = constraintLayout;
        this.backImageView = imageView;
        this.backLabel = textView;
        this.fragmentContainer = fragmentContainerView;
    }

    public static ActivitySearchBinding bind(View view) {
        int i = R.id.back_image_view;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.back_label;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.fragment_container;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                if (fragmentContainerView != null) {
                    return new ActivitySearchBinding((ConstraintLayout) view, imageView, textView, fragmentContainerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivitySearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_search, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
