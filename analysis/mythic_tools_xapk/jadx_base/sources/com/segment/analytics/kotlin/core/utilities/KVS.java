package com.segment.analytics.kotlin.core.utilities;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KVS.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0017J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/segment/analytics/kotlin/core/utilities/KVS;", "", "contains", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "get", "", "defaultVal", "getInt", "put", "value", "putInt", "remove", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface KVS {

    /* JADX INFO: compiled from: KVS.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(message = "Deprecated in favor of `get`", replaceWith = @ReplaceWith(expression = "get(key, defaultVal)", imports = {}))
        public static int getInt(KVS kvs, String key, int i) {
            Intrinsics.checkNotNullParameter(key, "key");
            return kvs.get(key, i);
        }

        @Deprecated(message = "Deprecated in favor of `put`", replaceWith = @ReplaceWith(expression = "put(key, value)", imports = {}))
        public static boolean putInt(KVS kvs, String key, int i) {
            Intrinsics.checkNotNullParameter(key, "key");
            return kvs.put(key, i);
        }
    }

    boolean contains(String key);

    int get(String key, int defaultVal);

    String get(String key, String defaultVal);

    @Deprecated(message = "Deprecated in favor of `get`", replaceWith = @ReplaceWith(expression = "get(key, defaultVal)", imports = {}))
    int getInt(String key, int defaultVal);

    boolean put(String key, int value);

    boolean put(String key, String value);

    @Deprecated(message = "Deprecated in favor of `put`", replaceWith = @ReplaceWith(expression = "put(key, value)", imports = {}))
    boolean putInt(String key, int value);

    boolean remove(String key);
}
