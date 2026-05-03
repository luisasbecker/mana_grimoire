package com.studiolaganne.lengendarylens;

import androidx.autofill.HintConstants;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b3\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010;\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010.J~\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u000f2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0003HÖ\u0001J\t\u0010A\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b+\u0010%\"\u0004\b,\u0010'R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006B"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGamePlayer;", "", "id", "", "firstname", "", HintConstants.AUTOFILL_HINT_USERNAME, AuthenticationTokenClaims.JSON_KEY_PICTURE, "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "position", "resultid", "teamid", "lifetotal", "startingplayer", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTDeck;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getId", "()I", "setId", "(I)V", "getFirstname", "()Ljava/lang/String;", "setFirstname", "(Ljava/lang/String;)V", "getUsername", "setUsername", "getPicture", "setPicture", "getDeck", "()Lcom/studiolaganne/lengendarylens/MTDeck;", "setDeck", "(Lcom/studiolaganne/lengendarylens/MTDeck;)V", "getPosition", "setPosition", "getResultid", "()Ljava/lang/Integer;", "setResultid", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTeamid", "setTeamid", "getLifetotal", "setLifetotal", "getStartingplayer", "()Ljava/lang/Boolean;", "setStartingplayer", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTDeck;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTGamePlayer;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTGamePlayer {
    public static final int $stable = 8;
    private MTDeck deck;
    private String firstname;
    private int id;
    private Integer lifetotal;
    private String picture;
    private int position;
    private Integer resultid;
    private Boolean startingplayer;
    private Integer teamid;
    private String username;

    public MTGamePlayer() {
        this(0, null, null, null, null, 0, null, null, null, null, 1023, null);
    }

    public MTGamePlayer(int i, String firstname, String username, String str, MTDeck mTDeck, int i2, Integer num, Integer num2, Integer num3, Boolean bool) {
        Intrinsics.checkNotNullParameter(firstname, "firstname");
        Intrinsics.checkNotNullParameter(username, "username");
        this.id = i;
        this.firstname = firstname;
        this.username = username;
        this.picture = str;
        this.deck = mTDeck;
        this.position = i2;
        this.resultid = num;
        this.teamid = num2;
        this.lifetotal = num3;
        this.startingplayer = bool;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MTGamePlayer(int r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, com.studiolaganne.lengendarylens.MTDeck r6, int r7, java.lang.Integer r8, java.lang.Integer r9, java.lang.Integer r10, java.lang.Boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r1 = this;
            r13 = r12 & 1
            if (r13 == 0) goto L5
            r2 = -1
        L5:
            r13 = r12 & 2
            java.lang.String r0 = ""
            if (r13 == 0) goto Lc
            r3 = r0
        Lc:
            r13 = r12 & 4
            if (r13 == 0) goto L11
            r4 = r0
        L11:
            r13 = r12 & 8
            r0 = 0
            if (r13 == 0) goto L17
            r5 = r0
        L17:
            r13 = r12 & 16
            if (r13 == 0) goto L1c
            r6 = r0
        L1c:
            r13 = r12 & 32
            if (r13 == 0) goto L21
            r7 = 0
        L21:
            r13 = r12 & 64
            if (r13 == 0) goto L26
            r8 = r0
        L26:
            r13 = r12 & 128(0x80, float:1.794E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTGamePlayer.<init>(int, java.lang.String, java.lang.String, java.lang.String, com.studiolaganne.lengendarylens.MTDeck, int, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ MTGamePlayer copy$default(MTGamePlayer mTGamePlayer, int i, String str, String str2, String str3, MTDeck mTDeck, int i2, Integer num, Integer num2, Integer num3, Boolean bool, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTGamePlayer.id;
        }
        if ((i3 & 2) != 0) {
            str = mTGamePlayer.firstname;
        }
        if ((i3 & 4) != 0) {
            str2 = mTGamePlayer.username;
        }
        if ((i3 & 8) != 0) {
            str3 = mTGamePlayer.picture;
        }
        if ((i3 & 16) != 0) {
            mTDeck = mTGamePlayer.deck;
        }
        if ((i3 & 32) != 0) {
            i2 = mTGamePlayer.position;
        }
        if ((i3 & 64) != 0) {
            num = mTGamePlayer.resultid;
        }
        if ((i3 & 128) != 0) {
            num2 = mTGamePlayer.teamid;
        }
        if ((i3 & 256) != 0) {
            num3 = mTGamePlayer.lifetotal;
        }
        if ((i3 & 512) != 0) {
            bool = mTGamePlayer.startingplayer;
        }
        Integer num4 = num3;
        Boolean bool2 = bool;
        Integer num5 = num;
        Integer num6 = num2;
        MTDeck mTDeck2 = mTDeck;
        int i4 = i2;
        return mTGamePlayer.copy(i, str, str2, str3, mTDeck2, i4, num5, num6, num4, bool2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Boolean getStartingplayer() {
        return this.startingplayer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFirstname() {
        return this.firstname;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPicture() {
        return this.picture;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MTDeck getDeck() {
        return this.deck;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getResultid() {
        return this.resultid;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getTeamid() {
        return this.teamid;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getLifetotal() {
        return this.lifetotal;
    }

    public final MTGamePlayer copy(int id, String firstname, String username, String picture, MTDeck deck, int position, Integer resultid, Integer teamid, Integer lifetotal, Boolean startingplayer) {
        Intrinsics.checkNotNullParameter(firstname, "firstname");
        Intrinsics.checkNotNullParameter(username, "username");
        return new MTGamePlayer(id, firstname, username, picture, deck, position, resultid, teamid, lifetotal, startingplayer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTGamePlayer)) {
            return false;
        }
        MTGamePlayer mTGamePlayer = (MTGamePlayer) other;
        return this.id == mTGamePlayer.id && Intrinsics.areEqual(this.firstname, mTGamePlayer.firstname) && Intrinsics.areEqual(this.username, mTGamePlayer.username) && Intrinsics.areEqual(this.picture, mTGamePlayer.picture) && Intrinsics.areEqual(this.deck, mTGamePlayer.deck) && this.position == mTGamePlayer.position && Intrinsics.areEqual(this.resultid, mTGamePlayer.resultid) && Intrinsics.areEqual(this.teamid, mTGamePlayer.teamid) && Intrinsics.areEqual(this.lifetotal, mTGamePlayer.lifetotal) && Intrinsics.areEqual(this.startingplayer, mTGamePlayer.startingplayer);
    }

    public final MTDeck getDeck() {
        return this.deck;
    }

    public final String getFirstname() {
        return this.firstname;
    }

    public final int getId() {
        return this.id;
    }

    public final Integer getLifetotal() {
        return this.lifetotal;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final int getPosition() {
        return this.position;
    }

    public final Integer getResultid() {
        return this.resultid;
    }

    public final Boolean getStartingplayer() {
        return this.startingplayer;
    }

    public final Integer getTeamid() {
        return this.teamid;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.id) * 31) + this.firstname.hashCode()) * 31) + this.username.hashCode()) * 31;
        String str = this.picture;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        MTDeck mTDeck = this.deck;
        int iHashCode3 = (((iHashCode2 + (mTDeck == null ? 0 : mTDeck.hashCode())) * 31) + Integer.hashCode(this.position)) * 31;
        Integer num = this.resultid;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.teamid;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.lifetotal;
        int iHashCode6 = (iHashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool = this.startingplayer;
        return iHashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setDeck(MTDeck mTDeck) {
        this.deck = mTDeck;
    }

    public final void setFirstname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstname = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setLifetotal(Integer num) {
        this.lifetotal = num;
    }

    public final void setPicture(String str) {
        this.picture = str;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setResultid(Integer num) {
        this.resultid = num;
    }

    public final void setStartingplayer(Boolean bool) {
        this.startingplayer = bool;
    }

    public final void setTeamid(Integer num) {
        this.teamid = num;
    }

    public final void setUsername(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.username = str;
    }

    public String toString() {
        return "MTGamePlayer(id=" + this.id + ", firstname=" + this.firstname + ", username=" + this.username + ", picture=" + this.picture + ", deck=" + this.deck + ", position=" + this.position + ", resultid=" + this.resultid + ", teamid=" + this.teamid + ", lifetotal=" + this.lifetotal + ", startingplayer=" + this.startingplayer + ")";
    }
}
