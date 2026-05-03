package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzli extends zzld {
    private final transient zzlb zza;
    private final transient Object[] zzb;
    private final transient int zzc = 1;

    zzli(zzlb zzlbVar, Object[] objArr, int i, int i2) {
        this.zza = zzlbVar;
        this.zzb = objArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv, java.util.AbstractCollection, java.util.Collection
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

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzld, com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv
    final int zza(Object[] objArr, int i) {
        return zzg().zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzld, com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv
    /* JADX INFO: renamed from: zzd */
    public final zzlp iterator() {
        return zzg().listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzld
    final zzkz zzh() {
        return new zzlh(this);
    }
}
