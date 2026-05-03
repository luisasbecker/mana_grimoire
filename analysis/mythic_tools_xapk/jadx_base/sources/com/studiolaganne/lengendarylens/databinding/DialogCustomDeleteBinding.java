package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogCustomDeleteBinding implements ViewBinding {
    public final TextView body;
    public final EditText customLifeEditText;
    public final MaterialButton negativeButton;
    public final MaterialButton positiveButton;
    public final CheckBox restoreCardsCheckBox;
    private final LinearLayout rootView;
    public final TextView title;
    public final TextView warningText;

    private DialogCustomDeleteBinding(LinearLayout linearLayout, TextView textView, EditText editText, MaterialButton materialButton, MaterialButton materialButton2, CheckBox checkBox, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.body = textView;
        this.customLifeEditText = editText;
        this.negativeButton = materialButton;
        this.positiveButton = materialButton2;
        this.restoreCardsCheckBox = checkBox;
        this.title = textView2;
        this.warningText = textView3;
    }

    public static DialogCustomDeleteBinding bind(View view) {
        int i = R.id.body;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.custom_life_edit_text;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.negative_button;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton != null) {
                    i = R.id.positive_button;
                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton2 != null) {
                        i = R.id.restoreCardsCheckBox;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                        if (checkBox != null) {
                            i = R.id.title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.warningText;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new DialogCustomDeleteBinding((LinearLayout) view, textView, editText, materialButton, materialButton2, checkBox, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogCustomDeleteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogCustomDeleteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_custom_delete, viewGroup, false);
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
