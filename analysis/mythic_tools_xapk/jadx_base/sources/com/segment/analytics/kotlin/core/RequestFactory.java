package com.segment.analytics.kotlin.core;

import androidx.webkit.internal.AssetHelper;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HTTPClient.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/segment/analytics/kotlin/core/RequestFactory;", "", "()V", "openConnection", "Ljava/net/HttpURLConnection;", "url", "", "settings", "cdnHost", "writeKey", "upload", "apiHost", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class RequestFactory {
    public HttpURLConnection openConnection(String url) throws IOException {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            URLConnection uRLConnectionOpenConnection = new URL(url).openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(201000);
            httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, "analytics-kotlin/1.19.2");
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        } catch (MalformedURLException e) {
            IOException iOException = new IOException("Attempted to use malformed url: " + url, e);
            ErrorsKt.reportInternalError(Analytics.INSTANCE, iOException);
            throw iOException;
        }
    }

    public HttpURLConnection settings(String cdnHost, String writeKey) throws IOException {
        Intrinsics.checkNotNullParameter(cdnHost, "cdnHost");
        Intrinsics.checkNotNullParameter(writeKey, "writeKey");
        HttpURLConnection httpURLConnectionOpenConnection = openConnection("https://" + cdnHost + "/projects/" + writeKey + "/settings");
        httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
        int responseCode = httpURLConnectionOpenConnection.getResponseCode();
        if (responseCode == 200) {
            return httpURLConnectionOpenConnection;
        }
        httpURLConnectionOpenConnection.disconnect();
        throw new IOException("HTTP " + responseCode + ": " + httpURLConnectionOpenConnection.getResponseMessage());
    }

    public HttpURLConnection upload(String apiHost) throws IOException {
        Intrinsics.checkNotNullParameter(apiHost, "apiHost");
        HttpURLConnection httpURLConnectionOpenConnection = openConnection("https://" + apiHost + "/b");
        httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, AssetHelper.DEFAULT_MIME_TYPE);
        httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
        httpURLConnectionOpenConnection.setDoOutput(true);
        httpURLConnectionOpenConnection.setChunkedStreamingMode(0);
        return httpURLConnectionOpenConnection;
    }
}
