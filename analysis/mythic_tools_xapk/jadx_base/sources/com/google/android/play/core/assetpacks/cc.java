package com.google.android.play.core.assetpacks;

import androidx.media3.muxer.MuxerUtil;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class cc {
    static int a(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    static int b(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    static long c(byte[] bArr, int i) {
        int i2 = i + 2;
        return ((long) ((a(bArr, i2) << 16) | a(bArr, i))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
    }
}
