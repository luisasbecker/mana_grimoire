package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/NetworkHelper;", "", "<init>", "()V", "lastCheckTimeMillis", "", "lastNetworkAvailable", "", "CACHE_DURATION_MILLIS", "isNetworkAvailable", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NetworkHelper {
    private static final long CACHE_DURATION_MILLIS = 5000;
    private static long lastCheckTimeMillis;
    private static boolean lastNetworkAvailable;
    public static final NetworkHelper INSTANCE = new NetworkHelper();
    public static final int $stable = 8;

    private NetworkHelper() {
    }

    public final boolean isNetworkAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - lastCheckTimeMillis < 5000) {
            return lastNetworkAvailable;
        }
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        boolean z = activeNetwork != null && networkCapabilities != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
        lastNetworkAvailable = z;
        lastCheckTimeMillis = jElapsedRealtime;
        return z;
    }
}
