package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class aa extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IBinder f417a;
    final /* synthetic */ ad b;

    aa(ad adVar, IBinder iBinder) {
        this.b = adVar;
        this.f417a = iBinder;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        this.b.f419a.o = (IInterface) this.b.f419a.j.a(this.f417a);
        ae.r(this.b.f419a);
        this.b.f419a.h = false;
        Iterator it = this.b.f419a.e.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.b.f419a.e.clear();
    }
}
