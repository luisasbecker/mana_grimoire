package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.os.Build;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzawt {
    public static final zzaws zza() {
        zzbyr zzbyrVarZze = zzbys.zze();
        zzbyrVarZze.zzc(Build.VERSION.SDK);
        zzbyrVarZze.zzb(Build.TYPE);
        zzbyrVarZze.zza(Build.ID);
        zzbyrVarZze.zzd(Build.VERSION.PREVIEW_SDK_INT);
        zzbyu zzbyuVarZze = zzbyv.zze();
        zzbyuVarZze.zza((zzbys) zzbyrVarZze.zzv());
        zzbyx zzbyxVarZzc = zzbyy.zzc();
        zzbyxVarZzc.zzb(Build.DEVICE);
        zzbyxVarZzc.zze(Build.PRODUCT);
        zzbyxVarZzc.zzd(Build.MODEL);
        zzbyxVarZzc.zzc(Build.MANUFACTURER);
        zzbyxVarZzc.zza(Build.BRAND);
        zzbyuVarZze.zzb((zzbyy) zzbyxVarZzc.zzv());
        zzbyuVarZze.zzc(com.google.android.libraries.intelligence.acceleration.zzd.zza().zzf());
        zzbyv zzbyvVar = (zzbyv) zzbyuVarZze.zzv();
        zzblq zzblqVarZzb = com.google.android.libraries.intelligence.acceleration.zzd.zzb();
        zzbzd zzbzdVarZzc = zzbze.zzc();
        for (zzblp zzblpVar : zzblqVarZzb.zzf()) {
            zzbza zzbzaVarZze = zzbzb.zze();
            zzbzaVarZze.zza(zzblpVar.zzf());
            zzbzaVarZze.zzc(zzblpVar.zzg());
            zzbzaVarZze.zzb((int) zzblpVar.zzc());
            zzbzdVarZzc.zza((zzbzb) zzbzaVarZze.zzv());
        }
        return new zzawu(zzbyvVar, (zzbze) zzbzdVarZzc.zzv());
    }
}
