package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbgb {
    public static final /* synthetic */ int zza = 0;
    private static final zzbgb zzb = new zzbgb();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzbgn zzc = new zzbfj();

    private zzbgb() {
    }

    public static zzbgb zza() {
        return zzb;
    }

    public final zzbgm zzb(Class cls) {
        zzbeu.zzc(cls, "messageType");
        zzbgm zzbgmVar = (zzbgm) this.zzd.get(cls);
        if (zzbgmVar != null) {
            return zzbgmVar;
        }
        zzbgm zzbgmVarZza = this.zzc.zza(cls);
        zzbeu.zzc(cls, "messageType");
        zzbgm zzbgmVar2 = (zzbgm) this.zzd.putIfAbsent(cls, zzbgmVarZza);
        return zzbgmVar2 == null ? zzbgmVarZza : zzbgmVar2;
    }
}
