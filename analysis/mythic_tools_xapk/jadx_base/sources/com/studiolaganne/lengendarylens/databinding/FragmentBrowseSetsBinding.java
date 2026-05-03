package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentBrowseSetsBinding implements ViewBinding {
    public final FrameLayout cardsContainer;
    public final CardView flagContainer;
    public final ImageView flagImage;
    private final ConstraintLayout rootView;
    public final EditText searchEditText;
    public final RecyclerView setListRecyclerView;

    private FragmentBrowseSetsBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, CardView cardView, ImageView imageView, EditText editText, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.cardsContainer = frameLayout;
        this.flagContainer = cardView;
        this.flagImage = imageView;
        this.searchEditText = editText;
        this.setListRecyclerView = recyclerView;
    }

    public static FragmentBrowseSetsBinding bind(View view) {
        int i = R.id.cardsContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.flag_container;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                i = R.id.flag_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.searchEditText;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText != null) {
                        i = R.id.setListRecyclerView;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            return new FragmentBrowseSetsBinding((ConstraintLayout) view, frameLayout, cardView, imageView, editText, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentBrowseSetsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBrowseSetsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_browse_sets, viewGroup, false);
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
