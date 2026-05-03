package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ai extends com.google.android.play.core.assetpacks.internal.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f220a;
    final /* synthetic */ String b;
    final /* synthetic */ TaskCompletionSource c;
    final /* synthetic */ int d;
    final /* synthetic */ ax e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ai(ax axVar, TaskCompletionSource taskCompletionSource, int i, String str, TaskCompletionSource taskCompletionSource2, int i2) {
        super(taskCompletionSource);
        this.f220a = i;
        this.b = str;
        this.c = taskCompletionSource2;
        this.d = i2;
        this.e = axVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.p
    protected final void a() {
        try {
            ((com.google.android.play.core.assetpacks.internal.f) this.e.f.e()).h(this.e.c, ax.z(this.f220a, this.b), ax.A(), new as(this.e, this.c, this.f220a, this.b, this.d));
        } catch (RemoteException e) {
            ax.f225a.c(e, "notifyModuleCompleted", new Object[0]);
        }
    }
}
