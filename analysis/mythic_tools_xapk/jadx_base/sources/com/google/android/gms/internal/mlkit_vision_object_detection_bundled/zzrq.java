package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzrq implements zzbw {
    MODE_UNSPECIFIED(0),
    STREAM(1),
    SINGLE_IMAGE(2);

    private final int zze;

    zzrq(int i) {
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzbw
    public final int zza() {
        return this.zze;
    }
}
