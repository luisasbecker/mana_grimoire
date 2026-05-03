package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ^\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCreateGamePlayer;", "", "userid", "", "deckid", "position", "resultid", "name", "", "lifetotal", "teamid", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getUserid", "()Ljava/lang/Integer;", "setUserid", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDeckid", "setDeckid", "getPosition", "()I", "setPosition", "(I)V", "getResultid", "setResultid", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getLifetotal", "setLifetotal", "getTeamid", "setTeamid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTCreateGamePlayer;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCreateGamePlayer {
    public static final int $stable = 8;
    private Integer deckid;
    private Integer lifetotal;
    private String name;
    private int position;
    private int resultid;
    private Integer teamid;
    private Integer userid;

    public MTCreateGamePlayer() {
        this(null, null, 0, 0, null, null, null, 127, null);
    }

    public MTCreateGamePlayer(Integer num, Integer num2, int i, int i2, String str, Integer num3, Integer num4) {
        this.userid = num;
        this.deckid = num2;
        this.position = i;
        this.resultid = i2;
        this.name = str;
        this.lifetotal = num3;
        this.teamid = num4;
    }

    public /* synthetic */ MTCreateGamePlayer(Integer num, Integer num2, int i, int i2, String str, Integer num3, Integer num4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? null : str, (i3 & 32) != 0 ? null : num3, (i3 & 64) != 0 ? null : num4);
    }

    public static /* synthetic */ MTCreateGamePlayer copy$default(MTCreateGamePlayer mTCreateGamePlayer, Integer num, Integer num2, int i, int i2, String str, Integer num3, Integer num4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = mTCreateGamePlayer.userid;
        }
        if ((i3 & 2) != 0) {
            num2 = mTCreateGamePlayer.deckid;
        }
        if ((i3 & 4) != 0) {
            i = mTCreateGamePlayer.position;
        }
        if ((i3 & 8) != 0) {
            i2 = mTCreateGamePlayer.resultid;
        }
        if ((i3 & 16) != 0) {
            str = mTCreateGamePlayer.name;
        }
        if ((i3 & 32) != 0) {
            num3 = mTCreateGamePlayer.lifetotal;
        }
        if ((i3 & 64) != 0) {
            num4 = mTCreateGamePlayer.teamid;
        }
        Integer num5 = num3;
        Integer num6 = num4;
        String str2 = str;
        int i4 = i;
        return mTCreateGamePlayer.copy(num, num2, i4, i2, str2, num5, num6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getUserid() {
        return this.userid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getDeckid() {
        return this.deckid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getResultid() {
        return this.resultid;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getLifetotal() {
        return this.lifetotal;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getTeamid() {
        return this.teamid;
    }

    public final MTCreateGamePlayer copy(Integer userid, Integer deckid, int position, int resultid, String name, Integer lifetotal, Integer teamid) {
        return new MTCreateGamePlayer(userid, deckid, position, resultid, name, lifetotal, teamid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCreateGamePlayer)) {
            return false;
        }
        MTCreateGamePlayer mTCreateGamePlayer = (MTCreateGamePlayer) other;
        return Intrinsics.areEqual(this.userid, mTCreateGamePlayer.userid) && Intrinsics.areEqual(this.deckid, mTCreateGamePlayer.deckid) && this.position == mTCreateGamePlayer.position && this.resultid == mTCreateGamePlayer.resultid && Intrinsics.areEqual(this.name, mTCreateGamePlayer.name) && Intrinsics.areEqual(this.lifetotal, mTCreateGamePlayer.lifetotal) && Intrinsics.areEqual(this.teamid, mTCreateGamePlayer.teamid);
    }

    public final Integer getDeckid() {
        return this.deckid;
    }

    public final Integer getLifetotal() {
        return this.lifetotal;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getResultid() {
        return this.resultid;
    }

    public final Integer getTeamid() {
        return this.teamid;
    }

    public final Integer getUserid() {
        return this.userid;
    }

    public int hashCode() {
        Integer num = this.userid;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.deckid;
        int iHashCode2 = (((((iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31) + Integer.hashCode(this.position)) * 31) + Integer.hashCode(this.resultid)) * 31;
        String str = this.name;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num3 = this.lifetotal;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.teamid;
        return iHashCode4 + (num4 != null ? num4.hashCode() : 0);
    }

    public final void setDeckid(Integer num) {
        this.deckid = num;
    }

    public final void setLifetotal(Integer num) {
        this.lifetotal = num;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setResultid(int i) {
        this.resultid = i;
    }

    public final void setTeamid(Integer num) {
        this.teamid = num;
    }

    public final void setUserid(Integer num) {
        this.userid = num;
    }

    public String toString() {
        return "MTCreateGamePlayer(userid=" + this.userid + ", deckid=" + this.deckid + ", position=" + this.position + ", resultid=" + this.resultid + ", name=" + this.name + ", lifetotal=" + this.lifetotal + ", teamid=" + this.teamid + ")";
    }
}
