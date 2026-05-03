package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTDeckIdCardModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018Jb\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdCardPipFlaggedCard;", "", "cardName", "", "manaCost", "colorSymbol", "pipCount", "", "cmc", "sourcesAvailable", "castProbability", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)V", "getCardName", "()Ljava/lang/String;", "getManaCost", "getColorSymbol", "getPipCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCmc", "getSourcesAvailable", "getCastProbability", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;)Lcom/studiolaganne/lengendarylens/MTIdCardPipFlaggedCard;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdCardPipFlaggedCard {
    public static final int $stable = 0;
    private final String cardName;
    private final Double castProbability;
    private final Integer cmc;
    private final String colorSymbol;
    private final String manaCost;
    private final Integer pipCount;
    private final Integer sourcesAvailable;

    public MTIdCardPipFlaggedCard() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public MTIdCardPipFlaggedCard(String str, String str2, String str3, Integer num, Integer num2, Integer num3, Double d) {
        this.cardName = str;
        this.manaCost = str2;
        this.colorSymbol = str3;
        this.pipCount = num;
        this.cmc = num2;
        this.sourcesAvailable = num3;
        this.castProbability = d;
    }

    public /* synthetic */ MTIdCardPipFlaggedCard(String str, String str2, String str3, Integer num, Integer num2, Integer num3, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : d);
    }

    public static /* synthetic */ MTIdCardPipFlaggedCard copy$default(MTIdCardPipFlaggedCard mTIdCardPipFlaggedCard, String str, String str2, String str3, Integer num, Integer num2, Integer num3, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTIdCardPipFlaggedCard.cardName;
        }
        if ((i & 2) != 0) {
            str2 = mTIdCardPipFlaggedCard.manaCost;
        }
        if ((i & 4) != 0) {
            str3 = mTIdCardPipFlaggedCard.colorSymbol;
        }
        if ((i & 8) != 0) {
            num = mTIdCardPipFlaggedCard.pipCount;
        }
        if ((i & 16) != 0) {
            num2 = mTIdCardPipFlaggedCard.cmc;
        }
        if ((i & 32) != 0) {
            num3 = mTIdCardPipFlaggedCard.sourcesAvailable;
        }
        if ((i & 64) != 0) {
            d = mTIdCardPipFlaggedCard.castProbability;
        }
        Integer num4 = num3;
        Double d2 = d;
        Integer num5 = num2;
        String str4 = str3;
        return mTIdCardPipFlaggedCard.copy(str, str2, str4, num, num5, num4, d2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCardName() {
        return this.cardName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getManaCost() {
        return this.manaCost;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getColorSymbol() {
        return this.colorSymbol;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getPipCount() {
        return this.pipCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getCmc() {
        return this.cmc;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getSourcesAvailable() {
        return this.sourcesAvailable;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getCastProbability() {
        return this.castProbability;
    }

    public final MTIdCardPipFlaggedCard copy(String cardName, String manaCost, String colorSymbol, Integer pipCount, Integer cmc, Integer sourcesAvailable, Double castProbability) {
        return new MTIdCardPipFlaggedCard(cardName, manaCost, colorSymbol, pipCount, cmc, sourcesAvailable, castProbability);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTIdCardPipFlaggedCard)) {
            return false;
        }
        MTIdCardPipFlaggedCard mTIdCardPipFlaggedCard = (MTIdCardPipFlaggedCard) other;
        return Intrinsics.areEqual(this.cardName, mTIdCardPipFlaggedCard.cardName) && Intrinsics.areEqual(this.manaCost, mTIdCardPipFlaggedCard.manaCost) && Intrinsics.areEqual(this.colorSymbol, mTIdCardPipFlaggedCard.colorSymbol) && Intrinsics.areEqual(this.pipCount, mTIdCardPipFlaggedCard.pipCount) && Intrinsics.areEqual(this.cmc, mTIdCardPipFlaggedCard.cmc) && Intrinsics.areEqual(this.sourcesAvailable, mTIdCardPipFlaggedCard.sourcesAvailable) && Intrinsics.areEqual((Object) this.castProbability, (Object) mTIdCardPipFlaggedCard.castProbability);
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final Double getCastProbability() {
        return this.castProbability;
    }

    public final Integer getCmc() {
        return this.cmc;
    }

    public final String getColorSymbol() {
        return this.colorSymbol;
    }

    public final String getManaCost() {
        return this.manaCost;
    }

    public final Integer getPipCount() {
        return this.pipCount;
    }

    public final Integer getSourcesAvailable() {
        return this.sourcesAvailable;
    }

    public int hashCode() {
        String str = this.cardName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.manaCost;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.colorSymbol;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.pipCount;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.cmc;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.sourcesAvailable;
        int iHashCode6 = (iHashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Double d = this.castProbability;
        return iHashCode6 + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        return "MTIdCardPipFlaggedCard(cardName=" + this.cardName + ", manaCost=" + this.manaCost + ", colorSymbol=" + this.colorSymbol + ", pipCount=" + this.pipCount + ", cmc=" + this.cmc + ", sourcesAvailable=" + this.sourcesAvailable + ", castProbability=" + this.castProbability + ")";
    }
}
