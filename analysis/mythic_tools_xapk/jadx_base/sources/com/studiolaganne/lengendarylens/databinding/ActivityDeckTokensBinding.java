package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityDeckTokensBinding implements ViewBinding {
    public final ImageView backArrow;
    public final ConstraintLayout backLayout;
    public final TextView connectingTextView;
    public final ConstraintLayout infoLayout;
    public final LinearLayoutCompat linearLayout;
    public final LottieAnimationView loadingAnimationView;
    public final ConstraintLayout overlay;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView titleLabel;
    public final RecyclerView tokensRecyclerView;

    private ActivityDeckTokensBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, LinearLayoutCompat linearLayoutCompat, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView2, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.backArrow = imageView;
        this.backLayout = constraintLayout2;
        this.connectingTextView = textView;
        this.infoLayout = constraintLayout3;
        this.linearLayout = linearLayoutCompat;
        this.loadingAnimationView = lottieAnimationView;
        this.overlay = constraintLayout4;
        this.rootLayout = constraintLayout5;
        this.titleLabel = textView2;
        this.tokensRecyclerView = recyclerView;
    }

    public static ActivityDeckTokensBinding bind(View view) {
        int i = R.id.backArrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.backLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.connectingTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.infoLayout;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.linearLayout;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                        if (linearLayoutCompat != null) {
                            i = R.id.loadingAnimationView;
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                            if (lottieAnimationView != null) {
                                i = R.id.overlay;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view;
                                    i = R.id.titleLabel;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.tokensRecyclerView;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                        if (recyclerView != null) {
                                            return new ActivityDeckTokensBinding(constraintLayout4, imageView, constraintLayout, textView, constraintLayout2, linearLayoutCompat, lottieAnimationView, constraintLayout3, constraintLayout4, textView2, recyclerView);
                                        }
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

    public static ActivityDeckTokensBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDeckTokensBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_deck_tokens, viewGroup, false);
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
