package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbbd extends zzbel implements zzbft {
    private static final zzbbd zzb;
    private int zzd;
    private int zze;
    private zzazv zzg;
    private zzazv zzh;
    private float zzj;
    private zzazv zzl;
    private zzazv zzm;
    private zzbal zzn;
    private zzbbh zzp;
    private byte zzq = 2;
    private zzber zzf = zzJ();
    private String zzi = "";
    private zzbet zzk = zzL();
    private boolean zzo = true;

    static {
        zzbbd zzbbdVar = new zzbbd();
        zzb = zzbbdVar;
        zzbel.zzR(zzbbd.class, zzbbdVar);
    }

    private zzbbd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzq);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0002\b\u0001ᔄ\u0000\u0002ᔉ\u0001\u0003ᐉ\u0002\u0004ဈ\u0003\u0005ခ\u0004\u0006ᐉ\u0005\u0007ᐉ\u0006\bᐉ\u0007\tဇ\b\nᐉ\t\u000bЛ\f\u0016", new Object[]{"zzd", "zze", "zzg", "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzk", zzazz.class, "zzf"});
        }
        if (i2 == 3) {
            return new zzbbd();
        }
        zzazt zzaztVar = null;
        if (i2 == 4) {
            return new zzbbc(zzaztVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzq = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
