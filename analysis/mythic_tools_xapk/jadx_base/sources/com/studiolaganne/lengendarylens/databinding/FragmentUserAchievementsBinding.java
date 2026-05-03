package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentUserAchievementsBinding implements ViewBinding {
    public final LottieAnimationView loadingAnimationView;
    public final LottieAnimationView loadingAnimationViewRecyclerView;
    public final RecyclerView medalsRecyclerView;
    public final TextView noMedalsTextView;
    public final ConstraintLayout overlay;
    private final ConstraintLayout rootView;

    private FragmentUserAchievementsBinding(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, RecyclerView recyclerView, TextView textView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.loadingAnimationView = lottieAnimationView;
        this.loadingAnimationViewRecyclerView = lottieAnimationView2;
        this.medalsRecyclerView = recyclerView;
        this.noMedalsTextView = textView;
        this.overlay = constraintLayout2;
    }

    public static FragmentUserAchievementsBinding bind(View view) {
        int i = R.id.loadingAnimationView;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
        if (lottieAnimationView != null) {
            i = R.id.loadingAnimationViewRecyclerView;
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView2 != null) {
                i = R.id.medalsRecyclerView;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    i = R.id.noMedalsTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.overlay;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            return new FragmentUserAchievementsBinding((ConstraintLayout) view, lottieAnimationView, lottieAnimationView2, recyclerView, textView, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentUserAchievementsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUserAchievementsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user_achievements, viewGroup, false);
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
