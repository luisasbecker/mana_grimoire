package com.appsflyer.internal;

import androidx.media3.muxer.MuxerUtil;

/* JADX INFO: loaded from: classes3.dex */
public final class AFk1vSDK {
    static long[] getMediationNetwork(int i, int i2) {
        long[] jArr = new long[4];
        jArr[0] = (((long) i2) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | ((((long) i) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) << 32);
        for (int i3 = 1; i3 < 4; i3++) {
            long j = jArr[i3 - 1];
            jArr[i3] = ((j ^ (j >> 30)) * 1812433253) + ((long) i3);
        }
        return jArr;
    }
}
