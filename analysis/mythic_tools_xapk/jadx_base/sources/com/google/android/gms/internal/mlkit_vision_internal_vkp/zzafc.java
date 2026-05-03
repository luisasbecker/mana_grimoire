package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzafc implements Iterator {
    zzafd zza;
    zzafd zzb = null;
    int zzc;
    final /* synthetic */ zzafe zzd;

    zzafc(zzafe zzafeVar) {
        this.zzd = zzafeVar;
        this.zza = zzafeVar.zzd.zzd;
        this.zzc = zzafeVar.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza != this.zzd.zzd;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzafd zzafdVar = this.zzb;
        if (zzafdVar == null) {
            throw new IllegalStateException();
        }
        this.zzd.zze(zzafdVar, true);
        this.zzb = null;
        this.zzc = this.zzd.zzc;
    }

    final zzafd zza() {
        zzafe zzafeVar = this.zzd;
        zzafd zzafdVar = this.zza;
        if (zzafdVar == zzafeVar.zzd) {
            throw new NoSuchElementException();
        }
        if (zzafeVar.zzc != this.zzc) {
            throw new ConcurrentModificationException();
        }
        this.zza = zzafdVar.zzd;
        this.zzb = zzafdVar;
        return zzafdVar;
    }
}
