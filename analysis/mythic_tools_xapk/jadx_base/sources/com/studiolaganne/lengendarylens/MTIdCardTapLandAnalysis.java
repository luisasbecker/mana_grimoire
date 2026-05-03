package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003Jj\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006*"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardTapLandAnalysis;", "", "totalLands", "", "alwaysTappedCount", "conditionallyTappedCount", "effectiveTappedScore", "", "alwaysTappedPercent", "alwaysTappedLands", "", "Lcom/studiolaganne/lengendarylens/MTIdCardTapLandEntry;", "conditionallyTappedLands", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;)V", "getTotalLands", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAlwaysTappedCount", "getConditionallyTappedCount", "getEffectiveTappedScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAlwaysTappedPercent", "getAlwaysTappedLands", "()Ljava/util/List;", "getConditionallyTappedLands", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardTapLandAnalysis;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardTapLandAnalysis {
    public static final int $stable = 8;
    private final Integer alwaysTappedCount;
    private final List<MTIdCardTapLandEntry> alwaysTappedLands;
    private final Double alwaysTappedPercent;
    private final Integer conditionallyTappedCount;
    private final List<MTIdCardTapLandEntry> conditionallyTappedLands;
    private final Double effectiveTappedScore;
    private final Integer totalLands;

    public MTIdCardTapLandAnalysis() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public MTIdCardTapLandAnalysis(Integer num, Integer num2, Integer num3, Double d, Double d2, List<MTIdCardTapLandEntry> alwaysTappedLands, List<MTIdCardTapLandEntry> conditionallyTappedLands) {
        Intrinsics.checkNotNullParameter(alwaysTappedLands, "alwaysTappedLands");
        Intrinsics.checkNotNullParameter(conditionallyTappedLands, "conditionallyTappedLands");
        this.totalLands = num;
        this.alwaysTappedCount = num2;
        this.conditionallyTappedCount = num3;
        this.effectiveTappedScore = d;
        this.alwaysTappedPercent = d2;
        this.alwaysTappedLands = alwaysTappedLands;
        this.conditionallyTappedLands = conditionallyTappedLands;
    }

    public /* synthetic */ MTIdCardTapLandAnalysis(Integer num, Integer num2, Integer num3, Double d, Double d2, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : d, (i & 16) != 0 ? null : d2, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardTapLandAnalysis copy$default(MTIdCardTapLandAnalysis mTIdCardTapLandAnalysis, Integer num, Integer num2, Integer num3, Double d, Double d2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardTapLandAnalysis.totalLands;
        }
        if ((i & 2) != 0) {
            num2 = mTIdCardTapLandAnalysis.alwaysTappedCount;
        }
        if ((i & 4) != 0) {
            num3 = mTIdCardTapLandAnalysis.conditionallyTappedCount;
        }
        if ((i & 8) != 0) {
            d = mTIdCardTapLandAnalysis.effectiveTappedScore;
        }
        if ((i & 16) != 0) {
            d2 = mTIdCardTapLandAnalysis.alwaysTappedPercent;
        }
        if ((i & 32) != 0) {
            list = mTIdCardTapLandAnalysis.alwaysTappedLands;
        }
        if ((i & 64) != 0) {
            list2 = mTIdCardTapLandAnalysis.conditionallyTappedLands;
        }
        List list3 = list;
        List list4 = list2;
        Double d3 = d2;
        Integer num4 = num3;
        return mTIdCardTapLandAnalysis.copy(num, num2, num4, d, d3, list3, list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getTotalLands() {
        return this.totalLands;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getAlwaysTappedCount() {
        return this.alwaysTappedCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getConditionallyTappedCount() {
        return this.conditionallyTappedCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getEffectiveTappedScore() {
        return this.effectiveTappedScore;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getAlwaysTappedPercent() {
        return this.alwaysTappedPercent;
    }

    public final List<MTIdCardTapLandEntry> component6() {
        return this.alwaysTappedLands;
    }

    public final List<MTIdCardTapLandEntry> component7() {
        return this.conditionallyTappedLands;
    }

    public final MTIdCardTapLandAnalysis copy(Integer totalLands, Integer alwaysTappedCount, Integer conditionallyTappedCount, Double effectiveTappedScore, Double alwaysTappedPercent, List<MTIdCardTapLandEntry> alwaysTappedLands, List<MTIdCardTapLandEntry> conditionallyTappedLands) {
        Intrinsics.checkNotNullParameter(alwaysTappedLands, "alwaysTappedLands");
        Intrinsics.checkNotNullParameter(conditionallyTappedLands, "conditionallyTappedLands");
        return new MTIdCardTapLandAnalysis(totalLands, alwaysTappedCount, conditionallyTappedCount, effectiveTappedScore, alwaysTappedPercent, alwaysTappedLands, conditionallyTappedLands);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardTapLandAnalysis)) {
            return false;
        }
        MTIdCardTapLandAnalysis mTIdCardTapLandAnalysis = (MTIdCardTapLandAnalysis) other;
        return Intrinsics.areEqual(this.totalLands, mTIdCardTapLandAnalysis.totalLands) && Intrinsics.areEqual(this.alwaysTappedCount, mTIdCardTapLandAnalysis.alwaysTappedCount) && Intrinsics.areEqual(this.conditionallyTappedCount, mTIdCardTapLandAnalysis.conditionallyTappedCount) && Intrinsics.areEqual((Object) this.effectiveTappedScore, (Object) mTIdCardTapLandAnalysis.effectiveTappedScore) && Intrinsics.areEqual((Object) this.alwaysTappedPercent, (Object) mTIdCardTapLandAnalysis.alwaysTappedPercent) && Intrinsics.areEqual(this.alwaysTappedLands, mTIdCardTapLandAnalysis.alwaysTappedLands) && Intrinsics.areEqual(this.conditionallyTappedLands, mTIdCardTapLandAnalysis.conditionallyTappedLands);
    }

    public final Integer getAlwaysTappedCount() {
        return this.alwaysTappedCount;
    }

    public final List<MTIdCardTapLandEntry> getAlwaysTappedLands() {
        return this.alwaysTappedLands;
    }

    public final Double getAlwaysTappedPercent() {
        return this.alwaysTappedPercent;
    }

    public final Integer getConditionallyTappedCount() {
        return this.conditionallyTappedCount;
    }

    public final List<MTIdCardTapLandEntry> getConditionallyTappedLands() {
        return this.conditionallyTappedLands;
    }

    public final Double getEffectiveTappedScore() {
        return this.effectiveTappedScore;
    }

    public final Integer getTotalLands() {
        return this.totalLands;
    }

    public int hashCode() {
        Integer num = this.totalLands;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.alwaysTappedCount;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.conditionallyTappedCount;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Double d = this.effectiveTappedScore;
        int iHashCode4 = (iHashCode3 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.alwaysTappedPercent;
        return ((((iHashCode4 + (d2 != null ? d2.hashCode() : 0)) * 31) + this.alwaysTappedLands.hashCode()) * 31) + this.conditionallyTappedLands.hashCode();
    }

    public String toString() {
        return "MTIdCardTapLandAnalysis(totalLands=" + this.totalLands + ", alwaysTappedCount=" + this.alwaysTappedCount + ", conditionallyTappedCount=" + this.conditionallyTappedCount + ", effectiveTappedScore=" + this.effectiveTappedScore + ", alwaysTappedPercent=" + this.alwaysTappedPercent + ", alwaysTappedLands=" + this.alwaysTappedLands + ", conditionallyTappedLands=" + this.conditionallyTappedLands + ")";
    }
}
