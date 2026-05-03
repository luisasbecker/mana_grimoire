package com.studiolaganne.lengendarylens;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: GamesAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/GamesClickListener;", "", "onGameClicked", "", "game", "Lcom/studiolaganne/lengendarylens/MTGame;", "onSetClicked", "set", "Lcom/studiolaganne/lengendarylens/MTSet;", "subgames", "", "onDeleteGameClicked", "onLoadMoreGamesClicked", "onGameItemExpanded", "onUnpublishGameClicked", "onPublishGameClicked", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface GamesClickListener {
    void onDeleteGameClicked(MTGame game);

    void onGameClicked(MTGame game);

    void onGameItemExpanded();

    void onLoadMoreGamesClicked();

    void onPublishGameClicked(MTGame game);

    void onSetClicked(MTSet set, List<MTGame> subgames);

    void onUnpublishGameClicked(MTGame game);
}
