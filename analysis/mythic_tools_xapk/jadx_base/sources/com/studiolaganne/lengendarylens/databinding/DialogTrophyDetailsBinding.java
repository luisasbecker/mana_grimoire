package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogTrophyDetailsBinding implements ViewBinding {
    public final ImageView backImage;
    public final ImageView closeImage;
    public final ImageView forwardImage;
    public final ConstraintLayout promoQRLayout;
    private final ConstraintLayout rootView;
    public final TextView stepUpDescription;
    public final ProgressBar stepUpProgressBar;
    public final TextView trophyDescription;
    public final ImageView trophyImage;
    public final TextView trophyName;

    private DialogTrophyDetailsBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout2, TextView textView, ProgressBar progressBar, TextView textView2, ImageView imageView4, TextView textView3) {
        this.rootView = constraintLayout;
        this.backImage = imageView;
        this.closeImage = imageView2;
        this.forwardImage = imageView3;
        this.promoQRLayout = constraintLayout2;
        this.stepUpDescription = textView;
        this.stepUpProgressBar = progressBar;
        this.trophyDescription = textView2;
        this.trophyImage = imageView4;
        this.trophyName = textView3;
    }

    public static DialogTrophyDetailsBinding bind(View view) {
        int i = R.id.backImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.closeImage;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.forwardImage;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.stepUpDescription;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.stepUpProgressBar;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            i = R.id.trophyDescription;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.trophyImage;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView4 != null) {
                                    i = R.id.trophyName;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        return new DialogTrophyDetailsBinding(constraintLayout, imageView, imageView2, imageView3, constraintLayout, textView, progressBar, textView2, imageView4, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogTrophyDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogTrophyDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_trophy_details, viewGroup, false);
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
