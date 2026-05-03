package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ad extends com.google.android.play.core.assetpacks.internal.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f215a;
    final /* synthetic */ Map b;
    final /* synthetic */ TaskCompletionSource c;
    final /* synthetic */ ax d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ad(ax axVar, TaskCompletionSource taskCompletionSource, List list, Map map, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f215a = list;
        this.b = map;
        this.c = taskCompletionSource2;
        this.d = axVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    protected final void a() {
        ArrayList arrayListV = ax.v(this.f215a);
        try {
            com.google.android.play.core.assetpacks.internal.f fVar = (com.google.android.play.core.assetpacks.internal.f) this.d.f.e();
            String str = this.d.c;
            Bundle bundleN = ax.n(this.b);
            ax axVar = this.d;
            fVar.l(str, arrayListV, bundleN, new aw(axVar, this.c, axVar.d, axVar.e));
        } catch (RemoteException e) {
            ax.f225a.c(e, "startDownload(%s)", this.f215a);
            this.c.trySetException(new RuntimeException(e));
        }
    }
}
