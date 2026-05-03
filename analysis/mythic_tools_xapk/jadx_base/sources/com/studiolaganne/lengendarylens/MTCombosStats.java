package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCombosStats;", "", "totalCombos", "", "completeCount", "partialCount", "deckCardsCount", "deckColorIdentity", "", "<init>", "(IIIILjava/lang/String;)V", "getTotalCombos", "()I", "getCompleteCount", "getPartialCount", "getDeckCardsCount", "getDeckColorIdentity", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCombosStats {
    public static final int $stable = 0;
    private final int completeCount;
    private final int deckCardsCount;
    private final String deckColorIdentity;
    private final int partialCount;
    private final int totalCombos;

    public MTCombosStats() {
        this(0, 0, 0, 0, null, 31, null);
    }

    public MTCombosStats(int i, int i2, int i3, int i4, String deckColorIdentity) {
        Intrinsics.checkNotNullParameter(deckColorIdentity, "deckColorIdentity");
        this.totalCombos = i;
        this.completeCount = i2;
        this.partialCount = i3;
        this.deckCardsCount = i4;
        this.deckColorIdentity = deckColorIdentity;
    }

    public /* synthetic */ MTCombosStats(int i, int i2, int i3, int i4, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? "" : str);
    }

    public static /* synthetic */ MTCombosStats copy$default(MTCombosStats mTCombosStats, int i, int i2, int i3, int i4, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mTCombosStats.totalCombos;
        }
        if ((i5 & 2) != 0) {
            i2 = mTCombosStats.completeCount;
        }
        if ((i5 & 4) != 0) {
            i3 = mTCombosStats.partialCount;
        }
        if ((i5 & 8) != 0) {
            i4 = mTCombosStats.deckCardsCount;
        }
        if ((i5 & 16) != 0) {
            str = mTCombosStats.deckColorIdentity;
        }
        String str2 = str;
        int i6 = i3;
        return mTCombosStats.copy(i, i2, i6, i4, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalCombos() {
        return this.totalCombos;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCompleteCount() {
        return this.completeCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPartialCount() {
        return this.partialCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDeckCardsCount() {
        return this.deckCardsCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDeckColorIdentity() {
        return this.deckColorIdentity;
    }

    public final MTCombosStats copy(int totalCombos, int completeCount, int partialCount, int deckCardsCount, String deckColorIdentity) {
        Intrinsics.checkNotNullParameter(deckColorIdentity, "deckColorIdentity");
        return new MTCombosStats(totalCombos, completeCount, partialCount, deckCardsCount, deckColorIdentity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCombosStats)) {
            return false;
        }
        MTCombosStats mTCombosStats = (MTCombosStats) other;
        return this.totalCombos == mTCombosStats.totalCombos && this.completeCount == mTCombosStats.completeCount && this.partialCount == mTCombosStats.partialCount && this.deckCardsCount == mTCombosStats.deckCardsCount && Intrinsics.areEqual(this.deckColorIdentity, mTCombosStats.deckColorIdentity);
    }

    public final int getCompleteCount() {
        return this.completeCount;
    }

    public final int getDeckCardsCount() {
        return this.deckCardsCount;
    }

    public final String getDeckColorIdentity() {
        return this.deckColorIdentity;
    }

    public final int getPartialCount() {
        return this.partialCount;
    }

    public final int getTotalCombos() {
        return this.totalCombos;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.totalCombos) * 31) + Integer.hashCode(this.completeCount)) * 31) + Integer.hashCode(this.partialCount)) * 31) + Integer.hashCode(this.deckCardsCount)) * 31) + this.deckColorIdentity.hashCode();
    }

    public String toString() {
        return "MTCombosStats(totalCombos=" + this.totalCombos + ", completeCount=" + this.completeCount + ", partialCount=" + this.partialCount + ", deckCardsCount=" + this.deckCardsCount + ", deckColorIdentity=" + this.deckColorIdentity + ")";
    }
}
