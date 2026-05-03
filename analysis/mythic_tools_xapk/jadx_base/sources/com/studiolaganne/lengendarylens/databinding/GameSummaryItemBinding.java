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
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.LifeTotalView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class GameSummaryItemBinding implements ViewBinding {
    public final ImageView bManaSummary;
    public final ConstraintLayout bracketLayoutResult;
    public final TextView bracketValueText;
    public final ImageView cManaSummary;
    public final ImageView clockImage;
    public final TextView closeBracketTextView;
    public final ImageView deckImageView;
    public final ConstraintLayout deckLayout;
    public final TextView deckNameTextView;
    public final ImageView gManaSummary;
    public final LifeTotalView lifeTotalView;
    public final ConstraintLayout lifeTotalViewLayout;
    public final LinearLayout manaLayoutSummary;
    public final ImageView noPhotoIconSummary;
    public final TextView openBracketTextView;
    public final CachedImageView profileIconSummary;
    public final ConstraintLayout profileLayoutSummary;
    public final ImageView rManaSummary;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final TextView startingPlayerLabel;
    public final ConstraintLayout totalTimeLayout;
    public final TextView totalTimeTextView;
    public final ImageView uManaSummary;
    public final TextView userFirstnameTextView;
    public final LinearLayout userLayout;
    public final TextView userNameTextView;
    public final ImageView wManaSummary;
    public final TextView winnerTextView;

    private GameSummaryItemBinding(LinearLayout linearLayout, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, ImageView imageView2, ImageView imageView3, TextView textView2, ImageView imageView4, ConstraintLayout constraintLayout2, TextView textView3, ImageView imageView5, LifeTotalView lifeTotalView, ConstraintLayout constraintLayout3, LinearLayout linearLayout2, ImageView imageView6, TextView textView4, CachedImageView cachedImageView, ConstraintLayout constraintLayout4, ImageView imageView7, LinearLayout linearLayout3, TextView textView5, ConstraintLayout constraintLayout5, TextView textView6, ImageView imageView8, TextView textView7, LinearLayout linearLayout4, TextView textView8, ImageView imageView9, TextView textView9) {
        this.rootView = linearLayout;
        this.bManaSummary = imageView;
        this.bracketLayoutResult = constraintLayout;
        this.bracketValueText = textView;
        this.cManaSummary = imageView2;
        this.clockImage = imageView3;
        this.closeBracketTextView = textView2;
        this.deckImageView = imageView4;
        this.deckLayout = constraintLayout2;
        this.deckNameTextView = textView3;
        this.gManaSummary = imageView5;
        this.lifeTotalView = lifeTotalView;
        this.lifeTotalViewLayout = constraintLayout3;
        this.manaLayoutSummary = linearLayout2;
        this.noPhotoIconSummary = imageView6;
        this.openBracketTextView = textView4;
        this.profileIconSummary = cachedImageView;
        this.profileLayoutSummary = constraintLayout4;
        this.rManaSummary = imageView7;
        this.rootLayout = linearLayout3;
        this.startingPlayerLabel = textView5;
        this.totalTimeLayout = constraintLayout5;
        this.totalTimeTextView = textView6;
        this.uManaSummary = imageView8;
        this.userFirstnameTextView = textView7;
        this.userLayout = linearLayout4;
        this.userNameTextView = textView8;
        this.wManaSummary = imageView9;
        this.winnerTextView = textView9;
    }

    public static GameSummaryItemBinding bind(View view) {
        int i = R.id.b_manaSummary;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.bracketLayoutResult;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.bracketValueText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.c_manaSummary;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.clock_image;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.closeBracketTextView;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.deckImageView;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView4 != null) {
                                    i = R.id.deckLayout;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout2 != null) {
                                        i = R.id.deckNameTextView;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.g_manaSummary;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView5 != null) {
                                                i = R.id.lifeTotalView;
                                                LifeTotalView lifeTotalView = (LifeTotalView) ViewBindings.findChildViewById(view, i);
                                                if (lifeTotalView != null) {
                                                    i = R.id.lifeTotalViewLayout;
                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout3 != null) {
                                                        i = R.id.manaLayoutSummary;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout != null) {
                                                            i = R.id.noPhotoIconSummary;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView6 != null) {
                                                                i = R.id.openBracketTextView;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView4 != null) {
                                                                    i = R.id.profileIconSummary;
                                                                    CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (cachedImageView != null) {
                                                                        i = R.id.profileLayoutSummary;
                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (constraintLayout4 != null) {
                                                                            i = R.id.r_manaSummary;
                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView7 != null) {
                                                                                LinearLayout linearLayout2 = (LinearLayout) view;
                                                                                i = R.id.startingPlayerLabel;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView5 != null) {
                                                                                    i = R.id.totalTimeLayout;
                                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (constraintLayout5 != null) {
                                                                                        i = R.id.totalTimeTextView;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.u_manaSummary;
                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                            if (imageView8 != null) {
                                                                                                i = R.id.userFirstnameTextView;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView7 != null) {
                                                                                                    i = R.id.userLayout;
                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout3 != null) {
                                                                                                        i = R.id.userNameTextView;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView8 != null) {
                                                                                                            i = R.id.w_manaSummary;
                                                                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (imageView9 != null) {
                                                                                                                i = R.id.winnerTextView;
                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView9 != null) {
                                                                                                                    return new GameSummaryItemBinding(linearLayout2, imageView, constraintLayout, textView, imageView2, imageView3, textView2, imageView4, constraintLayout2, textView3, imageView5, lifeTotalView, constraintLayout3, linearLayout, imageView6, textView4, cachedImageView, constraintLayout4, imageView7, linearLayout2, textView5, constraintLayout5, textView6, imageView8, textView7, linearLayout3, textView8, imageView9, textView9);
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

    public static GameSummaryItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GameSummaryItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.game_summary_item, viewGroup, false);
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
