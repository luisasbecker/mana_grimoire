package com.google.android.play.core.assetpacks;

import androidx.work.WorkManager;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class y implements com.google.android.play.core.assetpacks.internal.as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.core.assetpacks.internal.aw f360a;

    public y(com.google.android.play.core.assetpacks.internal.aw awVar) {
        this.f360a = awVar;
    }

    @Override // com.google.android.play.core.assetpacks.internal.aw, com.google.android.play.core.assetpacks.internal.av
    public final /* bridge */ /* synthetic */ Object a() {
        WorkManager workManager = WorkManager.getInstance(((u) this.f360a).b());
        com.google.android.play.core.assetpacks.internal.ar.a(workManager);
        return workManager;
    }
}
