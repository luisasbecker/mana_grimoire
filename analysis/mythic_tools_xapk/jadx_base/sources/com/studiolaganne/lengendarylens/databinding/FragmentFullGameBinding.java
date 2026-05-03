package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentFullGameBinding implements ViewBinding {
    public final ConstraintLayout alertOverlay;
    public final LinearLayout buttonsLayout;
    public final TextView closeButton;
    public final TextView closeGameHint;
    public final TextView closeGameOver;
    public final TextView closeReviewButton;
    public final TextView closeText;
    public final TextView connectingTextView;
    public final ImageView createFromPlaygroupIcon;
    public final TextView createFromPlaygroupText;
    public final ImageView createGuestIcon;
    public final LinearLayout createWithGuestsInnerLayout;
    public final TextView createWithGuestsSubtitleText;
    public final TextView createWithGuestsText;
    public final TextView deleteGameOver;
    public final LinearLayout endOfGameBottomLayout;
    public final MaterialButton exitButton;
    public final ConstraintLayout fadeInOverlay;
    public final FragmentContainerView fragmentContainer;
    public final LinearLayout gameOverCenterLayout;
    public final ConstraintLayout gameOverOverlay;
    public final TextView gameOverTitle;
    public final RecyclerView gamesRecyclerView;
    public final CardView leaderBadge;
    public final ConstraintLayout leaderSelectLayout;
    public final MaterialButton letsGoButton;
    public final LottieAnimationView loadingAnimationView;
    public final ConstraintLayout loadingOverlay;
    public final TextView mainText;
    public final FragmentContainerView menuFragmentContainer;
    public final ConstraintLayout menuOverlay;
    public final RecyclerView playerResultsRecyclerView;
    public final MaterialButton restartButton;
    public final ImageView reviewIcon;
    public final ConstraintLayout reviewLayout;
    public final TextView reviewText1;
    public final TextView reviewText2;
    public final LinearLayout reviewTextLayout;
    public final ConstraintLayout rootLayout;
    private final RelativeLayout rootView;
    public final ConstraintLayout saveAndRestartButtonLayout;
    public final ConstraintLayout saveGameButtonLayout;
    public final TextView skipText;
    public final View spacer;
    public final TextView subtitleText;
    public final LinearLayout textLayout;
    public final Toolbar toolbar;
    public final ImageView treacheryLogo;
    public final ConstraintLayout tutorialOverlay;
    public final TextView tutorialText;
    public final ViewPager2 viewPager;

    private FragmentFullGameBinding(RelativeLayout relativeLayout, ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ImageView imageView, TextView textView7, ImageView imageView2, LinearLayout linearLayout2, TextView textView8, TextView textView9, TextView textView10, LinearLayout linearLayout3, MaterialButton materialButton, ConstraintLayout constraintLayout2, FragmentContainerView fragmentContainerView, LinearLayout linearLayout4, ConstraintLayout constraintLayout3, TextView textView11, RecyclerView recyclerView, CardView cardView, ConstraintLayout constraintLayout4, MaterialButton materialButton2, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout5, TextView textView12, FragmentContainerView fragmentContainerView2, ConstraintLayout constraintLayout6, RecyclerView recyclerView2, MaterialButton materialButton3, ImageView imageView3, ConstraintLayout constraintLayout7, TextView textView13, TextView textView14, LinearLayout linearLayout5, ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10, TextView textView15, View view, TextView textView16, LinearLayout linearLayout6, Toolbar toolbar, ImageView imageView4, ConstraintLayout constraintLayout11, TextView textView17, ViewPager2 viewPager2) {
        this.rootView = relativeLayout;
        this.alertOverlay = constraintLayout;
        this.buttonsLayout = linearLayout;
        this.closeButton = textView;
        this.closeGameHint = textView2;
        this.closeGameOver = textView3;
        this.closeReviewButton = textView4;
        this.closeText = textView5;
        this.connectingTextView = textView6;
        this.createFromPlaygroupIcon = imageView;
        this.createFromPlaygroupText = textView7;
        this.createGuestIcon = imageView2;
        this.createWithGuestsInnerLayout = linearLayout2;
        this.createWithGuestsSubtitleText = textView8;
        this.createWithGuestsText = textView9;
        this.deleteGameOver = textView10;
        this.endOfGameBottomLayout = linearLayout3;
        this.exitButton = materialButton;
        this.fadeInOverlay = constraintLayout2;
        this.fragmentContainer = fragmentContainerView;
        this.gameOverCenterLayout = linearLayout4;
        this.gameOverOverlay = constraintLayout3;
        this.gameOverTitle = textView11;
        this.gamesRecyclerView = recyclerView;
        this.leaderBadge = cardView;
        this.leaderSelectLayout = constraintLayout4;
        this.letsGoButton = materialButton2;
        this.loadingAnimationView = lottieAnimationView;
        this.loadingOverlay = constraintLayout5;
        this.mainText = textView12;
        this.menuFragmentContainer = fragmentContainerView2;
        this.menuOverlay = constraintLayout6;
        this.playerResultsRecyclerView = recyclerView2;
        this.restartButton = materialButton3;
        this.reviewIcon = imageView3;
        this.reviewLayout = constraintLayout7;
        this.reviewText1 = textView13;
        this.reviewText2 = textView14;
        this.reviewTextLayout = linearLayout5;
        this.rootLayout = constraintLayout8;
        this.saveAndRestartButtonLayout = constraintLayout9;
        this.saveGameButtonLayout = constraintLayout10;
        this.skipText = textView15;
        this.spacer = view;
        this.subtitleText = textView16;
        this.textLayout = linearLayout6;
        this.toolbar = toolbar;
        this.treacheryLogo = imageView4;
        this.tutorialOverlay = constraintLayout11;
        this.tutorialText = textView17;
        this.viewPager = viewPager2;
    }

    public static FragmentFullGameBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.alert_overlay;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.buttonsLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.close_button;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.close_game_hint;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.close_game_over;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.close_review_button;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.close_text;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.connectingTextView;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null) {
                                        i = R.id.createFromPlaygroupIcon;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView != null) {
                                            i = R.id.createFromPlaygroupText;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                i = R.id.createGuestIcon;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView2 != null) {
                                                    i = R.id.createWithGuestsInnerLayout;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.createWithGuestsSubtitleText;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null) {
                                                            i = R.id.createWithGuestsText;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView9 != null) {
                                                                i = R.id.delete_game_over;
                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView10 != null) {
                                                                    i = R.id.endOfGameBottomLayout;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout3 != null) {
                                                                        i = R.id.exit_button;
                                                                        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                                        if (materialButton != null) {
                                                                            i = R.id.fade_in_overlay;
                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (constraintLayout2 != null) {
                                                                                i = R.id.fragment_container;
                                                                                FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                                                                                if (fragmentContainerView != null) {
                                                                                    i = R.id.game_over_center_layout;
                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout4 != null) {
                                                                                        i = R.id.game_over_overlay;
                                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (constraintLayout3 != null) {
                                                                                            i = R.id.game_over_title;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView11 != null) {
                                                                                                i = R.id.gamesRecyclerView;
                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                if (recyclerView != null) {
                                                                                                    i = R.id.leader_badge;
                                                                                                    CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (cardView != null) {
                                                                                                        i = R.id.leader_select_layout;
                                                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (constraintLayout4 != null) {
                                                                                                            i = R.id.lets_go_button;
                                                                                                            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                                                                            if (materialButton2 != null) {
                                                                                                                i = R.id.loadingAnimationView;
                                                                                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (lottieAnimationView != null) {
                                                                                                                    i = R.id.loading_overlay;
                                                                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (constraintLayout5 != null) {
                                                                                                                        i = R.id.main_text;
                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView12 != null) {
                                                                                                                            i = R.id.menu_fragment_container;
                                                                                                                            FragmentContainerView fragmentContainerView2 = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (fragmentContainerView2 != null) {
                                                                                                                                i = R.id.menu_overlay;
                                                                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (constraintLayout6 != null) {
                                                                                                                                    i = R.id.playerResultsRecyclerView;
                                                                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (recyclerView2 != null) {
                                                                                                                                        i = R.id.restart_button;
                                                                                                                                        MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (materialButton3 != null) {
                                                                                                                                            i = R.id.reviewIcon;
                                                                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (imageView3 != null) {
                                                                                                                                                i = R.id.review_layout;
                                                                                                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (constraintLayout7 != null) {
                                                                                                                                                    i = R.id.reviewText1;
                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                        i = R.id.reviewText2;
                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                            i = R.id.reviewTextLayout;
                                                                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (linearLayout5 != null) {
                                                                                                                                                                i = R.id.root_layout;
                                                                                                                                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (constraintLayout8 != null) {
                                                                                                                                                                    i = R.id.saveAndRestartButtonLayout;
                                                                                                                                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (constraintLayout9 != null) {
                                                                                                                                                                        i = R.id.saveGameButtonLayout;
                                                                                                                                                                        ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (constraintLayout10 != null) {
                                                                                                                                                                            i = R.id.skip_text;
                                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (textView15 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.spacer))) != null) {
                                                                                                                                                                                i = R.id.subtitle_text;
                                                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (textView16 != null) {
                                                                                                                                                                                    i = R.id.textLayout;
                                                                                                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (linearLayout6 != null) {
                                                                                                                                                                                        i = R.id.toolbar;
                                                                                                                                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (toolbar != null) {
                                                                                                                                                                                            i = R.id.treachery_logo;
                                                                                                                                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (imageView4 != null) {
                                                                                                                                                                                                i = R.id.tutorial_overlay;
                                                                                                                                                                                                ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (constraintLayout11 != null) {
                                                                                                                                                                                                    i = R.id.tutorial_text;
                                                                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                                                                        i = R.id.view_pager;
                                                                                                                                                                                                        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (viewPager2 != null) {
                                                                                                                                                                                                            return new FragmentFullGameBinding((RelativeLayout) view, constraintLayout, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, imageView, textView7, imageView2, linearLayout2, textView8, textView9, textView10, linearLayout3, materialButton, constraintLayout2, fragmentContainerView, linearLayout4, constraintLayout3, textView11, recyclerView, cardView, constraintLayout4, materialButton2, lottieAnimationView, constraintLayout5, textView12, fragmentContainerView2, constraintLayout6, recyclerView2, materialButton3, imageView3, constraintLayout7, textView13, textView14, linearLayout5, constraintLayout8, constraintLayout9, constraintLayout10, textView15, viewFindChildViewById, textView16, linearLayout6, toolbar, imageView4, constraintLayout11, textView17, viewPager2);
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

    public static FragmentFullGameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentFullGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_full_game, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
