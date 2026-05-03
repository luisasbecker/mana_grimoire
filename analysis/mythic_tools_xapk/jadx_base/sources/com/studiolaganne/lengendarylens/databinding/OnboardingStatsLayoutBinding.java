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
import com.studiolaganne.lengendarylens.LoadingImageViewPlaymat;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class OnboardingStatsLayoutBinding implements ViewBinding {
    public final ImageView bMana;
    public final ConstraintLayout bracketLayout;
    public final TextView bracketNameTextView;
    public final TextView bracketValueTextView;
    public final ImageView cMana;
    public final TextView closeBracketTextView;
    public final ImageView gMana;
    public final LinearLayout gamesLayout;
    public final LinearLayout leftLayout;
    public final LinearLayout manaLayout;
    public final TextView numDrawsLabel;
    public final TextView numDrawsValueLabel;
    public final TextView numGamesLabel;
    public final TextView numGamesValueLabel;
    public final TextView numLossesLabel;
    public final TextView numLossesValueLabel;
    public final TextView numWinsLabel;
    public final TextView numWinsValueLabel;
    public final TextView openBracketTextView;
    public final TextView otdHeader;
    public final ImageView otdImage;
    public final TextView otdNumDrawsValueLabel;
    public final TextView otdNumGames;
    public final TextView otdNumLossesLabel;
    public final TextView otdNumLossesValueLabel;
    public final TextView otdNumWinsLabel;
    public final TextView otdNumWinsValueLabel;
    public final LinearLayout otdWinLossLayout;
    public final TextView otdWinrate;
    public final TextView otpHeader;
    public final ImageView otpImage;
    public final TextView otpNumDrawsValueLabel;
    public final TextView otpNumGames;
    public final TextView otpNumLossesLabel;
    public final TextView otpNumLossesValueLabel;
    public final TextView otpNumWinsLabel;
    public final TextView otpNumWinsValueLabel;
    public final LinearLayout otpWinLossLayout;
    public final TextView otpWinrate;
    public final LoadingImageViewPlaymat playmatImageView;
    public final ConstraintLayout playmatLayout;
    public final ConstraintLayout playmatLayoutInner;
    public final ImageView rMana;
    public final LinearLayout rightLayout;
    private final LinearLayout rootView;
    public final LinearLayout scrollableLinearLayout;
    public final ConstraintLayout statsLayout;
    public final LinearLayout statsLayoutInner;
    public final ImageView uMana;
    public final ImageView wMana;
    public final LinearLayout winLossLayout;
    public final TextView winrateLabel;
    public final ConstraintLayout winrateLayout;
    public final TextView winrateValue;

    private OnboardingStatsLayoutBinding(LinearLayout linearLayout, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, ImageView imageView3, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, ImageView imageView4, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, LinearLayout linearLayout5, TextView textView20, TextView textView21, ImageView imageView5, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, LinearLayout linearLayout6, TextView textView28, LoadingImageViewPlaymat loadingImageViewPlaymat, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView6, LinearLayout linearLayout7, LinearLayout linearLayout8, ConstraintLayout constraintLayout4, LinearLayout linearLayout9, ImageView imageView7, ImageView imageView8, LinearLayout linearLayout10, TextView textView29, ConstraintLayout constraintLayout5, TextView textView30) {
        this.rootView = linearLayout;
        this.bMana = imageView;
        this.bracketLayout = constraintLayout;
        this.bracketNameTextView = textView;
        this.bracketValueTextView = textView2;
        this.cMana = imageView2;
        this.closeBracketTextView = textView3;
        this.gMana = imageView3;
        this.gamesLayout = linearLayout2;
        this.leftLayout = linearLayout3;
        this.manaLayout = linearLayout4;
        this.numDrawsLabel = textView4;
        this.numDrawsValueLabel = textView5;
        this.numGamesLabel = textView6;
        this.numGamesValueLabel = textView7;
        this.numLossesLabel = textView8;
        this.numLossesValueLabel = textView9;
        this.numWinsLabel = textView10;
        this.numWinsValueLabel = textView11;
        this.openBracketTextView = textView12;
        this.otdHeader = textView13;
        this.otdImage = imageView4;
        this.otdNumDrawsValueLabel = textView14;
        this.otdNumGames = textView15;
        this.otdNumLossesLabel = textView16;
        this.otdNumLossesValueLabel = textView17;
        this.otdNumWinsLabel = textView18;
        this.otdNumWinsValueLabel = textView19;
        this.otdWinLossLayout = linearLayout5;
        this.otdWinrate = textView20;
        this.otpHeader = textView21;
        this.otpImage = imageView5;
        this.otpNumDrawsValueLabel = textView22;
        this.otpNumGames = textView23;
        this.otpNumLossesLabel = textView24;
        this.otpNumLossesValueLabel = textView25;
        this.otpNumWinsLabel = textView26;
        this.otpNumWinsValueLabel = textView27;
        this.otpWinLossLayout = linearLayout6;
        this.otpWinrate = textView28;
        this.playmatImageView = loadingImageViewPlaymat;
        this.playmatLayout = constraintLayout2;
        this.playmatLayoutInner = constraintLayout3;
        this.rMana = imageView6;
        this.rightLayout = linearLayout7;
        this.scrollableLinearLayout = linearLayout8;
        this.statsLayout = constraintLayout4;
        this.statsLayoutInner = linearLayout9;
        this.uMana = imageView7;
        this.wMana = imageView8;
        this.winLossLayout = linearLayout10;
        this.winrateLabel = textView29;
        this.winrateLayout = constraintLayout5;
        this.winrateValue = textView30;
    }

    public static OnboardingStatsLayoutBinding bind(View view) {
        int i = R.id.b_mana;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.bracketLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.bracketNameTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.bracketValueTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.c_mana;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.closeBracketTextView;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.g_mana;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.gamesLayout;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        i = R.id.leftLayout;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout2 != null) {
                                            i = R.id.manaLayout;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout3 != null) {
                                                i = R.id.numDrawsLabel;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.numDrawsValueLabel;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.numGamesLabel;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            i = R.id.numGamesValueLabel;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView7 != null) {
                                                                i = R.id.numLossesLabel;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView8 != null) {
                                                                    i = R.id.numLossesValueLabel;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView9 != null) {
                                                                        i = R.id.numWinsLabel;
                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView10 != null) {
                                                                            i = R.id.numWinsValueLabel;
                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView11 != null) {
                                                                                i = R.id.openBracketTextView;
                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView12 != null) {
                                                                                    i = R.id.otdHeader;
                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView13 != null) {
                                                                                        i = R.id.otdImage;
                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                        if (imageView4 != null) {
                                                                                            i = R.id.otdNumDrawsValueLabel;
                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView14 != null) {
                                                                                                i = R.id.otdNumGames;
                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView15 != null) {
                                                                                                    i = R.id.otdNumLossesLabel;
                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView16 != null) {
                                                                                                        i = R.id.otdNumLossesValueLabel;
                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView17 != null) {
                                                                                                            i = R.id.otdNumWinsLabel;
                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView18 != null) {
                                                                                                                i = R.id.otdNumWinsValueLabel;
                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView19 != null) {
                                                                                                                    i = R.id.otdWinLossLayout;
                                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (linearLayout4 != null) {
                                                                                                                        i = R.id.otdWinrate;
                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView20 != null) {
                                                                                                                            i = R.id.otpHeader;
                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView21 != null) {
                                                                                                                                i = R.id.otpImage;
                                                                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (imageView5 != null) {
                                                                                                                                    i = R.id.otpNumDrawsValueLabel;
                                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView22 != null) {
                                                                                                                                        i = R.id.otpNumGames;
                                                                                                                                        TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView23 != null) {
                                                                                                                                            i = R.id.otpNumLossesLabel;
                                                                                                                                            TextView textView24 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView24 != null) {
                                                                                                                                                i = R.id.otpNumLossesValueLabel;
                                                                                                                                                TextView textView25 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView25 != null) {
                                                                                                                                                    i = R.id.otpNumWinsLabel;
                                                                                                                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView26 != null) {
                                                                                                                                                        i = R.id.otpNumWinsValueLabel;
                                                                                                                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView27 != null) {
                                                                                                                                                            i = R.id.otpWinLossLayout;
                                                                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (linearLayout5 != null) {
                                                                                                                                                                i = R.id.otpWinrate;
                                                                                                                                                                TextView textView28 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView28 != null) {
                                                                                                                                                                    i = R.id.playmatImageView;
                                                                                                                                                                    LoadingImageViewPlaymat loadingImageViewPlaymat = (LoadingImageViewPlaymat) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (loadingImageViewPlaymat != null) {
                                                                                                                                                                        i = R.id.playmatLayout;
                                                                                                                                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (constraintLayout2 != null) {
                                                                                                                                                                            i = R.id.playmatLayoutInner;
                                                                                                                                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (constraintLayout3 != null) {
                                                                                                                                                                                i = R.id.r_mana;
                                                                                                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (imageView6 != null) {
                                                                                                                                                                                    i = R.id.rightLayout;
                                                                                                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (linearLayout6 != null) {
                                                                                                                                                                                        LinearLayout linearLayout7 = (LinearLayout) view;
                                                                                                                                                                                        i = R.id.statsLayout;
                                                                                                                                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (constraintLayout4 != null) {
                                                                                                                                                                                            i = R.id.statsLayoutInner;
                                                                                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                                                                                i = R.id.u_mana;
                                                                                                                                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (imageView7 != null) {
                                                                                                                                                                                                    i = R.id.w_mana;
                                                                                                                                                                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (imageView8 != null) {
                                                                                                                                                                                                        i = R.id.winLossLayout;
                                                                                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                                                                                            i = R.id.winrateLabel;
                                                                                                                                                                                                            TextView textView29 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (textView29 != null) {
                                                                                                                                                                                                                i = R.id.winrateLayout;
                                                                                                                                                                                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (constraintLayout5 != null) {
                                                                                                                                                                                                                    i = R.id.winrateValue;
                                                                                                                                                                                                                    TextView textView30 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (textView30 != null) {
                                                                                                                                                                                                                        return new OnboardingStatsLayoutBinding(linearLayout7, imageView, constraintLayout, textView, textView2, imageView2, textView3, imageView3, linearLayout, linearLayout2, linearLayout3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, imageView4, textView14, textView15, textView16, textView17, textView18, textView19, linearLayout4, textView20, textView21, imageView5, textView22, textView23, textView24, textView25, textView26, textView27, linearLayout5, textView28, loadingImageViewPlaymat, constraintLayout2, constraintLayout3, imageView6, linearLayout6, linearLayout7, constraintLayout4, linearLayout8, imageView7, imageView8, linearLayout9, textView29, constraintLayout5, textView30);
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

    public static OnboardingStatsLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static OnboardingStatsLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.onboarding_stats_layout, viewGroup, false);
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
