package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/MTPriceSources;", "", "cardkingdom", "Lcom/studiolaganne/lengendarylens/MTPriceEntry;", "cardmarket", "cardmarket_public", "tcgplayer", "scryfall", "cardshpere", "<init>", "(Lcom/studiolaganne/lengendarylens/MTPriceEntry;Lcom/studiolaganne/lengendarylens/MTPriceEntry;Lcom/studiolaganne/lengendarylens/MTPriceEntry;Lcom/studiolaganne/lengendarylens/MTPriceEntry;Lcom/studiolaganne/lengendarylens/MTPriceEntry;Lcom/studiolaganne/lengendarylens/MTPriceEntry;)V", "getCardkingdom", "()Lcom/studiolaganne/lengendarylens/MTPriceEntry;", "getCardmarket", "getCardmarket_public", "setCardmarket_public", "(Lcom/studiolaganne/lengendarylens/MTPriceEntry;)V", "getTcgplayer", "getScryfall", "getCardshpere", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTPriceSources {
    public static final int $stable = 8;
    private final MTPriceEntry cardkingdom;
    private final MTPriceEntry cardmarket;
    private MTPriceEntry cardmarket_public;
    private final MTPriceEntry cardshpere;
    private final MTPriceEntry scryfall;
    private final MTPriceEntry tcgplayer;

    public MTPriceSources() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MTPriceSources(MTPriceEntry mTPriceEntry, MTPriceEntry mTPriceEntry2, MTPriceEntry mTPriceEntry3, MTPriceEntry mTPriceEntry4, MTPriceEntry mTPriceEntry5, MTPriceEntry mTPriceEntry6) {
        this.cardkingdom = mTPriceEntry;
        this.cardmarket = mTPriceEntry2;
        this.cardmarket_public = mTPriceEntry3;
        this.tcgplayer = mTPriceEntry4;
        this.scryfall = mTPriceEntry5;
        this.cardshpere = mTPriceEntry6;
    }

    public /* synthetic */ MTPriceSources(MTPriceEntry mTPriceEntry, MTPriceEntry mTPriceEntry2, MTPriceEntry mTPriceEntry3, MTPriceEntry mTPriceEntry4, MTPriceEntry mTPriceEntry5, MTPriceEntry mTPriceEntry6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTPriceEntry, (i & 2) != 0 ? null : mTPriceEntry2, (i & 4) != 0 ? null : mTPriceEntry3, (i & 8) != 0 ? null : mTPriceEntry4, (i & 16) != 0 ? null : mTPriceEntry5, (i & 32) != 0 ? null : mTPriceEntry6);
    }

    public static /* synthetic */ MTPriceSources copy$default(MTPriceSources mTPriceSources, MTPriceEntry mTPriceEntry, MTPriceEntry mTPriceEntry2, MTPriceEntry mTPriceEntry3, MTPriceEntry mTPriceEntry4, MTPriceEntry mTPriceEntry5, MTPriceEntry mTPriceEntry6, int i, Object obj) {
        if ((i & 1) != 0) {
            mTPriceEntry = mTPriceSources.cardkingdom;
        }
        if ((i & 2) != 0) {
            mTPriceEntry2 = mTPriceSources.cardmarket;
        }
        if ((i & 4) != 0) {
            mTPriceEntry3 = mTPriceSources.cardmarket_public;
        }
        if ((i & 8) != 0) {
            mTPriceEntry4 = mTPriceSources.tcgplayer;
        }
        if ((i & 16) != 0) {
            mTPriceEntry5 = mTPriceSources.scryfall;
        }
        if ((i & 32) != 0) {
            mTPriceEntry6 = mTPriceSources.cardshpere;
        }
        MTPriceEntry mTPriceEntry7 = mTPriceEntry5;
        MTPriceEntry mTPriceEntry8 = mTPriceEntry6;
        return mTPriceSources.copy(mTPriceEntry, mTPriceEntry2, mTPriceEntry3, mTPriceEntry4, mTPriceEntry7, mTPriceEntry8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTPriceEntry getCardkingdom() {
        return this.cardkingdom;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTPriceEntry getCardmarket() {
        return this.cardmarket;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTPriceEntry getCardmarket_public() {
        return this.cardmarket_public;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTPriceEntry getTcgplayer() {
        return this.tcgplayer;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTPriceEntry getScryfall() {
        return this.scryfall;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTPriceEntry getCardshpere() {
        return this.cardshpere;
    }

    public final MTPriceSources copy(MTPriceEntry cardkingdom, MTPriceEntry cardmarket, MTPriceEntry cardmarket_public, MTPriceEntry tcgplayer, MTPriceEntry scryfall, MTPriceEntry cardshpere) {
        return new MTPriceSources(cardkingdom, cardmarket, cardmarket_public, tcgplayer, scryfall, cardshpere);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTPriceSources)) {
            return false;
        }
        MTPriceSources mTPriceSources = (MTPriceSources) other;
        return Intrinsics.areEqual(this.cardkingdom, mTPriceSources.cardkingdom) && Intrinsics.areEqual(this.cardmarket, mTPriceSources.cardmarket) && Intrinsics.areEqual(this.cardmarket_public, mTPriceSources.cardmarket_public) && Intrinsics.areEqual(this.tcgplayer, mTPriceSources.tcgplayer) && Intrinsics.areEqual(this.scryfall, mTPriceSources.scryfall) && Intrinsics.areEqual(this.cardshpere, mTPriceSources.cardshpere);
    }

    public final MTPriceEntry getCardkingdom() {
        return this.cardkingdom;
    }

    public final MTPriceEntry getCardmarket() {
        return this.cardmarket;
    }

    public final MTPriceEntry getCardmarket_public() {
        return this.cardmarket_public;
    }

    public final MTPriceEntry getCardshpere() {
        return this.cardshpere;
    }

    public final MTPriceEntry getScryfall() {
        return this.scryfall;
    }

    public final MTPriceEntry getTcgplayer() {
        return this.tcgplayer;
    }

    public int hashCode() {
        MTPriceEntry mTPriceEntry = this.cardkingdom;
        int iHashCode = (mTPriceEntry == null ? 0 : mTPriceEntry.hashCode()) * 31;
        MTPriceEntry mTPriceEntry2 = this.cardmarket;
        int iHashCode2 = (iHashCode + (mTPriceEntry2 == null ? 0 : mTPriceEntry2.hashCode())) * 31;
        MTPriceEntry mTPriceEntry3 = this.cardmarket_public;
        int iHashCode3 = (iHashCode2 + (mTPriceEntry3 == null ? 0 : mTPriceEntry3.hashCode())) * 31;
        MTPriceEntry mTPriceEntry4 = this.tcgplayer;
        int iHashCode4 = (iHashCode3 + (mTPriceEntry4 == null ? 0 : mTPriceEntry4.hashCode())) * 31;
        MTPriceEntry mTPriceEntry5 = this.scryfall;
        int iHashCode5 = (iHashCode4 + (mTPriceEntry5 == null ? 0 : mTPriceEntry5.hashCode())) * 31;
        MTPriceEntry mTPriceEntry6 = this.cardshpere;
        return iHashCode5 + (mTPriceEntry6 != null ? mTPriceEntry6.hashCode() : 0);
    }

    public final void setCardmarket_public(MTPriceEntry mTPriceEntry) {
        this.cardmarket_public = mTPriceEntry;
    }

    public String toString() {
        return "MTPriceSources(cardkingdom=" + this.cardkingdom + ", cardmarket=" + this.cardmarket + ", cardmarket_public=" + this.cardmarket_public + ", tcgplayer=" + this.tcgplayer + ", scryfall=" + this.scryfall + ", cardshpere=" + this.cardshpere + ")";
    }
}
