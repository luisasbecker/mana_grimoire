package com.google.android.play.core.assetpacks.internal;

import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class v extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IBinder f344a;
    final /* synthetic */ x b;

    v(x xVar, IBinder iBinder) {
        this.f344a = iBinder;
        this.b = xVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    public final void a() {
        this.b.f346a.n = e.b(this.f344a);
        z.r(this.b.f346a);
        this.b.f346a.h = false;
        Iterator it = this.b.f346a.e.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.b.f346a.e.clear();
    }
}
