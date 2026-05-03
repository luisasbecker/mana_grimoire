package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003JZ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardHealthBreakdown;", "", "tier", "", "tierScore", "", "count", "", "totalWeight", "weightedContribution", "insightIds", "", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)V", "getTier", "()Ljava/lang/String;", "getTierScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalWeight", "getWeightedContribution", "getInsightIds", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardHealthBreakdown;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardHealthBreakdown {
    public static final int $stable = 8;
    private final Integer count;
    private final List<String> insightIds;
    private final String tier;
    private final Double tierScore;
    private final Double totalWeight;
    private final Double weightedContribution;

    public MTIdCardHealthBreakdown() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MTIdCardHealthBreakdown(String str, Double d, Integer num, Double d2, Double d3, List<String> insightIds) {
        Intrinsics.checkNotNullParameter(insightIds, "insightIds");
        this.tier = str;
        this.tierScore = d;
        this.count = num;
        this.totalWeight = d2;
        this.weightedContribution = d3;
        this.insightIds = insightIds;
    }

    public /* synthetic */ MTIdCardHealthBreakdown(String str, Double d, Integer num, Double d2, Double d3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : d2, (i & 16) != 0 ? null : d3, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardHealthBreakdown copy$default(MTIdCardHealthBreakdown mTIdCardHealthBreakdown, String str, Double d, Integer num, Double d2, Double d3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardHealthBreakdown.tier;
        }
        if ((i & 2) != 0) {
            d = mTIdCardHealthBreakdown.tierScore;
        }
        if ((i & 4) != 0) {
            num = mTIdCardHealthBreakdown.count;
        }
        if ((i & 8) != 0) {
            d2 = mTIdCardHealthBreakdown.totalWeight;
        }
        if ((i & 16) != 0) {
            d3 = mTIdCardHealthBreakdown.weightedContribution;
        }
        if ((i & 32) != 0) {
            list = mTIdCardHealthBreakdown.insightIds;
        }
        Double d4 = d3;
        List list2 = list;
        return mTIdCardHealthBreakdown.copy(str, d, num, d2, d4, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTier() {
        return this.tier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getTierScore() {
        return this.tierScore;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getTotalWeight() {
        return this.totalWeight;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getWeightedContribution() {
        return this.weightedContribution;
    }

    public final List<String> component6() {
        return this.insightIds;
    }

    public final MTIdCardHealthBreakdown copy(String tier, Double tierScore, Integer count, Double totalWeight, Double weightedContribution, List<String> insightIds) {
        Intrinsics.checkNotNullParameter(insightIds, "insightIds");
        return new MTIdCardHealthBreakdown(tier, tierScore, count, totalWeight, weightedContribution, insightIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardHealthBreakdown)) {
            return false;
        }
        MTIdCardHealthBreakdown mTIdCardHealthBreakdown = (MTIdCardHealthBreakdown) other;
        return Intrinsics.areEqual(this.tier, mTIdCardHealthBreakdown.tier) && Intrinsics.areEqual((Object) this.tierScore, (Object) mTIdCardHealthBreakdown.tierScore) && Intrinsics.areEqual(this.count, mTIdCardHealthBreakdown.count) && Intrinsics.areEqual((Object) this.totalWeight, (Object) mTIdCardHealthBreakdown.totalWeight) && Intrinsics.areEqual((Object) this.weightedContribution, (Object) mTIdCardHealthBreakdown.weightedContribution) && Intrinsics.areEqual(this.insightIds, mTIdCardHealthBreakdown.insightIds);
    }

    public final Integer getCount() {
        return this.count;
    }

    public final List<String> getInsightIds() {
        return this.insightIds;
    }

    public final String getTier() {
        return this.tier;
    }

    public final Double getTierScore() {
        return this.tierScore;
    }

    public final Double getTotalWeight() {
        return this.totalWeight;
    }

    public final Double getWeightedContribution() {
        return this.weightedContribution;
    }

    public int hashCode() {
        String str = this.tier;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double d = this.tierScore;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Integer num = this.count;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Double d2 = this.totalWeight;
        int iHashCode4 = (iHashCode3 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.weightedContribution;
        return ((iHashCode4 + (d3 != null ? d3.hashCode() : 0)) * 31) + this.insightIds.hashCode();
    }

    public String toString() {
        return "MTIdCardHealthBreakdown(tier=" + this.tier + ", tierScore=" + this.tierScore + ", count=" + this.count + ", totalWeight=" + this.totalWeight + ", weightedContribution=" + this.weightedContribution + ", insightIds=" + this.insightIds + ")";
    }
}
