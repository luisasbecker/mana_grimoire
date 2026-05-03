package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class aw extends am {
    private final dd c;
    private final er d;

    aw(ax axVar, TaskCompletionSource taskCompletionSource, dd ddVar, er erVar) {
        super(axVar, taskCompletionSource);
        this.c = ddVar;
        this.d = erVar;
    }

    @Override // com.google.android.play.core.assetpacks.am, com.google.android.play.core.assetpacks.internal.h
    public final void n(int i, Bundle bundle) {
        super.n(i, bundle);
        this.f224a.trySetResult(AssetPackStates.a(bundle, this.c, this.d));
    }
}
