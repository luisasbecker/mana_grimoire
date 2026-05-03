package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTPutExternalDeckResponse;", "", "success", "", "results", "Lcom/studiolaganne/lengendarylens/MTExternalDeckResults;", "list", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "<init>", "(ZLcom/studiolaganne/lengendarylens/MTExternalDeckResults;Lcom/studiolaganne/lengendarylens/MTCardContainer;)V", "getSuccess", "()Z", "setSuccess", "(Z)V", "getResults", "()Lcom/studiolaganne/lengendarylens/MTExternalDeckResults;", "setResults", "(Lcom/studiolaganne/lengendarylens/MTExternalDeckResults;)V", "getList", "()Lcom/studiolaganne/lengendarylens/MTCardContainer;", "setList", "(Lcom/studiolaganne/lengendarylens/MTCardContainer;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTPutExternalDeckResponse {
    public static final int $stable = 8;
    private MTCardContainer list;
    private MTExternalDeckResults results;
    private boolean success;

    public MTPutExternalDeckResponse() {
        this(false, null, null, 7, null);
    }

    public MTPutExternalDeckResponse(boolean z, MTExternalDeckResults mTExternalDeckResults, MTCardContainer mTCardContainer) {
        this.success = z;
        this.results = mTExternalDeckResults;
        this.list = mTCardContainer;
    }

    public /* synthetic */ MTPutExternalDeckResponse(boolean z, MTExternalDeckResults mTExternalDeckResults, MTCardContainer mTCardContainer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : mTExternalDeckResults, (i & 4) != 0 ? null : mTCardContainer);
    }

    public static /* synthetic */ MTPutExternalDeckResponse copy$default(MTPutExternalDeckResponse mTPutExternalDeckResponse, boolean z, MTExternalDeckResults mTExternalDeckResults, MTCardContainer mTCardContainer, int i, Object obj) {
        if ((i & 1) != 0) {
            z = mTPutExternalDeckResponse.success;
        }
        if ((i & 2) != 0) {
            mTExternalDeckResults = mTPutExternalDeckResponse.results;
        }
        if ((i & 4) != 0) {
            mTCardContainer = mTPutExternalDeckResponse.list;
        }
        return mTPutExternalDeckResponse.copy(z, mTExternalDeckResults, mTCardContainer);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTExternalDeckResults getResults() {
        return this.results;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTCardContainer getList() {
        return this.list;
    }

    public final MTPutExternalDeckResponse copy(boolean success, MTExternalDeckResults results, MTCardContainer list) {
        return new MTPutExternalDeckResponse(success, results, list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTPutExternalDeckResponse)) {
            return false;
        }
        MTPutExternalDeckResponse mTPutExternalDeckResponse = (MTPutExternalDeckResponse) other;
        return this.success == mTPutExternalDeckResponse.success && Intrinsics.areEqual(this.results, mTPutExternalDeckResponse.results) && Intrinsics.areEqual(this.list, mTPutExternalDeckResponse.list);
    }

    public final MTCardContainer getList() {
        return this.list;
    }

    public final MTExternalDeckResults getResults() {
        return this.results;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        MTExternalDeckResults mTExternalDeckResults = this.results;
        int iHashCode2 = (iHashCode + (mTExternalDeckResults == null ? 0 : mTExternalDeckResults.hashCode())) * 31;
        MTCardContainer mTCardContainer = this.list;
        return iHashCode2 + (mTCardContainer != null ? mTCardContainer.hashCode() : 0);
    }

    public final void setList(MTCardContainer mTCardContainer) {
        this.list = mTCardContainer;
    }

    public final void setResults(MTExternalDeckResults mTExternalDeckResults) {
        this.results = mTExternalDeckResults;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public String toString() {
        return "MTPutExternalDeckResponse(success=" + this.success + ", results=" + this.results + ", list=" + this.list + ")";
    }
}
