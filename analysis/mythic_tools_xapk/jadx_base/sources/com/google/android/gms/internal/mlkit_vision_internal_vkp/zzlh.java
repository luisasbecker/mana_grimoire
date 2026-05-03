package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlh extends zzkz {
    final /* synthetic */ zzli zza;

    zzlh(zzli zzliVar) {
        this.zza = zzliVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzkj.zza(i, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(this.zza.zzb[i2]), Objects.requireNonNull(this.zza.zzb[i2 + 1]));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }
}
