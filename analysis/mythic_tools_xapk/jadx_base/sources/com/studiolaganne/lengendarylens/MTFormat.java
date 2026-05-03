package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bF\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\nHÆ\u0003J\t\u0010M\u001a\u00020\nHÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\nHÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0003JÉ\u0001\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0001J\u0013\u0010Z\u001a\u00020\n2\b\u0010[\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\\\u001a\u00020\u0003HÖ\u0001J\t\u0010]\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010*\"\u0004\b:\u0010,R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001eR\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010\u001eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010\"R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010 \"\u0004\bB\u0010\"R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006^"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTFormat;", "", "id", "", "name", "", "commanderdamages", "decksizemax", "decksizemin", "hascommander", "", "hassideboard", "lifetotal", "playersmax", "playersmin", "scryfallid", "sideboardsizemax", "singleton", "timelimit", "bestof", "color", "icon", "subformats", "", "Lcom/studiolaganne/lengendarylens/MTSubformat;", "<init>", "(ILjava/lang/String;IIIZZIIILjava/lang/String;IZIILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getCommanderdamages", "setCommanderdamages", "getDecksizemax", "setDecksizemax", "getDecksizemin", "setDecksizemin", "getHascommander", "()Z", "setHascommander", "(Z)V", "getHassideboard", "setHassideboard", "getLifetotal", "setLifetotal", "getPlayersmax", "setPlayersmax", "getPlayersmin", "setPlayersmin", "getScryfallid", "setScryfallid", "getSideboardsizemax", "setSideboardsizemax", "getSingleton", "setSingleton", "getTimelimit", "setTimelimit", "getBestof", "setBestof", "getColor", "setColor", "getIcon", "setIcon", "getSubformats", "()Ljava/util/List;", "setSubformats", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTFormat {
    public static final int $stable = 8;
    private int bestof;
    private String color;
    private int commanderdamages;
    private int decksizemax;
    private int decksizemin;
    private boolean hascommander;
    private boolean hassideboard;
    private String icon;
    private int id;
    private int lifetotal;
    private String name;
    private int playersmax;
    private int playersmin;
    private String scryfallid;
    private int sideboardsizemax;
    private boolean singleton;
    private List<MTSubformat> subformats;
    private int timelimit;

    public MTFormat() {
        this(0, null, 0, 0, 0, false, false, 0, 0, 0, null, 0, false, 0, 0, null, null, null, 262143, null);
    }

    public MTFormat(int i, String name, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6, int i7, String scryfallid, int i8, boolean z3, int i9, int i10, String str, String str2, List<MTSubformat> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(scryfallid, "scryfallid");
        this.id = i;
        this.name = name;
        this.commanderdamages = i2;
        this.decksizemax = i3;
        this.decksizemin = i4;
        this.hascommander = z;
        this.hassideboard = z2;
        this.lifetotal = i5;
        this.playersmax = i6;
        this.playersmin = i7;
        this.scryfallid = scryfallid;
        this.sideboardsizemax = i8;
        this.singleton = z3;
        this.timelimit = i9;
        this.bestof = i10;
        this.color = str;
        this.icon = str2;
        this.subformats = list;
    }

    public /* synthetic */ MTFormat(int i, String str, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6, int i7, String str2, int i8, boolean z3, int i9, int i10, String str3, String str4, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? -1 : i, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? 0 : i2, (i11 & 8) != 0 ? 0 : i3, (i11 & 16) != 0 ? 60 : i4, (i11 & 32) != 0 ? false : z, (i11 & 64) != 0 ? false : z2, (i11 & 128) != 0 ? 20 : i5, (i11 & 256) != 0 ? 0 : i6, (i11 & 512) != 0 ? 2 : i7, (i11 & 1024) != 0 ? "" : str2, (i11 & 2048) != 0 ? 15 : i8, (i11 & 4096) != 0 ? false : z3, (i11 & 8192) != 0 ? 0 : i9, (i11 & 16384) != 0 ? 0 : i10, (i11 & 32768) != 0 ? "" : str3, (i11 & 65536) == 0 ? str4 : "", (i11 & 131072) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTFormat copy$default(MTFormat mTFormat, int i, String str, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6, int i7, String str2, int i8, boolean z3, int i9, int i10, String str3, String str4, List list, int i11, Object obj) {
        List list2;
        String str5;
        int i12 = (i11 & 1) != 0 ? mTFormat.id : i;
        String str6 = (i11 & 2) != 0 ? mTFormat.name : str;
        int i13 = (i11 & 4) != 0 ? mTFormat.commanderdamages : i2;
        int i14 = (i11 & 8) != 0 ? mTFormat.decksizemax : i3;
        int i15 = (i11 & 16) != 0 ? mTFormat.decksizemin : i4;
        boolean z4 = (i11 & 32) != 0 ? mTFormat.hascommander : z;
        boolean z5 = (i11 & 64) != 0 ? mTFormat.hassideboard : z2;
        int i16 = (i11 & 128) != 0 ? mTFormat.lifetotal : i5;
        int i17 = (i11 & 256) != 0 ? mTFormat.playersmax : i6;
        int i18 = (i11 & 512) != 0 ? mTFormat.playersmin : i7;
        String str7 = (i11 & 1024) != 0 ? mTFormat.scryfallid : str2;
        int i19 = (i11 & 2048) != 0 ? mTFormat.sideboardsizemax : i8;
        boolean z6 = (i11 & 4096) != 0 ? mTFormat.singleton : z3;
        int i20 = (i11 & 8192) != 0 ? mTFormat.timelimit : i9;
        int i21 = i12;
        int i22 = (i11 & 16384) != 0 ? mTFormat.bestof : i10;
        String str8 = (i11 & 32768) != 0 ? mTFormat.color : str3;
        String str9 = (i11 & 65536) != 0 ? mTFormat.icon : str4;
        if ((i11 & 131072) != 0) {
            str5 = str9;
            list2 = mTFormat.subformats;
        } else {
            list2 = list;
            str5 = str9;
        }
        return mTFormat.copy(i21, str6, i13, i14, i15, z4, z5, i16, i17, i18, str7, i19, z6, i20, i22, str8, str5, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getPlayersmin() {
        return this.playersmin;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getScryfallid() {
        return this.scryfallid;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getSideboardsizemax() {
        return this.sideboardsizemax;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getSingleton() {
        return this.singleton;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getTimelimit() {
        return this.timelimit;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getBestof() {
        return this.bestof;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    public final List<MTSubformat> component18() {
        return this.subformats;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCommanderdamages() {
        return this.commanderdamages;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDecksizemax() {
        return this.decksizemax;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDecksizemin() {
        return this.decksizemin;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getHascommander() {
        return this.hascommander;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getHassideboard() {
        return this.hassideboard;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getLifetotal() {
        return this.lifetotal;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getPlayersmax() {
        return this.playersmax;
    }

    public final MTFormat copy(int id, String name, int commanderdamages, int decksizemax, int decksizemin, boolean hascommander, boolean hassideboard, int lifetotal, int playersmax, int playersmin, String scryfallid, int sideboardsizemax, boolean singleton, int timelimit, int bestof, String color, String icon, List<MTSubformat> subformats) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(scryfallid, "scryfallid");
        return new MTFormat(id, name, commanderdamages, decksizemax, decksizemin, hascommander, hassideboard, lifetotal, playersmax, playersmin, scryfallid, sideboardsizemax, singleton, timelimit, bestof, color, icon, subformats);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTFormat)) {
            return false;
        }
        MTFormat mTFormat = (MTFormat) other;
        return this.id == mTFormat.id && Intrinsics.areEqual(this.name, mTFormat.name) && this.commanderdamages == mTFormat.commanderdamages && this.decksizemax == mTFormat.decksizemax && this.decksizemin == mTFormat.decksizemin && this.hascommander == mTFormat.hascommander && this.hassideboard == mTFormat.hassideboard && this.lifetotal == mTFormat.lifetotal && this.playersmax == mTFormat.playersmax && this.playersmin == mTFormat.playersmin && Intrinsics.areEqual(this.scryfallid, mTFormat.scryfallid) && this.sideboardsizemax == mTFormat.sideboardsizemax && this.singleton == mTFormat.singleton && this.timelimit == mTFormat.timelimit && this.bestof == mTFormat.bestof && Intrinsics.areEqual(this.color, mTFormat.color) && Intrinsics.areEqual(this.icon, mTFormat.icon) && Intrinsics.areEqual(this.subformats, mTFormat.subformats);
    }

    public final int getBestof() {
        return this.bestof;
    }

    public final String getColor() {
        return this.color;
    }

    public final int getCommanderdamages() {
        return this.commanderdamages;
    }

    public final int getDecksizemax() {
        return this.decksizemax;
    }

    public final int getDecksizemin() {
        return this.decksizemin;
    }

    public final boolean getHascommander() {
        return this.hascommander;
    }

    public final boolean getHassideboard() {
        return this.hassideboard;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final int getLifetotal() {
        return this.lifetotal;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPlayersmax() {
        return this.playersmax;
    }

    public final int getPlayersmin() {
        return this.playersmin;
    }

    public final String getScryfallid() {
        return this.scryfallid;
    }

    public final int getSideboardsizemax() {
        return this.sideboardsizemax;
    }

    public final boolean getSingleton() {
        return this.singleton;
    }

    public final List<MTSubformat> getSubformats() {
        return this.subformats;
    }

    public final int getTimelimit() {
        return this.timelimit;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.commanderdamages)) * 31) + Integer.hashCode(this.decksizemax)) * 31) + Integer.hashCode(this.decksizemin)) * 31) + Boolean.hashCode(this.hascommander)) * 31) + Boolean.hashCode(this.hassideboard)) * 31) + Integer.hashCode(this.lifetotal)) * 31) + Integer.hashCode(this.playersmax)) * 31) + Integer.hashCode(this.playersmin)) * 31) + this.scryfallid.hashCode()) * 31) + Integer.hashCode(this.sideboardsizemax)) * 31) + Boolean.hashCode(this.singleton)) * 31) + Integer.hashCode(this.timelimit)) * 31) + Integer.hashCode(this.bestof)) * 31;
        String str = this.color;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.icon;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<MTSubformat> list = this.subformats;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public final void setBestof(int i) {
        this.bestof = i;
    }

    public final void setColor(String str) {
        this.color = str;
    }

    public final void setCommanderdamages(int i) {
        this.commanderdamages = i;
    }

    public final void setDecksizemax(int i) {
        this.decksizemax = i;
    }

    public final void setDecksizemin(int i) {
        this.decksizemin = i;
    }

    public final void setHascommander(boolean z) {
        this.hascommander = z;
    }

    public final void setHassideboard(boolean z) {
        this.hassideboard = z;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setLifetotal(int i) {
        this.lifetotal = i;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setPlayersmax(int i) {
        this.playersmax = i;
    }

    public final void setPlayersmin(int i) {
        this.playersmin = i;
    }

    public final void setScryfallid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scryfallid = str;
    }

    public final void setSideboardsizemax(int i) {
        this.sideboardsizemax = i;
    }

    public final void setSingleton(boolean z) {
        this.singleton = z;
    }

    public final void setSubformats(List<MTSubformat> list) {
        this.subformats = list;
    }

    public final void setTimelimit(int i) {
        this.timelimit = i;
    }

    public String toString() {
        return "MTFormat(id=" + this.id + ", name=" + this.name + ", commanderdamages=" + this.commanderdamages + ", decksizemax=" + this.decksizemax + ", decksizemin=" + this.decksizemin + ", hascommander=" + this.hascommander + ", hassideboard=" + this.hassideboard + ", lifetotal=" + this.lifetotal + ", playersmax=" + this.playersmax + ", playersmin=" + this.playersmin + ", scryfallid=" + this.scryfallid + ", sideboardsizemax=" + this.sideboardsizemax + ", singleton=" + this.singleton + ", timelimit=" + this.timelimit + ", bestof=" + this.bestof + ", color=" + this.color + ", icon=" + this.icon + ", subformats=" + this.subformats + ")";
    }
}
