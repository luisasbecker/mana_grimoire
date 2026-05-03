package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzem {
    private final zzpa zza;
    private final Boolean zzb;
    private final Boolean zzc;
    private final zzoj zzd = null;
    private final zzrs zze;

    /* synthetic */ zzem(zzek zzekVar, zzel zzelVar) {
        this.zza = zzekVar.zza;
        this.zzb = zzekVar.zzb;
        this.zzc = zzekVar.zzc;
        this.zze = zzekVar.zzd;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzem)) {
            return false;
        }
        zzem zzemVar = (zzem) obj;
        if (Objects.equal(this.zza, zzemVar.zza) && Objects.equal(this.zzb, zzemVar.zzb) && Objects.equal(this.zzc, zzemVar.zzc)) {
            zzoj zzojVar = zzemVar.zzd;
            if (Objects.equal(null, null) && Objects.equal(this.zze, zzemVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, null, this.zze);
    }

    public final zzpa zza() {
        return this.zza;
    }

    public final zzrs zzb() {
        return this.zze;
    }

    public final Boolean zzc() {
        return this.zzb;
    }

    public final Boolean zzd() {
        return this.zzc;
    }
}
