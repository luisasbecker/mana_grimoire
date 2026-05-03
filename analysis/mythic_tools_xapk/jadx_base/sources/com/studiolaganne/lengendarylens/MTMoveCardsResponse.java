package com.studiolaganne.lengendarylens;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J<\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017¨\u0006%"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTMoveCardsResponse;", "", "success", "", "moved", "", "source", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", TypedValues.AttributesType.S_TARGET, "<init>", "(ZLjava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTCardContainer;Lcom/studiolaganne/lengendarylens/MTCardContainer;)V", "getSuccess", "()Z", "setSuccess", "(Z)V", "getMoved", "()Ljava/lang/Integer;", "setMoved", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSource", "()Lcom/studiolaganne/lengendarylens/MTCardContainer;", "setSource", "(Lcom/studiolaganne/lengendarylens/MTCardContainer;)V", "getTarget", "setTarget", "component1", "component2", "component3", "component4", "copy", "(ZLjava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTCardContainer;Lcom/studiolaganne/lengendarylens/MTCardContainer;)Lcom/studiolaganne/lengendarylens/MTMoveCardsResponse;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTMoveCardsResponse {
    public static final int $stable = 8;
    private Integer moved;
    private MTCardContainer source;
    private boolean success;
    private MTCardContainer target;

    public MTMoveCardsResponse() {
        this(false, null, null, null, 15, null);
    }

    public MTMoveCardsResponse(boolean z, Integer num, MTCardContainer mTCardContainer, MTCardContainer mTCardContainer2) {
        this.success = z;
        this.moved = num;
        this.source = mTCardContainer;
        this.target = mTCardContainer2;
    }

    public /* synthetic */ MTMoveCardsResponse(boolean z, Integer num, MTCardContainer mTCardContainer, MTCardContainer mTCardContainer2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : mTCardContainer, (i & 8) != 0 ? null : mTCardContainer2);
    }

    public static /* synthetic */ MTMoveCardsResponse copy$default(MTMoveCardsResponse mTMoveCardsResponse, boolean z, Integer num, MTCardContainer mTCardContainer, MTCardContainer mTCardContainer2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = mTMoveCardsResponse.success;
        }
        if ((i & 2) != 0) {
            num = mTMoveCardsResponse.moved;
        }
        if ((i & 4) != 0) {
            mTCardContainer = mTMoveCardsResponse.source;
        }
        if ((i & 8) != 0) {
            mTCardContainer2 = mTMoveCardsResponse.target;
        }
        return mTMoveCardsResponse.copy(z, num, mTCardContainer, mTCardContainer2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getMoved() {
        return this.moved;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MTCardContainer getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MTCardContainer getTarget() {
        return this.target;
    }

    public final MTMoveCardsResponse copy(boolean success, Integer moved, MTCardContainer source, MTCardContainer target) {
        return new MTMoveCardsResponse(success, moved, source, target);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTMoveCardsResponse)) {
            return false;
        }
        MTMoveCardsResponse mTMoveCardsResponse = (MTMoveCardsResponse) other;
        return this.success == mTMoveCardsResponse.success && Intrinsics.areEqual(this.moved, mTMoveCardsResponse.moved) && Intrinsics.areEqual(this.source, mTMoveCardsResponse.source) && Intrinsics.areEqual(this.target, mTMoveCardsResponse.target);
    }

    public final Integer getMoved() {
        return this.moved;
    }

    public final MTCardContainer getSource() {
        return this.source;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final MTCardContainer getTarget() {
        return this.target;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        Integer num = this.moved;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        MTCardContainer mTCardContainer = this.source;
        int iHashCode3 = (iHashCode2 + (mTCardContainer == null ? 0 : mTCardContainer.hashCode())) * 31;
        MTCardContainer mTCardContainer2 = this.target;
        return iHashCode3 + (mTCardContainer2 != null ? mTCardContainer2.hashCode() : 0);
    }

    public final void setMoved(Integer num) {
        this.moved = num;
    }

    public final void setSource(MTCardContainer mTCardContainer) {
        this.source = mTCardContainer;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public final void setTarget(MTCardContainer mTCardContainer) {
        this.target = mTCardContainer;
    }

    public String toString() {
        return "MTMoveCardsResponse(success=" + this.success + ", moved=" + this.moved + ", source=" + this.source + ", target=" + this.target + ")";
    }
}
