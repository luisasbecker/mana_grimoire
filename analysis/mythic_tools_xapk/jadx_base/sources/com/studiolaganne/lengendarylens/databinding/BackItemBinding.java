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
public final class BackItemBinding implements ViewBinding {
    public final ConstraintLayout cardView;
    public final TextView icon;
    public final TextView playerNameTextView;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private BackItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.cardView = constraintLayout2;
        this.icon = textView;
        this.playerNameTextView = textView2;
        this.rootLayout = constraintLayout3;
    }

    public static BackItemBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.icon;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.player_name_text_view;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.root_layout;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    return new BackItemBinding(constraintLayout, constraintLayout, textView, textView2, constraintLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static BackItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BackItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.back_item, viewGroup, false);
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
