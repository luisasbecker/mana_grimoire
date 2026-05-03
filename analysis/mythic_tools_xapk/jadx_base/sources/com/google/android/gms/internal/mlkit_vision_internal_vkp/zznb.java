package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class zznb extends zzbel implements zzbft {
    private static final zznb zzb;
    private int zzd;
    private zznd zzj;
    private byte zzk = 2;
    private String zze = "";
    private zzbet zzf = zzbel.zzL();
    private zzbet zzg = zzbel.zzL();
    private zzbet zzh = zzbel.zzL();
    private zzbet zzi = zzbel.zzL();

    static {
        zznb zznbVar = new zznb();
        zzb = zznbVar;
        zzbel.zzR(zznb.class, zznbVar);
    }

    private zznb() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0006\u0000\u0001\u0001ϫ\u0006\u0000\u0004\u0001\u0001ဈ\u0000\u0002\u001a\u0003\u001a\u0004ᐉ\u0001Ϫ\u001aϫ\u001a", new Object[]{"zzd", "zze", "zzf", "zzh", "zzj", "zzg", "zzi"});
        }
        if (i2 == 3) {
            return new zznb();
        }
        zzmz zzmzVar = null;
        if (i2 == 4) {
            return new zzna(zzmzVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
