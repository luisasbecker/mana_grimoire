package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeckCardCountDetails;", "", "card_count", "", "total_card_count", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCard_count", "()Ljava/lang/Integer;", "setCard_count", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTotal_card_count", "setTotal_card_count", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTDeckCardCountDetails;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeckCardCountDetails {
    public static final int $stable = 8;
    private Integer card_count;
    private Integer total_card_count;

    /* JADX WARN: Multi-variable type inference failed */
    public MTDeckCardCountDetails() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTDeckCardCountDetails(Integer num, Integer num2) {
        this.card_count = num;
        this.total_card_count = num2;
    }

    public /* synthetic */ MTDeckCardCountDetails(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    public static /* synthetic */ MTDeckCardCountDetails copy$default(MTDeckCardCountDetails mTDeckCardCountDetails, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTDeckCardCountDetails.card_count;
        }
        if ((i & 2) != 0) {
            num2 = mTDeckCardCountDetails.total_card_count;
        }
        return mTDeckCardCountDetails.copy(num, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getCard_count() {
        return this.card_count;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getTotal_card_count() {
        return this.total_card_count;
    }

    public final MTDeckCardCountDetails copy(Integer card_count, Integer total_card_count) {
        return new MTDeckCardCountDetails(card_count, total_card_count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeckCardCountDetails)) {
            return false;
        }
        MTDeckCardCountDetails mTDeckCardCountDetails = (MTDeckCardCountDetails) other;
        return Intrinsics.areEqual(this.card_count, mTDeckCardCountDetails.card_count) && Intrinsics.areEqual(this.total_card_count, mTDeckCardCountDetails.total_card_count);
    }

    public final Integer getCard_count() {
        return this.card_count;
    }

    public final Integer getTotal_card_count() {
        return this.total_card_count;
    }

    public int hashCode() {
        Integer num = this.card_count;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.total_card_count;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setCard_count(Integer num) {
        this.card_count = num;
    }

    public final void setTotal_card_count(Integer num) {
        this.total_card_count = num;
    }

    public String toString() {
        return "MTDeckCardCountDetails(card_count=" + this.card_count + ", total_card_count=" + this.total_card_count + ")";
    }
}
