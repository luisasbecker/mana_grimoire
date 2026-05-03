package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class cp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f256a = new com.google.android.play.core.assetpacks.internal.o("ExtractChunkTaskHandler");
    private final byte[] b = new byte[8192];
    private final bm c;
    private final dd d;
    private final er e;
    private final com.google.android.play.core.assetpacks.internal.aq f;
    private final com.google.android.play.core.assetpacks.internal.aq g;

    cp(bm bmVar, com.google.android.play.core.assetpacks.internal.aq aqVar, com.google.android.play.core.assetpacks.internal.aq aqVar2, dd ddVar, er erVar) {
        this.c = bmVar;
        this.f = aqVar;
        this.g = aqVar2;
        this.d = ddVar;
        this.e = erVar;
    }

    private final File b(co coVar) {
        File fileP = this.c.p(coVar.l, coVar.f255a, coVar.b, coVar.d);
        if (!fileP.exists()) {
            fileP.mkdirs();
        }
        return fileP;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(co coVar) {
        InputStream sequenceInputStream;
        fj fjVarB;
        File fileC;
        long length;
        int iMin;
        int iMax;
        bm bmVar = this.c;
        String str = coVar.l;
        int i = coVar.f255a;
        long j = coVar.b;
        String str2 = coVar.d;
        fd fdVar = new fd(bmVar, str, i, j, str2);
        File fileO = bmVar.o(str, i, j, str2);
        if (!fileO.exists()) {
            fileO.mkdirs();
        }
        try {
            InputStream inputStream = coVar.j;
            InputStream gZIPInputStream = coVar.e != 1 ? inputStream : new GZIPInputStream(inputStream, 8192);
            try {
                if (coVar.f > 0) {
                    fc fcVarB = fdVar.b();
                    int iB = fcVarB.b();
                    int i2 = coVar.f;
                    if (iB != i2 - 1) {
                        throw new cz(String.format("Trying to resume with chunk number %s when previously processed chunk was number %s.", Integer.valueOf(i2), Integer.valueOf(fcVarB.b())), coVar.k);
                    }
                    int iA = fcVarB.a();
                    sequenceInputStream = null;
                    if (iA == 1) {
                        f256a.a("Resuming zip entry from last chunk during file %s.", fcVarB.e());
                        File file = new File(fcVarB.e());
                        if (!file.exists()) {
                            throw new cz("Partial file specified in checkpoint does not exist. Corrupt directory.", coVar.k);
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                        randomAccessFile.seek(fcVarB.c());
                        long jD = fcVarB.d();
                        do {
                            iMin = (int) Math.min(jD, 8192L);
                            iMax = Math.max(gZIPInputStream.read(this.b, 0, iMin), 0);
                            if (iMax > 0) {
                                randomAccessFile.write(this.b, 0, iMax);
                            }
                            jD -= (long) iMax;
                            if (jD <= 0) {
                                break;
                            }
                        } while (iMax > 0);
                        long length2 = randomAccessFile.length();
                        randomAccessFile.close();
                        if (iMax != iMin) {
                            f256a.a("Chunk has ended while resuming the previous chunks file content.", new Object[0]);
                            fdVar.g(file.getCanonicalPath(), length2, jD, coVar.f);
                        } else {
                            sequenceInputStream = gZIPInputStream;
                        }
                    } else if (iA == 2) {
                        f256a.a("Resuming zip entry from last chunk during local file header.", new Object[0]);
                        File fileM = this.c.m(coVar.l, coVar.f255a, coVar.b, coVar.d);
                        if (!fileM.exists()) {
                            throw new cz("Checkpoint extension file not found.", coVar.k);
                        }
                        sequenceInputStream = new SequenceInputStream(new FileInputStream(fileM), gZIPInputStream);
                    } else {
                        if (iA != 3) {
                            throw new cz(String.format("Slice checkpoint file corrupt. Unexpected FileExtractionStatus %s.", Integer.valueOf(fcVarB.a())), coVar.k);
                        }
                        f256a.a("Resuming central directory from last chunk.", new Object[0]);
                        fdVar.d(gZIPInputStream, fcVarB.c());
                        if (!coVar.a()) {
                            throw new cz("Chunk has ended twice during central directory. This should not be possible with chunk sizes of 50MB.", coVar.k);
                        }
                    }
                }
                if (sequenceInputStream != null) {
                    ch chVar = new ch(sequenceInputStream);
                    File fileB = b(coVar);
                    do {
                        fjVarB = chVar.b();
                        if (!fjVarB.e() && !chVar.c()) {
                            if (!fjVarB.h() || fjVarB.g()) {
                                fdVar.k(fjVarB.f(), chVar);
                            } else {
                                fdVar.j(fjVarB.f());
                                File file2 = new File(fileB, fjVarB.c());
                                file2.getParentFile().mkdirs();
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                int i3 = chVar.read(this.b, 0, 8192);
                                while (i3 > 0) {
                                    fileOutputStream.write(this.b, 0, i3);
                                    i3 = chVar.read(this.b, 0, 8192);
                                }
                                fileOutputStream.close();
                            }
                        }
                        if (chVar.d()) {
                            break;
                        }
                    } while (!chVar.c());
                    if (chVar.c()) {
                        f256a.a("Writing central directory metadata.", new Object[0]);
                        fdVar.k(fjVarB.f(), sequenceInputStream);
                    }
                    if (!coVar.a()) {
                        if (fjVarB.e()) {
                            f256a.a("Writing slice checkpoint for partial local file header.", new Object[0]);
                            fdVar.h(fjVarB.f(), coVar.f);
                        } else if (chVar.c()) {
                            f256a.a("Writing slice checkpoint for central directory.", new Object[0]);
                            fdVar.f(coVar.f);
                        } else {
                            if (fjVarB.a() == 0) {
                                f256a.a("Writing slice checkpoint for partial file.", new Object[0]);
                                fileC = new File(b(coVar), fjVarB.c());
                                length = fjVarB.b() - chVar.a();
                                if (fileC.length() != length) {
                                    throw new cz("Partial file is of unexpected size.");
                                }
                            } else {
                                f256a.a("Writing slice checkpoint for partial unextractable file.", new Object[0]);
                                fileC = fdVar.c();
                                length = fileC.length();
                            }
                            fdVar.g(fileC.getCanonicalPath(), length, chVar.a(), coVar.f);
                        }
                    }
                }
                gZIPInputStream.close();
                if (coVar.a()) {
                    try {
                        fdVar.i(coVar.f);
                    } catch (IOException e) {
                        f256a.b("Writing extraction finished checkpoint failed with %s.", e.getMessage());
                        throw new cz("Writing extraction finished checkpoint failed.", e, coVar.k);
                    }
                }
                f256a.d("Extraction finished for chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(coVar.f), coVar.d, coVar.l, Integer.valueOf(coVar.k));
                ((z) this.f.a()).g(coVar.k, coVar.l, coVar.d, coVar.f);
                try {
                    coVar.j.close();
                } catch (IOException unused) {
                    f256a.e("Could not close file for chunk %s of slice %s of pack %s.", Integer.valueOf(coVar.f), coVar.d, coVar.l);
                }
                if (coVar.i == 3) {
                    bh bhVar = (bh) this.g.a();
                    String str3 = coVar.l;
                    long j2 = coVar.h;
                    bhVar.e(AssetPackState.a(str3, 3, 0, j2, j2, this.d.b(str3, coVar), 1, coVar.c, this.e.a(coVar.l)));
                }
            } finally {
            }
        } catch (IOException e2) {
            f256a.b("IOException during extraction %s.", e2.getMessage());
            throw new cz(String.format("Error extracting chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(coVar.f), coVar.d, coVar.l, Integer.valueOf(coVar.k)), e2, coVar.k);
        }
    }
}
