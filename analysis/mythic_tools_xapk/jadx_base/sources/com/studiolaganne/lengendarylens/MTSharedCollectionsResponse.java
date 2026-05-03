package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSharedCollectionsResponse;", "", "shared_collections", "", "Lcom/studiolaganne/lengendarylens/MTSharedCollection;", "invites", "Lcom/studiolaganne/lengendarylens/MTSharedCollectionInvite;", "unshare_requests", "Lcom/studiolaganne/lengendarylens/MTUnshareRequest;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getShared_collections", "()Ljava/util/List;", "setShared_collections", "(Ljava/util/List;)V", "getInvites", "setInvites", "getUnshare_requests", "setUnshare_requests", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSharedCollectionsResponse {
    public static final int $stable = 8;
    private List<MTSharedCollectionInvite> invites;
    private List<MTSharedCollection> shared_collections;
    private List<MTUnshareRequest> unshare_requests;

    public MTSharedCollectionsResponse() {
        this(null, null, null, 7, null);
    }

    public MTSharedCollectionsResponse(List<MTSharedCollection> list, List<MTSharedCollectionInvite> list2, List<MTUnshareRequest> list3) {
        this.shared_collections = list;
        this.invites = list2;
        this.unshare_requests = list3;
    }

    public /* synthetic */ MTSharedCollectionsResponse(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTSharedCollectionsResponse copy$default(MTSharedCollectionsResponse mTSharedCollectionsResponse, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTSharedCollectionsResponse.shared_collections;
        }
        if ((i & 2) != 0) {
            list2 = mTSharedCollectionsResponse.invites;
        }
        if ((i & 4) != 0) {
            list3 = mTSharedCollectionsResponse.unshare_requests;
        }
        return mTSharedCollectionsResponse.copy(list, list2, list3);
    }

    public final List<MTSharedCollection> component1() {
        return this.shared_collections;
    }

    public final List<MTSharedCollectionInvite> component2() {
        return this.invites;
    }

    public final List<MTUnshareRequest> component3() {
        return this.unshare_requests;
    }

    public final MTSharedCollectionsResponse copy(List<MTSharedCollection> shared_collections, List<MTSharedCollectionInvite> invites, List<MTUnshareRequest> unshare_requests) {
        return new MTSharedCollectionsResponse(shared_collections, invites, unshare_requests);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSharedCollectionsResponse)) {
            return false;
        }
        MTSharedCollectionsResponse mTSharedCollectionsResponse = (MTSharedCollectionsResponse) other;
        return Intrinsics.areEqual(this.shared_collections, mTSharedCollectionsResponse.shared_collections) && Intrinsics.areEqual(this.invites, mTSharedCollectionsResponse.invites) && Intrinsics.areEqual(this.unshare_requests, mTSharedCollectionsResponse.unshare_requests);
    }

    public final List<MTSharedCollectionInvite> getInvites() {
        return this.invites;
    }

    public final List<MTSharedCollection> getShared_collections() {
        return this.shared_collections;
    }

    public final List<MTUnshareRequest> getUnshare_requests() {
        return this.unshare_requests;
    }

    public int hashCode() {
        List<MTSharedCollection> list = this.shared_collections;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<MTSharedCollectionInvite> list2 = this.invites;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MTUnshareRequest> list3 = this.unshare_requests;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public final void setInvites(List<MTSharedCollectionInvite> list) {
        this.invites = list;
    }

    public final void setShared_collections(List<MTSharedCollection> list) {
        this.shared_collections = list;
    }

    public final void setUnshare_requests(List<MTUnshareRequest> list) {
        this.unshare_requests = list;
    }

    public String toString() {
        return "MTSharedCollectionsResponse(shared_collections=" + this.shared_collections + ", invites=" + this.invites + ", unshare_requests=" + this.unshare_requests + ")";
    }
}
