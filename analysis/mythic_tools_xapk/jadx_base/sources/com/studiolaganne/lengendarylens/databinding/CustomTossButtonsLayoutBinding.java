package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomTossButtonsLayoutBinding implements ViewBinding {
    public final ConstraintLayout buttonsLayout;
    public final ImageView closeButton;
    public final ImageView diceIcon;
    public final ConstraintLayout doneButtonLayout;
    public final TextView doneText;
    public final ConstraintLayout rerollButtonLayout;
    public final TextView rerollText;
    private final ConstraintLayout rootView;

    private CustomTossButtonsLayoutBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout3, TextView textView, ConstraintLayout constraintLayout4, TextView textView2) {
        this.rootView = constraintLayout;
        this.buttonsLayout = constraintLayout2;
        this.closeButton = imageView;
        this.diceIcon = imageView2;
        this.doneButtonLayout = constraintLayout3;
        this.doneText = textView;
        this.rerollButtonLayout = constraintLayout4;
        this.rerollText = textView2;
    }

    public static CustomTossButtonsLayoutBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.close_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.dice_icon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.doneButtonLayout;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.doneText;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.rerollButtonLayout;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout3 != null) {
                            i = R.id.rerollText;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new CustomTossButtonsLayoutBinding(constraintLayout, constraintLayout, imageView, imageView2, constraintLayout2, textView, constraintLayout3, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static CustomTossButtonsLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CustomTossButtonsLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.custom_toss_buttons_layout, viewGroup, false);
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
