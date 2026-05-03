package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeckListTxtParser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J9\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/ParsedDeckList;", "", "mainDeckCards", "", "Lcom/studiolaganne/lengendarylens/ParsedCard;", "sideboardCards", "maybeboardCards", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getMainDeckCards", "()Ljava/util/List;", "getSideboardCards", "getMaybeboardCards", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ParsedDeckList {
    public static final int $stable = 8;
    private final List<ParsedCard> mainDeckCards;
    private final List<ParsedCard> maybeboardCards;
    private final List<ParsedCard> sideboardCards;

    public ParsedDeckList(List<ParsedCard> mainDeckCards, List<ParsedCard> sideboardCards, List<ParsedCard> maybeboardCards) {
        Intrinsics.checkNotNullParameter(mainDeckCards, "mainDeckCards");
        Intrinsics.checkNotNullParameter(sideboardCards, "sideboardCards");
        Intrinsics.checkNotNullParameter(maybeboardCards, "maybeboardCards");
        this.mainDeckCards = mainDeckCards;
        this.sideboardCards = sideboardCards;
        this.maybeboardCards = maybeboardCards;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParsedDeckList copy$default(ParsedDeckList parsedDeckList, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = parsedDeckList.mainDeckCards;
        }
        if ((i & 2) != 0) {
            list2 = parsedDeckList.sideboardCards;
        }
        if ((i & 4) != 0) {
            list3 = parsedDeckList.maybeboardCards;
        }
        return parsedDeckList.copy(list, list2, list3);
    }

    public final List<ParsedCard> component1() {
        return this.mainDeckCards;
    }

    public final List<ParsedCard> component2() {
        return this.sideboardCards;
    }

    public final List<ParsedCard> component3() {
        return this.maybeboardCards;
    }

    public final ParsedDeckList copy(List<ParsedCard> mainDeckCards, List<ParsedCard> sideboardCards, List<ParsedCard> maybeboardCards) {
        Intrinsics.checkNotNullParameter(mainDeckCards, "mainDeckCards");
        Intrinsics.checkNotNullParameter(sideboardCards, "sideboardCards");
        Intrinsics.checkNotNullParameter(maybeboardCards, "maybeboardCards");
        return new ParsedDeckList(mainDeckCards, sideboardCards, maybeboardCards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedDeckList)) {
            return false;
        }
        ParsedDeckList parsedDeckList = (ParsedDeckList) other;
        return Intrinsics.areEqual(this.mainDeckCards, parsedDeckList.mainDeckCards) && Intrinsics.areEqual(this.sideboardCards, parsedDeckList.sideboardCards) && Intrinsics.areEqual(this.maybeboardCards, parsedDeckList.maybeboardCards);
    }

    public final List<ParsedCard> getMainDeckCards() {
        return this.mainDeckCards;
    }

    public final List<ParsedCard> getMaybeboardCards() {
        return this.maybeboardCards;
    }

    public final List<ParsedCard> getSideboardCards() {
        return this.sideboardCards;
    }

    public int hashCode() {
        return (((this.mainDeckCards.hashCode() * 31) + this.sideboardCards.hashCode()) * 31) + this.maybeboardCards.hashCode();
    }

    public String toString() {
        return "ParsedDeckList(mainDeckCards=" + this.mainDeckCards + ", sideboardCards=" + this.sideboardCards + ", maybeboardCards=" + this.maybeboardCards + ")";
    }
}
