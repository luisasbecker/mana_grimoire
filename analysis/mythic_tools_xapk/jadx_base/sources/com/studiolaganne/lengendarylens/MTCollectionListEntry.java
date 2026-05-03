package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCollectionListEntry;", "", "list_id", "", "list_card_id", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getList_id", "()Ljava/lang/Integer;", "setList_id", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getList_card_id", "setList_card_id", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTCollectionListEntry;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCollectionListEntry {
    public static final int $stable = 8;
    private Integer list_card_id;
    private Integer list_id;

    /* JADX WARN: Multi-variable type inference failed */
    public MTCollectionListEntry() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTCollectionListEntry(Integer num, Integer num2) {
        this.list_id = num;
        this.list_card_id = num2;
    }

    public /* synthetic */ MTCollectionListEntry(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    public static /* synthetic */ MTCollectionListEntry copy$default(MTCollectionListEntry mTCollectionListEntry, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTCollectionListEntry.list_id;
        }
        if ((i & 2) != 0) {
            num2 = mTCollectionListEntry.list_card_id;
        }
        return mTCollectionListEntry.copy(num, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getList_id() {
        return this.list_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getList_card_id() {
        return this.list_card_id;
    }

    public final MTCollectionListEntry copy(Integer list_id, Integer list_card_id) {
        return new MTCollectionListEntry(list_id, list_card_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCollectionListEntry)) {
            return false;
        }
        MTCollectionListEntry mTCollectionListEntry = (MTCollectionListEntry) other;
        return Intrinsics.areEqual(this.list_id, mTCollectionListEntry.list_id) && Intrinsics.areEqual(this.list_card_id, mTCollectionListEntry.list_card_id);
    }

    public final Integer getList_card_id() {
        return this.list_card_id;
    }

    public final Integer getList_id() {
        return this.list_id;
    }

    public int hashCode() {
        Integer num = this.list_id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.list_card_id;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setList_card_id(Integer num) {
        this.list_card_id = num;
    }

    public final void setList_id(Integer num) {
        this.list_id = num;
    }

    public String toString() {
        return "MTCollectionListEntry(list_id=" + this.list_id + ", list_card_id=" + this.list_card_id + ")";
    }
}
