package com.studiolaganne.lengendarylens;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GamePlayersFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR)\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00110\u00180\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/studiolaganne/lengendarylens/SharedViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "lifeTotal", "Landroidx/lifecycle/MutableLiveData;", "", "getLifeTotal", "()Landroidx/lifecycle/MutableLiveData;", "numberOfPlayers", "getNumberOfPlayers", "layoutType", "Lcom/studiolaganne/lengendarylens/LayoutType;", "getLayoutType", "playgroupId", "getPlaygroupId", "playgroupUsers", "", "getPlaygroupUsers", "formatId", "getFormatId", "subFormatId", "getSubFormatId", "decks", "", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "getDecks", "playgroup", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "getPlaygroup", "gameState", "Lcom/studiolaganne/lengendarylens/GameState;", "getGameState", "()Lcom/studiolaganne/lengendarylens/GameState;", "setGameState", "(Lcom/studiolaganne/lengendarylens/GameState;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableLiveData<Integer> lifeTotal = new MutableLiveData<>();
    private final MutableLiveData<Integer> numberOfPlayers = new MutableLiveData<>();
    private final MutableLiveData<LayoutType> layoutType = new MutableLiveData<>();
    private final MutableLiveData<Integer> playgroupId = new MutableLiveData<>();
    private final MutableLiveData<List<Integer>> playgroupUsers = new MutableLiveData<>();
    private final MutableLiveData<Integer> formatId = new MutableLiveData<>();
    private final MutableLiveData<Integer> subFormatId = new MutableLiveData<>();
    private final MutableLiveData<Map<String, List<MTDeck>>> decks = new MutableLiveData<>();
    private final MutableLiveData<MTPlaygroup> playgroup = new MutableLiveData<>();
    private GameState gameState = new GameState(null, 0, 0, null, false, false, null, false, false, false, 0, 0, 0, null, 0, 0, 0, null, null, null, false, false, false, false, false, false, 0, false, 0, 0, false, false, 0, 0, 0, 0, false, false, null, false, null, 0, 0, false, null, 0, null, 0, -1, 65535, null);

    public final MutableLiveData<Map<String, List<MTDeck>>> getDecks() {
        return this.decks;
    }

    public final MutableLiveData<Integer> getFormatId() {
        return this.formatId;
    }

    public final GameState getGameState() {
        return this.gameState;
    }

    public final MutableLiveData<LayoutType> getLayoutType() {
        return this.layoutType;
    }

    public final MutableLiveData<Integer> getLifeTotal() {
        return this.lifeTotal;
    }

    public final MutableLiveData<Integer> getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    public final MutableLiveData<MTPlaygroup> getPlaygroup() {
        return this.playgroup;
    }

    public final MutableLiveData<Integer> getPlaygroupId() {
        return this.playgroupId;
    }

    public final MutableLiveData<List<Integer>> getPlaygroupUsers() {
        return this.playgroupUsers;
    }

    public final MutableLiveData<Integer> getSubFormatId() {
        return this.subFormatId;
    }

    public final void setGameState(GameState gameState) {
        Intrinsics.checkNotNullParameter(gameState, "<set-?>");
        this.gameState = gameState;
    }
}
