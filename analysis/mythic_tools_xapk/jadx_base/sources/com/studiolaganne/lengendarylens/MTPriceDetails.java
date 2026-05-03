package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTPriceDetails;", "", "average", "", "sources", "Lcom/studiolaganne/lengendarylens/MTPriceSources;", "<init>", "(Ljava/lang/Double;Lcom/studiolaganne/lengendarylens/MTPriceSources;)V", "getAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSources", "()Lcom/studiolaganne/lengendarylens/MTPriceSources;", "component1", "component2", "copy", "(Ljava/lang/Double;Lcom/studiolaganne/lengendarylens/MTPriceSources;)Lcom/studiolaganne/lengendarylens/MTPriceDetails;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTPriceDetails {
    public static final int $stable = 8;
    private final Double average;
    private final MTPriceSources sources;

    /* JADX WARN: Multi-variable type inference failed */
    public MTPriceDetails() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTPriceDetails(Double d, MTPriceSources mTPriceSources) {
        this.average = d;
        this.sources = mTPriceSources;
    }

    public /* synthetic */ MTPriceDetails(Double d, MTPriceSources mTPriceSources, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : mTPriceSources);
    }

    public static /* synthetic */ MTPriceDetails copy$default(MTPriceDetails mTPriceDetails, Double d, MTPriceSources mTPriceSources, int i, Object obj) {
        if ((i & 1) != 0) {
            d = mTPriceDetails.average;
        }
        if ((i & 2) != 0) {
            mTPriceSources = mTPriceDetails.sources;
        }
        return mTPriceDetails.copy(d, mTPriceSources);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getAverage() {
        return this.average;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTPriceSources getSources() {
        return this.sources;
    }

    public final MTPriceDetails copy(Double average, MTPriceSources sources) {
        return new MTPriceDetails(average, sources);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTPriceDetails)) {
            return false;
        }
        MTPriceDetails mTPriceDetails = (MTPriceDetails) other;
        return Intrinsics.areEqual((Object) this.average, (Object) mTPriceDetails.average) && Intrinsics.areEqual(this.sources, mTPriceDetails.sources);
    }

    public final Double getAverage() {
        return this.average;
    }

    public final MTPriceSources getSources() {
        return this.sources;
    }

    public int hashCode() {
        Double d = this.average;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        MTPriceSources mTPriceSources = this.sources;
        return iHashCode + (mTPriceSources != null ? mTPriceSources.hashCode() : 0);
    }

    public String toString() {
        return "MTPriceDetails(average=" + this.average + ", sources=" + this.sources + ")";
    }
}
