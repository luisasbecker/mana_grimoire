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
public final class NoItemsBinding implements ViewBinding {
    public final TextView playerNameTextView;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private NoItemsBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.playerNameTextView = textView;
        this.rootLayout = constraintLayout2;
    }

    public static NoItemsBinding bind(View view) {
        int i = R.id.player_name_text_view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        return new NoItemsBinding(constraintLayout, textView, constraintLayout);
    }

    public static NoItemsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NoItemsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.no_items, viewGroup, false);
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
