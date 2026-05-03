package com.studiolaganne.lengendarylens;

import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\bZ\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003Jß\u0001\u0010^\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u0005HÆ\u0001J\u0013\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010b\u001a\u00020\u0003HÖ\u0001J\t\u0010c\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"R\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010 \"\u0004\b>\u0010\"R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010\"R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010 \"\u0004\bB\u0010\"R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010 \"\u0004\bD\u0010\"R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010 \"\u0004\bF\u0010\"R\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010 \"\u0004\bH\u0010\"¨\u0006d"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardRecord;", "", "id", "", "oracle_id", "", "scryfall_id", "number", "hash", OptionalModuleUtils.FACE, Constants.GP_IAP_TITLE, "en_title", "set", "bottom_text", "border_color", "android_hash", "lang", "type_line", "oracle_text", "mana_cost", "int_field_1", "int_field_2", "identity", "keywords", WindowExtensionsConstants.LAYOUT_PACKAGE, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getOracle_id", "()Ljava/lang/String;", "setOracle_id", "(Ljava/lang/String;)V", "getScryfall_id", "setScryfall_id", "getNumber", "setNumber", "getHash", "setHash", "getFace", "setFace", "getTitle", "setTitle", "getEn_title", "setEn_title", "getSet", "setSet", "getBottom_text", "setBottom_text", "getBorder_color", "setBorder_color", "getAndroid_hash", "setAndroid_hash", "getLang", "setLang", "getType_line", "setType_line", "getOracle_text", "setOracle_text", "getMana_cost", "setMana_cost", "getInt_field_1", "setInt_field_1", "getInt_field_2", "setInt_field_2", "getIdentity", "setIdentity", "getKeywords", "setKeywords", "getLayout", "setLayout", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CardRecord {
    public static final int $stable = 8;
    private String android_hash;
    private String border_color;
    private String bottom_text;
    private String en_title;
    private int face;
    private int hash;
    private int id;
    private String identity;
    private String int_field_1;
    private String int_field_2;
    private String keywords;
    private String lang;
    private String layout;
    private String mana_cost;
    private String number;
    private String oracle_id;
    private String oracle_text;
    private String scryfall_id;
    private String set;
    private String title;
    private String type_line;

    public CardRecord() {
        this(0, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    public CardRecord(int i, String oracle_id, String scryfall_id, String number, int i2, int i3, String title, String en_title, String set, String str, String str2, String android_hash, String lang, String type_line, String oracle_text, String mana_cost, String int_field_1, String int_field_2, String identity, String keywords, String layout) {
        Intrinsics.checkNotNullParameter(oracle_id, "oracle_id");
        Intrinsics.checkNotNullParameter(scryfall_id, "scryfall_id");
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(en_title, "en_title");
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(android_hash, "android_hash");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(type_line, "type_line");
        Intrinsics.checkNotNullParameter(oracle_text, "oracle_text");
        Intrinsics.checkNotNullParameter(mana_cost, "mana_cost");
        Intrinsics.checkNotNullParameter(int_field_1, "int_field_1");
        Intrinsics.checkNotNullParameter(int_field_2, "int_field_2");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.id = i;
        this.oracle_id = oracle_id;
        this.scryfall_id = scryfall_id;
        this.number = number;
        this.hash = i2;
        this.face = i3;
        this.title = title;
        this.en_title = en_title;
        this.set = set;
        this.bottom_text = str;
        this.border_color = str2;
        this.android_hash = android_hash;
        this.lang = lang;
        this.type_line = type_line;
        this.oracle_text = oracle_text;
        this.mana_cost = mana_cost;
        this.int_field_1 = int_field_1;
        this.int_field_2 = int_field_2;
        this.identity = identity;
        this.keywords = keywords;
        this.layout = layout;
    }

    public /* synthetic */ CardRecord(int i, String str, String str2, String str3, int i2, int i3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? "" : str3, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) == 0 ? i3 : 0, (i4 & 64) != 0 ? "" : str4, (i4 & 128) != 0 ? "" : str5, (i4 & 256) != 0 ? "" : str6, (i4 & 512) != 0 ? null : str7, (i4 & 1024) == 0 ? str8 : null, (i4 & 2048) != 0 ? "" : str9, (i4 & 4096) != 0 ? "en" : str10, (i4 & 8192) != 0 ? "" : str11, (i4 & 16384) != 0 ? "" : str12, (i4 & 32768) != 0 ? "" : str13, (i4 & 65536) != 0 ? "" : str14, (i4 & 131072) != 0 ? "" : str15, (i4 & 262144) != 0 ? "" : str16, (i4 & 524288) != 0 ? "" : str17, (i4 & 1048576) != 0 ? "" : str18);
    }

    public static /* synthetic */ CardRecord copy$default(CardRecord cardRecord, int i, String str, String str2, String str3, int i2, int i3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, int i4, Object obj) {
        String str19;
        String str20;
        int i5 = (i4 & 1) != 0 ? cardRecord.id : i;
        String str21 = (i4 & 2) != 0 ? cardRecord.oracle_id : str;
        String str22 = (i4 & 4) != 0 ? cardRecord.scryfall_id : str2;
        String str23 = (i4 & 8) != 0 ? cardRecord.number : str3;
        int i6 = (i4 & 16) != 0 ? cardRecord.hash : i2;
        int i7 = (i4 & 32) != 0 ? cardRecord.face : i3;
        String str24 = (i4 & 64) != 0 ? cardRecord.title : str4;
        String str25 = (i4 & 128) != 0 ? cardRecord.en_title : str5;
        String str26 = (i4 & 256) != 0 ? cardRecord.set : str6;
        String str27 = (i4 & 512) != 0 ? cardRecord.bottom_text : str7;
        String str28 = (i4 & 1024) != 0 ? cardRecord.border_color : str8;
        String str29 = (i4 & 2048) != 0 ? cardRecord.android_hash : str9;
        String str30 = (i4 & 4096) != 0 ? cardRecord.lang : str10;
        String str31 = (i4 & 8192) != 0 ? cardRecord.type_line : str11;
        int i8 = i5;
        String str32 = (i4 & 16384) != 0 ? cardRecord.oracle_text : str12;
        String str33 = (i4 & 32768) != 0 ? cardRecord.mana_cost : str13;
        String str34 = (i4 & 65536) != 0 ? cardRecord.int_field_1 : str14;
        String str35 = (i4 & 131072) != 0 ? cardRecord.int_field_2 : str15;
        String str36 = (i4 & 262144) != 0 ? cardRecord.identity : str16;
        String str37 = (i4 & 524288) != 0 ? cardRecord.keywords : str17;
        if ((i4 & 1048576) != 0) {
            str20 = str37;
            str19 = cardRecord.layout;
        } else {
            str19 = str18;
            str20 = str37;
        }
        return cardRecord.copy(i8, str21, str22, str23, i6, i7, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str20, str19);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getBottom_text() {
        return this.bottom_text;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getBorder_color() {
        return this.border_color;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getAndroid_hash() {
        return this.android_hash;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getType_line() {
        return this.type_line;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getOracle_text() {
        return this.oracle_text;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getMana_cost() {
        return this.mana_cost;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getInt_field_1() {
        return this.int_field_1;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getInt_field_2() {
        return this.int_field_2;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getIdentity() {
        return this.identity;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOracle_id() {
        return this.oracle_id;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getKeywords() {
        return this.keywords;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getLayout() {
        return this.layout;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getScryfall_id() {
        return this.scryfall_id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNumber() {
        return this.number;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getHash() {
        return this.hash;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getFace() {
        return this.face;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getEn_title() {
        return this.en_title;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSet() {
        return this.set;
    }

    public final CardRecord copy(int id, String oracle_id, String scryfall_id, String number, int hash, int face, String title, String en_title, String set, String bottom_text, String border_color, String android_hash, String lang, String type_line, String oracle_text, String mana_cost, String int_field_1, String int_field_2, String identity, String keywords, String layout) {
        Intrinsics.checkNotNullParameter(oracle_id, "oracle_id");
        Intrinsics.checkNotNullParameter(scryfall_id, "scryfall_id");
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(en_title, "en_title");
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(android_hash, "android_hash");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(type_line, "type_line");
        Intrinsics.checkNotNullParameter(oracle_text, "oracle_text");
        Intrinsics.checkNotNullParameter(mana_cost, "mana_cost");
        Intrinsics.checkNotNullParameter(int_field_1, "int_field_1");
        Intrinsics.checkNotNullParameter(int_field_2, "int_field_2");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        Intrinsics.checkNotNullParameter(layout, "layout");
        return new CardRecord(id, oracle_id, scryfall_id, number, hash, face, title, en_title, set, bottom_text, border_color, android_hash, lang, type_line, oracle_text, mana_cost, int_field_1, int_field_2, identity, keywords, layout);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardRecord)) {
            return false;
        }
        CardRecord cardRecord = (CardRecord) other;
        return this.id == cardRecord.id && Intrinsics.areEqual(this.oracle_id, cardRecord.oracle_id) && Intrinsics.areEqual(this.scryfall_id, cardRecord.scryfall_id) && Intrinsics.areEqual(this.number, cardRecord.number) && this.hash == cardRecord.hash && this.face == cardRecord.face && Intrinsics.areEqual(this.title, cardRecord.title) && Intrinsics.areEqual(this.en_title, cardRecord.en_title) && Intrinsics.areEqual(this.set, cardRecord.set) && Intrinsics.areEqual(this.bottom_text, cardRecord.bottom_text) && Intrinsics.areEqual(this.border_color, cardRecord.border_color) && Intrinsics.areEqual(this.android_hash, cardRecord.android_hash) && Intrinsics.areEqual(this.lang, cardRecord.lang) && Intrinsics.areEqual(this.type_line, cardRecord.type_line) && Intrinsics.areEqual(this.oracle_text, cardRecord.oracle_text) && Intrinsics.areEqual(this.mana_cost, cardRecord.mana_cost) && Intrinsics.areEqual(this.int_field_1, cardRecord.int_field_1) && Intrinsics.areEqual(this.int_field_2, cardRecord.int_field_2) && Intrinsics.areEqual(this.identity, cardRecord.identity) && Intrinsics.areEqual(this.keywords, cardRecord.keywords) && Intrinsics.areEqual(this.layout, cardRecord.layout);
    }

    public final String getAndroid_hash() {
        return this.android_hash;
    }

    public final String getBorder_color() {
        return this.border_color;
    }

    public final String getBottom_text() {
        return this.bottom_text;
    }

    public final String getEn_title() {
        return this.en_title;
    }

    public final int getFace() {
        return this.face;
    }

    public final int getHash() {
        return this.hash;
    }

    public final int getId() {
        return this.id;
    }

    public final String getIdentity() {
        return this.identity;
    }

    public final String getInt_field_1() {
        return this.int_field_1;
    }

    public final String getInt_field_2() {
        return this.int_field_2;
    }

    public final String getKeywords() {
        return this.keywords;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getLayout() {
        return this.layout;
    }

    public final String getMana_cost() {
        return this.mana_cost;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String getOracle_id() {
        return this.oracle_id;
    }

    public final String getOracle_text() {
        return this.oracle_text;
    }

    public final String getScryfall_id() {
        return this.scryfall_id;
    }

    public final String getSet() {
        return this.set;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType_line() {
        return this.type_line;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((Integer.hashCode(this.id) * 31) + this.oracle_id.hashCode()) * 31) + this.scryfall_id.hashCode()) * 31) + this.number.hashCode()) * 31) + Integer.hashCode(this.hash)) * 31) + Integer.hashCode(this.face)) * 31) + this.title.hashCode()) * 31) + this.en_title.hashCode()) * 31) + this.set.hashCode()) * 31;
        String str = this.bottom_text;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.border_color;
        return ((((((((((((((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.android_hash.hashCode()) * 31) + this.lang.hashCode()) * 31) + this.type_line.hashCode()) * 31) + this.oracle_text.hashCode()) * 31) + this.mana_cost.hashCode()) * 31) + this.int_field_1.hashCode()) * 31) + this.int_field_2.hashCode()) * 31) + this.identity.hashCode()) * 31) + this.keywords.hashCode()) * 31) + this.layout.hashCode();
    }

    public final void setAndroid_hash(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.android_hash = str;
    }

    public final void setBorder_color(String str) {
        this.border_color = str;
    }

    public final void setBottom_text(String str) {
        this.bottom_text = str;
    }

    public final void setEn_title(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.en_title = str;
    }

    public final void setFace(int i) {
        this.face = i;
    }

    public final void setHash(int i) {
        this.hash = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setIdentity(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.identity = str;
    }

    public final void setInt_field_1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.int_field_1 = str;
    }

    public final void setInt_field_2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.int_field_2 = str;
    }

    public final void setKeywords(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keywords = str;
    }

    public final void setLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lang = str;
    }

    public final void setLayout(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.layout = str;
    }

    public final void setMana_cost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mana_cost = str;
    }

    public final void setNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.number = str;
    }

    public final void setOracle_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.oracle_id = str;
    }

    public final void setOracle_text(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.oracle_text = str;
    }

    public final void setScryfall_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scryfall_id = str;
    }

    public final void setSet(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.set = str;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setType_line(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type_line = str;
    }

    public String toString() {
        return "CardRecord(id=" + this.id + ", oracle_id=" + this.oracle_id + ", scryfall_id=" + this.scryfall_id + ", number=" + this.number + ", hash=" + this.hash + ", face=" + this.face + ", title=" + this.title + ", en_title=" + this.en_title + ", set=" + this.set + ", bottom_text=" + this.bottom_text + ", border_color=" + this.border_color + ", android_hash=" + this.android_hash + ", lang=" + this.lang + ", type_line=" + this.type_line + ", oracle_text=" + this.oracle_text + ", mana_cost=" + this.mana_cost + ", int_field_1=" + this.int_field_1 + ", int_field_2=" + this.int_field_2 + ", identity=" + this.identity + ", keywords=" + this.keywords + ", layout=" + this.layout + ")";
    }
}
