package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDuplicateDeckResponse;", "", "success", "", "message", "", "<init>", "(ZLjava/lang/String;)V", "getSuccess", "()Z", "setSuccess", "(Z)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDuplicateDeckResponse {
    public static final int $stable = 8;
    private String message;
    private boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public MTDuplicateDeckResponse() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public MTDuplicateDeckResponse(boolean z, String str) {
        this.success = z;
        this.message = str;
    }

    public /* synthetic */ MTDuplicateDeckResponse(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str);
    }

    public static /* synthetic */ MTDuplicateDeckResponse copy$default(MTDuplicateDeckResponse mTDuplicateDeckResponse, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = mTDuplicateDeckResponse.success;
        }
        if ((i & 2) != 0) {
            str = mTDuplicateDeckResponse.message;
        }
        return mTDuplicateDeckResponse.copy(z, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final MTDuplicateDeckResponse copy(boolean success, String message) {
        return new MTDuplicateDeckResponse(success, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDuplicateDeckResponse)) {
            return false;
        }
        MTDuplicateDeckResponse mTDuplicateDeckResponse = (MTDuplicateDeckResponse) other;
        return this.success == mTDuplicateDeckResponse.success && Intrinsics.areEqual(this.message, mTDuplicateDeckResponse.message);
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        String str = this.message;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public String toString() {
        return "MTDuplicateDeckResponse(success=" + this.success + ", message=" + this.message + ")";
    }
}
