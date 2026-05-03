package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTRecommendResponse;", "", "categories", "", "Lcom/studiolaganne/lengendarylens/MTRecommendCategory;", "meta", "Lcom/studiolaganne/lengendarylens/MTRecommendMeta;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTRecommendMeta;)V", "getCategories", "()Ljava/util/List;", "getMeta", "()Lcom/studiolaganne/lengendarylens/MTRecommendMeta;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTRecommendResponse {
    public static final int $stable = 8;
    private final List<MTRecommendCategory> categories;
    private final MTRecommendMeta meta;

    /* JADX WARN: Multi-variable type inference failed */
    public MTRecommendResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MTRecommendResponse(List<MTRecommendCategory> list, MTRecommendMeta mTRecommendMeta) {
        this.categories = list;
        this.meta = mTRecommendMeta;
    }

    public /* synthetic */ MTRecommendResponse(List list, MTRecommendMeta mTRecommendMeta, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : mTRecommendMeta);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTRecommendResponse copy$default(MTRecommendResponse mTRecommendResponse, List list, MTRecommendMeta mTRecommendMeta, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mTRecommendResponse.categories;
        }
        if ((i & 2) != 0) {
            mTRecommendMeta = mTRecommendResponse.meta;
        }
        return mTRecommendResponse.copy(list, mTRecommendMeta);
    }

    public final List<MTRecommendCategory> component1() {
        return this.categories;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MTRecommendMeta getMeta() {
        return this.meta;
    }

    public final MTRecommendResponse copy(List<MTRecommendCategory> categories, MTRecommendMeta meta) {
        return new MTRecommendResponse(categories, meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTRecommendResponse)) {
            return false;
        }
        MTRecommendResponse mTRecommendResponse = (MTRecommendResponse) other;
        return Intrinsics.areEqual(this.categories, mTRecommendResponse.categories) && Intrinsics.areEqual(this.meta, mTRecommendResponse.meta);
    }

    public final List<MTRecommendCategory> getCategories() {
        return this.categories;
    }

    public final MTRecommendMeta getMeta() {
        return this.meta;
    }

    public int hashCode() {
        List<MTRecommendCategory> list = this.categories;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        MTRecommendMeta mTRecommendMeta = this.meta;
        return iHashCode + (mTRecommendMeta != null ? mTRecommendMeta.hashCode() : 0);
    }

    public String toString() {
        return "MTRecommendResponse(categories=" + this.categories + ", meta=" + this.meta + ")";
    }
}
