package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class aj extends com.google.android.play.core.assetpacks.internal.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f221a;
    final /* synthetic */ TaskCompletionSource b;
    final /* synthetic */ ax c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    aj(ax axVar, TaskCompletionSource taskCompletionSource, int i, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f221a = i;
        this.b = taskCompletionSource2;
        this.c = axVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    protected final void a() {
        try {
            ((com.google.android.play.core.assetpacks.internal.f) this.c.f.e()).i(this.c.c, ax.B(this.f221a), ax.A(), new at(this.c, this.b));
        } catch (RemoteException e) {
            ax.f225a.c(e, "notifySessionFailed", new Object[0]);
        }
    }
}
