package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTTutorialState;", "", "id", "", "seen", "", "<init>", "(IZ)V", "getId", "()I", "setId", "(I)V", "getSeen", "()Z", "setSeen", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTTutorialState {
    public static final int $stable = 8;
    private int id;
    private boolean seen;

    /* JADX WARN: Multi-variable type inference failed */
    public MTTutorialState() {
        this(0, 0 == true ? 1 : 0, 3, null);
    }

    public MTTutorialState(int i, boolean z) {
        this.id = i;
        this.seen = z;
    }

    public /* synthetic */ MTTutorialState(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? false : z);
    }

    public static /* synthetic */ MTTutorialState copy$default(MTTutorialState mTTutorialState, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTTutorialState.id;
        }
        if ((i2 & 2) != 0) {
            z = mTTutorialState.seen;
        }
        return mTTutorialState.copy(i, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSeen() {
        return this.seen;
    }

    public final MTTutorialState copy(int id, boolean seen) {
        return new MTTutorialState(id, seen);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTTutorialState)) {
            return false;
        }
        MTTutorialState mTTutorialState = (MTTutorialState) other;
        return this.id == mTTutorialState.id && this.seen == mTTutorialState.seen;
    }

    public final int getId() {
        return this.id;
    }

    public final boolean getSeen() {
        return this.seen;
    }

    public int hashCode() {
        return (Integer.hashCode(this.id) * 31) + Boolean.hashCode(this.seen);
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setSeen(boolean z) {
        this.seen = z;
    }

    public String toString() {
        return "MTTutorialState(id=" + this.id + ", seen=" + this.seen + ")";
    }
}
