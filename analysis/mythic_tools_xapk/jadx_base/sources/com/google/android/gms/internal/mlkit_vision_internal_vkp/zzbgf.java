package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbgf extends zzbcw {
    final zzbgj zza;
    zzbcy zzb = zzb();
    final /* synthetic */ zzbgl zzc;

    zzbgf(zzbgl zzbglVar) {
        this.zzc = zzbglVar;
        this.zza = new zzbgj(zzbglVar, null);
    }

    private final zzbcy zzb() {
        zzbgj zzbgjVar = this.zza;
        if (zzbgjVar.hasNext()) {
            return zzbgjVar.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcy
    public final byte zza() {
        zzbcy zzbcyVar = this.zzb;
        if (zzbcyVar == null) {
            throw new NoSuchElementException();
        }
        byte bZza = zzbcyVar.zza();
        if (!this.zzb.hasNext()) {
            this.zzb = zzb();
        }
        return bZza;
    }
}
