package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzoz implements zzbw {
    TYPE_UNKNOWN(0),
    TYPE_THIN(1),
    TYPE_THICK(2),
    TYPE_GMV(3);

    private final int zzf;

    zzoz(int i) {
        this.zzf = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzbw
    public final int zza() {
        return this.zzf;
    }
}
