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
public final class DialogTimerLeftBinding implements ViewBinding {
    public final ImageView clockImage;
    public final TextView mainText;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private DialogTimerLeftBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.clockImage = imageView;
        this.mainText = textView;
        this.rootLayout = constraintLayout2;
    }

    public static DialogTimerLeftBinding bind(View view) {
        int i = R.id.clock_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.main_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.root_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    return new DialogTimerLeftBinding((ConstraintLayout) view, imageView, textView, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogTimerLeftBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogTimerLeftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_timer_left, viewGroup, false);
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
