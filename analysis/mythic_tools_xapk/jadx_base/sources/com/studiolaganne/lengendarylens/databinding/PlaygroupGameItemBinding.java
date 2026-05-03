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
public final class PlaygroupGameItemBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout;
    public final LinearLayout bottomLayout;
    public final ImageView crownIcon;
    public final ImageView deckIcon;
    public final LinearLayout deckLayout;
    public final TextView deckName;
    public final ImageView dotsImage;
    public final ConstraintLayout dotsLayout;
    public final TextView firstNameLabel;
    public final TextView gameName;
    public final ImageView noPhotoIcon;
    public final ConstraintLayout playgroundInfoLayout;
    public final ConstraintLayout playgroupInfoInnerLayout;
    public final CachedImageView profileIcon;
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
    public final LinearLayout winnerUserInnerLayout;

    private PlaygroupGameItemBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout3, TextView textView, ImageView imageView3, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, ImageView imageView4, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, CachedImageView cachedImageView, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, TextView textView4, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView5, NonInteractiveRecyclerView nonInteractiveRecyclerView, TextView textView6, TextView textView7, ConstraintLayout constraintLayout7, LinearLayout linearLayout6) {
        this.rootView = constraintLayout;
        this.accountInfoVerticalLayout = linearLayout;
        this.bottomLayout = linearLayout2;
        this.crownIcon = imageView;
        this.deckIcon = imageView2;
        this.deckLayout = linearLayout3;
        this.deckName = textView;
        this.dotsImage = imageView3;
        this.dotsLayout = constraintLayout2;
        this.firstNameLabel = textView2;
        this.gameName = textView3;
        this.noPhotoIcon = imageView4;
        this.playgroundInfoLayout = constraintLayout3;
        this.playgroupInfoInnerLayout = constraintLayout4;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout5;
        this.rootLayout = constraintLayout6;
        this.timeLabel = textView4;
        this.topLayout = linearLayout4;
        this.userLayout = linearLayout5;
        this.userNameLabel = textView5;
        this.usersRecyclerView = nonInteractiveRecyclerView;
        this.victoryLabel = textView6;
        this.winnerLabel = textView7;
        this.winnerLayout = constraintLayout7;
        this.winnerUserInnerLayout = linearLayout6;
    }

    public static PlaygroupGameItemBinding bind(View view) {
        int i = R.id.accountInfoVerticalLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.bottomLayout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.crownIcon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.deckIcon;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.deckLayout;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null) {
                            i = R.id.deckName;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.dotsImage;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.dotsLayout;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout != null) {
                                        i = R.id.firstNameLabel;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.gameName;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.no_photo_icon;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView4 != null) {
                                                    i = R.id.playgroundInfoLayout;
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout2 != null) {
                                                        i = R.id.playgroupInfoInnerLayout;
                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout3 != null) {
                                                            i = R.id.profile_icon;
                                                            CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                            if (cachedImageView != null) {
                                                                i = R.id.profileLayout;
                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout4 != null) {
                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) view;
                                                                    i = R.id.timeLabel;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.topLayout;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout4 != null) {
                                                                            i = R.id.userLayout;
                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout5 != null) {
                                                                                i = R.id.userNameLabel;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView5 != null) {
                                                                                    i = R.id.usersRecyclerView;
                                                                                    NonInteractiveRecyclerView nonInteractiveRecyclerView = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                    if (nonInteractiveRecyclerView != null) {
                                                                                        i = R.id.victoryLabel;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.winnerLabel;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView7 != null) {
                                                                                                i = R.id.winnerLayout;
                                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (constraintLayout6 != null) {
                                                                                                    i = R.id.winnerUserInnerLayout;
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout6 != null) {
                                                                                                        return new PlaygroupGameItemBinding(constraintLayout5, linearLayout, linearLayout2, imageView, imageView2, linearLayout3, textView, imageView3, constraintLayout, textView2, textView3, imageView4, constraintLayout2, constraintLayout3, cachedImageView, constraintLayout4, constraintLayout5, textView4, linearLayout4, linearLayout5, textView5, nonInteractiveRecyclerView, textView6, textView7, constraintLayout6, linearLayout6);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static PlaygroupGameItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PlaygroupGameItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.playgroup_game_item, viewGroup, false);
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
