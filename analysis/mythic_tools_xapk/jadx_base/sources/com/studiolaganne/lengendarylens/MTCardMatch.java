package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bJ\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B×\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÞ\u0001\u0010U\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\rHÖ\u0001J\t\u0010[\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001cR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001a\"\u0004\b5\u0010\u001cR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001a\"\u0004\b7\u0010\u001cR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001a\"\u0004\b9\u0010\u001cR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b:\u0010.\"\u0004\b;\u00100R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001a\"\u0004\b=\u0010\u001cR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001a\"\u0004\b?\u0010\u001cR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001a\"\u0004\bA\u0010\u001cR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001a\"\u0004\bC\u0010\u001c¨\u0006\\"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardMatch;", "", "cardid", "", "collector_number", "condition", "finish", "finishes", "", "images", "Lcom/studiolaganne/lengendarylens/MTImageURIs;", "lang", "list_card_id", "", AndroidContextPlugin.LOCALE_KEY, "name", "oracleid", "printed_name", FirebaseAnalytics.Param.QUANTITY, "scryfallid", "set_code", "set_icon_svg_uri", "set_name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTImageURIs;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardid", "()Ljava/lang/String;", "setCardid", "(Ljava/lang/String;)V", "getCollector_number", "setCollector_number", "getCondition", "setCondition", "getFinish", "setFinish", "getFinishes", "()Ljava/util/List;", "setFinishes", "(Ljava/util/List;)V", "getImages", "()Lcom/studiolaganne/lengendarylens/MTImageURIs;", "setImages", "(Lcom/studiolaganne/lengendarylens/MTImageURIs;)V", "getLang", "setLang", "getList_card_id", "()Ljava/lang/Integer;", "setList_card_id", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLocale", "setLocale", "getName", "setName", "getOracleid", "setOracleid", "getPrinted_name", "setPrinted_name", "getQuantity", "setQuantity", "getScryfallid", "setScryfallid", "getSet_code", "setSet_code", "getSet_icon_svg_uri", "setSet_icon_svg_uri", "getSet_name", "setSet_name", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTImageURIs;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTCardMatch;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardMatch {
    public static final int $stable = 8;
    private String cardid;
    private String collector_number;
    private String condition;
    private String finish;
    private List<String> finishes;
    private MTImageURIs images;
    private String lang;
    private Integer list_card_id;
    private String locale;
    private String name;
    private String oracleid;
    private String printed_name;
    private Integer quantity;
    private String scryfallid;
    private String set_code;
    private String set_icon_svg_uri;
    private String set_name;

    public MTCardMatch() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public MTCardMatch(String str, String str2, String str3, String str4, List<String> list, MTImageURIs mTImageURIs, String lang, Integer num, String str5, String str6, String str7, String str8, Integer num2, String str9, String str10, String str11, String str12) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        this.cardid = str;
        this.collector_number = str2;
        this.condition = str3;
        this.finish = str4;
        this.finishes = list;
        this.images = mTImageURIs;
        this.lang = lang;
        this.list_card_id = num;
        this.locale = str5;
        this.name = str6;
        this.oracleid = str7;
        this.printed_name = str8;
        this.quantity = num2;
        this.scryfallid = str9;
        this.set_code = str10;
        this.set_icon_svg_uri = str11;
        this.set_name = str12;
    }

    public /* synthetic */ MTCardMatch(String str, String str2, String str3, String str4, List list, MTImageURIs mTImageURIs, String str5, Integer num, String str6, String str7, String str8, String str9, Integer num2, String str10, String str11, String str12, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : mTImageURIs, (i & 64) != 0 ? "en" : str5, (i & 128) != 0 ? null : num, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? null : str8, (i & 2048) != 0 ? null : str9, (i & 4096) != 0 ? 1 : num2, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : str11, (i & 32768) != 0 ? null : str12, (i & 65536) != 0 ? null : str13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardMatch copy$default(MTCardMatch mTCardMatch, String str, String str2, String str3, String str4, List list, MTImageURIs mTImageURIs, String str5, Integer num, String str6, String str7, String str8, String str9, Integer num2, String str10, String str11, String str12, String str13, int i, Object obj) {
        String str14;
        String str15;
        String str16;
        MTCardMatch mTCardMatch2;
        String str17;
        String str18;
        String str19;
        String str20;
        List list2;
        MTImageURIs mTImageURIs2;
        String str21;
        Integer num3;
        String str22;
        String str23;
        String str24;
        String str25;
        Integer num4;
        String str26;
        String str27 = (i & 1) != 0 ? mTCardMatch.cardid : str;
        String str28 = (i & 2) != 0 ? mTCardMatch.collector_number : str2;
        String str29 = (i & 4) != 0 ? mTCardMatch.condition : str3;
        String str30 = (i & 8) != 0 ? mTCardMatch.finish : str4;
        List list3 = (i & 16) != 0 ? mTCardMatch.finishes : list;
        MTImageURIs mTImageURIs3 = (i & 32) != 0 ? mTCardMatch.images : mTImageURIs;
        String str31 = (i & 64) != 0 ? mTCardMatch.lang : str5;
        Integer num5 = (i & 128) != 0 ? mTCardMatch.list_card_id : num;
        String str32 = (i & 256) != 0 ? mTCardMatch.locale : str6;
        String str33 = (i & 512) != 0 ? mTCardMatch.name : str7;
        String str34 = (i & 1024) != 0 ? mTCardMatch.oracleid : str8;
        String str35 = (i & 2048) != 0 ? mTCardMatch.printed_name : str9;
        Integer num6 = (i & 4096) != 0 ? mTCardMatch.quantity : num2;
        String str36 = (i & 8192) != 0 ? mTCardMatch.scryfallid : str10;
        String str37 = str27;
        String str38 = (i & 16384) != 0 ? mTCardMatch.set_code : str11;
        String str39 = (i & 32768) != 0 ? mTCardMatch.set_icon_svg_uri : str12;
        if ((i & 65536) != 0) {
            str15 = str39;
            str14 = mTCardMatch.set_name;
            str17 = str38;
            str18 = str28;
            str19 = str29;
            str20 = str30;
            list2 = list3;
            mTImageURIs2 = mTImageURIs3;
            str21 = str31;
            num3 = num5;
            str22 = str32;
            str23 = str33;
            str24 = str34;
            str25 = str35;
            num4 = num6;
            str26 = str36;
            str16 = str37;
            mTCardMatch2 = mTCardMatch;
        } else {
            str14 = str13;
            str15 = str39;
            str16 = str37;
            mTCardMatch2 = mTCardMatch;
            str17 = str38;
            str18 = str28;
            str19 = str29;
            str20 = str30;
            list2 = list3;
            mTImageURIs2 = mTImageURIs3;
            str21 = str31;
            num3 = num5;
            str22 = str32;
            str23 = str33;
            str24 = str34;
            str25 = str35;
            num4 = num6;
            str26 = str36;
        }
        return mTCardMatch2.copy(str16, str18, str19, str20, list2, mTImageURIs2, str21, num3, str22, str23, str24, str25, num4, str26, str17, str15, str14);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCardid() {
        return this.cardid;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getOracleid() {
        return this.oracleid;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getPrinted_name() {
        return this.printed_name;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getQuantity() {
        return this.quantity;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getScryfallid() {
        return this.scryfallid;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getSet_code() {
        return this.set_code;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getSet_icon_svg_uri() {
        return this.set_icon_svg_uri;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getSet_name() {
        return this.set_name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCollector_number() {
        return this.collector_number;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCondition() {
        return this.condition;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFinish() {
        return this.finish;
    }

    public final List<String> component5() {
        return this.finishes;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTImageURIs getImages() {
        return this.images;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getList_card_id() {
        return this.list_card_id;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    public final MTCardMatch copy(String cardid, String collector_number, String condition, String finish, List<String> finishes, MTImageURIs images, String lang, Integer list_card_id, String locale, String name, String oracleid, String printed_name, Integer quantity, String scryfallid, String set_code, String set_icon_svg_uri, String set_name) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        return new MTCardMatch(cardid, collector_number, condition, finish, finishes, images, lang, list_card_id, locale, name, oracleid, printed_name, quantity, scryfallid, set_code, set_icon_svg_uri, set_name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardMatch)) {
            return false;
        }
        MTCardMatch mTCardMatch = (MTCardMatch) other;
        return Intrinsics.areEqual(this.cardid, mTCardMatch.cardid) && Intrinsics.areEqual(this.collector_number, mTCardMatch.collector_number) && Intrinsics.areEqual(this.condition, mTCardMatch.condition) && Intrinsics.areEqual(this.finish, mTCardMatch.finish) && Intrinsics.areEqual(this.finishes, mTCardMatch.finishes) && Intrinsics.areEqual(this.images, mTCardMatch.images) && Intrinsics.areEqual(this.lang, mTCardMatch.lang) && Intrinsics.areEqual(this.list_card_id, mTCardMatch.list_card_id) && Intrinsics.areEqual(this.locale, mTCardMatch.locale) && Intrinsics.areEqual(this.name, mTCardMatch.name) && Intrinsics.areEqual(this.oracleid, mTCardMatch.oracleid) && Intrinsics.areEqual(this.printed_name, mTCardMatch.printed_name) && Intrinsics.areEqual(this.quantity, mTCardMatch.quantity) && Intrinsics.areEqual(this.scryfallid, mTCardMatch.scryfallid) && Intrinsics.areEqual(this.set_code, mTCardMatch.set_code) && Intrinsics.areEqual(this.set_icon_svg_uri, mTCardMatch.set_icon_svg_uri) && Intrinsics.areEqual(this.set_name, mTCardMatch.set_name);
    }

    public final String getCardid() {
        return this.cardid;
    }

    public final String getCollector_number() {
        return this.collector_number;
    }

    public final String getCondition() {
        return this.condition;
    }

    public final String getFinish() {
        return this.finish;
    }

    public final List<String> getFinishes() {
        return this.finishes;
    }

    public final MTImageURIs getImages() {
        return this.images;
    }

    public final String getLang() {
        return this.lang;
    }

    public final Integer getList_card_id() {
        return this.list_card_id;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOracleid() {
        return this.oracleid;
    }

    public final String getPrinted_name() {
        return this.printed_name;
    }

    public final Integer getQuantity() {
        return this.quantity;
    }

    public final String getScryfallid() {
        return this.scryfallid;
    }

    public final String getSet_code() {
        return this.set_code;
    }

    public final String getSet_icon_svg_uri() {
        return this.set_icon_svg_uri;
    }

    public final String getSet_name() {
        return this.set_name;
    }

    public int hashCode() {
        String str = this.cardid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.collector_number;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.condition;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.finish;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<String> list = this.finishes;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        MTImageURIs mTImageURIs = this.images;
        int iHashCode6 = (((iHashCode5 + (mTImageURIs == null ? 0 : mTImageURIs.hashCode())) * 31) + this.lang.hashCode()) * 31;
        Integer num = this.list_card_id;
        int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.locale;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.name;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.oracleid;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.printed_name;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num2 = this.quantity;
        int iHashCode12 = (iHashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str9 = this.scryfallid;
        int iHashCode13 = (iHashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.set_code;
        int iHashCode14 = (iHashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.set_icon_svg_uri;
        int iHashCode15 = (iHashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.set_name;
        return iHashCode15 + (str12 != null ? str12.hashCode() : 0);
    }

    public final void setCardid(String str) {
        this.cardid = str;
    }

    public final void setCollector_number(String str) {
        this.collector_number = str;
    }

    public final void setCondition(String str) {
        this.condition = str;
    }

    public final void setFinish(String str) {
        this.finish = str;
    }

    public final void setFinishes(List<String> list) {
        this.finishes = list;
    }

    public final void setImages(MTImageURIs mTImageURIs) {
        this.images = mTImageURIs;
    }

    public final void setLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lang = str;
    }

    public final void setList_card_id(Integer num) {
        this.list_card_id = num;
    }

    public final void setLocale(String str) {
        this.locale = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOracleid(String str) {
        this.oracleid = str;
    }

    public final void setPrinted_name(String str) {
        this.printed_name = str;
    }

    public final void setQuantity(Integer num) {
        this.quantity = num;
    }

    public final void setScryfallid(String str) {
        this.scryfallid = str;
    }

    public final void setSet_code(String str) {
        this.set_code = str;
    }

    public final void setSet_icon_svg_uri(String str) {
        this.set_icon_svg_uri = str;
    }

    public final void setSet_name(String str) {
        this.set_name = str;
    }

    public String toString() {
        return "MTCardMatch(cardid=" + this.cardid + ", collector_number=" + this.collector_number + ", condition=" + this.condition + ", finish=" + this.finish + ", finishes=" + this.finishes + ", images=" + this.images + ", lang=" + this.lang + ", list_card_id=" + this.list_card_id + ", locale=" + this.locale + ", name=" + this.name + ", oracleid=" + this.oracleid + ", printed_name=" + this.printed_name + ", quantity=" + this.quantity + ", scryfallid=" + this.scryfallid + ", set_code=" + this.set_code + ", set_icon_svg_uri=" + this.set_icon_svg_uri + ", set_name=" + this.set_name + ")";
    }
}
