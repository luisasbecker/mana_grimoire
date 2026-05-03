package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.ManaCostProductionChartView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ViewManaCostProductionBinding implements ViewBinding {
    public final TextView costCards;
    public final TextView costIcon;
    public final TextView costLabel;
    public final TextView costValue;
    public final ConstraintLayout infoPanel;
    public final ManaCostProductionChartView manaChartView;
    public final TextView productionCards;
    public final TextView productionIcon;
    public final TextView productionLabel;
    public final TextView productionValue;
    private final ConstraintLayout rootView;

    private ViewManaCostProductionBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout2, ManaCostProductionChartView manaCostProductionChartView, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.costCards = textView;
        this.costIcon = textView2;
        this.costLabel = textView3;
        this.costValue = textView4;
        this.infoPanel = constraintLayout2;
        this.manaChartView = manaCostProductionChartView;
        this.productionCards = textView5;
        this.productionIcon = textView6;
        this.productionLabel = textView7;
        this.productionValue = textView8;
    }

    public static ViewManaCostProductionBinding bind(View view) {
        int i = R.id.costCards;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.costIcon;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.costLabel;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.costValue;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.infoPanel;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.manaChartView;
                            ManaCostProductionChartView manaCostProductionChartView = (ManaCostProductionChartView) ViewBindings.findChildViewById(view, i);
                            if (manaCostProductionChartView != null) {
                                i = R.id.productionCards;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.productionIcon;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null) {
                                        i = R.id.productionLabel;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView7 != null) {
                                            i = R.id.productionValue;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView8 != null) {
                                                return new ViewManaCostProductionBinding((ConstraintLayout) view, textView, textView2, textView3, textView4, constraintLayout, manaCostProductionChartView, textView5, textView6, textView7, textView8);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ViewManaCostProductionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewManaCostProductionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_mana_cost_production, viewGroup, false);
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
