package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCreateCircleBody;", "", "name", "", "description", "userIds", "", "", "playgroupIds", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getUserIds", "()Ljava/util/List;", "setUserIds", "(Ljava/util/List;)V", "getPlaygroupIds", "setPlaygroupIds", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCreateCircleBody {
    public static final int $stable = 8;
    private String description;
    private String name;
    private List<Integer> playgroupIds;
    private List<Integer> userIds;

    public MTCreateCircleBody(String name, String str, List<Integer> list, List<Integer> list2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.description = str;
        this.userIds = list;
        this.playgroupIds = list2;
    }

    public /* synthetic */ MTCreateCircleBody(String str, String str2, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCreateCircleBody copy$default(MTCreateCircleBody mTCreateCircleBody, String str, String str2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTCreateCircleBody.name;
        }
        if ((i & 2) != 0) {
            str2 = mTCreateCircleBody.description;
        }
        if ((i & 4) != 0) {
            list = mTCreateCircleBody.userIds;
        }
        if ((i & 8) != 0) {
            list2 = mTCreateCircleBody.playgroupIds;
        }
        return mTCreateCircleBody.copy(str, str2, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<Integer> component3() {
        return this.userIds;
    }

    public final List<Integer> component4() {
        return this.playgroupIds;
    }

    public final MTCreateCircleBody copy(String name, String description, List<Integer> userIds, List<Integer> playgroupIds) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MTCreateCircleBody(name, description, userIds, playgroupIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCreateCircleBody)) {
            return false;
        }
        MTCreateCircleBody mTCreateCircleBody = (MTCreateCircleBody) other;
        return Intrinsics.areEqual(this.name, mTCreateCircleBody.name) && Intrinsics.areEqual(this.description, mTCreateCircleBody.description) && Intrinsics.areEqual(this.userIds, mTCreateCircleBody.userIds) && Intrinsics.areEqual(this.playgroupIds, mTCreateCircleBody.playgroupIds);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Integer> getPlaygroupIds() {
        return this.playgroupIds;
    }

    public final List<Integer> getUserIds() {
        return this.userIds;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<Integer> list = this.userIds;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<Integer> list2 = this.playgroupIds;
        return iHashCode3 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setPlaygroupIds(List<Integer> list) {
        this.playgroupIds = list;
    }

    public final void setUserIds(List<Integer> list) {
        this.userIds = list;
    }

    public String toString() {
        return "MTCreateCircleBody(name=" + this.name + ", description=" + this.description + ", userIds=" + this.userIds + ", playgroupIds=" + this.playgroupIds + ")";
    }
}
