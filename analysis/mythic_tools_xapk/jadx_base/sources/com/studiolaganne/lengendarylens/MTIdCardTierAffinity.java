package com.studiolaganne.lengendarylens;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardTierAffinity;", "", "tier", "", "similarity", "", "weight", TypedValues.AttributesType.S_TARGET, "", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;)V", "getTier", "()Ljava/lang/String;", "getSimilarity", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getWeight", "getTarget", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTIdCardTierAffinity;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardTierAffinity {
    public static final int $stable = 0;
    private final Double similarity;
    private final Integer target;
    private final String tier;
    private final Double weight;

    public MTIdCardTierAffinity() {
        this(null, null, null, null, 15, null);
    }

    public MTIdCardTierAffinity(String str, Double d, Double d2, Integer num) {
        this.tier = str;
        this.similarity = d;
        this.weight = d2;
        this.target = num;
    }

    public /* synthetic */ MTIdCardTierAffinity(String str, Double d, Double d2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : d2, (i & 8) != 0 ? null : num);
    }

    public static /* synthetic */ MTIdCardTierAffinity copy$default(MTIdCardTierAffinity mTIdCardTierAffinity, String str, Double d, Double d2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardTierAffinity.tier;
        }
        if ((i & 2) != 0) {
            d = mTIdCardTierAffinity.similarity;
        }
        if ((i & 4) != 0) {
            d2 = mTIdCardTierAffinity.weight;
        }
        if ((i & 8) != 0) {
            num = mTIdCardTierAffinity.target;
        }
        return mTIdCardTierAffinity.copy(str, d, d2, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTier() {
        return this.tier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getSimilarity() {
        return this.similarity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getWeight() {
        return this.weight;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getTarget() {
        return this.target;
    }

    public final MTIdCardTierAffinity copy(String tier, Double similarity, Double weight, Integer target) {
        return new MTIdCardTierAffinity(tier, similarity, weight, target);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardTierAffinity)) {
            return false;
        }
        MTIdCardTierAffinity mTIdCardTierAffinity = (MTIdCardTierAffinity) other;
        return Intrinsics.areEqual(this.tier, mTIdCardTierAffinity.tier) && Intrinsics.areEqual((Object) this.similarity, (Object) mTIdCardTierAffinity.similarity) && Intrinsics.areEqual((Object) this.weight, (Object) mTIdCardTierAffinity.weight) && Intrinsics.areEqual(this.target, mTIdCardTierAffinity.target);
    }

    public final Double getSimilarity() {
        return this.similarity;
    }

    public final Integer getTarget() {
        return this.target;
    }

    public final String getTier() {
        return this.tier;
    }

    public final Double getWeight() {
        return this.weight;
    }

    public int hashCode() {
        String str = this.tier;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double d = this.similarity;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.weight;
        int iHashCode3 = (iHashCode2 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Integer num = this.target;
        return iHashCode3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardTierAffinity(tier=" + this.tier + ", similarity=" + this.similarity + ", weight=" + this.weight + ", target=" + this.target + ")";
    }
}
