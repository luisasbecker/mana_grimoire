package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardLandDropReliabilityTurn;", "", "turn", "", "probability", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Double;)V", "getTurn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProbability", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTIdCardLandDropReliabilityTurn;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardLandDropReliabilityTurn {
    public static final int $stable = 0;
    private final Double probability;
    private final Integer turn;

    /* JADX WARN: Multi-variable type inference failed */
    public MTIdCardLandDropReliabilityTurn() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTIdCardLandDropReliabilityTurn(Integer num, Double d) {
        this.turn = num;
        this.probability = d;
    }

    public /* synthetic */ MTIdCardLandDropReliabilityTurn(Integer num, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : d);
    }

    public static /* synthetic */ MTIdCardLandDropReliabilityTurn copy$default(MTIdCardLandDropReliabilityTurn mTIdCardLandDropReliabilityTurn, Integer num, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardLandDropReliabilityTurn.turn;
        }
        if ((i & 2) != 0) {
            d = mTIdCardLandDropReliabilityTurn.probability;
        }
        return mTIdCardLandDropReliabilityTurn.copy(num, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getTurn() {
        return this.turn;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getProbability() {
        return this.probability;
    }

    public final MTIdCardLandDropReliabilityTurn copy(Integer turn, Double probability) {
        return new MTIdCardLandDropReliabilityTurn(turn, probability);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardLandDropReliabilityTurn)) {
            return false;
        }
        MTIdCardLandDropReliabilityTurn mTIdCardLandDropReliabilityTurn = (MTIdCardLandDropReliabilityTurn) other;
        return Intrinsics.areEqual(this.turn, mTIdCardLandDropReliabilityTurn.turn) && Intrinsics.areEqual((Object) this.probability, (Object) mTIdCardLandDropReliabilityTurn.probability);
    }

    public final Double getProbability() {
        return this.probability;
    }

    public final Integer getTurn() {
        return this.turn;
    }

    public int hashCode() {
        Integer num = this.turn;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Double d = this.probability;
        return iHashCode + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardLandDropReliabilityTurn(turn=" + this.turn + ", probability=" + this.probability + ")";
    }
}
