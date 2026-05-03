package com.segment.analytics.kotlin.android;

import android.content.Context;
import android.content.Intent;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.segment.analytics.kotlin.android.plugins.AndroidLifecyclePlugin;
import com.segment.analytics.kotlin.android.utilities.DeepLinkUtils;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.Configuration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AndroidAnalytics.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u001a\u001e\u0010\u000b\u001a\u00020\t*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\f\u0010\u000f\u001a\u00020\t*\u00020\u0001H\u0002¨\u0006\u0010"}, d2 = {"Analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "writeKey", "", "context", "Landroid/content/Context;", "configs", "Lkotlin/Function1;", "Lcom/segment/analytics/kotlin/core/Configuration;", "", "Lkotlin/ExtensionFunctionType;", "openUrl", "referrer", "intent", "Landroid/content/Intent;", "startup", "android_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidAnalyticsKt {
    public static final Analytics Analytics(String writeKey, Context context) {
        Intrinsics.checkNotNullParameter(writeKey, "writeKey");
        Intrinsics.checkNotNullParameter(context, "context");
        if (StringsKt.isBlank(writeKey)) {
            throw new IllegalArgumentException("writeKey cannot be blank ".toString());
        }
        Analytics analytics = new Analytics(new Configuration(writeKey, context, AndroidStorageProvider.INSTANCE, false, false, false, false, 0, 0, null, null, false, null, null, null, null, 65528, null));
        startup(analytics);
        return analytics;
    }

    public static final Analytics Analytics(String writeKey, Context context, Function1<? super Configuration, Unit> configs) {
        Intrinsics.checkNotNullParameter(writeKey, "writeKey");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configs, "configs");
        Analytics.INSTANCE.setLogger(new AndroidLogger());
        if (StringsKt.isBlank(writeKey)) {
            throw new IllegalArgumentException("writeKey cannot be blank ".toString());
        }
        Configuration configuration = new Configuration(writeKey, context, AndroidStorageProvider.INSTANCE, false, false, false, false, 0, 0, null, null, false, null, null, null, null, 65528, null);
        configs.invoke(configuration);
        Analytics analytics = new Analytics(configuration);
        startup(analytics);
        return analytics;
    }

    public static final void openUrl(Analytics analytics, String str, Intent intent) {
        Intrinsics.checkNotNullParameter(analytics, "<this>");
        new DeepLinkUtils(analytics).trackDeepLinkFrom(str, intent);
    }

    private static final void startup(Analytics analytics) {
        analytics.add(new AndroidContextPlugin());
        analytics.add(new AndroidLifecyclePlugin());
    }
}
