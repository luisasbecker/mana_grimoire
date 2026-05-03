package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CardListViewBinding implements ViewBinding {
    public final ConstraintLayout bottomLayout;
    public final TextView bottomText;
    public final LoadingImageView cardImage;
    public final ConstraintLayout cardLayout;
    public final TextView cardNumberLabel;
    public final LinearLayout horizontalLayout;
    public final ConstraintLayout mainLayout;
    public final TextView manaCostLabel;
    public final ConstraintLayout oracleLayout;
    public final TextView oracleTextView;
    public final TextView powerToughnessTextView;
    public final TextView priceLabel;
    private final LinearLayout rootView;
    public final ImageView setImage;
    public final TextView setLabel;
    public final TextView titleLabel;
    public final TextView typeLabel;

    private CardListViewBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView, LoadingImageView loadingImageView, ConstraintLayout constraintLayout2, TextView textView2, LinearLayout linearLayout2, ConstraintLayout constraintLayout3, TextView textView3, ConstraintLayout constraintLayout4, TextView textView4, TextView textView5, TextView textView6, ImageView imageView, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = linearLayout;
        this.bottomLayout = constraintLayout;
        this.bottomText = textView;
        this.cardImage = loadingImageView;
        this.cardLayout = constraintLayout2;
        this.cardNumberLabel = textView2;
        this.horizontalLayout = linearLayout2;
        this.mainLayout = constraintLayout3;
        this.manaCostLabel = textView3;
        this.oracleLayout = constraintLayout4;
        this.oracleTextView = textView4;
        this.powerToughnessTextView = textView5;
        this.priceLabel = textView6;
        this.setImage = imageView;
        this.setLabel = textView7;
        this.titleLabel = textView8;
        this.typeLabel = textView9;
    }

    public static CardListViewBinding bind(View view) {
        int i = R.id.bottomLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.bottomText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.cardImage;
                LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
                if (loadingImageView != null) {
                    i = R.id.cardLayout;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.cardNumberLabel;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.horizontalLayout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.mainLayout;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.manaCostLabel;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.oracleLayout;
                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout4 != null) {
                                            i = R.id.oracleTextView;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.powerToughnessTextView;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.priceLabel;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.setImage;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView != null) {
                                                            i = R.id.setLabel;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView7 != null) {
                                                                i = R.id.titleLabel;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView8 != null) {
                                                                    i = R.id.typeLabel;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView9 != null) {
                                                                        return new CardListViewBinding((LinearLayout) view, constraintLayout, textView, loadingImageView, constraintLayout2, textView2, linearLayout, constraintLayout3, textView3, constraintLayout4, textView4, textView5, textView6, imageView, textView7, textView8, textView9);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static CardListViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CardListViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.card_list_view, viewGroup, false);
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
