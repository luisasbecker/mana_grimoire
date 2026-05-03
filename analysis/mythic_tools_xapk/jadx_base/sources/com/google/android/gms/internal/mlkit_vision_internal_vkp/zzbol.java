package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbol extends zzbeh implements zzbft {
    private static final zzbol zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private zzbnu zzh;
    private int zzj;
    private int zzk;
    private zzbny zzm;
    private long zzp;
    private byte zzq = 2;
    private String zzi = "";
    private zzbet zzl = zzL();
    private String zzn = "";
    private zzbet zzo = zzbel.zzL();

    static {
        zzbol zzbolVar = new zzbol();
        zzd = zzbolVar;
        zzbel.zzR(zzbol.class, zzbolVar);
    }

    private zzbol() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzq);
        }
        if (i2 == 2) {
            return zzO(zzd, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0002\u0003\u0001င\u0000\u0002င\u0001\u0003ᐉ\u0002\u0004ဈ\u0003\u0005င\u0004\u0006င\u0005\u0007Л\bᐉ\u0006\tဈ\u0007\n\u001a\u000bဂ\b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzboj.class, "zzm", "zzn", "zzo", "zzp"});
        }
        if (i2 == 3) {
            return new zzbol();
        }
        zzbne zzbneVar = null;
        if (i2 == 4) {
            return new zzbok(zzbneVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzq = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
