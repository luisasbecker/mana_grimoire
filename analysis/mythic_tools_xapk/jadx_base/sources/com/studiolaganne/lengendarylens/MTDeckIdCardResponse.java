package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bõ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\r\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0004\b%\u0010&J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00180\rHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010 HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010EJ\u000b\u0010[\u001a\u0004\u0018\u00010#HÆ\u0003J\u000f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00050\rHÆ\u0003Jü\u0001\u0010]\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\rHÆ\u0001¢\u0006\u0002\u0010^J\u0013\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010b\u001a\u00020\u0003HÖ\u0001J\t\u0010c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\r¢\u0006\b\n\u0000\u001a\u0004\b;\u00102R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0015\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010F\u001a\u0004\bD\u0010ER\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\bI\u00102¨\u0006d"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeckIdCardResponse;", "", "deckId", "", "deckName", "", "commander", "Lcom/studiolaganne/lengendarylens/MTIdCardCommander;", "partner", "colors", "powerLevel", "Lcom/studiolaganne/lengendarylens/MTIdCardPowerLevel;", "winConditions", "", "Lcom/studiolaganne/lengendarylens/MTIdCardWinCondition;", "keyStats", "Lcom/studiolaganne/lengendarylens/MTIdCardKeyStats;", "combos", "Lcom/studiolaganne/lengendarylens/MTIdCardCombos;", "tagProfile", "Lcom/studiolaganne/lengendarylens/MTIdCardTagProfile;", "themeAnalysis", "Lcom/studiolaganne/lengendarylens/MTIdCardThemeAnalysis;", "insights", "Lcom/studiolaganne/lengendarylens/MTIdCardDeckInsight;", "deckHealthScore", "Lcom/studiolaganne/lengendarylens/MTIdCardDeckHealthScore;", "gameStats", "Lcom/studiolaganne/lengendarylens/MTIdCardGameStats;", "manaBaseAnalysis", "Lcom/studiolaganne/lengendarylens/MTIdCardManaBaseAnalysis;", "consistency", "Lcom/studiolaganne/lengendarylens/MTIdCardConsistency;", "globalScore", "playgroupMeta", "Lcom/studiolaganne/lengendarylens/MTIdCardPlaygroupMeta;", "metaInsights", "<init>", "(ILjava/lang/String;Lcom/studiolaganne/lengendarylens/MTIdCardCommander;Lcom/studiolaganne/lengendarylens/MTIdCardCommander;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTIdCardPowerLevel;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTIdCardKeyStats;Lcom/studiolaganne/lengendarylens/MTIdCardCombos;Lcom/studiolaganne/lengendarylens/MTIdCardTagProfile;Lcom/studiolaganne/lengendarylens/MTIdCardThemeAnalysis;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTIdCardDeckHealthScore;Lcom/studiolaganne/lengendarylens/MTIdCardGameStats;Lcom/studiolaganne/lengendarylens/MTIdCardManaBaseAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardConsistency;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTIdCardPlaygroupMeta;Ljava/util/List;)V", "getDeckId", "()I", "getDeckName", "()Ljava/lang/String;", "getCommander", "()Lcom/studiolaganne/lengendarylens/MTIdCardCommander;", "getPartner", "getColors", "getPowerLevel", "()Lcom/studiolaganne/lengendarylens/MTIdCardPowerLevel;", "getWinConditions", "()Ljava/util/List;", "getKeyStats", "()Lcom/studiolaganne/lengendarylens/MTIdCardKeyStats;", "getCombos", "()Lcom/studiolaganne/lengendarylens/MTIdCardCombos;", "getTagProfile", "()Lcom/studiolaganne/lengendarylens/MTIdCardTagProfile;", "getThemeAnalysis", "()Lcom/studiolaganne/lengendarylens/MTIdCardThemeAnalysis;", "getInsights", "getDeckHealthScore", "()Lcom/studiolaganne/lengendarylens/MTIdCardDeckHealthScore;", "getGameStats", "()Lcom/studiolaganne/lengendarylens/MTIdCardGameStats;", "getManaBaseAnalysis", "()Lcom/studiolaganne/lengendarylens/MTIdCardManaBaseAnalysis;", "getConsistency", "()Lcom/studiolaganne/lengendarylens/MTIdCardConsistency;", "getGlobalScore", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPlaygroupMeta", "()Lcom/studiolaganne/lengendarylens/MTIdCardPlaygroupMeta;", "getMetaInsights", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(ILjava/lang/String;Lcom/studiolaganne/lengendarylens/MTIdCardCommander;Lcom/studiolaganne/lengendarylens/MTIdCardCommander;Ljava/lang/String;Lcom/studiolaganne/lengendarylens/MTIdCardPowerLevel;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTIdCardKeyStats;Lcom/studiolaganne/lengendarylens/MTIdCardCombos;Lcom/studiolaganne/lengendarylens/MTIdCardTagProfile;Lcom/studiolaganne/lengendarylens/MTIdCardThemeAnalysis;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTIdCardDeckHealthScore;Lcom/studiolaganne/lengendarylens/MTIdCardGameStats;Lcom/studiolaganne/lengendarylens/MTIdCardManaBaseAnalysis;Lcom/studiolaganne/lengendarylens/MTIdCardConsistency;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTIdCardPlaygroupMeta;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTDeckIdCardResponse;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeckIdCardResponse {
    public static final int $stable = 8;
    private final String colors;
    private final MTIdCardCombos combos;
    private final MTIdCardCommander commander;
    private final MTIdCardConsistency consistency;
    private final MTIdCardDeckHealthScore deckHealthScore;
    private final int deckId;
    private final String deckName;
    private final MTIdCardGameStats gameStats;
    private final Integer globalScore;
    private final List<MTIdCardDeckInsight> insights;
    private final MTIdCardKeyStats keyStats;
    private final MTIdCardManaBaseAnalysis manaBaseAnalysis;
    private final List<String> metaInsights;
    private final MTIdCardCommander partner;
    private final MTIdCardPlaygroupMeta playgroupMeta;
    private final MTIdCardPowerLevel powerLevel;
    private final MTIdCardTagProfile tagProfile;
    private final MTIdCardThemeAnalysis themeAnalysis;
    private final List<MTIdCardWinCondition> winConditions;

    public MTDeckIdCardResponse() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    public MTDeckIdCardResponse(int i, String str, MTIdCardCommander mTIdCardCommander, MTIdCardCommander mTIdCardCommander2, String str2, MTIdCardPowerLevel mTIdCardPowerLevel, List<MTIdCardWinCondition> winConditions, MTIdCardKeyStats mTIdCardKeyStats, MTIdCardCombos mTIdCardCombos, MTIdCardTagProfile mTIdCardTagProfile, MTIdCardThemeAnalysis mTIdCardThemeAnalysis, List<MTIdCardDeckInsight> insights, MTIdCardDeckHealthScore mTIdCardDeckHealthScore, MTIdCardGameStats mTIdCardGameStats, MTIdCardManaBaseAnalysis mTIdCardManaBaseAnalysis, MTIdCardConsistency mTIdCardConsistency, Integer num, MTIdCardPlaygroupMeta mTIdCardPlaygroupMeta, List<String> metaInsights) {
        Intrinsics.checkNotNullParameter(winConditions, "winConditions");
        Intrinsics.checkNotNullParameter(insights, "insights");
        Intrinsics.checkNotNullParameter(metaInsights, "metaInsights");
        this.deckId = i;
        this.deckName = str;
        this.commander = mTIdCardCommander;
        this.partner = mTIdCardCommander2;
        this.colors = str2;
        this.powerLevel = mTIdCardPowerLevel;
        this.winConditions = winConditions;
        this.keyStats = mTIdCardKeyStats;
        this.combos = mTIdCardCombos;
        this.tagProfile = mTIdCardTagProfile;
        this.themeAnalysis = mTIdCardThemeAnalysis;
        this.insights = insights;
        this.deckHealthScore = mTIdCardDeckHealthScore;
        this.gameStats = mTIdCardGameStats;
        this.manaBaseAnalysis = mTIdCardManaBaseAnalysis;
        this.consistency = mTIdCardConsistency;
        this.globalScore = num;
        this.playgroupMeta = mTIdCardPlaygroupMeta;
        this.metaInsights = metaInsights;
    }

    public /* synthetic */ MTDeckIdCardResponse(int i, String str, MTIdCardCommander mTIdCardCommander, MTIdCardCommander mTIdCardCommander2, String str2, MTIdCardPowerLevel mTIdCardPowerLevel, List list, MTIdCardKeyStats mTIdCardKeyStats, MTIdCardCombos mTIdCardCombos, MTIdCardTagProfile mTIdCardTagProfile, MTIdCardThemeAnalysis mTIdCardThemeAnalysis, List list2, MTIdCardDeckHealthScore mTIdCardDeckHealthScore, MTIdCardGameStats mTIdCardGameStats, MTIdCardManaBaseAnalysis mTIdCardManaBaseAnalysis, MTIdCardConsistency mTIdCardConsistency, Integer num, MTIdCardPlaygroupMeta mTIdCardPlaygroupMeta, List list3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : mTIdCardCommander, (i2 & 8) != 0 ? null : mTIdCardCommander2, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? null : mTIdCardPowerLevel, (i2 & 64) != 0 ? CollectionsKt.emptyList() : list, (i2 & 128) != 0 ? null : mTIdCardKeyStats, (i2 & 256) != 0 ? null : mTIdCardCombos, (i2 & 512) != 0 ? null : mTIdCardTagProfile, (i2 & 1024) != 0 ? null : mTIdCardThemeAnalysis, (i2 & 2048) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 4096) != 0 ? null : mTIdCardDeckHealthScore, (i2 & 8192) != 0 ? null : mTIdCardGameStats, (i2 & 16384) != 0 ? null : mTIdCardManaBaseAnalysis, (i2 & 32768) != 0 ? null : mTIdCardConsistency, (i2 & 65536) != 0 ? null : num, (i2 & 131072) != 0 ? null : mTIdCardPlaygroupMeta, (i2 & 262144) != 0 ? CollectionsKt.emptyList() : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTDeckIdCardResponse copy$default(MTDeckIdCardResponse mTDeckIdCardResponse, int i, String str, MTIdCardCommander mTIdCardCommander, MTIdCardCommander mTIdCardCommander2, String str2, MTIdCardPowerLevel mTIdCardPowerLevel, List list, MTIdCardKeyStats mTIdCardKeyStats, MTIdCardCombos mTIdCardCombos, MTIdCardTagProfile mTIdCardTagProfile, MTIdCardThemeAnalysis mTIdCardThemeAnalysis, List list2, MTIdCardDeckHealthScore mTIdCardDeckHealthScore, MTIdCardGameStats mTIdCardGameStats, MTIdCardManaBaseAnalysis mTIdCardManaBaseAnalysis, MTIdCardConsistency mTIdCardConsistency, Integer num, MTIdCardPlaygroupMeta mTIdCardPlaygroupMeta, List list3, int i2, Object obj) {
        List list4;
        MTIdCardPlaygroupMeta mTIdCardPlaygroupMeta2;
        int i3 = (i2 & 1) != 0 ? mTDeckIdCardResponse.deckId : i;
        String str3 = (i2 & 2) != 0 ? mTDeckIdCardResponse.deckName : str;
        MTIdCardCommander mTIdCardCommander3 = (i2 & 4) != 0 ? mTDeckIdCardResponse.commander : mTIdCardCommander;
        MTIdCardCommander mTIdCardCommander4 = (i2 & 8) != 0 ? mTDeckIdCardResponse.partner : mTIdCardCommander2;
        String str4 = (i2 & 16) != 0 ? mTDeckIdCardResponse.colors : str2;
        MTIdCardPowerLevel mTIdCardPowerLevel2 = (i2 & 32) != 0 ? mTDeckIdCardResponse.powerLevel : mTIdCardPowerLevel;
        List list5 = (i2 & 64) != 0 ? mTDeckIdCardResponse.winConditions : list;
        MTIdCardKeyStats mTIdCardKeyStats2 = (i2 & 128) != 0 ? mTDeckIdCardResponse.keyStats : mTIdCardKeyStats;
        MTIdCardCombos mTIdCardCombos2 = (i2 & 256) != 0 ? mTDeckIdCardResponse.combos : mTIdCardCombos;
        MTIdCardTagProfile mTIdCardTagProfile2 = (i2 & 512) != 0 ? mTDeckIdCardResponse.tagProfile : mTIdCardTagProfile;
        MTIdCardThemeAnalysis mTIdCardThemeAnalysis2 = (i2 & 1024) != 0 ? mTDeckIdCardResponse.themeAnalysis : mTIdCardThemeAnalysis;
        List list6 = (i2 & 2048) != 0 ? mTDeckIdCardResponse.insights : list2;
        MTIdCardDeckHealthScore mTIdCardDeckHealthScore2 = (i2 & 4096) != 0 ? mTDeckIdCardResponse.deckHealthScore : mTIdCardDeckHealthScore;
        MTIdCardGameStats mTIdCardGameStats2 = (i2 & 8192) != 0 ? mTDeckIdCardResponse.gameStats : mTIdCardGameStats;
        int i4 = i3;
        MTIdCardManaBaseAnalysis mTIdCardManaBaseAnalysis2 = (i2 & 16384) != 0 ? mTDeckIdCardResponse.manaBaseAnalysis : mTIdCardManaBaseAnalysis;
        MTIdCardConsistency mTIdCardConsistency2 = (i2 & 32768) != 0 ? mTDeckIdCardResponse.consistency : mTIdCardConsistency;
        Integer num2 = (i2 & 65536) != 0 ? mTDeckIdCardResponse.globalScore : num;
        MTIdCardPlaygroupMeta mTIdCardPlaygroupMeta3 = (i2 & 131072) != 0 ? mTDeckIdCardResponse.playgroupMeta : mTIdCardPlaygroupMeta;
        if ((i2 & 262144) != 0) {
            mTIdCardPlaygroupMeta2 = mTIdCardPlaygroupMeta3;
            list4 = mTDeckIdCardResponse.metaInsights;
        } else {
            list4 = list3;
            mTIdCardPlaygroupMeta2 = mTIdCardPlaygroupMeta3;
        }
        return mTDeckIdCardResponse.copy(i4, str3, mTIdCardCommander3, mTIdCardCommander4, str4, mTIdCardPowerLevel2, list5, mTIdCardKeyStats2, mTIdCardCombos2, mTIdCardTagProfile2, mTIdCardThemeAnalysis2, list6, mTIdCardDeckHealthScore2, mTIdCardGameStats2, mTIdCardManaBaseAnalysis2, mTIdCardConsistency2, num2, mTIdCardPlaygroupMeta2, list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDeckId() {
        return this.deckId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final MTIdCardTagProfile getTagProfile() {
        return this.tagProfile;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final MTIdCardThemeAnalysis getThemeAnalysis() {
        return this.themeAnalysis;
    }

    public final List<MTIdCardDeckInsight> component12() {
        return this.insights;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final MTIdCardDeckHealthScore getDeckHealthScore() {
        return this.deckHealthScore;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final MTIdCardGameStats getGameStats() {
        return this.gameStats;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final MTIdCardManaBaseAnalysis getManaBaseAnalysis() {
        return this.manaBaseAnalysis;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final MTIdCardConsistency getConsistency() {
        return this.consistency;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Integer getGlobalScore() {
        return this.globalScore;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final MTIdCardPlaygroupMeta getPlaygroupMeta() {
        return this.playgroupMeta;
    }

    public final List<String> component19() {
        return this.metaInsights;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeckName() {
        return this.deckName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTIdCardCommander getCommander() {
        return this.commander;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTIdCardCommander getPartner() {
        return this.partner;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MTIdCardPowerLevel getPowerLevel() {
        return this.powerLevel;
    }

    public final List<MTIdCardWinCondition> component7() {
        return this.winConditions;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final MTIdCardKeyStats getKeyStats() {
        return this.keyStats;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final MTIdCardCombos getCombos() {
        return this.combos;
    }

    public final MTDeckIdCardResponse copy(int deckId, String deckName, MTIdCardCommander commander, MTIdCardCommander partner, String colors, MTIdCardPowerLevel powerLevel, List<MTIdCardWinCondition> winConditions, MTIdCardKeyStats keyStats, MTIdCardCombos combos, MTIdCardTagProfile tagProfile, MTIdCardThemeAnalysis themeAnalysis, List<MTIdCardDeckInsight> insights, MTIdCardDeckHealthScore deckHealthScore, MTIdCardGameStats gameStats, MTIdCardManaBaseAnalysis manaBaseAnalysis, MTIdCardConsistency consistency, Integer globalScore, MTIdCardPlaygroupMeta playgroupMeta, List<String> metaInsights) {
        Intrinsics.checkNotNullParameter(winConditions, "winConditions");
        Intrinsics.checkNotNullParameter(insights, "insights");
        Intrinsics.checkNotNullParameter(metaInsights, "metaInsights");
        return new MTDeckIdCardResponse(deckId, deckName, commander, partner, colors, powerLevel, winConditions, keyStats, combos, tagProfile, themeAnalysis, insights, deckHealthScore, gameStats, manaBaseAnalysis, consistency, globalScore, playgroupMeta, metaInsights);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeckIdCardResponse)) {
            return false;
        }
        MTDeckIdCardResponse mTDeckIdCardResponse = (MTDeckIdCardResponse) other;
        return this.deckId == mTDeckIdCardResponse.deckId && Intrinsics.areEqual(this.deckName, mTDeckIdCardResponse.deckName) && Intrinsics.areEqual(this.commander, mTDeckIdCardResponse.commander) && Intrinsics.areEqual(this.partner, mTDeckIdCardResponse.partner) && Intrinsics.areEqual(this.colors, mTDeckIdCardResponse.colors) && Intrinsics.areEqual(this.powerLevel, mTDeckIdCardResponse.powerLevel) && Intrinsics.areEqual(this.winConditions, mTDeckIdCardResponse.winConditions) && Intrinsics.areEqual(this.keyStats, mTDeckIdCardResponse.keyStats) && Intrinsics.areEqual(this.combos, mTDeckIdCardResponse.combos) && Intrinsics.areEqual(this.tagProfile, mTDeckIdCardResponse.tagProfile) && Intrinsics.areEqual(this.themeAnalysis, mTDeckIdCardResponse.themeAnalysis) && Intrinsics.areEqual(this.insights, mTDeckIdCardResponse.insights) && Intrinsics.areEqual(this.deckHealthScore, mTDeckIdCardResponse.deckHealthScore) && Intrinsics.areEqual(this.gameStats, mTDeckIdCardResponse.gameStats) && Intrinsics.areEqual(this.manaBaseAnalysis, mTDeckIdCardResponse.manaBaseAnalysis) && Intrinsics.areEqual(this.consistency, mTDeckIdCardResponse.consistency) && Intrinsics.areEqual(this.globalScore, mTDeckIdCardResponse.globalScore) && Intrinsics.areEqual(this.playgroupMeta, mTDeckIdCardResponse.playgroupMeta) && Intrinsics.areEqual(this.metaInsights, mTDeckIdCardResponse.metaInsights);
    }

    public final String getColors() {
        return this.colors;
    }

    public final MTIdCardCombos getCombos() {
        return this.combos;
    }

    public final MTIdCardCommander getCommander() {
        return this.commander;
    }

    public final MTIdCardConsistency getConsistency() {
        return this.consistency;
    }

    public final MTIdCardDeckHealthScore getDeckHealthScore() {
        return this.deckHealthScore;
    }

    public final int getDeckId() {
        return this.deckId;
    }

    public final String getDeckName() {
        return this.deckName;
    }

    public final MTIdCardGameStats getGameStats() {
        return this.gameStats;
    }

    public final Integer getGlobalScore() {
        return this.globalScore;
    }

    public final List<MTIdCardDeckInsight> getInsights() {
        return this.insights;
    }

    public final MTIdCardKeyStats getKeyStats() {
        return this.keyStats;
    }

    public final MTIdCardManaBaseAnalysis getManaBaseAnalysis() {
        return this.manaBaseAnalysis;
    }

    public final List<String> getMetaInsights() {
        return this.metaInsights;
    }

    public final MTIdCardCommander getPartner() {
        return this.partner;
    }

    public final MTIdCardPlaygroupMeta getPlaygroupMeta() {
        return this.playgroupMeta;
    }

    public final MTIdCardPowerLevel getPowerLevel() {
        return this.powerLevel;
    }

    public final MTIdCardTagProfile getTagProfile() {
        return this.tagProfile;
    }

    public final MTIdCardThemeAnalysis getThemeAnalysis() {
        return this.themeAnalysis;
    }

    public final List<MTIdCardWinCondition> getWinConditions() {
        return this.winConditions;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.deckId) * 31;
        String str = this.deckName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        MTIdCardCommander mTIdCardCommander = this.commander;
        int iHashCode3 = (iHashCode2 + (mTIdCardCommander == null ? 0 : mTIdCardCommander.hashCode())) * 31;
        MTIdCardCommander mTIdCardCommander2 = this.partner;
        int iHashCode4 = (iHashCode3 + (mTIdCardCommander2 == null ? 0 : mTIdCardCommander2.hashCode())) * 31;
        String str2 = this.colors;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        MTIdCardPowerLevel mTIdCardPowerLevel = this.powerLevel;
        int iHashCode6 = (((iHashCode5 + (mTIdCardPowerLevel == null ? 0 : mTIdCardPowerLevel.hashCode())) * 31) + this.winConditions.hashCode()) * 31;
        MTIdCardKeyStats mTIdCardKeyStats = this.keyStats;
        int iHashCode7 = (iHashCode6 + (mTIdCardKeyStats == null ? 0 : mTIdCardKeyStats.hashCode())) * 31;
        MTIdCardCombos mTIdCardCombos = this.combos;
        int iHashCode8 = (iHashCode7 + (mTIdCardCombos == null ? 0 : mTIdCardCombos.hashCode())) * 31;
        MTIdCardTagProfile mTIdCardTagProfile = this.tagProfile;
        int iHashCode9 = (iHashCode8 + (mTIdCardTagProfile == null ? 0 : mTIdCardTagProfile.hashCode())) * 31;
        MTIdCardThemeAnalysis mTIdCardThemeAnalysis = this.themeAnalysis;
        int iHashCode10 = (((iHashCode9 + (mTIdCardThemeAnalysis == null ? 0 : mTIdCardThemeAnalysis.hashCode())) * 31) + this.insights.hashCode()) * 31;
        MTIdCardDeckHealthScore mTIdCardDeckHealthScore = this.deckHealthScore;
        int iHashCode11 = (iHashCode10 + (mTIdCardDeckHealthScore == null ? 0 : mTIdCardDeckHealthScore.hashCode())) * 31;
        MTIdCardGameStats mTIdCardGameStats = this.gameStats;
        int iHashCode12 = (iHashCode11 + (mTIdCardGameStats == null ? 0 : mTIdCardGameStats.hashCode())) * 31;
        MTIdCardManaBaseAnalysis mTIdCardManaBaseAnalysis = this.manaBaseAnalysis;
        int iHashCode13 = (iHashCode12 + (mTIdCardManaBaseAnalysis == null ? 0 : mTIdCardManaBaseAnalysis.hashCode())) * 31;
        MTIdCardConsistency mTIdCardConsistency = this.consistency;
        int iHashCode14 = (iHashCode13 + (mTIdCardConsistency == null ? 0 : mTIdCardConsistency.hashCode())) * 31;
        Integer num = this.globalScore;
        int iHashCode15 = (iHashCode14 + (num == null ? 0 : num.hashCode())) * 31;
        MTIdCardPlaygroupMeta mTIdCardPlaygroupMeta = this.playgroupMeta;
        return ((iHashCode15 + (mTIdCardPlaygroupMeta != null ? mTIdCardPlaygroupMeta.hashCode() : 0)) * 31) + this.metaInsights.hashCode();
    }

    public String toString() {
        return "MTDeckIdCardResponse(deckId=" + this.deckId + ", deckName=" + this.deckName + ", commander=" + this.commander + ", partner=" + this.partner + ", colors=" + this.colors + ", powerLevel=" + this.powerLevel + ", winConditions=" + this.winConditions + ", keyStats=" + this.keyStats + ", combos=" + this.combos + ", tagProfile=" + this.tagProfile + ", themeAnalysis=" + this.themeAnalysis + ", insights=" + this.insights + ", deckHealthScore=" + this.deckHealthScore + ", gameStats=" + this.gameStats + ", manaBaseAnalysis=" + this.manaBaseAnalysis + ", consistency=" + this.consistency + ", globalScore=" + this.globalScore + ", playgroupMeta=" + this.playgroupMeta + ", metaInsights=" + this.metaInsights + ")";
    }
}
