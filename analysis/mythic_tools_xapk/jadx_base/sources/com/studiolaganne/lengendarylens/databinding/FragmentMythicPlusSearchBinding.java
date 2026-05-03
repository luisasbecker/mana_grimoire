package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentMythicPlusSearchBinding implements ViewBinding {
    public final TextView addTabButton;
    public final TextView emptyStateText;
    public final TextView filterButton;
    public final LinearLayout filterPillsRow;
    public final CheckBox fromCollectionCheckBox;
    public final ImageView gridToggle;
    public final ProgressBar loadingIndicator;
    public final TextView numResultsText;
    public final LinearLayout pillsContainer;
    public final HorizontalScrollView pillsScrollView;
    public final RecyclerView resultsRecyclerView;
    public final LinearLayout resultsToolbar;
    private final LinearLayout rootView;
    public final TextView searchButton;
    public final EditText searchEditText;
    public final TextView sortButton;
    public final LinearLayout tabStripContainer;
    public final View tabStripDivider;
    public final LinearLayout tabStripLayout;
    public final HorizontalScrollView tabStripScroll;

    private FragmentMythicPlusSearchBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout2, CheckBox checkBox, ImageView imageView, ProgressBar progressBar, TextView textView4, LinearLayout linearLayout3, HorizontalScrollView horizontalScrollView, RecyclerView recyclerView, LinearLayout linearLayout4, TextView textView5, EditText editText, TextView textView6, LinearLayout linearLayout5, View view, LinearLayout linearLayout6, HorizontalScrollView horizontalScrollView2) {
        this.rootView = linearLayout;
        this.addTabButton = textView;
        this.emptyStateText = textView2;
        this.filterButton = textView3;
        this.filterPillsRow = linearLayout2;
        this.fromCollectionCheckBox = checkBox;
        this.gridToggle = imageView;
        this.loadingIndicator = progressBar;
        this.numResultsText = textView4;
        this.pillsContainer = linearLayout3;
        this.pillsScrollView = horizontalScrollView;
        this.resultsRecyclerView = recyclerView;
        this.resultsToolbar = linearLayout4;
        this.searchButton = textView5;
        this.searchEditText = editText;
        this.sortButton = textView6;
        this.tabStripContainer = linearLayout5;
        this.tabStripDivider = view;
        this.tabStripLayout = linearLayout6;
        this.tabStripScroll = horizontalScrollView2;
    }

    public static FragmentMythicPlusSearchBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.addTabButton;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.emptyStateText;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.filterButton;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.filterPillsRow;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.fromCollectionCheckBox;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                        if (checkBox != null) {
                            i = R.id.gridToggle;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.loadingIndicator;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                if (progressBar != null) {
                                    i = R.id.numResultsText;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.pillsContainer;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout2 != null) {
                                            i = R.id.pillsScrollView;
                                            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i);
                                            if (horizontalScrollView != null) {
                                                i = R.id.resultsRecyclerView;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                if (recyclerView != null) {
                                                    i = R.id.resultsToolbar;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout3 != null) {
                                                        i = R.id.searchButton;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.searchEditText;
                                                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                            if (editText != null) {
                                                                i = R.id.sortButton;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView6 != null) {
                                                                    i = R.id.tabStripContainer;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.tabStripDivider))) != null) {
                                                                        i = R.id.tabStripLayout;
                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout5 != null) {
                                                                            i = R.id.tabStripScroll;
                                                                            HorizontalScrollView horizontalScrollView2 = (HorizontalScrollView) ViewBindings.findChildViewById(view, i);
                                                                            if (horizontalScrollView2 != null) {
                                                                                return new FragmentMythicPlusSearchBinding((LinearLayout) view, textView, textView2, textView3, linearLayout, checkBox, imageView, progressBar, textView4, linearLayout2, horizontalScrollView, recyclerView, linearLayout3, textView5, editText, textView6, linearLayout4, viewFindChildViewById, linearLayout5, horizontalScrollView2);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentMythicPlusSearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMythicPlusSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_mythic_plus_search, viewGroup, false);
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
