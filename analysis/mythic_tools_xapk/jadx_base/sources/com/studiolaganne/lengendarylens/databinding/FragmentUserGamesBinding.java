package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentUserGamesBinding implements ViewBinding {
    public final RecyclerView gamesRecyclerView;
    public final LottieAnimationView loadingAnimationViewRecyclerView;
    public final TextView noGamesText;
    public final TextView privacyMessageText;
    private final LinearLayout rootView;
    public final View separator1;

    private FragmentUserGamesBinding(LinearLayout linearLayout, RecyclerView recyclerView, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2, View view) {
        this.rootView = linearLayout;
        this.gamesRecyclerView = recyclerView;
        this.loadingAnimationViewRecyclerView = lottieAnimationView;
        this.noGamesText = textView;
        this.privacyMessageText = textView2;
        this.separator1 = view;
    }

    public static FragmentUserGamesBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.gamesRecyclerView;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.loadingAnimationViewRecyclerView;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView != null) {
                i = R.id.noGamesText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.privacyMessageText;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator1))) != null) {
                        return new FragmentUserGamesBinding((LinearLayout) view, recyclerView, lottieAnimationView, textView, textView2, viewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentUserGamesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUserGamesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user_games, viewGroup, false);
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
