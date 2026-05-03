package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzjt extends zzbel implements zzbft {
    private static final zzjt zzb;
    private int zzd;
    private zzbvq zzq;
    private long zze = C.NANOS_PER_SECOND;
    private float zzf = 0.2f;
    private float zzg = 0.6f;
    private float zzh = 0.6f;
    private float zzi = 0.5f;
    private int zzj = 3;
    private float zzk = -0.5f;
    private float zzl = -0.5f;
    private int zzm = 1000000;
    private float zzn = 10.0f;
    private float zzo = 0.8f;
    private float zzp = 1.5f;
    private float zzr = 0.15f;
    private float zzs = 0.5f;
    private float zzt = 0.3f;
    private float zzu = 3.0f;
    private float zzv = 3.0f;
    private int zzw = 5;
    private int zzx = 5;
    private float zzy = 0.5f;

    static {
        zzjt zzjtVar = new zzjt();
        zzb = zzjtVar;
        zzbel.zzR(zzjt.class, zzjtVar);
    }

    private zzjt() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006င\u0005\u0007ခ\u0006\bခ\u0007\tင\b\nခ\t\u000bခ\n\fဉ\f\rခ\u000b\u000eခ\r\u000fခ\u000e\u0010ခ\u000f\u0011ခ\u0010\u0012ခ\u0011\u0013င\u0012\u0014င\u0013\u0015ခ\u0014", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzq", "zzp", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy"});
        }
        if (i2 == 3) {
            return new zzjt();
        }
        zzjr zzjrVar = null;
        if (i2 == 4) {
            return new zzjs(zzjrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
