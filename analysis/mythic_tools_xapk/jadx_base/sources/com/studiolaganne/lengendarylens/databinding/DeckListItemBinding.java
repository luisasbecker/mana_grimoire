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
import com.studiolaganne.lengendarylens.LoadingImageViewDeck;
import com.studiolaganne.lengendarylens.MythicBorderAnimationView;
import com.studiolaganne.lengendarylens.MythicShimmerView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckListItemBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout;
    public final ImageView bMana;
    public final ConstraintLayout bracketLayout;
    public final TextView bracketValueTextView;
    public final ImageView cMana;
    public final TextView closeBracketTextView;
    public final TextView deckByLabel;
    public final TextView deckFormat;
    public final LoadingImageViewDeck deckImage;
    public final TextView deckName;
    public final ImageView dotsImage;
    public final ConstraintLayout dotsLayout;
    public final ImageView gMana;
    public final ConstraintLayout innerLayout;
    public final ConstraintLayout leftLayout;
    public final LinearLayout manaLayout;
    public final ImageView mythicPlusIcon;
    public final ImageView noPhotoIcon;
    public final TextView numDrawsLabel;
    public final TextView numDrawsValueLabel;
    public final TextView numGamesLabel;
    public final TextView numGamesValueLabel;
    public final TextView numLossesLabel;
    public final TextView numLossesValueLabel;
    public final TextView numWinsLabel;
    public final TextView numWinsValueLabel;
    public final TextView openBracketTextView;
    public final LinearLayout ownerLayout;
    public final TextView pendingText;
    public final ConstraintLayout playgroundInfoLayout;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final ImageView rMana;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final MythicBorderAnimationView smartDeckBorderView;
    public final TextView smartDeckHeader;
    public final ConstraintLayout smartDeckHeaderLayout;
    public final MythicShimmerView smartDeckShimmer;
    public final ImageView uMana;
    public final TextView userName;
    public final ImageView wMana;
    public final LinearLayout winLossLayout;
    public final TextView winrate;
    public final TextView winrateValue;

    private DeckListItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4, LoadingImageViewDeck loadingImageViewDeck, TextView textView5, ImageView imageView3, ConstraintLayout constraintLayout2, ImageView imageView4, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, LinearLayout linearLayout3, ImageView imageView5, ImageView imageView6, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, LinearLayout linearLayout4, TextView textView15, ConstraintLayout constraintLayout5, CachedImageView cachedImageView, ConstraintLayout constraintLayout6, ImageView imageView7, LinearLayout linearLayout5, MythicBorderAnimationView mythicBorderAnimationView, TextView textView16, ConstraintLayout constraintLayout7, MythicShimmerView mythicShimmerView, ImageView imageView8, TextView textView17, ImageView imageView9, LinearLayout linearLayout6, TextView textView18, TextView textView19) {
        this.rootView = linearLayout;
        this.accountInfoVerticalLayout = linearLayout2;
        this.bMana = imageView;
        this.bracketLayout = constraintLayout;
        this.bracketValueTextView = textView;
        this.cMana = imageView2;
        this.closeBracketTextView = textView2;
        this.deckByLabel = textView3;
        this.deckFormat = textView4;
        this.deckImage = loadingImageViewDeck;
        this.deckName = textView5;
        this.dotsImage = imageView3;
        this.dotsLayout = constraintLayout2;
        this.gMana = imageView4;
        this.innerLayout = constraintLayout3;
        this.leftLayout = constraintLayout4;
        this.manaLayout = linearLayout3;
        this.mythicPlusIcon = imageView5;
        this.noPhotoIcon = imageView6;
        this.numDrawsLabel = textView6;
        this.numDrawsValueLabel = textView7;
        this.numGamesLabel = textView8;
        this.numGamesValueLabel = textView9;
        this.numLossesLabel = textView10;
        this.numLossesValueLabel = textView11;
        this.numWinsLabel = textView12;
        this.numWinsValueLabel = textView13;
        this.openBracketTextView = textView14;
        this.ownerLayout = linearLayout4;
        this.pendingText = textView15;
        this.playgroundInfoLayout = constraintLayout5;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout6;
        this.rMana = imageView7;
        this.rootLayout = linearLayout5;
        this.smartDeckBorderView = mythicBorderAnimationView;
        this.smartDeckHeader = textView16;
        this.smartDeckHeaderLayout = constraintLayout7;
        this.smartDeckShimmer = mythicShimmerView;
        this.uMana = imageView8;
        this.userName = textView17;
        this.wMana = imageView9;
        this.winLossLayout = linearLayout6;
        this.winrate = textView18;
        this.winrateValue = textView19;
    }

    public static DeckListItemBinding bind(View view) {
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
                                i = R.id.deckByLabel;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.deckFormat;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.deckImage;
                                        LoadingImageViewDeck loadingImageViewDeck = (LoadingImageViewDeck) ViewBindings.findChildViewById(view, i);
                                        if (loadingImageViewDeck != null) {
                                            i = R.id.deckName;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.dotsImage;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView3 != null) {
                                                    i = R.id.dotsLayout;
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout2 != null) {
                                                        i = R.id.g_mana;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView4 != null) {
                                                            i = R.id.innerLayout;
                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout3 != null) {
                                                                i = R.id.left_layout;
                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout4 != null) {
                                                                    i = R.id.manaLayout;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout2 != null) {
                                                                        i = R.id.mythic_plus_icon;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (imageView5 != null) {
                                                                            i = R.id.no_photo_icon;
                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView6 != null) {
                                                                                i = R.id.numDrawsLabel;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.numDrawsValueLabel;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.numGamesLabel;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.numGamesValueLabel;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.numLossesLabel;
                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView10 != null) {
                                                                                                    i = R.id.numLossesValueLabel;
                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView11 != null) {
                                                                                                        i = R.id.numWinsLabel;
                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView12 != null) {
                                                                                                            i = R.id.numWinsValueLabel;
                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView13 != null) {
                                                                                                                i = R.id.openBracketTextView;
                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView14 != null) {
                                                                                                                    i = R.id.ownerLayout;
                                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (linearLayout3 != null) {
                                                                                                                        i = R.id.pendingText;
                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView15 != null) {
                                                                                                                            i = R.id.playgroundInfoLayout;
                                                                                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (constraintLayout5 != null) {
                                                                                                                                i = R.id.profile_icon;
                                                                                                                                CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (cachedImageView != null) {
                                                                                                                                    i = R.id.profileLayout;
                                                                                                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (constraintLayout6 != null) {
                                                                                                                                        i = R.id.r_mana;
                                                                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (imageView7 != null) {
                                                                                                                                            LinearLayout linearLayout4 = (LinearLayout) view;
                                                                                                                                            i = R.id.smartDeckBorderView;
                                                                                                                                            MythicBorderAnimationView mythicBorderAnimationView = (MythicBorderAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (mythicBorderAnimationView != null) {
                                                                                                                                                i = R.id.smartDeckHeader;
                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView16 != null) {
                                                                                                                                                    i = R.id.smartDeckHeaderLayout;
                                                                                                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (constraintLayout7 != null) {
                                                                                                                                                        i = R.id.smartDeckShimmer;
                                                                                                                                                        MythicShimmerView mythicShimmerView = (MythicShimmerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (mythicShimmerView != null) {
                                                                                                                                                            i = R.id.u_mana;
                                                                                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (imageView8 != null) {
                                                                                                                                                                i = R.id.userName;
                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                    i = R.id.w_mana;
                                                                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (imageView9 != null) {
                                                                                                                                                                        i = R.id.winLossLayout;
                                                                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (linearLayout5 != null) {
                                                                                                                                                                            i = R.id.winrate;
                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                i = R.id.winrateValue;
                                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                    return new DeckListItemBinding(linearLayout4, linearLayout, imageView, constraintLayout, textView, imageView2, textView2, textView3, textView4, loadingImageViewDeck, textView5, imageView3, constraintLayout2, imageView4, constraintLayout3, constraintLayout4, linearLayout2, imageView5, imageView6, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, linearLayout3, textView15, constraintLayout5, cachedImageView, constraintLayout6, imageView7, linearLayout4, mythicBorderAnimationView, textView16, constraintLayout7, mythicShimmerView, imageView8, textView17, imageView9, linearLayout5, textView18, textView19);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DeckListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_list_item, viewGroup, false);
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
