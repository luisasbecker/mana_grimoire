package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f322a = new com.google.android.play.core.assetpacks.internal.o("VerifySliceTaskHandler");
    private final bm b;

    fh(bm bmVar) {
        this.b = bmVar;
    }

    private final void b(fg fgVar, File file) {
        try {
            File fileO = this.b.o(fgVar.l, fgVar.f321a, fgVar.b, fgVar.c);
            if (!fileO.exists()) {
                throw new cz(String.format("Cannot find metadata files for slice %s.", fgVar.c), fgVar.k);
            }
            try {
                if (!ef.a(ff.a(file, fileO)).equals(fgVar.d)) {
                    throw new cz(String.format("Verification failed for slice %s.", fgVar.c), fgVar.k);
                }
                f322a.d("Verification of slice %s of pack %s successful.", fgVar.c, fgVar.l);
            } catch (IOException e) {
                throw new cz(String.format("Could not digest file during verification for slice %s.", fgVar.c), e, fgVar.k);
            } catch (NoSuchAlgorithmException e2) {
                throw new cz("SHA256 algorithm not supported.", e2, fgVar.k);
            }
        } catch (IOException e3) {
            throw new cz(String.format("Could not reconstruct slice archive during verification for slice %s.", fgVar.c), e3, fgVar.k);
        }
    }

    public final void a(fg fgVar) {
        File fileP = this.b.p(fgVar.l, fgVar.f321a, fgVar.b, fgVar.c);
        if (!fileP.exists()) {
            throw new cz(String.format("Cannot find unverified files for slice %s.", fgVar.c), fgVar.k);
        }
        b(fgVar, fileP);
        File fileQ = this.b.q(fgVar.l, fgVar.f321a, fgVar.b, fgVar.c);
        if (!fileQ.exists()) {
            fileQ.mkdirs();
        }
        if (!fileP.renameTo(fileQ)) {
            throw new cz(String.format("Failed to move slice %s after verification.", fgVar.c), fgVar.k);
        }
    }
}
