package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCurrencyPriceDetails;", "", "foil", "Lcom/studiolaganne/lengendarylens/MTPriceDetails;", "nonfoil", "etched", "<init>", "(Lcom/studiolaganne/lengendarylens/MTPriceDetails;Lcom/studiolaganne/lengendarylens/MTPriceDetails;Lcom/studiolaganne/lengendarylens/MTPriceDetails;)V", "getFoil", "()Lcom/studiolaganne/lengendarylens/MTPriceDetails;", "getNonfoil", "getEtched", "setEtched", "(Lcom/studiolaganne/lengendarylens/MTPriceDetails;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCurrencyPriceDetails {
    public static final int $stable = 8;
    private MTPriceDetails etched;
    private final MTPriceDetails foil;
    private final MTPriceDetails nonfoil;

    public MTCurrencyPriceDetails() {
        this(null, null, null, 7, null);
    }

    public MTCurrencyPriceDetails(MTPriceDetails mTPriceDetails, MTPriceDetails mTPriceDetails2, MTPriceDetails mTPriceDetails3) {
        this.foil = mTPriceDetails;
        this.nonfoil = mTPriceDetails2;
        this.etched = mTPriceDetails3;
    }

    public /* synthetic */ MTCurrencyPriceDetails(MTPriceDetails mTPriceDetails, MTPriceDetails mTPriceDetails2, MTPriceDetails mTPriceDetails3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTPriceDetails, (i & 2) != 0 ? null : mTPriceDetails2, (i & 4) != 0 ? null : mTPriceDetails3);
    }

    public static /* synthetic */ MTCurrencyPriceDetails copy$default(MTCurrencyPriceDetails mTCurrencyPriceDetails, MTPriceDetails mTPriceDetails, MTPriceDetails mTPriceDetails2, MTPriceDetails mTPriceDetails3, int i, Object obj) {
        if ((i & 1) != 0) {
            mTPriceDetails = mTCurrencyPriceDetails.foil;
        }
        if ((i & 2) != 0) {
            mTPriceDetails2 = mTCurrencyPriceDetails.nonfoil;
        }
        if ((i & 4) != 0) {
            mTPriceDetails3 = mTCurrencyPriceDetails.etched;
        }
        return mTCurrencyPriceDetails.copy(mTPriceDetails, mTPriceDetails2, mTPriceDetails3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTPriceDetails getFoil() {
        return this.foil;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTPriceDetails getNonfoil() {
        return this.nonfoil;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTPriceDetails getEtched() {
        return this.etched;
    }

    public final MTCurrencyPriceDetails copy(MTPriceDetails foil, MTPriceDetails nonfoil, MTPriceDetails etched) {
        return new MTCurrencyPriceDetails(foil, nonfoil, etched);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCurrencyPriceDetails)) {
            return false;
        }
        MTCurrencyPriceDetails mTCurrencyPriceDetails = (MTCurrencyPriceDetails) other;
        return Intrinsics.areEqual(this.foil, mTCurrencyPriceDetails.foil) && Intrinsics.areEqual(this.nonfoil, mTCurrencyPriceDetails.nonfoil) && Intrinsics.areEqual(this.etched, mTCurrencyPriceDetails.etched);
    }

    public final MTPriceDetails getEtched() {
        return this.etched;
    }

    public final MTPriceDetails getFoil() {
        return this.foil;
    }

    public final MTPriceDetails getNonfoil() {
        return this.nonfoil;
    }

    public int hashCode() {
        MTPriceDetails mTPriceDetails = this.foil;
        int iHashCode = (mTPriceDetails == null ? 0 : mTPriceDetails.hashCode()) * 31;
        MTPriceDetails mTPriceDetails2 = this.nonfoil;
        int iHashCode2 = (iHashCode + (mTPriceDetails2 == null ? 0 : mTPriceDetails2.hashCode())) * 31;
        MTPriceDetails mTPriceDetails3 = this.etched;
        return iHashCode2 + (mTPriceDetails3 != null ? mTPriceDetails3.hashCode() : 0);
    }

    public final void setEtched(MTPriceDetails mTPriceDetails) {
        this.etched = mTPriceDetails;
    }

    public String toString() {
        return "MTCurrencyPriceDetails(foil=" + this.foil + ", nonfoil=" + this.nonfoil + ", etched=" + this.etched + ")";
    }
}
