package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTManaCostProductionEntry;", "", "color", "", "costs", "Lcom/studiolaganne/lengendarylens/MTProductionEntry;", "production", "<init>", "(Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTProductionEntry;Lcom/studiolaganne/lengendarylens/MTProductionEntry;)V", "getColor", "()Ljava/lang/String;", "getCosts", "()Lcom/studiolaganne/lengendarylens/MTProductionEntry;", "getProduction", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTManaCostProductionEntry {
    public static final int $stable = 0;
    private final String color;
    private final MTProductionEntry costs;
    private final MTProductionEntry production;

    public MTManaCostProductionEntry(String color, MTProductionEntry mTProductionEntry, MTProductionEntry mTProductionEntry2) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.color = color;
        this.costs = mTProductionEntry;
        this.production = mTProductionEntry2;
    }

    public /* synthetic */ MTManaCostProductionEntry(String str, MTProductionEntry mTProductionEntry, MTProductionEntry mTProductionEntry2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : mTProductionEntry, (i & 4) != 0 ? null : mTProductionEntry2);
    }

    public static /* synthetic */ MTManaCostProductionEntry copy$default(MTManaCostProductionEntry mTManaCostProductionEntry, String str, MTProductionEntry mTProductionEntry, MTProductionEntry mTProductionEntry2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTManaCostProductionEntry.color;
        }
        if ((i & 2) != 0) {
            mTProductionEntry = mTManaCostProductionEntry.costs;
        }
        if ((i & 4) != 0) {
            mTProductionEntry2 = mTManaCostProductionEntry.production;
        }
        return mTManaCostProductionEntry.copy(str, mTProductionEntry, mTProductionEntry2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTProductionEntry getCosts() {
        return this.costs;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTProductionEntry getProduction() {
        return this.production;
    }

    public final MTManaCostProductionEntry copy(String color, MTProductionEntry costs, MTProductionEntry production) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new MTManaCostProductionEntry(color, costs, production);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTManaCostProductionEntry)) {
            return false;
        }
        MTManaCostProductionEntry mTManaCostProductionEntry = (MTManaCostProductionEntry) other;
        return Intrinsics.areEqual(this.color, mTManaCostProductionEntry.color) && Intrinsics.areEqual(this.costs, mTManaCostProductionEntry.costs) && Intrinsics.areEqual(this.production, mTManaCostProductionEntry.production);
    }

    public final String getColor() {
        return this.color;
    }

    public final MTProductionEntry getCosts() {
        return this.costs;
    }

    public final MTProductionEntry getProduction() {
        return this.production;
    }

    public int hashCode() {
        int iHashCode = this.color.hashCode() * 31;
        MTProductionEntry mTProductionEntry = this.costs;
        int iHashCode2 = (iHashCode + (mTProductionEntry == null ? 0 : mTProductionEntry.hashCode())) * 31;
        MTProductionEntry mTProductionEntry2 = this.production;
        return iHashCode2 + (mTProductionEntry2 != null ? mTProductionEntry2.hashCode() : 0);
    }

    public String toString() {
        return "MTManaCostProductionEntry(color=" + this.color + ", costs=" + this.costs + ", production=" + this.production + ")";
    }
}
