package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardPriceDetails;", "", "EUR", "Lcom/studiolaganne/lengendarylens/MTCurrencyPriceDetails;", "USD", "<init>", "(Lcom/studiolaganne/lengendarylens/MTCurrencyPriceDetails;Lcom/studiolaganne/lengendarylens/MTCurrencyPriceDetails;)V", "getEUR", "()Lcom/studiolaganne/lengendarylens/MTCurrencyPriceDetails;", "getUSD", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardPriceDetails {
    public static final int $stable = 8;
    private final MTCurrencyPriceDetails EUR;
    private final MTCurrencyPriceDetails USD;

    /* JADX WARN: Multi-variable type inference failed */
    public MTCardPriceDetails() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTCardPriceDetails(MTCurrencyPriceDetails mTCurrencyPriceDetails, MTCurrencyPriceDetails mTCurrencyPriceDetails2) {
        this.EUR = mTCurrencyPriceDetails;
        this.USD = mTCurrencyPriceDetails2;
    }

    public /* synthetic */ MTCardPriceDetails(MTCurrencyPriceDetails mTCurrencyPriceDetails, MTCurrencyPriceDetails mTCurrencyPriceDetails2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTCurrencyPriceDetails, (i & 2) != 0 ? null : mTCurrencyPriceDetails2);
    }

    public static /* synthetic */ MTCardPriceDetails copy$default(MTCardPriceDetails mTCardPriceDetails, MTCurrencyPriceDetails mTCurrencyPriceDetails, MTCurrencyPriceDetails mTCurrencyPriceDetails2, int i, Object obj) {
        if ((i & 1) != 0) {
            mTCurrencyPriceDetails = mTCardPriceDetails.EUR;
        }
        if ((i & 2) != 0) {
            mTCurrencyPriceDetails2 = mTCardPriceDetails.USD;
        }
        return mTCardPriceDetails.copy(mTCurrencyPriceDetails, mTCurrencyPriceDetails2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTCurrencyPriceDetails getEUR() {
        return this.EUR;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTCurrencyPriceDetails getUSD() {
        return this.USD;
    }

    public final MTCardPriceDetails copy(MTCurrencyPriceDetails EUR, MTCurrencyPriceDetails USD) {
        return new MTCardPriceDetails(EUR, USD);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardPriceDetails)) {
            return false;
        }
        MTCardPriceDetails mTCardPriceDetails = (MTCardPriceDetails) other;
        return Intrinsics.areEqual(this.EUR, mTCardPriceDetails.EUR) && Intrinsics.areEqual(this.USD, mTCardPriceDetails.USD);
    }

    public final MTCurrencyPriceDetails getEUR() {
        return this.EUR;
    }

    public final MTCurrencyPriceDetails getUSD() {
        return this.USD;
    }

    public int hashCode() {
        MTCurrencyPriceDetails mTCurrencyPriceDetails = this.EUR;
        int iHashCode = (mTCurrencyPriceDetails == null ? 0 : mTCurrencyPriceDetails.hashCode()) * 31;
        MTCurrencyPriceDetails mTCurrencyPriceDetails2 = this.USD;
        return iHashCode + (mTCurrencyPriceDetails2 != null ? mTCurrencyPriceDetails2.hashCode() : 0);
    }

    public String toString() {
        return "MTCardPriceDetails(EUR=" + this.EUR + ", USD=" + this.USD + ")";
    }
}
