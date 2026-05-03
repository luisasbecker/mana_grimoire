package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0092\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u0003HÖ\u0001J\t\u0010H\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006I"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSharedCollectionInvite;", "", "id", "", "inviter_userid", "invitee_userid", "shared_collection_id", "status", "", "merge_preview", "created_at", "updated_at", "direction", "other_party", "Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "participants", "", "Lcom/studiolaganne/lengendarylens/MTSharedCollectionInviteParticipant;", "<init>", "(IIILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTPrivacyUser;Ljava/util/List;)V", "getId", "()I", "setId", "(I)V", "getInviter_userid", "setInviter_userid", "getInvitee_userid", "setInvitee_userid", "getShared_collection_id", "()Ljava/lang/Integer;", "setShared_collection_id", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "getMerge_preview", "()Ljava/lang/Object;", "setMerge_preview", "(Ljava/lang/Object;)V", "getCreated_at", "setCreated_at", "getUpdated_at", "setUpdated_at", "getDirection", "setDirection", "getOther_party", "()Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "setOther_party", "(Lcom/studiolaganne/lengendarylens/MTPrivacyUser;)V", "getParticipants", "()Ljava/util/List;", "setParticipants", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(IIILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTPrivacyUser;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTSharedCollectionInvite;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSharedCollectionInvite {
    public static final int $stable = 8;
    private String created_at;
    private String direction;
    private int id;
    private int invitee_userid;
    private int inviter_userid;
    private Object merge_preview;
    private MTPrivacyUser other_party;
    private List<MTSharedCollectionInviteParticipant> participants;
    private Integer shared_collection_id;
    private String status;
    private String updated_at;

    public MTSharedCollectionInvite() {
        this(0, 0, 0, null, null, null, null, null, null, null, null, 2047, null);
    }

    public MTSharedCollectionInvite(int i, int i2, int i3, Integer num, String str, Object obj, String str2, String str3, String str4, MTPrivacyUser mTPrivacyUser, List<MTSharedCollectionInviteParticipant> list) {
        this.id = i;
        this.inviter_userid = i2;
        this.invitee_userid = i3;
        this.shared_collection_id = num;
        this.status = str;
        this.merge_preview = obj;
        this.created_at = str2;
        this.updated_at = str3;
        this.direction = str4;
        this.other_party = mTPrivacyUser;
        this.participants = list;
    }

    public /* synthetic */ MTSharedCollectionInvite(int i, int i2, int i3, Integer num, String str, Object obj, String str2, String str3, String str4, MTPrivacyUser mTPrivacyUser, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? -1 : i, (i4 & 2) != 0 ? -1 : i2, (i4 & 4) != 0 ? -1 : i3, (i4 & 8) != 0 ? null : num, (i4 & 16) != 0 ? null : str, (i4 & 32) != 0 ? null : obj, (i4 & 64) != 0 ? null : str2, (i4 & 128) != 0 ? null : str3, (i4 & 256) != 0 ? null : str4, (i4 & 512) != 0 ? null : mTPrivacyUser, (i4 & 1024) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTSharedCollectionInvite copy$default(MTSharedCollectionInvite mTSharedCollectionInvite, int i, int i2, int i3, Integer num, String str, Object obj, String str2, String str3, String str4, MTPrivacyUser mTPrivacyUser, List list, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            i = mTSharedCollectionInvite.id;
        }
        if ((i4 & 2) != 0) {
            i2 = mTSharedCollectionInvite.inviter_userid;
        }
        if ((i4 & 4) != 0) {
            i3 = mTSharedCollectionInvite.invitee_userid;
        }
        if ((i4 & 8) != 0) {
            num = mTSharedCollectionInvite.shared_collection_id;
        }
        if ((i4 & 16) != 0) {
            str = mTSharedCollectionInvite.status;
        }
        if ((i4 & 32) != 0) {
            obj = mTSharedCollectionInvite.merge_preview;
        }
        if ((i4 & 64) != 0) {
            str2 = mTSharedCollectionInvite.created_at;
        }
        if ((i4 & 128) != 0) {
            str3 = mTSharedCollectionInvite.updated_at;
        }
        if ((i4 & 256) != 0) {
            str4 = mTSharedCollectionInvite.direction;
        }
        if ((i4 & 512) != 0) {
            mTPrivacyUser = mTSharedCollectionInvite.other_party;
        }
        if ((i4 & 1024) != 0) {
            list = mTSharedCollectionInvite.participants;
        }
        MTPrivacyUser mTPrivacyUser2 = mTPrivacyUser;
        List list2 = list;
        String str5 = str3;
        String str6 = str4;
        Object obj3 = obj;
        String str7 = str2;
        String str8 = str;
        int i5 = i3;
        return mTSharedCollectionInvite.copy(i, i2, i5, num, str8, obj3, str7, str5, str6, mTPrivacyUser2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final MTPrivacyUser getOther_party() {
        return this.other_party;
    }

    public final List<MTSharedCollectionInviteParticipant> component11() {
        return this.participants;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getInviter_userid() {
        return this.inviter_userid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getInvitee_userid() {
        return this.invitee_userid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getShared_collection_id() {
        return this.shared_collection_id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Object getMerge_preview() {
        return this.merge_preview;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCreated_at() {
        return this.created_at;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getUpdated_at() {
        return this.updated_at;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDirection() {
        return this.direction;
    }

    public final MTSharedCollectionInvite copy(int id, int inviter_userid, int invitee_userid, Integer shared_collection_id, String status, Object merge_preview, String created_at, String updated_at, String direction, MTPrivacyUser other_party, List<MTSharedCollectionInviteParticipant> participants) {
        return new MTSharedCollectionInvite(id, inviter_userid, invitee_userid, shared_collection_id, status, merge_preview, created_at, updated_at, direction, other_party, participants);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSharedCollectionInvite)) {
            return false;
        }
        MTSharedCollectionInvite mTSharedCollectionInvite = (MTSharedCollectionInvite) other;
        return this.id == mTSharedCollectionInvite.id && this.inviter_userid == mTSharedCollectionInvite.inviter_userid && this.invitee_userid == mTSharedCollectionInvite.invitee_userid && Intrinsics.areEqual(this.shared_collection_id, mTSharedCollectionInvite.shared_collection_id) && Intrinsics.areEqual(this.status, mTSharedCollectionInvite.status) && Intrinsics.areEqual(this.merge_preview, mTSharedCollectionInvite.merge_preview) && Intrinsics.areEqual(this.created_at, mTSharedCollectionInvite.created_at) && Intrinsics.areEqual(this.updated_at, mTSharedCollectionInvite.updated_at) && Intrinsics.areEqual(this.direction, mTSharedCollectionInvite.direction) && Intrinsics.areEqual(this.other_party, mTSharedCollectionInvite.other_party) && Intrinsics.areEqual(this.participants, mTSharedCollectionInvite.participants);
    }

    public final String getCreated_at() {
        return this.created_at;
    }

    public final String getDirection() {
        return this.direction;
    }

    public final int getId() {
        return this.id;
    }

    public final int getInvitee_userid() {
        return this.invitee_userid;
    }

    public final int getInviter_userid() {
        return this.inviter_userid;
    }

    public final Object getMerge_preview() {
        return this.merge_preview;
    }

    public final MTPrivacyUser getOther_party() {
        return this.other_party;
    }

    public final List<MTSharedCollectionInviteParticipant> getParticipants() {
        return this.participants;
    }

    public final Integer getShared_collection_id() {
        return this.shared_collection_id;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getUpdated_at() {
        return this.updated_at;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.inviter_userid)) * 31) + Integer.hashCode(this.invitee_userid)) * 31;
        Integer num = this.shared_collection_id;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.status;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Object obj = this.merge_preview;
        int iHashCode4 = (iHashCode3 + (obj == null ? 0 : obj.hashCode())) * 31;
        String str2 = this.created_at;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.updated_at;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.direction;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        MTPrivacyUser mTPrivacyUser = this.other_party;
        int iHashCode8 = (iHashCode7 + (mTPrivacyUser == null ? 0 : mTPrivacyUser.hashCode())) * 31;
        List<MTSharedCollectionInviteParticipant> list = this.participants;
        return iHashCode8 + (list != null ? list.hashCode() : 0);
    }

    public final void setCreated_at(String str) {
        this.created_at = str;
    }

    public final void setDirection(String str) {
        this.direction = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setInvitee_userid(int i) {
        this.invitee_userid = i;
    }

    public final void setInviter_userid(int i) {
        this.inviter_userid = i;
    }

    public final void setMerge_preview(Object obj) {
        this.merge_preview = obj;
    }

    public final void setOther_party(MTPrivacyUser mTPrivacyUser) {
        this.other_party = mTPrivacyUser;
    }

    public final void setParticipants(List<MTSharedCollectionInviteParticipant> list) {
        this.participants = list;
    }

    public final void setShared_collection_id(Integer num) {
        this.shared_collection_id = num;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final void setUpdated_at(String str) {
        this.updated_at = str;
    }

    public String toString() {
        return "MTSharedCollectionInvite(id=" + this.id + ", inviter_userid=" + this.inviter_userid + ", invitee_userid=" + this.invitee_userid + ", shared_collection_id=" + this.shared_collection_id + ", status=" + this.status + ", merge_preview=" + this.merge_preview + ", created_at=" + this.created_at + ", updated_at=" + this.updated_at + ", direction=" + this.direction + ", other_party=" + this.other_party + ", participants=" + this.participants + ")";
    }
}
