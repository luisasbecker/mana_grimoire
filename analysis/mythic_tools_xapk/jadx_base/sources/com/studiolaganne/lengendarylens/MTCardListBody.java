package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardListBody;", "", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "<init>", "(Ljava/util/List;)V", "getCards", "()Ljava/util/List;", "setCards", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardListBody {
    public static final int $stable = 8;
    private List<MTFullCard> cards;

    /* JADX WARN: Multi-variable type inference failed */
    public MTCardListBody() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MTCardListBody(List<MTFullCard> list) {
        this.cards = list;
    }

    public /* synthetic */ MTCardListBody(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardListBody copy$default(MTCardListBody mTCardListBody, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTCardListBody.cards;
        }
        return mTCardListBody.copy(list);
    }

    public final List<MTFullCard> component1() {
        return this.cards;
    }

    public final MTCardListBody copy(List<MTFullCard> cards) {
        return new MTCardListBody(cards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTCardListBody) && Intrinsics.areEqual(this.cards, ((MTCardListBody) other).cards);
    }

    public final List<MTFullCard> getCards() {
        return this.cards;
    }

    public int hashCode() {
        List<MTFullCard> list = this.cards;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setCards(List<MTFullCard> list) {
        this.cards = list;
    }

    public String toString() {
        return "MTCardListBody(cards=" + this.cards + ")";
    }
}
