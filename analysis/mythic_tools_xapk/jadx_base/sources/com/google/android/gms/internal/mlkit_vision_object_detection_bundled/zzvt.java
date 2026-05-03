package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvt {
    private static final Date zza = new Date(0);
    private final JSONObject zzb;
    private final JSONObject zzc;
    private final Date zzd;

    zzvt(JSONObject jSONObject, Date date, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("configs_key", jSONObject);
        jSONObject2.put("fetch_time_key", date.getTime());
        jSONObject2.put("abt_experiments_key", jSONArray);
        this.zzc = jSONObject;
        this.zzd = date;
        this.zzb = jSONObject2;
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Date zzb() {
        return this.zzd;
    }

    public final JSONObject zzc() {
        return this.zzc;
    }
}
