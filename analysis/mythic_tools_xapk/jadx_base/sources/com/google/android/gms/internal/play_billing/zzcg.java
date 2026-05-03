package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcg extends zzca {
    private final transient zzbz zza;
    private final transient zzbw zzb;

    zzcg(zzbz zzbzVar, zzbw zzbwVar) {
        this.zza = zzbzVar;
        this.zzb = zzbwVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzca, com.google.android.gms.internal.play_billing.zzbt, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzca, com.google.android.gms.internal.play_billing.zzbt
    public final zzbw zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzca, com.google.android.gms.internal.play_billing.zzbt
    /* JADX INFO: renamed from: zze */
    public final zzck iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final boolean zzf() {
        throw null;
    }
}
