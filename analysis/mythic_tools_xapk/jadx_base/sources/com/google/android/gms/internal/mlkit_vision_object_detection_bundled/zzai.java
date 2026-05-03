package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzai {
    static int zza(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * (-862048943)), 15)) * 461845907);
    }

    static int zzb(@CheckForNull Object obj) {
        return zza(obj == null ? 0 : obj.hashCode());
    }
}
