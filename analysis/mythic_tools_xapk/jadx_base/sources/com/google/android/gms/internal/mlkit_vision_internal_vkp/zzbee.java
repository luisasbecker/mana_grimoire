package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbee implements zzbfq {
    private static final zzbee zza = new zzbee();

    private zzbee() {
    }

    public static zzbee zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfq
    public final zzbfp zzb(Class cls) {
        if (!zzbel.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzbfp) zzbel.zzE(cls.asSubclass(zzbel.class)).zzb(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfq
    public final boolean zzc(Class cls) {
        return zzbel.class.isAssignableFrom(cls);
    }
}
