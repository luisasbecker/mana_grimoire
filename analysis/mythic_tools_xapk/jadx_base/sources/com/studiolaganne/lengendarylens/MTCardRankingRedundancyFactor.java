package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingRedundancyFactor;", "", "type", "", "id", "count", "", "threshold", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getType", "()Ljava/lang/String;", "getId", "getCount", "()I", "getThreshold", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingRedundancyFactor {
    public static final int $stable = 0;
    private final int count;
    private final String id;
    private final int threshold;
    private final String type;

    public MTCardRankingRedundancyFactor() {
        this(null, null, 0, 0, 15, null);
    }

    public MTCardRankingRedundancyFactor(String str, String str2, int i, int i2) {
        this.type = str;
        this.id = str2;
        this.count = i;
        this.threshold = i2;
    }

    public /* synthetic */ MTCardRankingRedundancyFactor(String str, String str2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public static /* synthetic */ MTCardRankingRedundancyFactor copy$default(MTCardRankingRedundancyFactor mTCardRankingRedundancyFactor, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = mTCardRankingRedundancyFactor.type;
        }
        if ((i3 & 2) != 0) {
            str2 = mTCardRankingRedundancyFactor.id;
        }
        if ((i3 & 4) != 0) {
            i = mTCardRankingRedundancyFactor.count;
        }
        if ((i3 & 8) != 0) {
            i2 = mTCardRankingRedundancyFactor.threshold;
        }
        return mTCardRankingRedundancyFactor.copy(str, str2, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getThreshold() {
        return this.threshold;
    }

    public final MTCardRankingRedundancyFactor copy(String type, String id, int count, int threshold) {
        return new MTCardRankingRedundancyFactor(type, id, count, threshold);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingRedundancyFactor)) {
            return false;
        }
        MTCardRankingRedundancyFactor mTCardRankingRedundancyFactor = (MTCardRankingRedundancyFactor) other;
        return Intrinsics.areEqual(this.type, mTCardRankingRedundancyFactor.type) && Intrinsics.areEqual(this.id, mTCardRankingRedundancyFactor.id) && this.count == mTCardRankingRedundancyFactor.count && this.threshold == mTCardRankingRedundancyFactor.threshold;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getId() {
        return this.id;
    }

    public final int getThreshold() {
        return this.threshold;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.id;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.threshold);
    }

    public String toString() {
        return "MTCardRankingRedundancyFactor(type=" + this.type + ", id=" + this.id + ", count=" + this.count + ", threshold=" + this.threshold + ")";
    }
}
