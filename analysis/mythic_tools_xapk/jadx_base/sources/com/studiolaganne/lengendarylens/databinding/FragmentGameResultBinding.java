package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentGameResultBinding implements ViewBinding {
    public final LottieAnimationView loadingAnimationViewRecyclerView;
    public final RecyclerView recyclerViewGameResult;
    private final LinearLayout rootView;

    private FragmentGameResultBinding(LinearLayout linearLayout, LottieAnimationView lottieAnimationView, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.loadingAnimationViewRecyclerView = lottieAnimationView;
        this.recyclerViewGameResult = recyclerView;
    }

    public static FragmentGameResultBinding bind(View view) {
        int i = R.id.loadingAnimationViewRecyclerView;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
        if (lottieAnimationView != null) {
            i = R.id.recyclerViewGameResult;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                return new FragmentGameResultBinding((LinearLayout) view, lottieAnimationView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentGameResultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGameResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_game_result, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
