package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckListDestinationItemBinding implements ViewBinding {
    public final TextView deckListCount;
    public final ImageView deckListIcon;
    public final TextView deckListName;
    public final RadioButton deckListRadioButton;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private DeckListDestinationItemBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, RadioButton radioButton, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.deckListCount = textView;
        this.deckListIcon = imageView;
        this.deckListName = textView2;
        this.deckListRadioButton = radioButton;
        this.rootLayout = constraintLayout2;
    }

    public static DeckListDestinationItemBinding bind(View view) {
        int i = R.id.deckListCount;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.deckListIcon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.deckListName;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.deckListRadioButton;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                    if (radioButton != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        return new DeckListDestinationItemBinding(constraintLayout, textView, imageView, textView2, radioButton, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DeckListDestinationItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckListDestinationItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_list_destination_item, viewGroup, false);
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
