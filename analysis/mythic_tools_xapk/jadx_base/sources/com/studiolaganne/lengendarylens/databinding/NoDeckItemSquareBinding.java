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
public final class NoDeckItemSquareBinding implements ViewBinding {
    public final ConstraintLayout chooseDeckLayout;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView tapToSelectText;

    private NoDeckItemSquareBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView) {
        this.rootView = constraintLayout;
        this.chooseDeckLayout = constraintLayout2;
        this.rootLayout = constraintLayout3;
        this.tapToSelectText = textView;
    }

    public static NoDeckItemSquareBinding bind(View view) {
        int i = R.id.chooseDeckLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
            int i2 = R.id.tapToSelectText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i2);
            if (textView != null) {
                return new NoDeckItemSquareBinding(constraintLayout2, constraintLayout, constraintLayout2, textView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NoDeckItemSquareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NoDeckItemSquareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.no_deck_item_square, viewGroup, false);
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
