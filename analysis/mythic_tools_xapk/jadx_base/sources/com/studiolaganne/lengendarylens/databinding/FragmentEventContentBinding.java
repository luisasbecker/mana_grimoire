package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentEventContentBinding implements ViewBinding {
    public final ImageView closeButton;
    public final FragmentContainerView fragmentContainer;
    public final ConstraintLayout headerLayout;
    public final TextView labelTextView;
    private final ConstraintLayout rootView;
    public final SeekBar seekBar;

    private FragmentEventContentBinding(ConstraintLayout constraintLayout, ImageView imageView, FragmentContainerView fragmentContainerView, ConstraintLayout constraintLayout2, TextView textView, SeekBar seekBar) {
        this.rootView = constraintLayout;
        this.closeButton = imageView;
        this.fragmentContainer = fragmentContainerView;
        this.headerLayout = constraintLayout2;
        this.labelTextView = textView;
        this.seekBar = seekBar;
    }

    public static FragmentEventContentBinding bind(View view) {
        int i = R.id.close_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.fragment_container;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
            if (fragmentContainerView != null) {
                i = R.id.header_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.labelTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.seekBar;
                        SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, i);
                        if (seekBar != null) {
                            return new FragmentEventContentBinding((ConstraintLayout) view, imageView, fragmentContainerView, constraintLayout, textView, seekBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentEventContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEventContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_event_content, viewGroup, false);
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
