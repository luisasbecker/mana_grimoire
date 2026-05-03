package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogCustomLifeBinding implements ViewBinding {
    public final EditText customLifeEditText;
    public final TextView dialogTitle;
    public final MaterialButton negativeButton;
    public final MaterialButton positiveButton;
    private final LinearLayout rootView;

    private DialogCustomLifeBinding(LinearLayout linearLayout, EditText editText, TextView textView, MaterialButton materialButton, MaterialButton materialButton2) {
        this.rootView = linearLayout;
        this.customLifeEditText = editText;
        this.dialogTitle = textView;
        this.negativeButton = materialButton;
        this.positiveButton = materialButton2;
    }

    public static DialogCustomLifeBinding bind(View view) {
        int i = R.id.custom_life_edit_text;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = R.id.dialog_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.negative_button;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton != null) {
                    i = R.id.positive_button;
                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton2 != null) {
                        return new DialogCustomLifeBinding((LinearLayout) view, editText, textView, materialButton, materialButton2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogCustomLifeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogCustomLifeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_custom_life, viewGroup, false);
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
