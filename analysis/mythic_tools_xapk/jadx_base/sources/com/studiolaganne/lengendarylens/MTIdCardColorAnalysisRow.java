package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006)"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardColorAnalysisRow;", "", "color", "", "colorSymbol", "costPips", "", "productionSources", "costProportion", "productionProportion", "imbalance", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getColorSymbol", "getCostPips", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getProductionSources", "getCostProportion", "getProductionProportion", "getImbalance", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTIdCardColorAnalysisRow;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardColorAnalysisRow {
    public static final int $stable = 0;
    private final String color;
    private final String colorSymbol;
    private final Double costPips;
    private final Double costProportion;
    private final Double imbalance;
    private final Double productionProportion;
    private final Double productionSources;
    private final String status;

    public MTIdCardColorAnalysisRow() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public MTIdCardColorAnalysisRow(String str, String str2, Double d, Double d2, Double d3, Double d4, Double d5, String str3) {
        this.color = str;
        this.colorSymbol = str2;
        this.costPips = d;
        this.productionSources = d2;
        this.costProportion = d3;
        this.productionProportion = d4;
        this.imbalance = d5;
        this.status = str3;
    }

    public /* synthetic */ MTIdCardColorAnalysisRow(String str, String str2, Double d, Double d2, Double d3, Double d4, Double d5, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : d2, (i & 16) != 0 ? null : d3, (i & 32) != 0 ? null : d4, (i & 64) != 0 ? null : d5, (i & 128) != 0 ? null : str3);
    }

    public static /* synthetic */ MTIdCardColorAnalysisRow copy$default(MTIdCardColorAnalysisRow mTIdCardColorAnalysisRow, String str, String str2, Double d, Double d2, Double d3, Double d4, Double d5, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardColorAnalysisRow.color;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardColorAnalysisRow.colorSymbol;
        }
        if ((i & 4) != 0) {
            d = mTIdCardColorAnalysisRow.costPips;
        }
        if ((i & 8) != 0) {
            d2 = mTIdCardColorAnalysisRow.productionSources;
        }
        if ((i & 16) != 0) {
            d3 = mTIdCardColorAnalysisRow.costProportion;
        }
        if ((i & 32) != 0) {
            d4 = mTIdCardColorAnalysisRow.productionProportion;
        }
        if ((i & 64) != 0) {
            d5 = mTIdCardColorAnalysisRow.imbalance;
        }
        if ((i & 128) != 0) {
            str3 = mTIdCardColorAnalysisRow.status;
        }
        Double d6 = d5;
        String str4 = str3;
        Double d7 = d3;
        Double d8 = d4;
        return mTIdCardColorAnalysisRow.copy(str, str2, d, d2, d7, d8, d6, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getColorSymbol() {
        return this.colorSymbol;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getCostPips() {
        return this.costPips;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getProductionSources() {
        return this.productionSources;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getCostProportion() {
        return this.costProportion;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Double getProductionProportion() {
        return this.productionProportion;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getImbalance() {
        return this.imbalance;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final MTIdCardColorAnalysisRow copy(String color, String colorSymbol, Double costPips, Double productionSources, Double costProportion, Double productionProportion, Double imbalance, String status) {
        return new MTIdCardColorAnalysisRow(color, colorSymbol, costPips, productionSources, costProportion, productionProportion, imbalance, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardColorAnalysisRow)) {
            return false;
        }
        MTIdCardColorAnalysisRow mTIdCardColorAnalysisRow = (MTIdCardColorAnalysisRow) other;
        return Intrinsics.areEqual(this.color, mTIdCardColorAnalysisRow.color) && Intrinsics.areEqual(this.colorSymbol, mTIdCardColorAnalysisRow.colorSymbol) && Intrinsics.areEqual((Object) this.costPips, (Object) mTIdCardColorAnalysisRow.costPips) && Intrinsics.areEqual((Object) this.productionSources, (Object) mTIdCardColorAnalysisRow.productionSources) && Intrinsics.areEqual((Object) this.costProportion, (Object) mTIdCardColorAnalysisRow.costProportion) && Intrinsics.areEqual((Object) this.productionProportion, (Object) mTIdCardColorAnalysisRow.productionProportion) && Intrinsics.areEqual((Object) this.imbalance, (Object) mTIdCardColorAnalysisRow.imbalance) && Intrinsics.areEqual(this.status, mTIdCardColorAnalysisRow.status);
    }

    public final String getColor() {
        return this.color;
    }

    public final String getColorSymbol() {
        return this.colorSymbol;
    }

    public final Double getCostPips() {
        return this.costPips;
    }

    public final Double getCostProportion() {
        return this.costProportion;
    }

    public final Double getImbalance() {
        return this.imbalance;
    }

    public final Double getProductionProportion() {
        return this.productionProportion;
    }

    public final Double getProductionSources() {
        return this.productionSources;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.color;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.colorSymbol;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d = this.costPips;
        int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.productionSources;
        int iHashCode4 = (iHashCode3 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.costProportion;
        int iHashCode5 = (iHashCode4 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Double d4 = this.productionProportion;
        int iHashCode6 = (iHashCode5 + (d4 == null ? 0 : d4.hashCode())) * 31;
        Double d5 = this.imbalance;
        int iHashCode7 = (iHashCode6 + (d5 == null ? 0 : d5.hashCode())) * 31;
        String str3 = this.status;
        return iHashCode7 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardColorAnalysisRow(color=" + this.color + ", colorSymbol=" + this.colorSymbol + ", costPips=" + this.costPips + ", productionSources=" + this.productionSources + ", costProportion=" + this.costProportion + ", productionProportion=" + this.productionProportion + ", imbalance=" + this.imbalance + ", status=" + this.status + ")";
    }
}
