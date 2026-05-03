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
public final class GuestItemBinding implements ViewBinding {
    public final TextView guestLabel1;
    public final TextView guestLabel2;
    public final ImageView guestNoPhotoIcon;
    public final ConstraintLayout guestProfileLayout;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private GuestItemBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.guestLabel1 = textView;
        this.guestLabel2 = textView2;
        this.guestNoPhotoIcon = imageView;
        this.guestProfileLayout = constraintLayout2;
        this.rootLayout = constraintLayout3;
    }

    public static GuestItemBinding bind(View view) {
        int i = R.id.guestLabel1;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.guestLabel2;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.guest_no_photo_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.guestProfileLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                        return new GuestItemBinding(constraintLayout2, textView, textView2, imageView, constraintLayout, constraintLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static GuestItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GuestItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.guest_item, viewGroup, false);
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
