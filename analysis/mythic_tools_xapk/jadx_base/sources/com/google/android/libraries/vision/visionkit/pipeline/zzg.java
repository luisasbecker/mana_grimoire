package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzg extends zzbel implements zzbft {
    private static final zzg zzb;
    private int zzd;
    private boolean zze;
    private String zzf = "";

    static {
        zzg zzgVar = new zzg();
        zzb = zzgVar;
        zzbel.zzR(zzg.class, zzgVar);
    }

    private zzg() {
    }

    public static zzf zza() {
        return (zzf) zzb.zzB();
    }

    static /* synthetic */ void zzd(zzg zzgVar, boolean z) {
        zzgVar.zzd |= 1;
        zzgVar.zze = true;
    }

    static /* synthetic */ void zze(zzg zzgVar, String str) {
        str.getClass();
        zzgVar.zzd |= 2;
        zzgVar.zzf = str;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzg();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzf(zzeVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
