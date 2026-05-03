package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StreamingDataClasses.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003Ja\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameStreamingData;", "", "status", "", "format", "set", "Lcom/studiolaganne/lengendarylens/StreamingGameSet;", "timer", "", "turn", "turnTimer", "activePlayer", "players", "", "Lcom/studiolaganne/lengendarylens/PlayerStreamingData;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/StreamingGameSet;IIIILjava/util/List;)V", "getStatus", "()Ljava/lang/String;", "getFormat", "getSet", "()Lcom/studiolaganne/lengendarylens/StreamingGameSet;", "getTimer", "()I", "getTurn", "getTurnTimer", "getActivePlayer", "getPlayers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GameStreamingData {
    public static final int $stable = 8;

    @SerializedName("activePlayer")
    private final int activePlayer;

    @SerializedName("format")
    private final String format;

    @SerializedName("players")
    private final List<PlayerStreamingData> players;

    @SerializedName("set")
    private final StreamingGameSet set;

    @SerializedName("status")
    private final String status;

    @SerializedName("timer")
    private final int timer;

    @SerializedName("turn")
    private final int turn;

    @SerializedName("turn_timer")
    private final int turnTimer;

    public GameStreamingData(String status, String format, StreamingGameSet streamingGameSet, int i, int i2, int i3, int i4, List<PlayerStreamingData> players) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(players, "players");
        this.status = status;
        this.format = format;
        this.set = streamingGameSet;
        this.timer = i;
        this.turn = i2;
        this.turnTimer = i3;
        this.activePlayer = i4;
        this.players = players;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameStreamingData copy$default(GameStreamingData gameStreamingData, String str, String str2, StreamingGameSet streamingGameSet, int i, int i2, int i3, int i4, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = gameStreamingData.status;
        }
        if ((i5 & 2) != 0) {
            str2 = gameStreamingData.format;
        }
        if ((i5 & 4) != 0) {
            streamingGameSet = gameStreamingData.set;
        }
        if ((i5 & 8) != 0) {
            i = gameStreamingData.timer;
        }
        if ((i5 & 16) != 0) {
            i2 = gameStreamingData.turn;
        }
        if ((i5 & 32) != 0) {
            i3 = gameStreamingData.turnTimer;
        }
        if ((i5 & 64) != 0) {
            i4 = gameStreamingData.activePlayer;
        }
        if ((i5 & 128) != 0) {
            list = gameStreamingData.players;
        }
        int i6 = i4;
        List list2 = list;
        int i7 = i2;
        int i8 = i3;
        return gameStreamingData.copy(str, str2, streamingGameSet, i, i7, i8, i6, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StreamingGameSet getSet() {
        return this.set;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTimer() {
        return this.timer;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTurn() {
        return this.turn;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getTurnTimer() {
        return this.turnTimer;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getActivePlayer() {
        return this.activePlayer;
    }

    public final List<PlayerStreamingData> component8() {
        return this.players;
    }

    public final GameStreamingData copy(String status, String format, StreamingGameSet set, int timer, int turn, int turnTimer, int activePlayer, List<PlayerStreamingData> players) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(players, "players");
        return new GameStreamingData(status, format, set, timer, turn, turnTimer, activePlayer, players);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameStreamingData)) {
            return false;
        }
        GameStreamingData gameStreamingData = (GameStreamingData) other;
        return Intrinsics.areEqual(this.status, gameStreamingData.status) && Intrinsics.areEqual(this.format, gameStreamingData.format) && Intrinsics.areEqual(this.set, gameStreamingData.set) && this.timer == gameStreamingData.timer && this.turn == gameStreamingData.turn && this.turnTimer == gameStreamingData.turnTimer && this.activePlayer == gameStreamingData.activePlayer && Intrinsics.areEqual(this.players, gameStreamingData.players);
    }

    public final int getActivePlayer() {
        return this.activePlayer;
    }

    public final String getFormat() {
        return this.format;
    }

    public final List<PlayerStreamingData> getPlayers() {
        return this.players;
    }

    public final StreamingGameSet getSet() {
        return this.set;
    }

    public final String getStatus() {
        return this.status;
    }

    public final int getTimer() {
        return this.timer;
    }

    public final int getTurn() {
        return this.turn;
    }

    public final int getTurnTimer() {
        return this.turnTimer;
    }

    public int hashCode() {
        int iHashCode = ((this.status.hashCode() * 31) + this.format.hashCode()) * 31;
        StreamingGameSet streamingGameSet = this.set;
        return ((((((((((iHashCode + (streamingGameSet == null ? 0 : streamingGameSet.hashCode())) * 31) + Integer.hashCode(this.timer)) * 31) + Integer.hashCode(this.turn)) * 31) + Integer.hashCode(this.turnTimer)) * 31) + Integer.hashCode(this.activePlayer)) * 31) + this.players.hashCode();
    }

    public String toString() {
        return "GameStreamingData(status=" + this.status + ", format=" + this.format + ", set=" + this.set + ", timer=" + this.timer + ", turn=" + this.turn + ", turnTimer=" + this.turnTimer + ", activePlayer=" + this.activePlayer + ", players=" + this.players + ")";
    }
}
