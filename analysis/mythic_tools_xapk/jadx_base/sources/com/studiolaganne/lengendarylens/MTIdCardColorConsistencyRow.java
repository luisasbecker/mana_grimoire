package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardColorConsistencyRow;", "", "color", "", "symbol", "required", "", "sources", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getSymbol", "getRequired", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSources", "getStatus", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTIdCardColorConsistencyRow;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardColorConsistencyRow {
    public static final int $stable = 0;
    private final String color;
    private final Double required;
    private final Double sources;
    private final String status;
    private final String symbol;

    public MTIdCardColorConsistencyRow() {
        this(null, null, null, null, null, 31, null);
    }

    public MTIdCardColorConsistencyRow(String str, String str2, Double d, Double d2, String str3) {
        this.color = str;
        this.symbol = str2;
        this.required = d;
        this.sources = d2;
        this.status = str3;
    }

    public /* synthetic */ MTIdCardColorConsistencyRow(String str, String str2, Double d, Double d2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : d2, (i & 16) != 0 ? null : str3);
    }

    public static /* synthetic */ MTIdCardColorConsistencyRow copy$default(MTIdCardColorConsistencyRow mTIdCardColorConsistencyRow, String str, String str2, Double d, Double d2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardColorConsistencyRow.color;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardColorConsistencyRow.symbol;
        }
        if ((i & 4) != 0) {
            d = mTIdCardColorConsistencyRow.required;
        }
        if ((i & 8) != 0) {
            d2 = mTIdCardColorConsistencyRow.sources;
        }
        if ((i & 16) != 0) {
            str3 = mTIdCardColorConsistencyRow.status;
        }
        String str4 = str3;
        Double d3 = d;
        return mTIdCardColorConsistencyRow.copy(str, str2, d3, d2, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSymbol() {
        return this.symbol;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getRequired() {
        return this.required;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getSources() {
        return this.sources;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final MTIdCardColorConsistencyRow copy(String color, String symbol, Double required, Double sources, String status) {
        return new MTIdCardColorConsistencyRow(color, symbol, required, sources, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardColorConsistencyRow)) {
            return false;
        }
        MTIdCardColorConsistencyRow mTIdCardColorConsistencyRow = (MTIdCardColorConsistencyRow) other;
        return Intrinsics.areEqual(this.color, mTIdCardColorConsistencyRow.color) && Intrinsics.areEqual(this.symbol, mTIdCardColorConsistencyRow.symbol) && Intrinsics.areEqual((Object) this.required, (Object) mTIdCardColorConsistencyRow.required) && Intrinsics.areEqual((Object) this.sources, (Object) mTIdCardColorConsistencyRow.sources) && Intrinsics.areEqual(this.status, mTIdCardColorConsistencyRow.status);
    }

    public final String getColor() {
        return this.color;
    }

    public final Double getRequired() {
        return this.required;
    }

    public final Double getSources() {
        return this.sources;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String str = this.color;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.symbol;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d = this.required;
        int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.sources;
        int iHashCode4 = (iHashCode3 + (d2 == null ? 0 : d2.hashCode())) * 31;
        String str3 = this.status;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardColorConsistencyRow(color=" + this.color + ", symbol=" + this.symbol + ", required=" + this.required + ", sources=" + this.sources + ", status=" + this.status + ")";
    }
}
