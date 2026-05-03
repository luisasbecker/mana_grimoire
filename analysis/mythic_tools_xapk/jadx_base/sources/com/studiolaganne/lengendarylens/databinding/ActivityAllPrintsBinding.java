package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityAllPrintsBinding implements ViewBinding {
    public final MaterialButton backButton;
    public final EditText filterEditText;
    public final LottieAnimationView loadingAnimationView;
    public final View loadingBackgroundView;
    public final RecyclerView printsRecyclerView;
    private final FrameLayout rootView;
    public final ImageView sortOrderImageView;
    public final TextView sortOrderLabel;
    public final Spinner sortSpinner;
    public final LinearLayout topLayout;

    private ActivityAllPrintsBinding(FrameLayout frameLayout, MaterialButton materialButton, EditText editText, LottieAnimationView lottieAnimationView, View view, RecyclerView recyclerView, ImageView imageView, TextView textView, Spinner spinner, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.backButton = materialButton;
        this.filterEditText = editText;
        this.loadingAnimationView = lottieAnimationView;
        this.loadingBackgroundView = view;
        this.printsRecyclerView = recyclerView;
        this.sortOrderImageView = imageView;
        this.sortOrderLabel = textView;
        this.sortSpinner = spinner;
        this.topLayout = linearLayout;
    }

    public static ActivityAllPrintsBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.backButton;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.filter_edit_text;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.loadingAnimationView;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                if (lottieAnimationView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.loadingBackgroundView))) != null) {
                    i = R.id.prints_recycler_view;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.sort_order_image_view;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.sort_order_label;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.sort_spinner;
                                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, i);
                                if (spinner != null) {
                                    i = R.id.top_layout;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        return new ActivityAllPrintsBinding((FrameLayout) view, materialButton, editText, lottieAnimationView, viewFindChildViewById, recyclerView, imageView, textView, spinner, linearLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityAllPrintsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAllPrintsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_all_prints, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
