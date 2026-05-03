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
public final class PlaygroupListItemBinding implements ViewBinding {
    public final ConstraintLayout actionButtonLayout;
    public final TextView actionButtonText;
    public final LinearLayout innerLayout;
    public final ConstraintLayout messageBubbleLayout;
    public final LinearLayout nameLayout;
    public final ImageView noPhotoIcon;
    public final TextView notificationCount;
    public final TextView playgroupName;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final LinearLayout roleLayout;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView secondaryText;
    public final LinearLayout userLayout;

    private PlaygroupListItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, LinearLayout linearLayout, ConstraintLayout constraintLayout3, LinearLayout linearLayout2, ImageView imageView, TextView textView2, TextView textView3, CachedImageView cachedImageView, ConstraintLayout constraintLayout4, LinearLayout linearLayout3, ConstraintLayout constraintLayout5, TextView textView4, LinearLayout linearLayout4) {
        this.rootView = constraintLayout;
        this.actionButtonLayout = constraintLayout2;
        this.actionButtonText = textView;
        this.innerLayout = linearLayout;
        this.messageBubbleLayout = constraintLayout3;
        this.nameLayout = linearLayout2;
        this.noPhotoIcon = imageView;
        this.notificationCount = textView2;
        this.playgroupName = textView3;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout4;
        this.roleLayout = linearLayout3;
        this.rootLayout = constraintLayout5;
        this.secondaryText = textView4;
        this.userLayout = linearLayout4;
    }

    public static PlaygroupListItemBinding bind(View view) {
        int i = R.id.actionButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.actionButtonText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.inner_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.messageBubbleLayout;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.name_layout;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R.id.no_photo_icon;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.notificationCount;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.playgroupName;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.profile_icon;
                                        CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                        if (cachedImageView != null) {
                                            i = R.id.profileLayout;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout3 != null) {
                                                i = R.id.role_layout;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout3 != null) {
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view;
                                                    i = R.id.secondaryText;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.user_layout;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout4 != null) {
                                                            return new PlaygroupListItemBinding(constraintLayout4, constraintLayout, textView, linearLayout, constraintLayout2, linearLayout2, imageView, textView2, textView3, cachedImageView, constraintLayout3, linearLayout3, constraintLayout4, textView4, linearLayout4);
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

    public static PlaygroupListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PlaygroupListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.playgroup_list_item, viewGroup, false);
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
