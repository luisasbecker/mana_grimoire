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
public final class ManabaseInsightItemBinding implements ViewBinding {
    public final TextView insightActionable;
    public final TextView insightDetailsButton;
    public final TextView insightMessage;
    public final TextView insightStatusIcon;
    public final TextView insightTitle;
    public final ConstraintLayout manabaseInsightRoot;
    private final ConstraintLayout rootView;

    private ManabaseInsightItemBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.insightActionable = textView;
        this.insightDetailsButton = textView2;
        this.insightMessage = textView3;
        this.insightStatusIcon = textView4;
        this.insightTitle = textView5;
        this.manabaseInsightRoot = constraintLayout2;
    }

    public static ManabaseInsightItemBinding bind(View view) {
        int i = R.id.insightActionable;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.insightDetailsButton;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.insightMessage;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.insightStatusIcon;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.insightTitle;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView5 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            return new ManabaseInsightItemBinding(constraintLayout, textView, textView2, textView3, textView4, textView5, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ManabaseInsightItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ManabaseInsightItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.manabase_insight_item, viewGroup, false);
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
