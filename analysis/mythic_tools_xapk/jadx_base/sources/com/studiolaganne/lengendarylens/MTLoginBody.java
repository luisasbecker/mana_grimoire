package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006&"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTLoginBody;", "", "fcmToken", "", AndroidContextPlugin.LOCALE_KEY, "firstname", "email", "code", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFcmToken", "()Ljava/lang/String;", "setFcmToken", "(Ljava/lang/String;)V", "getLocale", "setLocale", "getFirstname", "setFirstname", "getEmail", "setEmail", "getCode", "setCode", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTLoginBody {
    public static final int $stable = 8;
    private String code;
    private String email;
    private String fcmToken;
    private String firstname;
    private String locale;
    private String type;

    public MTLoginBody() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MTLoginBody(String fcmToken, String locale, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(fcmToken, "fcmToken");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.fcmToken = fcmToken;
        this.locale = locale;
        this.firstname = str;
        this.email = str2;
        this.code = str3;
        this.type = str4;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTLoginBody(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r9 = r8 & 2
            if (r9 == 0) goto Lc
            java.lang.String r3 = "en"
        Lc:
            r9 = r8 & 4
            r0 = 0
            if (r9 == 0) goto L12
            r4 = r0
        L12:
            r9 = r8 & 8
            if (r9 == 0) goto L17
            r5 = r0
        L17:
            r9 = r8 & 16
            if (r9 == 0) goto L1c
            r6 = r0
        L1c:
            r8 = r8 & 32
            if (r8 == 0) goto L28
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2f
        L28:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2f:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTLoginBody.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ MTLoginBody copy$default(MTLoginBody mTLoginBody, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTLoginBody.fcmToken;
        }
        if ((i & 2) != 0) {
            str2 = mTLoginBody.locale;
        }
        if ((i & 4) != 0) {
            str3 = mTLoginBody.firstname;
        }
        if ((i & 8) != 0) {
            str4 = mTLoginBody.email;
        }
        if ((i & 16) != 0) {
            str5 = mTLoginBody.code;
        }
        if ((i & 32) != 0) {
            str6 = mTLoginBody.type;
        }
        String str7 = str5;
        String str8 = str6;
        return mTLoginBody.copy(str, str2, str3, str4, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFcmToken() {
        return this.fcmToken;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLocale() {
        return this.locale;
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
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final MTLoginBody copy(String fcmToken, String locale, String firstname, String email, String code, String type) {
        Intrinsics.checkNotNullParameter(fcmToken, "fcmToken");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new MTLoginBody(fcmToken, locale, firstname, email, code, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTLoginBody)) {
            return false;
        }
        MTLoginBody mTLoginBody = (MTLoginBody) other;
        return Intrinsics.areEqual(this.fcmToken, mTLoginBody.fcmToken) && Intrinsics.areEqual(this.locale, mTLoginBody.locale) && Intrinsics.areEqual(this.firstname, mTLoginBody.firstname) && Intrinsics.areEqual(this.email, mTLoginBody.email) && Intrinsics.areEqual(this.code, mTLoginBody.code) && Intrinsics.areEqual(this.type, mTLoginBody.type);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getFcmToken() {
        return this.fcmToken;
    }

    public final String getFirstname() {
        return this.firstname;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((this.fcmToken.hashCode() * 31) + this.locale.hashCode()) * 31;
        String str = this.firstname;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.email;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.code;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.type;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final void setFcmToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fcmToken = str;
    }

    public final void setFirstname(String str) {
        this.firstname = str;
    }

    public final void setLocale(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.locale = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "MTLoginBody(fcmToken=" + this.fcmToken + ", locale=" + this.locale + ", firstname=" + this.firstname + ", email=" + this.email + ", code=" + this.code + ", type=" + this.type + ")";
    }
}
