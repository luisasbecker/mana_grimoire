package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzam extends zzbel implements zzbft {
    private static final zzam zzb;
    private int zzd;
    private String zze = "";
    private int zzf;

    static {
        zzam zzamVar = new zzam();
        zzb = zzamVar;
        zzbel.zzR(zzam.class, zzamVar);
    }

    private zzam() {
    }

    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzam();
        }
        zzak zzakVar = null;
        if (i2 == 4) {
            return new zzal(zzakVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final String zzd() {
        return this.zze;
    }
}
