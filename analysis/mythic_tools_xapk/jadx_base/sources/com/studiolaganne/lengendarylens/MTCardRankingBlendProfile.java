package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingBlendProfile;", "", "weights", "Lcom/studiolaganne/lengendarylens/MTCardRankingBlendWeights;", "powerScore", "", "<init>", "(Lcom/studiolaganne/lengendarylens/MTCardRankingBlendWeights;Ljava/lang/Integer;)V", "getWeights", "()Lcom/studiolaganne/lengendarylens/MTCardRankingBlendWeights;", "getPowerScore", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Lcom/studiolaganne/lengendarylens/MTCardRankingBlendWeights;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTCardRankingBlendProfile;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingBlendProfile {
    public static final int $stable = 0;
    private final Integer powerScore;
    private final MTCardRankingBlendWeights weights;

    /* JADX WARN: Multi-variable type inference failed */
    public MTCardRankingBlendProfile() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTCardRankingBlendProfile(MTCardRankingBlendWeights mTCardRankingBlendWeights, Integer num) {
        this.weights = mTCardRankingBlendWeights;
        this.powerScore = num;
    }

    public /* synthetic */ MTCardRankingBlendProfile(MTCardRankingBlendWeights mTCardRankingBlendWeights, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTCardRankingBlendWeights, (i & 2) != 0 ? null : num);
    }

    public static /* synthetic */ MTCardRankingBlendProfile copy$default(MTCardRankingBlendProfile mTCardRankingBlendProfile, MTCardRankingBlendWeights mTCardRankingBlendWeights, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            mTCardRankingBlendWeights = mTCardRankingBlendProfile.weights;
        }
        if ((i & 2) != 0) {
            num = mTCardRankingBlendProfile.powerScore;
        }
        return mTCardRankingBlendProfile.copy(mTCardRankingBlendWeights, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTCardRankingBlendWeights getWeights() {
        return this.weights;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getPowerScore() {
        return this.powerScore;
    }

    public final MTCardRankingBlendProfile copy(MTCardRankingBlendWeights weights, Integer powerScore) {
        return new MTCardRankingBlendProfile(weights, powerScore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingBlendProfile)) {
            return false;
        }
        MTCardRankingBlendProfile mTCardRankingBlendProfile = (MTCardRankingBlendProfile) other;
        return Intrinsics.areEqual(this.weights, mTCardRankingBlendProfile.weights) && Intrinsics.areEqual(this.powerScore, mTCardRankingBlendProfile.powerScore);
    }

    public final Integer getPowerScore() {
        return this.powerScore;
    }

    public final MTCardRankingBlendWeights getWeights() {
        return this.weights;
    }

    public int hashCode() {
        MTCardRankingBlendWeights mTCardRankingBlendWeights = this.weights;
        int iHashCode = (mTCardRankingBlendWeights == null ? 0 : mTCardRankingBlendWeights.hashCode()) * 31;
        Integer num = this.powerScore;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "MTCardRankingBlendProfile(weights=" + this.weights + ", powerScore=" + this.powerScore + ")";
    }
}
