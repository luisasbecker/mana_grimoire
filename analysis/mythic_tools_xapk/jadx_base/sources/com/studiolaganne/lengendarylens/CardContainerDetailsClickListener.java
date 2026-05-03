package com.studiolaganne.lengendarylens;

import kotlin.Metadata;

/* JADX INFO: compiled from: CardContainerDetailsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardContainerDetailsClickListener;", "", "onCardContainerDetailsClick", "", "container", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "onCardContainerSingleCardClick", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "position", "", "onCardContainerEditClick", "onCardContainerDeleteClick", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CardContainerDetailsClickListener {
    void onCardContainerDeleteClick(MTCardContainer container);

    void onCardContainerDetailsClick(MTCardContainer container);

    void onCardContainerEditClick(MTCardContainer container);

    void onCardContainerSingleCardClick(MTCardContainer container, MTFullCard card, int position);
}
