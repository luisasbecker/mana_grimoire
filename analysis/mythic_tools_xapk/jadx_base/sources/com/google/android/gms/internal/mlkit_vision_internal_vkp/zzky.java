package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzky extends zzkz {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzkz zzc;

    zzky(zzkz zzkzVar, int i, int i2) {
        this.zzc = zzkzVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzkj.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkz, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkv
    @CheckForNull
    final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkz
    /* JADX INFO: renamed from: zzf */
    public final zzkz subList(int i, int i2) {
        zzkj.zze(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
