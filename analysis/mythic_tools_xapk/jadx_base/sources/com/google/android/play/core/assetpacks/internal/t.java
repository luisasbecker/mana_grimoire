package com.google.android.play.core.assetpacks.internal;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class t extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f343a;

    t(z zVar) {
        this.f343a = zVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    public final void a() {
        synchronized (this.f343a.g) {
            if (this.f343a.l.get() > 0 && this.f343a.l.decrementAndGet() > 0) {
                this.f343a.c.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                return;
            }
            z zVar = this.f343a;
            if (zVar.n != null) {
                zVar.c.d("Unbind from service.", new Object[0]);
                z zVar2 = this.f343a;
                zVar2.b.unbindService(zVar2.m);
                this.f343a.h = false;
                this.f343a.n = null;
                this.f343a.m = null;
            }
            this.f343a.w();
        }
    }
}
