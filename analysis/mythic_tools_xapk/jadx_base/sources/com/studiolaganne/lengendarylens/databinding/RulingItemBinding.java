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
public final class RulingItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView rulingTextView;

    private RulingItemBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.rulingTextView = textView;
    }

    public static RulingItemBinding bind(View view) {
        int i = R.id.rulingTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new RulingItemBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static RulingItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RulingItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.ruling_item, viewGroup, false);
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
