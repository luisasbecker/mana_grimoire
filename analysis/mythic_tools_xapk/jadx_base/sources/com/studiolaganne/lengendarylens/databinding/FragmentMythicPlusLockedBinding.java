package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentMythicPlusLockedBinding implements ViewBinding {
    public final TextView lockedButton;
    public final ImageView lockedIcon;
    public final TextView lockedMessage;
    private final LinearLayout rootView;

    private FragmentMythicPlusLockedBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2) {
        this.rootView = linearLayout;
        this.lockedButton = textView;
        this.lockedIcon = imageView;
        this.lockedMessage = textView2;
    }

    public static FragmentMythicPlusLockedBinding bind(View view) {
        int i = R.id.lockedButton;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.lockedIcon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.lockedMessage;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new FragmentMythicPlusLockedBinding((LinearLayout) view, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentMythicPlusLockedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMythicPlusLockedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_mythic_plus_locked, viewGroup, false);
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
