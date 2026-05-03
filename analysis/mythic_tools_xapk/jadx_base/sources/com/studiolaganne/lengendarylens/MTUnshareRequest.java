package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003Jr\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00068"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUnshareRequest;", "", "id", "", "shared_collection_id", "target_userid", "requester_userid", "status", "", "created_at", "updated_at", "participants", "", "Lcom/studiolaganne/lengendarylens/MTSharedCollectionInviteParticipant;", "<init>", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()I", "setId", "(I)V", "getShared_collection_id", "()Ljava/lang/Integer;", "setShared_collection_id", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTarget_userid", "setTarget_userid", "getRequester_userid", "setRequester_userid", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "getCreated_at", "setCreated_at", "getUpdated_at", "setUpdated_at", "getParticipants", "()Ljava/util/List;", "setParticipants", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTUnshareRequest;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUnshareRequest {
    public static final int $stable = 8;
    private String created_at;
    private int id;
    private List<MTSharedCollectionInviteParticipant> participants;
    private Integer requester_userid;
    private Integer shared_collection_id;
    private String status;
    private Integer target_userid;
    private String updated_at;

    public MTUnshareRequest() {
        this(0, null, null, null, null, null, null, null, 255, null);
    }

    public MTUnshareRequest(int i, Integer num, Integer num2, Integer num3, String str, String str2, String str3, List<MTSharedCollectionInviteParticipant> list) {
        this.id = i;
        this.shared_collection_id = num;
        this.target_userid = num2;
        this.requester_userid = num3;
        this.status = str;
        this.created_at = str2;
        this.updated_at = str3;
        this.participants = list;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTUnshareRequest(int r2, java.lang.Integer r3, java.lang.Integer r4, java.lang.Integer r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.util.List r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r1 = this;
            r11 = r10 & 1
            if (r11 == 0) goto L5
            r2 = -1
        L5:
            r11 = r10 & 2
            r0 = 0
            if (r11 == 0) goto Lb
            r3 = r0
        Lb:
            r11 = r10 & 4
            if (r11 == 0) goto L10
            r4 = r0
        L10:
            r11 = r10 & 8
            if (r11 == 0) goto L15
            r5 = r0
        L15:
            r11 = r10 & 16
            if (r11 == 0) goto L1a
            r6 = r0
        L1a:
            r11 = r10 & 32
            if (r11 == 0) goto L1f
            r7 = r0
        L1f:
            r11 = r10 & 64
            if (r11 == 0) goto L24
            r8 = r0
        L24:
            r10 = r10 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L32
            r11 = r0
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L3b
        L32:
            r11 = r9
            r10 = r8
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L3b:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTUnshareRequest.<init>(int, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTUnshareRequest copy$default(MTUnshareRequest mTUnshareRequest, int i, Integer num, Integer num2, Integer num3, String str, String str2, String str3, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTUnshareRequest.id;
        }
        if ((i2 & 2) != 0) {
            num = mTUnshareRequest.shared_collection_id;
        }
        if ((i2 & 4) != 0) {
            num2 = mTUnshareRequest.target_userid;
        }
        if ((i2 & 8) != 0) {
            num3 = mTUnshareRequest.requester_userid;
        }
        if ((i2 & 16) != 0) {
            str = mTUnshareRequest.status;
        }
        if ((i2 & 32) != 0) {
            str2 = mTUnshareRequest.created_at;
        }
        if ((i2 & 64) != 0) {
            str3 = mTUnshareRequest.updated_at;
        }
        if ((i2 & 128) != 0) {
            list = mTUnshareRequest.participants;
        }
        String str4 = str3;
        List list2 = list;
        String str5 = str;
        String str6 = str2;
        return mTUnshareRequest.copy(i, num, num2, num3, str5, str6, str4, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getShared_collection_id() {
        return this.shared_collection_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getTarget_userid() {
        return this.target_userid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getRequester_userid() {
        return this.requester_userid;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCreated_at() {
        return this.created_at;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUpdated_at() {
        return this.updated_at;
    }

    public final List<MTSharedCollectionInviteParticipant> component8() {
        return this.participants;
    }

    public final MTUnshareRequest copy(int id, Integer shared_collection_id, Integer target_userid, Integer requester_userid, String status, String created_at, String updated_at, List<MTSharedCollectionInviteParticipant> participants) {
        return new MTUnshareRequest(id, shared_collection_id, target_userid, requester_userid, status, created_at, updated_at, participants);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTUnshareRequest)) {
            return false;
        }
        MTUnshareRequest mTUnshareRequest = (MTUnshareRequest) other;
        return this.id == mTUnshareRequest.id && Intrinsics.areEqual(this.shared_collection_id, mTUnshareRequest.shared_collection_id) && Intrinsics.areEqual(this.target_userid, mTUnshareRequest.target_userid) && Intrinsics.areEqual(this.requester_userid, mTUnshareRequest.requester_userid) && Intrinsics.areEqual(this.status, mTUnshareRequest.status) && Intrinsics.areEqual(this.created_at, mTUnshareRequest.created_at) && Intrinsics.areEqual(this.updated_at, mTUnshareRequest.updated_at) && Intrinsics.areEqual(this.participants, mTUnshareRequest.participants);
    }

    public final String getCreated_at() {
        return this.created_at;
    }

    public final int getId() {
        return this.id;
    }

    public final List<MTSharedCollectionInviteParticipant> getParticipants() {
        return this.participants;
    }

    public final Integer getRequester_userid() {
        return this.requester_userid;
    }

    public final Integer getShared_collection_id() {
        return this.shared_collection_id;
    }

    public final String getStatus() {
        return this.status;
    }

    public final Integer getTarget_userid() {
        return this.target_userid;
    }

    public final String getUpdated_at() {
        return this.updated_at;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id) * 31;
        Integer num = this.shared_collection_id;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.target_userid;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.requester_userid;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.status;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.created_at;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.updated_at;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<MTSharedCollectionInviteParticipant> list = this.participants;
        return iHashCode7 + (list != null ? list.hashCode() : 0);
    }

    public final void setCreated_at(String str) {
        this.created_at = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setParticipants(List<MTSharedCollectionInviteParticipant> list) {
        this.participants = list;
    }

    public final void setRequester_userid(Integer num) {
        this.requester_userid = num;
    }

    public final void setShared_collection_id(Integer num) {
        this.shared_collection_id = num;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final void setTarget_userid(Integer num) {
        this.target_userid = num;
    }

    public final void setUpdated_at(String str) {
        this.updated_at = str;
    }

    public String toString() {
        return "MTUnshareRequest(id=" + this.id + ", shared_collection_id=" + this.shared_collection_id + ", target_userid=" + this.target_userid + ", requester_userid=" + this.requester_userid + ", status=" + this.status + ", created_at=" + this.created_at + ", updated_at=" + this.updated_at + ", participants=" + this.participants + ")";
    }
}
