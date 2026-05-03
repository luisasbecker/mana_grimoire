package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class en {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bm f304a;
    private final dt b;
    private final dd c;
    private final er d;
    private final com.google.android.play.core.assetpacks.internal.aq e;
    private final com.google.android.play.core.assetpacks.internal.aq f;

    en(bm bmVar, com.google.android.play.core.assetpacks.internal.aq aqVar, dt dtVar, com.google.android.play.core.assetpacks.internal.aq aqVar2, dd ddVar, er erVar) {
        this.f304a = bmVar;
        this.e = aqVar;
        this.b = dtVar;
        this.f = aqVar2;
        this.c = ddVar;
        this.d = erVar;
    }

    public final void b(final el elVar) {
        bm bmVar = this.f304a;
        String str = elVar.l;
        int i = elVar.f302a;
        long j = elVar.b;
        File fileJ = bmVar.j(str, i, j);
        File fileL = bmVar.l(str, i, j);
        if (!fileJ.exists() || !fileL.exists()) {
            throw new cz(String.format("Cannot find pack files to move for pack %s.", elVar.l), elVar.k);
        }
        File fileH = this.f304a.h(elVar.l, elVar.f302a, elVar.b);
        fileH.mkdirs();
        if (!fileJ.renameTo(fileH)) {
            throw new cz("Cannot move merged pack files to final location.", elVar.k);
        }
        new File(this.f304a.h(elVar.l, elVar.f302a, elVar.b), "merge.tmp").delete();
        File fileI = this.f304a.i(elVar.l, elVar.f302a, elVar.b);
        fileI.mkdirs();
        if (!fileL.renameTo(fileI)) {
            throw new cz("Cannot move metadata files to final location.", elVar.k);
        }
        try {
            this.d.b(elVar.l, elVar.f302a, elVar.b, elVar.c);
            ((Executor) this.f.a()).execute(new Runnable() { // from class: com.google.android.play.core.assetpacks.em
                @Override // java.lang.Runnable
                public final void run() {
                    en enVar = this.f303a;
                    el elVar2 = elVar;
                    enVar.f304a.B(elVar2.l, elVar2.f302a, elVar2.b);
                }
            });
            this.b.k(elVar.l, elVar.f302a, elVar.b);
            this.c.c(elVar.l);
            ((z) this.e.a()).h(elVar.k, elVar.l);
        } catch (IOException e) {
            throw new cz(String.format("Could not write asset pack version tag for pack %s: %s", elVar.l, e.getMessage()), elVar.k);
        }
    }
}
