package com.google.android.play.core.assetpacks;

import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class fa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bm f317a;
    private final dt b;
    private final dd c;
    private final com.google.android.play.core.assetpacks.internal.aq d;
    private final com.google.android.play.core.assetpacks.internal.aq e;

    fa(bm bmVar, com.google.android.play.core.assetpacks.internal.aq aqVar, dt dtVar, com.google.android.play.core.assetpacks.internal.aq aqVar2, dd ddVar) {
        this.f317a = bmVar;
        this.d = aqVar;
        this.b = dtVar;
        this.e = aqVar2;
        this.c = ddVar;
    }

    public final void b(final ey eyVar) {
        File fileH = this.f317a.h(eyVar.l, eyVar.f315a, eyVar.c);
        if (!fileH.exists()) {
            throw new cz(String.format("Cannot find pack files to promote for pack %s at %s", eyVar.l, fileH.getAbsolutePath()), eyVar.k);
        }
        File fileH2 = this.f317a.h(eyVar.l, eyVar.b, eyVar.c);
        fileH2.mkdirs();
        if (!fileH.renameTo(fileH2)) {
            throw new cz(String.format("Cannot promote pack %s from %s to %s", eyVar.l, fileH.getAbsolutePath(), fileH2.getAbsolutePath()), eyVar.k);
        }
        ((Executor) this.e.a()).execute(new Runnable() { // from class: com.google.android.play.core.assetpacks.ez
            @Override // java.lang.Runnable
            public final void run() {
                fa faVar = this.f316a;
                ey eyVar2 = eyVar;
                faVar.f317a.B(eyVar2.l, eyVar2.b, eyVar2.c);
            }
        });
        this.b.k(eyVar.l, eyVar.b, eyVar.c);
        this.c.c(eyVar.l);
        ((z) this.d.a()).h(eyVar.k, eyVar.l);
    }
}
