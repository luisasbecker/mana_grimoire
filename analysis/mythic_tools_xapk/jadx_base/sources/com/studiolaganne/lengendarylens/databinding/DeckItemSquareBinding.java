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
import com.studiolaganne.lengendarylens.LoadingImageViewDeck;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckItemSquareBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout;
    public final ImageView bMana;
    public final ConstraintLayout bracketLayout;
    public final TextView bracketValueTextView;
    public final ImageView cMana;
    public final TextView closeBracketTextView;
    public final TextView deckFormat;
    public final LoadingImageViewDeck deckImage;
    public final TextView deckName;
    public final ImageView gMana;
    public final ConstraintLayout innerLayout;
    public final LinearLayout manaLayout;
    public final TextView openBracketTextView;
    public final ConstraintLayout playgroundInfoLayout;
    public final ImageView rMana;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final ImageView uMana;
    public final ImageView wMana;

    private DeckItemSquareBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, ImageView imageView2, TextView textView2, TextView textView3, LoadingImageViewDeck loadingImageViewDeck, TextView textView4, ImageView imageView3, ConstraintLayout constraintLayout3, LinearLayout linearLayout2, TextView textView5, ConstraintLayout constraintLayout4, ImageView imageView4, ConstraintLayout constraintLayout5, ImageView imageView5, ImageView imageView6) {
        this.rootView = constraintLayout;
        this.accountInfoVerticalLayout = linearLayout;
        this.bMana = imageView;
        this.bracketLayout = constraintLayout2;
        this.bracketValueTextView = textView;
        this.cMana = imageView2;
        this.closeBracketTextView = textView2;
        this.deckFormat = textView3;
        this.deckImage = loadingImageViewDeck;
        this.deckName = textView4;
        this.gMana = imageView3;
        this.innerLayout = constraintLayout3;
        this.manaLayout = linearLayout2;
        this.openBracketTextView = textView5;
        this.playgroundInfoLayout = constraintLayout4;
        this.rMana = imageView4;
        this.rootLayout = constraintLayout5;
        this.uMana = imageView5;
        this.wMana = imageView6;
    }

    public static DeckItemSquareBinding bind(View view) {
        int i = R.id.accountInfoVerticalLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.b_mana;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.bracketLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.bracketValueTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.c_mana;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.closeBracketTextView;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.deckFormat;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.deckImage;
                                    LoadingImageViewDeck loadingImageViewDeck = (LoadingImageViewDeck) ViewBindings.findChildViewById(view, i);
                                    if (loadingImageViewDeck != null) {
                                        i = R.id.deckName;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.g_mana;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView3 != null) {
                                                i = R.id.innerLayout;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout2 != null) {
                                                    i = R.id.manaLayout;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.openBracketTextView;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.playgroundInfoLayout;
                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout3 != null) {
                                                                i = R.id.r_mana;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView4 != null) {
                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view;
                                                                    i = R.id.u_mana;
                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView5 != null) {
                                                                        i = R.id.w_mana;
                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView6 != null) {
                                                                            return new DeckItemSquareBinding(constraintLayout4, linearLayout, imageView, constraintLayout, textView, imageView2, textView2, textView3, loadingImageViewDeck, textView4, imageView3, constraintLayout2, linearLayout2, textView5, constraintLayout3, imageView4, constraintLayout4, imageView5, imageView6);
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

    public static DeckItemSquareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckItemSquareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_item_square, viewGroup, false);
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
