package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.github.mikephil.charting.charts.BarChart;
import com.google.android.material.slider.RangeSlider;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PopupOpeningHandChartBinding implements ViewBinding {
    public final TextView mulliganProbabilityValue;
    public final BarChart openingHandChart;
    public final ImageView popupCloseButton;
    public final TextView popupTitle;
    public final TextView rangeLabel;
    public final RangeSlider rangeSlider;
    public final TextView rawProbabilityValue;
    public final TextView recommendedRangeLabel;
    private final ConstraintLayout rootView;

    private PopupOpeningHandChartBinding(ConstraintLayout constraintLayout, TextView textView, BarChart barChart, ImageView imageView, TextView textView2, TextView textView3, RangeSlider rangeSlider, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.mulliganProbabilityValue = textView;
        this.openingHandChart = barChart;
        this.popupCloseButton = imageView;
        this.popupTitle = textView2;
        this.rangeLabel = textView3;
        this.rangeSlider = rangeSlider;
        this.rawProbabilityValue = textView4;
        this.recommendedRangeLabel = textView5;
    }

    public static PopupOpeningHandChartBinding bind(View view) {
        int i = R.id.mulliganProbabilityValue;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.openingHandChart;
            BarChart barChart = (BarChart) ViewBindings.findChildViewById(view, i);
            if (barChart != null) {
                i = R.id.popupCloseButton;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.popupTitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.rangeLabel;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.rangeSlider;
                            RangeSlider rangeSlider = (RangeSlider) ViewBindings.findChildViewById(view, i);
                            if (rangeSlider != null) {
                                i = R.id.rawProbabilityValue;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.recommendedRangeLabel;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        return new PopupOpeningHandChartBinding((ConstraintLayout) view, textView, barChart, imageView, textView2, textView3, rangeSlider, textView4, textView5);
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

    public static PopupOpeningHandChartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PopupOpeningHandChartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.popup_opening_hand_chart, viewGroup, false);
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
