package com.studiolaganne.lengendarylens;

import androidx.camera.video.AudioStats;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018JN\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardsValue;", "", "average_price", "", "card_count", "", "delta", "Lcom/studiolaganne/lengendarylens/MTPriceDelta;", "last_updated", "", "total_value", FirebaseAnalytics.Event.PURCHASE, "<init>", "(DILcom/studiolaganne/lengendarylens/MTPriceDelta;Ljava/lang/String;DLjava/lang/Double;)V", "getAverage_price", "()D", "getCard_count", "()I", "getDelta", "()Lcom/studiolaganne/lengendarylens/MTPriceDelta;", "getLast_updated", "()Ljava/lang/String;", "getTotal_value", "getPurchase", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(DILcom/studiolaganne/lengendarylens/MTPriceDelta;Ljava/lang/String;DLjava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTCardsValue;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardsValue {
    public static final int $stable = 0;
    private final double average_price;
    private final int card_count;
    private final MTPriceDelta delta;
    private final String last_updated;
    private final Double purchase;
    private final double total_value;

    public MTCardsValue() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, 0, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, null, 63, null);
    }

    public MTCardsValue(double d, int i, MTPriceDelta mTPriceDelta, String last_updated, double d2, Double d3) {
        Intrinsics.checkNotNullParameter(last_updated, "last_updated");
        this.average_price = d;
        this.card_count = i;
        this.delta = mTPriceDelta;
        this.last_updated = last_updated;
        this.total_value = d2;
        this.purchase = d3;
    }

    public /* synthetic */ MTCardsValue(double d, int i, MTPriceDelta mTPriceDelta, String str, double d2, Double d3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0d : d, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : mTPriceDelta, (i2 & 8) != 0 ? "" : str, (i2 & 16) != 0 ? 0.0d : d2, (i2 & 32) != 0 ? null : d3);
    }

    public static /* synthetic */ MTCardsValue copy$default(MTCardsValue mTCardsValue, double d, int i, MTPriceDelta mTPriceDelta, String str, double d2, Double d3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d = mTCardsValue.average_price;
        }
        double d4 = d;
        if ((i2 & 2) != 0) {
            i = mTCardsValue.card_count;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            mTPriceDelta = mTCardsValue.delta;
        }
        MTPriceDelta mTPriceDelta2 = mTPriceDelta;
        if ((i2 & 8) != 0) {
            str = mTCardsValue.last_updated;
        }
        return mTCardsValue.copy(d4, i3, mTPriceDelta2, str, (i2 & 16) != 0 ? mTCardsValue.total_value : d2, (i2 & 32) != 0 ? mTCardsValue.purchase : d3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getAverage_price() {
        return this.average_price;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCard_count() {
        return this.card_count;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTPriceDelta getDelta() {
        return this.delta;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLast_updated() {
        return this.last_updated;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final double getTotal_value() {
        return this.total_value;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Double getPurchase() {
        return this.purchase;
    }

    public final MTCardsValue copy(double average_price, int card_count, MTPriceDelta delta, String last_updated, double total_value, Double purchase) {
        Intrinsics.checkNotNullParameter(last_updated, "last_updated");
        return new MTCardsValue(average_price, card_count, delta, last_updated, total_value, purchase);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardsValue)) {
            return false;
        }
        MTCardsValue mTCardsValue = (MTCardsValue) other;
        return Double.compare(this.average_price, mTCardsValue.average_price) == 0 && this.card_count == mTCardsValue.card_count && Intrinsics.areEqual(this.delta, mTCardsValue.delta) && Intrinsics.areEqual(this.last_updated, mTCardsValue.last_updated) && Double.compare(this.total_value, mTCardsValue.total_value) == 0 && Intrinsics.areEqual((Object) this.purchase, (Object) mTCardsValue.purchase);
    }

    public final double getAverage_price() {
        return this.average_price;
    }

    public final int getCard_count() {
        return this.card_count;
    }

    public final MTPriceDelta getDelta() {
        return this.delta;
    }

    public final String getLast_updated() {
        return this.last_updated;
    }

    public final Double getPurchase() {
        return this.purchase;
    }

    public final double getTotal_value() {
        return this.total_value;
    }

    public int hashCode() {
        int iHashCode = ((Double.hashCode(this.average_price) * 31) + Integer.hashCode(this.card_count)) * 31;
        MTPriceDelta mTPriceDelta = this.delta;
        int iHashCode2 = (((((iHashCode + (mTPriceDelta == null ? 0 : mTPriceDelta.hashCode())) * 31) + this.last_updated.hashCode()) * 31) + Double.hashCode(this.total_value)) * 31;
        Double d = this.purchase;
        return iHashCode2 + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        return "MTCardsValue(average_price=" + this.average_price + ", card_count=" + this.card_count + ", delta=" + this.delta + ", last_updated=" + this.last_updated + ", total_value=" + this.total_value + ", purchase=" + this.purchase + ")";
    }
}
