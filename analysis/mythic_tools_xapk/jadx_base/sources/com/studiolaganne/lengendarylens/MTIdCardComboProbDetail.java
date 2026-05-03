package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardComboProbDetail;", "", "openingHand", "", "byTurn7", "byTurn10", "withTutors", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getOpeningHand", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getByTurn7", "getByTurn10", "getWithTutors", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTIdCardComboProbDetail;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardComboProbDetail {
    public static final int $stable = 0;
    private final Double byTurn10;
    private final Double byTurn7;
    private final Double openingHand;
    private final Double withTutors;

    public MTIdCardComboProbDetail() {
        this(null, null, null, null, 15, null);
    }

    public MTIdCardComboProbDetail(Double d, Double d2, Double d3, Double d4) {
        this.openingHand = d;
        this.byTurn7 = d2;
        this.byTurn10 = d3;
        this.withTutors = d4;
    }

    public /* synthetic */ MTIdCardComboProbDetail(Double d, Double d2, Double d3, Double d4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2, (i & 4) != 0 ? null : d3, (i & 8) != 0 ? null : d4);
    }

    public static /* synthetic */ MTIdCardComboProbDetail copy$default(MTIdCardComboProbDetail mTIdCardComboProbDetail, Double d, Double d2, Double d3, Double d4, int i, Object obj) {
        if ((i & 1) != 0) {
            d = mTIdCardComboProbDetail.openingHand;
        }
        if ((i & 2) != 0) {
            d2 = mTIdCardComboProbDetail.byTurn7;
        }
        if ((i & 4) != 0) {
            d3 = mTIdCardComboProbDetail.byTurn10;
        }
        if ((i & 8) != 0) {
            d4 = mTIdCardComboProbDetail.withTutors;
        }
        return mTIdCardComboProbDetail.copy(d, d2, d3, d4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getOpeningHand() {
        return this.openingHand;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getByTurn7() {
        return this.byTurn7;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getByTurn10() {
        return this.byTurn10;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getWithTutors() {
        return this.withTutors;
    }

    public final MTIdCardComboProbDetail copy(Double openingHand, Double byTurn7, Double byTurn10, Double withTutors) {
        return new MTIdCardComboProbDetail(openingHand, byTurn7, byTurn10, withTutors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardComboProbDetail)) {
            return false;
        }
        MTIdCardComboProbDetail mTIdCardComboProbDetail = (MTIdCardComboProbDetail) other;
        return Intrinsics.areEqual((Object) this.openingHand, (Object) mTIdCardComboProbDetail.openingHand) && Intrinsics.areEqual((Object) this.byTurn7, (Object) mTIdCardComboProbDetail.byTurn7) && Intrinsics.areEqual((Object) this.byTurn10, (Object) mTIdCardComboProbDetail.byTurn10) && Intrinsics.areEqual((Object) this.withTutors, (Object) mTIdCardComboProbDetail.withTutors);
    }

    public final Double getByTurn10() {
        return this.byTurn10;
    }

    public final Double getByTurn7() {
        return this.byTurn7;
    }

    public final Double getOpeningHand() {
        return this.openingHand;
    }

    public final Double getWithTutors() {
        return this.withTutors;
    }

    public int hashCode() {
        Double d = this.openingHand;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.byTurn7;
        int iHashCode2 = (iHashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.byTurn10;
        int iHashCode3 = (iHashCode2 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Double d4 = this.withTutors;
        return iHashCode3 + (d4 != null ? d4.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardComboProbDetail(openingHand=" + this.openingHand + ", byTurn7=" + this.byTurn7 + ", byTurn10=" + this.byTurn10 + ", withTutors=" + this.withTutors + ")";
    }
}
