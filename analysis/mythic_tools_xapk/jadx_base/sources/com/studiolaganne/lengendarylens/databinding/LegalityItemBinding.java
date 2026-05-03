package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LegalityItemBinding implements ViewBinding {
    public final TextView formatTextView;
    public final Button legalityButton;
    private final LinearLayout rootView;

    private LegalityItemBinding(LinearLayout linearLayout, TextView textView, Button button) {
        this.rootView = linearLayout;
        this.formatTextView = textView;
        this.legalityButton = button;
    }

    public static LegalityItemBinding bind(View view) {
        int i = R.id.formatTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.legalityButton;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                return new LegalityItemBinding((LinearLayout) view, textView, button);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LegalityItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LegalityItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.legality_item, viewGroup, false);
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
