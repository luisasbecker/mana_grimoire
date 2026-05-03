package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardCommanderTierData;", "", "ceiling", "", "topCuts", "", "entries", "conversionRate", "<init>", "(Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)V", "getCeiling", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getTopCuts", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEntries", "getConversionRate", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTIdCardCommanderTierData;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardCommanderTierData {
    public static final int $stable = 0;
    private final Double ceiling;
    private final Double conversionRate;
    private final Integer entries;
    private final Integer topCuts;

    public MTIdCardCommanderTierData() {
        this(null, null, null, null, 15, null);
    }

    public MTIdCardCommanderTierData(Double d, Integer num, Integer num2, Double d2) {
        this.ceiling = d;
        this.topCuts = num;
        this.entries = num2;
        this.conversionRate = d2;
    }

    public /* synthetic */ MTIdCardCommanderTierData(Double d, Integer num, Integer num2, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : d2);
    }

    public static /* synthetic */ MTIdCardCommanderTierData copy$default(MTIdCardCommanderTierData mTIdCardCommanderTierData, Double d, Integer num, Integer num2, Double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = mTIdCardCommanderTierData.ceiling;
        }
        if ((i & 2) != 0) {
            num = mTIdCardCommanderTierData.topCuts;
        }
        if ((i & 4) != 0) {
            num2 = mTIdCardCommanderTierData.entries;
        }
        if ((i & 8) != 0) {
            d2 = mTIdCardCommanderTierData.conversionRate;
        }
        return mTIdCardCommanderTierData.copy(d, num, num2, d2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getCeiling() {
        return this.ceiling;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getTopCuts() {
        return this.topCuts;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getEntries() {
        return this.entries;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getConversionRate() {
        return this.conversionRate;
    }

    public final MTIdCardCommanderTierData copy(Double ceiling, Integer topCuts, Integer entries, Double conversionRate) {
        return new MTIdCardCommanderTierData(ceiling, topCuts, entries, conversionRate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardCommanderTierData)) {
            return false;
        }
        MTIdCardCommanderTierData mTIdCardCommanderTierData = (MTIdCardCommanderTierData) other;
        return Intrinsics.areEqual((Object) this.ceiling, (Object) mTIdCardCommanderTierData.ceiling) && Intrinsics.areEqual(this.topCuts, mTIdCardCommanderTierData.topCuts) && Intrinsics.areEqual(this.entries, mTIdCardCommanderTierData.entries) && Intrinsics.areEqual((Object) this.conversionRate, (Object) mTIdCardCommanderTierData.conversionRate);
    }

    public final Double getCeiling() {
        return this.ceiling;
    }

    public final Double getConversionRate() {
        return this.conversionRate;
    }

    public final Integer getEntries() {
        return this.entries;
    }

    public final Integer getTopCuts() {
        return this.topCuts;
    }

    public int hashCode() {
        Double d = this.ceiling;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Integer num = this.topCuts;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.entries;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d2 = this.conversionRate;
        return iHashCode3 + (d2 != null ? d2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardCommanderTierData(ceiling=" + this.ceiling + ", topCuts=" + this.topCuts + ", entries=" + this.entries + ", conversionRate=" + this.conversionRate + ")";
    }
}
