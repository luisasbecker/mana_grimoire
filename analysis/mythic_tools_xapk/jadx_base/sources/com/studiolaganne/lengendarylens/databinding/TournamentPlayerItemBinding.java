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
public final class TournamentPlayerItemBinding implements ViewBinding {
    public final MaterialCardView cardView;
    public final ImageView closeButton;
    public final TextView playerNameTextView;
    public final TextView playerPositionTextView;
    public final ConstraintLayout rootLayout;
    private final MaterialCardView rootView;

    private TournamentPlayerItemBinding(MaterialCardView materialCardView, MaterialCardView materialCardView2, ImageView imageView, TextView textView, TextView textView2, ConstraintLayout constraintLayout) {
        this.rootView = materialCardView;
        this.cardView = materialCardView2;
        this.closeButton = imageView;
        this.playerNameTextView = textView;
        this.playerPositionTextView = textView2;
        this.rootLayout = constraintLayout;
    }

    public static TournamentPlayerItemBinding bind(View view) {
        MaterialCardView materialCardView = (MaterialCardView) view;
        int i = R.id.close_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.player_name_text_view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.player_position_text_view;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.root_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        return new TournamentPlayerItemBinding(materialCardView, materialCardView, imageView, textView, textView2, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TournamentPlayerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TournamentPlayerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.tournament_player_item, viewGroup, false);
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
