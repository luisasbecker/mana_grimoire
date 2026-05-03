package com.studiolaganne.lengendarylens;

import androidx.autofill.HintConstants;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b%\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J[\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010,\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001f\"\u0004\b\"\u0010!¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTFriend;", "", "id", "", "firstname", "", "email", HintConstants.AUTOFILL_HINT_USERNAME, AuthenticationTokenClaims.JSON_KEY_PICTURE, "status", "is_requestee", "", "is_requester", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getId", "()I", "setId", "(I)V", "getFirstname", "()Ljava/lang/String;", "setFirstname", "(Ljava/lang/String;)V", "getEmail", "setEmail", "getUsername", "setUsername", "getPicture", "setPicture", "getStatus", "setStatus", "()Z", "set_requestee", "(Z)V", "set_requester", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTFriend {
    public static final int $stable = 8;
    private String email;
    private String firstname;
    private int id;
    private boolean is_requestee;
    private boolean is_requester;
    private String picture;
    private String status;
    private String username;

    public MTFriend() {
        this(0, null, null, null, null, null, false, false, 255, null);
    }

    public MTFriend(int i, String firstname, String email, String username, String str, String status, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(firstname, "firstname");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(status, "status");
        this.id = i;
        this.firstname = firstname;
        this.email = email;
        this.username = username;
        this.picture = str;
        this.status = status;
        this.is_requestee = z;
        this.is_requester = z2;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTFriend(int r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, boolean r8, boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r1 = this;
            r11 = r10 & 1
            if (r11 == 0) goto L5
            r2 = -1
        L5:
            r11 = r10 & 2
            java.lang.String r0 = ""
            if (r11 == 0) goto Lc
            r3 = r0
        Lc:
            r11 = r10 & 4
            if (r11 == 0) goto L11
            r4 = r0
        L11:
            r11 = r10 & 8
            if (r11 == 0) goto L16
            r5 = r0
        L16:
            r11 = r10 & 16
            if (r11 == 0) goto L1b
            r6 = r0
        L1b:
            r11 = r10 & 32
            if (r11 == 0) goto L20
            r7 = r0
        L20:
            r11 = r10 & 64
            r0 = 0
            if (r11 == 0) goto L26
            r8 = r0
        L26:
            r10 = r10 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L34
            r11 = r0
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L3d
        L34:
            r11 = r9
            r10 = r8
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L3d:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTFriend.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ MTFriend copy$default(MTFriend mTFriend, int i, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTFriend.id;
        }
        if ((i2 & 2) != 0) {
            str = mTFriend.firstname;
        }
        if ((i2 & 4) != 0) {
            str2 = mTFriend.email;
        }
        if ((i2 & 8) != 0) {
            str3 = mTFriend.username;
        }
        if ((i2 & 16) != 0) {
            str4 = mTFriend.picture;
        }
        if ((i2 & 32) != 0) {
            str5 = mTFriend.status;
        }
        if ((i2 & 64) != 0) {
            z = mTFriend.is_requestee;
        }
        if ((i2 & 128) != 0) {
            z2 = mTFriend.is_requester;
        }
        boolean z3 = z;
        boolean z4 = z2;
        String str6 = str4;
        String str7 = str5;
        return mTFriend.copy(i, str, str2, str3, str6, str7, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFirstname() {
        return this.firstname;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPicture() {
        return this.picture;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIs_requestee() {
        return this.is_requestee;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIs_requester() {
        return this.is_requester;
    }

    public final MTFriend copy(int id, String firstname, String email, String username, String picture, String status, boolean is_requestee, boolean is_requester) {
        Intrinsics.checkNotNullParameter(firstname, "firstname");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(status, "status");
        return new MTFriend(id, firstname, email, username, picture, status, is_requestee, is_requester);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTFriend)) {
            return false;
        }
        MTFriend mTFriend = (MTFriend) other;
        return this.id == mTFriend.id && Intrinsics.areEqual(this.firstname, mTFriend.firstname) && Intrinsics.areEqual(this.email, mTFriend.email) && Intrinsics.areEqual(this.username, mTFriend.username) && Intrinsics.areEqual(this.picture, mTFriend.picture) && Intrinsics.areEqual(this.status, mTFriend.status) && this.is_requestee == mTFriend.is_requestee && this.is_requester == mTFriend.is_requester;
    }

    public final String getEmail() {
        return this.email;
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

    public final String getStatus() {
        return this.status;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.id) * 31) + this.firstname.hashCode()) * 31) + this.email.hashCode()) * 31) + this.username.hashCode()) * 31;
        String str = this.picture;
        return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.status.hashCode()) * 31) + Boolean.hashCode(this.is_requestee)) * 31) + Boolean.hashCode(this.is_requester);
    }

    public final boolean is_requestee() {
        return this.is_requestee;
    }

    public final boolean is_requester() {
        return this.is_requester;
    }

    public final void setEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.email = str;
    }

    public final void setFirstname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstname = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setPicture(String str) {
        this.picture = str;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final void setUsername(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.username = str;
    }

    public final void set_requestee(boolean z) {
        this.is_requestee = z;
    }

    public final void set_requester(boolean z) {
        this.is_requester = z;
    }

    public String toString() {
        return "MTFriend(id=" + this.id + ", firstname=" + this.firstname + ", email=" + this.email + ", username=" + this.username + ", picture=" + this.picture + ", status=" + this.status + ", is_requestee=" + this.is_requestee + ", is_requester=" + this.is_requester + ")";
    }
}
