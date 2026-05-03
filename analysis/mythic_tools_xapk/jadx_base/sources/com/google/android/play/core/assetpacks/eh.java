package com.google.android.play.core.assetpacks;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f298a = new byte[4096];
    private int b;
    private long c;
    private long d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private String i;

    public eh() {
        d();
    }

    private final int e(int i, byte[] bArr, int i2, int i3) {
        int i4 = this.b;
        if (i4 >= i) {
            return 0;
        }
        int iMin = Math.min(i3, i - i4);
        System.arraycopy(bArr, i2, this.f298a, this.b, iMin);
        int i5 = this.b + iMin;
        this.b = i5;
        if (i5 < i) {
            return -1;
        }
        return iMin;
    }

    public final int a() {
        return this.f;
    }

    public final int b(byte[] bArr, int i, int i2) {
        int iE = e(30, bArr, i, i2);
        if (iE == -1) {
            return -1;
        }
        if (this.c == -1) {
            long jC = cc.c(this.f298a, 0);
            this.c = jC;
            if (jC == 67324752) {
                this.h = false;
                this.d = cc.c(this.f298a, 18);
                this.g = cc.a(this.f298a, 8);
                this.e = cc.a(this.f298a, 26);
                int iA = this.e + 30 + cc.a(this.f298a, 28);
                this.f = iA;
                int length = this.f298a.length;
                if (length < iA) {
                    do {
                        length += length;
                    } while (length < iA);
                    this.f298a = Arrays.copyOf(this.f298a, length);
                }
            } else {
                this.h = true;
            }
        }
        int iE2 = e(this.f, bArr, i + iE, i2 - iE);
        if (iE2 == -1) {
            return -1;
        }
        int i3 = iE + iE2;
        if (!this.h && this.i == null) {
            this.i = new String(this.f298a, 30, this.e);
        }
        return i3;
    }

    public final fj c() {
        int i = this.b;
        int i2 = this.f;
        String str = this.i;
        long j = this.d;
        int i3 = this.g;
        if (i < i2) {
            return new bv(str, j, i3, true, this.h, Arrays.copyOf(this.f298a, i));
        }
        bv bvVar = new bv(str, j, i3, false, this.h, Arrays.copyOf(this.f298a, i2));
        d();
        return bvVar;
    }

    public final void d() {
        this.b = 0;
        this.e = -1;
        this.c = -1L;
        this.h = false;
        this.f = 30;
        this.d = -1L;
        this.g = -1;
        this.i = null;
    }
}
