package com.google.android.play.core.assetpacks;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class bo extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f237a;
    private long b;

    bo(InputStream inputStream, long j) {
        this.f237a = inputStream;
        this.b = j;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        this.f237a.close();
        this.b = 0L;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        long j = this.b;
        if (j <= 0) {
            return -1;
        }
        this.b = j - 1;
        return this.f237a.read();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.b;
        if (j <= 0) {
            return -1;
        }
        int i3 = this.f237a.read(bArr, i, (int) Math.min(i2, j));
        if (i3 != -1) {
            this.b -= (long) i3;
        }
        return i3;
    }
}
