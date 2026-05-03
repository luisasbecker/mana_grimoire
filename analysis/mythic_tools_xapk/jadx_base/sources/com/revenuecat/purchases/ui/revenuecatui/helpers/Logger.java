package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Logger;", "", "()V", "TAG", "", "d", "", "message", "e", "throwable", "", "i", "w", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Logger {
    public static final int $stable = 0;
    public static final Logger INSTANCE = new Logger();
    private static final String TAG = "[Purchases]";

    private Logger() {
    }

    public final void d(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Log.d(TAG, message);
    }

    public final void e(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Log.e(TAG, message);
    }

    public final void e(String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Log.e(TAG, message, throwable);
    }

    public final void i(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Log.i(TAG, message);
    }

    public final void w(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Log.w(TAG, message);
    }
}
