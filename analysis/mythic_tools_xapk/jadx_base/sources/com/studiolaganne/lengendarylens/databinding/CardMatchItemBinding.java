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
public final class CardMatchItemBinding implements ViewBinding {
    public final LoadingImageView cardImage;
    public final TextView cardName;
    public final ImageView collectionImage;
    public final LinearLayout collectionLayout;
    public final TextView collectorNumber;
    public final TextView containerLabel;
    public final TextView exactMatchLabel;
    public final ImageView foilEffectImage;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView setCode;
    public final LinearLayout setInfoLayout;

    private CardMatchItemBinding(ConstraintLayout constraintLayout, LoadingImageView loadingImageView, TextView textView, ImageView imageView, LinearLayout linearLayout, TextView textView2, TextView textView3, TextView textView4, ImageView imageView2, ConstraintLayout constraintLayout2, TextView textView5, LinearLayout linearLayout2) {
        this.rootView = constraintLayout;
        this.cardImage = loadingImageView;
        this.cardName = textView;
        this.collectionImage = imageView;
        this.collectionLayout = linearLayout;
        this.collectorNumber = textView2;
        this.containerLabel = textView3;
        this.exactMatchLabel = textView4;
        this.foilEffectImage = imageView2;
        this.rootLayout = constraintLayout2;
        this.setCode = textView5;
        this.setInfoLayout = linearLayout2;
    }

    public static CardMatchItemBinding bind(View view) {
        int i = R.id.cardImage;
        LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
        if (loadingImageView != null) {
            i = R.id.cardName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.collectionImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.collectionLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.collectorNumber;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.containerLabel;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.exactMatchLabel;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.foilEffectImage;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                        i = R.id.setCode;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.setInfoLayout;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout2 != null) {
                                                return new CardMatchItemBinding(constraintLayout, loadingImageView, textView, imageView, linearLayout, textView2, textView3, textView4, imageView2, constraintLayout, textView5, linearLayout2);
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

    public static CardMatchItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CardMatchItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.card_match_item, viewGroup, false);
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
