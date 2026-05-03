package com.appsflyer.internal;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class AFk1ySDK {
    public String getMonetizationNetwork;
    public final WeakReference<Context> getRevenue;

    public AFk1ySDK(Context context) {
        this.getRevenue = new WeakReference<>(context);
    }
}
