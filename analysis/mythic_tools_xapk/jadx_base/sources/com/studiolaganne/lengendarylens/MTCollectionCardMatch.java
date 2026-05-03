package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCollectionCardMatch;", "", "card", "Lcom/studiolaganne/lengendarylens/MTCardMatch;", "list", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTCardMatch;Lcom/studiolaganne/lengendarylens/MTCardContainer;)V", "getCard", "()Lcom/studiolaganne/lengendarylens/MTCardMatch;", "setCard", "(Lcom/studiolaganne/lengendarylens/MTCardMatch;)V", "getList", "()Lcom/studiolaganne/lengendarylens/MTCardContainer;", "setList", "(Lcom/studiolaganne/lengendarylens/MTCardContainer;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCollectionCardMatch {
    public static final int $stable = 8;
    private MTCardMatch card;
    private MTCardContainer list;

    /* JADX WARN: Multi-variable type inference failed */
    public MTCollectionCardMatch() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTCollectionCardMatch(MTCardMatch mTCardMatch, MTCardContainer mTCardContainer) {
        this.card = mTCardMatch;
        this.list = mTCardContainer;
    }

    public /* synthetic */ MTCollectionCardMatch(MTCardMatch mTCardMatch, MTCardContainer mTCardContainer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTCardMatch, (i & 2) != 0 ? null : mTCardContainer);
    }

    public static /* synthetic */ MTCollectionCardMatch copy$default(MTCollectionCardMatch mTCollectionCardMatch, MTCardMatch mTCardMatch, MTCardContainer mTCardContainer, int i, Object obj) {
        if ((i & 1) != 0) {
            mTCardMatch = mTCollectionCardMatch.card;
        }
        if ((i & 2) != 0) {
            mTCardContainer = mTCollectionCardMatch.list;
        }
        return mTCollectionCardMatch.copy(mTCardMatch, mTCardContainer);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTCardMatch getCard() {
        return this.card;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTCardContainer getList() {
        return this.list;
    }

    public final MTCollectionCardMatch copy(MTCardMatch card, MTCardContainer list) {
        return new MTCollectionCardMatch(card, list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCollectionCardMatch)) {
            return false;
        }
        MTCollectionCardMatch mTCollectionCardMatch = (MTCollectionCardMatch) other;
        return Intrinsics.areEqual(this.card, mTCollectionCardMatch.card) && Intrinsics.areEqual(this.list, mTCollectionCardMatch.list);
    }

    public final MTCardMatch getCard() {
        return this.card;
    }

    public final MTCardContainer getList() {
        return this.list;
    }

    public int hashCode() {
        MTCardMatch mTCardMatch = this.card;
        int iHashCode = (mTCardMatch == null ? 0 : mTCardMatch.hashCode()) * 31;
        MTCardContainer mTCardContainer = this.list;
        return iHashCode + (mTCardContainer != null ? mTCardContainer.hashCode() : 0);
    }

    public final void setCard(MTCardMatch mTCardMatch) {
        this.card = mTCardMatch;
    }

    public final void setList(MTCardContainer mTCardContainer) {
        this.list = mTCardContainer;
    }

    public String toString() {
        return "MTCollectionCardMatch(card=" + this.card + ", list=" + this.list + ")";
    }
}
