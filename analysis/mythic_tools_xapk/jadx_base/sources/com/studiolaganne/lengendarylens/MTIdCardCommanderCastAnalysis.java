package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b8\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010?\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\u0017\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011HÆ\u0003J\u0017\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010G\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010H\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010I\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\u008e\u0002\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010P\u001a\u00020\u0006HÖ\u0001J\t\u0010Q\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b#\u0010!R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010(\u001a\u0004\b*\u0010'R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b,\u0010!R\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001f\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b0\u0010!R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010(\u001a\u0004\b3\u0010'R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b4\u0010!R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b5\u0010!R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b6\u0010!R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b7\u0010!¨\u0006R"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardCommanderCastAnalysis;", "", "commanderName", "", "commanderManaCost", "commanderCmc", "", "faceCmc", "costReduction", "Lcom/studiolaganne/lengendarylens/MTIdCardCostReduction;", "onCurveProb", "", "aheadOfCurveProb", "twoAheadOfCurveProb", "colorBottleneck", "colorBottleneckSources", "pipRequirements", "", "sourceCountsByColor", "iterations", "enablerNames", "", "avgCastTurn", "landCountInDeck", "rampCount", "minLandsFilter", "validIterations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTIdCardCostReduction;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCommanderName", "()Ljava/lang/String;", "getCommanderManaCost", "getCommanderCmc", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFaceCmc", "getCostReduction", "()Lcom/studiolaganne/lengendarylens/MTIdCardCostReduction;", "getOnCurveProb", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAheadOfCurveProb", "getTwoAheadOfCurveProb", "getColorBottleneck", "getColorBottleneckSources", "getPipRequirements", "()Ljava/util/Map;", "getSourceCountsByColor", "getIterations", "getEnablerNames", "()Ljava/util/List;", "getAvgCastTurn", "getLandCountInDeck", "getRampCount", "getMinLandsFilter", "getValidIterations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTIdCardCostReduction;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTIdCardCommanderCastAnalysis;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardCommanderCastAnalysis {
    public static final int $stable = 8;
    private final Double aheadOfCurveProb;
    private final Double avgCastTurn;
    private final String colorBottleneck;
    private final Integer colorBottleneckSources;
    private final Integer commanderCmc;
    private final String commanderManaCost;
    private final String commanderName;
    private final MTIdCardCostReduction costReduction;
    private final List<String> enablerNames;
    private final Integer faceCmc;
    private final Integer iterations;
    private final Integer landCountInDeck;
    private final Integer minLandsFilter;
    private final Double onCurveProb;
    private final Map<String, Integer> pipRequirements;
    private final Integer rampCount;
    private final Map<String, Integer> sourceCountsByColor;
    private final Double twoAheadOfCurveProb;
    private final Integer validIterations;

    public MTIdCardCommanderCastAnalysis() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    public MTIdCardCommanderCastAnalysis(String str, String str2, Integer num, Integer num2, MTIdCardCostReduction mTIdCardCostReduction, Double d, Double d2, Double d3, String str3, Integer num3, Map<String, Integer> map, Map<String, Integer> map2, Integer num4, List<String> enablerNames, Double d4, Integer num5, Integer num6, Integer num7, Integer num8) {
        Intrinsics.checkNotNullParameter(enablerNames, "enablerNames");
        this.commanderName = str;
        this.commanderManaCost = str2;
        this.commanderCmc = num;
        this.faceCmc = num2;
        this.costReduction = mTIdCardCostReduction;
        this.onCurveProb = d;
        this.aheadOfCurveProb = d2;
        this.twoAheadOfCurveProb = d3;
        this.colorBottleneck = str3;
        this.colorBottleneckSources = num3;
        this.pipRequirements = map;
        this.sourceCountsByColor = map2;
        this.iterations = num4;
        this.enablerNames = enablerNames;
        this.avgCastTurn = d4;
        this.landCountInDeck = num5;
        this.rampCount = num6;
        this.minLandsFilter = num7;
        this.validIterations = num8;
    }

    public /* synthetic */ MTIdCardCommanderCastAnalysis(String str, String str2, Integer num, Integer num2, MTIdCardCostReduction mTIdCardCostReduction, Double d, Double d2, Double d3, String str3, Integer num3, Map map, Map map2, Integer num4, List list, Double d4, Integer num5, Integer num6, Integer num7, Integer num8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : mTIdCardCostReduction, (i & 32) != 0 ? null : d, (i & 64) != 0 ? null : d2, (i & 128) != 0 ? null : d3, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : num3, (i & 1024) != 0 ? null : map, (i & 2048) != 0 ? null : map2, (i & 4096) != 0 ? null : num4, (i & 8192) != 0 ? CollectionsKt.emptyList() : list, (i & 16384) != 0 ? null : d4, (i & 32768) != 0 ? null : num5, (i & 65536) != 0 ? null : num6, (i & 131072) != 0 ? null : num7, (i & 262144) != 0 ? null : num8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardCommanderCastAnalysis copy$default(MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis, String str, String str2, Integer num, Integer num2, MTIdCardCostReduction mTIdCardCostReduction, Double d, Double d2, Double d3, String str3, Integer num3, Map map, Map map2, Integer num4, List list, Double d4, Integer num5, Integer num6, Integer num7, Integer num8, int i, Object obj) {
        Integer num9;
        Integer num10;
        String str4 = (i & 1) != 0 ? mTIdCardCommanderCastAnalysis.commanderName : str;
        String str5 = (i & 2) != 0 ? mTIdCardCommanderCastAnalysis.commanderManaCost : str2;
        Integer num11 = (i & 4) != 0 ? mTIdCardCommanderCastAnalysis.commanderCmc : num;
        Integer num12 = (i & 8) != 0 ? mTIdCardCommanderCastAnalysis.faceCmc : num2;
        MTIdCardCostReduction mTIdCardCostReduction2 = (i & 16) != 0 ? mTIdCardCommanderCastAnalysis.costReduction : mTIdCardCostReduction;
        Double d5 = (i & 32) != 0 ? mTIdCardCommanderCastAnalysis.onCurveProb : d;
        Double d6 = (i & 64) != 0 ? mTIdCardCommanderCastAnalysis.aheadOfCurveProb : d2;
        Double d7 = (i & 128) != 0 ? mTIdCardCommanderCastAnalysis.twoAheadOfCurveProb : d3;
        String str6 = (i & 256) != 0 ? mTIdCardCommanderCastAnalysis.colorBottleneck : str3;
        Integer num13 = (i & 512) != 0 ? mTIdCardCommanderCastAnalysis.colorBottleneckSources : num3;
        Map map3 = (i & 1024) != 0 ? mTIdCardCommanderCastAnalysis.pipRequirements : map;
        Map map4 = (i & 2048) != 0 ? mTIdCardCommanderCastAnalysis.sourceCountsByColor : map2;
        Integer num14 = (i & 4096) != 0 ? mTIdCardCommanderCastAnalysis.iterations : num4;
        List list2 = (i & 8192) != 0 ? mTIdCardCommanderCastAnalysis.enablerNames : list;
        String str7 = str4;
        Double d8 = (i & 16384) != 0 ? mTIdCardCommanderCastAnalysis.avgCastTurn : d4;
        Integer num15 = (i & 32768) != 0 ? mTIdCardCommanderCastAnalysis.landCountInDeck : num5;
        Integer num16 = (i & 65536) != 0 ? mTIdCardCommanderCastAnalysis.rampCount : num6;
        Integer num17 = (i & 131072) != 0 ? mTIdCardCommanderCastAnalysis.minLandsFilter : num7;
        if ((i & 262144) != 0) {
            num10 = num17;
            num9 = mTIdCardCommanderCastAnalysis.validIterations;
        } else {
            num9 = num8;
            num10 = num17;
        }
        return mTIdCardCommanderCastAnalysis.copy(str7, str5, num11, num12, mTIdCardCostReduction2, d5, d6, d7, str6, num13, map3, map4, num14, list2, d8, num15, num16, num10, num9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCommanderName() {
        return this.commanderName;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getColorBottleneckSources() {
        return this.colorBottleneckSources;
    }

    public final Map<String, Integer> component11() {
        return this.pipRequirements;
    }

    public final Map<String, Integer> component12() {
        return this.sourceCountsByColor;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getIterations() {
        return this.iterations;
    }

    public final List<String> component14() {
        return this.enablerNames;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Double getAvgCastTurn() {
        return this.avgCastTurn;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Integer getLandCountInDeck() {
        return this.landCountInDeck;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Integer getRampCount() {
        return this.rampCount;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Integer getMinLandsFilter() {
        return this.minLandsFilter;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Integer getValidIterations() {
        return this.validIterations;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCommanderManaCost() {
        return this.commanderManaCost;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getCommanderCmc() {
        return this.commanderCmc;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getFaceCmc() {
        return this.faceCmc;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTIdCardCostReduction getCostReduction() {
        return this.costReduction;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Double getOnCurveProb() {
        return this.onCurveProb;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getAheadOfCurveProb() {
        return this.aheadOfCurveProb;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Double getTwoAheadOfCurveProb() {
        return this.twoAheadOfCurveProb;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getColorBottleneck() {
        return this.colorBottleneck;
    }

    public final MTIdCardCommanderCastAnalysis copy(String commanderName, String commanderManaCost, Integer commanderCmc, Integer faceCmc, MTIdCardCostReduction costReduction, Double onCurveProb, Double aheadOfCurveProb, Double twoAheadOfCurveProb, String colorBottleneck, Integer colorBottleneckSources, Map<String, Integer> pipRequirements, Map<String, Integer> sourceCountsByColor, Integer iterations, List<String> enablerNames, Double avgCastTurn, Integer landCountInDeck, Integer rampCount, Integer minLandsFilter, Integer validIterations) {
        Intrinsics.checkNotNullParameter(enablerNames, "enablerNames");
        return new MTIdCardCommanderCastAnalysis(commanderName, commanderManaCost, commanderCmc, faceCmc, costReduction, onCurveProb, aheadOfCurveProb, twoAheadOfCurveProb, colorBottleneck, colorBottleneckSources, pipRequirements, sourceCountsByColor, iterations, enablerNames, avgCastTurn, landCountInDeck, rampCount, minLandsFilter, validIterations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardCommanderCastAnalysis)) {
            return false;
        }
        MTIdCardCommanderCastAnalysis mTIdCardCommanderCastAnalysis = (MTIdCardCommanderCastAnalysis) other;
        return Intrinsics.areEqual(this.commanderName, mTIdCardCommanderCastAnalysis.commanderName) && Intrinsics.areEqual(this.commanderManaCost, mTIdCardCommanderCastAnalysis.commanderManaCost) && Intrinsics.areEqual(this.commanderCmc, mTIdCardCommanderCastAnalysis.commanderCmc) && Intrinsics.areEqual(this.faceCmc, mTIdCardCommanderCastAnalysis.faceCmc) && Intrinsics.areEqual(this.costReduction, mTIdCardCommanderCastAnalysis.costReduction) && Intrinsics.areEqual((Object) this.onCurveProb, (Object) mTIdCardCommanderCastAnalysis.onCurveProb) && Intrinsics.areEqual((Object) this.aheadOfCurveProb, (Object) mTIdCardCommanderCastAnalysis.aheadOfCurveProb) && Intrinsics.areEqual((Object) this.twoAheadOfCurveProb, (Object) mTIdCardCommanderCastAnalysis.twoAheadOfCurveProb) && Intrinsics.areEqual(this.colorBottleneck, mTIdCardCommanderCastAnalysis.colorBottleneck) && Intrinsics.areEqual(this.colorBottleneckSources, mTIdCardCommanderCastAnalysis.colorBottleneckSources) && Intrinsics.areEqual(this.pipRequirements, mTIdCardCommanderCastAnalysis.pipRequirements) && Intrinsics.areEqual(this.sourceCountsByColor, mTIdCardCommanderCastAnalysis.sourceCountsByColor) && Intrinsics.areEqual(this.iterations, mTIdCardCommanderCastAnalysis.iterations) && Intrinsics.areEqual(this.enablerNames, mTIdCardCommanderCastAnalysis.enablerNames) && Intrinsics.areEqual((Object) this.avgCastTurn, (Object) mTIdCardCommanderCastAnalysis.avgCastTurn) && Intrinsics.areEqual(this.landCountInDeck, mTIdCardCommanderCastAnalysis.landCountInDeck) && Intrinsics.areEqual(this.rampCount, mTIdCardCommanderCastAnalysis.rampCount) && Intrinsics.areEqual(this.minLandsFilter, mTIdCardCommanderCastAnalysis.minLandsFilter) && Intrinsics.areEqual(this.validIterations, mTIdCardCommanderCastAnalysis.validIterations);
    }

    public final Double getAheadOfCurveProb() {
        return this.aheadOfCurveProb;
    }

    public final Double getAvgCastTurn() {
        return this.avgCastTurn;
    }

    public final String getColorBottleneck() {
        return this.colorBottleneck;
    }

    public final Integer getColorBottleneckSources() {
        return this.colorBottleneckSources;
    }

    public final Integer getCommanderCmc() {
        return this.commanderCmc;
    }

    public final String getCommanderManaCost() {
        return this.commanderManaCost;
    }

    public final String getCommanderName() {
        return this.commanderName;
    }

    public final MTIdCardCostReduction getCostReduction() {
        return this.costReduction;
    }

    public final List<String> getEnablerNames() {
        return this.enablerNames;
    }

    public final Integer getFaceCmc() {
        return this.faceCmc;
    }

    public final Integer getIterations() {
        return this.iterations;
    }

    public final Integer getLandCountInDeck() {
        return this.landCountInDeck;
    }

    public final Integer getMinLandsFilter() {
        return this.minLandsFilter;
    }

    public final Double getOnCurveProb() {
        return this.onCurveProb;
    }

    public final Map<String, Integer> getPipRequirements() {
        return this.pipRequirements;
    }

    public final Integer getRampCount() {
        return this.rampCount;
    }

    public final Map<String, Integer> getSourceCountsByColor() {
        return this.sourceCountsByColor;
    }

    public final Double getTwoAheadOfCurveProb() {
        return this.twoAheadOfCurveProb;
    }

    public final Integer getValidIterations() {
        return this.validIterations;
    }

    public int hashCode() {
        String str = this.commanderName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.commanderManaCost;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.commanderCmc;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.faceCmc;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        MTIdCardCostReduction mTIdCardCostReduction = this.costReduction;
        int iHashCode5 = (iHashCode4 + (mTIdCardCostReduction == null ? 0 : mTIdCardCostReduction.hashCode())) * 31;
        Double d = this.onCurveProb;
        int iHashCode6 = (iHashCode5 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.aheadOfCurveProb;
        int iHashCode7 = (iHashCode6 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.twoAheadOfCurveProb;
        int iHashCode8 = (iHashCode7 + (d3 == null ? 0 : d3.hashCode())) * 31;
        String str3 = this.colorBottleneck;
        int iHashCode9 = (iHashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num3 = this.colorBottleneckSources;
        int iHashCode10 = (iHashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Map<String, Integer> map = this.pipRequirements;
        int iHashCode11 = (iHashCode10 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, Integer> map2 = this.sourceCountsByColor;
        int iHashCode12 = (iHashCode11 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Integer num4 = this.iterations;
        int iHashCode13 = (((iHashCode12 + (num4 == null ? 0 : num4.hashCode())) * 31) + this.enablerNames.hashCode()) * 31;
        Double d4 = this.avgCastTurn;
        int iHashCode14 = (iHashCode13 + (d4 == null ? 0 : d4.hashCode())) * 31;
        Integer num5 = this.landCountInDeck;
        int iHashCode15 = (iHashCode14 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.rampCount;
        int iHashCode16 = (iHashCode15 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.minLandsFilter;
        int iHashCode17 = (iHashCode16 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.validIterations;
        return iHashCode17 + (num8 != null ? num8.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardCommanderCastAnalysis(commanderName=" + this.commanderName + ", commanderManaCost=" + this.commanderManaCost + ", commanderCmc=" + this.commanderCmc + ", faceCmc=" + this.faceCmc + ", costReduction=" + this.costReduction + ", onCurveProb=" + this.onCurveProb + ", aheadOfCurveProb=" + this.aheadOfCurveProb + ", twoAheadOfCurveProb=" + this.twoAheadOfCurveProb + ", colorBottleneck=" + this.colorBottleneck + ", colorBottleneckSources=" + this.colorBottleneckSources + ", pipRequirements=" + this.pipRequirements + ", sourceCountsByColor=" + this.sourceCountsByColor + ", iterations=" + this.iterations + ", enablerNames=" + this.enablerNames + ", avgCastTurn=" + this.avgCastTurn + ", landCountInDeck=" + this.landCountInDeck + ", rampCount=" + this.rampCount + ", minLandsFilter=" + this.minLandsFilter + ", validIterations=" + this.validIterations + ")";
    }
}
