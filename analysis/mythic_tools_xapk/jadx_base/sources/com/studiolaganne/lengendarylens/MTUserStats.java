package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J]\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00062"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUserStats;", "", "games", "", "wins", "losses", "draws", "rate", "", "mostPlayedFormat", "Lcom/studiolaganne/lengendarylens/MTFormatStats;", "bestDeck", "Lcom/studiolaganne/lengendarylens/MTBestDeck;", "averageGameDuration", "", "<init>", "(IIIILjava/lang/String;Lcom/studiolaganne/lengendarylens/MTFormatStats;Lcom/studiolaganne/lengendarylens/MTBestDeck;F)V", "getGames", "()I", "getWins", "getLosses", "getDraws", "getRate", "()Ljava/lang/String;", "getMostPlayedFormat", "()Lcom/studiolaganne/lengendarylens/MTFormatStats;", "setMostPlayedFormat", "(Lcom/studiolaganne/lengendarylens/MTFormatStats;)V", "getBestDeck", "()Lcom/studiolaganne/lengendarylens/MTBestDeck;", "setBestDeck", "(Lcom/studiolaganne/lengendarylens/MTBestDeck;)V", "getAverageGameDuration", "()F", "setAverageGameDuration", "(F)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUserStats {
    public static final int $stable = 8;
    private float averageGameDuration;
    private MTBestDeck bestDeck;
    private final int draws;
    private final int games;
    private final int losses;
    private MTFormatStats mostPlayedFormat;
    private final String rate;
    private final int wins;

    public MTUserStats() {
        this(0, 0, 0, 0, null, null, null, 0.0f, 255, null);
    }

    public MTUserStats(int i, int i2, int i3, int i4, String rate, MTFormatStats mTFormatStats, MTBestDeck mTBestDeck, float f) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        this.games = i;
        this.wins = i2;
        this.losses = i3;
        this.draws = i4;
        this.rate = rate;
        this.mostPlayedFormat = mTFormatStats;
        this.bestDeck = mTBestDeck;
        this.averageGameDuration = f;
    }

    public /* synthetic */ MTUserStats(int i, int i2, int i3, int i4, String str, MTFormatStats mTFormatStats, MTBestDeck mTBestDeck, float f, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? "0.0" : str, (i5 & 32) != 0 ? null : mTFormatStats, (i5 & 64) != 0 ? null : mTBestDeck, (i5 & 128) != 0 ? 0.0f : f);
    }

    public static /* synthetic */ MTUserStats copy$default(MTUserStats mTUserStats, int i, int i2, int i3, int i4, String str, MTFormatStats mTFormatStats, MTBestDeck mTBestDeck, float f, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mTUserStats.games;
        }
        if ((i5 & 2) != 0) {
            i2 = mTUserStats.wins;
        }
        if ((i5 & 4) != 0) {
            i3 = mTUserStats.losses;
        }
        if ((i5 & 8) != 0) {
            i4 = mTUserStats.draws;
        }
        if ((i5 & 16) != 0) {
            str = mTUserStats.rate;
        }
        if ((i5 & 32) != 0) {
            mTFormatStats = mTUserStats.mostPlayedFormat;
        }
        if ((i5 & 64) != 0) {
            mTBestDeck = mTUserStats.bestDeck;
        }
        if ((i5 & 128) != 0) {
            f = mTUserStats.averageGameDuration;
        }
        MTBestDeck mTBestDeck2 = mTBestDeck;
        float f2 = f;
        String str2 = str;
        MTFormatStats mTFormatStats2 = mTFormatStats;
        return mTUserStats.copy(i, i2, i3, i4, str2, mTFormatStats2, mTBestDeck2, f2);
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
    public final int getLosses() {
        return this.losses;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDraws() {
        return this.draws;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRate() {
        return this.rate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTFormatStats getMostPlayedFormat() {
        return this.mostPlayedFormat;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MTBestDeck getBestDeck() {
        return this.bestDeck;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final float getAverageGameDuration() {
        return this.averageGameDuration;
    }

    public final MTUserStats copy(int games, int wins, int losses, int draws, String rate, MTFormatStats mostPlayedFormat, MTBestDeck bestDeck, float averageGameDuration) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        return new MTUserStats(games, wins, losses, draws, rate, mostPlayedFormat, bestDeck, averageGameDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTUserStats)) {
            return false;
        }
        MTUserStats mTUserStats = (MTUserStats) other;
        return this.games == mTUserStats.games && this.wins == mTUserStats.wins && this.losses == mTUserStats.losses && this.draws == mTUserStats.draws && Intrinsics.areEqual(this.rate, mTUserStats.rate) && Intrinsics.areEqual(this.mostPlayedFormat, mTUserStats.mostPlayedFormat) && Intrinsics.areEqual(this.bestDeck, mTUserStats.bestDeck) && Float.compare(this.averageGameDuration, mTUserStats.averageGameDuration) == 0;
    }

    public final float getAverageGameDuration() {
        return this.averageGameDuration;
    }

    public final MTBestDeck getBestDeck() {
        return this.bestDeck;
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

    public final MTFormatStats getMostPlayedFormat() {
        return this.mostPlayedFormat;
    }

    public final String getRate() {
        return this.rate;
    }

    public final int getWins() {
        return this.wins;
    }

    public int hashCode() {
        int iHashCode = ((((((((Integer.hashCode(this.games) * 31) + Integer.hashCode(this.wins)) * 31) + Integer.hashCode(this.losses)) * 31) + Integer.hashCode(this.draws)) * 31) + this.rate.hashCode()) * 31;
        MTFormatStats mTFormatStats = this.mostPlayedFormat;
        int iHashCode2 = (iHashCode + (mTFormatStats == null ? 0 : mTFormatStats.hashCode())) * 31;
        MTBestDeck mTBestDeck = this.bestDeck;
        return ((iHashCode2 + (mTBestDeck != null ? mTBestDeck.hashCode() : 0)) * 31) + Float.hashCode(this.averageGameDuration);
    }

    public final void setAverageGameDuration(float f) {
        this.averageGameDuration = f;
    }

    public final void setBestDeck(MTBestDeck mTBestDeck) {
        this.bestDeck = mTBestDeck;
    }

    public final void setMostPlayedFormat(MTFormatStats mTFormatStats) {
        this.mostPlayedFormat = mTFormatStats;
    }

    public String toString() {
        return "MTUserStats(games=" + this.games + ", wins=" + this.wins + ", losses=" + this.losses + ", draws=" + this.draws + ", rate=" + this.rate + ", mostPlayedFormat=" + this.mostPlayedFormat + ", bestDeck=" + this.bestDeck + ", averageGameDuration=" + this.averageGameDuration + ")";
    }
}
