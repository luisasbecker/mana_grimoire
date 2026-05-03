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
public final class ActivityCirclesListBinding implements ViewBinding {
    public final ImageView backArrow;
    public final ConstraintLayout backLayout;
    public final RecyclerView circlesRecyclerView;
    public final TextView connectingTextView;
    public final ConstraintLayout createButtonLayout;
    public final TextView createButtonText;
    public final ConstraintLayout infoLayout;
    public final LinearLayoutCompat linearLayout;
    public final LottieAnimationView loadingAnimationView;
    public final ConstraintLayout overlay;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView title;

    private ActivityCirclesListBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView, ConstraintLayout constraintLayout3, TextView textView2, ConstraintLayout constraintLayout4, LinearLayoutCompat linearLayoutCompat, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, TextView textView3) {
        this.rootView = constraintLayout;
        this.backArrow = imageView;
        this.backLayout = constraintLayout2;
        this.circlesRecyclerView = recyclerView;
        this.connectingTextView = textView;
        this.createButtonLayout = constraintLayout3;
        this.createButtonText = textView2;
        this.infoLayout = constraintLayout4;
        this.linearLayout = linearLayoutCompat;
        this.loadingAnimationView = lottieAnimationView;
        this.overlay = constraintLayout5;
        this.rootLayout = constraintLayout6;
        this.title = textView3;
    }

    public static ActivityCirclesListBinding bind(View view) {
        int i = R.id.backArrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.backLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.circlesRecyclerView;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    i = R.id.connectingTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.createButtonLayout;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.createButtonText;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.infoLayout;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.linearLayout;
                                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                    if (linearLayoutCompat != null) {
                                        i = R.id.loadingAnimationView;
                                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                        if (lottieAnimationView != null) {
                                            i = R.id.overlay;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout4 != null) {
                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) view;
                                                i = R.id.title;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    return new ActivityCirclesListBinding(constraintLayout5, imageView, constraintLayout, recyclerView, textView, constraintLayout2, textView2, constraintLayout3, linearLayoutCompat, lottieAnimationView, constraintLayout4, constraintLayout5, textView3);
                                                }
                                            }
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

    public static ActivityCirclesListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityCirclesListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_circles_list, viewGroup, false);
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
