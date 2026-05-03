package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003JM\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSharedStats;", "", "games", "", "wins", "draws", "losses", "rate", "", "players", "", "Lcom/studiolaganne/lengendarylens/MTSharedPlayer;", "<init>", "(IIIILjava/lang/String;Ljava/util/List;)V", "getGames", "()I", "getWins", "getDraws", "getLosses", "getRate", "()Ljava/lang/String;", "getPlayers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSharedStats {
    public static final int $stable = 8;
    private final int draws;
    private final int games;
    private final int losses;
    private final List<MTSharedPlayer> players;
    private final String rate;
    private final int wins;

    public MTSharedStats() {
        this(0, 0, 0, 0, null, null, 63, null);
    }

    public MTSharedStats(int i, int i2, int i3, int i4, String rate, List<MTSharedPlayer> list) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        this.games = i;
        this.wins = i2;
        this.draws = i3;
        this.losses = i4;
        this.rate = rate;
        this.players = list;
    }

    public /* synthetic */ MTSharedStats(int i, int i2, int i3, int i4, String str, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? "0.0" : str, (i5 & 32) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTSharedStats copy$default(MTSharedStats mTSharedStats, int i, int i2, int i3, int i4, String str, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mTSharedStats.games;
        }
        if ((i5 & 2) != 0) {
            i2 = mTSharedStats.wins;
        }
        if ((i5 & 4) != 0) {
            i3 = mTSharedStats.draws;
        }
        if ((i5 & 8) != 0) {
            i4 = mTSharedStats.losses;
        }
        if ((i5 & 16) != 0) {
            str = mTSharedStats.rate;
        }
        if ((i5 & 32) != 0) {
            list = mTSharedStats.players;
        }
        String str2 = str;
        List list2 = list;
        return mTSharedStats.copy(i, i2, i3, i4, str2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getGames() {
        return this.games;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWins() {
        return this.wins;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDraws() {
        return this.draws;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getLosses() {
        return this.losses;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRate() {
        return this.rate;
    }

    public final List<MTSharedPlayer> component6() {
        return this.players;
    }

    public final MTSharedStats copy(int games, int wins, int draws, int losses, String rate, List<MTSharedPlayer> players) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        return new MTSharedStats(games, wins, draws, losses, rate, players);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSharedStats)) {
            return false;
        }
        MTSharedStats mTSharedStats = (MTSharedStats) other;
        return this.games == mTSharedStats.games && this.wins == mTSharedStats.wins && this.draws == mTSharedStats.draws && this.losses == mTSharedStats.losses && Intrinsics.areEqual(this.rate, mTSharedStats.rate) && Intrinsics.areEqual(this.players, mTSharedStats.players);
    }

    public final int getDraws() {
        return this.draws;
    }

    public final int getGames() {
        return this.games;
    }

    public final int getLosses() {
        return this.losses;
    }

    public final List<MTSharedPlayer> getPlayers() {
        return this.players;
    }

    public final String getRate() {
        return this.rate;
    }

    public final int getWins() {
        return this.wins;
    }

    public int hashCode() {
        int iHashCode = ((((((((Integer.hashCode(this.games) * 31) + Integer.hashCode(this.wins)) * 31) + Integer.hashCode(this.draws)) * 31) + Integer.hashCode(this.losses)) * 31) + this.rate.hashCode()) * 31;
        List<MTSharedPlayer> list = this.players;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "MTSharedStats(games=" + this.games + ", wins=" + this.wins + ", draws=" + this.draws + ", losses=" + this.losses + ", rate=" + this.rate + ", players=" + this.players + ")";
    }
}
