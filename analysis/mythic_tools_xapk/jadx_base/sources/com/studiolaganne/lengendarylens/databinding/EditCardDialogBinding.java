package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class EditCardDialogBinding implements ViewBinding {
    public final CheckBox alteredCheckbox;
    public final TextView applyFooter;
    public final TextView applyHeader;
    public final LinearLayout applyLayout;
    public final TextView applyValueLabel;
    public final LinearLayout buttonsLinearLayout;
    public final ConstraintLayout cancelButtonLayout;
    public final TextView cancelText;
    public final LoadingImageView cardImage;
    public final ConstraintLayout cardImageContainer;
    public final LinearLayout cardLinearLayout;
    public final ImageView conditionChevron;
    public final TextView conditionHeaderLabel;
    public final LinearLayout conditionLayout;
    public final LinearLayout conditionSelectionLayout;
    public final TextView conditionTextView;
    public final TextView connectingTextView;
    public final ScrollView contentScrollView;
    public final TextView deckListHeader;
    public final LinearLayout deckListSelectionLayout;
    public final ConstraintLayout editButtonLayout;
    public final TextView editButtonText;
    public final TextView editCardSetHeader;
    public final TextView editCardTitle;
    public final TextView extrasHeader;
    public final LinearLayout extrasLinearLayout;
    public final ImageView finishChevron;
    public final TextView finishHeaderLabel;
    public final LinearLayout finishLayout;
    public final LinearLayout finishSelectionLayout;
    public final CardView flagContainer;
    public final ImageView flagImage;
    public final ImageView foilEffectImage;
    public final ImageView foilImage;
    public final ImageView langChevron;
    public final TextView languageHeaderLabel;
    public final LinearLayout languageLayout;
    public final LinearLayout languageSelectionLayout;
    public final LottieAnimationView loadingAnimationView;
    public final ConstraintLayout mainConstraintLayout;
    public final RadioButton mainDeckRadioButton;
    public final RadioButton maybeboardRadioButton;
    public final Guideline middleGuideline;
    public final TextView minusApplyLabel;
    public final TextView minusQtyLabel;
    public final CheckBox misprintCheckbox;
    public final ConstraintLayout overlay;
    public final TextView plusApplyLabel;
    public final TextView plusQtyLabel;
    public final CheckBox proxyCheckbox;
    public final EditText purchasePriceEditText;
    public final TextView purchasePriceHeader;
    public final TextView purchasePriceSetter;
    public final TextView qtyHeaderLabel;
    public final TextView qtyLabel;
    public final LinearLayout qtyLayout;
    public final LinearLayout rightLayout;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final TextView selectedCollectorNumberTextView;
    public final TextView selectedConditionTextView;
    public final TextView selectedFinishTextView;
    public final TextView selectedLanguageTextView;
    public final TextView selectedSetCodeTextView;
    public final TextView selectedSetNameTextView;
    public final View separator2;
    public final ImageView setChevron;
    public final ImageView setImage;
    public final LinearLayout setSelectionLayout;
    public final RadioButton sideboardRadioButton;
    public final CheckBox signedCheckbox;

    private EditCardDialogBinding(ConstraintLayout constraintLayout, CheckBox checkBox, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, TextView textView4, LoadingImageView loadingImageView, ConstraintLayout constraintLayout3, LinearLayout linearLayout3, ImageView imageView, TextView textView5, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView6, TextView textView7, ScrollView scrollView, TextView textView8, LinearLayout linearLayout6, ConstraintLayout constraintLayout4, TextView textView9, TextView textView10, TextView textView11, TextView textView12, LinearLayout linearLayout7, ImageView imageView2, TextView textView13, LinearLayout linearLayout8, LinearLayout linearLayout9, CardView cardView, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView14, LinearLayout linearLayout10, LinearLayout linearLayout11, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout5, RadioButton radioButton, RadioButton radioButton2, Guideline guideline, TextView textView15, TextView textView16, CheckBox checkBox2, ConstraintLayout constraintLayout6, TextView textView17, TextView textView18, CheckBox checkBox3, EditText editText, TextView textView19, TextView textView20, TextView textView21, TextView textView22, LinearLayout linearLayout12, LinearLayout linearLayout13, ConstraintLayout constraintLayout7, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, View view, ImageView imageView7, ImageView imageView8, LinearLayout linearLayout14, RadioButton radioButton3, CheckBox checkBox4) {
        this.rootView = constraintLayout;
        this.alteredCheckbox = checkBox;
        this.applyFooter = textView;
        this.applyHeader = textView2;
        this.applyLayout = linearLayout;
        this.applyValueLabel = textView3;
        this.buttonsLinearLayout = linearLayout2;
        this.cancelButtonLayout = constraintLayout2;
        this.cancelText = textView4;
        this.cardImage = loadingImageView;
        this.cardImageContainer = constraintLayout3;
        this.cardLinearLayout = linearLayout3;
        this.conditionChevron = imageView;
        this.conditionHeaderLabel = textView5;
        this.conditionLayout = linearLayout4;
        this.conditionSelectionLayout = linearLayout5;
        this.conditionTextView = textView6;
        this.connectingTextView = textView7;
        this.contentScrollView = scrollView;
        this.deckListHeader = textView8;
        this.deckListSelectionLayout = linearLayout6;
        this.editButtonLayout = constraintLayout4;
        this.editButtonText = textView9;
        this.editCardSetHeader = textView10;
        this.editCardTitle = textView11;
        this.extrasHeader = textView12;
        this.extrasLinearLayout = linearLayout7;
        this.finishChevron = imageView2;
        this.finishHeaderLabel = textView13;
        this.finishLayout = linearLayout8;
        this.finishSelectionLayout = linearLayout9;
        this.flagContainer = cardView;
        this.flagImage = imageView3;
        this.foilEffectImage = imageView4;
        this.foilImage = imageView5;
        this.langChevron = imageView6;
        this.languageHeaderLabel = textView14;
        this.languageLayout = linearLayout10;
        this.languageSelectionLayout = linearLayout11;
        this.loadingAnimationView = lottieAnimationView;
        this.mainConstraintLayout = constraintLayout5;
        this.mainDeckRadioButton = radioButton;
        this.maybeboardRadioButton = radioButton2;
        this.middleGuideline = guideline;
        this.minusApplyLabel = textView15;
        this.minusQtyLabel = textView16;
        this.misprintCheckbox = checkBox2;
        this.overlay = constraintLayout6;
        this.plusApplyLabel = textView17;
        this.plusQtyLabel = textView18;
        this.proxyCheckbox = checkBox3;
        this.purchasePriceEditText = editText;
        this.purchasePriceHeader = textView19;
        this.purchasePriceSetter = textView20;
        this.qtyHeaderLabel = textView21;
        this.qtyLabel = textView22;
        this.qtyLayout = linearLayout12;
        this.rightLayout = linearLayout13;
        this.root = constraintLayout7;
        this.selectedCollectorNumberTextView = textView23;
        this.selectedConditionTextView = textView24;
        this.selectedFinishTextView = textView25;
        this.selectedLanguageTextView = textView26;
        this.selectedSetCodeTextView = textView27;
        this.selectedSetNameTextView = textView28;
        this.separator2 = view;
        this.setChevron = imageView7;
        this.setImage = imageView8;
        this.setSelectionLayout = linearLayout14;
        this.sideboardRadioButton = radioButton3;
        this.signedCheckbox = checkBox4;
    }

    public static EditCardDialogBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.alteredCheckbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
        if (checkBox != null) {
            i = R.id.applyFooter;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.applyHeader;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.applyLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.applyValueLabel;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.buttonsLinearLayout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.cancelButtonLayout;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout != null) {
                                    i = R.id.cancelText;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.cardImage;
                                        LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
                                        if (loadingImageView != null) {
                                            i = R.id.cardImageContainer;
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout2 != null) {
                                                i = R.id.cardLinearLayout;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout3 != null) {
                                                    i = R.id.conditionChevron;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView != null) {
                                                        i = R.id.conditionHeaderLabel;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.conditionLayout;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout4 != null) {
                                                                i = R.id.conditionSelectionLayout;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout5 != null) {
                                                                    i = R.id.conditionTextView;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.connectingTextView;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.contentScrollView;
                                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                            if (scrollView != null) {
                                                                                i = R.id.deckListHeader;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.deckListSelectionLayout;
                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout6 != null) {
                                                                                        i = R.id.editButtonLayout;
                                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (constraintLayout3 != null) {
                                                                                            i = R.id.editButtonText;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.editCardSetHeader;
                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView10 != null) {
                                                                                                    i = R.id.editCardTitle;
                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView11 != null) {
                                                                                                        i = R.id.extrasHeader;
                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView12 != null) {
                                                                                                            i = R.id.extrasLinearLayout;
                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (linearLayout7 != null) {
                                                                                                                i = R.id.finishChevron;
                                                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (imageView2 != null) {
                                                                                                                    i = R.id.finishHeaderLabel;
                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView13 != null) {
                                                                                                                        i = R.id.finishLayout;
                                                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (linearLayout8 != null) {
                                                                                                                            i = R.id.finishSelectionLayout;
                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                i = R.id.flag_container;
                                                                                                                                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (cardView != null) {
                                                                                                                                    i = R.id.flag_image;
                                                                                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (imageView3 != null) {
                                                                                                                                        i = R.id.foilEffectImage;
                                                                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (imageView4 != null) {
                                                                                                                                            i = R.id.foil_image;
                                                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (imageView5 != null) {
                                                                                                                                                i = R.id.langChevron;
                                                                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (imageView6 != null) {
                                                                                                                                                    i = R.id.languageHeaderLabel;
                                                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView14 != null) {
                                                                                                                                                        i = R.id.languageLayout;
                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                            i = R.id.languageSelectionLayout;
                                                                                                                                                            LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (linearLayout11 != null) {
                                                                                                                                                                i = R.id.loadingAnimationView;
                                                                                                                                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (lottieAnimationView != null) {
                                                                                                                                                                    i = R.id.mainConstraintLayout;
                                                                                                                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (constraintLayout4 != null) {
                                                                                                                                                                        i = R.id.mainDeckRadioButton;
                                                                                                                                                                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (radioButton != null) {
                                                                                                                                                                            i = R.id.maybeboardRadioButton;
                                                                                                                                                                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (radioButton2 != null) {
                                                                                                                                                                                i = R.id.middleGuideline;
                                                                                                                                                                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (guideline != null) {
                                                                                                                                                                                    i = R.id.minusApplyLabel;
                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                        i = R.id.minusQtyLabel;
                                                                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                                                            i = R.id.misprintCheckbox;
                                                                                                                                                                                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (checkBox2 != null) {
                                                                                                                                                                                                i = R.id.overlay;
                                                                                                                                                                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (constraintLayout5 != null) {
                                                                                                                                                                                                    i = R.id.plusApplyLabel;
                                                                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                                                                        i = R.id.plusQtyLabel;
                                                                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                                                                            i = R.id.proxyCheckbox;
                                                                                                                                                                                                            CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (checkBox3 != null) {
                                                                                                                                                                                                                i = R.id.purchasePriceEditText;
                                                                                                                                                                                                                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (editText != null) {
                                                                                                                                                                                                                    i = R.id.purchasePriceHeader;
                                                                                                                                                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (textView19 != null) {
                                                                                                                                                                                                                        i = R.id.purchasePriceSetter;
                                                                                                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                                                                                            i = R.id.qtyHeaderLabel;
                                                                                                                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                                                                                i = R.id.qtyLabel;
                                                                                                                                                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                if (textView22 != null) {
                                                                                                                                                                                                                                    i = R.id.qtyLayout;
                                                                                                                                                                                                                                    LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                    if (linearLayout12 != null) {
                                                                                                                                                                                                                                        i = R.id.rightLayout;
                                                                                                                                                                                                                                        LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                        if (linearLayout13 != null) {
                                                                                                                                                                                                                                            i = R.id.root;
                                                                                                                                                                                                                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                            if (constraintLayout6 != null) {
                                                                                                                                                                                                                                                i = R.id.selectedCollectorNumberTextView;
                                                                                                                                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                                                                                                    i = R.id.selectedConditionTextView;
                                                                                                                                                                                                                                                    TextView textView24 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                    if (textView24 != null) {
                                                                                                                                                                                                                                                        i = R.id.selectedFinishTextView;
                                                                                                                                                                                                                                                        TextView textView25 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                        if (textView25 != null) {
                                                                                                                                                                                                                                                            i = R.id.selectedLanguageTextView;
                                                                                                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                                                                                                i = R.id.selectedSetCodeTextView;
                                                                                                                                                                                                                                                                TextView textView27 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                if (textView27 != null) {
                                                                                                                                                                                                                                                                    i = R.id.selectedSetNameTextView;
                                                                                                                                                                                                                                                                    TextView textView28 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                    if (textView28 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator2))) != null) {
                                                                                                                                                                                                                                                                        i = R.id.setChevron;
                                                                                                                                                                                                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                        if (imageView7 != null) {
                                                                                                                                                                                                                                                                            i = R.id.set_image;
                                                                                                                                                                                                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                            if (imageView8 != null) {
                                                                                                                                                                                                                                                                                i = R.id.setSelectionLayout;
                                                                                                                                                                                                                                                                                LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                if (linearLayout14 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.sideboardRadioButton;
                                                                                                                                                                                                                                                                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                    if (radioButton3 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.signedCheckbox;
                                                                                                                                                                                                                                                                                        CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                                        if (checkBox4 != null) {
                                                                                                                                                                                                                                                                                            return new EditCardDialogBinding((ConstraintLayout) view, checkBox, textView, textView2, linearLayout, textView3, linearLayout2, constraintLayout, textView4, loadingImageView, constraintLayout2, linearLayout3, imageView, textView5, linearLayout4, linearLayout5, textView6, textView7, scrollView, textView8, linearLayout6, constraintLayout3, textView9, textView10, textView11, textView12, linearLayout7, imageView2, textView13, linearLayout8, linearLayout9, cardView, imageView3, imageView4, imageView5, imageView6, textView14, linearLayout10, linearLayout11, lottieAnimationView, constraintLayout4, radioButton, radioButton2, guideline, textView15, textView16, checkBox2, constraintLayout5, textView17, textView18, checkBox3, editText, textView19, textView20, textView21, textView22, linearLayout12, linearLayout13, constraintLayout6, textView23, textView24, textView25, textView26, textView27, textView28, viewFindChildViewById, imageView7, imageView8, linearLayout14, radioButton3, checkBox4);
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

    public static EditCardDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EditCardDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.edit_card_dialog, viewGroup, false);
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
