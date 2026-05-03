package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015Jb\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardExplainReplacement;", "", "name", "", "oracleId", "typeLine", "manaCost", "oracleText", "imageUrl", "similarity", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getName", "()Ljava/lang/String;", "getOracleId", "getTypeLine", "getManaCost", "getOracleText", "getImageUrl", "getSimilarity", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTCardExplainReplacement;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardExplainReplacement {
    public static final int $stable = 0;
    private final String imageUrl;
    private final String manaCost;
    private final String name;
    private final String oracleId;
    private final String oracleText;
    private final Double similarity;
    private final String typeLine;

    public MTCardExplainReplacement() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public MTCardExplainReplacement(String str, String str2, String str3, String str4, String str5, String str6, Double d) {
        this.name = str;
        this.oracleId = str2;
        this.typeLine = str3;
        this.manaCost = str4;
        this.oracleText = str5;
        this.imageUrl = str6;
        this.similarity = d;
    }

    public /* synthetic */ MTCardExplainReplacement(String str, String str2, String str3, String str4, String str5, String str6, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : d);
    }

    public static /* synthetic */ MTCardExplainReplacement copy$default(MTCardExplainReplacement mTCardExplainReplacement, String str, String str2, String str3, String str4, String str5, String str6, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTCardExplainReplacement.name;
        }
        if ((i & 2) != 0) {
            str2 = mTCardExplainReplacement.oracleId;
        }
        if ((i & 4) != 0) {
            str3 = mTCardExplainReplacement.typeLine;
        }
        if ((i & 8) != 0) {
            str4 = mTCardExplainReplacement.manaCost;
        }
        if ((i & 16) != 0) {
            str5 = mTCardExplainReplacement.oracleText;
        }
        if ((i & 32) != 0) {
            str6 = mTCardExplainReplacement.imageUrl;
        }
        if ((i & 64) != 0) {
            d = mTCardExplainReplacement.similarity;
        }
        String str7 = str6;
        Double d2 = d;
        String str8 = str5;
        String str9 = str3;
        return mTCardExplainReplacement.copy(str, str2, str9, str4, str8, str7, d2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOracleId() {
        return this.oracleId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTypeLine() {
        return this.typeLine;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getManaCost() {
        return this.manaCost;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOracleText() {
        return this.oracleText;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getSimilarity() {
        return this.similarity;
    }

    public final MTCardExplainReplacement copy(String name, String oracleId, String typeLine, String manaCost, String oracleText, String imageUrl, Double similarity) {
        return new MTCardExplainReplacement(name, oracleId, typeLine, manaCost, oracleText, imageUrl, similarity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardExplainReplacement)) {
            return false;
        }
        MTCardExplainReplacement mTCardExplainReplacement = (MTCardExplainReplacement) other;
        return Intrinsics.areEqual(this.name, mTCardExplainReplacement.name) && Intrinsics.areEqual(this.oracleId, mTCardExplainReplacement.oracleId) && Intrinsics.areEqual(this.typeLine, mTCardExplainReplacement.typeLine) && Intrinsics.areEqual(this.manaCost, mTCardExplainReplacement.manaCost) && Intrinsics.areEqual(this.oracleText, mTCardExplainReplacement.oracleText) && Intrinsics.areEqual(this.imageUrl, mTCardExplainReplacement.imageUrl) && Intrinsics.areEqual((Object) this.similarity, (Object) mTCardExplainReplacement.similarity);
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getManaCost() {
        return this.manaCost;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOracleId() {
        return this.oracleId;
    }

    public final String getOracleText() {
        return this.oracleText;
    }

    public final Double getSimilarity() {
        return this.similarity;
    }

    public final String getTypeLine() {
        return this.typeLine;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.oracleId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.typeLine;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.manaCost;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.oracleText;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.imageUrl;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Double d = this.similarity;
        return iHashCode6 + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        return "MTCardExplainReplacement(name=" + this.name + ", oracleId=" + this.oracleId + ", typeLine=" + this.typeLine + ", manaCost=" + this.manaCost + ", oracleText=" + this.oracleText + ", imageUrl=" + this.imageUrl + ", similarity=" + this.similarity + ")";
    }
}
