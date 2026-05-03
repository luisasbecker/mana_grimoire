package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTPriceEntry;", "", "average", "", "<init>", "(Ljava/lang/Double;)V", "getAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "copy", "(Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTPriceEntry;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTPriceEntry {
    public static final int $stable = 0;
    private final Double average;

    /* JADX WARN: Multi-variable type inference failed */
    public MTPriceEntry() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MTPriceEntry(Double d) {
        this.average = d;
    }

    public /* synthetic */ MTPriceEntry(Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d);
    }

    public static /* synthetic */ MTPriceEntry copy$default(MTPriceEntry mTPriceEntry, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            d = mTPriceEntry.average;
        }
        return mTPriceEntry.copy(d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getAverage() {
        return this.average;
    }

    public final MTPriceEntry copy(Double average) {
        return new MTPriceEntry(average);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTPriceEntry) && Intrinsics.areEqual((Object) this.average, (Object) ((MTPriceEntry) other).average);
    }

    public final Double getAverage() {
        return this.average;
    }

    public int hashCode() {
        Double d = this.average;
        if (d == null) {
            return 0;
        }
        return d.hashCode();
    }

    public String toString() {
        return "MTPriceEntry(average=" + this.average + ")";
    }
}
