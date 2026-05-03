package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogCollectionRestoreBinding implements ViewBinding {
    public final ConstraintLayout body;
    public final MaterialButton cancelButton;
    public final LinearLayout cardInfoLayout;
    public final TextView cardName;
    public final TextView collectorNumberTextView;
    public final TextView currentCardHeader;
    public final LoadingImageView currentCardImage;
    public final LinearLayout currentCardInfoLayout;
    public final LinearLayout currentCardLayout;
    public final LinearLayout headerLayout;
    public final TextView instructionsText;
    public final MaterialButton previousButton;
    public final TextView progressHeader;
    public final TextView restoreIcon;
    public final ConstraintLayout restoreToCollectionLayout;
    public final RadioButton restoreToCollectionRadioButton;
    public final TextView restoreToCollectionTextView;
    private final LinearLayout rootView;
    public final MaterialButton saveButton;
    public final TextView setCodeTextView;
    public final TextView title;

    private DialogCollectionRestoreBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, MaterialButton materialButton, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, LoadingImageView loadingImageView, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView4, MaterialButton materialButton2, TextView textView5, TextView textView6, ConstraintLayout constraintLayout2, RadioButton radioButton, TextView textView7, MaterialButton materialButton3, TextView textView8, TextView textView9) {
        this.rootView = linearLayout;
        this.body = constraintLayout;
        this.cancelButton = materialButton;
        this.cardInfoLayout = linearLayout2;
        this.cardName = textView;
        this.collectorNumberTextView = textView2;
        this.currentCardHeader = textView3;
        this.currentCardImage = loadingImageView;
        this.currentCardInfoLayout = linearLayout3;
        this.currentCardLayout = linearLayout4;
        this.headerLayout = linearLayout5;
        this.instructionsText = textView4;
        this.previousButton = materialButton2;
        this.progressHeader = textView5;
        this.restoreIcon = textView6;
        this.restoreToCollectionLayout = constraintLayout2;
        this.restoreToCollectionRadioButton = radioButton;
        this.restoreToCollectionTextView = textView7;
        this.saveButton = materialButton3;
        this.setCodeTextView = textView8;
        this.title = textView9;
    }

    public static DialogCollectionRestoreBinding bind(View view) {
        int i = R.id.body;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.cancelButton;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.cardInfoLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.cardName;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.collectorNumberTextView;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.currentCardHeader;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.currentCardImage;
                                LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
                                if (loadingImageView != null) {
                                    i = R.id.currentCardInfoLayout;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.currentCardLayout;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.headerLayout;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout4 != null) {
                                                i = R.id.instructionsText;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.previousButton;
                                                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                    if (materialButton2 != null) {
                                                        i = R.id.progressHeader;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.restoreIcon;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = R.id.restoreToCollectionLayout;
                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout2 != null) {
                                                                    i = R.id.restoreToCollectionRadioButton;
                                                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                                    if (radioButton != null) {
                                                                        i = R.id.restoreToCollectionTextView;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.saveButton;
                                                                            MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                                            if (materialButton3 != null) {
                                                                                i = R.id.setCodeTextView;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.title;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView9 != null) {
                                                                                        return new DialogCollectionRestoreBinding((LinearLayout) view, constraintLayout, materialButton, linearLayout, textView, textView2, textView3, loadingImageView, linearLayout2, linearLayout3, linearLayout4, textView4, materialButton2, textView5, textView6, constraintLayout2, radioButton, textView7, materialButton3, textView8, textView9);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static DialogCollectionRestoreBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogCollectionRestoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_collection_restore, viewGroup, false);
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
