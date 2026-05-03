package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkk extends zzki {
    private final Object zza;

    zzkk(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzkk) {
            return this.zza.equals(((zzkk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.zza.toString() + ")";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzki
    public final Object zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzki
    public final Object zzb(Object obj) {
        zzkj.zzc(obj, "use Optional.orNull() instead of Optional.or(null)");
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzki
    public final boolean zzc() {
        return true;
    }
}
