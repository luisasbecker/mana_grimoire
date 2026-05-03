package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogCollectionMatchesViewerBinding implements ViewBinding {
    public final TextView cardNameTextView;
    public final MaterialButton closeButton;
    public final ImageView closeImage;
    public final TextView collectorNumberTextView;
    public final RecyclerView matchesRecyclerView;
    private final LinearLayout rootView;
    public final TextView setCodeTextView;
    public final TextView titleTextView;

    private DialogCollectionMatchesViewerBinding(LinearLayout linearLayout, TextView textView, MaterialButton materialButton, ImageView imageView, TextView textView2, RecyclerView recyclerView, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.cardNameTextView = textView;
        this.closeButton = materialButton;
        this.closeImage = imageView;
        this.collectorNumberTextView = textView2;
        this.matchesRecyclerView = recyclerView;
        this.setCodeTextView = textView3;
        this.titleTextView = textView4;
    }

    public static DialogCollectionMatchesViewerBinding bind(View view) {
        int i = R.id.cardNameTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.closeButton;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.closeImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.collectorNumberTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.matchesRecyclerView;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            i = R.id.setCodeTextView;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.titleTextView;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    return new DialogCollectionMatchesViewerBinding((LinearLayout) view, textView, materialButton, imageView, textView2, recyclerView, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogCollectionMatchesViewerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogCollectionMatchesViewerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_collection_matches_viewer, viewGroup, false);
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
