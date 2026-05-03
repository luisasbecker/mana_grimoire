package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetFinalsLayoutBinding implements ViewBinding {
    public final Spinner matchTypeSpinner;
    private final LinearLayout rootView;
    public final MaterialButton top16Button;
    public final MaterialButton top2Button;
    public final MaterialButton top4Button;
    public final MaterialButton top8Button;

    private BottomSheetFinalsLayoutBinding(LinearLayout linearLayout, Spinner spinner, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, MaterialButton materialButton4) {
        this.rootView = linearLayout;
        this.matchTypeSpinner = spinner;
        this.top16Button = materialButton;
        this.top2Button = materialButton2;
        this.top4Button = materialButton3;
        this.top8Button = materialButton4;
    }

    public static BottomSheetFinalsLayoutBinding bind(View view) {
        int i = R.id.match_type_spinner;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, i);
        if (spinner != null) {
            i = R.id.top16_button;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.top2_button;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton2 != null) {
                    i = R.id.top4_button;
                    MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton3 != null) {
                        i = R.id.top8_button;
                        MaterialButton materialButton4 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                        if (materialButton4 != null) {
                            return new BottomSheetFinalsLayoutBinding((LinearLayout) view, spinner, materialButton, materialButton2, materialButton3, materialButton4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static BottomSheetFinalsLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetFinalsLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_finals_layout, viewGroup, false);
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
