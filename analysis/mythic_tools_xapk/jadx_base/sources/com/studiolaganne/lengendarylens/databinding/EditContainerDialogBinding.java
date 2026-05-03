package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class EditContainerDialogBinding implements ViewBinding {
    public final RadioButton addToDeckButton;
    public final LinearLayout addToExistingDeckLinearLayout;
    public final RadioButton binderButton;
    public final RadioButton boxButton;
    public final LinearLayout buttonsLinearLayout;
    public final ConstraintLayout cancelButtonLayout;
    public final TextView cancelText;
    public final EditText commanderEditText;
    public final CheckBox convertToDeckCheckBox;
    public final LinearLayout createDeckFormatLayout;
    public final LinearLayout createDeckLinearLayout;
    public final RadioButton createNewDeckButton;
    public final ImageView deckChevron;
    public final TextView deckNameTextView;
    public final LinearLayout deckRadioButtonsLinearLayout;
    public final RadioGroup deckRadioGroup;
    public final LinearLayout deckSelectionLayout;
    public final ConstraintLayout editButtonLayout;
    public final TextView editButtonText;
    public final ImageView faceCardImage;
    public final ConstraintLayout faceCardLayout;
    public final TextView faceCardheader;
    public final LinearLayout filtersLinearLayout;
    public final LinearLayout firstRowLayout;
    public final ImageView formatChevron;
    public final LinearLayout formatLayout;
    public final TextView formatTextView;
    public final ImageView listColorImageView;
    public final TextInputEditText listNameEditText;
    public final TextInputLayout listNameInputLayout;
    public final CheckBox moveToCheckBox;
    public final LinearLayout noFaceCardLinearLayout;
    public final TextView noFaceCardTextView;
    public final EditText partnerEditText;
    public final LinearLayout radioButtonsLinearLayout;
    public final RadioGroup radioGroup;
    public final ImageView removeFaceCardImageView;
    public final CheckBox replaceCardsCheckBox;
    private final ConstraintLayout rootView;
    public final ConstraintLayout selectButtonLayout;
    public final TextView selectText;
    public final View separator2;

    private EditContainerDialogBinding(ConstraintLayout constraintLayout, RadioButton radioButton, LinearLayout linearLayout, RadioButton radioButton2, RadioButton radioButton3, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, TextView textView, EditText editText, CheckBox checkBox, LinearLayout linearLayout3, LinearLayout linearLayout4, RadioButton radioButton4, ImageView imageView, TextView textView2, LinearLayout linearLayout5, RadioGroup radioGroup, LinearLayout linearLayout6, ConstraintLayout constraintLayout3, TextView textView3, ImageView imageView2, ConstraintLayout constraintLayout4, TextView textView4, LinearLayout linearLayout7, LinearLayout linearLayout8, ImageView imageView3, LinearLayout linearLayout9, TextView textView5, ImageView imageView4, TextInputEditText textInputEditText, TextInputLayout textInputLayout, CheckBox checkBox2, LinearLayout linearLayout10, TextView textView6, EditText editText2, LinearLayout linearLayout11, RadioGroup radioGroup2, ImageView imageView5, CheckBox checkBox3, ConstraintLayout constraintLayout5, TextView textView7, View view) {
        this.rootView = constraintLayout;
        this.addToDeckButton = radioButton;
        this.addToExistingDeckLinearLayout = linearLayout;
        this.binderButton = radioButton2;
        this.boxButton = radioButton3;
        this.buttonsLinearLayout = linearLayout2;
        this.cancelButtonLayout = constraintLayout2;
        this.cancelText = textView;
        this.commanderEditText = editText;
        this.convertToDeckCheckBox = checkBox;
        this.createDeckFormatLayout = linearLayout3;
        this.createDeckLinearLayout = linearLayout4;
        this.createNewDeckButton = radioButton4;
        this.deckChevron = imageView;
        this.deckNameTextView = textView2;
        this.deckRadioButtonsLinearLayout = linearLayout5;
        this.deckRadioGroup = radioGroup;
        this.deckSelectionLayout = linearLayout6;
        this.editButtonLayout = constraintLayout3;
        this.editButtonText = textView3;
        this.faceCardImage = imageView2;
        this.faceCardLayout = constraintLayout4;
        this.faceCardheader = textView4;
        this.filtersLinearLayout = linearLayout7;
        this.firstRowLayout = linearLayout8;
        this.formatChevron = imageView3;
        this.formatLayout = linearLayout9;
        this.formatTextView = textView5;
        this.listColorImageView = imageView4;
        this.listNameEditText = textInputEditText;
        this.listNameInputLayout = textInputLayout;
        this.moveToCheckBox = checkBox2;
        this.noFaceCardLinearLayout = linearLayout10;
        this.noFaceCardTextView = textView6;
        this.partnerEditText = editText2;
        this.radioButtonsLinearLayout = linearLayout11;
        this.radioGroup = radioGroup2;
        this.removeFaceCardImageView = imageView5;
        this.replaceCardsCheckBox = checkBox3;
        this.selectButtonLayout = constraintLayout5;
        this.selectText = textView7;
        this.separator2 = view;
    }

    public static EditContainerDialogBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.addToDeckButton;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
        if (radioButton != null) {
            i = R.id.addToExistingDeckLinearLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.binderButton;
                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                if (radioButton2 != null) {
                    i = R.id.boxButton;
                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, i);
                    if (radioButton3 != null) {
                        i = R.id.buttonsLinearLayout;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R.id.cancelButtonLayout;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                i = R.id.cancelText;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.commanderEditText;
                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText != null) {
                                        i = R.id.convertToDeckCheckBox;
                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                                        if (checkBox != null) {
                                            i = R.id.createDeckFormatLayout;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout3 != null) {
                                                i = R.id.createDeckLinearLayout;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout4 != null) {
                                                    i = R.id.createNewDeckButton;
                                                    RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                    if (radioButton4 != null) {
                                                        i = R.id.deckChevron;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView != null) {
                                                            i = R.id.deckNameTextView;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView2 != null) {
                                                                i = R.id.deckRadioButtonsLinearLayout;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout5 != null) {
                                                                    i = R.id.deckRadioGroup;
                                                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                                                                    if (radioGroup != null) {
                                                                        i = R.id.deckSelectionLayout;
                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout6 != null) {
                                                                            i = R.id.editButtonLayout;
                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (constraintLayout2 != null) {
                                                                                i = R.id.editButtonText;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView3 != null) {
                                                                                    i = R.id.faceCardImage;
                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (imageView2 != null) {
                                                                                        i = R.id.faceCardLayout;
                                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (constraintLayout3 != null) {
                                                                                            i = R.id.faceCardheader;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.filtersLinearLayout;
                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (linearLayout7 != null) {
                                                                                                    i = R.id.firstRowLayout;
                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout8 != null) {
                                                                                                        i = R.id.formatChevron;
                                                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (imageView3 != null) {
                                                                                                            i = R.id.formatLayout;
                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (linearLayout9 != null) {
                                                                                                                i = R.id.formatTextView;
                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView5 != null) {
                                                                                                                    i = R.id.listColorImageView;
                                                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (imageView4 != null) {
                                                                                                                        i = R.id.listNameEditText;
                                                                                                                        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textInputEditText != null) {
                                                                                                                            i = R.id.listNameInputLayout;
                                                                                                                            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textInputLayout != null) {
                                                                                                                                i = R.id.moveToCheckBox;
                                                                                                                                CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (checkBox2 != null) {
                                                                                                                                    i = R.id.noFaceCardLinearLayout;
                                                                                                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (linearLayout10 != null) {
                                                                                                                                        i = R.id.noFaceCardTextView;
                                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView6 != null) {
                                                                                                                                            i = R.id.partnerEditText;
                                                                                                                                            EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (editText2 != null) {
                                                                                                                                                i = R.id.radioButtonsLinearLayout;
                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                    i = R.id.radioGroup;
                                                                                                                                                    RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (radioGroup2 != null) {
                                                                                                                                                        i = R.id.removeFaceCardImageView;
                                                                                                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (imageView5 != null) {
                                                                                                                                                            i = R.id.replaceCardsCheckBox;
                                                                                                                                                            CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (checkBox3 != null) {
                                                                                                                                                                i = R.id.selectButtonLayout;
                                                                                                                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (constraintLayout4 != null) {
                                                                                                                                                                    i = R.id.selectText;
                                                                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView7 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator2))) != null) {
                                                                                                                                                                        return new EditContainerDialogBinding((ConstraintLayout) view, radioButton, linearLayout, radioButton2, radioButton3, linearLayout2, constraintLayout, textView, editText, checkBox, linearLayout3, linearLayout4, radioButton4, imageView, textView2, linearLayout5, radioGroup, linearLayout6, constraintLayout2, textView3, imageView2, constraintLayout3, textView4, linearLayout7, linearLayout8, imageView3, linearLayout9, textView5, imageView4, textInputEditText, textInputLayout, checkBox2, linearLayout10, textView6, editText2, linearLayout11, radioGroup2, imageView5, checkBox3, constraintLayout4, textView7, viewFindChildViewById);
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static EditContainerDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EditContainerDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.edit_container_dialog, viewGroup, false);
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
