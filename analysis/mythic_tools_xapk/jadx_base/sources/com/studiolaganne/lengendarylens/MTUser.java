package com.studiolaganne.lengendarylens;

import androidx.autofill.HintConstants;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b0\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u007f\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0001J\u0013\u0010=\u001a\u00020\u00032\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0005HÖ\u0001J\t\u0010@\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006A"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUser;", "", "fcm", "", "id", "", "firstname", "", "email", HintConstants.AUTOFILL_HINT_USERNAME, AuthenticationTokenClaims.JSON_KEY_PICTURE, "status", "code", "stats", "Lcom/studiolaganne/lengendarylens/MTStats;", "roles", "", "Lcom/studiolaganne/lengendarylens/MTRole;", "<init>", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTStats;Ljava/util/List;)V", "getFcm", "()Z", "setFcm", "(Z)V", "getId", "()I", "setId", "(I)V", "getFirstname", "()Ljava/lang/String;", "setFirstname", "(Ljava/lang/String;)V", "getEmail", "setEmail", "getUsername", "setUsername", "getPicture", "setPicture", "getStatus", "setStatus", "getCode", "setCode", "getStats", "()Lcom/studiolaganne/lengendarylens/MTStats;", "setStats", "(Lcom/studiolaganne/lengendarylens/MTStats;)V", "getRoles", "()Ljava/util/List;", "setRoles", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUser {
    public static final int $stable = 8;
    private String code;
    private String email;
    private boolean fcm;
    private String firstname;
    private int id;
    private String picture;
    private List<MTRole> roles;
    private MTStats stats;
    private String status;
    private String username;

    public MTUser() {
        this(false, 0, null, null, null, null, null, null, null, null, 1023, null);
    }

    public MTUser(boolean z, int i, String str, String email, String str2, String str3, String status, String str4, MTStats mTStats, List<MTRole> list) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(status, "status");
        this.fcm = z;
        this.id = i;
        this.firstname = str;
        this.email = email;
        this.username = str2;
        this.picture = str3;
        this.status = status;
        this.code = str4;
        this.stats = mTStats;
        this.roles = list;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTUser(boolean r2, int r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, com.studiolaganne.lengendarylens.MTStats r10, java.util.List r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r1 = this;
            r13 = r12 & 1
            if (r13 == 0) goto L5
            r2 = 0
        L5:
            r13 = r12 & 2
            if (r13 == 0) goto La
            r3 = -1
        La:
            r13 = r12 & 4
            java.lang.String r0 = ""
            if (r13 == 0) goto L11
            r4 = r0
        L11:
            r13 = r12 & 8
            if (r13 == 0) goto L16
            r5 = r0
        L16:
            r13 = r12 & 16
            if (r13 == 0) goto L1b
            r6 = r0
        L1b:
            r13 = r12 & 32
            if (r13 == 0) goto L20
            r7 = r0
        L20:
            r13 = r12 & 64
            if (r13 == 0) goto L25
            r8 = r0
        L25:
            r13 = r12 & 128(0x80, float:1.794E-43)
            r0 = 0
            if (r13 == 0) goto L2b
            r9 = r0
        L2b:
            r13 = r12 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L30
            r10 = r0
        L30:
            r12 = r12 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L40
            r13 = r0
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L4b
        L40:
            r13 = r11
            r12 = r10
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L4b:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTUser.<init>(boolean, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.studiolaganne.lengendarylens.MTStats, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTUser copy$default(MTUser mTUser, boolean z, int i, String str, String str2, String str3, String str4, String str5, String str6, MTStats mTStats, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = mTUser.fcm;
        }
        if ((i2 & 2) != 0) {
            i = mTUser.id;
        }
        if ((i2 & 4) != 0) {
            str = mTUser.firstname;
        }
        if ((i2 & 8) != 0) {
            str2 = mTUser.email;
        }
        if ((i2 & 16) != 0) {
            str3 = mTUser.username;
        }
        if ((i2 & 32) != 0) {
            str4 = mTUser.picture;
        }
        if ((i2 & 64) != 0) {
            str5 = mTUser.status;
        }
        if ((i2 & 128) != 0) {
            str6 = mTUser.code;
        }
        if ((i2 & 256) != 0) {
            mTStats = mTUser.stats;
        }
        if ((i2 & 512) != 0) {
            list = mTUser.roles;
        }
        MTStats mTStats2 = mTStats;
        List list2 = list;
        String str7 = str5;
        String str8 = str6;
        String str9 = str3;
        String str10 = str4;
        return mTUser.copy(z, i, str, str2, str9, str10, str7, str8, mTStats2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getFcm() {
        return this.fcm;
    }

    public final List<MTRole> component10() {
        return this.roles;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFirstname() {
        return this.firstname;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPicture() {
        return this.picture;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final MTStats getStats() {
        return this.stats;
    }

    public final MTUser copy(boolean fcm, int id, String firstname, String email, String username, String picture, String status, String code, MTStats stats, List<MTRole> roles) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(status, "status");
        return new MTUser(fcm, id, firstname, email, username, picture, status, code, stats, roles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTUser)) {
            return false;
        }
        MTUser mTUser = (MTUser) other;
        return this.fcm == mTUser.fcm && this.id == mTUser.id && Intrinsics.areEqual(this.firstname, mTUser.firstname) && Intrinsics.areEqual(this.email, mTUser.email) && Intrinsics.areEqual(this.username, mTUser.username) && Intrinsics.areEqual(this.picture, mTUser.picture) && Intrinsics.areEqual(this.status, mTUser.status) && Intrinsics.areEqual(this.code, mTUser.code) && Intrinsics.areEqual(this.stats, mTUser.stats) && Intrinsics.areEqual(this.roles, mTUser.roles);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getEmail() {
        return this.email;
    }

    public final boolean getFcm() {
        return this.fcm;
    }

    public final String getFirstname() {
        return this.firstname;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final List<MTRole> getRoles() {
        return this.roles;
    }

    public final MTStats getStats() {
        return this.stats;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.fcm) * 31) + Integer.hashCode(this.id)) * 31;
        String str = this.firstname;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.email.hashCode()) * 31;
        String str2 = this.username;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.picture;
        int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.status.hashCode()) * 31;
        String str4 = this.code;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        MTStats mTStats = this.stats;
        int iHashCode6 = (iHashCode5 + (mTStats == null ? 0 : mTStats.hashCode())) * 31;
        List<MTRole> list = this.roles;
        return iHashCode6 + (list != null ? list.hashCode() : 0);
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.email = str;
    }

    public final void setFcm(boolean z) {
        this.fcm = z;
    }

    public final void setFirstname(String str) {
        this.firstname = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setPicture(String str) {
        this.picture = str;
    }

    public final void setRoles(List<MTRole> list) {
        this.roles = list;
    }

    public final void setStats(MTStats mTStats) {
        this.stats = mTStats;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        return "MTUser(fcm=" + this.fcm + ", id=" + this.id + ", firstname=" + this.firstname + ", email=" + this.email + ", username=" + this.username + ", picture=" + this.picture + ", status=" + this.status + ", code=" + this.code + ", stats=" + this.stats + ", roles=" + this.roles + ")";
    }
}
