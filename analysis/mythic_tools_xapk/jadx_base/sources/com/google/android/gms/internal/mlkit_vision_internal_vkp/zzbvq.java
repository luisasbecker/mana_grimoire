package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbvq extends zzbel implements zzbft {
    private static final zzbvq zzb;
    private int zzd;
    private zzbvo zze;
    private float zzf = 0.6f;
    private float zzg = 0.5f;
    private float zzh = 0.01f;
    private float zzi = 0.2f;
    private float zzj = 3.0f;
    private float zzk = 0.75f;
    private float zzl = 0.75f;
    private float zzm = 0.25f;
    private float zzn = 0.2f;
    private float zzo = 0.4f;
    private int zzp = 10;
    private float zzq = 0.05f;
    private int zzr = 3;

    static {
        zzbvq zzbvqVar = new zzbvq();
        zzb = zzbvqVar;
        zzbel.zzR(zzbvq.class, zzbvqVar);
    }

    private zzbvq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0000\u0000\u0001ဉ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005\bခ\u0006\tခ\u0007\nခ\b\u000bခ\t\fခ\n\rင\u000b\u000eခ\f\u000fင\r", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr"});
        }
        if (i2 == 3) {
            return new zzbvq();
        }
        zzbvm zzbvmVar = null;
        if (i2 == 4) {
            return new zzbvp(zzbvmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
