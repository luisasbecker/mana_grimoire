package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class MtFullCardViewBinding implements ViewBinding {
    public final TextView addToDeckButton;
    public final TextView alteredTextView;
    public final LoadingImageView cardImage;
    public final ConstraintLayout cardImageContainer;
    public final TextView cardNumberLabel;
    public final ConstraintLayout centerSelectionLayout;
    public final ImageView collectionImage;
    public final LinearLayout collectionLayout;
    public final TextView conditionTextView;
    public final TextView confidenceBadge;
    public final TextView containerLabel;
    public final View cornerView;
    public final TextView deckCountLabel;
    public final TextView deckLabel;
    public final LinearLayout deckLayout;
    public final TextView deckNameLabel;
    public final ImageView dotsMenuButton;
    public final LinearLayout extrasLayout;
    public final CardView flagContainer;
    public final ImageView flagImage;
    public final ImageView foilEffectImage;
    public final Guideline guidelineBottom;
    public final Guideline guidelineBottomArrow1;
    public final Guideline guidelineBottomArrow2;
    public final Guideline guidelineBottomButton1;
    public final Guideline guidelineBottomButton2;
    public final Guideline guidelineBottomCheck;
    public final Guideline guidelineLeftCheck;
    public final Guideline guidelineRightCheck;
    public final Guideline guidelineTop;
    public final Guideline guidelineTopArrow1;
    public final Guideline guidelineTopArrow2;
    public final Guideline guidelineTopButton1;
    public final Guideline guidelineTopButton2;
    public final Guideline guidelineTopCheck;
    public final LinearLayout horizontalLayout;
    public final ImageView isFoilImage;
    public final ConstraintLayout minusQtyLayout;
    public final TextView minusQtyTextIcon;
    public final TextView missprintTextView;
    public final TextView mythicAvailableLabel;
    public final LinearLayout mythicAvailableLayout;
    public final TextView mythicInDeckLabel;
    public final LinearLayout mythicInDeckLayout;
    public final Barrier mythicPillTopBarrier;
    public final TextView newRibbonLabel;
    public final ConstraintLayout plusQtyLayout;
    public final TextView plusQtyTextIcon;
    public final TextView priceLabel;
    public final TextView proxyTextView;
    public final TextView qtyTextView;
    public final LinearLayout recommendationActionsLayout;
    public final LinearLayout recommendationInfoLayout;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView selectedAmountText;
    public final ConstraintLayout selectionControlsLayout;
    public final ImageView setImage;
    public final TextView setLabel;
    public final TextView signedTextView;
    public final TextView similarityLabel;
    public final TextView titleLabel;

    private MtFullCardViewBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, LoadingImageView loadingImageView, ConstraintLayout constraintLayout2, TextView textView3, ConstraintLayout constraintLayout3, ImageView imageView, LinearLayout linearLayout, TextView textView4, TextView textView5, TextView textView6, View view, TextView textView7, TextView textView8, LinearLayout linearLayout2, TextView textView9, ImageView imageView2, LinearLayout linearLayout3, CardView cardView, ImageView imageView3, ImageView imageView4, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, Guideline guideline10, Guideline guideline11, Guideline guideline12, Guideline guideline13, Guideline guideline14, LinearLayout linearLayout4, ImageView imageView5, ConstraintLayout constraintLayout4, TextView textView10, TextView textView11, TextView textView12, LinearLayout linearLayout5, TextView textView13, LinearLayout linearLayout6, Barrier barrier, TextView textView14, ConstraintLayout constraintLayout5, TextView textView15, TextView textView16, TextView textView17, TextView textView18, LinearLayout linearLayout7, LinearLayout linearLayout8, ConstraintLayout constraintLayout6, TextView textView19, ConstraintLayout constraintLayout7, ImageView imageView6, TextView textView20, TextView textView21, TextView textView22, TextView textView23) {
        this.rootView = constraintLayout;
        this.addToDeckButton = textView;
        this.alteredTextView = textView2;
        this.cardImage = loadingImageView;
        this.cardImageContainer = constraintLayout2;
        this.cardNumberLabel = textView3;
        this.centerSelectionLayout = constraintLayout3;
        this.collectionImage = imageView;
        this.collectionLayout = linearLayout;
        this.conditionTextView = textView4;
        this.confidenceBadge = textView5;
        this.containerLabel = textView6;
        this.cornerView = view;
        this.deckCountLabel = textView7;
        this.deckLabel = textView8;
        this.deckLayout = linearLayout2;
        this.deckNameLabel = textView9;
        this.dotsMenuButton = imageView2;
        this.extrasLayout = linearLayout3;
        this.flagContainer = cardView;
        this.flagImage = imageView3;
        this.foilEffectImage = imageView4;
        this.guidelineBottom = guideline;
        this.guidelineBottomArrow1 = guideline2;
        this.guidelineBottomArrow2 = guideline3;
        this.guidelineBottomButton1 = guideline4;
        this.guidelineBottomButton2 = guideline5;
        this.guidelineBottomCheck = guideline6;
        this.guidelineLeftCheck = guideline7;
        this.guidelineRightCheck = guideline8;
        this.guidelineTop = guideline9;
        this.guidelineTopArrow1 = guideline10;
        this.guidelineTopArrow2 = guideline11;
        this.guidelineTopButton1 = guideline12;
        this.guidelineTopButton2 = guideline13;
        this.guidelineTopCheck = guideline14;
        this.horizontalLayout = linearLayout4;
        this.isFoilImage = imageView5;
        this.minusQtyLayout = constraintLayout4;
        this.minusQtyTextIcon = textView10;
        this.missprintTextView = textView11;
        this.mythicAvailableLabel = textView12;
        this.mythicAvailableLayout = linearLayout5;
        this.mythicInDeckLabel = textView13;
        this.mythicInDeckLayout = linearLayout6;
        this.mythicPillTopBarrier = barrier;
        this.newRibbonLabel = textView14;
        this.plusQtyLayout = constraintLayout5;
        this.plusQtyTextIcon = textView15;
        this.priceLabel = textView16;
        this.proxyTextView = textView17;
        this.qtyTextView = textView18;
        this.recommendationActionsLayout = linearLayout7;
        this.recommendationInfoLayout = linearLayout8;
        this.rootLayout = constraintLayout6;
        this.selectedAmountText = textView19;
        this.selectionControlsLayout = constraintLayout7;
        this.setImage = imageView6;
        this.setLabel = textView20;
        this.signedTextView = textView21;
        this.similarityLabel = textView22;
        this.titleLabel = textView23;
    }

    public static MtFullCardViewBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.addToDeckButton;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.alteredTextView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.cardImage;
                LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
                if (loadingImageView != null) {
                    i = R.id.cardImageContainer;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.cardNumberLabel;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.centerSelectionLayout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = R.id.collectionImage;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R.id.collectionLayout;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        i = R.id.conditionTextView;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.confidenceBadge;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.containerLabel;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.cornerView))) != null) {
                                                    i = R.id.deckCountLabel;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        i = R.id.deckLabel;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null) {
                                                            i = R.id.deckLayout;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.deckNameLabel;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView9 != null) {
                                                                    i = R.id.dotsMenuButton;
                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView2 != null) {
                                                                        i = R.id.extrasLayout;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout3 != null) {
                                                                            i = R.id.flag_container;
                                                                            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                                                                            if (cardView != null) {
                                                                                i = R.id.flag_image;
                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView3 != null) {
                                                                                    i = R.id.foilEffectImage;
                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (imageView4 != null) {
                                                                                        i = R.id.guideline_bottom;
                                                                                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                        if (guideline != null) {
                                                                                            i = R.id.guideline_bottom_arrow1;
                                                                                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                            if (guideline2 != null) {
                                                                                                i = R.id.guideline_bottom_arrow2;
                                                                                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                if (guideline3 != null) {
                                                                                                    i = R.id.guideline_bottom_button1;
                                                                                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                    if (guideline4 != null) {
                                                                                                        i = R.id.guideline_bottom_button2;
                                                                                                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                        if (guideline5 != null) {
                                                                                                            i = R.id.guideline_bottom_check;
                                                                                                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                            if (guideline6 != null) {
                                                                                                                i = R.id.guideline_left_check;
                                                                                                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                if (guideline7 != null) {
                                                                                                                    i = R.id.guideline_right_check;
                                                                                                                    Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (guideline8 != null) {
                                                                                                                        i = R.id.guideline_top;
                                                                                                                        Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (guideline9 != null) {
                                                                                                                            i = R.id.guideline_top_arrow1;
                                                                                                                            Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (guideline10 != null) {
                                                                                                                                i = R.id.guideline_top_arrow2;
                                                                                                                                Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (guideline11 != null) {
                                                                                                                                    i = R.id.guideline_top_button1;
                                                                                                                                    Guideline guideline12 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (guideline12 != null) {
                                                                                                                                        i = R.id.guideline_top_button2;
                                                                                                                                        Guideline guideline13 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (guideline13 != null) {
                                                                                                                                            i = R.id.guideline_top_check;
                                                                                                                                            Guideline guideline14 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (guideline14 != null) {
                                                                                                                                                i = R.id.horizontalLayout;
                                                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (linearLayout4 != null) {
                                                                                                                                                    i = R.id.is_foil_image;
                                                                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (imageView5 != null) {
                                                                                                                                                        i = R.id.minusQtyLayout;
                                                                                                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (constraintLayout3 != null) {
                                                                                                                                                            i = R.id.minusQtyTextIcon;
                                                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (textView10 != null) {
                                                                                                                                                                i = R.id.missprintTextView;
                                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                    i = R.id.mythicAvailableLabel;
                                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                        i = R.id.mythicAvailableLayout;
                                                                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (linearLayout5 != null) {
                                                                                                                                                                            i = R.id.mythicInDeckLabel;
                                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                i = R.id.mythicInDeckLayout;
                                                                                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (linearLayout6 != null) {
                                                                                                                                                                                    i = R.id.mythicPillTopBarrier;
                                                                                                                                                                                    Barrier barrier = (Barrier) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (barrier != null) {
                                                                                                                                                                                        i = R.id.newRibbonLabel;
                                                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                                                            i = R.id.plusQtyLayout;
                                                                                                                                                                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (constraintLayout4 != null) {
                                                                                                                                                                                                i = R.id.plusQtyTextIcon;
                                                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                                    i = R.id.priceLabel;
                                                                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                                                                        i = R.id.proxyTextView;
                                                                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                                                                            i = R.id.qtyTextView;
                                                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                                                i = R.id.recommendationActionsLayout;
                                                                                                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (linearLayout7 != null) {
                                                                                                                                                                                                                    i = R.id.recommendationInfoLayout;
                                                                                                                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (linearLayout8 != null) {
                                                                                                                                                                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) view;
                                                                                                                                                                                                                        i = R.id.selectedAmountText;
                                                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                                            i = R.id.selectionControlsLayout;
                                                                                                                                                                                                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                            if (constraintLayout6 != null) {
                                                                                                                                                                                                                                i = R.id.setImage;
                                                                                                                                                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                if (imageView6 != null) {
                                                                                                                                                                                                                                    i = R.id.setLabel;
                                                                                                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                                                                                                        i = R.id.signedTextView;
                                                                                                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                                                                                                            i = R.id.similarityLabel;
                                                                                                                                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                            if (textView22 != null) {
                                                                                                                                                                                                                                                i = R.id.titleLabel;
                                                                                                                                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                                                                                                    return new MtFullCardViewBinding(constraintLayout5, textView, textView2, loadingImageView, constraintLayout, textView3, constraintLayout2, imageView, linearLayout, textView4, textView5, textView6, viewFindChildViewById, textView7, textView8, linearLayout2, textView9, imageView2, linearLayout3, cardView, imageView3, imageView4, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10, guideline11, guideline12, guideline13, guideline14, linearLayout4, imageView5, constraintLayout3, textView10, textView11, textView12, linearLayout5, textView13, linearLayout6, barrier, textView14, constraintLayout4, textView15, textView16, textView17, textView18, linearLayout7, linearLayout8, constraintLayout5, textView19, constraintLayout6, imageView6, textView20, textView21, textView22, textView23);
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

    public static MtFullCardViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MtFullCardViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.mt_full_card_view, viewGroup, false);
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
