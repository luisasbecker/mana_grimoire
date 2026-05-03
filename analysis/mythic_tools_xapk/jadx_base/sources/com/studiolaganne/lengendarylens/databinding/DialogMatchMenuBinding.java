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
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogMatchMenuBinding implements ViewBinding {
    public final ImageView closeImage;
    public final TextView concedeButtonText;
    public final TextView concedeButtonText2;
    public final ImageView concedeIcon;
    public final ImageView concedeIcon2;
    public final ConstraintLayout concedeLayout;
    public final ConstraintLayout concedeLayout2;
    public final TextView drawButtonText;
    public final TextView drawButtonText2;
    public final ImageView drawIcon;
    public final ImageView drawIcon2;
    public final ConstraintLayout drawLayout;
    public final ConstraintLayout drawLayout2;
    public final MaterialButton endGameButton;
    public final LinearLayout linearLayout;
    public final LinearLayout linearLayoutBottom;
    public final LinearLayout linearLayoutBottom2;
    public final LinearLayout linearLayoutTop;
    public final LinearLayout linearLayoutTop2;
    public final TextView loseButtonText;
    public final TextView loseButtonText2;
    public final ImageView loseIcon;
    public final ImageView loseIcon2;
    public final ConstraintLayout loseLayout;
    public final ConstraintLayout loseLayout2;
    public final ConstraintLayout player1Layout;
    public final ConstraintLayout player2Layout;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final View separator;
    public final TextView winButtonText;
    public final TextView winButtonText2;
    public final ImageView winIcon;
    public final ImageView winIcon2;
    public final ConstraintLayout winLayout;
    public final ConstraintLayout winLayout2;

    private DialogMatchMenuBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView3, TextView textView4, ImageView imageView4, ImageView imageView5, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, MaterialButton materialButton, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView5, TextView textView6, ImageView imageView6, ImageView imageView7, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10, View view, TextView textView7, TextView textView8, ImageView imageView8, ImageView imageView9, ConstraintLayout constraintLayout11, ConstraintLayout constraintLayout12) {
        this.rootView = constraintLayout;
        this.closeImage = imageView;
        this.concedeButtonText = textView;
        this.concedeButtonText2 = textView2;
        this.concedeIcon = imageView2;
        this.concedeIcon2 = imageView3;
        this.concedeLayout = constraintLayout2;
        this.concedeLayout2 = constraintLayout3;
        this.drawButtonText = textView3;
        this.drawButtonText2 = textView4;
        this.drawIcon = imageView4;
        this.drawIcon2 = imageView5;
        this.drawLayout = constraintLayout4;
        this.drawLayout2 = constraintLayout5;
        this.endGameButton = materialButton;
        this.linearLayout = linearLayout;
        this.linearLayoutBottom = linearLayout2;
        this.linearLayoutBottom2 = linearLayout3;
        this.linearLayoutTop = linearLayout4;
        this.linearLayoutTop2 = linearLayout5;
        this.loseButtonText = textView5;
        this.loseButtonText2 = textView6;
        this.loseIcon = imageView6;
        this.loseIcon2 = imageView7;
        this.loseLayout = constraintLayout6;
        this.loseLayout2 = constraintLayout7;
        this.player1Layout = constraintLayout8;
        this.player2Layout = constraintLayout9;
        this.rootLayout = constraintLayout10;
        this.separator = view;
        this.winButtonText = textView7;
        this.winButtonText2 = textView8;
        this.winIcon = imageView8;
        this.winIcon2 = imageView9;
        this.winLayout = constraintLayout11;
        this.winLayout2 = constraintLayout12;
    }

    public static DialogMatchMenuBinding bind(View view) {
        int i = R.id.closeImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.concedeButtonText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.concedeButtonText_2;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.concede_icon;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.concede_icon_2;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.concedeLayout;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                i = R.id.concedeLayout_2;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout2 != null) {
                                    i = R.id.drawButtonText;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.drawButtonText_2;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.draw_icon;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView4 != null) {
                                                i = R.id.draw_icon_2;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView5 != null) {
                                                    i = R.id.drawLayout;
                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout3 != null) {
                                                        i = R.id.drawLayout_2;
                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout4 != null) {
                                                            i = R.id.endGameButton;
                                                            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                                            if (materialButton != null) {
                                                                i = R.id.linearLayout;
                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout != null) {
                                                                    i = R.id.linearLayoutBottom;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout2 != null) {
                                                                        i = R.id.linearLayoutBottom_2;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout3 != null) {
                                                                            i = R.id.linearLayoutTop;
                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout4 != null) {
                                                                                i = R.id.linearLayoutTop_2;
                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout5 != null) {
                                                                                    i = R.id.loseButtonText;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.loseButtonText_2;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.lose_icon;
                                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                            if (imageView6 != null) {
                                                                                                i = R.id.lose_icon_2;
                                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView7 != null) {
                                                                                                    i = R.id.loseLayout;
                                                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (constraintLayout5 != null) {
                                                                                                        i = R.id.loseLayout_2;
                                                                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (constraintLayout6 != null) {
                                                                                                            i = R.id.player1Layout;
                                                                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (constraintLayout7 != null) {
                                                                                                                i = R.id.player2Layout;
                                                                                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (constraintLayout8 != null) {
                                                                                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) view;
                                                                                                                    i = R.id.separator;
                                                                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
                                                                                                                    if (viewFindChildViewById != null) {
                                                                                                                        i = R.id.winButtonText;
                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView7 != null) {
                                                                                                                            i = R.id.winButtonText_2;
                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView8 != null) {
                                                                                                                                i = R.id.win_icon;
                                                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (imageView8 != null) {
                                                                                                                                    i = R.id.win_icon_2;
                                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (imageView9 != null) {
                                                                                                                                        i = R.id.winLayout;
                                                                                                                                        ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (constraintLayout10 != null) {
                                                                                                                                            i = R.id.winLayout_2;
                                                                                                                                            ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (constraintLayout11 != null) {
                                                                                                                                                return new DialogMatchMenuBinding(constraintLayout9, imageView, textView, textView2, imageView2, imageView3, constraintLayout, constraintLayout2, textView3, textView4, imageView4, imageView5, constraintLayout3, constraintLayout4, materialButton, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, textView5, textView6, imageView6, imageView7, constraintLayout5, constraintLayout6, constraintLayout7, constraintLayout8, constraintLayout9, viewFindChildViewById, textView7, textView8, imageView8, imageView9, constraintLayout10, constraintLayout11);
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

    public static DialogMatchMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogMatchMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_match_menu, viewGroup, false);
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
