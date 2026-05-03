package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019Jr\u0010%\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0006HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019¨\u0006-"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardLandDropAnalysis;", "", "perTurnProbabilities", "", "Lcom/studiolaganne/lengendarylens/MTIdCardLandDropTurnProb;", "startingLands", "", "landCount", "deckSize", "criticalTurn", "criticalTurnProb", "", "addOneLandCriticalProb", "addTwoLandsCriticalProb", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getPerTurnProbabilities", "()Ljava/util/List;", "getStartingLands", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLandCount", "getDeckSize", "getCriticalTurn", "getCriticalTurnProb", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAddOneLandCriticalProb", "getAddTwoLandsCriticalProb", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTIdCardLandDropAnalysis;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardLandDropAnalysis {
    public static final int $stable = 8;
    private final Double addOneLandCriticalProb;
    private final Double addTwoLandsCriticalProb;
    private final Integer criticalTurn;
    private final Double criticalTurnProb;
    private final Integer deckSize;
    private final Integer landCount;
    private final List<MTIdCardLandDropTurnProb> perTurnProbabilities;
    private final Integer startingLands;

    public MTIdCardLandDropAnalysis() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public MTIdCardLandDropAnalysis(List<MTIdCardLandDropTurnProb> perTurnProbabilities, Integer num, Integer num2, Integer num3, Integer num4, Double d, Double d2, Double d3) {
        Intrinsics.checkNotNullParameter(perTurnProbabilities, "perTurnProbabilities");
        this.perTurnProbabilities = perTurnProbabilities;
        this.startingLands = num;
        this.landCount = num2;
        this.deckSize = num3;
        this.criticalTurn = num4;
        this.criticalTurnProb = d;
        this.addOneLandCriticalProb = d2;
        this.addTwoLandsCriticalProb = d3;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTIdCardLandDropAnalysis(java.util.List r2, java.lang.Integer r3, java.lang.Integer r4, java.lang.Integer r5, java.lang.Integer r6, java.lang.Double r7, java.lang.Double r8, java.lang.Double r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r1 = this;
            r11 = r10 & 1
            if (r11 == 0) goto L8
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L8:
            r11 = r10 & 2
            r0 = 0
            if (r11 == 0) goto Le
            r3 = r0
        Le:
            r11 = r10 & 4
            if (r11 == 0) goto L13
            r4 = r0
        L13:
            r11 = r10 & 8
            if (r11 == 0) goto L18
            r5 = r0
        L18:
            r11 = r10 & 16
            if (r11 == 0) goto L1d
            r6 = r0
        L1d:
            r11 = r10 & 32
            if (r11 == 0) goto L22
            r7 = r0
        L22:
            r11 = r10 & 64
            if (r11 == 0) goto L27
            r8 = r0
        L27:
            r10 = r10 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L35
            r11 = r0
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L3e
        L35:
            r11 = r9
            r10 = r8
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L3e:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTIdCardLandDropAnalysis.<init>(java.util.List, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Double, java.lang.Double, java.lang.Double, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardLandDropAnalysis copy$default(MTIdCardLandDropAnalysis mTIdCardLandDropAnalysis, List list, Integer num, Integer num2, Integer num3, Integer num4, Double d, Double d2, Double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTIdCardLandDropAnalysis.perTurnProbabilities;
        }
        if ((i & 2) != 0) {
            num = mTIdCardLandDropAnalysis.startingLands;
        }
        if ((i & 4) != 0) {
            num2 = mTIdCardLandDropAnalysis.landCount;
        }
        if ((i & 8) != 0) {
            num3 = mTIdCardLandDropAnalysis.deckSize;
        }
        if ((i & 16) != 0) {
            num4 = mTIdCardLandDropAnalysis.criticalTurn;
        }
        if ((i & 32) != 0) {
            d = mTIdCardLandDropAnalysis.criticalTurnProb;
        }
        if ((i & 64) != 0) {
            d2 = mTIdCardLandDropAnalysis.addOneLandCriticalProb;
        }
        if ((i & 128) != 0) {
            d3 = mTIdCardLandDropAnalysis.addTwoLandsCriticalProb;
        }
        Double d4 = d2;
        Double d5 = d3;
        Integer num5 = num4;
        Double d6 = d;
        return mTIdCardLandDropAnalysis.copy(list, num, num2, num3, num5, d6, d4, d5);
    }

    public final List<MTIdCardLandDropTurnProb> component1() {
        return this.perTurnProbabilities;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getStartingLands() {
        return this.startingLands;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getLandCount() {
        return this.landCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getDeckSize() {
        return this.deckSize;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getCriticalTurn() {
        return this.criticalTurn;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Double getCriticalTurnProb() {
        return this.criticalTurnProb;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getAddOneLandCriticalProb() {
        return this.addOneLandCriticalProb;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Double getAddTwoLandsCriticalProb() {
        return this.addTwoLandsCriticalProb;
    }

    public final MTIdCardLandDropAnalysis copy(List<MTIdCardLandDropTurnProb> perTurnProbabilities, Integer startingLands, Integer landCount, Integer deckSize, Integer criticalTurn, Double criticalTurnProb, Double addOneLandCriticalProb, Double addTwoLandsCriticalProb) {
        Intrinsics.checkNotNullParameter(perTurnProbabilities, "perTurnProbabilities");
        return new MTIdCardLandDropAnalysis(perTurnProbabilities, startingLands, landCount, deckSize, criticalTurn, criticalTurnProb, addOneLandCriticalProb, addTwoLandsCriticalProb);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardLandDropAnalysis)) {
            return false;
        }
        MTIdCardLandDropAnalysis mTIdCardLandDropAnalysis = (MTIdCardLandDropAnalysis) other;
        return Intrinsics.areEqual(this.perTurnProbabilities, mTIdCardLandDropAnalysis.perTurnProbabilities) && Intrinsics.areEqual(this.startingLands, mTIdCardLandDropAnalysis.startingLands) && Intrinsics.areEqual(this.landCount, mTIdCardLandDropAnalysis.landCount) && Intrinsics.areEqual(this.deckSize, mTIdCardLandDropAnalysis.deckSize) && Intrinsics.areEqual(this.criticalTurn, mTIdCardLandDropAnalysis.criticalTurn) && Intrinsics.areEqual((Object) this.criticalTurnProb, (Object) mTIdCardLandDropAnalysis.criticalTurnProb) && Intrinsics.areEqual((Object) this.addOneLandCriticalProb, (Object) mTIdCardLandDropAnalysis.addOneLandCriticalProb) && Intrinsics.areEqual((Object) this.addTwoLandsCriticalProb, (Object) mTIdCardLandDropAnalysis.addTwoLandsCriticalProb);
    }

    public final Double getAddOneLandCriticalProb() {
        return this.addOneLandCriticalProb;
    }

    public final Double getAddTwoLandsCriticalProb() {
        return this.addTwoLandsCriticalProb;
    }

    public final Integer getCriticalTurn() {
        return this.criticalTurn;
    }

    public final Double getCriticalTurnProb() {
        return this.criticalTurnProb;
    }

    public final Integer getDeckSize() {
        return this.deckSize;
    }

    public final Integer getLandCount() {
        return this.landCount;
    }

    public final List<MTIdCardLandDropTurnProb> getPerTurnProbabilities() {
        return this.perTurnProbabilities;
    }

    public final Integer getStartingLands() {
        return this.startingLands;
    }

    public int hashCode() {
        int iHashCode = this.perTurnProbabilities.hashCode() * 31;
        Integer num = this.startingLands;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.landCount;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.deckSize;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.criticalTurn;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Double d = this.criticalTurnProb;
        int iHashCode6 = (iHashCode5 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.addOneLandCriticalProb;
        int iHashCode7 = (iHashCode6 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.addTwoLandsCriticalProb;
        return iHashCode7 + (d3 != null ? d3.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardLandDropAnalysis(perTurnProbabilities=" + this.perTurnProbabilities + ", startingLands=" + this.startingLands + ", landCount=" + this.landCount + ", deckSize=" + this.deckSize + ", criticalTurn=" + this.criticalTurn + ", criticalTurnProb=" + this.criticalTurnProb + ", addOneLandCriticalProb=" + this.addOneLandCriticalProb + ", addTwoLandsCriticalProb=" + this.addTwoLandsCriticalProb + ")";
    }
}
