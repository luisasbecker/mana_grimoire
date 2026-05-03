package com.studiolaganne.lengendarylens;

import androidx.autofill.HintConstants;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003JC\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSharedPlayer;", "", "id", "", HintConstants.AUTOFILL_HINT_USERNAME, "", "firstname", AuthenticationTokenClaims.JSON_KEY_PICTURE, "stats", "Lcom/studiolaganne/lengendarylens/MTSharedPlayerStats;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTSharedPlayerStats;)V", "getId", "()I", "setId", "(I)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "getFirstname", "setFirstname", "getPicture", "setPicture", "getStats", "()Lcom/studiolaganne/lengendarylens/MTSharedPlayerStats;", "setStats", "(Lcom/studiolaganne/lengendarylens/MTSharedPlayerStats;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSharedPlayer {
    public static final int $stable = 8;
    private String firstname;
    private int id;
    private String picture;
    private MTSharedPlayerStats stats;
    private String username;

    public MTSharedPlayer() {
        this(0, null, null, null, null, 31, null);
    }

    public MTSharedPlayer(int i, String str, String str2, String str3, MTSharedPlayerStats mTSharedPlayerStats) {
        this.id = i;
        this.username = str;
        this.firstname = str2;
        this.picture = str3;
        this.stats = mTSharedPlayerStats;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTSharedPlayer(int r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, com.studiolaganne.lengendarylens.MTSharedPlayerStats r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L5
            r2 = -1
        L5:
            r8 = r7 & 2
            r0 = 0
            if (r8 == 0) goto Lb
            r3 = r0
        Lb:
            r8 = r7 & 4
            if (r8 == 0) goto L10
            r4 = r0
        L10:
            r8 = r7 & 8
            if (r8 == 0) goto L15
            r5 = r0
        L15:
            r7 = r7 & 16
            if (r7 == 0) goto L20
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L26
        L20:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L26:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTSharedPlayer.<init>(int, java.lang.String, java.lang.String, java.lang.String, com.studiolaganne.lengendarylens.MTSharedPlayerStats, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ MTSharedPlayer copy$default(MTSharedPlayer mTSharedPlayer, int i, String str, String str2, String str3, MTSharedPlayerStats mTSharedPlayerStats, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTSharedPlayer.id;
        }
        if ((i2 & 2) != 0) {
            str = mTSharedPlayer.username;
        }
        if ((i2 & 4) != 0) {
            str2 = mTSharedPlayer.firstname;
        }
        if ((i2 & 8) != 0) {
            str3 = mTSharedPlayer.picture;
        }
        if ((i2 & 16) != 0) {
            mTSharedPlayerStats = mTSharedPlayer.stats;
        }
        MTSharedPlayerStats mTSharedPlayerStats2 = mTSharedPlayerStats;
        String str4 = str2;
        return mTSharedPlayer.copy(i, str, str4, str3, mTSharedPlayerStats2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFirstname() {
        return this.firstname;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPicture() {
        return this.picture;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTSharedPlayerStats getStats() {
        return this.stats;
    }

    public final MTSharedPlayer copy(int id, String username, String firstname, String picture, MTSharedPlayerStats stats) {
        return new MTSharedPlayer(id, username, firstname, picture, stats);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSharedPlayer)) {
            return false;
        }
        MTSharedPlayer mTSharedPlayer = (MTSharedPlayer) other;
        return this.id == mTSharedPlayer.id && Intrinsics.areEqual(this.username, mTSharedPlayer.username) && Intrinsics.areEqual(this.firstname, mTSharedPlayer.firstname) && Intrinsics.areEqual(this.picture, mTSharedPlayer.picture) && Intrinsics.areEqual(this.stats, mTSharedPlayer.stats);
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

    public final MTSharedPlayerStats getStats() {
        return this.stats;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id) * 31;
        String str = this.username;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.firstname;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.picture;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        MTSharedPlayerStats mTSharedPlayerStats = this.stats;
        return iHashCode4 + (mTSharedPlayerStats != null ? mTSharedPlayerStats.hashCode() : 0);
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

    public final void setStats(MTSharedPlayerStats mTSharedPlayerStats) {
        this.stats = mTSharedPlayerStats;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        return "MTSharedPlayer(id=" + this.id + ", username=" + this.username + ", firstname=" + this.firstname + ", picture=" + this.picture + ", stats=" + this.stats + ")";
    }
}
