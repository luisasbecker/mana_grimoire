package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbg extends zzaq {
    static final zzaq zza = new zzbg(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzbg(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzd.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return Objects.requireNonNull(this.zzb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzaq, com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzal
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzal
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzal
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzal
    final Object[] zze() {
        return this.zzb;
    }
}
