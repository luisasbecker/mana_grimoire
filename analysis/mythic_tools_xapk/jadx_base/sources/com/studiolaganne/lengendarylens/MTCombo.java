package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\f\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\fHÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00120\fHÆ\u0003J¦\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\fHÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0007HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"¨\u0006<"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCombo;", "", "id", "", "identity", "manaNeeded", "manaValueNeeded", "", "popularity", "bracketTag", "cardCount", "produces", "", "Lcom/studiolaganne/lengendarylens/MTComboProduces;", "cardsInDeck", "totalCards", "matchStatus", "cards", "Lcom/studiolaganne/lengendarylens/MTComboCard;", "missingCards", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;ILjava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getIdentity", "getManaNeeded", "getManaValueNeeded", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPopularity", "()I", "getBracketTag", "getCardCount", "getProduces", "()Ljava/util/List;", "getCardsInDeck", "getTotalCards", "getMatchStatus", "getCards", "getMissingCards", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;ILjava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/studiolaganne/lengendarylens/MTCombo;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCombo {
    public static final int $stable = 8;
    private final String bracketTag;
    private final int cardCount;
    private final List<MTComboCard> cards;
    private final String cardsInDeck;
    private final String id;
    private final String identity;
    private final String manaNeeded;
    private final Integer manaValueNeeded;
    private final String matchStatus;
    private final List<MTComboCard> missingCards;
    private final int popularity;
    private final List<MTComboProduces> produces;
    private final int totalCards;

    public MTCombo() {
        this(null, null, null, null, 0, null, 0, null, null, 0, null, null, null, 8191, null);
    }

    public MTCombo(String id, String identity, String str, Integer num, int i, String bracketTag, int i2, List<MTComboProduces> produces, String cardsInDeck, int i3, String matchStatus, List<MTComboCard> cards, List<MTComboCard> missingCards) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(bracketTag, "bracketTag");
        Intrinsics.checkNotNullParameter(produces, "produces");
        Intrinsics.checkNotNullParameter(cardsInDeck, "cardsInDeck");
        Intrinsics.checkNotNullParameter(matchStatus, "matchStatus");
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(missingCards, "missingCards");
        this.id = id;
        this.identity = identity;
        this.manaNeeded = str;
        this.manaValueNeeded = num;
        this.popularity = i;
        this.bracketTag = bracketTag;
        this.cardCount = i2;
        this.produces = produces;
        this.cardsInDeck = cardsInDeck;
        this.totalCards = i3;
        this.matchStatus = matchStatus;
        this.cards = cards;
        this.missingCards = missingCards;
    }

    public /* synthetic */ MTCombo(String str, String str2, String str3, Integer num, int i, String str4, int i2, List list, String str5, int i3, String str6, List list2, List list3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) == 0 ? num : null, (i4 & 16) != 0 ? 0 : i, (i4 & 32) != 0 ? "" : str4, (i4 & 64) != 0 ? 0 : i2, (i4 & 128) != 0 ? CollectionsKt.emptyList() : list, (i4 & 256) != 0 ? "" : str5, (i4 & 512) == 0 ? i3 : 0, (i4 & 1024) == 0 ? str6 : "", (i4 & 2048) != 0 ? CollectionsKt.emptyList() : list2, (i4 & 4096) != 0 ? CollectionsKt.emptyList() : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCombo copy$default(MTCombo mTCombo, String str, String str2, String str3, Integer num, int i, String str4, int i2, List list, String str5, int i3, String str6, List list2, List list3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = mTCombo.id;
        }
        return mTCombo.copy(str, (i4 & 2) != 0 ? mTCombo.identity : str2, (i4 & 4) != 0 ? mTCombo.manaNeeded : str3, (i4 & 8) != 0 ? mTCombo.manaValueNeeded : num, (i4 & 16) != 0 ? mTCombo.popularity : i, (i4 & 32) != 0 ? mTCombo.bracketTag : str4, (i4 & 64) != 0 ? mTCombo.cardCount : i2, (i4 & 128) != 0 ? mTCombo.produces : list, (i4 & 256) != 0 ? mTCombo.cardsInDeck : str5, (i4 & 512) != 0 ? mTCombo.totalCards : i3, (i4 & 1024) != 0 ? mTCombo.matchStatus : str6, (i4 & 2048) != 0 ? mTCombo.cards : list2, (i4 & 4096) != 0 ? mTCombo.missingCards : list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getTotalCards() {
        return this.totalCards;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getMatchStatus() {
        return this.matchStatus;
    }

    public final List<MTComboCard> component12() {
        return this.cards;
    }

    public final List<MTComboCard> component13() {
        return this.missingCards;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIdentity() {
        return this.identity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getManaNeeded() {
        return this.manaNeeded;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getManaValueNeeded() {
        return this.manaValueNeeded;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPopularity() {
        return this.popularity;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getBracketTag() {
        return this.bracketTag;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getCardCount() {
        return this.cardCount;
    }

    public final List<MTComboProduces> component8() {
        return this.produces;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getCardsInDeck() {
        return this.cardsInDeck;
    }

    public final MTCombo copy(String id, String identity, String manaNeeded, Integer manaValueNeeded, int popularity, String bracketTag, int cardCount, List<MTComboProduces> produces, String cardsInDeck, int totalCards, String matchStatus, List<MTComboCard> cards, List<MTComboCard> missingCards) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(bracketTag, "bracketTag");
        Intrinsics.checkNotNullParameter(produces, "produces");
        Intrinsics.checkNotNullParameter(cardsInDeck, "cardsInDeck");
        Intrinsics.checkNotNullParameter(matchStatus, "matchStatus");
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(missingCards, "missingCards");
        return new MTCombo(id, identity, manaNeeded, manaValueNeeded, popularity, bracketTag, cardCount, produces, cardsInDeck, totalCards, matchStatus, cards, missingCards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCombo)) {
            return false;
        }
        MTCombo mTCombo = (MTCombo) other;
        return Intrinsics.areEqual(this.id, mTCombo.id) && Intrinsics.areEqual(this.identity, mTCombo.identity) && Intrinsics.areEqual(this.manaNeeded, mTCombo.manaNeeded) && Intrinsics.areEqual(this.manaValueNeeded, mTCombo.manaValueNeeded) && this.popularity == mTCombo.popularity && Intrinsics.areEqual(this.bracketTag, mTCombo.bracketTag) && this.cardCount == mTCombo.cardCount && Intrinsics.areEqual(this.produces, mTCombo.produces) && Intrinsics.areEqual(this.cardsInDeck, mTCombo.cardsInDeck) && this.totalCards == mTCombo.totalCards && Intrinsics.areEqual(this.matchStatus, mTCombo.matchStatus) && Intrinsics.areEqual(this.cards, mTCombo.cards) && Intrinsics.areEqual(this.missingCards, mTCombo.missingCards);
    }

    public final String getBracketTag() {
        return this.bracketTag;
    }

    public final int getCardCount() {
        return this.cardCount;
    }

    public final List<MTComboCard> getCards() {
        return this.cards;
    }

    public final String getCardsInDeck() {
        return this.cardsInDeck;
    }

    public final String getId() {
        return this.id;
    }

    public final String getIdentity() {
        return this.identity;
    }

    public final String getManaNeeded() {
        return this.manaNeeded;
    }

    public final Integer getManaValueNeeded() {
        return this.manaValueNeeded;
    }

    public final String getMatchStatus() {
        return this.matchStatus;
    }

    public final List<MTComboCard> getMissingCards() {
        return this.missingCards;
    }

    public final int getPopularity() {
        return this.popularity;
    }

    public final List<MTComboProduces> getProduces() {
        return this.produces;
    }

    public final int getTotalCards() {
        return this.totalCards;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.identity.hashCode()) * 31;
        String str = this.manaNeeded;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.manaValueNeeded;
        return ((((((((((((((((((iHashCode2 + (num != null ? num.hashCode() : 0)) * 31) + Integer.hashCode(this.popularity)) * 31) + this.bracketTag.hashCode()) * 31) + Integer.hashCode(this.cardCount)) * 31) + this.produces.hashCode()) * 31) + this.cardsInDeck.hashCode()) * 31) + Integer.hashCode(this.totalCards)) * 31) + this.matchStatus.hashCode()) * 31) + this.cards.hashCode()) * 31) + this.missingCards.hashCode();
    }

    public String toString() {
        return "MTCombo(id=" + this.id + ", identity=" + this.identity + ", manaNeeded=" + this.manaNeeded + ", manaValueNeeded=" + this.manaValueNeeded + ", popularity=" + this.popularity + ", bracketTag=" + this.bracketTag + ", cardCount=" + this.cardCount + ", produces=" + this.produces + ", cardsInDeck=" + this.cardsInDeck + ", totalCards=" + this.totalCards + ", matchStatus=" + this.matchStatus + ", cards=" + this.cards + ", missingCards=" + this.missingCards + ")";
    }
}
