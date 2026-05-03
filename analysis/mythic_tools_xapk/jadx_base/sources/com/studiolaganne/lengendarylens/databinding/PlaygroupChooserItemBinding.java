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
public final class PlaygroupChooserItemBinding implements ViewBinding {
    public final LinearLayout innerLayout;
    public final LinearLayout nameLayout;
    public final ImageView noPhotoIcon;
    public final TextView playgroupName;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final LinearLayout roleLayout;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView secondaryText;
    public final LinearLayout userLayout;
    public final TextView usersCount;
    public final ImageView usersIcon;

    private PlaygroupChooserItemBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, TextView textView, CachedImageView cachedImageView, ConstraintLayout constraintLayout2, LinearLayout linearLayout3, ConstraintLayout constraintLayout3, TextView textView2, LinearLayout linearLayout4, TextView textView3, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.innerLayout = linearLayout;
        this.nameLayout = linearLayout2;
        this.noPhotoIcon = imageView;
        this.playgroupName = textView;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout2;
        this.roleLayout = linearLayout3;
        this.rootLayout = constraintLayout3;
        this.secondaryText = textView2;
        this.userLayout = linearLayout4;
        this.usersCount = textView3;
        this.usersIcon = imageView2;
    }

    public static PlaygroupChooserItemBinding bind(View view) {
        int i = R.id.inner_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.name_layout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.no_photo_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.playgroupName;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.profile_icon;
                        CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                        if (cachedImageView != null) {
                            i = R.id.profileLayout;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                i = R.id.role_layout;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout3 != null) {
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                    i = R.id.secondaryText;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.user_layout;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout4 != null) {
                                            i = R.id.usersCount;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.usersIcon;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView2 != null) {
                                                    return new PlaygroupChooserItemBinding(constraintLayout2, linearLayout, linearLayout2, imageView, textView, cachedImageView, constraintLayout, linearLayout3, constraintLayout2, textView2, linearLayout4, textView3, imageView2);
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

    public static PlaygroupChooserItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PlaygroupChooserItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.playgroup_chooser_item, viewGroup, false);
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
