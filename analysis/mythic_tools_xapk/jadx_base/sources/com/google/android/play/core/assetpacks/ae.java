package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ae extends com.google.android.play.core.assetpacks.internal.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f216a;
    final /* synthetic */ TaskCompletionSource b;
    final /* synthetic */ ax c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ae(ax axVar, TaskCompletionSource taskCompletionSource, List list, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f216a = list;
        this.b = taskCompletionSource2;
        this.c = axVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    protected final void a() {
        try {
            ((com.google.android.play.core.assetpacks.internal.f) this.c.f.e()).c(this.c.c, ax.v(this.f216a), ax.A(), new an(this.c, this.b));
        } catch (RemoteException e) {
            ax.f225a.c(e, "cancelDownloads(%s)", this.f216a);
        }
    }
}
