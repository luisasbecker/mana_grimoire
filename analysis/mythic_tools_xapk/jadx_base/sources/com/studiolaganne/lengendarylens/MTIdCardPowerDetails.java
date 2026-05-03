package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010-\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010$Jv\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0010HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$¨\u00064"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardPowerDetails;", "", "dominantTier", "", "tierAffinities", "", "Lcom/studiolaganne/lengendarylens/MTIdCardTierAffinity;", "signalWeights", "Lcom/studiolaganne/lengendarylens/MTIdCardPowerSignalWeights;", "structuralBreakdown", "Lcom/studiolaganne/lengendarylens/MTIdCardStructuralMetric;", "cardPowerCoverage", "Lcom/studiolaganne/lengendarylens/MTIdCardCardPowerCoverage;", "commanderTierData", "Lcom/studiolaganne/lengendarylens/MTIdCardCommanderTierData;", "rawScore", "", "calibrated", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTIdCardPowerSignalWeights;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTIdCardCardPowerCoverage;Lcom/studiolaganne/lengendarylens/MTIdCardCommanderTierData;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getDominantTier", "()Ljava/lang/String;", "getTierAffinities", "()Ljava/util/List;", "getSignalWeights", "()Lcom/studiolaganne/lengendarylens/MTIdCardPowerSignalWeights;", "getStructuralBreakdown", "getCardPowerCoverage", "()Lcom/studiolaganne/lengendarylens/MTIdCardCardPowerCoverage;", "getCommanderTierData", "()Lcom/studiolaganne/lengendarylens/MTIdCardCommanderTierData;", "getRawScore", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCalibrated", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTIdCardPowerSignalWeights;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTIdCardCardPowerCoverage;Lcom/studiolaganne/lengendarylens/MTIdCardCommanderTierData;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTIdCardPowerDetails;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardPowerDetails {
    public static final int $stable = 8;
    private final Boolean calibrated;
    private final MTIdCardCardPowerCoverage cardPowerCoverage;
    private final MTIdCardCommanderTierData commanderTierData;
    private final String dominantTier;
    private final Integer rawScore;
    private final MTIdCardPowerSignalWeights signalWeights;
    private final List<MTIdCardStructuralMetric> structuralBreakdown;
    private final List<MTIdCardTierAffinity> tierAffinities;

    public MTIdCardPowerDetails() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public MTIdCardPowerDetails(String str, List<MTIdCardTierAffinity> tierAffinities, MTIdCardPowerSignalWeights mTIdCardPowerSignalWeights, List<MTIdCardStructuralMetric> structuralBreakdown, MTIdCardCardPowerCoverage mTIdCardCardPowerCoverage, MTIdCardCommanderTierData mTIdCardCommanderTierData, Integer num, Boolean bool) {
        Intrinsics.checkNotNullParameter(tierAffinities, "tierAffinities");
        Intrinsics.checkNotNullParameter(structuralBreakdown, "structuralBreakdown");
        this.dominantTier = str;
        this.tierAffinities = tierAffinities;
        this.signalWeights = mTIdCardPowerSignalWeights;
        this.structuralBreakdown = structuralBreakdown;
        this.cardPowerCoverage = mTIdCardCardPowerCoverage;
        this.commanderTierData = mTIdCardCommanderTierData;
        this.rawScore = num;
        this.calibrated = bool;
    }

    public /* synthetic */ MTIdCardPowerDetails(String str, List list, MTIdCardPowerSignalWeights mTIdCardPowerSignalWeights, List list2, MTIdCardCardPowerCoverage mTIdCardCardPowerCoverage, MTIdCardCommanderTierData mTIdCardCommanderTierData, Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : mTIdCardPowerSignalWeights, (i & 8) != 0 ? CollectionsKt.emptyList() : list2, (i & 16) != 0 ? null : mTIdCardCardPowerCoverage, (i & 32) != 0 ? null : mTIdCardCommanderTierData, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardPowerDetails copy$default(MTIdCardPowerDetails mTIdCardPowerDetails, String str, List list, MTIdCardPowerSignalWeights mTIdCardPowerSignalWeights, List list2, MTIdCardCardPowerCoverage mTIdCardCardPowerCoverage, MTIdCardCommanderTierData mTIdCardCommanderTierData, Integer num, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardPowerDetails.dominantTier;
        }
        if ((i & 2) != 0) {
            list = mTIdCardPowerDetails.tierAffinities;
        }
        if ((i & 4) != 0) {
            mTIdCardPowerSignalWeights = mTIdCardPowerDetails.signalWeights;
        }
        if ((i & 8) != 0) {
            list2 = mTIdCardPowerDetails.structuralBreakdown;
        }
        if ((i & 16) != 0) {
            mTIdCardCardPowerCoverage = mTIdCardPowerDetails.cardPowerCoverage;
        }
        if ((i & 32) != 0) {
            mTIdCardCommanderTierData = mTIdCardPowerDetails.commanderTierData;
        }
        if ((i & 64) != 0) {
            num = mTIdCardPowerDetails.rawScore;
        }
        if ((i & 128) != 0) {
            bool = mTIdCardPowerDetails.calibrated;
        }
        Integer num2 = num;
        Boolean bool2 = bool;
        MTIdCardCardPowerCoverage mTIdCardCardPowerCoverage2 = mTIdCardCardPowerCoverage;
        MTIdCardCommanderTierData mTIdCardCommanderTierData2 = mTIdCardCommanderTierData;
        return mTIdCardPowerDetails.copy(str, list, mTIdCardPowerSignalWeights, list2, mTIdCardCardPowerCoverage2, mTIdCardCommanderTierData2, num2, bool2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDominantTier() {
        return this.dominantTier;
    }

    public final List<MTIdCardTierAffinity> component2() {
        return this.tierAffinities;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTIdCardPowerSignalWeights getSignalWeights() {
        return this.signalWeights;
    }

    public final List<MTIdCardStructuralMetric> component4() {
        return this.structuralBreakdown;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTIdCardCardPowerCoverage getCardPowerCoverage() {
        return this.cardPowerCoverage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTIdCardCommanderTierData getCommanderTierData() {
        return this.commanderTierData;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getRawScore() {
        return this.rawScore;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getCalibrated() {
        return this.calibrated;
    }

    public final MTIdCardPowerDetails copy(String dominantTier, List<MTIdCardTierAffinity> tierAffinities, MTIdCardPowerSignalWeights signalWeights, List<MTIdCardStructuralMetric> structuralBreakdown, MTIdCardCardPowerCoverage cardPowerCoverage, MTIdCardCommanderTierData commanderTierData, Integer rawScore, Boolean calibrated) {
        Intrinsics.checkNotNullParameter(tierAffinities, "tierAffinities");
        Intrinsics.checkNotNullParameter(structuralBreakdown, "structuralBreakdown");
        return new MTIdCardPowerDetails(dominantTier, tierAffinities, signalWeights, structuralBreakdown, cardPowerCoverage, commanderTierData, rawScore, calibrated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardPowerDetails)) {
            return false;
        }
        MTIdCardPowerDetails mTIdCardPowerDetails = (MTIdCardPowerDetails) other;
        return Intrinsics.areEqual(this.dominantTier, mTIdCardPowerDetails.dominantTier) && Intrinsics.areEqual(this.tierAffinities, mTIdCardPowerDetails.tierAffinities) && Intrinsics.areEqual(this.signalWeights, mTIdCardPowerDetails.signalWeights) && Intrinsics.areEqual(this.structuralBreakdown, mTIdCardPowerDetails.structuralBreakdown) && Intrinsics.areEqual(this.cardPowerCoverage, mTIdCardPowerDetails.cardPowerCoverage) && Intrinsics.areEqual(this.commanderTierData, mTIdCardPowerDetails.commanderTierData) && Intrinsics.areEqual(this.rawScore, mTIdCardPowerDetails.rawScore) && Intrinsics.areEqual(this.calibrated, mTIdCardPowerDetails.calibrated);
    }

    public final Boolean getCalibrated() {
        return this.calibrated;
    }

    public final MTIdCardCardPowerCoverage getCardPowerCoverage() {
        return this.cardPowerCoverage;
    }

    public final MTIdCardCommanderTierData getCommanderTierData() {
        return this.commanderTierData;
    }

    public final String getDominantTier() {
        return this.dominantTier;
    }

    public final Integer getRawScore() {
        return this.rawScore;
    }

    public final MTIdCardPowerSignalWeights getSignalWeights() {
        return this.signalWeights;
    }

    public final List<MTIdCardStructuralMetric> getStructuralBreakdown() {
        return this.structuralBreakdown;
    }

    public final List<MTIdCardTierAffinity> getTierAffinities() {
        return this.tierAffinities;
    }

    public int hashCode() {
        String str = this.dominantTier;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.tierAffinities.hashCode()) * 31;
        MTIdCardPowerSignalWeights mTIdCardPowerSignalWeights = this.signalWeights;
        int iHashCode2 = (((iHashCode + (mTIdCardPowerSignalWeights == null ? 0 : mTIdCardPowerSignalWeights.hashCode())) * 31) + this.structuralBreakdown.hashCode()) * 31;
        MTIdCardCardPowerCoverage mTIdCardCardPowerCoverage = this.cardPowerCoverage;
        int iHashCode3 = (iHashCode2 + (mTIdCardCardPowerCoverage == null ? 0 : mTIdCardCardPowerCoverage.hashCode())) * 31;
        MTIdCardCommanderTierData mTIdCardCommanderTierData = this.commanderTierData;
        int iHashCode4 = (iHashCode3 + (mTIdCardCommanderTierData == null ? 0 : mTIdCardCommanderTierData.hashCode())) * 31;
        Integer num = this.rawScore;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.calibrated;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardPowerDetails(dominantTier=" + this.dominantTier + ", tierAffinities=" + this.tierAffinities + ", signalWeights=" + this.signalWeights + ", structuralBreakdown=" + this.structuralBreakdown + ", cardPowerCoverage=" + this.cardPowerCoverage + ", commanderTierData=" + this.commanderTierData + ", rawScore=" + this.rawScore + ", calibrated=" + this.calibrated + ")";
    }
}
