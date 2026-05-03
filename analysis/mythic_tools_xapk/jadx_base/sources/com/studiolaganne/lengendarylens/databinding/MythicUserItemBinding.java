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
public final class MythicUserItemBinding implements ViewBinding {
    public final ImageView mythicNoPhotoIcon;
    public final ConstraintLayout mythicProfileLayout;
    public final TextView mythicUserLabel;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private MythicUserItemBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.mythicNoPhotoIcon = imageView;
        this.mythicProfileLayout = constraintLayout2;
        this.mythicUserLabel = textView;
        this.rootLayout = constraintLayout3;
    }

    public static MythicUserItemBinding bind(View view) {
        int i = R.id.mythic_no_photo_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.mythicProfileLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.mythicUserLabel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                    return new MythicUserItemBinding(constraintLayout2, imageView, constraintLayout, textView, constraintLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static MythicUserItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MythicUserItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.mythic_user_item, viewGroup, false);
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
