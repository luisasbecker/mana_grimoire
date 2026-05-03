package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.LoadingImageViewDeck;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SwipeMenuViewBinding implements ViewBinding {
    public final ImageView advancedImage;
    public final ImageView advancedImage1;
    public final ImageView advancedImage2;
    public final ImageView advancedImage3;
    public final ImageView advancedImage4;
    public final TextView advancedLabel;
    public final TextView advancedLabel1;
    public final TextView advancedLabel2;
    public final TextView advancedLabel3;
    public final TextView advancedLabel4;
    public final LinearLayout advancedLayout;
    public final LinearLayout advancedLayout1;
    public final LinearLayout advancedLayout2;
    public final LinearLayout advancedLayout3;
    public final LinearLayout advancedLayout4;
    public final ImageView bkgImage;
    public final TextView bkgLabel;
    public final LinearLayout bkgLayout;
    public final ImageView cardBackgroundImage;
    public final CardView cardView;
    public final View centerView;
    public final ImageView countersImage;
    public final TextView countersLabel;
    public final LinearLayout countersLayout;
    public final RecyclerView countersRecyclerView;
    public final TextView deckName;
    public final RecyclerView decksRecyclerView;
    public final TextView editIconTextViewDeck;
    public final TextView editIconTextViewName;
    public final TextView editIconTextViewResult;
    public final TextView firstnameTextView;
    public final ConstraintLayout gamePlayerSummaryInnerLayout;
    public final ConstraintLayout gamePlayerSummaryLayout;
    public final ConstraintLayout gamePlayerSummaryRootLayout;
    public final LinearLayout gpsBottomLayout;
    public final LoadingImageViewDeck gpsDeckImage;
    public final LinearLayout gpsMainLayout;
    public final ConstraintLayout gpsRootLineLayout;
    public final LinearLayout gpsTopLayout;
    public final LinearLayout gpsUserLayout;
    public final LinearLayout leftContainer;
    public final TextView leftLabel;
    public final ConstraintLayout leftLayout;
    public final TextView leftRightHeader;
    public final ConstraintLayout leftRightInnerLayout;
    public final ConstraintLayout leftRightLayout;
    public final LinearLayout leftRightLinearLayout;
    public final LottieAnimationView loadingAnimationView;
    public final ConstraintLayout loadingOverlay;
    public final ImageView noPhotoIcon;
    public final ImageView noPhotoIconSummary;
    public final View overlay;
    public final TextView playerNameLabel;
    public final RecyclerView playerRecyclerView;
    public final RecyclerView playmatRecyclerView;
    public final CachedImageView profileIcon;
    public final CachedImageView profileIconSummary;
    public final ConstraintLayout profileLayout;
    public final ConstraintLayout profileLayoutSummary;
    public final TextView resultTextView;
    public final TextView rightLabel;
    public final ConstraintLayout rightLayout;
    public final RelativeLayout rootLayout;
    private final CardView rootView;
    public final LinearLayout userLayout;
    public final TextView usernameTextView;
    public final ImageView winLoseImage;
    public final TextView winLoseLabel;
    public final LinearLayout winLoseLayout;

    private SwipeMenuViewBinding(CardView cardView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, ImageView imageView6, TextView textView6, LinearLayout linearLayout6, ImageView imageView7, CardView cardView2, View view, ImageView imageView8, TextView textView7, LinearLayout linearLayout7, RecyclerView recyclerView, TextView textView8, RecyclerView recyclerView2, TextView textView9, TextView textView10, TextView textView11, TextView textView12, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout8, LoadingImageViewDeck loadingImageViewDeck, LinearLayout linearLayout9, ConstraintLayout constraintLayout4, LinearLayout linearLayout10, LinearLayout linearLayout11, LinearLayout linearLayout12, TextView textView13, ConstraintLayout constraintLayout5, TextView textView14, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, LinearLayout linearLayout13, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout8, ImageView imageView9, ImageView imageView10, View view2, TextView textView15, RecyclerView recyclerView3, RecyclerView recyclerView4, CachedImageView cachedImageView, CachedImageView cachedImageView2, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10, TextView textView16, TextView textView17, ConstraintLayout constraintLayout11, RelativeLayout relativeLayout, LinearLayout linearLayout14, TextView textView18, ImageView imageView11, TextView textView19, LinearLayout linearLayout15) {
        this.rootView = cardView;
        this.advancedImage = imageView;
        this.advancedImage1 = imageView2;
        this.advancedImage2 = imageView3;
        this.advancedImage3 = imageView4;
        this.advancedImage4 = imageView5;
        this.advancedLabel = textView;
        this.advancedLabel1 = textView2;
        this.advancedLabel2 = textView3;
        this.advancedLabel3 = textView4;
        this.advancedLabel4 = textView5;
        this.advancedLayout = linearLayout;
        this.advancedLayout1 = linearLayout2;
        this.advancedLayout2 = linearLayout3;
        this.advancedLayout3 = linearLayout4;
        this.advancedLayout4 = linearLayout5;
        this.bkgImage = imageView6;
        this.bkgLabel = textView6;
        this.bkgLayout = linearLayout6;
        this.cardBackgroundImage = imageView7;
        this.cardView = cardView2;
        this.centerView = view;
        this.countersImage = imageView8;
        this.countersLabel = textView7;
        this.countersLayout = linearLayout7;
        this.countersRecyclerView = recyclerView;
        this.deckName = textView8;
        this.decksRecyclerView = recyclerView2;
        this.editIconTextViewDeck = textView9;
        this.editIconTextViewName = textView10;
        this.editIconTextViewResult = textView11;
        this.firstnameTextView = textView12;
        this.gamePlayerSummaryInnerLayout = constraintLayout;
        this.gamePlayerSummaryLayout = constraintLayout2;
        this.gamePlayerSummaryRootLayout = constraintLayout3;
        this.gpsBottomLayout = linearLayout8;
        this.gpsDeckImage = loadingImageViewDeck;
        this.gpsMainLayout = linearLayout9;
        this.gpsRootLineLayout = constraintLayout4;
        this.gpsTopLayout = linearLayout10;
        this.gpsUserLayout = linearLayout11;
        this.leftContainer = linearLayout12;
        this.leftLabel = textView13;
        this.leftLayout = constraintLayout5;
        this.leftRightHeader = textView14;
        this.leftRightInnerLayout = constraintLayout6;
        this.leftRightLayout = constraintLayout7;
        this.leftRightLinearLayout = linearLayout13;
        this.loadingAnimationView = lottieAnimationView;
        this.loadingOverlay = constraintLayout8;
        this.noPhotoIcon = imageView9;
        this.noPhotoIconSummary = imageView10;
        this.overlay = view2;
        this.playerNameLabel = textView15;
        this.playerRecyclerView = recyclerView3;
        this.playmatRecyclerView = recyclerView4;
        this.profileIcon = cachedImageView;
        this.profileIconSummary = cachedImageView2;
        this.profileLayout = constraintLayout9;
        this.profileLayoutSummary = constraintLayout10;
        this.resultTextView = textView16;
        this.rightLabel = textView17;
        this.rightLayout = constraintLayout11;
        this.rootLayout = relativeLayout;
        this.userLayout = linearLayout14;
        this.usernameTextView = textView18;
        this.winLoseImage = imageView11;
        this.winLoseLabel = textView19;
        this.winLoseLayout = linearLayout15;
    }

    public static SwipeMenuViewBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.advancedImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.advancedImage1;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.advancedImage2;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.advancedImage3;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.advancedImage4;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView5 != null) {
                            i = R.id.advancedLabel;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.advancedLabel1;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.advancedLabel2;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.advancedLabel3;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.advancedLabel4;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.advancedLayout;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout != null) {
                                                    i = R.id.advancedLayout1;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.advancedLayout2;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.advancedLayout3;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout4 != null) {
                                                                i = R.id.advancedLayout4;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout5 != null) {
                                                                    i = R.id.bkgImage;
                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView6 != null) {
                                                                        i = R.id.bkgLabel;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.bkgLayout;
                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout6 != null) {
                                                                                i = R.id.card_background_image;
                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView7 != null) {
                                                                                    CardView cardView = (CardView) view;
                                                                                    i = R.id.centerView;
                                                                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(view, i);
                                                                                    if (viewFindChildViewById2 != null) {
                                                                                        i = R.id.countersImage;
                                                                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                        if (imageView8 != null) {
                                                                                            i = R.id.countersLabel;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView7 != null) {
                                                                                                i = R.id.countersLayout;
                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (linearLayout7 != null) {
                                                                                                    i = R.id.counters_recycler_view;
                                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (recyclerView != null) {
                                                                                                        i = R.id.deckName;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView8 != null) {
                                                                                                            i = R.id.decks_recycler_view;
                                                                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (recyclerView2 != null) {
                                                                                                                i = R.id.editIconTextViewDeck;
                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView9 != null) {
                                                                                                                    i = R.id.editIconTextViewName;
                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView10 != null) {
                                                                                                                        i = R.id.editIconTextViewResult;
                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView11 != null) {
                                                                                                                            i = R.id.firstnameTextView;
                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView12 != null) {
                                                                                                                                i = R.id.gamePlayerSummaryInnerLayout;
                                                                                                                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (constraintLayout != null) {
                                                                                                                                    i = R.id.gamePlayerSummaryLayout;
                                                                                                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (constraintLayout2 != null) {
                                                                                                                                        i = R.id.gamePlayerSummaryRootLayout;
                                                                                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (constraintLayout3 != null) {
                                                                                                                                            i = R.id.gpsBottomLayout;
                                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                                i = R.id.gpsDeckImage;
                                                                                                                                                LoadingImageViewDeck loadingImageViewDeck = (LoadingImageViewDeck) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (loadingImageViewDeck != null) {
                                                                                                                                                    i = R.id.gpsMainLayout;
                                                                                                                                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (linearLayout9 != null) {
                                                                                                                                                        i = R.id.gpsRootLineLayout;
                                                                                                                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (constraintLayout4 != null) {
                                                                                                                                                            i = R.id.gpsTopLayout;
                                                                                                                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (linearLayout10 != null) {
                                                                                                                                                                i = R.id.gpsUserLayout;
                                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                                    i = R.id.leftContainer;
                                                                                                                                                                    LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (linearLayout12 != null) {
                                                                                                                                                                        i = R.id.leftLabel;
                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                            i = R.id.leftLayout;
                                                                                                                                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (constraintLayout5 != null) {
                                                                                                                                                                                i = R.id.leftRightHeader;
                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                    i = R.id.leftRightInnerLayout;
                                                                                                                                                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (constraintLayout6 != null) {
                                                                                                                                                                                        i = R.id.leftRightLayout;
                                                                                                                                                                                        ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (constraintLayout7 != null) {
                                                                                                                                                                                            i = R.id.leftRightLinearLayout;
                                                                                                                                                                                            LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (linearLayout13 != null) {
                                                                                                                                                                                                i = R.id.loadingAnimationView;
                                                                                                                                                                                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (lottieAnimationView != null) {
                                                                                                                                                                                                    i = R.id.loadingOverlay;
                                                                                                                                                                                                    ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (constraintLayout8 != null) {
                                                                                                                                                                                                        i = R.id.no_photo_icon;
                                                                                                                                                                                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (imageView9 != null) {
                                                                                                                                                                                                            i = R.id.noPhotoIconSummary;
                                                                                                                                                                                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (imageView10 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.overlay))) != null) {
                                                                                                                                                                                                                i = R.id.playerNameLabel;
                                                                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                                                    i = R.id.player_recycler_view;
                                                                                                                                                                                                                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (recyclerView3 != null) {
                                                                                                                                                                                                                        i = R.id.playmat_recycler_view;
                                                                                                                                                                                                                        RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (recyclerView4 != null) {
                                                                                                                                                                                                                            i = R.id.profile_icon;
                                                                                                                                                                                                                            CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                            if (cachedImageView != null) {
                                                                                                                                                                                                                                i = R.id.profileIconSummary;
                                                                                                                                                                                                                                CachedImageView cachedImageView2 = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                if (cachedImageView2 != null) {
                                                                                                                                                                                                                                    i = R.id.profileLayout;
                                                                                                                                                                                                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                    if (constraintLayout9 != null) {
                                                                                                                                                                                                                                        i = R.id.profileLayoutSummary;
                                                                                                                                                                                                                                        ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                        if (constraintLayout10 != null) {
                                                                                                                                                                                                                                            i = R.id.resultTextView;
                                                                                                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                                                                                i = R.id.rightLabel;
                                                                                                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                                                                                                    i = R.id.rightLayout;
                                                                                                                                                                                                                                                    ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                    if (constraintLayout11 != null) {
                                                                                                                                                                                                                                                        i = R.id.rootLayout;
                                                                                                                                                                                                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                        if (relativeLayout != null) {
                                                                                                                                                                                                                                                            i = R.id.userLayout;
                                                                                                                                                                                                                                                            LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                            if (linearLayout14 != null) {
                                                                                                                                                                                                                                                                i = R.id.usernameTextView;
                                                                                                                                                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                if (textView18 != null) {
                                                                                                                                                                                                                                                                    i = R.id.winLoseImage;
                                                                                                                                                                                                                                                                    ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                    if (imageView11 != null) {
                                                                                                                                                                                                                                                                        i = R.id.winLoseLabel;
                                                                                                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                                                                                            i = R.id.winLoseLayout;
                                                                                                                                                                                                                                                                            LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                                                                            if (linearLayout15 != null) {
                                                                                                                                                                                                                                                                                return new SwipeMenuViewBinding(cardView, imageView, imageView2, imageView3, imageView4, imageView5, textView, textView2, textView3, textView4, textView5, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, imageView6, textView6, linearLayout6, imageView7, cardView, viewFindChildViewById2, imageView8, textView7, linearLayout7, recyclerView, textView8, recyclerView2, textView9, textView10, textView11, textView12, constraintLayout, constraintLayout2, constraintLayout3, linearLayout8, loadingImageViewDeck, linearLayout9, constraintLayout4, linearLayout10, linearLayout11, linearLayout12, textView13, constraintLayout5, textView14, constraintLayout6, constraintLayout7, linearLayout13, lottieAnimationView, constraintLayout8, imageView9, imageView10, viewFindChildViewById, textView15, recyclerView3, recyclerView4, cachedImageView, cachedImageView2, constraintLayout9, constraintLayout10, textView16, textView17, constraintLayout11, relativeLayout, linearLayout14, textView18, imageView11, textView19, linearLayout15);
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
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static SwipeMenuViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SwipeMenuViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.swipe_menu_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }
}
