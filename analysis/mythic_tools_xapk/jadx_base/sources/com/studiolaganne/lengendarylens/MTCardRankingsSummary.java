package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003Jk\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingsSummary;", "", "total", "", "distribution", "", "", "overallDistribution", "redundantCount", "protectedCount", "average", "median", "<init>", "(ILjava/util/Map;Ljava/util/Map;IIII)V", "getTotal", "()I", "getDistribution", "()Ljava/util/Map;", "getOverallDistribution", "getRedundantCount", "getProtectedCount", "getAverage", "getMedian", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingsSummary {
    public static final int $stable = 8;
    private final int average;
    private final Map<String, Integer> distribution;
    private final int median;
    private final Map<String, Integer> overallDistribution;
    private final int protectedCount;
    private final int redundantCount;
    private final int total;

    public MTCardRankingsSummary() {
        this(0, null, null, 0, 0, 0, 0, 127, null);
    }

    public MTCardRankingsSummary(int i, Map<String, Integer> map, Map<String, Integer> map2, int i2, int i3, int i4, int i5) {
        this.total = i;
        this.distribution = map;
        this.overallDistribution = map2;
        this.redundantCount = i2;
        this.protectedCount = i3;
        this.average = i4;
        this.median = i5;
    }

    public /* synthetic */ MTCardRankingsSummary(int i, Map map, Map map2, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? null : map, (i6 & 4) != 0 ? null : map2, (i6 & 8) != 0 ? 0 : i2, (i6 & 16) != 0 ? 0 : i3, (i6 & 32) != 0 ? 0 : i4, (i6 & 64) != 0 ? 0 : i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardRankingsSummary copy$default(MTCardRankingsSummary mTCardRankingsSummary, int i, Map map, Map map2, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = mTCardRankingsSummary.total;
        }
        if ((i6 & 2) != 0) {
            map = mTCardRankingsSummary.distribution;
        }
        if ((i6 & 4) != 0) {
            map2 = mTCardRankingsSummary.overallDistribution;
        }
        if ((i6 & 8) != 0) {
            i2 = mTCardRankingsSummary.redundantCount;
        }
        if ((i6 & 16) != 0) {
            i3 = mTCardRankingsSummary.protectedCount;
        }
        if ((i6 & 32) != 0) {
            i4 = mTCardRankingsSummary.average;
        }
        if ((i6 & 64) != 0) {
            i5 = mTCardRankingsSummary.median;
        }
        int i7 = i4;
        int i8 = i5;
        int i9 = i3;
        Map map3 = map2;
        return mTCardRankingsSummary.copy(i, map, map3, i2, i9, i7, i8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final Map<String, Integer> component2() {
        return this.distribution;
    }

    public final Map<String, Integer> component3() {
        return this.overallDistribution;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getRedundantCount() {
        return this.redundantCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getProtectedCount() {
        return this.protectedCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getAverage() {
        return this.average;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getMedian() {
        return this.median;
    }

    public final MTCardRankingsSummary copy(int total, Map<String, Integer> distribution, Map<String, Integer> overallDistribution, int redundantCount, int protectedCount, int average, int median) {
        return new MTCardRankingsSummary(total, distribution, overallDistribution, redundantCount, protectedCount, average, median);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingsSummary)) {
            return false;
        }
        MTCardRankingsSummary mTCardRankingsSummary = (MTCardRankingsSummary) other;
        return this.total == mTCardRankingsSummary.total && Intrinsics.areEqual(this.distribution, mTCardRankingsSummary.distribution) && Intrinsics.areEqual(this.overallDistribution, mTCardRankingsSummary.overallDistribution) && this.redundantCount == mTCardRankingsSummary.redundantCount && this.protectedCount == mTCardRankingsSummary.protectedCount && this.average == mTCardRankingsSummary.average && this.median == mTCardRankingsSummary.median;
    }

    public final int getAverage() {
        return this.average;
    }

    public final Map<String, Integer> getDistribution() {
        return this.distribution;
    }

    public final int getMedian() {
        return this.median;
    }

    public final Map<String, Integer> getOverallDistribution() {
        return this.overallDistribution;
    }

    public final int getProtectedCount() {
        return this.protectedCount;
    }

    public final int getRedundantCount() {
        return this.redundantCount;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.total) * 31;
        Map<String, Integer> map = this.distribution;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, Integer> map2 = this.overallDistribution;
        return ((((((((iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31) + Integer.hashCode(this.redundantCount)) * 31) + Integer.hashCode(this.protectedCount)) * 31) + Integer.hashCode(this.average)) * 31) + Integer.hashCode(this.median);
    }

    public String toString() {
        return "MTCardRankingsSummary(total=" + this.total + ", distribution=" + this.distribution + ", overallDistribution=" + this.overallDistribution + ", redundantCount=" + this.redundantCount + ", protectedCount=" + this.protectedCount + ", average=" + this.average + ", median=" + this.median + ")";
    }
}
