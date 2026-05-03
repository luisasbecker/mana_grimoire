package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTManaCurveEntry;", "", "cmc", "", "total", "permanents", "spells", "<init>", "(IIII)V", "getCmc", "()I", "getTotal", "getPermanents", "getSpells", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTManaCurveEntry {
    public static final int $stable = 0;
    private final int cmc;
    private final int permanents;
    private final int spells;
    private final int total;

    public MTManaCurveEntry(int i, int i2, int i3, int i4) {
        this.cmc = i;
        this.total = i2;
        this.permanents = i3;
        this.spells = i4;
    }

    public static /* synthetic */ MTManaCurveEntry copy$default(MTManaCurveEntry mTManaCurveEntry, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = mTManaCurveEntry.cmc;
        }
        if ((i5 & 2) != 0) {
            i2 = mTManaCurveEntry.total;
        }
        if ((i5 & 4) != 0) {
            i3 = mTManaCurveEntry.permanents;
        }
        if ((i5 & 8) != 0) {
            i4 = mTManaCurveEntry.spells;
        }
        return mTManaCurveEntry.copy(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCmc() {
        return this.cmc;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPermanents() {
        return this.permanents;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSpells() {
        return this.spells;
    }

    public final MTManaCurveEntry copy(int cmc, int total, int permanents, int spells) {
        return new MTManaCurveEntry(cmc, total, permanents, spells);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTManaCurveEntry)) {
            return false;
        }
        MTManaCurveEntry mTManaCurveEntry = (MTManaCurveEntry) other;
        return this.cmc == mTManaCurveEntry.cmc && this.total == mTManaCurveEntry.total && this.permanents == mTManaCurveEntry.permanents && this.spells == mTManaCurveEntry.spells;
    }

    public final int getCmc() {
        return this.cmc;
    }

    public final int getPermanents() {
        return this.permanents;
    }

    public final int getSpells() {
        return this.spells;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.cmc) * 31) + Integer.hashCode(this.total)) * 31) + Integer.hashCode(this.permanents)) * 31) + Integer.hashCode(this.spells);
    }

    public String toString() {
        return "MTManaCurveEntry(cmc=" + this.cmc + ", total=" + this.total + ", permanents=" + this.permanents + ", spells=" + this.spells + ")";
    }
}
