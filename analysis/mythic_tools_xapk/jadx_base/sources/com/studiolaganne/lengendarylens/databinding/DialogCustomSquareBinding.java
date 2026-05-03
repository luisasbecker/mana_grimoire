package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogCustomSquareBinding implements ViewBinding {
    public final TextView body;
    public final LinearLayout buttonsLayout;
    public final RelativeLayout dialogRoot;
    public final MaterialButton negativeButton;
    public final MaterialButton positiveButton;
    private final RelativeLayout rootView;
    public final MaterialButton thirdButton;
    public final TextView title;

    private DialogCustomSquareBinding(RelativeLayout relativeLayout, TextView textView, LinearLayout linearLayout, RelativeLayout relativeLayout2, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, TextView textView2) {
        this.rootView = relativeLayout;
        this.body = textView;
        this.buttonsLayout = linearLayout;
        this.dialogRoot = relativeLayout2;
        this.negativeButton = materialButton;
        this.positiveButton = materialButton2;
        this.thirdButton = materialButton3;
        this.title = textView2;
    }

    public static DialogCustomSquareBinding bind(View view) {
        int i = R.id.body;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.buttonsLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i = R.id.negative_button;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton != null) {
                    i = R.id.positive_button;
                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton2 != null) {
                        i = R.id.third_button;
                        MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                        if (materialButton3 != null) {
                            i = R.id.title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new DialogCustomSquareBinding(relativeLayout, textView, linearLayout, relativeLayout, materialButton, materialButton2, materialButton3, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogCustomSquareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogCustomSquareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_custom_square, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
