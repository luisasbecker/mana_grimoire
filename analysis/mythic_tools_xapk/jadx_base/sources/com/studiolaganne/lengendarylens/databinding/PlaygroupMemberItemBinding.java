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
public final class PlaygroupMemberItemBinding implements ViewBinding {
    public final ConstraintLayout actionButtonLayout;
    public final TextView actionButtonText;
    public final TextView adminBox;
    public final ImageView dotsImage;
    public final ConstraintLayout dotsLayout;
    public final LinearLayout nameLayout;
    public final ImageView noPhotoIcon;
    public final TextView ownerBox;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final LinearLayout roleLayout;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final TextView userFirstName;
    public final LinearLayout userLayout;
    public final TextView userName;
    public final TextView youBox;

    private PlaygroupMemberItemBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, ImageView imageView2, TextView textView3, CachedImageView cachedImageView, ConstraintLayout constraintLayout3, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView4, LinearLayout linearLayout5, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.actionButtonLayout = constraintLayout;
        this.actionButtonText = textView;
        this.adminBox = textView2;
        this.dotsImage = imageView;
        this.dotsLayout = constraintLayout2;
        this.nameLayout = linearLayout2;
        this.noPhotoIcon = imageView2;
        this.ownerBox = textView3;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout3;
        this.roleLayout = linearLayout3;
        this.rootLayout = linearLayout4;
        this.userFirstName = textView4;
        this.userLayout = linearLayout5;
        this.userName = textView5;
        this.youBox = textView6;
    }

    public static PlaygroupMemberItemBinding bind(View view) {
        int i = R.id.actionButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.actionButtonText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.adminBox;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
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
                                    i = R.id.ownerBox;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
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
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.user_layout;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout4 != null) {
                                                            i = R.id.userName;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R.id.youBox;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView6 != null) {
                                                                    return new PlaygroupMemberItemBinding(linearLayout3, constraintLayout, textView, textView2, imageView, constraintLayout2, linearLayout, imageView2, textView3, cachedImageView, constraintLayout3, linearLayout2, linearLayout3, textView4, linearLayout4, textView5, textView6);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static PlaygroupMemberItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PlaygroupMemberItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.playgroup_member_item, viewGroup, false);
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
