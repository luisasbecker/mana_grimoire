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
public final class PlaygroupStatsMemberItemBinding implements ViewBinding {
    public final TextView drawsValueLabel;
    public final TextView gamesLabel;
    public final TextView gamesValueLabel;
    public final TextView lossesLabel;
    public final TextView lossesValueLabel;
    public final ImageView noPhotoIcon;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final LinearLayout statsLayout;
    public final LinearLayout statsLayout1;
    public final LinearLayout statsLayout2;
    public final TextView userFirstName;
    public final LinearLayout userLayout;
    public final TextView userName;
    public final TextView winRateLabel;
    public final TextView winRateValueLabel;
    public final TextView winsLabel;
    public final TextView winsValueLabel;

    private PlaygroupStatsMemberItemBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ImageView imageView, CachedImageView cachedImageView, ConstraintLayout constraintLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView6, LinearLayout linearLayout6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = linearLayout;
        this.drawsValueLabel = textView;
        this.gamesLabel = textView2;
        this.gamesValueLabel = textView3;
        this.lossesLabel = textView4;
        this.lossesValueLabel = textView5;
        this.noPhotoIcon = imageView;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout;
        this.rootLayout = linearLayout2;
        this.statsLayout = linearLayout3;
        this.statsLayout1 = linearLayout4;
        this.statsLayout2 = linearLayout5;
        this.userFirstName = textView6;
        this.userLayout = linearLayout6;
        this.userName = textView7;
        this.winRateLabel = textView8;
        this.winRateValueLabel = textView9;
        this.winsLabel = textView10;
        this.winsValueLabel = textView11;
    }

    public static PlaygroupStatsMemberItemBinding bind(View view) {
        int i = R.id.drawsValueLabel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.gamesLabel;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.gamesValueLabel;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.lossesLabel;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.lossesValueLabel;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView5 != null) {
                            i = R.id.no_photo_icon;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.profile_icon;
                                CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                if (cachedImageView != null) {
                                    i = R.id.profileLayout;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout != null) {
                                        LinearLayout linearLayout = (LinearLayout) view;
                                        i = R.id.stats_layout;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout2 != null) {
                                            i = R.id.stats_layout_1;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout3 != null) {
                                                i = R.id.stats_layout_2;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout4 != null) {
                                                    i = R.id.userFirstName;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.user_layout;
                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout5 != null) {
                                                            i = R.id.userName;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView7 != null) {
                                                                i = R.id.winRateLabel;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView8 != null) {
                                                                    i = R.id.winRateValueLabel;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView9 != null) {
                                                                        i = R.id.winsLabel;
                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView10 != null) {
                                                                            i = R.id.winsValueLabel;
                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView11 != null) {
                                                                                return new PlaygroupStatsMemberItemBinding(linearLayout, textView, textView2, textView3, textView4, textView5, imageView, cachedImageView, constraintLayout, linearLayout, linearLayout2, linearLayout3, linearLayout4, textView6, linearLayout5, textView7, textView8, textView9, textView10, textView11);
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

    public static PlaygroupStatsMemberItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PlaygroupStatsMemberItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.playgroup_stats_member_item, viewGroup, false);
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
