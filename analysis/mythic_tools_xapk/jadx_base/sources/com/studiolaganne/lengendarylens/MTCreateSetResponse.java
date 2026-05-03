package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCreateSetResponse;", "", "set", "Lcom/studiolaganne/lengendarylens/MTSetResponse;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTSetResponse;)V", "getSet", "()Lcom/studiolaganne/lengendarylens/MTSetResponse;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCreateSetResponse {
    public static final int $stable = 8;
    private final MTSetResponse set;

    /* JADX WARN: Multi-variable type inference failed */
    public MTCreateSetResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MTCreateSetResponse(MTSetResponse mTSetResponse) {
        this.set = mTSetResponse;
    }

    public /* synthetic */ MTCreateSetResponse(MTSetResponse mTSetResponse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTSetResponse);
    }

    public static /* synthetic */ MTCreateSetResponse copy$default(MTCreateSetResponse mTCreateSetResponse, MTSetResponse mTSetResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            mTSetResponse = mTCreateSetResponse.set;
        }
        return mTCreateSetResponse.copy(mTSetResponse);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTSetResponse getSet() {
        return this.set;
    }

    public final MTCreateSetResponse copy(MTSetResponse set) {
        return new MTCreateSetResponse(set);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTCreateSetResponse) && Intrinsics.areEqual(this.set, ((MTCreateSetResponse) other).set);
    }

    public final MTSetResponse getSet() {
        return this.set;
    }

    public int hashCode() {
        MTSetResponse mTSetResponse = this.set;
        if (mTSetResponse == null) {
            return 0;
        }
        return mTSetResponse.hashCode();
    }

    public String toString() {
        return "MTCreateSetResponse(set=" + this.set + ")";
    }
}
