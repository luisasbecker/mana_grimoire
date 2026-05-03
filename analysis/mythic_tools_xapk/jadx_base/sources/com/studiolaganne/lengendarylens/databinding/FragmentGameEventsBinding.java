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
public final class FragmentGameEventsBinding implements ViewBinding {
    public final RecyclerView gameEventsRecyclerView;
    public final LottieAnimationView loadingAnimationViewRecyclerView;
    private final LinearLayout rootView;

    private FragmentGameEventsBinding(LinearLayout linearLayout, RecyclerView recyclerView, LottieAnimationView lottieAnimationView) {
        this.rootView = linearLayout;
        this.gameEventsRecyclerView = recyclerView;
        this.loadingAnimationViewRecyclerView = lottieAnimationView;
    }

    public static FragmentGameEventsBinding bind(View view) {
        int i = R.id.gameEventsRecyclerView;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.loadingAnimationViewRecyclerView;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView != null) {
                return new FragmentGameEventsBinding((LinearLayout) view, recyclerView, lottieAnimationView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentGameEventsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGameEventsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_game_events, viewGroup, false);
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
