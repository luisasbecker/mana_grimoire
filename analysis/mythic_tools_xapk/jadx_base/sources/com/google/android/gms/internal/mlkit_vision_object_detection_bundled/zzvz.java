package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import android.util.Log;
import java.net.HttpURLConnection;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvz implements zzwi {
    final /* synthetic */ zzwa zza;
    private final String zzb;
    private final Date zzc;
    private final zzum zzd;
    private zzat zze;
    private zzvt zzf;

    zzvz(zzwa zzwaVar, String str, Date date, zzum zzumVar) {
        this.zza = zzwaVar;
        this.zzb = str;
        this.zzc = date;
        this.zzd = zzumVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzwi
    public final boolean zza() throws zzwc {
        try {
            zzvu zzvuVar = this.zza.zzh;
            Log.d("MLKit RemoteConfigRestC", "Creating HTTP connection to remote config service");
            HttpURLConnection httpURLConnectionZzb = zzvuVar.zzb();
            zzwa zzwaVar = this.zza;
            zzvu zzvuVar2 = zzwaVar.zzh;
            String strZza = zzwaVar.zzg.zza().zza();
            String str = this.zzb;
            Date date = this.zzc;
            zzwa zzwaVar2 = this.zza;
            zzvv zzvvVarZza = zzvuVar2.zza(httpURLConnectionZzb, strZza, str, zzat.zzc(), null, zzat.zzc(), date, "o:a:mlkit:1.0.0", zzwaVar2.zzn, this.zzd);
            Log.d("MLKit RemoteConfigRestC", "Got FetchResponse");
            zzvt zzvtVarZza = zzvvVarZza.zza();
            this.zzf = zzvtVarZza;
            JSONObject jSONObjectZzc = zzvtVarZza.zzc();
            try {
                this.zze = zzwa.zzm(jSONObjectZzc);
                return true;
            } catch (JSONException e) {
                this.zzd.zzb(zzsw.RPC_RETURNED_MALFORMED_RESULT);
                Log.e("MLKit RemoteConfigRestC", "Fetched remote config setting has invalid format: ".concat(String.valueOf(String.valueOf(jSONObjectZzc))), e);
                return false;
            }
        } catch (zzwc e2) {
            Log.e("MLKit RemoteConfigRestC", "Creating HTTP connection to remote config service failed", e2);
            this.zzd.zzb(zzsw.NO_CONNECTION);
            return false;
        }
    }

    public final zzat zzb() {
        return this.zze;
    }

    public final zzvt zzc() {
        return this.zzf;
    }
}
