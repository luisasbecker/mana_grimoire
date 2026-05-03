package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzsr implements zzbw {
    UNKNOWN(0),
    CANONICAL(1),
    TFLITE(2),
    TFLITE_SUPPORT(3);

    private final int zzf;

    zzsr(int i) {
        this.zzf = i;
    }

    public static zzsr zzb(int i) {
        for (zzsr zzsrVar : values()) {
            if (zzsrVar.zzf == i) {
                return zzsrVar;
            }
        }
        return UNKNOWN;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzbw
    public final int zza() {
        return this.zzf;
    }
}
