package com.studiolaganne.lengendarylens;

import kotlin.Metadata;

/* JADX INFO: compiled from: MTEvaluationCardViewHolder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/OnEvaluationCardActionListener;", "", "onRemoveFromDeck", "", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "onMoveCard", "listType", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OnEvaluationCardActionListener {
    void onMoveCard(MTFullCard card, String listType);

    void onRemoveFromDeck(MTFullCard card);
}
