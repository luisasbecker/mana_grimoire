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
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CardContainerItemBinding implements ViewBinding {
    public final LinearLayout accountInfoVerticalLayout;
    public final TextView boxByLabel;
    public final View colorView;
    public final LoadingImageViewDeck deckImage;
    public final TextView deltaTextView;
    public final ImageView dotsImage;
    public final ConstraintLayout dotsLayout;
    public final LinearLayout iconAndNameLayout;
    public final TextView iconTextView;
    public final ConstraintLayout innerLayout;
    public final ConstraintLayout leftLayout;
    public final TextView nameTextView;
    public final ImageView noPhotoIcon;
    public final TextView numCardsLabel;
    public final LinearLayout ownerLayout;
    public final ConstraintLayout playgroundInfoLayout;
    public final TextView priceTextView;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final TextView userName;

    private CardContainerItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, View view, LoadingImageViewDeck loadingImageViewDeck, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout, LinearLayout linearLayout3, TextView textView3, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView4, ImageView imageView2, TextView textView5, LinearLayout linearLayout4, ConstraintLayout constraintLayout4, TextView textView6, CachedImageView cachedImageView, ConstraintLayout constraintLayout5, LinearLayout linearLayout5, TextView textView7) {
        this.rootView = linearLayout;
        this.accountInfoVerticalLayout = linearLayout2;
        this.boxByLabel = textView;
        this.colorView = view;
        this.deckImage = loadingImageViewDeck;
        this.deltaTextView = textView2;
        this.dotsImage = imageView;
        this.dotsLayout = constraintLayout;
        this.iconAndNameLayout = linearLayout3;
        this.iconTextView = textView3;
        this.innerLayout = constraintLayout2;
        this.leftLayout = constraintLayout3;
        this.nameTextView = textView4;
        this.noPhotoIcon = imageView2;
        this.numCardsLabel = textView5;
        this.ownerLayout = linearLayout4;
        this.playgroundInfoLayout = constraintLayout4;
        this.priceTextView = textView6;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout5;
        this.rootLayout = linearLayout5;
        this.userName = textView7;
    }

    public static CardContainerItemBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.accountInfoVerticalLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.boxByLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.colorView))) != null) {
                i = R.id.deckImage;
                LoadingImageViewDeck loadingImageViewDeck = (LoadingImageViewDeck) ViewBindings.findChildViewById(view, i);
                if (loadingImageViewDeck != null) {
                    i = R.id.deltaTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.dotsImage;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.dotsLayout;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                i = R.id.iconAndNameLayout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = R.id.iconTextView;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.innerLayout;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout2 != null) {
                                            i = R.id.left_layout;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout3 != null) {
                                                i = R.id.nameTextView;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.no_photo_icon;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView2 != null) {
                                                        i = R.id.numCardsLabel;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.ownerLayout;
                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout3 != null) {
                                                                i = R.id.playgroundInfoLayout;
                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout4 != null) {
                                                                    i = R.id.priceTextView;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.profile_icon;
                                                                        CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                        if (cachedImageView != null) {
                                                                            i = R.id.profileLayout;
                                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (constraintLayout5 != null) {
                                                                                LinearLayout linearLayout4 = (LinearLayout) view;
                                                                                i = R.id.userName;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView7 != null) {
                                                                                    return new CardContainerItemBinding(linearLayout4, linearLayout, textView, viewFindChildViewById, loadingImageViewDeck, textView2, imageView, constraintLayout, linearLayout2, textView3, constraintLayout2, constraintLayout3, textView4, imageView2, textView5, linearLayout3, constraintLayout4, textView6, cachedImageView, constraintLayout5, linearLayout4, textView7);
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

    public static CardContainerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CardContainerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.card_container_item, viewGroup, false);
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
