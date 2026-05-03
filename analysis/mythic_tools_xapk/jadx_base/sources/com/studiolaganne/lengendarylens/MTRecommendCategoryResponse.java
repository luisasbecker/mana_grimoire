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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003Jh\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTRecommendCategoryResponse;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", Constants.ScionAnalytics.PARAM_LABEL, "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "total", "", "page", "limit", "meta", "Lcom/studiolaganne/lengendarylens/MTRecommendMeta;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTRecommendMeta;)V", "getKey", "()Ljava/lang/String;", "getLabel", "getCards", "()Ljava/util/List;", "getTotal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPage", "getLimit", "getMeta", "()Lcom/studiolaganne/lengendarylens/MTRecommendMeta;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTRecommendMeta;)Lcom/studiolaganne/lengendarylens/MTRecommendCategoryResponse;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTRecommendCategoryResponse {
    public static final int $stable = 8;
    private final List<MTFullCard> cards;
    private final String key;
    private final String label;
    private final Integer limit;
    private final MTRecommendMeta meta;
    private final Integer page;
    private final Integer total;

    public MTRecommendCategoryResponse() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public MTRecommendCategoryResponse(String str, String str2, List<MTFullCard> list, Integer num, Integer num2, Integer num3, MTRecommendMeta mTRecommendMeta) {
        this.key = str;
        this.label = str2;
        this.cards = list;
        this.total = num;
        this.page = num2;
        this.limit = num3;
        this.meta = mTRecommendMeta;
    }

    public /* synthetic */ MTRecommendCategoryResponse(String str, String str2, List list, Integer num, Integer num2, Integer num3, MTRecommendMeta mTRecommendMeta, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : mTRecommendMeta);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTRecommendCategoryResponse copy$default(MTRecommendCategoryResponse mTRecommendCategoryResponse, String str, String str2, List list, Integer num, Integer num2, Integer num3, MTRecommendMeta mTRecommendMeta, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTRecommendCategoryResponse.key;
        }
        if ((i & 2) != 0) {
            str2 = mTRecommendCategoryResponse.label;
        }
        if ((i & 4) != 0) {
            list = mTRecommendCategoryResponse.cards;
        }
        if ((i & 8) != 0) {
            num = mTRecommendCategoryResponse.total;
        }
        if ((i & 16) != 0) {
            num2 = mTRecommendCategoryResponse.page;
        }
        if ((i & 32) != 0) {
            num3 = mTRecommendCategoryResponse.limit;
        }
        if ((i & 64) != 0) {
            mTRecommendMeta = mTRecommendCategoryResponse.meta;
        }
        Integer num4 = num3;
        MTRecommendMeta mTRecommendMeta2 = mTRecommendMeta;
        Integer num5 = num2;
        List list2 = list;
        return mTRecommendCategoryResponse.copy(str, str2, list2, num, num5, num4, mTRecommendMeta2);
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
    public final Integer getTotal() {
        return this.total;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getPage() {
        return this.page;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MTRecommendMeta getMeta() {
        return this.meta;
    }

    public final MTRecommendCategoryResponse copy(String key, String label, List<MTFullCard> cards, Integer total, Integer page, Integer limit, MTRecommendMeta meta) {
        return new MTRecommendCategoryResponse(key, label, cards, total, page, limit, meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTRecommendCategoryResponse)) {
            return false;
        }
        MTRecommendCategoryResponse mTRecommendCategoryResponse = (MTRecommendCategoryResponse) other;
        return Intrinsics.areEqual(this.key, mTRecommendCategoryResponse.key) && Intrinsics.areEqual(this.label, mTRecommendCategoryResponse.label) && Intrinsics.areEqual(this.cards, mTRecommendCategoryResponse.cards) && Intrinsics.areEqual(this.total, mTRecommendCategoryResponse.total) && Intrinsics.areEqual(this.page, mTRecommendCategoryResponse.page) && Intrinsics.areEqual(this.limit, mTRecommendCategoryResponse.limit) && Intrinsics.areEqual(this.meta, mTRecommendCategoryResponse.meta);
    }

    public final List<MTFullCard> getCards() {
        return this.cards;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getLabel() {
        return this.label;
    }

    public final Integer getLimit() {
        return this.limit;
    }

    public final MTRecommendMeta getMeta() {
        return this.meta;
    }

    public final Integer getPage() {
        return this.page;
    }

    public final Integer getTotal() {
        return this.total;
    }

    public int hashCode() {
        String str = this.key;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.label;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<MTFullCard> list = this.cards;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.total;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.page;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.limit;
        int iHashCode6 = (iHashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        MTRecommendMeta mTRecommendMeta = this.meta;
        return iHashCode6 + (mTRecommendMeta != null ? mTRecommendMeta.hashCode() : 0);
    }

    public String toString() {
        return "MTRecommendCategoryResponse(key=" + this.key + ", label=" + this.label + ", cards=" + this.cards + ", total=" + this.total + ", page=" + this.page + ", limit=" + this.limit + ", meta=" + this.meta + ")";
    }
}
