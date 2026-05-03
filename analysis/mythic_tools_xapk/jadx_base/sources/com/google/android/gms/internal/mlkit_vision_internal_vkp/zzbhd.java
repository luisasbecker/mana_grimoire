package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzbhd {
    private static volatile int zza = 100;

    zzbhd() {
    }

    abstract Object zza(Object obj);

    abstract Object zzb();

    abstract Object zzc(Object obj);

    abstract void zzd(Object obj, int i, int i2);

    abstract void zze(Object obj, int i, long j);

    abstract void zzf(Object obj, int i, Object obj2);

    abstract void zzg(Object obj, int i, zzbdd zzbddVar);

    abstract void zzh(Object obj, int i, long j);

    abstract void zzi(Object obj);

    abstract void zzj(Object obj, Object obj2);

    final boolean zzk(Object obj, zzbge zzbgeVar, int i) throws IOException {
        int iZzd = zzbgeVar.zzd();
        int i2 = iZzd >>> 3;
        int i3 = iZzd & 7;
        if (i3 == 0) {
            zzh(obj, i2, zzbgeVar.zzl());
            return true;
        }
        if (i3 == 1) {
            zze(obj, i2, zzbgeVar.zzk());
            return true;
        }
        if (i3 == 2) {
            zzg(obj, i2, zzbgeVar.zzp());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw new zzbev("Protocol message tag had invalid wire type.");
            }
            zzd(obj, i2, zzbgeVar.zzf());
            return true;
        }
        Object objZzb = zzb();
        int i4 = i2 << 3;
        int i5 = i + 1;
        if (i5 >= zza) {
            throw new zzbew("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzbgeVar.zzc() != Integer.MAX_VALUE && zzk(objZzb, zzbgeVar, i5)) {
        }
        if ((i4 | 4) != zzbgeVar.zzd()) {
            throw new zzbew("Protocol message end-group tag did not match expected tag.");
        }
        zzf(obj, i2, zzc(objZzb));
        return true;
    }
}
