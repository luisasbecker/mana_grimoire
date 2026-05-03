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
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogDiceSelectionBinding implements ViewBinding {
    public final ImageView backButton;
    public final ImageView closeButton;
    public final ConstraintLayout coinLayout;
    public final TextView coinLose;
    public final TextView coinWin;
    public final ConstraintLayout d10Layout;
    public final ConstraintLayout d12Layout;
    public final ConstraintLayout d20Layout;
    public final ConstraintLayout d4Layout;
    public final ConstraintLayout d6Layout;
    public final ConstraintLayout d8Layout;
    public final TextView diceLabelTextCoin;
    public final TextView diceLabelTextD10;
    public final TextView diceLabelTextD12;
    public final TextView diceLabelTextD20;
    public final TextView diceLabelTextD4;
    public final TextView diceLabelTextD6;
    public final TextView diceLabelTextD8;
    public final ImageView diceTextCoin;
    public final TextView diceTextD10;
    public final TextView diceTextD12;
    public final TextView diceTextD20;
    public final TextView diceTextD4;
    public final TextView diceTextD6;
    public final TextView diceTextD8;
    public final ConstraintLayout emptyLayout1;
    public final ConstraintLayout emptyLayout2;
    public final LinearLayout lineOne;
    public final LinearLayout lineTwo;
    public final LinearLayout lineZero;
    public final ConstraintLayout phyrexianLayout;
    public final ConstraintLayout playerLayout;
    public final ImageView playerTossImage;
    public final TextView playerTossText;
    public final ImageView rerollButton;
    public final TextView rerollLabel;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final LinearLayout verticalLayout;

    private DialogDiceSelectionBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ConstraintLayout constraintLayout8, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ImageView imageView3, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ConstraintLayout constraintLayout11, ConstraintLayout constraintLayout12, ImageView imageView4, TextView textView16, ImageView imageView5, TextView textView17, ConstraintLayout constraintLayout13, LinearLayout linearLayout4) {
        this.rootView = constraintLayout;
        this.backButton = imageView;
        this.closeButton = imageView2;
        this.coinLayout = constraintLayout2;
        this.coinLose = textView;
        this.coinWin = textView2;
        this.d10Layout = constraintLayout3;
        this.d12Layout = constraintLayout4;
        this.d20Layout = constraintLayout5;
        this.d4Layout = constraintLayout6;
        this.d6Layout = constraintLayout7;
        this.d8Layout = constraintLayout8;
        this.diceLabelTextCoin = textView3;
        this.diceLabelTextD10 = textView4;
        this.diceLabelTextD12 = textView5;
        this.diceLabelTextD20 = textView6;
        this.diceLabelTextD4 = textView7;
        this.diceLabelTextD6 = textView8;
        this.diceLabelTextD8 = textView9;
        this.diceTextCoin = imageView3;
        this.diceTextD10 = textView10;
        this.diceTextD12 = textView11;
        this.diceTextD20 = textView12;
        this.diceTextD4 = textView13;
        this.diceTextD6 = textView14;
        this.diceTextD8 = textView15;
        this.emptyLayout1 = constraintLayout9;
        this.emptyLayout2 = constraintLayout10;
        this.lineOne = linearLayout;
        this.lineTwo = linearLayout2;
        this.lineZero = linearLayout3;
        this.phyrexianLayout = constraintLayout11;
        this.playerLayout = constraintLayout12;
        this.playerTossImage = imageView4;
        this.playerTossText = textView16;
        this.rerollButton = imageView5;
        this.rerollLabel = textView17;
        this.rootLayout = constraintLayout13;
        this.verticalLayout = linearLayout4;
    }

    public static DialogDiceSelectionBinding bind(View view) {
        int i = R.id.backButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.closeButton;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.coinLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.coinLose;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.coinWin;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.d10Layout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = R.id.d12Layout;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.d20Layout;
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout4 != null) {
                                        i = R.id.d4Layout;
                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout5 != null) {
                                            i = R.id.d6Layout;
                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout6 != null) {
                                                i = R.id.d8Layout;
                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout7 != null) {
                                                    i = R.id.dice_label_text_coin;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.dice_label_text_d10;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.dice_label_text_d12;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R.id.dice_label_text_d20;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView6 != null) {
                                                                    i = R.id.dice_label_text_d4;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView7 != null) {
                                                                        i = R.id.dice_label_text_d6;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView8 != null) {
                                                                            i = R.id.dice_label_text_d8;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView9 != null) {
                                                                                i = R.id.dice_text_coin;
                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView3 != null) {
                                                                                    i = R.id.dice_text_d10;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView10 != null) {
                                                                                        i = R.id.dice_text_d12;
                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView11 != null) {
                                                                                            i = R.id.dice_text_d20;
                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView12 != null) {
                                                                                                i = R.id.dice_text_d4;
                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView13 != null) {
                                                                                                    i = R.id.dice_text_d6;
                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView14 != null) {
                                                                                                        i = R.id.dice_text_d8;
                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView15 != null) {
                                                                                                            i = R.id.emptyLayout1;
                                                                                                            ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (constraintLayout8 != null) {
                                                                                                                i = R.id.emptyLayout2;
                                                                                                                ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (constraintLayout9 != null) {
                                                                                                                    i = R.id.lineOne;
                                                                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (linearLayout != null) {
                                                                                                                        i = R.id.lineTwo;
                                                                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (linearLayout2 != null) {
                                                                                                                            i = R.id.lineZero;
                                                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (linearLayout3 != null) {
                                                                                                                                ConstraintLayout constraintLayout10 = (ConstraintLayout) view;
                                                                                                                                i = R.id.playerLayout;
                                                                                                                                ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (constraintLayout11 != null) {
                                                                                                                                    i = R.id.playerTossImage;
                                                                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (imageView4 != null) {
                                                                                                                                        i = R.id.playerTossText;
                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView16 != null) {
                                                                                                                                            i = R.id.rerollButton;
                                                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (imageView5 != null) {
                                                                                                                                                i = R.id.rerollLabel;
                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView17 != null) {
                                                                                                                                                    i = R.id.rootLayout;
                                                                                                                                                    ConstraintLayout constraintLayout12 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (constraintLayout12 != null) {
                                                                                                                                                        i = R.id.verticalLayout;
                                                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (linearLayout4 != null) {
                                                                                                                                                            return new DialogDiceSelectionBinding(constraintLayout10, imageView, imageView2, constraintLayout, textView, textView2, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, constraintLayout7, textView3, textView4, textView5, textView6, textView7, textView8, textView9, imageView3, textView10, textView11, textView12, textView13, textView14, textView15, constraintLayout8, constraintLayout9, linearLayout, linearLayout2, linearLayout3, constraintLayout10, constraintLayout11, imageView4, textView16, imageView5, textView17, constraintLayout12, linearLayout4);
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

    public static DialogDiceSelectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogDiceSelectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_dice_selection, viewGroup, false);
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
