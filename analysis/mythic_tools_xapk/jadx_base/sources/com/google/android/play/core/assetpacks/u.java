package com.google.android.play.core.assetpacks;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class u implements com.google.android.play.core.assetpacks.internal.as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f357a;

    public u(p pVar) {
        this.f357a = pVar;
    }

    public static Context c(p pVar) {
        Context contextA = pVar.a();
        com.google.android.play.core.assetpacks.internal.ar.a(contextA);
        return contextA;
    }

    @Override // com.google.android.play.core.assetpacks.internal.aw, com.google.android.play.core.assetpacks.internal.av
    public final /* synthetic */ Object a() {
        return c(this.f357a);
    }

    public final Context b() {
        return c(this.f357a);
    }
}
