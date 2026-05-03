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
import com.google.android.flexbox.FlexboxLayout;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.NonInteractiveRecyclerView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class GameItemBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout;
    public final ImageView assassinsImage;
    public final ConstraintLayout bottomLayout;
    public final ImageView defaultProfileImage;
    public final ImageView dotsImage;
    public final ConstraintLayout dotsLayout;
    public final LinearLayout firstLayout;
    public final TextView gameName;
    public final ImageView guardianImage;
    public final TextView interLabel1;
    public final TextView interLabel2;
    public final ImageView leaderImage;
    public final LinearLayout nameAndPlaygroupLayout;
    public final ImageView noteImage;
    public final ConstraintLayout playgroundInfoLayout;
    public final ConstraintLayout playgroupInfoInnerLayout;
    public final TextView playgroupName;
    public final CachedImageView profileImage;
    public final ConstraintLayout profileLayout;
    public final ConstraintLayout rootLayout;
    public final LinearLayout rootLinearLayout;
    private final LinearLayout rootView;
    public final LinearLayout secondLayout;
    public final FlexboxLayout tagsFlexboxLayout;
    public final TextView timeLabel;
    public final LinearLayout topLayout;
    public final ImageView traitorsImage;
    public final NonInteractiveRecyclerView usersRecyclerView;
    public final NonInteractiveRecyclerView usersRecyclerView2;
    public final NonInteractiveRecyclerView usersRecyclerView3;
    public final TextView victoryLabel;
    public final TextView winnersHeaderLabel;
    public final TextView winnersLabel;
    public final ConstraintLayout winnersLayout;
    public final NonInteractiveRecyclerView winnersRecyclerView;

    private GameItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, ConstraintLayout constraintLayout, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout2, LinearLayout linearLayout3, TextView textView, ImageView imageView4, TextView textView2, TextView textView3, ImageView imageView5, LinearLayout linearLayout4, ImageView imageView6, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView4, CachedImageView cachedImageView, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, LinearLayout linearLayout5, LinearLayout linearLayout6, FlexboxLayout flexboxLayout, TextView textView5, LinearLayout linearLayout7, ImageView imageView7, NonInteractiveRecyclerView nonInteractiveRecyclerView, NonInteractiveRecyclerView nonInteractiveRecyclerView2, NonInteractiveRecyclerView nonInteractiveRecyclerView3, TextView textView6, TextView textView7, TextView textView8, ConstraintLayout constraintLayout7, NonInteractiveRecyclerView nonInteractiveRecyclerView4) {
        this.rootView = linearLayout;
        this.accountInfoVerticalLayout = linearLayout2;
        this.assassinsImage = imageView;
        this.bottomLayout = constraintLayout;
        this.defaultProfileImage = imageView2;
        this.dotsImage = imageView3;
        this.dotsLayout = constraintLayout2;
        this.firstLayout = linearLayout3;
        this.gameName = textView;
        this.guardianImage = imageView4;
        this.interLabel1 = textView2;
        this.interLabel2 = textView3;
        this.leaderImage = imageView5;
        this.nameAndPlaygroupLayout = linearLayout4;
        this.noteImage = imageView6;
        this.playgroundInfoLayout = constraintLayout3;
        this.playgroupInfoInnerLayout = constraintLayout4;
        this.playgroupName = textView4;
        this.profileImage = cachedImageView;
        this.profileLayout = constraintLayout5;
        this.rootLayout = constraintLayout6;
        this.rootLinearLayout = linearLayout5;
        this.secondLayout = linearLayout6;
        this.tagsFlexboxLayout = flexboxLayout;
        this.timeLabel = textView5;
        this.topLayout = linearLayout7;
        this.traitorsImage = imageView7;
        this.usersRecyclerView = nonInteractiveRecyclerView;
        this.usersRecyclerView2 = nonInteractiveRecyclerView2;
        this.usersRecyclerView3 = nonInteractiveRecyclerView3;
        this.victoryLabel = textView6;
        this.winnersHeaderLabel = textView7;
        this.winnersLabel = textView8;
        this.winnersLayout = constraintLayout7;
        this.winnersRecyclerView = nonInteractiveRecyclerView4;
    }

    public static GameItemBinding bind(View view) {
        int i = R.id.accountInfoVerticalLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.assassinsImage;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.bottomLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.defaultProfileImage;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.dotsImage;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.dotsLayout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = R.id.firstLayout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = R.id.gameName;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.guardianImage;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView4 != null) {
                                            i = R.id.interLabel1;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.interLabel2;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.leaderImage;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView5 != null) {
                                                        i = R.id.nameAndPlaygroupLayout;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.noteImage;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView6 != null) {
                                                                i = R.id.playgroundInfoLayout;
                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout3 != null) {
                                                                    i = R.id.playgroupInfoInnerLayout;
                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout4 != null) {
                                                                        i = R.id.playgroupName;
                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView4 != null) {
                                                                            i = R.id.profileImage;
                                                                            CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (cachedImageView != null) {
                                                                                i = R.id.profileLayout;
                                                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (constraintLayout5 != null) {
                                                                                    i = R.id.root_layout;
                                                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (constraintLayout6 != null) {
                                                                                        LinearLayout linearLayout4 = (LinearLayout) view;
                                                                                        i = R.id.secondLayout;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout5 != null) {
                                                                                            i = R.id.tagsFlexboxLayout;
                                                                                            FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (flexboxLayout != null) {
                                                                                                i = R.id.timeLabel;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.topLayout;
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout6 != null) {
                                                                                                        i = R.id.traitorsImage;
                                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (imageView7 != null) {
                                                                                                            i = R.id.usersRecyclerView;
                                                                                                            NonInteractiveRecyclerView nonInteractiveRecyclerView = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (nonInteractiveRecyclerView != null) {
                                                                                                                i = R.id.usersRecyclerView2;
                                                                                                                NonInteractiveRecyclerView nonInteractiveRecyclerView2 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (nonInteractiveRecyclerView2 != null) {
                                                                                                                    i = R.id.usersRecyclerView3;
                                                                                                                    NonInteractiveRecyclerView nonInteractiveRecyclerView3 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (nonInteractiveRecyclerView3 != null) {
                                                                                                                        i = R.id.victoryLabel;
                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView6 != null) {
                                                                                                                            i = R.id.winnersHeaderLabel;
                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView7 != null) {
                                                                                                                                i = R.id.winnersLabel;
                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView8 != null) {
                                                                                                                                    i = R.id.winnersLayout;
                                                                                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (constraintLayout7 != null) {
                                                                                                                                        i = R.id.winnersRecyclerView;
                                                                                                                                        NonInteractiveRecyclerView nonInteractiveRecyclerView4 = (NonInteractiveRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (nonInteractiveRecyclerView4 != null) {
                                                                                                                                            return new GameItemBinding(linearLayout4, linearLayout, imageView, constraintLayout, imageView2, imageView3, constraintLayout2, linearLayout2, textView, imageView4, textView2, textView3, imageView5, linearLayout3, imageView6, constraintLayout3, constraintLayout4, textView4, cachedImageView, constraintLayout5, constraintLayout6, linearLayout4, linearLayout5, flexboxLayout, textView5, linearLayout6, imageView7, nonInteractiveRecyclerView, nonInteractiveRecyclerView2, nonInteractiveRecyclerView3, textView6, textView7, textView8, constraintLayout7, nonInteractiveRecyclerView4);
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

    public static GameItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GameItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.game_item, viewGroup, false);
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
