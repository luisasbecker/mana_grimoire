package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbze extends zzbel implements zzbft {
    private static final zzbze zzb;
    private zzbet zzd = zzL();

    static {
        zzbze zzbzeVar = new zzbze();
        zzb = zzbzeVar;
        zzbel.zzR(zzbze.class, zzbzeVar);
    }

    private zzbze() {
    }

    public static zzbzd zzc() {
        return (zzbzd) zzb.zzB();
    }

    static /* synthetic */ void zzg(zzbze zzbzeVar, zzbzb zzbzbVar) {
        zzbzbVar.getClass();
        zzbet zzbetVar = zzbzeVar.zzd;
        if (!zzbetVar.zzc()) {
            zzbzeVar.zzd = zzbel.zzM(zzbetVar);
        }
        zzbzeVar.zzd.add(zzbzbVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzO(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzbzb.class});
        }
        if (i2 == 3) {
            return new zzbze();
        }
        zzbzc zzbzcVar = null;
        if (i2 == 4) {
            return new zzbzd(zzbzcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final List zzf() {
        return this.zzd;
    }
}
