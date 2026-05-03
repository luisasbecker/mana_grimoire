package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\bC\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0085\u0002\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020JHÖ\u0001J\t\u0010K\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001b¨\u0006L"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTLegalities;", "", "standard", "", "future", "historic", "timeless", "gladiator", "pioneer", "modern", "legacy", "pauper", "vintage", "penny", "commander", "oathbreaker", "standardbrawl", "brawl", "alchemy", "paupercommander", "duel", "oldschool", "premodern", "predh", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStandard", "()Ljava/lang/String;", "getFuture", "getHistoric", "getTimeless", "getGladiator", "getPioneer", "getModern", "getLegacy", "getPauper", "getVintage", "getPenny", "getCommander", "getOathbreaker", "getStandardbrawl", "getBrawl", "getAlchemy", "getPaupercommander", "getDuel", "getOldschool", "getPremodern", "getPredh", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTLegalities {
    public static final int $stable = 0;
    private final String alchemy;
    private final String brawl;
    private final String commander;
    private final String duel;
    private final String future;
    private final String gladiator;
    private final String historic;
    private final String legacy;
    private final String modern;
    private final String oathbreaker;
    private final String oldschool;
    private final String pauper;
    private final String paupercommander;
    private final String penny;
    private final String pioneer;
    private final String predh;
    private final String premodern;
    private final String standard;
    private final String standardbrawl;
    private final String timeless;
    private final String vintage;

    public MTLegalities() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    public MTLegalities(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21) {
        this.standard = str;
        this.future = str2;
        this.historic = str3;
        this.timeless = str4;
        this.gladiator = str5;
        this.pioneer = str6;
        this.modern = str7;
        this.legacy = str8;
        this.pauper = str9;
        this.vintage = str10;
        this.penny = str11;
        this.commander = str12;
        this.oathbreaker = str13;
        this.standardbrawl = str14;
        this.brawl = str15;
        this.alchemy = str16;
        this.paupercommander = str17;
        this.duel = str18;
        this.oldschool = str19;
        this.premodern = str20;
        this.predh = str21;
    }

    public /* synthetic */ MTLegalities(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13, (i & 8192) != 0 ? null : str14, (i & 16384) != 0 ? null : str15, (i & 32768) != 0 ? null : str16, (i & 65536) != 0 ? null : str17, (i & 131072) != 0 ? null : str18, (i & 262144) != 0 ? null : str19, (i & 524288) != 0 ? null : str20, (i & 1048576) != 0 ? null : str21);
    }

    public static /* synthetic */ MTLegalities copy$default(MTLegalities mTLegalities, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, int i, Object obj) {
        String str22;
        String str23;
        String str24 = (i & 1) != 0 ? mTLegalities.standard : str;
        String str25 = (i & 2) != 0 ? mTLegalities.future : str2;
        String str26 = (i & 4) != 0 ? mTLegalities.historic : str3;
        String str27 = (i & 8) != 0 ? mTLegalities.timeless : str4;
        String str28 = (i & 16) != 0 ? mTLegalities.gladiator : str5;
        String str29 = (i & 32) != 0 ? mTLegalities.pioneer : str6;
        String str30 = (i & 64) != 0 ? mTLegalities.modern : str7;
        String str31 = (i & 128) != 0 ? mTLegalities.legacy : str8;
        String str32 = (i & 256) != 0 ? mTLegalities.pauper : str9;
        String str33 = (i & 512) != 0 ? mTLegalities.vintage : str10;
        String str34 = (i & 1024) != 0 ? mTLegalities.penny : str11;
        String str35 = (i & 2048) != 0 ? mTLegalities.commander : str12;
        String str36 = (i & 4096) != 0 ? mTLegalities.oathbreaker : str13;
        String str37 = (i & 8192) != 0 ? mTLegalities.standardbrawl : str14;
        String str38 = str24;
        String str39 = (i & 16384) != 0 ? mTLegalities.brawl : str15;
        String str40 = (i & 32768) != 0 ? mTLegalities.alchemy : str16;
        String str41 = (i & 65536) != 0 ? mTLegalities.paupercommander : str17;
        String str42 = (i & 131072) != 0 ? mTLegalities.duel : str18;
        String str43 = (i & 262144) != 0 ? mTLegalities.oldschool : str19;
        String str44 = (i & 524288) != 0 ? mTLegalities.premodern : str20;
        if ((i & 1048576) != 0) {
            str23 = str44;
            str22 = mTLegalities.predh;
        } else {
            str22 = str21;
            str23 = str44;
        }
        return mTLegalities.copy(str38, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str39, str40, str41, str42, str43, str23, str22);
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
    public final String getOathbreaker() {
        return this.oathbreaker;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getStandardbrawl() {
        return this.standardbrawl;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getBrawl() {
        return this.brawl;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getAlchemy() {
        return this.alchemy;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getPaupercommander() {
        return this.paupercommander;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getDuel() {
        return this.duel;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getOldschool() {
        return this.oldschool;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFuture() {
        return this.future;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getPremodern() {
        return this.premodern;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getPredh() {
        return this.predh;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getHistoric() {
        return this.historic;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTimeless() {
        return this.timeless;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGladiator() {
        return this.gladiator;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPioneer() {
        return this.pioneer;
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

    public final MTLegalities copy(String standard, String future, String historic, String timeless, String gladiator, String pioneer, String modern, String legacy, String pauper, String vintage, String penny, String commander, String oathbreaker, String standardbrawl, String brawl, String alchemy, String paupercommander, String duel, String oldschool, String premodern, String predh) {
        return new MTLegalities(standard, future, historic, timeless, gladiator, pioneer, modern, legacy, pauper, vintage, penny, commander, oathbreaker, standardbrawl, brawl, alchemy, paupercommander, duel, oldschool, premodern, predh);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTLegalities)) {
            return false;
        }
        MTLegalities mTLegalities = (MTLegalities) other;
        return Intrinsics.areEqual(this.standard, mTLegalities.standard) && Intrinsics.areEqual(this.future, mTLegalities.future) && Intrinsics.areEqual(this.historic, mTLegalities.historic) && Intrinsics.areEqual(this.timeless, mTLegalities.timeless) && Intrinsics.areEqual(this.gladiator, mTLegalities.gladiator) && Intrinsics.areEqual(this.pioneer, mTLegalities.pioneer) && Intrinsics.areEqual(this.modern, mTLegalities.modern) && Intrinsics.areEqual(this.legacy, mTLegalities.legacy) && Intrinsics.areEqual(this.pauper, mTLegalities.pauper) && Intrinsics.areEqual(this.vintage, mTLegalities.vintage) && Intrinsics.areEqual(this.penny, mTLegalities.penny) && Intrinsics.areEqual(this.commander, mTLegalities.commander) && Intrinsics.areEqual(this.oathbreaker, mTLegalities.oathbreaker) && Intrinsics.areEqual(this.standardbrawl, mTLegalities.standardbrawl) && Intrinsics.areEqual(this.brawl, mTLegalities.brawl) && Intrinsics.areEqual(this.alchemy, mTLegalities.alchemy) && Intrinsics.areEqual(this.paupercommander, mTLegalities.paupercommander) && Intrinsics.areEqual(this.duel, mTLegalities.duel) && Intrinsics.areEqual(this.oldschool, mTLegalities.oldschool) && Intrinsics.areEqual(this.premodern, mTLegalities.premodern) && Intrinsics.areEqual(this.predh, mTLegalities.predh);
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

    public final String getFuture() {
        return this.future;
    }

    public final String getGladiator() {
        return this.gladiator;
    }

    public final String getHistoric() {
        return this.historic;
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

    public final String getPredh() {
        return this.predh;
    }

    public final String getPremodern() {
        return this.premodern;
    }

    public final String getStandard() {
        return this.standard;
    }

    public final String getStandardbrawl() {
        return this.standardbrawl;
    }

    public final String getTimeless() {
        return this.timeless;
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
        String str4 = this.timeless;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.gladiator;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.pioneer;
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
        String str13 = this.oathbreaker;
        int iHashCode13 = (iHashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.standardbrawl;
        int iHashCode14 = (iHashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.brawl;
        int iHashCode15 = (iHashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.alchemy;
        int iHashCode16 = (iHashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.paupercommander;
        int iHashCode17 = (iHashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.duel;
        int iHashCode18 = (iHashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.oldschool;
        int iHashCode19 = (iHashCode18 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.premodern;
        int iHashCode20 = (iHashCode19 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.predh;
        return iHashCode20 + (str21 != null ? str21.hashCode() : 0);
    }

    public String toString() {
        return "MTLegalities(standard=" + this.standard + ", future=" + this.future + ", historic=" + this.historic + ", timeless=" + this.timeless + ", gladiator=" + this.gladiator + ", pioneer=" + this.pioneer + ", modern=" + this.modern + ", legacy=" + this.legacy + ", pauper=" + this.pauper + ", vintage=" + this.vintage + ", penny=" + this.penny + ", commander=" + this.commander + ", oathbreaker=" + this.oathbreaker + ", standardbrawl=" + this.standardbrawl + ", brawl=" + this.brawl + ", alchemy=" + this.alchemy + ", paupercommander=" + this.paupercommander + ", duel=" + this.duel + ", oldschool=" + this.oldschool + ", premodern=" + this.premodern + ", predh=" + this.predh + ")";
    }
}
