package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ag extends com.google.android.play.core.assetpacks.internal.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f218a;
    final /* synthetic */ Map b;
    final /* synthetic */ TaskCompletionSource c;
    final /* synthetic */ bf d;
    final /* synthetic */ ax e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ag(ax axVar, TaskCompletionSource taskCompletionSource, List list, Map map, TaskCompletionSource taskCompletionSource2, bf bfVar) {
        super(taskCompletionSource);
        this.f218a = list;
        this.b = map;
        this.c = taskCompletionSource2;
        this.d = bfVar;
        this.e = axVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    protected final void a() {
        ArrayList arrayListV = ax.v(this.f218a);
        try {
            com.google.android.play.core.assetpacks.internal.f fVar = (com.google.android.play.core.assetpacks.internal.f) this.e.f.e();
            String str = this.e.c;
            Bundle bundleN = ax.n(this.b);
            ax axVar = this.e;
            fVar.k(str, arrayListV, bundleN, new av(axVar, this.c, axVar.d, axVar.e, this.d));
        } catch (RemoteException e) {
            ax.f225a.c(e, "getPackStates(%s)", this.f218a);
            this.c.trySetException(new RuntimeException(e));
        }
    }
}
