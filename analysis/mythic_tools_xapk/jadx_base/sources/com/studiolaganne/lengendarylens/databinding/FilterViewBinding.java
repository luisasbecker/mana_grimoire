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
public final class FilterViewBinding implements ViewBinding {
    public final ImageView closeImage;
    public final ImageView excludeImageView;
    public final TextView keywordTextView;
    public final TextView operatorTextView;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView valueTextView;

    private FilterViewBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, TextView textView3) {
        this.rootView = constraintLayout;
        this.closeImage = imageView;
        this.excludeImageView = imageView2;
        this.keywordTextView = textView;
        this.operatorTextView = textView2;
        this.rootLayout = constraintLayout2;
        this.valueTextView = textView3;
    }

    public static FilterViewBinding bind(View view) {
        int i = R.id.closeImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.excludeImageView;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.keywordTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.operatorTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.valueTextView;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new FilterViewBinding(constraintLayout, imageView, imageView2, textView, textView2, constraintLayout, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FilterViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FilterViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.filter_view, viewGroup, false);
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
