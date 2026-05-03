package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhs extends zzbel implements zzbft {
    private static final zzhs zzb;
    private int zzd;
    private Object zzf;
    private boolean zzg;
    private long zzi;
    private float zzm;
    private float zzn;
    private float zzo;
    private int zze = 0;
    private byte zzp = 2;
    private zzbet zzh = zzL();
    private boolean zzj = true;
    private zzbeq zzk = zzI();
    private float zzl = 0.15f;

    static {
        zzhs zzhsVar = new zzhs();
        zzb = zzhsVar;
        zzbel.zzR(zzhs.class, zzhsVar);
    }

    private zzhs() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzp);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\n\u0001\u0001\u0002\r\n\u0000\u0002\u0001\u0002м\u0000\u0003ဇ\u0000\u0004\u001b\u0005\u0013\u0006ခ\u0003\u0007ခ\u0004\bခ\u0005\u000bခ\u0006\fဂ\u0001\rဇ\u0002", new Object[]{"zzf", "zze", "zzd", zzin.class, "zzg", "zzh", zzhj.class, "zzk", "zzl", "zzm", "zzn", "zzo", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzhs();
        }
        zzhq zzhqVar = null;
        if (i2 == 4) {
            return new zzhr(zzhqVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzp = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
