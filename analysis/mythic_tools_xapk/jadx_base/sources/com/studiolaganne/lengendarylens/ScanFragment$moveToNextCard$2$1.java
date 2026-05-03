package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScanFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/studiolaganne/lengendarylens/ScanFragment$moveToNextCard$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScanFragment$moveToNextCard$2$1 extends AnimatorListenerAdapter {
    final /* synthetic */ Map<ConstraintLayout, Pair<Float, Float>> $originalPositions;
    final /* synthetic */ Map<ConstraintLayout, Pair<Float, Float>> $originalScales;
    final /* synthetic */ ConstraintLayout $previousCard;
    final /* synthetic */ ScanFragment this$0;

    ScanFragment$moveToNextCard$2$1(Map<ConstraintLayout, Pair<Float, Float>> map, Map<ConstraintLayout, Pair<Float, Float>> map2, ConstraintLayout constraintLayout, ScanFragment scanFragment) {
        this.$originalPositions = map;
        this.$originalScales = map2;
        this.$previousCard = constraintLayout;
        this.this$0 = scanFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAnimationEnd$lambda$4$0$0(MTFullCard mTFullCard, ScanFragment scanFragment) {
        String lowerCase;
        String lowerCase2;
        String layout = mTFullCard.getLayout();
        String lowerCase3 = null;
        if (layout != null) {
            lowerCase = layout.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        boolean zAreEqual = Intrinsics.areEqual(lowerCase, "split");
        String layout2 = mTFullCard.getLayout();
        if (layout2 != null) {
            lowerCase2 = layout2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        } else {
            lowerCase2 = null;
        }
        boolean zAreEqual2 = Intrinsics.areEqual(lowerCase2, "adventure");
        String layout3 = mTFullCard.getLayout();
        if (layout3 != null) {
            lowerCase3 = layout3.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        }
        boolean zAreEqual3 = Intrinsics.areEqual(lowerCase3, "prepare");
        boolean zIsAftermath = scanFragment.isAftermath();
        if (!zAreEqual || zIsAftermath) {
            if (zAreEqual2 || zAreEqual3) {
                scanFragment.getBinding().flipCardButton.setText("\uf063");
            } else {
                scanFragment.getBinding().flipCardButton.setText("\uf021");
            }
        } else if (scanFragment.currentFace == 0) {
            scanFragment.getBinding().flipCardButton.setText("\uf061");
        } else {
            scanFragment.getBinding().flipCardButton.setText("\uf060");
        }
        scanFragment.getBinding().flipCardButton.setVisibility(0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        MTFullCard mTFullCard;
        Intrinsics.checkNotNullParameter(animation, "animation");
        for (Map.Entry<ConstraintLayout, Pair<Float, Float>> entry : this.$originalPositions.entrySet()) {
            ConstraintLayout key = entry.getKey();
            Pair<Float, Float> value = entry.getValue();
            key.setX(value.getFirst().floatValue());
            key.setY(value.getSecond().floatValue());
        }
        for (Map.Entry<ConstraintLayout, Pair<Float, Float>> entry2 : this.$originalScales.entrySet()) {
            ConstraintLayout key2 = entry2.getKey();
            Pair<Float, Float> value2 = entry2.getValue();
            key2.setScaleX(value2.getFirst().floatValue());
            key2.setScaleY(value2.getSecond().floatValue());
        }
        this.$previousCard.setAlpha(1.0f);
        if (this.this$0.currentMTCard != null) {
            ScanFragment scanFragment = this.this$0;
            LoadingImageView cardPrevious = scanFragment.getBinding().cardPrevious;
            Intrinsics.checkNotNullExpressionValue(cardPrevious, "cardPrevious");
            LoadingImageView loadingImageView = scanFragment.currentFace == 0 ? scanFragment.getBinding().cardFront : scanFragment.getBinding().cardBack;
            Intrinsics.checkNotNull(loadingImageView);
            scanFragment.replaceCardImage(cardPrevious, loadingImageView);
            cardPrevious.setImageColorDimmed(scanFragment.isComboCardMissing(scanFragment.currentMTCard));
        }
        boolean z = true;
        if (this.this$0.hasMTCards && (mTFullCard = this.this$0.nextMTCard) != null) {
            ScanFragment scanFragment2 = this.this$0;
            LoadingImageView cardFront = scanFragment2.getBinding().cardFront;
            Intrinsics.checkNotNullExpressionValue(cardFront, "cardFront");
            LoadingImageView cardBack = scanFragment2.getBinding().cardBack;
            Intrinsics.checkNotNullExpressionValue(cardBack, "cardBack");
            LoadingImageView cardNext = scanFragment2.getBinding().cardNext;
            Intrinsics.checkNotNullExpressionValue(cardNext, "cardNext");
            scanFragment2.replaceCardImage(cardFront, cardNext);
            cardFront.setImageColorDimmed(scanFragment2.isComboCardMissing(mTFullCard));
            cardBack.setImageColorDimmed(scanFragment2.isComboCardMissing(mTFullCard));
            List<MTImageURIs> images = mTFullCard.getImages();
            if (images == null) {
                List<MTImageURIs> en_images = mTFullCard.getEn_images();
                if (en_images != null && en_images.size() > 1) {
                    scanFragment2.loadCardImage(scanFragment2.getBackFaceMTCardImageURL(mTFullCard), cardBack, null);
                }
            } else if (images.size() > 1) {
                scanFragment2.loadCardImage(scanFragment2.getBackFaceMTCardImageURL(mTFullCard), cardBack, null);
            }
        }
        LoadingImageView cardNext2 = this.this$0.getBinding().cardNext;
        Intrinsics.checkNotNullExpressionValue(cardNext2, "cardNext");
        cardNext2.reset();
        this.this$0.currentCardListIndex++;
        ScanFragment scanFragment3 = this.this$0;
        scanFragment3.previousMTCard = scanFragment3.currentMTCard;
        ScanFragment scanFragment4 = this.this$0;
        scanFragment4.currentMTCard = scanFragment4.nextMTCard;
        this.this$0.currentFace = 0;
        final MTFullCard mTFullCard2 = this.this$0.currentMTCard;
        if (mTFullCard2 != null) {
            final ScanFragment scanFragment5 = this.this$0;
            scanFragment5.displayMTCard(mTFullCard2, true, true);
            scanFragment5.fetchRulings();
            scanFragment5.applySplitCardRotationIfNeeded();
            scanFragment5.getBinding().flipCardButton.setVisibility(4);
            List<MTFace> card_faces = mTFullCard2.getCard_faces();
            if (card_faces != null && card_faces.size() >= 2) {
                scanFragment5.getBinding().flipCardButton.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.ScanFragment$moveToNextCard$2$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScanFragment$moveToNextCard$2$1.onAnimationEnd$lambda$4$0$0(mTFullCard2, scanFragment5);
                    }
                }, 50L);
            }
            if (scanFragment5.currentCardListIndex < scanFragment5.currentMTCardList.size() - 1) {
                scanFragment5.fetchNextCard();
                z = false;
            }
        } else {
            z = false;
        }
        this.this$0.updateNextPrevious();
        if (z) {
            this.this$0.animatingCards = false;
        }
    }
}
