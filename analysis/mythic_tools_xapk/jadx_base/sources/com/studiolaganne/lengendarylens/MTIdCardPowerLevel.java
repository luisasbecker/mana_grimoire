package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u000eHÆ\u0003Jf\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\fHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006."}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardPowerLevel;", "", FirebaseAnalytics.Param.SCORE, "", "signals", "Lcom/studiolaganne/lengendarylens/MTIdCardPowerSignals;", "commanderTier", "", "details", "Lcom/studiolaganne/lengendarylens/MTIdCardPowerDetails;", "bracket", "confidence", "", "reasons", "", "<init>", "(Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTIdCardPowerSignals;Ljava/lang/Double;Lcom/studiolaganne/lengendarylens/MTIdCardPowerDetails;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getScore", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSignals", "()Lcom/studiolaganne/lengendarylens/MTIdCardPowerSignals;", "getCommanderTier", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDetails", "()Lcom/studiolaganne/lengendarylens/MTIdCardPowerDetails;", "getBracket", "getConfidence", "()Ljava/lang/String;", "getReasons", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTIdCardPowerSignals;Ljava/lang/Double;Lcom/studiolaganne/lengendarylens/MTIdCardPowerDetails;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardPowerLevel;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardPowerLevel {
    public static final int $stable = 8;
    private final Integer bracket;
    private final Double commanderTier;
    private final String confidence;
    private final MTIdCardPowerDetails details;
    private final List<String> reasons;
    private final Integer score;
    private final MTIdCardPowerSignals signals;

    public MTIdCardPowerLevel() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public MTIdCardPowerLevel(Integer num, MTIdCardPowerSignals mTIdCardPowerSignals, Double d, MTIdCardPowerDetails mTIdCardPowerDetails, Integer num2, String str, List<String> reasons) {
        Intrinsics.checkNotNullParameter(reasons, "reasons");
        this.score = num;
        this.signals = mTIdCardPowerSignals;
        this.commanderTier = d;
        this.details = mTIdCardPowerDetails;
        this.bracket = num2;
        this.confidence = str;
        this.reasons = reasons;
    }

    public /* synthetic */ MTIdCardPowerLevel(Integer num, MTIdCardPowerSignals mTIdCardPowerSignals, Double d, MTIdCardPowerDetails mTIdCardPowerDetails, Integer num2, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : mTIdCardPowerSignals, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : mTIdCardPowerDetails, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : str, (i & 64) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardPowerLevel copy$default(MTIdCardPowerLevel mTIdCardPowerLevel, Integer num, MTIdCardPowerSignals mTIdCardPowerSignals, Double d, MTIdCardPowerDetails mTIdCardPowerDetails, Integer num2, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardPowerLevel.score;
        }
        if ((i & 2) != 0) {
            mTIdCardPowerSignals = mTIdCardPowerLevel.signals;
        }
        if ((i & 4) != 0) {
            d = mTIdCardPowerLevel.commanderTier;
        }
        if ((i & 8) != 0) {
            mTIdCardPowerDetails = mTIdCardPowerLevel.details;
        }
        if ((i & 16) != 0) {
            num2 = mTIdCardPowerLevel.bracket;
        }
        if ((i & 32) != 0) {
            str = mTIdCardPowerLevel.confidence;
        }
        if ((i & 64) != 0) {
            list = mTIdCardPowerLevel.reasons;
        }
        String str2 = str;
        List list2 = list;
        Integer num3 = num2;
        Double d2 = d;
        return mTIdCardPowerLevel.copy(num, mTIdCardPowerSignals, d2, mTIdCardPowerDetails, num3, str2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTIdCardPowerSignals getSignals() {
        return this.signals;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getCommanderTier() {
        return this.commanderTier;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTIdCardPowerDetails getDetails() {
        return this.details;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getBracket() {
        return this.bracket;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getConfidence() {
        return this.confidence;
    }

    public final List<String> component7() {
        return this.reasons;
    }

    public final MTIdCardPowerLevel copy(Integer score, MTIdCardPowerSignals signals, Double commanderTier, MTIdCardPowerDetails details, Integer bracket, String confidence, List<String> reasons) {
        Intrinsics.checkNotNullParameter(reasons, "reasons");
        return new MTIdCardPowerLevel(score, signals, commanderTier, details, bracket, confidence, reasons);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardPowerLevel)) {
            return false;
        }
        MTIdCardPowerLevel mTIdCardPowerLevel = (MTIdCardPowerLevel) other;
        return Intrinsics.areEqual(this.score, mTIdCardPowerLevel.score) && Intrinsics.areEqual(this.signals, mTIdCardPowerLevel.signals) && Intrinsics.areEqual((Object) this.commanderTier, (Object) mTIdCardPowerLevel.commanderTier) && Intrinsics.areEqual(this.details, mTIdCardPowerLevel.details) && Intrinsics.areEqual(this.bracket, mTIdCardPowerLevel.bracket) && Intrinsics.areEqual(this.confidence, mTIdCardPowerLevel.confidence) && Intrinsics.areEqual(this.reasons, mTIdCardPowerLevel.reasons);
    }

    public final Integer getBracket() {
        return this.bracket;
    }

    public final Double getCommanderTier() {
        return this.commanderTier;
    }

    public final String getConfidence() {
        return this.confidence;
    }

    public final MTIdCardPowerDetails getDetails() {
        return this.details;
    }

    public final List<String> getReasons() {
        return this.reasons;
    }

    public final Integer getScore() {
        return this.score;
    }

    public final MTIdCardPowerSignals getSignals() {
        return this.signals;
    }

    public int hashCode() {
        Integer num = this.score;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        MTIdCardPowerSignals mTIdCardPowerSignals = this.signals;
        int iHashCode2 = (iHashCode + (mTIdCardPowerSignals == null ? 0 : mTIdCardPowerSignals.hashCode())) * 31;
        Double d = this.commanderTier;
        int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        MTIdCardPowerDetails mTIdCardPowerDetails = this.details;
        int iHashCode4 = (iHashCode3 + (mTIdCardPowerDetails == null ? 0 : mTIdCardPowerDetails.hashCode())) * 31;
        Integer num2 = this.bracket;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.confidence;
        return ((iHashCode5 + (str != null ? str.hashCode() : 0)) * 31) + this.reasons.hashCode();
    }

    public String toString() {
        return "MTIdCardPowerLevel(score=" + this.score + ", signals=" + this.signals + ", commanderTier=" + this.commanderTier + ", details=" + this.details + ", bracket=" + this.bracket + ", confidence=" + this.confidence + ", reasons=" + this.reasons + ")";
    }
}
