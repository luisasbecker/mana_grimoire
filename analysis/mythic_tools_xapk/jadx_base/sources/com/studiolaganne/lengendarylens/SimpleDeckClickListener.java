package com.studiolaganne.lengendarylens;

import kotlin.Metadata;

/* JADX INFO: compiled from: SimpleDecksAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/SimpleDeckClickListener;", "", "onDeckSelected", "", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "onBackFromDecksSelected", "onRefreshDecksSelected", "onCreateDeckSelected", "onSharedDecksSelected", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SimpleDeckClickListener {
    void onBackFromDecksSelected();

    void onCreateDeckSelected();

    void onDeckSelected(MTDeck deck);

    void onRefreshDecksSelected();

    void onSharedDecksSelected();
}
