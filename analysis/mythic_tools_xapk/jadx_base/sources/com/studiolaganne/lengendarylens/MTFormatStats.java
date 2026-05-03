package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTFormatStats;", "", "id", "", "name", "", "gamesPlayed", "<init>", "(ILjava/lang/String;I)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getGamesPlayed", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTFormatStats {
    public static final int $stable = 0;
    private final int gamesPlayed;
    private final int id;
    private final String name;

    public MTFormatStats() {
        this(0, null, 0, 7, null);
    }

    public MTFormatStats(int i, String name, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.gamesPlayed = i2;
    }

    public /* synthetic */ MTFormatStats(int i, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? 0 : i2);
    }

    public static /* synthetic */ MTFormatStats copy$default(MTFormatStats mTFormatStats, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTFormatStats.id;
        }
        if ((i3 & 2) != 0) {
            str = mTFormatStats.name;
        }
        if ((i3 & 4) != 0) {
            i2 = mTFormatStats.gamesPlayed;
        }
        return mTFormatStats.copy(i, str, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getGamesPlayed() {
        return this.gamesPlayed;
    }

    public final MTFormatStats copy(int id, String name, int gamesPlayed) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MTFormatStats(id, name, gamesPlayed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTFormatStats)) {
            return false;
        }
        MTFormatStats mTFormatStats = (MTFormatStats) other;
        return this.id == mTFormatStats.id && Intrinsics.areEqual(this.name, mTFormatStats.name) && this.gamesPlayed == mTFormatStats.gamesPlayed;
    }

    public final int getGamesPlayed() {
        return this.gamesPlayed;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.gamesPlayed);
    }

    public String toString() {
        return "MTFormatStats(id=" + this.id + ", name=" + this.name + ", gamesPlayed=" + this.gamesPlayed + ")";
    }
}
