package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B»\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJÂ\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\bHÖ\u0001J\t\u0010=\u001a\u00020>HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b!\u0010\u0016R\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001cR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0016R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b%\u0010\u0016R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b&\u0010\u001cR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b'\u0010\u001c¨\u0006?"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardLandCountCalculation;", "", "karstenBase", "", "avgManaValue", "cmcContribution", "rampDeduction", "rampCount", "", "cantripCount", "cantripDeduction", "mulliganAdj", "themeAdjustment", "mdfcLandCount", "mdfcAdjustment", "fastManaCount", "fastManaDeduction", "recommendedMin", "recommendedMax", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getKarstenBase", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAvgManaValue", "getCmcContribution", "getRampDeduction", "getRampCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCantripCount", "getCantripDeduction", "getMulliganAdj", "getThemeAdjustment", "getMdfcLandCount", "getMdfcAdjustment", "getFastManaCount", "getFastManaDeduction", "getRecommendedMin", "getRecommendedMax", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTIdCardLandCountCalculation;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardLandCountCalculation {
    public static final int $stable = 0;
    private final Double avgManaValue;
    private final Integer cantripCount;
    private final Double cantripDeduction;
    private final Double cmcContribution;
    private final Integer fastManaCount;
    private final Double fastManaDeduction;
    private final Double karstenBase;
    private final Double mdfcAdjustment;
    private final Integer mdfcLandCount;
    private final Double mulliganAdj;
    private final Integer rampCount;
    private final Double rampDeduction;
    private final Integer recommendedMax;
    private final Integer recommendedMin;
    private final Double themeAdjustment;

    public MTIdCardLandCountCalculation() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public MTIdCardLandCountCalculation(Double d, Double d2, Double d3, Double d4, Integer num, Integer num2, Double d5, Double d6, Double d7, Integer num3, Double d8, Integer num4, Double d9, Integer num5, Integer num6) {
        this.karstenBase = d;
        this.avgManaValue = d2;
        this.cmcContribution = d3;
        this.rampDeduction = d4;
        this.rampCount = num;
        this.cantripCount = num2;
        this.cantripDeduction = d5;
        this.mulliganAdj = d6;
        this.themeAdjustment = d7;
        this.mdfcLandCount = num3;
        this.mdfcAdjustment = d8;
        this.fastManaCount = num4;
        this.fastManaDeduction = d9;
        this.recommendedMin = num5;
        this.recommendedMax = num6;
    }

    public /* synthetic */ MTIdCardLandCountCalculation(Double d, Double d2, Double d3, Double d4, Integer num, Integer num2, Double d5, Double d6, Double d7, Integer num3, Double d8, Integer num4, Double d9, Integer num5, Integer num6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2, (i & 4) != 0 ? null : d3, (i & 8) != 0 ? null : d4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : d5, (i & 128) != 0 ? null : d6, (i & 256) != 0 ? null : d7, (i & 512) != 0 ? null : num3, (i & 1024) != 0 ? null : d8, (i & 2048) != 0 ? null : num4, (i & 4096) != 0 ? null : d9, (i & 8192) != 0 ? null : num5, (i & 16384) != 0 ? null : num6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getKarstenBase() {
        return this.karstenBase;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getMdfcLandCount() {
        return this.mdfcLandCount;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Double getMdfcAdjustment() {
        return this.mdfcAdjustment;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Integer getFastManaCount() {
        return this.fastManaCount;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Double getFastManaDeduction() {
        return this.fastManaDeduction;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getRecommendedMin() {
        return this.recommendedMin;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getRecommendedMax() {
        return this.recommendedMax;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getAvgManaValue() {
        return this.avgManaValue;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getCmcContribution() {
        return this.cmcContribution;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getRampDeduction() {
        return this.rampDeduction;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getRampCount() {
        return this.rampCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getCantripCount() {
        return this.cantripCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getCantripDeduction() {
        return this.cantripDeduction;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Double getMulliganAdj() {
        return this.mulliganAdj;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Double getThemeAdjustment() {
        return this.themeAdjustment;
    }

    public final MTIdCardLandCountCalculation copy(Double karstenBase, Double avgManaValue, Double cmcContribution, Double rampDeduction, Integer rampCount, Integer cantripCount, Double cantripDeduction, Double mulliganAdj, Double themeAdjustment, Integer mdfcLandCount, Double mdfcAdjustment, Integer fastManaCount, Double fastManaDeduction, Integer recommendedMin, Integer recommendedMax) {
        return new MTIdCardLandCountCalculation(karstenBase, avgManaValue, cmcContribution, rampDeduction, rampCount, cantripCount, cantripDeduction, mulliganAdj, themeAdjustment, mdfcLandCount, mdfcAdjustment, fastManaCount, fastManaDeduction, recommendedMin, recommendedMax);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardLandCountCalculation)) {
            return false;
        }
        MTIdCardLandCountCalculation mTIdCardLandCountCalculation = (MTIdCardLandCountCalculation) other;
        return Intrinsics.areEqual((Object) this.karstenBase, (Object) mTIdCardLandCountCalculation.karstenBase) && Intrinsics.areEqual((Object) this.avgManaValue, (Object) mTIdCardLandCountCalculation.avgManaValue) && Intrinsics.areEqual((Object) this.cmcContribution, (Object) mTIdCardLandCountCalculation.cmcContribution) && Intrinsics.areEqual((Object) this.rampDeduction, (Object) mTIdCardLandCountCalculation.rampDeduction) && Intrinsics.areEqual(this.rampCount, mTIdCardLandCountCalculation.rampCount) && Intrinsics.areEqual(this.cantripCount, mTIdCardLandCountCalculation.cantripCount) && Intrinsics.areEqual((Object) this.cantripDeduction, (Object) mTIdCardLandCountCalculation.cantripDeduction) && Intrinsics.areEqual((Object) this.mulliganAdj, (Object) mTIdCardLandCountCalculation.mulliganAdj) && Intrinsics.areEqual((Object) this.themeAdjustment, (Object) mTIdCardLandCountCalculation.themeAdjustment) && Intrinsics.areEqual(this.mdfcLandCount, mTIdCardLandCountCalculation.mdfcLandCount) && Intrinsics.areEqual((Object) this.mdfcAdjustment, (Object) mTIdCardLandCountCalculation.mdfcAdjustment) && Intrinsics.areEqual(this.fastManaCount, mTIdCardLandCountCalculation.fastManaCount) && Intrinsics.areEqual((Object) this.fastManaDeduction, (Object) mTIdCardLandCountCalculation.fastManaDeduction) && Intrinsics.areEqual(this.recommendedMin, mTIdCardLandCountCalculation.recommendedMin) && Intrinsics.areEqual(this.recommendedMax, mTIdCardLandCountCalculation.recommendedMax);
    }

    public final Double getAvgManaValue() {
        return this.avgManaValue;
    }

    public final Integer getCantripCount() {
        return this.cantripCount;
    }

    public final Double getCantripDeduction() {
        return this.cantripDeduction;
    }

    public final Double getCmcContribution() {
        return this.cmcContribution;
    }

    public final Integer getFastManaCount() {
        return this.fastManaCount;
    }

    public final Double getFastManaDeduction() {
        return this.fastManaDeduction;
    }

    public final Double getKarstenBase() {
        return this.karstenBase;
    }

    public final Double getMdfcAdjustment() {
        return this.mdfcAdjustment;
    }

    public final Integer getMdfcLandCount() {
        return this.mdfcLandCount;
    }

    public final Double getMulliganAdj() {
        return this.mulliganAdj;
    }

    public final Integer getRampCount() {
        return this.rampCount;
    }

    public final Double getRampDeduction() {
        return this.rampDeduction;
    }

    public final Integer getRecommendedMax() {
        return this.recommendedMax;
    }

    public final Integer getRecommendedMin() {
        return this.recommendedMin;
    }

    public final Double getThemeAdjustment() {
        return this.themeAdjustment;
    }

    public int hashCode() {
        Double d = this.karstenBase;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.avgManaValue;
        int iHashCode2 = (iHashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.cmcContribution;
        int iHashCode3 = (iHashCode2 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Double d4 = this.rampDeduction;
        int iHashCode4 = (iHashCode3 + (d4 == null ? 0 : d4.hashCode())) * 31;
        Integer num = this.rampCount;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.cantripCount;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d5 = this.cantripDeduction;
        int iHashCode7 = (iHashCode6 + (d5 == null ? 0 : d5.hashCode())) * 31;
        Double d6 = this.mulliganAdj;
        int iHashCode8 = (iHashCode7 + (d6 == null ? 0 : d6.hashCode())) * 31;
        Double d7 = this.themeAdjustment;
        int iHashCode9 = (iHashCode8 + (d7 == null ? 0 : d7.hashCode())) * 31;
        Integer num3 = this.mdfcLandCount;
        int iHashCode10 = (iHashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Double d8 = this.mdfcAdjustment;
        int iHashCode11 = (iHashCode10 + (d8 == null ? 0 : d8.hashCode())) * 31;
        Integer num4 = this.fastManaCount;
        int iHashCode12 = (iHashCode11 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Double d9 = this.fastManaDeduction;
        int iHashCode13 = (iHashCode12 + (d9 == null ? 0 : d9.hashCode())) * 31;
        Integer num5 = this.recommendedMin;
        int iHashCode14 = (iHashCode13 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.recommendedMax;
        return iHashCode14 + (num6 != null ? num6.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardLandCountCalculation(karstenBase=" + this.karstenBase + ", avgManaValue=" + this.avgManaValue + ", cmcContribution=" + this.cmcContribution + ", rampDeduction=" + this.rampDeduction + ", rampCount=" + this.rampCount + ", cantripCount=" + this.cantripCount + ", cantripDeduction=" + this.cantripDeduction + ", mulliganAdj=" + this.mulliganAdj + ", themeAdjustment=" + this.themeAdjustment + ", mdfcLandCount=" + this.mdfcLandCount + ", mdfcAdjustment=" + this.mdfcAdjustment + ", fastManaCount=" + this.fastManaCount + ", fastManaDeduction=" + this.fastManaDeduction + ", recommendedMin=" + this.recommendedMin + ", recommendedMax=" + this.recommendedMax + ")";
    }
}
