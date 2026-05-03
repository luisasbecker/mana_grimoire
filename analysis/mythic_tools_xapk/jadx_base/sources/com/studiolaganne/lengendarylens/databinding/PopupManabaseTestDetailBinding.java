package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PopupManabaseTestDetailBinding implements ViewBinding {
    public final LinearLayout contentContainer;
    public final LinearLayout metricsContainer;
    public final View metricsSeparator;
    public final ImageView popupCloseButton;
    public final TextView popupScoreBadge;
    public final TextView popupSubtitle;
    public final TextView popupTitle;
    private final ConstraintLayout rootView;

    private PopupManabaseTestDetailBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, View view, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.contentContainer = linearLayout;
        this.metricsContainer = linearLayout2;
        this.metricsSeparator = view;
        this.popupCloseButton = imageView;
        this.popupScoreBadge = textView;
        this.popupSubtitle = textView2;
        this.popupTitle = textView3;
    }

    public static PopupManabaseTestDetailBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.contentContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.metricsContainer;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.metricsSeparator))) != null) {
                i = R.id.popupCloseButton;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.popupScoreBadge;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.popupSubtitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.popupTitle;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new PopupManabaseTestDetailBinding((ConstraintLayout) view, linearLayout, linearLayout2, viewFindChildViewById, imageView, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static PopupManabaseTestDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PopupManabaseTestDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.popup_manabase_test_detail, viewGroup, false);
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
