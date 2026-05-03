package com.studiolaganne.lengendarylens;

import kotlin.Metadata;

/* JADX INFO: compiled from: DecksListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/DecksListClickListener;", "", "onDeckDelete", "", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "onDeckSelected", "onDeckRestore", "onDeckEdit", "onDeckTemporary", "onDeckFullDelete", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DecksListClickListener {
    void onDeckDelete(MTDeck deck);

    void onDeckEdit(MTDeck deck);

    void onDeckFullDelete(MTDeck deck);

    void onDeckRestore(MTDeck deck);

    void onDeckSelected(MTDeck deck);

    void onDeckTemporary(MTDeck deck);
}
