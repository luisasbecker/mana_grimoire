package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LoadingImageViewDeckBinding implements ViewBinding {
    public final LottieAnimationView animationView;
    public final ImageView imageView;
    public final CardView root;
    private final CardView rootView;

    private LoadingImageViewDeckBinding(CardView cardView, LottieAnimationView lottieAnimationView, ImageView imageView, CardView cardView2) {
        this.rootView = cardView;
        this.animationView = lottieAnimationView;
        this.imageView = imageView;
        this.root = cardView2;
    }

    public static LoadingImageViewDeckBinding bind(View view) {
        int i = R.id.animationView;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
        if (lottieAnimationView != null) {
            i = R.id.imageView;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                CardView cardView = (CardView) view;
                return new LoadingImageViewDeckBinding(cardView, lottieAnimationView, imageView, cardView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LoadingImageViewDeckBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LoadingImageViewDeckBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.loading_image_view_deck, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }
}
