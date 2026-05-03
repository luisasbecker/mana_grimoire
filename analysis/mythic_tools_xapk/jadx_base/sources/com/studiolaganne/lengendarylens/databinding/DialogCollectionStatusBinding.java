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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogCollectionStatusBinding implements ViewBinding {
    public final ImageView addToCollectionIcon;
    public final ConstraintLayout addToCollectionLayout;
    public final RadioButton addToCollectionRadioButton;
    public final TextView addToCollectionSubtitle;
    public final TextView addToCollectionTextView;
    public final LinearLayout answerLayout;
    public final ImageView backImage;
    public final ConstraintLayout body;
    public final MaterialButton cancelButton;
    public final LinearLayout cardInfoLayout;
    public final TextView cardName;
    public final TextView collectorNumberTextView;
    public final TextView currentCardHeader;
    public final LoadingImageView currentCardImage;
    public final LinearLayout currentCardInfoLayout;
    public final LinearLayout currentCardLayout;
    public final TextView grabFromCollectionIcon;
    public final ConstraintLayout grabFromCollectionLayout;
    public final RadioButton grabFromCollectionRadioButton;
    public final TextView grabFromCollectionSubtitle;
    public final TextView grabFromCollectionTextView;
    public final LinearLayout headerLayout;
    public final TextView instructionsText;
    public final TextView makeAProxyIcon;
    public final ConstraintLayout makeAProxyLayout;
    public final RadioButton makeAProxyRadioButton;
    public final TextView makeAProxyTextView;
    public final RecyclerView matchesRecyclerView;
    public final NestedScrollView optionsScrollView;
    public final MaterialButton previousButton;
    public final TextView progressHeader;
    private final LinearLayout rootView;
    public final MaterialButton saveButton;
    public final TextView setCodeTextView;
    public final TextView title;

    private DialogCollectionStatusBinding(LinearLayout linearLayout, ImageView imageView, ConstraintLayout constraintLayout, RadioButton radioButton, TextView textView, TextView textView2, LinearLayout linearLayout2, ImageView imageView2, ConstraintLayout constraintLayout2, MaterialButton materialButton, LinearLayout linearLayout3, TextView textView3, TextView textView4, TextView textView5, LoadingImageView loadingImageView, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView6, ConstraintLayout constraintLayout3, RadioButton radioButton2, TextView textView7, TextView textView8, LinearLayout linearLayout6, TextView textView9, TextView textView10, ConstraintLayout constraintLayout4, RadioButton radioButton3, TextView textView11, RecyclerView recyclerView, NestedScrollView nestedScrollView, MaterialButton materialButton2, TextView textView12, MaterialButton materialButton3, TextView textView13, TextView textView14) {
        this.rootView = linearLayout;
        this.addToCollectionIcon = imageView;
        this.addToCollectionLayout = constraintLayout;
        this.addToCollectionRadioButton = radioButton;
        this.addToCollectionSubtitle = textView;
        this.addToCollectionTextView = textView2;
        this.answerLayout = linearLayout2;
        this.backImage = imageView2;
        this.body = constraintLayout2;
        this.cancelButton = materialButton;
        this.cardInfoLayout = linearLayout3;
        this.cardName = textView3;
        this.collectorNumberTextView = textView4;
        this.currentCardHeader = textView5;
        this.currentCardImage = loadingImageView;
        this.currentCardInfoLayout = linearLayout4;
        this.currentCardLayout = linearLayout5;
        this.grabFromCollectionIcon = textView6;
        this.grabFromCollectionLayout = constraintLayout3;
        this.grabFromCollectionRadioButton = radioButton2;
        this.grabFromCollectionSubtitle = textView7;
        this.grabFromCollectionTextView = textView8;
        this.headerLayout = linearLayout6;
        this.instructionsText = textView9;
        this.makeAProxyIcon = textView10;
        this.makeAProxyLayout = constraintLayout4;
        this.makeAProxyRadioButton = radioButton3;
        this.makeAProxyTextView = textView11;
        this.matchesRecyclerView = recyclerView;
        this.optionsScrollView = nestedScrollView;
        this.previousButton = materialButton2;
        this.progressHeader = textView12;
        this.saveButton = materialButton3;
        this.setCodeTextView = textView13;
        this.title = textView14;
    }

    public static DialogCollectionStatusBinding bind(View view) {
        int i = R.id.addToCollectionIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.addToCollectionLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.addToCollectionRadioButton;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                if (radioButton != null) {
                    i = R.id.addToCollectionSubtitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.addToCollectionTextView;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.answerLayout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.backImage;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = R.id.body;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout2 != null) {
                                        i = R.id.cancelButton;
                                        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                        if (materialButton != null) {
                                            i = R.id.cardInfoLayout;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout2 != null) {
                                                i = R.id.cardName;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.collectorNumberTextView;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.currentCardHeader;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.currentCardImage;
                                                            LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
                                                            if (loadingImageView != null) {
                                                                i = R.id.currentCardInfoLayout;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.currentCardLayout;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout4 != null) {
                                                                        i = R.id.grabFromCollectionIcon;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.grabFromCollectionLayout;
                                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (constraintLayout3 != null) {
                                                                                i = R.id.grabFromCollectionRadioButton;
                                                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                                                if (radioButton2 != null) {
                                                                                    i = R.id.grabFromCollectionSubtitle;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.grabFromCollectionTextView;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.headerLayout;
                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout5 != null) {
                                                                                                i = R.id.instructionsText;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.makeAProxyIcon;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.makeAProxyLayout;
                                                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (constraintLayout4 != null) {
                                                                                                            i = R.id.makeAProxyRadioButton;
                                                                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                                                                            if (radioButton3 != null) {
                                                                                                                i = R.id.makeAProxyTextView;
                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView11 != null) {
                                                                                                                    i = R.id.matchesRecyclerView;
                                                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (recyclerView != null) {
                                                                                                                        i = R.id.optionsScrollView;
                                                                                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (nestedScrollView != null) {
                                                                                                                            i = R.id.previousButton;
                                                                                                                            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (materialButton2 != null) {
                                                                                                                                i = R.id.progressHeader;
                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView12 != null) {
                                                                                                                                    i = R.id.saveButton;
                                                                                                                                    MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (materialButton3 != null) {
                                                                                                                                        i = R.id.setCodeTextView;
                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView13 != null) {
                                                                                                                                            i = R.id.title;
                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView14 != null) {
                                                                                                                                                return new DialogCollectionStatusBinding((LinearLayout) view, imageView, constraintLayout, radioButton, textView, textView2, linearLayout, imageView2, constraintLayout2, materialButton, linearLayout2, textView3, textView4, textView5, loadingImageView, linearLayout3, linearLayout4, textView6, constraintLayout3, radioButton2, textView7, textView8, linearLayout5, textView9, textView10, constraintLayout4, radioButton3, textView11, recyclerView, nestedScrollView, materialButton2, textView12, materialButton3, textView13, textView14);
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static DialogCollectionStatusBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogCollectionStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_collection_status, viewGroup, false);
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
