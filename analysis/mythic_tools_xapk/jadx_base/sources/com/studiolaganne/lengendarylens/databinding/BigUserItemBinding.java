package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BigUserItemBinding implements ViewBinding {
    public final ImageView noPhotoIcon;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;

    private BigUserItemBinding(LinearLayout linearLayout, ImageView imageView, CachedImageView cachedImageView, ConstraintLayout constraintLayout, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.noPhotoIcon = imageView;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout;
        this.rootLayout = linearLayout2;
    }

    public static BigUserItemBinding bind(View view) {
        int i = R.id.no_photo_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.profile_icon;
            CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
            if (cachedImageView != null) {
                i = R.id.profileLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new BigUserItemBinding(linearLayout, imageView, cachedImageView, constraintLayout, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static BigUserItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BigUserItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.big_user_item, viewGroup, false);
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
