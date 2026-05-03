package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzvs {
    private JSONObject zza = new JSONObject();
    private Date zzb = zzvt.zza;
    private JSONArray zzc = new JSONArray();

    private zzvs() {
    }

    /* synthetic */ zzvs(zzvr zzvrVar) {
    }

    public final zzvs zza(JSONObject jSONObject) {
        try {
            this.zza = new JSONObject(jSONObject.toString());
        } catch (JSONException unused) {
        }
        return this;
    }

    public final zzvs zzb(JSONArray jSONArray) {
        try {
            this.zzc = new JSONArray(jSONArray.toString());
        } catch (JSONException unused) {
        }
        return this;
    }

    public final zzvs zzc(Date date) {
        this.zzb = date;
        return this;
    }

    public final zzvt zzd() throws JSONException {
        return new zzvt(this.zza, this.zzb, this.zzc);
    }
}
