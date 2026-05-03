package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckItemSharedDecksBinding implements ViewBinding {
    public final TextView icon;
    public final ConstraintLayout innerLayout;
    public final TextView label;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private DeckItemSharedDecksBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.icon = textView;
        this.innerLayout = constraintLayout2;
        this.label = textView2;
        this.rootLayout = constraintLayout3;
    }

    public static DeckItemSharedDecksBinding bind(View view) {
        int i = R.id.icon;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.innerLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.label;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                    return new DeckItemSharedDecksBinding(constraintLayout2, textView, constraintLayout, textView2, constraintLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DeckItemSharedDecksBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckItemSharedDecksBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_item_shared_decks, viewGroup, false);
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
