package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class eg extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Enumeration f297a;
    private InputStream b;

    public eg(Enumeration enumeration) throws IOException {
        this.f297a = enumeration;
        a();
    }

    final void a() throws IOException {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.close();
        }
        if (this.f297a.hasMoreElements()) {
            this.b = new FileInputStream((File) this.f297a.nextElement());
        } else {
            this.b = null;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.close();
            this.b = null;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        while (true) {
            InputStream inputStream = this.b;
            if (inputStream == null) {
                return -1;
            }
            int i = inputStream.read();
            if (i != -1) {
                return i;
            }
            a();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.b == null) {
            return -1;
        }
        bArr.getClass();
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        do {
            int i3 = this.b.read(bArr, i, i2);
            if (i3 > 0) {
                return i3;
            }
            a();
        } while (this.b != null);
        return -1;
    }
}
