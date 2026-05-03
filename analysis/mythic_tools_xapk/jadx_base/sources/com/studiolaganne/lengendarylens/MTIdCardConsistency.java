package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardConsistency;", "", FirebaseAnalytics.Param.SCORE, "", "openingHandProbabilities", "", "Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandCategoryProb;", "comboProbabilities", "Lcom/studiolaganne/lengendarylens/MTIdCardComboProbability;", "diagnostics", "Lcom/studiolaganne/lengendarylens/MTIdCardConsistencyDiagnostic;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getScore", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOpeningHandProbabilities", "()Ljava/util/List;", "getComboProbabilities", "getDiagnostics", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardConsistency;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardConsistency {
    public static final int $stable = 8;
    private final List<MTIdCardComboProbability> comboProbabilities;
    private final List<MTIdCardConsistencyDiagnostic> diagnostics;
    private final List<MTIdCardOpeningHandCategoryProb> openingHandProbabilities;
    private final Integer score;

    public MTIdCardConsistency() {
        this(null, null, null, null, 15, null);
    }

    public MTIdCardConsistency(Integer num, List<MTIdCardOpeningHandCategoryProb> openingHandProbabilities, List<MTIdCardComboProbability> comboProbabilities, List<MTIdCardConsistencyDiagnostic> diagnostics) {
        Intrinsics.checkNotNullParameter(openingHandProbabilities, "openingHandProbabilities");
        Intrinsics.checkNotNullParameter(comboProbabilities, "comboProbabilities");
        Intrinsics.checkNotNullParameter(diagnostics, "diagnostics");
        this.score = num;
        this.openingHandProbabilities = openingHandProbabilities;
        this.comboProbabilities = comboProbabilities;
        this.diagnostics = diagnostics;
    }

    public /* synthetic */ MTIdCardConsistency(Integer num, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? CollectionsKt.emptyList() : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardConsistency copy$default(MTIdCardConsistency mTIdCardConsistency, Integer num, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardConsistency.score;
        }
        if ((i & 2) != 0) {
            list = mTIdCardConsistency.openingHandProbabilities;
        }
        if ((i & 4) != 0) {
            list2 = mTIdCardConsistency.comboProbabilities;
        }
        if ((i & 8) != 0) {
            list3 = mTIdCardConsistency.diagnostics;
        }
        return mTIdCardConsistency.copy(num, list, list2, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getScore() {
        return this.score;
    }

    public final List<MTIdCardOpeningHandCategoryProb> component2() {
        return this.openingHandProbabilities;
    }

    public final List<MTIdCardComboProbability> component3() {
        return this.comboProbabilities;
    }

    public final List<MTIdCardConsistencyDiagnostic> component4() {
        return this.diagnostics;
    }

    public final MTIdCardConsistency copy(Integer score, List<MTIdCardOpeningHandCategoryProb> openingHandProbabilities, List<MTIdCardComboProbability> comboProbabilities, List<MTIdCardConsistencyDiagnostic> diagnostics) {
        Intrinsics.checkNotNullParameter(openingHandProbabilities, "openingHandProbabilities");
        Intrinsics.checkNotNullParameter(comboProbabilities, "comboProbabilities");
        Intrinsics.checkNotNullParameter(diagnostics, "diagnostics");
        return new MTIdCardConsistency(score, openingHandProbabilities, comboProbabilities, diagnostics);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardConsistency)) {
            return false;
        }
        MTIdCardConsistency mTIdCardConsistency = (MTIdCardConsistency) other;
        return Intrinsics.areEqual(this.score, mTIdCardConsistency.score) && Intrinsics.areEqual(this.openingHandProbabilities, mTIdCardConsistency.openingHandProbabilities) && Intrinsics.areEqual(this.comboProbabilities, mTIdCardConsistency.comboProbabilities) && Intrinsics.areEqual(this.diagnostics, mTIdCardConsistency.diagnostics);
    }

    public final List<MTIdCardComboProbability> getComboProbabilities() {
        return this.comboProbabilities;
    }

    public final List<MTIdCardConsistencyDiagnostic> getDiagnostics() {
        return this.diagnostics;
    }

    public final List<MTIdCardOpeningHandCategoryProb> getOpeningHandProbabilities() {
        return this.openingHandProbabilities;
    }

    public final Integer getScore() {
        return this.score;
    }

    public int hashCode() {
        Integer num = this.score;
        return ((((((num == null ? 0 : num.hashCode()) * 31) + this.openingHandProbabilities.hashCode()) * 31) + this.comboProbabilities.hashCode()) * 31) + this.diagnostics.hashCode();
    }

    public String toString() {
        return "MTIdCardConsistency(score=" + this.score + ", openingHandProbabilities=" + this.openingHandProbabilities + ", comboProbabilities=" + this.comboProbabilities + ", diagnostics=" + this.diagnostics + ")";
    }
}
