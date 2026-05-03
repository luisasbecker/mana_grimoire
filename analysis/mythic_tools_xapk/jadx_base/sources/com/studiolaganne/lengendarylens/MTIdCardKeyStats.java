package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J~\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0012R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00060"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardKeyStats;", "", "cardCount", "", "avgCmc", "", "creatureCount", "instantSorceryCount", "enchantmentCount", "artifactCount", "planeswalkerCount", "landCount", "manaCurve", "", "Lcom/studiolaganne/lengendarylens/MTIdCardManaCurveBucket;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getCardCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAvgCmc", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCreatureCount", "getInstantSorceryCount", "getEnchantmentCount", "getArtifactCount", "getPlaneswalkerCount", "getLandCount", "getManaCurve", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTIdCardKeyStats;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardKeyStats {
    public static final int $stable = 8;
    private final Integer artifactCount;
    private final Double avgCmc;
    private final Integer cardCount;
    private final Integer creatureCount;
    private final Integer enchantmentCount;
    private final Integer instantSorceryCount;
    private final Integer landCount;
    private final List<MTIdCardManaCurveBucket> manaCurve;
    private final Integer planeswalkerCount;

    public MTIdCardKeyStats() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public MTIdCardKeyStats(Integer num, Double d, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, List<MTIdCardManaCurveBucket> manaCurve) {
        Intrinsics.checkNotNullParameter(manaCurve, "manaCurve");
        this.cardCount = num;
        this.avgCmc = d;
        this.creatureCount = num2;
        this.instantSorceryCount = num3;
        this.enchantmentCount = num4;
        this.artifactCount = num5;
        this.planeswalkerCount = num6;
        this.landCount = num7;
        this.manaCurve = manaCurve;
    }

    public /* synthetic */ MTIdCardKeyStats(Integer num, Double d, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : num5, (i & 64) != 0 ? null : num6, (i & 128) != 0 ? null : num7, (i & 256) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTIdCardKeyStats copy$default(MTIdCardKeyStats mTIdCardKeyStats, Integer num, Double d, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTIdCardKeyStats.cardCount;
        }
        if ((i & 2) != 0) {
            d = mTIdCardKeyStats.avgCmc;
        }
        if ((i & 4) != 0) {
            num2 = mTIdCardKeyStats.creatureCount;
        }
        if ((i & 8) != 0) {
            num3 = mTIdCardKeyStats.instantSorceryCount;
        }
        if ((i & 16) != 0) {
            num4 = mTIdCardKeyStats.enchantmentCount;
        }
        if ((i & 32) != 0) {
            num5 = mTIdCardKeyStats.artifactCount;
        }
        if ((i & 64) != 0) {
            num6 = mTIdCardKeyStats.planeswalkerCount;
        }
        if ((i & 128) != 0) {
            num7 = mTIdCardKeyStats.landCount;
        }
        if ((i & 256) != 0) {
            list = mTIdCardKeyStats.manaCurve;
        }
        Integer num8 = num7;
        List list2 = list;
        Integer num9 = num5;
        Integer num10 = num6;
        Integer num11 = num4;
        Integer num12 = num2;
        return mTIdCardKeyStats.copy(num, d, num12, num3, num11, num9, num10, num8, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getCardCount() {
        return this.cardCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getAvgCmc() {
        return this.avgCmc;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getCreatureCount() {
        return this.creatureCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getInstantSorceryCount() {
        return this.instantSorceryCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getEnchantmentCount() {
        return this.enchantmentCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getArtifactCount() {
        return this.artifactCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getPlaneswalkerCount() {
        return this.planeswalkerCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getLandCount() {
        return this.landCount;
    }

    public final List<MTIdCardManaCurveBucket> component9() {
        return this.manaCurve;
    }

    public final MTIdCardKeyStats copy(Integer cardCount, Double avgCmc, Integer creatureCount, Integer instantSorceryCount, Integer enchantmentCount, Integer artifactCount, Integer planeswalkerCount, Integer landCount, List<MTIdCardManaCurveBucket> manaCurve) {
        Intrinsics.checkNotNullParameter(manaCurve, "manaCurve");
        return new MTIdCardKeyStats(cardCount, avgCmc, creatureCount, instantSorceryCount, enchantmentCount, artifactCount, planeswalkerCount, landCount, manaCurve);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardKeyStats)) {
            return false;
        }
        MTIdCardKeyStats mTIdCardKeyStats = (MTIdCardKeyStats) other;
        return Intrinsics.areEqual(this.cardCount, mTIdCardKeyStats.cardCount) && Intrinsics.areEqual((Object) this.avgCmc, (Object) mTIdCardKeyStats.avgCmc) && Intrinsics.areEqual(this.creatureCount, mTIdCardKeyStats.creatureCount) && Intrinsics.areEqual(this.instantSorceryCount, mTIdCardKeyStats.instantSorceryCount) && Intrinsics.areEqual(this.enchantmentCount, mTIdCardKeyStats.enchantmentCount) && Intrinsics.areEqual(this.artifactCount, mTIdCardKeyStats.artifactCount) && Intrinsics.areEqual(this.planeswalkerCount, mTIdCardKeyStats.planeswalkerCount) && Intrinsics.areEqual(this.landCount, mTIdCardKeyStats.landCount) && Intrinsics.areEqual(this.manaCurve, mTIdCardKeyStats.manaCurve);
    }

    public final Integer getArtifactCount() {
        return this.artifactCount;
    }

    public final Double getAvgCmc() {
        return this.avgCmc;
    }

    public final Integer getCardCount() {
        return this.cardCount;
    }

    public final Integer getCreatureCount() {
        return this.creatureCount;
    }

    public final Integer getEnchantmentCount() {
        return this.enchantmentCount;
    }

    public final Integer getInstantSorceryCount() {
        return this.instantSorceryCount;
    }

    public final Integer getLandCount() {
        return this.landCount;
    }

    public final List<MTIdCardManaCurveBucket> getManaCurve() {
        return this.manaCurve;
    }

    public final Integer getPlaneswalkerCount() {
        return this.planeswalkerCount;
    }

    public int hashCode() {
        Integer num = this.cardCount;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Double d = this.avgCmc;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Integer num2 = this.creatureCount;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.instantSorceryCount;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.enchantmentCount;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.artifactCount;
        int iHashCode6 = (iHashCode5 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.planeswalkerCount;
        int iHashCode7 = (iHashCode6 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.landCount;
        return ((iHashCode7 + (num7 != null ? num7.hashCode() : 0)) * 31) + this.manaCurve.hashCode();
    }

    public String toString() {
        return "MTIdCardKeyStats(cardCount=" + this.cardCount + ", avgCmc=" + this.avgCmc + ", creatureCount=" + this.creatureCount + ", instantSorceryCount=" + this.instantSorceryCount + ", enchantmentCount=" + this.enchantmentCount + ", artifactCount=" + this.artifactCount + ", planeswalkerCount=" + this.planeswalkerCount + ", landCount=" + this.landCount + ", manaCurve=" + this.manaCurve + ")";
    }
}
