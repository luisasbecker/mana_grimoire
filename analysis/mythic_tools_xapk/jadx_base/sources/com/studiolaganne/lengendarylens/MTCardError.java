package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\bHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardError;", "", "cardid", "", "oracle_id", "name", "type_line", "total_quantity", "", "max_allowed", "legality", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getCardid", "()Ljava/lang/String;", "getOracle_id", "getName", "getType_line", "getTotal_quantity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMax_allowed", "getLegality", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTCardError;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardError {
    public static final int $stable = 0;
    private final String cardid;
    private final String legality;
    private final Integer max_allowed;
    private final String name;
    private final String oracle_id;
    private final Integer total_quantity;
    private final String type_line;

    public MTCardError() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public MTCardError(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5) {
        this.cardid = str;
        this.oracle_id = str2;
        this.name = str3;
        this.type_line = str4;
        this.total_quantity = num;
        this.max_allowed = num2;
        this.legality = str5;
    }

    public /* synthetic */ MTCardError(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str5);
    }

    public static /* synthetic */ MTCardError copy$default(MTCardError mTCardError, String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTCardError.cardid;
        }
        if ((i & 2) != 0) {
            str2 = mTCardError.oracle_id;
        }
        if ((i & 4) != 0) {
            str3 = mTCardError.name;
        }
        if ((i & 8) != 0) {
            str4 = mTCardError.type_line;
        }
        if ((i & 16) != 0) {
            num = mTCardError.total_quantity;
        }
        if ((i & 32) != 0) {
            num2 = mTCardError.max_allowed;
        }
        if ((i & 64) != 0) {
            str5 = mTCardError.legality;
        }
        Integer num3 = num2;
        String str6 = str5;
        Integer num4 = num;
        String str7 = str3;
        return mTCardError.copy(str, str2, str7, str4, num4, num3, str6);
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
    public final String getType_line() {
        return this.type_line;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getTotal_quantity() {
        return this.total_quantity;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getMax_allowed() {
        return this.max_allowed;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLegality() {
        return this.legality;
    }

    public final MTCardError copy(String cardid, String oracle_id, String name, String type_line, Integer total_quantity, Integer max_allowed, String legality) {
        return new MTCardError(cardid, oracle_id, name, type_line, total_quantity, max_allowed, legality);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardError)) {
            return false;
        }
        MTCardError mTCardError = (MTCardError) other;
        return Intrinsics.areEqual(this.cardid, mTCardError.cardid) && Intrinsics.areEqual(this.oracle_id, mTCardError.oracle_id) && Intrinsics.areEqual(this.name, mTCardError.name) && Intrinsics.areEqual(this.type_line, mTCardError.type_line) && Intrinsics.areEqual(this.total_quantity, mTCardError.total_quantity) && Intrinsics.areEqual(this.max_allowed, mTCardError.max_allowed) && Intrinsics.areEqual(this.legality, mTCardError.legality);
    }

    public final String getCardid() {
        return this.cardid;
    }

    public final String getLegality() {
        return this.legality;
    }

    public final Integer getMax_allowed() {
        return this.max_allowed;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOracle_id() {
        return this.oracle_id;
    }

    public final Integer getTotal_quantity() {
        return this.total_quantity;
    }

    public final String getType_line() {
        return this.type_line;
    }

    public int hashCode() {
        String str = this.cardid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.oracle_id;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.type_line;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.total_quantity;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.max_allowed;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.legality;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "MTCardError(cardid=" + this.cardid + ", oracle_id=" + this.oracle_id + ", name=" + this.name + ", type_line=" + this.type_line + ", total_quantity=" + this.total_quantity + ", max_allowed=" + this.max_allowed + ", legality=" + this.legality + ")";
    }
}
