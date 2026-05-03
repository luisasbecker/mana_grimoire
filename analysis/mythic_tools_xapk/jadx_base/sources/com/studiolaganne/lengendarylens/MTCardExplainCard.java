package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardExplainCard;", "", "name", "", "oracleId", "typeLine", "manaCost", "imageUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getOracleId", "getTypeLine", "getManaCost", "getImageUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardExplainCard {
    public static final int $stable = 0;
    private final String imageUrl;
    private final String manaCost;
    private final String name;
    private final String oracleId;
    private final String typeLine;

    public MTCardExplainCard() {
        this(null, null, null, null, null, 31, null);
    }

    public MTCardExplainCard(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.oracleId = str2;
        this.typeLine = str3;
        this.manaCost = str4;
        this.imageUrl = str5;
    }

    public /* synthetic */ MTCardExplainCard(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public static /* synthetic */ MTCardExplainCard copy$default(MTCardExplainCard mTCardExplainCard, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTCardExplainCard.name;
        }
        if ((i & 2) != 0) {
            str2 = mTCardExplainCard.oracleId;
        }
        if ((i & 4) != 0) {
            str3 = mTCardExplainCard.typeLine;
        }
        if ((i & 8) != 0) {
            str4 = mTCardExplainCard.manaCost;
        }
        if ((i & 16) != 0) {
            str5 = mTCardExplainCard.imageUrl;
        }
        String str6 = str5;
        String str7 = str3;
        return mTCardExplainCard.copy(str, str2, str7, str4, str6);
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
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final MTCardExplainCard copy(String name, String oracleId, String typeLine, String manaCost, String imageUrl) {
        return new MTCardExplainCard(name, oracleId, typeLine, manaCost, imageUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardExplainCard)) {
            return false;
        }
        MTCardExplainCard mTCardExplainCard = (MTCardExplainCard) other;
        return Intrinsics.areEqual(this.name, mTCardExplainCard.name) && Intrinsics.areEqual(this.oracleId, mTCardExplainCard.oracleId) && Intrinsics.areEqual(this.typeLine, mTCardExplainCard.typeLine) && Intrinsics.areEqual(this.manaCost, mTCardExplainCard.manaCost) && Intrinsics.areEqual(this.imageUrl, mTCardExplainCard.imageUrl);
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
        String str5 = this.imageUrl;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "MTCardExplainCard(name=" + this.name + ", oracleId=" + this.oracleId + ", typeLine=" + this.typeLine + ", manaCost=" + this.manaCost + ", imageUrl=" + this.imageUrl + ")";
    }
}
