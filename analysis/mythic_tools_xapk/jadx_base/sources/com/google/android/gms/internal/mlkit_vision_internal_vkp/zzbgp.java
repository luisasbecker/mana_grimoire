package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbgp extends zzbgw {
    zzbgp() {
        super(null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbgw
    public final void zza() {
        if (!zzj()) {
            for (int i = 0; i < zzc(); i++) {
                ((zzbdz) ((zzbgq) zzg(i)).zza()).zzg();
            }
            Iterator it = zzd().iterator();
            while (it.hasNext()) {
                ((zzbdz) ((Map.Entry) it.next()).getKey()).zzg();
            }
        }
        super.zza();
    }
}
