package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class RandomCardBinding implements ViewBinding {
    public final View emptyView;
    public final TextView randomCardText;
    public final ImageView randomIcon;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private RandomCardBinding(ConstraintLayout constraintLayout, View view, TextView textView, ImageView imageView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.emptyView = view;
        this.randomCardText = textView;
        this.randomIcon = imageView;
        this.rootLayout = constraintLayout2;
    }

    public static RandomCardBinding bind(View view) {
        int i = R.id.emptyView;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById != null) {
            i = R.id.randomCardText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.randomIcon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new RandomCardBinding(constraintLayout, viewFindChildViewById, textView, imageView, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static RandomCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RandomCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.random_card, viewGroup, false);
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
