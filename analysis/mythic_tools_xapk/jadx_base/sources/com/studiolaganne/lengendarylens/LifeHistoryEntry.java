package com.studiolaganne.lengendarylens;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LifeHistoryAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ$\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/LifeHistoryEntry;", "", "lifeTotal", "", TypedValues.CycleType.S_WAVE_OFFSET, "<init>", "(ILjava/lang/Integer;)V", "getLifeTotal", "()I", "setLifeTotal", "(I)V", "getOffset", "()Ljava/lang/Integer;", "setOffset", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ILjava/lang/Integer;)Lcom/studiolaganne/lengendarylens/LifeHistoryEntry;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LifeHistoryEntry {
    public static final int $stable = 8;
    private int lifeTotal;
    private Integer offset;

    public LifeHistoryEntry(int i, Integer num) {
        this.lifeTotal = i;
        this.offset = num;
    }

    public /* synthetic */ LifeHistoryEntry(int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : num);
    }

    public static /* synthetic */ LifeHistoryEntry copy$default(LifeHistoryEntry lifeHistoryEntry, int i, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = lifeHistoryEntry.lifeTotal;
        }
        if ((i2 & 2) != 0) {
            num = lifeHistoryEntry.offset;
        }
        return lifeHistoryEntry.copy(i, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLifeTotal() {
        return this.lifeTotal;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getOffset() {
        return this.offset;
    }

    public final LifeHistoryEntry copy(int lifeTotal, Integer offset) {
        return new LifeHistoryEntry(lifeTotal, offset);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LifeHistoryEntry)) {
            return false;
        }
        LifeHistoryEntry lifeHistoryEntry = (LifeHistoryEntry) other;
        return this.lifeTotal == lifeHistoryEntry.lifeTotal && Intrinsics.areEqual(this.offset, lifeHistoryEntry.offset);
    }

    public final int getLifeTotal() {
        return this.lifeTotal;
    }

    public final Integer getOffset() {
        return this.offset;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.lifeTotal) * 31;
        Integer num = this.offset;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public final void setLifeTotal(int i) {
        this.lifeTotal = i;
    }

    public final void setOffset(Integer num) {
        this.offset = num;
    }

    public String toString() {
        return "LifeHistoryEntry(lifeTotal=" + this.lifeTotal + ", offset=" + this.offset + ")";
    }
}
