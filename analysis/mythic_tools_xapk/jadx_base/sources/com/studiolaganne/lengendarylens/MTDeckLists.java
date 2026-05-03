package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeckLists;", "", "main", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "sideboard", "maybeboard", "<init>", "(Lcom/studiolaganne/lengendarylens/MTCardContainer;Lcom/studiolaganne/lengendarylens/MTCardContainer;Lcom/studiolaganne/lengendarylens/MTCardContainer;)V", "getMain", "()Lcom/studiolaganne/lengendarylens/MTCardContainer;", "setMain", "(Lcom/studiolaganne/lengendarylens/MTCardContainer;)V", "getSideboard", "setSideboard", "getMaybeboard", "setMaybeboard", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeckLists {
    public static final int $stable = 8;
    private MTCardContainer main;
    private MTCardContainer maybeboard;
    private MTCardContainer sideboard;

    public MTDeckLists() {
        this(null, null, null, 7, null);
    }

    public MTDeckLists(MTCardContainer mTCardContainer, MTCardContainer mTCardContainer2, MTCardContainer mTCardContainer3) {
        this.main = mTCardContainer;
        this.sideboard = mTCardContainer2;
        this.maybeboard = mTCardContainer3;
    }

    public /* synthetic */ MTDeckLists(MTCardContainer mTCardContainer, MTCardContainer mTCardContainer2, MTCardContainer mTCardContainer3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTCardContainer, (i & 2) != 0 ? null : mTCardContainer2, (i & 4) != 0 ? null : mTCardContainer3);
    }

    public static /* synthetic */ MTDeckLists copy$default(MTDeckLists mTDeckLists, MTCardContainer mTCardContainer, MTCardContainer mTCardContainer2, MTCardContainer mTCardContainer3, int i, Object obj) {
        if ((i & 1) != 0) {
            mTCardContainer = mTDeckLists.main;
        }
        if ((i & 2) != 0) {
            mTCardContainer2 = mTDeckLists.sideboard;
        }
        if ((i & 4) != 0) {
            mTCardContainer3 = mTDeckLists.maybeboard;
        }
        return mTDeckLists.copy(mTCardContainer, mTCardContainer2, mTCardContainer3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTCardContainer getMain() {
        return this.main;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTCardContainer getSideboard() {
        return this.sideboard;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTCardContainer getMaybeboard() {
        return this.maybeboard;
    }

    public final MTDeckLists copy(MTCardContainer main, MTCardContainer sideboard, MTCardContainer maybeboard) {
        return new MTDeckLists(main, sideboard, maybeboard);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeckLists)) {
            return false;
        }
        MTDeckLists mTDeckLists = (MTDeckLists) other;
        return Intrinsics.areEqual(this.main, mTDeckLists.main) && Intrinsics.areEqual(this.sideboard, mTDeckLists.sideboard) && Intrinsics.areEqual(this.maybeboard, mTDeckLists.maybeboard);
    }

    public final MTCardContainer getMain() {
        return this.main;
    }

    public final MTCardContainer getMaybeboard() {
        return this.maybeboard;
    }

    public final MTCardContainer getSideboard() {
        return this.sideboard;
    }

    public int hashCode() {
        MTCardContainer mTCardContainer = this.main;
        int iHashCode = (mTCardContainer == null ? 0 : mTCardContainer.hashCode()) * 31;
        MTCardContainer mTCardContainer2 = this.sideboard;
        int iHashCode2 = (iHashCode + (mTCardContainer2 == null ? 0 : mTCardContainer2.hashCode())) * 31;
        MTCardContainer mTCardContainer3 = this.maybeboard;
        return iHashCode2 + (mTCardContainer3 != null ? mTCardContainer3.hashCode() : 0);
    }

    public final void setMain(MTCardContainer mTCardContainer) {
        this.main = mTCardContainer;
    }

    public final void setMaybeboard(MTCardContainer mTCardContainer) {
        this.maybeboard = mTCardContainer;
    }

    public final void setSideboard(MTCardContainer mTCardContainer) {
        this.sideboard = mTCardContainer;
    }

    public String toString() {
        return "MTDeckLists(main=" + this.main + ", sideboard=" + this.sideboard + ", maybeboard=" + this.maybeboard + ")";
    }
}
