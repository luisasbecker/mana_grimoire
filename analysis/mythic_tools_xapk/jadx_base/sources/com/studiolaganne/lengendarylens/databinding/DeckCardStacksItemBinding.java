package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;
import com.studiolaganne.lengendarylens.StackedCardsView;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckCardStacksItemBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final StackedCardsView stackedCardsView;

    private DeckCardStacksItemBinding(ConstraintLayout constraintLayout, StackedCardsView stackedCardsView) {
        this.rootView = constraintLayout;
        this.stackedCardsView = stackedCardsView;
    }

    public static DeckCardStacksItemBinding bind(View view) {
        int i = R.id.stackedCardsView;
        StackedCardsView stackedCardsView = (StackedCardsView) ViewBindings.findChildViewById(view, i);
        if (stackedCardsView != null) {
            return new DeckCardStacksItemBinding((ConstraintLayout) view, stackedCardsView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DeckCardStacksItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckCardStacksItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_card_stacks_item, viewGroup, false);
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
