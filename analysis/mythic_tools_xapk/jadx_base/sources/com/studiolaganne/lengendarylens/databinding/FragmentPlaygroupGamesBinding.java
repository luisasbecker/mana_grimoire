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
public final class FragmentPlaygroupGamesBinding implements ViewBinding {
    public final RecyclerView gamesRecyclerView;
    public final LottieAnimationView loadingAnimationView;
    public final LottieAnimationView loadingAnimationViewRecyclerView;
    public final ConstraintLayout newGameButtonLayout;
    public final TextView newGameButtonText;
    public final TextView noGamesText;
    public final ConstraintLayout overlay;
    private final ConstraintLayout rootView;

    private FragmentPlaygroupGamesBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.gamesRecyclerView = recyclerView;
        this.loadingAnimationView = lottieAnimationView;
        this.loadingAnimationViewRecyclerView = lottieAnimationView2;
        this.newGameButtonLayout = constraintLayout2;
        this.newGameButtonText = textView;
        this.noGamesText = textView2;
        this.overlay = constraintLayout3;
    }

    public static FragmentPlaygroupGamesBinding bind(View view) {
        int i = R.id.gamesRecyclerView;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.loadingAnimationView;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView != null) {
                i = R.id.loadingAnimationViewRecyclerView;
                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                if (lottieAnimationView2 != null) {
                    i = R.id.newGameButtonLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.newGameButtonText;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.noGamesText;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.overlay;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout2 != null) {
                                    return new FragmentPlaygroupGamesBinding((ConstraintLayout) view, recyclerView, lottieAnimationView, lottieAnimationView2, constraintLayout, textView, textView2, constraintLayout2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentPlaygroupGamesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentPlaygroupGamesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_playgroup_games, viewGroup, false);
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
