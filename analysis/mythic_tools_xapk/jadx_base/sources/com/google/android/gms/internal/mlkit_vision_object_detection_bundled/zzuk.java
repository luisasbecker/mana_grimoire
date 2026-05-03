package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzuk {
    private static zzuk zza;
    private final zzui zzb;
    private final zzup zzc;
    private final zzun zzd;
    private zzuq zze;

    public zzuk(Context context, zzuj zzujVar) {
        zzun zzunVar = new zzun(context);
        this.zzd = zzunVar;
        this.zzc = new zzup(context);
        this.zzb = new zzui(zzujVar, zzunVar);
    }

    public static synchronized zzuk zzb(Context context) {
        if (zza == null) {
            zza = new zzuk(context, zzur.zza);
        }
        return zza;
    }

    public final zzuf zza() {
        Preconditions.checkState(this.zze != null);
        return this.zze.zzb();
    }

    public final String zzc() throws InterruptedException {
        Preconditions.checkState(this.zze != null);
        Preconditions.checkState(this.zze != null);
        if (this.zze.zze()) {
            zzum zzumVar = new zzum();
            zzumVar.zzg();
            try {
                if (this.zzb.zzc(zzumVar)) {
                    this.zze = this.zzb.zza();
                }
            } finally {
                zzumVar.zze();
                this.zzd.zza(zzpb.INSTALLATION_ID_REFRESH_TEMPORARY_TOKEN, zzumVar);
            }
        }
        Preconditions.checkState(this.zze != null);
        return this.zze.zzd();
    }

    public final void zzd() throws InterruptedException, IOException {
        zzun zzunVar;
        zzum zzumVar = new zzum();
        zzumVar.zzg();
        try {
            zzuq zzuqVarZza = this.zzc.zza(zzumVar);
            if (zzuqVarZza != null) {
                this.zze = zzuqVarZza;
            } else {
                final zzum zzumVar2 = new zzum();
                zzumVar2.zzg();
                try {
                    int i = zzul.zzb;
                    byte[] bArr = new byte[17];
                    zzul.zza.nextBytes(bArr);
                    bArr[0] = (byte) ((bArr[0] & Ascii.SI) | 112);
                    String strSubstring = Base64.encodeToString(bArr, 11).substring(0, 22);
                    Log.d("MLKitInstallationIdGenerator", "Generated installation id: ".concat(String.valueOf(strSubstring)));
                    final zzuf zzufVar = new zzuf(strSubstring);
                    final zzui zzuiVar = this.zzb;
                    if (zzwj.zza(new zzwi() { // from class: com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzuh
                        @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzwi
                        public final boolean zza() {
                            return zzuiVar.zzb(zzufVar, zzumVar2);
                        }
                    })) {
                        zzuq zzuqVarZza2 = this.zzb.zza();
                        this.zze = zzuqVarZza2;
                        if (zzuqVarZza2 != null) {
                            this.zzc.zzc(zzuqVarZza2, zzumVar2);
                        }
                        zzumVar2.zze();
                        zzunVar = this.zzd;
                    } else {
                        zzumVar2.zzd(zzsw.RPC_EXPONENTIAL_BACKOFF_FAILED);
                        zzumVar2.zzd(zzsw.RPC_ERROR);
                        zzumVar2.zze();
                        zzunVar = this.zzd;
                    }
                    zzunVar.zza(zzpb.INSTALLATION_ID_REGISTER_NEW_ID, zzumVar2);
                } catch (Throwable th) {
                    zzumVar2.zze();
                    this.zzd.zza(zzpb.INSTALLATION_ID_REGISTER_NEW_ID, zzumVar2);
                    throw th;
                }
            }
        } finally {
            zzumVar.zze();
            this.zzd.zza(zzpb.INSTALLATION_ID_INIT, zzumVar);
        }
    }
}
