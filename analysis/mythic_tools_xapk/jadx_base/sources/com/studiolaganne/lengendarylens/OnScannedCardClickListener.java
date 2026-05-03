package com.studiolaganne.lengendarylens;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: ScannedCardViewHolder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/OnScannedCardClickListener;", "", "onScannedCardClick", "", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", FirebaseAnalytics.Param.INDEX, "", "onScannedCardDeleteClick", "onScannedCardEditClick", "onScannedCardQuantityChanged", "newQuantity", "onScannedCardFinishToggled", "onScannedCardCollectionTapped", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OnScannedCardClickListener {
    void onScannedCardClick(MTFullCard card, int index);

    void onScannedCardCollectionTapped(MTFullCard card, int index);

    void onScannedCardDeleteClick(MTFullCard card, int index);

    void onScannedCardEditClick(MTFullCard card, int index);

    void onScannedCardFinishToggled(MTFullCard card, int index);

    void onScannedCardQuantityChanged(MTFullCard card, int index, int newQuantity);
}
