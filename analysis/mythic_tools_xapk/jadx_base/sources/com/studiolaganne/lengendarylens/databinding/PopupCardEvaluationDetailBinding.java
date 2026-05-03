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
public final class PopupCardEvaluationDetailBinding implements ViewBinding {
    public final LinearLayout contentContainer;
    public final ImageView popupCloseButton;
    public final TextView popupTitle;
    public final TextView popupVerdictBadge;
    private final ConstraintLayout rootView;

    private PopupCardEvaluationDetailBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.contentContainer = linearLayout;
        this.popupCloseButton = imageView;
        this.popupTitle = textView;
        this.popupVerdictBadge = textView2;
    }

    public static PopupCardEvaluationDetailBinding bind(View view) {
        int i = R.id.contentContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.popupCloseButton;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.popupTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.popupVerdictBadge;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new PopupCardEvaluationDetailBinding((ConstraintLayout) view, linearLayout, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static PopupCardEvaluationDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PopupCardEvaluationDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.popup_card_evaluation_detail, viewGroup, false);
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
