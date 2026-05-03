package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bÿ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0014¢\u0006\u0004\b \u0010!J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010F\u001a\u00020\bHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010K\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010L\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010P\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010Q\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010U\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0014HÆ\u0003J\u0086\u0002\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010[\u001a\u00020\bHÖ\u0001J\t\u0010\\\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u00102\u001a\u0004\b3\u00101R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u00102\u001a\u0004\b:\u00101R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b;\u0010(R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010%R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010%R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010%R\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\bA\u00107¨\u0006]"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardExplainResponse;", "", "card", "Lcom/studiolaganne/lengendarylens/MTCardExplainCard;", "verdict", "", "overallLabel", "signalsVersion", "", "sortPriority", "protectionReason", "flags", "Lcom/studiolaganne/lengendarylens/MTCardRankingFlags;", "popularityTier", "popularityPct", "", "cardPower", "signals", "Lcom/studiolaganne/lengendarylens/MTCardRankingSignals;", "signalsList", "", "redundancy", "Lcom/studiolaganne/lengendarylens/MTCardRankingRedundancy;", "inclusionRate", "totalCommanderDecks", "cmcSlot", "Lcom/studiolaganne/lengendarylens/MTCardRankingCmcSlot;", "commanderName", "rationale_en", "rationale_fr", "replacements", "Lcom/studiolaganne/lengendarylens/MTCardExplainReplacement;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTCardExplainCard;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Lcom/studiolaganne/lengendarylens/MTCardRankingFlags;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Lcom/studiolaganne/lengendarylens/MTCardRankingSignals;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTCardRankingRedundancy;Ljava/lang/Double;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTCardRankingCmcSlot;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCard", "()Lcom/studiolaganne/lengendarylens/MTCardExplainCard;", "getVerdict", "()Ljava/lang/String;", "getOverallLabel", "getSignalsVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSortPriority", "()I", "getProtectionReason", "getFlags", "()Lcom/studiolaganne/lengendarylens/MTCardRankingFlags;", "getPopularityTier", "getPopularityPct", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCardPower", "getSignals", "()Lcom/studiolaganne/lengendarylens/MTCardRankingSignals;", "getSignalsList", "()Ljava/util/List;", "getRedundancy", "()Lcom/studiolaganne/lengendarylens/MTCardRankingRedundancy;", "getInclusionRate", "getTotalCommanderDecks", "getCmcSlot", "()Lcom/studiolaganne/lengendarylens/MTCardRankingCmcSlot;", "getCommanderName", "getRationale_en", "getRationale_fr", "getReplacements", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Lcom/studiolaganne/lengendarylens/MTCardExplainCard;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Lcom/studiolaganne/lengendarylens/MTCardRankingFlags;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Lcom/studiolaganne/lengendarylens/MTCardRankingSignals;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTCardRankingRedundancy;Ljava/lang/Double;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTCardRankingCmcSlot;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTCardExplainResponse;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardExplainResponse {
    public static final int $stable = 8;
    private final MTCardExplainCard card;
    private final Double cardPower;
    private final MTCardRankingCmcSlot cmcSlot;
    private final String commanderName;
    private final MTCardRankingFlags flags;
    private final Double inclusionRate;
    private final String overallLabel;
    private final Double popularityPct;
    private final String popularityTier;
    private final String protectionReason;
    private final String rationale_en;
    private final String rationale_fr;
    private final MTCardRankingRedundancy redundancy;
    private final List<MTCardExplainReplacement> replacements;
    private final MTCardRankingSignals signals;
    private final List<String> signalsList;
    private final Integer signalsVersion;
    private final int sortPriority;
    private final Integer totalCommanderDecks;
    private final String verdict;

    public MTCardExplainResponse() {
        this(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    public MTCardExplainResponse(MTCardExplainCard mTCardExplainCard, String str, String str2, Integer num, int i, String str3, MTCardRankingFlags mTCardRankingFlags, String str4, Double d, Double d2, MTCardRankingSignals mTCardRankingSignals, List<String> signalsList, MTCardRankingRedundancy mTCardRankingRedundancy, Double d3, Integer num2, MTCardRankingCmcSlot mTCardRankingCmcSlot, String str5, String str6, String str7, List<MTCardExplainReplacement> list) {
        Intrinsics.checkNotNullParameter(signalsList, "signalsList");
        this.card = mTCardExplainCard;
        this.verdict = str;
        this.overallLabel = str2;
        this.signalsVersion = num;
        this.sortPriority = i;
        this.protectionReason = str3;
        this.flags = mTCardRankingFlags;
        this.popularityTier = str4;
        this.popularityPct = d;
        this.cardPower = d2;
        this.signals = mTCardRankingSignals;
        this.signalsList = signalsList;
        this.redundancy = mTCardRankingRedundancy;
        this.inclusionRate = d3;
        this.totalCommanderDecks = num2;
        this.cmcSlot = mTCardRankingCmcSlot;
        this.commanderName = str5;
        this.rationale_en = str6;
        this.rationale_fr = str7;
        this.replacements = list;
    }

    public /* synthetic */ MTCardExplainResponse(MTCardExplainCard mTCardExplainCard, String str, String str2, Integer num, int i, String str3, MTCardRankingFlags mTCardRankingFlags, String str4, Double d, Double d2, MTCardRankingSignals mTCardRankingSignals, List list, MTCardRankingRedundancy mTCardRankingRedundancy, Double d3, Integer num2, MTCardRankingCmcSlot mTCardRankingCmcSlot, String str5, String str6, String str7, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : mTCardExplainCard, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : mTCardRankingFlags, (i2 & 128) != 0 ? null : str4, (i2 & 256) != 0 ? null : d, (i2 & 512) != 0 ? null : d2, (i2 & 1024) != 0 ? null : mTCardRankingSignals, (i2 & 2048) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4096) != 0 ? null : mTCardRankingRedundancy, (i2 & 8192) != 0 ? null : d3, (i2 & 16384) != 0 ? null : num2, (i2 & 32768) != 0 ? null : mTCardRankingCmcSlot, (i2 & 65536) != 0 ? null : str5, (i2 & 131072) != 0 ? null : str6, (i2 & 262144) != 0 ? null : str7, (i2 & 524288) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardExplainResponse copy$default(MTCardExplainResponse mTCardExplainResponse, MTCardExplainCard mTCardExplainCard, String str, String str2, Integer num, int i, String str3, MTCardRankingFlags mTCardRankingFlags, String str4, Double d, Double d2, MTCardRankingSignals mTCardRankingSignals, List list, MTCardRankingRedundancy mTCardRankingRedundancy, Double d3, Integer num2, MTCardRankingCmcSlot mTCardRankingCmcSlot, String str5, String str6, String str7, List list2, int i2, Object obj) {
        List list3;
        String str8;
        MTCardExplainCard mTCardExplainCard2 = (i2 & 1) != 0 ? mTCardExplainResponse.card : mTCardExplainCard;
        String str9 = (i2 & 2) != 0 ? mTCardExplainResponse.verdict : str;
        String str10 = (i2 & 4) != 0 ? mTCardExplainResponse.overallLabel : str2;
        Integer num3 = (i2 & 8) != 0 ? mTCardExplainResponse.signalsVersion : num;
        int i3 = (i2 & 16) != 0 ? mTCardExplainResponse.sortPriority : i;
        String str11 = (i2 & 32) != 0 ? mTCardExplainResponse.protectionReason : str3;
        MTCardRankingFlags mTCardRankingFlags2 = (i2 & 64) != 0 ? mTCardExplainResponse.flags : mTCardRankingFlags;
        String str12 = (i2 & 128) != 0 ? mTCardExplainResponse.popularityTier : str4;
        Double d4 = (i2 & 256) != 0 ? mTCardExplainResponse.popularityPct : d;
        Double d5 = (i2 & 512) != 0 ? mTCardExplainResponse.cardPower : d2;
        MTCardRankingSignals mTCardRankingSignals2 = (i2 & 1024) != 0 ? mTCardExplainResponse.signals : mTCardRankingSignals;
        List list4 = (i2 & 2048) != 0 ? mTCardExplainResponse.signalsList : list;
        MTCardRankingRedundancy mTCardRankingRedundancy2 = (i2 & 4096) != 0 ? mTCardExplainResponse.redundancy : mTCardRankingRedundancy;
        Double d6 = (i2 & 8192) != 0 ? mTCardExplainResponse.inclusionRate : d3;
        MTCardExplainCard mTCardExplainCard3 = mTCardExplainCard2;
        Integer num4 = (i2 & 16384) != 0 ? mTCardExplainResponse.totalCommanderDecks : num2;
        MTCardRankingCmcSlot mTCardRankingCmcSlot2 = (i2 & 32768) != 0 ? mTCardExplainResponse.cmcSlot : mTCardRankingCmcSlot;
        String str13 = (i2 & 65536) != 0 ? mTCardExplainResponse.commanderName : str5;
        String str14 = (i2 & 131072) != 0 ? mTCardExplainResponse.rationale_en : str6;
        String str15 = (i2 & 262144) != 0 ? mTCardExplainResponse.rationale_fr : str7;
        if ((i2 & 524288) != 0) {
            str8 = str15;
            list3 = mTCardExplainResponse.replacements;
        } else {
            list3 = list2;
            str8 = str15;
        }
        return mTCardExplainResponse.copy(mTCardExplainCard3, str9, str10, num3, i3, str11, mTCardRankingFlags2, str12, d4, d5, mTCardRankingSignals2, list4, mTCardRankingRedundancy2, d6, num4, mTCardRankingCmcSlot2, str13, str14, str8, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTCardExplainCard getCard() {
        return this.card;
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
    public final Double getInclusionRate() {
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

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getCommanderName() {
        return this.commanderName;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getRationale_en() {
        return this.rationale_en;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getRationale_fr() {
        return this.rationale_fr;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVerdict() {
        return this.verdict;
    }

    public final List<MTCardExplainReplacement> component20() {
        return this.replacements;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOverallLabel() {
        return this.overallLabel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getSignalsVersion() {
        return this.signalsVersion;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSortPriority() {
        return this.sortPriority;
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

    public final MTCardExplainResponse copy(MTCardExplainCard card, String verdict, String overallLabel, Integer signalsVersion, int sortPriority, String protectionReason, MTCardRankingFlags flags, String popularityTier, Double popularityPct, Double cardPower, MTCardRankingSignals signals, List<String> signalsList, MTCardRankingRedundancy redundancy, Double inclusionRate, Integer totalCommanderDecks, MTCardRankingCmcSlot cmcSlot, String commanderName, String rationale_en, String rationale_fr, List<MTCardExplainReplacement> replacements) {
        Intrinsics.checkNotNullParameter(signalsList, "signalsList");
        return new MTCardExplainResponse(card, verdict, overallLabel, signalsVersion, sortPriority, protectionReason, flags, popularityTier, popularityPct, cardPower, signals, signalsList, redundancy, inclusionRate, totalCommanderDecks, cmcSlot, commanderName, rationale_en, rationale_fr, replacements);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardExplainResponse)) {
            return false;
        }
        MTCardExplainResponse mTCardExplainResponse = (MTCardExplainResponse) other;
        return Intrinsics.areEqual(this.card, mTCardExplainResponse.card) && Intrinsics.areEqual(this.verdict, mTCardExplainResponse.verdict) && Intrinsics.areEqual(this.overallLabel, mTCardExplainResponse.overallLabel) && Intrinsics.areEqual(this.signalsVersion, mTCardExplainResponse.signalsVersion) && this.sortPriority == mTCardExplainResponse.sortPriority && Intrinsics.areEqual(this.protectionReason, mTCardExplainResponse.protectionReason) && Intrinsics.areEqual(this.flags, mTCardExplainResponse.flags) && Intrinsics.areEqual(this.popularityTier, mTCardExplainResponse.popularityTier) && Intrinsics.areEqual((Object) this.popularityPct, (Object) mTCardExplainResponse.popularityPct) && Intrinsics.areEqual((Object) this.cardPower, (Object) mTCardExplainResponse.cardPower) && Intrinsics.areEqual(this.signals, mTCardExplainResponse.signals) && Intrinsics.areEqual(this.signalsList, mTCardExplainResponse.signalsList) && Intrinsics.areEqual(this.redundancy, mTCardExplainResponse.redundancy) && Intrinsics.areEqual((Object) this.inclusionRate, (Object) mTCardExplainResponse.inclusionRate) && Intrinsics.areEqual(this.totalCommanderDecks, mTCardExplainResponse.totalCommanderDecks) && Intrinsics.areEqual(this.cmcSlot, mTCardExplainResponse.cmcSlot) && Intrinsics.areEqual(this.commanderName, mTCardExplainResponse.commanderName) && Intrinsics.areEqual(this.rationale_en, mTCardExplainResponse.rationale_en) && Intrinsics.areEqual(this.rationale_fr, mTCardExplainResponse.rationale_fr) && Intrinsics.areEqual(this.replacements, mTCardExplainResponse.replacements);
    }

    public final MTCardExplainCard getCard() {
        return this.card;
    }

    public final Double getCardPower() {
        return this.cardPower;
    }

    public final MTCardRankingCmcSlot getCmcSlot() {
        return this.cmcSlot;
    }

    public final String getCommanderName() {
        return this.commanderName;
    }

    public final MTCardRankingFlags getFlags() {
        return this.flags;
    }

    public final Double getInclusionRate() {
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

    public final String getRationale_en() {
        return this.rationale_en;
    }

    public final String getRationale_fr() {
        return this.rationale_fr;
    }

    public final MTCardRankingRedundancy getRedundancy() {
        return this.redundancy;
    }

    public final List<MTCardExplainReplacement> getReplacements() {
        return this.replacements;
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
        MTCardExplainCard mTCardExplainCard = this.card;
        int iHashCode = (mTCardExplainCard == null ? 0 : mTCardExplainCard.hashCode()) * 31;
        String str = this.verdict;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.overallLabel;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.signalsVersion;
        int iHashCode4 = (((iHashCode3 + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.sortPriority)) * 31;
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
        Double d3 = this.inclusionRate;
        int iHashCode12 = (iHashCode11 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Integer num2 = this.totalCommanderDecks;
        int iHashCode13 = (iHashCode12 + (num2 == null ? 0 : num2.hashCode())) * 31;
        MTCardRankingCmcSlot mTCardRankingCmcSlot = this.cmcSlot;
        int iHashCode14 = (iHashCode13 + (mTCardRankingCmcSlot == null ? 0 : mTCardRankingCmcSlot.hashCode())) * 31;
        String str5 = this.commanderName;
        int iHashCode15 = (iHashCode14 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.rationale_en;
        int iHashCode16 = (iHashCode15 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.rationale_fr;
        int iHashCode17 = (iHashCode16 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<MTCardExplainReplacement> list = this.replacements;
        return iHashCode17 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "MTCardExplainResponse(card=" + this.card + ", verdict=" + this.verdict + ", overallLabel=" + this.overallLabel + ", signalsVersion=" + this.signalsVersion + ", sortPriority=" + this.sortPriority + ", protectionReason=" + this.protectionReason + ", flags=" + this.flags + ", popularityTier=" + this.popularityTier + ", popularityPct=" + this.popularityPct + ", cardPower=" + this.cardPower + ", signals=" + this.signals + ", signalsList=" + this.signalsList + ", redundancy=" + this.redundancy + ", inclusionRate=" + this.inclusionRate + ", totalCommanderDecks=" + this.totalCommanderDecks + ", cmcSlot=" + this.cmcSlot + ", commanderName=" + this.commanderName + ", rationale_en=" + this.rationale_en + ", rationale_fr=" + this.rationale_fr + ", replacements=" + this.replacements + ")";
    }
}
