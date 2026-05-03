package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u0017\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010%\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jv\u0010&\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\tHÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingsResponse;", "", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "commanderNames", "", "deckAutoTags", "", "", "summary", "Lcom/studiolaganne/lengendarylens/MTCardRankingsSummary;", "signalsVersion", "deckPowerScore", "blendProfile", "Lcom/studiolaganne/lengendarylens/MTCardRankingBlendProfile;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;Lcom/studiolaganne/lengendarylens/MTCardRankingsSummary;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTCardRankingBlendProfile;)V", "getCards", "()Ljava/util/List;", "getCommanderNames", "getDeckAutoTags", "()Ljava/util/Map;", "getSummary", "()Lcom/studiolaganne/lengendarylens/MTCardRankingsSummary;", "getSignalsVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeckPowerScore", "getBlendProfile", "()Lcom/studiolaganne/lengendarylens/MTCardRankingBlendProfile;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;Lcom/studiolaganne/lengendarylens/MTCardRankingsSummary;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTCardRankingBlendProfile;)Lcom/studiolaganne/lengendarylens/MTCardRankingsResponse;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingsResponse {
    public static final int $stable = 8;
    private final MTCardRankingBlendProfile blendProfile;
    private final List<MTFullCard> cards;
    private final List<String> commanderNames;
    private final Map<String, Integer> deckAutoTags;
    private final Integer deckPowerScore;
    private final Integer signalsVersion;
    private final MTCardRankingsSummary summary;

    public MTCardRankingsResponse() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public MTCardRankingsResponse(List<MTFullCard> cards, List<String> commanderNames, Map<String, Integer> map, MTCardRankingsSummary mTCardRankingsSummary, Integer num, Integer num2, MTCardRankingBlendProfile mTCardRankingBlendProfile) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(commanderNames, "commanderNames");
        this.cards = cards;
        this.commanderNames = commanderNames;
        this.deckAutoTags = map;
        this.summary = mTCardRankingsSummary;
        this.signalsVersion = num;
        this.deckPowerScore = num2;
        this.blendProfile = mTCardRankingBlendProfile;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ MTCardRankingsResponse(java.util.List r2, java.util.List r3, java.util.Map r4, com.studiolaganne.lengendarylens.MTCardRankingsSummary r5, java.lang.Integer r6, java.lang.Integer r7, com.studiolaganne.lengendarylens.MTCardRankingBlendProfile r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r1 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L8
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L8:
            r10 = r9 & 2
            if (r10 == 0) goto L10
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        L10:
            r10 = r9 & 4
            r0 = 0
            if (r10 == 0) goto L16
            r4 = r0
        L16:
            r10 = r9 & 8
            if (r10 == 0) goto L1b
            r5 = r0
        L1b:
            r10 = r9 & 16
            if (r10 == 0) goto L20
            r6 = r0
        L20:
            r10 = r9 & 32
            if (r10 == 0) goto L25
            r7 = r0
        L25:
            r9 = r9 & 64
            if (r9 == 0) goto L32
            r10 = r0
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L3a
        L32:
            r10 = r8
            r9 = r7
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L3a:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.studiolaganne.lengendarylens.MTCardRankingsResponse.<init>(java.util.List, java.util.List, java.util.Map, com.studiolaganne.lengendarylens.MTCardRankingsSummary, java.lang.Integer, java.lang.Integer, com.studiolaganne.lengendarylens.MTCardRankingBlendProfile, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardRankingsResponse copy$default(MTCardRankingsResponse mTCardRankingsResponse, List list, List list2, Map map, MTCardRankingsSummary mTCardRankingsSummary, Integer num, Integer num2, MTCardRankingBlendProfile mTCardRankingBlendProfile, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTCardRankingsResponse.cards;
        }
        if ((i & 2) != 0) {
            list2 = mTCardRankingsResponse.commanderNames;
        }
        if ((i & 4) != 0) {
            map = mTCardRankingsResponse.deckAutoTags;
        }
        if ((i & 8) != 0) {
            mTCardRankingsSummary = mTCardRankingsResponse.summary;
        }
        if ((i & 16) != 0) {
            num = mTCardRankingsResponse.signalsVersion;
        }
        if ((i & 32) != 0) {
            num2 = mTCardRankingsResponse.deckPowerScore;
        }
        if ((i & 64) != 0) {
            mTCardRankingBlendProfile = mTCardRankingsResponse.blendProfile;
        }
        Integer num3 = num2;
        MTCardRankingBlendProfile mTCardRankingBlendProfile2 = mTCardRankingBlendProfile;
        Integer num4 = num;
        Map map2 = map;
        return mTCardRankingsResponse.copy(list, list2, map2, mTCardRankingsSummary, num4, num3, mTCardRankingBlendProfile2);
    }

    public final List<MTFullCard> component1() {
        return this.cards;
    }

    public final List<String> component2() {
        return this.commanderNames;
    }

    public final Map<String, Integer> component3() {
        return this.deckAutoTags;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTCardRankingsSummary getSummary() {
        return this.summary;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getSignalsVersion() {
        return this.signalsVersion;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getDeckPowerScore() {
        return this.deckPowerScore;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MTCardRankingBlendProfile getBlendProfile() {
        return this.blendProfile;
    }

    public final MTCardRankingsResponse copy(List<MTFullCard> cards, List<String> commanderNames, Map<String, Integer> deckAutoTags, MTCardRankingsSummary summary, Integer signalsVersion, Integer deckPowerScore, MTCardRankingBlendProfile blendProfile) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(commanderNames, "commanderNames");
        return new MTCardRankingsResponse(cards, commanderNames, deckAutoTags, summary, signalsVersion, deckPowerScore, blendProfile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingsResponse)) {
            return false;
        }
        MTCardRankingsResponse mTCardRankingsResponse = (MTCardRankingsResponse) other;
        return Intrinsics.areEqual(this.cards, mTCardRankingsResponse.cards) && Intrinsics.areEqual(this.commanderNames, mTCardRankingsResponse.commanderNames) && Intrinsics.areEqual(this.deckAutoTags, mTCardRankingsResponse.deckAutoTags) && Intrinsics.areEqual(this.summary, mTCardRankingsResponse.summary) && Intrinsics.areEqual(this.signalsVersion, mTCardRankingsResponse.signalsVersion) && Intrinsics.areEqual(this.deckPowerScore, mTCardRankingsResponse.deckPowerScore) && Intrinsics.areEqual(this.blendProfile, mTCardRankingsResponse.blendProfile);
    }

    public final MTCardRankingBlendProfile getBlendProfile() {
        return this.blendProfile;
    }

    public final List<MTFullCard> getCards() {
        return this.cards;
    }

    public final List<String> getCommanderNames() {
        return this.commanderNames;
    }

    public final Map<String, Integer> getDeckAutoTags() {
        return this.deckAutoTags;
    }

    public final Integer getDeckPowerScore() {
        return this.deckPowerScore;
    }

    public final Integer getSignalsVersion() {
        return this.signalsVersion;
    }

    public final MTCardRankingsSummary getSummary() {
        return this.summary;
    }

    public int hashCode() {
        int iHashCode = ((this.cards.hashCode() * 31) + this.commanderNames.hashCode()) * 31;
        Map<String, Integer> map = this.deckAutoTags;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        MTCardRankingsSummary mTCardRankingsSummary = this.summary;
        int iHashCode3 = (iHashCode2 + (mTCardRankingsSummary == null ? 0 : mTCardRankingsSummary.hashCode())) * 31;
        Integer num = this.signalsVersion;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.deckPowerScore;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        MTCardRankingBlendProfile mTCardRankingBlendProfile = this.blendProfile;
        return iHashCode5 + (mTCardRankingBlendProfile != null ? mTCardRankingBlendProfile.hashCode() : 0);
    }

    public String toString() {
        return "MTCardRankingsResponse(cards=" + this.cards + ", commanderNames=" + this.commanderNames + ", deckAutoTags=" + this.deckAutoTags + ", summary=" + this.summary + ", signalsVersion=" + this.signalsVersion + ", deckPowerScore=" + this.deckPowerScore + ", blendProfile=" + this.blendProfile + ")";
    }
}
