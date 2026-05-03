package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ComboItemBinding implements ViewBinding {
    public final View bottomLine;
    public final ConstraintLayout cardCountLayout;
    public final TextView cardCountTextView;
    public final ConstraintLayout cardLayout;
    public final ConstraintLayout comboInfoInnerLayout;
    public final LinearLayout comboStrengthLayout;
    public final TextView comboTitleTextView;
    public final ImageView dotsImage;
    public final ConstraintLayout dotsLayout;
    public final LoadingImageView firstCardImageView;
    public final ConstraintLayout firstCardZoneLayout;
    public final TextView firstCardZoneTextView;
    public final LinearLayout manaCostComboLayout;
    public final TextView manaNeededHeaderTextView;
    public final TextView manaNeededValueTextView;
    public final ConstraintLayout plusCardsLayout;
    public final TextView plusCardsTextView;
    public final FlexboxLayout resultTags;
    public final ConstraintLayout rootLayout;
    public final LinearLayout rootLinearLayout;
    private final LinearLayout rootView;
    public final LoadingImageView secondCardImageView;
    public final ConstraintLayout secondCardZoneLayout;
    public final TextView secondCardZoneTextView;
    public final TextView strengthColorTextView;
    public final TextView strengthTextView;

    private ComboItemBinding(LinearLayout linearLayout, View view, ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout2, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout4, LoadingImageView loadingImageView, ConstraintLayout constraintLayout5, TextView textView3, LinearLayout linearLayout3, TextView textView4, TextView textView5, ConstraintLayout constraintLayout6, TextView textView6, FlexboxLayout flexboxLayout, ConstraintLayout constraintLayout7, LinearLayout linearLayout4, LoadingImageView loadingImageView2, ConstraintLayout constraintLayout8, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = linearLayout;
        this.bottomLine = view;
        this.cardCountLayout = constraintLayout;
        this.cardCountTextView = textView;
        this.cardLayout = constraintLayout2;
        this.comboInfoInnerLayout = constraintLayout3;
        this.comboStrengthLayout = linearLayout2;
        this.comboTitleTextView = textView2;
        this.dotsImage = imageView;
        this.dotsLayout = constraintLayout4;
        this.firstCardImageView = loadingImageView;
        this.firstCardZoneLayout = constraintLayout5;
        this.firstCardZoneTextView = textView3;
        this.manaCostComboLayout = linearLayout3;
        this.manaNeededHeaderTextView = textView4;
        this.manaNeededValueTextView = textView5;
        this.plusCardsLayout = constraintLayout6;
        this.plusCardsTextView = textView6;
        this.resultTags = flexboxLayout;
        this.rootLayout = constraintLayout7;
        this.rootLinearLayout = linearLayout4;
        this.secondCardImageView = loadingImageView2;
        this.secondCardZoneLayout = constraintLayout8;
        this.secondCardZoneTextView = textView7;
        this.strengthColorTextView = textView8;
        this.strengthTextView = textView9;
    }

    public static ComboItemBinding bind(View view) {
        int i = R.id.bottomLine;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById != null) {
            i = R.id.cardCountLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.cardCountTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.cardLayout;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.comboInfoInnerLayout;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout3 != null) {
                            i = R.id.comboStrengthLayout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.comboTitleTextView;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.dotsImage;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = R.id.dotsLayout;
                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout4 != null) {
                                            i = R.id.firstCardImageView;
                                            LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
                                            if (loadingImageView != null) {
                                                i = R.id.firstCardZoneLayout;
                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout5 != null) {
                                                    i = R.id.firstCardZoneTextView;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.manaCostComboLayout;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.manaNeededHeaderTextView;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.manaNeededValueTextView;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.plusCardsLayout;
                                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout6 != null) {
                                                                        i = R.id.plusCardsTextView;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.resultTags;
                                                                            FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (flexboxLayout != null) {
                                                                                i = R.id.root_layout;
                                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (constraintLayout7 != null) {
                                                                                    LinearLayout linearLayout3 = (LinearLayout) view;
                                                                                    i = R.id.secondCardImageView;
                                                                                    LoadingImageView loadingImageView2 = (LoadingImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (loadingImageView2 != null) {
                                                                                        i = R.id.secondCardZoneLayout;
                                                                                        ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (constraintLayout8 != null) {
                                                                                            i = R.id.secondCardZoneTextView;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView7 != null) {
                                                                                                i = R.id.strengthColorTextView;
                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView8 != null) {
                                                                                                    i = R.id.strengthTextView;
                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView9 != null) {
                                                                                                        return new ComboItemBinding(linearLayout3, viewFindChildViewById, constraintLayout, textView, constraintLayout2, constraintLayout3, linearLayout, textView2, imageView, constraintLayout4, loadingImageView, constraintLayout5, textView3, linearLayout2, textView4, textView5, constraintLayout6, textView6, flexboxLayout, constraintLayout7, linearLayout3, loadingImageView2, constraintLayout8, textView7, textView8, textView9);
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

    public static ComboItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ComboItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.combo_item, viewGroup, false);
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
