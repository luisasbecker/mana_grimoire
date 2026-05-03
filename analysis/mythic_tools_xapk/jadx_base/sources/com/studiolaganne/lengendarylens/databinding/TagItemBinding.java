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
public final class TagItemBinding implements ViewBinding {
    public final ConstraintLayout existingTag1Layout;
    private final ConstraintLayout rootView;
    public final ImageView tagIcon;
    public final TextView tagName;

    private TagItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.existingTag1Layout = constraintLayout2;
        this.tagIcon = imageView;
        this.tagName = textView;
    }

    public static TagItemBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.tagIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.tagName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new TagItemBinding(constraintLayout, constraintLayout, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TagItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TagItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.tag_item, viewGroup, false);
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
