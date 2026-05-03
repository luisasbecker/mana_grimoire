package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentGamePlayersBinding implements ViewBinding {
    public final CardView cardView2;
    public final TextView cardView2Text;
    public final CardView cardView3;
    public final TextView cardView3Text;
    public final CardView cardView4;
    public final TextView cardView4Text;
    public final CardView cardView5;
    public final TextView cardView5Text;
    public final CardView cardView6;
    public final TextView cardView6Text;
    public final CardView cardView7;
    public final TextView cardView7Text;
    public final CardView cardView8;
    public final TextView cardView8Text;
    public final CardView cardViewSpacer1;
    public final TextView cardViewSpacer1Text;
    public final CardView cardViewSpacer2;
    public final TextView cardViewSpacer2Text;
    public final TextView questionText;
    private final ConstraintLayout rootView;

    private FragmentGamePlayersBinding(ConstraintLayout constraintLayout, CardView cardView, TextView textView, CardView cardView2, TextView textView2, CardView cardView3, TextView textView3, CardView cardView4, TextView textView4, CardView cardView5, TextView textView5, CardView cardView6, TextView textView6, CardView cardView7, TextView textView7, CardView cardView8, TextView textView8, CardView cardView9, TextView textView9, TextView textView10) {
        this.rootView = constraintLayout;
        this.cardView2 = cardView;
        this.cardView2Text = textView;
        this.cardView3 = cardView2;
        this.cardView3Text = textView2;
        this.cardView4 = cardView3;
        this.cardView4Text = textView3;
        this.cardView5 = cardView4;
        this.cardView5Text = textView4;
        this.cardView6 = cardView5;
        this.cardView6Text = textView5;
        this.cardView7 = cardView6;
        this.cardView7Text = textView6;
        this.cardView8 = cardView7;
        this.cardView8Text = textView7;
        this.cardViewSpacer1 = cardView8;
        this.cardViewSpacer1Text = textView8;
        this.cardViewSpacer2 = cardView9;
        this.cardViewSpacer2Text = textView9;
        this.questionText = textView10;
    }

    public static FragmentGamePlayersBinding bind(View view) {
        int i = R.id.cardView2;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.cardView2_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.cardView3;
                CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView2 != null) {
                    i = R.id.cardView3_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.cardView4;
                        CardView cardView3 = (CardView) ViewBindings.findChildViewById(view, i);
                        if (cardView3 != null) {
                            i = R.id.cardView4_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.cardView5;
                                CardView cardView4 = (CardView) ViewBindings.findChildViewById(view, i);
                                if (cardView4 != null) {
                                    i = R.id.cardView5_text;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.cardView6;
                                        CardView cardView5 = (CardView) ViewBindings.findChildViewById(view, i);
                                        if (cardView5 != null) {
                                            i = R.id.cardView6_text;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.cardView7;
                                                CardView cardView6 = (CardView) ViewBindings.findChildViewById(view, i);
                                                if (cardView6 != null) {
                                                    i = R.id.cardView7_text;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.cardView8;
                                                        CardView cardView7 = (CardView) ViewBindings.findChildViewById(view, i);
                                                        if (cardView7 != null) {
                                                            i = R.id.cardView8_text;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView7 != null) {
                                                                i = R.id.cardViewSpacer1;
                                                                CardView cardView8 = (CardView) ViewBindings.findChildViewById(view, i);
                                                                if (cardView8 != null) {
                                                                    i = R.id.cardViewSpacer1_text;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.cardViewSpacer2;
                                                                        CardView cardView9 = (CardView) ViewBindings.findChildViewById(view, i);
                                                                        if (cardView9 != null) {
                                                                            i = R.id.cardViewSpacer2_text;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView9 != null) {
                                                                                i = R.id.question_text;
                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView10 != null) {
                                                                                    return new FragmentGamePlayersBinding((ConstraintLayout) view, cardView, textView, cardView2, textView2, cardView3, textView3, cardView4, textView4, cardView5, textView5, cardView6, textView6, cardView7, textView7, cardView8, textView8, cardView9, textView9, textView10);
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

    public static FragmentGamePlayersBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGamePlayersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_game_players, viewGroup, false);
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
