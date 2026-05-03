package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUpdateToCheapestResponse;", "", "list", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "result", "Lcom/studiolaganne/lengendarylens/MTCheapestResult;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTCardContainer;Lcom/studiolaganne/lengendarylens/MTCheapestResult;)V", "getList", "()Lcom/studiolaganne/lengendarylens/MTCardContainer;", "getResult", "()Lcom/studiolaganne/lengendarylens/MTCheapestResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUpdateToCheapestResponse {
    public static final int $stable = 8;
    private final MTCardContainer list;
    private final MTCheapestResult result;

    /* JADX WARN: Multi-variable type inference failed */
    public MTUpdateToCheapestResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTUpdateToCheapestResponse(MTCardContainer mTCardContainer, MTCheapestResult mTCheapestResult) {
        this.list = mTCardContainer;
        this.result = mTCheapestResult;
    }

    public /* synthetic */ MTUpdateToCheapestResponse(MTCardContainer mTCardContainer, MTCheapestResult mTCheapestResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTCardContainer, (i & 2) != 0 ? null : mTCheapestResult);
    }

    public static /* synthetic */ MTUpdateToCheapestResponse copy$default(MTUpdateToCheapestResponse mTUpdateToCheapestResponse, MTCardContainer mTCardContainer, MTCheapestResult mTCheapestResult, int i, Object obj) {
        if ((i & 1) != 0) {
            mTCardContainer = mTUpdateToCheapestResponse.list;
        }
        if ((i & 2) != 0) {
            mTCheapestResult = mTUpdateToCheapestResponse.result;
        }
        return mTUpdateToCheapestResponse.copy(mTCardContainer, mTCheapestResult);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTCardContainer getList() {
        return this.list;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTCheapestResult getResult() {
        return this.result;
    }

    public final MTUpdateToCheapestResponse copy(MTCardContainer list, MTCheapestResult result) {
        return new MTUpdateToCheapestResponse(list, result);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTUpdateToCheapestResponse)) {
            return false;
        }
        MTUpdateToCheapestResponse mTUpdateToCheapestResponse = (MTUpdateToCheapestResponse) other;
        return Intrinsics.areEqual(this.list, mTUpdateToCheapestResponse.list) && Intrinsics.areEqual(this.result, mTUpdateToCheapestResponse.result);
    }

    public final MTCardContainer getList() {
        return this.list;
    }

    public final MTCheapestResult getResult() {
        return this.result;
    }

    public int hashCode() {
        MTCardContainer mTCardContainer = this.list;
        int iHashCode = (mTCardContainer == null ? 0 : mTCardContainer.hashCode()) * 31;
        MTCheapestResult mTCheapestResult = this.result;
        return iHashCode + (mTCheapestResult != null ? mTCheapestResult.hashCode() : 0);
    }

    public String toString() {
        return "MTUpdateToCheapestResponse(list=" + this.list + ", result=" + this.result + ")";
    }
}
