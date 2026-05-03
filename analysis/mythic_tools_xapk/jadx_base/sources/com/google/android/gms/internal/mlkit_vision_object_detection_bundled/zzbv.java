package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbv extends OutputStream {
    private long zza = 0;

    zzbv() {
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.zza++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.zza += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        int length;
        int i3;
        if (i < 0 || i > (length = bArr.length) || i2 < 0 || (i3 = i + i2) > length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.zza += (long) i2;
    }

    final long zza() {
        return this.zza;
    }
}
