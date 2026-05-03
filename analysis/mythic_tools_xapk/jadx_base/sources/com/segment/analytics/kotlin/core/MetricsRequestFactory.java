package com.segment.analytics.kotlin.core;

import androidx.webkit.internal.AssetHelper;
import com.google.common.net.HttpHeaders;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Telemetry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/segment/analytics/kotlin/core/MetricsRequestFactory;", "Lcom/segment/analytics/kotlin/core/RequestFactory;", "()V", "upload", "Ljava/net/HttpURLConnection;", "apiHost", "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MetricsRequestFactory extends RequestFactory {
    @Override // com.segment.analytics.kotlin.core.RequestFactory
    public HttpURLConnection upload(String apiHost) {
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        HttpURLConnection httpURLConnectionOpenConnection = openConnection("https://" + apiHost + "/m");
        httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, AssetHelper.DEFAULT_MIME_TYPE);
        httpURLConnectionOpenConnection.setDoOutput(true);
        httpURLConnectionOpenConnection.setChunkedStreamingMode(0);
        return httpURLConnectionOpenConnection;
    }
}
