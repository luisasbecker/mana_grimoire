package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbtk extends zzbel implements zzbft {
    private static final zzbtk zzb;
    private int zzd;
    private long zze;
    private int zzh;
    private int zzi;
    private zzbtc zzl;
    private zzbtw zzn;
    private byte zzt = 2;
    private String zzf = "";
    private String zzg = "";
    private zzbet zzj = zzbel.zzL();
    private String zzk = "";
    private zzbdd zzm = zzbdd.zzb;
    private String zzo = "";
    private zzbet zzp = zzL();
    private zzbet zzq = zzL();
    private zzbdd zzr = zzbdd.zzb;
    private String zzs = "";

    static {
        zzbtk zzbtkVar = new zzbtk();
        zzb = zzbtkVar;
        zzbel.zzR(zzbtk.class, zzbtkVar);
    }

    private zzbtk() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzt);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u000f\u0000\u0001\u0001\u001c\u000f\u0000\u0003\u0004\u0001ᔂ\u0000\u0002б\u0010ဈ\u0001\u0011ဈ\u0002\u0012င\u0003\u0013င\u0004\u0014\u001a\u0015ဈ\u0005\u0016ည\u0007\u0017ᐉ\b\u0018ᐉ\u0006\u0019ည\n\u001aဈ\t\u001bဈ\u000b\u001c\u001b", new Object[]{"zzd", "zze", "zzp", zzbtj.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzm", "zzn", "zzl", "zzr", "zzo", "zzs", "zzq", zzbtf.class});
        }
        if (i2 == 3) {
            return new zzbtk();
        }
        zzbtg zzbtgVar = null;
        if (i2 == 4) {
            return new zzbth(zzbtgVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzt = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
