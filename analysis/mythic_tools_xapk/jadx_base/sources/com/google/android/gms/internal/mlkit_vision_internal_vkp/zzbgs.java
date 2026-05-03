package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbgs implements Iterator {
    final /* synthetic */ zzbgw zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzbgs(zzbgw zzbgwVar, zzbgr zzbgrVar) {
        this.zza = zzbgwVar;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzbgw zzbgwVar = this.zza;
        if (i >= zzbgwVar.zzb) {
            return !zzbgwVar.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzbgw zzbgwVar = this.zza;
        return i < zzbgwVar.zzb ? (zzbgq) zzbgwVar.zza[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzo();
        int i = this.zzb;
        zzbgw zzbgwVar = this.zza;
        if (i >= zzbgwVar.zzb) {
            zza().remove();
        } else {
            this.zzb = i - 1;
            zzbgwVar.zzm(i);
        }
    }
}
