package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ThemeItemBinding implements ViewBinding {
    public final ConstraintLayout buyButtonLayout;
    public final ImageView cartIcon;
    public final TextView catchphraseTextView;
    public final TextView priceText;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final CachedImageView themeImage;
    public final ConstraintLayout themeInfoInnerLayout;
    public final ConstraintLayout themeInfoLayout;
    public final TextView themeTitle;

    private ThemeItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2, ConstraintLayout constraintLayout3, CachedImageView cachedImageView, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView3) {
        this.rootView = constraintLayout;
        this.buyButtonLayout = constraintLayout2;
        this.cartIcon = imageView;
        this.catchphraseTextView = textView;
        this.priceText = textView2;
        this.rootLayout = constraintLayout3;
        this.themeImage = cachedImageView;
        this.themeInfoInnerLayout = constraintLayout4;
        this.themeInfoLayout = constraintLayout5;
        this.themeTitle = textView3;
    }

    public static ThemeItemBinding bind(View view) {
        int i = R.id.buyButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.cart_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.catchphraseTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.priceText;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                        i = R.id.themeImage;
                        CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                        if (cachedImageView != null) {
                            i = R.id.themeInfoInnerLayout;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout3 != null) {
                                i = R.id.themeInfoLayout;
                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout4 != null) {
                                    i = R.id.themeTitle;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        return new ThemeItemBinding(constraintLayout2, constraintLayout, imageView, textView, textView2, constraintLayout2, cachedImageView, constraintLayout3, constraintLayout4, textView3);
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

    public static ThemeItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ThemeItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.theme_item, viewGroup, false);
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
