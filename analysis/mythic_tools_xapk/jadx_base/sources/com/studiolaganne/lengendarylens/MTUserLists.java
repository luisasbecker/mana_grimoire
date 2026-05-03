package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUserLists;", "", "global", "", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "user", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getGlobal", "()Ljava/util/List;", "setGlobal", "(Ljava/util/List;)V", "getUser", "setUser", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUserLists {
    public static final int $stable = 8;
    private List<MTCardContainer> global;
    private List<MTCardContainer> user;

    /* JADX WARN: Multi-variable type inference failed */
    public MTUserLists() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTUserLists(List<MTCardContainer> list, List<MTCardContainer> list2) {
        this.global = list;
        this.user = list2;
    }

    public /* synthetic */ MTUserLists(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTUserLists copy$default(MTUserLists mTUserLists, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTUserLists.global;
        }
        if ((i & 2) != 0) {
            list2 = mTUserLists.user;
        }
        return mTUserLists.copy(list, list2);
    }

    public final List<MTCardContainer> component1() {
        return this.global;
    }

    public final List<MTCardContainer> component2() {
        return this.user;
    }

    public final MTUserLists copy(List<MTCardContainer> global, List<MTCardContainer> user) {
        return new MTUserLists(global, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTUserLists)) {
            return false;
        }
        MTUserLists mTUserLists = (MTUserLists) other;
        return Intrinsics.areEqual(this.global, mTUserLists.global) && Intrinsics.areEqual(this.user, mTUserLists.user);
    }

    public final List<MTCardContainer> getGlobal() {
        return this.global;
    }

    public final List<MTCardContainer> getUser() {
        return this.user;
    }

    public int hashCode() {
        List<MTCardContainer> list = this.global;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<MTCardContainer> list2 = this.user;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setGlobal(List<MTCardContainer> list) {
        this.global = list;
    }

    public final void setUser(List<MTCardContainer> list) {
        this.user = list;
    }

    public String toString() {
        return "MTUserLists(global=" + this.global + ", user=" + this.user + ")";
    }
}
