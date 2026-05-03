package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardContainerCache.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/CachedContainer;", "", "container", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/studiolaganne/lengendarylens/CacheKey;", DiagnosticsEntry.TIMESTAMP_KEY, "", "version", "", "<init>", "(Lcom/studiolaganne/lengendarylens/MTCardContainer;Lcom/studiolaganne/lengendarylens/CacheKey;JI)V", "getContainer", "()Lcom/studiolaganne/lengendarylens/MTCardContainer;", "getKey", "()Lcom/studiolaganne/lengendarylens/CacheKey;", "getTimestamp", "()J", "getVersion", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CachedContainer {
    public static final int $stable = 8;
    private final MTCardContainer container;
    private final CacheKey key;
    private final long timestamp;
    private final int version;

    public CachedContainer(MTCardContainer container, CacheKey key, long j, int i) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(key, "key");
        this.container = container;
        this.key = key;
        this.timestamp = j;
        this.version = i;
    }

    public /* synthetic */ CachedContainer(MTCardContainer mTCardContainer, CacheKey cacheKey, long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(mTCardContainer, cacheKey, (i2 & 4) != 0 ? System.currentTimeMillis() : j, (i2 & 8) != 0 ? 0 : i);
    }

    public static /* synthetic */ CachedContainer copy$default(CachedContainer cachedContainer, MTCardContainer mTCardContainer, CacheKey cacheKey, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mTCardContainer = cachedContainer.container;
        }
        if ((i2 & 2) != 0) {
            cacheKey = cachedContainer.key;
        }
        if ((i2 & 4) != 0) {
            j = cachedContainer.timestamp;
        }
        if ((i2 & 8) != 0) {
            i = cachedContainer.version;
        }
        int i3 = i;
        return cachedContainer.copy(mTCardContainer, cacheKey, j, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTCardContainer getContainer() {
        return this.container;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CacheKey getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final CachedContainer copy(MTCardContainer container, CacheKey key, long timestamp, int version) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(key, "key");
        return new CachedContainer(container, key, timestamp, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CachedContainer)) {
            return false;
        }
        CachedContainer cachedContainer = (CachedContainer) other;
        return Intrinsics.areEqual(this.container, cachedContainer.container) && Intrinsics.areEqual(this.key, cachedContainer.key) && this.timestamp == cachedContainer.timestamp && this.version == cachedContainer.version;
    }

    public final MTCardContainer getContainer() {
        return this.container;
    }

    public final CacheKey getKey() {
        return this.key;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((this.container.hashCode() * 31) + this.key.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + Integer.hashCode(this.version);
    }

    public String toString() {
        return "CachedContainer(container=" + this.container + ", key=" + this.key + ", timestamp=" + this.timestamp + ", version=" + this.version + ")";
    }
}
