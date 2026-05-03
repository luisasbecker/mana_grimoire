package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentUserStatsBinding implements ViewBinding {
    public final TextView bestDeckLabelText;
    public final ConstraintLayout bestDeckStatsLayout;
    public final TextView bestDeckValueText;
    public final TextView deckWinsLabel;
    public final LinearLayout deckWinsLayout;
    public final TextView deckWinsValueLabel;
    public final TextView durationLabelText;
    public final ConstraintLayout durationStatsLayout;
    public final TextView durationValueText;
    public final ConstraintLayout formatStatsLayout;
    public final LinearLayout gamesLayout;
    public final ConstraintLayout gamesStatsLayout;
    public final LottieAnimationView loadingAnimationView;
    public final TextView mostPlayedFormatGamesLabelText;
    public final LinearLayout mostPlayedFormatGamesLayout;
    public final TextView mostPlayedFormatGamesValueText;
    public final TextView mostPlayedFormatLabelText;
    public final TextView mostPlayedFormatValueText;
    public final TextView numGamesLabel;
    public final TextView numGamesValueLabel;
    public final TextView numLossesLabel;
    public final TextView numLossesValueLabel;
    public final TextView numWinsLabel;
    public final TextView numWinsValueLabel;
    public final ConstraintLayout overlay;
    public final TextView privacyMessageText;
    private final ConstraintLayout rootView;
    public final View separator1;
    public final View separator2;
    public final View separator3;
    public final LinearLayout statsContentLayout;
    public final LinearLayout statsLayout1;
    public final LinearLayout statsLayout2;
    public final View vSeparator1;
    public final View vSeparator12;
    public final TextView winRateLabelText;
    public final TextView winRateValueText;

    private FragmentUserStatsBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, LinearLayout linearLayout, TextView textView4, TextView textView5, ConstraintLayout constraintLayout3, TextView textView6, ConstraintLayout constraintLayout4, LinearLayout linearLayout2, ConstraintLayout constraintLayout5, LottieAnimationView lottieAnimationView, TextView textView7, LinearLayout linearLayout3, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, ConstraintLayout constraintLayout6, TextView textView17, View view, View view2, View view3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, View view4, View view5, TextView textView18, TextView textView19) {
        this.rootView = constraintLayout;
        this.bestDeckLabelText = textView;
        this.bestDeckStatsLayout = constraintLayout2;
        this.bestDeckValueText = textView2;
        this.deckWinsLabel = textView3;
        this.deckWinsLayout = linearLayout;
        this.deckWinsValueLabel = textView4;
        this.durationLabelText = textView5;
        this.durationStatsLayout = constraintLayout3;
        this.durationValueText = textView6;
        this.formatStatsLayout = constraintLayout4;
        this.gamesLayout = linearLayout2;
        this.gamesStatsLayout = constraintLayout5;
        this.loadingAnimationView = lottieAnimationView;
        this.mostPlayedFormatGamesLabelText = textView7;
        this.mostPlayedFormatGamesLayout = linearLayout3;
        this.mostPlayedFormatGamesValueText = textView8;
        this.mostPlayedFormatLabelText = textView9;
        this.mostPlayedFormatValueText = textView10;
        this.numGamesLabel = textView11;
        this.numGamesValueLabel = textView12;
        this.numLossesLabel = textView13;
        this.numLossesValueLabel = textView14;
        this.numWinsLabel = textView15;
        this.numWinsValueLabel = textView16;
        this.overlay = constraintLayout6;
        this.privacyMessageText = textView17;
        this.separator1 = view;
        this.separator2 = view2;
        this.separator3 = view3;
        this.statsContentLayout = linearLayout4;
        this.statsLayout1 = linearLayout5;
        this.statsLayout2 = linearLayout6;
        this.vSeparator1 = view4;
        this.vSeparator12 = view5;
        this.winRateLabelText = textView18;
        this.winRateValueText = textView19;
    }

    public static FragmentUserStatsBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        int i = R.id.bestDeckLabelText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bestDeckStatsLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.bestDeckValueText;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.deckWinsLabel;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.deckWinsLayout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.deckWinsValueLabel;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.durationLabelText;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.durationStatsLayout;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout2 != null) {
                                        i = R.id.durationValueText;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R.id.formatStatsLayout;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout3 != null) {
                                                i = R.id.gamesLayout;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout2 != null) {
                                                    i = R.id.gamesStatsLayout;
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout4 != null) {
                                                        i = R.id.loadingAnimationView;
                                                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                        if (lottieAnimationView != null) {
                                                            i = R.id.mostPlayedFormatGamesLabelText;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView7 != null) {
                                                                i = R.id.mostPlayedFormatGamesLayout;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.mostPlayedFormatGamesValueText;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.mostPlayedFormatLabelText;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView9 != null) {
                                                                            i = R.id.mostPlayedFormatValueText;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView10 != null) {
                                                                                i = R.id.numGamesLabel;
                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView11 != null) {
                                                                                    i = R.id.numGamesValueLabel;
                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView12 != null) {
                                                                                        i = R.id.numLossesLabel;
                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView13 != null) {
                                                                                            i = R.id.numLossesValueLabel;
                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView14 != null) {
                                                                                                i = R.id.numWinsLabel;
                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView15 != null) {
                                                                                                    i = R.id.numWinsValueLabel;
                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView16 != null) {
                                                                                                        i = R.id.overlay;
                                                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (constraintLayout5 != null) {
                                                                                                            i = R.id.privacyMessageText;
                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView17 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.separator2))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.separator3))) != null) {
                                                                                                                i = R.id.statsContentLayout;
                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (linearLayout4 != null) {
                                                                                                                    i = R.id.statsLayout1;
                                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (linearLayout5 != null) {
                                                                                                                        i = R.id.statsLayout2;
                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (linearLayout6 != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.vSeparator1))) != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.vSeparator12))) != null) {
                                                                                                                            i = R.id.winRateLabelText;
                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView18 != null) {
                                                                                                                                i = R.id.winRateValueText;
                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView19 != null) {
                                                                                                                                    return new FragmentUserStatsBinding((ConstraintLayout) view, textView, constraintLayout, textView2, textView3, linearLayout, textView4, textView5, constraintLayout2, textView6, constraintLayout3, linearLayout2, constraintLayout4, lottieAnimationView, textView7, linearLayout3, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, constraintLayout5, textView17, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, linearLayout4, linearLayout5, linearLayout6, viewFindChildViewById4, viewFindChildViewById5, textView18, textView19);
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

    public static FragmentUserStatsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUserStatsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user_stats, viewGroup, false);
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
