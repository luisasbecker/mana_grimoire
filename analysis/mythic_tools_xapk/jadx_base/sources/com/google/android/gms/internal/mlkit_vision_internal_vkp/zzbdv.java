package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbdv {
    static final zzbdv zza = new zzbdv(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzbdv zzd;
    private final Map zze;

    zzbdv() {
        this.zze = new HashMap();
    }

    zzbdv(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzbdv zza() {
        int i = zzbgb.zza;
        return zza;
    }

    public static zzbdv zzb() {
        zzbdv zzbdvVar = zzd;
        if (zzbdvVar != null) {
            return zzbdvVar;
        }
        synchronized (zzbdv.class) {
            zzbdv zzbdvVar2 = zzd;
            if (zzbdvVar2 != null) {
                return zzbdvVar2;
            }
            int i = zzbgb.zza;
            zzbdv zzbdvVarZzb = zzbed.zzb(zzbdv.class);
            zzd = zzbdvVarZzb;
            return zzbdvVarZzb;
        }
    }

    public final zzbej zzc(zzbfs zzbfsVar, int i) {
        return (zzbej) this.zze.get(new zzbdu(zzbfsVar, i));
    }
}
