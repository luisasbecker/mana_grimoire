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
import com.studiolaganne.lengendarylens.NonInteractiveRecyclerView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PlaygroupItemBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout;
    public final LinearLayout bottomLayout;
    public final ImageView defaultProfileImage;
    public final ConstraintLayout iconBubbleLayout;
    public final ConstraintLayout messageBubbleLayout;
    public final TextView notificationCount;
    public final TextView pendingText;
    public final ConstraintLayout playgroundInfoLayout;
    public final TextView playgroupDescription;
    public final ConstraintLayout playgroupInfoInnerLayout;
    public final TextView playgroupName;
    public final ConstraintLayout profileIcon;
    public final CachedImageView profileImage;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView usersCount;
    public final ImageView usersIcon;
    public final NonInteractiveRecyclerView usersRecyclerView;

    private PlaygroupItemBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, ConstraintLayout constraintLayout4, TextView textView3, ConstraintLayout constraintLayout5, TextView textView4, ConstraintLayout constraintLayout6, CachedImageView cachedImageView, ConstraintLayout constraintLayout7, TextView textView5, ImageView imageView2, NonInteractiveRecyclerView nonInteractiveRecyclerView) {
        this.rootView = constraintLayout;
        this.accountInfoVerticalLayout = linearLayout;
        this.bottomLayout = linearLayout2;
        this.defaultProfileImage = imageView;
        this.iconBubbleLayout = constraintLayout2;
        this.messageBubbleLayout = constraintLayout3;
        this.notificationCount = textView;
        this.pendingText = textView2;
        this.playgroundInfoLayout = constraintLayout4;
        this.playgroupDescription = textView3;
        this.playgroupInfoInnerLayout = constraintLayout5;
        this.playgroupName = textView4;
        this.profileIcon = constraintLayout6;
        this.profileImage = cachedImageView;
        this.rootLayout = constraintLayout7;
        this.usersCount = textView5;
        this.usersIcon = imageView2;
        this.usersRecyclerView = nonInteractiveRecyclerView;
    }

    public static PlaygroupItemBinding bind(View view) {
        int i = R.id.accountInfoVerticalLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.bottomLayout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.defaultProfileImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.iconBubbleLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.messageBubbleLayout;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.notificationCount;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.pendingText;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.playgroundInfoLayout;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout3 != null) {
                                        i = R.id.playgroupDescription;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.playgroupInfoInnerLayout;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout4 != null) {
                                                i = R.id.playgroupName;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.profileIcon;
                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout5 != null) {
                                                        i = R.id.profileImage;
                                                        CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                        if (cachedImageView != null) {
                                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) view;
                                                            i = R.id.usersCount;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R.id.usersIcon;
                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView2 != null) {
                                                                    i = R.id.usersRecyclerView;
                                                                    NonInteractiveRecyclerView nonInteractiveRecyclerView = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                    if (nonInteractiveRecyclerView != null) {
                                                                        return new PlaygroupItemBinding(constraintLayout6, linearLayout, linearLayout2, imageView, constraintLayout, constraintLayout2, textView, textView2, constraintLayout3, textView3, constraintLayout4, textView4, constraintLayout5, cachedImageView, constraintLayout6, textView5, imageView2, nonInteractiveRecyclerView);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static PlaygroupItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PlaygroupItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.playgroup_item, viewGroup, false);
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
