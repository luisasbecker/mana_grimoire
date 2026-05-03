package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class av extends am {
    private final dd c;
    private final er d;
    private final bf e;

    av(ax axVar, TaskCompletionSource taskCompletionSource, dd ddVar, er erVar, bf bfVar) {
        super(axVar, taskCompletionSource);
        this.c = ddVar;
        this.d = erVar;
        this.e = bfVar;
    }

    @Override // com.google.android.play.core.assetpacks.am, com.google.android.play.core.assetpacks.internal.h
    public final void m(Bundle bundle, Bundle bundle2) {
        super.m(bundle, bundle2);
        this.f224a.trySetResult(AssetPackStates.b(bundle, this.c, this.d, this.e));
    }
}
