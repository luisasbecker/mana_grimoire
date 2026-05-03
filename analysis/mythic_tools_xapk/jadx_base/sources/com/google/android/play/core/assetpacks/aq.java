package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class aq extends am {
    final /* synthetic */ ax c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    aq(ax axVar, TaskCompletionSource taskCompletionSource) {
        super(axVar, taskCompletionSource);
        this.c = axVar;
    }

    @Override // com.google.android.play.core.assetpacks.am, com.google.android.play.core.assetpacks.internal.h
    public final void d(Bundle bundle) {
        this.c.g.u(this.f224a);
        int i = bundle.getInt("error_code");
        ax.f225a.b("onError(%d)", Integer.valueOf(i));
        this.f224a.trySetException(new AssetPackException(i));
    }

    @Override // com.google.android.play.core.assetpacks.am, com.google.android.play.core.assetpacks.internal.h
    public final void h(Bundle bundle, Bundle bundle2) {
        super.h(bundle, bundle2);
        if (!this.c.h.compareAndSet(true, false)) {
            ax.f225a.e("Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.c.f();
        }
    }
}
