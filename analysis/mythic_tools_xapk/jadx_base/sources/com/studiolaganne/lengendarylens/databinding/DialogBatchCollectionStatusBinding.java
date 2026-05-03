package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogBatchCollectionStatusBinding implements ViewBinding {
    public final ConstraintLayout addToCollectionLayout;
    public final RadioButton addToCollectionRadioButton;
    public final TextView addToCollectionTextView;
    public final LinearLayout answerLayout;
    public final TextView applyToAllHeader;
    public final RadioButton applyToAllRadioButton;
    public final TextView applyToAllSubtitle;
    public final TextView applyToAllTextView;
    public final ImageView backImage;
    public final ConstraintLayout body;
    public final MaterialButton cancelButton;
    public final ImageView cardsIDontOwnActionChevron;
    public final LinearLayout cardsIDontOwnActionLayout;
    public final TextView cardsIDontOwnActionTextView;
    public final ImageView cardsIOwnActionChevron;
    public final LinearLayout cardsIOwnActionLayout;
    public final TextView cardsIOwnActionTextView;
    public final ConstraintLayout collectionBasedActionLayout;
    public final LinearLayout currentCardInfoLayout;
    public final TextView forCardsIDontOwnHeader;
    public final TextView forCardsIOwnHeader;
    public final RadioButton grabFromCollectionRadioButton;
    public final TextView grabFromCollectionSubtitle;
    public final TextView grabFromCollectionTextView;
    public final TextView instructionsText1;
    public final TextView instructionsText2;
    public final ConstraintLayout makeAProxyLayout;
    public final RadioButton makeAProxyRadioButton;
    public final TextView makeAProxyTextView;
    public final NestedScrollView optionsScrollView;
    private final LinearLayout rootView;
    public final ConstraintLayout sameActionLayout;
    public final MaterialButton saveButton;
    public final TextView title;

    private DialogBatchCollectionStatusBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, RadioButton radioButton, TextView textView, LinearLayout linearLayout2, TextView textView2, RadioButton radioButton2, TextView textView3, TextView textView4, ImageView imageView, ConstraintLayout constraintLayout2, MaterialButton materialButton, ImageView imageView2, LinearLayout linearLayout3, TextView textView5, ImageView imageView3, LinearLayout linearLayout4, TextView textView6, ConstraintLayout constraintLayout3, LinearLayout linearLayout5, TextView textView7, TextView textView8, RadioButton radioButton3, TextView textView9, TextView textView10, TextView textView11, TextView textView12, ConstraintLayout constraintLayout4, RadioButton radioButton4, TextView textView13, NestedScrollView nestedScrollView, ConstraintLayout constraintLayout5, MaterialButton materialButton2, TextView textView14) {
        this.rootView = linearLayout;
        this.addToCollectionLayout = constraintLayout;
        this.addToCollectionRadioButton = radioButton;
        this.addToCollectionTextView = textView;
        this.answerLayout = linearLayout2;
        this.applyToAllHeader = textView2;
        this.applyToAllRadioButton = radioButton2;
        this.applyToAllSubtitle = textView3;
        this.applyToAllTextView = textView4;
        this.backImage = imageView;
        this.body = constraintLayout2;
        this.cancelButton = materialButton;
        this.cardsIDontOwnActionChevron = imageView2;
        this.cardsIDontOwnActionLayout = linearLayout3;
        this.cardsIDontOwnActionTextView = textView5;
        this.cardsIOwnActionChevron = imageView3;
        this.cardsIOwnActionLayout = linearLayout4;
        this.cardsIOwnActionTextView = textView6;
        this.collectionBasedActionLayout = constraintLayout3;
        this.currentCardInfoLayout = linearLayout5;
        this.forCardsIDontOwnHeader = textView7;
        this.forCardsIOwnHeader = textView8;
        this.grabFromCollectionRadioButton = radioButton3;
        this.grabFromCollectionSubtitle = textView9;
        this.grabFromCollectionTextView = textView10;
        this.instructionsText1 = textView11;
        this.instructionsText2 = textView12;
        this.makeAProxyLayout = constraintLayout4;
        this.makeAProxyRadioButton = radioButton4;
        this.makeAProxyTextView = textView13;
        this.optionsScrollView = nestedScrollView;
        this.sameActionLayout = constraintLayout5;
        this.saveButton = materialButton2;
        this.title = textView14;
    }

    public static DialogBatchCollectionStatusBinding bind(View view) {
        int i = R.id.addToCollectionLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.addToCollectionRadioButton;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
            if (radioButton != null) {
                i = R.id.addToCollectionTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.answerLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.applyToAllHeader;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.applyToAllRadioButton;
                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                            if (radioButton2 != null) {
                                i = R.id.applyToAllSubtitle;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.applyToAllTextView;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.backImage;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView != null) {
                                            i = R.id.body;
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout2 != null) {
                                                i = R.id.cancelButton;
                                                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                if (materialButton != null) {
                                                    i = R.id.cardsIDontOwnActionChevron;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView2 != null) {
                                                        i = R.id.cardsIDontOwnActionLayout;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.cardsIDontOwnActionTextView;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R.id.cardsIOwnActionChevron;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView3 != null) {
                                                                    i = R.id.cardsIOwnActionLayout;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout3 != null) {
                                                                        i = R.id.cardsIOwnActionTextView;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.collectionBasedActionLayout;
                                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (constraintLayout3 != null) {
                                                                                i = R.id.currentCardInfoLayout;
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout4 != null) {
                                                                                    i = R.id.forCardsIDontOwnHeader;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.forCardsIOwnHeader;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.grabFromCollectionRadioButton;
                                                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                                                            if (radioButton3 != null) {
                                                                                                i = R.id.grabFromCollectionSubtitle;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.grabFromCollectionTextView;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.instructionsText1;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView11 != null) {
                                                                                                            i = R.id.instructionsText2;
                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView12 != null) {
                                                                                                                i = R.id.makeAProxyLayout;
                                                                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (constraintLayout4 != null) {
                                                                                                                    i = R.id.makeAProxyRadioButton;
                                                                                                                    RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (radioButton4 != null) {
                                                                                                                        i = R.id.makeAProxyTextView;
                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView13 != null) {
                                                                                                                            i = R.id.optionsScrollView;
                                                                                                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (nestedScrollView != null) {
                                                                                                                                i = R.id.sameActionLayout;
                                                                                                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (constraintLayout5 != null) {
                                                                                                                                    i = R.id.saveButton;
                                                                                                                                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (materialButton2 != null) {
                                                                                                                                        i = R.id.title;
                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView14 != null) {
                                                                                                                                            return new DialogBatchCollectionStatusBinding((LinearLayout) view, constraintLayout, radioButton, textView, linearLayout, textView2, radioButton2, textView3, textView4, imageView, constraintLayout2, materialButton, imageView2, linearLayout2, textView5, imageView3, linearLayout3, textView6, constraintLayout3, linearLayout4, textView7, textView8, radioButton3, textView9, textView10, textView11, textView12, constraintLayout4, radioButton4, textView13, nestedScrollView, constraintLayout5, materialButton2, textView14);
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static DialogBatchCollectionStatusBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogBatchCollectionStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_batch_collection_status, viewGroup, false);
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
