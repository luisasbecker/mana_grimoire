package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CirclePlaygroupItemBinding implements ViewBinding {
    public final CheckBox checkBox;
    public final ImageView noPhotoIcon;
    public final TextView playgroupDescription;
    public final TextView playgroupName;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;

    private CirclePlaygroupItemBinding(LinearLayout linearLayout, CheckBox checkBox, ImageView imageView, TextView textView, TextView textView2, CachedImageView cachedImageView, ConstraintLayout constraintLayout, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.checkBox = checkBox;
        this.noPhotoIcon = imageView;
        this.playgroupDescription = textView;
        this.playgroupName = textView2;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout;
        this.rootLayout = linearLayout2;
    }

    public static CirclePlaygroupItemBinding bind(View view) {
        int i = R.id.checkBox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
        if (checkBox != null) {
            i = R.id.no_photo_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.playgroupDescription;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.playgroupName;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.profile_icon;
                        CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                        if (cachedImageView != null) {
                            i = R.id.profileLayout;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                LinearLayout linearLayout = (LinearLayout) view;
                                return new CirclePlaygroupItemBinding(linearLayout, checkBox, imageView, textView, textView2, cachedImageView, constraintLayout, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static CirclePlaygroupItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CirclePlaygroupItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.circle_playgroup_item, viewGroup, false);
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
