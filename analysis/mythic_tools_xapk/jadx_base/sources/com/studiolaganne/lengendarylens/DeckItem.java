package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoveCardDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckItem;", "", "id", "", "name", "", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "<init>", "(ILjava/lang/String;Lcom/studiolaganne/lengendarylens/MTDeck;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getDeck", "()Lcom/studiolaganne/lengendarylens/MTDeck;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DeckItem {
    public static final int $stable = MTDeck.$stable;
    private final MTDeck deck;
    private final int id;
    private final String name;

    public DeckItem(int i, String name, MTDeck deck) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(deck, "deck");
        this.id = i;
        this.name = name;
        this.deck = deck;
    }

    public static /* synthetic */ DeckItem copy$default(DeckItem deckItem, int i, String str, MTDeck mTDeck, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = deckItem.id;
        }
        if ((i2 & 2) != 0) {
            str = deckItem.name;
        }
        if ((i2 & 4) != 0) {
            mTDeck = deckItem.deck;
        }
        return deckItem.copy(i, str, mTDeck);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTDeck getDeck() {
        return this.deck;
    }

    public final DeckItem copy(int id, String name, MTDeck deck) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(deck, "deck");
        return new DeckItem(id, name, deck);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeckItem)) {
            return false;
        }
        DeckItem deckItem = (DeckItem) other;
        return this.id == deckItem.id && Intrinsics.areEqual(this.name, deckItem.name) && Intrinsics.areEqual(this.deck, deckItem.deck);
    }

    public final MTDeck getDeck() {
        return this.deck;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.deck.hashCode();
    }

    public String toString() {
        return "DeckItem(id=" + this.id + ", name=" + this.name + ", deck=" + this.deck + ")";
    }
}
