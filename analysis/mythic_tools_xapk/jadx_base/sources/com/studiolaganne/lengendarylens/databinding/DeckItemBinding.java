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
public final class DeckItemBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout;
    public final ImageView bMana;
    public final ImageView cMana;
    public final TextView deckByLabel;
    public final TextView deckFormat;
    public final LoadingImageViewDeck deckImage;
    public final TextView deckName;
    public final ImageView gMana;
    public final ConstraintLayout innerLayout;
    public final LinearLayout manaLayout;
    public final ImageView mythicPlusIcon;
    public final ImageView noPhotoIcon;
    public final LinearLayout ownerLayout;
    public final TextView pendingText;
    public final ConstraintLayout playgroundInfoLayout;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final ImageView rMana;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final MythicBorderAnimationView smartDeckBorderView;
    public final TextView smartDeckHeader;
    public final ConstraintLayout smartDeckHeaderLayout;
    public final MythicShimmerView smartDeckShimmer;
    public final ImageView uMana;
    public final TextView userName;
    public final ImageView wMana;
    public final TextView winrate;
    public final TextView winrateValue;

    private DeckItemBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, LoadingImageViewDeck loadingImageViewDeck, TextView textView3, ImageView imageView3, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout3, TextView textView4, ConstraintLayout constraintLayout3, CachedImageView cachedImageView, ConstraintLayout constraintLayout4, ImageView imageView6, ConstraintLayout constraintLayout5, MythicBorderAnimationView mythicBorderAnimationView, TextView textView5, ConstraintLayout constraintLayout6, MythicShimmerView mythicShimmerView, ImageView imageView7, TextView textView6, ImageView imageView8, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.accountInfoVerticalLayout = linearLayout;
        this.bMana = imageView;
        this.cMana = imageView2;
        this.deckByLabel = textView;
        this.deckFormat = textView2;
        this.deckImage = loadingImageViewDeck;
        this.deckName = textView3;
        this.gMana = imageView3;
        this.innerLayout = constraintLayout2;
        this.manaLayout = linearLayout2;
        this.mythicPlusIcon = imageView4;
        this.noPhotoIcon = imageView5;
        this.ownerLayout = linearLayout3;
        this.pendingText = textView4;
        this.playgroundInfoLayout = constraintLayout3;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout4;
        this.rMana = imageView6;
        this.rootLayout = constraintLayout5;
        this.smartDeckBorderView = mythicBorderAnimationView;
        this.smartDeckHeader = textView5;
        this.smartDeckHeaderLayout = constraintLayout6;
        this.smartDeckShimmer = mythicShimmerView;
        this.uMana = imageView7;
        this.userName = textView6;
        this.wMana = imageView8;
        this.winrate = textView7;
        this.winrateValue = textView8;
    }

    public static DeckItemBinding bind(View view) {
        int i = R.id.accountInfoVerticalLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.b_mana;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.c_mana;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.deckByLabel;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.deckFormat;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.deckImage;
                            LoadingImageViewDeck loadingImageViewDeck = (LoadingImageViewDeck) ViewBindings.findChildViewById(view, i);
                            if (loadingImageViewDeck != null) {
                                i = R.id.deckName;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.g_mana;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = R.id.innerLayout;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout != null) {
                                            i = R.id.manaLayout;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout2 != null) {
                                                i = R.id.mythic_plus_icon;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView4 != null) {
                                                    i = R.id.no_photo_icon;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView5 != null) {
                                                        i = R.id.ownerLayout;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.pendingText;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.playgroundInfoLayout;
                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout2 != null) {
                                                                    i = R.id.profile_icon;
                                                                    CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (cachedImageView != null) {
                                                                        i = R.id.profileLayout;
                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (constraintLayout3 != null) {
                                                                            i = R.id.r_mana;
                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView6 != null) {
                                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) view;
                                                                                i = R.id.smartDeckBorderView;
                                                                                MythicBorderAnimationView mythicBorderAnimationView = (MythicBorderAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                if (mythicBorderAnimationView != null) {
                                                                                    i = R.id.smartDeckHeader;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.smartDeckHeaderLayout;
                                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (constraintLayout5 != null) {
                                                                                            i = R.id.smartDeckShimmer;
                                                                                            MythicShimmerView mythicShimmerView = (MythicShimmerView) ViewBindings.findChildViewById(view, i);
                                                                                            if (mythicShimmerView != null) {
                                                                                                i = R.id.u_mana;
                                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView7 != null) {
                                                                                                    i = R.id.userName;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.w_mana;
                                                                                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (imageView8 != null) {
                                                                                                            i = R.id.winrate;
                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView7 != null) {
                                                                                                                i = R.id.winrateValue;
                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView8 != null) {
                                                                                                                    return new DeckItemBinding(constraintLayout4, linearLayout, imageView, imageView2, textView, textView2, loadingImageViewDeck, textView3, imageView3, constraintLayout, linearLayout2, imageView4, imageView5, linearLayout3, textView4, constraintLayout2, cachedImageView, constraintLayout3, imageView6, constraintLayout4, mythicBorderAnimationView, textView5, constraintLayout5, mythicShimmerView, imageView7, textView6, imageView8, textView7, textView8);
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

    public static DeckItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_item, viewGroup, false);
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
