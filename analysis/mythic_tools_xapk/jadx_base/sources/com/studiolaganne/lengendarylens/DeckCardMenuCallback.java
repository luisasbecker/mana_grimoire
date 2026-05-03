package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeckCardMenuCallback.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH\u0016¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckCardMenuCallback;", "", "onDeckCardOpen", "", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "listId", "", "groupType", "", "onDeckCardMove", "onDeckCardEdit", "onDeckCardDelete", "onDeckCardCollectionStatus", "onDeckCardSetCompanion", "setAsCompanion", "", "onDeckCardCommanderColorClick", "onDeckCardSelect", "onDeckCardEvaluate", "onDeckCardFindSimilar", "mode", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DeckCardMenuCallback {

    /* JADX INFO: compiled from: DeckCardMenuCallback.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onDeckCardFindSimilar(DeckCardMenuCallback deckCardMenuCallback, MTFullCard card, String mode) {
            Intrinsics.checkNotNullParameter(card, "card");
            Intrinsics.checkNotNullParameter(mode, "mode");
            DeckCardMenuCallback.super.onDeckCardFindSimilar(card, mode);
        }
    }

    static /* synthetic */ void onDeckCardOpen$default(DeckCardMenuCallback deckCardMenuCallback, MTFullCard mTFullCard, int i, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDeckCardOpen");
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        deckCardMenuCallback.onDeckCardOpen(mTFullCard, i, str);
    }

    void onDeckCardCollectionStatus(MTFullCard card, int listId);

    void onDeckCardCommanderColorClick(MTFullCard card, int listId);

    void onDeckCardDelete(MTFullCard card, int listId);

    void onDeckCardEdit(MTFullCard card, int listId);

    void onDeckCardEvaluate(MTFullCard card, int listId);

    default void onDeckCardFindSimilar(MTFullCard card, String mode) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(mode, "mode");
    }

    void onDeckCardMove(MTFullCard card, int listId);

    void onDeckCardOpen(MTFullCard card, int listId, String groupType);

    void onDeckCardSelect(MTFullCard card, int listId);

    void onDeckCardSetCompanion(MTFullCard card, int listId, boolean setAsCompanion);
}
