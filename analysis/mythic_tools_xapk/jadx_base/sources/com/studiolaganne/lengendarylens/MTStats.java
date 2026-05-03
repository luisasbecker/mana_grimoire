package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jq\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00062"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTStats;", "", "games", "", "wins", "draws", "losses", "rate", "", "onThePlay", "Lcom/studiolaganne/lengendarylens/MTInnerStats;", "onTheDraw", "matchups", "", "Lcom/studiolaganne/lengendarylens/MTMatchupStats;", "sharedStats", "Lcom/studiolaganne/lengendarylens/MTSharedStats;", "<init>", "(IIIILjava/lang/String;Lcom/studiolaganne/lengendarylens/MTInnerStats;Lcom/studiolaganne/lengendarylens/MTInnerStats;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTSharedStats;)V", "getGames", "()I", "getWins", "getDraws", "getLosses", "getRate", "()Ljava/lang/String;", "getOnThePlay", "()Lcom/studiolaganne/lengendarylens/MTInnerStats;", "getOnTheDraw", "getMatchups", "()Ljava/util/List;", "getSharedStats", "()Lcom/studiolaganne/lengendarylens/MTSharedStats;", "setSharedStats", "(Lcom/studiolaganne/lengendarylens/MTSharedStats;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTStats {
    public static final int $stable = 8;
    private final int draws;
    private final int games;
    private final int losses;
    private final List<MTMatchupStats> matchups;
    private final MTInnerStats onTheDraw;
    private final MTInnerStats onThePlay;
    private final String rate;
    private MTSharedStats sharedStats;
    private final int wins;

    public MTStats() {
        this(0, 0, 0, 0, null, null, null, null, null, 511, null);
    }

    public MTStats(int i, int i2, int i3, int i4, String rate, MTInnerStats mTInnerStats, MTInnerStats mTInnerStats2, List<MTMatchupStats> list, MTSharedStats mTSharedStats) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        this.games = i;
        this.wins = i2;
        this.draws = i3;
        this.losses = i4;
        this.rate = rate;
        this.onThePlay = mTInnerStats;
        this.onTheDraw = mTInnerStats2;
        this.matchups = list;
        this.sharedStats = mTSharedStats;
    }

    public /* synthetic */ MTStats(int i, int i2, int i3, int i4, String str, MTInnerStats mTInnerStats, MTInnerStats mTInnerStats2, List list, MTSharedStats mTSharedStats, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? "0.0" : str, (i5 & 32) != 0 ? null : mTInnerStats, (i5 & 64) != 0 ? null : mTInnerStats2, (i5 & 128) != 0 ? null : list, (i5 & 256) != 0 ? null : mTSharedStats);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTStats copy$default(MTStats mTStats, int i, int i2, int i3, int i4, String str, MTInnerStats mTInnerStats, MTInnerStats mTInnerStats2, List list, MTSharedStats mTSharedStats, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mTStats.games;
        }
        if ((i5 & 2) != 0) {
            i2 = mTStats.wins;
        }
        if ((i5 & 4) != 0) {
            i3 = mTStats.draws;
        }
        if ((i5 & 8) != 0) {
            i4 = mTStats.losses;
        }
        if ((i5 & 16) != 0) {
            str = mTStats.rate;
        }
        if ((i5 & 32) != 0) {
            mTInnerStats = mTStats.onThePlay;
        }
        if ((i5 & 64) != 0) {
            mTInnerStats2 = mTStats.onTheDraw;
        }
        if ((i5 & 128) != 0) {
            list = mTStats.matchups;
        }
        if ((i5 & 256) != 0) {
            mTSharedStats = mTStats.sharedStats;
        }
        List list2 = list;
        MTSharedStats mTSharedStats2 = mTSharedStats;
        MTInnerStats mTInnerStats3 = mTInnerStats;
        MTInnerStats mTInnerStats4 = mTInnerStats2;
        String str2 = str;
        int i6 = i3;
        return mTStats.copy(i, i2, i6, i4, str2, mTInnerStats3, mTInnerStats4, list2, mTSharedStats2);
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

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTInnerStats getOnThePlay() {
        return this.onThePlay;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MTInnerStats getOnTheDraw() {
        return this.onTheDraw;
    }

    public final List<MTMatchupStats> component8() {
        return this.matchups;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final MTSharedStats getSharedStats() {
        return this.sharedStats;
    }

    public final MTStats copy(int games, int wins, int draws, int losses, String rate, MTInnerStats onThePlay, MTInnerStats onTheDraw, List<MTMatchupStats> matchups, MTSharedStats sharedStats) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        return new MTStats(games, wins, draws, losses, rate, onThePlay, onTheDraw, matchups, sharedStats);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTStats)) {
            return false;
        }
        MTStats mTStats = (MTStats) other;
        return this.games == mTStats.games && this.wins == mTStats.wins && this.draws == mTStats.draws && this.losses == mTStats.losses && Intrinsics.areEqual(this.rate, mTStats.rate) && Intrinsics.areEqual(this.onThePlay, mTStats.onThePlay) && Intrinsics.areEqual(this.onTheDraw, mTStats.onTheDraw) && Intrinsics.areEqual(this.matchups, mTStats.matchups) && Intrinsics.areEqual(this.sharedStats, mTStats.sharedStats);
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

    public final List<MTMatchupStats> getMatchups() {
        return this.matchups;
    }

    public final MTInnerStats getOnTheDraw() {
        return this.onTheDraw;
    }

    public final MTInnerStats getOnThePlay() {
        return this.onThePlay;
    }

    public final String getRate() {
        return this.rate;
    }

    public final MTSharedStats getSharedStats() {
        return this.sharedStats;
    }

    public final int getWins() {
        return this.wins;
    }

    public int hashCode() {
        int iHashCode = ((((((((Integer.hashCode(this.games) * 31) + Integer.hashCode(this.wins)) * 31) + Integer.hashCode(this.draws)) * 31) + Integer.hashCode(this.losses)) * 31) + this.rate.hashCode()) * 31;
        MTInnerStats mTInnerStats = this.onThePlay;
        int iHashCode2 = (iHashCode + (mTInnerStats == null ? 0 : mTInnerStats.hashCode())) * 31;
        MTInnerStats mTInnerStats2 = this.onTheDraw;
        int iHashCode3 = (iHashCode2 + (mTInnerStats2 == null ? 0 : mTInnerStats2.hashCode())) * 31;
        List<MTMatchupStats> list = this.matchups;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        MTSharedStats mTSharedStats = this.sharedStats;
        return iHashCode4 + (mTSharedStats != null ? mTSharedStats.hashCode() : 0);
    }

    public final void setSharedStats(MTSharedStats mTSharedStats) {
        this.sharedStats = mTSharedStats;
    }

    public String toString() {
        return "MTStats(games=" + this.games + ", wins=" + this.wins + ", draws=" + this.draws + ", losses=" + this.losses + ", rate=" + this.rate + ", onThePlay=" + this.onThePlay + ", onTheDraw=" + this.onTheDraw + ", matchups=" + this.matchups + ", sharedStats=" + this.sharedStats + ")";
    }
}
