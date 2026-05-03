package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.collection.ArrayMap;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.firebase.FirebaseApp;
import com.revenuecat.purchases.common.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagl {
    private static final Map<String, zzagk> zza = new ArrayMap();
    private static final Map<String, List<WeakReference<zzagn>>> zzb = new ArrayMap();

    public static String zza(String str) {
        zzagk zzagkVar;
        Map<String, zzagk> map = zza;
        synchronized (map) {
            zzagkVar = map.get(str);
        }
        if (zzagkVar == null) {
            throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
        }
        return zza(zzagkVar.zzb(), zzagkVar.zza(), zzagkVar.zzb().contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) + "emulator/auth/handler";
    }

    private static String zza(String str, int i, boolean z) {
        return z ? "http://[" + str + "]:" + i + DomExceptionUtils.SEPARATOR : "http://" + str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i + DomExceptionUtils.SEPARATOR;
    }

    public static void zza(FirebaseApp firebaseApp, String str, int i) {
        String apiKey = firebaseApp.getOptions().getApiKey();
        Map<String, zzagk> map = zza;
        synchronized (map) {
            map.put(apiKey, new zzagk(str, i));
        }
        Map<String, List<WeakReference<zzagn>>> map2 = zzb;
        synchronized (map2) {
            if (map2.containsKey(apiKey)) {
                Iterator<WeakReference<zzagn>> it = map2.get(apiKey).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    zzagn zzagnVar = it.next().get();
                    if (zzagnVar != null) {
                        zzagnVar.zza();
                        z = true;
                    }
                }
                if (!z) {
                    zza.remove(apiKey);
                }
            }
        }
    }

    public static void zza(String str, zzagn zzagnVar) {
        Map<String, List<WeakReference<zzagn>>> map = zzb;
        synchronized (map) {
            if (map.containsKey(str)) {
                map.get(str).add(new WeakReference<>(zzagnVar));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new WeakReference<>(zzagnVar));
                map.put(str, arrayList);
            }
        }
    }

    public static boolean zza(FirebaseApp firebaseApp) {
        return zza.containsKey(firebaseApp.getOptions().getApiKey());
    }

    public static String zzb(String str) {
        zzagk zzagkVar;
        String str2;
        Map<String, zzagk> map = zza;
        synchronized (map) {
            zzagkVar = map.get(str);
        }
        if (zzagkVar != null) {
            str2 = "" + zza(zzagkVar.zzb(), zzagkVar.zza(), zzagkVar.zzb().contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR));
        } else {
            str2 = "https://";
        }
        return str2 + "www.googleapis.com/identitytoolkit/v3/relyingparty";
    }

    public static String zzc(String str) {
        zzagk zzagkVar;
        String str2;
        Map<String, zzagk> map = zza;
        synchronized (map) {
            zzagkVar = map.get(str);
        }
        if (zzagkVar != null) {
            str2 = "" + zza(zzagkVar.zzb(), zzagkVar.zza(), zzagkVar.zzb().contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR));
        } else {
            str2 = "https://";
        }
        return str2 + "identitytoolkit.googleapis.com/v2";
    }

    public static String zzd(String str) {
        zzagk zzagkVar;
        String str2;
        Map<String, zzagk> map = zza;
        synchronized (map) {
            zzagkVar = map.get(str);
        }
        if (zzagkVar != null) {
            str2 = "" + zza(zzagkVar.zzb(), zzagkVar.zza(), zzagkVar.zzb().contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR));
        } else {
            str2 = "https://";
        }
        return str2 + "securetoken.googleapis.com/v1";
    }
}
