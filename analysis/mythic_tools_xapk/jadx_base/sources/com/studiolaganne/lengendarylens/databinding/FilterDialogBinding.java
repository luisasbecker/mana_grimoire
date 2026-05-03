package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FilterDialogBinding implements ViewBinding {
    public final ImageView bManaAdd;
    public final LinearLayout buttonsLinearLayout;
    public final ImageView cManaAdd;
    public final ImageView clearFilterValue;
    public final TextView filterTitleTextView;
    public final EditText filterValueEditText;
    public final LinearLayout filterValueLinearLayout;
    public final TextView filterValueTextView;
    public final LinearLayout filtersLinearLayout;
    public final FlexboxLayout flexboxLayout;
    public final ImageView gManaAdd;
    public final Spinner includeSpinner;
    public final LinearLayout manaSymbolsLayout1;
    public final LinearLayout manaSymbolsLayout2;
    public final MaterialButton negativeButton;
    public final ImageView oneManaAdd;
    public final Spinner operatorSpinner;
    public final MaterialButton positiveButton;
    public final ImageView rManaAdd;
    public final Spinner raritySpinner;
    private final ConstraintLayout rootView;
    public final View separator1;
    public final View separator2;
    public final AutoCompleteTextView setTextView;
    public final TextView tagArtifact;
    public final TextView tagBasic;
    public final TextView tagBattle;
    public final TextView tagCreature;
    public final TextView tagDungeon;
    public final TextView tagEmblem;
    public final TextView tagEnchantment;
    public final TextView tagInstant;
    public final TextView tagLand;
    public final TextView tagLegendary;
    public final TextView tagPlaneswalker;
    public final TextView tagSnow;
    public final TextView tagSorcery;
    public final TextView tagToken;
    public final TextView tagTribal;
    public final ImageView uManaAdd;
    public final ImageView wManaAdd;
    public final ImageView xManaAdd;
    public final ImageView zeroManaAdd;

    private FilterDialogBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, ImageView imageView3, TextView textView, EditText editText, LinearLayout linearLayout2, TextView textView2, LinearLayout linearLayout3, FlexboxLayout flexboxLayout, ImageView imageView4, Spinner spinner, LinearLayout linearLayout4, LinearLayout linearLayout5, MaterialButton materialButton, ImageView imageView5, Spinner spinner2, MaterialButton materialButton2, ImageView imageView6, Spinner spinner3, View view, View view2, AutoCompleteTextView autoCompleteTextView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10) {
        this.rootView = constraintLayout;
        this.bManaAdd = imageView;
        this.buttonsLinearLayout = linearLayout;
        this.cManaAdd = imageView2;
        this.clearFilterValue = imageView3;
        this.filterTitleTextView = textView;
        this.filterValueEditText = editText;
        this.filterValueLinearLayout = linearLayout2;
        this.filterValueTextView = textView2;
        this.filtersLinearLayout = linearLayout3;
        this.flexboxLayout = flexboxLayout;
        this.gManaAdd = imageView4;
        this.includeSpinner = spinner;
        this.manaSymbolsLayout1 = linearLayout4;
        this.manaSymbolsLayout2 = linearLayout5;
        this.negativeButton = materialButton;
        this.oneManaAdd = imageView5;
        this.operatorSpinner = spinner2;
        this.positiveButton = materialButton2;
        this.rManaAdd = imageView6;
        this.raritySpinner = spinner3;
        this.separator1 = view;
        this.separator2 = view2;
        this.setTextView = autoCompleteTextView;
        this.tagArtifact = textView3;
        this.tagBasic = textView4;
        this.tagBattle = textView5;
        this.tagCreature = textView6;
        this.tagDungeon = textView7;
        this.tagEmblem = textView8;
        this.tagEnchantment = textView9;
        this.tagInstant = textView10;
        this.tagLand = textView11;
        this.tagLegendary = textView12;
        this.tagPlaneswalker = textView13;
        this.tagSnow = textView14;
        this.tagSorcery = textView15;
        this.tagToken = textView16;
        this.tagTribal = textView17;
        this.uManaAdd = imageView7;
        this.wManaAdd = imageView8;
        this.xManaAdd = imageView9;
        this.zeroManaAdd = imageView10;
    }

    public static FilterDialogBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.bManaAdd;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.buttonsLinearLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.cManaAdd;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.clearFilterValue;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.filterTitleTextView;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.filterValueEditText;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText != null) {
                                i = R.id.filterValueLinearLayout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = R.id.filterValueTextView;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.filtersLinearLayout;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.flexboxLayout;
                                            FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view, i);
                                            if (flexboxLayout != null) {
                                                i = R.id.gManaAdd;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView4 != null) {
                                                    i = R.id.includeSpinner;
                                                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, i);
                                                    if (spinner != null) {
                                                        i = R.id.manaSymbolsLayout1;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout4 != null) {
                                                            i = R.id.manaSymbolsLayout2;
                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout5 != null) {
                                                                i = R.id.negative_button;
                                                                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                                if (materialButton != null) {
                                                                    i = R.id.oneManaAdd;
                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView5 != null) {
                                                                        i = R.id.operatorSpinner;
                                                                        Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, i);
                                                                        if (spinner2 != null) {
                                                                            i = R.id.positive_button;
                                                                            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                                            if (materialButton2 != null) {
                                                                                i = R.id.rManaAdd;
                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView6 != null) {
                                                                                    i = R.id.raritySpinner;
                                                                                    Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(view, i);
                                                                                    if (spinner3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.separator2))) != null) {
                                                                                        i = R.id.setTextView;
                                                                                        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (autoCompleteTextView != null) {
                                                                                            i = R.id.tagArtifact;
                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView3 != null) {
                                                                                                i = R.id.tagBasic;
                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView4 != null) {
                                                                                                    i = R.id.tagBattle;
                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView5 != null) {
                                                                                                        i = R.id.tagCreature;
                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView6 != null) {
                                                                                                            i = R.id.tagDungeon;
                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView7 != null) {
                                                                                                                i = R.id.tagEmblem;
                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView8 != null) {
                                                                                                                    i = R.id.tagEnchantment;
                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView9 != null) {
                                                                                                                        i = R.id.tagInstant;
                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView10 != null) {
                                                                                                                            i = R.id.tagLand;
                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView11 != null) {
                                                                                                                                i = R.id.tagLegendary;
                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView12 != null) {
                                                                                                                                    i = R.id.tagPlaneswalker;
                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView13 != null) {
                                                                                                                                        i = R.id.tagSnow;
                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView14 != null) {
                                                                                                                                            i = R.id.tagSorcery;
                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView15 != null) {
                                                                                                                                                i = R.id.tagToken;
                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView16 != null) {
                                                                                                                                                    i = R.id.tagTribal;
                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                        i = R.id.uManaAdd;
                                                                                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (imageView7 != null) {
                                                                                                                                                            i = R.id.wManaAdd;
                                                                                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (imageView8 != null) {
                                                                                                                                                                i = R.id.xManaAdd;
                                                                                                                                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (imageView9 != null) {
                                                                                                                                                                    i = R.id.zeroManaAdd;
                                                                                                                                                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (imageView10 != null) {
                                                                                                                                                                        return new FilterDialogBinding((ConstraintLayout) view, imageView, linearLayout, imageView2, imageView3, textView, editText, linearLayout2, textView2, linearLayout3, flexboxLayout, imageView4, spinner, linearLayout4, linearLayout5, materialButton, imageView5, spinner2, materialButton2, imageView6, spinner3, viewFindChildViewById, viewFindChildViewById2, autoCompleteTextView, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, imageView7, imageView8, imageView9, imageView10);
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

    public static FilterDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FilterDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.filter_dialog, viewGroup, false);
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
