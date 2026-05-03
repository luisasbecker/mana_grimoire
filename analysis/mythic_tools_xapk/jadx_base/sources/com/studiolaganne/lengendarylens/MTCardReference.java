package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardReference;", "", "list_card_id", "", "<init>", "(I)V", "getList_card_id", "()I", "setList_card_id", "component1", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardReference {
    public static final int $stable = 8;
    private int list_card_id;

    public MTCardReference() {
        this(0, 1, null);
    }

    public MTCardReference(int i) {
        this.list_card_id = i;
    }

    public /* synthetic */ MTCardReference(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i);
    }

    public static /* synthetic */ MTCardReference copy$default(MTCardReference mTCardReference, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTCardReference.list_card_id;
        }
        return mTCardReference.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getList_card_id() {
        return this.list_card_id;
    }

    public final MTCardReference copy(int list_card_id) {
        return new MTCardReference(list_card_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTCardReference) && this.list_card_id == ((MTCardReference) other).list_card_id;
    }

    public final int getList_card_id() {
        return this.list_card_id;
    }

    public int hashCode() {
        return Integer.hashCode(this.list_card_id);
    }

    public final void setList_card_id(int i) {
        this.list_card_id = i;
    }

    public String toString() {
        return "MTCardReference(list_card_id=" + this.list_card_id + ")";
    }
}
