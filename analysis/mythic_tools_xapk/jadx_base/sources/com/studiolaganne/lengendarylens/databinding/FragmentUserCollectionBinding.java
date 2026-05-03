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
public final class FragmentUserCollectionBinding implements ViewBinding {
    public final RecyclerView collectionRecyclerView;
    public final LottieAnimationView loadingAnimationViewRecyclerView;
    public final TextView noCollectionText;
    private final LinearLayout rootView;

    private FragmentUserCollectionBinding(LinearLayout linearLayout, RecyclerView recyclerView, LottieAnimationView lottieAnimationView, TextView textView) {
        this.rootView = linearLayout;
        this.collectionRecyclerView = recyclerView;
        this.loadingAnimationViewRecyclerView = lottieAnimationView;
        this.noCollectionText = textView;
    }

    public static FragmentUserCollectionBinding bind(View view) {
        int i = R.id.collectionRecyclerView;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.loadingAnimationViewRecyclerView;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView != null) {
                i = R.id.noCollectionText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new FragmentUserCollectionBinding((LinearLayout) view, recyclerView, lottieAnimationView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentUserCollectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUserCollectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user_collection, viewGroup, false);
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
