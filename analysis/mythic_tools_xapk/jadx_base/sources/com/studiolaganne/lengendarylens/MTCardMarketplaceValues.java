package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardMarketplaceValues;", "", "mythictools", "Lcom/studiolaganne/lengendarylens/MTMarketplaceFinishPrices;", "tcgplayer", "cardmarket", "cardkingdom", "cardsphere", "<init>", "(Lcom/studiolaganne/lengendarylens/MTMarketplaceFinishPrices;Lcom/studiolaganne/lengendarylens/MTMarketplaceFinishPrices;Lcom/studiolaganne/lengendarylens/MTMarketplaceFinishPrices;Lcom/studiolaganne/lengendarylens/MTMarketplaceFinishPrices;Lcom/studiolaganne/lengendarylens/MTMarketplaceFinishPrices;)V", "getMythictools", "()Lcom/studiolaganne/lengendarylens/MTMarketplaceFinishPrices;", "getTcgplayer", "getCardmarket", "getCardkingdom", "getCardsphere", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardMarketplaceValues {
    public static final int $stable = 0;
    private final MTMarketplaceFinishPrices cardkingdom;
    private final MTMarketplaceFinishPrices cardmarket;
    private final MTMarketplaceFinishPrices cardsphere;
    private final MTMarketplaceFinishPrices mythictools;
    private final MTMarketplaceFinishPrices tcgplayer;

    public MTCardMarketplaceValues() {
        this(null, null, null, null, null, 31, null);
    }

    public MTCardMarketplaceValues(MTMarketplaceFinishPrices mTMarketplaceFinishPrices, MTMarketplaceFinishPrices mTMarketplaceFinishPrices2, MTMarketplaceFinishPrices mTMarketplaceFinishPrices3, MTMarketplaceFinishPrices mTMarketplaceFinishPrices4, MTMarketplaceFinishPrices mTMarketplaceFinishPrices5) {
        this.mythictools = mTMarketplaceFinishPrices;
        this.tcgplayer = mTMarketplaceFinishPrices2;
        this.cardmarket = mTMarketplaceFinishPrices3;
        this.cardkingdom = mTMarketplaceFinishPrices4;
        this.cardsphere = mTMarketplaceFinishPrices5;
    }

    public /* synthetic */ MTCardMarketplaceValues(MTMarketplaceFinishPrices mTMarketplaceFinishPrices, MTMarketplaceFinishPrices mTMarketplaceFinishPrices2, MTMarketplaceFinishPrices mTMarketplaceFinishPrices3, MTMarketplaceFinishPrices mTMarketplaceFinishPrices4, MTMarketplaceFinishPrices mTMarketplaceFinishPrices5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTMarketplaceFinishPrices, (i & 2) != 0 ? null : mTMarketplaceFinishPrices2, (i & 4) != 0 ? null : mTMarketplaceFinishPrices3, (i & 8) != 0 ? null : mTMarketplaceFinishPrices4, (i & 16) != 0 ? null : mTMarketplaceFinishPrices5);
    }

    public static /* synthetic */ MTCardMarketplaceValues copy$default(MTCardMarketplaceValues mTCardMarketplaceValues, MTMarketplaceFinishPrices mTMarketplaceFinishPrices, MTMarketplaceFinishPrices mTMarketplaceFinishPrices2, MTMarketplaceFinishPrices mTMarketplaceFinishPrices3, MTMarketplaceFinishPrices mTMarketplaceFinishPrices4, MTMarketplaceFinishPrices mTMarketplaceFinishPrices5, int i, Object obj) {
        if ((i & 1) != 0) {
            mTMarketplaceFinishPrices = mTCardMarketplaceValues.mythictools;
        }
        if ((i & 2) != 0) {
            mTMarketplaceFinishPrices2 = mTCardMarketplaceValues.tcgplayer;
        }
        if ((i & 4) != 0) {
            mTMarketplaceFinishPrices3 = mTCardMarketplaceValues.cardmarket;
        }
        if ((i & 8) != 0) {
            mTMarketplaceFinishPrices4 = mTCardMarketplaceValues.cardkingdom;
        }
        if ((i & 16) != 0) {
            mTMarketplaceFinishPrices5 = mTCardMarketplaceValues.cardsphere;
        }
        MTMarketplaceFinishPrices mTMarketplaceFinishPrices6 = mTMarketplaceFinishPrices5;
        MTMarketplaceFinishPrices mTMarketplaceFinishPrices7 = mTMarketplaceFinishPrices3;
        return mTCardMarketplaceValues.copy(mTMarketplaceFinishPrices, mTMarketplaceFinishPrices2, mTMarketplaceFinishPrices7, mTMarketplaceFinishPrices4, mTMarketplaceFinishPrices6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTMarketplaceFinishPrices getMythictools() {
        return this.mythictools;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTMarketplaceFinishPrices getTcgplayer() {
        return this.tcgplayer;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTMarketplaceFinishPrices getCardmarket() {
        return this.cardmarket;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTMarketplaceFinishPrices getCardkingdom() {
        return this.cardkingdom;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTMarketplaceFinishPrices getCardsphere() {
        return this.cardsphere;
    }

    public final MTCardMarketplaceValues copy(MTMarketplaceFinishPrices mythictools, MTMarketplaceFinishPrices tcgplayer, MTMarketplaceFinishPrices cardmarket, MTMarketplaceFinishPrices cardkingdom, MTMarketplaceFinishPrices cardsphere) {
        return new MTCardMarketplaceValues(mythictools, tcgplayer, cardmarket, cardkingdom, cardsphere);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardMarketplaceValues)) {
            return false;
        }
        MTCardMarketplaceValues mTCardMarketplaceValues = (MTCardMarketplaceValues) other;
        return Intrinsics.areEqual(this.mythictools, mTCardMarketplaceValues.mythictools) && Intrinsics.areEqual(this.tcgplayer, mTCardMarketplaceValues.tcgplayer) && Intrinsics.areEqual(this.cardmarket, mTCardMarketplaceValues.cardmarket) && Intrinsics.areEqual(this.cardkingdom, mTCardMarketplaceValues.cardkingdom) && Intrinsics.areEqual(this.cardsphere, mTCardMarketplaceValues.cardsphere);
    }

    public final MTMarketplaceFinishPrices getCardkingdom() {
        return this.cardkingdom;
    }

    public final MTMarketplaceFinishPrices getCardmarket() {
        return this.cardmarket;
    }

    public final MTMarketplaceFinishPrices getCardsphere() {
        return this.cardsphere;
    }

    public final MTMarketplaceFinishPrices getMythictools() {
        return this.mythictools;
    }

    public final MTMarketplaceFinishPrices getTcgplayer() {
        return this.tcgplayer;
    }

    public int hashCode() {
        MTMarketplaceFinishPrices mTMarketplaceFinishPrices = this.mythictools;
        int iHashCode = (mTMarketplaceFinishPrices == null ? 0 : mTMarketplaceFinishPrices.hashCode()) * 31;
        MTMarketplaceFinishPrices mTMarketplaceFinishPrices2 = this.tcgplayer;
        int iHashCode2 = (iHashCode + (mTMarketplaceFinishPrices2 == null ? 0 : mTMarketplaceFinishPrices2.hashCode())) * 31;
        MTMarketplaceFinishPrices mTMarketplaceFinishPrices3 = this.cardmarket;
        int iHashCode3 = (iHashCode2 + (mTMarketplaceFinishPrices3 == null ? 0 : mTMarketplaceFinishPrices3.hashCode())) * 31;
        MTMarketplaceFinishPrices mTMarketplaceFinishPrices4 = this.cardkingdom;
        int iHashCode4 = (iHashCode3 + (mTMarketplaceFinishPrices4 == null ? 0 : mTMarketplaceFinishPrices4.hashCode())) * 31;
        MTMarketplaceFinishPrices mTMarketplaceFinishPrices5 = this.cardsphere;
        return iHashCode4 + (mTMarketplaceFinishPrices5 != null ? mTMarketplaceFinishPrices5.hashCode() : 0);
    }

    public String toString() {
        return "MTCardMarketplaceValues(mythictools=" + this.mythictools + ", tcgplayer=" + this.tcgplayer + ", cardmarket=" + this.cardmarket + ", cardkingdom=" + this.cardkingdom + ", cardsphere=" + this.cardsphere + ")";
    }
}
