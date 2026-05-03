package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdd extends zzcq {
    zzdd() {
    }

    private static final zzch zzd(zzdg zzdgVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 5) {
            return new zzcn(zzdgVar.zze());
        }
        if (i2 == 6) {
            return new zzcn(new zzcs(zzdgVar.zze()));
        }
        if (i2 == 7) {
            return new zzcn(Boolean.valueOf(zzdgVar.zzm()));
        }
        if (i2 != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(zzdh.zza(i)));
        }
        zzdgVar.zzj();
        return zzcj.zza;
    }

    private static final zzch zze(zzdg zzdgVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 0) {
            zzdgVar.zzf();
            return new zzcg();
        }
        if (i2 != 2) {
            return null;
        }
        zzdgVar.zzg();
        return new zzck();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzcq
    public final /* bridge */ /* synthetic */ Object zza(zzdg zzdgVar) throws IOException {
        int iZzn = zzdgVar.zzn();
        zzch zzchVarZze = zze(zzdgVar, iZzn);
        if (zzchVarZze == null) {
            return zzd(zzdgVar, iZzn);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (zzdgVar.zzl()) {
                String strZzd = zzchVarZze instanceof zzck ? zzdgVar.zzd() : null;
                int iZzn2 = zzdgVar.zzn();
                zzch zzchVarZze2 = zze(zzdgVar, iZzn2);
                zzch zzchVarZzd = zzchVarZze2 == null ? zzd(zzdgVar, iZzn2) : zzchVarZze2;
                if (zzchVarZze instanceof zzcg) {
                    ((zzcg) zzchVarZze).zza(zzchVarZzd);
                } else {
                    ((zzck) zzchVarZze).zze(strZzd, zzchVarZzd);
                }
                if (zzchVarZze2 != null) {
                    arrayDeque.addLast(zzchVarZze);
                    zzchVarZze = zzchVarZzd;
                }
            } else {
                if (zzchVarZze instanceof zzcg) {
                    zzdgVar.zzh();
                } else {
                    zzdgVar.zzi();
                }
                if (arrayDeque.isEmpty()) {
                    return zzchVarZze;
                }
                zzchVarZze = (zzch) arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzcq
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final void zzb(zzdi zzdiVar, zzch zzchVar) throws IOException {
        if (zzchVar == null || (zzchVar instanceof zzcj)) {
            zzdiVar.zzf();
            return;
        }
        if (zzchVar instanceof zzcn) {
            zzcn zzcnVar = (zzcn) zzchVar;
            if (zzcnVar.zzj()) {
                zzdiVar.zzg(zzcnVar.zzd());
                return;
            } else if (zzcnVar.zzi()) {
                zzdiVar.zzi(zzcnVar.zzh());
                return;
            } else {
                zzdiVar.zzh(zzcnVar.zze());
                return;
            }
        }
        if (zzchVar instanceof zzcg) {
            zzdiVar.zza();
            Iterator it = ((zzcg) zzchVar).iterator();
            while (it.hasNext()) {
                zzb(zzdiVar, (zzch) it.next());
            }
            zzdiVar.zzc();
            return;
        }
        if (!(zzchVar instanceof zzck)) {
            throw new IllegalArgumentException("Couldn't write ".concat(String.valueOf(String.valueOf(zzchVar.getClass()))));
        }
        zzdiVar.zzb();
        for (Map.Entry entry : zzchVar.zzb().zzd()) {
            zzdiVar.zze((String) entry.getKey());
            zzb(zzdiVar, (zzch) entry.getValue());
        }
        zzdiVar.zzd();
    }
}
