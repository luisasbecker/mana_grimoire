package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentPlaygroupStatsBinding implements ViewBinding {
    public final TextView bestPlayerLabelText;
    public final LinearLayout bestPlayerLayout;
    public final ConstraintLayout bestPlayerStatsLayout;
    public final TextView bestUserFirstnameValueText;
    public final LinearLayout bestUserHorizontalLayout2;
    public final TextView bestUserUsernameValueText;
    public final LinearLayout bestUserVerticalLayout;
    public final TextView bestUserWinrateLabelText;
    public final TextView bestUserWinrateValueText;
    public final TextView durationLabelText;
    public final ConstraintLayout durationStatsLayout;
    public final TextView durationValueText;
    public final ConstraintLayout formatStatsLayout;
    public final TextView gamesLabelText;
    public final ConstraintLayout gamesStatsLayout;
    public final TextView gamesValueText;
    public final LottieAnimationView loadingAnimationView;
    public final TextView mostPlayedFormatGamesLabelText;
    public final LinearLayout mostPlayedFormatGamesLayout;
    public final TextView mostPlayedFormatGamesValueText;
    public final TextView mostPlayedFormatLabelText;
    public final TextView mostPlayedFormatValueText;
    public final ImageView noPhotoIcon;
    public final ConstraintLayout overlay;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final View separator1;
    public final View separator2;
    public final View separator3;
    public final LinearLayout statsLayout1;
    public final LinearLayout statsLayout2;
    public final RecyclerView statsUsersRecyclerView;
    public final View vSeparator1;
    public final View vSeparator12;

    private FragmentPlaygroupStatsBinding(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, TextView textView2, LinearLayout linearLayout2, TextView textView3, LinearLayout linearLayout3, TextView textView4, TextView textView5, TextView textView6, ConstraintLayout constraintLayout3, TextView textView7, ConstraintLayout constraintLayout4, TextView textView8, ConstraintLayout constraintLayout5, TextView textView9, LottieAnimationView lottieAnimationView, TextView textView10, LinearLayout linearLayout4, TextView textView11, TextView textView12, TextView textView13, ImageView imageView, ConstraintLayout constraintLayout6, CachedImageView cachedImageView, ConstraintLayout constraintLayout7, ScrollView scrollView, View view, View view2, View view3, LinearLayout linearLayout5, LinearLayout linearLayout6, RecyclerView recyclerView, View view4, View view5) {
        this.rootView = constraintLayout;
        this.bestPlayerLabelText = textView;
        this.bestPlayerLayout = linearLayout;
        this.bestPlayerStatsLayout = constraintLayout2;
        this.bestUserFirstnameValueText = textView2;
        this.bestUserHorizontalLayout2 = linearLayout2;
        this.bestUserUsernameValueText = textView3;
        this.bestUserVerticalLayout = linearLayout3;
        this.bestUserWinrateLabelText = textView4;
        this.bestUserWinrateValueText = textView5;
        this.durationLabelText = textView6;
        this.durationStatsLayout = constraintLayout3;
        this.durationValueText = textView7;
        this.formatStatsLayout = constraintLayout4;
        this.gamesLabelText = textView8;
        this.gamesStatsLayout = constraintLayout5;
        this.gamesValueText = textView9;
        this.loadingAnimationView = lottieAnimationView;
        this.mostPlayedFormatGamesLabelText = textView10;
        this.mostPlayedFormatGamesLayout = linearLayout4;
        this.mostPlayedFormatGamesValueText = textView11;
        this.mostPlayedFormatLabelText = textView12;
        this.mostPlayedFormatValueText = textView13;
        this.noPhotoIcon = imageView;
        this.overlay = constraintLayout6;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout7;
        this.scrollView = scrollView;
        this.separator1 = view;
        this.separator2 = view2;
        this.separator3 = view3;
        this.statsLayout1 = linearLayout5;
        this.statsLayout2 = linearLayout6;
        this.statsUsersRecyclerView = recyclerView;
        this.vSeparator1 = view4;
        this.vSeparator12 = view5;
    }

    public static FragmentPlaygroupStatsBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        int i = R.id.bestPlayerLabelText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bestPlayerLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.bestPlayerStatsLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.bestUserFirstnameValueText;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.bestUserHorizontalLayout2;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R.id.bestUserUsernameValueText;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.bestUserVerticalLayout;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout3 != null) {
                                    i = R.id.bestUserWinrateLabelText;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.bestUserWinrateValueText;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.durationLabelText;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.durationStatsLayout;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout2 != null) {
                                                    i = R.id.durationValueText;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        i = R.id.formatStatsLayout;
                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout3 != null) {
                                                            i = R.id.gamesLabelText;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView8 != null) {
                                                                i = R.id.gamesStatsLayout;
                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout4 != null) {
                                                                    i = R.id.gamesValueText;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView9 != null) {
                                                                        i = R.id.loadingAnimationView;
                                                                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                        if (lottieAnimationView != null) {
                                                                            i = R.id.mostPlayedFormatGamesLabelText;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView10 != null) {
                                                                                i = R.id.mostPlayedFormatGamesLayout;
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout4 != null) {
                                                                                    i = R.id.mostPlayedFormatGamesValueText;
                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView11 != null) {
                                                                                        i = R.id.mostPlayedFormatLabelText;
                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView12 != null) {
                                                                                            i = R.id.mostPlayedFormatValueText;
                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView13 != null) {
                                                                                                i = R.id.no_photo_icon;
                                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView != null) {
                                                                                                    i = R.id.overlay;
                                                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (constraintLayout5 != null) {
                                                                                                        i = R.id.profile_icon;
                                                                                                        CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (cachedImageView != null) {
                                                                                                            i = R.id.profileLayout;
                                                                                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (constraintLayout6 != null) {
                                                                                                                i = R.id.scrollView;
                                                                                                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (scrollView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.separator2))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.separator3))) != null) {
                                                                                                                    i = R.id.statsLayout1;
                                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (linearLayout5 != null) {
                                                                                                                        i = R.id.statsLayout2;
                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (linearLayout6 != null) {
                                                                                                                            i = R.id.statsUsersRecyclerView;
                                                                                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (recyclerView != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.vSeparator1))) != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.vSeparator12))) != null) {
                                                                                                                                return new FragmentPlaygroupStatsBinding((ConstraintLayout) view, textView, linearLayout, constraintLayout, textView2, linearLayout2, textView3, linearLayout3, textView4, textView5, textView6, constraintLayout2, textView7, constraintLayout3, textView8, constraintLayout4, textView9, lottieAnimationView, textView10, linearLayout4, textView11, textView12, textView13, imageView, constraintLayout5, cachedImageView, constraintLayout6, scrollView, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, linearLayout5, linearLayout6, recyclerView, viewFindChildViewById4, viewFindChildViewById5);
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

    public static FragmentPlaygroupStatsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentPlaygroupStatsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_playgroup_stats, viewGroup, false);
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
