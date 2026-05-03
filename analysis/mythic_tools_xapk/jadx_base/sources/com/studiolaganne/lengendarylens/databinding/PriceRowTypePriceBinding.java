package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PriceRowTypePriceBinding implements ViewBinding {
    public final TextView label;
    public final TextView priceEur;
    public final TextView priceUsd;
    public final LinearLayout rootLinearLayout;
    private final LinearLayout rootView;

    private PriceRowTypePriceBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.label = textView;
        this.priceEur = textView2;
        this.priceUsd = textView3;
        this.rootLinearLayout = linearLayout2;
    }

    public static PriceRowTypePriceBinding bind(View view) {
        int i = R.id.label;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.price_eur;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.price_usd;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new PriceRowTypePriceBinding(linearLayout, textView, textView2, textView3, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static PriceRowTypePriceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PriceRowTypePriceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.price_row_type_price, viewGroup, false);
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
