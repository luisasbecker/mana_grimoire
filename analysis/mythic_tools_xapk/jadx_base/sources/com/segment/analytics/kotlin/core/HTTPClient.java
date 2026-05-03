package com.segment.analytics.kotlin.core;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HTTPClient.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/segment/analytics/kotlin/core/HTTPClient;", "", "writeKey", "", "requestFactory", "Lcom/segment/analytics/kotlin/core/RequestFactory;", "(Ljava/lang/String;Lcom/segment/analytics/kotlin/core/RequestFactory;)V", "openConnection", "Ljava/net/HttpURLConnection;", "url", "settings", "Lcom/segment/analytics/kotlin/core/Connection;", "cdnHost", "upload", "apiHost", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HTTPClient {
    private final RequestFactory requestFactory;
    private final String writeKey;

    public HTTPClient(String writeKey, RequestFactory requestFactory) {
        Intrinsics.checkNotNullParameter(writeKey, "writeKey");
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        this.writeKey = writeKey;
        this.requestFactory = requestFactory;
    }

    public /* synthetic */ HTTPClient(String str, RequestFactory requestFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new RequestFactory() : requestFactory);
    }

    private final HttpURLConnection openConnection(String url) throws IOException {
        try {
            URLConnection uRLConnectionOpenConnection = new URL(url).openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
            httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, "analytics-kotlin/1.19.2");
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        } catch (MalformedURLException e) {
            MalformedURLException malformedURLException = e;
            IOException iOException = new IOException("Attempted to use malformed url: " + url, malformedURLException);
            ErrorsKt.reportErrorWithMetrics(null, malformedURLException, "Attempted to use malformed url: " + url, Telemetry.INVOKE_ERROR_METRIC, ExceptionsKt.stackTraceToString(malformedURLException), new Function1<Map<String, String>, Unit>() { // from class: com.segment.analytics.kotlin.core.HTTPClient$openConnection$requestedURL$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<String, String> map) {
                    invoke2(map);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<String, String> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.put("error", e.toString());
                    it.put("writekey", this.writeKey);
                    it.put("message", "Malformed url");
                }
            });
            throw iOException;
        }
    }

    public final Connection settings(String cdnHost) {
        Intrinsics.checkNotNullParameter(cdnHost, "cdnHost");
        return HTTPClientKt.createGetConnection(this.requestFactory.settings(cdnHost, this.writeKey));
    }

    public final Connection upload(String apiHost) {
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        return HTTPClientKt.createPostConnection(this.requestFactory.upload(apiHost));
    }
}
