package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeckCardToModify;", "", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "list_card_id", "", "list_id", "change", "Lcom/studiolaganne/lengendarylens/MTDeckCardChange;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTFullCard;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTDeckCardChange;)V", "getCard", "()Lcom/studiolaganne/lengendarylens/MTFullCard;", "setCard", "(Lcom/studiolaganne/lengendarylens/MTFullCard;)V", "getList_card_id", "()Ljava/lang/Integer;", "setList_card_id", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getList_id", "setList_id", "getChange", "()Lcom/studiolaganne/lengendarylens/MTDeckCardChange;", "setChange", "(Lcom/studiolaganne/lengendarylens/MTDeckCardChange;)V", "component1", "component2", "component3", "component4", "copy", "(Lcom/studiolaganne/lengendarylens/MTFullCard;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTDeckCardChange;)Lcom/studiolaganne/lengendarylens/MTDeckCardToModify;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeckCardToModify {
    public static final int $stable = 8;
    private MTFullCard card;
    private MTDeckCardChange change;
    private Integer list_card_id;
    private Integer list_id;

    public MTDeckCardToModify() {
        this(null, null, null, null, 15, null);
    }

    public MTDeckCardToModify(MTFullCard mTFullCard, Integer num, Integer num2, MTDeckCardChange mTDeckCardChange) {
        this.card = mTFullCard;
        this.list_card_id = num;
        this.list_id = num2;
        this.change = mTDeckCardChange;
    }

    public /* synthetic */ MTDeckCardToModify(MTFullCard mTFullCard, Integer num, Integer num2, MTDeckCardChange mTDeckCardChange, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTFullCard, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : mTDeckCardChange);
    }

    public static /* synthetic */ MTDeckCardToModify copy$default(MTDeckCardToModify mTDeckCardToModify, MTFullCard mTFullCard, Integer num, Integer num2, MTDeckCardChange mTDeckCardChange, int i, Object obj) {
        if ((i & 1) != 0) {
            mTFullCard = mTDeckCardToModify.card;
        }
        if ((i & 2) != 0) {
            num = mTDeckCardToModify.list_card_id;
        }
        if ((i & 4) != 0) {
            num2 = mTDeckCardToModify.list_id;
        }
        if ((i & 8) != 0) {
            mTDeckCardChange = mTDeckCardToModify.change;
        }
        return mTDeckCardToModify.copy(mTFullCard, num, num2, mTDeckCardChange);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTFullCard getCard() {
        return this.card;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getList_card_id() {
        return this.list_card_id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getList_id() {
        return this.list_id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTDeckCardChange getChange() {
        return this.change;
    }

    public final MTDeckCardToModify copy(MTFullCard card, Integer list_card_id, Integer list_id, MTDeckCardChange change) {
        return new MTDeckCardToModify(card, list_card_id, list_id, change);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeckCardToModify)) {
            return false;
        }
        MTDeckCardToModify mTDeckCardToModify = (MTDeckCardToModify) other;
        return Intrinsics.areEqual(this.card, mTDeckCardToModify.card) && Intrinsics.areEqual(this.list_card_id, mTDeckCardToModify.list_card_id) && Intrinsics.areEqual(this.list_id, mTDeckCardToModify.list_id) && Intrinsics.areEqual(this.change, mTDeckCardToModify.change);
    }

    public final MTFullCard getCard() {
        return this.card;
    }

    public final MTDeckCardChange getChange() {
        return this.change;
    }

    public final Integer getList_card_id() {
        return this.list_card_id;
    }

    public final Integer getList_id() {
        return this.list_id;
    }

    public int hashCode() {
        MTFullCard mTFullCard = this.card;
        int iHashCode = (mTFullCard == null ? 0 : mTFullCard.hashCode()) * 31;
        Integer num = this.list_card_id;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.list_id;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        MTDeckCardChange mTDeckCardChange = this.change;
        return iHashCode3 + (mTDeckCardChange != null ? mTDeckCardChange.hashCode() : 0);
    }

    public final void setCard(MTFullCard mTFullCard) {
        this.card = mTFullCard;
    }

    public final void setChange(MTDeckCardChange mTDeckCardChange) {
        this.change = mTDeckCardChange;
    }

    public final void setList_card_id(Integer num) {
        this.list_card_id = num;
    }

    public final void setList_id(Integer num) {
        this.list_id = num;
    }

    public String toString() {
        return "MTDeckCardToModify(card=" + this.card + ", list_card_id=" + this.list_card_id + ", list_id=" + this.list_id + ", change=" + this.change + ")";
    }
}
