package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzayn {
    private static zzayn zza;

    private zzayn() {
    }

    public static synchronized zzayn zza() {
        if (zza == null) {
            zza = new zzayn();
        }
        return zza;
    }
}
