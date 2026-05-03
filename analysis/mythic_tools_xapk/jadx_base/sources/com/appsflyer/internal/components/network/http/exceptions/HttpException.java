package com.appsflyer.internal.components.network.http.exceptions;

import com.appsflyer.internal.AFd1dSDK;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class HttpException extends IOException {
    private final AFd1dSDK getRevenue;

    public HttpException(Throwable th, AFd1dSDK aFd1dSDK) {
        super(th.getMessage(), th);
        this.getRevenue = aFd1dSDK;
    }

    public AFd1dSDK getMetrics() {
        return this.getRevenue;
    }
}
