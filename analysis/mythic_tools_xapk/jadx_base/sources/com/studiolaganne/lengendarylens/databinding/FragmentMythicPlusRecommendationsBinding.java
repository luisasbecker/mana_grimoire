package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentMythicPlusRecommendationsBinding implements ViewBinding {
    public final LinearLayout broadCategoryRow;
    public final RecyclerView cardsRecyclerView;
    public final CheckBox fromCollectionCheckBox;
    public final ImageView gridToggle;
    public final TextView languageIcon;
    public final ProgressBar loadingFooter;
    public final ProgressBar loadingIndicator;
    public final ConstraintLayout refreshButtonLayout;
    public final TextView refreshIconTextView;
    public final TextView refreshTitle;
    private final ConstraintLayout rootView;
    public final TextView scrollHintButton;
    public final LinearLayout typeCategoryRow;
    public final HorizontalScrollView typeCategoryScroll;

    private FragmentMythicPlusRecommendationsBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, RecyclerView recyclerView, CheckBox checkBox, ImageView imageView, TextView textView, ProgressBar progressBar, ProgressBar progressBar2, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout2, HorizontalScrollView horizontalScrollView) {
        this.rootView = constraintLayout;
        this.broadCategoryRow = linearLayout;
        this.cardsRecyclerView = recyclerView;
        this.fromCollectionCheckBox = checkBox;
        this.gridToggle = imageView;
        this.languageIcon = textView;
        this.loadingFooter = progressBar;
        this.loadingIndicator = progressBar2;
        this.refreshButtonLayout = constraintLayout2;
        this.refreshIconTextView = textView2;
        this.refreshTitle = textView3;
        this.scrollHintButton = textView4;
        this.typeCategoryRow = linearLayout2;
        this.typeCategoryScroll = horizontalScrollView;
    }

    public static FragmentMythicPlusRecommendationsBinding bind(View view) {
        int i = R.id.broadCategoryRow;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.cardsRecyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.fromCollectionCheckBox;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                if (checkBox != null) {
                    i = R.id.gridToggle;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.languageIcon;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.loadingFooter;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                            if (progressBar != null) {
                                i = R.id.loadingIndicator;
                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                if (progressBar2 != null) {
                                    i = R.id.refreshButtonLayout;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout != null) {
                                        i = R.id.refreshIconTextView;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.refreshTitle;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.scrollHintButton;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.typeCategoryRow;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.typeCategoryScroll;
                                                        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i);
                                                        if (horizontalScrollView != null) {
                                                            return new FragmentMythicPlusRecommendationsBinding((ConstraintLayout) view, linearLayout, recyclerView, checkBox, imageView, textView, progressBar, progressBar2, constraintLayout, textView2, textView3, textView4, linearLayout2, horizontalScrollView);
                                                        }
                                                    }
                                                }
                                            }
                                        }
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

    public static FragmentMythicPlusRecommendationsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMythicPlusRecommendationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_mythic_plus_recommendations, viewGroup, false);
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
