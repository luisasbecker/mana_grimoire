package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardCardPowerCoverage;", "", "cardsWithWeights", "", "totalCards", "coveragePct", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCardsWithWeights", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalCards", "getCoveragePct", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTIdCardCardPowerCoverage;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardCardPowerCoverage {
    public static final int $stable = 0;
    private final Integer cardsWithWeights;
    private final Integer coveragePct;
    private final Integer totalCards;

    public MTIdCardCardPowerCoverage() {
        this(null, null, null, 7, null);
    }

    public MTIdCardCardPowerCoverage(Integer num, Integer num2, Integer num3) {
        this.cardsWithWeights = num;
        this.totalCards = num2;
        this.coveragePct = num3;
    }

    public /* synthetic */ MTIdCardCardPowerCoverage(Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3);
    }

    public static /* synthetic */ MTIdCardCardPowerCoverage copy$default(MTIdCardCardPowerCoverage mTIdCardCardPowerCoverage, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardCardPowerCoverage.cardsWithWeights;
        }
        if ((i & 2) != 0) {
            num2 = mTIdCardCardPowerCoverage.totalCards;
        }
        if ((i & 4) != 0) {
            num3 = mTIdCardCardPowerCoverage.coveragePct;
        }
        return mTIdCardCardPowerCoverage.copy(num, num2, num3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getCardsWithWeights() {
        return this.cardsWithWeights;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getTotalCards() {
        return this.totalCards;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getCoveragePct() {
        return this.coveragePct;
    }

    public final MTIdCardCardPowerCoverage copy(Integer cardsWithWeights, Integer totalCards, Integer coveragePct) {
        return new MTIdCardCardPowerCoverage(cardsWithWeights, totalCards, coveragePct);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardCardPowerCoverage)) {
            return false;
        }
        MTIdCardCardPowerCoverage mTIdCardCardPowerCoverage = (MTIdCardCardPowerCoverage) other;
        return Intrinsics.areEqual(this.cardsWithWeights, mTIdCardCardPowerCoverage.cardsWithWeights) && Intrinsics.areEqual(this.totalCards, mTIdCardCardPowerCoverage.totalCards) && Intrinsics.areEqual(this.coveragePct, mTIdCardCardPowerCoverage.coveragePct);
    }

    public final Integer getCardsWithWeights() {
        return this.cardsWithWeights;
    }

    public final Integer getCoveragePct() {
        return this.coveragePct;
    }

    public final Integer getTotalCards() {
        return this.totalCards;
    }

    public int hashCode() {
        Integer num = this.cardsWithWeights;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.totalCards;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.coveragePct;
        return iHashCode2 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardCardPowerCoverage(cardsWithWeights=" + this.cardsWithWeights + ", totalCards=" + this.totalCards + ", coveragePct=" + this.coveragePct + ")";
    }
}
