package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0006\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandProb;", "", "landCount", "", "probability", "", "isIdeal", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Boolean;)V", "getLandCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProbability", "()Ljava/lang/Double;", "Ljava/lang/Double;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTIdCardOpeningHandProb;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardOpeningHandProb {
    public static final int $stable = 0;
    private final Boolean isIdeal;
    private final Integer landCount;
    private final Double probability;

    public MTIdCardOpeningHandProb() {
        this(null, null, null, 7, null);
    }

    public MTIdCardOpeningHandProb(Integer num, Double d, Boolean bool) {
        this.landCount = num;
        this.probability = d;
        this.isIdeal = bool;
    }

    public /* synthetic */ MTIdCardOpeningHandProb(Integer num, Double d, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : bool);
    }

    public static /* synthetic */ MTIdCardOpeningHandProb copy$default(MTIdCardOpeningHandProb mTIdCardOpeningHandProb, Integer num, Double d, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardOpeningHandProb.landCount;
        }
        if ((i & 2) != 0) {
            d = mTIdCardOpeningHandProb.probability;
        }
        if ((i & 4) != 0) {
            bool = mTIdCardOpeningHandProb.isIdeal;
        }
        return mTIdCardOpeningHandProb.copy(num, d, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getLandCount() {
        return this.landCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getProbability() {
        return this.probability;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getIsIdeal() {
        return this.isIdeal;
    }

    public final MTIdCardOpeningHandProb copy(Integer landCount, Double probability, Boolean isIdeal) {
        return new MTIdCardOpeningHandProb(landCount, probability, isIdeal);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardOpeningHandProb)) {
            return false;
        }
        MTIdCardOpeningHandProb mTIdCardOpeningHandProb = (MTIdCardOpeningHandProb) other;
        return Intrinsics.areEqual(this.landCount, mTIdCardOpeningHandProb.landCount) && Intrinsics.areEqual((Object) this.probability, (Object) mTIdCardOpeningHandProb.probability) && Intrinsics.areEqual(this.isIdeal, mTIdCardOpeningHandProb.isIdeal);
    }

    public final Integer getLandCount() {
        return this.landCount;
    }

    public final Double getProbability() {
        return this.probability;
    }

    public int hashCode() {
        Integer num = this.landCount;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Double d = this.probability;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Boolean bool = this.isIdeal;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public final Boolean isIdeal() {
        return this.isIdeal;
    }

    public String toString() {
        return "MTIdCardOpeningHandProb(landCount=" + this.landCount + ", probability=" + this.probability + ", isIdeal=" + this.isIdeal + ")";
    }
}
