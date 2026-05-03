package com.google.android.play.core.assetpacks.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class s extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f342a;
    final /* synthetic */ p b;
    final /* synthetic */ z c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    s(z zVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, p pVar) {
        super(taskCompletionSource);
        this.f342a = taskCompletionSource2;
        this.b = pVar;
        this.c = zVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    public final void a() {
        synchronized (this.c.g) {
            z.o(this.c, this.f342a);
            if (this.c.l.getAndIncrement() > 0) {
                this.c.c.d("Already connected to the service.", new Object[0]);
            }
            z.q(this.c, this.b);
        }
    }
}
