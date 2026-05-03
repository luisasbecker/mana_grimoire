package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class MtPriceRowHeaderBinding implements ViewBinding {
    public final ImageView marketplaceIcon;
    public final TextView marketplaceName;
    public final LinearLayout rootLinearLayout;
    private final LinearLayout rootView;

    private MtPriceRowHeaderBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.marketplaceIcon = imageView;
        this.marketplaceName = textView;
        this.rootLinearLayout = linearLayout2;
    }

    public static MtPriceRowHeaderBinding bind(View view) {
        int i = R.id.marketplace_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.marketplace_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new MtPriceRowHeaderBinding(linearLayout, imageView, textView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static MtPriceRowHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MtPriceRowHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.mt_price_row_header, viewGroup, false);
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
