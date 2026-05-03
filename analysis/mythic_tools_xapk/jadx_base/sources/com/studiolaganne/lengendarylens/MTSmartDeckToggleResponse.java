package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0004\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTSmartDeckToggleResponse;", "", "success", "", "is_smart_deck", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getSuccess", "()Ljava/lang/Boolean;", "setSuccess", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "set_smart_deck", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTSmartDeckToggleResponse;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTSmartDeckToggleResponse {
    public static final int $stable = 8;
    private Boolean is_smart_deck;
    private Boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public MTSmartDeckToggleResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTSmartDeckToggleResponse(Boolean bool, Boolean bool2) {
        this.success = bool;
        this.is_smart_deck = bool2;
    }

    public /* synthetic */ MTSmartDeckToggleResponse(Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2);
    }

    public static /* synthetic */ MTSmartDeckToggleResponse copy$default(MTSmartDeckToggleResponse mTSmartDeckToggleResponse, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = mTSmartDeckToggleResponse.success;
        }
        if ((i & 2) != 0) {
            bool2 = mTSmartDeckToggleResponse.is_smart_deck;
        }
        return mTSmartDeckToggleResponse.copy(bool, bool2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getIs_smart_deck() {
        return this.is_smart_deck;
    }

    public final MTSmartDeckToggleResponse copy(Boolean success, Boolean is_smart_deck) {
        return new MTSmartDeckToggleResponse(success, is_smart_deck);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTSmartDeckToggleResponse)) {
            return false;
        }
        MTSmartDeckToggleResponse mTSmartDeckToggleResponse = (MTSmartDeckToggleResponse) other;
        return Intrinsics.areEqual(this.success, mTSmartDeckToggleResponse.success) && Intrinsics.areEqual(this.is_smart_deck, mTSmartDeckToggleResponse.is_smart_deck);
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        Boolean bool = this.success;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.is_smart_deck;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final Boolean is_smart_deck() {
        return this.is_smart_deck;
    }

    public final void setSuccess(Boolean bool) {
        this.success = bool;
    }

    public final void set_smart_deck(Boolean bool) {
        this.is_smart_deck = bool;
    }

    public String toString() {
        return "MTSmartDeckToggleResponse(success=" + this.success + ", is_smart_deck=" + this.is_smart_deck + ")";
    }
}
