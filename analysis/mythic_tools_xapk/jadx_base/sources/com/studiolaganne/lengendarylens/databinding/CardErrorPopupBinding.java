package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CardErrorPopupBinding implements ViewBinding {
    public final View cardErrorPopupArrow;
    public final ConstraintLayout cardErrorPopupLayout;
    public final TextView cardErrorText;
    private final ConstraintLayout rootView;

    private CardErrorPopupBinding(ConstraintLayout constraintLayout, View view, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.cardErrorPopupArrow = view;
        this.cardErrorPopupLayout = constraintLayout2;
        this.cardErrorText = textView;
    }

    public static CardErrorPopupBinding bind(View view) {
        int i = R.id.cardErrorPopupArrow;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i2 = R.id.cardErrorText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i2);
            if (textView != null) {
                return new CardErrorPopupBinding(constraintLayout, viewFindChildViewById, constraintLayout, textView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static CardErrorPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CardErrorPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.card_error_popup, viewGroup, false);
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
