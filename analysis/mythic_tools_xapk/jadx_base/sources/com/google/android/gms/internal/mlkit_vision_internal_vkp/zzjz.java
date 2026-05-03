package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzjz extends zzki {
    static final zzjz zza = new zzjz();

    private zzjz() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzki
    public final Object zza() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzki
    public final Object zzb(Object obj) {
        zzkj.zzc(obj, "use Optional.orNull() instead of Optional.or(null)");
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzki
    public final boolean zzc() {
        return false;
    }
}
