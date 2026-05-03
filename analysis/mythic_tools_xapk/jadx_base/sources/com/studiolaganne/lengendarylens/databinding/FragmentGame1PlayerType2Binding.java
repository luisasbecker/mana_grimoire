package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.LifeTotalView;
import com.studiolaganne.lengendarylens.R;
import com.studiolaganne.lengendarylens.TransparentClickImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentGame1PlayerType2Binding implements ViewBinding {
    public final ImageView backgroundImage;
    public final ConstraintLayout constraintLayout;
    public final TransparentClickImageView customMenuButtonImage;
    public final View dayNightBkg;
    public final ImageView dayNightImageView;
    public final Guideline guideline;
    public final Guideline guideline2;
    public final LifeTotalView lifeTotalView1;
    public final TextView menuButton;
    public final TextView menuButtonBlack;
    public final TextView menuButtonWhite;
    public final View overlayView1;
    private final ConstraintLayout rootView;
    public final ConstraintLayout startGameButtonLayout;
    public final TextView startGameButtonText;
    public final TextView timerTextView;

    private FragmentGame1PlayerType2Binding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TransparentClickImageView transparentClickImageView, View view, ImageView imageView2, Guideline guideline, Guideline guideline2, LifeTotalView lifeTotalView, TextView textView, TextView textView2, TextView textView3, View view2, ConstraintLayout constraintLayout3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.backgroundImage = imageView;
        this.constraintLayout = constraintLayout2;
        this.customMenuButtonImage = transparentClickImageView;
        this.dayNightBkg = view;
        this.dayNightImageView = imageView2;
        this.guideline = guideline;
        this.guideline2 = guideline2;
        this.lifeTotalView1 = lifeTotalView;
        this.menuButton = textView;
        this.menuButtonBlack = textView2;
        this.menuButtonWhite = textView3;
        this.overlayView1 = view2;
        this.startGameButtonLayout = constraintLayout3;
        this.startGameButtonText = textView4;
        this.timerTextView = textView5;
    }

    public static FragmentGame1PlayerType2Binding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.backgroundImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.customMenuButtonImage;
            TransparentClickImageView transparentClickImageView = (TransparentClickImageView) ViewBindings.findChildViewById(view, i);
            if (transparentClickImageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.dayNightBkg))) != null) {
                i = R.id.dayNightImageView;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.guideline;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline != null) {
                        i = R.id.guideline2;
                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline2 != null) {
                            i = R.id.lifeTotalView1;
                            LifeTotalView lifeTotalView = (LifeTotalView) ViewBindings.findChildViewById(view, i);
                            if (lifeTotalView != null) {
                                i = R.id.menu_button;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.menu_button_black;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.menu_button_white;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.overlayView1))) != null) {
                                            i = R.id.startGameButtonLayout;
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout2 != null) {
                                                i = R.id.startGameButtonText;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.timerTextView;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        return new FragmentGame1PlayerType2Binding(constraintLayout, imageView, constraintLayout, transparentClickImageView, viewFindChildViewById, imageView2, guideline, guideline2, lifeTotalView, textView, textView2, textView3, viewFindChildViewById2, constraintLayout2, textView4, textView5);
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

    public static FragmentGame1PlayerType2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGame1PlayerType2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_game_1_player_type_2, viewGroup, false);
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
