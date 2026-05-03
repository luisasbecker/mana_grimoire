package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzayj {
    private static zzayi zza;

    public static synchronized zzaxz zza(zzaxu zzaxuVar) {
        if (zza == null) {
            zza = new zzayi(null);
        }
        return (zzaxz) zza.get(zzaxuVar);
    }

    public static synchronized zzaxz zzb(String str) {
        return zza(zzaxu.zzd(str).zzd());
    }
}
