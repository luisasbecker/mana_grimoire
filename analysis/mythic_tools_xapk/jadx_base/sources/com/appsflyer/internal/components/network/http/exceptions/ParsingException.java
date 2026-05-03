package com.appsflyer.internal.components.network.http.exceptions;

import com.appsflyer.internal.AFe1ySDK;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ParsingException extends IOException {
    private final AFe1ySDK<String> getRevenue;

    public ParsingException(String str, Throwable th, AFe1ySDK<String> aFe1ySDK) {
        super(str, th);
        this.getRevenue = aFe1ySDK;
    }

    public AFe1ySDK<String> getRawResponse() {
        return this.getRevenue;
    }
}
