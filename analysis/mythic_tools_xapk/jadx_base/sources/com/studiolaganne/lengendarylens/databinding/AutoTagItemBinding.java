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
public final class AutoTagItemBinding implements ViewBinding {
    public final TextView autoTagCount;
    public final ConstraintLayout autoTagItemRoot;
    public final TextView autoTagLabel;
    private final ConstraintLayout rootView;

    private AutoTagItemBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, TextView textView2) {
        this.rootView = constraintLayout;
        this.autoTagCount = textView;
        this.autoTagItemRoot = constraintLayout2;
        this.autoTagLabel = textView2;
    }

    public static AutoTagItemBinding bind(View view) {
        int i = R.id.autoTagCount;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i2 = R.id.autoTagLabel;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i2);
            if (textView2 != null) {
                return new AutoTagItemBinding(constraintLayout, textView, constraintLayout, textView2);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AutoTagItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AutoTagItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auto_tag_item, viewGroup, false);
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
