package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSuccessResponse;", "", "success", "", "<init>", "(Ljava/lang/Boolean;)V", "getSuccess", "()Ljava/lang/Boolean;", "setSuccess", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTSuccessResponse;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSuccessResponse {
    public static final int $stable = 8;
    private Boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public MTSuccessResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MTSuccessResponse(Boolean bool) {
        this.success = bool;
    }

    public /* synthetic */ MTSuccessResponse(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : bool);
    }

    public static /* synthetic */ MTSuccessResponse copy$default(MTSuccessResponse mTSuccessResponse, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = mTSuccessResponse.success;
        }
        return mTSuccessResponse.copy(bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    public final MTSuccessResponse copy(Boolean success) {
        return new MTSuccessResponse(success);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTSuccessResponse) && Intrinsics.areEqual(this.success, ((MTSuccessResponse) other).success);
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        Boolean bool = this.success;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public final void setSuccess(Boolean bool) {
        this.success = bool;
    }

    public String toString() {
        return "MTSuccessResponse(success=" + this.success + ")";
    }
}
