package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007HÆ\u0003Jn\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017¨\u0006)"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardPlaygroupMeta;", "", "playgroupId", "", "scopeName", "", "opponents", "", "Lcom/studiolaganne/lengendarylens/MTIdCardOpponent;", "topCommanders", "Lcom/studiolaganne/lengendarylens/MTIdCardTopCommander;", "colorDistribution", "", "worstMatchups", "Lcom/studiolaganne/lengendarylens/MTIdCardMatchup;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/List;)V", "getPlaygroupId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScopeName", "()Ljava/lang/String;", "getOpponents", "()Ljava/util/List;", "getTopCommanders", "getColorDistribution", "()Ljava/util/Map;", "getWorstMatchups", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardPlaygroupMeta;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardPlaygroupMeta {
    public static final int $stable = 8;
    private final Map<String, Integer> colorDistribution;
    private final List<MTIdCardOpponent> opponents;
    private final Integer playgroupId;
    private final String scopeName;
    private final List<MTIdCardTopCommander> topCommanders;
    private final List<MTIdCardMatchup> worstMatchups;

    public MTIdCardPlaygroupMeta() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MTIdCardPlaygroupMeta(Integer num, String str, List<MTIdCardOpponent> opponents, List<MTIdCardTopCommander> topCommanders, Map<String, Integer> map, List<MTIdCardMatchup> worstMatchups) {
        Intrinsics.checkNotNullParameter(opponents, "opponents");
        Intrinsics.checkNotNullParameter(topCommanders, "topCommanders");
        Intrinsics.checkNotNullParameter(worstMatchups, "worstMatchups");
        this.playgroupId = num;
        this.scopeName = str;
        this.opponents = opponents;
        this.topCommanders = topCommanders;
        this.colorDistribution = map;
        this.worstMatchups = worstMatchups;
    }

    public /* synthetic */ MTIdCardPlaygroupMeta(Integer num, String str, List list, List list2, Map map, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? CollectionsKt.emptyList() : list2, (i & 16) != 0 ? null : map, (i & 32) != 0 ? CollectionsKt.emptyList() : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardPlaygroupMeta copy$default(MTIdCardPlaygroupMeta mTIdCardPlaygroupMeta, Integer num, String str, List list, List list2, Map map, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardPlaygroupMeta.playgroupId;
        }
        if ((i & 2) != 0) {
            str = mTIdCardPlaygroupMeta.scopeName;
        }
        if ((i & 4) != 0) {
            list = mTIdCardPlaygroupMeta.opponents;
        }
        if ((i & 8) != 0) {
            list2 = mTIdCardPlaygroupMeta.topCommanders;
        }
        if ((i & 16) != 0) {
            map = mTIdCardPlaygroupMeta.colorDistribution;
        }
        if ((i & 32) != 0) {
            list3 = mTIdCardPlaygroupMeta.worstMatchups;
        }
        Map map2 = map;
        List list4 = list3;
        return mTIdCardPlaygroupMeta.copy(num, str, list, list2, map2, list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getPlaygroupId() {
        return this.playgroupId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getScopeName() {
        return this.scopeName;
    }

    public final List<MTIdCardOpponent> component3() {
        return this.opponents;
    }

    public final List<MTIdCardTopCommander> component4() {
        return this.topCommanders;
    }

    public final Map<String, Integer> component5() {
        return this.colorDistribution;
    }

    public final List<MTIdCardMatchup> component6() {
        return this.worstMatchups;
    }

    public final MTIdCardPlaygroupMeta copy(Integer playgroupId, String scopeName, List<MTIdCardOpponent> opponents, List<MTIdCardTopCommander> topCommanders, Map<String, Integer> colorDistribution, List<MTIdCardMatchup> worstMatchups) {
        Intrinsics.checkNotNullParameter(opponents, "opponents");
        Intrinsics.checkNotNullParameter(topCommanders, "topCommanders");
        Intrinsics.checkNotNullParameter(worstMatchups, "worstMatchups");
        return new MTIdCardPlaygroupMeta(playgroupId, scopeName, opponents, topCommanders, colorDistribution, worstMatchups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardPlaygroupMeta)) {
            return false;
        }
        MTIdCardPlaygroupMeta mTIdCardPlaygroupMeta = (MTIdCardPlaygroupMeta) other;
        return Intrinsics.areEqual(this.playgroupId, mTIdCardPlaygroupMeta.playgroupId) && Intrinsics.areEqual(this.scopeName, mTIdCardPlaygroupMeta.scopeName) && Intrinsics.areEqual(this.opponents, mTIdCardPlaygroupMeta.opponents) && Intrinsics.areEqual(this.topCommanders, mTIdCardPlaygroupMeta.topCommanders) && Intrinsics.areEqual(this.colorDistribution, mTIdCardPlaygroupMeta.colorDistribution) && Intrinsics.areEqual(this.worstMatchups, mTIdCardPlaygroupMeta.worstMatchups);
    }

    public final Map<String, Integer> getColorDistribution() {
        return this.colorDistribution;
    }

    public final List<MTIdCardOpponent> getOpponents() {
        return this.opponents;
    }

    public final Integer getPlaygroupId() {
        return this.playgroupId;
    }

    public final String getScopeName() {
        return this.scopeName;
    }

    public final List<MTIdCardTopCommander> getTopCommanders() {
        return this.topCommanders;
    }

    public final List<MTIdCardMatchup> getWorstMatchups() {
        return this.worstMatchups;
    }

    public int hashCode() {
        Integer num = this.playgroupId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.scopeName;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.opponents.hashCode()) * 31) + this.topCommanders.hashCode()) * 31;
        Map<String, Integer> map = this.colorDistribution;
        return ((iHashCode2 + (map != null ? map.hashCode() : 0)) * 31) + this.worstMatchups.hashCode();
    }

    public String toString() {
        return "MTIdCardPlaygroupMeta(playgroupId=" + this.playgroupId + ", scopeName=" + this.scopeName + ", opponents=" + this.opponents + ", topCommanders=" + this.topCommanders + ", colorDistribution=" + this.colorDistribution + ", worstMatchups=" + this.worstMatchups + ")";
    }
}
