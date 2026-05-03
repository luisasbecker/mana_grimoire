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
public final class SquarePlayerItemBinding implements ViewBinding {
    public final MaterialCardView cardView;
    public final TextView icon;
    public final ImageView moreButton;
    public final TextView playerNameTextView;
    public final ConstraintLayout rootLayout;
    private final MaterialCardView rootView;

    private SquarePlayerItemBinding(MaterialCardView materialCardView, MaterialCardView materialCardView2, TextView textView, ImageView imageView, TextView textView2, ConstraintLayout constraintLayout) {
        this.rootView = materialCardView;
        this.cardView = materialCardView2;
        this.icon = textView;
        this.moreButton = imageView;
        this.playerNameTextView = textView2;
        this.rootLayout = constraintLayout;
    }

    public static SquarePlayerItemBinding bind(View view) {
        MaterialCardView materialCardView = (MaterialCardView) view;
        int i = R.id.icon;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.more_button;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.player_name_text_view;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.root_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        return new SquarePlayerItemBinding(materialCardView, materialCardView, textView, imageView, textView2, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static SquarePlayerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SquarePlayerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.square_player_item, viewGroup, false);
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
