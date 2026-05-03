package com.studiolaganne.lengendarylens;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: CreateDeckBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/CreateDeckCallback;", "", "onDeckCreated", "", "decks", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "onDeckEdited", "deck", "onGhostDeckCreated", "onDeckCreatedForUser", "userId", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CreateDeckCallback {
    void onDeckCreated(List<MTDeck> decks);

    void onDeckCreatedForUser(MTDeck deck, int userId);

    void onDeckEdited(MTDeck deck);

    void onGhostDeckCreated(MTDeck deck);
}
