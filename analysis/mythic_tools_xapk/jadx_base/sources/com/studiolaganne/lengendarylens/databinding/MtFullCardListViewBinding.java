package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class MtFullCardListViewBinding implements ViewBinding {
    public final TextView addToDeckButton;
    public final TextView alteredTextView;
    public final ConstraintLayout bottomLayout;
    public final TextView bottomText;
    public final LoadingImageView cardImage;
    public final ConstraintLayout cardImageContainer;
    public final ConstraintLayout cardLayout;
    public final TextView cardNumberLabel;
    public final ConstraintLayout centerSelectionLayout;
    public final ImageView collectionImage;
    public final LinearLayout collectionLayout;
    public final LinearLayout collectionRootLayout;
    public final TextView conditionTextView;
    public final TextView confidenceBadge;
    public final TextView containerLabel;
    public final View cornerView;
    public final TextView deckCountLabel;
    public final TextView deckLabel;
    public final LinearLayout deckLayout;
    public final TextView deckNameLabel;
    public final ImageView dotsMenuButton;
    public final LinearLayout extrasLayout;
    public final CardView flagContainer;
    public final ImageView flagImage;
    public final ImageView foilEffectImage;
    public final Guideline guidelineBottom;
    public final Guideline guidelineBottomArrow1;
    public final Guideline guidelineBottomArrow2;
    public final Guideline guidelineBottomButton1;
    public final Guideline guidelineBottomButton2;
    public final Guideline guidelineBottomCheck;
    public final Guideline guidelineLeftCheck;
    public final Guideline guidelineRightCheck;
    public final Guideline guidelineTop;
    public final Guideline guidelineTopArrow1;
    public final Guideline guidelineTopArrow2;
    public final Guideline guidelineTopButton1;
    public final Guideline guidelineTopButton2;
    public final Guideline guidelineTopCheck;
    public final LinearLayout horizontalLayout;
    public final ImageView isFoilImage;
    public final ConstraintLayout mainLayout;
    public final TextView manaCostLabel;
    public final ConstraintLayout minusQtyLayout;
    public final TextView minusQtyTextIcon;
    public final TextView missprintTextView;
    public final TextView mythicAvailableLabel;
    public final LinearLayout mythicAvailableLayout;
    public final TextView mythicInDeckLabel;
    public final LinearLayout mythicInDeckLayout;
    public final TextView newRibbonLabel;
    public final ConstraintLayout oracleLayout;
    public final TextView oracleTextView;
    public final ConstraintLayout plusQtyLayout;
    public final TextView plusQtyTextIcon;
    public final TextView powerToughnessTextView;
    public final TextView priceLabel;
    public final LinearLayout priceLayout;
    public final TextView proxyTextView;
    public final TextView qtyTextView;
    public final LinearLayout recommendationActionsLayout;
    public final LinearLayout recommendationInfoLayout;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final TextView selectedAmountText;
    public final ConstraintLayout selectionControlsLayout;
    public final ImageView setImage;
    public final TextView setLabel;
    public final TextView signedTextView;
    public final TextView similarityLabel;
    public final TextView titleLabel;
    public final TextView typeLabel;

    private MtFullCardListViewBinding(LinearLayout linearLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout, TextView textView3, LoadingImageView loadingImageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView4, ConstraintLayout constraintLayout4, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView5, TextView textView6, TextView textView7, View view, TextView textView8, TextView textView9, LinearLayout linearLayout4, TextView textView10, ImageView imageView2, LinearLayout linearLayout5, CardView cardView, ImageView imageView3, ImageView imageView4, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, Guideline guideline10, Guideline guideline11, Guideline guideline12, Guideline guideline13, Guideline guideline14, LinearLayout linearLayout6, ImageView imageView5, ConstraintLayout constraintLayout5, TextView textView11, ConstraintLayout constraintLayout6, TextView textView12, TextView textView13, TextView textView14, LinearLayout linearLayout7, TextView textView15, LinearLayout linearLayout8, TextView textView16, ConstraintLayout constraintLayout7, TextView textView17, ConstraintLayout constraintLayout8, TextView textView18, TextView textView19, TextView textView20, LinearLayout linearLayout9, TextView textView21, TextView textView22, LinearLayout linearLayout10, LinearLayout linearLayout11, LinearLayout linearLayout12, TextView textView23, ConstraintLayout constraintLayout9, ImageView imageView6, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28) {
        this.rootView = linearLayout;
        this.addToDeckButton = textView;
        this.alteredTextView = textView2;
        this.bottomLayout = constraintLayout;
        this.bottomText = textView3;
        this.cardImage = loadingImageView;
        this.cardImageContainer = constraintLayout2;
        this.cardLayout = constraintLayout3;
        this.cardNumberLabel = textView4;
        this.centerSelectionLayout = constraintLayout4;
        this.collectionImage = imageView;
        this.collectionLayout = linearLayout2;
        this.collectionRootLayout = linearLayout3;
        this.conditionTextView = textView5;
        this.confidenceBadge = textView6;
        this.containerLabel = textView7;
        this.cornerView = view;
        this.deckCountLabel = textView8;
        this.deckLabel = textView9;
        this.deckLayout = linearLayout4;
        this.deckNameLabel = textView10;
        this.dotsMenuButton = imageView2;
        this.extrasLayout = linearLayout5;
        this.flagContainer = cardView;
        this.flagImage = imageView3;
        this.foilEffectImage = imageView4;
        this.guidelineBottom = guideline;
        this.guidelineBottomArrow1 = guideline2;
        this.guidelineBottomArrow2 = guideline3;
        this.guidelineBottomButton1 = guideline4;
        this.guidelineBottomButton2 = guideline5;
        this.guidelineBottomCheck = guideline6;
        this.guidelineLeftCheck = guideline7;
        this.guidelineRightCheck = guideline8;
        this.guidelineTop = guideline9;
        this.guidelineTopArrow1 = guideline10;
        this.guidelineTopArrow2 = guideline11;
        this.guidelineTopButton1 = guideline12;
        this.guidelineTopButton2 = guideline13;
        this.guidelineTopCheck = guideline14;
        this.horizontalLayout = linearLayout6;
        this.isFoilImage = imageView5;
        this.mainLayout = constraintLayout5;
        this.manaCostLabel = textView11;
        this.minusQtyLayout = constraintLayout6;
        this.minusQtyTextIcon = textView12;
        this.missprintTextView = textView13;
        this.mythicAvailableLabel = textView14;
        this.mythicAvailableLayout = linearLayout7;
        this.mythicInDeckLabel = textView15;
        this.mythicInDeckLayout = linearLayout8;
        this.newRibbonLabel = textView16;
        this.oracleLayout = constraintLayout7;
        this.oracleTextView = textView17;
        this.plusQtyLayout = constraintLayout8;
        this.plusQtyTextIcon = textView18;
        this.powerToughnessTextView = textView19;
        this.priceLabel = textView20;
        this.priceLayout = linearLayout9;
        this.proxyTextView = textView21;
        this.qtyTextView = textView22;
        this.recommendationActionsLayout = linearLayout10;
        this.recommendationInfoLayout = linearLayout11;
        this.rootLayout = linearLayout12;
        this.selectedAmountText = textView23;
        this.selectionControlsLayout = constraintLayout9;
        this.setImage = imageView6;
        this.setLabel = textView24;
        this.signedTextView = textView25;
        this.similarityLabel = textView26;
        this.titleLabel = textView27;
        this.typeLabel = textView28;
    }

    public static MtFullCardListViewBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.addToDeckButton;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.alteredTextView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.bottomLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.bottomText;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.cardImage;
                        LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
                        if (loadingImageView != null) {
                            i = R.id.cardImageContainer;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = R.id.cardLayout;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.cardNumberLabel;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.centerSelectionLayout;
                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout4 != null) {
                                            i = R.id.collectionImage;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView != null) {
                                                i = R.id.collectionLayout;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout != null) {
                                                    i = R.id.collectionRootLayout;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.conditionTextView;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.confidenceBadge;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = R.id.containerLabel;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.cornerView))) != null) {
                                                                    i = R.id.deckCountLabel;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.deckLabel;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView9 != null) {
                                                                            i = R.id.deckLayout;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.deckNameLabel;
                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView10 != null) {
                                                                                    i = R.id.dotsMenuButton;
                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (imageView2 != null) {
                                                                                        i = R.id.extrasLayout;
                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout4 != null) {
                                                                                            i = R.id.flag_container;
                                                                                            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                                                                                            if (cardView != null) {
                                                                                                i = R.id.flag_image;
                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView3 != null) {
                                                                                                    i = R.id.foilEffectImage;
                                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (imageView4 != null) {
                                                                                                        i = R.id.guideline_bottom;
                                                                                                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                        if (guideline != null) {
                                                                                                            i = R.id.guideline_bottom_arrow1;
                                                                                                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                            if (guideline2 != null) {
                                                                                                                i = R.id.guideline_bottom_arrow2;
                                                                                                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                if (guideline3 != null) {
                                                                                                                    i = R.id.guideline_bottom_button1;
                                                                                                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (guideline4 != null) {
                                                                                                                        i = R.id.guideline_bottom_button2;
                                                                                                                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (guideline5 != null) {
                                                                                                                            i = R.id.guideline_bottom_check;
                                                                                                                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (guideline6 != null) {
                                                                                                                                i = R.id.guideline_left_check;
                                                                                                                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (guideline7 != null) {
                                                                                                                                    i = R.id.guideline_right_check;
                                                                                                                                    Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (guideline8 != null) {
                                                                                                                                        i = R.id.guideline_top;
                                                                                                                                        Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (guideline9 != null) {
                                                                                                                                            i = R.id.guideline_top_arrow1;
                                                                                                                                            Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (guideline10 != null) {
                                                                                                                                                i = R.id.guideline_top_arrow2;
                                                                                                                                                Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (guideline11 != null) {
                                                                                                                                                    i = R.id.guideline_top_button1;
                                                                                                                                                    Guideline guideline12 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (guideline12 != null) {
                                                                                                                                                        i = R.id.guideline_top_button2;
                                                                                                                                                        Guideline guideline13 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (guideline13 != null) {
                                                                                                                                                            i = R.id.guideline_top_check;
                                                                                                                                                            Guideline guideline14 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (guideline14 != null) {
                                                                                                                                                                i = R.id.horizontalLayout;
                                                                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (linearLayout5 != null) {
                                                                                                                                                                    i = R.id.is_foil_image;
                                                                                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (imageView5 != null) {
                                                                                                                                                                        i = R.id.mainLayout;
                                                                                                                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (constraintLayout5 != null) {
                                                                                                                                                                            i = R.id.manaCostLabel;
                                                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (textView11 != null) {
                                                                                                                                                                                i = R.id.minusQtyLayout;
                                                                                                                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (constraintLayout6 != null) {
                                                                                                                                                                                    i = R.id.minusQtyTextIcon;
                                                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                                        i = R.id.missprintTextView;
                                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                                            i = R.id.mythicAvailableLabel;
                                                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                                                i = R.id.mythicAvailableLayout;
                                                                                                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (linearLayout6 != null) {
                                                                                                                                                                                                    i = R.id.mythicInDeckLabel;
                                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                                        i = R.id.mythicInDeckLayout;
                                                                                                                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (linearLayout7 != null) {
                                                                                                                                                                                                            i = R.id.newRibbonLabel;
                                                                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                                                i = R.id.oracleLayout;
                                                                                                                                                                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (constraintLayout7 != null) {
                                                                                                                                                                                                                    i = R.id.oracleTextView;
                                                                                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                                                                                        i = R.id.plusQtyLayout;
                                                                                                                                                                                                                        ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (constraintLayout8 != null) {
                                                                                                                                                                                                                            i = R.id.plusQtyTextIcon;
                                                                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                                                                i = R.id.powerToughnessTextView;
                                                                                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                                                                    i = R.id.priceLabel;
                                                                                                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                                                                                                        i = R.id.priceLayout;
                                                                                                                                                                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                        if (linearLayout8 != null) {
                                                                                                                                                                                                                                            i = R.id.proxyTextView;
                                                                                                                                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                                                                                                i = R.id.qtyTextView;
                                                                                                                                                                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                if (textView22 != null) {
                                                                                                                                                                                                                                                    i = R.id.recommendationActionsLayout;
                                                                                                                                                                                                                                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                    if (linearLayout9 != null) {
                                                                                                                                                                                                                                                        i = R.id.recommendationInfoLayout;
                                                                                                                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                                                                                                                            LinearLayout linearLayout11 = (LinearLayout) view;
                                                                                                                                                                                                                                                            i = R.id.selectedAmountText;
                                                                                                                                                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                            if (textView23 != null) {
                                                                                                                                                                                                                                                                i = R.id.selectionControlsLayout;
                                                                                                                                                                                                                                                                ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                if (constraintLayout9 != null) {
                                                                                                                                                                                                                                                                    i = R.id.setImage;
                                                                                                                                                                                                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                    if (imageView6 != null) {
                                                                                                                                                                                                                                                                        i = R.id.setLabel;
                                                                                                                                                                                                                                                                        TextView textView24 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                        if (textView24 != null) {
                                                                                                                                                                                                                                                                            i = R.id.signedTextView;
                                                                                                                                                                                                                                                                            TextView textView25 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                            if (textView25 != null) {
                                                                                                                                                                                                                                                                                i = R.id.similarityLabel;
                                                                                                                                                                                                                                                                                TextView textView26 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                if (textView26 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.titleLabel;
                                                                                                                                                                                                                                                                                    TextView textView27 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                    if (textView27 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.typeLabel;
                                                                                                                                                                                                                                                                                        TextView textView28 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                        if (textView28 != null) {
                                                                                                                                                                                                                                                                                            return new MtFullCardListViewBinding(linearLayout11, textView, textView2, constraintLayout, textView3, loadingImageView, constraintLayout2, constraintLayout3, textView4, constraintLayout4, imageView, linearLayout, linearLayout2, textView5, textView6, textView7, viewFindChildViewById, textView8, textView9, linearLayout3, textView10, imageView2, linearLayout4, cardView, imageView3, imageView4, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10, guideline11, guideline12, guideline13, guideline14, linearLayout5, imageView5, constraintLayout5, textView11, constraintLayout6, textView12, textView13, textView14, linearLayout6, textView15, linearLayout7, textView16, constraintLayout7, textView17, constraintLayout8, textView18, textView19, textView20, linearLayout8, textView21, textView22, linearLayout9, linearLayout10, linearLayout11, textView23, constraintLayout9, imageView6, textView24, textView25, textView26, textView27, textView28);
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

    public static MtFullCardListViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MtFullCardListViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.mt_full_card_list_view, viewGroup, false);
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
