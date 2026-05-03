package com.google.android.play.core.assetpacks;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class cs implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.core.assetpacks.internal.o f259a = new com.google.android.play.core.assetpacks.internal.o("ExtractionForegroundServiceConnection");
    private final List b = new ArrayList();
    private final Context c;
    private ExtractionForegroundService d;
    private Notification e;

    cs(Context context) {
        this.c = context;
    }

    private final void d() {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList(this.b);
            this.b.clear();
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            try {
                ((com.google.android.play.core.assetpacks.internal.k) arrayList.get(i)).e(new Bundle(), new Bundle());
            } catch (RemoteException unused) {
                this.f259a.b("Could not resolve Play Store service state update callback.", new Object[0]);
            }
        }
    }

    final void a(Notification notification) {
        this.e = notification;
    }

    final void b() {
        this.f259a.a("Stopping foreground installation service.", new Object[0]);
        this.c.unbindService(this);
        ExtractionForegroundService extractionForegroundService = this.d;
        if (extractionForegroundService != null) {
            extractionForegroundService.a();
        }
        d();
    }

    final void c(com.google.android.play.core.assetpacks.internal.k kVar) {
        synchronized (this.b) {
            this.b.add(kVar);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f259a.a("Starting foreground installation service.", new Object[0]);
        ExtractionForegroundService extractionForegroundService = ((cr) iBinder).f258a;
        this.d = extractionForegroundService;
        extractionForegroundService.startForeground(-1883842196, this.e);
        d();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
