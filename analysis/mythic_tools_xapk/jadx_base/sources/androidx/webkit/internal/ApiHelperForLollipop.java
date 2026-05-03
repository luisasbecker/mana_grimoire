package androidx.webkit.internal;

import android.net.Uri;
import android.webkit.WebResourceRequest;

/* JADX INFO: loaded from: classes3.dex */
public class ApiHelperForLollipop {
    private ApiHelperForLollipop() {
    }

    public static Uri getUrl(WebResourceRequest webResourceRequest) {
        return webResourceRequest.getUrl();
    }

    public static boolean isForMainFrame(WebResourceRequest webResourceRequest) {
        return webResourceRequest.isForMainFrame();
    }
}
