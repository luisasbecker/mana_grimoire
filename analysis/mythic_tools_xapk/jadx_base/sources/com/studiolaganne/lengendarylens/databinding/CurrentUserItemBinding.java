package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CurrentUserItemBinding implements ViewBinding {
    public final ImageView noPhotoIcon;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView userFirstName;
    public final TextView userName;

    private CurrentUserItemBinding(ConstraintLayout constraintLayout, ImageView imageView, CachedImageView cachedImageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.noPhotoIcon = imageView;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout2;
        this.rootLayout = constraintLayout3;
        this.userFirstName = textView;
        this.userName = textView2;
    }

    public static CurrentUserItemBinding bind(View view) {
        int i = R.id.no_photo_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.profile_icon;
            CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
            if (cachedImageView != null) {
                i = R.id.profileLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                    i = R.id.userFirstName;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.userName;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new CurrentUserItemBinding(constraintLayout2, imageView, cachedImageView, constraintLayout, constraintLayout2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static CurrentUserItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CurrentUserItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.current_user_item, viewGroup, false);
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
