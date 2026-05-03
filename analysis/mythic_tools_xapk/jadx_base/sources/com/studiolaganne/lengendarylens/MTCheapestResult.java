package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCheapestResult;", "", "updated", "", "restored", "deck", "Lcom/studiolaganne/lengendarylens/MTCheapestDeckResult;", "<init>", "(IILcom/studiolaganne/lengendarylens/MTCheapestDeckResult;)V", "getUpdated", "()I", "getRestored", "getDeck", "()Lcom/studiolaganne/lengendarylens/MTCheapestDeckResult;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCheapestResult {
    public static final int $stable = 8;
    private final MTCheapestDeckResult deck;
    private final int restored;
    private final int updated;

    public MTCheapestResult() {
        this(0, 0, null, 7, null);
    }

    public MTCheapestResult(int i, int i2, MTCheapestDeckResult mTCheapestDeckResult) {
        this.updated = i;
        this.restored = i2;
        this.deck = mTCheapestDeckResult;
    }

    public /* synthetic */ MTCheapestResult(int i, int i2, MTCheapestDeckResult mTCheapestDeckResult, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : mTCheapestDeckResult);
    }

    public static /* synthetic */ MTCheapestResult copy$default(MTCheapestResult mTCheapestResult, int i, int i2, MTCheapestDeckResult mTCheapestDeckResult, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTCheapestResult.updated;
        }
        if ((i3 & 2) != 0) {
            i2 = mTCheapestResult.restored;
        }
        if ((i3 & 4) != 0) {
            mTCheapestDeckResult = mTCheapestResult.deck;
        }
        return mTCheapestResult.copy(i, i2, mTCheapestDeckResult);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getUpdated() {
        return this.updated;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRestored() {
        return this.restored;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTCheapestDeckResult getDeck() {
        return this.deck;
    }

    public final MTCheapestResult copy(int updated, int restored, MTCheapestDeckResult deck) {
        return new MTCheapestResult(updated, restored, deck);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCheapestResult)) {
            return false;
        }
        MTCheapestResult mTCheapestResult = (MTCheapestResult) other;
        return this.updated == mTCheapestResult.updated && this.restored == mTCheapestResult.restored && Intrinsics.areEqual(this.deck, mTCheapestResult.deck);
    }

    public final MTCheapestDeckResult getDeck() {
        return this.deck;
    }

    public final int getRestored() {
        return this.restored;
    }

    public final int getUpdated() {
        return this.updated;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.updated) * 31) + Integer.hashCode(this.restored)) * 31;
        MTCheapestDeckResult mTCheapestDeckResult = this.deck;
        return iHashCode + (mTCheapestDeckResult == null ? 0 : mTCheapestDeckResult.hashCode());
    }

    public String toString() {
        return "MTCheapestResult(updated=" + this.updated + ", restored=" + this.restored + ", deck=" + this.deck + ")";
    }
}
