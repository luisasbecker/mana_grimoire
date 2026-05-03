package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogPromoQrBinding implements ViewBinding {
    public final ConstraintLayout cancelButtonLayout;
    public final TextView cancelButtonText;
    public final CardView cardView;
    public final ConstraintLayout promoQRLayout;
    private final ConstraintLayout rootView;

    private DialogPromoQrBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, CardView cardView, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.cancelButtonLayout = constraintLayout2;
        this.cancelButtonText = textView;
        this.cardView = cardView;
        this.promoQRLayout = constraintLayout3;
    }

    public static DialogPromoQrBinding bind(View view) {
        int i = R.id.cancelButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.cancelButtonText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.cardView;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                    return new DialogPromoQrBinding(constraintLayout2, constraintLayout, textView, cardView, constraintLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogPromoQrBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogPromoQrBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_promo_qr, viewGroup, false);
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
