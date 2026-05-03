package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbdu {
    private final Object zza;
    private final int zzb;

    zzbdu(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbdu)) {
            return false;
        }
        zzbdu zzbduVar = (zzbdu) obj;
        return this.zza == zzbduVar.zza && this.zzb == zzbduVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
