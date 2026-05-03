package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentListsRootBinding implements ViewBinding {
    public final ConstraintLayout addButtonLayout;
    public final TextView connectingTextView;
    public final RecyclerView listsRecyclerView;
    public final LottieAnimationView loadingAnimationView;
    public final ConstraintLayout overlay;
    public final ImageView plusImageView;
    private final ConstraintLayout rootView;
    public final SwipeRefreshLayout swipeRefreshLayout;

    private FragmentListsRootBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, RecyclerView recyclerView, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout3, ImageView imageView, SwipeRefreshLayout swipeRefreshLayout) {
        this.rootView = constraintLayout;
        this.addButtonLayout = constraintLayout2;
        this.connectingTextView = textView;
        this.listsRecyclerView = recyclerView;
        this.loadingAnimationView = lottieAnimationView;
        this.overlay = constraintLayout3;
        this.plusImageView = imageView;
        this.swipeRefreshLayout = swipeRefreshLayout;
    }

    public static FragmentListsRootBinding bind(View view) {
        int i = R.id.addButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.connectingTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.listsRecyclerView;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    i = R.id.loadingAnimationView;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                    if (lottieAnimationView != null) {
                        i = R.id.overlay;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.plusImageView;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.swipeRefreshLayout;
                                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                                if (swipeRefreshLayout != null) {
                                    return new FragmentListsRootBinding((ConstraintLayout) view, constraintLayout, textView, recyclerView, lottieAnimationView, constraintLayout2, imageView, swipeRefreshLayout);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentListsRootBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentListsRootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_lists_root, viewGroup, false);
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
