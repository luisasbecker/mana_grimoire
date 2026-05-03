package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ&\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeckValueDetail;", "", "total_value", "", "card_count", "", "<init>", "(Ljava/lang/Double;Ljava/lang/Integer;)V", "getTotal_value", "()Ljava/lang/Double;", "setTotal_value", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getCard_count", "()Ljava/lang/Integer;", "setCard_count", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTDeckValueDetail;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeckValueDetail {
    public static final int $stable = 8;
    private Integer card_count;
    private Double total_value;

    /* JADX WARN: Multi-variable type inference failed */
    public MTDeckValueDetail() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTDeckValueDetail(Double d, Integer num) {
        this.total_value = d;
        this.card_count = num;
    }

    public /* synthetic */ MTDeckValueDetail(Double d, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : num);
    }

    public static /* synthetic */ MTDeckValueDetail copy$default(MTDeckValueDetail mTDeckValueDetail, Double d, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            d = mTDeckValueDetail.total_value;
        }
        if ((i & 2) != 0) {
            num = mTDeckValueDetail.card_count;
        }
        return mTDeckValueDetail.copy(d, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getTotal_value() {
        return this.total_value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getCard_count() {
        return this.card_count;
    }

    public final MTDeckValueDetail copy(Double total_value, Integer card_count) {
        return new MTDeckValueDetail(total_value, card_count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeckValueDetail)) {
            return false;
        }
        MTDeckValueDetail mTDeckValueDetail = (MTDeckValueDetail) other;
        return Intrinsics.areEqual((Object) this.total_value, (Object) mTDeckValueDetail.total_value) && Intrinsics.areEqual(this.card_count, mTDeckValueDetail.card_count);
    }

    public final Integer getCard_count() {
        return this.card_count;
    }

    public final Double getTotal_value() {
        return this.total_value;
    }

    public int hashCode() {
        Double d = this.total_value;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Integer num = this.card_count;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final void setCard_count(Integer num) {
        this.card_count = num;
    }

    public final void setTotal_value(Double d) {
        this.total_value = d;
    }

    public String toString() {
        return "MTDeckValueDetail(total_value=" + this.total_value + ", card_count=" + this.card_count + ")";
    }
}
