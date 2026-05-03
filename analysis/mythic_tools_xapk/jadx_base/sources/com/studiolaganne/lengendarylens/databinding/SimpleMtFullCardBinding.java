package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SimpleMtFullCardBinding implements ViewBinding {
    public final LoadingImageView cardImage;
    public final View cornerView;
    public final TextView qtyTextView;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private SimpleMtFullCardBinding(ConstraintLayout constraintLayout, LoadingImageView loadingImageView, View view, TextView textView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.cardImage = loadingImageView;
        this.cornerView = view;
        this.qtyTextView = textView;
        this.rootLayout = constraintLayout2;
    }

    public static SimpleMtFullCardBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.cardImage;
        LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
        if (loadingImageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.cornerView))) != null) {
            i = R.id.qtyTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new SimpleMtFullCardBinding(constraintLayout, loadingImageView, viewFindChildViewById, textView, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static SimpleMtFullCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SimpleMtFullCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.simple_mt_full_card, viewGroup, false);
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
