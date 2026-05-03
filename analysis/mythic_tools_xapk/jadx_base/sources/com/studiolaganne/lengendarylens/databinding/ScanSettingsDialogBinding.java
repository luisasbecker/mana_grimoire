package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ScanSettingsDialogBinding implements ViewBinding {
    public final ConstraintLayout cancelButtonLayout;
    public final TextView cancelText;
    public final TextView dialogTitleTextView;
    public final ImageView finishChevron;
    public final TextView finishOverrideLabel;
    public final LinearLayout finishOverrideLayout;
    public final SwitchMaterial finishOverrideSwitch;
    public final LinearLayout finishSelectionLayout;
    public final TextInputEditText fixedPriceEditText;
    public final TextInputLayout fixedPriceInputLayout;
    public final CardView flagContainer;
    public final ImageView flagImage;
    public final ImageView foilImage;
    public final TextView highPriceBeepLabel;
    public final LinearLayout highPriceBeepLayout;
    public final SwitchMaterial highPriceBeepSwitch;
    public final ImageView langChevron;
    public final TextView languageOverrideLabel;
    public final LinearLayout languageOverrideLayout;
    public final SwitchMaterial languageOverrideSwitch;
    public final LinearLayout languageSelectionLayout;
    public final LinearLayout mainLayout;
    public final TextInputEditText priceThresholdEditText;
    public final TextInputLayout priceThresholdInputLayout;
    public final TextView priceThresholdLabel;
    public final LinearLayout priceThresholdLayout;
    public final TextView purchasePriceLabel;
    public final LinearLayout purchasePriceLayout;
    public final LinearLayout purchasePriceOptionsLayout;
    public final RadioGroup purchasePriceRadioGroup;
    public final SwitchMaterial purchasePriceSwitch;
    public final RadioButton radioCurrentPrice;
    public final RadioButton radioFixedPrice;
    private final ConstraintLayout rootView;
    public final ConstraintLayout saveButtonLayout;
    public final TextView saveButtonText;
    public final TextView selectedFinishTextView;
    public final TextView selectedLanguageTextView;
    public final View separator1;
    public final View separator2;
    public final TextView setOverrideLabel;
    public final LinearLayout setOverrideLayout;
    public final SwitchMaterial setOverrideSwitch;
    public final AutoCompleteTextView setTextView;
    public final ScrollView settingsScrollView;

    private ScanSettingsDialogBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ImageView imageView, TextView textView3, LinearLayout linearLayout, SwitchMaterial switchMaterial, LinearLayout linearLayout2, TextInputEditText textInputEditText, TextInputLayout textInputLayout, CardView cardView, ImageView imageView2, ImageView imageView3, TextView textView4, LinearLayout linearLayout3, SwitchMaterial switchMaterial2, ImageView imageView4, TextView textView5, LinearLayout linearLayout4, SwitchMaterial switchMaterial3, LinearLayout linearLayout5, LinearLayout linearLayout6, TextInputEditText textInputEditText2, TextInputLayout textInputLayout2, TextView textView6, LinearLayout linearLayout7, TextView textView7, LinearLayout linearLayout8, LinearLayout linearLayout9, RadioGroup radioGroup, SwitchMaterial switchMaterial4, RadioButton radioButton, RadioButton radioButton2, ConstraintLayout constraintLayout3, TextView textView8, TextView textView9, TextView textView10, View view, View view2, TextView textView11, LinearLayout linearLayout10, SwitchMaterial switchMaterial5, AutoCompleteTextView autoCompleteTextView, ScrollView scrollView) {
        this.rootView = constraintLayout;
        this.cancelButtonLayout = constraintLayout2;
        this.cancelText = textView;
        this.dialogTitleTextView = textView2;
        this.finishChevron = imageView;
        this.finishOverrideLabel = textView3;
        this.finishOverrideLayout = linearLayout;
        this.finishOverrideSwitch = switchMaterial;
        this.finishSelectionLayout = linearLayout2;
        this.fixedPriceEditText = textInputEditText;
        this.fixedPriceInputLayout = textInputLayout;
        this.flagContainer = cardView;
        this.flagImage = imageView2;
        this.foilImage = imageView3;
        this.highPriceBeepLabel = textView4;
        this.highPriceBeepLayout = linearLayout3;
        this.highPriceBeepSwitch = switchMaterial2;
        this.langChevron = imageView4;
        this.languageOverrideLabel = textView5;
        this.languageOverrideLayout = linearLayout4;
        this.languageOverrideSwitch = switchMaterial3;
        this.languageSelectionLayout = linearLayout5;
        this.mainLayout = linearLayout6;
        this.priceThresholdEditText = textInputEditText2;
        this.priceThresholdInputLayout = textInputLayout2;
        this.priceThresholdLabel = textView6;
        this.priceThresholdLayout = linearLayout7;
        this.purchasePriceLabel = textView7;
        this.purchasePriceLayout = linearLayout8;
        this.purchasePriceOptionsLayout = linearLayout9;
        this.purchasePriceRadioGroup = radioGroup;
        this.purchasePriceSwitch = switchMaterial4;
        this.radioCurrentPrice = radioButton;
        this.radioFixedPrice = radioButton2;
        this.saveButtonLayout = constraintLayout3;
        this.saveButtonText = textView8;
        this.selectedFinishTextView = textView9;
        this.selectedLanguageTextView = textView10;
        this.separator1 = view;
        this.separator2 = view2;
        this.setOverrideLabel = textView11;
        this.setOverrideLayout = linearLayout10;
        this.setOverrideSwitch = switchMaterial5;
        this.setTextView = autoCompleteTextView;
        this.settingsScrollView = scrollView;
    }

    public static ScanSettingsDialogBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.cancelButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.cancelText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.dialogTitleTextView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.finishChevron;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.finishOverrideLabel;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.finishOverrideLayout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.finishOverrideSwitch;
                                SwitchMaterial switchMaterial = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
                                if (switchMaterial != null) {
                                    i = R.id.finishSelectionLayout;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.fixedPriceEditText;
                                        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, i);
                                        if (textInputEditText != null) {
                                            i = R.id.fixedPriceInputLayout;
                                            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                            if (textInputLayout != null) {
                                                i = R.id.flag_container;
                                                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                                                if (cardView != null) {
                                                    i = R.id.flag_image;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView2 != null) {
                                                        i = R.id.foil_image;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView3 != null) {
                                                            i = R.id.highPriceBeepLabel;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.highPriceBeepLayout;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.highPriceBeepSwitch;
                                                                    SwitchMaterial switchMaterial2 = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
                                                                    if (switchMaterial2 != null) {
                                                                        i = R.id.langChevron;
                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView4 != null) {
                                                                            i = R.id.languageOverrideLabel;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView5 != null) {
                                                                                i = R.id.languageOverrideLayout;
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout4 != null) {
                                                                                    i = R.id.languageOverrideSwitch;
                                                                                    SwitchMaterial switchMaterial3 = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
                                                                                    if (switchMaterial3 != null) {
                                                                                        i = R.id.languageSelectionLayout;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout5 != null) {
                                                                                            i = R.id.mainLayout;
                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout6 != null) {
                                                                                                i = R.id.priceThresholdEditText;
                                                                                                TextInputEditText textInputEditText2 = (TextInputEditText) ViewBindings.findChildViewById(view, i);
                                                                                                if (textInputEditText2 != null) {
                                                                                                    i = R.id.priceThresholdInputLayout;
                                                                                                    TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textInputLayout2 != null) {
                                                                                                        i = R.id.priceThresholdLabel;
                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView6 != null) {
                                                                                                            i = R.id.priceThresholdLayout;
                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (linearLayout7 != null) {
                                                                                                                i = R.id.purchasePriceLabel;
                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView7 != null) {
                                                                                                                    i = R.id.purchasePriceLayout;
                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (linearLayout8 != null) {
                                                                                                                        i = R.id.purchasePriceOptionsLayout;
                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (linearLayout9 != null) {
                                                                                                                            i = R.id.purchasePriceRadioGroup;
                                                                                                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (radioGroup != null) {
                                                                                                                                i = R.id.purchasePriceSwitch;
                                                                                                                                SwitchMaterial switchMaterial4 = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (switchMaterial4 != null) {
                                                                                                                                    i = R.id.radioCurrentPrice;
                                                                                                                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (radioButton != null) {
                                                                                                                                        i = R.id.radioFixedPrice;
                                                                                                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (radioButton2 != null) {
                                                                                                                                            i = R.id.saveButtonLayout;
                                                                                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (constraintLayout2 != null) {
                                                                                                                                                i = R.id.saveButtonText;
                                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView8 != null) {
                                                                                                                                                    i = R.id.selectedFinishTextView;
                                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView9 != null) {
                                                                                                                                                        i = R.id.selectedLanguageTextView;
                                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView10 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.separator2))) != null) {
                                                                                                                                                            i = R.id.setOverrideLabel;
                                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (textView11 != null) {
                                                                                                                                                                i = R.id.setOverrideLayout;
                                                                                                                                                                LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (linearLayout10 != null) {
                                                                                                                                                                    i = R.id.setOverrideSwitch;
                                                                                                                                                                    SwitchMaterial switchMaterial5 = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (switchMaterial5 != null) {
                                                                                                                                                                        i = R.id.setTextView;
                                                                                                                                                                        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (autoCompleteTextView != null) {
                                                                                                                                                                            i = R.id.settingsScrollView;
                                                                                                                                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (scrollView != null) {
                                                                                                                                                                                return new ScanSettingsDialogBinding((ConstraintLayout) view, constraintLayout, textView, textView2, imageView, textView3, linearLayout, switchMaterial, linearLayout2, textInputEditText, textInputLayout, cardView, imageView2, imageView3, textView4, linearLayout3, switchMaterial2, imageView4, textView5, linearLayout4, switchMaterial3, linearLayout5, linearLayout6, textInputEditText2, textInputLayout2, textView6, linearLayout7, textView7, linearLayout8, linearLayout9, radioGroup, switchMaterial4, radioButton, radioButton2, constraintLayout2, textView8, textView9, textView10, viewFindChildViewById, viewFindChildViewById2, textView11, linearLayout10, switchMaterial5, autoCompleteTextView, scrollView);
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

    public static ScanSettingsDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ScanSettingsDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.scan_settings_dialog, viewGroup, false);
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
