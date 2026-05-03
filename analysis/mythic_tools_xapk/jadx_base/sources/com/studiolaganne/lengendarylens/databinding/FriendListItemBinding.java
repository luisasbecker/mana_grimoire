package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FriendListItemBinding implements ViewBinding {
    public final ConstraintLayout actionButtonLayout;
    public final TextView actionButtonText;
    public final ImageView dotsImage;
    public final ConstraintLayout dotsLayout;
    public final LinearLayout nameLayout;
    public final ImageView noPhotoIcon;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final LinearLayout roleLayout;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final TextView userFirstName;
    public final LinearLayout userLayout;
    public final TextView userName;

    private FriendListItemBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView, ImageView imageView, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, ImageView imageView2, CachedImageView cachedImageView, ConstraintLayout constraintLayout3, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView2, LinearLayout linearLayout5, TextView textView3) {
        this.rootView = linearLayout;
        this.actionButtonLayout = constraintLayout;
        this.actionButtonText = textView;
        this.dotsImage = imageView;
        this.dotsLayout = constraintLayout2;
        this.nameLayout = linearLayout2;
        this.noPhotoIcon = imageView2;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout3;
        this.roleLayout = linearLayout3;
        this.rootLayout = linearLayout4;
        this.userFirstName = textView2;
        this.userLayout = linearLayout5;
        this.userName = textView3;
    }

    public static FriendListItemBinding bind(View view) {
        int i = R.id.actionButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.actionButtonText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.dotsImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.dotsLayout;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.name_layout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.no_photo_icon;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.profile_icon;
                                CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                if (cachedImageView != null) {
                                    i = R.id.profileLayout;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout3 != null) {
                                        i = R.id.role_layout;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout2 != null) {
                                            LinearLayout linearLayout3 = (LinearLayout) view;
                                            i = R.id.userFirstName;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.user_layout;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout4 != null) {
                                                    i = R.id.userName;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        return new FriendListItemBinding(linearLayout3, constraintLayout, textView, imageView, constraintLayout2, linearLayout, imageView2, cachedImageView, constraintLayout3, linearLayout2, linearLayout3, textView2, linearLayout4, textView3);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FriendListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FriendListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.friend_list_item, viewGroup, false);
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
