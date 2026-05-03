package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.MarketplaceSelectorView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentSearchCardsBinding implements ViewBinding {
    public final TextView addFilterButton;
    public final LinearLayout addFilterLayout;
    public final TextView addFilterTextView;
    public final LinearLayout advancedSearchLayout;
    public final TextView btnAllCards;
    public final TextView btnMyCollection;
    public final RecyclerView cardsRecyclerView;
    public final ImageView collapseImageView;
    public final TextView collectionReminderTextView;
    public final TextView downloadLabel;
    public final TextView filterNumberTextView;
    public final ConstraintLayout filterSummaryLayout;
    public final TextView filterSummaryTextView;
    public final RecyclerView filtersRecyclerView;
    public final ImageView gridImage;
    public final TextView groupByButton;
    public final LottieAnimationView loadingAnimationView;
    public final View loadingBackgroundView;
    public final MarketplaceSelectorView marketplaceSelectorView;
    public final TextView noMatchesTextView;
    public final TextView numCardsTextView;
    public final TextView offlineModeIndicator;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final LottieAnimationView scrollAnimationView;
    public final TextView searchButton;
    public final EditText searchEditText;
    public final TextView searchSettingsIcon;
    public final LinearLayout searchSourceToggle;
    public final TextView sortByButton;
    public final LinearLayout sortGroupToolbar;

    private FragmentSearchCardsBinding(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, TextView textView3, TextView textView4, RecyclerView recyclerView, ImageView imageView, TextView textView5, TextView textView6, TextView textView7, ConstraintLayout constraintLayout2, TextView textView8, RecyclerView recyclerView2, ImageView imageView2, TextView textView9, LottieAnimationView lottieAnimationView, View view, MarketplaceSelectorView marketplaceSelectorView, TextView textView10, TextView textView11, TextView textView12, ProgressBar progressBar, LottieAnimationView lottieAnimationView2, TextView textView13, EditText editText, TextView textView14, LinearLayout linearLayout3, TextView textView15, LinearLayout linearLayout4) {
        this.rootView = constraintLayout;
        this.addFilterButton = textView;
        this.addFilterLayout = linearLayout;
        this.addFilterTextView = textView2;
        this.advancedSearchLayout = linearLayout2;
        this.btnAllCards = textView3;
        this.btnMyCollection = textView4;
        this.cardsRecyclerView = recyclerView;
        this.collapseImageView = imageView;
        this.collectionReminderTextView = textView5;
        this.downloadLabel = textView6;
        this.filterNumberTextView = textView7;
        this.filterSummaryLayout = constraintLayout2;
        this.filterSummaryTextView = textView8;
        this.filtersRecyclerView = recyclerView2;
        this.gridImage = imageView2;
        this.groupByButton = textView9;
        this.loadingAnimationView = lottieAnimationView;
        this.loadingBackgroundView = view;
        this.marketplaceSelectorView = marketplaceSelectorView;
        this.noMatchesTextView = textView10;
        this.numCardsTextView = textView11;
        this.offlineModeIndicator = textView12;
        this.progressBar = progressBar;
        this.scrollAnimationView = lottieAnimationView2;
        this.searchButton = textView13;
        this.searchEditText = editText;
        this.searchSettingsIcon = textView14;
        this.searchSourceToggle = linearLayout3;
        this.sortByButton = textView15;
        this.sortGroupToolbar = linearLayout4;
    }

    public static FragmentSearchCardsBinding bind(View view) {
        View viewFindChildViewById;
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
                        i = R.id.btnAllCards;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.btnMyCollection;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.cards_recycler_view;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                if (recyclerView != null) {
                                    i = R.id.collapseImageView;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = R.id.collectionReminderTextView;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.downloadLabel;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.filterNumberTextView;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView7 != null) {
                                                    i = R.id.filterSummaryLayout;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout != null) {
                                                        i = R.id.filterSummaryTextView;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null) {
                                                            i = R.id.filtersRecyclerView;
                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                            if (recyclerView2 != null) {
                                                                i = R.id.gridImage;
                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView2 != null) {
                                                                    i = R.id.groupByButton;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView9 != null) {
                                                                        i = R.id.loadingAnimationView;
                                                                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                        if (lottieAnimationView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.loadingBackgroundView))) != null) {
                                                                            i = R.id.marketplaceSelectorView;
                                                                            MarketplaceSelectorView marketplaceSelectorView = (MarketplaceSelectorView) ViewBindings.findChildViewById(view, i);
                                                                            if (marketplaceSelectorView != null) {
                                                                                i = R.id.noMatchesTextView;
                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView10 != null) {
                                                                                    i = R.id.numCardsTextView;
                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView11 != null) {
                                                                                        i = R.id.offlineModeIndicator;
                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView12 != null) {
                                                                                            i = R.id.progressBar;
                                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                            if (progressBar != null) {
                                                                                                i = R.id.scrollAnimationView;
                                                                                                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                                if (lottieAnimationView2 != null) {
                                                                                                    i = R.id.searchButton;
                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView13 != null) {
                                                                                                        i = R.id.searchEditText;
                                                                                                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                        if (editText != null) {
                                                                                                            i = R.id.searchSettingsIcon;
                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView14 != null) {
                                                                                                                i = R.id.searchSourceToggle;
                                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (linearLayout3 != null) {
                                                                                                                    i = R.id.sortByButton;
                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView15 != null) {
                                                                                                                        i = R.id.sortGroupToolbar;
                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (linearLayout4 != null) {
                                                                                                                            return new FragmentSearchCardsBinding((ConstraintLayout) view, textView, linearLayout, textView2, linearLayout2, textView3, textView4, recyclerView, imageView, textView5, textView6, textView7, constraintLayout, textView8, recyclerView2, imageView2, textView9, lottieAnimationView, viewFindChildViewById, marketplaceSelectorView, textView10, textView11, textView12, progressBar, lottieAnimationView2, textView13, editText, textView14, linearLayout3, textView15, linearLayout4);
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
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentSearchCardsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSearchCardsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_search_cards, viewGroup, false);
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
