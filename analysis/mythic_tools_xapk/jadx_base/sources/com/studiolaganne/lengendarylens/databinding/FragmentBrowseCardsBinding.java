package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentBrowseCardsBinding implements ViewBinding {
    public final TextView addFilterButton;
    public final LinearLayout addFilterLayout;
    public final TextView addFilterTextView;
    public final LinearLayout advancedSearchLayout;
    public final ImageView backImage;
    public final RecyclerView cardsRecyclerView;
    public final ImageView collapseImageView;
    public final EditText filterEditText;
    public final ImageView filterImage;
    public final LinearLayout filterLayout;
    public final TextView filterNumberTextView;
    public final ConstraintLayout filterSummaryLayout;
    public final TextView filterSummaryTextView;
    public final RecyclerView filtersRecyclerView;
    public final ImageView gridImage;
    public final TextView numCardsTextView;
    public final ConstraintLayout rootLayout;
    private final RelativeLayout rootView;
    public final ImageView sortOrderImageView;
    public final TextView sortOrderLabel;
    public final Spinner sortSpinner;
    public final TextView titleTextView;
    public final LinearLayout topLayout;

    private FragmentBrowseCardsBinding(RelativeLayout relativeLayout, TextView textView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, ImageView imageView, RecyclerView recyclerView, ImageView imageView2, EditText editText, ImageView imageView3, LinearLayout linearLayout3, TextView textView3, ConstraintLayout constraintLayout, TextView textView4, RecyclerView recyclerView2, ImageView imageView4, TextView textView5, ConstraintLayout constraintLayout2, ImageView imageView5, TextView textView6, Spinner spinner, TextView textView7, LinearLayout linearLayout4) {
        this.rootView = relativeLayout;
        this.addFilterButton = textView;
        this.addFilterLayout = linearLayout;
        this.addFilterTextView = textView2;
        this.advancedSearchLayout = linearLayout2;
        this.backImage = imageView;
        this.cardsRecyclerView = recyclerView;
        this.collapseImageView = imageView2;
        this.filterEditText = editText;
        this.filterImage = imageView3;
        this.filterLayout = linearLayout3;
        this.filterNumberTextView = textView3;
        this.filterSummaryLayout = constraintLayout;
        this.filterSummaryTextView = textView4;
        this.filtersRecyclerView = recyclerView2;
        this.gridImage = imageView4;
        this.numCardsTextView = textView5;
        this.rootLayout = constraintLayout2;
        this.sortOrderImageView = imageView5;
        this.sortOrderLabel = textView6;
        this.sortSpinner = spinner;
        this.titleTextView = textView7;
        this.topLayout = linearLayout4;
    }

    public static FragmentBrowseCardsBinding bind(View view) {
        int i = R.id.addFilterButton;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.addFilterLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.addFilterTextView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.advancedSearchLayout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.backImage;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.cardsRecyclerView;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                i = R.id.collapseImageView;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = R.id.filterEditText;
                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText != null) {
                                        i = R.id.filterImage;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.filterLayout;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout3 != null) {
                                                i = R.id.filterNumberTextView;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.filterSummaryLayout;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout != null) {
                                                        i = R.id.filterSummaryTextView;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.filtersRecyclerView;
                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                            if (recyclerView2 != null) {
                                                                i = R.id.gridImage;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView4 != null) {
                                                                    i = R.id.numCardsTextView;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.rootLayout;
                                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (constraintLayout2 != null) {
                                                                            i = R.id.sort_order_image_view;
                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView5 != null) {
                                                                                i = R.id.sort_order_label;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.sort_spinner;
                                                                                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, i);
                                                                                    if (spinner != null) {
                                                                                        i = R.id.titleTextView;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.topLayout;
                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout4 != null) {
                                                                                                return new FragmentBrowseCardsBinding((RelativeLayout) view, textView, linearLayout, textView2, linearLayout2, imageView, recyclerView, imageView2, editText, imageView3, linearLayout3, textView3, constraintLayout, textView4, recyclerView2, imageView4, textView5, constraintLayout2, imageView5, textView6, spinner, textView7, linearLayout4);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentBrowseCardsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBrowseCardsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_browse_cards, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
