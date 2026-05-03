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
public final class DialogDeckImportConfirmationBinding implements ViewBinding {
    public final LinearLayout buttonContainer;
    public final MaterialButton cancelButton;
    public final LinearLayout cardsLayout;
    public final LinearLayout dialogRoot;
    public final TextView expandButton;
    public final MaterialButton importButton;
    private final LinearLayout rootView;
    public final ScrollView scrollView;
    public final TextView summary;
    public final TextView title;

    private DialogDeckImportConfirmationBinding(LinearLayout linearLayout, LinearLayout linearLayout2, MaterialButton materialButton, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, MaterialButton materialButton2, ScrollView scrollView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.buttonContainer = linearLayout2;
        this.cancelButton = materialButton;
        this.cardsLayout = linearLayout3;
        this.dialogRoot = linearLayout4;
        this.expandButton = textView;
        this.importButton = materialButton2;
        this.scrollView = scrollView;
        this.summary = textView2;
        this.title = textView3;
    }

    public static DialogDeckImportConfirmationBinding bind(View view) {
        int i = R.id.button_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.cancel_button;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.cards_layout;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    LinearLayout linearLayout3 = (LinearLayout) view;
                    i = R.id.expand_button;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.import_button;
                        MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                        if (materialButton2 != null) {
                            i = R.id.scroll_view;
                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                            if (scrollView != null) {
                                i = R.id.summary;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.title;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        return new DialogDeckImportConfirmationBinding(linearLayout3, linearLayout, materialButton, linearLayout2, linearLayout3, textView, materialButton2, scrollView, textView2, textView3);
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

    public static DialogDeckImportConfirmationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogDeckImportConfirmationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_deck_import_confirmation, viewGroup, false);
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
