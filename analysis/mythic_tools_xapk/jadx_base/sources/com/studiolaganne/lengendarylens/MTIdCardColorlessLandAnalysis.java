package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JN\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\nHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardColorlessLandAnalysis;", "", "colorlessCount", "", "totalLands", "colorlessPercent", "", "deckColorCount", "colorlessLandNames", "", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/util/List;)V", "getColorlessCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalLands", "getColorlessPercent", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDeckColorCount", "getColorlessLandNames", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardColorlessLandAnalysis;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardColorlessLandAnalysis {
    public static final int $stable = 8;
    private final Integer colorlessCount;
    private final List<String> colorlessLandNames;
    private final Double colorlessPercent;
    private final Integer deckColorCount;
    private final Integer totalLands;

    public MTIdCardColorlessLandAnalysis() {
        this(null, null, null, null, null, 31, null);
    }

    public MTIdCardColorlessLandAnalysis(Integer num, Integer num2, Double d, Integer num3, List<String> colorlessLandNames) {
        Intrinsics.checkNotNullParameter(colorlessLandNames, "colorlessLandNames");
        this.colorlessCount = num;
        this.totalLands = num2;
        this.colorlessPercent = d;
        this.deckColorCount = num3;
        this.colorlessLandNames = colorlessLandNames;
    }

    public /* synthetic */ MTIdCardColorlessLandAnalysis(Integer num, Integer num2, Double d, Integer num3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardColorlessLandAnalysis copy$default(MTIdCardColorlessLandAnalysis mTIdCardColorlessLandAnalysis, Integer num, Integer num2, Double d, Integer num3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardColorlessLandAnalysis.colorlessCount;
        }
        if ((i & 2) != 0) {
            num2 = mTIdCardColorlessLandAnalysis.totalLands;
        }
        if ((i & 4) != 0) {
            d = mTIdCardColorlessLandAnalysis.colorlessPercent;
        }
        if ((i & 8) != 0) {
            num3 = mTIdCardColorlessLandAnalysis.deckColorCount;
        }
        if ((i & 16) != 0) {
            list = mTIdCardColorlessLandAnalysis.colorlessLandNames;
        }
        List list2 = list;
        Double d2 = d;
        return mTIdCardColorlessLandAnalysis.copy(num, num2, d2, num3, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getColorlessCount() {
        return this.colorlessCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getTotalLands() {
        return this.totalLands;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getColorlessPercent() {
        return this.colorlessPercent;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getDeckColorCount() {
        return this.deckColorCount;
    }

    public final List<String> component5() {
        return this.colorlessLandNames;
    }

    public final MTIdCardColorlessLandAnalysis copy(Integer colorlessCount, Integer totalLands, Double colorlessPercent, Integer deckColorCount, List<String> colorlessLandNames) {
        Intrinsics.checkNotNullParameter(colorlessLandNames, "colorlessLandNames");
        return new MTIdCardColorlessLandAnalysis(colorlessCount, totalLands, colorlessPercent, deckColorCount, colorlessLandNames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardColorlessLandAnalysis)) {
            return false;
        }
        MTIdCardColorlessLandAnalysis mTIdCardColorlessLandAnalysis = (MTIdCardColorlessLandAnalysis) other;
        return Intrinsics.areEqual(this.colorlessCount, mTIdCardColorlessLandAnalysis.colorlessCount) && Intrinsics.areEqual(this.totalLands, mTIdCardColorlessLandAnalysis.totalLands) && Intrinsics.areEqual((Object) this.colorlessPercent, (Object) mTIdCardColorlessLandAnalysis.colorlessPercent) && Intrinsics.areEqual(this.deckColorCount, mTIdCardColorlessLandAnalysis.deckColorCount) && Intrinsics.areEqual(this.colorlessLandNames, mTIdCardColorlessLandAnalysis.colorlessLandNames);
    }

    public final Integer getColorlessCount() {
        return this.colorlessCount;
    }

    public final List<String> getColorlessLandNames() {
        return this.colorlessLandNames;
    }

    public final Double getColorlessPercent() {
        return this.colorlessPercent;
    }

    public final Integer getDeckColorCount() {
        return this.deckColorCount;
    }

    public final Integer getTotalLands() {
        return this.totalLands;
    }

    public int hashCode() {
        Integer num = this.colorlessCount;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.totalLands;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d = this.colorlessPercent;
        int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Integer num3 = this.deckColorCount;
        return ((iHashCode3 + (num3 != null ? num3.hashCode() : 0)) * 31) + this.colorlessLandNames.hashCode();
    }

    public String toString() {
        return "MTIdCardColorlessLandAnalysis(colorlessCount=" + this.colorlessCount + ", totalLands=" + this.totalLands + ", colorlessPercent=" + this.colorlessPercent + ", deckColorCount=" + this.deckColorCount + ", colorlessLandNames=" + this.colorlessLandNames + ")";
    }
}
