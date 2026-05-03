package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzec extends zzbel implements zzbft {
    private static final zzec zzb;
    private int zzd;
    private zzcv zze;
    private zzaw zzf;
    private zzaj zzg;
    private zzff zzh;
    private boolean zzi;
    private zzaz zzj;
    private zzcy zzk;
    private zzcm zzl;

    static {
        zzec zzecVar = new zzec();
        zzb = zzecVar;
        zzbel.zzR(zzec.class, zzecVar);
    }

    private zzec() {
    }

    public static zzeb zza() {
        return (zzeb) zzb.zzB();
    }

    static /* synthetic */ void zzd(zzec zzecVar, zzcv zzcvVar) {
        zzcvVar.getClass();
        zzecVar.zze = zzcvVar;
        zzecVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\b\u0000\u0001\u0001\t\b\u0000\u0000\u0000\u0001ဉ\u0001\u0003ဉ\u0005\u0004ဉ\u0000\u0005ဉ\u0002\u0006ဉ\u0003\u0007ဇ\u0004\bဉ\u0006\tဉ\u0007", new Object[]{"zzd", "zzf", "zzj", "zze", "zzg", "zzh", "zzi", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzec();
        }
        zzea zzeaVar = null;
        if (i2 == 4) {
            return new zzeb(zzeaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
