package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010<\u001a\u00020\tHÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0094\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u0003HÖ\u0001J\t\u0010H\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001d¨\u0006I"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCreateGame;", "", "formatid", "", "subformatid", "playgroupid", "created_by", "winner", "started_at", "", "ended_at", "players", "", "Lcom/studiolaganne/lengendarylens/MTCreateGamePlayer;", "events", "", "Lcom/studiolaganne/lengendarylens/MTGameEvent;", "set", "Lcom/studiolaganne/lengendarylens/MTSet;", "pausetime", "<init>", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTSet;Ljava/lang/Integer;)V", "getFormatid", "()I", "setFormatid", "(I)V", "getSubformatid", "()Ljava/lang/Integer;", "setSubformatid", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPlaygroupid", "setPlaygroupid", "getCreated_by", "setCreated_by", "getWinner", "setWinner", "getStarted_at", "()Ljava/lang/String;", "setStarted_at", "(Ljava/lang/String;)V", "getEnded_at", "setEnded_at", "getPlayers", "()Ljava/util/List;", "setPlayers", "(Ljava/util/List;)V", "getEvents", "setEvents", "getSet", "()Lcom/studiolaganne/lengendarylens/MTSet;", "setSet", "(Lcom/studiolaganne/lengendarylens/MTSet;)V", "getPausetime", "setPausetime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTSet;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTCreateGame;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCreateGame {
    public static final int $stable = 8;
    private Integer created_by;
    private String ended_at;
    private List<MTGameEvent> events;
    private int formatid;
    private Integer pausetime;
    private List<MTCreateGamePlayer> players;
    private Integer playgroupid;
    private MTSet set;
    private String started_at;
    private Integer subformatid;
    private Integer winner;

    public MTCreateGame() {
        this(0, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public MTCreateGame(int i, Integer num, Integer num2, Integer num3, Integer num4, String started_at, String ended_at, List<MTCreateGamePlayer> players, List<MTGameEvent> events, MTSet mTSet, Integer num5) {
        Intrinsics.checkNotNullParameter(started_at, "started_at");
        Intrinsics.checkNotNullParameter(ended_at, "ended_at");
        Intrinsics.checkNotNullParameter(players, "players");
        Intrinsics.checkNotNullParameter(events, "events");
        this.formatid = i;
        this.subformatid = num;
        this.playgroupid = num2;
        this.created_by = num3;
        this.winner = num4;
        this.started_at = started_at;
        this.ended_at = ended_at;
        this.players = players;
        this.events = events;
        this.set = mTSet;
        this.pausetime = num5;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTCreateGame(int r3, java.lang.Integer r4, java.lang.Integer r5, java.lang.Integer r6, java.lang.Integer r7, java.lang.String r8, java.lang.String r9, java.util.List r10, java.util.List r11, com.studiolaganne.lengendarylens.MTSet r12, java.lang.Integer r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r2 = this;
            r15 = r14 & 1
            if (r15 == 0) goto L5
            r3 = -1
        L5:
            r15 = r14 & 2
            r0 = 0
            if (r15 == 0) goto Lb
            r4 = r0
        Lb:
            r15 = r14 & 4
            if (r15 == 0) goto L10
            r5 = r0
        L10:
            r15 = r14 & 8
            if (r15 == 0) goto L15
            r6 = r0
        L15:
            r15 = r14 & 16
            if (r15 == 0) goto L1a
            r7 = r0
        L1a:
            r15 = r14 & 32
            java.lang.String r1 = ""
            if (r15 == 0) goto L21
            r8 = r1
        L21:
            r15 = r14 & 64
            if (r15 == 0) goto L26
            r9 = r1
        L26:
            r15 = r14 & 128(0x80, float:1.794E-43)
            if (r15 == 0) goto L31
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
        L31:
            r15 = r14 & 256(0x100, float:3.59E-43)
            if (r15 == 0) goto L39
            java.util.List r11 = kotlin.collections.CollectionsKt.emptyList()
        L39:
            r15 = r14 & 512(0x200, float:7.175E-43)
            if (r15 == 0) goto L3e
            r12 = r0
        L3e:
            r14 = r14 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L4f
            r15 = r0
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
            goto L5b
        L4f:
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
        L5b:
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTCreateGame.<init>(int, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.util.List, java.util.List, com.studiolaganne.lengendarylens.MTSet, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCreateGame copy$default(MTCreateGame mTCreateGame, int i, Integer num, Integer num2, Integer num3, Integer num4, String str, String str2, List list, List list2, MTSet mTSet, Integer num5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTCreateGame.formatid;
        }
        if ((i2 & 2) != 0) {
            num = mTCreateGame.subformatid;
        }
        if ((i2 & 4) != 0) {
            num2 = mTCreateGame.playgroupid;
        }
        if ((i2 & 8) != 0) {
            num3 = mTCreateGame.created_by;
        }
        if ((i2 & 16) != 0) {
            num4 = mTCreateGame.winner;
        }
        if ((i2 & 32) != 0) {
            str = mTCreateGame.started_at;
        }
        if ((i2 & 64) != 0) {
            str2 = mTCreateGame.ended_at;
        }
        if ((i2 & 128) != 0) {
            list = mTCreateGame.players;
        }
        if ((i2 & 256) != 0) {
            list2 = mTCreateGame.events;
        }
        if ((i2 & 512) != 0) {
            mTSet = mTCreateGame.set;
        }
        if ((i2 & 1024) != 0) {
            num5 = mTCreateGame.pausetime;
        }
        MTSet mTSet2 = mTSet;
        Integer num6 = num5;
        List list3 = list;
        List list4 = list2;
        String str3 = str;
        String str4 = str2;
        Integer num7 = num4;
        Integer num8 = num2;
        return mTCreateGame.copy(i, num, num8, num3, num7, str3, str4, list3, list4, mTSet2, num6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFormatid() {
        return this.formatid;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final MTSet getSet() {
        return this.set;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getPausetime() {
        return this.pausetime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getSubformatid() {
        return this.subformatid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getPlaygroupid() {
        return this.playgroupid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getCreated_by() {
        return this.created_by;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getWinner() {
        return this.winner;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStarted_at() {
        return this.started_at;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getEnded_at() {
        return this.ended_at;
    }

    public final List<MTCreateGamePlayer> component8() {
        return this.players;
    }

    public final List<MTGameEvent> component9() {
        return this.events;
    }

    public final MTCreateGame copy(int formatid, Integer subformatid, Integer playgroupid, Integer created_by, Integer winner, String started_at, String ended_at, List<MTCreateGamePlayer> players, List<MTGameEvent> events, MTSet set, Integer pausetime) {
        Intrinsics.checkNotNullParameter(started_at, "started_at");
        Intrinsics.checkNotNullParameter(ended_at, "ended_at");
        Intrinsics.checkNotNullParameter(players, "players");
        Intrinsics.checkNotNullParameter(events, "events");
        return new MTCreateGame(formatid, subformatid, playgroupid, created_by, winner, started_at, ended_at, players, events, set, pausetime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCreateGame)) {
            return false;
        }
        MTCreateGame mTCreateGame = (MTCreateGame) other;
        return this.formatid == mTCreateGame.formatid && Intrinsics.areEqual(this.subformatid, mTCreateGame.subformatid) && Intrinsics.areEqual(this.playgroupid, mTCreateGame.playgroupid) && Intrinsics.areEqual(this.created_by, mTCreateGame.created_by) && Intrinsics.areEqual(this.winner, mTCreateGame.winner) && Intrinsics.areEqual(this.started_at, mTCreateGame.started_at) && Intrinsics.areEqual(this.ended_at, mTCreateGame.ended_at) && Intrinsics.areEqual(this.players, mTCreateGame.players) && Intrinsics.areEqual(this.events, mTCreateGame.events) && Intrinsics.areEqual(this.set, mTCreateGame.set) && Intrinsics.areEqual(this.pausetime, mTCreateGame.pausetime);
    }

    public final Integer getCreated_by() {
        return this.created_by;
    }

    public final String getEnded_at() {
        return this.ended_at;
    }

    public final List<MTGameEvent> getEvents() {
        return this.events;
    }

    public final int getFormatid() {
        return this.formatid;
    }

    public final Integer getPausetime() {
        return this.pausetime;
    }

    public final List<MTCreateGamePlayer> getPlayers() {
        return this.players;
    }

    public final Integer getPlaygroupid() {
        return this.playgroupid;
    }

    public final MTSet getSet() {
        return this.set;
    }

    public final String getStarted_at() {
        return this.started_at;
    }

    public final Integer getSubformatid() {
        return this.subformatid;
    }

    public final Integer getWinner() {
        return this.winner;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.formatid) * 31;
        Integer num = this.subformatid;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.playgroupid;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.created_by;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.winner;
        int iHashCode5 = (((((((((iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31) + this.started_at.hashCode()) * 31) + this.ended_at.hashCode()) * 31) + this.players.hashCode()) * 31) + this.events.hashCode()) * 31;
        MTSet mTSet = this.set;
        int iHashCode6 = (iHashCode5 + (mTSet == null ? 0 : mTSet.hashCode())) * 31;
        Integer num5 = this.pausetime;
        return iHashCode6 + (num5 != null ? num5.hashCode() : 0);
    }

    public final void setCreated_by(Integer num) {
        this.created_by = num;
    }

    public final void setEnded_at(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ended_at = str;
    }

    public final void setEvents(List<MTGameEvent> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.events = list;
    }

    public final void setFormatid(int i) {
        this.formatid = i;
    }

    public final void setPausetime(Integer num) {
        this.pausetime = num;
    }

    public final void setPlayers(List<MTCreateGamePlayer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.players = list;
    }

    public final void setPlaygroupid(Integer num) {
        this.playgroupid = num;
    }

    public final void setSet(MTSet mTSet) {
        this.set = mTSet;
    }

    public final void setStarted_at(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.started_at = str;
    }

    public final void setSubformatid(Integer num) {
        this.subformatid = num;
    }

    public final void setWinner(Integer num) {
        this.winner = num;
    }

    public String toString() {
        return "MTCreateGame(formatid=" + this.formatid + ", subformatid=" + this.subformatid + ", playgroupid=" + this.playgroupid + ", created_by=" + this.created_by + ", winner=" + this.winner + ", started_at=" + this.started_at + ", ended_at=" + this.ended_at + ", players=" + this.players + ", events=" + this.events + ", set=" + this.set + ", pausetime=" + this.pausetime + ")";
    }
}
