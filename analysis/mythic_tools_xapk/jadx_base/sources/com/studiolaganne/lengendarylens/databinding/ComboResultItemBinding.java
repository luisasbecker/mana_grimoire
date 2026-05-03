package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ComboResultItemBinding implements ViewBinding {
    public final ConstraintLayout comboResultInnerLayout;
    public final TextView comboResultTextView;
    public final LinearLayout rootLinearLayout;
    private final LinearLayout rootView;

    private ComboResultItemBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.comboResultInnerLayout = constraintLayout;
        this.comboResultTextView = textView;
        this.rootLinearLayout = linearLayout2;
    }

    public static ComboResultItemBinding bind(View view) {
        int i = R.id.comboResultInnerLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.comboResultTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new ComboResultItemBinding(linearLayout, constraintLayout, textView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ComboResultItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ComboResultItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.combo_result_item, viewGroup, false);
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
