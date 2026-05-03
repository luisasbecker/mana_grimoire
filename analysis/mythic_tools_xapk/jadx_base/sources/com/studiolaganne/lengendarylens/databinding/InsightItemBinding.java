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
public final class InsightItemBinding implements ViewBinding {
    public final TextView insightIcon;
    public final LinearLayout insightItemRoot;
    public final TextView insightLabel;
    private final LinearLayout rootView;

    private InsightItemBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2) {
        this.rootView = linearLayout;
        this.insightIcon = textView;
        this.insightItemRoot = linearLayout2;
        this.insightLabel = textView2;
    }

    public static InsightItemBinding bind(View view) {
        int i = R.id.insightIcon;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i2 = R.id.insightLabel;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i2);
            if (textView2 != null) {
                return new InsightItemBinding(linearLayout, textView, linearLayout, textView2);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static InsightItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static InsightItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.insight_item, viewGroup, false);
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
