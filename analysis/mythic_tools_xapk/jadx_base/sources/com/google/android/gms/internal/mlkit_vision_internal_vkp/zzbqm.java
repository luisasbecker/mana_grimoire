package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbqm extends zzbeh implements zzbft {
    private static final zzbqm zzd;
    private int zze;
    private Object zzg;
    private Object zzi;
    private zzbhv zzm;
    private int zzn;
    private int zzo;
    private int zzf = 0;
    private int zzh = 0;
    private byte zzs = 2;
    private String zzj = "FaceAttributesClientBrainEmbedder";
    private String zzk = "";
    private zzbdd zzl = zzbdd.zzb;
    private boolean zzp = true;
    private int zzq = 1;
    private zzbdd zzr = zzbdd.zzb;

    static {
        zzbqm zzbqmVar = new zzbqm();
        zzd = zzbqmVar;
        zzbel.zzR(zzbqm.class, zzbqmVar);
    }

    private zzbqm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzs);
        }
        if (i2 == 2) {
            return zzO(zzd, "\u0004\r\u0002\u0001\u0002\u0010\r\u0000\u0000\u0001\u0002<\u0000\u0003;\u0000\u0004ဇ\u0006\u0005᠌\u0007\u0007м\u0001\b;\u0001\tဈ\u0000\nဈ\u0001\fင\u0004\rဉ\u0003\u000eည\b\u000fည\u0002\u0010င\u0005", new Object[]{"zzg", "zzf", "zzi", "zzh", "zze", zzbop.class, "zzp", "zzq", zzbqk.zza, zzbqz.class, "zzj", "zzk", "zzn", "zzm", "zzr", "zzl", "zzo"});
        }
        if (i2 == 3) {
            return new zzbqm();
        }
        zzbqj zzbqjVar = null;
        if (i2 == 4) {
            return new zzbql(zzbqjVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzs = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
