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
public final class FriendItemBinding implements ViewBinding {
    public final ImageView noPhotoIcon;
    public final TextView playerFirstName;
    public final CachedImageView playerImage;
    public final ConstraintLayout playerLayout;
    public final TextView playerUserName;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final ConstraintLayout statusLayout;
    public final TextView statusText;

    private FriendItemBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, CachedImageView cachedImageView, ConstraintLayout constraintLayout2, TextView textView2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView3) {
        this.rootView = constraintLayout;
        this.noPhotoIcon = imageView;
        this.playerFirstName = textView;
        this.playerImage = cachedImageView;
        this.playerLayout = constraintLayout2;
        this.playerUserName = textView2;
        this.rootLayout = constraintLayout3;
        this.statusLayout = constraintLayout4;
        this.statusText = textView3;
    }

    public static FriendItemBinding bind(View view) {
        int i = R.id.no_photo_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.player_first_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.player_image;
                CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                if (cachedImageView != null) {
                    i = R.id.playerLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.player_user_name;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                            i = R.id.statusLayout;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout3 != null) {
                                i = R.id.statusText;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new FriendItemBinding(constraintLayout2, imageView, textView, cachedImageView, constraintLayout, textView2, constraintLayout2, constraintLayout3, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FriendItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FriendItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.friend_item, viewGroup, false);
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
