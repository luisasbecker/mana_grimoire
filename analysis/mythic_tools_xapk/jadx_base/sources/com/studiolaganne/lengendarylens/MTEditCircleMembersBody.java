package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEditCircleMembersBody;", "", "userIds", "", "", "playgroupIds", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getUserIds", "()Ljava/util/List;", "setUserIds", "(Ljava/util/List;)V", "getPlaygroupIds", "setPlaygroupIds", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTEditCircleMembersBody {
    public static final int $stable = 8;
    private List<Integer> playgroupIds;
    private List<Integer> userIds;

    /* JADX WARN: Multi-variable type inference failed */
    public MTEditCircleMembersBody() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTEditCircleMembersBody(List<Integer> list, List<Integer> list2) {
        this.userIds = list;
        this.playgroupIds = list2;
    }

    public /* synthetic */ MTEditCircleMembersBody(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTEditCircleMembersBody copy$default(MTEditCircleMembersBody mTEditCircleMembersBody, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTEditCircleMembersBody.userIds;
        }
        if ((i & 2) != 0) {
            list2 = mTEditCircleMembersBody.playgroupIds;
        }
        return mTEditCircleMembersBody.copy(list, list2);
    }

    public final List<Integer> component1() {
        return this.userIds;
    }

    public final List<Integer> component2() {
        return this.playgroupIds;
    }

    public final MTEditCircleMembersBody copy(List<Integer> userIds, List<Integer> playgroupIds) {
        return new MTEditCircleMembersBody(userIds, playgroupIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTEditCircleMembersBody)) {
            return false;
        }
        MTEditCircleMembersBody mTEditCircleMembersBody = (MTEditCircleMembersBody) other;
        return Intrinsics.areEqual(this.userIds, mTEditCircleMembersBody.userIds) && Intrinsics.areEqual(this.playgroupIds, mTEditCircleMembersBody.playgroupIds);
    }

    public final List<Integer> getPlaygroupIds() {
        return this.playgroupIds;
    }

    public final List<Integer> getUserIds() {
        return this.userIds;
    }

    public int hashCode() {
        List<Integer> list = this.userIds;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<Integer> list2 = this.playgroupIds;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setPlaygroupIds(List<Integer> list) {
        this.playgroupIds = list;
    }

    public final void setUserIds(List<Integer> list) {
        this.userIds = list;
    }

    public String toString() {
        return "MTEditCircleMembersBody(userIds=" + this.userIds + ", playgroupIds=" + this.playgroupIds + ")";
    }
}
