package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardTapLandEntry;", "", "name", "", "oracleId", "category", "tapChance", "", "detectionMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getOracleId", "getCategory", "getTapChance", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDetectionMethod", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTIdCardTapLandEntry;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardTapLandEntry {
    public static final int $stable = 0;
    private final String category;
    private final String detectionMethod;
    private final String name;
    private final String oracleId;
    private final Double tapChance;

    public MTIdCardTapLandEntry() {
        this(null, null, null, null, null, 31, null);
    }

    public MTIdCardTapLandEntry(String str, String str2, String str3, Double d, String str4) {
        this.name = str;
        this.oracleId = str2;
        this.category = str3;
        this.tapChance = d;
        this.detectionMethod = str4;
    }

    public /* synthetic */ MTIdCardTapLandEntry(String str, String str2, String str3, Double d, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : d, (i & 16) != 0 ? null : str4);
    }

    public static /* synthetic */ MTIdCardTapLandEntry copy$default(MTIdCardTapLandEntry mTIdCardTapLandEntry, String str, String str2, String str3, Double d, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardTapLandEntry.name;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardTapLandEntry.oracleId;
        }
        if ((i & 4) != 0) {
            str3 = mTIdCardTapLandEntry.category;
        }
        if ((i & 8) != 0) {
            d = mTIdCardTapLandEntry.tapChance;
        }
        if ((i & 16) != 0) {
            str4 = mTIdCardTapLandEntry.detectionMethod;
        }
        String str5 = str4;
        String str6 = str3;
        return mTIdCardTapLandEntry.copy(str, str2, str6, d, str5);
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
    public final String getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getTapChance() {
        return this.tapChance;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDetectionMethod() {
        return this.detectionMethod;
    }

    public final MTIdCardTapLandEntry copy(String name, String oracleId, String category, Double tapChance, String detectionMethod) {
        return new MTIdCardTapLandEntry(name, oracleId, category, tapChance, detectionMethod);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardTapLandEntry)) {
            return false;
        }
        MTIdCardTapLandEntry mTIdCardTapLandEntry = (MTIdCardTapLandEntry) other;
        return Intrinsics.areEqual(this.name, mTIdCardTapLandEntry.name) && Intrinsics.areEqual(this.oracleId, mTIdCardTapLandEntry.oracleId) && Intrinsics.areEqual(this.category, mTIdCardTapLandEntry.category) && Intrinsics.areEqual((Object) this.tapChance, (Object) mTIdCardTapLandEntry.tapChance) && Intrinsics.areEqual(this.detectionMethod, mTIdCardTapLandEntry.detectionMethod);
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getDetectionMethod() {
        return this.detectionMethod;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOracleId() {
        return this.oracleId;
    }

    public final Double getTapChance() {
        return this.tapChance;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.oracleId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.category;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Double d = this.tapChance;
        int iHashCode4 = (iHashCode3 + (d == null ? 0 : d.hashCode())) * 31;
        String str4 = this.detectionMethod;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardTapLandEntry(name=" + this.name + ", oracleId=" + this.oracleId + ", category=" + this.category + ", tapChance=" + this.tapChance + ", detectionMethod=" + this.detectionMethod + ")";
    }
}
