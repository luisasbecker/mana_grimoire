package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class al extends com.google.android.play.core.assetpacks.internal.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f223a;
    final /* synthetic */ ax b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    al(ax axVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f223a = taskCompletionSource2;
        this.b = axVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    protected final void a() {
        try {
            ((com.google.android.play.core.assetpacks.internal.f) this.b.g.e()).f(this.b.c, ax.A(), new aq(this.b, this.f223a));
        } catch (RemoteException e) {
            ax.f225a.c(e, "keepAlive", new Object[0]);
        }
    }
}
