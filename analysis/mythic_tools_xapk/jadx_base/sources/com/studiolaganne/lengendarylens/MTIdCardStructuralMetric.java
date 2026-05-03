package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardStructuralMetric;", "", "metric", "", "value", "", FirebaseAnalytics.Param.SCORE, "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V", "getMetric", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getScore", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTIdCardStructuralMetric;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardStructuralMetric {
    public static final int $stable = 0;
    private final String metric;
    private final Double score;
    private final Double value;

    public MTIdCardStructuralMetric() {
        this(null, null, null, 7, null);
    }

    public MTIdCardStructuralMetric(String str, Double d, Double d2) {
        this.metric = str;
        this.value = d;
        this.score = d2;
    }

    public /* synthetic */ MTIdCardStructuralMetric(String str, Double d, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : d2);
    }

    public static /* synthetic */ MTIdCardStructuralMetric copy$default(MTIdCardStructuralMetric mTIdCardStructuralMetric, String str, Double d, Double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardStructuralMetric.metric;
        }
        if ((i & 2) != 0) {
            d = mTIdCardStructuralMetric.value;
        }
        if ((i & 4) != 0) {
            d2 = mTIdCardStructuralMetric.score;
        }
        return mTIdCardStructuralMetric.copy(str, d, d2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMetric() {
        return this.metric;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getScore() {
        return this.score;
    }

    public final MTIdCardStructuralMetric copy(String metric, Double value, Double score) {
        return new MTIdCardStructuralMetric(metric, value, score);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardStructuralMetric)) {
            return false;
        }
        MTIdCardStructuralMetric mTIdCardStructuralMetric = (MTIdCardStructuralMetric) other;
        return Intrinsics.areEqual(this.metric, mTIdCardStructuralMetric.metric) && Intrinsics.areEqual((Object) this.value, (Object) mTIdCardStructuralMetric.value) && Intrinsics.areEqual((Object) this.score, (Object) mTIdCardStructuralMetric.score);
    }

    public final String getMetric() {
        return this.metric;
    }

    public final Double getScore() {
        return this.score;
    }

    public final Double getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.metric;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double d = this.value;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.score;
        return iHashCode2 + (d2 != null ? d2.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardStructuralMetric(metric=" + this.metric + ", value=" + this.value + ", score=" + this.score + ")";
    }
}
