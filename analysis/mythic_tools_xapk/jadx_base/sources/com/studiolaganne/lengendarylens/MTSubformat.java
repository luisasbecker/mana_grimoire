package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017Jj\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019¨\u00064"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSubformat;", "", "id", "", "name", "", "commanderdamages", "lifetotal", "playersmax", "playersmin", "timelimit", "bestof", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getCommanderdamages", "()Ljava/lang/Integer;", "setCommanderdamages", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLifetotal", "setLifetotal", "getPlayersmax", "setPlayersmax", "getPlayersmin", "setPlayersmin", "getTimelimit", "setTimelimit", "getBestof", "setBestof", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTSubformat;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSubformat {
    public static final int $stable = 8;
    private Integer bestof;
    private Integer commanderdamages;
    private int id;
    private Integer lifetotal;
    private String name;
    private Integer playersmax;
    private Integer playersmin;
    private Integer timelimit;

    public MTSubformat() {
        this(0, null, null, null, null, null, null, null, 255, null);
    }

    public MTSubformat(int i, String name, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.commanderdamages = num;
        this.lifetotal = num2;
        this.playersmax = num3;
        this.playersmin = num4;
        this.timelimit = num5;
        this.bestof = num6;
    }

    public /* synthetic */ MTSubformat(int i, String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0 : num, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : num3, (i2 & 32) != 0 ? null : num4, (i2 & 64) != 0 ? 0 : num5, (i2 & 128) != 0 ? 0 : num6);
    }

    public static /* synthetic */ MTSubformat copy$default(MTSubformat mTSubformat, int i, String str, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTSubformat.id;
        }
        if ((i2 & 2) != 0) {
            str = mTSubformat.name;
        }
        if ((i2 & 4) != 0) {
            num = mTSubformat.commanderdamages;
        }
        if ((i2 & 8) != 0) {
            num2 = mTSubformat.lifetotal;
        }
        if ((i2 & 16) != 0) {
            num3 = mTSubformat.playersmax;
        }
        if ((i2 & 32) != 0) {
            num4 = mTSubformat.playersmin;
        }
        if ((i2 & 64) != 0) {
            num5 = mTSubformat.timelimit;
        }
        if ((i2 & 128) != 0) {
            num6 = mTSubformat.bestof;
        }
        Integer num7 = num5;
        Integer num8 = num6;
        Integer num9 = num3;
        Integer num10 = num4;
        return mTSubformat.copy(i, str, num, num2, num9, num10, num7, num8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getCommanderdamages() {
        return this.commanderdamages;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getLifetotal() {
        return this.lifetotal;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getPlayersmax() {
        return this.playersmax;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getPlayersmin() {
        return this.playersmin;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getTimelimit() {
        return this.timelimit;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getBestof() {
        return this.bestof;
    }

    public final MTSubformat copy(int id, String name, Integer commanderdamages, Integer lifetotal, Integer playersmax, Integer playersmin, Integer timelimit, Integer bestof) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MTSubformat(id, name, commanderdamages, lifetotal, playersmax, playersmin, timelimit, bestof);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSubformat)) {
            return false;
        }
        MTSubformat mTSubformat = (MTSubformat) other;
        return this.id == mTSubformat.id && Intrinsics.areEqual(this.name, mTSubformat.name) && Intrinsics.areEqual(this.commanderdamages, mTSubformat.commanderdamages) && Intrinsics.areEqual(this.lifetotal, mTSubformat.lifetotal) && Intrinsics.areEqual(this.playersmax, mTSubformat.playersmax) && Intrinsics.areEqual(this.playersmin, mTSubformat.playersmin) && Intrinsics.areEqual(this.timelimit, mTSubformat.timelimit) && Intrinsics.areEqual(this.bestof, mTSubformat.bestof);
    }

    public final Integer getBestof() {
        return this.bestof;
    }

    public final Integer getCommanderdamages() {
        return this.commanderdamages;
    }

    public final int getId() {
        return this.id;
    }

    public final Integer getLifetotal() {
        return this.lifetotal;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getPlayersmax() {
        return this.playersmax;
    }

    public final Integer getPlayersmin() {
        return this.playersmin;
    }

    public final Integer getTimelimit() {
        return this.timelimit;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31;
        Integer num = this.commanderdamages;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.lifetotal;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.playersmax;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.playersmin;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.timelimit;
        int iHashCode6 = (iHashCode5 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.bestof;
        return iHashCode6 + (num6 != null ? num6.hashCode() : 0);
    }

    public final void setBestof(Integer num) {
        this.bestof = num;
    }

    public final void setCommanderdamages(Integer num) {
        this.commanderdamages = num;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setLifetotal(Integer num) {
        this.lifetotal = num;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setPlayersmax(Integer num) {
        this.playersmax = num;
    }

    public final void setPlayersmin(Integer num) {
        this.playersmin = num;
    }

    public final void setTimelimit(Integer num) {
        this.timelimit = num;
    }

    public String toString() {
        return "MTSubformat(id=" + this.id + ", name=" + this.name + ", commanderdamages=" + this.commanderdamages + ", lifetotal=" + this.lifetotal + ", playersmax=" + this.playersmax + ", playersmin=" + this.playersmin + ", timelimit=" + this.timelimit + ", bestof=" + this.bestof + ")";
    }
}
