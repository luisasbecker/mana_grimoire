package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f313a = new com.google.android.play.core.assetpacks.internal.o("PatchSliceTaskHandler");
    private final bm b;
    private final com.google.android.play.core.assetpacks.internal.aq c;

    ew(bm bmVar, com.google.android.play.core.assetpacks.internal.aq aqVar) {
        this.b = bmVar;
        this.c = aqVar;
    }

    public final void a(ev evVar) {
        bm bmVar = this.b;
        String str = evVar.l;
        int i = evVar.f312a;
        long j = evVar.b;
        File fileH = bmVar.h(str, i, j);
        File file = new File(bmVar.i(str, i, j), evVar.f);
        try {
            InputStream inputStream = evVar.h;
            InputStream gZIPInputStream = evVar.e != 2 ? inputStream : new GZIPInputStream(inputStream, 8192);
            try {
                bp bpVar = new bp(fileH, file);
                File fileP = this.b.p(evVar.l, evVar.c, evVar.d, evVar.f);
                if (!fileP.exists()) {
                    fileP.mkdirs();
                }
                fd fdVar = new fd(this.b, evVar.l, evVar.c, evVar.d, evVar.f);
                com.google.android.play.core.assetpacks.internal.am.a(bpVar, gZIPInputStream, new dc(fileP, fdVar), evVar.g);
                fdVar.i(0);
                gZIPInputStream.close();
                f313a.d("Patching and extraction finished for slice %s of pack %s.", evVar.f, evVar.l);
                ((z) this.c.a()).g(evVar.k, evVar.l, evVar.f, 0);
                try {
                    evVar.h.close();
                } catch (IOException unused) {
                    f313a.e("Could not close file for slice %s of pack %s.", evVar.f, evVar.l);
                }
            } finally {
            }
        } catch (IOException e) {
            f313a.b("IOException during patching %s.", e.getMessage());
            throw new cz(String.format("Error patching slice %s of pack %s.", evVar.f, evVar.l), e, evVar.k);
        }
    }
}
