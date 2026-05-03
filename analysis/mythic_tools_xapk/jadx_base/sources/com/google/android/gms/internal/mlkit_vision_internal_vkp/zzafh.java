package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafh extends zzaeu {
    zzafh() {
    }

    private static final zzael zzd(zzafk zzafkVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 5) {
            return new zzaer(zzafkVar.zze());
        }
        if (i2 == 6) {
            return new zzaer(new zzaew(zzafkVar.zze()));
        }
        if (i2 == 7) {
            return new zzaer(Boolean.valueOf(zzafkVar.zzm()));
        }
        if (i2 != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(zzafl.zza(i)));
        }
        zzafkVar.zzj();
        return zzaen.zza;
    }

    private static final zzael zze(zzafk zzafkVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 0) {
            zzafkVar.zzf();
            return new zzaek();
        }
        if (i2 != 2) {
            return null;
        }
        zzafkVar.zzg();
        return new zzaeo();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaeu
    public final /* bridge */ /* synthetic */ Object zza(zzafk zzafkVar) throws IOException {
        int iZzn = zzafkVar.zzn();
        zzael zzaelVarZze = zze(zzafkVar, iZzn);
        if (zzaelVarZze == null) {
            return zzd(zzafkVar, iZzn);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (zzafkVar.zzl()) {
                String strZzd = zzaelVarZze instanceof zzaeo ? zzafkVar.zzd() : null;
                int iZzn2 = zzafkVar.zzn();
                zzael zzaelVarZze2 = zze(zzafkVar, iZzn2);
                zzael zzaelVarZzd = zzaelVarZze2 == null ? zzd(zzafkVar, iZzn2) : zzaelVarZze2;
                if (zzaelVarZze instanceof zzaek) {
                    ((zzaek) zzaelVarZze).zza(zzaelVarZzd);
                } else {
                    ((zzaeo) zzaelVarZze).zze(strZzd, zzaelVarZzd);
                }
                if (zzaelVarZze2 != null) {
                    arrayDeque.addLast(zzaelVarZze);
                    zzaelVarZze = zzaelVarZzd;
                }
            } else {
                if (zzaelVarZze instanceof zzaek) {
                    zzafkVar.zzh();
                } else {
                    zzafkVar.zzi();
                }
                if (arrayDeque.isEmpty()) {
                    return zzaelVarZze;
                }
                zzaelVarZze = (zzael) arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaeu
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final void zzb(zzafm zzafmVar, zzael zzaelVar) throws IOException {
        if (zzaelVar == null || (zzaelVar instanceof zzaen)) {
            zzafmVar.zzf();
            return;
        }
        if (zzaelVar instanceof zzaer) {
            zzaer zzaerVar = (zzaer) zzaelVar;
            if (zzaerVar.zzj()) {
                zzafmVar.zzg(zzaerVar.zzd());
                return;
            } else if (zzaerVar.zzi()) {
                zzafmVar.zzi(zzaerVar.zzh());
                return;
            } else {
                zzafmVar.zzh(zzaerVar.zze());
                return;
            }
        }
        if (zzaelVar instanceof zzaek) {
            zzafmVar.zza();
            Iterator it = ((zzaek) zzaelVar).iterator();
            while (it.hasNext()) {
                zzb(zzafmVar, (zzael) it.next());
            }
            zzafmVar.zzc();
            return;
        }
        if (!(zzaelVar instanceof zzaeo)) {
            throw new IllegalArgumentException("Couldn't write ".concat(String.valueOf(String.valueOf(zzaelVar.getClass()))));
        }
        zzafmVar.zzb();
        for (Map.Entry entry : zzaelVar.zzb().zzd()) {
            zzafmVar.zze((String) entry.getKey());
            zzb(zzafmVar, (zzael) entry.getValue());
        }
        zzafmVar.zzd();
    }
}
