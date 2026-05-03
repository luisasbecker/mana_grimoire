package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003JN\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014¨\u0006,"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGameEvent;", "", "id", "", "type", "", "playerid", "source_playerid", "value", "date", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getPlayerid", "()I", "setPlayerid", "(I)V", "getSource_playerid", "setSource_playerid", "getValue", "setValue", "getDate", "setDate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;)Lcom/studiolaganne/lengendarylens/MTGameEvent;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTGameEvent {
    public static final int $stable = 8;
    private String date;
    private Integer id;
    private int playerid;
    private Integer source_playerid;
    private String type;
    private int value;

    public MTGameEvent() {
        this(null, null, 0, null, 0, null, 63, null);
    }

    public MTGameEvent(Integer num, String type, int i, Integer num2, int i2, String date) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(date, "date");
        this.id = num;
        this.type = type;
        this.playerid = i;
        this.source_playerid = num2;
        this.value = i2;
        this.date = date;
    }

    public /* synthetic */ MTGameEvent(Integer num, String str, int i, Integer num2, int i2, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? -1 : i, (i3 & 8) != 0 ? null : num2, (i3 & 16) != 0 ? 0 : i2, (i3 & 32) != 0 ? "" : str2);
    }

    public static /* synthetic */ MTGameEvent copy$default(MTGameEvent mTGameEvent, Integer num, String str, int i, Integer num2, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = mTGameEvent.id;
        }
        if ((i3 & 2) != 0) {
            str = mTGameEvent.type;
        }
        if ((i3 & 4) != 0) {
            i = mTGameEvent.playerid;
        }
        if ((i3 & 8) != 0) {
            num2 = mTGameEvent.source_playerid;
        }
        if ((i3 & 16) != 0) {
            i2 = mTGameEvent.value;
        }
        if ((i3 & 32) != 0) {
            str2 = mTGameEvent.date;
        }
        int i4 = i2;
        String str3 = str2;
        return mTGameEvent.copy(num, str, i, num2, i4, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPlayerid() {
        return this.playerid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getSource_playerid() {
        return this.source_playerid;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final MTGameEvent copy(Integer id, String type, int playerid, Integer source_playerid, int value, String date) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(date, "date");
        return new MTGameEvent(id, type, playerid, source_playerid, value, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTGameEvent)) {
            return false;
        }
        MTGameEvent mTGameEvent = (MTGameEvent) other;
        return Intrinsics.areEqual(this.id, mTGameEvent.id) && Intrinsics.areEqual(this.type, mTGameEvent.type) && this.playerid == mTGameEvent.playerid && Intrinsics.areEqual(this.source_playerid, mTGameEvent.source_playerid) && this.value == mTGameEvent.value && Intrinsics.areEqual(this.date, mTGameEvent.date);
    }

    public final String getDate() {
        return this.date;
    }

    public final Integer getId() {
        return this.id;
    }

    public final int getPlayerid() {
        return this.playerid;
    }

    public final Integer getSource_playerid() {
        return this.source_playerid;
    }

    public final String getType() {
        return this.type;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (((((num == null ? 0 : num.hashCode()) * 31) + this.type.hashCode()) * 31) + Integer.hashCode(this.playerid)) * 31;
        Integer num2 = this.source_playerid;
        return ((((iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31) + Integer.hashCode(this.value)) * 31) + this.date.hashCode();
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final void setPlayerid(int i) {
        this.playerid = i;
    }

    public final void setSource_playerid(Integer num) {
        this.source_playerid = num;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final void setValue(int i) {
        this.value = i;
    }

    public String toString() {
        return "MTGameEvent(id=" + this.id + ", type=" + this.type + ", playerid=" + this.playerid + ", source_playerid=" + this.source_playerid + ", value=" + this.value + ", date=" + this.date + ")";
    }
}
