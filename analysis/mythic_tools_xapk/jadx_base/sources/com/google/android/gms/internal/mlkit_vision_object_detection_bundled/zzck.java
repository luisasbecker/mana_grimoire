package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.Set;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzck extends zzch {
    private final zzda zza = new zzda(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzck) && ((zzck) obj).zza.equals(this.zza);
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzck zza(String str) {
        return (zzck) this.zza.get("authToken");
    }

    public final zzcn zzc(String str) {
        return (zzcn) this.zza.get(str);
    }

    public final Set zzd() {
        return this.zza.entrySet();
    }

    public final void zze(String str, zzch zzchVar) {
        this.zza.put(str, zzchVar);
    }
}
