package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PriceRowTypeButtonsBinding implements ViewBinding {
    public final MaterialCardView buyEurButton;
    public final MaterialCardView buyUsdButton;
    public final TextView eurButtonText;
    public final TextView label;
    private final LinearLayout rootView;
    public final TextView usdButtonText;

    private PriceRowTypeButtonsBinding(LinearLayout linearLayout, MaterialCardView materialCardView, MaterialCardView materialCardView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.buyEurButton = materialCardView;
        this.buyUsdButton = materialCardView2;
        this.eurButtonText = textView;
        this.label = textView2;
        this.usdButtonText = textView3;
    }

    public static PriceRowTypeButtonsBinding bind(View view) {
        int i = R.id.buy_eur_button;
        MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, i);
        if (materialCardView != null) {
            i = R.id.buy_usd_button;
            MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.findChildViewById(view, i);
            if (materialCardView2 != null) {
                i = R.id.eur_button_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.label;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.usd_button_text;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new PriceRowTypeButtonsBinding((LinearLayout) view, materialCardView, materialCardView2, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static PriceRowTypeButtonsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PriceRowTypeButtonsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.price_row_type_buttons, viewGroup, false);
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
