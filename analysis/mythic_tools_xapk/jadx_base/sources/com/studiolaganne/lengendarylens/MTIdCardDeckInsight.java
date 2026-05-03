package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003JW\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardDeckInsight;", "", "id", "", "tier", "rationale", "rationaleEn", "rationaleFr", "cards", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getTier", "getRationale", "getRationaleEn", "getRationaleFr", "getCards", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardDeckInsight {
    public static final int $stable = 8;
    private final List<String> cards;
    private final String id;
    private final String rationale;

    @SerializedName("rationale_en")
    private final String rationaleEn;

    @SerializedName("rationale_fr")
    private final String rationaleFr;
    private final String tier;

    public MTIdCardDeckInsight() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MTIdCardDeckInsight(String str, String str2, String str3, String str4, String str5, List<String> list) {
        this.id = str;
        this.tier = str2;
        this.rationale = str3;
        this.rationaleEn = str4;
        this.rationaleFr = str5;
        this.cards = list;
    }

    public /* synthetic */ MTIdCardDeckInsight(String str, String str2, String str3, String str4, String str5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardDeckInsight copy$default(MTIdCardDeckInsight mTIdCardDeckInsight, String str, String str2, String str3, String str4, String str5, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardDeckInsight.id;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardDeckInsight.tier;
        }
        if ((i & 4) != 0) {
            str3 = mTIdCardDeckInsight.rationale;
        }
        if ((i & 8) != 0) {
            str4 = mTIdCardDeckInsight.rationaleEn;
        }
        if ((i & 16) != 0) {
            str5 = mTIdCardDeckInsight.rationaleFr;
        }
        if ((i & 32) != 0) {
            list = mTIdCardDeckInsight.cards;
        }
        String str6 = str5;
        List list2 = list;
        return mTIdCardDeckInsight.copy(str, str2, str3, str4, str6, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTier() {
        return this.tier;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRationale() {
        return this.rationale;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRationaleEn() {
        return this.rationaleEn;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRationaleFr() {
        return this.rationaleFr;
    }

    public final List<String> component6() {
        return this.cards;
    }

    public final MTIdCardDeckInsight copy(String id, String tier, String rationale, String rationaleEn, String rationaleFr, List<String> cards) {
        return new MTIdCardDeckInsight(id, tier, rationale, rationaleEn, rationaleFr, cards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardDeckInsight)) {
            return false;
        }
        MTIdCardDeckInsight mTIdCardDeckInsight = (MTIdCardDeckInsight) other;
        return Intrinsics.areEqual(this.id, mTIdCardDeckInsight.id) && Intrinsics.areEqual(this.tier, mTIdCardDeckInsight.tier) && Intrinsics.areEqual(this.rationale, mTIdCardDeckInsight.rationale) && Intrinsics.areEqual(this.rationaleEn, mTIdCardDeckInsight.rationaleEn) && Intrinsics.areEqual(this.rationaleFr, mTIdCardDeckInsight.rationaleFr) && Intrinsics.areEqual(this.cards, mTIdCardDeckInsight.cards);
    }

    public final List<String> getCards() {
        return this.cards;
    }

    public final String getId() {
        return this.id;
    }

    public final String getRationale() {
        return this.rationale;
    }

    public final String getRationaleEn() {
        return this.rationaleEn;
    }

    public final String getRationaleFr() {
        return this.rationaleFr;
    }

    public final String getTier() {
        return this.tier;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.tier;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.rationale;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.rationaleEn;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.rationaleFr;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<String> list = this.cards;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardDeckInsight(id=" + this.id + ", tier=" + this.tier + ", rationale=" + this.rationale + ", rationaleEn=" + this.rationaleEn + ", rationaleFr=" + this.rationaleFr + ", cards=" + this.cards + ")";
    }
}
