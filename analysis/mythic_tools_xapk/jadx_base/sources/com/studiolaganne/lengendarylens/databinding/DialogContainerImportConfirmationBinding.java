package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogContainerImportConfirmationBinding implements ViewBinding {
    public final LinearLayout buttonContainer;
    public final LinearLayout dialogRoot;
    public final MaterialButton negativeButton;
    public final MaterialButton positiveButton;
    private final LinearLayout rootView;
    public final TextView summary;
    public final ScrollView summaryScroll;
    public final TextView title;

    private DialogContainerImportConfirmationBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, MaterialButton materialButton, MaterialButton materialButton2, TextView textView, ScrollView scrollView, TextView textView2) {
        this.rootView = linearLayout;
        this.buttonContainer = linearLayout2;
        this.dialogRoot = linearLayout3;
        this.negativeButton = materialButton;
        this.positiveButton = materialButton2;
        this.summary = textView;
        this.summaryScroll = scrollView;
        this.title = textView2;
    }

    public static DialogContainerImportConfirmationBinding bind(View view) {
        int i = R.id.button_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) view;
            i = R.id.negative_button;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.positive_button;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                if (materialButton2 != null) {
                    i = R.id.summary;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.summary_scroll;
                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                        if (scrollView != null) {
                            i = R.id.title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new DialogContainerImportConfirmationBinding(linearLayout2, linearLayout, linearLayout2, materialButton, materialButton2, textView, scrollView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogContainerImportConfirmationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogContainerImportConfirmationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_container_import_confirmation, viewGroup, false);
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
