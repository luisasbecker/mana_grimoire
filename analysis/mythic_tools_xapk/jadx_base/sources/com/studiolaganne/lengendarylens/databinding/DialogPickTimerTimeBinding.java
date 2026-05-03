package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogPickTimerTimeBinding implements ViewBinding {
    public final NumberPicker hrTimepicker;
    public final NumberPicker minTimepicker;
    public final MaterialButton negativeButton;
    public final MaterialButton positiveButton;
    private final LinearLayout rootView;

    private DialogPickTimerTimeBinding(LinearLayout linearLayout, NumberPicker numberPicker, NumberPicker numberPicker2, MaterialButton materialButton, MaterialButton materialButton2) {
        this.rootView = linearLayout;
        this.hrTimepicker = numberPicker;
        this.minTimepicker = numberPicker2;
        this.negativeButton = materialButton;
        this.positiveButton = materialButton2;
    }

    public static DialogPickTimerTimeBinding bind(View view) {
        int i = R.id.hr_timepicker;
        NumberPicker numberPicker = (NumberPicker) ViewBindings.findChildViewById(view, i);
        if (numberPicker != null) {
            i = R.id.min_timepicker;
            NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, i);
            if (numberPicker2 != null) {
                i = R.id.negative_button;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton != null) {
                    i = R.id.positive_button;
                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton2 != null) {
                        return new DialogPickTimerTimeBinding((LinearLayout) view, numberPicker, numberPicker2, materialButton, materialButton2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogPickTimerTimeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogPickTimerTimeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_pick_timer_time, viewGroup, false);
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
