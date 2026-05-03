package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUpdateTagsInnerBody;", "", "add", "", "Lcom/studiolaganne/lengendarylens/MTTag;", "remove", "", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getAdd", "()Ljava/util/List;", "setAdd", "(Ljava/util/List;)V", "getRemove", "setRemove", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUpdateTagsInnerBody {
    public static final int $stable = 8;
    private List<MTTag> add;
    private List<Integer> remove;

    /* JADX WARN: Multi-variable type inference failed */
    public MTUpdateTagsInnerBody() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTUpdateTagsInnerBody(List<MTTag> list, List<Integer> list2) {
        this.add = list;
        this.remove = list2;
    }

    public /* synthetic */ MTUpdateTagsInnerBody(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTUpdateTagsInnerBody copy$default(MTUpdateTagsInnerBody mTUpdateTagsInnerBody, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTUpdateTagsInnerBody.add;
        }
        if ((i & 2) != 0) {
            list2 = mTUpdateTagsInnerBody.remove;
        }
        return mTUpdateTagsInnerBody.copy(list, list2);
    }

    public final List<MTTag> component1() {
        return this.add;
    }

    public final List<Integer> component2() {
        return this.remove;
    }

    public final MTUpdateTagsInnerBody copy(List<MTTag> add, List<Integer> remove) {
        return new MTUpdateTagsInnerBody(add, remove);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTUpdateTagsInnerBody)) {
            return false;
        }
        MTUpdateTagsInnerBody mTUpdateTagsInnerBody = (MTUpdateTagsInnerBody) other;
        return Intrinsics.areEqual(this.add, mTUpdateTagsInnerBody.add) && Intrinsics.areEqual(this.remove, mTUpdateTagsInnerBody.remove);
    }

    public final List<MTTag> getAdd() {
        return this.add;
    }

    public final List<Integer> getRemove() {
        return this.remove;
    }

    public int hashCode() {
        List<MTTag> list = this.add;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<Integer> list2 = this.remove;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setAdd(List<MTTag> list) {
        this.add = list;
    }

    public final void setRemove(List<Integer> list) {
        this.remove = list;
    }

    public String toString() {
        return "MTUpdateTagsInnerBody(add=" + this.add + ", remove=" + this.remove + ")";
    }
}
