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
public final class PrintViewBinding implements ViewBinding {
    public final LoadingImageView cardImage;
    public final TextView cardNumberLabel;
    public final LinearLayout horizontalLayout;
    public final LinearLayout horizontalLayout2;
    public final ImageView isFoilImage;
    public final TextView priceLabel;
    private final ConstraintLayout rootView;
    public final TextView secondaryCardNumber;
    public final ImageView setImage;
    public final TextView setLabel;
    public final TextView titleLabel;

    private PrintViewBinding(ConstraintLayout constraintLayout, LoadingImageView loadingImageView, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, TextView textView2, TextView textView3, ImageView imageView2, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.cardImage = loadingImageView;
        this.cardNumberLabel = textView;
        this.horizontalLayout = linearLayout;
        this.horizontalLayout2 = linearLayout2;
        this.isFoilImage = imageView;
        this.priceLabel = textView2;
        this.secondaryCardNumber = textView3;
        this.setImage = imageView2;
        this.setLabel = textView4;
        this.titleLabel = textView5;
    }

    public static PrintViewBinding bind(View view) {
        int i = R.id.cardImage;
        LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
        if (loadingImageView != null) {
            i = R.id.cardNumberLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.horizontalLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.horizontalLayout2;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.is_foil_image;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.priceLabel;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.secondaryCardNumber;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.setImage;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = R.id.setLabel;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.titleLabel;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                return new PrintViewBinding((ConstraintLayout) view, loadingImageView, textView, linearLayout, linearLayout2, imageView, textView2, textView3, imageView2, textView4, textView5);
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

    public static PrintViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PrintViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.print_view, viewGroup, false);
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
