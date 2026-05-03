package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzawu extends zzaws {
    private final zzbyv zza;
    private final zzbze zzb;

    zzawu(zzbyv zzbyvVar, zzbze zzbzeVar) {
        if (zzbyvVar == null) {
            throw new NullPointerException("Null deviceInfo");
        }
        this.zza = zzbyvVar;
        if (zzbzeVar == null) {
            throw new NullPointerException("Null NNAPIInfo");
        }
        this.zzb = zzbzeVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzaws) {
            zzaws zzawsVar = (zzaws) obj;
            if (this.zza.equals(zzawsVar.zza()) && this.zzb.equals(zzawsVar.zzb())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        return this.zzb.hashCode() ^ (iHashCode * 1000003);
    }

    public final String toString() {
        zzbze zzbzeVar = this.zzb;
        return "AndroidSystemInfo{deviceInfo=" + this.zza.toString() + ", NNAPIInfo=" + zzbzeVar.toString() + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaws
    final zzbyv zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaws
    final zzbze zzb() {
        return this.zzb;
    }
}
