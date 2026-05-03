package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ$\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTForkDeckResponse;", "", "success", "", "newDeckId", "", "<init>", "(ZLjava/lang/Integer;)V", "getSuccess", "()Z", "setSuccess", "(Z)V", "getNewDeckId", "()Ljava/lang/Integer;", "setNewDeckId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ZLjava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTForkDeckResponse;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTForkDeckResponse {
    public static final int $stable = 8;
    private Integer newDeckId;
    private boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public MTForkDeckResponse() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public MTForkDeckResponse(boolean z, Integer num) {
        this.success = z;
        this.newDeckId = num;
    }

    public /* synthetic */ MTForkDeckResponse(boolean z, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : num);
    }

    public static /* synthetic */ MTForkDeckResponse copy$default(MTForkDeckResponse mTForkDeckResponse, boolean z, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            z = mTForkDeckResponse.success;
        }
        if ((i & 2) != 0) {
            num = mTForkDeckResponse.newDeckId;
        }
        return mTForkDeckResponse.copy(z, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getNewDeckId() {
        return this.newDeckId;
    }

    public final MTForkDeckResponse copy(boolean success, Integer newDeckId) {
        return new MTForkDeckResponse(success, newDeckId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTForkDeckResponse)) {
            return false;
        }
        MTForkDeckResponse mTForkDeckResponse = (MTForkDeckResponse) other;
        return this.success == mTForkDeckResponse.success && Intrinsics.areEqual(this.newDeckId, mTForkDeckResponse.newDeckId);
    }

    public final Integer getNewDeckId() {
        return this.newDeckId;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        Integer num = this.newDeckId;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public final void setNewDeckId(Integer num) {
        this.newDeckId = num;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public String toString() {
        return "MTForkDeckResponse(success=" + this.success + ", newDeckId=" + this.newDeckId + ")";
    }
}
