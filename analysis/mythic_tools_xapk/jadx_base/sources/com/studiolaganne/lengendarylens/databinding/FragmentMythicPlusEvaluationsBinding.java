package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentMythicPlusEvaluationsBinding implements ViewBinding {
    public final HorizontalScrollView categoryTabsScroll;
    public final TextView evalErrorText;
    public final ProgressBar evalLoadingIndicator;
    public final RecyclerView evalRecyclerView;
    public final TextView evalSummaryLabel;
    private final ConstraintLayout rootView;
    public final LinearLayout verdictTabsRow;

    private FragmentMythicPlusEvaluationsBinding(ConstraintLayout constraintLayout, HorizontalScrollView horizontalScrollView, TextView textView, ProgressBar progressBar, RecyclerView recyclerView, TextView textView2, LinearLayout linearLayout) {
        this.rootView = constraintLayout;
        this.categoryTabsScroll = horizontalScrollView;
        this.evalErrorText = textView;
        this.evalLoadingIndicator = progressBar;
        this.evalRecyclerView = recyclerView;
        this.evalSummaryLabel = textView2;
        this.verdictTabsRow = linearLayout;
    }

    public static FragmentMythicPlusEvaluationsBinding bind(View view) {
        int i = R.id.categoryTabsScroll;
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i);
        if (horizontalScrollView != null) {
            i = R.id.evalErrorText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.evalLoadingIndicator;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null) {
                    i = R.id.evalRecyclerView;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.evalSummaryLabel;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.verdictTabsRow;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                return new FragmentMythicPlusEvaluationsBinding((ConstraintLayout) view, horizontalScrollView, textView, progressBar, recyclerView, textView2, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentMythicPlusEvaluationsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMythicPlusEvaluationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_mythic_plus_evaluations, viewGroup, false);
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
