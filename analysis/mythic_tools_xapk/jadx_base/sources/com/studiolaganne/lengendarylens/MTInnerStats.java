package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTInnerStats;", "", "games", "", "wins", "draws", "losses", "rate", "", "<init>", "(IIIILjava/lang/String;)V", "getGames", "()I", "getWins", "getDraws", "getLosses", "getRate", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTInnerStats {
    public static final int $stable = 0;
    private final int draws;
    private final int games;
    private final int losses;
    private final String rate;
    private final int wins;

    public MTInnerStats() {
        this(0, 0, 0, 0, null, 31, null);
    }

    public MTInnerStats(int i, int i2, int i3, int i4, String rate) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        this.games = i;
        this.wins = i2;
        this.draws = i3;
        this.losses = i4;
        this.rate = rate;
    }

    public /* synthetic */ MTInnerStats(int i, int i2, int i3, int i4, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? "0.0" : str);
    }

    public static /* synthetic */ MTInnerStats copy$default(MTInnerStats mTInnerStats, int i, int i2, int i3, int i4, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mTInnerStats.games;
        }
        if ((i5 & 2) != 0) {
            i2 = mTInnerStats.wins;
        }
        if ((i5 & 4) != 0) {
            i3 = mTInnerStats.draws;
        }
        if ((i5 & 8) != 0) {
            i4 = mTInnerStats.losses;
        }
        if ((i5 & 16) != 0) {
            str = mTInnerStats.rate;
        }
        String str2 = str;
        int i6 = i3;
        return mTInnerStats.copy(i, i2, i6, i4, str2);
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

    public final MTInnerStats copy(int games, int wins, int draws, int losses, String rate) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        return new MTInnerStats(games, wins, draws, losses, rate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTInnerStats)) {
            return false;
        }
        MTInnerStats mTInnerStats = (MTInnerStats) other;
        return this.games == mTInnerStats.games && this.wins == mTInnerStats.wins && this.draws == mTInnerStats.draws && this.losses == mTInnerStats.losses && Intrinsics.areEqual(this.rate, mTInnerStats.rate);
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

    public final String getRate() {
        return this.rate;
    }

    public final int getWins() {
        return this.wins;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.games) * 31) + Integer.hashCode(this.wins)) * 31) + Integer.hashCode(this.draws)) * 31) + Integer.hashCode(this.losses)) * 31) + this.rate.hashCode();
    }

    public String toString() {
        return "MTInnerStats(games=" + this.games + ", wins=" + this.wins + ", draws=" + this.draws + ", losses=" + this.losses + ", rate=" + this.rate + ")";
    }
}
