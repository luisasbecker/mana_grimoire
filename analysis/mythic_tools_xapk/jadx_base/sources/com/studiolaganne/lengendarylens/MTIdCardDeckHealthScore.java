package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016JN\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016¨\u0006%"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardDeckHealthScore;", "", "overall", "", "color", "", "breakdown", "", "Lcom/studiolaganne/lengendarylens/MTIdCardHealthBreakdown;", "totalWeight", "", "totalWeightedSum", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;)V", "getOverall", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getColor", "()Ljava/lang/String;", "getBreakdown", "()Ljava/util/List;", "getTotalWeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getTotalWeightedSum", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTIdCardDeckHealthScore;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardDeckHealthScore {
    public static final int $stable = 8;
    private final List<MTIdCardHealthBreakdown> breakdown;
    private final String color;
    private final Integer overall;
    private final Double totalWeight;
    private final Double totalWeightedSum;

    public MTIdCardDeckHealthScore() {
        this(null, null, null, null, null, 31, null);
    }

    public MTIdCardDeckHealthScore(Integer num, String str, List<MTIdCardHealthBreakdown> breakdown, Double d, Double d2) {
        Intrinsics.checkNotNullParameter(breakdown, "breakdown");
        this.overall = num;
        this.color = str;
        this.breakdown = breakdown;
        this.totalWeight = d;
        this.totalWeightedSum = d2;
    }

    public /* synthetic */ MTIdCardDeckHealthScore(Integer num, String str, List list, Double d, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : d, (i & 16) != 0 ? null : d2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardDeckHealthScore copy$default(MTIdCardDeckHealthScore mTIdCardDeckHealthScore, Integer num, String str, List list, Double d, Double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardDeckHealthScore.overall;
        }
        if ((i & 2) != 0) {
            str = mTIdCardDeckHealthScore.color;
        }
        if ((i & 4) != 0) {
            list = mTIdCardDeckHealthScore.breakdown;
        }
        if ((i & 8) != 0) {
            d = mTIdCardDeckHealthScore.totalWeight;
        }
        if ((i & 16) != 0) {
            d2 = mTIdCardDeckHealthScore.totalWeightedSum;
        }
        Double d3 = d2;
        List list2 = list;
        return mTIdCardDeckHealthScore.copy(num, str, list2, d, d3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getOverall() {
        return this.overall;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    public final List<MTIdCardHealthBreakdown> component3() {
        return this.breakdown;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getTotalWeight() {
        return this.totalWeight;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getTotalWeightedSum() {
        return this.totalWeightedSum;
    }

    public final MTIdCardDeckHealthScore copy(Integer overall, String color, List<MTIdCardHealthBreakdown> breakdown, Double totalWeight, Double totalWeightedSum) {
        Intrinsics.checkNotNullParameter(breakdown, "breakdown");
        return new MTIdCardDeckHealthScore(overall, color, breakdown, totalWeight, totalWeightedSum);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardDeckHealthScore)) {
            return false;
        }
        MTIdCardDeckHealthScore mTIdCardDeckHealthScore = (MTIdCardDeckHealthScore) other;
        return Intrinsics.areEqual(this.overall, mTIdCardDeckHealthScore.overall) && Intrinsics.areEqual(this.color, mTIdCardDeckHealthScore.color) && Intrinsics.areEqual(this.breakdown, mTIdCardDeckHealthScore.breakdown) && Intrinsics.areEqual((Object) this.totalWeight, (Object) mTIdCardDeckHealthScore.totalWeight) && Intrinsics.areEqual((Object) this.totalWeightedSum, (Object) mTIdCardDeckHealthScore.totalWeightedSum);
    }

    public final List<MTIdCardHealthBreakdown> getBreakdown() {
        return this.breakdown;
    }

    public final String getColor() {
        return this.color;
    }

    public final Integer getOverall() {
        return this.overall;
    }

    public final Double getTotalWeight() {
        return this.totalWeight;
    }

    public final Double getTotalWeightedSum() {
        return this.totalWeightedSum;
    }

    public int hashCode() {
        Integer num = this.overall;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.color;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.breakdown.hashCode()) * 31;
        Double d = this.totalWeight;
        int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.totalWeightedSum;
        return iHashCode3 + (d2 != null ? d2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardDeckHealthScore(overall=" + this.overall + ", color=" + this.color + ", breakdown=" + this.breakdown + ", totalWeight=" + this.totalWeight + ", totalWeightedSum=" + this.totalWeightedSum + ")";
    }
}
