package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CollectionStatusView;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckCardImageItemBinding implements ViewBinding {
    public final LoadingImageView cardImage;
    public final ConstraintLayout cardImageContainer;
    public final ConstraintLayout collectionStatusLayout;
    public final CollectionStatusView collectionStatusView;
    public final FrameLayout commanderColorOverlayContainer;
    public final TextView commanderColorOverlayIcon;
    public final ImageView commanderColorOverlayMana;
    public final ImageView cornerView;
    public final ImageView dotsImage;
    public final ImageView errorImage;
    public final ConstraintLayout errorLayout;
    public final ImageView foilEffectImage;
    public final Guideline innerBottomGuideline;
    public final Guideline innerTopGuideline;
    public final Guideline labelGuideline;
    public final ConstraintLayout menuLayout;
    public final Guideline menuXGuideline;
    public final Guideline menuYGuideline;
    public final TextView qtyTextView;
    private final ConstraintLayout rootView;
    public final View selectionBorderView;
    public final Guideline topGuideline;

    private DeckCardImageItemBinding(ConstraintLayout constraintLayout, LoadingImageView loadingImageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, CollectionStatusView collectionStatusView, FrameLayout frameLayout, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout4, ImageView imageView5, Guideline guideline, Guideline guideline2, Guideline guideline3, ConstraintLayout constraintLayout5, Guideline guideline4, Guideline guideline5, TextView textView2, View view, Guideline guideline6) {
        this.rootView = constraintLayout;
        this.cardImage = loadingImageView;
        this.cardImageContainer = constraintLayout2;
        this.collectionStatusLayout = constraintLayout3;
        this.collectionStatusView = collectionStatusView;
        this.commanderColorOverlayContainer = frameLayout;
        this.commanderColorOverlayIcon = textView;
        this.commanderColorOverlayMana = imageView;
        this.cornerView = imageView2;
        this.dotsImage = imageView3;
        this.errorImage = imageView4;
        this.errorLayout = constraintLayout4;
        this.foilEffectImage = imageView5;
        this.innerBottomGuideline = guideline;
        this.innerTopGuideline = guideline2;
        this.labelGuideline = guideline3;
        this.menuLayout = constraintLayout5;
        this.menuXGuideline = guideline4;
        this.menuYGuideline = guideline5;
        this.qtyTextView = textView2;
        this.selectionBorderView = view;
        this.topGuideline = guideline6;
    }

    public static DeckCardImageItemBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.cardImage;
        LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
        if (loadingImageView != null) {
            i = R.id.cardImageContainer;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.collectionStatusLayout;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.collectionStatusView;
                    CollectionStatusView collectionStatusView = (CollectionStatusView) ViewBindings.findChildViewById(view, i);
                    if (collectionStatusView != null) {
                        i = R.id.commanderColorOverlayContainer;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            i = R.id.commanderColorOverlayIcon;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.commanderColorOverlayMana;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R.id.cornerView;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = R.id.dotsImage;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.errorImage;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView4 != null) {
                                                i = R.id.errorLayout;
                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout3 != null) {
                                                    i = R.id.foilEffectImage;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView5 != null) {
                                                        i = R.id.inner_bottom_guideline;
                                                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                                        if (guideline != null) {
                                                            i = R.id.inner_top_guideline;
                                                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                            if (guideline2 != null) {
                                                                i = R.id.label_guideline;
                                                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                if (guideline3 != null) {
                                                                    i = R.id.menuLayout;
                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout4 != null) {
                                                                        i = R.id.menu_x_guideline;
                                                                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                        if (guideline4 != null) {
                                                                            i = R.id.menu_y_guideline;
                                                                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                            if (guideline5 != null) {
                                                                                i = R.id.qtyTextView;
                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.selectionBorderView))) != null) {
                                                                                    i = R.id.top_guideline;
                                                                                    Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                    if (guideline6 != null) {
                                                                                        return new DeckCardImageItemBinding((ConstraintLayout) view, loadingImageView, constraintLayout, constraintLayout2, collectionStatusView, frameLayout, textView, imageView, imageView2, imageView3, imageView4, constraintLayout3, imageView5, guideline, guideline2, guideline3, constraintLayout4, guideline4, guideline5, textView2, viewFindChildViewById, guideline6);
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

    public static DeckCardImageItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckCardImageItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_card_image_item, viewGroup, false);
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
