package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jq\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012¨\u00065"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSimpleCard;", "", "collector_number", "", "id", "image_uris", "Lcom/studiolaganne/lengendarylens/MTImageURIs;", "lang", "name", "oracle_id", "printed_name", "scryfall_id", "set_code", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTImageURIs;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCollector_number", "()Ljava/lang/String;", "setCollector_number", "(Ljava/lang/String;)V", "getId", "setId", "getImage_uris", "()Lcom/studiolaganne/lengendarylens/MTImageURIs;", "setImage_uris", "(Lcom/studiolaganne/lengendarylens/MTImageURIs;)V", "getLang", "setLang", "getName", "setName", "getOracle_id", "setOracle_id", "getPrinted_name", "setPrinted_name", "getScryfall_id", "setScryfall_id", "getSet_code", "setSet_code", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSimpleCard {
    public static final int $stable = 8;
    private String collector_number;
    private String id;
    private MTImageURIs image_uris;
    private String lang;
    private String name;
    private String oracle_id;
    private String printed_name;
    private String scryfall_id;
    private String set_code;

    public MTSimpleCard() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public MTSimpleCard(String str, String id, MTImageURIs mTImageURIs, String str2, String name, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.collector_number = str;
        this.id = id;
        this.image_uris = mTImageURIs;
        this.lang = str2;
        this.name = name;
        this.oracle_id = str3;
        this.printed_name = str4;
        this.scryfall_id = str5;
        this.set_code = str6;
    }

    public /* synthetic */ MTSimpleCard(String str, String str2, MTImageURIs mTImageURIs, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : mTImageURIs, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8);
    }

    public static /* synthetic */ MTSimpleCard copy$default(MTSimpleCard mTSimpleCard, String str, String str2, MTImageURIs mTImageURIs, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTSimpleCard.collector_number;
        }
        if ((i & 2) != 0) {
            str2 = mTSimpleCard.id;
        }
        if ((i & 4) != 0) {
            mTImageURIs = mTSimpleCard.image_uris;
        }
        if ((i & 8) != 0) {
            str3 = mTSimpleCard.lang;
        }
        if ((i & 16) != 0) {
            str4 = mTSimpleCard.name;
        }
        if ((i & 32) != 0) {
            str5 = mTSimpleCard.oracle_id;
        }
        if ((i & 64) != 0) {
            str6 = mTSimpleCard.printed_name;
        }
        if ((i & 128) != 0) {
            str7 = mTSimpleCard.scryfall_id;
        }
        if ((i & 256) != 0) {
            str8 = mTSimpleCard.set_code;
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str5;
        String str12 = str6;
        String str13 = str4;
        MTImageURIs mTImageURIs2 = mTImageURIs;
        return mTSimpleCard.copy(str, str2, mTImageURIs2, str3, str13, str11, str12, str9, str10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCollector_number() {
        return this.collector_number;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTImageURIs getImage_uris() {
        return this.image_uris;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOracle_id() {
        return this.oracle_id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPrinted_name() {
        return this.printed_name;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getScryfall_id() {
        return this.scryfall_id;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSet_code() {
        return this.set_code;
    }

    public final MTSimpleCard copy(String collector_number, String id, MTImageURIs image_uris, String lang, String name, String oracle_id, String printed_name, String scryfall_id, String set_code) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new MTSimpleCard(collector_number, id, image_uris, lang, name, oracle_id, printed_name, scryfall_id, set_code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSimpleCard)) {
            return false;
        }
        MTSimpleCard mTSimpleCard = (MTSimpleCard) other;
        return Intrinsics.areEqual(this.collector_number, mTSimpleCard.collector_number) && Intrinsics.areEqual(this.id, mTSimpleCard.id) && Intrinsics.areEqual(this.image_uris, mTSimpleCard.image_uris) && Intrinsics.areEqual(this.lang, mTSimpleCard.lang) && Intrinsics.areEqual(this.name, mTSimpleCard.name) && Intrinsics.areEqual(this.oracle_id, mTSimpleCard.oracle_id) && Intrinsics.areEqual(this.printed_name, mTSimpleCard.printed_name) && Intrinsics.areEqual(this.scryfall_id, mTSimpleCard.scryfall_id) && Intrinsics.areEqual(this.set_code, mTSimpleCard.set_code);
    }

    public final String getCollector_number() {
        return this.collector_number;
    }

    public final String getId() {
        return this.id;
    }

    public final MTImageURIs getImage_uris() {
        return this.image_uris;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOracle_id() {
        return this.oracle_id;
    }

    public final String getPrinted_name() {
        return this.printed_name;
    }

    public final String getScryfall_id() {
        return this.scryfall_id;
    }

    public final String getSet_code() {
        return this.set_code;
    }

    public int hashCode() {
        String str = this.collector_number;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.id.hashCode()) * 31;
        MTImageURIs mTImageURIs = this.image_uris;
        int iHashCode2 = (iHashCode + (mTImageURIs == null ? 0 : mTImageURIs.hashCode())) * 31;
        String str2 = this.lang;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.name.hashCode()) * 31;
        String str3 = this.oracle_id;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.printed_name;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.scryfall_id;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.set_code;
        return iHashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setCollector_number(String str) {
        this.collector_number = str;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setImage_uris(MTImageURIs mTImageURIs) {
        this.image_uris = mTImageURIs;
    }

    public final void setLang(String str) {
        this.lang = str;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setOracle_id(String str) {
        this.oracle_id = str;
    }

    public final void setPrinted_name(String str) {
        this.printed_name = str;
    }

    public final void setScryfall_id(String str) {
        this.scryfall_id = str;
    }

    public final void setSet_code(String str) {
        this.set_code = str;
    }

    public String toString() {
        return "MTSimpleCard(collector_number=" + this.collector_number + ", id=" + this.id + ", image_uris=" + this.image_uris + ", lang=" + this.lang + ", name=" + this.name + ", oracle_id=" + this.oracle_id + ", printed_name=" + this.printed_name + ", scryfall_id=" + this.scryfall_id + ", set_code=" + this.set_code + ")";
    }
}
