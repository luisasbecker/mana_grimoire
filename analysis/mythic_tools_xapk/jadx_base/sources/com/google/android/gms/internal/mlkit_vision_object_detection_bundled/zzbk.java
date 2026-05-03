package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbk extends zzaq {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzbk(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzd.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return Objects.requireNonNull(this.zza[i + i + this.zzb]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }
}
