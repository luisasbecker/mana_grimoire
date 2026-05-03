package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JR\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandAnalysis;", "", "probabilities", "", "Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandProb;", "idealRange", "", "healthyProb", "", "afterMulliganProb", "addOneLandImprovement", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getProbabilities", "()Ljava/util/List;", "getIdealRange", "getHealthyProb", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAfterMulliganProb", "getAddOneLandImprovement", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandAnalysis;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardOpeningHandAnalysis {
    public static final int $stable = 8;
    private final Double addOneLandImprovement;
    private final Double afterMulliganProb;
    private final Double healthyProb;
    private final List<Integer> idealRange;
    private final List<MTIdCardOpeningHandProb> probabilities;

    public MTIdCardOpeningHandAnalysis() {
        this(null, null, null, null, null, 31, null);
    }

    public MTIdCardOpeningHandAnalysis(List<MTIdCardOpeningHandProb> probabilities, List<Integer> idealRange, Double d, Double d2, Double d3) {
        Intrinsics.checkNotNullParameter(probabilities, "probabilities");
        Intrinsics.checkNotNullParameter(idealRange, "idealRange");
        this.probabilities = probabilities;
        this.idealRange = idealRange;
        this.healthyProb = d;
        this.afterMulliganProb = d2;
        this.addOneLandImprovement = d3;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTIdCardOpeningHandAnalysis(java.util.List r2, java.util.List r3, java.lang.Double r4, java.lang.Double r5, java.lang.Double r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L8
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L8:
            r8 = r7 & 2
            if (r8 == 0) goto L10
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        L10:
            r8 = r7 & 4
            r0 = 0
            if (r8 == 0) goto L16
            r4 = r0
        L16:
            r8 = r7 & 8
            if (r8 == 0) goto L1b
            r5 = r0
        L1b:
            r7 = r7 & 16
            if (r7 == 0) goto L26
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L2c
        L26:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L2c:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTIdCardOpeningHandAnalysis.<init>(java.util.List, java.util.List, java.lang.Double, java.lang.Double, java.lang.Double, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardOpeningHandAnalysis copy$default(MTIdCardOpeningHandAnalysis mTIdCardOpeningHandAnalysis, List list, List list2, Double d, Double d2, Double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTIdCardOpeningHandAnalysis.probabilities;
        }
        if ((i & 2) != 0) {
            list2 = mTIdCardOpeningHandAnalysis.idealRange;
        }
        if ((i & 4) != 0) {
            d = mTIdCardOpeningHandAnalysis.healthyProb;
        }
        if ((i & 8) != 0) {
            d2 = mTIdCardOpeningHandAnalysis.afterMulliganProb;
        }
        if ((i & 16) != 0) {
            d3 = mTIdCardOpeningHandAnalysis.addOneLandImprovement;
        }
        Double d4 = d3;
        Double d5 = d;
        return mTIdCardOpeningHandAnalysis.copy(list, list2, d5, d2, d4);
    }

    public final List<MTIdCardOpeningHandProb> component1() {
        return this.probabilities;
    }

    public final List<Integer> component2() {
        return this.idealRange;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getHealthyProb() {
        return this.healthyProb;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getAfterMulliganProb() {
        return this.afterMulliganProb;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getAddOneLandImprovement() {
        return this.addOneLandImprovement;
    }

    public final MTIdCardOpeningHandAnalysis copy(List<MTIdCardOpeningHandProb> probabilities, List<Integer> idealRange, Double healthyProb, Double afterMulliganProb, Double addOneLandImprovement) {
        Intrinsics.checkNotNullParameter(probabilities, "probabilities");
        Intrinsics.checkNotNullParameter(idealRange, "idealRange");
        return new MTIdCardOpeningHandAnalysis(probabilities, idealRange, healthyProb, afterMulliganProb, addOneLandImprovement);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardOpeningHandAnalysis)) {
            return false;
        }
        MTIdCardOpeningHandAnalysis mTIdCardOpeningHandAnalysis = (MTIdCardOpeningHandAnalysis) other;
        return Intrinsics.areEqual(this.probabilities, mTIdCardOpeningHandAnalysis.probabilities) && Intrinsics.areEqual(this.idealRange, mTIdCardOpeningHandAnalysis.idealRange) && Intrinsics.areEqual((Object) this.healthyProb, (Object) mTIdCardOpeningHandAnalysis.healthyProb) && Intrinsics.areEqual((Object) this.afterMulliganProb, (Object) mTIdCardOpeningHandAnalysis.afterMulliganProb) && Intrinsics.areEqual((Object) this.addOneLandImprovement, (Object) mTIdCardOpeningHandAnalysis.addOneLandImprovement);
    }

    public final Double getAddOneLandImprovement() {
        return this.addOneLandImprovement;
    }

    public final Double getAfterMulliganProb() {
        return this.afterMulliganProb;
    }

    public final Double getHealthyProb() {
        return this.healthyProb;
    }

    public final List<Integer> getIdealRange() {
        return this.idealRange;
    }

    public final List<MTIdCardOpeningHandProb> getProbabilities() {
        return this.probabilities;
    }

    public int hashCode() {
        int iHashCode = ((this.probabilities.hashCode() * 31) + this.idealRange.hashCode()) * 31;
        Double d = this.healthyProb;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.afterMulliganProb;
        int iHashCode3 = (iHashCode2 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.addOneLandImprovement;
        return iHashCode3 + (d3 != null ? d3.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardOpeningHandAnalysis(probabilities=" + this.probabilities + ", idealRange=" + this.idealRange + ", healthyProb=" + this.healthyProb + ", afterMulliganProb=" + this.afterMulliganProb + ", addOneLandImprovement=" + this.addOneLandImprovement + ")";
    }
}
