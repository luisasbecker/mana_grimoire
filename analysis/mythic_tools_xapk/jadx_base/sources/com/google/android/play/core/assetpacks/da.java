package com.google.android.play.core.assetpacks;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f268a = new com.google.android.play.core.assetpacks.internal.o("ExtractorLooper");
    private final dt b;
    private final cp c;
    private final fh d;
    private final ej e;
    private final en f;
    private final ew g;
    private final fa h;
    private final dw i;
    private final AtomicBoolean j = new AtomicBoolean(false);
    private final com.google.android.play.core.assetpacks.internal.aq k;

    da(dt dtVar, com.google.android.play.core.assetpacks.internal.aq aqVar, cp cpVar, fh fhVar, ej ejVar, en enVar, ew ewVar, fa faVar, dw dwVar) {
        this.b = dtVar;
        this.k = aqVar;
        this.c = cpVar;
        this.d = fhVar;
        this.e = ejVar;
        this.f = enVar;
        this.g = ewVar;
        this.h = faVar;
        this.i = dwVar;
    }

    private final void b(int i, Exception exc) {
        try {
            this.b.m(i, 5);
            this.b.n(i);
        } catch (cz unused) {
            f268a.b("Error during error handling: %s", exc.getMessage());
        }
    }

    final void a() {
        dv dvVarA;
        com.google.android.play.core.assetpacks.internal.o oVar = f268a;
        oVar.a("Run extractor loop", new Object[0]);
        if (!this.j.compareAndSet(false, true)) {
            oVar.e("runLoop already looping; return", new Object[0]);
            return;
        }
        while (true) {
            try {
                dvVarA = this.i.a();
            } catch (cz e) {
                f268a.b("Error while getting next extraction task: %s", e.getMessage());
                if (e.f266a >= 0) {
                    ((z) this.k.a()).i(e.f266a);
                    b(e.f266a, e);
                }
                dvVarA = null;
            }
            if (dvVarA == null) {
                this.j.set(false);
                return;
            }
            try {
                if (dvVarA instanceof co) {
                    this.c.a((co) dvVarA);
                } else if (dvVarA instanceof fg) {
                    this.d.a((fg) dvVarA);
                } else if (dvVarA instanceof ei) {
                    this.e.a((ei) dvVarA);
                } else if (dvVarA instanceof el) {
                    this.f.b((el) dvVarA);
                } else if (dvVarA instanceof ev) {
                    this.g.a((ev) dvVarA);
                } else if (dvVarA instanceof ey) {
                    this.h.b((ey) dvVarA);
                } else {
                    f268a.b("Unknown task type: %s", dvVarA.getClass().getName());
                }
            } catch (Exception e2) {
                f268a.b("Error during extraction task: %s", e2.getMessage());
                ((z) this.k.a()).i(dvVarA.k);
                b(dvVarA.k, e2);
            }
        }
    }
}
