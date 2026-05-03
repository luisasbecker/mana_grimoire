package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J?\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTUpdatePrivacyBody;", "", "type", "", "circleIds", "", "", "options", "", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getCircleIds", "()Ljava/util/List;", "setCircleIds", "(Ljava/util/List;)V", "getOptions", "()Ljava/util/Map;", "setOptions", "(Ljava/util/Map;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTUpdatePrivacyBody {
    public static final int $stable = 8;
    private List<Integer> circleIds;
    private Map<String, Boolean> options;
    private String type;

    public MTUpdatePrivacyBody() {
        this(null, null, null, 7, null);
    }

    public MTUpdatePrivacyBody(String str, List<Integer> list, Map<String, Boolean> map) {
        this.type = str;
        this.circleIds = list;
        this.options = map;
    }

    public /* synthetic */ MTUpdatePrivacyBody(String str, List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTUpdatePrivacyBody copy$default(MTUpdatePrivacyBody mTUpdatePrivacyBody, String str, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTUpdatePrivacyBody.type;
        }
        if ((i & 2) != 0) {
            list = mTUpdatePrivacyBody.circleIds;
        }
        if ((i & 4) != 0) {
            map = mTUpdatePrivacyBody.options;
        }
        return mTUpdatePrivacyBody.copy(str, list, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<Integer> component2() {
        return this.circleIds;
    }

    public final Map<String, Boolean> component3() {
        return this.options;
    }

    public final MTUpdatePrivacyBody copy(String type, List<Integer> circleIds, Map<String, Boolean> options) {
        return new MTUpdatePrivacyBody(type, circleIds, options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTUpdatePrivacyBody)) {
            return false;
        }
        MTUpdatePrivacyBody mTUpdatePrivacyBody = (MTUpdatePrivacyBody) other;
        return Intrinsics.areEqual(this.type, mTUpdatePrivacyBody.type) && Intrinsics.areEqual(this.circleIds, mTUpdatePrivacyBody.circleIds) && Intrinsics.areEqual(this.options, mTUpdatePrivacyBody.options);
    }

    public final List<Integer> getCircleIds() {
        return this.circleIds;
    }

    public final Map<String, Boolean> getOptions() {
        return this.options;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<Integer> list = this.circleIds;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Map<String, Boolean> map = this.options;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public final void setCircleIds(List<Integer> list) {
        this.circleIds = list;
    }

    public final void setOptions(Map<String, Boolean> map) {
        this.options = map;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "MTUpdatePrivacyBody(type=" + this.type + ", circleIds=" + this.circleIds + ", options=" + this.options + ")";
    }
}
