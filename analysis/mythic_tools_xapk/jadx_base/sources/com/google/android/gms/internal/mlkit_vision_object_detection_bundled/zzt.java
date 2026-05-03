package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzt implements zzbe {

    @CheckForNull
    private transient Set zza;

    @CheckForNull
    private transient Map zzb;

    zzt() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbe) {
            return zzn().equals(((zzbe) obj).zzn());
        }
        return false;
    }

    public final int hashCode() {
        return zzn().hashCode();
    }

    public final String toString() {
        return zzn().toString();
    }

    abstract Map zzh();

    abstract Set zzi();

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzbe
    public boolean zzm(Object obj, Object obj2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzbe
    public final Map zzn() {
        Map map = this.zzb;
        if (map != null) {
            return map;
        }
        Map mapZzh = zzh();
        this.zzb = mapZzh;
        return mapZzh;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzbe
    public final Set zzo() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set setZzi = zzi();
        this.zza = setZzi;
        return setZzi;
    }
}
