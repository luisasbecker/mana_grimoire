package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzpm implements zzbw {
    CATEGORY_UNKNOWN(0),
    CATEGORY_HOME_GOOD(1),
    CATEGORY_FASHION_GOOD(2),
    CATEGORY_ANIMAL(3),
    CATEGORY_FOOD(4),
    CATEGORY_PLACE(5),
    CATEGORY_PLANT(6);

    private final int zzi;

    zzpm(int i) {
        this.zzi = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzbw
    public final int zza() {
        return this.zzi;
    }
}
