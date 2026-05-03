package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CustomCircleView;
import com.studiolaganne.lengendarylens.LifeTotalView;
import com.studiolaganne.lengendarylens.R;
import com.studiolaganne.lengendarylens.TransparentClickImageView;
import com.studiolaganne.lengendarylens.TransparentRecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentGame2PlayersType3Binding implements ViewBinding {
    public final ImageView arrowIcon;
    public final ImageView backgroundImage;
    public final ConstraintLayout bestOfResultLayout;
    public final ConstraintLayout boHelpInnerLayout;
    public final ConstraintLayout boHelpLayout;
    public final TextView boHelpText;
    public final CustomCircleView circleView;
    public final ConstraintLayout constraintLayout;
    public final TransparentClickImageView customMenuButtonImage;
    public final View dayNightBkg;
    public final ImageView dayNightImageView;
    public final View divider;
    public final LifeTotalView lifeTotalView1;
    public final LifeTotalView lifeTotalView2;
    public final TextView menuButton;
    public final TextView menuButtonBlack;
    public final TextView menuButtonWhite;
    public final View overlay;
    public final FrameLayout overlayContainer;
    public final View overlayView1;
    public final View planechaseBkg;
    public final ImageView planechaseImageView;
    public final TransparentRecyclerView player1EventsRecyclerView;
    public final TransparentRecyclerView player2EventsRecyclerView;
    private final ConstraintLayout rootView;
    public final TextView scoreBottomTextView;
    public final TextView scoreTopTextView;
    public final LinearLayout scoresLayout;
    public final ConstraintLayout startGameButtonLayout;
    public final TextView startGameButtonText;
    public final TextView timerPausedTextView;
    public final TextView timerTextView;
    public final TextView timerTurnTextView;

    private FragmentGame2PlayersType3Binding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView, CustomCircleView customCircleView, ConstraintLayout constraintLayout5, TransparentClickImageView transparentClickImageView, View view, ImageView imageView3, View view2, LifeTotalView lifeTotalView, LifeTotalView lifeTotalView2, TextView textView2, TextView textView3, TextView textView4, View view3, FrameLayout frameLayout, View view4, View view5, ImageView imageView4, TransparentRecyclerView transparentRecyclerView, TransparentRecyclerView transparentRecyclerView2, TextView textView5, TextView textView6, LinearLayout linearLayout, ConstraintLayout constraintLayout6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.rootView = constraintLayout;
        this.arrowIcon = imageView;
        this.backgroundImage = imageView2;
        this.bestOfResultLayout = constraintLayout2;
        this.boHelpInnerLayout = constraintLayout3;
        this.boHelpLayout = constraintLayout4;
        this.boHelpText = textView;
        this.circleView = customCircleView;
        this.constraintLayout = constraintLayout5;
        this.customMenuButtonImage = transparentClickImageView;
        this.dayNightBkg = view;
        this.dayNightImageView = imageView3;
        this.divider = view2;
        this.lifeTotalView1 = lifeTotalView;
        this.lifeTotalView2 = lifeTotalView2;
        this.menuButton = textView2;
        this.menuButtonBlack = textView3;
        this.menuButtonWhite = textView4;
        this.overlay = view3;
        this.overlayContainer = frameLayout;
        this.overlayView1 = view4;
        this.planechaseBkg = view5;
        this.planechaseImageView = imageView4;
        this.player1EventsRecyclerView = transparentRecyclerView;
        this.player2EventsRecyclerView = transparentRecyclerView2;
        this.scoreBottomTextView = textView5;
        this.scoreTopTextView = textView6;
        this.scoresLayout = linearLayout;
        this.startGameButtonLayout = constraintLayout6;
        this.startGameButtonText = textView7;
        this.timerPausedTextView = textView8;
        this.timerTextView = textView9;
        this.timerTurnTextView = textView10;
    }

    public static FragmentGame2PlayersType3Binding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        int i = R.id.arrowIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.backgroundImage;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.bestOfResultLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.boHelpInnerLayout;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.boHelpLayout;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout3 != null) {
                            i = R.id.boHelpText;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.circleView;
                                CustomCircleView customCircleView = (CustomCircleView) ViewBindings.findChildViewById(view, i);
                                if (customCircleView != null) {
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view;
                                    i = R.id.customMenuButtonImage;
                                    TransparentClickImageView transparentClickImageView = (TransparentClickImageView) ViewBindings.findChildViewById(view, i);
                                    if (transparentClickImageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.dayNightBkg))) != null) {
                                        i = R.id.dayNightImageView;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.divider))) != null) {
                                            i = R.id.lifeTotalView1;
                                            LifeTotalView lifeTotalView = (LifeTotalView) ViewBindings.findChildViewById(view, i);
                                            if (lifeTotalView != null) {
                                                i = R.id.lifeTotalView2;
                                                LifeTotalView lifeTotalView2 = (LifeTotalView) ViewBindings.findChildViewById(view, i);
                                                if (lifeTotalView2 != null) {
                                                    i = R.id.menu_button;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R.id.menu_button_black;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.menu_button_white;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.overlay))) != null) {
                                                                i = R.id.overlay_container;
                                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                if (frameLayout != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.overlayView1))) != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.planechaseBkg))) != null) {
                                                                    i = R.id.planechaseImageView;
                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView4 != null) {
                                                                        i = R.id.player1EventsRecyclerView;
                                                                        TransparentRecyclerView transparentRecyclerView = (TransparentRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                        if (transparentRecyclerView != null) {
                                                                            i = R.id.player2EventsRecyclerView;
                                                                            TransparentRecyclerView transparentRecyclerView2 = (TransparentRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                            if (transparentRecyclerView2 != null) {
                                                                                i = R.id.scoreBottomTextView;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView5 != null) {
                                                                                    i = R.id.scoreTopTextView;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.scoresLayout;
                                                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout != null) {
                                                                                            i = R.id.startGameButtonLayout;
                                                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (constraintLayout5 != null) {
                                                                                                i = R.id.startGameButtonText;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView7 != null) {
                                                                                                    i = R.id.timerPausedTextView;
                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView8 != null) {
                                                                                                        i = R.id.timerTextView;
                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView9 != null) {
                                                                                                            i = R.id.timerTurnTextView;
                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView10 != null) {
                                                                                                                return new FragmentGame2PlayersType3Binding(constraintLayout4, imageView, imageView2, constraintLayout, constraintLayout2, constraintLayout3, textView, customCircleView, constraintLayout4, transparentClickImageView, viewFindChildViewById, imageView3, viewFindChildViewById2, lifeTotalView, lifeTotalView2, textView2, textView3, textView4, viewFindChildViewById3, frameLayout, viewFindChildViewById4, viewFindChildViewById5, imageView4, transparentRecyclerView, transparentRecyclerView2, textView5, textView6, linearLayout, constraintLayout5, textView7, textView8, textView9, textView10);
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

    public static FragmentGame2PlayersType3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGame2PlayersType3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_game_2_players_type_3, viewGroup, false);
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
