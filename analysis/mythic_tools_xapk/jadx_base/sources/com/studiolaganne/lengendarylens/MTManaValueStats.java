package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJJ\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTManaValueStats;", "", "total_mana_value", "", "average_mana_value", "average_mana_value_without_lands", "median_mana_value", "median_mana_value_without_lands", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getTotal_mana_value", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAverage_mana_value", "getAverage_mana_value_without_lands", "getMedian_mana_value", "getMedian_mana_value_without_lands", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTManaValueStats;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTManaValueStats {
    public static final int $stable = 0;
    private final Double average_mana_value;
    private final Double average_mana_value_without_lands;
    private final Double median_mana_value;
    private final Double median_mana_value_without_lands;
    private final Double total_mana_value;

    public MTManaValueStats() {
        this(null, null, null, null, null, 31, null);
    }

    public MTManaValueStats(Double d, Double d2, Double d3, Double d4, Double d5) {
        this.total_mana_value = d;
        this.average_mana_value = d2;
        this.average_mana_value_without_lands = d3;
        this.median_mana_value = d4;
        this.median_mana_value_without_lands = d5;
    }

    public /* synthetic */ MTManaValueStats(Double d, Double d2, Double d3, Double d4, Double d5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2, (i & 4) != 0 ? null : d3, (i & 8) != 0 ? null : d4, (i & 16) != 0 ? null : d5);
    }

    public static /* synthetic */ MTManaValueStats copy$default(MTManaValueStats mTManaValueStats, Double d, Double d2, Double d3, Double d4, Double d5, int i, Object obj) {
        if ((i & 1) != 0) {
            d = mTManaValueStats.total_mana_value;
        }
        if ((i & 2) != 0) {
            d2 = mTManaValueStats.average_mana_value;
        }
        if ((i & 4) != 0) {
            d3 = mTManaValueStats.average_mana_value_without_lands;
        }
        if ((i & 8) != 0) {
            d4 = mTManaValueStats.median_mana_value;
        }
        if ((i & 16) != 0) {
            d5 = mTManaValueStats.median_mana_value_without_lands;
        }
        Double d6 = d5;
        Double d7 = d3;
        return mTManaValueStats.copy(d, d2, d7, d4, d6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getTotal_mana_value() {
        return this.total_mana_value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getAverage_mana_value() {
        return this.average_mana_value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getAverage_mana_value_without_lands() {
        return this.average_mana_value_without_lands;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getMedian_mana_value() {
        return this.median_mana_value;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getMedian_mana_value_without_lands() {
        return this.median_mana_value_without_lands;
    }

    public final MTManaValueStats copy(Double total_mana_value, Double average_mana_value, Double average_mana_value_without_lands, Double median_mana_value, Double median_mana_value_without_lands) {
        return new MTManaValueStats(total_mana_value, average_mana_value, average_mana_value_without_lands, median_mana_value, median_mana_value_without_lands);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTManaValueStats)) {
            return false;
        }
        MTManaValueStats mTManaValueStats = (MTManaValueStats) other;
        return Intrinsics.areEqual((Object) this.total_mana_value, (Object) mTManaValueStats.total_mana_value) && Intrinsics.areEqual((Object) this.average_mana_value, (Object) mTManaValueStats.average_mana_value) && Intrinsics.areEqual((Object) this.average_mana_value_without_lands, (Object) mTManaValueStats.average_mana_value_without_lands) && Intrinsics.areEqual((Object) this.median_mana_value, (Object) mTManaValueStats.median_mana_value) && Intrinsics.areEqual((Object) this.median_mana_value_without_lands, (Object) mTManaValueStats.median_mana_value_without_lands);
    }

    public final Double getAverage_mana_value() {
        return this.average_mana_value;
    }

    public final Double getAverage_mana_value_without_lands() {
        return this.average_mana_value_without_lands;
    }

    public final Double getMedian_mana_value() {
        return this.median_mana_value;
    }

    public final Double getMedian_mana_value_without_lands() {
        return this.median_mana_value_without_lands;
    }

    public final Double getTotal_mana_value() {
        return this.total_mana_value;
    }

    public int hashCode() {
        Double d = this.total_mana_value;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.average_mana_value;
        int iHashCode2 = (iHashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.average_mana_value_without_lands;
        int iHashCode3 = (iHashCode2 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Double d4 = this.median_mana_value;
        int iHashCode4 = (iHashCode3 + (d4 == null ? 0 : d4.hashCode())) * 31;
        Double d5 = this.median_mana_value_without_lands;
        return iHashCode4 + (d5 != null ? d5.hashCode() : 0);
    }

    public String toString() {
        return "MTManaValueStats(total_mana_value=" + this.total_mana_value + ", average_mana_value=" + this.average_mana_value + ", average_mana_value_without_lands=" + this.average_mana_value_without_lands + ", median_mana_value=" + this.median_mana_value + ", median_mana_value_without_lands=" + this.median_mana_value_without_lands + ")";
    }
}
