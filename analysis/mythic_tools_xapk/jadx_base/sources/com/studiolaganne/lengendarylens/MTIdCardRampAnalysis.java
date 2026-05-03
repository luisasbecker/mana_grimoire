package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B÷\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010=\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010>\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010?\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010C\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010D\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010E\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010F\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0017HÆ\u0003Jþ\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020\u0003HÖ\u0001J\t\u0010N\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001cR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b!\u0010\u001cR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001cR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b#\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b%\u0010\u001cR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010(\u001a\u0004\b*\u0010'R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b+\u0010\u001cR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b,\u0010\u001cR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b-\u0010\u001cR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010(\u001a\u0004\b.\u0010'R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010(\u001a\u0004\b/\u0010'R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010(\u001a\u0004\b0\u0010'R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b3\u00102¨\u0006O"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardRampAnalysis;", "", "manaRockCount", "", "manaDorkCount", "cheapLandRampCount", "costReducerCount", "midRampCount", "highRampCount", "ritualCount", "cheapRampCount", "totalRampCount", "ritualBonus", "", "costReducerBonus", "totalEffectiveRamp", "recommendedRamp", "commanderCmc", "commanderBaseline", "commanderAdjustment", "curveComponent", "avgManaValue", "effectiveRampInfo", "", "effectiveRampInfoFr", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)V", "getManaRockCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getManaDorkCount", "getCheapLandRampCount", "getCostReducerCount", "getMidRampCount", "getHighRampCount", "getRitualCount", "getCheapRampCount", "getTotalRampCount", "getRitualBonus", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCostReducerBonus", "getTotalEffectiveRamp", "getRecommendedRamp", "getCommanderCmc", "getCommanderBaseline", "getCommanderAdjustment", "getCurveComponent", "getAvgManaValue", "getEffectiveRampInfo", "()Ljava/lang/String;", "getEffectiveRampInfoFr", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTIdCardRampAnalysis;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardRampAnalysis {
    public static final int $stable = 0;
    private final Double avgManaValue;
    private final Integer cheapLandRampCount;
    private final Integer cheapRampCount;
    private final Double commanderAdjustment;
    private final Integer commanderBaseline;
    private final Integer commanderCmc;
    private final Double costReducerBonus;
    private final Integer costReducerCount;
    private final Double curveComponent;
    private final String effectiveRampInfo;
    private final String effectiveRampInfoFr;
    private final Integer highRampCount;
    private final Integer manaDorkCount;
    private final Integer manaRockCount;
    private final Integer midRampCount;
    private final Integer recommendedRamp;
    private final Double ritualBonus;
    private final Integer ritualCount;
    private final Double totalEffectiveRamp;
    private final Integer totalRampCount;

    public MTIdCardRampAnalysis() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    public MTIdCardRampAnalysis(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Double d, Double d2, Double d3, Integer num10, Integer num11, Integer num12, Double d4, Double d5, Double d6, String str, String str2) {
        this.manaRockCount = num;
        this.manaDorkCount = num2;
        this.cheapLandRampCount = num3;
        this.costReducerCount = num4;
        this.midRampCount = num5;
        this.highRampCount = num6;
        this.ritualCount = num7;
        this.cheapRampCount = num8;
        this.totalRampCount = num9;
        this.ritualBonus = d;
        this.costReducerBonus = d2;
        this.totalEffectiveRamp = d3;
        this.recommendedRamp = num10;
        this.commanderCmc = num11;
        this.commanderBaseline = num12;
        this.commanderAdjustment = d4;
        this.curveComponent = d5;
        this.avgManaValue = d6;
        this.effectiveRampInfo = str;
        this.effectiveRampInfoFr = str2;
    }

    public /* synthetic */ MTIdCardRampAnalysis(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Double d, Double d2, Double d3, Integer num10, Integer num11, Integer num12, Double d4, Double d5, Double d6, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : num5, (i & 32) != 0 ? null : num6, (i & 64) != 0 ? null : num7, (i & 128) != 0 ? null : num8, (i & 256) != 0 ? null : num9, (i & 512) != 0 ? null : d, (i & 1024) != 0 ? null : d2, (i & 2048) != 0 ? null : d3, (i & 4096) != 0 ? null : num10, (i & 8192) != 0 ? null : num11, (i & 16384) != 0 ? null : num12, (i & 32768) != 0 ? null : d4, (i & 65536) != 0 ? null : d5, (i & 131072) != 0 ? null : d6, (i & 262144) != 0 ? null : str, (i & 524288) != 0 ? null : str2);
    }

    public static /* synthetic */ MTIdCardRampAnalysis copy$default(MTIdCardRampAnalysis mTIdCardRampAnalysis, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Double d, Double d2, Double d3, Integer num10, Integer num11, Integer num12, Double d4, Double d5, Double d6, String str, String str2, int i, Object obj) {
        String str3;
        String str4;
        Integer num13 = (i & 1) != 0 ? mTIdCardRampAnalysis.manaRockCount : num;
        Integer num14 = (i & 2) != 0 ? mTIdCardRampAnalysis.manaDorkCount : num2;
        Integer num15 = (i & 4) != 0 ? mTIdCardRampAnalysis.cheapLandRampCount : num3;
        Integer num16 = (i & 8) != 0 ? mTIdCardRampAnalysis.costReducerCount : num4;
        Integer num17 = (i & 16) != 0 ? mTIdCardRampAnalysis.midRampCount : num5;
        Integer num18 = (i & 32) != 0 ? mTIdCardRampAnalysis.highRampCount : num6;
        Integer num19 = (i & 64) != 0 ? mTIdCardRampAnalysis.ritualCount : num7;
        Integer num20 = (i & 128) != 0 ? mTIdCardRampAnalysis.cheapRampCount : num8;
        Integer num21 = (i & 256) != 0 ? mTIdCardRampAnalysis.totalRampCount : num9;
        Double d7 = (i & 512) != 0 ? mTIdCardRampAnalysis.ritualBonus : d;
        Double d8 = (i & 1024) != 0 ? mTIdCardRampAnalysis.costReducerBonus : d2;
        Double d9 = (i & 2048) != 0 ? mTIdCardRampAnalysis.totalEffectiveRamp : d3;
        Integer num22 = (i & 4096) != 0 ? mTIdCardRampAnalysis.recommendedRamp : num10;
        Integer num23 = (i & 8192) != 0 ? mTIdCardRampAnalysis.commanderCmc : num11;
        Integer num24 = num13;
        Integer num25 = (i & 16384) != 0 ? mTIdCardRampAnalysis.commanderBaseline : num12;
        Double d10 = (i & 32768) != 0 ? mTIdCardRampAnalysis.commanderAdjustment : d4;
        Double d11 = (i & 65536) != 0 ? mTIdCardRampAnalysis.curveComponent : d5;
        Double d12 = (i & 131072) != 0 ? mTIdCardRampAnalysis.avgManaValue : d6;
        String str5 = (i & 262144) != 0 ? mTIdCardRampAnalysis.effectiveRampInfo : str;
        if ((i & 524288) != 0) {
            str4 = str5;
            str3 = mTIdCardRampAnalysis.effectiveRampInfoFr;
        } else {
            str3 = str2;
            str4 = str5;
        }
        return mTIdCardRampAnalysis.copy(num24, num14, num15, num16, num17, num18, num19, num20, num21, d7, d8, d9, num22, num23, num25, d10, d11, d12, str4, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getManaRockCount() {
        return this.manaRockCount;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Double getRitualBonus() {
        return this.ritualBonus;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Double getCostReducerBonus() {
        return this.costReducerBonus;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Double getTotalEffectiveRamp() {
        return this.totalEffectiveRamp;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getRecommendedRamp() {
        return this.recommendedRamp;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getCommanderCmc() {
        return this.commanderCmc;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getCommanderBaseline() {
        return this.commanderBaseline;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Double getCommanderAdjustment() {
        return this.commanderAdjustment;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Double getCurveComponent() {
        return this.curveComponent;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Double getAvgManaValue() {
        return this.avgManaValue;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getEffectiveRampInfo() {
        return this.effectiveRampInfo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getManaDorkCount() {
        return this.manaDorkCount;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getEffectiveRampInfoFr() {
        return this.effectiveRampInfoFr;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getCheapLandRampCount() {
        return this.cheapLandRampCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getCostReducerCount() {
        return this.costReducerCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getMidRampCount() {
        return this.midRampCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getHighRampCount() {
        return this.highRampCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getRitualCount() {
        return this.ritualCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getCheapRampCount() {
        return this.cheapRampCount;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getTotalRampCount() {
        return this.totalRampCount;
    }

    public final MTIdCardRampAnalysis copy(Integer manaRockCount, Integer manaDorkCount, Integer cheapLandRampCount, Integer costReducerCount, Integer midRampCount, Integer highRampCount, Integer ritualCount, Integer cheapRampCount, Integer totalRampCount, Double ritualBonus, Double costReducerBonus, Double totalEffectiveRamp, Integer recommendedRamp, Integer commanderCmc, Integer commanderBaseline, Double commanderAdjustment, Double curveComponent, Double avgManaValue, String effectiveRampInfo, String effectiveRampInfoFr) {
        return new MTIdCardRampAnalysis(manaRockCount, manaDorkCount, cheapLandRampCount, costReducerCount, midRampCount, highRampCount, ritualCount, cheapRampCount, totalRampCount, ritualBonus, costReducerBonus, totalEffectiveRamp, recommendedRamp, commanderCmc, commanderBaseline, commanderAdjustment, curveComponent, avgManaValue, effectiveRampInfo, effectiveRampInfoFr);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardRampAnalysis)) {
            return false;
        }
        MTIdCardRampAnalysis mTIdCardRampAnalysis = (MTIdCardRampAnalysis) other;
        return Intrinsics.areEqual(this.manaRockCount, mTIdCardRampAnalysis.manaRockCount) && Intrinsics.areEqual(this.manaDorkCount, mTIdCardRampAnalysis.manaDorkCount) && Intrinsics.areEqual(this.cheapLandRampCount, mTIdCardRampAnalysis.cheapLandRampCount) && Intrinsics.areEqual(this.costReducerCount, mTIdCardRampAnalysis.costReducerCount) && Intrinsics.areEqual(this.midRampCount, mTIdCardRampAnalysis.midRampCount) && Intrinsics.areEqual(this.highRampCount, mTIdCardRampAnalysis.highRampCount) && Intrinsics.areEqual(this.ritualCount, mTIdCardRampAnalysis.ritualCount) && Intrinsics.areEqual(this.cheapRampCount, mTIdCardRampAnalysis.cheapRampCount) && Intrinsics.areEqual(this.totalRampCount, mTIdCardRampAnalysis.totalRampCount) && Intrinsics.areEqual((Object) this.ritualBonus, (Object) mTIdCardRampAnalysis.ritualBonus) && Intrinsics.areEqual((Object) this.costReducerBonus, (Object) mTIdCardRampAnalysis.costReducerBonus) && Intrinsics.areEqual((Object) this.totalEffectiveRamp, (Object) mTIdCardRampAnalysis.totalEffectiveRamp) && Intrinsics.areEqual(this.recommendedRamp, mTIdCardRampAnalysis.recommendedRamp) && Intrinsics.areEqual(this.commanderCmc, mTIdCardRampAnalysis.commanderCmc) && Intrinsics.areEqual(this.commanderBaseline, mTIdCardRampAnalysis.commanderBaseline) && Intrinsics.areEqual((Object) this.commanderAdjustment, (Object) mTIdCardRampAnalysis.commanderAdjustment) && Intrinsics.areEqual((Object) this.curveComponent, (Object) mTIdCardRampAnalysis.curveComponent) && Intrinsics.areEqual((Object) this.avgManaValue, (Object) mTIdCardRampAnalysis.avgManaValue) && Intrinsics.areEqual(this.effectiveRampInfo, mTIdCardRampAnalysis.effectiveRampInfo) && Intrinsics.areEqual(this.effectiveRampInfoFr, mTIdCardRampAnalysis.effectiveRampInfoFr);
    }

    public final Double getAvgManaValue() {
        return this.avgManaValue;
    }

    public final Integer getCheapLandRampCount() {
        return this.cheapLandRampCount;
    }

    public final Integer getCheapRampCount() {
        return this.cheapRampCount;
    }

    public final Double getCommanderAdjustment() {
        return this.commanderAdjustment;
    }

    public final Integer getCommanderBaseline() {
        return this.commanderBaseline;
    }

    public final Integer getCommanderCmc() {
        return this.commanderCmc;
    }

    public final Double getCostReducerBonus() {
        return this.costReducerBonus;
    }

    public final Integer getCostReducerCount() {
        return this.costReducerCount;
    }

    public final Double getCurveComponent() {
        return this.curveComponent;
    }

    public final String getEffectiveRampInfo() {
        return this.effectiveRampInfo;
    }

    public final String getEffectiveRampInfoFr() {
        return this.effectiveRampInfoFr;
    }

    public final Integer getHighRampCount() {
        return this.highRampCount;
    }

    public final Integer getManaDorkCount() {
        return this.manaDorkCount;
    }

    public final Integer getManaRockCount() {
        return this.manaRockCount;
    }

    public final Integer getMidRampCount() {
        return this.midRampCount;
    }

    public final Integer getRecommendedRamp() {
        return this.recommendedRamp;
    }

    public final Double getRitualBonus() {
        return this.ritualBonus;
    }

    public final Integer getRitualCount() {
        return this.ritualCount;
    }

    public final Double getTotalEffectiveRamp() {
        return this.totalEffectiveRamp;
    }

    public final Integer getTotalRampCount() {
        return this.totalRampCount;
    }

    public int hashCode() {
        Integer num = this.manaRockCount;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.manaDorkCount;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.cheapLandRampCount;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.costReducerCount;
        int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.midRampCount;
        int iHashCode5 = (iHashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.highRampCount;
        int iHashCode6 = (iHashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.ritualCount;
        int iHashCode7 = (iHashCode6 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.cheapRampCount;
        int iHashCode8 = (iHashCode7 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.totalRampCount;
        int iHashCode9 = (iHashCode8 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Double d = this.ritualBonus;
        int iHashCode10 = (iHashCode9 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.costReducerBonus;
        int iHashCode11 = (iHashCode10 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.totalEffectiveRamp;
        int iHashCode12 = (iHashCode11 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Integer num10 = this.recommendedRamp;
        int iHashCode13 = (iHashCode12 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.commanderCmc;
        int iHashCode14 = (iHashCode13 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.commanderBaseline;
        int iHashCode15 = (iHashCode14 + (num12 == null ? 0 : num12.hashCode())) * 31;
        Double d4 = this.commanderAdjustment;
        int iHashCode16 = (iHashCode15 + (d4 == null ? 0 : d4.hashCode())) * 31;
        Double d5 = this.curveComponent;
        int iHashCode17 = (iHashCode16 + (d5 == null ? 0 : d5.hashCode())) * 31;
        Double d6 = this.avgManaValue;
        int iHashCode18 = (iHashCode17 + (d6 == null ? 0 : d6.hashCode())) * 31;
        String str = this.effectiveRampInfo;
        int iHashCode19 = (iHashCode18 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.effectiveRampInfoFr;
        return iHashCode19 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardRampAnalysis(manaRockCount=" + this.manaRockCount + ", manaDorkCount=" + this.manaDorkCount + ", cheapLandRampCount=" + this.cheapLandRampCount + ", costReducerCount=" + this.costReducerCount + ", midRampCount=" + this.midRampCount + ", highRampCount=" + this.highRampCount + ", ritualCount=" + this.ritualCount + ", cheapRampCount=" + this.cheapRampCount + ", totalRampCount=" + this.totalRampCount + ", ritualBonus=" + this.ritualBonus + ", costReducerBonus=" + this.costReducerBonus + ", totalEffectiveRamp=" + this.totalEffectiveRamp + ", recommendedRamp=" + this.recommendedRamp + ", commanderCmc=" + this.commanderCmc + ", commanderBaseline=" + this.commanderBaseline + ", commanderAdjustment=" + this.commanderAdjustment + ", curveComponent=" + this.curveComponent + ", avgManaValue=" + this.avgManaValue + ", effectiveRampInfo=" + this.effectiveRampInfo + ", effectiveRampInfoFr=" + this.effectiveRampInfoFr + ")";
    }
}
