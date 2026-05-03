package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CircleView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class InitiativeUserTokenBinding implements ViewBinding {
    public final ConstraintLayout mythicProfileLayout;
    public final CircleView plainCircleView;
    public final TextView playerNameLabel;
    public final ImageView profileImageView;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private InitiativeUserTokenBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, CircleView circleView, TextView textView, ImageView imageView, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.mythicProfileLayout = constraintLayout2;
        this.plainCircleView = circleView;
        this.playerNameLabel = textView;
        this.profileImageView = imageView;
        this.rootLayout = constraintLayout3;
    }

    public static InitiativeUserTokenBinding bind(View view) {
        int i = R.id.mythicProfileLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.plainCircleView;
            CircleView circleView = (CircleView) ViewBindings.findChildViewById(view, i);
            if (circleView != null) {
                i = R.id.playerNameLabel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.profileImageView;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                        return new InitiativeUserTokenBinding(constraintLayout2, constraintLayout, circleView, textView, imageView, constraintLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static InitiativeUserTokenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static InitiativeUserTokenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.initiative_user_token, viewGroup, false);
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
