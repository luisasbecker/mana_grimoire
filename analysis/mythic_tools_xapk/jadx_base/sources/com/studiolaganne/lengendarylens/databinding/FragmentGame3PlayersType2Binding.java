package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CustomCircleView;
import com.studiolaganne.lengendarylens.LifeTotalView;
import com.studiolaganne.lengendarylens.R;
import com.studiolaganne.lengendarylens.TransparentClickImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentGame3PlayersType2Binding implements ViewBinding {
    public final ImageView backgroundImage;
    public final CustomCircleView circleView;
    public final ConstraintLayout constraintLayout;
    public final TransparentClickImageView customMenuButtonImage;
    public final View dayNightBkg;
    public final ImageView dayNightImageView;
    public final LifeTotalView lifeTotalView1;
    public final LifeTotalView lifeTotalView2;
    public final LifeTotalView lifeTotalView3;
    public final TextView menuButton;
    public final TextView menuButtonBlack;
    public final TextView menuButtonWhite;
    public final View overlayView1;
    public final View planechaseBkg;
    public final ImageView planechaseImageView;
    private final ConstraintLayout rootView;
    public final ConstraintLayout startGameButtonLayout;
    public final TextView startGameButtonText;
    public final TextView timerPausedTextView;
    public final TextView timerTextView;
    public final TextView timerTurnTextView;

    private FragmentGame3PlayersType2Binding(ConstraintLayout constraintLayout, ImageView imageView, CustomCircleView customCircleView, ConstraintLayout constraintLayout2, TransparentClickImageView transparentClickImageView, View view, ImageView imageView2, LifeTotalView lifeTotalView, LifeTotalView lifeTotalView2, LifeTotalView lifeTotalView3, TextView textView, TextView textView2, TextView textView3, View view2, View view3, ImageView imageView3, ConstraintLayout constraintLayout3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.backgroundImage = imageView;
        this.circleView = customCircleView;
        this.constraintLayout = constraintLayout2;
        this.customMenuButtonImage = transparentClickImageView;
        this.dayNightBkg = view;
        this.dayNightImageView = imageView2;
        this.lifeTotalView1 = lifeTotalView;
        this.lifeTotalView2 = lifeTotalView2;
        this.lifeTotalView3 = lifeTotalView3;
        this.menuButton = textView;
        this.menuButtonBlack = textView2;
        this.menuButtonWhite = textView3;
        this.overlayView1 = view2;
        this.planechaseBkg = view3;
        this.planechaseImageView = imageView3;
        this.startGameButtonLayout = constraintLayout3;
        this.startGameButtonText = textView4;
        this.timerPausedTextView = textView5;
        this.timerTextView = textView6;
        this.timerTurnTextView = textView7;
    }

    public static FragmentGame3PlayersType2Binding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        int i = R.id.backgroundImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.circleView;
            CustomCircleView customCircleView = (CustomCircleView) ViewBindings.findChildViewById(view, i);
            if (customCircleView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.customMenuButtonImage;
                TransparentClickImageView transparentClickImageView = (TransparentClickImageView) ViewBindings.findChildViewById(view, i);
                if (transparentClickImageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.dayNightBkg))) != null) {
                    i = R.id.dayNightImageView;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.lifeTotalView1;
                        LifeTotalView lifeTotalView = (LifeTotalView) ViewBindings.findChildViewById(view, i);
                        if (lifeTotalView != null) {
                            i = R.id.lifeTotalView2;
                            LifeTotalView lifeTotalView2 = (LifeTotalView) ViewBindings.findChildViewById(view, i);
                            if (lifeTotalView2 != null) {
                                i = R.id.lifeTotalView3;
                                LifeTotalView lifeTotalView3 = (LifeTotalView) ViewBindings.findChildViewById(view, i);
                                if (lifeTotalView3 != null) {
                                    i = R.id.menu_button;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.menu_button_black;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.menu_button_white;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.overlayView1))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.planechaseBkg))) != null) {
                                                i = R.id.planechaseImageView;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView3 != null) {
                                                    i = R.id.startGameButtonLayout;
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout2 != null) {
                                                        i = R.id.startGameButtonText;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.timerPausedTextView;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R.id.timerTextView;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView6 != null) {
                                                                    i = R.id.timerTurnTextView;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView7 != null) {
                                                                        return new FragmentGame3PlayersType2Binding(constraintLayout, imageView, customCircleView, constraintLayout, transparentClickImageView, viewFindChildViewById, imageView2, lifeTotalView, lifeTotalView2, lifeTotalView3, textView, textView2, textView3, viewFindChildViewById2, viewFindChildViewById3, imageView3, constraintLayout2, textView4, textView5, textView6, textView7);
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

    public static FragmentGame3PlayersType2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGame3PlayersType2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_game_3_players_type_2, viewGroup, false);
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
