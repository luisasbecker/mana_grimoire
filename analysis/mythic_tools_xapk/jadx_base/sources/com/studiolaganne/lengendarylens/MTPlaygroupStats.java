package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTPlaygroupStats;", "", "games", "", "averageGameDuration", "", "mostPlayedFormat", "Lcom/studiolaganne/lengendarylens/MTFormatStats;", "bestWinRateUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "<init>", "(IFLcom/studiolaganne/lengendarylens/MTFormatStats;Lcom/studiolaganne/lengendarylens/MTUser;)V", "getGames", "()I", "getAverageGameDuration", "()F", "setAverageGameDuration", "(F)V", "getMostPlayedFormat", "()Lcom/studiolaganne/lengendarylens/MTFormatStats;", "setMostPlayedFormat", "(Lcom/studiolaganne/lengendarylens/MTFormatStats;)V", "getBestWinRateUser", "()Lcom/studiolaganne/lengendarylens/MTUser;", "setBestWinRateUser", "(Lcom/studiolaganne/lengendarylens/MTUser;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTPlaygroupStats {
    public static final int $stable = 8;
    private float averageGameDuration;
    private MTUser bestWinRateUser;
    private final int games;
    private MTFormatStats mostPlayedFormat;

    public MTPlaygroupStats() {
        this(0, 0.0f, null, null, 15, null);
    }

    public MTPlaygroupStats(int i, float f, MTFormatStats mTFormatStats, MTUser mTUser) {
        this.games = i;
        this.averageGameDuration = f;
        this.mostPlayedFormat = mTFormatStats;
        this.bestWinRateUser = mTUser;
    }

    public /* synthetic */ MTPlaygroupStats(int i, float f, MTFormatStats mTFormatStats, MTUser mTUser, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0f : f, (i2 & 4) != 0 ? null : mTFormatStats, (i2 & 8) != 0 ? null : mTUser);
    }

    public static /* synthetic */ MTPlaygroupStats copy$default(MTPlaygroupStats mTPlaygroupStats, int i, float f, MTFormatStats mTFormatStats, MTUser mTUser, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTPlaygroupStats.games;
        }
        if ((i2 & 2) != 0) {
            f = mTPlaygroupStats.averageGameDuration;
        }
        if ((i2 & 4) != 0) {
            mTFormatStats = mTPlaygroupStats.mostPlayedFormat;
        }
        if ((i2 & 8) != 0) {
            mTUser = mTPlaygroupStats.bestWinRateUser;
        }
        return mTPlaygroupStats.copy(i, f, mTFormatStats, mTUser);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getGames() {
        return this.games;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getAverageGameDuration() {
        return this.averageGameDuration;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTFormatStats getMostPlayedFormat() {
        return this.mostPlayedFormat;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTUser getBestWinRateUser() {
        return this.bestWinRateUser;
    }

    public final MTPlaygroupStats copy(int games, float averageGameDuration, MTFormatStats mostPlayedFormat, MTUser bestWinRateUser) {
        return new MTPlaygroupStats(games, averageGameDuration, mostPlayedFormat, bestWinRateUser);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTPlaygroupStats)) {
            return false;
        }
        MTPlaygroupStats mTPlaygroupStats = (MTPlaygroupStats) other;
        return this.games == mTPlaygroupStats.games && Float.compare(this.averageGameDuration, mTPlaygroupStats.averageGameDuration) == 0 && Intrinsics.areEqual(this.mostPlayedFormat, mTPlaygroupStats.mostPlayedFormat) && Intrinsics.areEqual(this.bestWinRateUser, mTPlaygroupStats.bestWinRateUser);
    }

    public final float getAverageGameDuration() {
        return this.averageGameDuration;
    }

    public final MTUser getBestWinRateUser() {
        return this.bestWinRateUser;
    }

    public final int getGames() {
        return this.games;
    }

    public final MTFormatStats getMostPlayedFormat() {
        return this.mostPlayedFormat;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.games) * 31) + Float.hashCode(this.averageGameDuration)) * 31;
        MTFormatStats mTFormatStats = this.mostPlayedFormat;
        int iHashCode2 = (iHashCode + (mTFormatStats == null ? 0 : mTFormatStats.hashCode())) * 31;
        MTUser mTUser = this.bestWinRateUser;
        return iHashCode2 + (mTUser != null ? mTUser.hashCode() : 0);
    }

    public final void setAverageGameDuration(float f) {
        this.averageGameDuration = f;
    }

    public final void setBestWinRateUser(MTUser mTUser) {
        this.bestWinRateUser = mTUser;
    }

    public final void setMostPlayedFormat(MTFormatStats mTFormatStats) {
        this.mostPlayedFormat = mTFormatStats;
    }

    public String toString() {
        return "MTPlaygroupStats(games=" + this.games + ", averageGameDuration=" + this.averageGameDuration + ", mostPlayedFormat=" + this.mostPlayedFormat + ", bestWinRateUser=" + this.bestWinRateUser + ")";
    }
}
