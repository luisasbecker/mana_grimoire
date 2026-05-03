package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzoj {
    private final zzoh zza;
    private final Integer zzb;
    private final Integer zzc = null;
    private final Boolean zzd = null;

    /* synthetic */ zzoj(zzog zzogVar, zzoi zzoiVar) {
        this.zza = zzogVar.zza;
        this.zzb = zzogVar.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzoj)) {
            return false;
        }
        zzoj zzojVar = (zzoj) obj;
        if (Objects.equal(this.zza, zzojVar.zza) && Objects.equal(this.zzb, zzojVar.zzb)) {
            Integer num = zzojVar.zzc;
            if (Objects.equal(null, null)) {
                Boolean bool = zzojVar.zzd;
                if (Objects.equal(null, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, null);
    }

    public final zzoh zza() {
        return this.zza;
    }

    public final Integer zzb() {
        return this.zzb;
    }
}
