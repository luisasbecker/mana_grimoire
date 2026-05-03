package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrs {
    private final zzrq zza;
    private final Boolean zzb;
    private final Boolean zzc;
    private final Integer zzd = null;
    private final Float zze = null;
    private final zzpi zzf = null;

    /* synthetic */ zzrs(zzrp zzrpVar, zzrr zzrrVar) {
        this.zza = zzrpVar.zza;
        this.zzb = zzrpVar.zzb;
        this.zzc = zzrpVar.zzc;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzrs)) {
            return false;
        }
        zzrs zzrsVar = (zzrs) obj;
        if (Objects.equal(this.zza, zzrsVar.zza) && Objects.equal(this.zzb, zzrsVar.zzb) && Objects.equal(this.zzc, zzrsVar.zzc)) {
            Integer num = zzrsVar.zzd;
            if (Objects.equal(null, null)) {
                Float f = zzrsVar.zze;
                if (Objects.equal(null, null)) {
                    zzpi zzpiVar = zzrsVar.zzf;
                    if (Objects.equal(null, null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, null, null, null);
    }

    public final zzrq zza() {
        return this.zza;
    }

    public final Boolean zzb() {
        return this.zzc;
    }

    public final Boolean zzc() {
        return this.zzb;
    }
}
