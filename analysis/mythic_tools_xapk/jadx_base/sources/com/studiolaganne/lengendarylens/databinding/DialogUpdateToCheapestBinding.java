package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogUpdateToCheapestBinding implements ViewBinding {
    public final MaterialButton cancelButton;
    public final CheckBox checkDe;
    public final CheckBox checkEn;
    public final CheckBox checkEs;
    public final CheckBox checkFr;
    public final CheckBox checkIt;
    public final CheckBox checkJa;
    public final CheckBox checkKo;
    public final CheckBox checkPt;
    public final CheckBox checkRu;
    public final CheckBox checkZhs;
    public final CheckBox checkZht;
    public final GridLayout languagesGrid;
    private final LinearLayout rootView;
    public final TextView title;
    public final MaterialButton updateButton;

    private DialogUpdateToCheapestBinding(LinearLayout linearLayout, MaterialButton materialButton, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, CheckBox checkBox8, CheckBox checkBox9, CheckBox checkBox10, CheckBox checkBox11, GridLayout gridLayout, TextView textView, MaterialButton materialButton2) {
        this.rootView = linearLayout;
        this.cancelButton = materialButton;
        this.checkDe = checkBox;
        this.checkEn = checkBox2;
        this.checkEs = checkBox3;
        this.checkFr = checkBox4;
        this.checkIt = checkBox5;
        this.checkJa = checkBox6;
        this.checkKo = checkBox7;
        this.checkPt = checkBox8;
        this.checkRu = checkBox9;
        this.checkZhs = checkBox10;
        this.checkZht = checkBox11;
        this.languagesGrid = gridLayout;
        this.title = textView;
        this.updateButton = materialButton2;
    }

    public static DialogUpdateToCheapestBinding bind(View view) {
        int i = R.id.cancelButton;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.checkDe;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
            if (checkBox != null) {
                i = R.id.checkEn;
                CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, i);
                if (checkBox2 != null) {
                    i = R.id.checkEs;
                    CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, i);
                    if (checkBox3 != null) {
                        i = R.id.checkFr;
                        CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, i);
                        if (checkBox4 != null) {
                            i = R.id.checkIt;
                            CheckBox checkBox5 = (CheckBox) ViewBindings.findChildViewById(view, i);
                            if (checkBox5 != null) {
                                i = R.id.checkJa;
                                CheckBox checkBox6 = (CheckBox) ViewBindings.findChildViewById(view, i);
                                if (checkBox6 != null) {
                                    i = R.id.checkKo;
                                    CheckBox checkBox7 = (CheckBox) ViewBindings.findChildViewById(view, i);
                                    if (checkBox7 != null) {
                                        i = R.id.checkPt;
                                        CheckBox checkBox8 = (CheckBox) ViewBindings.findChildViewById(view, i);
                                        if (checkBox8 != null) {
                                            i = R.id.checkRu;
                                            CheckBox checkBox9 = (CheckBox) ViewBindings.findChildViewById(view, i);
                                            if (checkBox9 != null) {
                                                i = R.id.checkZhs;
                                                CheckBox checkBox10 = (CheckBox) ViewBindings.findChildViewById(view, i);
                                                if (checkBox10 != null) {
                                                    i = R.id.checkZht;
                                                    CheckBox checkBox11 = (CheckBox) ViewBindings.findChildViewById(view, i);
                                                    if (checkBox11 != null) {
                                                        i = R.id.languagesGrid;
                                                        GridLayout gridLayout = (GridLayout) ViewBindings.findChildViewById(view, i);
                                                        if (gridLayout != null) {
                                                            i = R.id.title;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView != null) {
                                                                i = R.id.updateButton;
                                                                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                                if (materialButton2 != null) {
                                                                    return new DialogUpdateToCheapestBinding((LinearLayout) view, materialButton, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, gridLayout, textView, materialButton2);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogUpdateToCheapestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogUpdateToCheapestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_update_to_cheapest, viewGroup, false);
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
