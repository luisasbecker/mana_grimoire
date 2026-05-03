package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzae extends zzs {
    final /* synthetic */ zzag zza;
    private final Object zzb;
    private int zzc;

    zzae(zzag zzagVar, int i) {
        this.zza = zzagVar;
        this.zzb = zzag.zzg(zzagVar, i);
        this.zzc = i;
    }

    private final void zza() {
        int i = this.zzc;
        if (i == -1 || i >= this.zza.size() || !zzc.zza(this.zzb, zzag.zzg(this.zza, this.zzc))) {
            this.zzc = this.zza.zzw(this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzs, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzs, java.util.Map.Entry
    public final Object getValue() {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return zzag.zzj(this.zza, i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzs, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        zzag zzagVar = this.zza;
        if (i == -1) {
            zzagVar.put(this.zzb, obj);
            return null;
        }
        Object objZzj = zzag.zzj(zzagVar, i);
        zzag.zzn(zzagVar, this.zzc, obj);
        return objZzj;
    }
}
