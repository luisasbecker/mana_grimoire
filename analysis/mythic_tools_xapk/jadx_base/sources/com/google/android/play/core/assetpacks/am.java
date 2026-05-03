package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
class am extends com.google.android.play.core.assetpacks.internal.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f224a;
    final /* synthetic */ ax b;

    am(ax axVar, TaskCompletionSource taskCompletionSource) {
        this.b = axVar;
        this.f224a = taskCompletionSource;
    }

    @Override // com.google.android.play.core.assetpacks.internal.h
    public final void b(int i, Bundle bundle) {
        this.b.f.u(this.f224a);
        ax.f225a.d("onCancelDownload(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.assetpacks.internal.h
    public final void c(Bundle bundle) {
        this.b.f.u(this.f224a);
        ax.f225a.d("onCancelDownloads()", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.internal.h
    public void d(Bundle bundle) {
        this.b.f.u(this.f224a);
        int i = bundle.getInt("error_code");
        ax.f225a.b("onError(%d)", Integer.valueOf(i));
        this.f224a.trySetException(new AssetPackException(i));
    }

    @Override // com.google.android.play.core.assetpacks.internal.h
    public void e(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.b.f.u(this.f224a);
        ax.f225a.d("onGetChunkFileDescriptor", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.internal.h
    public final void f(int i, Bundle bundle) {
        this.b.f.u(this.f224a);
        ax.f225a.d("onGetSession(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.assetpacks.internal.h
    public void g(List list) {
        this.b.f.u(this.f224a);
        ax.f225a.d("onGetSessionStates", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.internal.h
    public void h(Bundle bundle, Bundle bundle2) {
        this.b.g.u(this.f224a);
        ax.f225a.d("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    @Override // com.google.android.play.core.assetpacks.internal.h
    public final void i(Bundle bundle, Bundle bundle2) {
        this.b.f.u(this.f224a);
        ax.f225a.d("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt("session_id")));
    }

    @Override // com.google.android.play.core.assetpacks.internal.h
    public final void j(Bundle bundle, Bundle bundle2) {
        this.b.f.u(this.f224a);
        ax.f225a.d("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt("session_id")));
    }

    @Override // com.google.android.play.core.assetpacks.internal.h
    public final void k(Bundle bundle, Bundle bundle2) {
        this.b.f.u(this.f224a);
        ax.f225a.d("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt("session_id")));
    }

    @Override // com.google.android.play.core.assetpacks.internal.h
    public final void l(Bundle bundle, Bundle bundle2) {
        this.b.f.u(this.f224a);
        ax.f225a.d("onRemoveModule()", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.internal.h
    public void m(Bundle bundle, Bundle bundle2) {
        this.b.f.u(this.f224a);
        ax.f225a.d("onRequestDownloadInfo()", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.internal.h
    public void n(int i, Bundle bundle) {
        this.b.f.u(this.f224a);
        ax.f225a.d("onStartDownload(%d)", Integer.valueOf(i));
    }
}
