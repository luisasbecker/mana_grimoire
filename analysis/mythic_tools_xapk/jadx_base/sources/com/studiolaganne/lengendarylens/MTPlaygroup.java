package com.studiolaganne.lengendarylens;

import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\f0\bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u008e\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\u0003HÖ\u0001J\t\u0010I\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006J"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "", "id", "", "name", "", "description", "admins", "", "owner", AuthenticationTokenClaims.JSON_KEY_PICTURE, "users", "Lcom/studiolaganne/lengendarylens/MTUser;", "stats", "Lcom/studiolaganne/lengendarylens/MTPlaygroupStats;", "status", "unreadCount", "favorites", "Lcom/studiolaganne/lengendarylens/MTFavorites;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTPlaygroupStats;Ljava/lang/String;ILcom/studiolaganne/lengendarylens/MTFavorites;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getAdmins", "()Ljava/util/List;", "setAdmins", "(Ljava/util/List;)V", "getOwner", "()Ljava/lang/Integer;", "setOwner", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPicture", "setPicture", "getUsers", "setUsers", "getStats", "()Lcom/studiolaganne/lengendarylens/MTPlaygroupStats;", "setStats", "(Lcom/studiolaganne/lengendarylens/MTPlaygroupStats;)V", "getStatus", "setStatus", "getUnreadCount", "setUnreadCount", "getFavorites", "()Lcom/studiolaganne/lengendarylens/MTFavorites;", "setFavorites", "(Lcom/studiolaganne/lengendarylens/MTFavorites;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTPlaygroupStats;Ljava/lang/String;ILcom/studiolaganne/lengendarylens/MTFavorites;)Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTPlaygroup {
    public static final int $stable = 8;
    private List<Integer> admins;
    private String description;
    private MTFavorites favorites;
    private int id;
    private String name;
    private Integer owner;
    private String picture;
    private MTPlaygroupStats stats;
    private String status;
    private int unreadCount;
    private List<MTUser> users;

    public MTPlaygroup() {
        this(0, null, null, null, null, null, null, null, null, 0, null, 2047, null);
    }

    public MTPlaygroup(int i, String name, String description, List<Integer> admins, Integer num, String picture, List<MTUser> users, MTPlaygroupStats mTPlaygroupStats, String status, int i2, MTFavorites mTFavorites) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(admins, "admins");
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(users, "users");
        Intrinsics.checkNotNullParameter(status, "status");
        this.id = i;
        this.name = name;
        this.description = description;
        this.admins = admins;
        this.owner = num;
        this.picture = picture;
        this.users = users;
        this.stats = mTPlaygroupStats;
        this.status = status;
        this.unreadCount = i2;
        this.favorites = mTFavorites;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTPlaygroup(int r3, java.lang.String r4, java.lang.String r5, java.util.List r6, java.lang.Integer r7, java.lang.String r8, java.util.List r9, com.studiolaganne.lengendarylens.MTPlaygroupStats r10, java.lang.String r11, int r12, com.studiolaganne.lengendarylens.MTFavorites r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r2 = this;
            r15 = r14 & 1
            if (r15 == 0) goto L5
            r3 = -1
        L5:
            r15 = r14 & 2
            java.lang.String r0 = ""
            if (r15 == 0) goto Lc
            r4 = r0
        Lc:
            r15 = r14 & 4
            if (r15 == 0) goto L11
            r5 = r0
        L11:
            r15 = r14 & 8
            if (r15 == 0) goto L19
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L19:
            r15 = r14 & 16
            r1 = 0
            if (r15 == 0) goto L1f
            r7 = r1
        L1f:
            r15 = r14 & 32
            if (r15 == 0) goto L24
            r8 = r0
        L24:
            r15 = r14 & 64
            if (r15 == 0) goto L2c
            java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()
        L2c:
            r15 = r14 & 128(0x80, float:1.794E-43)
            if (r15 == 0) goto L31
            r10 = r1
        L31:
            r15 = r14 & 256(0x100, float:3.59E-43)
            if (r15 == 0) goto L36
            r11 = r0
        L36:
            r15 = r14 & 512(0x200, float:7.175E-43)
            if (r15 == 0) goto L3b
            r12 = 0
        L3b:
            r14 = r14 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L4c
            r15 = r1
            r13 = r11
            r14 = r12
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r4 = r2
            goto L58
        L4c:
            r15 = r13
            r14 = r12
            r12 = r10
            r13 = r11
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
        L58:
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTPlaygroup.<init>(int, java.lang.String, java.lang.String, java.util.List, java.lang.Integer, java.lang.String, java.util.List, com.studiolaganne.lengendarylens.MTPlaygroupStats, java.lang.String, int, com.studiolaganne.lengendarylens.MTFavorites, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTPlaygroup copy$default(MTPlaygroup mTPlaygroup, int i, String str, String str2, List list, Integer num, String str3, List list2, MTPlaygroupStats mTPlaygroupStats, String str4, int i2, MTFavorites mTFavorites, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTPlaygroup.id;
        }
        if ((i3 & 2) != 0) {
            str = mTPlaygroup.name;
        }
        if ((i3 & 4) != 0) {
            str2 = mTPlaygroup.description;
        }
        if ((i3 & 8) != 0) {
            list = mTPlaygroup.admins;
        }
        if ((i3 & 16) != 0) {
            num = mTPlaygroup.owner;
        }
        if ((i3 & 32) != 0) {
            str3 = mTPlaygroup.picture;
        }
        if ((i3 & 64) != 0) {
            list2 = mTPlaygroup.users;
        }
        if ((i3 & 128) != 0) {
            mTPlaygroupStats = mTPlaygroup.stats;
        }
        if ((i3 & 256) != 0) {
            str4 = mTPlaygroup.status;
        }
        if ((i3 & 512) != 0) {
            i2 = mTPlaygroup.unreadCount;
        }
        if ((i3 & 1024) != 0) {
            mTFavorites = mTPlaygroup.favorites;
        }
        int i4 = i2;
        MTFavorites mTFavorites2 = mTFavorites;
        MTPlaygroupStats mTPlaygroupStats2 = mTPlaygroupStats;
        String str5 = str4;
        String str6 = str3;
        List list3 = list2;
        Integer num2 = num;
        String str7 = str2;
        return mTPlaygroup.copy(i, str, str7, list, num2, str6, list3, mTPlaygroupStats2, str5, i4, mTFavorites2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final MTFavorites getFavorites() {
        return this.favorites;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<Integer> component4() {
        return this.admins;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getOwner() {
        return this.owner;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPicture() {
        return this.picture;
    }

    public final List<MTUser> component7() {
        return this.users;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final MTPlaygroupStats getStats() {
        return this.stats;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final MTPlaygroup copy(int id, String name, String description, List<Integer> admins, Integer owner, String picture, List<MTUser> users, MTPlaygroupStats stats, String status, int unreadCount, MTFavorites favorites) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(admins, "admins");
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(users, "users");
        Intrinsics.checkNotNullParameter(status, "status");
        return new MTPlaygroup(id, name, description, admins, owner, picture, users, stats, status, unreadCount, favorites);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTPlaygroup)) {
            return false;
        }
        MTPlaygroup mTPlaygroup = (MTPlaygroup) other;
        return this.id == mTPlaygroup.id && Intrinsics.areEqual(this.name, mTPlaygroup.name) && Intrinsics.areEqual(this.description, mTPlaygroup.description) && Intrinsics.areEqual(this.admins, mTPlaygroup.admins) && Intrinsics.areEqual(this.owner, mTPlaygroup.owner) && Intrinsics.areEqual(this.picture, mTPlaygroup.picture) && Intrinsics.areEqual(this.users, mTPlaygroup.users) && Intrinsics.areEqual(this.stats, mTPlaygroup.stats) && Intrinsics.areEqual(this.status, mTPlaygroup.status) && this.unreadCount == mTPlaygroup.unreadCount && Intrinsics.areEqual(this.favorites, mTPlaygroup.favorites);
    }

    public final List<Integer> getAdmins() {
        return this.admins;
    }

    public final String getDescription() {
        return this.description;
    }

    public final MTFavorites getFavorites() {
        return this.favorites;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getOwner() {
        return this.owner;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final MTPlaygroupStats getStats() {
        return this.stats;
    }

    public final String getStatus() {
        return this.status;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public final List<MTUser> getUsers() {
        return this.users;
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.admins.hashCode()) * 31;
        Integer num = this.owner;
        int iHashCode2 = (((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.picture.hashCode()) * 31) + this.users.hashCode()) * 31;
        MTPlaygroupStats mTPlaygroupStats = this.stats;
        int iHashCode3 = (((((iHashCode2 + (mTPlaygroupStats == null ? 0 : mTPlaygroupStats.hashCode())) * 31) + this.status.hashCode()) * 31) + Integer.hashCode(this.unreadCount)) * 31;
        MTFavorites mTFavorites = this.favorites;
        return iHashCode3 + (mTFavorites != null ? mTFavorites.hashCode() : 0);
    }

    public final void setAdmins(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.admins = list;
    }

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setFavorites(MTFavorites mTFavorites) {
        this.favorites = mTFavorites;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setOwner(Integer num) {
        this.owner = num;
    }

    public final void setPicture(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.picture = str;
    }

    public final void setStats(MTPlaygroupStats mTPlaygroupStats) {
        this.stats = mTPlaygroupStats;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final void setUnreadCount(int i) {
        this.unreadCount = i;
    }

    public final void setUsers(List<MTUser> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.users = list;
    }

    public String toString() {
        return "MTPlaygroup(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", admins=" + this.admins + ", owner=" + this.owner + ", picture=" + this.picture + ", users=" + this.users + ", stats=" + this.stats + ", status=" + this.status + ", unreadCount=" + this.unreadCount + ", favorites=" + this.favorites + ")";
    }
}
