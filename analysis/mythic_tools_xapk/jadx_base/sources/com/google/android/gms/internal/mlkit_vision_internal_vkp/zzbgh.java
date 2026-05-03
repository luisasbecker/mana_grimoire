package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbgh {
    private final ArrayDeque zza = new ArrayDeque();

    private zzbgh() {
    }

    /* synthetic */ zzbgh(zzbgg zzbggVar) {
    }

    static /* bridge */ /* synthetic */ zzbdd zza(zzbgh zzbghVar, zzbdd zzbddVar, zzbdd zzbddVar2) {
        zzbghVar.zzb(zzbddVar);
        zzbghVar.zzb(zzbddVar2);
        zzbdd zzbglVar = (zzbdd) zzbghVar.zza.pop();
        while (!zzbghVar.zza.isEmpty()) {
            zzbglVar = new zzbgl((zzbdd) zzbghVar.zza.pop(), zzbglVar);
        }
        return zzbglVar;
    }

    private final void zzb(zzbdd zzbddVar) {
        zzbgk zzbgkVar;
        if (!zzbddVar.zzh()) {
            if (!(zzbddVar instanceof zzbgl)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(String.valueOf(zzbddVar.getClass()))));
            }
            zzbgl zzbglVar = (zzbgl) zzbddVar;
            zzb(zzbglVar.zzd);
            zzb(zzbglVar.zze);
            return;
        }
        int iZzc = zzc(zzbddVar.zzd());
        ArrayDeque arrayDeque = this.zza;
        int iZzc2 = zzbgl.zzc(iZzc + 1);
        if (arrayDeque.isEmpty() || ((zzbdd) this.zza.peek()).zzd() >= iZzc2) {
            this.zza.push(zzbddVar);
            return;
        }
        int iZzc3 = zzbgl.zzc(iZzc);
        zzbdd zzbglVar2 = (zzbdd) this.zza.pop();
        while (true) {
            zzbgkVar = null;
            if (this.zza.isEmpty() || ((zzbdd) this.zza.peek()).zzd() >= iZzc3) {
                break;
            } else {
                zzbglVar2 = new zzbgl((zzbdd) this.zza.pop(), zzbglVar2);
            }
        }
        zzbgl zzbglVar3 = new zzbgl(zzbglVar2, zzbddVar);
        while (!this.zza.isEmpty()) {
            int iZzc4 = zzc(zzbglVar3.zzd()) + 1;
            ArrayDeque arrayDeque2 = this.zza;
            if (((zzbdd) arrayDeque2.peek()).zzd() >= zzbgl.zzc(iZzc4)) {
                break;
            } else {
                zzbglVar3 = new zzbgl((zzbdd) this.zza.pop(), zzbglVar3);
            }
        }
        this.zza.push(zzbglVar3);
    }

    private static final int zzc(int i) {
        int iBinarySearch = Arrays.binarySearch(zzbgl.zza, i);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }
}
