package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.util.Base64;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaxb implements zzawz {
    static final String zza;
    private final String zzb = zza;
    private final String zzc = "https://mobilemlaccelerationcompatibility.googleapis.com";

    static {
        byte[] bArrDecode = Base64.decode("opMaSwzKffHEPgAzu/wXmmAoBSQ+L5trn/RQom0", 3);
        byte[] bArrDecode2 = Base64.decode("oh/AACypu7EhHIzJlqtCgyEK8MToFuQ8E7pIO7A", 3);
        byte[] bArr = new byte[bArrDecode.length];
        for (int i = 0; i < bArrDecode.length; i++) {
            bArr[i] = (byte) (bArrDecode[i] ^ bArrDecode2[i]);
        }
        zza = Base64.encodeToString(bArr, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzawz
    public final zzbhx zza(zzaws zzawsVar, zzaxc zzaxcVar, String str, String str2, String str3, int i) throws zzaxa {
        String str4 = this.zzb;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.zzc + "/v1/advisor?alt=PROTO").openConnection();
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/x-protobuf");
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; utf-8");
                httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
                httpURLConnection.setRequestProperty("X-Goog-Api-Key", str4);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("installation_id", zzaxcVar.zza());
                    jSONObject.put("client", "MLKIT");
                    jSONObject.put("client_library", str);
                    jSONObject.put("client_library_version", str2);
                    JSONObject jSONObjectPut = new JSONObject().put("client_info", jSONObject);
                    zzbyv zzbyvVarZza = zzawsVar.zza();
                    zzbyy zzbyyVarZzg = zzbyvVarZza.zzg();
                    zzbys zzbysVarZzc = zzbyvVarZza.zzc();
                    JSONObject jSONObjectPut2 = jSONObjectPut.put("android_info", new JSONObject().put("product", new JSONObject().put(AndroidContextPlugin.DEVICE_KEY, zzbyyVarZzg.zzh()).put("product", zzbyyVarZzg.zzk()).put(AndroidContextPlugin.DEVICE_MODEL_KEY, zzbyyVarZzg.zzj()).put(AndroidContextPlugin.DEVICE_MANUFACTURER_KEY, zzbyyVarZzg.zzi()).put("brand", zzbyyVarZzg.zzg())).put("build", new JSONObject().put("os_version", zzbysVarZzc.zzj()).put("build_type", zzbysVarZzc.zzi()).put("preview_sdk", zzbysVarZzc.zzc()).put("build_id", zzbysVarZzc.zzh())).put("soc", zzbyvVarZza.zzh()));
                    zzbze zzbzeVarZzb = zzawsVar.zzb();
                    JSONArray jSONArray = new JSONArray();
                    for (zzbzb zzbzbVar : zzbzeVarZzb.zzf()) {
                        jSONArray.put(new JSONObject().put(AndroidContextPlugin.DEVICE_KEY, zzbzbVar.zzg()).put("version", zzbzbVar.zzh()).put("feature_level", zzbzbVar.zzc()));
                    }
                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("nnapi_info", new JSONObject().put("nnapi_driver_versions", jSONArray)).put("model_namespace", "com.google.perception");
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    try {
                        byte[] bytes = jSONObjectPut3.toString().getBytes(StandardCharsets.UTF_8);
                        outputStream.write(bytes, 0, bytes.length);
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        try {
                            httpURLConnection.connect();
                            if (httpURLConnection.getResponseCode() != 200) {
                                throw new zzaxa(zzags.RPC_ERROR, String.format("Error response (%d: '%s') from MlGoldblumServer", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage()));
                            }
                            String headerField = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_TYPE);
                            if (headerField == null || !zzkb.zza(headerField, "application/x-protobuf")) {
                                throw new zzaxa(zzags.RPC_RETURNED_MALFORMED_RESULT, "Invalid response from MlGoldblum, expected proto buf but got ".concat(String.valueOf(headerField)));
                            }
                            try {
                                return zzbyp.zzf(httpURLConnection.getInputStream(), zzbdv.zza()).zzc();
                            } catch (IOException e) {
                                throw new zzaxa(zzags.RPC_RETURNED_MALFORMED_RESULT, "Error while reading response from MlGoldblum", e);
                            }
                        } catch (IOException e2) {
                            throw new zzaxa(zzags.NO_CONNECTION, "Error while requesting allowlist to MlGoldblum", e2);
                        }
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException | JSONException e3) {
                    throw new zzaxa(zzags.RPC_CLIENT_ERROR, "Error creating request", e3);
                }
            } catch (IOException e4) {
                throw new zzaxa(zzags.RPC_CLIENT_ERROR, "Error while building allowlist request to MlGoldblum", e4);
            }
        } catch (IOException e5) {
            throw new zzaxa(zzags.RPC_CLIENT_ERROR, "Invalid URL built while trying to connect to MlGoldblum", e5);
        }
    }
}
