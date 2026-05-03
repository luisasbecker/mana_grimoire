package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbfj implements zzbgn {
    private static final zzbfq zza = new zzbfh();
    private final zzbfq zzb;

    public zzbfj() {
        zzbfq zzbfqVar = zza;
        int i = zzbgb.zza;
        zzbfi zzbfiVar = new zzbfi(zzbee.zza(), zzbfqVar);
        byte[] bArr = zzbeu.zzb;
        this.zzb = zzbfiVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbgn
    public final zzbgm zza(Class cls) {
        int i = zzbgo.zza;
        if (!zzbel.class.isAssignableFrom(cls)) {
            int i2 = zzbgb.zza;
        }
        zzbfp zzbfpVarZzb = this.zzb.zzb(cls);
        if (zzbfpVarZzb.zzb()) {
            int i3 = zzbgb.zza;
            return zzbfw.zzc(zzbgo.zzm(), zzbdy.zza(), zzbfpVarZzb.zza());
        }
        int i4 = zzbgb.zza;
        return zzbfv.zzm(cls, zzbfpVarZzb, zzbfz.zza(), zzbff.zza(), zzbgo.zzm(), zzbfpVarZzb.zzc() + (-1) != 1 ? zzbdy.zza() : null, zzbfo.zza());
    }
}
