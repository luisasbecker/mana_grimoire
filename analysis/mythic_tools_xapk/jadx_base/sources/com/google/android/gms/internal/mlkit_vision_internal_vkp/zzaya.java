package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaya implements zzaxr {
    private final zzun zza;

    private zzaya(zzun zzunVar, int i) {
        this.zza = zzunVar;
        zzayn.zza();
    }

    public static zzaxr zze(zzun zzunVar) {
        return new zzaya(zzunVar, 0);
    }

    private static int zzf(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxr
    public final zzaxr zza(zzary zzaryVar) {
        this.zza.zzd(zzue.zza(zzaryVar.zza()));
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxr
    public final zzaxr zzb(zzavq zzavqVar) {
        zzavs zzavsVarZzm = zzavqVar.zzm();
        zzadt zzadtVarZza = zzadu.zza();
        zzadtVarZza.zzc(zzkp.zzb(zzavsVarZzm.zzg()));
        zzadtVarZza.zzd(zzkp.zzb(zzavsVarZzm.zzh()));
        zzadtVarZza.zzf(zzkp.zzb(null));
        zzadtVarZza.zzk(zzkp.zzb(zzavsVarZzm.zzj()));
        zzadtVarZza.zzm(zzkp.zzb(zzavsVarZzm.zzk()));
        zzadtVarZza.zzg(zzkp.zzb(null));
        zzadtVarZza.zzb(zzkp.zzb(null));
        zzadtVarZza.zzj(zzkp.zzb(zzavsVarZzm.zzi()));
        zzadtVarZza.zzh(Boolean.TRUE.equals(zzavsVarZzm.zzb()));
        zzadtVarZza.zzi(Boolean.TRUE.equals(zzavsVarZzm.zzd()));
        zzadtVarZza.zze(zzf(zzavsVarZzm.zze()));
        zzadtVarZza.zzl(zzf(zzavsVarZzm.zzf()));
        zzkz zzkzVarZza = zzavsVarZzm.zza();
        if (zzkzVarZza != null) {
            zzadtVarZza.zza(zzkzVarZza);
        }
        this.zza.zzb(zzadtVarZza);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxr
    public final String zzc() {
        zzadu zzaduVarZzd = ((zzuo) this.zza.zzv()).zzd();
        return !zzaduVarZzd.zze().isEmpty() ? zzaduVarZzd.zze() : "NA";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxr
    public final byte[] zzd(int i, boolean z) {
        zzadt zzadtVar = (zzadt) this.zza.zzc().zzC();
        zzadtVar.zzh(false);
        this.zza.zzb(zzadtVar);
        return ((zzuo) this.zza.zzv()).zzw();
    }
}
