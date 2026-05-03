package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003JR\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\nHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardFetchTargetAnalysis;", "", "fetchCount", "", "fetchableTargetCount", "surplus", "fetchEntries", "", "Lcom/studiolaganne/lengendarylens/MTIdCardFetchEntry;", "targetLandNames", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "getFetchCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFetchableTargetCount", "getSurplus", "getFetchEntries", "()Ljava/util/List;", "getTargetLandNames", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardFetchTargetAnalysis;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardFetchTargetAnalysis {
    public static final int $stable = 8;
    private final Integer fetchCount;
    private final List<MTIdCardFetchEntry> fetchEntries;
    private final Integer fetchableTargetCount;
    private final Integer surplus;
    private final List<String> targetLandNames;

    public MTIdCardFetchTargetAnalysis() {
        this(null, null, null, null, null, 31, null);
    }

    public MTIdCardFetchTargetAnalysis(Integer num, Integer num2, Integer num3, List<MTIdCardFetchEntry> fetchEntries, List<String> targetLandNames) {
        Intrinsics.checkNotNullParameter(fetchEntries, "fetchEntries");
        Intrinsics.checkNotNullParameter(targetLandNames, "targetLandNames");
        this.fetchCount = num;
        this.fetchableTargetCount = num2;
        this.surplus = num3;
        this.fetchEntries = fetchEntries;
        this.targetLandNames = targetLandNames;
    }

    public /* synthetic */ MTIdCardFetchTargetAnalysis(Integer num, Integer num2, Integer num3, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardFetchTargetAnalysis copy$default(MTIdCardFetchTargetAnalysis mTIdCardFetchTargetAnalysis, Integer num, Integer num2, Integer num3, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardFetchTargetAnalysis.fetchCount;
        }
        if ((i & 2) != 0) {
            num2 = mTIdCardFetchTargetAnalysis.fetchableTargetCount;
        }
        if ((i & 4) != 0) {
            num3 = mTIdCardFetchTargetAnalysis.surplus;
        }
        if ((i & 8) != 0) {
            list = mTIdCardFetchTargetAnalysis.fetchEntries;
        }
        if ((i & 16) != 0) {
            list2 = mTIdCardFetchTargetAnalysis.targetLandNames;
        }
        List list3 = list2;
        Integer num4 = num3;
        return mTIdCardFetchTargetAnalysis.copy(num, num2, num4, list, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getFetchCount() {
        return this.fetchCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getFetchableTargetCount() {
        return this.fetchableTargetCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getSurplus() {
        return this.surplus;
    }

    public final List<MTIdCardFetchEntry> component4() {
        return this.fetchEntries;
    }

    public final List<String> component5() {
        return this.targetLandNames;
    }

    public final MTIdCardFetchTargetAnalysis copy(Integer fetchCount, Integer fetchableTargetCount, Integer surplus, List<MTIdCardFetchEntry> fetchEntries, List<String> targetLandNames) {
        Intrinsics.checkNotNullParameter(fetchEntries, "fetchEntries");
        Intrinsics.checkNotNullParameter(targetLandNames, "targetLandNames");
        return new MTIdCardFetchTargetAnalysis(fetchCount, fetchableTargetCount, surplus, fetchEntries, targetLandNames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardFetchTargetAnalysis)) {
            return false;
        }
        MTIdCardFetchTargetAnalysis mTIdCardFetchTargetAnalysis = (MTIdCardFetchTargetAnalysis) other;
        return Intrinsics.areEqual(this.fetchCount, mTIdCardFetchTargetAnalysis.fetchCount) && Intrinsics.areEqual(this.fetchableTargetCount, mTIdCardFetchTargetAnalysis.fetchableTargetCount) && Intrinsics.areEqual(this.surplus, mTIdCardFetchTargetAnalysis.surplus) && Intrinsics.areEqual(this.fetchEntries, mTIdCardFetchTargetAnalysis.fetchEntries) && Intrinsics.areEqual(this.targetLandNames, mTIdCardFetchTargetAnalysis.targetLandNames);
    }

    public final Integer getFetchCount() {
        return this.fetchCount;
    }

    public final List<MTIdCardFetchEntry> getFetchEntries() {
        return this.fetchEntries;
    }

    public final Integer getFetchableTargetCount() {
        return this.fetchableTargetCount;
    }

    public final Integer getSurplus() {
        return this.surplus;
    }

    public final List<String> getTargetLandNames() {
        return this.targetLandNames;
    }

    public int hashCode() {
        Integer num = this.fetchCount;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.fetchableTargetCount;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.surplus;
        return ((((iHashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31) + this.fetchEntries.hashCode()) * 31) + this.targetLandNames.hashCode();
    }

    public String toString() {
        return "MTIdCardFetchTargetAnalysis(fetchCount=" + this.fetchCount + ", fetchableTargetCount=" + this.fetchableTargetCount + ", surplus=" + this.surplus + ", fetchEntries=" + this.fetchEntries + ", targetLandNames=" + this.targetLandNames + ")";
    }
}
