package com.google.android.play.core.assetpacks;

import androidx.media3.muxer.MuxerUtil;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class ch extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eh f250a;
    private byte[] b;
    private long c;
    private boolean d;
    private boolean e;

    ch(InputStream inputStream) {
        super(inputStream);
        this.f250a = new eh();
        this.b = new byte[4096];
        this.d = false;
        this.e = false;
    }

    private final int e(byte[] bArr, int i, int i2) throws IOException {
        return Math.max(0, super.read(bArr, i, i2));
    }

    private final boolean f(int i) throws IOException {
        int iE = e(this.b, 0, i);
        if (iE != i) {
            int i2 = i - iE;
            if (e(this.b, iE, i2) != i2) {
                this.f250a.b(this.b, 0, iE);
                return false;
            }
        }
        this.f250a.b(this.b, 0, i);
        return true;
    }

    final long a() {
        return this.c;
    }

    final fj b() throws IOException {
        byte[] bArr;
        if (this.c > 0) {
            do {
                bArr = this.b;
            } while (read(bArr, 0, bArr.length) != -1);
        }
        if (this.d || this.e) {
            return new bv(null, -1L, -1, false, false, null);
        }
        if (!f(30)) {
            this.d = true;
            return this.f250a.c();
        }
        fj fjVarC = this.f250a.c();
        if (fjVarC.d()) {
            this.e = true;
            return fjVarC;
        }
        if (fjVarC.b() == MuxerUtil.UNSIGNED_INT_MAX_VALUE) {
            throw new cz("Files bigger than 4GiB are not supported.");
        }
        int iA = this.f250a.a() - 30;
        int length = this.b.length;
        long j = iA;
        if (j > length) {
            do {
                length += length;
            } while (length < j);
            this.b = Arrays.copyOf(this.b, length);
        }
        if (!f(iA)) {
            this.d = true;
            return this.f250a.c();
        }
        fj fjVarC2 = this.f250a.c();
        this.c = fjVarC2.b();
        return fjVarC2;
    }

    final boolean c() {
        return this.e;
    }

    final boolean d() {
        return this.d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.c;
        if (j <= 0 || this.d) {
            return -1;
        }
        int iE = e(bArr, i, (int) Math.min(j, i2));
        this.c -= (long) iE;
        if (iE != 0) {
            return iE;
        }
        this.d = true;
        return 0;
    }
}
