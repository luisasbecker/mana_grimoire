package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\u000f¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardManaSubscore;", "", "type", "", "value", "", "rawWeight", "", "normalizedWeight", "weightedContribution", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;)V", "getType", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getRawWeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNormalizedWeight", "getWeightedContribution", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTIdCardManaSubscore;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardManaSubscore {
    public static final int $stable = 0;
    private final Double normalizedWeight;
    private final Integer rawWeight;
    private final String type;
    private final Double value;
    private final Double weightedContribution;

    public MTIdCardManaSubscore() {
        this(null, null, null, null, null, 31, null);
    }

    public MTIdCardManaSubscore(String str, Double d, Integer num, Double d2, Double d3) {
        this.type = str;
        this.value = d;
        this.rawWeight = num;
        this.normalizedWeight = d2;
        this.weightedContribution = d3;
    }

    public /* synthetic */ MTIdCardManaSubscore(String str, Double d, Integer num, Double d2, Double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : d2, (i & 16) != 0 ? null : d3);
    }

    public static /* synthetic */ MTIdCardManaSubscore copy$default(MTIdCardManaSubscore mTIdCardManaSubscore, String str, Double d, Integer num, Double d2, Double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardManaSubscore.type;
        }
        if ((i & 2) != 0) {
            d = mTIdCardManaSubscore.value;
        }
        if ((i & 4) != 0) {
            num = mTIdCardManaSubscore.rawWeight;
        }
        if ((i & 8) != 0) {
            d2 = mTIdCardManaSubscore.normalizedWeight;
        }
        if ((i & 16) != 0) {
            d3 = mTIdCardManaSubscore.weightedContribution;
        }
        Double d4 = d3;
        Integer num2 = num;
        return mTIdCardManaSubscore.copy(str, d, num2, d2, d4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getRawWeight() {
        return this.rawWeight;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getNormalizedWeight() {
        return this.normalizedWeight;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getWeightedContribution() {
        return this.weightedContribution;
    }

    public final MTIdCardManaSubscore copy(String type, Double value, Integer rawWeight, Double normalizedWeight, Double weightedContribution) {
        return new MTIdCardManaSubscore(type, value, rawWeight, normalizedWeight, weightedContribution);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardManaSubscore)) {
            return false;
        }
        MTIdCardManaSubscore mTIdCardManaSubscore = (MTIdCardManaSubscore) other;
        return Intrinsics.areEqual(this.type, mTIdCardManaSubscore.type) && Intrinsics.areEqual((Object) this.value, (Object) mTIdCardManaSubscore.value) && Intrinsics.areEqual(this.rawWeight, mTIdCardManaSubscore.rawWeight) && Intrinsics.areEqual((Object) this.normalizedWeight, (Object) mTIdCardManaSubscore.normalizedWeight) && Intrinsics.areEqual((Object) this.weightedContribution, (Object) mTIdCardManaSubscore.weightedContribution);
    }

    public final Double getNormalizedWeight() {
        return this.normalizedWeight;
    }

    public final Integer getRawWeight() {
        return this.rawWeight;
    }

    public final String getType() {
        return this.type;
    }

    public final Double getValue() {
        return this.value;
    }

    public final Double getWeightedContribution() {
        return this.weightedContribution;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double d = this.value;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Integer num = this.rawWeight;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Double d2 = this.normalizedWeight;
        int iHashCode4 = (iHashCode3 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.weightedContribution;
        return iHashCode4 + (d3 != null ? d3.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardManaSubscore(type=" + this.type + ", value=" + this.value + ", rawWeight=" + this.rawWeight + ", normalizedWeight=" + this.normalizedWeight + ", weightedContribution=" + this.weightedContribution + ")";
    }
}
