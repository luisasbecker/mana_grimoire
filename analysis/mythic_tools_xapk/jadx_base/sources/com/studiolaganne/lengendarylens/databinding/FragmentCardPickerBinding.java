package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentCardPickerBinding implements ViewBinding {
    public final ImageView chevronDown;
    public final FrameLayout fragmentContainer;
    public final ConstraintLayout headerLayout;
    private final ConstraintLayout rootView;
    public final TextView titleTextView;

    private FragmentCardPickerBinding(ConstraintLayout constraintLayout, ImageView imageView, FrameLayout frameLayout, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.chevronDown = imageView;
        this.fragmentContainer = frameLayout;
        this.headerLayout = constraintLayout2;
        this.titleTextView = textView;
    }

    public static FragmentCardPickerBinding bind(View view) {
        int i = R.id.chevron_down;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.fragment_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.headerLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.titleTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new FragmentCardPickerBinding((ConstraintLayout) view, imageView, frameLayout, constraintLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentCardPickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCardPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_card_picker, viewGroup, false);
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
