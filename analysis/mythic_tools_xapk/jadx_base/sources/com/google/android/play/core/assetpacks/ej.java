package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ej {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f300a = new com.google.android.play.core.assetpacks.internal.o("MergeSliceTaskHandler");
    private final bm b;

    ej(bm bmVar) {
        this.b = bmVar;
    }

    private static void b(File file, File file2) {
        if (!file.isDirectory()) {
            if (file2.exists()) {
                throw new cz("File clashing with existing file from other slice: ".concat(file2.toString()));
            }
            if (!file.renameTo(file2)) {
                throw new cz("Unable to move file: ".concat(String.valueOf(String.valueOf(file))));
            }
            return;
        }
        file2.mkdirs();
        for (File file3 : file.listFiles()) {
            b(file3, new File(file2, file3.getName()));
        }
        if (!file.delete()) {
            throw new cz("Unable to delete directory: ".concat(String.valueOf(String.valueOf(file))));
        }
    }

    public final void a(ei eiVar) {
        File fileQ = this.b.q(eiVar.l, eiVar.f299a, eiVar.b, eiVar.c);
        if (!fileQ.exists()) {
            throw new cz(String.format("Cannot find verified files for slice %s.", eiVar.c), eiVar.k);
        }
        File fileJ = this.b.j(eiVar.l, eiVar.f299a, eiVar.b);
        if (!fileJ.exists()) {
            fileJ.mkdirs();
        }
        b(fileQ, fileJ);
        try {
            this.b.A(eiVar.l, eiVar.f299a, eiVar.b, this.b.b(eiVar.l, eiVar.f299a, eiVar.b) + 1);
        } catch (IOException e) {
            f300a.b("Writing merge checkpoint failed with %s.", e.getMessage());
            throw new cz("Writing merge checkpoint failed.", e, eiVar.k);
        }
    }
}
