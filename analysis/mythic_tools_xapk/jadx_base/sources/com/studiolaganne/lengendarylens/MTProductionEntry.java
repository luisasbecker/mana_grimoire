package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTProductionEntry;", "", "cards", "", "symbols", "<init>", "(II)V", "getCards", "()I", "getSymbols", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTProductionEntry {
    public static final int $stable = 0;
    private final int cards;
    private final int symbols;

    public MTProductionEntry(int i, int i2) {
        this.cards = i;
        this.symbols = i2;
    }

    public static /* synthetic */ MTProductionEntry copy$default(MTProductionEntry mTProductionEntry, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTProductionEntry.cards;
        }
        if ((i3 & 2) != 0) {
            i2 = mTProductionEntry.symbols;
        }
        return mTProductionEntry.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCards() {
        return this.cards;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSymbols() {
        return this.symbols;
    }

    public final MTProductionEntry copy(int cards, int symbols) {
        return new MTProductionEntry(cards, symbols);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTProductionEntry)) {
            return false;
        }
        MTProductionEntry mTProductionEntry = (MTProductionEntry) other;
        return this.cards == mTProductionEntry.cards && this.symbols == mTProductionEntry.symbols;
    }

    public final int getCards() {
        return this.cards;
    }

    public final int getSymbols() {
        return this.symbols;
    }

    public int hashCode() {
        return (Integer.hashCode(this.cards) * 31) + Integer.hashCode(this.symbols);
    }

    public String toString() {
        return "MTProductionEntry(cards=" + this.cards + ", symbols=" + this.symbols + ")";
    }
}
