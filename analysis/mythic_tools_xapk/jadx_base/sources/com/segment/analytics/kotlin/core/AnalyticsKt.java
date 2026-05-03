package com.segment.analytics.kotlin.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Analytics.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b\u001a\b\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"Analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "writeKey", "", "configs", "Lkotlin/Function1;", "Lcom/segment/analytics/kotlin/core/Configuration;", "", "Lkotlin/ExtensionFunctionType;", "isAndroid", "", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnalyticsKt {
    public static final Analytics Analytics(String writeKey, Function1<? super Configuration, Unit> configs) {
        Intrinsics.checkNotNullParameter(writeKey, "writeKey");
        Intrinsics.checkNotNullParameter(configs, "configs");
        if (isAndroid()) {
            throw new IllegalStateException("Using JVM Analytics initializer in Android platform. Context is required in constructor!".toString());
        }
        Configuration configuration = new Configuration(writeKey, null, null, false, false, false, false, 0, 0, null, null, false, null, null, null, null, 65534, null);
        configs.invoke(configuration);
        return new Analytics(configuration);
    }

    public static final boolean isAndroid() {
        try {
            Class.forName("com.segment.analytics.kotlin.android.AndroidStorage");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
