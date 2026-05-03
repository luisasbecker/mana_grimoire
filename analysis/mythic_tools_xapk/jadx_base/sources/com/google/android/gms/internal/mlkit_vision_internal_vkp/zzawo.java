package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.util.Log;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzawo implements zzayl {
    private zzbhx zza;
    private final zzawy zzb;
    private final String zzc;
    private final String zzd;
    private final String zze = "com.google.perception";
    private final zzaws zzf;
    private final zzaxc zzg;
    private final zzawz zzh;
    private final zzawq zzi;

    zzawo(zzawy zzawyVar, String str, String str2, String str3, int i, zzaws zzawsVar, zzaxc zzaxcVar, zzawz zzawzVar, zzawq zzawqVar) {
        this.zzb = zzawyVar;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = zzawsVar;
        this.zzg = zzaxcVar;
        this.zzh = zzawzVar;
        this.zzi = zzawqVar;
    }

    public final zzbhx zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzayl
    public final boolean zzb() throws Throwable {
        boolean z;
        zzawy zzawyVar = new zzawy(this.zze, 2);
        zzawyVar.zzf();
        try {
            try {
                Log.d("AccelerationAllowlist", "Calling goldblum client");
                this.zza = this.zzh.zza(this.zzf, this.zzg, this.zzc, this.zzd, this.zze, 2);
                z = true;
            } catch (zzaxa e) {
                Log.d("AccelerationAllowlist", "Exception calling goldblum", e);
                this.zzb.zzb(e.zza());
                zzawyVar.zzd(e.zza());
                z = false;
            }
            return z;
        } finally {
            zzawyVar.zze();
            this.zzi.zza(zzawyVar);
        }
    }
}
