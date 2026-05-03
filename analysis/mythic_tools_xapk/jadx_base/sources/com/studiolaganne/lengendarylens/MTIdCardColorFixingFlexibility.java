package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0010\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardColorFixingFlexibility;", "", "perColor", "", "", "", "landTutorCount", "<init>", "(Ljava/util/Map;Ljava/lang/Integer;)V", "getPerColor", "()Ljava/util/Map;", "getLandTutorCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/Map;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTIdCardColorFixingFlexibility;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardColorFixingFlexibility {
    public static final int $stable = 8;
    private final Integer landTutorCount;
    private final Map<String, Integer> perColor;

    /* JADX WARN: Multi-variable type inference failed */
    public MTIdCardColorFixingFlexibility() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTIdCardColorFixingFlexibility(Map<String, Integer> map, Integer num) {
        this.perColor = map;
        this.landTutorCount = num;
    }

    public /* synthetic */ MTIdCardColorFixingFlexibility(Map map, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : num);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardColorFixingFlexibility copy$default(MTIdCardColorFixingFlexibility mTIdCardColorFixingFlexibility, Map map, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            map = mTIdCardColorFixingFlexibility.perColor;
        }
        if ((i & 2) != 0) {
            num = mTIdCardColorFixingFlexibility.landTutorCount;
        }
        return mTIdCardColorFixingFlexibility.copy(map, num);
    }

    public final Map<String, Integer> component1() {
        return this.perColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getLandTutorCount() {
        return this.landTutorCount;
    }

    public final MTIdCardColorFixingFlexibility copy(Map<String, Integer> perColor, Integer landTutorCount) {
        return new MTIdCardColorFixingFlexibility(perColor, landTutorCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardColorFixingFlexibility)) {
            return false;
        }
        MTIdCardColorFixingFlexibility mTIdCardColorFixingFlexibility = (MTIdCardColorFixingFlexibility) other;
        return Intrinsics.areEqual(this.perColor, mTIdCardColorFixingFlexibility.perColor) && Intrinsics.areEqual(this.landTutorCount, mTIdCardColorFixingFlexibility.landTutorCount);
    }

    public final Integer getLandTutorCount() {
        return this.landTutorCount;
    }

    public final Map<String, Integer> getPerColor() {
        return this.perColor;
    }

    public int hashCode() {
        Map<String, Integer> map = this.perColor;
        int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
        Integer num = this.landTutorCount;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardColorFixingFlexibility(perColor=" + this.perColor + ", landTutorCount=" + this.landTutorCount + ")";
    }
}
