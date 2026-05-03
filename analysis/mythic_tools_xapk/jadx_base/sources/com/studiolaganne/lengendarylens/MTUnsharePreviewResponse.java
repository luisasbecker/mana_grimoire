package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005HÆ\u0003J\\\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017¨\u0006-"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUnsharePreviewResponse;", "", "shared_collection_id", "", "members", "", "Lcom/studiolaganne/lengendarylens/MTSharedCollectionMember;", "lists", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "unshare_request", "Lcom/studiolaganne/lengendarylens/MTUnshareRequest;", "participants", "Lcom/studiolaganne/lengendarylens/MTSharedCollectionInviteParticipant;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTUnshareRequest;Ljava/util/List;)V", "getShared_collection_id", "()Ljava/lang/Integer;", "setShared_collection_id", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMembers", "()Ljava/util/List;", "setMembers", "(Ljava/util/List;)V", "getLists", "setLists", "getUnshare_request", "()Lcom/studiolaganne/lengendarylens/MTUnshareRequest;", "setUnshare_request", "(Lcom/studiolaganne/lengendarylens/MTUnshareRequest;)V", "getParticipants", "setParticipants", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTUnshareRequest;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTUnsharePreviewResponse;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUnsharePreviewResponse {
    public static final int $stable = 8;
    private List<MTCardContainer> lists;
    private List<MTSharedCollectionMember> members;
    private List<MTSharedCollectionInviteParticipant> participants;
    private Integer shared_collection_id;
    private MTUnshareRequest unshare_request;

    public MTUnsharePreviewResponse() {
        this(null, null, null, null, null, 31, null);
    }

    public MTUnsharePreviewResponse(Integer num, List<MTSharedCollectionMember> list, List<MTCardContainer> list2, MTUnshareRequest mTUnshareRequest, List<MTSharedCollectionInviteParticipant> list3) {
        this.shared_collection_id = num;
        this.members = list;
        this.lists = list2;
        this.unshare_request = mTUnshareRequest;
        this.participants = list3;
    }

    public /* synthetic */ MTUnsharePreviewResponse(Integer num, List list, List list2, MTUnshareRequest mTUnshareRequest, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : mTUnshareRequest, (i & 16) != 0 ? null : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTUnsharePreviewResponse copy$default(MTUnsharePreviewResponse mTUnsharePreviewResponse, Integer num, List list, List list2, MTUnshareRequest mTUnshareRequest, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTUnsharePreviewResponse.shared_collection_id;
        }
        if ((i & 2) != 0) {
            list = mTUnsharePreviewResponse.members;
        }
        if ((i & 4) != 0) {
            list2 = mTUnsharePreviewResponse.lists;
        }
        if ((i & 8) != 0) {
            mTUnshareRequest = mTUnsharePreviewResponse.unshare_request;
        }
        if ((i & 16) != 0) {
            list3 = mTUnsharePreviewResponse.participants;
        }
        List list4 = list3;
        List list5 = list2;
        return mTUnsharePreviewResponse.copy(num, list, list5, mTUnshareRequest, list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getShared_collection_id() {
        return this.shared_collection_id;
    }

    public final List<MTSharedCollectionMember> component2() {
        return this.members;
    }

    public final List<MTCardContainer> component3() {
        return this.lists;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTUnshareRequest getUnshare_request() {
        return this.unshare_request;
    }

    public final List<MTSharedCollectionInviteParticipant> component5() {
        return this.participants;
    }

    public final MTUnsharePreviewResponse copy(Integer shared_collection_id, List<MTSharedCollectionMember> members, List<MTCardContainer> lists, MTUnshareRequest unshare_request, List<MTSharedCollectionInviteParticipant> participants) {
        return new MTUnsharePreviewResponse(shared_collection_id, members, lists, unshare_request, participants);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTUnsharePreviewResponse)) {
            return false;
        }
        MTUnsharePreviewResponse mTUnsharePreviewResponse = (MTUnsharePreviewResponse) other;
        return Intrinsics.areEqual(this.shared_collection_id, mTUnsharePreviewResponse.shared_collection_id) && Intrinsics.areEqual(this.members, mTUnsharePreviewResponse.members) && Intrinsics.areEqual(this.lists, mTUnsharePreviewResponse.lists) && Intrinsics.areEqual(this.unshare_request, mTUnsharePreviewResponse.unshare_request) && Intrinsics.areEqual(this.participants, mTUnsharePreviewResponse.participants);
    }

    public final List<MTCardContainer> getLists() {
        return this.lists;
    }

    public final List<MTSharedCollectionMember> getMembers() {
        return this.members;
    }

    public final List<MTSharedCollectionInviteParticipant> getParticipants() {
        return this.participants;
    }

    public final Integer getShared_collection_id() {
        return this.shared_collection_id;
    }

    public final MTUnshareRequest getUnshare_request() {
        return this.unshare_request;
    }

    public int hashCode() {
        Integer num = this.shared_collection_id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<MTSharedCollectionMember> list = this.members;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<MTCardContainer> list2 = this.lists;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        MTUnshareRequest mTUnshareRequest = this.unshare_request;
        int iHashCode4 = (iHashCode3 + (mTUnshareRequest == null ? 0 : mTUnshareRequest.hashCode())) * 31;
        List<MTSharedCollectionInviteParticipant> list3 = this.participants;
        return iHashCode4 + (list3 != null ? list3.hashCode() : 0);
    }

    public final void setLists(List<MTCardContainer> list) {
        this.lists = list;
    }

    public final void setMembers(List<MTSharedCollectionMember> list) {
        this.members = list;
    }

    public final void setParticipants(List<MTSharedCollectionInviteParticipant> list) {
        this.participants = list;
    }

    public final void setShared_collection_id(Integer num) {
        this.shared_collection_id = num;
    }

    public final void setUnshare_request(MTUnshareRequest mTUnshareRequest) {
        this.unshare_request = mTUnshareRequest;
    }

    public String toString() {
        return "MTUnsharePreviewResponse(shared_collection_id=" + this.shared_collection_id + ", members=" + this.members + ", lists=" + this.lists + ", unshare_request=" + this.unshare_request + ", participants=" + this.participants + ")";
    }
}
