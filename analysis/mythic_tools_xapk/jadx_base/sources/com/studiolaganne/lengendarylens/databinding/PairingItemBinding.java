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
public final class PairingItemBinding implements ViewBinding {
    public final TextView player1Name;
    public final TextView player1Score;
    public final TextView player2Name;
    public final TextView player2Score;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView vs;
    public final ImageView warning;

    private PairingItemBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout2, TextView textView5, ImageView imageView) {
        this.rootView = constraintLayout;
        this.player1Name = textView;
        this.player1Score = textView2;
        this.player2Name = textView3;
        this.player2Score = textView4;
        this.rootLayout = constraintLayout2;
        this.vs = textView5;
        this.warning = imageView;
    }

    public static PairingItemBinding bind(View view) {
        int i = R.id.player1_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.player1_score;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.player2_name;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.player2_score;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.vs;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView5 != null) {
                            i = R.id.warning;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                return new PairingItemBinding(constraintLayout, textView, textView2, textView3, textView4, constraintLayout, textView5, imageView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static PairingItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PairingItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.pairing_item, viewGroup, false);
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
