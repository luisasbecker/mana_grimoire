package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zznm implements zznr {
    private final int zza;
    private final zznq zzb;

    zznm(int i, zznq zznqVar) {
        this.zza = i;
        this.zzb = zznqVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return zznr.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zznr)) {
            return false;
        }
        zznr zznrVar = (zznr) obj;
        return this.zza == zznrVar.zza() && this.zzb.equals(zznrVar.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zznr
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zznr
    public final zznq zzb() {
        return this.zzb;
    }
}
