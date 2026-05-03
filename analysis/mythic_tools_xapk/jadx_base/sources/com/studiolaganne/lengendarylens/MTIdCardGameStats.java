package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012JJ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardGameStats;", "", "games", "", "wins", "draws", "losses", "winRate", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)V", "getGames", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWins", "getDraws", "getLosses", "getWinRate", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTIdCardGameStats;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardGameStats {
    public static final int $stable = 0;
    private final Integer draws;
    private final Integer games;
    private final Integer losses;
    private final Double winRate;
    private final Integer wins;

    public MTIdCardGameStats() {
        this(null, null, null, null, null, 31, null);
    }

    public MTIdCardGameStats(Integer num, Integer num2, Integer num3, Integer num4, Double d) {
        this.games = num;
        this.wins = num2;
        this.draws = num3;
        this.losses = num4;
        this.winRate = d;
    }

    public /* synthetic */ MTIdCardGameStats(Integer num, Integer num2, Integer num3, Integer num4, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : d);
    }

    public static /* synthetic */ MTIdCardGameStats copy$default(MTIdCardGameStats mTIdCardGameStats, Integer num, Integer num2, Integer num3, Integer num4, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardGameStats.games;
        }
        if ((i & 2) != 0) {
            num2 = mTIdCardGameStats.wins;
        }
        if ((i & 4) != 0) {
            num3 = mTIdCardGameStats.draws;
        }
        if ((i & 8) != 0) {
            num4 = mTIdCardGameStats.losses;
        }
        if ((i & 16) != 0) {
            d = mTIdCardGameStats.winRate;
        }
        Double d2 = d;
        Integer num5 = num3;
        return mTIdCardGameStats.copy(num, num2, num5, num4, d2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getGames() {
        return this.games;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getWins() {
        return this.wins;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getDraws() {
        return this.draws;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getLosses() {
        return this.losses;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getWinRate() {
        return this.winRate;
    }

    public final MTIdCardGameStats copy(Integer games, Integer wins, Integer draws, Integer losses, Double winRate) {
        return new MTIdCardGameStats(games, wins, draws, losses, winRate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardGameStats)) {
            return false;
        }
        MTIdCardGameStats mTIdCardGameStats = (MTIdCardGameStats) other;
        return Intrinsics.areEqual(this.games, mTIdCardGameStats.games) && Intrinsics.areEqual(this.wins, mTIdCardGameStats.wins) && Intrinsics.areEqual(this.draws, mTIdCardGameStats.draws) && Intrinsics.areEqual(this.losses, mTIdCardGameStats.losses) && Intrinsics.areEqual((Object) this.winRate, (Object) mTIdCardGameStats.winRate);
    }

    public final Integer getDraws() {
        return this.draws;
    }

    public final Integer getGames() {
        return this.games;
    }

    public final Integer getLosses() {
        return this.losses;
    }

    public final Double getWinRate() {
        return this.winRate;
    }

    public final Integer getWins() {
        return this.wins;
    }

    public int hashCode() {
        Integer num = this.games;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.wins;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.draws;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.losses;
        int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Double d = this.winRate;
        return iHashCode4 + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardGameStats(games=" + this.games + ", wins=" + this.wins + ", draws=" + this.draws + ", losses=" + this.losses + ", winRate=" + this.winRate + ")";
    }
}
