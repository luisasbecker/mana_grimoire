package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.content.Context;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzs {
    public static final zzs zza;
    private final boolean zzb;
    private final boolean zzc = false;
    private final zzkz zzd;

    static {
        zzp zzpVar = null;
        zzq zzqVar = new zzq(zzpVar);
        zzqVar.zzb();
        zza = zzqVar.zzd();
        zzq zzqVar2 = new zzq(zzpVar);
        zzqVar2.zzb();
        zzqVar2.zza(new zzo());
        zzqVar2.zzd();
        zzq zzqVar3 = new zzq(zzpVar);
        zzqVar3.zzc();
        zzqVar3.zzd();
    }

    /* synthetic */ zzs(boolean z, boolean z2, zzkz zzkzVar, zzr zzrVar) {
        this.zzb = z;
        this.zzd = zzkzVar;
    }

    static /* bridge */ /* synthetic */ boolean zza(zzs zzsVar) {
        boolean z = zzsVar.zzc;
        return false;
    }

    static /* bridge */ /* synthetic */ int zzc(zzs zzsVar, Context context, zzu zzuVar) {
        zzkz zzkzVar = zzsVar.zzd;
        int size = zzkzVar.size();
        int i = 0;
        while (i < size) {
            int iZza = ((zzv) zzkzVar.get(i)).zza(context, zzuVar, zzsVar.zzb) - 1;
            i++;
            if (iZza == 1) {
                return 2;
            }
        }
        return 3;
    }
}
