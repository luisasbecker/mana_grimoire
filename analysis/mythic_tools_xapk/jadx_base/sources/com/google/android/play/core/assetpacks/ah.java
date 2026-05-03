package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ah extends com.google.android.play.core.assetpacks.internal.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f219a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;
    final /* synthetic */ TaskCompletionSource e;
    final /* synthetic */ ax f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ah(ax axVar, TaskCompletionSource taskCompletionSource, int i, String str, String str2, int i2, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f219a = i;
        this.b = str;
        this.c = str2;
        this.d = i2;
        this.e = taskCompletionSource2;
        this.f = axVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    protected final void a() {
        try {
            ((com.google.android.play.core.assetpacks.internal.f) this.f.f.e()).g(this.f.c, ax.k(this.f219a, this.b, this.c, this.d), ax.A(), new ar(this.f, this.e));
        } catch (RemoteException e) {
            ax.f225a.c(e, "notifyChunkTransferred", new Object[0]);
        }
    }
}
