package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentMtCardPickerBinding implements ViewBinding {
    public final TextView addFilterButton;
    public final LinearLayout addFilterLayout;
    public final TextView addFilterTextView;
    public final LinearLayout advancedSearchLayout;
    public final TextView btnAllCards;
    public final TextView btnMyCollection;
    public final RecyclerView cardsRecyclerView;
    public final ImageView chevronDown;
    public final ImageView collapseImageView;
    public final TextView collectionReminderTextView;
    public final TextView filterNumberTextView;
    public final ConstraintLayout filterSummaryLayout;
    public final TextView filterSummaryTextView;
    public final RecyclerView filtersRecyclerView;
    public final ImageView gridImage;
    public final ConstraintLayout headerLayout;
    public final CheckBox legalCardsOnlyCheckBox;
    public final LinearLayout legalCardsOnlyLayout;
    public final LottieAnimationView loadingAnimationView;
    public final View loadingBackgroundView;
    public final TextView noMatchesTextView;
    public final TextView numCardsTextView;
    private final ConstraintLayout rootView;
    public final TextView searchButton;
    public final EditText searchEditText;
    public final LinearLayout searchSourceToggle;
    public final TextView titleTextView;

    private FragmentMtCardPickerBinding(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, TextView textView3, TextView textView4, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, TextView textView5, TextView textView6, ConstraintLayout constraintLayout2, TextView textView7, RecyclerView recyclerView2, ImageView imageView3, ConstraintLayout constraintLayout3, CheckBox checkBox, LinearLayout linearLayout3, LottieAnimationView lottieAnimationView, View view, TextView textView8, TextView textView9, TextView textView10, EditText editText, LinearLayout linearLayout4, TextView textView11) {
        this.rootView = constraintLayout;
        this.addFilterButton = textView;
        this.addFilterLayout = linearLayout;
        this.addFilterTextView = textView2;
        this.advancedSearchLayout = linearLayout2;
        this.btnAllCards = textView3;
        this.btnMyCollection = textView4;
        this.cardsRecyclerView = recyclerView;
        this.chevronDown = imageView;
        this.collapseImageView = imageView2;
        this.collectionReminderTextView = textView5;
        this.filterNumberTextView = textView6;
        this.filterSummaryLayout = constraintLayout2;
        this.filterSummaryTextView = textView7;
        this.filtersRecyclerView = recyclerView2;
        this.gridImage = imageView3;
        this.headerLayout = constraintLayout3;
        this.legalCardsOnlyCheckBox = checkBox;
        this.legalCardsOnlyLayout = linearLayout3;
        this.loadingAnimationView = lottieAnimationView;
        this.loadingBackgroundView = view;
        this.noMatchesTextView = textView8;
        this.numCardsTextView = textView9;
        this.searchButton = textView10;
        this.searchEditText = editText;
        this.searchSourceToggle = linearLayout4;
        this.titleTextView = textView11;
    }

    public static FragmentMtCardPickerBinding bind(View view) {
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
                                    i = R.id.chevron_down;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = R.id.collapseImageView;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView2 != null) {
                                            i = R.id.collectionReminderTextView;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.filterNumberTextView;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    i = R.id.filterSummaryLayout;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout != null) {
                                                        i = R.id.filterSummaryTextView;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            i = R.id.filtersRecyclerView;
                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                            if (recyclerView2 != null) {
                                                                i = R.id.gridImage;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView3 != null) {
                                                                    i = R.id.headerLayout;
                                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout2 != null) {
                                                                        i = R.id.legalCardsOnlyCheckBox;
                                                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                                                                        if (checkBox != null) {
                                                                            i = R.id.legalCardsOnlyLayout;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.loadingAnimationView;
                                                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                if (lottieAnimationView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.loadingBackgroundView))) != null) {
                                                                                    i = R.id.noMatchesTextView;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.numCardsTextView;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.searchButton;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.searchEditText;
                                                                                                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                if (editText != null) {
                                                                                                    i = R.id.searchSourceToggle;
                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout4 != null) {
                                                                                                        i = R.id.titleTextView;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView11 != null) {
                                                                                                            return new FragmentMtCardPickerBinding((ConstraintLayout) view, textView, linearLayout, textView2, linearLayout2, textView3, textView4, recyclerView, imageView, imageView2, textView5, textView6, constraintLayout, textView7, recyclerView2, imageView3, constraintLayout2, checkBox, linearLayout3, lottieAnimationView, viewFindChildViewById, textView8, textView9, textView10, editText, linearLayout4, textView11);
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

    public static FragmentMtCardPickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMtCardPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_mt_card_picker, viewGroup, false);
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
