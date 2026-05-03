package com.studiolaganne.lengendarylens;

import kotlin.Metadata;

/* JADX INFO: compiled from: GameCallback.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameCallback;", "", "menuPressed", "", "tutorialComplete", "gameFinished", "nonSyncableGameFinished", "gameForceUpload", "startGamePressed", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface GameCallback {
    void gameFinished();

    void gameForceUpload();

    void menuPressed();

    void nonSyncableGameFinished();

    void startGamePressed();

    void tutorialComplete();
}
