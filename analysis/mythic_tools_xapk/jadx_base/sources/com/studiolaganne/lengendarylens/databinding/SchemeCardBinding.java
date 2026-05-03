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
public final class SchemeCardBinding implements ViewBinding {
    public final LoadingImageView cardImage;
    public final ConstraintLayout closeLayout;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView scanListExportTextView;

    private SchemeCardBinding(ConstraintLayout constraintLayout, LoadingImageView loadingImageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView) {
        this.rootView = constraintLayout;
        this.cardImage = loadingImageView;
        this.closeLayout = constraintLayout2;
        this.rootLayout = constraintLayout3;
        this.scanListExportTextView = textView;
    }

    public static SchemeCardBinding bind(View view) {
        int i = R.id.cardImage;
        LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
        if (loadingImageView != null) {
            i = R.id.closeLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                i = R.id.scanListExportTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new SchemeCardBinding(constraintLayout2, loadingImageView, constraintLayout, constraintLayout2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static SchemeCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SchemeCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.scheme_card, viewGroup, false);
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
