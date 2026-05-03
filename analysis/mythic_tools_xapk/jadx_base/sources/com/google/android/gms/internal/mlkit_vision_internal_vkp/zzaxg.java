package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaxg {
    private static zzaxg zza;
    private final zzaxe zzb;
    private final zzaxl zzc;
    private final zzaxj zzd;
    private zzaxm zze;

    public zzaxg(Context context, zzaxf zzaxfVar) {
        zzaxj zzaxjVar = new zzaxj(context);
        this.zzd = zzaxjVar;
        this.zzc = new zzaxl(context);
        this.zzb = new zzaxe(zzaxfVar, zzaxjVar);
    }

    public static synchronized zzaxg zzb(Context context) {
        if (zza == null) {
            zza = new zzaxg(context, zzaxn.zza);
        }
        return zza;
    }

    public final zzaxc zza() {
        Preconditions.checkState(this.zze != null);
        return this.zze.zzb();
    }

    public final void zzc() throws InterruptedException, IOException {
        zzaxj zzaxjVar;
        zzaxi zzaxiVar = new zzaxi();
        zzaxiVar.zzg();
        try {
            zzaxm zzaxmVarZza = this.zzc.zza(zzaxiVar);
            if (zzaxmVarZza != null) {
                this.zze = zzaxmVarZza;
            } else {
                final zzaxi zzaxiVar2 = new zzaxi();
                zzaxiVar2.zzg();
                try {
                    int i = zzaxh.zzb;
                    byte[] bArr = new byte[17];
                    zzaxh.zza.nextBytes(bArr);
                    bArr[0] = (byte) ((bArr[0] & Ascii.SI) | 112);
                    String strSubstring = Base64.encodeToString(bArr, 11).substring(0, 22);
                    Log.d("MLKitInstallationIdGenerator", "Generated installation id: ".concat(String.valueOf(strSubstring)));
                    final zzaxc zzaxcVar = new zzaxc(strSubstring);
                    final zzaxe zzaxeVar = this.zzb;
                    if (zzaym.zza(new zzayl() { // from class: com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxd
                        @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzayl
                        public final boolean zzb() {
                            return zzaxeVar.zzb(zzaxcVar, zzaxiVar2);
                        }
                    })) {
                        zzaxm zzaxmVarZza2 = this.zzb.zza();
                        this.zze = zzaxmVarZza2;
                        if (zzaxmVarZza2 != null) {
                            this.zzc.zzc(zzaxmVarZza2, zzaxiVar2);
                        }
                        zzaxiVar2.zze();
                        zzaxjVar = this.zzd;
                    } else {
                        zzaxiVar2.zzd(zzave.RPC_EXPONENTIAL_BACKOFF_FAILED);
                        zzaxiVar2.zzd(zzave.RPC_ERROR);
                        zzaxiVar2.zze();
                        zzaxjVar = this.zzd;
                    }
                    zzaxjVar.zza(zzary.INSTALLATION_ID_REGISTER_NEW_ID, zzaxiVar2);
                } catch (Throwable th) {
                    zzaxiVar2.zze();
                    this.zzd.zza(zzary.INSTALLATION_ID_REGISTER_NEW_ID, zzaxiVar2);
                    throw th;
                }
            }
        } finally {
            zzaxiVar.zze();
            this.zzd.zza(zzary.INSTALLATION_ID_INIT, zzaxiVar);
        }
    }
}
