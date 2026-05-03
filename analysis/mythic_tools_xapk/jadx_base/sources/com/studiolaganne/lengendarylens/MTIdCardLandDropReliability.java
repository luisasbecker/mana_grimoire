package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ*\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardLandDropReliability;", "", "perTurn", "", "Lcom/studiolaganne/lengendarylens/MTIdCardLandDropReliabilityTurn;", "criticalTurn", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;)V", "getPerTurn", "()Ljava/util/List;", "getCriticalTurn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTIdCardLandDropReliability;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardLandDropReliability {
    public static final int $stable = 8;
    private final Integer criticalTurn;
    private final List<MTIdCardLandDropReliabilityTurn> perTurn;

    /* JADX WARN: Multi-variable type inference failed */
    public MTIdCardLandDropReliability() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTIdCardLandDropReliability(List<MTIdCardLandDropReliabilityTurn> perTurn, Integer num) {
        Intrinsics.checkNotNullParameter(perTurn, "perTurn");
        this.perTurn = perTurn;
        this.criticalTurn = num;
    }

    public /* synthetic */ MTIdCardLandDropReliability(List list, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : num);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardLandDropReliability copy$default(MTIdCardLandDropReliability mTIdCardLandDropReliability, List list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTIdCardLandDropReliability.perTurn;
        }
        if ((i & 2) != 0) {
            num = mTIdCardLandDropReliability.criticalTurn;
        }
        return mTIdCardLandDropReliability.copy(list, num);
    }

    public final List<MTIdCardLandDropReliabilityTurn> component1() {
        return this.perTurn;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getCriticalTurn() {
        return this.criticalTurn;
    }

    public final MTIdCardLandDropReliability copy(List<MTIdCardLandDropReliabilityTurn> perTurn, Integer criticalTurn) {
        Intrinsics.checkNotNullParameter(perTurn, "perTurn");
        return new MTIdCardLandDropReliability(perTurn, criticalTurn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardLandDropReliability)) {
            return false;
        }
        MTIdCardLandDropReliability mTIdCardLandDropReliability = (MTIdCardLandDropReliability) other;
        return Intrinsics.areEqual(this.perTurn, mTIdCardLandDropReliability.perTurn) && Intrinsics.areEqual(this.criticalTurn, mTIdCardLandDropReliability.criticalTurn);
    }

    public final Integer getCriticalTurn() {
        return this.criticalTurn;
    }

    public final List<MTIdCardLandDropReliabilityTurn> getPerTurn() {
        return this.perTurn;
    }

    public int hashCode() {
        int iHashCode = this.perTurn.hashCode() * 31;
        Integer num = this.criticalTurn;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "MTIdCardLandDropReliability(perTurn=" + this.perTurn + ", criticalTurn=" + this.criticalTurn + ")";
    }
}
