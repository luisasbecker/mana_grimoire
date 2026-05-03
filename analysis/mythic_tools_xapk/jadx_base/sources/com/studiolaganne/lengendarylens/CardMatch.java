package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\bR\b\u0087\b\u0018\u00002\u00020\u0001BÙ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0006HÆ\u0003J\t\u0010U\u001a\u00020\bHÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0012HÆ\u0003J\t\u0010_\u001a\u00020\u0012HÆ\u0003J\t\u0010`\u001a\u00020\u0012HÆ\u0003J\t\u0010a\u001a\u00020\u0012HÆ\u0003J\t\u0010b\u001a\u00020\u0012HÆ\u0003J\t\u0010c\u001a\u00020\u0012HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u001aHÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003JÛ\u0001\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010h\u001a\u00020\u001a2\b\u0010i\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010j\u001a\u00020\u0006HÖ\u0001J\t\u0010k\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001f\"\u0004\b/\u0010!R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001f\"\u0004\b5\u0010!R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u0010!R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010!R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001f\"\u0004\b;\u0010!R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010=\"\u0004\bA\u0010?R\u001a\u0010\u0014\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010=\"\u0004\bC\u0010?R\u001a\u0010\u0015\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010=\"\u0004\bE\u0010?R\u001a\u0010\u0016\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010=\"\u0004\bG\u0010?R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010=\"\u0004\bI\u0010?R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001f\"\u0004\bK\u0010!R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010\u001b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001f\"\u0004\bQ\u0010!¨\u0006l"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardMatch;", "", "scryfallId", "", "oracleId", OptionalModuleUtils.FACE, "", "hashDifference", "", "number", Constants.GP_IAP_TITLE, "localizedTitle", "localizedTypeLine", "localizedOracle", "lang", "set", "bottomText", "setScore", "", "numberScore", "dateScore", "hashScore", "borderScore", "totalScore", "enScryfallId", "ignoreSetForScoring", "", "detectedCardLang", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FFFFFFLjava/lang/String;ZLjava/lang/String;)V", "getScryfallId", "()Ljava/lang/String;", "setScryfallId", "(Ljava/lang/String;)V", "getOracleId", "setOracleId", "getFace", "()I", "setFace", "(I)V", "getHashDifference", "()J", "setHashDifference", "(J)V", "getNumber", "setNumber", "getTitle", "setTitle", "getLocalizedTitle", "setLocalizedTitle", "getLocalizedTypeLine", "setLocalizedTypeLine", "getLocalizedOracle", "setLocalizedOracle", "getLang", "setLang", "getSet", "setSet", "getBottomText", "setBottomText", "getSetScore", "()F", "setSetScore", "(F)V", "getNumberScore", "setNumberScore", "getDateScore", "setDateScore", "getHashScore", "setHashScore", "getBorderScore", "setBorderScore", "getTotalScore", "setTotalScore", "getEnScryfallId", "setEnScryfallId", "getIgnoreSetForScoring", "()Z", "setIgnoreSetForScoring", "(Z)V", "getDetectedCardLang", "setDetectedCardLang", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CardMatch {
    public static final int $stable = 8;
    private float borderScore;
    private String bottomText;
    private float dateScore;
    private String detectedCardLang;
    private String enScryfallId;
    private int face;
    private long hashDifference;
    private float hashScore;
    private boolean ignoreSetForScoring;
    private String lang;
    private String localizedOracle;
    private String localizedTitle;
    private String localizedTypeLine;
    private String number;
    private float numberScore;
    private String oracleId;
    private String scryfallId;
    private String set;
    private float setScore;
    private String title;
    private float totalScore;

    public CardMatch() {
        this(null, null, 0, 0L, null, null, null, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, false, null, 2097151, null);
    }

    public CardMatch(String scryfallId, String oracleId, int i, long j, String number, String title, String localizedTitle, String localizedTypeLine, String localizedOracle, String lang, String set, String bottomText, float f, float f2, float f3, float f4, float f5, float f6, String enScryfallId, boolean z, String detectedCardLang) {
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(localizedTitle, "localizedTitle");
        Intrinsics.checkNotNullParameter(localizedTypeLine, "localizedTypeLine");
        Intrinsics.checkNotNullParameter(localizedOracle, "localizedOracle");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(bottomText, "bottomText");
        Intrinsics.checkNotNullParameter(enScryfallId, "enScryfallId");
        Intrinsics.checkNotNullParameter(detectedCardLang, "detectedCardLang");
        this.scryfallId = scryfallId;
        this.oracleId = oracleId;
        this.face = i;
        this.hashDifference = j;
        this.number = number;
        this.title = title;
        this.localizedTitle = localizedTitle;
        this.localizedTypeLine = localizedTypeLine;
        this.localizedOracle = localizedOracle;
        this.lang = lang;
        this.set = set;
        this.bottomText = bottomText;
        this.setScore = f;
        this.numberScore = f2;
        this.dateScore = f3;
        this.hashScore = f4;
        this.borderScore = f5;
        this.totalScore = f6;
        this.enScryfallId = enScryfallId;
        this.ignoreSetForScoring = z;
        this.detectedCardLang = detectedCardLang;
    }

    public /* synthetic */ CardMatch(String str, String str2, int i, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, float f, float f2, float f3, float f4, float f5, float f6, String str11, boolean z, String str12, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? 0L : j, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? "" : str4, (i2 & 64) != 0 ? "" : str5, (i2 & 128) != 0 ? "" : str6, (i2 & 256) != 0 ? "" : str7, (i2 & 512) != 0 ? "en" : str8, (i2 & 1024) != 0 ? "" : str9, (i2 & 2048) != 0 ? "" : str10, (i2 & 4096) != 0 ? 0.0f : f, (i2 & 8192) != 0 ? 0.0f : f2, (i2 & 16384) != 0 ? 0.0f : f3, (i2 & 32768) != 0 ? 0.0f : f4, (i2 & 65536) != 0 ? 0.0f : f5, (i2 & 131072) == 0 ? f6 : 0.0f, (i2 & 262144) == 0 ? str11 : "", (i2 & 524288) != 0 ? false : z, (i2 & 1048576) != 0 ? "en" : str12);
    }

    public static /* synthetic */ CardMatch copy$default(CardMatch cardMatch, String str, String str2, int i, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, float f, float f2, float f3, float f4, float f5, float f6, String str11, boolean z, String str12, int i2, Object obj) {
        String str13;
        boolean z2;
        String str14 = (i2 & 1) != 0 ? cardMatch.scryfallId : str;
        String str15 = (i2 & 2) != 0 ? cardMatch.oracleId : str2;
        int i3 = (i2 & 4) != 0 ? cardMatch.face : i;
        long j2 = (i2 & 8) != 0 ? cardMatch.hashDifference : j;
        String str16 = (i2 & 16) != 0 ? cardMatch.number : str3;
        String str17 = (i2 & 32) != 0 ? cardMatch.title : str4;
        String str18 = (i2 & 64) != 0 ? cardMatch.localizedTitle : str5;
        String str19 = (i2 & 128) != 0 ? cardMatch.localizedTypeLine : str6;
        String str20 = (i2 & 256) != 0 ? cardMatch.localizedOracle : str7;
        String str21 = (i2 & 512) != 0 ? cardMatch.lang : str8;
        String str22 = (i2 & 1024) != 0 ? cardMatch.set : str9;
        String str23 = (i2 & 2048) != 0 ? cardMatch.bottomText : str10;
        float f7 = (i2 & 4096) != 0 ? cardMatch.setScore : f;
        String str24 = str14;
        float f8 = (i2 & 8192) != 0 ? cardMatch.numberScore : f2;
        float f9 = (i2 & 16384) != 0 ? cardMatch.dateScore : f3;
        float f10 = (i2 & 32768) != 0 ? cardMatch.hashScore : f4;
        float f11 = (i2 & 65536) != 0 ? cardMatch.borderScore : f5;
        float f12 = (i2 & 131072) != 0 ? cardMatch.totalScore : f6;
        String str25 = (i2 & 262144) != 0 ? cardMatch.enScryfallId : str11;
        boolean z3 = (i2 & 524288) != 0 ? cardMatch.ignoreSetForScoring : z;
        if ((i2 & 1048576) != 0) {
            z2 = z3;
            str13 = cardMatch.detectedCardLang;
        } else {
            str13 = str12;
            z2 = z3;
        }
        return cardMatch.copy(str24, str15, i3, j2, str16, str17, str18, str19, str20, str21, str22, str23, f7, f8, f9, f10, f11, f12, str25, z2, str13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getScryfallId() {
        return this.scryfallId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSet() {
        return this.set;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getBottomText() {
        return this.bottomText;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final float getSetScore() {
        return this.setScore;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final float getNumberScore() {
        return this.numberScore;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final float getDateScore() {
        return this.dateScore;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final float getHashScore() {
        return this.hashScore;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final float getBorderScore() {
        return this.borderScore;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final float getTotalScore() {
        return this.totalScore;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getEnScryfallId() {
        return this.enScryfallId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOracleId() {
        return this.oracleId;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final boolean getIgnoreSetForScoring() {
        return this.ignoreSetForScoring;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getDetectedCardLang() {
        return this.detectedCardLang;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFace() {
        return this.face;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getHashDifference() {
        return this.hashDifference;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNumber() {
        return this.number;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLocalizedTitle() {
        return this.localizedTitle;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getLocalizedTypeLine() {
        return this.localizedTypeLine;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getLocalizedOracle() {
        return this.localizedOracle;
    }

    public final CardMatch copy(String scryfallId, String oracleId, int face, long hashDifference, String number, String title, String localizedTitle, String localizedTypeLine, String localizedOracle, String lang, String set, String bottomText, float setScore, float numberScore, float dateScore, float hashScore, float borderScore, float totalScore, String enScryfallId, boolean ignoreSetForScoring, String detectedCardLang) {
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(oracleId, "oracleId");
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(localizedTitle, "localizedTitle");
        Intrinsics.checkNotNullParameter(localizedTypeLine, "localizedTypeLine");
        Intrinsics.checkNotNullParameter(localizedOracle, "localizedOracle");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(bottomText, "bottomText");
        Intrinsics.checkNotNullParameter(enScryfallId, "enScryfallId");
        Intrinsics.checkNotNullParameter(detectedCardLang, "detectedCardLang");
        return new CardMatch(scryfallId, oracleId, face, hashDifference, number, title, localizedTitle, localizedTypeLine, localizedOracle, lang, set, bottomText, setScore, numberScore, dateScore, hashScore, borderScore, totalScore, enScryfallId, ignoreSetForScoring, detectedCardLang);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardMatch)) {
            return false;
        }
        CardMatch cardMatch = (CardMatch) other;
        return Intrinsics.areEqual(this.scryfallId, cardMatch.scryfallId) && Intrinsics.areEqual(this.oracleId, cardMatch.oracleId) && this.face == cardMatch.face && this.hashDifference == cardMatch.hashDifference && Intrinsics.areEqual(this.number, cardMatch.number) && Intrinsics.areEqual(this.title, cardMatch.title) && Intrinsics.areEqual(this.localizedTitle, cardMatch.localizedTitle) && Intrinsics.areEqual(this.localizedTypeLine, cardMatch.localizedTypeLine) && Intrinsics.areEqual(this.localizedOracle, cardMatch.localizedOracle) && Intrinsics.areEqual(this.lang, cardMatch.lang) && Intrinsics.areEqual(this.set, cardMatch.set) && Intrinsics.areEqual(this.bottomText, cardMatch.bottomText) && Float.compare(this.setScore, cardMatch.setScore) == 0 && Float.compare(this.numberScore, cardMatch.numberScore) == 0 && Float.compare(this.dateScore, cardMatch.dateScore) == 0 && Float.compare(this.hashScore, cardMatch.hashScore) == 0 && Float.compare(this.borderScore, cardMatch.borderScore) == 0 && Float.compare(this.totalScore, cardMatch.totalScore) == 0 && Intrinsics.areEqual(this.enScryfallId, cardMatch.enScryfallId) && this.ignoreSetForScoring == cardMatch.ignoreSetForScoring && Intrinsics.areEqual(this.detectedCardLang, cardMatch.detectedCardLang);
    }

    public final float getBorderScore() {
        return this.borderScore;
    }

    public final String getBottomText() {
        return this.bottomText;
    }

    public final float getDateScore() {
        return this.dateScore;
    }

    public final String getDetectedCardLang() {
        return this.detectedCardLang;
    }

    public final String getEnScryfallId() {
        return this.enScryfallId;
    }

    public final int getFace() {
        return this.face;
    }

    public final long getHashDifference() {
        return this.hashDifference;
    }

    public final float getHashScore() {
        return this.hashScore;
    }

    public final boolean getIgnoreSetForScoring() {
        return this.ignoreSetForScoring;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getLocalizedOracle() {
        return this.localizedOracle;
    }

    public final String getLocalizedTitle() {
        return this.localizedTitle;
    }

    public final String getLocalizedTypeLine() {
        return this.localizedTypeLine;
    }

    public final String getNumber() {
        return this.number;
    }

    public final float getNumberScore() {
        return this.numberScore;
    }

    public final String getOracleId() {
        return this.oracleId;
    }

    public final String getScryfallId() {
        return this.scryfallId;
    }

    public final String getSet() {
        return this.set;
    }

    public final float getSetScore() {
        return this.setScore;
    }

    public final String getTitle() {
        return this.title;
    }

    public final float getTotalScore() {
        return this.totalScore;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((this.scryfallId.hashCode() * 31) + this.oracleId.hashCode()) * 31) + Integer.hashCode(this.face)) * 31) + Long.hashCode(this.hashDifference)) * 31) + this.number.hashCode()) * 31) + this.title.hashCode()) * 31) + this.localizedTitle.hashCode()) * 31) + this.localizedTypeLine.hashCode()) * 31) + this.localizedOracle.hashCode()) * 31) + this.lang.hashCode()) * 31) + this.set.hashCode()) * 31) + this.bottomText.hashCode()) * 31) + Float.hashCode(this.setScore)) * 31) + Float.hashCode(this.numberScore)) * 31) + Float.hashCode(this.dateScore)) * 31) + Float.hashCode(this.hashScore)) * 31) + Float.hashCode(this.borderScore)) * 31) + Float.hashCode(this.totalScore)) * 31) + this.enScryfallId.hashCode()) * 31) + Boolean.hashCode(this.ignoreSetForScoring)) * 31) + this.detectedCardLang.hashCode();
    }

    public final void setBorderScore(float f) {
        this.borderScore = f;
    }

    public final void setBottomText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bottomText = str;
    }

    public final void setDateScore(float f) {
        this.dateScore = f;
    }

    public final void setDetectedCardLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.detectedCardLang = str;
    }

    public final void setEnScryfallId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.enScryfallId = str;
    }

    public final void setFace(int i) {
        this.face = i;
    }

    public final void setHashDifference(long j) {
        this.hashDifference = j;
    }

    public final void setHashScore(float f) {
        this.hashScore = f;
    }

    public final void setIgnoreSetForScoring(boolean z) {
        this.ignoreSetForScoring = z;
    }

    public final void setLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lang = str;
    }

    public final void setLocalizedOracle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.localizedOracle = str;
    }

    public final void setLocalizedTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.localizedTitle = str;
    }

    public final void setLocalizedTypeLine(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.localizedTypeLine = str;
    }

    public final void setNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.number = str;
    }

    public final void setNumberScore(float f) {
        this.numberScore = f;
    }

    public final void setOracleId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.oracleId = str;
    }

    public final void setScryfallId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scryfallId = str;
    }

    public final void setSet(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.set = str;
    }

    public final void setSetScore(float f) {
        this.setScore = f;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setTotalScore(float f) {
        this.totalScore = f;
    }

    public String toString() {
        return "CardMatch(scryfallId=" + this.scryfallId + ", oracleId=" + this.oracleId + ", face=" + this.face + ", hashDifference=" + this.hashDifference + ", number=" + this.number + ", title=" + this.title + ", localizedTitle=" + this.localizedTitle + ", localizedTypeLine=" + this.localizedTypeLine + ", localizedOracle=" + this.localizedOracle + ", lang=" + this.lang + ", set=" + this.set + ", bottomText=" + this.bottomText + ", setScore=" + this.setScore + ", numberScore=" + this.numberScore + ", dateScore=" + this.dateScore + ", hashScore=" + this.hashScore + ", borderScore=" + this.borderScore + ", totalScore=" + this.totalScore + ", enScryfallId=" + this.enScryfallId + ", ignoreSetForScoring=" + this.ignoreSetForScoring + ", detectedCardLang=" + this.detectedCardLang + ")";
    }
}
