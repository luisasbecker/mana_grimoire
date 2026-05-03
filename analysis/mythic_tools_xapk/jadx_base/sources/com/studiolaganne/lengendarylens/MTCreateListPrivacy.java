package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCreateListPrivacy;", "", "type", "", "circleIds", "", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getCircleIds", "()Ljava/util/List;", "setCircleIds", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCreateListPrivacy {
    public static final int $stable = 8;
    private List<Integer> circleIds;
    private String type;

    /* JADX WARN: Multi-variable type inference failed */
    public MTCreateListPrivacy() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTCreateListPrivacy(String str, List<Integer> list) {
        this.type = str;
        this.circleIds = list;
    }

    public /* synthetic */ MTCreateListPrivacy(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTCreateListPrivacy copy$default(MTCreateListPrivacy mTCreateListPrivacy, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTCreateListPrivacy.type;
        }
        if ((i & 2) != 0) {
            list = mTCreateListPrivacy.circleIds;
        }
        return mTCreateListPrivacy.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<Integer> component2() {
        return this.circleIds;
    }

    public final MTCreateListPrivacy copy(String type, List<Integer> circleIds) {
        return new MTCreateListPrivacy(type, circleIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCreateListPrivacy)) {
            return false;
        }
        MTCreateListPrivacy mTCreateListPrivacy = (MTCreateListPrivacy) other;
        return Intrinsics.areEqual(this.type, mTCreateListPrivacy.type) && Intrinsics.areEqual(this.circleIds, mTCreateListPrivacy.circleIds);
    }

    public final List<Integer> getCircleIds() {
        return this.circleIds;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<Integer> list = this.circleIds;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setCircleIds(List<Integer> list) {
        this.circleIds = list;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "MTCreateListPrivacy(type=" + this.type + ", circleIds=" + this.circleIds + ")";
    }
}
