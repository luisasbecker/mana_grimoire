package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzce extends zzbw {
    final /* synthetic */ zzcf zza;

    zzce(zzcf zzcfVar) {
        Objects.requireNonNull(zzcfVar);
        this.zza = zzcfVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzcf zzcfVar = this.zza;
        zzbj.zza(i, zzcfVar.zzc, FirebaseAnalytics.Param.INDEX);
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(zzcfVar.zzb[i2]), Objects.requireNonNull(zzcfVar.zzb[i2 + 1]));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    public final boolean zzf() {
        return true;
    }
}
