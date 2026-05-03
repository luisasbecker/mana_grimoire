package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckSelectionItemBinding implements ViewBinding {
    public final TextView deckNameTextView;
    public final RadioButton deckRadioButton;
    public final ConstraintLayout deckSelectionItemRoot;
    private final ConstraintLayout rootView;

    private DeckSelectionItemBinding(ConstraintLayout constraintLayout, TextView textView, RadioButton radioButton, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.deckNameTextView = textView;
        this.deckRadioButton = radioButton;
        this.deckSelectionItemRoot = constraintLayout2;
    }

    public static DeckSelectionItemBinding bind(View view) {
        int i = R.id.deckNameTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.deckRadioButton;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
            if (radioButton != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new DeckSelectionItemBinding(constraintLayout, textView, radioButton, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DeckSelectionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckSelectionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_selection_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
