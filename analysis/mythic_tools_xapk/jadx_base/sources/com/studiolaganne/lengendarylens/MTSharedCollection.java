package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003JZ\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSharedCollection;", "", "id", "", "status", "", "created_by", "created_at", "updated_at", "members", "", "Lcom/studiolaganne/lengendarylens/MTSharedCollectionMember;", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()I", "setId", "(I)V", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "getCreated_by", "()Ljava/lang/Integer;", "setCreated_by", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCreated_at", "setCreated_at", "getUpdated_at", "setUpdated_at", "getMembers", "()Ljava/util/List;", "setMembers", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTSharedCollection;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSharedCollection {
    public static final int $stable = 8;
    private String created_at;
    private Integer created_by;
    private int id;
    private List<MTSharedCollectionMember> members;
    private String status;
    private String updated_at;

    public MTSharedCollection() {
        this(0, null, null, null, null, null, 63, null);
    }

    public MTSharedCollection(int i, String str, Integer num, String str2, String str3, List<MTSharedCollectionMember> list) {
        this.id = i;
        this.status = str;
        this.created_by = num;
        this.created_at = str2;
        this.updated_at = str3;
        this.members = list;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTSharedCollection(int r2, java.lang.String r3, java.lang.Integer r4, java.lang.String r5, java.lang.String r6, java.util.List r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L5
            r2 = -1
        L5:
            r9 = r8 & 2
            r0 = 0
            if (r9 == 0) goto Lb
            r3 = r0
        Lb:
            r9 = r8 & 4
            if (r9 == 0) goto L10
            r4 = r0
        L10:
            r9 = r8 & 8
            if (r9 == 0) goto L15
            r5 = r0
        L15:
            r9 = r8 & 16
            if (r9 == 0) goto L1a
            r6 = r0
        L1a:
            r8 = r8 & 32
            if (r8 == 0) goto L26
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2d
        L26:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2d:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTSharedCollection.<init>(int, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTSharedCollection copy$default(MTSharedCollection mTSharedCollection, int i, String str, Integer num, String str2, String str3, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTSharedCollection.id;
        }
        if ((i2 & 2) != 0) {
            str = mTSharedCollection.status;
        }
        if ((i2 & 4) != 0) {
            num = mTSharedCollection.created_by;
        }
        if ((i2 & 8) != 0) {
            str2 = mTSharedCollection.created_at;
        }
        if ((i2 & 16) != 0) {
            str3 = mTSharedCollection.updated_at;
        }
        if ((i2 & 32) != 0) {
            list = mTSharedCollection.members;
        }
        String str4 = str3;
        List list2 = list;
        return mTSharedCollection.copy(i, str, num, str2, str4, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getCreated_by() {
        return this.created_by;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCreated_at() {
        return this.created_at;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUpdated_at() {
        return this.updated_at;
    }

    public final List<MTSharedCollectionMember> component6() {
        return this.members;
    }

    public final MTSharedCollection copy(int id, String status, Integer created_by, String created_at, String updated_at, List<MTSharedCollectionMember> members) {
        return new MTSharedCollection(id, status, created_by, created_at, updated_at, members);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSharedCollection)) {
            return false;
        }
        MTSharedCollection mTSharedCollection = (MTSharedCollection) other;
        return this.id == mTSharedCollection.id && Intrinsics.areEqual(this.status, mTSharedCollection.status) && Intrinsics.areEqual(this.created_by, mTSharedCollection.created_by) && Intrinsics.areEqual(this.created_at, mTSharedCollection.created_at) && Intrinsics.areEqual(this.updated_at, mTSharedCollection.updated_at) && Intrinsics.areEqual(this.members, mTSharedCollection.members);
    }

    public final String getCreated_at() {
        return this.created_at;
    }

    public final Integer getCreated_by() {
        return this.created_by;
    }

    public final int getId() {
        return this.id;
    }

    public final List<MTSharedCollectionMember> getMembers() {
        return this.members;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getUpdated_at() {
        return this.updated_at;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id) * 31;
        String str = this.status;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.created_by;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.created_at;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.updated_at;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<MTSharedCollectionMember> list = this.members;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    public final void setCreated_at(String str) {
        this.created_at = str;
    }

    public final void setCreated_by(Integer num) {
        this.created_by = num;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setMembers(List<MTSharedCollectionMember> list) {
        this.members = list;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final void setUpdated_at(String str) {
        this.updated_at = str;
    }

    public String toString() {
        return "MTSharedCollection(id=" + this.id + ", status=" + this.status + ", created_by=" + this.created_by + ", created_at=" + this.created_at + ", updated_at=" + this.updated_at + ", members=" + this.members + ")";
    }
}
