package com.studiolaganne.lengendarylens;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTMoveCardsBody;", "", TypedValues.AttributesType.S_TARGET, "", "cards", "", "Lcom/studiolaganne/lengendarylens/MTCardReference;", "<init>", "(ILjava/util/List;)V", "getTarget", "()I", "setTarget", "(I)V", "getCards", "()Ljava/util/List;", "setCards", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTMoveCardsBody {
    public static final int $stable = 8;
    private List<MTCardReference> cards;
    private int target;

    /* JADX WARN: Multi-variable type inference failed */
    public MTMoveCardsBody() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public MTMoveCardsBody(int i, List<MTCardReference> list) {
        this.target = i;
        this.cards = list;
    }

    public /* synthetic */ MTMoveCardsBody(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTMoveCardsBody copy$default(MTMoveCardsBody mTMoveCardsBody, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTMoveCardsBody.target;
        }
        if ((i2 & 2) != 0) {
            list = mTMoveCardsBody.cards;
        }
        return mTMoveCardsBody.copy(i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTarget() {
        return this.target;
    }

    public final List<MTCardReference> component2() {
        return this.cards;
    }

    public final MTMoveCardsBody copy(int target, List<MTCardReference> cards) {
        return new MTMoveCardsBody(target, cards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTMoveCardsBody)) {
            return false;
        }
        MTMoveCardsBody mTMoveCardsBody = (MTMoveCardsBody) other;
        return this.target == mTMoveCardsBody.target && Intrinsics.areEqual(this.cards, mTMoveCardsBody.cards);
    }

    public final List<MTCardReference> getCards() {
        return this.cards;
    }

    public final int getTarget() {
        return this.target;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.target) * 31;
        List<MTCardReference> list = this.cards;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public final void setCards(List<MTCardReference> list) {
        this.cards = list;
    }

    public final void setTarget(int i) {
        this.target = i;
    }

    public String toString() {
        return "MTMoveCardsBody(target=" + this.target + ", cards=" + this.cards + ")";
    }
}
