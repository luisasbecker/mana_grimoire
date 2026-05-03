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
public final class LoadMoreItemBinding implements ViewBinding {
    public final ConstraintLayout logoutButtonLayout;
    public final TextView logoutButtonText;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private LoadMoreItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.logoutButtonLayout = constraintLayout2;
        this.logoutButtonText = textView;
        this.rootLayout = constraintLayout3;
    }

    public static LoadMoreItemBinding bind(View view) {
        int i = R.id.logoutButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.logoutButtonText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                return new LoadMoreItemBinding(constraintLayout2, constraintLayout, textView, constraintLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LoadMoreItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LoadMoreItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.load_more_item, viewGroup, false);
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
