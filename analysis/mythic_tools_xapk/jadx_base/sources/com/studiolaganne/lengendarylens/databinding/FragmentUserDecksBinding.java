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
public final class FragmentUserDecksBinding implements ViewBinding {
    public final RecyclerView decksRecyclerView;
    public final LottieAnimationView loadingAnimationViewRecyclerView;
    public final TextView noDecksText;
    private final LinearLayout rootView;
    public final View separator1;

    private FragmentUserDecksBinding(LinearLayout linearLayout, RecyclerView recyclerView, LottieAnimationView lottieAnimationView, TextView textView, View view) {
        this.rootView = linearLayout;
        this.decksRecyclerView = recyclerView;
        this.loadingAnimationViewRecyclerView = lottieAnimationView;
        this.noDecksText = textView;
        this.separator1 = view;
    }

    public static FragmentUserDecksBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.decksRecyclerView;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.loadingAnimationViewRecyclerView;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView != null) {
                i = R.id.noDecksText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator1))) != null) {
                    return new FragmentUserDecksBinding((LinearLayout) view, recyclerView, lottieAnimationView, textView, viewFindChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentUserDecksBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUserDecksBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user_decks, viewGroup, false);
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
