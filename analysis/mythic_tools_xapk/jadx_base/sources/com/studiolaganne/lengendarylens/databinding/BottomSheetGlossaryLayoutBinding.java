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
public final class BottomSheetGlossaryLayoutBinding implements ViewBinding {
    public final TextView body;
    private final ConstraintLayout rootView;
    public final TextView title;

    private BottomSheetGlossaryLayoutBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.body = textView;
        this.title = textView2;
    }

    public static BottomSheetGlossaryLayoutBinding bind(View view) {
        int i = R.id.body;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                return new BottomSheetGlossaryLayoutBinding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static BottomSheetGlossaryLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetGlossaryLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_glossary_layout, viewGroup, false);
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
