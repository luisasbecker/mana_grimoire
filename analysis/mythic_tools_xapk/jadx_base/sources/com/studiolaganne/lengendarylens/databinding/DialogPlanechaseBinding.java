package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;
import com.studiolaganne.lengendarylens.SquareButton;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogPlanechaseBinding implements ViewBinding {
    public final ConstraintLayout cardContainer;
    public final LoadingImageView cardImage;
    public final ImageView closeImage;
    public final ImageView diceResultImage;
    public final SquareButton flipCardButton;
    public final ConstraintLayout innerLayout;
    public final ConstraintLayout ldicePlaneswalkButtonLayout;
    public final TextView loginButtonText;
    public final View overlay;
    public final ConstraintLayout planeswalkButtonLayout;
    public final TextView planeswalkButtonText;
    public final TextView resultText;
    public final ConstraintLayout rollButtonLayout;
    public final TextView rollButtonText;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final ImageView settingsImage;

    private DialogPlanechaseBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LoadingImageView loadingImageView, ImageView imageView, ImageView imageView2, SquareButton squareButton, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView, View view, ConstraintLayout constraintLayout5, TextView textView2, TextView textView3, ConstraintLayout constraintLayout6, TextView textView4, ConstraintLayout constraintLayout7, ImageView imageView3) {
        this.rootView = constraintLayout;
        this.cardContainer = constraintLayout2;
        this.cardImage = loadingImageView;
        this.closeImage = imageView;
        this.diceResultImage = imageView2;
        this.flipCardButton = squareButton;
        this.innerLayout = constraintLayout3;
        this.ldicePlaneswalkButtonLayout = constraintLayout4;
        this.loginButtonText = textView;
        this.overlay = view;
        this.planeswalkButtonLayout = constraintLayout5;
        this.planeswalkButtonText = textView2;
        this.resultText = textView3;
        this.rollButtonLayout = constraintLayout6;
        this.rollButtonText = textView4;
        this.rootLayout = constraintLayout7;
        this.settingsImage = imageView3;
    }

    public static DialogPlanechaseBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.cardContainer;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.cardImage;
            LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
            if (loadingImageView != null) {
                i = R.id.closeImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.diceResultImage;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.flipCardButton;
                        SquareButton squareButton = (SquareButton) ViewBindings.findChildViewById(view, i);
                        if (squareButton != null) {
                            i = R.id.innerLayout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = R.id.ldicePlaneswalkButtonLayout;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.loginButtonText;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.overlay))) != null) {
                                        i = R.id.planeswalkButtonLayout;
                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout4 != null) {
                                            i = R.id.planeswalkButtonText;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.resultText;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.rollButtonLayout;
                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout5 != null) {
                                                        i = R.id.rollButtonText;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) view;
                                                            i = R.id.settingsImage;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView3 != null) {
                                                                return new DialogPlanechaseBinding(constraintLayout6, constraintLayout, loadingImageView, imageView, imageView2, squareButton, constraintLayout2, constraintLayout3, textView, viewFindChildViewById, constraintLayout4, textView2, textView3, constraintLayout5, textView4, constraintLayout6, imageView3);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static DialogPlanechaseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogPlanechaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_planechase, viewGroup, false);
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
