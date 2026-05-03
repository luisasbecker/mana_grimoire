package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbt implements zzby {
    private final int zza;
    private final zzbx zzb;

    zzbt(int i, zzbx zzbxVar) {
        this.zza = i;
        this.zzb = zzbxVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return zzby.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzby)) {
            return false;
        }
        zzby zzbyVar = (zzby) obj;
        return this.zza == zzbyVar.zza() && this.zzb.equals(zzbyVar.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzby
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzby
    public final zzbx zzb() {
        return this.zzb;
    }
}
