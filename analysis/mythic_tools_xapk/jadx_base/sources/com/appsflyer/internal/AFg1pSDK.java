package com.appsflyer.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class AFg1pSDK {
    public static boolean getCurrencyIso4217Code(Context context) {
        return context.getPackageManager().isInstantApp();
    }
}
