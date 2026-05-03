package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScanFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J.\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"com/studiolaganne/lengendarylens/ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo", "", "prices", "Lcom/studiolaganne/lengendarylens/MTMarketplaceFinishPrices;", "iconRes", "", "nameResId", "<init>", "(Lcom/studiolaganne/lengendarylens/MTMarketplaceFinishPrices;II)V", "getPrices", "()Lcom/studiolaganne/lengendarylens/MTMarketplaceFinishPrices;", "getIconRes", "()I", "getNameResId", "component1", "component2", "component3", "copy", "(Lcom/studiolaganne/lengendarylens/MTMarketplaceFinishPrices;II)Lcom/studiolaganne/lengendarylens/ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo {
    private final int iconRes;
    private final int nameResId;
    private final MTMarketplaceFinishPrices prices;

    public ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo(MTMarketplaceFinishPrices mTMarketplaceFinishPrices, int i, int i2) {
        this.prices = mTMarketplaceFinishPrices;
        this.iconRes = i;
        this.nameResId = i2;
    }

    public static /* synthetic */ ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo copy$default(ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo, MTMarketplaceFinishPrices mTMarketplaceFinishPrices, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            mTMarketplaceFinishPrices = scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.prices;
        }
        if ((i3 & 2) != 0) {
            i = scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.iconRes;
        }
        if ((i3 & 4) != 0) {
            i2 = scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.nameResId;
        }
        return scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.copy(mTMarketplaceFinishPrices, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTMarketplaceFinishPrices getPrices() {
        return this.prices;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getNameResId() {
        return this.nameResId;
    }

    public final ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo copy(MTMarketplaceFinishPrices prices, int iconRes, int nameResId) {
        return new ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo(prices, iconRes, nameResId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo)) {
            return false;
        }
        ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo = (ScanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo) other;
        return Intrinsics.areEqual(this.prices, scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.prices) && this.iconRes == scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.iconRes && this.nameResId == scanFragment$updatePricesRecyclerView$1$1$MarketplaceInfo.nameResId;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getNameResId() {
        return this.nameResId;
    }

    public final MTMarketplaceFinishPrices getPrices() {
        return this.prices;
    }

    public int hashCode() {
        MTMarketplaceFinishPrices mTMarketplaceFinishPrices = this.prices;
        return ((((mTMarketplaceFinishPrices == null ? 0 : mTMarketplaceFinishPrices.hashCode()) * 31) + Integer.hashCode(this.iconRes)) * 31) + Integer.hashCode(this.nameResId);
    }

    public String toString() {
        return "MarketplaceInfo(prices=" + this.prices + ", iconRes=" + this.iconRes + ", nameResId=" + this.nameResId + ")";
    }
}
