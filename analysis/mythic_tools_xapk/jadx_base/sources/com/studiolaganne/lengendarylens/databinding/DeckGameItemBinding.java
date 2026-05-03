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
public final class DeckGameItemBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout;
    public final LinearLayout bottomLayout;
    public final ImageView crownIcon;
    public final ImageView defaultProfileImage;
    public final TextView firstNameLabel;
    public final TextView gameName;
    public final ConstraintLayout iconBubbleLayout;
    public final ImageView noPhotoIcon;
    public final ConstraintLayout playgroundInfoLayout;
    public final ConstraintLayout playgroupInfoInnerLayout;
    public final ConstraintLayout profileIcon;
    public final CachedImageView profileIcon1;
    public final CachedImageView profileImage;
    public final ConstraintLayout profileLayout;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView timeLabel;
    public final LinearLayout topLayout;
    public final LinearLayout userLayout;
    public final TextView userNameLabel;
    public final NonInteractiveRecyclerView usersRecyclerView;
    public final TextView victoryLabel;
    public final TextView winnerLabel;
    public final ConstraintLayout winnerLayout;

    private DeckGameItemBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, ImageView imageView3, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, CachedImageView cachedImageView, CachedImageView cachedImageView2, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, TextView textView3, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView4, NonInteractiveRecyclerView nonInteractiveRecyclerView, TextView textView5, TextView textView6, ConstraintLayout constraintLayout8) {
        this.rootView = constraintLayout;
        this.accountInfoVerticalLayout = linearLayout;
        this.bottomLayout = linearLayout2;
        this.crownIcon = imageView;
        this.defaultProfileImage = imageView2;
        this.firstNameLabel = textView;
        this.gameName = textView2;
        this.iconBubbleLayout = constraintLayout2;
        this.noPhotoIcon = imageView3;
        this.playgroundInfoLayout = constraintLayout3;
        this.playgroupInfoInnerLayout = constraintLayout4;
        this.profileIcon = constraintLayout5;
        this.profileIcon1 = cachedImageView;
        this.profileImage = cachedImageView2;
        this.profileLayout = constraintLayout6;
        this.rootLayout = constraintLayout7;
        this.timeLabel = textView3;
        this.topLayout = linearLayout3;
        this.userLayout = linearLayout4;
        this.userNameLabel = textView4;
        this.usersRecyclerView = nonInteractiveRecyclerView;
        this.victoryLabel = textView5;
        this.winnerLabel = textView6;
        this.winnerLayout = constraintLayout8;
    }

    public static DeckGameItemBinding bind(View view) {
        int i = R.id.accountInfoVerticalLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.bottomLayout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.crownIcon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.defaultProfileImage;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.firstNameLabel;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.gameName;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.iconBubbleLayout;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout != null) {
                                    i = R.id.no_photo_icon;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = R.id.playgroundInfoLayout;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout2 != null) {
                                            i = R.id.playgroupInfoInnerLayout;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout3 != null) {
                                                i = R.id.profileIcon;
                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout4 != null) {
                                                    i = R.id.profile_icon;
                                                    CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                    if (cachedImageView != null) {
                                                        i = R.id.profileImage;
                                                        CachedImageView cachedImageView2 = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                        if (cachedImageView2 != null) {
                                                            i = R.id.profileLayout;
                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout5 != null) {
                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) view;
                                                                i = R.id.timeLabel;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView3 != null) {
                                                                    i = R.id.topLayout;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout3 != null) {
                                                                        i = R.id.userLayout;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout4 != null) {
                                                                            i = R.id.userNameLabel;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView4 != null) {
                                                                                i = R.id.usersRecyclerView;
                                                                                NonInteractiveRecyclerView nonInteractiveRecyclerView = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                if (nonInteractiveRecyclerView != null) {
                                                                                    i = R.id.victoryLabel;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.winnerLabel;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.winnerLayout;
                                                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (constraintLayout7 != null) {
                                                                                                return new DeckGameItemBinding(constraintLayout6, linearLayout, linearLayout2, imageView, imageView2, textView, textView2, constraintLayout, imageView3, constraintLayout2, constraintLayout3, constraintLayout4, cachedImageView, cachedImageView2, constraintLayout5, constraintLayout6, textView3, linearLayout3, linearLayout4, textView4, nonInteractiveRecyclerView, textView5, textView6, constraintLayout7);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DeckGameItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckGameItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_game_item, viewGroup, false);
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
