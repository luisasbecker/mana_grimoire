package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003JT\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006/"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSharedCollectionInviteParticipant;", "", "userid", "", "role", "", "required", "", "status", "responded_at", "user", "Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "<init>", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTPrivacyUser;)V", "getUserid", "()I", "setUserid", "(I)V", "getRole", "()Ljava/lang/String;", "setRole", "(Ljava/lang/String;)V", "getRequired", "()Ljava/lang/Boolean;", "setRequired", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getStatus", "setStatus", "getResponded_at", "setResponded_at", "getUser", "()Lcom/studiolaganne/lengendarylens/MTPrivacyUser;", "setUser", "(Lcom/studiolaganne/lengendarylens/MTPrivacyUser;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTPrivacyUser;)Lcom/studiolaganne/lengendarylens/MTSharedCollectionInviteParticipant;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSharedCollectionInviteParticipant {
    public static final int $stable = 8;
    private Boolean required;
    private String responded_at;
    private String role;
    private String status;
    private MTPrivacyUser user;
    private int userid;

    public MTSharedCollectionInviteParticipant() {
        this(0, null, null, null, null, null, 63, null);
    }

    public MTSharedCollectionInviteParticipant(int i, String str, Boolean bool, String str2, String str3, MTPrivacyUser mTPrivacyUser) {
        this.userid = i;
        this.role = str;
        this.required = bool;
        this.status = str2;
        this.responded_at = str3;
        this.user = mTPrivacyUser;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTSharedCollectionInviteParticipant(int r2, java.lang.String r3, java.lang.Boolean r4, java.lang.String r5, java.lang.String r6, com.studiolaganne.lengendarylens.MTPrivacyUser r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTSharedCollectionInviteParticipant.<init>(int, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, com.studiolaganne.lengendarylens.MTPrivacyUser, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ MTSharedCollectionInviteParticipant copy$default(MTSharedCollectionInviteParticipant mTSharedCollectionInviteParticipant, int i, String str, Boolean bool, String str2, String str3, MTPrivacyUser mTPrivacyUser, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTSharedCollectionInviteParticipant.userid;
        }
        if ((i2 & 2) != 0) {
            str = mTSharedCollectionInviteParticipant.role;
        }
        if ((i2 & 4) != 0) {
            bool = mTSharedCollectionInviteParticipant.required;
        }
        if ((i2 & 8) != 0) {
            str2 = mTSharedCollectionInviteParticipant.status;
        }
        if ((i2 & 16) != 0) {
            str3 = mTSharedCollectionInviteParticipant.responded_at;
        }
        if ((i2 & 32) != 0) {
            mTPrivacyUser = mTSharedCollectionInviteParticipant.user;
        }
        String str4 = str3;
        MTPrivacyUser mTPrivacyUser2 = mTPrivacyUser;
        return mTSharedCollectionInviteParticipant.copy(i, str, bool, str2, str4, mTPrivacyUser2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getUserid() {
        return this.userid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getRequired() {
        return this.required;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getResponded_at() {
        return this.responded_at;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTPrivacyUser getUser() {
        return this.user;
    }

    public final MTSharedCollectionInviteParticipant copy(int userid, String role, Boolean required, String status, String responded_at, MTPrivacyUser user) {
        return new MTSharedCollectionInviteParticipant(userid, role, required, status, responded_at, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSharedCollectionInviteParticipant)) {
            return false;
        }
        MTSharedCollectionInviteParticipant mTSharedCollectionInviteParticipant = (MTSharedCollectionInviteParticipant) other;
        return this.userid == mTSharedCollectionInviteParticipant.userid && Intrinsics.areEqual(this.role, mTSharedCollectionInviteParticipant.role) && Intrinsics.areEqual(this.required, mTSharedCollectionInviteParticipant.required) && Intrinsics.areEqual(this.status, mTSharedCollectionInviteParticipant.status) && Intrinsics.areEqual(this.responded_at, mTSharedCollectionInviteParticipant.responded_at) && Intrinsics.areEqual(this.user, mTSharedCollectionInviteParticipant.user);
    }

    public final Boolean getRequired() {
        return this.required;
    }

    public final String getResponded_at() {
        return this.responded_at;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getStatus() {
        return this.status;
    }

    public final MTPrivacyUser getUser() {
        return this.user;
    }

    public final int getUserid() {
        return this.userid;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.userid) * 31;
        String str = this.role;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.required;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.status;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.responded_at;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        MTPrivacyUser mTPrivacyUser = this.user;
        return iHashCode5 + (mTPrivacyUser != null ? mTPrivacyUser.hashCode() : 0);
    }

    public final void setRequired(Boolean bool) {
        this.required = bool;
    }

    public final void setResponded_at(String str) {
        this.responded_at = str;
    }

    public final void setRole(String str) {
        this.role = str;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final void setUser(MTPrivacyUser mTPrivacyUser) {
        this.user = mTPrivacyUser;
    }

    public final void setUserid(int i) {
        this.userid = i;
    }

    public String toString() {
        return "MTSharedCollectionInviteParticipant(userid=" + this.userid + ", role=" + this.role + ", required=" + this.required + ", status=" + this.status + ", responded_at=" + this.responded_at + ", user=" + this.user + ")";
    }
}
