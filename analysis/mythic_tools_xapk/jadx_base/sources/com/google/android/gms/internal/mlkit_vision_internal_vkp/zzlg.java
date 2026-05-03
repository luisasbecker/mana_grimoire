package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlg extends zzkz {
    static final zzkz zza = new zzlg(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzlg(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzkj.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return Objects.requireNonNull(this.zzb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkz, com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv
    final Object[] zze() {
        return this.zzb;
    }
}
