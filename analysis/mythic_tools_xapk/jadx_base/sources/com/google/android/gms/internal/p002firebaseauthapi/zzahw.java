package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import com.facebook.AuthenticationTokenClaims;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzahw {
    private Long zza;
    private Long zzb;

    public static zzahw zza(String str) throws UnsupportedEncodingException {
        try {
            zzahw zzahwVar = new zzahw();
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_ISS);
            jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_AUD);
            jSONObject.optString(AuthenticationTokenClaims.JSON_KEY_SUB);
            zzahwVar.zza = Long.valueOf(jSONObject.optLong(AuthenticationTokenClaims.JSON_KEY_IAT));
            zzahwVar.zzb = Long.valueOf(jSONObject.optLong(AuthenticationTokenClaims.JSON_KEY_EXP));
            jSONObject.optBoolean("is_anonymous");
            return zzahwVar;
        } catch (JSONException e) {
            if (Log.isLoggable("JwtToken", 3)) {
                Log.d("JwtToken", "Failed to read JwtToken from JSONObject. " + String.valueOf(e));
            }
            throw new UnsupportedEncodingException("Failed to read JwtToken from JSONObject. " + String.valueOf(e));
        }
    }

    public final Long zza() {
        return this.zzb;
    }

    public final Long zzb() {
        return this.zza;
    }
}
