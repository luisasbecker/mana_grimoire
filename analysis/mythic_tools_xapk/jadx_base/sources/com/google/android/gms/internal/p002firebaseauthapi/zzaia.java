package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.autofill.HintConstants;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaia {
    private List<zzaib> zza;

    public zzaia() {
        this.zza = new ArrayList();
    }

    private zzaia(List<zzaib> list) {
        if (list.isEmpty()) {
            this.zza = Collections.emptyList();
        } else {
            this.zza = Collections.unmodifiableList(list);
        }
    }

    public static zzaia zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new zzaia(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(jSONObject == null ? new zzaib() : new zzaib(Strings.emptyToNull(jSONObject.optString("federatedId")), Strings.emptyToNull(jSONObject.optString("displayName")), Strings.emptyToNull(jSONObject.optString("photoUrl")), Strings.emptyToNull(jSONObject.optString("providerId")), null, Strings.emptyToNull(jSONObject.optString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER)), Strings.emptyToNull(jSONObject.optString("email"))));
        }
        return new zzaia(arrayList);
    }

    public final List<zzaib> zza() {
        return this.zza;
    }
}
