package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CmdDamageAssignViewBinding implements ViewBinding {
    public final FrameLayout bottomHalf;
    public final FrameLayout bottomLeftHalf;
    public final FrameLayout bottomRightHalf;
    public final ImageView cardBackgroundImage;
    public final CardView cardView;
    public final RelativeLayout cmdRootLayout;
    public final TextView commanderNameTextView;
    public final ImageView decreaseLifeTotal;
    public final ConstraintLayout doubleValueLayout;
    public final ImageView increaseLifeTotal;
    public final FrameLayout leftHalf;
    public final TextView lifeTotalTextView;
    public final TextView lifeTotalTextViewLeft;
    public final TextView lifeTotalTextViewRight;
    public final RelativeLayout mainRelativeLayout;
    public final View overlay;
    public final TextView partnerName1TextView;
    public final TextView partnerName2TextView;
    public final TextView playerNameLabel;
    public final FrameLayout rightHalf;
    private final CardView rootView;
    public final TextView runningTotalTextViewDown;
    public final TextView runningTotalTextViewUp;
    public final View separator;
    public final ConstraintLayout singleValueLayout;
    public final FrameLayout topHalf;
    public final FrameLayout topLeftHalf;
    public final FrameLayout topRightHalf;

    private CmdDamageAssignViewBinding(CardView cardView, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, CardView cardView2, RelativeLayout relativeLayout, TextView textView, ImageView imageView2, ConstraintLayout constraintLayout, ImageView imageView3, FrameLayout frameLayout4, TextView textView2, TextView textView3, TextView textView4, RelativeLayout relativeLayout2, View view, TextView textView5, TextView textView6, TextView textView7, FrameLayout frameLayout5, TextView textView8, TextView textView9, View view2, ConstraintLayout constraintLayout2, FrameLayout frameLayout6, FrameLayout frameLayout7, FrameLayout frameLayout8) {
        this.rootView = cardView;
        this.bottomHalf = frameLayout;
        this.bottomLeftHalf = frameLayout2;
        this.bottomRightHalf = frameLayout3;
        this.cardBackgroundImage = imageView;
        this.cardView = cardView2;
        this.cmdRootLayout = relativeLayout;
        this.commanderNameTextView = textView;
        this.decreaseLifeTotal = imageView2;
        this.doubleValueLayout = constraintLayout;
        this.increaseLifeTotal = imageView3;
        this.leftHalf = frameLayout4;
        this.lifeTotalTextView = textView2;
        this.lifeTotalTextViewLeft = textView3;
        this.lifeTotalTextViewRight = textView4;
        this.mainRelativeLayout = relativeLayout2;
        this.overlay = view;
        this.partnerName1TextView = textView5;
        this.partnerName2TextView = textView6;
        this.playerNameLabel = textView7;
        this.rightHalf = frameLayout5;
        this.runningTotalTextViewDown = textView8;
        this.runningTotalTextViewUp = textView9;
        this.separator = view2;
        this.singleValueLayout = constraintLayout2;
        this.topHalf = frameLayout6;
        this.topLeftHalf = frameLayout7;
        this.topRightHalf = frameLayout8;
    }

    public static CmdDamageAssignViewBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.bottomHalf;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.bottomLeftHalf;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout2 != null) {
                i = R.id.bottomRightHalf;
                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout3 != null) {
                    i = R.id.card_background_image;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        CardView cardView = (CardView) view;
                        i = R.id.cmdRootLayout;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = R.id.commanderNameTextView;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.decreaseLifeTotal;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = R.id.doubleValueLayout;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout != null) {
                                        i = R.id.increaseLifeTotal;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.leftHalf;
                                            FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                            if (frameLayout4 != null) {
                                                i = R.id.lifeTotalTextView;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.lifeTotalTextViewLeft;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.lifeTotalTextViewRight;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.main_relative_layout;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.overlay))) != null) {
                                                                i = R.id.partnerName1TextView;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.partnerName2TextView;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.playerNameLabel;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.rightHalf;
                                                                            FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (frameLayout5 != null) {
                                                                                i = R.id.runningTotalTextViewDown;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.runningTotalTextViewUp;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView9 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.separator))) != null) {
                                                                                        i = R.id.singleValueLayout;
                                                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (constraintLayout2 != null) {
                                                                                            i = R.id.topHalf;
                                                                                            FrameLayout frameLayout6 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (frameLayout6 != null) {
                                                                                                i = R.id.topLeftHalf;
                                                                                                FrameLayout frameLayout7 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (frameLayout7 != null) {
                                                                                                    i = R.id.topRightHalf;
                                                                                                    FrameLayout frameLayout8 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (frameLayout8 != null) {
                                                                                                        return new CmdDamageAssignViewBinding(cardView, frameLayout, frameLayout2, frameLayout3, imageView, cardView, relativeLayout, textView, imageView2, constraintLayout, imageView3, frameLayout4, textView2, textView3, textView4, relativeLayout2, viewFindChildViewById, textView5, textView6, textView7, frameLayout5, textView8, textView9, viewFindChildViewById2, constraintLayout2, frameLayout6, frameLayout7, frameLayout8);
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

    public static CmdDamageAssignViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CmdDamageAssignViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.cmd_damage_assign_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }
}
