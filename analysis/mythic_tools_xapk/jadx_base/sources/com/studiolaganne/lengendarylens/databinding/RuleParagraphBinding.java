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
public final class RuleParagraphBinding implements ViewBinding {
    public final TextView offsetLabel;
    public final TextView paragraphLabel;
    private final LinearLayout rootView;
    public final TextView sectionNumberLabel;

    private RuleParagraphBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.offsetLabel = textView;
        this.paragraphLabel = textView2;
        this.sectionNumberLabel = textView3;
    }

    public static RuleParagraphBinding bind(View view) {
        int i = R.id.offset_label;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.paragraph_label;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.section_number_label;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    return new RuleParagraphBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static RuleParagraphBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RuleParagraphBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.rule_paragraph, viewGroup, false);
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
