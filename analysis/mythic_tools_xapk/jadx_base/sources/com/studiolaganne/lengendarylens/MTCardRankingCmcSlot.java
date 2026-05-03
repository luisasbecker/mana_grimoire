package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingCmcSlot;", "", "cmc", "", "count", "<init>", "(II)V", "getCmc", "()I", "getCount", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingCmcSlot {
    public static final int $stable = 0;
    private final int cmc;
    private final int count;

    /* JADX WARN: Illegal instructions before constructor call */
    public MTCardRankingCmcSlot() {
        int i = 0;
        this(i, i, 3, null);
    }

    public MTCardRankingCmcSlot(int i, int i2) {
        this.cmc = i;
        this.count = i2;
    }

    public /* synthetic */ MTCardRankingCmcSlot(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public static /* synthetic */ MTCardRankingCmcSlot copy$default(MTCardRankingCmcSlot mTCardRankingCmcSlot, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTCardRankingCmcSlot.cmc;
        }
        if ((i3 & 2) != 0) {
            i2 = mTCardRankingCmcSlot.count;
        }
        return mTCardRankingCmcSlot.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCmc() {
        return this.cmc;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final MTCardRankingCmcSlot copy(int cmc, int count) {
        return new MTCardRankingCmcSlot(cmc, count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingCmcSlot)) {
            return false;
        }
        MTCardRankingCmcSlot mTCardRankingCmcSlot = (MTCardRankingCmcSlot) other;
        return this.cmc == mTCardRankingCmcSlot.cmc && this.count == mTCardRankingCmcSlot.count;
    }

    public final int getCmc() {
        return this.cmc;
    }

    public final int getCount() {
        return this.count;
    }

    public int hashCode() {
        return (Integer.hashCode(this.cmc) * 31) + Integer.hashCode(this.count);
    }

    public String toString() {
        return "MTCardRankingCmcSlot(cmc=" + this.cmc + ", count=" + this.count + ")";
    }
}
