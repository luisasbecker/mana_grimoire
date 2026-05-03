package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class af extends com.google.android.play.core.assetpacks.internal.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f217a;
    final /* synthetic */ TaskCompletionSource b;
    final /* synthetic */ ax c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    af(ax axVar, TaskCompletionSource taskCompletionSource, Map map, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f217a = map;
        this.b = taskCompletionSource2;
        this.c = axVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    protected final void a() {
        try {
            ((com.google.android.play.core.assetpacks.internal.f) this.c.f.e()).e(this.c.c, ax.n(this.f217a), new ap(this.c, this.b));
        } catch (RemoteException e) {
            ax.f225a.c(e, "syncPacks", new Object[0]);
            this.b.trySetException(new RuntimeException(e));
        }
    }
}
