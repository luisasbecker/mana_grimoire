package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardGroup;", "", "type", "", "count", "", "total_count", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "<init>", "(Ljava/lang/String;IILjava/util/List;)V", "getType", "()Ljava/lang/String;", "getCount", "()I", "getTotal_count", "getCards", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardGroup {
    public static final int $stable = 8;
    private final List<MTFullCard> cards;
    private final int count;
    private final int total_count;
    private final String type;

    public MTCardGroup() {
        this(null, 0, 0, null, 15, null);
    }

    public MTCardGroup(String type, int i, int i2, List<MTFullCard> list) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.count = i;
        this.total_count = i2;
        this.cards = list;
    }

    public /* synthetic */ MTCardGroup(String str, int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCardGroup copy$default(MTCardGroup mTCardGroup, String str, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = mTCardGroup.type;
        }
        if ((i3 & 2) != 0) {
            i = mTCardGroup.count;
        }
        if ((i3 & 4) != 0) {
            i2 = mTCardGroup.total_count;
        }
        if ((i3 & 8) != 0) {
            list = mTCardGroup.cards;
        }
        return mTCardGroup.copy(str, i, i2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTotal_count() {
        return this.total_count;
    }

    public final List<MTFullCard> component4() {
        return this.cards;
    }

    public final MTCardGroup copy(String type, int count, int total_count, List<MTFullCard> cards) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new MTCardGroup(type, count, total_count, cards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardGroup)) {
            return false;
        }
        MTCardGroup mTCardGroup = (MTCardGroup) other;
        return Intrinsics.areEqual(this.type, mTCardGroup.type) && this.count == mTCardGroup.count && this.total_count == mTCardGroup.total_count && Intrinsics.areEqual(this.cards, mTCardGroup.cards);
    }

    public final List<MTFullCard> getCards() {
        return this.cards;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getTotal_count() {
        return this.total_count;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((((this.type.hashCode() * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.total_count)) * 31;
        List<MTFullCard> list = this.cards;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "MTCardGroup(type=" + this.type + ", count=" + this.count + ", total_count=" + this.total_count + ", cards=" + this.cards + ")";
    }
}
