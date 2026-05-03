package com.segment.analytics.kotlin.core;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HTTPClient.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/segment/analytics/kotlin/core/HTTPException;", "Ljava/io/IOException;", "responseCode", "", "responseMessage", "", "responseBody", "responseHeaders", "", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getResponseBody", "()Ljava/lang/String;", InAppPurchaseConstants.METHOD_GET_RESPONSE_CODE, "()I", "getResponseHeaders", "()Ljava/util/Map;", "getResponseMessage", "is4xx", "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HTTPException extends IOException {
    private final String responseBody;
    private final int responseCode;
    private final Map<String, List<String>> responseHeaders;
    private final String responseMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HTTPException(int i, String responseMessage, String str, Map<String, List<String>> responseHeaders) {
        super("HTTP " + i + ": " + responseMessage + ". Response: " + (str == null ? "No response" : str));
        Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        this.responseCode = i;
        this.responseMessage = responseMessage;
        this.responseBody = str;
        this.responseHeaders = responseHeaders;
    }

    public final String getResponseBody() {
        return this.responseBody;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final Map<String, List<String>> getResponseHeaders() {
        return this.responseHeaders;
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public final boolean is4xx() {
        int i = this.responseCode;
        return 400 <= i && i < 500;
    }
}
