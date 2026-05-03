package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class MoreUserItemBinding implements ViewBinding {
    public final TextView label;
    public final ConstraintLayout profileLayout;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;

    private MoreUserItemBinding(LinearLayout linearLayout, TextView textView, ConstraintLayout constraintLayout, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.label = textView;
        this.profileLayout = constraintLayout;
        this.rootLayout = linearLayout2;
    }

    public static MoreUserItemBinding bind(View view) {
        int i = R.id.label;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.profileLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new MoreUserItemBinding(linearLayout, textView, constraintLayout, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static MoreUserItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MoreUserItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.more_user_item, viewGroup, false);
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
