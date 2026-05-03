package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J@\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTRecommendCategory;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", Constants.ScionAnalytics.PARAM_LABEL, "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "hasMore", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "getKey", "()Ljava/lang/String;", "getLabel", "getCards", "()Ljava/util/List;", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTRecommendCategory;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTRecommendCategory {
    public static final int $stable = 8;
    private final List<MTFullCard> cards;
    private final Boolean hasMore;
    private final String key;
    private final String label;

    public MTRecommendCategory() {
        this(null, null, null, null, 15, null);
    }

    public MTRecommendCategory(String key, String label, List<MTFullCard> list, Boolean bool) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(label, "label");
        this.key = key;
        this.label = label;
        this.cards = list;
        this.hasMore = bool;
    }

    public /* synthetic */ MTRecommendCategory(String str, String str2, List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTRecommendCategory copy$default(MTRecommendCategory mTRecommendCategory, String str, String str2, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTRecommendCategory.key;
        }
        if ((i & 2) != 0) {
            str2 = mTRecommendCategory.label;
        }
        if ((i & 4) != 0) {
            list = mTRecommendCategory.cards;
        }
        if ((i & 8) != 0) {
            bool = mTRecommendCategory.hasMore;
        }
        return mTRecommendCategory.copy(str, str2, list, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public final List<MTFullCard> component3() {
        return this.cards;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final MTRecommendCategory copy(String key, String label, List<MTFullCard> cards, Boolean hasMore) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(label, "label");
        return new MTRecommendCategory(key, label, cards, hasMore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTRecommendCategory)) {
            return false;
        }
        MTRecommendCategory mTRecommendCategory = (MTRecommendCategory) other;
        return Intrinsics.areEqual(this.key, mTRecommendCategory.key) && Intrinsics.areEqual(this.label, mTRecommendCategory.label) && Intrinsics.areEqual(this.cards, mTRecommendCategory.cards) && Intrinsics.areEqual(this.hasMore, mTRecommendCategory.hasMore);
    }

    public final List<MTFullCard> getCards() {
        return this.cards;
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getLabel() {
        return this.label;
    }

    public int hashCode() {
        int iHashCode = ((this.key.hashCode() * 31) + this.label.hashCode()) * 31;
        List<MTFullCard> list = this.cards;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.hasMore;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "MTRecommendCategory(key=" + this.key + ", label=" + this.label + ", cards=" + this.cards + ", hasMore=" + this.hasMore + ")";
    }
}
