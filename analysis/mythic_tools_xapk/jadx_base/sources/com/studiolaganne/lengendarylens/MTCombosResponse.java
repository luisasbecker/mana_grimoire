package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCombosResponse;", "", "complete", "", "Lcom/studiolaganne/lengendarylens/MTCombo;", "partial", "stats", "Lcom/studiolaganne/lengendarylens/MTCombosStats;", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTCombosStats;)V", "getComplete", "()Ljava/util/List;", "getPartial", "getStats", "()Lcom/studiolaganne/lengendarylens/MTCombosStats;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCombosResponse {
    public static final int $stable = 8;
    private final List<MTCombo> complete;
    private final List<MTCombo> partial;
    private final MTCombosStats stats;

    public MTCombosResponse() {
        this(null, null, null, 7, null);
    }

    public MTCombosResponse(List<MTCombo> complete, List<MTCombo> partial, MTCombosStats mTCombosStats) {
        Intrinsics.checkNotNullParameter(complete, "complete");
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.complete = complete;
        this.partial = partial;
        this.stats = mTCombosStats;
    }

    public /* synthetic */ MTCombosResponse(List list, List list2, MTCombosStats mTCombosStats, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? null : mTCombosStats);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCombosResponse copy$default(MTCombosResponse mTCombosResponse, List list, List list2, MTCombosStats mTCombosStats, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTCombosResponse.complete;
        }
        if ((i & 2) != 0) {
            list2 = mTCombosResponse.partial;
        }
        if ((i & 4) != 0) {
            mTCombosStats = mTCombosResponse.stats;
        }
        return mTCombosResponse.copy(list, list2, mTCombosStats);
    }

    public final List<MTCombo> component1() {
        return this.complete;
    }

    public final List<MTCombo> component2() {
        return this.partial;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTCombosStats getStats() {
        return this.stats;
    }

    public final MTCombosResponse copy(List<MTCombo> complete, List<MTCombo> partial, MTCombosStats stats) {
        Intrinsics.checkNotNullParameter(complete, "complete");
        Intrinsics.checkNotNullParameter(partial, "partial");
        return new MTCombosResponse(complete, partial, stats);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCombosResponse)) {
            return false;
        }
        MTCombosResponse mTCombosResponse = (MTCombosResponse) other;
        return Intrinsics.areEqual(this.complete, mTCombosResponse.complete) && Intrinsics.areEqual(this.partial, mTCombosResponse.partial) && Intrinsics.areEqual(this.stats, mTCombosResponse.stats);
    }

    public final List<MTCombo> getComplete() {
        return this.complete;
    }

    public final List<MTCombo> getPartial() {
        return this.partial;
    }

    public final MTCombosStats getStats() {
        return this.stats;
    }

    public int hashCode() {
        int iHashCode = ((this.complete.hashCode() * 31) + this.partial.hashCode()) * 31;
        MTCombosStats mTCombosStats = this.stats;
        return iHashCode + (mTCombosStats == null ? 0 : mTCombosStats.hashCode());
    }

    public String toString() {
        return "MTCombosResponse(complete=" + this.complete + ", partial=" + this.partial + ", stats=" + this.stats + ")";
    }
}
