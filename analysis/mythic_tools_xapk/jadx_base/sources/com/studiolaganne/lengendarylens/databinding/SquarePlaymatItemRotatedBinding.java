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
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SquarePlaymatItemRotatedBinding implements ViewBinding {
    public final MaterialCardView cardView;
    public final ImageView lockImage;
    public final ImageView playmatImageView;
    public final TextView playmatNameTextView;
    public final ConstraintLayout rootLayout;
    private final MaterialCardView rootView;

    private SquarePlaymatItemRotatedBinding(MaterialCardView materialCardView, MaterialCardView materialCardView2, ImageView imageView, ImageView imageView2, TextView textView, ConstraintLayout constraintLayout) {
        this.rootView = materialCardView;
        this.cardView = materialCardView2;
        this.lockImage = imageView;
        this.playmatImageView = imageView2;
        this.playmatNameTextView = textView;
        this.rootLayout = constraintLayout;
    }

    public static SquarePlaymatItemRotatedBinding bind(View view) {
        MaterialCardView materialCardView = (MaterialCardView) view;
        int i = R.id.lock_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.playmat_image_view;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.playmat_name_text_view;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.root_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        return new SquarePlaymatItemRotatedBinding(materialCardView, materialCardView, imageView, imageView2, textView, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static SquarePlaymatItemRotatedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SquarePlaymatItemRotatedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.square_playmat_item_rotated, viewGroup, false);
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
