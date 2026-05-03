package com.appsflyer.internal;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.media3.common.MimeTypes;
import androidx.webkit.internal.AssetHelper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f"}, d2 = {"Lcom/appsflyer/internal/AFd1hSDK;", "", "", "p0", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCurrencyIso4217Code", "Ljava/lang/String;", "getMediationNetwork", "getRevenue", "AFAdRevenueData", "getMonetizationNetwork", "component1", "component2", "areAllFieldsValid", "component4"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum AFd1hSDK {
    TEXT(AssetHelper.DEFAULT_MIME_TYPE),
    JSON("application/json"),
    OCTET_STREAM("application/octet-stream"),
    XML("application/xml"),
    HTML("text/html"),
    FORM(ShareTarget.ENCODING_TYPE_URL_ENCODED),
    IMAGE_JPEG("image/jpeg"),
    IMAGE_PNG(MimeTypes.IMAGE_PNG);


    /* JADX INFO: renamed from: getCurrencyIso4217Code, reason: from kotlin metadata */
    public final String getMediationNetwork;

    AFd1hSDK(String str) {
        this.getMediationNetwork = str;
    }
}
