package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingRedundancy;", "", FirebaseAnalytics.Param.SCORE, "", "isRedundant", "", "factors", "", "Lcom/studiolaganne/lengendarylens/MTCardRankingRedundancyFactor;", "<init>", "(IZLjava/util/List;)V", "getScore", "()I", "()Z", "getFactors", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingRedundancy {
    public static final int $stable = 8;
    private final List<MTCardRankingRedundancyFactor> factors;
    private final boolean isRedundant;
    private final int score;

    public MTCardRankingRedundancy() {
        this(0, false, null, 7, null);
    }

    public MTCardRankingRedundancy(int i, boolean z, List<MTCardRankingRedundancyFactor> factors) {
        Intrinsics.checkNotNullParameter(factors, "factors");
        this.score = i;
        this.isRedundant = z;
        this.factors = factors;
    }

    public /* synthetic */ MTCardRankingRedundancy(int i, boolean z, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardRankingRedundancy copy$default(MTCardRankingRedundancy mTCardRankingRedundancy, int i, boolean z, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTCardRankingRedundancy.score;
        }
        if ((i2 & 2) != 0) {
            z = mTCardRankingRedundancy.isRedundant;
        }
        if ((i2 & 4) != 0) {
            list = mTCardRankingRedundancy.factors;
        }
        return mTCardRankingRedundancy.copy(i, z, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsRedundant() {
        return this.isRedundant;
    }

    public final List<MTCardRankingRedundancyFactor> component3() {
        return this.factors;
    }

    public final MTCardRankingRedundancy copy(int score, boolean isRedundant, List<MTCardRankingRedundancyFactor> factors) {
        Intrinsics.checkNotNullParameter(factors, "factors");
        return new MTCardRankingRedundancy(score, isRedundant, factors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingRedundancy)) {
            return false;
        }
        MTCardRankingRedundancy mTCardRankingRedundancy = (MTCardRankingRedundancy) other;
        return this.score == mTCardRankingRedundancy.score && this.isRedundant == mTCardRankingRedundancy.isRedundant && Intrinsics.areEqual(this.factors, mTCardRankingRedundancy.factors);
    }

    public final List<MTCardRankingRedundancyFactor> getFactors() {
        return this.factors;
    }

    public final int getScore() {
        return this.score;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.score) * 31) + Boolean.hashCode(this.isRedundant)) * 31) + this.factors.hashCode();
    }

    public final boolean isRedundant() {
        return this.isRedundant;
    }

    public String toString() {
        return "MTCardRankingRedundancy(score=" + this.score + ", isRedundant=" + this.isRedundant + ", factors=" + this.factors + ")";
    }
}
