package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.Date;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvv {
    private final zzvt zza;

    private zzvv(Date date, int i, zzvt zzvtVar, String str) {
        this.zza = zzvtVar;
    }

    public static zzvv zzb(Date date) {
        return new zzvv(date, 1, null, null);
    }

    public static zzvv zzc(zzvt zzvtVar, String str) {
        return new zzvv(zzvtVar.zzb(), 0, zzvtVar, str);
    }

    public final zzvt zza() {
        return this.zza;
    }
}
