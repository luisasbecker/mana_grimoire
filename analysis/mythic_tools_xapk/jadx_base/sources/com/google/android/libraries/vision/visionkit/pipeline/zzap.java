package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbsq;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzhg;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zziy;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzap extends zzbel implements zzbft {
    private static final zzap zzb;
    private int zzd;
    private Object zzf;
    private boolean zzg;
    private zziy zzh;
    private boolean zzi;
    private zzhg zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzo;
    private float zzp;
    private int zzq;
    private com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbp zzr;
    private int zze = 0;
    private byte zzs = 2;
    private int zzn = -1;

    static {
        zzap zzapVar = new zzap();
        zzb = zzapVar;
        zzbel.zzR(zzap.class, zzapVar);
    }

    private zzap() {
    }

    public static zzao zza() {
        return (zzao) zzb.zzB();
    }

    static /* synthetic */ void zzd(zzap zzapVar, zziy zziyVar) {
        zziyVar.getClass();
        zzapVar.zzh = zziyVar;
        zzapVar.zzd |= 2;
    }

    static /* synthetic */ void zze(zzap zzapVar, boolean z) {
        zzapVar.zzd |= 4;
        zzapVar.zzi = true;
    }

    static /* synthetic */ void zzf(zzap zzapVar, zzhg zzhgVar) {
        zzhgVar.getClass();
        zzapVar.zzj = zzhgVar;
        zzapVar.zzd |= 8;
    }

    static /* synthetic */ void zzg(zzap zzapVar, zzbsq zzbsqVar) {
        zzbsqVar.getClass();
        zzapVar.zzf = zzbsqVar;
        zzapVar.zze = 1;
    }

    static /* synthetic */ void zzh(zzap zzapVar, boolean z) {
        zzapVar.zzd |= 64;
        zzapVar.zzm = z;
    }

    static /* synthetic */ void zzi(zzap zzapVar, int i) {
        zzapVar.zzd |= 128;
        zzapVar.zzn = i;
    }

    static /* synthetic */ void zzj(zzap zzapVar, float f) {
        zzapVar.zzd |= 512;
        zzapVar.zzp = 0.6f;
    }

    static /* synthetic */ void zzk(zzap zzapVar, int i) {
        zzapVar.zzd |= 1024;
        zzapVar.zzq = 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzs);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u000e\u0001\u0001\u0001\u000e\u000e\u0000\u0000\u0001\u0001м\u0000\u0002ဉ\u0001\u0003ဉ\u0003\u0004ဇ\u0006\u0005င\u0007\u0006ဇ\b\u0007ဇ\u0000\bခ\t\tင\n\nဇ\u0002\u000bဉ\u000b\fခ\u0004\rဇ\u0005\u000e<\u0000", new Object[]{"zzf", "zze", "zzd", zzbsq.class, "zzh", "zzj", "zzm", "zzn", "zzo", "zzg", "zzp", "zzq", "zzi", "zzr", "zzk", "zzl", com.google.android.gms.internal.mlkit_vision_internal_vkp.zzcy.class});
        }
        if (i2 == 3) {
            return new zzap();
        }
        zzan zzanVar = null;
        if (i2 == 4) {
            return new zzao(zzanVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzs = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
