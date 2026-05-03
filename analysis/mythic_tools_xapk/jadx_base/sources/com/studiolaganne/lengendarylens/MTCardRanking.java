package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b4\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010A\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010B\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010G\u001a\u0004\u0018\u00010\u001aHÆ\u0003JÎ\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÆ\u0001¢\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020\u00032\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\u0005HÖ\u0001J\t\u0010M\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010,\u001a\u0004\b-\u0010+R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b4\u0010$R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010%\u001a\u0004\b5\u0010$R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006N"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRanking;", "", "isCommander", "", "sortPriority", "", "verdict", "", "overallLabel", "signalsVersion", "protectionReason", "flags", "Lcom/studiolaganne/lengendarylens/MTCardRankingFlags;", "popularityTier", "popularityPct", "", "cardPower", "signals", "Lcom/studiolaganne/lengendarylens/MTCardRankingSignals;", "signalsList", "", "redundancy", "Lcom/studiolaganne/lengendarylens/MTCardRankingRedundancy;", "inclusionRate", "totalCommanderDecks", "cmcSlot", "Lcom/studiolaganne/lengendarylens/MTCardRankingCmcSlot;", "<init>", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTCardRankingFlags;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Lcom/studiolaganne/lengendarylens/MTCardRankingSignals;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTCardRankingRedundancy;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTCardRankingCmcSlot;)V", "()Z", "getSortPriority", "()I", "getVerdict", "()Ljava/lang/String;", "getOverallLabel", "getSignalsVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProtectionReason", "getFlags", "()Lcom/studiolaganne/lengendarylens/MTCardRankingFlags;", "getPopularityTier", "getPopularityPct", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCardPower", "getSignals", "()Lcom/studiolaganne/lengendarylens/MTCardRankingSignals;", "getSignalsList", "()Ljava/util/List;", "getRedundancy", "()Lcom/studiolaganne/lengendarylens/MTCardRankingRedundancy;", "getInclusionRate", "getTotalCommanderDecks", "getCmcSlot", "()Lcom/studiolaganne/lengendarylens/MTCardRankingCmcSlot;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTCardRankingFlags;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Lcom/studiolaganne/lengendarylens/MTCardRankingSignals;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTCardRankingRedundancy;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTCardRankingCmcSlot;)Lcom/studiolaganne/lengendarylens/MTCardRanking;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRanking {
    public static final int $stable = 8;
    private final Double cardPower;
    private final MTCardRankingCmcSlot cmcSlot;
    private final MTCardRankingFlags flags;
    private final Integer inclusionRate;
    private final boolean isCommander;
    private final String overallLabel;
    private final Double popularityPct;
    private final String popularityTier;
    private final String protectionReason;
    private final MTCardRankingRedundancy redundancy;
    private final MTCardRankingSignals signals;
    private final List<String> signalsList;
    private final Integer signalsVersion;
    private final int sortPriority;
    private final Integer totalCommanderDecks;
    private final String verdict;

    public MTCardRanking() {
        this(false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    public MTCardRanking(boolean z, int i, String str, String str2, Integer num, String str3, MTCardRankingFlags mTCardRankingFlags, String str4, Double d, Double d2, MTCardRankingSignals mTCardRankingSignals, List<String> signalsList, MTCardRankingRedundancy mTCardRankingRedundancy, Integer num2, Integer num3, MTCardRankingCmcSlot mTCardRankingCmcSlot) {
        Intrinsics.checkNotNullParameter(signalsList, "signalsList");
        this.isCommander = z;
        this.sortPriority = i;
        this.verdict = str;
        this.overallLabel = str2;
        this.signalsVersion = num;
        this.protectionReason = str3;
        this.flags = mTCardRankingFlags;
        this.popularityTier = str4;
        this.popularityPct = d;
        this.cardPower = d2;
        this.signals = mTCardRankingSignals;
        this.signalsList = signalsList;
        this.redundancy = mTCardRankingRedundancy;
        this.inclusionRate = num2;
        this.totalCommanderDecks = num3;
        this.cmcSlot = mTCardRankingCmcSlot;
    }

    public /* synthetic */ MTCardRanking(boolean z, int i, String str, String str2, Integer num, String str3, MTCardRankingFlags mTCardRankingFlags, String str4, Double d, Double d2, MTCardRankingSignals mTCardRankingSignals, List list, MTCardRankingRedundancy mTCardRankingRedundancy, Integer num2, Integer num3, MTCardRankingCmcSlot mTCardRankingCmcSlot, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) == 0 ? i : 0, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : num, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : mTCardRankingFlags, (i2 & 128) != 0 ? null : str4, (i2 & 256) != 0 ? null : d, (i2 & 512) != 0 ? null : d2, (i2 & 1024) != 0 ? null : mTCardRankingSignals, (i2 & 2048) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4096) != 0 ? null : mTCardRankingRedundancy, (i2 & 8192) != 0 ? null : num2, (i2 & 16384) != 0 ? null : num3, (i2 & 32768) != 0 ? null : mTCardRankingCmcSlot);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardRanking copy$default(MTCardRanking mTCardRanking, boolean z, int i, String str, String str2, Integer num, String str3, MTCardRankingFlags mTCardRankingFlags, String str4, Double d, Double d2, MTCardRankingSignals mTCardRankingSignals, List list, MTCardRankingRedundancy mTCardRankingRedundancy, Integer num2, Integer num3, MTCardRankingCmcSlot mTCardRankingCmcSlot, int i2, Object obj) {
        boolean z2 = (i2 & 1) != 0 ? mTCardRanking.isCommander : z;
        return mTCardRanking.copy(z2, (i2 & 2) != 0 ? mTCardRanking.sortPriority : i, (i2 & 4) != 0 ? mTCardRanking.verdict : str, (i2 & 8) != 0 ? mTCardRanking.overallLabel : str2, (i2 & 16) != 0 ? mTCardRanking.signalsVersion : num, (i2 & 32) != 0 ? mTCardRanking.protectionReason : str3, (i2 & 64) != 0 ? mTCardRanking.flags : mTCardRankingFlags, (i2 & 128) != 0 ? mTCardRanking.popularityTier : str4, (i2 & 256) != 0 ? mTCardRanking.popularityPct : d, (i2 & 512) != 0 ? mTCardRanking.cardPower : d2, (i2 & 1024) != 0 ? mTCardRanking.signals : mTCardRankingSignals, (i2 & 2048) != 0 ? mTCardRanking.signalsList : list, (i2 & 4096) != 0 ? mTCardRanking.redundancy : mTCardRankingRedundancy, (i2 & 8192) != 0 ? mTCardRanking.inclusionRate : num2, (i2 & 16384) != 0 ? mTCardRanking.totalCommanderDecks : num3, (i2 & 32768) != 0 ? mTCardRanking.cmcSlot : mTCardRankingCmcSlot);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsCommander() {
        return this.isCommander;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Double getCardPower() {
        return this.cardPower;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final MTCardRankingSignals getSignals() {
        return this.signals;
    }

    public final List<String> component12() {
        return this.signalsList;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final MTCardRankingRedundancy getRedundancy() {
        return this.redundancy;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getInclusionRate() {
        return this.inclusionRate;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getTotalCommanderDecks() {
        return this.totalCommanderDecks;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final MTCardRankingCmcSlot getCmcSlot() {
        return this.cmcSlot;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSortPriority() {
        return this.sortPriority;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVerdict() {
        return this.verdict;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOverallLabel() {
        return this.overallLabel;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getSignalsVersion() {
        return this.signalsVersion;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getProtectionReason() {
        return this.protectionReason;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MTCardRankingFlags getFlags() {
        return this.flags;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPopularityTier() {
        return this.popularityTier;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Double getPopularityPct() {
        return this.popularityPct;
    }

    public final MTCardRanking copy(boolean isCommander, int sortPriority, String verdict, String overallLabel, Integer signalsVersion, String protectionReason, MTCardRankingFlags flags, String popularityTier, Double popularityPct, Double cardPower, MTCardRankingSignals signals, List<String> signalsList, MTCardRankingRedundancy redundancy, Integer inclusionRate, Integer totalCommanderDecks, MTCardRankingCmcSlot cmcSlot) {
        Intrinsics.checkNotNullParameter(signalsList, "signalsList");
        return new MTCardRanking(isCommander, sortPriority, verdict, overallLabel, signalsVersion, protectionReason, flags, popularityTier, popularityPct, cardPower, signals, signalsList, redundancy, inclusionRate, totalCommanderDecks, cmcSlot);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRanking)) {
            return false;
        }
        MTCardRanking mTCardRanking = (MTCardRanking) other;
        return this.isCommander == mTCardRanking.isCommander && this.sortPriority == mTCardRanking.sortPriority && Intrinsics.areEqual(this.verdict, mTCardRanking.verdict) && Intrinsics.areEqual(this.overallLabel, mTCardRanking.overallLabel) && Intrinsics.areEqual(this.signalsVersion, mTCardRanking.signalsVersion) && Intrinsics.areEqual(this.protectionReason, mTCardRanking.protectionReason) && Intrinsics.areEqual(this.flags, mTCardRanking.flags) && Intrinsics.areEqual(this.popularityTier, mTCardRanking.popularityTier) && Intrinsics.areEqual((Object) this.popularityPct, (Object) mTCardRanking.popularityPct) && Intrinsics.areEqual((Object) this.cardPower, (Object) mTCardRanking.cardPower) && Intrinsics.areEqual(this.signals, mTCardRanking.signals) && Intrinsics.areEqual(this.signalsList, mTCardRanking.signalsList) && Intrinsics.areEqual(this.redundancy, mTCardRanking.redundancy) && Intrinsics.areEqual(this.inclusionRate, mTCardRanking.inclusionRate) && Intrinsics.areEqual(this.totalCommanderDecks, mTCardRanking.totalCommanderDecks) && Intrinsics.areEqual(this.cmcSlot, mTCardRanking.cmcSlot);
    }

    public final Double getCardPower() {
        return this.cardPower;
    }

    public final MTCardRankingCmcSlot getCmcSlot() {
        return this.cmcSlot;
    }

    public final MTCardRankingFlags getFlags() {
        return this.flags;
    }

    public final Integer getInclusionRate() {
        return this.inclusionRate;
    }

    public final String getOverallLabel() {
        return this.overallLabel;
    }

    public final Double getPopularityPct() {
        return this.popularityPct;
    }

    public final String getPopularityTier() {
        return this.popularityTier;
    }

    public final String getProtectionReason() {
        return this.protectionReason;
    }

    public final MTCardRankingRedundancy getRedundancy() {
        return this.redundancy;
    }

    public final MTCardRankingSignals getSignals() {
        return this.signals;
    }

    public final List<String> getSignalsList() {
        return this.signalsList;
    }

    public final Integer getSignalsVersion() {
        return this.signalsVersion;
    }

    public final int getSortPriority() {
        return this.sortPriority;
    }

    public final Integer getTotalCommanderDecks() {
        return this.totalCommanderDecks;
    }

    public final String getVerdict() {
        return this.verdict;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.isCommander) * 31) + Integer.hashCode(this.sortPriority)) * 31;
        String str = this.verdict;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.overallLabel;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.signalsVersion;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.protectionReason;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        MTCardRankingFlags mTCardRankingFlags = this.flags;
        int iHashCode6 = (iHashCode5 + (mTCardRankingFlags == null ? 0 : mTCardRankingFlags.hashCode())) * 31;
        String str4 = this.popularityTier;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Double d = this.popularityPct;
        int iHashCode8 = (iHashCode7 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.cardPower;
        int iHashCode9 = (iHashCode8 + (d2 == null ? 0 : d2.hashCode())) * 31;
        MTCardRankingSignals mTCardRankingSignals = this.signals;
        int iHashCode10 = (((iHashCode9 + (mTCardRankingSignals == null ? 0 : mTCardRankingSignals.hashCode())) * 31) + this.signalsList.hashCode()) * 31;
        MTCardRankingRedundancy mTCardRankingRedundancy = this.redundancy;
        int iHashCode11 = (iHashCode10 + (mTCardRankingRedundancy == null ? 0 : mTCardRankingRedundancy.hashCode())) * 31;
        Integer num2 = this.inclusionRate;
        int iHashCode12 = (iHashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.totalCommanderDecks;
        int iHashCode13 = (iHashCode12 + (num3 == null ? 0 : num3.hashCode())) * 31;
        MTCardRankingCmcSlot mTCardRankingCmcSlot = this.cmcSlot;
        return iHashCode13 + (mTCardRankingCmcSlot != null ? mTCardRankingCmcSlot.hashCode() : 0);
    }

    public final boolean isCommander() {
        return this.isCommander;
    }

    public String toString() {
        return "MTCardRanking(isCommander=" + this.isCommander + ", sortPriority=" + this.sortPriority + ", verdict=" + this.verdict + ", overallLabel=" + this.overallLabel + ", signalsVersion=" + this.signalsVersion + ", protectionReason=" + this.protectionReason + ", flags=" + this.flags + ", popularityTier=" + this.popularityTier + ", popularityPct=" + this.popularityPct + ", cardPower=" + this.cardPower + ", signals=" + this.signals + ", signalsList=" + this.signalsList + ", redundancy=" + this.redundancy + ", inclusionRate=" + this.inclusionRate + ", totalCommanderDecks=" + this.totalCommanderDecks + ", cmcSlot=" + this.cmcSlot + ")";
    }
}
