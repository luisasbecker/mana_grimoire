package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CustomCircleView;
import com.studiolaganne.lengendarylens.LifeTotalView;
import com.studiolaganne.lengendarylens.R;
import com.studiolaganne.lengendarylens.TransparentClickImageView;
import com.studiolaganne.lengendarylens.TransparentRecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentGame2PlayersType2Binding implements ViewBinding {
    public final ImageView backgroundImage;
    public final ConstraintLayout bestOfResultLayout;
    public final CustomCircleView circleView;
    public final ConstraintLayout constraintLayout;
    public final TransparentClickImageView customMenuButtonImage;
    public final View dayNightBkg;
    public final ImageView dayNightImageView;
    public final View divider;
    public final Guideline guideline;
    public final LifeTotalView lifeTotalView1;
    public final LifeTotalView lifeTotalView2;
    public final TextView menuButton;
    public final TextView menuButtonBlack;
    public final TextView menuButtonWhite;
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

    private FragmentGame2PlayersType2Binding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, CustomCircleView customCircleView, ConstraintLayout constraintLayout3, TransparentClickImageView transparentClickImageView, View view, ImageView imageView2, View view2, Guideline guideline, LifeTotalView lifeTotalView, LifeTotalView lifeTotalView2, TextView textView, TextView textView2, TextView textView3, FrameLayout frameLayout, View view3, View view4, ImageView imageView3, TransparentRecyclerView transparentRecyclerView, TransparentRecyclerView transparentRecyclerView2, TextView textView4, TextView textView5, LinearLayout linearLayout, ConstraintLayout constraintLayout4, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.backgroundImage = imageView;
        this.bestOfResultLayout = constraintLayout2;
        this.circleView = customCircleView;
        this.constraintLayout = constraintLayout3;
        this.customMenuButtonImage = transparentClickImageView;
        this.dayNightBkg = view;
        this.dayNightImageView = imageView2;
        this.divider = view2;
        this.guideline = guideline;
        this.lifeTotalView1 = lifeTotalView;
        this.lifeTotalView2 = lifeTotalView2;
        this.menuButton = textView;
        this.menuButtonBlack = textView2;
        this.menuButtonWhite = textView3;
        this.overlayContainer = frameLayout;
        this.overlayView1 = view3;
        this.planechaseBkg = view4;
        this.planechaseImageView = imageView3;
        this.player1EventsRecyclerView = transparentRecyclerView;
        this.player2EventsRecyclerView = transparentRecyclerView2;
        this.scoreBottomTextView = textView4;
        this.scoreTopTextView = textView5;
        this.scoresLayout = linearLayout;
        this.startGameButtonLayout = constraintLayout4;
        this.startGameButtonText = textView6;
        this.timerPausedTextView = textView7;
        this.timerTextView = textView8;
        this.timerTurnTextView = textView9;
    }

    public static FragmentGame2PlayersType2Binding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        int i = R.id.backgroundImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.bestOfResultLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.circleView;
                CustomCircleView customCircleView = (CustomCircleView) ViewBindings.findChildViewById(view, i);
                if (customCircleView != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                    i = R.id.customMenuButtonImage;
                    TransparentClickImageView transparentClickImageView = (TransparentClickImageView) ViewBindings.findChildViewById(view, i);
                    if (transparentClickImageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.dayNightBkg))) != null) {
                        i = R.id.dayNightImageView;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.divider))) != null) {
                            i = R.id.guideline;
                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline != null) {
                                i = R.id.lifeTotalView1;
                                LifeTotalView lifeTotalView = (LifeTotalView) ViewBindings.findChildViewById(view, i);
                                if (lifeTotalView != null) {
                                    i = R.id.lifeTotalView2;
                                    LifeTotalView lifeTotalView2 = (LifeTotalView) ViewBindings.findChildViewById(view, i);
                                    if (lifeTotalView2 != null) {
                                        i = R.id.menu_button;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.menu_button_black;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.menu_button_white;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.overlay_container;
                                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                    if (frameLayout != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.overlayView1))) != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.planechaseBkg))) != null) {
                                                        i = R.id.planechaseImageView;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView3 != null) {
                                                            i = R.id.player1EventsRecyclerView;
                                                            TransparentRecyclerView transparentRecyclerView = (TransparentRecyclerView) ViewBindings.findChildViewById(view, i);
                                                            if (transparentRecyclerView != null) {
                                                                i = R.id.player2EventsRecyclerView;
                                                                TransparentRecyclerView transparentRecyclerView2 = (TransparentRecyclerView) ViewBindings.findChildViewById(view, i);
                                                                if (transparentRecyclerView2 != null) {
                                                                    i = R.id.scoreBottomTextView;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.scoreTopTextView;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView5 != null) {
                                                                            i = R.id.scoresLayout;
                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout != null) {
                                                                                i = R.id.startGameButtonLayout;
                                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (constraintLayout3 != null) {
                                                                                    i = R.id.startGameButtonText;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.timerPausedTextView;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.timerTextView;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView8 != null) {
                                                                                                i = R.id.timerTurnTextView;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView9 != null) {
                                                                                                    return new FragmentGame2PlayersType2Binding(constraintLayout2, imageView, constraintLayout, customCircleView, constraintLayout2, transparentClickImageView, viewFindChildViewById, imageView2, viewFindChildViewById2, guideline, lifeTotalView, lifeTotalView2, textView, textView2, textView3, frameLayout, viewFindChildViewById3, viewFindChildViewById4, imageView3, transparentRecyclerView, transparentRecyclerView2, textView4, textView5, linearLayout, constraintLayout3, textView6, textView7, textView8, textView9);
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

    public static FragmentGame2PlayersType2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGame2PlayersType2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_game_2_players_type_2, viewGroup, false);
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
