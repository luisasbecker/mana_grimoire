package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaf extends AbstractCollection {
    final /* synthetic */ zzag zza;

    zzaf(zzag zzagVar) {
        this.zza = zzagVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzag zzagVar = this.zza;
        Map mapZzl = zzagVar.zzl();
        return mapZzl != null ? mapZzl.values().iterator() : new zzz(zzagVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size();
    }
}
