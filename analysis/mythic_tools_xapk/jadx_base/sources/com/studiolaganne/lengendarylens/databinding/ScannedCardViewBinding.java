package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ScannedCardViewBinding implements ViewBinding {
    public final ConstraintLayout adjustmentsLayout;
    public final LinearLayout adjustmentsRootLayout;
    public final LoadingImageView cardImage;
    public final ConstraintLayout cardImageContainer;
    public final TextView cardNumberTextView;
    public final ConstraintLayout cardOverlayLayout;
    public final ConstraintLayout closeLayout;
    public final TextView collectionMatchLabel;
    public final View cornerView;
    public final ConstraintLayout flagContainer;
    public final ImageView flagImage;
    public final ImageView foilEffectImage;
    public final Switch foilSwitch;
    public final ImageView foilSwitchImage;
    public final LinearLayout foilSwitchLayout;
    public final Guideline middleGuideline;
    public final TextView minusQtyLabel;
    public final TextView plusQtyLabel;
    public final TextView priceLabel;
    public final TextView qtyLabel;
    public final LinearLayout qtyLayout;
    public final TextView qtyTextView;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView scanListExportTextView;
    public final ImageView setImage;
    public final ConstraintLayout setImageLayout;

    private ScannedCardViewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout, LoadingImageView loadingImageView, ConstraintLayout constraintLayout3, TextView textView, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView2, View view, ConstraintLayout constraintLayout6, ImageView imageView, ImageView imageView2, Switch r14, ImageView imageView3, LinearLayout linearLayout2, Guideline guideline, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout3, TextView textView7, ConstraintLayout constraintLayout7, TextView textView8, ImageView imageView4, ConstraintLayout constraintLayout8) {
        this.rootView = constraintLayout;
        this.adjustmentsLayout = constraintLayout2;
        this.adjustmentsRootLayout = linearLayout;
        this.cardImage = loadingImageView;
        this.cardImageContainer = constraintLayout3;
        this.cardNumberTextView = textView;
        this.cardOverlayLayout = constraintLayout4;
        this.closeLayout = constraintLayout5;
        this.collectionMatchLabel = textView2;
        this.cornerView = view;
        this.flagContainer = constraintLayout6;
        this.flagImage = imageView;
        this.foilEffectImage = imageView2;
        this.foilSwitch = r14;
        this.foilSwitchImage = imageView3;
        this.foilSwitchLayout = linearLayout2;
        this.middleGuideline = guideline;
        this.minusQtyLabel = textView3;
        this.plusQtyLabel = textView4;
        this.priceLabel = textView5;
        this.qtyLabel = textView6;
        this.qtyLayout = linearLayout3;
        this.qtyTextView = textView7;
        this.rootLayout = constraintLayout7;
        this.scanListExportTextView = textView8;
        this.setImage = imageView4;
        this.setImageLayout = constraintLayout8;
    }

    public static ScannedCardViewBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.adjustmentsLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.adjustmentsRootLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.cardImage;
                LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
                if (loadingImageView != null) {
                    i = R.id.cardImageContainer;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.cardNumberTextView;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.cardOverlayLayout;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout3 != null) {
                                i = R.id.closeLayout;
                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout4 != null) {
                                    i = R.id.collectionMatchLabel;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.cornerView))) != null) {
                                        i = R.id.flag_container;
                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout5 != null) {
                                            i = R.id.flag_image;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView != null) {
                                                i = R.id.foilEffectImage;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView2 != null) {
                                                    i = R.id.foilSwitch;
                                                    Switch r17 = (Switch) ViewBindings.findChildViewById(view, i);
                                                    if (r17 != null) {
                                                        i = R.id.foilSwitchImage;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView3 != null) {
                                                            i = R.id.foilSwitchLayout;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.middle_guideline;
                                                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                if (guideline != null) {
                                                                    i = R.id.minusQtyLabel;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView3 != null) {
                                                                        i = R.id.plusQtyLabel;
                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView4 != null) {
                                                                            i = R.id.priceLabel;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView5 != null) {
                                                                                i = R.id.qtyLabel;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.qtyLayout;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout3 != null) {
                                                                                        i = R.id.qtyTextView;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView7 != null) {
                                                                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) view;
                                                                                            i = R.id.scanListExportTextView;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView8 != null) {
                                                                                                i = R.id.setImage;
                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView4 != null) {
                                                                                                    i = R.id.setImageLayout;
                                                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (constraintLayout7 != null) {
                                                                                                        return new ScannedCardViewBinding(constraintLayout6, constraintLayout, linearLayout, loadingImageView, constraintLayout2, textView, constraintLayout3, constraintLayout4, textView2, viewFindChildViewById, constraintLayout5, imageView, imageView2, r17, imageView3, linearLayout2, guideline, textView3, textView4, textView5, textView6, linearLayout3, textView7, constraintLayout6, textView8, imageView4, constraintLayout7);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static ScannedCardViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ScannedCardViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.scanned_card_view, viewGroup, false);
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
