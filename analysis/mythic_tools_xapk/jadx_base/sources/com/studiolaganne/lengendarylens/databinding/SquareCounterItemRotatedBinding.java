package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SquareCounterItemRotatedBinding implements ViewBinding {
    public final ConstraintLayout cardView;
    public final TextView counterNameTextView;
    public final ImageView icon;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private SquareCounterItemRotatedBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ImageView imageView, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.cardView = constraintLayout2;
        this.counterNameTextView = textView;
        this.icon = imageView;
        this.rootLayout = constraintLayout3;
    }

    public static SquareCounterItemRotatedBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.counter_name_text_view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.root_layout;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    return new SquareCounterItemRotatedBinding(constraintLayout, constraintLayout, textView, imageView, constraintLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static SquareCounterItemRotatedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SquareCounterItemRotatedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.square_counter_item_rotated, viewGroup, false);
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
