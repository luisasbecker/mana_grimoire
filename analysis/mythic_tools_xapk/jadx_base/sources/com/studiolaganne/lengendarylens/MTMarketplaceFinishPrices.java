package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTMarketplaceFinishPrices;", "", "nonfoil", "", "foil", "etched", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getNonfoil", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getFoil", "getEtched", "component1", "component2", "component3", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTMarketplaceFinishPrices;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTMarketplaceFinishPrices {
    public static final int $stable = 0;
    private final Double etched;
    private final Double foil;
    private final Double nonfoil;

    public MTMarketplaceFinishPrices() {
        this(null, null, null, 7, null);
    }

    public MTMarketplaceFinishPrices(Double d, Double d2, Double d3) {
        this.nonfoil = d;
        this.foil = d2;
        this.etched = d3;
    }

    public /* synthetic */ MTMarketplaceFinishPrices(Double d, Double d2, Double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2, (i & 4) != 0 ? null : d3);
    }

    public static /* synthetic */ MTMarketplaceFinishPrices copy$default(MTMarketplaceFinishPrices mTMarketplaceFinishPrices, Double d, Double d2, Double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            d = mTMarketplaceFinishPrices.nonfoil;
        }
        if ((i & 2) != 0) {
            d2 = mTMarketplaceFinishPrices.foil;
        }
        if ((i & 4) != 0) {
            d3 = mTMarketplaceFinishPrices.etched;
        }
        return mTMarketplaceFinishPrices.copy(d, d2, d3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getNonfoil() {
        return this.nonfoil;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getFoil() {
        return this.foil;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getEtched() {
        return this.etched;
    }

    public final MTMarketplaceFinishPrices copy(Double nonfoil, Double foil, Double etched) {
        return new MTMarketplaceFinishPrices(nonfoil, foil, etched);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTMarketplaceFinishPrices)) {
            return false;
        }
        MTMarketplaceFinishPrices mTMarketplaceFinishPrices = (MTMarketplaceFinishPrices) other;
        return Intrinsics.areEqual((Object) this.nonfoil, (Object) mTMarketplaceFinishPrices.nonfoil) && Intrinsics.areEqual((Object) this.foil, (Object) mTMarketplaceFinishPrices.foil) && Intrinsics.areEqual((Object) this.etched, (Object) mTMarketplaceFinishPrices.etched);
    }

    public final Double getEtched() {
        return this.etched;
    }

    public final Double getFoil() {
        return this.foil;
    }

    public final Double getNonfoil() {
        return this.nonfoil;
    }

    public int hashCode() {
        Double d = this.nonfoil;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.foil;
        int iHashCode2 = (iHashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.etched;
        return iHashCode2 + (d3 != null ? d3.hashCode() : 0);
    }

    public String toString() {
        return "MTMarketplaceFinishPrices(nonfoil=" + this.nonfoil + ", foil=" + this.foil + ", etched=" + this.etched + ")";
    }
}
