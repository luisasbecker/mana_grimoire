package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingSignal;", "", FirebaseAnalytics.Param.SCORE, "", "raw", Constants.ScionAnalytics.PARAM_LABEL, "", "<init>", "(IILjava/lang/String;)V", "getScore", "()I", "getRaw", "getLabel", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingSignal {
    public static final int $stable = 0;
    private final String label;
    private final int raw;
    private final int score;

    public MTCardRankingSignal() {
        this(0, 0, null, 7, null);
    }

    public MTCardRankingSignal(int i, int i2, String str) {
        this.score = i;
        this.raw = i2;
        this.label = str;
    }

    public /* synthetic */ MTCardRankingSignal(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : str);
    }

    public static /* synthetic */ MTCardRankingSignal copy$default(MTCardRankingSignal mTCardRankingSignal, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mTCardRankingSignal.score;
        }
        if ((i3 & 2) != 0) {
            i2 = mTCardRankingSignal.raw;
        }
        if ((i3 & 4) != 0) {
            str = mTCardRankingSignal.label;
        }
        return mTCardRankingSignal.copy(i, i2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRaw() {
        return this.raw;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public final MTCardRankingSignal copy(int score, int raw, String label) {
        return new MTCardRankingSignal(score, raw, label);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingSignal)) {
            return false;
        }
        MTCardRankingSignal mTCardRankingSignal = (MTCardRankingSignal) other;
        return this.score == mTCardRankingSignal.score && this.raw == mTCardRankingSignal.raw && Intrinsics.areEqual(this.label, mTCardRankingSignal.label);
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getRaw() {
        return this.raw;
    }

    public final int getScore() {
        return this.score;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.score) * 31) + Integer.hashCode(this.raw)) * 31;
        String str = this.label;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "MTCardRankingSignal(score=" + this.score + ", raw=" + this.raw + ", label=" + this.label + ")";
    }
}
