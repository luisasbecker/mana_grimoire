package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDecksResponse;", "", "decks", "", "Lcom/studiolaganne/lengendarylens/MTDeck;", "<init>", "(Ljava/util/List;)V", "getDecks", "()Ljava/util/List;", "setDecks", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDecksResponse {
    public static final int $stable = 8;
    private List<MTDeck> decks;

    /* JADX WARN: Multi-variable type inference failed */
    public MTDecksResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MTDecksResponse(List<MTDeck> decks) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        this.decks = decks;
    }

    public /* synthetic */ MTDecksResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTDecksResponse copy$default(MTDecksResponse mTDecksResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTDecksResponse.decks;
        }
        return mTDecksResponse.copy(list);
    }

    public final List<MTDeck> component1() {
        return this.decks;
    }

    public final MTDecksResponse copy(List<MTDeck> decks) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        return new MTDecksResponse(decks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTDecksResponse) && Intrinsics.areEqual(this.decks, ((MTDecksResponse) other).decks);
    }

    public final List<MTDeck> getDecks() {
        return this.decks;
    }

    public int hashCode() {
        return this.decks.hashCode();
    }

    public final void setDecks(List<MTDeck> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.decks = list;
    }

    public String toString() {
        return "MTDecksResponse(decks=" + this.decks + ")";
    }
}
