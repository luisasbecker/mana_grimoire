package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuthProvider;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwa {
    private static zzwa zzd;
    private final Executor zze;
    private final Executor zzf;
    private final zzuk zzg;
    private final zzvu zzh;
    private volatile zzat zzi;
    private volatile zzat zzj;
    private final Map zzk;
    private final zzwf zzl;
    private final zzwd zzm;
    private String zzn;
    private static final ExecutorService zzb = Executors.newSingleThreadExecutor();
    private static final ExecutorService zzc = Executors.newSingleThreadExecutor();
    public static final long zza = TimeUnit.HOURS.toSeconds(12);

    private zzwa(Context context, zzuk zzukVar, zzwd zzwdVar, zzuj zzujVar) {
        ExecutorService executorService = zzb;
        ExecutorService executorService2 = zzc;
        this.zzk = new TreeMap();
        context.getApplicationContext();
        this.zzg = zzukVar;
        this.zze = executorService;
        this.zzf = executorService2;
        this.zzm = zzwdVar;
        this.zzh = new zzvu(context, zzujVar.zzb(), zzujVar.zza(), FirebaseAuthProvider.PROVIDER_ID, 5L, 5L, zzwdVar);
        this.zzl = new zzwf(context);
    }

    public static synchronized zzwa zzf(Context context) {
        if (zzd == null) {
            zzd = new zzwa(context, zzuk.zzb(context), new zzwd(context), zzur.zza);
        }
        return zzd;
    }

    private final Pair zzl(zzum zzumVar, boolean z) {
        zzvt zzvtVarZza = this.zzl.zza(zzumVar);
        if (zzvtVarZza == null) {
            return null;
        }
        JSONObject jSONObjectZzc = zzvtVarZza.zzc();
        try {
            zzat zzatVarZzm = zzm(jSONObjectZzc);
            this.zzj = zzatVarZzm;
            if (z) {
                zzum zzumVar2 = new zzum();
                zzumVar2.zzg();
                this.zzi = this.zzj;
                zzumVar2.zze();
                this.zzm.zzb(zzumVar2);
            }
            zzumVar.zzh();
            return Pair.create(zzatVarZzm, zzvtVarZza.zzb());
        } catch (JSONException e) {
            zzumVar.zzc(zzsw.FILE_READ_RETURNED_MALFORMED_DATA);
            Log.e("MLKit RemoteConfigRestC", "Saved remote config setting has invalid format: ".concat(String.valueOf(String.valueOf(jSONObjectZzc))), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzat zzm(JSONObject jSONObject) throws JSONException {
        String string;
        zzvx zzvxVar = new zzvx(jSONObject);
        zzas zzasVar = new zzas();
        Iterator<String> itKeys = zzvxVar.zza.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                String string2 = jSONObject.getString(next);
                if (string2 == null) {
                    string = null;
                } else if (string2.isEmpty()) {
                    string = "";
                } else {
                    string = new JSONObject("{ \"value\": " + string2 + " }").getString("value");
                }
                zzasVar.zza(next, string);
            } catch (JSONException e) {
                Log.e("MLKit RemoteConfigRestC", "Getting JSON string value for remote config key " + next + " failed", e);
                throw e;
            }
        }
        return zzasVar.zzb();
    }

    public final Task zza(final long j) {
        final Date date = new Date(System.currentTimeMillis());
        final zzum zzumVar = new zzum();
        zzumVar.zzg();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final boolean z = false;
        this.zzf.execute(new Runnable(date, j, zzumVar, z, taskCompletionSource) { // from class: com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzvy
            public final /* synthetic */ Date zzb;
            public final /* synthetic */ long zzc;
            public final /* synthetic */ zzum zzd;
            public final /* synthetic */ TaskCompletionSource zze;

            {
                this.zze = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzi(this.zzb, this.zzc, this.zzd, false, this.zze);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final Task zzb() {
        final zzum zzumVar = new zzum();
        zzumVar.zzg();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final boolean z = true;
        this.zze.execute(new Runnable(zzumVar, z, taskCompletionSource) { // from class: com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzvw
            public final /* synthetic */ zzum zzb;
            public final /* synthetic */ TaskCompletionSource zzc;

            {
                this.zzc = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzj(this.zzb, true, this.zzc);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final String zzh(String str) {
        String str2;
        zzat zzatVar = this.zzi;
        if (zzatVar != null && zzatVar.containsKey("vision_object_detection_enable_acceleration")) {
            return (String) zzatVar.get("vision_object_detection_enable_acceleration");
        }
        synchronized (this.zzk) {
            str2 = (String) this.zzk.get("vision_object_detection_enable_acceleration");
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008c A[Catch: all -> 0x009b, zzwc | InterruptedException | RuntimeException -> 0x009d, InterruptedException -> 0x009f, RuntimeException -> 0x00a1, TryCatch #2 {all -> 0x009b, blocks: (B:3:0x0003, B:11:0x0032, B:12:0x003c, B:14:0x0057, B:15:0x005d, B:20:0x008c, B:22:0x0097, B:21:0x0092, B:17:0x007f, B:6:0x000c, B:8:0x002a, B:31:0x00a2), top: B:36:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0092 A[Catch: all -> 0x009b, zzwc | InterruptedException | RuntimeException -> 0x009d, InterruptedException -> 0x009f, RuntimeException -> 0x00a1, TryCatch #2 {all -> 0x009b, blocks: (B:3:0x0003, B:11:0x0032, B:12:0x003c, B:14:0x0057, B:15:0x005d, B:20:0x008c, B:22:0x0097, B:21:0x0092, B:17:0x007f, B:6:0x000c, B:8:0x002a, B:31:0x00a2), top: B:36:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final /* synthetic */ void zzi(Date date, long j, zzum zzumVar, boolean z, TaskCompletionSource taskCompletionSource) {
        zzat zzatVarZzb;
        zzvz zzvzVar;
        try {
            try {
                Pair pairZzl = zzl(zzumVar, false);
                if (pairZzl == null) {
                    zzatVarZzb = null;
                    if (zzatVarZzb == null) {
                        try {
                            Log.d("MLKit RemoteConfigRestC", "Getting installation id...");
                            this.zzg.zzd();
                            Log.d("MLKit RemoteConfigRestC", "Got installation id. Checking temporary token for expiry...");
                            String strZzc = this.zzg.zzc();
                            Log.d("MLKit RemoteConfigRestC", "Got valid temporary auth token. Fetching remote config...");
                            zzvzVar = new zzvz(this, strZzc, date, zzumVar);
                        } catch (IOException e) {
                            zzumVar.zzd(zzsw.UNKNOWN_ERROR);
                            Log.e("MLKit RemoteConfigRestC", "Initializing installation id failed", e);
                        }
                        if (zzwj.zza(zzvzVar)) {
                            zzatVarZzb = zzvzVar.zzb();
                            Log.d("MLKit RemoteConfigRestC", "writeAndSetFetchedConfig: ".concat(String.valueOf(String.valueOf(zzatVarZzb))));
                            this.zzl.zzb(zzvzVar.zzc(), zzumVar);
                            this.zzj = zzatVarZzb;
                        } else {
                            zzumVar.zzd(zzsw.RPC_EXPONENTIAL_BACKOFF_FAILED);
                            zzatVarZzb = null;
                        }
                    }
                    if (zzatVarZzb != null) {
                        Log.e("MLKit RemoteConfigRestC", "Remote config was null!");
                    } else {
                        Log.d("MLKit RemoteConfigRestC", "Got remote config.");
                    }
                    taskCompletionSource.setResult(null);
                } else {
                    zzatVarZzb = (zzat) pairZzl.first;
                    if (date.after(new Date(((Date) pairZzl.second).getTime() + TimeUnit.SECONDS.toMillis(j)))) {
                        Log.i("MLKit RemoteConfigRestC", "Saved remote config is past its expiration time.");
                        zzatVarZzb = null;
                    }
                    if (zzatVarZzb == null) {
                    }
                    if (zzatVarZzb != null) {
                    }
                    taskCompletionSource.setResult(null);
                }
            } finally {
                zzumVar.zze();
                this.zzm.zzc(zzumVar);
            }
        } catch (zzwc | InterruptedException | RuntimeException e2) {
            Log.e("MLKit RemoteConfigRestC", "Fetch failed", e2);
            taskCompletionSource.setException(e2);
        }
    }

    final /* synthetic */ void zzj(zzum zzumVar, boolean z, TaskCompletionSource taskCompletionSource) {
        try {
            try {
                if (zzl(zzumVar, true) == null) {
                    Log.w("MLKit RemoteConfigRestC", "Cached remote config was null!");
                } else {
                    Log.d("MLKit RemoteConfigRestC", "Loaded cached remote config.");
                }
                taskCompletionSource.setResult(null);
            } catch (RuntimeException e) {
                Log.e("MLKit RemoteConfigRestC", "Load failed", e);
                taskCompletionSource.setException(e);
            }
        } finally {
            zzumVar.zze();
            this.zzm.zze(zzumVar);
        }
    }

    public final void zzk(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzn = str;
    }
}
