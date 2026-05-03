package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbdx extends zzbdw {
    zzbdx() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdw
    final void zza(Object obj) {
        ((zzbeh) obj).zzb.zzh();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdw
    final void zzb(zzbge zzbgeVar, Object obj, zzbdv zzbdvVar, zzbea zzbeaVar) throws IOException {
        zzbej zzbejVar = (zzbej) obj;
        zzbeaVar.zzj(zzbejVar.zzb, zzbgeVar.zzs(zzbejVar.zza.getClass(), zzbdvVar));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdw
    final void zzc(zzbhs zzbhsVar, Map.Entry entry) throws IOException {
        zzbhq zzbhqVar = zzbhq.DOUBLE;
        switch (r3.zzb) {
            case DOUBLE:
                zzbhsVar.zzf(32149011, ((Double) entry.getValue()).doubleValue());
                break;
            case FLOAT:
                zzbhsVar.zzo(32149011, ((Float) entry.getValue()).floatValue());
                break;
            case INT64:
                zzbhsVar.zzt(32149011, ((Long) entry.getValue()).longValue());
                break;
            case UINT64:
                zzbhsVar.zzL(32149011, ((Long) entry.getValue()).longValue());
                break;
            case INT32:
                zzbhsVar.zzr(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case FIXED64:
                zzbhsVar.zzm(32149011, ((Long) entry.getValue()).longValue());
                break;
            case FIXED32:
                zzbhsVar.zzk(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case BOOL:
                zzbhsVar.zzb(32149011, ((Boolean) entry.getValue()).booleanValue());
                break;
            case STRING:
                zzbhsVar.zzH(32149011, (String) entry.getValue());
                break;
            case GROUP:
                zzbhsVar.zzq(32149011, entry.getValue(), zzbgb.zza().zzb(entry.getValue().getClass()));
                break;
            case MESSAGE:
                zzbhsVar.zzw(32149011, entry.getValue(), zzbgb.zza().zzb(entry.getValue().getClass()));
                break;
            case BYTES:
                zzbhsVar.zzd(32149011, (zzbdd) entry.getValue());
                break;
            case UINT32:
                zzbhsVar.zzJ(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case ENUM:
                zzbhsVar.zzr(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case SFIXED32:
                zzbhsVar.zzy(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case SFIXED64:
                zzbhsVar.zzA(32149011, ((Long) entry.getValue()).longValue());
                break;
            case SINT32:
                zzbhsVar.zzC(32149011, ((Integer) entry.getValue()).intValue());
                break;
            case SINT64:
                zzbhsVar.zzE(32149011, ((Long) entry.getValue()).longValue());
                break;
        }
    }
}
