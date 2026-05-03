package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerResultsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlayerResultItem;", "", "player", "Lcom/studiolaganne/lengendarylens/Player;", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "resultId", "", "<init>", "(Lcom/studiolaganne/lengendarylens/Player;Lcom/studiolaganne/lengendarylens/MTUser;Lcom/studiolaganne/lengendarylens/MTDeck;I)V", "getPlayer", "()Lcom/studiolaganne/lengendarylens/Player;", "getUser", "()Lcom/studiolaganne/lengendarylens/MTUser;", "getDeck", "()Lcom/studiolaganne/lengendarylens/MTDeck;", "getResultId", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PlayerResultItem {
    public static final int $stable = 8;
    private final MTDeck deck;
    private final Player player;
    private final int resultId;
    private final MTUser user;

    public PlayerResultItem(Player player, MTUser mTUser, MTDeck mTDeck, int i) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.player = player;
        this.user = mTUser;
        this.deck = mTDeck;
        this.resultId = i;
    }

    public static /* synthetic */ PlayerResultItem copy$default(PlayerResultItem playerResultItem, Player player, MTUser mTUser, MTDeck mTDeck, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            player = playerResultItem.player;
        }
        if ((i2 & 2) != 0) {
            mTUser = playerResultItem.user;
        }
        if ((i2 & 4) != 0) {
            mTDeck = playerResultItem.deck;
        }
        if ((i2 & 8) != 0) {
            i = playerResultItem.resultId;
        }
        return playerResultItem.copy(player, mTUser, mTDeck, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Player getPlayer() {
        return this.player;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTUser getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTDeck getDeck() {
        return this.deck;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getResultId() {
        return this.resultId;
    }

    public final PlayerResultItem copy(Player player, MTUser user, MTDeck deck, int resultId) {
        Intrinsics.checkNotNullParameter(player, "player");
        return new PlayerResultItem(player, user, deck, resultId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerResultItem)) {
            return false;
        }
        PlayerResultItem playerResultItem = (PlayerResultItem) other;
        return Intrinsics.areEqual(this.player, playerResultItem.player) && Intrinsics.areEqual(this.user, playerResultItem.user) && Intrinsics.areEqual(this.deck, playerResultItem.deck) && this.resultId == playerResultItem.resultId;
    }

    public final MTDeck getDeck() {
        return this.deck;
    }

    public final Player getPlayer() {
        return this.player;
    }

    public final int getResultId() {
        return this.resultId;
    }

    public final MTUser getUser() {
        return this.user;
    }

    public int hashCode() {
        int iHashCode = this.player.hashCode() * 31;
        MTUser mTUser = this.user;
        int iHashCode2 = (iHashCode + (mTUser == null ? 0 : mTUser.hashCode())) * 31;
        MTDeck mTDeck = this.deck;
        return ((iHashCode2 + (mTDeck != null ? mTDeck.hashCode() : 0)) * 31) + Integer.hashCode(this.resultId);
    }

    public String toString() {
        return "PlayerResultItem(player=" + this.player + ", user=" + this.user + ", deck=" + this.deck + ", resultId=" + this.resultId + ")";
    }
}
