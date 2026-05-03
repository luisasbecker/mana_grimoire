package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingCardPower;", "", FirebaseAnalytics.Param.SCORE, "", "rawWeight", "", Constants.ScionAnalytics.PARAM_LABEL, "", "<init>", "(ILjava/lang/Double;Ljava/lang/String;)V", "getScore", "()I", "getRawWeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLabel", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(ILjava/lang/Double;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/MTCardRankingCardPower;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingCardPower {
    public static final int $stable = 0;
    private final String label;
    private final Double rawWeight;
    private final int score;

    public MTCardRankingCardPower() {
        this(0, null, null, 7, null);
    }

    public MTCardRankingCardPower(int i, Double d, String str) {
        this.score = i;
        this.rawWeight = d;
        this.label = str;
    }

    public /* synthetic */ MTCardRankingCardPower(int i, Double d, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : d, (i2 & 4) != 0 ? null : str);
    }

    public static /* synthetic */ MTCardRankingCardPower copy$default(MTCardRankingCardPower mTCardRankingCardPower, int i, Double d, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTCardRankingCardPower.score;
        }
        if ((i2 & 2) != 0) {
            d = mTCardRankingCardPower.rawWeight;
        }
        if ((i2 & 4) != 0) {
            str = mTCardRankingCardPower.label;
        }
        return mTCardRankingCardPower.copy(i, d, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getRawWeight() {
        return this.rawWeight;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public final MTCardRankingCardPower copy(int score, Double rawWeight, String label) {
        return new MTCardRankingCardPower(score, rawWeight, label);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingCardPower)) {
            return false;
        }
        MTCardRankingCardPower mTCardRankingCardPower = (MTCardRankingCardPower) other;
        return this.score == mTCardRankingCardPower.score && Intrinsics.areEqual((Object) this.rawWeight, (Object) mTCardRankingCardPower.rawWeight) && Intrinsics.areEqual(this.label, mTCardRankingCardPower.label);
    }

    public final String getLabel() {
        return this.label;
    }

    public final Double getRawWeight() {
        return this.rawWeight;
    }

    public final int getScore() {
        return this.score;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.score) * 31;
        Double d = this.rawWeight;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        String str = this.label;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "MTCardRankingCardPower(score=" + this.score + ", rawWeight=" + this.rawWeight + ", label=" + this.label + ")";
    }
}
