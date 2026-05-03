package com.appsflyer.internal;

import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.appsflyer.share.LinkGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class AFe1kSDK extends AFe1bSDK<String> {
    private final String component2;
    private final String copy;
    private final LinkGenerator.ResponseListener copydefault;
    private final LinkGenerator equals;
    private final Map<String, String> hashCode;
    private final UUID toString;

    public AFe1kSDK(AFd1zSDK aFd1zSDK, UUID uuid, String str, Map<String, String> map, String str2, LinkGenerator.ResponseListener responseListener, LinkGenerator linkGenerator) {
        super(AFe1lSDK.ONELINK, new AFe1lSDK[]{AFe1lSDK.RC_CDN}, aFd1zSDK, uuid.toString());
        this.toString = uuid;
        this.component2 = str;
        this.hashCode = new HashMap(map);
        this.copydefault = responseListener;
        this.copy = str2;
        this.equals = linkGenerator;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final boolean a_() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final AppsFlyerRequestListener component1() {
        return null;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final boolean copy() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final void getMonetizationNetwork() {
        super.getMonetizationNetwork();
        LinkGenerator.ResponseListener responseListener = this.copydefault;
        if (responseListener != null) {
            if (this.AFAdRevenueData == AFe1rSDK.SUCCESS && ((AFe1bSDK) this).component4 != null) {
                responseListener.onResponse((String) ((AFe1bSDK) this).component4.getBody());
                return;
            }
            Throwable thComponent2 = component2();
            if (!(thComponent2 instanceof ParsingException)) {
                responseListener.onResponse(this.equals.generateLink());
            } else if (((ParsingException) thComponent2).getRawResponse().isSuccessful()) {
                responseListener.onResponseError("Can't parse one link data");
            } else {
                responseListener.onResponse(this.equals.generateLink());
            }
        }
    }

    @Override // com.appsflyer.internal.AFe1bSDK, com.appsflyer.internal.AFe1uSDK
    public final long getRevenue() {
        return 3000L;
    }

    @Override // com.appsflyer.internal.AFe1bSDK
    protected final AFd1fSDK<String> getRevenue(String str) {
        return ((AFe1bSDK) this).component3.getCurrencyIso4217Code(this.component2, this.hashCode, this.copy, this.toString, str);
    }
}
