package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCollectionStatusEdit;", "", "old", "Lcom/studiolaganne/lengendarylens/MTCollectionListEntry;", "new", "<init>", "(Lcom/studiolaganne/lengendarylens/MTCollectionListEntry;Lcom/studiolaganne/lengendarylens/MTCollectionListEntry;)V", "getOld", "()Lcom/studiolaganne/lengendarylens/MTCollectionListEntry;", "setOld", "(Lcom/studiolaganne/lengendarylens/MTCollectionListEntry;)V", "getNew", "setNew", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCollectionStatusEdit {
    public static final int $stable = 8;
    private MTCollectionListEntry new;
    private MTCollectionListEntry old;

    /* JADX WARN: Multi-variable type inference failed */
    public MTCollectionStatusEdit() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTCollectionStatusEdit(MTCollectionListEntry mTCollectionListEntry, MTCollectionListEntry mTCollectionListEntry2) {
        this.old = mTCollectionListEntry;
        this.new = mTCollectionListEntry2;
    }

    public /* synthetic */ MTCollectionStatusEdit(MTCollectionListEntry mTCollectionListEntry, MTCollectionListEntry mTCollectionListEntry2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTCollectionListEntry, (i & 2) != 0 ? null : mTCollectionListEntry2);
    }

    public static /* synthetic */ MTCollectionStatusEdit copy$default(MTCollectionStatusEdit mTCollectionStatusEdit, MTCollectionListEntry mTCollectionListEntry, MTCollectionListEntry mTCollectionListEntry2, int i, Object obj) {
        if ((i & 1) != 0) {
            mTCollectionListEntry = mTCollectionStatusEdit.old;
        }
        if ((i & 2) != 0) {
            mTCollectionListEntry2 = mTCollectionStatusEdit.new;
        }
        return mTCollectionStatusEdit.copy(mTCollectionListEntry, mTCollectionListEntry2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTCollectionListEntry getOld() {
        return this.old;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTCollectionListEntry getNew() {
        return this.new;
    }

    public final MTCollectionStatusEdit copy(MTCollectionListEntry old, MTCollectionListEntry mTCollectionListEntry) {
        return new MTCollectionStatusEdit(old, mTCollectionListEntry);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCollectionStatusEdit)) {
            return false;
        }
        MTCollectionStatusEdit mTCollectionStatusEdit = (MTCollectionStatusEdit) other;
        return Intrinsics.areEqual(this.old, mTCollectionStatusEdit.old) && Intrinsics.areEqual(this.new, mTCollectionStatusEdit.new);
    }

    public final MTCollectionListEntry getNew() {
        return this.new;
    }

    public final MTCollectionListEntry getOld() {
        return this.old;
    }

    public int hashCode() {
        MTCollectionListEntry mTCollectionListEntry = this.old;
        int iHashCode = (mTCollectionListEntry == null ? 0 : mTCollectionListEntry.hashCode()) * 31;
        MTCollectionListEntry mTCollectionListEntry2 = this.new;
        return iHashCode + (mTCollectionListEntry2 != null ? mTCollectionListEntry2.hashCode() : 0);
    }

    public final void setNew(MTCollectionListEntry mTCollectionListEntry) {
        this.new = mTCollectionListEntry;
    }

    public final void setOld(MTCollectionListEntry mTCollectionListEntry) {
        this.old = mTCollectionListEntry;
    }

    public String toString() {
        return "MTCollectionStatusEdit(old=" + this.old + ", new=" + this.new + ")";
    }
}
