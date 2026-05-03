package com.google.android.play.core.assetpacks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public class AssetPackExtractionService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f208a;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f208a;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        d.a(getApplicationContext()).c(this);
    }
}
