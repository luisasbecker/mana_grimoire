package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGetExternalDeckResponse;", "", "toAdd", "", "Lcom/studiolaganne/lengendarylens/MTDeckCardToAdd;", "toModify", "Lcom/studiolaganne/lengendarylens/MTDeckCardToModify;", "toRemove", "Lcom/studiolaganne/lengendarylens/MTDeckCardToRemove;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getToAdd", "()Ljava/util/List;", "setToAdd", "(Ljava/util/List;)V", "getToModify", "setToModify", "getToRemove", "setToRemove", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTGetExternalDeckResponse {
    public static final int $stable = 8;
    private List<MTDeckCardToAdd> toAdd;
    private List<MTDeckCardToModify> toModify;
    private List<MTDeckCardToRemove> toRemove;

    public MTGetExternalDeckResponse() {
        this(null, null, null, 7, null);
    }

    public MTGetExternalDeckResponse(List<MTDeckCardToAdd> list, List<MTDeckCardToModify> list2, List<MTDeckCardToRemove> list3) {
        this.toAdd = list;
        this.toModify = list2;
        this.toRemove = list3;
    }

    public /* synthetic */ MTGetExternalDeckResponse(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTGetExternalDeckResponse copy$default(MTGetExternalDeckResponse mTGetExternalDeckResponse, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTGetExternalDeckResponse.toAdd;
        }
        if ((i & 2) != 0) {
            list2 = mTGetExternalDeckResponse.toModify;
        }
        if ((i & 4) != 0) {
            list3 = mTGetExternalDeckResponse.toRemove;
        }
        return mTGetExternalDeckResponse.copy(list, list2, list3);
    }

    public final List<MTDeckCardToAdd> component1() {
        return this.toAdd;
    }

    public final List<MTDeckCardToModify> component2() {
        return this.toModify;
    }

    public final List<MTDeckCardToRemove> component3() {
        return this.toRemove;
    }

    public final MTGetExternalDeckResponse copy(List<MTDeckCardToAdd> toAdd, List<MTDeckCardToModify> toModify, List<MTDeckCardToRemove> toRemove) {
        return new MTGetExternalDeckResponse(toAdd, toModify, toRemove);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTGetExternalDeckResponse)) {
            return false;
        }
        MTGetExternalDeckResponse mTGetExternalDeckResponse = (MTGetExternalDeckResponse) other;
        return Intrinsics.areEqual(this.toAdd, mTGetExternalDeckResponse.toAdd) && Intrinsics.areEqual(this.toModify, mTGetExternalDeckResponse.toModify) && Intrinsics.areEqual(this.toRemove, mTGetExternalDeckResponse.toRemove);
    }

    public final List<MTDeckCardToAdd> getToAdd() {
        return this.toAdd;
    }

    public final List<MTDeckCardToModify> getToModify() {
        return this.toModify;
    }

    public final List<MTDeckCardToRemove> getToRemove() {
        return this.toRemove;
    }

    public int hashCode() {
        List<MTDeckCardToAdd> list = this.toAdd;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<MTDeckCardToModify> list2 = this.toModify;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MTDeckCardToRemove> list3 = this.toRemove;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public final void setToAdd(List<MTDeckCardToAdd> list) {
        this.toAdd = list;
    }

    public final void setToModify(List<MTDeckCardToModify> list) {
        this.toModify = list;
    }

    public final void setToRemove(List<MTDeckCardToRemove> list) {
        this.toRemove = list;
    }

    public String toString() {
        return "MTGetExternalDeckResponse(toAdd=" + this.toAdd + ", toModify=" + this.toModify + ", toRemove=" + this.toRemove + ")";
    }
}
