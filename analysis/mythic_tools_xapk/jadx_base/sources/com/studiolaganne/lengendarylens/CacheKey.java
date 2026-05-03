package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardContainerCache.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/CacheKey;", "", "containerId", "", "orderBy", "", "orderDirection", "groupBy", "nameFilter", "scryfallFilter", "pagesLoaded", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getContainerId", "()I", "getOrderBy", "()Ljava/lang/String;", "getOrderDirection", "getGroupBy", "getNameFilter", "getScryfallFilter", "getPagesLoaded", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CacheKey {
    public static final int $stable = 0;
    private final int containerId;
    private final String groupBy;
    private final String nameFilter;
    private final String orderBy;
    private final String orderDirection;
    private final int pagesLoaded;
    private final String scryfallFilter;

    public CacheKey(int i, String str, String str2, String str3, String str4, String str5, int i2) {
        this.containerId = i;
        this.orderBy = str;
        this.orderDirection = str2;
        this.groupBy = str3;
        this.nameFilter = str4;
        this.scryfallFilter = str5;
        this.pagesLoaded = i2;
    }

    public /* synthetic */ CacheKey(int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? null : str5, (i3 & 64) != 0 ? 1 : i2);
    }

    public static /* synthetic */ CacheKey copy$default(CacheKey cacheKey, int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = cacheKey.containerId;
        }
        if ((i3 & 2) != 0) {
            str = cacheKey.orderBy;
        }
        if ((i3 & 4) != 0) {
            str2 = cacheKey.orderDirection;
        }
        if ((i3 & 8) != 0) {
            str3 = cacheKey.groupBy;
        }
        if ((i3 & 16) != 0) {
            str4 = cacheKey.nameFilter;
        }
        if ((i3 & 32) != 0) {
            str5 = cacheKey.scryfallFilter;
        }
        if ((i3 & 64) != 0) {
            i2 = cacheKey.pagesLoaded;
        }
        String str6 = str5;
        int i4 = i2;
        String str7 = str4;
        String str8 = str2;
        return cacheKey.copy(i, str, str8, str3, str7, str6, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getContainerId() {
        return this.containerId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOrderBy() {
        return this.orderBy;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOrderDirection() {
        return this.orderDirection;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getGroupBy() {
        return this.groupBy;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNameFilter() {
        return this.nameFilter;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getScryfallFilter() {
        return this.scryfallFilter;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getPagesLoaded() {
        return this.pagesLoaded;
    }

    public final CacheKey copy(int containerId, String orderBy, String orderDirection, String groupBy, String nameFilter, String scryfallFilter, int pagesLoaded) {
        return new CacheKey(containerId, orderBy, orderDirection, groupBy, nameFilter, scryfallFilter, pagesLoaded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheKey)) {
            return false;
        }
        CacheKey cacheKey = (CacheKey) other;
        return this.containerId == cacheKey.containerId && Intrinsics.areEqual(this.orderBy, cacheKey.orderBy) && Intrinsics.areEqual(this.orderDirection, cacheKey.orderDirection) && Intrinsics.areEqual(this.groupBy, cacheKey.groupBy) && Intrinsics.areEqual(this.nameFilter, cacheKey.nameFilter) && Intrinsics.areEqual(this.scryfallFilter, cacheKey.scryfallFilter) && this.pagesLoaded == cacheKey.pagesLoaded;
    }

    public final int getContainerId() {
        return this.containerId;
    }

    public final String getGroupBy() {
        return this.groupBy;
    }

    public final String getNameFilter() {
        return this.nameFilter;
    }

    public final String getOrderBy() {
        return this.orderBy;
    }

    public final String getOrderDirection() {
        return this.orderDirection;
    }

    public final int getPagesLoaded() {
        return this.pagesLoaded;
    }

    public final String getScryfallFilter() {
        return this.scryfallFilter;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.containerId) * 31;
        String str = this.orderBy;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.orderDirection;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.groupBy;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nameFilter;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.scryfallFilter;
        return ((iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + Integer.hashCode(this.pagesLoaded);
    }

    public String toString() {
        return "CacheKey(containerId=" + this.containerId + ", orderBy=" + this.orderBy + ", orderDirection=" + this.orderDirection + ", groupBy=" + this.groupBy + ", nameFilter=" + this.nameFilter + ", scryfallFilter=" + this.scryfallFilter + ", pagesLoaded=" + this.pagesLoaded + ")";
    }
}
