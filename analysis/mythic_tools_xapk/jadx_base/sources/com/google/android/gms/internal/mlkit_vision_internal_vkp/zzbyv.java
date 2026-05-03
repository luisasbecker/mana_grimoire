package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbyv extends zzbel implements zzbft {
    private static final zzbyv zzb;
    private int zzd;
    private zzbyy zze;
    private zzbys zzf;
    private String zzg = "";

    static {
        zzbyv zzbyvVar = new zzbyv();
        zzb = zzbyvVar;
        zzbel.zzR(zzbyv.class, zzbyvVar);
    }

    private zzbyv() {
    }

    public static zzbyu zze() {
        return (zzbyu) zzb.zzB();
    }

    static /* synthetic */ void zzi(zzbyv zzbyvVar, zzbyy zzbyyVar) {
        zzbyyVar.getClass();
        zzbyvVar.zze = zzbyyVar;
        zzbyvVar.zzd |= 1;
    }

    static /* synthetic */ void zzj(zzbyv zzbyvVar, zzbys zzbysVar) {
        zzbysVar.getClass();
        zzbyvVar.zzf = zzbysVar;
        zzbyvVar.zzd |= 2;
    }

    static /* synthetic */ void zzk(zzbyv zzbyvVar, String str) {
        str.getClass();
        zzbyvVar.zzg = str;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003Ȉ", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzbyv();
        }
        zzbyt zzbytVar = null;
        if (i2 == 4) {
            return new zzbyu(zzbytVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzbys zzc() {
        zzbys zzbysVar = this.zzf;
        return zzbysVar == null ? zzbys.zzg() : zzbysVar;
    }

    public final zzbyy zzg() {
        zzbyy zzbyyVar = this.zze;
        return zzbyyVar == null ? zzbyy.zzf() : zzbyyVar;
    }

    public final String zzh() {
        return this.zzg;
    }
}
