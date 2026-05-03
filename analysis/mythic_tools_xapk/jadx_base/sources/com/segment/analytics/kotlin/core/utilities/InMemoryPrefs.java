package com.segment.analytics.kotlin.core.utilities;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.segment.analytics.kotlin.core.utilities.KVS;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KVS.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/segment/analytics/kotlin/core/utilities/InMemoryPrefs;", "Lcom/segment/analytics/kotlin/core/utilities/KVS;", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "contains", "", SubscriberAttributeKt.JSON_NAME_KEY, "get", "", "defaultVal", "put", "value", "remove", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InMemoryPrefs implements KVS {
    private final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public boolean contains(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.cache.containsKey(key);
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public int get(String key, int defaultVal) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!(this.cache.get(key) instanceof Integer)) {
            return defaultVal;
        }
        Object obj = this.cache.get(key);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) obj).intValue();
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public String get(String key, String defaultVal) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!(this.cache.get(key) instanceof String)) {
            return defaultVal;
        }
        Object obj = this.cache.get(key);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        return (String) obj;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    @Deprecated(message = "Deprecated in favor of `get`", replaceWith = @ReplaceWith(expression = "get(key, defaultVal)", imports = {}))
    public int getInt(String str, int i) {
        return KVS.DefaultImpls.getInt(this, str, i);
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public boolean put(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.cache.put(key, Integer.valueOf(value));
        return true;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public boolean put(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.cache.put(key, value);
        return true;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    @Deprecated(message = "Deprecated in favor of `put`", replaceWith = @ReplaceWith(expression = "put(key, value)", imports = {}))
    public boolean putInt(String str, int i) {
        return KVS.DefaultImpls.putInt(this, str, i);
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public boolean remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.cache.remove(key);
        return true;
    }
}
