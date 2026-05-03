package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlj extends zzld {
    private final transient zzlb zza;
    private final transient zzkz zzb;

    zzlj(zzlb zzlbVar, zzkz zzkzVar) {
        this.zza = zzlbVar;
        this.zzb = zzkzVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzld, com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv
    final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzld, com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv
    /* JADX INFO: renamed from: zzd */
    public final zzlp iterator() {
        return this.zzb.listIterator(0);
    }
}
