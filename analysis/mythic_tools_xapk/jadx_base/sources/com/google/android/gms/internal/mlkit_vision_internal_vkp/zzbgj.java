package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbgj implements Iterator {
    private final ArrayDeque zza;
    private zzbdb zzb;

    /* synthetic */ zzbgj(zzbdd zzbddVar, zzbgi zzbgiVar) {
        if (!(zzbddVar instanceof zzbgl)) {
            this.zza = null;
            this.zzb = (zzbdb) zzbddVar;
            return;
        }
        zzbgl zzbglVar = (zzbgl) zzbddVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzbglVar.zzf());
        this.zza = arrayDeque;
        arrayDeque.push(zzbglVar);
        this.zzb = zzb(zzbglVar.zzd);
    }

    private final zzbdb zzb(zzbdd zzbddVar) {
        while (zzbddVar instanceof zzbgl) {
            zzbgl zzbglVar = (zzbgl) zzbddVar;
            this.zza.push(zzbglVar);
            zzbddVar = zzbglVar.zzd;
        }
        return (zzbdb) zzbddVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbdb next() {
        zzbdb zzbdbVarZzb;
        zzbdb zzbdbVar = this.zzb;
        if (zzbdbVar == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.zza;
            zzbdbVarZzb = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzbdbVarZzb = zzb(((zzbgl) this.zza.pop()).zze);
        } while (zzbdbVarZzb.zzd() == 0);
        this.zzb = zzbdbVarZzb;
        return zzbdbVar;
    }
}
