package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckSelectionToolbarBinding implements ViewBinding {
    public final LinearLayout deckSelectionToolbarLayout;
    private final LinearLayout rootView;
    public final TextView selectionClearTextView;
    public final TextView selectionCountTextView;
    public final TextView selectionDeleteTextView;
    public final TextView selectionMoveTextView;
    public final TextView selectionSelectAllTextView;

    private DeckSelectionToolbarBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.deckSelectionToolbarLayout = linearLayout2;
        this.selectionClearTextView = textView;
        this.selectionCountTextView = textView2;
        this.selectionDeleteTextView = textView3;
        this.selectionMoveTextView = textView4;
        this.selectionSelectAllTextView = textView5;
    }

    public static DeckSelectionToolbarBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.selectionClearTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.selectionCountTextView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.selectionDeleteTextView;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.selectionMoveTextView;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.selectionSelectAllTextView;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView5 != null) {
                            return new DeckSelectionToolbarBinding(linearLayout, linearLayout, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DeckSelectionToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckSelectionToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_selection_toolbar, viewGroup, false);
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
