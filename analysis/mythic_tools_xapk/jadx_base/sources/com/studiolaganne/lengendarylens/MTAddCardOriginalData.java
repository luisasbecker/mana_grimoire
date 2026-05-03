package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001aJz\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\bHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001a¨\u0006-"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTAddCardOriginalData;", "", "set_code", "", "collector_number", "lang", "finish", FirebaseAnalytics.Param.QUANTITY, "", "condition", "altered", "", "missprint", "signed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getSet_code", "()Ljava/lang/String;", "getCollector_number", "getLang", "getFinish", "getQuantity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCondition", "getAltered", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMissprint", "getSigned", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTAddCardOriginalData;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTAddCardOriginalData {
    public static final int $stable = 0;
    private final Boolean altered;
    private final String collector_number;
    private final String condition;
    private final String finish;
    private final String lang;
    private final Boolean missprint;
    private final Integer quantity;
    private final String set_code;
    private final Boolean signed;

    public MTAddCardOriginalData() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public MTAddCardOriginalData(String str, String str2, String str3, String str4, Integer num, String str5, Boolean bool, Boolean bool2, Boolean bool3) {
        this.set_code = str;
        this.collector_number = str2;
        this.lang = str3;
        this.finish = str4;
        this.quantity = num;
        this.condition = str5;
        this.altered = bool;
        this.missprint = bool2;
        this.signed = bool3;
    }

    public /* synthetic */ MTAddCardOriginalData(String str, String str2, String str3, String str4, Integer num, String str5, Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? 1 : num, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : bool2, (i & 256) != 0 ? null : bool3);
    }

    public static /* synthetic */ MTAddCardOriginalData copy$default(MTAddCardOriginalData mTAddCardOriginalData, String str, String str2, String str3, String str4, Integer num, String str5, Boolean bool, Boolean bool2, Boolean bool3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTAddCardOriginalData.set_code;
        }
        if ((i & 2) != 0) {
            str2 = mTAddCardOriginalData.collector_number;
        }
        if ((i & 4) != 0) {
            str3 = mTAddCardOriginalData.lang;
        }
        if ((i & 8) != 0) {
            str4 = mTAddCardOriginalData.finish;
        }
        if ((i & 16) != 0) {
            num = mTAddCardOriginalData.quantity;
        }
        if ((i & 32) != 0) {
            str5 = mTAddCardOriginalData.condition;
        }
        if ((i & 64) != 0) {
            bool = mTAddCardOriginalData.altered;
        }
        if ((i & 128) != 0) {
            bool2 = mTAddCardOriginalData.missprint;
        }
        if ((i & 256) != 0) {
            bool3 = mTAddCardOriginalData.signed;
        }
        Boolean bool4 = bool2;
        Boolean bool5 = bool3;
        String str6 = str5;
        Boolean bool6 = bool;
        Integer num2 = num;
        String str7 = str3;
        return mTAddCardOriginalData.copy(str, str2, str7, str4, num2, str6, bool6, bool4, bool5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSet_code() {
        return this.set_code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCollector_number() {
        return this.collector_number;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFinish() {
        return this.finish;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getQuantity() {
        return this.quantity;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCondition() {
        return this.condition;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Boolean getAltered() {
        return this.altered;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getMissprint() {
        return this.missprint;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getSigned() {
        return this.signed;
    }

    public final MTAddCardOriginalData copy(String set_code, String collector_number, String lang, String finish, Integer quantity, String condition, Boolean altered, Boolean missprint, Boolean signed) {
        return new MTAddCardOriginalData(set_code, collector_number, lang, finish, quantity, condition, altered, missprint, signed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTAddCardOriginalData)) {
            return false;
        }
        MTAddCardOriginalData mTAddCardOriginalData = (MTAddCardOriginalData) other;
        return Intrinsics.areEqual(this.set_code, mTAddCardOriginalData.set_code) && Intrinsics.areEqual(this.collector_number, mTAddCardOriginalData.collector_number) && Intrinsics.areEqual(this.lang, mTAddCardOriginalData.lang) && Intrinsics.areEqual(this.finish, mTAddCardOriginalData.finish) && Intrinsics.areEqual(this.quantity, mTAddCardOriginalData.quantity) && Intrinsics.areEqual(this.condition, mTAddCardOriginalData.condition) && Intrinsics.areEqual(this.altered, mTAddCardOriginalData.altered) && Intrinsics.areEqual(this.missprint, mTAddCardOriginalData.missprint) && Intrinsics.areEqual(this.signed, mTAddCardOriginalData.signed);
    }

    public final Boolean getAltered() {
        return this.altered;
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

    public final String getLang() {
        return this.lang;
    }

    public final Boolean getMissprint() {
        return this.missprint;
    }

    public final Integer getQuantity() {
        return this.quantity;
    }

    public final String getSet_code() {
        return this.set_code;
    }

    public final Boolean getSigned() {
        return this.signed;
    }

    public int hashCode() {
        String str = this.set_code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.collector_number;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.lang;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.finish;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.quantity;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.condition;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.altered;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.missprint;
        int iHashCode8 = (iHashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.signed;
        return iHashCode8 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        return "MTAddCardOriginalData(set_code=" + this.set_code + ", collector_number=" + this.collector_number + ", lang=" + this.lang + ", finish=" + this.finish + ", quantity=" + this.quantity + ", condition=" + this.condition + ", altered=" + this.altered + ", missprint=" + this.missprint + ", signed=" + this.signed + ")";
    }
}
