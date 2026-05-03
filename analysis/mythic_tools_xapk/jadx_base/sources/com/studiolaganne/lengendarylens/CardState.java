package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/CardState;", "", "card", "Lcom/studiolaganne/lengendarylens/Card;", "cardMatch", "Lcom/studiolaganne/lengendarylens/CardMatch;", "imageURL", "", "<init>", "(Lcom/studiolaganne/lengendarylens/Card;Lcom/studiolaganne/lengendarylens/CardMatch;Ljava/lang/String;)V", "getCard", "()Lcom/studiolaganne/lengendarylens/Card;", "setCard", "(Lcom/studiolaganne/lengendarylens/Card;)V", "getCardMatch", "()Lcom/studiolaganne/lengendarylens/CardMatch;", "setCardMatch", "(Lcom/studiolaganne/lengendarylens/CardMatch;)V", "getImageURL", "()Ljava/lang/String;", "setImageURL", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CardState {
    public static final int $stable = 8;
    private Card card;
    private CardMatch cardMatch;
    private String imageURL;

    public CardState() {
        this(null, null, null, 7, null);
    }

    public CardState(Card card, CardMatch cardMatch, String str) {
        this.card = card;
        this.cardMatch = cardMatch;
        this.imageURL = str;
    }

    public /* synthetic */ CardState(Card card, CardMatch cardMatch, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : card, (i & 2) != 0 ? null : cardMatch, (i & 4) != 0 ? null : str);
    }

    public static /* synthetic */ CardState copy$default(CardState cardState, Card card, CardMatch cardMatch, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            card = cardState.card;
        }
        if ((i & 2) != 0) {
            cardMatch = cardState.cardMatch;
        }
        if ((i & 4) != 0) {
            str = cardState.imageURL;
        }
        return cardState.copy(card, cardMatch, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Card getCard() {
        return this.card;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CardMatch getCardMatch() {
        return this.cardMatch;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImageURL() {
        return this.imageURL;
    }

    public final CardState copy(Card card, CardMatch cardMatch, String imageURL) {
        return new CardState(card, cardMatch, imageURL);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardState)) {
            return false;
        }
        CardState cardState = (CardState) other;
        return Intrinsics.areEqual(this.card, cardState.card) && Intrinsics.areEqual(this.cardMatch, cardState.cardMatch) && Intrinsics.areEqual(this.imageURL, cardState.imageURL);
    }

    public final Card getCard() {
        return this.card;
    }

    public final CardMatch getCardMatch() {
        return this.cardMatch;
    }

    public final String getImageURL() {
        return this.imageURL;
    }

    public int hashCode() {
        Card card = this.card;
        int iHashCode = (card == null ? 0 : card.hashCode()) * 31;
        CardMatch cardMatch = this.cardMatch;
        int iHashCode2 = (iHashCode + (cardMatch == null ? 0 : cardMatch.hashCode())) * 31;
        String str = this.imageURL;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void setCard(Card card) {
        this.card = card;
    }

    public final void setCardMatch(CardMatch cardMatch) {
        this.cardMatch = cardMatch;
    }

    public final void setImageURL(String str) {
        this.imageURL = str;
    }

    public String toString() {
        return "CardState(card=" + this.card + ", cardMatch=" + this.cardMatch + ", imageURL=" + this.imageURL + ")";
    }
}
