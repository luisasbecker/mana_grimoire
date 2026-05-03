package com.studiolaganne.lengendarylens;

import androidx.camera.video.AudioStats;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTPriceDelta;", "", "amount", "", "percentage", "<init>", "(DD)V", "getAmount", "()D", "getPercentage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTPriceDelta {
    public static final int $stable = 0;
    private final double amount;
    private final double percentage;

    public MTPriceDelta() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 3, null);
    }

    public MTPriceDelta(double d, double d2) {
        this.amount = d;
        this.percentage = d2;
    }

    public /* synthetic */ MTPriceDelta(double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2);
    }

    public static /* synthetic */ MTPriceDelta copy$default(MTPriceDelta mTPriceDelta, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = mTPriceDelta.amount;
        }
        if ((i & 2) != 0) {
            d2 = mTPriceDelta.percentage;
        }
        return mTPriceDelta.copy(d, d2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getPercentage() {
        return this.percentage;
    }

    public final MTPriceDelta copy(double amount, double percentage) {
        return new MTPriceDelta(amount, percentage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTPriceDelta)) {
            return false;
        }
        MTPriceDelta mTPriceDelta = (MTPriceDelta) other;
        return Double.compare(this.amount, mTPriceDelta.amount) == 0 && Double.compare(this.percentage, mTPriceDelta.percentage) == 0;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final double getPercentage() {
        return this.percentage;
    }

    public int hashCode() {
        return (Double.hashCode(this.amount) * 31) + Double.hashCode(this.percentage);
    }

    public String toString() {
        return "MTPriceDelta(amount=" + this.amount + ", percentage=" + this.percentage + ")";
    }
}
