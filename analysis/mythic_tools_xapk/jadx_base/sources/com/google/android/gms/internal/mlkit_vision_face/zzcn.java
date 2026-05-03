package com.google.android.gms.internal.mlkit_vision_face;

import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.1.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcn extends zzco {
    public static int zza(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }
}
