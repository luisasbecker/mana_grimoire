package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006&"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeckValues;", "", "raw", "Lcom/studiolaganne/lengendarylens/MTDeckValueItems;", "unowned", "cheapest_printing", "collection_owned_exact", "Lcom/studiolaganne/lengendarylens/MTDeckCardCounts;", "collection_owned_any", "<init>", "(Lcom/studiolaganne/lengendarylens/MTDeckValueItems;Lcom/studiolaganne/lengendarylens/MTDeckValueItems;Lcom/studiolaganne/lengendarylens/MTDeckValueItems;Lcom/studiolaganne/lengendarylens/MTDeckCardCounts;Lcom/studiolaganne/lengendarylens/MTDeckCardCounts;)V", "getRaw", "()Lcom/studiolaganne/lengendarylens/MTDeckValueItems;", "setRaw", "(Lcom/studiolaganne/lengendarylens/MTDeckValueItems;)V", "getUnowned", "setUnowned", "getCheapest_printing", "setCheapest_printing", "getCollection_owned_exact", "()Lcom/studiolaganne/lengendarylens/MTDeckCardCounts;", "setCollection_owned_exact", "(Lcom/studiolaganne/lengendarylens/MTDeckCardCounts;)V", "getCollection_owned_any", "setCollection_owned_any", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeckValues {
    public static final int $stable = 8;
    private MTDeckValueItems cheapest_printing;
    private MTDeckCardCounts collection_owned_any;
    private MTDeckCardCounts collection_owned_exact;
    private MTDeckValueItems raw;
    private MTDeckValueItems unowned;

    public MTDeckValues() {
        this(null, null, null, null, null, 31, null);
    }

    public MTDeckValues(MTDeckValueItems mTDeckValueItems, MTDeckValueItems mTDeckValueItems2, MTDeckValueItems mTDeckValueItems3, MTDeckCardCounts mTDeckCardCounts, MTDeckCardCounts mTDeckCardCounts2) {
        this.raw = mTDeckValueItems;
        this.unowned = mTDeckValueItems2;
        this.cheapest_printing = mTDeckValueItems3;
        this.collection_owned_exact = mTDeckCardCounts;
        this.collection_owned_any = mTDeckCardCounts2;
    }

    public /* synthetic */ MTDeckValues(MTDeckValueItems mTDeckValueItems, MTDeckValueItems mTDeckValueItems2, MTDeckValueItems mTDeckValueItems3, MTDeckCardCounts mTDeckCardCounts, MTDeckCardCounts mTDeckCardCounts2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTDeckValueItems, (i & 2) != 0 ? null : mTDeckValueItems2, (i & 4) != 0 ? null : mTDeckValueItems3, (i & 8) != 0 ? null : mTDeckCardCounts, (i & 16) != 0 ? null : mTDeckCardCounts2);
    }

    public static /* synthetic */ MTDeckValues copy$default(MTDeckValues mTDeckValues, MTDeckValueItems mTDeckValueItems, MTDeckValueItems mTDeckValueItems2, MTDeckValueItems mTDeckValueItems3, MTDeckCardCounts mTDeckCardCounts, MTDeckCardCounts mTDeckCardCounts2, int i, Object obj) {
        if ((i & 1) != 0) {
            mTDeckValueItems = mTDeckValues.raw;
        }
        if ((i & 2) != 0) {
            mTDeckValueItems2 = mTDeckValues.unowned;
        }
        if ((i & 4) != 0) {
            mTDeckValueItems3 = mTDeckValues.cheapest_printing;
        }
        if ((i & 8) != 0) {
            mTDeckCardCounts = mTDeckValues.collection_owned_exact;
        }
        if ((i & 16) != 0) {
            mTDeckCardCounts2 = mTDeckValues.collection_owned_any;
        }
        MTDeckCardCounts mTDeckCardCounts3 = mTDeckCardCounts2;
        MTDeckValueItems mTDeckValueItems4 = mTDeckValueItems3;
        return mTDeckValues.copy(mTDeckValueItems, mTDeckValueItems2, mTDeckValueItems4, mTDeckCardCounts, mTDeckCardCounts3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTDeckValueItems getRaw() {
        return this.raw;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTDeckValueItems getUnowned() {
        return this.unowned;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTDeckValueItems getCheapest_printing() {
        return this.cheapest_printing;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTDeckCardCounts getCollection_owned_exact() {
        return this.collection_owned_exact;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTDeckCardCounts getCollection_owned_any() {
        return this.collection_owned_any;
    }

    public final MTDeckValues copy(MTDeckValueItems raw, MTDeckValueItems unowned, MTDeckValueItems cheapest_printing, MTDeckCardCounts collection_owned_exact, MTDeckCardCounts collection_owned_any) {
        return new MTDeckValues(raw, unowned, cheapest_printing, collection_owned_exact, collection_owned_any);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeckValues)) {
            return false;
        }
        MTDeckValues mTDeckValues = (MTDeckValues) other;
        return Intrinsics.areEqual(this.raw, mTDeckValues.raw) && Intrinsics.areEqual(this.unowned, mTDeckValues.unowned) && Intrinsics.areEqual(this.cheapest_printing, mTDeckValues.cheapest_printing) && Intrinsics.areEqual(this.collection_owned_exact, mTDeckValues.collection_owned_exact) && Intrinsics.areEqual(this.collection_owned_any, mTDeckValues.collection_owned_any);
    }

    public final MTDeckValueItems getCheapest_printing() {
        return this.cheapest_printing;
    }

    public final MTDeckCardCounts getCollection_owned_any() {
        return this.collection_owned_any;
    }

    public final MTDeckCardCounts getCollection_owned_exact() {
        return this.collection_owned_exact;
    }

    public final MTDeckValueItems getRaw() {
        return this.raw;
    }

    public final MTDeckValueItems getUnowned() {
        return this.unowned;
    }

    public int hashCode() {
        MTDeckValueItems mTDeckValueItems = this.raw;
        int iHashCode = (mTDeckValueItems == null ? 0 : mTDeckValueItems.hashCode()) * 31;
        MTDeckValueItems mTDeckValueItems2 = this.unowned;
        int iHashCode2 = (iHashCode + (mTDeckValueItems2 == null ? 0 : mTDeckValueItems2.hashCode())) * 31;
        MTDeckValueItems mTDeckValueItems3 = this.cheapest_printing;
        int iHashCode3 = (iHashCode2 + (mTDeckValueItems3 == null ? 0 : mTDeckValueItems3.hashCode())) * 31;
        MTDeckCardCounts mTDeckCardCounts = this.collection_owned_exact;
        int iHashCode4 = (iHashCode3 + (mTDeckCardCounts == null ? 0 : mTDeckCardCounts.hashCode())) * 31;
        MTDeckCardCounts mTDeckCardCounts2 = this.collection_owned_any;
        return iHashCode4 + (mTDeckCardCounts2 != null ? mTDeckCardCounts2.hashCode() : 0);
    }

    public final void setCheapest_printing(MTDeckValueItems mTDeckValueItems) {
        this.cheapest_printing = mTDeckValueItems;
    }

    public final void setCollection_owned_any(MTDeckCardCounts mTDeckCardCounts) {
        this.collection_owned_any = mTDeckCardCounts;
    }

    public final void setCollection_owned_exact(MTDeckCardCounts mTDeckCardCounts) {
        this.collection_owned_exact = mTDeckCardCounts;
    }

    public final void setRaw(MTDeckValueItems mTDeckValueItems) {
        this.raw = mTDeckValueItems;
    }

    public final void setUnowned(MTDeckValueItems mTDeckValueItems) {
        this.unowned = mTDeckValueItems;
    }

    public String toString() {
        return "MTDeckValues(raw=" + this.raw + ", unowned=" + this.unowned + ", cheapest_printing=" + this.cheapest_printing + ", collection_owned_exact=" + this.collection_owned_exact + ", collection_owned_any=" + this.collection_owned_any + ")";
    }
}
