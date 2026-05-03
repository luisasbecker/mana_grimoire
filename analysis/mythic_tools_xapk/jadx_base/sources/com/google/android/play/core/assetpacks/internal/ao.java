package com.google.android.play.core.assetpacks.internal;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class ao extends an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final an f332a;
    private final long b;
    private final long c;

    public ao(an anVar, long j, long j2) {
        this.f332a = anVar;
        long jD = d(j);
        this.b = jD;
        this.c = d(jD + j2);
    }

    private final long d(long j) {
        if (j < 0) {
            return 0L;
        }
        return j > this.f332a.a() ? this.f332a.a() : j;
    }

    @Override // com.google.android.play.core.assetpacks.internal.an
    public final long a() {
        return this.c - this.b;
    }

    @Override // com.google.android.play.core.assetpacks.internal.an
    protected final InputStream b(long j, long j2) throws IOException {
        long jD = d(this.b);
        return this.f332a.b(jD, d(j2 + jD) - jD);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }
}
