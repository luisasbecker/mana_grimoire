package com.google.android.gms.internal.mlkit_vision_internal_vkp;

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

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaxe {
    private static final MediaType zzb = MediaType.parse("application/json; charset=utf-8");
    public final zzaxf zza;
    private final zzaxj zze;
    private final OkHttpClient zzc = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(10000, TimeUnit.MILLISECONDS).writeTimeout(10000, TimeUnit.MILLISECONDS).build();
    private zzaxm zzd = null;
    private final String zzf = "https://firebaseinstallations.googleapis.com/v1";

    public zzaxe(zzaxf zzaxfVar, zzaxj zzaxjVar) {
        this.zza = zzaxfVar;
        this.zze = zzaxjVar;
    }

    public final zzaxm zza() {
        return this.zzd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0151  */
    /* JADX WARN: Type inference failed for: r0v49, types: [com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxj] */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxj] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxi] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxi] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxi] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final /* synthetic */ boolean zzb(zzaxc zzaxcVar, zzaxi zzaxiVar) throws Throwable {
        String str;
        ?? r18;
        String str2;
        zzaxi zzaxiVar2;
        zzaeo zzaeoVar;
        boolean z;
        ?? r2;
        Response responseExecute;
        int iCode;
        String strString;
        ?? r22 = zzaxiVar;
        String str3 = String.format("%s/projects/%s/installations", this.zzf, this.zza.zzc());
        Headers headersBuild = new Headers.Builder().add("x-goog-api-key", this.zza.zza()).build();
        String str4 = String.format("{fid: '%s', appId: '%s', authVersion: '%s', sdkVersion: '%s'}", zzaxcVar.zza(), this.zza.zzb(), "FIS_v2", "o:a:mlkit:1.0.0");
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzaxi zzaxiVar3 = new zzaxi();
        zzaxiVar3.zzg();
        long j = jCurrentTimeMillis;
        try {
            responseExecute = this.zzc.newCall(new Request.Builder().headers(headersBuild).url(str3).post(RequestBody.create(zzb, str4)).build()).execute();
            iCode = responseExecute.code();
            zzaxiVar3.zzf(iCode);
        } catch (IOException e) {
            Log.e("MLKitFbInstsRestClient", "Connection error (or timeout) sending HTTPS POST request to <" + str3 + ">", e);
            zzaxiVar3.zzd(zzave.NO_CONNECTION);
            r22.zzb(zzave.NO_CONNECTION);
        }
        try {
            if (iCode >= 200 && iCode < 300) {
                try {
                    ResponseBody responseBodyBody = responseExecute.body();
                    try {
                        String strString2 = responseBodyBody.string();
                        if (responseBodyBody != null) {
                            responseBodyBody.close();
                        }
                        str = strString2;
                    } finally {
                        zzaxiVar3.zze();
                        if (str == null) {
                        }
                        z = false;
                        r2 = r22;
                        this.zze.zza(zzary.INSTALLATION_ID_FIS_CREATE_INSTALLATION, r2);
                        return z;
                    }
                } catch (IOException e2) {
                    Log.e("MLKitFbInstsRestClient", "Error retrieving response body from HTTPS POST request to <" + str3 + ">", e2);
                    zzaxiVar3.zzd(zzave.RPC_ERROR);
                    r22.zzb(zzave.RPC_ERROR);
                    str = null;
                }
                zzaxiVar3.zze();
                if (str == null) {
                    try {
                        try {
                            zzaeo zzaeoVarZzb = zzaeq.zzb(str).zzb();
                            try {
                                try {
                                    String strZze = zzaeoVarZzb.zzc("name").zze();
                                    zzaxc zzaxcVar2 = new zzaxc(zzaeoVarZzb.zzc("fid").zze());
                                    String strZze2 = zzaeoVarZzb.zzc("refreshToken").zze();
                                    zzaeo zzaeoVarZza = zzaeoVarZzb.zza("authToken");
                                    zzaeoVar = zzaeoVarZzb;
                                    try {
                                        String strZze3 = zzaeoVarZza.zzc("token").zze();
                                        String strZze4 = zzaeoVarZza.zzc("expiresIn").zze();
                                        str2 = str;
                                        long j2 = j + (Long.parseLong(strZze4.replaceFirst("s$", "")) * 1000);
                                        zzaxiVar2 = zzaxiVar3;
                                        try {
                                            Log.i("MLKitFbInstsRestClient", "installation name: " + strZze);
                                            Log.d("MLKitFbInstsRestClient", "fid: " + zzaxcVar2.zza());
                                            Log.d("MLKitFbInstsRestClient", "refresh_token: " + strZze2);
                                            Log.d("MLKitFbInstsRestClient", "auth token: " + String.valueOf(zzaeoVarZza));
                                            Log.d("MLKitFbInstsRestClient", "auth token expires in: " + strZze4);
                                            Log.d("MLKitFbInstsRestClient", "auth token expiry: " + j2);
                                            this.zzd = new zzaxm(zzaxcVar2, strZze2, strZze3, j2);
                                            z = true;
                                            r2 = zzaxiVar2;
                                        } catch (ClassCastException e3) {
                                            e = e3;
                                            Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from url <" + str3 + ">:\nraw json:\n" + str2 + "\nparsed json:\n" + zzaeoVar.toString(), e);
                                            zzaxi zzaxiVar4 = zzaxiVar2;
                                            zzaxiVar4.zzd(zzave.RPC_RETURNED_INVALID_RESULT);
                                            zzaxiVar.zzb(zzave.RPC_RETURNED_INVALID_RESULT);
                                            r22 = zzaxiVar4;
                                            z = false;
                                            r2 = r22;
                                        } catch (IllegalStateException e4) {
                                            e = e4;
                                            Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from url <" + str3 + ">:\nraw json:\n" + str2 + "\nparsed json:\n" + zzaeoVar.toString(), e);
                                            zzaxi zzaxiVar42 = zzaxiVar2;
                                            zzaxiVar42.zzd(zzave.RPC_RETURNED_INVALID_RESULT);
                                            zzaxiVar.zzb(zzave.RPC_RETURNED_INVALID_RESULT);
                                            r22 = zzaxiVar42;
                                            z = false;
                                            r2 = r22;
                                        } catch (NullPointerException e5) {
                                            e = e5;
                                            Log.e("MLKitFbInstsRestClient", "Error traversing JSON object returned from url <" + str3 + ">:\nraw json:\n" + str2 + "\nparsed json:\n" + zzaeoVar.toString(), e);
                                            zzaxi zzaxiVar422 = zzaxiVar2;
                                            zzaxiVar422.zzd(zzave.RPC_RETURNED_INVALID_RESULT);
                                            zzaxiVar.zzb(zzave.RPC_RETURNED_INVALID_RESULT);
                                            r22 = zzaxiVar422;
                                            z = false;
                                            r2 = r22;
                                        }
                                    } catch (ClassCastException | IllegalStateException | NullPointerException e6) {
                                        e = e6;
                                        str2 = str;
                                        zzaxiVar2 = zzaxiVar3;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    r18 = zzaxiVar3;
                                    r22 = r18;
                                    this.zze.zza(zzary.INSTALLATION_ID_FIS_CREATE_INSTALLATION, r22);
                                    throw th;
                                }
                            } catch (ClassCastException | IllegalStateException | NullPointerException e7) {
                                e = e7;
                                str2 = str;
                                zzaxiVar2 = zzaxiVar3;
                                zzaeoVar = zzaeoVarZzb;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            r18 = j;
                        }
                    } catch (zzaes e8) {
                        e = e8;
                        zzaxi zzaxiVar5 = zzaxiVar3;
                        Log.e("MLKitFbInstsRestClient", "Error parsing JSON object returned from <" + str3 + ">:\n" + str, e);
                        zzaxiVar5.zzd(zzave.RPC_RETURNED_MALFORMED_RESULT);
                        r22.zzb(zzave.RPC_RETURNED_MALFORMED_RESULT);
                        r22 = zzaxiVar5;
                        z = false;
                        r2 = r22;
                        this.zze.zza(zzary.INSTALLATION_ID_FIS_CREATE_INSTALLATION, r2);
                        return z;
                    } catch (IllegalStateException e9) {
                        e = e9;
                        zzaxi zzaxiVar52 = zzaxiVar3;
                        Log.e("MLKitFbInstsRestClient", "Error parsing JSON object returned from <" + str3 + ">:\n" + str, e);
                        zzaxiVar52.zzd(zzave.RPC_RETURNED_MALFORMED_RESULT);
                        r22.zzb(zzave.RPC_RETURNED_MALFORMED_RESULT);
                        r22 = zzaxiVar52;
                        z = false;
                        r2 = r22;
                        this.zze.zza(zzary.INSTALLATION_ID_FIS_CREATE_INSTALLATION, r2);
                        return z;
                    } catch (NullPointerException e10) {
                        e = e10;
                        zzaxi zzaxiVar522 = zzaxiVar3;
                        Log.e("MLKitFbInstsRestClient", "Error parsing JSON object returned from <" + str3 + ">:\n" + str, e);
                        zzaxiVar522.zzd(zzave.RPC_RETURNED_MALFORMED_RESULT);
                        r22.zzb(zzave.RPC_RETURNED_MALFORMED_RESULT);
                        r22 = zzaxiVar522;
                        z = false;
                        r2 = r22;
                        this.zze.zza(zzary.INSTALLATION_ID_FIS_CREATE_INSTALLATION, r2);
                        return z;
                    } catch (Throwable th3) {
                        th = th3;
                        r22 = zzaxiVar3;
                        this.zze.zza(zzary.INSTALLATION_ID_FIS_CREATE_INSTALLATION, r22);
                        throw th;
                    }
                    this.zze.zza(zzary.INSTALLATION_ID_FIS_CREATE_INSTALLATION, r2);
                    return z;
                }
                r22 = zzaxiVar3;
                z = false;
                r2 = r22;
                this.zze.zza(zzary.INSTALLATION_ID_FIS_CREATE_INSTALLATION, r2);
                return z;
            }
            Log.e("MLKitFbInstsRestClient", "Got HTTP status " + iCode + " from HTTPS POST request to <" + str3 + ">");
            try {
                ResponseBody responseBodyBody2 = responseExecute.body();
                try {
                    strString = responseBodyBody2.string();
                    if (responseBodyBody2 != null) {
                        responseBodyBody2.close();
                    }
                } finally {
                    if (responseBodyBody2 == null) {
                        throw th;
                    }
                    try {
                        responseBodyBody2.close();
                        throw th;
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                    Log.d("MLKitFbInstsRestClient", "HTTP Response Body:\n".concat(String.valueOf(strString)));
                    zzaxiVar3.zzd(zzave.RPC_ERROR);
                    r22.zzb(zzave.RPC_ERROR);
                    str = null;
                    zzaxiVar3.zze();
                    if (str == null) {
                    }
                    z = false;
                    r2 = r22;
                    this.zze.zza(zzary.INSTALLATION_ID_FIS_CREATE_INSTALLATION, r2);
                    return z;
                }
            } catch (IOException unused) {
                strString = "<none>";
            }
            Log.d("MLKitFbInstsRestClient", "HTTP Response Body:\n".concat(String.valueOf(strString)));
            zzaxiVar3.zzd(zzave.RPC_ERROR);
            r22.zzb(zzave.RPC_ERROR);
            if (str == null) {
            }
            z = false;
            r2 = r22;
            this.zze.zza(zzary.INSTALLATION_ID_FIS_CREATE_INSTALLATION, r2);
            return z;
        } catch (Throwable th5) {
            th = th5;
        }
        str = null;
        zzaxiVar3.zze();
    }
}
