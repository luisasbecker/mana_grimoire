package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbi extends zzau {
    private final transient zzat zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zzbi(zzat zzatVar, Object[] objArr, int i, int i2) {
        this.zza = zzatVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzal, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzau, com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzal, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzf().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzal
    final int zza(Object[] objArr, int i) {
        return zzf().zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzau, com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzal
    /* JADX INFO: renamed from: zzd */
    public final zzbp iterator() {
        return zzf().listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzau
    final zzaq zzg() {
        return new zzbh(this);
    }
}
