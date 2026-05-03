package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012JN\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardComboProbability;", "", "comboId", "", "cards", "", "cardCount", "", "probability", "Lcom/studiolaganne/lengendarylens/MTIdCardComboProbDetail;", "tutorCount", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTIdCardComboProbDetail;Ljava/lang/Integer;)V", "getComboId", "()Ljava/lang/String;", "getCards", "()Ljava/util/List;", "getCardCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProbability", "()Lcom/studiolaganne/lengendarylens/MTIdCardComboProbDetail;", "getTutorCount", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTIdCardComboProbDetail;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTIdCardComboProbability;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardComboProbability {
    public static final int $stable = 8;
    private final Integer cardCount;
    private final List<String> cards;
    private final String comboId;
    private final MTIdCardComboProbDetail probability;
    private final Integer tutorCount;

    public MTIdCardComboProbability() {
        this(null, null, null, null, null, 31, null);
    }

    public MTIdCardComboProbability(String str, List<String> cards, Integer num, MTIdCardComboProbDetail mTIdCardComboProbDetail, Integer num2) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        this.comboId = str;
        this.cards = cards;
        this.cardCount = num;
        this.probability = mTIdCardComboProbDetail;
        this.tutorCount = num2;
    }

    public /* synthetic */ MTIdCardComboProbability(String str, List list, Integer num, MTIdCardComboProbDetail mTIdCardComboProbDetail, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : mTIdCardComboProbDetail, (i & 16) != 0 ? null : num2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardComboProbability copy$default(MTIdCardComboProbability mTIdCardComboProbability, String str, List list, Integer num, MTIdCardComboProbDetail mTIdCardComboProbDetail, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardComboProbability.comboId;
        }
        if ((i & 2) != 0) {
            list = mTIdCardComboProbability.cards;
        }
        if ((i & 4) != 0) {
            num = mTIdCardComboProbability.cardCount;
        }
        if ((i & 8) != 0) {
            mTIdCardComboProbDetail = mTIdCardComboProbability.probability;
        }
        if ((i & 16) != 0) {
            num2 = mTIdCardComboProbability.tutorCount;
        }
        Integer num3 = num2;
        Integer num4 = num;
        return mTIdCardComboProbability.copy(str, list, num4, mTIdCardComboProbDetail, num3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getComboId() {
        return this.comboId;
    }

    public final List<String> component2() {
        return this.cards;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getCardCount() {
        return this.cardCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTIdCardComboProbDetail getProbability() {
        return this.probability;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getTutorCount() {
        return this.tutorCount;
    }

    public final MTIdCardComboProbability copy(String comboId, List<String> cards, Integer cardCount, MTIdCardComboProbDetail probability, Integer tutorCount) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        return new MTIdCardComboProbability(comboId, cards, cardCount, probability, tutorCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardComboProbability)) {
            return false;
        }
        MTIdCardComboProbability mTIdCardComboProbability = (MTIdCardComboProbability) other;
        return Intrinsics.areEqual(this.comboId, mTIdCardComboProbability.comboId) && Intrinsics.areEqual(this.cards, mTIdCardComboProbability.cards) && Intrinsics.areEqual(this.cardCount, mTIdCardComboProbability.cardCount) && Intrinsics.areEqual(this.probability, mTIdCardComboProbability.probability) && Intrinsics.areEqual(this.tutorCount, mTIdCardComboProbability.tutorCount);
    }

    public final Integer getCardCount() {
        return this.cardCount;
    }

    public final List<String> getCards() {
        return this.cards;
    }

    public final String getComboId() {
        return this.comboId;
    }

    public final MTIdCardComboProbDetail getProbability() {
        return this.probability;
    }

    public final Integer getTutorCount() {
        return this.tutorCount;
    }

    public int hashCode() {
        String str = this.comboId;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.cards.hashCode()) * 31;
        Integer num = this.cardCount;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        MTIdCardComboProbDetail mTIdCardComboProbDetail = this.probability;
        int iHashCode3 = (iHashCode2 + (mTIdCardComboProbDetail == null ? 0 : mTIdCardComboProbDetail.hashCode())) * 31;
        Integer num2 = this.tutorCount;
        return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardComboProbability(comboId=" + this.comboId + ", cards=" + this.cards + ", cardCount=" + this.cardCount + ", probability=" + this.probability + ", tutorCount=" + this.tutorCount + ")";
    }
}
