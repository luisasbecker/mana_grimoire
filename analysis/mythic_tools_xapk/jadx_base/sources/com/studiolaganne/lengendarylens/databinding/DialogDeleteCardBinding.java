package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogDeleteCardBinding implements ViewBinding {
    public final TextView body;
    public final TextView minusQtyLabel;
    public final MaterialButton negativeButton;
    public final TextView plusQtyLabel;
    public final MaterialButton positiveButton;
    public final TextView qtyLabel;
    public final TextView quantityHeaderLabel;
    public final LinearLayout quantityLayout;
    public final CheckBox restoreCardsCheckBox;
    private final LinearLayout rootView;
    public final TextView title;
    public final TextView warningText;

    private DialogDeleteCardBinding(LinearLayout linearLayout, TextView textView, TextView textView2, MaterialButton materialButton, TextView textView3, MaterialButton materialButton2, TextView textView4, TextView textView5, LinearLayout linearLayout2, CheckBox checkBox, TextView textView6, TextView textView7) {
        this.rootView = linearLayout;
        this.body = textView;
        this.minusQtyLabel = textView2;
        this.negativeButton = materialButton;
        this.plusQtyLabel = textView3;
        this.positiveButton = materialButton2;
        this.qtyLabel = textView4;
        this.quantityHeaderLabel = textView5;
        this.quantityLayout = linearLayout2;
        this.restoreCardsCheckBox = checkBox;
        this.title = textView6;
        this.warningText = textView7;
    }

    public static DialogDeleteCardBinding bind(View view) {
        int i = R.id.body;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.minusQtyLabel;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.negative_button;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton != null) {
                    i = R.id.plusQtyLabel;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.positive_button;
                        MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                        if (materialButton2 != null) {
                            i = R.id.qtyLabel;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.quantityHeaderLabel;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.quantityLayout;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        i = R.id.restoreCardsCheckBox;
                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                                        if (checkBox != null) {
                                            i = R.id.title;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.warningText;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView7 != null) {
                                                    return new DialogDeleteCardBinding((LinearLayout) view, textView, textView2, materialButton, textView3, materialButton2, textView4, textView5, linearLayout, checkBox, textView6, textView7);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogDeleteCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogDeleteCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_delete_card, viewGroup, false);
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
