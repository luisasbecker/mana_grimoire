package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogCustomBinding implements ViewBinding {
    public final TextView body;
    public final MaterialButton destructiveButton;
    public final RelativeLayout dialogRoot;
    public final MaterialButton negativeButton;
    public final MaterialButton positiveButton;
    public final CheckBox restoreCardsCheckBox;
    private final RelativeLayout rootView;
    public final View spacer;
    public final TextView title;
    public final TextView warningText;

    private DialogCustomBinding(RelativeLayout relativeLayout, TextView textView, MaterialButton materialButton, RelativeLayout relativeLayout2, MaterialButton materialButton2, MaterialButton materialButton3, CheckBox checkBox, View view, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.body = textView;
        this.destructiveButton = materialButton;
        this.dialogRoot = relativeLayout2;
        this.negativeButton = materialButton2;
        this.positiveButton = materialButton3;
        this.restoreCardsCheckBox = checkBox;
        this.spacer = view;
        this.title = textView2;
        this.warningText = textView3;
    }

    public static DialogCustomBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.body;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.destructive_button;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i = R.id.negative_button;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton2 != null) {
                    i = R.id.positive_button;
                    MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton3 != null) {
                        i = R.id.restoreCardsCheckBox;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                        if (checkBox != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.spacer))) != null) {
                            i = R.id.title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.warningText;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new DialogCustomBinding(relativeLayout, textView, materialButton, relativeLayout, materialButton2, materialButton3, checkBox, viewFindChildViewById, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogCustomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogCustomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_custom, viewGroup, false);
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
