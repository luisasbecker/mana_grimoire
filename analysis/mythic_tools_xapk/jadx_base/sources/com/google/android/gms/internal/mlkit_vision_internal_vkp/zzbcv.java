package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbcv extends zzbcw {
    final /* synthetic */ zzbdd zza;
    private int zzb = 0;
    private final int zzc;

    zzbcv(zzbdd zzbddVar) {
        this.zza = zzbddVar;
        this.zzc = zzbddVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcy
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
