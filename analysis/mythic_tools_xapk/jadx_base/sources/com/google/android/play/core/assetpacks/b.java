package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class b extends com.google.android.play.core.assetpacks.internal.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.core.assetpacks.internal.o f228a = new com.google.android.play.core.assetpacks.internal.o("AssetPackExtractionService");
    private final Context b;
    private final bm c;
    private final l d;
    private final cs e;
    private final ep f;

    b(Context context, bm bmVar, l lVar, cs csVar, ep epVar) {
        this.b = context;
        this.c = bmVar;
        this.d = lVar;
        this.e = csVar;
        this.f = epVar;
    }

    private final synchronized void d(Bundle bundle, com.google.android.play.core.assetpacks.internal.k kVar) throws RemoteException {
        this.f228a.a("updateServiceState AIDL call", new Object[0]);
        if (com.google.android.play.core.assetpacks.internal.ai.b(this.b) && com.google.android.play.core.assetpacks.internal.ai.a(this.b)) {
            int i = bundle.getInt("action_type");
            this.e.c(kVar);
            if (i == 1) {
                this.f.b(bundle);
                this.d.g(true);
                this.e.a(this.f.a(bundle));
                this.b.bindService(new Intent(this.b, (Class<?>) ExtractionForegroundService.class), this.e, 1);
                return;
            }
            if (i == 2) {
                this.d.g(false);
                this.e.b();
                return;
            } else {
                this.f228a.b("Unknown action type received: %d", Integer.valueOf(i));
                kVar.d(new Bundle());
                return;
            }
        }
        kVar.d(new Bundle());
    }

    @Override // com.google.android.play.core.assetpacks.internal.j
    public final void b(Bundle bundle, com.google.android.play.core.assetpacks.internal.k kVar) throws RemoteException {
        this.f228a.a("clearAssetPackStorage AIDL call", new Object[0]);
        if (!com.google.android.play.core.assetpacks.internal.ai.b(this.b) || !com.google.android.play.core.assetpacks.internal.ai.a(this.b)) {
            kVar.d(new Bundle());
        } else {
            this.c.z();
            kVar.c(new Bundle());
        }
    }

    @Override // com.google.android.play.core.assetpacks.internal.j
    public final void c(Bundle bundle, com.google.android.play.core.assetpacks.internal.k kVar) throws RemoteException {
        d(bundle, kVar);
    }
}
