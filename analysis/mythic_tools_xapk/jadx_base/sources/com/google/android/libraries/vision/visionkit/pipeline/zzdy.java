package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdy extends zzbel implements zzbft {
    private static final zzdy zzb;
    private int zzd;
    private String zze = "";
    private int zzf;
    private float zzg;
    private long zzh;
    private boolean zzi;
    private float zzj;
    private float zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    static {
        zzdy zzdyVar = new zzdy();
        zzb = zzdyVar;
        zzbel.zzR(zzdy.class, zzdyVar);
    }

    private zzdy() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ခ\u0002\u0004ဂ\u0003\u0005ဇ\u0004\u0006ခ\u0005\u0007ခ\u0006\bဂ\u0007\tင\b\nဂ\t", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
        }
        if (i2 == 3) {
            return new zzdy();
        }
        zzdv zzdvVar = null;
        if (i2 == 4) {
            return new zzdx(zzdvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
