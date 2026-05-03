package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.studiolaganne.lengendarylens.LoadingImageViewPlaymat;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SquareBkgCardItemBinding implements ViewBinding {
    public final LoadingImageViewPlaymat cardImageView;
    public final TextView cardNameTextView;
    public final MaterialCardView cardView;
    public final ImageView moreButton;
    public final ConstraintLayout rootLayout;
    private final MaterialCardView rootView;

    private SquareBkgCardItemBinding(MaterialCardView materialCardView, LoadingImageViewPlaymat loadingImageViewPlaymat, TextView textView, MaterialCardView materialCardView2, ImageView imageView, ConstraintLayout constraintLayout) {
        this.rootView = materialCardView;
        this.cardImageView = loadingImageViewPlaymat;
        this.cardNameTextView = textView;
        this.cardView = materialCardView2;
        this.moreButton = imageView;
        this.rootLayout = constraintLayout;
    }

    public static SquareBkgCardItemBinding bind(View view) {
        int i = R.id.card_image_view;
        LoadingImageViewPlaymat loadingImageViewPlaymat = (LoadingImageViewPlaymat) ViewBindings.findChildViewById(view, i);
        if (loadingImageViewPlaymat != null) {
            i = R.id.card_name_text_view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                MaterialCardView materialCardView = (MaterialCardView) view;
                i = R.id.more_button;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.root_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        return new SquareBkgCardItemBinding(materialCardView, loadingImageViewPlaymat, textView, materialCardView, imageView, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static SquareBkgCardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SquareBkgCardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.square_bkg_card_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }
}
