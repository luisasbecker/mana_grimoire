package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzcy implements Iterator {
    zzcz zza;
    zzcz zzb = null;
    int zzc;
    final /* synthetic */ zzda zzd;

    zzcy(zzda zzdaVar) {
        this.zzd = zzdaVar;
        this.zza = zzdaVar.zzd.zzd;
        this.zzc = zzdaVar.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza != this.zzd.zzd;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzcz zzczVar = this.zzb;
        if (zzczVar == null) {
            throw new IllegalStateException();
        }
        this.zzd.zze(zzczVar, true);
        this.zzb = null;
        this.zzc = this.zzd.zzc;
    }

    final zzcz zza() {
        zzda zzdaVar = this.zzd;
        zzcz zzczVar = this.zza;
        if (zzczVar == zzdaVar.zzd) {
            throw new NoSuchElementException();
        }
        if (zzdaVar.zzc != this.zzc) {
            throw new ConcurrentModificationException();
        }
        this.zza = zzczVar.zzd;
        this.zzb = zzczVar;
        return zzczVar;
    }
}
