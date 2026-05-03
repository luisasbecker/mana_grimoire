package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006*"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTBracketMetricsCard;", "", "cardid", "", "oracle_id", "name", "printed_name", "set_code", "collector_number", "lang", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardid", "()Ljava/lang/String;", "setCardid", "(Ljava/lang/String;)V", "getOracle_id", "setOracle_id", "getName", "setName", "getPrinted_name", "setPrinted_name", "getSet_code", "setSet_code", "getCollector_number", "setCollector_number", "getLang", "setLang", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTBracketMetricsCard {
    public static final int $stable = 8;
    private String cardid;
    private String collector_number;
    private String lang;
    private String name;
    private String oracle_id;
    private String printed_name;
    private String set_code;

    public MTBracketMetricsCard() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public MTBracketMetricsCard(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.cardid = str;
        this.oracle_id = str2;
        this.name = str3;
        this.printed_name = str4;
        this.set_code = str5;
        this.collector_number = str6;
        this.lang = str7;
    }

    public /* synthetic */ MTBracketMetricsCard(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }

    public static /* synthetic */ MTBracketMetricsCard copy$default(MTBracketMetricsCard mTBracketMetricsCard, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTBracketMetricsCard.cardid;
        }
        if ((i & 2) != 0) {
            str2 = mTBracketMetricsCard.oracle_id;
        }
        if ((i & 4) != 0) {
            str3 = mTBracketMetricsCard.name;
        }
        if ((i & 8) != 0) {
            str4 = mTBracketMetricsCard.printed_name;
        }
        if ((i & 16) != 0) {
            str5 = mTBracketMetricsCard.set_code;
        }
        if ((i & 32) != 0) {
            str6 = mTBracketMetricsCard.collector_number;
        }
        if ((i & 64) != 0) {
            str7 = mTBracketMetricsCard.lang;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        String str11 = str3;
        return mTBracketMetricsCard.copy(str, str2, str11, str4, str10, str8, str9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCardid() {
        return this.cardid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOracle_id() {
        return this.oracle_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPrinted_name() {
        return this.printed_name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSet_code() {
        return this.set_code;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCollector_number() {
        return this.collector_number;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    public final MTBracketMetricsCard copy(String cardid, String oracle_id, String name, String printed_name, String set_code, String collector_number, String lang) {
        return new MTBracketMetricsCard(cardid, oracle_id, name, printed_name, set_code, collector_number, lang);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTBracketMetricsCard)) {
            return false;
        }
        MTBracketMetricsCard mTBracketMetricsCard = (MTBracketMetricsCard) other;
        return Intrinsics.areEqual(this.cardid, mTBracketMetricsCard.cardid) && Intrinsics.areEqual(this.oracle_id, mTBracketMetricsCard.oracle_id) && Intrinsics.areEqual(this.name, mTBracketMetricsCard.name) && Intrinsics.areEqual(this.printed_name, mTBracketMetricsCard.printed_name) && Intrinsics.areEqual(this.set_code, mTBracketMetricsCard.set_code) && Intrinsics.areEqual(this.collector_number, mTBracketMetricsCard.collector_number) && Intrinsics.areEqual(this.lang, mTBracketMetricsCard.lang);
    }

    public final String getCardid() {
        return this.cardid;
    }

    public final String getCollector_number() {
        return this.collector_number;
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

    public final String getSet_code() {
        return this.set_code;
    }

    public int hashCode() {
        String str = this.cardid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.oracle_id;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.printed_name;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.set_code;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.collector_number;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.lang;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setCardid(String str) {
        this.cardid = str;
    }

    public final void setCollector_number(String str) {
        this.collector_number = str;
    }

    public final void setLang(String str) {
        this.lang = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOracle_id(String str) {
        this.oracle_id = str;
    }

    public final void setPrinted_name(String str) {
        this.printed_name = str;
    }

    public final void setSet_code(String str) {
        this.set_code = str;
    }

    public String toString() {
        return "MTBracketMetricsCard(cardid=" + this.cardid + ", oracle_id=" + this.oracle_id + ", name=" + this.name + ", printed_name=" + this.printed_name + ", set_code=" + this.set_code + ", collector_number=" + this.collector_number + ", lang=" + this.lang + ")";
    }
}
