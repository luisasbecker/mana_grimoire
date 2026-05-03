package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentNewEventBinding implements ViewBinding {
    public final TextView eventTypeHeader;
    public final Spinner eventTypeSpinner;
    public final Guideline guidelineEnd;
    public final Guideline guidelineStart;
    public final TextView matchTypeHeader;
    public final Spinner matchTypeSpinner;
    public final MaterialButton nextButton;
    public final TextView pairingTypeHeader;
    public final Spinner pairingTypeSpinner;
    private final View rootView;
    public final View spacer;

    private FragmentNewEventBinding(View view, TextView textView, Spinner spinner, Guideline guideline, Guideline guideline2, TextView textView2, Spinner spinner2, MaterialButton materialButton, TextView textView3, Spinner spinner3, View view2) {
        this.rootView = view;
        this.eventTypeHeader = textView;
        this.eventTypeSpinner = spinner;
        this.guidelineEnd = guideline;
        this.guidelineStart = guideline2;
        this.matchTypeHeader = textView2;
        this.matchTypeSpinner = spinner2;
        this.nextButton = materialButton;
        this.pairingTypeHeader = textView3;
        this.pairingTypeSpinner = spinner3;
        this.spacer = view2;
    }

    public static FragmentNewEventBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.event_type_header;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.event_type_spinner;
            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, i);
            if (spinner != null) {
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline_end);
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline_start);
                i = R.id.match_type_header;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.match_type_spinner;
                    Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, i);
                    if (spinner2 != null) {
                        i = R.id.next_button;
                        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                        if (materialButton != null) {
                            i = R.id.pairing_type_header;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.pairing_type_spinner;
                                Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(view, i);
                                if (spinner3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.spacer))) != null) {
                                    return new FragmentNewEventBinding(view, textView, spinner, guideline, guideline2, textView2, spinner2, materialButton, textView3, spinner3, viewFindChildViewById);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentNewEventBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentNewEventBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_new_event, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }
}
