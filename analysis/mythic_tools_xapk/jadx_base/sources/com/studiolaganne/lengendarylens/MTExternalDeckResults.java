package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTExternalDeckResults;", "", "added", "", "modified", "removed", "restored", "<init>", "(IIII)V", "getAdded", "()I", "setAdded", "(I)V", "getModified", "setModified", "getRemoved", "setRemoved", "getRestored", "setRestored", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTExternalDeckResults {
    public static final int $stable = 8;
    private int added;
    private int modified;
    private int removed;
    private int restored;

    public MTExternalDeckResults() {
        this(0, 0, 0, 0, 15, null);
    }

    public MTExternalDeckResults(int i, int i2, int i3, int i4) {
        this.added = i;
        this.modified = i2;
        this.removed = i3;
        this.restored = i4;
    }

    public /* synthetic */ MTExternalDeckResults(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    public static /* synthetic */ MTExternalDeckResults copy$default(MTExternalDeckResults mTExternalDeckResults, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mTExternalDeckResults.added;
        }
        if ((i5 & 2) != 0) {
            i2 = mTExternalDeckResults.modified;
        }
        if ((i5 & 4) != 0) {
            i3 = mTExternalDeckResults.removed;
        }
        if ((i5 & 8) != 0) {
            i4 = mTExternalDeckResults.restored;
        }
        return mTExternalDeckResults.copy(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAdded() {
        return this.added;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getModified() {
        return this.modified;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRemoved() {
        return this.removed;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getRestored() {
        return this.restored;
    }

    public final MTExternalDeckResults copy(int added, int modified, int removed, int restored) {
        return new MTExternalDeckResults(added, modified, removed, restored);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTExternalDeckResults)) {
            return false;
        }
        MTExternalDeckResults mTExternalDeckResults = (MTExternalDeckResults) other;
        return this.added == mTExternalDeckResults.added && this.modified == mTExternalDeckResults.modified && this.removed == mTExternalDeckResults.removed && this.restored == mTExternalDeckResults.restored;
    }

    public final int getAdded() {
        return this.added;
    }

    public final int getModified() {
        return this.modified;
    }

    public final int getRemoved() {
        return this.removed;
    }

    public final int getRestored() {
        return this.restored;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.added) * 31) + Integer.hashCode(this.modified)) * 31) + Integer.hashCode(this.removed)) * 31) + Integer.hashCode(this.restored);
    }

    public final void setAdded(int i) {
        this.added = i;
    }

    public final void setModified(int i) {
        this.modified = i;
    }

    public final void setRemoved(int i) {
        this.removed = i;
    }

    public final void setRestored(int i) {
        this.restored = i;
    }

    public String toString() {
        return "MTExternalDeckResults(added=" + this.added + ", modified=" + this.modified + ", removed=" + this.removed + ", restored=" + this.restored + ")";
    }
}
