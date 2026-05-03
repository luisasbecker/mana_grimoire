package com.studiolaganne.lengendarylens;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b@\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B÷\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jù\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010C\u001a\u00020DJ\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020DHÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001J\u0016\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020DR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001a¨\u0006P"}, d2 = {"Lcom/studiolaganne/lengendarylens/Legalities;", "Landroid/os/Parcelable;", "standard", "", "future", "historic", "gladiator", "pioneer", "explorer", "modern", "legacy", "pauper", "vintage", "penny", "commander", "brawl", "historicbrawl", "alchemy", "paupercommander", "duel", "oldschool", "premodern", "oathbreaker", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStandard", "()Ljava/lang/String;", "getFuture", "getHistoric", "getGladiator", "getPioneer", "getExplorer", "getModern", "getLegacy", "getPauper", "getVintage", "getPenny", "getCommander", "getBrawl", "getHistoricbrawl", "getAlchemy", "getPaupercommander", "getDuel", "getOldschool", "getPremodern", "getOathbreaker", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Legalities implements Parcelable {
    private final String alchemy;
    private final String brawl;
    private final String commander;
    private final String duel;
    private final String explorer;
    private final String future;
    private final String gladiator;
    private final String historic;
    private final String historicbrawl;
    private final String legacy;
    private final String modern;
    private final String oathbreaker;
    private final String oldschool;
    private final String pauper;
    private final String paupercommander;
    private final String penny;
    private final String pioneer;
    private final String premodern;
    private final String standard;
    private final String vintage;
    public static final Parcelable.Creator<Legalities> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: JsonStructs.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Legalities> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Legalities createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Legalities(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Legalities[] newArray(int i) {
            return new Legalities[i];
        }
    }

    public Legalities() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    public Legalities(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20) {
        this.standard = str;
        this.future = str2;
        this.historic = str3;
        this.gladiator = str4;
        this.pioneer = str5;
        this.explorer = str6;
        this.modern = str7;
        this.legacy = str8;
        this.pauper = str9;
        this.vintage = str10;
        this.penny = str11;
        this.commander = str12;
        this.brawl = str13;
        this.historicbrawl = str14;
        this.alchemy = str15;
        this.paupercommander = str16;
        this.duel = str17;
        this.oldschool = str18;
        this.premodern = str19;
        this.oathbreaker = str20;
    }

    public /* synthetic */ Legalities(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13, (i & 8192) != 0 ? null : str14, (i & 16384) != 0 ? null : str15, (i & 32768) != 0 ? null : str16, (i & 65536) != 0 ? null : str17, (i & 131072) != 0 ? null : str18, (i & 262144) != 0 ? null : str19, (i & 524288) != 0 ? null : str20);
    }

    public static /* synthetic */ Legalities copy$default(Legalities legalities, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, int i, Object obj) {
        String str21;
        String str22;
        String str23 = (i & 1) != 0 ? legalities.standard : str;
        String str24 = (i & 2) != 0 ? legalities.future : str2;
        String str25 = (i & 4) != 0 ? legalities.historic : str3;
        String str26 = (i & 8) != 0 ? legalities.gladiator : str4;
        String str27 = (i & 16) != 0 ? legalities.pioneer : str5;
        String str28 = (i & 32) != 0 ? legalities.explorer : str6;
        String str29 = (i & 64) != 0 ? legalities.modern : str7;
        String str30 = (i & 128) != 0 ? legalities.legacy : str8;
        String str31 = (i & 256) != 0 ? legalities.pauper : str9;
        String str32 = (i & 512) != 0 ? legalities.vintage : str10;
        String str33 = (i & 1024) != 0 ? legalities.penny : str11;
        String str34 = (i & 2048) != 0 ? legalities.commander : str12;
        String str35 = (i & 4096) != 0 ? legalities.brawl : str13;
        String str36 = (i & 8192) != 0 ? legalities.historicbrawl : str14;
        String str37 = str23;
        String str38 = (i & 16384) != 0 ? legalities.alchemy : str15;
        String str39 = (i & 32768) != 0 ? legalities.paupercommander : str16;
        String str40 = (i & 65536) != 0 ? legalities.duel : str17;
        String str41 = (i & 131072) != 0 ? legalities.oldschool : str18;
        String str42 = (i & 262144) != 0 ? legalities.premodern : str19;
        if ((i & 524288) != 0) {
            str22 = str42;
            str21 = legalities.oathbreaker;
        } else {
            str21 = str20;
            str22 = str42;
        }
        return legalities.copy(str37, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str38, str39, str40, str41, str22, str21);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStandard() {
        return this.standard;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getVintage() {
        return this.vintage;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPenny() {
        return this.penny;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getCommander() {
        return this.commander;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getBrawl() {
        return this.brawl;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getHistoricbrawl() {
        return this.historicbrawl;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getAlchemy() {
        return this.alchemy;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getPaupercommander() {
        return this.paupercommander;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getDuel() {
        return this.duel;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getOldschool() {
        return this.oldschool;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getPremodern() {
        return this.premodern;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFuture() {
        return this.future;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getOathbreaker() {
        return this.oathbreaker;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getHistoric() {
        return this.historic;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getGladiator() {
        return this.gladiator;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPioneer() {
        return this.pioneer;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getExplorer() {
        return this.explorer;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getModern() {
        return this.modern;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLegacy() {
        return this.legacy;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPauper() {
        return this.pauper;
    }

    public final Legalities copy(String standard, String future, String historic, String gladiator, String pioneer, String explorer, String modern, String legacy, String pauper, String vintage, String penny, String commander, String brawl, String historicbrawl, String alchemy, String paupercommander, String duel, String oldschool, String premodern, String oathbreaker) {
        return new Legalities(standard, future, historic, gladiator, pioneer, explorer, modern, legacy, pauper, vintage, penny, commander, brawl, historicbrawl, alchemy, paupercommander, duel, oldschool, premodern, oathbreaker);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Legalities)) {
            return false;
        }
        Legalities legalities = (Legalities) other;
        return Intrinsics.areEqual(this.standard, legalities.standard) && Intrinsics.areEqual(this.future, legalities.future) && Intrinsics.areEqual(this.historic, legalities.historic) && Intrinsics.areEqual(this.gladiator, legalities.gladiator) && Intrinsics.areEqual(this.pioneer, legalities.pioneer) && Intrinsics.areEqual(this.explorer, legalities.explorer) && Intrinsics.areEqual(this.modern, legalities.modern) && Intrinsics.areEqual(this.legacy, legalities.legacy) && Intrinsics.areEqual(this.pauper, legalities.pauper) && Intrinsics.areEqual(this.vintage, legalities.vintage) && Intrinsics.areEqual(this.penny, legalities.penny) && Intrinsics.areEqual(this.commander, legalities.commander) && Intrinsics.areEqual(this.brawl, legalities.brawl) && Intrinsics.areEqual(this.historicbrawl, legalities.historicbrawl) && Intrinsics.areEqual(this.alchemy, legalities.alchemy) && Intrinsics.areEqual(this.paupercommander, legalities.paupercommander) && Intrinsics.areEqual(this.duel, legalities.duel) && Intrinsics.areEqual(this.oldschool, legalities.oldschool) && Intrinsics.areEqual(this.premodern, legalities.premodern) && Intrinsics.areEqual(this.oathbreaker, legalities.oathbreaker);
    }

    public final String getAlchemy() {
        return this.alchemy;
    }

    public final String getBrawl() {
        return this.brawl;
    }

    public final String getCommander() {
        return this.commander;
    }

    public final String getDuel() {
        return this.duel;
    }

    public final String getExplorer() {
        return this.explorer;
    }

    public final String getFuture() {
        return this.future;
    }

    public final String getGladiator() {
        return this.gladiator;
    }

    public final String getHistoric() {
        return this.historic;
    }

    public final String getHistoricbrawl() {
        return this.historicbrawl;
    }

    public final String getLegacy() {
        return this.legacy;
    }

    public final String getModern() {
        return this.modern;
    }

    public final String getOathbreaker() {
        return this.oathbreaker;
    }

    public final String getOldschool() {
        return this.oldschool;
    }

    public final String getPauper() {
        return this.pauper;
    }

    public final String getPaupercommander() {
        return this.paupercommander;
    }

    public final String getPenny() {
        return this.penny;
    }

    public final String getPioneer() {
        return this.pioneer;
    }

    public final String getPremodern() {
        return this.premodern;
    }

    public final String getStandard() {
        return this.standard;
    }

    public final String getVintage() {
        return this.vintage;
    }

    public int hashCode() {
        String str = this.standard;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.future;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.historic;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.gladiator;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.pioneer;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.explorer;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.modern;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.legacy;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.pauper;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.vintage;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.penny;
        int iHashCode11 = (iHashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.commander;
        int iHashCode12 = (iHashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.brawl;
        int iHashCode13 = (iHashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.historicbrawl;
        int iHashCode14 = (iHashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.alchemy;
        int iHashCode15 = (iHashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.paupercommander;
        int iHashCode16 = (iHashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.duel;
        int iHashCode17 = (iHashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.oldschool;
        int iHashCode18 = (iHashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.premodern;
        int iHashCode19 = (iHashCode18 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.oathbreaker;
        return iHashCode19 + (str20 != null ? str20.hashCode() : 0);
    }

    public String toString() {
        return "Legalities(standard=" + this.standard + ", future=" + this.future + ", historic=" + this.historic + ", gladiator=" + this.gladiator + ", pioneer=" + this.pioneer + ", explorer=" + this.explorer + ", modern=" + this.modern + ", legacy=" + this.legacy + ", pauper=" + this.pauper + ", vintage=" + this.vintage + ", penny=" + this.penny + ", commander=" + this.commander + ", brawl=" + this.brawl + ", historicbrawl=" + this.historicbrawl + ", alchemy=" + this.alchemy + ", paupercommander=" + this.paupercommander + ", duel=" + this.duel + ", oldschool=" + this.oldschool + ", premodern=" + this.premodern + ", oathbreaker=" + this.oathbreaker + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.standard);
        dest.writeString(this.future);
        dest.writeString(this.historic);
        dest.writeString(this.gladiator);
        dest.writeString(this.pioneer);
        dest.writeString(this.explorer);
        dest.writeString(this.modern);
        dest.writeString(this.legacy);
        dest.writeString(this.pauper);
        dest.writeString(this.vintage);
        dest.writeString(this.penny);
        dest.writeString(this.commander);
        dest.writeString(this.brawl);
        dest.writeString(this.historicbrawl);
        dest.writeString(this.alchemy);
        dest.writeString(this.paupercommander);
        dest.writeString(this.duel);
        dest.writeString(this.oldschool);
        dest.writeString(this.premodern);
        dest.writeString(this.oathbreaker);
    }
}
