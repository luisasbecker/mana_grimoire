package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbvi extends zzbel implements zzbft {
    private static final zzbvi zzb;
    private int zzd;
    private boolean zzg;
    private boolean zzo;
    private float zze = 0.05f;
    private float zzf = 0.5f;
    private int zzh = 10;
    private int zzi = 200;
    private float zzj = 0.8f;
    private int zzk = 4;
    private int zzl = 10;
    private float zzm = 0.2f;
    private float zzn = 0.1f;

    static {
        zzbvi zzbviVar = new zzbvi();
        zzb = zzbviVar;
        zzbel.zzR(zzbvi.class, zzbviVar);
    }

    private zzbvi() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003င\u0003\u0004င\u0004\u0005င\u0006\u0006င\u0007\u0007ခ\b\bခ\t\tဇ\n\nခ\u0005\u000bဇ\u0002", new Object[]{"zzd", "zze", "zzf", "zzh", "zzi", "zzk", "zzl", "zzm", "zzn", "zzo", "zzj", "zzg"});
        }
        if (i2 == 3) {
            return new zzbvi();
        }
        zzbvg zzbvgVar = null;
        if (i2 == 4) {
            return new zzbvh(zzbvgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
