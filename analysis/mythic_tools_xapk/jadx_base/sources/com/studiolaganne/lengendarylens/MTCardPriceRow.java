package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardPriceAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardPriceRow;", "", "<init>", "()V", "MarketplaceHeader", "PriceRow", "Lcom/studiolaganne/lengendarylens/MTCardPriceRow$MarketplaceHeader;", "Lcom/studiolaganne/lengendarylens/MTCardPriceRow$PriceRow;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class MTCardPriceRow {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: MTCardPriceAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardPriceRow$MarketplaceHeader;", "Lcom/studiolaganne/lengendarylens/MTCardPriceRow;", "marketplaceIconRes", "", "marketplaceName", "", "<init>", "(ILjava/lang/String;)V", "getMarketplaceIconRes", "()I", "getMarketplaceName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MarketplaceHeader extends MTCardPriceRow {
        public static final int $stable = 0;
        private final int marketplaceIconRes;
        private final String marketplaceName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MarketplaceHeader(int i, String marketplaceName) {
            super(null);
            Intrinsics.checkNotNullParameter(marketplaceName, "marketplaceName");
            this.marketplaceIconRes = i;
            this.marketplaceName = marketplaceName;
        }

        public static /* synthetic */ MarketplaceHeader copy$default(MarketplaceHeader marketplaceHeader, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = marketplaceHeader.marketplaceIconRes;
            }
            if ((i2 & 2) != 0) {
                str = marketplaceHeader.marketplaceName;
            }
            return marketplaceHeader.copy(i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getMarketplaceIconRes() {
            return this.marketplaceIconRes;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMarketplaceName() {
            return this.marketplaceName;
        }

        public final MarketplaceHeader copy(int marketplaceIconRes, String marketplaceName) {
            Intrinsics.checkNotNullParameter(marketplaceName, "marketplaceName");
            return new MarketplaceHeader(marketplaceIconRes, marketplaceName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MarketplaceHeader)) {
                return false;
            }
            MarketplaceHeader marketplaceHeader = (MarketplaceHeader) other;
            return this.marketplaceIconRes == marketplaceHeader.marketplaceIconRes && Intrinsics.areEqual(this.marketplaceName, marketplaceHeader.marketplaceName);
        }

        public final int getMarketplaceIconRes() {
            return this.marketplaceIconRes;
        }

        public final String getMarketplaceName() {
            return this.marketplaceName;
        }

        public int hashCode() {
            return (Integer.hashCode(this.marketplaceIconRes) * 31) + this.marketplaceName.hashCode();
        }

        public String toString() {
            return "MarketplaceHeader(marketplaceIconRes=" + this.marketplaceIconRes + ", marketplaceName=" + this.marketplaceName + ")";
        }
    }

    /* JADX INFO: compiled from: MTCardPriceAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardPriceRow$PriceRow;", "Lcom/studiolaganne/lengendarylens/MTCardPriceRow;", "isFoil", "", "finishLabel", "", FirebaseAnalytics.Param.PRICE, "isFirstRow", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Z)V", "()Z", "getFinishLabel", "()Ljava/lang/String;", "getPrice", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PriceRow extends MTCardPriceRow {
        public static final int $stable = 0;
        private final String finishLabel;
        private final boolean isFirstRow;
        private final boolean isFoil;
        private final String price;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PriceRow(boolean z, String finishLabel, String str, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(finishLabel, "finishLabel");
            this.isFoil = z;
            this.finishLabel = finishLabel;
            this.price = str;
            this.isFirstRow = z2;
        }

        public /* synthetic */ PriceRow(boolean z, String str, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z2);
        }

        public static /* synthetic */ PriceRow copy$default(PriceRow priceRow, boolean z, String str, String str2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = priceRow.isFoil;
            }
            if ((i & 2) != 0) {
                str = priceRow.finishLabel;
            }
            if ((i & 4) != 0) {
                str2 = priceRow.price;
            }
            if ((i & 8) != 0) {
                z2 = priceRow.isFirstRow;
            }
            return priceRow.copy(z, str, str2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsFoil() {
            return this.isFoil;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFinishLabel() {
            return this.finishLabel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPrice() {
            return this.price;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsFirstRow() {
            return this.isFirstRow;
        }

        public final PriceRow copy(boolean isFoil, String finishLabel, String price, boolean isFirstRow) {
            Intrinsics.checkNotNullParameter(finishLabel, "finishLabel");
            return new PriceRow(isFoil, finishLabel, price, isFirstRow);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PriceRow)) {
                return false;
            }
            PriceRow priceRow = (PriceRow) other;
            return this.isFoil == priceRow.isFoil && Intrinsics.areEqual(this.finishLabel, priceRow.finishLabel) && Intrinsics.areEqual(this.price, priceRow.price) && this.isFirstRow == priceRow.isFirstRow;
        }

        public final String getFinishLabel() {
            return this.finishLabel;
        }

        public final String getPrice() {
            return this.price;
        }

        public int hashCode() {
            int iHashCode = ((Boolean.hashCode(this.isFoil) * 31) + this.finishLabel.hashCode()) * 31;
            String str = this.price;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isFirstRow);
        }

        public final boolean isFirstRow() {
            return this.isFirstRow;
        }

        public final boolean isFoil() {
            return this.isFoil;
        }

        public String toString() {
            return "PriceRow(isFoil=" + this.isFoil + ", finishLabel=" + this.finishLabel + ", price=" + this.price + ", isFirstRow=" + this.isFirstRow + ")";
        }
    }

    private MTCardPriceRow() {
    }

    public /* synthetic */ MTCardPriceRow(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
