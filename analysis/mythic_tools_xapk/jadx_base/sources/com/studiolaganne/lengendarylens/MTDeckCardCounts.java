package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeckCardCounts;", "", "card_count", "", "total_card_count", "main", "Lcom/studiolaganne/lengendarylens/MTDeckCardCountDetails;", "sideboard", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTDeckCardCountDetails;Lcom/studiolaganne/lengendarylens/MTDeckCardCountDetails;)V", "getCard_count", "()Ljava/lang/Integer;", "setCard_count", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTotal_card_count", "setTotal_card_count", "getMain", "()Lcom/studiolaganne/lengendarylens/MTDeckCardCountDetails;", "setMain", "(Lcom/studiolaganne/lengendarylens/MTDeckCardCountDetails;)V", "getSideboard", "setSideboard", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTDeckCardCountDetails;Lcom/studiolaganne/lengendarylens/MTDeckCardCountDetails;)Lcom/studiolaganne/lengendarylens/MTDeckCardCounts;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeckCardCounts {
    public static final int $stable = 8;
    private Integer card_count;
    private MTDeckCardCountDetails main;
    private MTDeckCardCountDetails sideboard;
    private Integer total_card_count;

    public MTDeckCardCounts() {
        this(null, null, null, null, 15, null);
    }

    public MTDeckCardCounts(Integer num, Integer num2, MTDeckCardCountDetails mTDeckCardCountDetails, MTDeckCardCountDetails mTDeckCardCountDetails2) {
        this.card_count = num;
        this.total_card_count = num2;
        this.main = mTDeckCardCountDetails;
        this.sideboard = mTDeckCardCountDetails2;
    }

    public /* synthetic */ MTDeckCardCounts(Integer num, Integer num2, MTDeckCardCountDetails mTDeckCardCountDetails, MTDeckCardCountDetails mTDeckCardCountDetails2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : mTDeckCardCountDetails, (i & 8) != 0 ? null : mTDeckCardCountDetails2);
    }

    public static /* synthetic */ MTDeckCardCounts copy$default(MTDeckCardCounts mTDeckCardCounts, Integer num, Integer num2, MTDeckCardCountDetails mTDeckCardCountDetails, MTDeckCardCountDetails mTDeckCardCountDetails2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTDeckCardCounts.card_count;
        }
        if ((i & 2) != 0) {
            num2 = mTDeckCardCounts.total_card_count;
        }
        if ((i & 4) != 0) {
            mTDeckCardCountDetails = mTDeckCardCounts.main;
        }
        if ((i & 8) != 0) {
            mTDeckCardCountDetails2 = mTDeckCardCounts.sideboard;
        }
        return mTDeckCardCounts.copy(num, num2, mTDeckCardCountDetails, mTDeckCardCountDetails2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getCard_count() {
        return this.card_count;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getTotal_card_count() {
        return this.total_card_count;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTDeckCardCountDetails getMain() {
        return this.main;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTDeckCardCountDetails getSideboard() {
        return this.sideboard;
    }

    public final MTDeckCardCounts copy(Integer card_count, Integer total_card_count, MTDeckCardCountDetails main, MTDeckCardCountDetails sideboard) {
        return new MTDeckCardCounts(card_count, total_card_count, main, sideboard);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeckCardCounts)) {
            return false;
        }
        MTDeckCardCounts mTDeckCardCounts = (MTDeckCardCounts) other;
        return Intrinsics.areEqual(this.card_count, mTDeckCardCounts.card_count) && Intrinsics.areEqual(this.total_card_count, mTDeckCardCounts.total_card_count) && Intrinsics.areEqual(this.main, mTDeckCardCounts.main) && Intrinsics.areEqual(this.sideboard, mTDeckCardCounts.sideboard);
    }

    public final Integer getCard_count() {
        return this.card_count;
    }

    public final MTDeckCardCountDetails getMain() {
        return this.main;
    }

    public final MTDeckCardCountDetails getSideboard() {
        return this.sideboard;
    }

    public final Integer getTotal_card_count() {
        return this.total_card_count;
    }

    public int hashCode() {
        Integer num = this.card_count;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.total_card_count;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        MTDeckCardCountDetails mTDeckCardCountDetails = this.main;
        int iHashCode3 = (iHashCode2 + (mTDeckCardCountDetails == null ? 0 : mTDeckCardCountDetails.hashCode())) * 31;
        MTDeckCardCountDetails mTDeckCardCountDetails2 = this.sideboard;
        return iHashCode3 + (mTDeckCardCountDetails2 != null ? mTDeckCardCountDetails2.hashCode() : 0);
    }

    public final void setCard_count(Integer num) {
        this.card_count = num;
    }

    public final void setMain(MTDeckCardCountDetails mTDeckCardCountDetails) {
        this.main = mTDeckCardCountDetails;
    }

    public final void setSideboard(MTDeckCardCountDetails mTDeckCardCountDetails) {
        this.sideboard = mTDeckCardCountDetails;
    }

    public final void setTotal_card_count(Integer num) {
        this.total_card_count = num;
    }

    public String toString() {
        return "MTDeckCardCounts(card_count=" + this.card_count + ", total_card_count=" + this.total_card_count + ", main=" + this.main + ", sideboard=" + this.sideboard + ")";
    }
}
