package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.common.net.HttpHeaders;
import com.google.firebase.auth.FirebaseAuthProvider;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvu {
    private static final Pattern zza = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    private final Context zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final zzwd zzf;

    public zzvu(Context context, String str, String str2, String str3, long j, long j2, zzwd zzwdVar) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = str2;
        Matcher matcher = zza.matcher(str);
        this.zze = matcher.matches() ? matcher.group(1) : null;
        this.zzf = zzwdVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a9 A[LOOP:0: B:12:0x00a3->B:14:0x00a9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final zzvv zza(HttpURLConnection httpURLConnection, String str, String str2, Map map, String str3, Map map2, Date date, String str4, String str5, zzum zzumVar) throws zzwc {
        String strBytesToStringUppercase;
        String str6;
        String str7;
        InputStream errorStream;
        JSONObject jSONObject;
        JSONArray jSONArray;
        zzvv zzvvVarZzc;
        PackageInfo packageInfo;
        byte[] packageCertificateHashBytes;
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout((int) TimeUnit.SECONDS.toMillis(5L));
        httpURLConnection.setReadTimeout((int) TimeUnit.SECONDS.toMillis(5L));
        httpURLConnection.setRequestProperty(HttpHeaders.IF_NONE_MATCH, null);
        httpURLConnection.setRequestProperty("X-Goog-Api-Key", this.zzd);
        httpURLConnection.setRequestProperty("X-Android-Package", this.zzb.getPackageName());
        try {
            Context context = this.zzb;
            packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("MLKitRemoteConfigFetch", "No such package: ".concat(String.valueOf(this.zzb.getPackageName())), e);
        }
        if (packageCertificateHashBytes == null) {
            Log.e("MLKitRemoteConfigFetch", "Could not get fingerprint hash for package: " + this.zzb.getPackageName());
            strBytesToStringUppercase = null;
            httpURLConnection.setRequestProperty("X-Android-Cert", strBytesToStringUppercase);
            httpURLConnection.setRequestProperty("X-Google-GFE-Can-Retry", "yes");
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
            for (Map.Entry entry : ((zzat) map2).entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            if (Log.isLoggable("MLKitRemoteConfigFetch", 3)) {
                for (Map.Entry<String, List<String>> entry2 : httpURLConnection.getRequestProperties().entrySet()) {
                    String key = entry2.getKey();
                    if (!zza.zza(key).contains("api-key") && !zza.zza(key).contains("android-cert")) {
                        Iterator<String> it = entry2.getValue().iterator();
                        while (it.hasNext()) {
                            Log.d("MLKitRemoteConfigFetch", "HTTP Request Header: " + key + ": " + it.next());
                        }
                    }
                }
            }
            HashMap map3 = new HashMap();
            if (str != null) {
                throw new zzwb("Fetch failed: Firebase instance id is null.");
            }
            map3.put("appInstanceId", str);
            map3.put("appInstanceIdToken", str2);
            map3.put("appId", this.zzc);
            Locale locale = this.zzb.getResources().getConfiguration().locale;
            map3.put("countryCode", locale.getCountry());
            map3.put("languageCode", locale.toString());
            map3.put("platformVersion", Integer.toString(Build.VERSION.SDK_INT));
            map3.put("timeZone", TimeZone.getDefault().getID());
            try {
                packageInfo = this.zzb.getPackageManager().getPackageInfo(this.zzb.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (packageInfo != null) {
                str7 = packageInfo.versionName;
                str6 = str5;
            } else {
                str6 = str5;
                str7 = null;
            }
            String str8 = String.format("%s-MLKit-%s", str7, str6);
            Log.d("MLKitRemoteConfigFetch", "APP_VERSION: ".concat(String.valueOf(str8)));
            map3.put("appVersion", str8);
            map3.put("packageName", this.zzb.getPackageName());
            map3.put("sdkVersion", "o:a:mlkit:1.0.0");
            map3.put("analyticsUserProperties", new JSONObject(map));
            JSONObject jSONObject2 = new JSONObject(map3);
            if (Log.isLoggable("MLKitRemoteConfigFetch", 3)) {
                JSONObject jSONObject3 = new JSONObject();
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject3.put(next, jSONObject2.get(next));
                    } catch (JSONException e2) {
                        throw new IllegalStateException("shallowCopyJsonObject: concurrent mutation?", e2);
                    }
                }
                jSONObject3.remove("appInstanceIdToken");
                Log.d("MLKitRemoteConfigFetch", "HTTP Request Body: ".concat(jSONObject3.toString()));
            }
            byte[] bytes = jSONObject2.toString().getBytes(StandardCharsets.UTF_8);
            zzum zzumVar2 = new zzum();
            zzumVar2.zzg();
            try {
                Log.d("MLKitRemoteConfigFetch", "Getting remote config");
                Log.d("MLKitRemoteConfigFetch", "Connecting: ".concat(String.valueOf(String.valueOf(httpURLConnection))));
                try {
                    httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    try {
                        zzumVar2.zzf(responseCode);
                        Log.d("MLKitRemoteConfigFetch", "Remote config: got response code " + responseCode);
                        if (responseCode != 200) {
                            zzumVar2.zzd(zzsw.RPC_ERROR);
                            zzumVar.zzb(zzsw.RPC_ERROR);
                            if (Log.isLoggable("MLKitRemoteConfigFetch", 4)) {
                                for (Map.Entry<String, List<String>> entry3 : httpURLConnection.getHeaderFields().entrySet()) {
                                    for (String str9 : entry3.getValue()) {
                                        Log.i("MLKitRemoteConfigFetch", "HTTP Response Header: " + entry3.getKey() + ": " + str9);
                                    }
                                }
                            }
                            if (Log.isLoggable("MLKitRemoteConfigFetch", 5) && (errorStream = httpURLConnection.getErrorStream()) != null) {
                                Scanner scannerUseDelimiter = new Scanner(errorStream).useDelimiter("\\A");
                                if (scannerUseDelimiter.hasNext()) {
                                    Log.w("MLKitRemoteConfigFetch", "HTTP Error Stream: ".concat(String.valueOf(scannerUseDelimiter.next())));
                                }
                            }
                            try {
                                throw new zzwg(responseCode, httpURLConnection.getResponseMessage());
                            } catch (IOException e3) {
                                throw new zzwg(responseCode, "<error reading HTTP response>", e3);
                            }
                        }
                        if (Log.isLoggable("MLKitRemoteConfigFetch", 3)) {
                            for (Map.Entry<String, List<String>> entry4 : httpURLConnection.getHeaderFields().entrySet()) {
                                for (String str10 : entry4.getValue()) {
                                    Log.d("MLKitRemoteConfigFetch", "HTTP Response Header: " + entry4.getKey() + ": " + str10);
                                }
                            }
                        }
                        String headerField = httpURLConnection.getHeaderField(HttpHeaders.ETAG);
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                int i = bufferedReader.read();
                                if (i == -1) {
                                    break;
                                }
                                sb.append((char) i);
                            }
                            JSONObject jSONObject4 = new JSONObject(sb.toString());
                            Log.d("MLKitRemoteConfigFetch", "Remote config: got response ETag: " + headerField);
                            Log.d("MLKitRemoteConfigFetch", "Remote config: got response: " + jSONObject4.toString());
                            if (jSONObject4.get(ServerProtocol.DIALOG_PARAM_STATE).equals("NO_CHANGE")) {
                                zzvvVarZzc = zzvv.zzb(date);
                            } else {
                                try {
                                    zzvs zzvsVar = new zzvs(null);
                                    zzvsVar.zzc(date);
                                    try {
                                        jSONObject = jSONObject4.getJSONObject("entries");
                                    } catch (JSONException unused2) {
                                        jSONObject = null;
                                    }
                                    if (jSONObject != null) {
                                        zzvsVar.zza(jSONObject);
                                    }
                                    try {
                                        jSONArray = jSONObject4.getJSONArray("experimentDescriptions");
                                    } catch (JSONException unused3) {
                                        jSONArray = null;
                                    }
                                    if (jSONArray != null) {
                                        zzvsVar.zzb(jSONArray);
                                    }
                                    zzvvVarZzc = zzvv.zzc(zzvsVar.zzd(), headerField);
                                } catch (JSONException e4) {
                                    zzumVar2.zzd(zzsw.RPC_RETURNED_INVALID_RESULT);
                                    zzumVar.zzb(zzsw.RPC_RETURNED_INVALID_RESULT);
                                    throw new zzwb("Fetch failed: fetch response could not be parsed.", e4);
                                }
                            }
                            return zzvvVarZzc;
                        } catch (IOException e5) {
                            zzumVar2.zzd(zzsw.RPC_ERROR);
                            zzumVar.zzb(zzsw.RPC_ERROR);
                            throw new zzwb("The client had an error while calling the backend!", e5);
                        } catch (JSONException e6) {
                            zzumVar2.zzd(zzsw.RPC_RETURNED_MALFORMED_RESULT);
                            zzumVar.zzb(zzsw.RPC_RETURNED_MALFORMED_RESULT);
                            throw new zzwb("Error parsing the server output", e6);
                        }
                    } finally {
                        Log.d("MLKitRemoteConfigFetch", "Remote config: disconnecting...");
                        httpURLConnection.disconnect();
                        Log.d("MLKitRemoteConfigFetch", "Remote config: disconnected");
                    }
                } catch (IOException e7) {
                    zzumVar2.zzd(zzsw.NO_CONNECTION);
                    zzumVar.zzb(zzsw.NO_CONNECTION);
                    throw new zzwb("Error connecting to ".concat(String.valueOf(String.valueOf(httpURLConnection))), e7);
                }
            } finally {
                zzumVar2.zze();
                this.zzf.zzd(zzumVar2);
            }
        }
        strBytesToStringUppercase = Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
        httpURLConnection.setRequestProperty("X-Android-Cert", strBytesToStringUppercase);
        httpURLConnection.setRequestProperty("X-Google-GFE-Can-Retry", "yes");
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
        while (r0.hasNext()) {
        }
        if (Log.isLoggable("MLKitRemoteConfigFetch", 3)) {
        }
        HashMap map32 = new HashMap();
        if (str != null) {
        }
    }

    public final HttpURLConnection zzb() throws zzwc {
        try {
            return (HttpURLConnection) new URL(String.format("https://firebaseremoteconfig.googleapis.com/v1/projects/%s/namespaces/%s:fetch", this.zze, FirebaseAuthProvider.PROVIDER_ID)).openConnection();
        } catch (IOException e) {
            throw new zzwc(e.getMessage());
        }
    }
}
