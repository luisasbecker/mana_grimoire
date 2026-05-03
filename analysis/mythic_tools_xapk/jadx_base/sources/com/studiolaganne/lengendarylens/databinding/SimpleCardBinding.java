package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SimpleCardBinding implements ViewBinding {
    public final LoadingImageView cardImage;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private SimpleCardBinding(ConstraintLayout constraintLayout, LoadingImageView loadingImageView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.cardImage = loadingImageView;
        this.rootLayout = constraintLayout2;
    }

    public static SimpleCardBinding bind(View view) {
        int i = R.id.cardImage;
        LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
        if (loadingImageView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        return new SimpleCardBinding(constraintLayout, loadingImageView, constraintLayout);
    }

    public static SimpleCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SimpleCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.simple_card, viewGroup, false);
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
