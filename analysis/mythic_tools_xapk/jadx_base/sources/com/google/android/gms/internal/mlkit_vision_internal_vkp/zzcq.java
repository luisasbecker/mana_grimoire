package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcq {
    private final int zza;
    private final int zzb;

    public zzcq(int i, int i2) {
        zzkj.zzd(i < 32767 && i >= 0);
        zzkj.zzd(i2 < 32767 && i2 >= 0);
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzcq) {
            zzcq zzcqVar = (zzcq) obj;
            if (this.zza == zzcqVar.zza && this.zzb == zzcqVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb | (this.zza << 16);
    }

    public final String toString() {
        return this.zza + "x" + this.zzb;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }
}
