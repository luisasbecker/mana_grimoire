package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardPriceResponse;", "", "card_id", "", "prices", "Lcom/studiolaganne/lengendarylens/MTCardPriceDetails;", "<init>", "(Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTCardPriceDetails;)V", "getCard_id", "()Ljava/lang/String;", "getPrices", "()Lcom/studiolaganne/lengendarylens/MTCardPriceDetails;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardPriceResponse {
    public static final int $stable = 8;
    private final String card_id;
    private final MTCardPriceDetails prices;

    /* JADX WARN: Multi-variable type inference failed */
    public MTCardPriceResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTCardPriceResponse(String str, MTCardPriceDetails mTCardPriceDetails) {
        this.card_id = str;
        this.prices = mTCardPriceDetails;
    }

    public /* synthetic */ MTCardPriceResponse(String str, MTCardPriceDetails mTCardPriceDetails, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : mTCardPriceDetails);
    }

    public static /* synthetic */ MTCardPriceResponse copy$default(MTCardPriceResponse mTCardPriceResponse, String str, MTCardPriceDetails mTCardPriceDetails, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTCardPriceResponse.card_id;
        }
        if ((i & 2) != 0) {
            mTCardPriceDetails = mTCardPriceResponse.prices;
        }
        return mTCardPriceResponse.copy(str, mTCardPriceDetails);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCard_id() {
        return this.card_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTCardPriceDetails getPrices() {
        return this.prices;
    }

    public final MTCardPriceResponse copy(String card_id, MTCardPriceDetails prices) {
        return new MTCardPriceResponse(card_id, prices);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardPriceResponse)) {
            return false;
        }
        MTCardPriceResponse mTCardPriceResponse = (MTCardPriceResponse) other;
        return Intrinsics.areEqual(this.card_id, mTCardPriceResponse.card_id) && Intrinsics.areEqual(this.prices, mTCardPriceResponse.prices);
    }

    public final String getCard_id() {
        return this.card_id;
    }

    public final MTCardPriceDetails getPrices() {
        return this.prices;
    }

    public int hashCode() {
        String str = this.card_id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        MTCardPriceDetails mTCardPriceDetails = this.prices;
        return iHashCode + (mTCardPriceDetails != null ? mTCardPriceDetails.hashCode() : 0);
    }

    public String toString() {
        return "MTCardPriceResponse(card_id=" + this.card_id + ", prices=" + this.prices + ")";
    }
}
