package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardLandDropTurnProb;", "", "turn", "", "cardsDrawn", "probability", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)V", "getTurn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCardsDrawn", "getProbability", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTIdCardLandDropTurnProb;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardLandDropTurnProb {
    public static final int $stable = 0;
    private final Integer cardsDrawn;
    private final Double probability;
    private final Integer turn;

    public MTIdCardLandDropTurnProb() {
        this(null, null, null, 7, null);
    }

    public MTIdCardLandDropTurnProb(Integer num, Integer num2, Double d) {
        this.turn = num;
        this.cardsDrawn = num2;
        this.probability = d;
    }

    public /* synthetic */ MTIdCardLandDropTurnProb(Integer num, Integer num2, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : d);
    }

    public static /* synthetic */ MTIdCardLandDropTurnProb copy$default(MTIdCardLandDropTurnProb mTIdCardLandDropTurnProb, Integer num, Integer num2, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardLandDropTurnProb.turn;
        }
        if ((i & 2) != 0) {
            num2 = mTIdCardLandDropTurnProb.cardsDrawn;
        }
        if ((i & 4) != 0) {
            d = mTIdCardLandDropTurnProb.probability;
        }
        return mTIdCardLandDropTurnProb.copy(num, num2, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getTurn() {
        return this.turn;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getCardsDrawn() {
        return this.cardsDrawn;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getProbability() {
        return this.probability;
    }

    public final MTIdCardLandDropTurnProb copy(Integer turn, Integer cardsDrawn, Double probability) {
        return new MTIdCardLandDropTurnProb(turn, cardsDrawn, probability);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardLandDropTurnProb)) {
            return false;
        }
        MTIdCardLandDropTurnProb mTIdCardLandDropTurnProb = (MTIdCardLandDropTurnProb) other;
        return Intrinsics.areEqual(this.turn, mTIdCardLandDropTurnProb.turn) && Intrinsics.areEqual(this.cardsDrawn, mTIdCardLandDropTurnProb.cardsDrawn) && Intrinsics.areEqual((Object) this.probability, (Object) mTIdCardLandDropTurnProb.probability);
    }

    public final Integer getCardsDrawn() {
        return this.cardsDrawn;
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
        Integer num2 = this.cardsDrawn;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d = this.probability;
        return iHashCode2 + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardLandDropTurnProb(turn=" + this.turn + ", cardsDrawn=" + this.cardsDrawn + ", probability=" + this.probability + ")";
    }
}
