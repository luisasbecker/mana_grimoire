package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ac extends com.google.android.play.core.assetpacks.internal.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f214a;
    final /* synthetic */ TaskCompletionSource b;
    final /* synthetic */ ax c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ac(ax axVar, TaskCompletionSource taskCompletionSource, String str, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f214a = str;
        this.b = taskCompletionSource2;
        this.c = axVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    protected final void a() {
        try {
            ((com.google.android.play.core.assetpacks.internal.f) this.c.f.e()).j(this.c.c, ax.z(0, this.f214a), ax.A(), new au(this.c, this.b));
        } catch (RemoteException e) {
            ax.f225a.c(e, "removePack(%s)", this.f214a);
        }
    }
}
