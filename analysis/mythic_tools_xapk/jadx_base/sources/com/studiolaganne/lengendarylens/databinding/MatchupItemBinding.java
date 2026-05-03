package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.LoadingImageViewDeck;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class MatchupItemBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout;
    public final LoadingImageViewDeck deckImage;
    public final ConstraintLayout innerLayout;
    public final ConstraintLayout leftLayout;
    public final TextView matchupName;
    public final TextView numDrawsValueLabel;
    public final TextView numGamesLabel;
    public final TextView numGamesValueLabel;
    public final TextView numLossesLabel;
    public final TextView numLossesValueLabel;
    public final TextView numWinsLabel;
    public final TextView numWinsValueLabel;
    public final ConstraintLayout playgroundInfoLayout;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final LinearLayout winLossLayout;
    public final TextView winrateValue;

    private MatchupItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LoadingImageViewDeck loadingImageViewDeck, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, ConstraintLayout constraintLayout3, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView9) {
        this.rootView = linearLayout;
        this.accountInfoVerticalLayout = linearLayout2;
        this.deckImage = loadingImageViewDeck;
        this.innerLayout = constraintLayout;
        this.leftLayout = constraintLayout2;
        this.matchupName = textView;
        this.numDrawsValueLabel = textView2;
        this.numGamesLabel = textView3;
        this.numGamesValueLabel = textView4;
        this.numLossesLabel = textView5;
        this.numLossesValueLabel = textView6;
        this.numWinsLabel = textView7;
        this.numWinsValueLabel = textView8;
        this.playgroundInfoLayout = constraintLayout3;
        this.rootLayout = linearLayout3;
        this.winLossLayout = linearLayout4;
        this.winrateValue = textView9;
    }

    public static MatchupItemBinding bind(View view) {
        int i = R.id.accountInfoVerticalLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.deckImage;
            LoadingImageViewDeck loadingImageViewDeck = (LoadingImageViewDeck) ViewBindings.findChildViewById(view, i);
            if (loadingImageViewDeck != null) {
                i = R.id.innerLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.left_layout;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.matchupName;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.numDrawsValueLabel;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.numGamesLabel;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.numGamesValueLabel;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.numLossesLabel;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.numLossesValueLabel;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.numWinsLabel;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView7 != null) {
                                                    i = R.id.numWinsValueLabel;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView8 != null) {
                                                        i = R.id.playgroundInfoLayout;
                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout3 != null) {
                                                            LinearLayout linearLayout2 = (LinearLayout) view;
                                                            i = R.id.winLossLayout;
                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout3 != null) {
                                                                i = R.id.winrateValue;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView9 != null) {
                                                                    return new MatchupItemBinding(linearLayout2, linearLayout, loadingImageViewDeck, constraintLayout, constraintLayout2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, constraintLayout3, linearLayout2, linearLayout3, textView9);
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

    public static MatchupItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MatchupItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.matchup_item, viewGroup, false);
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
