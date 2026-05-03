package com.google.android.play.core.assetpacks;

import android.content.ComponentName;
import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class s implements com.google.android.play.core.assetpacks.internal.as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.core.assetpacks.internal.aw f355a;
    private final com.google.android.play.core.assetpacks.internal.aw b;

    public s(com.google.android.play.core.assetpacks.internal.aw awVar, com.google.android.play.core.assetpacks.internal.aw awVar2) {
        this.f355a = awVar;
        this.b = awVar2;
    }

    @Override // com.google.android.play.core.assetpacks.internal.aw, com.google.android.play.core.assetpacks.internal.av
    public final /* bridge */ /* synthetic */ Object a() {
        Object objA = this.f355a.a();
        Context contextB = ((u) this.b).b();
        l lVar = (l) objA;
        com.google.android.play.core.assetpacks.internal.af.a(contextB.getPackageManager(), new ComponentName(contextB.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"), 4);
        com.google.android.play.core.assetpacks.internal.af.a(contextB.getPackageManager(), new ComponentName(contextB.getPackageName(), "com.google.android.play.core.assetpacks.ExtractionForegroundService"), 4);
        com.google.android.play.core.assetpacks.internal.ar.a(lVar);
        return lVar;
    }
}
