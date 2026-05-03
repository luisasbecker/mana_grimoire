package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzby extends zzbel implements zzbft {
    private static final zzby zzb;
    private int zzd;
    private int zze = -1;
    private float zzf = 0.3f;
    private int zzg = 5;
    private float zzh = 0.5f;
    private int zzi = 1;
    private boolean zzj = true;
    private float zzk = 0.85f;
    private boolean zzl = true;
    private float zzm;

    static {
        zzby zzbyVar = new zzby();
        zzb = zzbyVar;
        zzbel.zzR(zzby.class, zzbyVar);
    }

    private zzby() {
    }

    public static zzbw zza() {
        return (zzbw) zzb.zzB();
    }

    static /* synthetic */ void zzd(zzby zzbyVar, float f) {
        zzbyVar.zzd |= 64;
        zzbyVar.zzk = 0.0f;
    }

    static /* synthetic */ void zze(zzby zzbyVar, boolean z) {
        zzbyVar.zzd |= 128;
        zzbyVar.zzl = false;
    }

    static /* synthetic */ void zzf(zzby zzbyVar, int i) {
        zzbyVar.zzd |= 4;
        zzbyVar.zzg = i;
    }

    static /* synthetic */ void zzg(zzby zzbyVar, float f) {
        zzbyVar.zzd |= 8;
        zzbyVar.zzh = 0.2f;
    }

    static /* synthetic */ void zzh(zzby zzbyVar, int i) {
        zzbyVar.zzi = 2;
        zzbyVar.zzd |= 16;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\t\u0000\u0001\u0001\u0011\t\u0000\u0000\u0000\u0001င\u0000\u0005ခ\u0001\u0006င\u0002\u0007ခ\u0003\f᠌\u0004\u000eဇ\u0005\u000fခ\u0006\u0010ဇ\u0007\u0011ခ\b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzbx.zza, "zzj", "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzby();
        }
        zzbv zzbvVar = null;
        if (i2 == 4) {
            return new zzbw(zzbvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
