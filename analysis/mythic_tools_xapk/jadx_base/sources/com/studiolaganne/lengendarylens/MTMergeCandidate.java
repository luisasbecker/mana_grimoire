package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013Jn\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0005HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015¨\u00062"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTMergeCandidate;", "", "list_name", "", "type", "", "inviter_listid", "invitee_listid", "canonical_listid", "canonical_owner_userid", "inviter_card_count", "invitee_card_count", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getList_name", "()Ljava/lang/String;", "setList_name", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getInviter_listid", "setInviter_listid", "getInvitee_listid", "setInvitee_listid", "getCanonical_listid", "setCanonical_listid", "getCanonical_owner_userid", "setCanonical_owner_userid", "getInviter_card_count", "setInviter_card_count", "getInvitee_card_count", "setInvitee_card_count", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTMergeCandidate;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTMergeCandidate {
    public static final int $stable = 8;
    private Integer canonical_listid;
    private Integer canonical_owner_userid;
    private Integer invitee_card_count;
    private Integer invitee_listid;
    private Integer inviter_card_count;
    private Integer inviter_listid;
    private String list_name;
    private Integer type;

    public MTMergeCandidate() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public MTMergeCandidate(String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        this.list_name = str;
        this.type = num;
        this.inviter_listid = num2;
        this.invitee_listid = num3;
        this.canonical_listid = num4;
        this.canonical_owner_userid = num5;
        this.inviter_card_count = num6;
        this.invitee_card_count = num7;
    }

    public /* synthetic */ MTMergeCandidate(String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : num5, (i & 64) != 0 ? null : num6, (i & 128) != 0 ? null : num7);
    }

    public static /* synthetic */ MTMergeCandidate copy$default(MTMergeCandidate mTMergeCandidate, String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTMergeCandidate.list_name;
        }
        if ((i & 2) != 0) {
            num = mTMergeCandidate.type;
        }
        if ((i & 4) != 0) {
            num2 = mTMergeCandidate.inviter_listid;
        }
        if ((i & 8) != 0) {
            num3 = mTMergeCandidate.invitee_listid;
        }
        if ((i & 16) != 0) {
            num4 = mTMergeCandidate.canonical_listid;
        }
        if ((i & 32) != 0) {
            num5 = mTMergeCandidate.canonical_owner_userid;
        }
        if ((i & 64) != 0) {
            num6 = mTMergeCandidate.inviter_card_count;
        }
        if ((i & 128) != 0) {
            num7 = mTMergeCandidate.invitee_card_count;
        }
        Integer num8 = num6;
        Integer num9 = num7;
        Integer num10 = num4;
        Integer num11 = num5;
        return mTMergeCandidate.copy(str, num, num2, num3, num10, num11, num8, num9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getList_name() {
        return this.list_name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getInviter_listid() {
        return this.inviter_listid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getInvitee_listid() {
        return this.invitee_listid;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getCanonical_listid() {
        return this.canonical_listid;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getCanonical_owner_userid() {
        return this.canonical_owner_userid;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getInviter_card_count() {
        return this.inviter_card_count;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getInvitee_card_count() {
        return this.invitee_card_count;
    }

    public final MTMergeCandidate copy(String list_name, Integer type, Integer inviter_listid, Integer invitee_listid, Integer canonical_listid, Integer canonical_owner_userid, Integer inviter_card_count, Integer invitee_card_count) {
        return new MTMergeCandidate(list_name, type, inviter_listid, invitee_listid, canonical_listid, canonical_owner_userid, inviter_card_count, invitee_card_count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTMergeCandidate)) {
            return false;
        }
        MTMergeCandidate mTMergeCandidate = (MTMergeCandidate) other;
        return Intrinsics.areEqual(this.list_name, mTMergeCandidate.list_name) && Intrinsics.areEqual(this.type, mTMergeCandidate.type) && Intrinsics.areEqual(this.inviter_listid, mTMergeCandidate.inviter_listid) && Intrinsics.areEqual(this.invitee_listid, mTMergeCandidate.invitee_listid) && Intrinsics.areEqual(this.canonical_listid, mTMergeCandidate.canonical_listid) && Intrinsics.areEqual(this.canonical_owner_userid, mTMergeCandidate.canonical_owner_userid) && Intrinsics.areEqual(this.inviter_card_count, mTMergeCandidate.inviter_card_count) && Intrinsics.areEqual(this.invitee_card_count, mTMergeCandidate.invitee_card_count);
    }

    public final Integer getCanonical_listid() {
        return this.canonical_listid;
    }

    public final Integer getCanonical_owner_userid() {
        return this.canonical_owner_userid;
    }

    public final Integer getInvitee_card_count() {
        return this.invitee_card_count;
    }

    public final Integer getInvitee_listid() {
        return this.invitee_listid;
    }

    public final Integer getInviter_card_count() {
        return this.inviter_card_count;
    }

    public final Integer getInviter_listid() {
        return this.inviter_listid;
    }

    public final String getList_name() {
        return this.list_name;
    }

    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.list_name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.type;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.inviter_listid;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.invitee_listid;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.canonical_listid;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.canonical_owner_userid;
        int iHashCode6 = (iHashCode5 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.inviter_card_count;
        int iHashCode7 = (iHashCode6 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.invitee_card_count;
        return iHashCode7 + (num7 != null ? num7.hashCode() : 0);
    }

    public final void setCanonical_listid(Integer num) {
        this.canonical_listid = num;
    }

    public final void setCanonical_owner_userid(Integer num) {
        this.canonical_owner_userid = num;
    }

    public final void setInvitee_card_count(Integer num) {
        this.invitee_card_count = num;
    }

    public final void setInvitee_listid(Integer num) {
        this.invitee_listid = num;
    }

    public final void setInviter_card_count(Integer num) {
        this.inviter_card_count = num;
    }

    public final void setInviter_listid(Integer num) {
        this.inviter_listid = num;
    }

    public final void setList_name(String str) {
        this.list_name = str;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public String toString() {
        return "MTMergeCandidate(list_name=" + this.list_name + ", type=" + this.type + ", inviter_listid=" + this.inviter_listid + ", invitee_listid=" + this.invitee_listid + ", canonical_listid=" + this.canonical_listid + ", canonical_owner_userid=" + this.canonical_owner_userid + ", inviter_card_count=" + this.inviter_card_count + ", invitee_card_count=" + this.invitee_card_count + ")";
    }
}
