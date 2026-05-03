package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbj extends zzau {
    private final transient zzat zza;
    private final transient zzaq zzb;

    zzbj(zzat zzatVar, zzaq zzaqVar) {
        this.zza = zzatVar;
        this.zzb = zzaqVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzal, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzau, com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzal, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzal
    final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzau, com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzal
    /* JADX INFO: renamed from: zzd */
    public final zzbp iterator() {
        return this.zzb.listIterator(0);
    }
}
