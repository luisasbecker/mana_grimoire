package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbck;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdv;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbet;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbew;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbli;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd extends zzbel implements zzbft {
    private static final zzd zzb;
    private byte zze = 2;
    private zzbet zzd = zzL();

    static {
        zzd zzdVar = new zzd();
        zzb = zzdVar;
        zzbel.zzR(zzd.class, zzdVar);
    }

    private zzd() {
    }

    public static zzd zzd() {
        return zzb;
    }

    public static zzd zze(byte[] bArr, zzbdv zzbdvVar) throws zzbew {
        return (zzd) zzbel.zzH(zzb, bArr, zzbdvVar);
    }

    static /* synthetic */ void zzg(zzd zzdVar, Iterable iterable) {
        zzbet zzbetVar = zzdVar.zzd;
        if (!zzbetVar.zzc()) {
            zzdVar.zzd = zzbel.zzM(zzbetVar);
        }
        zzbck.zzu(iterable, zzdVar.zzd);
    }

    public final int zza() {
        return this.zzd.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzd", zzbli.class});
        }
        if (i2 == 3) {
            return new zzd();
        }
        zzb zzbVar = null;
        if (i2 == 4) {
            return new zzc(zzbVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final List zzf() {
        return this.zzd;
    }
}
