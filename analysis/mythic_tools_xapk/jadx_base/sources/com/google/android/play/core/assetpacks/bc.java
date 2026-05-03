package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class bc extends com.google.android.play.core.assetpacks.internal.n {
    private final dt c;
    private final da d;
    private final ci e;
    private final dd f;
    private final er g;
    private final Handler h;
    private final com.google.android.play.core.assetpacks.internal.aq i;
    private final com.google.android.play.core.assetpacks.internal.aq j;
    private final com.google.android.play.core.assetpacks.internal.aq k;

    bc(Context context, dt dtVar, da daVar, com.google.android.play.core.assetpacks.internal.aq aqVar, dd ddVar, ci ciVar, com.google.android.play.core.assetpacks.internal.aq aqVar2, com.google.android.play.core.assetpacks.internal.aq aqVar3, er erVar) {
        super(new com.google.android.play.core.assetpacks.internal.o("AssetPackServiceListenerRegistry"), new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE"), context);
        this.h = new Handler(Looper.getMainLooper());
        this.c = dtVar;
        this.d = daVar;
        this.i = aqVar;
        this.f = ddVar;
        this.e = ciVar;
        this.j = aqVar2;
        this.k = aqVar3;
        this.g = erVar;
    }

    public static /* synthetic */ void a(bc bcVar, Bundle bundle) {
        if (bcVar.c.p(bundle)) {
            bcVar.d.a();
        }
    }

    public static /* synthetic */ void b(final bc bcVar, Bundle bundle, final AssetPackState assetPackState) {
        if (bcVar.c.o(bundle)) {
            bcVar.h.post(new Runnable() { // from class: com.google.android.play.core.assetpacks.az
                @Override // java.lang.Runnable
                public final void run() {
                    this.f227a.h(assetPackState);
                }
            });
            ((z) bcVar.i.a()).f();
        }
    }

    @Override // com.google.android.play.core.assetpacks.internal.n
    protected final void c(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.FLAGS");
        if (bundleExtra == null || !bundleExtra.getBoolean("enableWorkManager")) {
            final Bundle bundleExtra2 = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
            if (bundleExtra2 == null) {
                this.f337a.b("Empty bundle received from broadcast.", new Object[0]);
                return;
            }
            ArrayList<String> stringArrayList = bundleExtra2.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                this.f337a.b("Corrupt bundle received from broadcast.", new Object[0]);
                return;
            }
            final AssetPackState assetPackStateB = AssetPackState.b(bundleExtra2, stringArrayList.get(0), this.f, this.g);
            this.f337a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", assetPackStateB);
            PendingIntent pendingIntent = (PendingIntent) bundleExtra2.getParcelable("confirmation_intent");
            if (pendingIntent != null) {
                this.e.b(pendingIntent);
            }
            ((Executor) this.k.a()).execute(new Runnable() { // from class: com.google.android.play.core.assetpacks.ba
                @Override // java.lang.Runnable
                public final void run() {
                    bc.b(this.f229a, bundleExtra2, assetPackStateB);
                }
            });
            ((Executor) this.j.a()).execute(new Runnable() { // from class: com.google.android.play.core.assetpacks.bb
                @Override // java.lang.Runnable
                public final void run() {
                    bc.a(this.f230a, bundleExtra2);
                }
            });
        }
    }
}
