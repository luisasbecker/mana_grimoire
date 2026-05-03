package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTMatchupStats;", "", "oracleid", "", "games", "", "wins", "draws", "losses", "rate", "<init>", "(Ljava/lang/String;IIIILjava/lang/String;)V", "getOracleid", "()Ljava/lang/String;", "getGames", "()I", "getWins", "getDraws", "getLosses", "getRate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTMatchupStats {
    public static final int $stable = 0;
    private final int draws;
    private final int games;
    private final int losses;
    private final String oracleid;
    private final String rate;
    private final int wins;

    public MTMatchupStats() {
        this(null, 0, 0, 0, 0, null, 63, null);
    }

    public MTMatchupStats(String oracleid, int i, int i2, int i3, int i4, String rate) {
        Intrinsics.checkNotNullParameter(oracleid, "oracleid");
        Intrinsics.checkNotNullParameter(rate, "rate");
        this.oracleid = oracleid;
        this.games = i;
        this.wins = i2;
        this.draws = i3;
        this.losses = i4;
        this.rate = rate;
    }

    public /* synthetic */ MTMatchupStats(String str, int i, int i2, int i3, int i4, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? 0 : i, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? 0 : i4, (i5 & 32) != 0 ? "0.0" : str2);
    }

    public static /* synthetic */ MTMatchupStats copy$default(MTMatchupStats mTMatchupStats, String str, int i, int i2, int i3, int i4, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = mTMatchupStats.oracleid;
        }
        if ((i5 & 2) != 0) {
            i = mTMatchupStats.games;
        }
        if ((i5 & 4) != 0) {
            i2 = mTMatchupStats.wins;
        }
        if ((i5 & 8) != 0) {
            i3 = mTMatchupStats.draws;
        }
        if ((i5 & 16) != 0) {
            i4 = mTMatchupStats.losses;
        }
        if ((i5 & 32) != 0) {
            str2 = mTMatchupStats.rate;
        }
        int i6 = i4;
        String str3 = str2;
        return mTMatchupStats.copy(str, i, i2, i3, i6, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOracleid() {
        return this.oracleid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getGames() {
        return this.games;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWins() {
        return this.wins;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDraws() {
        return this.draws;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getLosses() {
        return this.losses;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRate() {
        return this.rate;
    }

    public final MTMatchupStats copy(String oracleid, int games, int wins, int draws, int losses, String rate) {
        Intrinsics.checkNotNullParameter(oracleid, "oracleid");
        Intrinsics.checkNotNullParameter(rate, "rate");
        return new MTMatchupStats(oracleid, games, wins, draws, losses, rate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTMatchupStats)) {
            return false;
        }
        MTMatchupStats mTMatchupStats = (MTMatchupStats) other;
        return Intrinsics.areEqual(this.oracleid, mTMatchupStats.oracleid) && this.games == mTMatchupStats.games && this.wins == mTMatchupStats.wins && this.draws == mTMatchupStats.draws && this.losses == mTMatchupStats.losses && Intrinsics.areEqual(this.rate, mTMatchupStats.rate);
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

    public final String getOracleid() {
        return this.oracleid;
    }

    public final String getRate() {
        return this.rate;
    }

    public final int getWins() {
        return this.wins;
    }

    public int hashCode() {
        return (((((((((this.oracleid.hashCode() * 31) + Integer.hashCode(this.games)) * 31) + Integer.hashCode(this.wins)) * 31) + Integer.hashCode(this.draws)) * 31) + Integer.hashCode(this.losses)) * 31) + this.rate.hashCode();
    }

    public String toString() {
        return "MTMatchupStats(oracleid=" + this.oracleid + ", games=" + this.games + ", wins=" + this.wins + ", draws=" + this.draws + ", losses=" + this.losses + ", rate=" + this.rate + ")";
    }
}
