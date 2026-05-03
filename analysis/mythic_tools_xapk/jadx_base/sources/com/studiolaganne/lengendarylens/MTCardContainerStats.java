package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardContainerStats;", "", "mana_value_stats", "Lcom/studiolaganne/lengendarylens/MTManaValueStats;", "mana_curve", "", "Lcom/studiolaganne/lengendarylens/MTManaCurveEntry;", "mana_cost_production", "Lcom/studiolaganne/lengendarylens/MTManaCostProductionEntry;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTManaValueStats;Ljava/util/List;Ljava/util/List;)V", "getMana_value_stats", "()Lcom/studiolaganne/lengendarylens/MTManaValueStats;", "getMana_curve", "()Ljava/util/List;", "getMana_cost_production", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardContainerStats {
    public static final int $stable = 8;
    private final List<MTManaCostProductionEntry> mana_cost_production;
    private final List<MTManaCurveEntry> mana_curve;
    private final MTManaValueStats mana_value_stats;

    public MTCardContainerStats() {
        this(null, null, null, 7, null);
    }

    public MTCardContainerStats(MTManaValueStats mTManaValueStats, List<MTManaCurveEntry> list, List<MTManaCostProductionEntry> list2) {
        this.mana_value_stats = mTManaValueStats;
        this.mana_curve = list;
        this.mana_cost_production = list2;
    }

    public /* synthetic */ MTCardContainerStats(MTManaValueStats mTManaValueStats, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTManaValueStats, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardContainerStats copy$default(MTCardContainerStats mTCardContainerStats, MTManaValueStats mTManaValueStats, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            mTManaValueStats = mTCardContainerStats.mana_value_stats;
        }
        if ((i & 2) != 0) {
            list = mTCardContainerStats.mana_curve;
        }
        if ((i & 4) != 0) {
            list2 = mTCardContainerStats.mana_cost_production;
        }
        return mTCardContainerStats.copy(mTManaValueStats, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTManaValueStats getMana_value_stats() {
        return this.mana_value_stats;
    }

    public final List<MTManaCurveEntry> component2() {
        return this.mana_curve;
    }

    public final List<MTManaCostProductionEntry> component3() {
        return this.mana_cost_production;
    }

    public final MTCardContainerStats copy(MTManaValueStats mana_value_stats, List<MTManaCurveEntry> mana_curve, List<MTManaCostProductionEntry> mana_cost_production) {
        return new MTCardContainerStats(mana_value_stats, mana_curve, mana_cost_production);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardContainerStats)) {
            return false;
        }
        MTCardContainerStats mTCardContainerStats = (MTCardContainerStats) other;
        return Intrinsics.areEqual(this.mana_value_stats, mTCardContainerStats.mana_value_stats) && Intrinsics.areEqual(this.mana_curve, mTCardContainerStats.mana_curve) && Intrinsics.areEqual(this.mana_cost_production, mTCardContainerStats.mana_cost_production);
    }

    public final List<MTManaCostProductionEntry> getMana_cost_production() {
        return this.mana_cost_production;
    }

    public final List<MTManaCurveEntry> getMana_curve() {
        return this.mana_curve;
    }

    public final MTManaValueStats getMana_value_stats() {
        return this.mana_value_stats;
    }

    public int hashCode() {
        MTManaValueStats mTManaValueStats = this.mana_value_stats;
        int iHashCode = (mTManaValueStats == null ? 0 : mTManaValueStats.hashCode()) * 31;
        List<MTManaCurveEntry> list = this.mana_curve;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<MTManaCostProductionEntry> list2 = this.mana_cost_production;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "MTCardContainerStats(mana_value_stats=" + this.mana_value_stats + ", mana_curve=" + this.mana_curve + ", mana_cost_production=" + this.mana_cost_production + ")";
    }
}
