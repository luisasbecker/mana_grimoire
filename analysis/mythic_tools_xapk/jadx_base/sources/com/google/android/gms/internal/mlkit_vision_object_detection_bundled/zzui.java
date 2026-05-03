package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import android.util.Log;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzui {
    private static final MediaType zzb = MediaType.parse("application/json; charset=utf-8");
    public final zzuj zza;
    private final zzun zze;
    private final OkHttpClient zzc = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(10000, TimeUnit.MILLISECONDS).writeTimeout(10000, TimeUnit.MILLISECONDS).build();
    private zzuq zzd = null;
    private final String zzf = "https://firebaseinstallations.googleapis.com/v1";

    public zzui(zzuj zzujVar, zzun zzunVar) {
        this.zza = zzujVar;
        this.zze = zzunVar;
    }

    private static long zze(long j, String str) {
        return j + (Long.parseLong(str.replaceFirst("s$", "")) * 1000);
    }

    private final String zzf(Headers headers, String str, String str2, zzum zzumVar, zzum zzumVar2) {
        String strString;
        ResponseBody responseBodyBody;
        try {
            Response responseExecute = this.zzc.newCall(new Request.Builder().headers(headers).url(str).post(RequestBody.create(zzb, str2)).build()).execute();
            int iCode = responseExecute.code();
            zzumVar2.zzf(iCode);
            if (iCode >= 200 && iCode < 300) {
                try {
                    responseBodyBody = responseExecute.body();
                    try {
                        String strString2 = responseBodyBody.string();
                        if (responseBodyBody != null) {
                            responseBodyBody.close();
                        }
                        return strString2;
                    } finally {
                    }
                } catch (IOException e) {
                    Log.e("MLKitFbInstsRestClient", "Error retrieving response body from HTTPS POST request to <" + str + ">", e);
                    zzumVar2.zzd(zzsw.RPC_ERROR);
                    zzumVar.zzb(zzsw.RPC_ERROR);
                    return null;
                }
            }
            Log.e("MLKitFbInstsRestClient", "Got HTTP status " + iCode + " from HTTPS POST request to <" + str + ">");
            try {
                responseBodyBody = responseExecute.body();
            } catch (IOException unused) {
                strString = "<none>";
            }
            try {
                strString = responseBodyBody.string();
                if (responseBodyBody != null) {
                    responseBodyBody.close();
                }
                Log.d("MLKitFbInstsRestClient", "HTTP Response Body:\n".concat(String.valueOf(strString)));
                zzumVar2.zzd(zzsw.RPC_ERROR);
                zzumVar.zzb(zzsw.RPC_ERROR);
                return null;
            } finally {
                if (responseBodyBody != null) {
                    try {
                        responseBodyBody.close();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                }
            }
        } catch (IOException e2) {
            Log.e("MLKitFbInstsRestClient", "Connection error (or timeout) sending HTTPS POST request to <" + str + ">", e2);
            zzumVar2.zzd(zzsw.NO_CONNECTION);
            zzumVar.zzb(zzsw.NO_CONNECTION);
            return null;
        }
    }

    public final zzuq zza() {
        return this.zzd;
    }

    /* JADX WARN: Not initialized variable reg: 22, insn: 0x0145: MOVE (r6 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY]), block:B:27:0x0145 */
    final /* synthetic */ boolean zzb(zzuf zzufVar, zzum zzumVar) throws Throwable {
        boolean z;
        zzum zzumVar2;
        zzck zzckVarZzb;
        String str;
        zzck zzckVar;
        zzum zzumVar3;
        String str2 = String.format("%s/projects/%s/installations", this.zzf, this.zza.zzc());
        Headers headersBuild = new Headers.Builder().add("x-goog-api-key", this.zza.zza()).build();
        String str3 = String.format("{fid: '%s', appId: '%s', authVersion: '%s', sdkVersion: '%s'}", zzufVar.zza(), this.zza.zzb(), "FIS_v2", "o:a:mlkit:1.0.0");
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzum zzumVar4 = new zzum();
        zzumVar4.zzg();
        String strZzf = zzf(headersBuild, str2, str3, zzumVar, zzumVar4);
        zzumVar4.zze();
        try {
            if (strZzf == null) {
                z = false;
            } else {
                try {
                    try {
                        zzckVarZzb = zzcm.zzb(strZzf).zzb();
                    } catch (Throwable th) {
                        th = th;
                        zzumVar4 = zzumVar2;
                    }
                } catch (zzco e) {
                    e = e;
                    Log.e("MLKitFbInstsRestClient", "Error parsing JSON object returned from <" + str2 + ">:\n" + strZzf, e);
                    zzumVar4.zzd(zzsw.RPC_RETURNED_MALFORMED_RESULT);
                    zzumVar.zzb(zzsw.RPC_RETURNED_MALFORMED_RESULT);
                    z = false;
                    this.zze.zza(zzpb.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzumVar4);
                    return z;
                } catch (IllegalStateException e2) {
                    e = e2;
                    Log.e("MLKitFbInstsRestClient", "Error parsing JSON object returned from <" + str2 + ">:\n" + strZzf, e);
                    zzumVar4.zzd(zzsw.RPC_RETURNED_MALFORMED_RESULT);
                    zzumVar.zzb(zzsw.RPC_RETURNED_MALFORMED_RESULT);
                    z = false;
                    this.zze.zza(zzpb.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzumVar4);
                    return z;
                } catch (NullPointerException e3) {
                    e = e3;
                    Log.e("MLKitFbInstsRestClient", "Error parsing JSON object returned from <" + str2 + ">:\n" + strZzf, e);
                    zzumVar4.zzd(zzsw.RPC_RETURNED_MALFORMED_RESULT);
                    zzumVar.zzb(zzsw.RPC_RETURNED_MALFORMED_RESULT);
                    z = false;
                    this.zze.zza(zzpb.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzumVar4);
                    return z;
                }
                try {
                    String strZze = zzckVarZzb.zzc("name").zze();
                    zzumVar3 = zzumVar4;
                    try {
                        str = strZzf;
                        try {
                            zzuf zzufVar2 = new zzuf(zzckVarZzb.zzc("fid").zze());
                            String strZze2 = zzckVarZzb.zzc("refreshToken").zze();
                            zzck zzckVarZza = zzckVarZzb.zza("authToken");
                            zzckVar = zzckVarZzb;
                            try {
                                String strZze3 = zzckVarZza.zzc("token").zze();
                                String strZze4 = zzckVarZza.zzc("expiresIn").zze();
                                long jZze = zze(jCurrentTimeMillis, strZze4);
                                Log.i("MLKitFbInstsRestClient", "installation name: " + strZze);
                                Log.d("MLKitFbInstsRestClient", "fid: " + zzufVar2.zza());
                                Log.d("MLKitFbInstsRestClient", "refresh_token: " + strZze2);
                                Log.d("MLKitFbInstsRestClient", "auth token: " + String.valueOf(zzckVarZza));
                                Log.d("MLKitFbInstsRestClient", "auth token expires in: " + strZze4);
                                Log.d("MLKitFbInstsRestClient", "auth token expiry: " + jZze);
                                this.zzd = new zzuq(zzufVar2, strZze2, strZze3, jZze);
                                z = true;
                                zzumVar4 = zzumVar3;
                            } catch (ClassCastException e4) {
                                e = e4;
                                Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from url <" + str2 + ">:\nraw json:\n" + str + "\nparsed json:\n" + zzckVar.toString(), e);
                                zzumVar4 = zzumVar3;
                                zzumVar4.zzd(zzsw.RPC_RETURNED_INVALID_RESULT);
                                zzumVar.zzb(zzsw.RPC_RETURNED_INVALID_RESULT);
                                z = false;
                            } catch (IllegalStateException e5) {
                                e = e5;
                                Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from url <" + str2 + ">:\nraw json:\n" + str + "\nparsed json:\n" + zzckVar.toString(), e);
                                zzumVar4 = zzumVar3;
                                zzumVar4.zzd(zzsw.RPC_RETURNED_INVALID_RESULT);
                                zzumVar.zzb(zzsw.RPC_RETURNED_INVALID_RESULT);
                                z = false;
                            } catch (NullPointerException e6) {
                                e = e6;
                                Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from url <" + str2 + ">:\nraw json:\n" + str + "\nparsed json:\n" + zzckVar.toString(), e);
                                zzumVar4 = zzumVar3;
                                zzumVar4.zzd(zzsw.RPC_RETURNED_INVALID_RESULT);
                                zzumVar.zzb(zzsw.RPC_RETURNED_INVALID_RESULT);
                                z = false;
                            }
                        } catch (ClassCastException e7) {
                            e = e7;
                            zzckVar = zzckVarZzb;
                            Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from url <" + str2 + ">:\nraw json:\n" + str + "\nparsed json:\n" + zzckVar.toString(), e);
                            zzumVar4 = zzumVar3;
                            zzumVar4.zzd(zzsw.RPC_RETURNED_INVALID_RESULT);
                            zzumVar.zzb(zzsw.RPC_RETURNED_INVALID_RESULT);
                            z = false;
                            this.zze.zza(zzpb.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzumVar4);
                            return z;
                        } catch (IllegalStateException e8) {
                            e = e8;
                            zzckVar = zzckVarZzb;
                            Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from url <" + str2 + ">:\nraw json:\n" + str + "\nparsed json:\n" + zzckVar.toString(), e);
                            zzumVar4 = zzumVar3;
                            zzumVar4.zzd(zzsw.RPC_RETURNED_INVALID_RESULT);
                            zzumVar.zzb(zzsw.RPC_RETURNED_INVALID_RESULT);
                            z = false;
                            this.zze.zza(zzpb.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzumVar4);
                            return z;
                        } catch (NullPointerException e9) {
                            e = e9;
                            zzckVar = zzckVarZzb;
                            Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from url <" + str2 + ">:\nraw json:\n" + str + "\nparsed json:\n" + zzckVar.toString(), e);
                            zzumVar4 = zzumVar3;
                            zzumVar4.zzd(zzsw.RPC_RETURNED_INVALID_RESULT);
                            zzumVar.zzb(zzsw.RPC_RETURNED_INVALID_RESULT);
                            z = false;
                            this.zze.zza(zzpb.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzumVar4);
                            return z;
                        }
                    } catch (ClassCastException | IllegalStateException | NullPointerException e10) {
                        e = e10;
                        str = strZzf;
                    }
                } catch (ClassCastException e11) {
                    e = e11;
                    str = strZzf;
                    zzckVar = zzckVarZzb;
                    zzumVar3 = zzumVar4;
                    Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from url <" + str2 + ">:\nraw json:\n" + str + "\nparsed json:\n" + zzckVar.toString(), e);
                    zzumVar4 = zzumVar3;
                    zzumVar4.zzd(zzsw.RPC_RETURNED_INVALID_RESULT);
                    zzumVar.zzb(zzsw.RPC_RETURNED_INVALID_RESULT);
                    z = false;
                    this.zze.zza(zzpb.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzumVar4);
                    return z;
                } catch (IllegalStateException e12) {
                    e = e12;
                    str = strZzf;
                    zzckVar = zzckVarZzb;
                    zzumVar3 = zzumVar4;
                    Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from url <" + str2 + ">:\nraw json:\n" + str + "\nparsed json:\n" + zzckVar.toString(), e);
                    zzumVar4 = zzumVar3;
                    zzumVar4.zzd(zzsw.RPC_RETURNED_INVALID_RESULT);
                    zzumVar.zzb(zzsw.RPC_RETURNED_INVALID_RESULT);
                    z = false;
                    this.zze.zza(zzpb.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzumVar4);
                    return z;
                } catch (NullPointerException e13) {
                    e = e13;
                    str = strZzf;
                    zzckVar = zzckVarZzb;
                    zzumVar3 = zzumVar4;
                    Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from url <" + str2 + ">:\nraw json:\n" + str + "\nparsed json:\n" + zzckVar.toString(), e);
                    zzumVar4 = zzumVar3;
                    zzumVar4.zzd(zzsw.RPC_RETURNED_INVALID_RESULT);
                    zzumVar.zzb(zzsw.RPC_RETURNED_INVALID_RESULT);
                    z = false;
                    this.zze.zza(zzpb.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzumVar4);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    this.zze.zza(zzpb.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzumVar4);
                    throw th;
                }
            }
            this.zze.zza(zzpb.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzumVar4);
            return z;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final boolean zzc(final zzum zzumVar) throws InterruptedException {
        if (this.zzd == null) {
            return false;
        }
        boolean zZza = zzwj.zza(new zzwi() { // from class: com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzug
            @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzwi
            public final boolean zza() {
                return this.zza.zzd(zzumVar);
            }
        });
        if (!zZza) {
            zzumVar.zzc(zzsw.RPC_EXPONENTIAL_BACKOFF_FAILED);
        }
        return zZza;
    }

    public final boolean zzd(zzum zzumVar) {
        zzck zzckVarZzb;
        boolean z;
        String str = String.format("%s/projects/%s/installations/%s/authTokens:generate", this.zzf, this.zza.zzc(), this.zzd.zzb().zza());
        Headers headersBuild = new Headers.Builder().add("authorization", "FIS_v2 ".concat(String.valueOf(this.zzd.zzc()))).add("x-goog-api-key", this.zza.zza()).build();
        String str2 = String.format("{installation:{sdkVersion:'%s'}}", "o:a:mlkit:1.0.0");
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzum zzumVar2 = new zzum();
        zzumVar2.zzg();
        String strZzf = zzf(headersBuild, str, str2, zzumVar, zzumVar2);
        zzumVar2.zze();
        if (strZzf == null) {
            z = false;
        } else {
            try {
                try {
                    zzckVarZzb = zzcm.zzb(strZzf).zzb();
                } catch (zzco e) {
                    Log.e("MLKitFbInstsRestClient", "Error parsing JSON object returned from <" + str + ">:\n" + strZzf, e);
                    zzumVar2.zzd(zzsw.RPC_RETURNED_MALFORMED_RESULT);
                    zzumVar.zzb(zzsw.RPC_RETURNED_MALFORMED_RESULT);
                }
                try {
                    String strZze = zzckVarZzb.zzc("token").zze();
                    String strZze2 = zzckVarZzb.zzc("expiresIn").zze();
                    long jZze = zze(jCurrentTimeMillis, strZze2);
                    Log.d("MLKitFbInstsRestClient", "refreshed auth token: " + strZze);
                    Log.d("MLKitFbInstsRestClient", "auth token expires in: " + strZze2);
                    Log.d("MLKitFbInstsRestClient", "auth token expiry: " + jZze);
                    this.zzd = new zzuq(this.zzd.zzb(), this.zzd.zzc(), strZze, jZze);
                    z = true;
                } catch (ClassCastException | IllegalStateException | NullPointerException e2) {
                    zzumVar2.zzd(zzsw.RPC_RETURNED_INVALID_RESULT);
                    zzumVar.zzb(zzsw.RPC_RETURNED_INVALID_RESULT);
                    Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from <" + str + ">:\nraw json:\n" + strZzf + "\nparsed json:\n" + zzckVarZzb.toString(), e2);
                    z = false;
                }
            } catch (Throwable th) {
                this.zze.zza(zzpb.INSTALLATION_ID_FIS_GENERATE_AUTH_TOKEN, zzumVar2);
                throw th;
            }
        }
        this.zze.zza(zzpb.INSTALLATION_ID_FIS_GENERATE_AUTH_TOKEN, zzumVar2);
        return z;
    }
}
