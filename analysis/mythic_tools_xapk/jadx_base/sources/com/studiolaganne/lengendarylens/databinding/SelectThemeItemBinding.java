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
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SelectThemeItemBinding implements ViewBinding {
    public final ConstraintLayout buyButtonLayout;
    public final ImageView cartIcon;
    public final ImageView checkmark;
    public final LinearLayout innerLayout;
    public final LinearLayout innerLayout2;
    public final TextView priceText;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final CachedImageView themeImage;
    public final TextView themeTitle;

    private SelectThemeItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, ConstraintLayout constraintLayout3, CachedImageView cachedImageView, TextView textView2) {
        this.rootView = constraintLayout;
        this.buyButtonLayout = constraintLayout2;
        this.cartIcon = imageView;
        this.checkmark = imageView2;
        this.innerLayout = linearLayout;
        this.innerLayout2 = linearLayout2;
        this.priceText = textView;
        this.rootLayout = constraintLayout3;
        this.themeImage = cachedImageView;
        this.themeTitle = textView2;
    }

    public static SelectThemeItemBinding bind(View view) {
        int i = R.id.buyButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.cart_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.checkmark;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.innerLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.innerLayout2;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R.id.priceText;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                i = R.id.themeImage;
                                CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                if (cachedImageView != null) {
                                    i = R.id.themeTitle;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        return new SelectThemeItemBinding(constraintLayout2, constraintLayout, imageView, imageView2, linearLayout, linearLayout2, textView, constraintLayout2, cachedImageView, textView2);
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

    public static SelectThemeItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SelectThemeItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.select_theme_item, viewGroup, false);
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
