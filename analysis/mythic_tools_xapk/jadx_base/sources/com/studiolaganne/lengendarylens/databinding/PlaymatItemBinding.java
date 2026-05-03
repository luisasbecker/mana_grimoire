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
public final class PlaymatItemBinding implements ViewBinding {
    public final MaterialCardView cardView;
    public final ImageView playmatImageView;
    public final TextView playmatNameTextView;
    public final ConstraintLayout rootLayout;
    private final MaterialCardView rootView;

    private PlaymatItemBinding(MaterialCardView materialCardView, MaterialCardView materialCardView2, ImageView imageView, TextView textView, ConstraintLayout constraintLayout) {
        this.rootView = materialCardView;
        this.cardView = materialCardView2;
        this.playmatImageView = imageView;
        this.playmatNameTextView = textView;
        this.rootLayout = constraintLayout;
    }

    public static PlaymatItemBinding bind(View view) {
        MaterialCardView materialCardView = (MaterialCardView) view;
        int i = R.id.playmat_image_view;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.playmat_name_text_view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.root_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    return new PlaymatItemBinding(materialCardView, materialCardView, imageView, textView, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static PlaymatItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PlaymatItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.playmat_item, viewGroup, false);
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
