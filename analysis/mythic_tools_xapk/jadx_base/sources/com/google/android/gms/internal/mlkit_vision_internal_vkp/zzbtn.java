package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbtn extends zzbel implements zzbft {
    private static final zzbtn zzb;
    private int zzd;
    private float zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private zzbtq zzi;
    private float zzj;
    private zzbsz zzk;
    private float zzl;
    private byte zzo = 2;
    private zzbdd zzm = zzbdd.zzb;
    private zzbdd zzn = zzbdd.zzb;

    static {
        zzbtn zzbtnVar = new zzbtn();
        zzb = zzbtnVar;
        zzbel.zzR(zzbtn.class, zzbtnVar);
    }

    private zzbtn() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzo);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0004\u0001ᔁ\u0000\u0002ᔁ\u0001\u0003ᔁ\u0002\u0004ခ\u0003\u0005ခ\u0007\u0006ည\b\u0007ခ\u0005\bဉ\u0006\tᐉ\u0004\nည\t", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzl", "zzm", "zzj", "zzk", "zzi", "zzn"});
        }
        if (i2 == 3) {
            return new zzbtn();
        }
        zzbtl zzbtlVar = null;
        if (i2 == 4) {
            return new zzbtm(zzbtlVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
