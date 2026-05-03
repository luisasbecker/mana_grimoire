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
public final class FragmentUserListsBinding implements ViewBinding {
    public final RecyclerView listsRecyclerView;
    public final LottieAnimationView loadingAnimationViewRecyclerView;
    public final TextView noListsText;
    private final LinearLayout rootView;

    private FragmentUserListsBinding(LinearLayout linearLayout, RecyclerView recyclerView, LottieAnimationView lottieAnimationView, TextView textView) {
        this.rootView = linearLayout;
        this.listsRecyclerView = recyclerView;
        this.loadingAnimationViewRecyclerView = lottieAnimationView;
        this.noListsText = textView;
    }

    public static FragmentUserListsBinding bind(View view) {
        int i = R.id.listsRecyclerView;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.loadingAnimationViewRecyclerView;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView != null) {
                i = R.id.noListsText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new FragmentUserListsBinding((LinearLayout) view, recyclerView, lottieAnimationView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentUserListsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUserListsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user_lists, viewGroup, false);
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
