package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzawq {
    private final zzaxz zza = zzayj.zzb("shared-acceleration-allowlist");

    private final void zzc(zzawy zzawyVar, zzary zzaryVar) throws Throwable {
        zzarz zzarzVar = new zzarz();
        zzarzVar.zzc(zzawyVar.zza().zzk());
        this.zza.zzc(zzayb.zze(zzarzVar), zzaryVar);
    }

    public final void zza(zzawy zzawyVar) throws Throwable {
        zzc(zzawyVar, zzary.ACCELERATION_ALLOWLIST_FETCH);
    }

    public final void zzb(zzawy zzawyVar) throws Throwable {
        zzc(zzawyVar, zzary.ACCELERATION_ALLOWLIST_GET);
    }
}
