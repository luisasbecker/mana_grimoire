package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbfl {
    private final zzbfk zza;

    private zzbfl(zzbhq zzbhqVar, Object obj, zzbhq zzbhqVar2, Object obj2) {
        this.zza = new zzbfk(zzbhqVar, obj, zzbhqVar2, obj2);
    }

    static int zzb(zzbfk zzbfkVar, Object obj, Object obj2) {
        return zzbea.zza(zzbfkVar.zza, 1, obj) + zzbea.zza(zzbfkVar.zzc, 2, obj2);
    }

    public static zzbfl zzd(zzbhq zzbhqVar, Object obj, zzbhq zzbhqVar2, Object obj2) {
        return new zzbfl(zzbhqVar, obj, zzbhqVar2, obj2);
    }

    static void zze(zzbdq zzbdqVar, zzbfk zzbfkVar, Object obj, Object obj2) throws IOException {
        zzbea.zzk(zzbdqVar, zzbfkVar.zza, 1, obj);
        zzbea.zzk(zzbdqVar, zzbfkVar.zzc, 2, obj2);
    }

    public final int zza(int i, Object obj, Object obj2) {
        zzbfk zzbfkVar = this.zza;
        int iZzF = zzbdq.zzF(i << 3);
        int iZzb = zzb(zzbfkVar, obj, obj2);
        return iZzF + zzbdq.zzF(iZzb) + iZzb;
    }

    final zzbfk zzc() {
        return this.zza;
    }
}
