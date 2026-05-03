package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JC\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/MTAddCardsResult;", "", "success", "", "added", "", "total_processed", "total_sent", "failed_cards", "", "Lcom/studiolaganne/lengendarylens/MTAddCardResult;", "<init>", "(ZIIILjava/util/List;)V", "getSuccess", "()Z", "getAdded", "()I", "getTotal_processed", "getTotal_sent", "getFailed_cards", "()Ljava/util/List;", "setFailed_cards", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTAddCardsResult {
    public static final int $stable = 8;
    private final int added;
    private List<MTAddCardResult> failed_cards;
    private final boolean success;
    private final int total_processed;
    private final int total_sent;

    public MTAddCardsResult(boolean z, int i, int i2, int i3, List<MTAddCardResult> list) {
        this.success = z;
        this.added = i;
        this.total_processed = i2;
        this.total_sent = i3;
        this.failed_cards = list;
    }

    public /* synthetic */ MTAddCardsResult(boolean z, int i, int i2, int i3, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, i2, i3, (i4 & 16) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTAddCardsResult copy$default(MTAddCardsResult mTAddCardsResult, boolean z, int i, int i2, int i3, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = mTAddCardsResult.success;
        }
        if ((i4 & 2) != 0) {
            i = mTAddCardsResult.added;
        }
        if ((i4 & 4) != 0) {
            i2 = mTAddCardsResult.total_processed;
        }
        if ((i4 & 8) != 0) {
            i3 = mTAddCardsResult.total_sent;
        }
        if ((i4 & 16) != 0) {
            list = mTAddCardsResult.failed_cards;
        }
        List list2 = list;
        int i5 = i2;
        return mTAddCardsResult.copy(z, i, i5, i3, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAdded() {
        return this.added;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTotal_processed() {
        return this.total_processed;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTotal_sent() {
        return this.total_sent;
    }

    public final List<MTAddCardResult> component5() {
        return this.failed_cards;
    }

    public final MTAddCardsResult copy(boolean success, int added, int total_processed, int total_sent, List<MTAddCardResult> failed_cards) {
        return new MTAddCardsResult(success, added, total_processed, total_sent, failed_cards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTAddCardsResult)) {
            return false;
        }
        MTAddCardsResult mTAddCardsResult = (MTAddCardsResult) other;
        return this.success == mTAddCardsResult.success && this.added == mTAddCardsResult.added && this.total_processed == mTAddCardsResult.total_processed && this.total_sent == mTAddCardsResult.total_sent && Intrinsics.areEqual(this.failed_cards, mTAddCardsResult.failed_cards);
    }

    public final int getAdded() {
        return this.added;
    }

    public final List<MTAddCardResult> getFailed_cards() {
        return this.failed_cards;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final int getTotal_processed() {
        return this.total_processed;
    }

    public final int getTotal_sent() {
        return this.total_sent;
    }

    public int hashCode() {
        int iHashCode = ((((((Boolean.hashCode(this.success) * 31) + Integer.hashCode(this.added)) * 31) + Integer.hashCode(this.total_processed)) * 31) + Integer.hashCode(this.total_sent)) * 31;
        List<MTAddCardResult> list = this.failed_cards;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public final void setFailed_cards(List<MTAddCardResult> list) {
        this.failed_cards = list;
    }

    public String toString() {
        return "MTAddCardsResult(success=" + this.success + ", added=" + this.added + ", total_processed=" + this.total_processed + ", total_sent=" + this.total_sent + ", failed_cards=" + this.failed_cards + ")";
    }
}
