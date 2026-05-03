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
public final class PreferenceMarketplaceItemBinding implements ViewBinding {
    public final ImageView marketplaceIcon;
    public final TextView marketplaceText;
    private final LinearLayout rootView;
    public final View text1;

    private PreferenceMarketplaceItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, View view) {
        this.rootView = linearLayout;
        this.marketplaceIcon = imageView;
        this.marketplaceText = textView;
        this.text1 = view;
    }

    public static PreferenceMarketplaceItemBinding bind(View view) {
        int i = R.id.marketplace_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.marketplace_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = android.R.id.text1;
                View viewFindChildViewById = ViewBindings.findChildViewById(view, android.R.id.text1);
                if (viewFindChildViewById != null) {
                    return new PreferenceMarketplaceItemBinding((LinearLayout) view, imageView, textView, viewFindChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static PreferenceMarketplaceItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PreferenceMarketplaceItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.preference_marketplace_item, viewGroup, false);
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
