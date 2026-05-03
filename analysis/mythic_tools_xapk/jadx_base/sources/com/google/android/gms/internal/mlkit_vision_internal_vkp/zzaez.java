package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaez extends AbstractSet {
    final /* synthetic */ zzafe zza;

    zzaez(zzafe zzafeVar) {
        this.zza = zzafeVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj instanceof Map.Entry) && this.zza.zzb((Map.Entry) obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzaey(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        zzafd zzafdVarZzb;
        if (!(obj instanceof Map.Entry) || (zzafdVarZzb = this.zza.zzb((Map.Entry) obj)) == null) {
            return false;
        }
        this.zza.zze(zzafdVarZzb, true);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.zzb;
    }
}
