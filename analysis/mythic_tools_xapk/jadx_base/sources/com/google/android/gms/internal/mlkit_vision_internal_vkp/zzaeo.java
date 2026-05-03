package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.Set;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaeo extends zzael {
    private final zzafe zza = new zzafe(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzaeo) && ((zzaeo) obj).zza.equals(this.zza);
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzaeo zza(String str) {
        return (zzaeo) this.zza.get("authToken");
    }

    public final zzaer zzc(String str) {
        return (zzaer) this.zza.get(str);
    }

    public final Set zzd() {
        return this.zza.entrySet();
    }

    public final void zze(String str, zzael zzaelVar) {
        this.zza.put(str, zzaelVar);
    }
}
