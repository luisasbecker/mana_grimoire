package com.segment.analytics.kotlin.android.utilities;

import android.content.Intent;
import android.net.Uri;
import com.segment.analytics.kotlin.core.Analytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* JADX INFO: compiled from: DeepLinkUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/segment/analytics/kotlin/android/utilities/DeepLinkUtils;", "", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", "(Lcom/segment/analytics/kotlin/core/Analytics;)V", "getAnalytics", "()Lcom/segment/analytics/kotlin/core/Analytics;", "extractLinkProperties", "Lkotlinx/serialization/json/JsonObject;", "referrer", "", "uri", "Landroid/net/Uri;", "trackDeepLinkFrom", "", "intent", "Landroid/content/Intent;", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeepLinkUtils {
    private final Analytics analytics;

    public DeepLinkUtils(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.analytics = analytics;
    }

    public final JsonObject extractLinkProperties(String referrer, Uri uri) {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        if (referrer != null) {
            JsonElementBuildersKt.put(jsonObjectBuilder, "referrer", referrer);
        }
        if (uri != null) {
            if (uri.isHierarchical()) {
                for (String parameter : uri.getQueryParameterNames()) {
                    String queryParameter = uri.getQueryParameter(parameter);
                    if (queryParameter != null && StringsKt.trim((CharSequence) queryParameter).toString().length() > 0) {
                        Intrinsics.checkNotNullExpressionValue(parameter, "parameter");
                        JsonElementBuildersKt.put(jsonObjectBuilder, parameter, queryParameter);
                    }
                }
            }
            JsonElementBuildersKt.put(jsonObjectBuilder, "url", uri.toString());
        }
        return jsonObjectBuilder.build();
    }

    public final Analytics getAnalytics() {
        return this.analytics;
    }

    public final void trackDeepLinkFrom(String referrer, Intent intent) {
        if (intent == null || intent.getData() == null) {
            return;
        }
        Analytics.track$default(this.analytics, "Deep Link Opened", extractLinkProperties(referrer, intent.getData()), (Function1) null, 4, (Object) null);
    }
}
