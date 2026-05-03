package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardCostReduction;", "", "effectiveCmc", "", "reductionType", "", "estimatedDiscount", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getEffectiveCmc", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReductionType", "()Ljava/lang/String;", "getEstimatedDiscount", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTIdCardCostReduction;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardCostReduction {
    public static final int $stable = 0;
    private final Integer effectiveCmc;
    private final Integer estimatedDiscount;
    private final String reductionType;

    public MTIdCardCostReduction() {
        this(null, null, null, 7, null);
    }

    public MTIdCardCostReduction(Integer num, String str, Integer num2) {
        this.effectiveCmc = num;
        this.reductionType = str;
        this.estimatedDiscount = num2;
    }

    public /* synthetic */ MTIdCardCostReduction(Integer num, String str, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2);
    }

    public static /* synthetic */ MTIdCardCostReduction copy$default(MTIdCardCostReduction mTIdCardCostReduction, Integer num, String str, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardCostReduction.effectiveCmc;
        }
        if ((i & 2) != 0) {
            str = mTIdCardCostReduction.reductionType;
        }
        if ((i & 4) != 0) {
            num2 = mTIdCardCostReduction.estimatedDiscount;
        }
        return mTIdCardCostReduction.copy(num, str, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getEffectiveCmc() {
        return this.effectiveCmc;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getReductionType() {
        return this.reductionType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getEstimatedDiscount() {
        return this.estimatedDiscount;
    }

    public final MTIdCardCostReduction copy(Integer effectiveCmc, String reductionType, Integer estimatedDiscount) {
        return new MTIdCardCostReduction(effectiveCmc, reductionType, estimatedDiscount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardCostReduction)) {
            return false;
        }
        MTIdCardCostReduction mTIdCardCostReduction = (MTIdCardCostReduction) other;
        return Intrinsics.areEqual(this.effectiveCmc, mTIdCardCostReduction.effectiveCmc) && Intrinsics.areEqual(this.reductionType, mTIdCardCostReduction.reductionType) && Intrinsics.areEqual(this.estimatedDiscount, mTIdCardCostReduction.estimatedDiscount);
    }

    public final Integer getEffectiveCmc() {
        return this.effectiveCmc;
    }

    public final Integer getEstimatedDiscount() {
        return this.estimatedDiscount;
    }

    public final String getReductionType() {
        return this.reductionType;
    }

    public int hashCode() {
        Integer num = this.effectiveCmc;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.reductionType;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.estimatedDiscount;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardCostReduction(effectiveCmc=" + this.effectiveCmc + ", reductionType=" + this.reductionType + ", estimatedDiscount=" + this.estimatedDiscount + ")";
    }
}
