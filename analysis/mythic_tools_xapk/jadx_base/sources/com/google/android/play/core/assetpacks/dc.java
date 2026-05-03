package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class dc extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eh f270a = new eh();
    private final File b;
    private final fd c;
    private long d;
    private long e;
    private FileOutputStream f;
    private fj g;

    dc(File file, fd fdVar) {
        this.b = file;
        this.c = fdVar;
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2;
        int i3;
        while (i2 > 0) {
            if (this.d == 0 && this.e == 0) {
                int iB = this.f270a.b(bArr, i, i2);
                if (iB == -1) {
                    return;
                }
                i += iB;
                i2 -= iB;
                fj fjVarC = this.f270a.c();
                this.g = fjVarC;
                if (fjVarC.d()) {
                    this.d = 0L;
                    this.c.l(this.g.f(), 0, this.g.f().length);
                    this.e = this.g.f().length;
                } else if (!this.g.h() || this.g.g()) {
                    byte[] bArrF = this.g.f();
                    this.c.l(bArrF, 0, bArrF.length);
                    this.d = this.g.b();
                } else {
                    this.c.j(this.g.f());
                    File file = new File(this.b, this.g.c());
                    file.getParentFile().mkdirs();
                    this.d = this.g.b();
                    this.f = new FileOutputStream(file);
                }
            }
            int i4 = i;
            int iMin = i2;
            if (this.g.g()) {
                i2 = iMin;
                bArr = bArr;
                i = i4;
            } else {
                long j = iMin;
                if (this.g.d()) {
                    bArr2 = bArr;
                    this.c.e(this.e, bArr2, i4, iMin);
                    i3 = iMin;
                    this.e += j;
                } else {
                    bArr2 = bArr;
                    i3 = iMin;
                    boolean zH = this.g.h();
                    long j2 = this.d;
                    if (zH) {
                        iMin = (int) Math.min(j, j2);
                        this.f.write(bArr2, i4, iMin);
                        long j3 = this.d - ((long) iMin);
                        this.d = j3;
                        if (j3 == 0) {
                            this.f.close();
                        }
                    } else {
                        iMin = (int) Math.min(j, j2);
                        this.c.e((((long) this.g.f().length) + this.g.b()) - this.d, bArr2, i4, iMin);
                        this.d -= (long) iMin;
                    }
                }
                i = i4 + iMin;
                i2 = i3 - iMin;
                bArr = bArr2;
            }
        }
    }
}
