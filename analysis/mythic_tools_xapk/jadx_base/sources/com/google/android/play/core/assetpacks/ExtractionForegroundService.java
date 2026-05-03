package com.google.android.play.core.assetpacks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public class ExtractionForegroundService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f210a = new cr(this);

    public final synchronized void a() {
        stopForeground(true);
        stopSelf();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f210a;
    }
}
