package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzac implements Iterator {
    int zzb;
    int zzc;
    int zzd = -1;
    final /* synthetic */ zzag zze;

    /* synthetic */ zzac(zzag zzagVar, zzab zzabVar) {
        this.zze = zzagVar;
        this.zzb = zzagVar.zzf;
        this.zzc = zzagVar.zze();
    }

    private final void zzb() {
        if (this.zze.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        zzb();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzc;
        this.zzd = i;
        Object objZza = zza(i);
        this.zzc = this.zze.zzf(this.zzc);
        return objZza;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzb();
        zzd.zze(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        int i = this.zzd;
        zzag zzagVar = this.zze;
        zzagVar.remove(zzag.zzg(zzagVar, i));
        this.zzc--;
        this.zzd = -1;
    }

    abstract Object zza(int i);
}
