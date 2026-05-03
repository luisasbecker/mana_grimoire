package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.internal.play_billing.zzhu;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzio;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zziu;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zziy;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzjb;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzjk;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjr;
import com.google.android.gms.internal.play_billing.zzjv;
import com.google.android.gms.internal.play_billing.zzjy;
import com.google.android.gms.internal.play_billing.zzks;
import com.google.android.gms.internal.play_billing.zzku;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes3.dex */
class BillingClientImpl extends BillingClient {
    private boolean zzA;
    private boolean zzB;
    private boolean zzC;
    private boolean zzD;
    private PendingPurchasesParams zzE;
    private boolean zzF;
    private boolean zzG;
    private volatile BillingClientStateListener zzH;
    private ExecutorService zzI;
    private final Long zzJ;
    private com.google.android.gms.internal.play_billing.zzbo zzK;
    private final Object zza;
    private volatile int zzb;
    private final String zzc;
    private final String zzd;
    private final Handler zze;
    private volatile zzab zzf;
    private Context zzg;
    private zzcz zzh;
    private volatile com.google.android.gms.internal.play_billing.zzap zzi;
    private volatile zzbw zzj;
    private boolean zzk;
    private boolean zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;

    private BillingClientImpl(Activity activity, PendingPurchasesParams pendingPurchasesParams, String str, BillingClient.Builder builder) {
        this(activity.getApplicationContext(), pendingPurchasesParams, new zzci(), str, null, null, null, null, null, builder);
    }

    private BillingClientImpl(Context context, PendingPurchasesParams pendingPurchasesParams, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, UserChoiceBillingListener userChoiceBillingListener, DeveloperProvidedBillingListener developerProvidedBillingListener, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzJ = Long.valueOf(new Random().nextLong());
        this.zzK = com.google.android.gms.internal.play_billing.zzbd.zza();
        this.zzc = str;
        this.zzd = zzaE();
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, userChoiceBillingListener, developerProvidedBillingListener, str, null, builder);
    }

    private BillingClientImpl(String str) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzJ = Long.valueOf(new Random().nextLong());
        this.zzK = com.google.android.gms.internal.play_billing.zzbd.zza();
        this.zzc = str;
        this.zzd = zzaE();
    }

    BillingClientImpl(String str, Context context, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzJ = lValueOf;
        this.zzK = com.google.android.gms.internal.play_billing.zzbd.zza();
        this.zzc = "8.3.0";
        String strZzaE = zzaE();
        this.zzd = strZzaE;
        this.zzg = context.getApplicationContext();
        zzjp zzjpVarZza = zzjr.zza();
        zzjpVarZza.zzx("8.3.0");
        if (strZzaE != null) {
            zzjpVarZza.zzy(strZzaE);
        }
        zzjpVarZza.zzq(this.zzg.getPackageName());
        zzjpVarZza.zzd(lValueOf.longValue());
        zzjpVarZza.zzw(builder.zza);
        zzjpVarZza.zza(Build.VERSION.SDK_INT);
        zzjpVarZza.zzp(846465066L);
        zzbo(zzjpVarZza, context);
        try {
            zzjpVarZza.zzb(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzdl(this.zzg, (zzjr) zzjpVarZza.zzi());
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbo zzboVar = builder.zzb;
        this.zzF = builder.zza;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, DeveloperProvidedBillingListener developerProvidedBillingListener, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        this(context, pendingPurchasesParams, purchasesUpdatedListener, "8.3.0", null, userChoiceBillingListener, developerProvidedBillingListener, null, null, builder);
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzb zzbVar, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzJ = Long.valueOf(new Random().nextLong());
        this.zzK = com.google.android.gms.internal.play_billing.zzbd.zza();
        this.zzc = "8.3.0";
        this.zzd = zzaE();
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, null, "8.3.0", null, builder);
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzdo zzdoVar, zzcz zzczVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzJ = lValueOf;
        this.zzK = com.google.android.gms.internal.play_billing.zzbd.zza();
        this.zzc = "8.3.0";
        String strZzaE = zzaE();
        this.zzd = strZzaE;
        this.zzg = context.getApplicationContext();
        zzjp zzjpVarZza = zzjr.zza();
        zzjpVarZza.zzx("8.3.0");
        if (strZzaE != null) {
            zzjpVarZza.zzy(strZzaE);
        }
        zzjpVarZza.zzq(this.zzg.getPackageName());
        zzjpVarZza.zzd(lValueOf.longValue());
        zzjpVarZza.zzw(builder.zza);
        zzjpVarZza.zza(Build.VERSION.SDK_INT);
        zzjpVarZza.zzp(846465066L);
        zzbo(zzjpVarZza, context);
        try {
            zzjpVarZza.zzb(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzdl(this.zzg, (zzjr) zzjpVarZza.zzi());
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzf = new zzab(this.zzg, null, null, null, null, null, this.zzh);
        this.zzE = pendingPurchasesParams;
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbo zzboVar = builder.zzb;
        this.zzF = builder.zza;
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, UserChoiceBillingListener userChoiceBillingListener, DeveloperProvidedBillingListener developerProvidedBillingListener, String str, zzcz zzczVar, BillingClient.Builder builder) {
        this.zzg = context.getApplicationContext();
        zzjp zzjpVarZza = zzjr.zza();
        zzjpVarZza.zzx(str);
        String str2 = this.zzd;
        if (str2 != null) {
            zzjpVarZza.zzy(str2);
        }
        zzjpVarZza.zzq(this.zzg.getPackageName());
        zzjpVarZza.zzd(this.zzJ.longValue());
        zzjpVarZza.zzw(builder.zza);
        zzjpVarZza.zza(Build.VERSION.SDK_INT);
        zzjpVarZza.zzp(846465066L);
        zzbo(zzjpVarZza, context);
        try {
            zzjpVarZza.zzb(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error getting app version code.", th);
        }
        if (zzczVar != null) {
            this.zzh = zzczVar;
        } else {
            this.zzh = new zzdl(this.zzg, (zzjr) zzjpVarZza.zzi());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new zzab(this.zzg, purchasesUpdatedListener, null, null, userChoiceBillingListener, developerProvidedBillingListener, this.zzh);
        this.zzE = pendingPurchasesParams;
        this.zzG = userChoiceBillingListener != null;
        com.google.android.gms.internal.play_billing.zzbo zzboVar = builder.zzb;
        this.zzF = builder.zza;
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, zzb zzbVar, String str, zzcz zzczVar, BillingClient.Builder builder) {
        this.zzg = context.getApplicationContext();
        zzjp zzjpVarZza = zzjr.zza();
        zzjpVarZza.zzx(str);
        String str2 = this.zzd;
        if (str2 != null) {
            zzjpVarZza.zzy(str2);
        }
        zzjpVarZza.zzq(this.zzg.getPackageName());
        zzjpVarZza.zzd(this.zzJ.longValue());
        zzjpVarZza.zzw(builder.zza);
        zzjpVarZza.zza(Build.VERSION.SDK_INT);
        zzjpVarZza.zzp(846465066L);
        zzbo(zzjpVarZza, context);
        try {
            zzjpVarZza.zzb(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error getting app version code.", th);
        }
        if (zzczVar != null) {
            this.zzh = zzczVar;
        } else {
            this.zzh = new zzdl(this.zzg, (zzjr) zzjpVarZza.zzi());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new zzab(this.zzg, purchasesUpdatedListener, null, zzbVar, null, null, this.zzh);
        this.zzE = pendingPurchasesParams;
        this.zzG = zzbVar != null;
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbo zzboVar = builder.zzb;
        this.zzF = builder.zza;
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    private void startConnection(long j) {
        startConnection(new zzci(j));
    }

    public static /* synthetic */ Void zzA(BillingClientImpl billingClientImpl, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        billingClientImpl.zzaL(alternativeBillingOnlyInformationDialogListener, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Void zzB(BillingClientImpl billingClientImpl, ExternalOfferAvailabilityListener externalOfferAvailabilityListener) throws Exception {
        billingClientImpl.zzaK(externalOfferAvailabilityListener);
        return null;
    }

    public static /* synthetic */ Void zzC(BillingClientImpl billingClientImpl, BillingProgramAvailabilityListener billingProgramAvailabilityListener, int i) throws Exception {
        billingClientImpl.zzaJ(billingProgramAvailabilityListener, i);
        return null;
    }

    public static /* synthetic */ Void zzD(BillingClientImpl billingClientImpl, LaunchExternalLinkResponseListener launchExternalLinkResponseListener, LaunchExternalLinkParams launchExternalLinkParams, Activity activity) throws RemoteException {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        zzch zzchVar = null;
        try {
            if (!billingClientImpl.zzbl(30000L)) {
                billingClientImpl.zzaZ(launchExternalLinkResponseListener, zzdc.zzj, zzjd.SERVICE_CONNECTION_NOT_READY, null);
            } else if (billingClientImpl.zzD) {
                synchronized (billingClientImpl.zza) {
                    zzapVar = billingClientImpl.zzi;
                }
                if (zzapVar == null) {
                    billingClientImpl.zzaZ(launchExternalLinkResponseListener, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = billingClientImpl.zzg.getPackageName();
                    String str = billingClientImpl.zzc;
                    String str2 = billingClientImpl.zzd;
                    long jLongValue = billingClientImpl.zzJ.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, jLongValue);
                    zzhu zzhuVarZza = zzhx.zza();
                    zzio zzioVarZza = zziq.zza();
                    zzioVarZza.zza(launchExternalLinkParams.getLinkUri().toString());
                    zzhuVarZza.zza("externalOfferUri", (zziq) zzioVarZza.zzi());
                    zzio zzioVarZza2 = zziq.zza();
                    zzioVarZza2.zza(String.valueOf(launchExternalLinkParams.getLaunchMode()));
                    zzhuVarZza.zza("externalOfferLaunchMode", (zziq) zzioVarZza2.zzi());
                    zzio zzioVarZza3 = zziq.zza();
                    zzioVarZza3.zza(String.valueOf(launchExternalLinkParams.getLinkType()));
                    zzhuVarZza.zza("externalOfferLinkType", (zziq) zzioVarZza3.zzi());
                    zzio zzioVarZza4 = zziq.zza();
                    zzioVarZza4.zza(String.valueOf(launchExternalLinkParams.getBillingProgram()));
                    zzhuVarZza.zza("externalOfferBillingProgram", (zziq) zzioVarZza4.zzi());
                    bundle.putByteArray("REQUEST_PARAMS", ((zzhx) zzhuVarZza.zzi()).zzQ());
                    zzapVar.zzp(27, packageName, bundle, new zzcc(billingClientImpl, new WeakReference(activity), launchExternalLinkResponseListener, zzchVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support launch external link.");
                billingClientImpl.zzaZ(launchExternalLinkResponseListener, zzdc.zzG, zzjd.LAUNCH_EXTERNAL_LINK_NOT_SUPPORTED, null);
            }
        } catch (RuntimeException e) {
            billingClientImpl.zzaZ(launchExternalLinkResponseListener, zzdc.zzh, zzjd.SERVICE_CALL_EXCEPTION, e);
        }
        return null;
    }

    public static /* synthetic */ Void zzE(BillingClientImpl billingClientImpl, ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) throws Exception {
        billingClientImpl.zzaH(externalOfferReportingDetailsListener);
        return null;
    }

    public static /* synthetic */ Void zzF(BillingClientImpl billingClientImpl, ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        billingClientImpl.zzaM(externalOfferInformationDialogListener, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Void zzG(BillingClientImpl billingClientImpl, AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        billingClientImpl.zzaF(alternativeBillingOnlyReportingDetailsListener);
        return null;
    }

    public static /* synthetic */ Void zzH(BillingClientImpl billingClientImpl, BillingProgramReportingDetailsListener billingProgramReportingDetailsListener, BillingProgramReportingDetailsParams billingProgramReportingDetailsParams) throws Exception {
        billingClientImpl.zzaG(billingProgramReportingDetailsListener, billingProgramReportingDetailsParams);
        return null;
    }

    public static /* synthetic */ Void zzI(BillingClientImpl billingClientImpl, AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) throws Exception {
        billingClientImpl.zzaI(alternativeBillingOnlyAvailabilityListener);
        return null;
    }

    static Future zzK(Callable callable, long j, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzaz
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    public static /* synthetic */ void zzL(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.zzk;
        billingClientImpl.zzbs(zzjdVar, 4, billingResult);
        consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
    }

    public static /* synthetic */ void zzM(BillingClientImpl billingClientImpl, PurchasesResponseListener purchasesResponseListener) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.zzk;
        billingClientImpl.zzbs(zzjdVar, 9, billingResult);
        purchasesResponseListener.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzbw.zzk());
    }

    public static /* synthetic */ void zzN(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.zzk;
        billingClientImpl.zzbs(zzjdVar, 13, billingResult);
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    public static /* synthetic */ void zzR(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.zzk;
        billingClientImpl.zzbs(zzjdVar, 3, billingResult);
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    public static /* synthetic */ void zzT(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener) {
        zzjd zzjdVar = zzjd.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzdc.zzk;
        billingClientImpl.zzbs(zzjdVar, 7, billingResult);
        productDetailsResponseListener.onProductDetailsResponse(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbw.zzk(), com.google.android.gms.internal.play_billing.zzbw.zzk()));
    }

    public static /* synthetic */ void zzV(BillingClientImpl billingClientImpl, BillingResult billingResult) {
        if (billingClientImpl.zzf.zzf() != null) {
            billingClientImpl.zzf.zzf().onPurchasesUpdated(billingResult, null);
        } else {
            zzab zzabVar = billingClientImpl.zzf;
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    private final /* synthetic */ Object zzaA(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) throws Exception {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            if (!zzbl(30000L)) {
                zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzdc.zzj;
                zzbs(zzjdVar, 3, billingResult);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
            } else if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Please provide a valid purchase token.");
                zzjd zzjdVar2 = zzjd.EMPTY_PURCHASE_TOKEN;
                BillingResult billingResult2 = zzdc.zzg;
                zzbs(zzjdVar2, 3, billingResult2);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult2);
            } else if (this.zzp) {
                synchronized (this.zza) {
                    zzapVar = this.zzi;
                }
                if (zzapVar != null) {
                    String packageName = this.zzg.getPackageName();
                    String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
                    String str = this.zzc;
                    String str2 = this.zzd;
                    long jLongValue = this.zzJ.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, jLongValue);
                    Bundle bundleZzd = zzapVar.zzd(9, packageName, purchaseToken, bundle);
                    acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzdc.zza(com.google.android.gms.internal.play_billing.zzc.zzb(bundleZzd, "BillingClient"), com.google.android.gms.internal.play_billing.zzc.zzk(bundleZzd, "BillingClient")));
                    return null;
                }
                zzaP(acknowledgePurchaseResponseListener, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, null);
            } else {
                zzjd zzjdVar3 = zzjd.API_VERSION_NOT_V9;
                BillingResult billingResult3 = zzdc.zza;
                zzbs(zzjdVar3, 3, billingResult3);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult3);
            }
            return null;
        } catch (DeadObjectException e) {
            zzaP(acknowledgePurchaseResponseListener, zzdc.zzj, zzjd.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e2) {
            zzaP(acknowledgePurchaseResponseListener, zzdc.zzh, zzjd.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e2);
            return null;
        }
    }

    private final /* synthetic */ Object zzaB(BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        zzch zzchVar = null;
        try {
            if (!zzbl(30000L)) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Service disconnected.");
                zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzdc.zzj;
                zzbs(zzjdVar, 13, billingResult);
                billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
            } else if (this.zzv) {
                synchronized (this.zza) {
                    zzapVar = this.zzi;
                }
                if (zzapVar == null) {
                    zzaY(billingConfigResponseListener, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.zzg.getPackageName();
                    String str = this.zzc;
                    String str2 = this.zzd;
                    long jLongValue = this.zzJ.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, jLongValue);
                    zzapVar.zzo(18, packageName, bundle, new zzca(billingConfigResponseListener, this.zzh, this.zzm, zzchVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support get billing config.");
                zzjd zzjdVar2 = zzjd.GET_BILLING_CONFIG_NOT_SUPPORTED;
                BillingResult billingResult2 = zzdc.zzy;
                zzbs(zzjdVar2, 13, billingResult2);
                billingConfigResponseListener.onBillingConfigResponse(billingResult2, null);
            }
        } catch (DeadObjectException e) {
            zzaY(billingConfigResponseListener, zzdc.zzj, zzjd.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaY(billingConfigResponseListener, zzdc.zzh, zzjd.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Object zzaC(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            synchronized (this.zza) {
                zzapVar = this.zzi;
            }
            if (zzapVar == null) {
                zzbb(-1, zzjd.SERVICE_RESET_TO_NULL, null);
            } else {
                zzapVar.zzs(12, this.zzg.getPackageName(), bundle, new zzcf(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzbb(-1, zzjd.SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzbb(6, zzjd.SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final String zzaD(QueryProductDetailsParams queryProductDetailsParams) {
        if (TextUtils.isEmpty(null)) {
            return this.zzg.getPackageName();
        }
        return null;
    }

    private static String zzaE() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    private final /* synthetic */ Void zzaF(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        zzch zzchVar = null;
        try {
            if (!zzbl(30000L)) {
                zzaT(alternativeBillingOnlyReportingDetailsListener, zzdc.zzj, zzjd.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzy) {
                synchronized (this.zza) {
                    zzapVar = this.zzi;
                }
                if (zzapVar == null) {
                    zzaT(alternativeBillingOnlyReportingDetailsListener, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzapVar.zzk(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.zzc, this.zzd, this.zzJ.longValue()), new zzbx(alternativeBillingOnlyReportingDetailsListener, this.zzh, this.zzm, zzchVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support alternative billing only.");
                zzaT(alternativeBillingOnlyReportingDetailsListener, zzdc.zzC, zzjd.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaT(alternativeBillingOnlyReportingDetailsListener, zzdc.zzj, zzjd.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaT(alternativeBillingOnlyReportingDetailsListener, zzdc.zzh, zzjd.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaG(BillingProgramReportingDetailsListener billingProgramReportingDetailsListener, BillingProgramReportingDetailsParams billingProgramReportingDetailsParams) throws Exception {
        BillingProgramReportingDetailsListener billingProgramReportingDetailsListener2;
        BillingProgramReportingDetailsListener billingProgramReportingDetailsListener3;
        RuntimeException runtimeException;
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            try {
                if (!zzbl(30000L)) {
                    zzaU(billingProgramReportingDetailsListener, zzdc.zzj, zzjd.SERVICE_CONNECTION_NOT_READY, null);
                } else if (this.zzD) {
                    synchronized (this.zza) {
                        try {
                            try {
                                zzapVar = this.zzi;
                            } finally {
                                th = th;
                                while (true) {
                                    Throwable th = th;
                                    try {
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                            }
                        } catch (DeadObjectException e) {
                            e = e;
                            zzaU(billingProgramReportingDetailsListener3, zzdc.zzj, zzjd.SERVICE_CALL_EXCEPTION, deadObjectException);
                        } catch (RuntimeException e2) {
                            e = e2;
                            runtimeException = e;
                            zzaU(billingProgramReportingDetailsListener2, zzdc.zzh, zzjd.SERVICE_CALL_EXCEPTION, runtimeException);
                        }
                    }
                    if (zzapVar == null) {
                        zzaU(billingProgramReportingDetailsListener, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, null);
                    } else {
                        String str = this.zzc;
                        com.google.android.gms.internal.play_billing.zzdy zzdyVarZzb = zzdg.zzb(str, 24, this.zzg, zzdf.CREATE_BILLING_PROGRAM_REPORTING_DETAILS_ASYNC.zza());
                        zzhu zzhuVarZza = zzhx.zza();
                        zzio zzioVarZza = zziq.zza();
                        zzioVarZza.zza(str);
                        zzhuVarZza.zza("PLAY_BILLING_LIBRARY_VERSION", (zziq) zzioVarZza.zzi());
                        zzio zzioVarZza2 = zziq.zza();
                        zzioVarZza2.zza(this.zzg.getPackageName());
                        zzhuVarZza.zza("CALLING_PACKAGE", (zziq) zzioVarZza2.zzi());
                        zzio zzioVarZza3 = zziq.zza();
                        zzioVarZza3.zza(String.valueOf(billingProgramReportingDetailsParams.getBillingProgram()));
                        zzhuVarZza.zza("BILLING_PROGRAM", (zziq) zzioVarZza3.zzi());
                        zzio zzioVarZza4 = zziq.zza();
                        zzioVarZza4.zza("RESPONSE_FORMAT_PROTO");
                        zzhuVarZza.zza("RESPONSE_FORMAT", (zziq) zzioVarZza4.zzi());
                        if (billingProgramReportingDetailsParams.getBillingProgram() == 3) {
                            zzio zzioVarZza5 = zziq.zza();
                            zzioVarZza5.zza(String.valueOf(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).firstInstallTime));
                            zzhuVarZza.zza("APP_INSTALL_TIME_MILLIS", (zziq) zzioVarZza5.zzi());
                        }
                        zzapVar.zzm(zzdg.zza(zzdyVarZzb, (zzhx) zzhuVarZza.zzi()), new CreateBillingProgramReportingDetailsDelegateToBackendCallback(billingProgramReportingDetailsListener, billingProgramReportingDetailsParams.getBillingProgram(), this.zzh, this.zzm, zzav(), zzJ()));
                    }
                } else {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support the provided billing program.");
                    zzaU(billingProgramReportingDetailsListener, zzdc.zzF, zzjd.BILLING_PROGRAM_NOT_SUPPORTED, null);
                }
            } catch (DeadObjectException e3) {
                DeadObjectException deadObjectException = e3;
                billingProgramReportingDetailsListener3 = billingProgramReportingDetailsListener;
                zzaU(billingProgramReportingDetailsListener3, zzdc.zzj, zzjd.SERVICE_CALL_EXCEPTION, deadObjectException);
            } catch (RuntimeException e4) {
                runtimeException = e4;
                billingProgramReportingDetailsListener2 = billingProgramReportingDetailsListener;
                zzaU(billingProgramReportingDetailsListener2, zzdc.zzh, zzjd.SERVICE_CALL_EXCEPTION, runtimeException);
            }
        } catch (DeadObjectException e5) {
            e = e5;
            billingProgramReportingDetailsListener3 = billingProgramReportingDetailsListener;
        } catch (RuntimeException e6) {
            e = e6;
            billingProgramReportingDetailsListener2 = billingProgramReportingDetailsListener;
        }
        return null;
    }

    private final /* synthetic */ Void zzaH(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        zzch zzchVar = null;
        try {
            if (!zzbl(30000L)) {
                zzaV(externalOfferReportingDetailsListener, zzdc.zzj, zzjd.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzz) {
                synchronized (this.zza) {
                    zzapVar = this.zzi;
                }
                if (zzapVar == null) {
                    zzaV(externalOfferReportingDetailsListener, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.zzg.getPackageName();
                    long j = this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).firstInstallTime;
                    String str = this.zzc;
                    String str2 = this.zzd;
                    long jLongValue = this.zzJ.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, jLongValue);
                    bundle.putLong("appInstallTimeMillis", j);
                    zzapVar.zzl(22, packageName, bundle, new zzby(externalOfferReportingDetailsListener, this.zzh, this.zzm, zzchVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support external offer.");
                zzaV(externalOfferReportingDetailsListener, zzdc.zzt, zzjd.EXTERNAL_OFFER_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaV(externalOfferReportingDetailsListener, zzdc.zzj, zzjd.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaV(externalOfferReportingDetailsListener, zzdc.zzh, zzjd.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaI(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        zzch zzchVar = null;
        try {
            if (!zzbl(30000L)) {
                zzaQ(alternativeBillingOnlyAvailabilityListener, zzdc.zzj, zzjd.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzy) {
                synchronized (this.zza) {
                    zzapVar = this.zzi;
                }
                if (zzapVar == null) {
                    zzaQ(alternativeBillingOnlyAvailabilityListener, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzapVar.zzq(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.zzc, this.zzd, this.zzJ.longValue()), new zzcd(alternativeBillingOnlyAvailabilityListener, this.zzh, this.zzm, zzchVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support alternative billing only.");
                zzaQ(alternativeBillingOnlyAvailabilityListener, zzdc.zzC, zzjd.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaQ(alternativeBillingOnlyAvailabilityListener, zzdc.zzj, zzjd.IS_ALTERNATIVE_BILLING_ONLY_AVAILABLE_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaQ(alternativeBillingOnlyAvailabilityListener, zzdc.zzh, zzjd.IS_ALTERNATIVE_BILLING_ONLY_AVAILABLE_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaJ(BillingProgramAvailabilityListener billingProgramAvailabilityListener, int i) throws Exception {
        BillingClientImpl billingClientImpl;
        BillingProgramAvailabilityListener billingProgramAvailabilityListener2;
        int i2;
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            if (zzbl(30000L)) {
                billingClientImpl = this;
                billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
                i2 = i;
                try {
                    if (!billingClientImpl.zzD) {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support the provided billing program.");
                        billingClientImpl.zzaR(billingProgramAvailabilityListener2, i2, zzdc.zzF, zzjd.BILLING_PROGRAM_NOT_SUPPORTED, null);
                        return null;
                    }
                    synchronized (billingClientImpl.zza) {
                        zzapVar = billingClientImpl.zzi;
                    }
                    if (zzapVar == null) {
                        billingClientImpl.zzaR(billingProgramAvailabilityListener2, i2, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, null);
                        return null;
                    }
                    String str = billingClientImpl.zzc;
                    com.google.android.gms.internal.play_billing.zzdy zzdyVarZzb = zzdg.zzb(str, 24, billingClientImpl.zzg, zzdf.IS_BILLING_PROGRAM_AVAILABLE_ASYNC.zza());
                    zzhu zzhuVarZza = zzhx.zza();
                    zzio zzioVarZza = zziq.zza();
                    zzioVarZza.zza(str);
                    zzhuVarZza.zza("PLAY_BILLING_LIBRARY_VERSION", (zziq) zzioVarZza.zzi());
                    zzio zzioVarZza2 = zziq.zza();
                    zzioVarZza2.zza(billingClientImpl.zzg.getPackageName());
                    zzhuVarZza.zza("CALLING_PACKAGE", (zziq) zzioVarZza2.zzi());
                    zzio zzioVarZza3 = zziq.zza();
                    zzioVarZza3.zza(String.valueOf(i2));
                    zzhuVarZza.zza("BILLING_PROGRAM", (zziq) zzioVarZza3.zzi());
                    try {
                        zzapVar.zzm(zzdg.zza(zzdyVarZzb, (zzhx) zzhuVarZza.zzi()), new IsBillingProgramAvailableDelegateToBackendCallback(billingProgramAvailabilityListener2, i2, billingClientImpl.zzh, billingClientImpl.zzm, billingClientImpl.zzav(), billingClientImpl.zzJ()));
                        return null;
                    } catch (DeadObjectException e) {
                        e = e;
                        billingProgramAvailabilityListener2 = billingProgramAvailabilityListener2;
                        i2 = i2;
                    } catch (Exception e2) {
                        e = e2;
                        billingProgramAvailabilityListener2 = billingProgramAvailabilityListener2;
                        i2 = i2;
                        billingClientImpl.zzaR(billingProgramAvailabilityListener2, i2, zzdc.zzh, zzjd.SERVICE_CALL_EXCEPTION, e);
                        return null;
                    }
                } catch (DeadObjectException e3) {
                    e = e3;
                } catch (Exception e4) {
                    e = e4;
                }
            } else {
                try {
                    zzaR(billingProgramAvailabilityListener, i, zzdc.zzj, zzjd.SERVICE_CONNECTION_NOT_READY, null);
                    return null;
                } catch (DeadObjectException e5) {
                    e = e5;
                    billingClientImpl = this;
                    billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
                    i2 = i;
                } catch (Exception e6) {
                    e = e6;
                    billingClientImpl = this;
                    billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
                    i2 = i;
                    billingClientImpl.zzaR(billingProgramAvailabilityListener2, i2, zzdc.zzh, zzjd.SERVICE_CALL_EXCEPTION, e);
                    return null;
                }
            }
        } catch (DeadObjectException e7) {
            e = e7;
            billingClientImpl = this;
            billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
            i2 = i;
        } catch (Exception e8) {
            e = e8;
            billingClientImpl = this;
            billingProgramAvailabilityListener2 = billingProgramAvailabilityListener;
            i2 = i;
        }
        billingClientImpl.zzaR(billingProgramAvailabilityListener2, i2, zzdc.zzj, zzjd.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e);
        return null;
    }

    private final /* synthetic */ Void zzaK(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        zzch zzchVar = null;
        try {
            if (!zzbl(30000L)) {
                zzaW(externalOfferAvailabilityListener, zzdc.zzj, zzjd.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzB) {
                synchronized (this.zza) {
                    zzapVar = this.zzi;
                }
                if (zzapVar == null) {
                    zzaW(externalOfferAvailabilityListener, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzapVar.zzr(24, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.zzc, this.zzd, this.zzJ.longValue()), new zzce(externalOfferAvailabilityListener, this.zzh, this.zzm, zzchVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support external offer.");
                zzaW(externalOfferAvailabilityListener, zzdc.zzt, zzjd.EXTERNAL_OFFER_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaW(externalOfferAvailabilityListener, zzdc.zzj, zzjd.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaW(externalOfferAvailabilityListener, zzdc.zzh, zzjd.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaL(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            synchronized (this.zza) {
                zzapVar = this.zzi;
            }
            if (zzapVar == null) {
                zzba(alternativeBillingOnlyInformationDialogListener, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, null);
            } else {
                zzapVar.zzn(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.zzc, this.zzd, this.zzJ.longValue()), new zzbz(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzba(alternativeBillingOnlyInformationDialogListener, zzdc.zzj, zzjd.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzba(alternativeBillingOnlyInformationDialogListener, zzdc.zzh, zzjd.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaM(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            synchronized (this.zza) {
                zzapVar = this.zzi;
            }
            if (zzapVar == null) {
                zzaX(externalOfferInformationDialogListener, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, null);
            } else {
                zzapVar.zzp(22, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzh(this.zzc, this.zzd, this.zzJ.longValue()), new zzcb(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzaX(externalOfferInformationDialogListener, zzdc.zzj, zzjd.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaX(externalOfferInformationDialogListener, zzdc.zzh, zzjd.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final Future zzaN(Callable callable, long j, final Runnable runnable, Handler handler) throws Exception {
        try {
            final Future futureSubmit = zzJ().submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzbi
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Async task is taking too long, cancel it!");
                    runnable2.run();
                }
            }, 28500L);
            return futureSubmit;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Async task throws exception!", e);
            throw e;
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.android.billingclient.api.BillingClientImpl] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.android.billingclient.api.BillingClientImpl] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    private final void zzaO(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Throwable {
        ?? sb;
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        int iZza;
        String strZzk;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            sb = new StringBuilder("Consuming purchase with token: ");
            sb.append(purchaseToken);
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", sb.toString());
        } catch (DeadObjectException e) {
            e = e;
            sb = this;
        } catch (Exception e2) {
            e = e2;
            sb = this;
        }
        try {
            synchronized (this.zza) {
                try {
                    zzapVar = this.zzi;
                } catch (Throwable th) {
                    th = th;
                    while (true) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            }
            if (zzapVar == null) {
                zzaS(consumeResponseListener, purchaseToken, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                return;
            }
            boolean z = this.zzp;
            Context context = this.zzg;
            if (z) {
                String packageName = context.getPackageName();
                boolean z2 = this.zzp;
                String str = this.zzc;
                String str2 = this.zzd;
                long jLongValue = this.zzJ.longValue();
                Bundle bundle = new Bundle();
                if (z2) {
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, jLongValue);
                }
                Bundle bundleZze = zzapVar.zze(9, packageName, purchaseToken, bundle);
                iZza = bundleZze.getInt("RESPONSE_CODE");
                strZzk = com.google.android.gms.internal.play_billing.zzc.zzk(bundleZze, "BillingClient");
            } else {
                iZza = zzapVar.zza(3, context.getPackageName(), purchaseToken);
                strZzk = "";
            }
            BillingResult billingResultZza = zzdc.zza(iZza, strZzk);
            if (iZza == 0) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener.onConsumeResponse(billingResultZza, purchaseToken);
                return;
            } else {
                zzaS(consumeResponseListener, purchaseToken, billingResultZza, zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY, "Error consuming purchase with token. Response code: " + iZza, null);
                return;
            }
        } catch (DeadObjectException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
            sb.zzaS(consumeResponseListener, purchaseToken, zzdc.zzh, zzjd.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
            return;
        }
        sb.zzaS(consumeResponseListener, purchaseToken, zzdc.zzj, zzjd.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION, "Error consuming purchase!", e);
    }

    private final void zzaP(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error in acknowledge purchase!", exc);
        zzbu(zzjdVar, 3, billingResult, zzcy.zza(exc));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaQ(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        zzbu(zzjdVar, 14, billingResult, zzcy.zza(exc));
        alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaR(BillingProgramAvailabilityListener billingProgramAvailabilityListener, int i, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        zzbu(zzjdVar, 33, billingResult, zzcy.zza(exc));
        billingProgramAvailabilityListener.onBillingProgramAvailabilityResponse(billingResult, new BillingProgramAvailabilityDetails(i));
    }

    private final void zzaS(ConsumeResponseListener consumeResponseListener, String str, BillingResult billingResult, zzjd zzjdVar, String str2, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", str2, exc);
        zzbu(zzjdVar, 4, billingResult, zzcy.zza(exc));
        consumeResponseListener.onConsumeResponse(billingResult, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaT(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        zzbu(zzjdVar, 15, billingResult, zzcy.zza(exc));
        alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaU(BillingProgramReportingDetailsListener billingProgramReportingDetailsListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        zzbu(zzjdVar, 35, billingResult, zzcy.zza(exc));
        billingProgramReportingDetailsListener.onCreateBillingProgramReportingDetailsResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaV(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        zzbu(zzjdVar, 24, billingResult, zzcy.zza(exc));
        externalOfferReportingDetailsListener.onExternalOfferReportingDetailsResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaW(ExternalOfferAvailabilityListener externalOfferAvailabilityListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        zzbu(zzjdVar, 23, billingResult, zzcy.zza(exc));
        externalOfferAvailabilityListener.onExternalOfferAvailabilityResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaX(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        zzbu(zzjdVar, 25, billingResult, zzcy.zza(exc));
        externalOfferInformationDialogListener.onExternalOfferInformationDialogResponse(billingResult);
    }

    private final void zzaY(BillingConfigResponseListener billingConfigResponseListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "getBillingConfig got an exception.", exc);
        zzbu(zzjdVar, 13, billingResult, zzcy.zza(exc));
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaZ(LaunchExternalLinkResponseListener launchExternalLinkResponseListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        zzbu(zzjdVar, 37, billingResult, zzcy.zza(exc));
        launchExternalLinkResponseListener.onLaunchExternalLinkResponse(billingResult);
    }

    static /* bridge */ /* synthetic */ void zzak(BillingClientImpl billingClientImpl, int i) {
        billingClientImpl.zzm = i;
        billingClientImpl.zzD = i >= 27;
        billingClientImpl.zzC = i >= 26;
        billingClientImpl.zzB = i >= 24;
        billingClientImpl.zzA = i >= 23;
        billingClientImpl.zzz = i >= 22;
        billingClientImpl.zzy = i >= 21;
        billingClientImpl.zzx = i >= 20;
        billingClientImpl.zzw = i >= 19;
        billingClientImpl.zzv = i >= 18;
        billingClientImpl.zzu = i >= 17;
        billingClientImpl.zzt = i >= 16;
        billingClientImpl.zzs = i >= 15;
        billingClientImpl.zzr = i >= 14;
        billingClientImpl.zzq = i >= 12;
        billingClientImpl.zzp = i >= 9;
        billingClientImpl.zzo = i >= 8;
        billingClientImpl.zzn = i >= 6;
    }

    static /* bridge */ /* synthetic */ void zzam(BillingClientImpl billingClientImpl, int i) {
        if (i != 0) {
            billingClientImpl.zzbg(0);
            return;
        }
        synchronized (billingClientImpl.zza) {
            if (billingClientImpl.zzb == 3) {
                return;
            }
            billingClientImpl.zzbg(2);
            zzab zzabVar = billingClientImpl.zzf != null ? billingClientImpl.zzf : null;
            if (zzabVar != null) {
                zzabVar.zzi(billingClientImpl.zzy);
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean zzaq(BillingClientImpl billingClientImpl) {
        boolean z;
        synchronized (billingClientImpl.zza) {
            z = true;
            if (billingClientImpl.zzb != 1) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzat(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            synchronized (this.zza) {
                zzapVar = this.zzi;
            }
            return zzapVar == null ? com.google.android.gms.internal.play_billing.zzc.zzd(zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL) : zzapVar.zzg(i, this.zzg.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzdc.zzj, zzjd.LAUNCH_BILLING_FLOW_EXCEPTION, zzcy.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzdc.zzh, zzjd.LAUNCH_BILLING_FLOW_EXCEPTION, zzcy.zza(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzau(String str, String str2) throws Exception {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        try {
            synchronized (this.zza) {
                zzapVar = this.zzi;
            }
            return zzapVar == null ? com.google.android.gms.internal.play_billing.zzc.zzd(zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL) : zzapVar.zzf(3, this.zzg.getPackageName(), str, str2, null);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzdc.zzj, zzjd.LAUNCH_BILLING_FLOW_EXCEPTION, zzcy.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzdc.zzh, zzjd.LAUNCH_BILLING_FLOW_EXCEPTION, zzcy.zza(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzav() {
        return Looper.myLooper() == null ? this.zze : new Handler(Looper.myLooper());
    }

    private final zzcg zzaw(BillingResult billingResult, zzjd zzjdVar, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", str, exc);
        zzbu(zzjdVar, 7, billingResult, zzcy.zza(exc));
        return new zzcg(billingResult.getResponseCode(), billingResult.getDebugMessage(), new ArrayList(), new ArrayList());
    }

    private final BillingResult zzax(int i) {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Service connection is valid. No need to re-initialize.");
        zziy zziyVarZza = zzja.zza();
        zziyVarZza.zze(6);
        zzks zzksVarZza = zzku.zza();
        zzksVarZza.zze(true);
        zzksVarZza.zza(i > 0);
        zzksVarZza.zzb(i);
        zziyVarZza.zzd(zzksVarZza);
        zzbe((zzja) zziyVarZza.zzi());
        return zzdc.zzi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzay() {
        int[] iArr = {0, 3};
        synchronized (this.zza) {
            for (int i = 0; i < 2; i++) {
                if (this.zzb == iArr[i]) {
                    return zzdc.zzj;
                }
            }
            return zzdc.zzh;
        }
    }

    private final com.google.android.gms.internal.play_billing.zzdc zzaz(final int i) {
        if (this.zzF && !zzbm()) {
            return com.google.android.gms.internal.play_billing.zzu.zza(new com.google.android.gms.internal.play_billing.zzr() { // from class: com.android.billingclient.api.zzad
                @Override // com.google.android.gms.internal.play_billing.zzr
                public final Object zza(com.google.android.gms.internal.play_billing.zzp zzpVar) {
                    return BillingClientImpl.zzr(this.zza, i, zzpVar);
                }
            });
        }
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Already connected or not opted into auto reconnection.");
        return com.google.android.gms.internal.play_billing.zzcx.zza(zzdc.zzi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzba(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, BillingResult billingResult, zzjd zzjdVar, Exception exc) {
        zzbu(zzjdVar, 16, billingResult, zzcy.zza(exc));
        alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(billingResult);
    }

    private final void zzbb(int i, zzjd zzjdVar, Exception exc) {
        zziw zziwVar;
        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "showInAppMessages error.", exc);
        zzcz zzczVar = this.zzh;
        String strZza = zzcy.zza(exc);
        try {
            zzjb zzjbVarZza = zzjf.zza();
            zzjbVarZza.zzp(i);
            if (zzjdVar != null) {
                zzjbVarZza.zze(zzjdVar);
            }
            if (strZza != null) {
                zzjbVarZza.zza(strZza);
            }
            zziu zziuVarZza = zziw.zza();
            zziuVarZza.zzb(zzjbVarZza);
            zziuVarZza.zzp(30);
            zziwVar = (zziw) zziuVarZza.zzi();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to create logging payload", th);
            zziwVar = null;
        }
        zzczVar.zza(zziwVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbc(zziw zziwVar) {
        try {
            this.zzh.zzb(zziwVar, this.zzm);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbd(zziw zziwVar, long j, boolean z) {
        try {
            this.zzh.zze(zziwVar, this.zzm, j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbe(zzja zzjaVar) {
        try {
            this.zzh.zzg(zzjaVar, this.zzm);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbf(zzjd zzjdVar, BillingResult billingResult, int i) {
        try {
            int i2 = zzcy.zza;
            zziu zziuVar = (zziu) zzcy.zzb(zzjdVar, 6, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED).zzq();
            zzks zzksVarZza = zzku.zza();
            zzksVarZza.zza(i > 0);
            zzksVarZza.zzb(i);
            zziuVar.zze(zzksVarZza);
            zzbc((zziw) zziuVar.zzi());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbg(int i) {
        synchronized (this.zza) {
            if (this.zzb == 3) {
                return;
            }
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Setting clientState from " + zzbn(this.zzb) + " to " + zzbn(i));
            this.zzb = i;
        }
    }

    private final synchronized void zzbh() {
        ExecutorService executorService = this.zzI;
        if (executorService != null) {
            executorService.shutdownNow();
            this.zzI = null;
        }
    }

    private final void zzbi(BillingClientStateListener billingClientStateListener, int i) {
        zzjd zzjdVar;
        BillingResult billingResultZzax;
        BillingResult billingResult;
        synchronized (this.zza) {
            if (zzbm()) {
                billingResultZzax = zzax(i);
            } else {
                if (this.zzb == 1) {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Client is already in the process of connecting to billing service.");
                    zzjd zzjdVar2 = zzjd.BILLING_CLIENT_CONNECTING;
                    billingResult = zzdc.zzd;
                    zzbf(zzjdVar2, billingResult, i);
                } else if (this.zzb == 3) {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                    zzjd zzjdVar3 = zzjd.BILLING_CLIENT_CLOSED;
                    billingResult = zzdc.zzj;
                    zzbf(zzjdVar3, billingResult, i);
                } else {
                    zzbg(1);
                    if (i == 0) {
                        this.zzH = billingClientStateListener;
                        i = 0;
                    }
                    zzbj();
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Starting in-app billing setup.");
                    this.zzj = new zzbw(this, billingClientStateListener, i, null);
                    this.zzj.zzc();
                    Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                    intent.setPackage("com.android.vending");
                    List<ResolveInfo> listQueryIntentServices = this.zzg.getPackageManager().queryIntentServices(intent, 0);
                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                        zzjdVar = zzjd.INTENT_SERVICE_NOT_FOUND;
                    } else {
                        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
                        if (resolveInfo.serviceInfo != null) {
                            String str = resolveInfo.serviceInfo.packageName;
                            String str2 = resolveInfo.serviceInfo.name;
                            if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                zzjdVar = zzjd.INVALID_PHONESKY_PACKAGE;
                                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "The device doesn't have valid Play Store.");
                            } else {
                                ComponentName componentName = new ComponentName(str, str2);
                                Intent intent2 = new Intent(intent);
                                intent2.setComponent(componentName);
                                intent2.putExtra("playBillingLibraryVersion", this.zzc);
                                synchronized (this.zza) {
                                    if (this.zzb == 2) {
                                        billingResultZzax = zzax(i);
                                    } else if (this.zzb != 1) {
                                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                        zzjd zzjdVar4 = zzjd.BILLING_CLIENT_TRANSITIONED_OUT_OF_CONNECTING;
                                        billingResult = zzdc.zzj;
                                        zzbf(zzjdVar4, billingResult, i);
                                    } else {
                                        zzbw zzbwVar = this.zzj;
                                        if ((i <= 0 || Build.VERSION.SDK_INT < 29) ? this.zzg.bindService(intent2, zzbwVar, 1) : this.zzg.bindService(intent2, 1, zzJ(), zzbwVar)) {
                                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Service was bonded successfully.");
                                            billingResultZzax = null;
                                        } else {
                                            zzjdVar = zzjd.BILLING_SERVICE_BLOCKED;
                                            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Connection to Billing service is blocked.");
                                        }
                                    }
                                }
                            }
                        } else {
                            zzjdVar = zzjd.INVALID_PHONESKY_PACKAGE;
                            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "The device doesn't have valid Play Store.");
                        }
                    }
                    zzbg(0);
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing service unavailable on device.");
                    BillingResult billingResult2 = zzdc.zzb;
                    zzbf(zzjdVar, billingResult2, i);
                    billingResultZzax = billingResult2;
                }
                billingResultZzax = billingResult;
            }
        }
        if (billingResultZzax != null) {
            billingClientStateListener.onBillingSetupFinished(billingResultZzax);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzbj() {
        synchronized (this.zza) {
            if (this.zzj != null) {
                try {
                    this.zzg.unbindService(this.zzj);
                } catch (Throwable th) {
                    try {
                        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "There was an exception while unbinding service!", th);
                        this.zzi = null;
                        this.zzj = null;
                    } finally {
                        this.zzi = null;
                        this.zzj = null;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean zzbk(long j) {
        try {
            BillingResult billingResult = (BillingResult) zzaz(1).get(Build.VERSION.SDK_INT < 29 ? 0L : 3000L, TimeUnit.MILLISECONDS);
            if (billingResult.getResponseCode() == 0) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection succeeded with result: " + billingResult.getResponseCode());
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Reconnection failed with result: " + billingResult.getResponseCode());
            }
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error during reconnection attempt: ", e);
        }
        return zzbm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zzbl(long j) {
        long jMax;
        com.google.android.gms.internal.play_billing.zzbl zzblVarZzb = com.google.android.gms.internal.play_billing.zzbl.zzb(this.zzK);
        long jZza = 30000;
        for (int i = 1; i <= 3; i++) {
            try {
                jMax = Math.max(0L, jZza);
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error during reconnection attempt: ", e);
            }
            if (jMax <= 0) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "No time remaining for reconnection attempt.");
                return zzbm();
            }
            BillingResult billingResult = (BillingResult) zzaz(i).get(jMax, TimeUnit.MILLISECONDS);
            if (billingResult.getResponseCode() == 0) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection succeeded with result: " + billingResult.getResponseCode());
                return zzbm();
            }
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Reconnection failed with result: " + billingResult.getResponseCode());
            jZza = 30000 - zzblVarZzb.zza(TimeUnit.MILLISECONDS);
            long jPow = ((long) Math.pow(2.0d, i - 1)) * 1000;
            if (jZza < jPow) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Reconnection failed due to timeout limit reached.");
                return zzbm();
            }
            if (i < 3 && jPow > 0) {
                try {
                    Thread.sleep(jPow);
                    jZza = 30000 - zzblVarZzb.zza(TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error sleeping during reconnection attempt: ", e2);
                }
            }
        }
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Max retries reached.");
        return zzbm();
    }

    private final boolean zzbm() {
        boolean z;
        synchronized (this.zza) {
            z = false;
            if (this.zzb == 2 && this.zzi != null && this.zzj != null) {
                z = true;
            }
        }
        return z;
    }

    private static final String zzbn(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "CLOSED" : "CONNECTED" : "CONNECTING" : "DISCONNECTED";
    }

    private static final void zzbo(zzjp zzjpVar, Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                zzjpVar.zzv((int) (memoryInfo.totalMem / FileUtils.ONE_MB));
                zzjpVar.zzr(Build.BRAND);
                zzjpVar.zzu(Build.MODEL);
                zzjpVar.zzt(Build.MANUFACTURER);
                zzjpVar.zzs(Build.FINGERPRINT);
            }
        } catch (RuntimeException e) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Runtime error while populating device info.", e);
        }
    }

    private final zzdz zzbp(int i, BillingResult billingResult, zzjd zzjdVar, String str, Exception exc) {
        zzbu(zzjdVar, 9, billingResult, zzcy.zza(exc));
        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", str, exc);
        return new zzdz(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0178 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzdz zzbq(String str, boolean z, int i) {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        int i2;
        int i3;
        Bundle bundleZzi;
        BillingResult billingResultBuild;
        zzjd zzjdVar;
        BillingClientImpl billingClientImpl = this;
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z2 = billingClientImpl.zzp;
        boolean z3 = billingClientImpl.zzw;
        boolean zIsEnabledForOneTimeProducts = billingClientImpl.zzE.isEnabledForOneTimeProducts();
        boolean zIsEnabledForPrepaidPlans = billingClientImpl.zzE.isEnabledForPrepaidPlans();
        long jLongValue = billingClientImpl.zzJ.longValue();
        Bundle bundle = new Bundle();
        com.google.android.gms.internal.play_billing.zzc.zzc(bundle, billingClientImpl.zzc, billingClientImpl.zzd, jLongValue);
        if (z2 && zIsEnabledForOneTimeProducts) {
            bundle.putBoolean(InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, true);
        }
        if (z3 && zIsEnabledForPrepaidPlans) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        if (z) {
            bundle.putBoolean("includeSuspendedSubscriptions", true);
        }
        String string = null;
        do {
            try {
                synchronized (billingClientImpl.zza) {
                    zzapVar = billingClientImpl.zzi;
                }
                if (zzapVar == null) {
                    return billingClientImpl.zzbp(9, zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, "Service has been reset to null", null);
                }
                if (z && !billingClientImpl.zzC) {
                    return billingClientImpl.zzbp(9, zzdc.zzw, zzjd.INCLUDE_SUSPENDED_SUBSCRIPTIONS_NOT_SUPPORTED, "Include suspended subscriptions is not supported", null);
                }
                if (billingClientImpl.zzp) {
                    if (billingClientImpl.zzC) {
                        i3 = 26;
                    } else if (billingClientImpl.zzB) {
                        i3 = 24;
                    } else if (billingClientImpl.zzw) {
                        i3 = 19;
                    } else {
                        i2 = 9;
                        bundleZzi = zzapVar.zzi(i2, billingClientImpl.zzg.getPackageName(), str, string, bundle);
                    }
                    i2 = i3;
                    bundleZzi = zzapVar.zzi(i2, billingClientImpl.zzg.getPackageName(), str, string, bundle);
                } else {
                    bundleZzi = zzapVar.zzh(3, billingClientImpl.zzg.getPackageName(), str, string);
                }
                BillingResult billingResult = zzdc.zzh;
                if (bundleZzi == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", String.format("%s got null owned items list", "getPurchase()"));
                    zzjdVar = zzjd.NULL_OWNED_ITEMS_LIST;
                } else {
                    int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundleZzi, "BillingClient");
                    String strZzk = com.google.android.gms.internal.play_billing.zzc.zzk(bundleZzi, "BillingClient");
                    BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
                    builderNewBuilder.setResponseCode(iZzb);
                    builderNewBuilder.setDebugMessage(strZzk);
                    billingResultBuild = builderNewBuilder.build();
                    if (iZzb != 0) {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", String.format("%s failed. Response code: %s", "getPurchase()", Integer.valueOf(iZzb)));
                        zzjdVar = zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
                    } else if (bundleZzi.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundleZzi.containsKey("INAPP_PURCHASE_DATA_LIST") && bundleZzi.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                        ArrayList<String> stringArrayList = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                        ArrayList<String> stringArrayList2 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        ArrayList<String> stringArrayList3 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                        if (stringArrayList == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", "getPurchase()"));
                            zzjdVar = zzjd.NULL_SKUS_LIST;
                        } else if (stringArrayList2 == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", String.format("Bundle returned from %s contains null purchases list.", "getPurchase()"));
                            zzjdVar = zzjd.NULL_PURCHASES_LIST;
                        } else if (stringArrayList3 == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", String.format("Bundle returned from %s contains null signatures list.", "getPurchase()"));
                            zzjdVar = zzjd.NULL_SIGNATURES_LIST;
                        } else {
                            billingResultBuild = zzdc.zzi;
                            zzjdVar = zzjd.REASON_UNSPECIFIED;
                        }
                    } else {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", "getPurchase()"));
                        zzjdVar = zzjd.MISSING_REQUIRED_PURCHASE_KEY;
                    }
                    if (billingResultBuild == zzdc.zzi) {
                        return billingClientImpl.zzbp(9, billingResultBuild, zzjdVar, "Purchase bundle invalid", null);
                    }
                    ArrayList<String> stringArrayList4 = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList<String> stringArrayList5 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    ArrayList<String> stringArrayList6 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    boolean z4 = false;
                    for (int i4 = 0; i4 < stringArrayList5.size(); i4++) {
                        String str2 = stringArrayList5.get(i4);
                        String str3 = stringArrayList6.get(i4);
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList4.get(i4))));
                        try {
                            Purchase purchase = new Purchase(str2, str3);
                            if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "BUG: empty/null token!");
                                z4 = true;
                            }
                            arrayList.add(purchase);
                        } catch (JSONException e) {
                            return zzbp(9, zzdc.zzh, zzjd.ERROR_DECODING_PURCHASE_DATA, "Got an exception trying to decode the purchase!", e);
                        }
                    }
                    billingClientImpl = this;
                    if (z4) {
                        billingClientImpl.zzbs(zzjd.EMPTY_PURCHASE_TOKEN, 9, billingResult);
                    }
                    string = bundleZzi.getString("INAPP_CONTINUATION_TOKEN");
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                }
                billingResultBuild = billingResult;
                if (billingResultBuild == zzdc.zzi) {
                }
            } catch (DeadObjectException e2) {
                return zzbp(9, zzdc.zzj, zzjd.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e2);
            } catch (Exception e3) {
                return billingClientImpl.zzbp(9, zzdc.zzh, zzjd.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e3);
            }
        } while (!TextUtils.isEmpty(string));
        return new zzdz(zzdc.zzi, arrayList);
    }

    private final void zzbr(BillingResult billingResult, zzjd zzjdVar, int i) {
        zzja zzjaVar = null;
        zziw zziwVar = null;
        if (billingResult.getResponseCode() == 0) {
            int i2 = zzcy.zza;
            try {
                zziy zziyVarZza = zzja.zza();
                zziyVarZza.zze(5);
                zzjv zzjvVarZza = zzjy.zza();
                zzjvVarZza.zza(i);
                zziyVarZza.zzb((zzjy) zzjvVarZza.zzi());
                zzjaVar = (zzja) zziyVarZza.zzi();
            } catch (Exception e) {
                com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to create logging payload", e);
            }
            zzbe(zzjaVar);
            return;
        }
        int i3 = zzcy.zza;
        try {
            zziu zziuVarZza = zziw.zza();
            zzjb zzjbVarZza = zzjf.zza();
            zzjbVarZza.zzp(billingResult.getResponseCode());
            zzjbVarZza.zzb(billingResult.getDebugMessage());
            zzjbVarZza.zze(zzjdVar);
            zziuVarZza.zzb(zzjbVarZza);
            zziuVarZza.zzp(5);
            zzjv zzjvVarZza2 = zzjy.zza();
            zzjvVarZza2.zza(i);
            zziuVarZza.zzc((zzjy) zzjvVarZza2.zzi());
            zziwVar = (zziw) zziuVarZza.zzi();
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to create logging payload", e2);
        }
        zzbc(zziwVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbs(zzjd zzjdVar, int i, BillingResult billingResult) {
        try {
            int i2 = zzcy.zza;
            zzbc(zzcy.zzb(zzjdVar, i, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbt(zzjd zzjdVar, int i, BillingResult billingResult, long j) {
        try {
            int i2 = zzcy.zza;
            try {
                this.zzh.zzc(zzcy.zzb(zzjdVar, 2, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.zzm, j);
            } catch (Throwable th) {
                com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
            }
        } catch (Throwable th2) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th2);
        }
    }

    private final void zzbu(zzjd zzjdVar, int i, BillingResult billingResult, String str) {
        try {
            int i2 = zzcy.zza;
            zzbc(zzcy.zzb(zzjdVar, i, billingResult, str, zzjk.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbv(zzjd zzjdVar, int i, BillingResult billingResult, long j, boolean z) {
        try {
            int i2 = zzcy.zza;
            zzbd(zzcy.zzb(zzjdVar, 2, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbw(zzjd zzjdVar, int i, BillingResult billingResult, String str, long j, boolean z) {
        try {
            int i2 = zzcy.zza;
            zzbd(zzcy.zzb(zzjdVar, 2, billingResult, str, zzjk.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    private void zzbx(int i) {
        try {
            int i2 = zzcy.zza;
            zzbe(zzcy.zzc(i, zzjk.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to log.", th);
        }
    }

    static /* bridge */ /* synthetic */ ResultReceiver zzg(BillingClientImpl billingClientImpl, LaunchExternalLinkResponseListener launchExternalLinkResponseListener) {
        return new zzbt(billingClientImpl, billingClientImpl.zze, launchExternalLinkResponseListener);
    }

    static /* bridge */ /* synthetic */ BillingResult zzm(Exception exc) {
        return exc instanceof DeadObjectException ? zzdc.zzj : zzdc.zzh;
    }

    public static /* synthetic */ Object zzr(BillingClientImpl billingClientImpl, int i, com.google.android.gms.internal.play_billing.zzp zzpVar) {
        billingClientImpl.zzbi(new zzbs(billingClientImpl, zzpVar), i);
        return "reconnectIfNeeded";
    }

    public static /* synthetic */ Object zzs(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) throws Throwable {
        if (billingClientImpl.zzbl(30000L)) {
            billingClientImpl.zzaO(consumeParams, consumeResponseListener);
            return null;
        }
        zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
        BillingResult billingResult = zzdc.zzj;
        billingClientImpl.zzbs(zzjdVar, 4, billingResult);
        consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
        return null;
    }

    public static /* synthetic */ Object zzt(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener, QueryProductDetailsParams queryProductDetailsParams) throws JSONException {
        if (!billingClientImpl.zzbl(30000L)) {
            zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzdc.zzj;
            billingClientImpl.zzbs(zzjdVar, 7, billingResult);
            productDetailsResponseListener.onProductDetailsResponse(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbw.zzk(), com.google.android.gms.internal.play_billing.zzbw.zzk()));
            return null;
        }
        if (billingClientImpl.zzu) {
            zzcg zzcgVarZzh = billingClientImpl.zzh(queryProductDetailsParams);
            productDetailsResponseListener.onProductDetailsResponse(zzdc.zza(zzcgVarZzh.zza(), zzcgVarZzh.zzb()), new QueryProductDetailsResult(zzcgVarZzh.zzc(), zzcgVarZzh.zzd()));
            return null;
        }
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Querying product details is not supported.");
        zzjd zzjdVar2 = zzjd.PRODUCT_DETAILS_NOT_SUPPORTED;
        BillingResult billingResult2 = zzdc.zzr;
        billingClientImpl.zzbs(zzjdVar2, 7, billingResult2);
        productDetailsResponseListener.onProductDetailsResponse(billingResult2, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbw.zzk(), com.google.android.gms.internal.play_billing.zzbw.zzk()));
        return null;
    }

    public static /* synthetic */ Object zzu(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) throws Exception {
        billingClientImpl.zzaA(acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
        return null;
    }

    public static /* synthetic */ Object zzv(BillingClientImpl billingClientImpl, Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        billingClientImpl.zzaC(bundle, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Object zzw(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        billingClientImpl.zzaB(billingConfigResponseListener);
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzaj
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzu(this.zza, acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzak
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzR(this.zza, acknowledgePurchaseResponseListener);
            }
        }, zzav(), zzJ()) == null) {
            BillingResult billingResultZzay = zzay();
            zzbs(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 3, billingResultZzay);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResultZzay);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzba
            @Override // java.util.concurrent.Callable
            public final Object call() throws Throwable {
                BillingClientImpl.zzs(this.zza, consumeResponseListener, consumeParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbb
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzL(this.zza, consumeResponseListener, consumeParams);
            }
        }, zzav(), zzJ()) == null) {
            BillingResult billingResultZzay = zzay();
            zzbs(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 4, billingResultZzay);
            consumeResponseListener.onConsumeResponse(billingResultZzay, consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createAlternativeBillingOnlyReportingDetailsAsync(final AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzau
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzG(this.zza, alternativeBillingOnlyReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzav
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaT(alternativeBillingOnlyReportingDetailsListener, zzdc.zzk, zzjd.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzav(), zzJ()) == null) {
            zzaT(alternativeBillingOnlyReportingDetailsListener, zzay(), zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createBillingProgramReportingDetailsAsync(final BillingProgramReportingDetailsParams billingProgramReportingDetailsParams, final BillingProgramReportingDetailsListener billingProgramReportingDetailsListener) {
        BillingClientImpl billingClientImpl;
        try {
            billingClientImpl = this;
        } catch (Exception e) {
            e = e;
            billingClientImpl = this;
        }
        try {
            billingClientImpl.zzaN(new Callable() { // from class: com.android.billingclient.api.zzao
                @Override // java.util.concurrent.Callable
                public final Object call() throws Exception {
                    BillingClientImpl.zzH(this.zza, billingProgramReportingDetailsListener, billingProgramReportingDetailsParams);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzap
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzaU(billingProgramReportingDetailsListener, zzdc.zzk, zzjd.EXECUTE_ASYNC_TIMEOUT, null);
                }
            }, zzav());
        } catch (Exception e2) {
            e = e2;
            billingClientImpl.zzaU(billingProgramReportingDetailsListener, billingClientImpl.zzay(), zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, e);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createExternalOfferReportingDetailsAsync(final ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzaw
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzE(this.zza, externalOfferReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbe
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaV(externalOfferReportingDetailsListener, zzdc.zzk, zzjd.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzav(), zzJ()) == null) {
            zzaV(externalOfferReportingDetailsListener, zzay(), zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void endConnection() {
        zzbx(12);
        synchronized (this.zza) {
            try {
            } finally {
            }
            if (this.zzf != null) {
                this.zzf.zzh();
                try {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Unbinding from service.");
                    zzbj();
                } catch (Throwable th) {
                    com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "There was an exception while unbinding from the service while ending connection!", th);
                }
                try {
                    zzbh();
                } finally {
                    try {
                    } finally {
                    }
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Unbinding from service.");
                zzbj();
                zzbh();
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, final BillingConfigResponseListener billingConfigResponseListener) {
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzaq
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzw(this.zza, billingConfigResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzar
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzN(this.zza, billingConfigResponseListener);
            }
        }, zzav(), zzJ()) == null) {
            BillingResult billingResultZzay = zzay();
            zzbs(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 13, billingResultZzay);
            billingConfigResponseListener.onBillingConfigResponse(billingResultZzay, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        int i;
        synchronized (this.zza) {
            i = this.zzb;
        }
        return i;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isAlternativeBillingOnlyAvailableAsync(final AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzax
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzI(this.zza, alternativeBillingOnlyAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzay
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaQ(alternativeBillingOnlyAvailabilityListener, zzdc.zzk, zzjd.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzav(), zzJ()) == null) {
            zzaQ(alternativeBillingOnlyAvailabilityListener, zzay(), zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isBillingProgramAvailableAsync(final int i, final BillingProgramAvailabilityListener billingProgramAvailabilityListener) {
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzal
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzC(this.zza, billingProgramAvailabilityListener, i);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzam
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaR(billingProgramAvailabilityListener, i, zzdc.zzk, zzjd.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzav(), zzJ()) == null) {
            zzaR(billingProgramAvailabilityListener, i, zzay(), zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isExternalOfferAvailableAsync(final ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzbk
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzB(this.zza, externalOfferAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzae
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaW(externalOfferAvailabilityListener, zzdc.zzk, zzjd.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzav(), zzJ()) == null) {
            zzaW(externalOfferAvailabilityListener, zzay(), zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        if (!zzbk(3000L)) {
            BillingResult billingResult = zzdc.zzj;
            zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
            if (billingResult.getResponseCode() != 0) {
                zzbs(zzjdVar, 5, billingResult);
                return billingResult;
            }
            zzbx(5);
            return billingResult;
        }
        int i = zzdc.zzI;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE)) {
                    BillingResult billingResult2 = this.zzl ? zzdc.zzi : zzdc.zzm;
                    zzbr(billingResult2, zzjd.SUBSCRIPTIONS_UPDATE_NOT_SUPPORTED, 3);
                    return billingResult2;
                }
                break;
            case 96321:
                if (str.equals("aaa")) {
                    BillingResult billingResult3 = this.zzs ? zzdc.zzi : zzdc.zzo;
                    zzbr(billingResult3, zzjd.CROSS_APP_NOT_SUPPORTED, 6);
                    return billingResult3;
                }
                break;
            case 97314:
                if (str.equals(BillingClient.FeatureType.IN_APP_MESSAGING)) {
                    BillingResult billingResult4 = this.zzq ? zzdc.zzi : zzdc.zzs;
                    zzbr(billingResult4, zzjd.IN_APP_MESSAGE_NOT_SUPPORTED, 5);
                    return billingResult4;
                }
                break;
            case 98307:
                if (str.equals("ccc")) {
                    BillingResult billingResult5 = this.zzt ? zzdc.zzi : zzdc.zzp;
                    zzbr(billingResult5, zzjd.MULTI_ITEM_NOT_SUPPORTED, 8);
                    return billingResult5;
                }
                break;
            case 99300:
                if (str.equals("ddd")) {
                    BillingResult billingResult6 = this.zzr ? zzdc.zzi : zzdc.zzq;
                    zzbr(billingResult6, zzjd.OFFER_ID_TOKEN_NOT_SUPPORTED, 7);
                    return billingResult6;
                }
                break;
            case 100293:
                if (str.equals("eee")) {
                    BillingResult billingResult7 = this.zzt ? zzdc.zzi : zzdc.zzp;
                    zzbr(billingResult7, zzjd.PBL_FOR_PAYMENTS_GATEWAY_BUYFLOW_NOT_SUPPORTED, 9);
                    return billingResult7;
                }
                break;
            case 101286:
                if (str.equals(BillingClient.FeatureType.PRODUCT_DETAILS)) {
                    BillingResult billingResult8 = this.zzu ? zzdc.zzi : zzdc.zzr;
                    zzbr(billingResult8, zzjd.PRODUCT_DETAILS_NOT_SUPPORTED, 10);
                    return billingResult8;
                }
                break;
            case 102279:
                if (str.equals(BillingClient.FeatureType.BILLING_CONFIG)) {
                    BillingResult billingResult9 = this.zzv ? zzdc.zzi : zzdc.zzy;
                    zzbr(billingResult9, zzjd.GET_BILLING_CONFIG_NOT_SUPPORTED, 11);
                    return billingResult9;
                }
                break;
            case 103272:
                if (str.equals("hhh")) {
                    BillingResult billingResult10 = this.zzv ? zzdc.zzi : zzdc.zzz;
                    zzbr(billingResult10, zzjd.QUERY_PRODUCT_DETAILS_WITH_SERIALIZED_DOCID_NOT_SUPPORTED, 12);
                    return billingResult10;
                }
                break;
            case 104265:
                if (str.equals("iii")) {
                    BillingResult billingResult11 = this.zzx ? zzdc.zzi : zzdc.zzB;
                    zzbr(billingResult11, zzjd.QUERY_PRODUCT_DETAILS_WITH_DEVELOPER_SPECIFIED_ACCOUNT_NOT_SUPPORTED, 13);
                    return billingResult11;
                }
                break;
            case 105258:
                if (str.equals(BillingClient.FeatureType.ALTERNATIVE_BILLING_ONLY)) {
                    BillingResult billingResult12 = this.zzy ? zzdc.zzi : zzdc.zzC;
                    zzbr(billingResult12, zzjd.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, 14);
                    return billingResult12;
                }
                break;
            case 106251:
                if (str.equals(BillingClient.FeatureType.EXTERNAL_OFFER)) {
                    BillingResult billingResult13 = this.zzB ? zzdc.zzi : zzdc.zzt;
                    zzbr(billingResult13, zzjd.EXTERNAL_OFFER_NOT_SUPPORTED, 18);
                    return billingResult13;
                }
                break;
            case 107244:
                if (str.equals("lll")) {
                    BillingResult billingResult14 = this.zzA ? zzdc.zzi : zzdc.zzu;
                    zzbr(billingResult14, zzjd.MULTI_ITEM_WITH_SEASON_PASS_NOT_SUPPORTED, 19);
                    return billingResult14;
                }
                break;
            case 108237:
                if (str.equals("mmm")) {
                    BillingResult billingResult15 = this.zzB ? zzdc.zzi : zzdc.zzv;
                    zzbr(billingResult15, zzjd.AUTO_PAY_NOT_SUPPORTED, 20);
                    return billingResult15;
                }
                break;
            case 109230:
                if (str.equals(BillingClient.FeatureType.INCLUDE_SUSPENDED_SUBSCRIPTIONS)) {
                    BillingResult billingResult16 = this.zzC ? zzdc.zzi : zzdc.zzw;
                    zzbr(billingResult16, zzjd.INCLUDE_SUSPENDED_SUBSCRIPTIONS_NOT_SUPPORTED, 21);
                    return billingResult16;
                }
                break;
            case 207616302:
                if (str.equals(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION)) {
                    BillingResult billingResult17 = this.zzo ? zzdc.zzi : zzdc.zzn;
                    zzbr(billingResult17, zzjd.PRICE_CHANGE_CONFIRMATION_NOT_SUPPORTED, 4);
                    return billingResult17;
                }
                break;
            case 1987365622:
                if (str.equals("subscriptions")) {
                    BillingResult billingResult18 = this.zzk ? zzdc.zzi : zzdc.zzl;
                    zzbr(billingResult18, zzjd.SUBSCRIPTIONS_NOT_SUPPORTED, 2);
                    return billingResult18;
                }
                break;
        }
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unsupported feature: ".concat(String.valueOf(str)));
        BillingResult billingResult19 = zzdc.zzx;
        zzbr(billingResult19, zzjd.UNKNOWN_FEATURE, 1);
        return billingResult19;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        if (this.zzF) {
            return true;
        }
        return zzbm();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:131:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03e5  */
    /* JADX WARN: Type inference failed for: r31v0, types: [com.android.billingclient.api.BillingClientImpl] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    @Override // com.android.billingclient.api.BillingClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BillingResult launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams) {
        boolean zZzd;
        String productId;
        String productType;
        Activity activity2;
        long j;
        String string;
        Future futureZzK;
        ?? r5;
        zzjd zzjdVarZzb;
        Object obj;
        int i;
        String str;
        int i2;
        String str2;
        Intent intent;
        long jNextLong = new Random().nextLong();
        if (this.zzf == null || this.zzf.zzf() == null) {
            zzjd zzjdVar = zzjd.MISSING_LISTENER;
            BillingResult billingResult = zzdc.zzD;
            zzbt(zzjdVar, 2, billingResult, jNextLong);
            return billingResult;
        }
        if (billingFlowParams.getDeveloperBillingOptionParams() != null && this.zzf.zzd() == null) {
            zzjd zzjdVar2 = zzjd.MISSING_DEVELOPER_PROVIDED_BILLING_LISTENER;
            BillingResult billingResult2 = zzdc.zzH;
            zzbt(zzjdVar2, 2, billingResult2, jNextLong);
            return billingResult2;
        }
        if (!zzbk(3000L)) {
            zzjd zzjdVar3 = zzjd.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult3 = zzdc.zzj;
            zzbt(zzjdVar3, 2, billingResult3, jNextLong);
            zzn(billingResult3);
            return billingResult3;
        }
        synchronized (this.zza) {
            zZzd = this.zzj != null ? this.zzj.zzd() : false;
        }
        ArrayList<SkuDetails> arrayListZzj = billingFlowParams.zzj();
        List listZzk = billingFlowParams.zzk();
        SkuDetails skuDetails = (SkuDetails) com.google.android.gms.internal.play_billing.zzcb.zza(arrayListZzj, null);
        BillingFlowParams.ProductDetailsParams productDetailsParams = (BillingFlowParams.ProductDetailsParams) com.google.android.gms.internal.play_billing.zzcb.zza(listZzk, null);
        if (skuDetails != null) {
            productId = skuDetails.getSku();
            productType = skuDetails.getType();
        } else {
            productId = productDetailsParams.zza().getProductId();
            productType = productDetailsParams.zza().getProductType();
        }
        final String str3 = productId;
        final String str4 = productType;
        if (str4.equals("subs") && !this.zzk) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support subscriptions.");
            zzjd zzjdVar4 = zzjd.SUBSCRIPTIONS_NOT_SUPPORTED;
            BillingResult billingResult4 = zzdc.zzl;
            zzbv(zzjdVar4, 2, billingResult4, jNextLong, zZzd);
            zzn(billingResult4);
            return billingResult4;
        }
        if (billingFlowParams.zzu() && !this.zzn) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support extra params for buy intent.");
            zzjd zzjdVar5 = zzjd.EXTRA_PARAMS_NOT_SUPPORTED;
            BillingResult billingResult5 = zzdc.zzf;
            zzbv(zzjdVar5, 2, billingResult5, jNextLong, zZzd);
            zzn(billingResult5);
            return billingResult5;
        }
        if (arrayListZzj.size() > 1 && !this.zzt) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support multi-item purchases.");
            zzjd zzjdVar6 = zzjd.MULTI_ITEM_NOT_SUPPORTED;
            BillingResult billingResult6 = zzdc.zzp;
            zzbv(zzjdVar6, 2, billingResult6, jNextLong, zZzd);
            zzn(billingResult6);
            return billingResult6;
        }
        if (!listZzk.isEmpty() && !this.zzu) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            zzjd zzjdVar7 = zzjd.PRODUCT_DETAILS_NOT_SUPPORTED;
            BillingResult billingResult7 = zzdc.zzr;
            zzbv(zzjdVar7, 2, billingResult7, jNextLong, zZzd);
            zzn(billingResult7);
            return billingResult7;
        }
        BillingResult billingResultZzd = billingFlowParams.zzd();
        if (billingResultZzd != zzdc.zzi) {
            zzbv(zzjd.INVALID_BILLING_FLOW_PARAMS, 2, billingResultZzd, jNextLong, zZzd);
            zzn(billingResultZzd);
            return billingResultZzd;
        }
        boolean z = zZzd;
        if (this.zzn) {
            int i3 = 1;
            long j2 = jNextLong;
            String str5 = null;
            final Bundle bundleZzf = com.google.android.gms.internal.play_billing.zzc.zzf(billingFlowParams, this.zzp, this.zzw, this.zzE.isEnabledForOneTimeProducts(), this.zzE.isEnabledForPrepaidPlans(), this.zzG, this.zzc, this.zzd, this.zzJ.longValue(), this.zzg.getPackageName(), j2);
            if (arrayListZzj.isEmpty()) {
                i = 1;
                str = null;
                ArrayList<String> arrayList = new ArrayList<>(listZzk.size() - 1);
                ArrayList<String> arrayList2 = new ArrayList<>(listZzk.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                ArrayList<Integer> arrayList6 = new ArrayList<>();
                for (int i4 = 0; i4 < listZzk.size(); i4++) {
                    BillingFlowParams.ProductDetailsParams productDetailsParams2 = (BillingFlowParams.ProductDetailsParams) listZzk.get(i4);
                    ProductDetails productDetailsZza = productDetailsParams2.zza();
                    if (!productDetailsZza.zzb().isEmpty()) {
                        arrayList3.add(productDetailsZza.zzb());
                    }
                    String strZzb = productDetailsParams2.zzb();
                    arrayList4.add(strZzb);
                    String strZzc = productDetailsZza.zzc(strZzb);
                    if (!TextUtils.isEmpty(strZzc)) {
                        arrayList5.add(strZzc);
                    }
                    if (i4 > 0) {
                        arrayList.add(((BillingFlowParams.ProductDetailsParams) listZzk.get(i4)).zza().getProductId());
                        arrayList2.add(((BillingFlowParams.ProductDetailsParams) listZzk.get(i4)).zza().getProductType());
                    }
                }
                bundleZzf.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                if (!arrayList6.isEmpty()) {
                    bundleZzf.putIntegerArrayList("autoPayBalanceThresholdList", arrayList6);
                }
                if (!arrayList3.isEmpty()) {
                    bundleZzf.putStringArrayList("skuDetailsTokens", arrayList3);
                }
                if (!arrayList5.isEmpty()) {
                    bundleZzf.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (!arrayList.isEmpty()) {
                    bundleZzf.putStringArrayList("additionalSkus", arrayList);
                    bundleZzf.putStringArrayList("additionalSkuTypes", arrayList2);
                }
            } else {
                ArrayList<String> arrayList7 = new ArrayList<>();
                ArrayList<String> arrayList8 = new ArrayList<>();
                ArrayList<String> arrayList9 = new ArrayList<>();
                ArrayList<Integer> arrayList10 = new ArrayList<>();
                ArrayList<String> arrayList11 = new ArrayList<>();
                boolean z2 = false;
                boolean z3 = false;
                int i5 = 0;
                boolean z4 = false;
                for (SkuDetails skuDetails2 : arrayListZzj) {
                    if (!skuDetails2.zzf().isEmpty()) {
                        arrayList7.add(skuDetails2.zzf());
                    }
                    String strZzc2 = skuDetails2.zzc();
                    String str6 = str5;
                    String strZzb2 = skuDetails2.zzb();
                    int iZza = skuDetails2.zza();
                    int i6 = i3;
                    String strZze = skuDetails2.zze();
                    arrayList8.add(strZzc2);
                    z2 |= !TextUtils.isEmpty(strZzc2);
                    arrayList9.add(strZzb2);
                    z3 |= !TextUtils.isEmpty(strZzb2);
                    arrayList10.add(Integer.valueOf(iZza));
                    i5 |= iZza != 0 ? i6 : 0;
                    z4 |= !TextUtils.isEmpty(strZze);
                    arrayList11.add(strZze);
                    str5 = str6;
                    i3 = i6;
                }
                int i7 = i3;
                str = str5;
                if (!arrayList7.isEmpty()) {
                    bundleZzf.putStringArrayList("skuDetailsTokens", arrayList7);
                }
                if (z2) {
                    bundleZzf.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList8);
                }
                if (z3) {
                    bundleZzf.putStringArrayList("SKU_OFFER_ID_LIST", arrayList9);
                }
                if (i5 != 0) {
                    bundleZzf.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList10);
                }
                if (z4) {
                    bundleZzf.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList11);
                }
                i = i7;
                if (arrayListZzj.size() > i) {
                    ArrayList<String> arrayList12 = new ArrayList<>(arrayListZzj.size() - 1);
                    ArrayList<String> arrayList13 = new ArrayList<>(arrayListZzj.size() - 1);
                    for (int i8 = i; i8 < arrayListZzj.size(); i8++) {
                        arrayList12.add(((SkuDetails) arrayListZzj.get(i8)).getSku());
                        arrayList13.add(((SkuDetails) arrayListZzj.get(i8)).getType());
                    }
                    bundleZzf.putStringArrayList("additionalSkus", arrayList12);
                    bundleZzf.putStringArrayList("additionalSkuTypes", arrayList13);
                }
            }
            if (bundleZzf.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.zzr) {
                zzjd zzjdVar8 = zzjd.OFFER_ID_TOKEN_NOT_SUPPORTED;
                BillingResult billingResult8 = zzdc.zzq;
                zzbv(zzjdVar8, 2, billingResult8, j2, z);
                zzn(billingResult8);
                return billingResult8;
            }
            if (skuDetails != null && !TextUtils.isEmpty(skuDetails.zzd())) {
                bundleZzf.putString("skuPackageName", skuDetails.zzd());
            } else if (productDetailsParams == null || TextUtils.isEmpty(productDetailsParams.zza().zza())) {
                i2 = 0;
                if (TextUtils.isEmpty(str)) {
                    str2 = str;
                    bundleZzf.putString("accountName", str2);
                } else {
                    str2 = str;
                }
                intent = activity.getIntent();
                if (intent != null) {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Activity's intent is null.");
                } else if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                    String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                    bundleZzf.putString("proxyPackage", stringExtra);
                    try {
                        bundleZzf.putString("proxyPackageVersion", this.zzg.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                    } catch (PackageManager.NameNotFoundException unused) {
                        bundleZzf.putString("proxyPackageVersion", "package not found");
                    }
                }
                final int i9 = (this.zzu || listZzk.isEmpty()) ? (this.zzs || i2 == 0) ? !this.zzp ? 9 : 6 : 15 : 17;
                activity2 = activity;
                string = str2;
                final BillingFlowParams billingFlowParams2 = billingFlowParams;
                futureZzK = zzK(new Callable() { // from class: com.android.billingclient.api.zzaf
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zza.zzat(i9, str3, str4, billingFlowParams2, bundleZzf);
                    }
                }, 5000L, null, this.zze, zzJ());
                r5 = billingFlowParams2;
                j = j2;
            } else {
                bundleZzf.putString("skuPackageName", productDetailsParams.zza().zza());
            }
            i2 = i;
            if (TextUtils.isEmpty(str)) {
            }
            intent = activity.getIntent();
            if (intent != null) {
            }
            if (this.zzu) {
                if (this.zzs) {
                    final int i92 = (this.zzu || listZzk.isEmpty()) ? (this.zzs || i2 == 0) ? !this.zzp ? 9 : 6 : 15 : 17;
                    activity2 = activity;
                    string = str2;
                    final BillingFlowParams billingFlowParams22 = billingFlowParams;
                    futureZzK = zzK(new Callable() { // from class: com.android.billingclient.api.zzaf
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zza.zzat(i92, str3, str4, billingFlowParams22, bundleZzf);
                        }
                    }, 5000L, null, this.zze, zzJ());
                    r5 = billingFlowParams22;
                    j = j2;
                }
            }
        } else {
            activity2 = activity;
            j = jNextLong;
            string = null;
            futureZzK = zzK(new Callable() { // from class: com.android.billingclient.api.zzag
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzau(str3, str4);
                }
            }, 5000L, null, this.zze, zzJ());
            r5 = jNextLong;
        }
        try {
            if (futureZzK == null) {
                try {
                    zzjd zzjdVar9 = zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC;
                    BillingResult billingResult9 = zzdc.zzc;
                    zzbv(zzjdVar9, 2, billingResult9, j, z);
                    zzn(billingResult9);
                    return billingResult9;
                } catch (CancellationException e) {
                    e = e;
                    r5 = j;
                    com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzjd zzjdVar10 = zzjd.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult10 = zzdc.zzk;
                    zzbw(zzjdVar10, 2, billingResult10, zzcy.zza(e), r5, z);
                    zzn(billingResult10);
                    return billingResult10;
                } catch (TimeoutException e2) {
                    e = e2;
                    r5 = j;
                    com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzjd zzjdVar102 = zzjd.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult102 = zzdc.zzk;
                    zzbw(zzjdVar102, 2, billingResult102, zzcy.zza(e), r5, z);
                    zzn(billingResult102);
                    return billingResult102;
                } catch (Exception e3) {
                    e = e3;
                    r5 = j;
                    com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
                    zzjd zzjdVar11 = zzjd.LAUNCH_BILLING_FLOW_EXCEPTION;
                    BillingResult billingResult11 = zzdc.zzj;
                    zzbw(zzjdVar11, 2, billingResult11, zzcy.zza(e), r5, z);
                    zzn(billingResult11);
                    return billingResult11;
                }
            }
            long j3 = j;
            Bundle bundle = (Bundle) futureZzK.get(5000L, TimeUnit.MILLISECONDS);
            int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
            String strZzk = com.google.android.gms.internal.play_billing.zzc.zzk(bundle, "BillingClient");
            if (iZzb == 0) {
                Intent intent2 = new Intent(activity2, (Class<?>) ProxyBillingActivity.class);
                intent2.putExtra("BUY_INTENT", (PendingIntent) bundle.getParcelable("BUY_INTENT"));
                intent2.putExtra("billingClientTransactionId", j3);
                intent2.putExtra("wasServiceAutoReconnected", z);
                activity2.startActivity(intent2);
                return zzdc.zzi;
            }
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to buy item, Error response code: " + iZzb);
            BillingResult billingResultZza = zzdc.zza(iZzb, strZzk);
            try {
                if (bundle == null || (obj = bundle.get("LOG_REASON")) == null) {
                    zzjdVarZzb = zzjd.REASON_UNSPECIFIED;
                } else if (obj instanceof Integer) {
                    zzjdVarZzb = zzjd.zzb(((Integer) obj).intValue());
                } else {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unexpected type for bundle log reason: " + obj.getClass().getName());
                    zzjdVarZzb = zzjd.REASON_UNSPECIFIED;
                }
            } catch (Throwable th) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Failed to get log reason from bundle: ".concat(String.valueOf(th.getMessage())));
                zzjdVarZzb = zzjd.REASON_UNSPECIFIED;
            }
            if (zzjdVarZzb == zzjd.REASON_UNSPECIFIED) {
                zzjdVarZzb = zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            }
            zzjd zzjdVar12 = zzjdVarZzb;
            if (bundle != null) {
                try {
                    string = bundle.getString("ADDITIONAL_LOG_DETAILS");
                } catch (Throwable th2) {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Failed to get additional log details from bundle: ".concat(String.valueOf(th2.getMessage())));
                }
            }
            try {
                zzbw(zzjdVar12, 2, billingResultZza, string, j3, z);
                zzn(billingResultZza);
                return billingResultZza;
            } catch (CancellationException e4) {
                e = e4;
                r5 = j3;
                z = z;
                com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                zzjd zzjdVar1022 = zzjd.LAUNCH_BILLING_FLOW_TIMEOUT;
                BillingResult billingResult1022 = zzdc.zzk;
                zzbw(zzjdVar1022, 2, billingResult1022, zzcy.zza(e), r5, z);
                zzn(billingResult1022);
                return billingResult1022;
            } catch (TimeoutException e5) {
                e = e5;
                r5 = j3;
                z = z;
                com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                zzjd zzjdVar10222 = zzjd.LAUNCH_BILLING_FLOW_TIMEOUT;
                BillingResult billingResult10222 = zzdc.zzk;
                zzbw(zzjdVar10222, 2, billingResult10222, zzcy.zza(e), r5, z);
                zzn(billingResult10222);
                return billingResult10222;
            } catch (Exception e6) {
                e = e6;
                r5 = j3;
                z = z;
                com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
                zzjd zzjdVar112 = zzjd.LAUNCH_BILLING_FLOW_EXCEPTION;
                BillingResult billingResult112 = zzdc.zzj;
                zzbw(zzjdVar112, 2, billingResult112, zzcy.zza(e), r5, z);
                zzn(billingResult112);
                return billingResult112;
            }
        } catch (CancellationException e7) {
            e = e7;
        } catch (TimeoutException e8) {
            e = e8;
        } catch (Exception e9) {
            e = e9;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void launchExternalLink(final Activity activity, final LaunchExternalLinkParams launchExternalLinkParams, final LaunchExternalLinkResponseListener launchExternalLinkResponseListener) {
        BillingClientImpl billingClientImpl;
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        try {
            billingClientImpl = this;
        } catch (Exception e) {
            e = e;
            billingClientImpl = this;
        }
        try {
            billingClientImpl.zzaN(new Callable() { // from class: com.android.billingclient.api.zzas
                @Override // java.util.concurrent.Callable
                public final Object call() throws RemoteException {
                    BillingClientImpl.zzD(this.zza, launchExternalLinkResponseListener, launchExternalLinkParams, activity);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzat
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzaZ(launchExternalLinkResponseListener, zzdc.zzk, zzjd.EXECUTE_ASYNC_TIMEOUT, null);
                }
            }, zzav());
        } catch (Exception e2) {
            e = e2;
            billingClientImpl.zzaZ(launchExternalLinkResponseListener, billingClientImpl.zzay(), zzjd.SERVICE_CALL_EXCEPTION, e);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzbf
            @Override // java.util.concurrent.Callable
            public final Object call() throws JSONException {
                BillingClientImpl.zzt(this.zza, productDetailsResponseListener, queryProductDetailsParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbg
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzT(this.zza, productDetailsResponseListener);
            }
        }, zzav(), zzJ()) == null) {
            BillingResult billingResultZzay = zzay();
            zzbs(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 7, billingResultZzay);
            productDetailsResponseListener.onProductDetailsResponse(billingResultZzay, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbw.zzk(), com.google.android.gms.internal.play_billing.zzbw.zzk()));
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, final PurchasesResponseListener purchasesResponseListener) {
        if (zzK(new zzbm(this, purchasesResponseListener, queryPurchasesParams.zza(), queryPurchasesParams.getIncludeSuspendedSubscriptions()), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbj
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzM(this.zza, purchasesResponseListener);
            }
        }, zzav(), zzJ()) == null) {
            BillingResult billingResultZzay = zzay();
            zzbs(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 9, billingResultZzay);
            purchasesResponseListener.onQueryPurchasesResponse(billingResultZzay, com.google.android.gms.internal.play_billing.zzbw.zzk());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showAlternativeBillingOnlyInformationDialog(final Activity activity, final AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!zzbk(3000L)) {
            zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzdc.zzj;
            zzbs(zzjdVar, 16, billingResult);
            return billingResult;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current Play Store version doesn't support alternative billing only.");
            zzjd zzjdVar2 = zzjd.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED;
            BillingResult billingResult2 = zzdc.zzC;
            zzbs(zzjdVar2, 16, billingResult2);
            return billingResult2;
        }
        Handler handler = this.zze;
        final zzbo zzboVar = new zzbo(this, handler, alternativeBillingOnlyInformationDialogListener);
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzah
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzA(this.zza, alternativeBillingOnlyInformationDialogListener, activity, zzboVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzai
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzba(alternativeBillingOnlyInformationDialogListener, zzdc.zzk, zzjd.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, handler, zzJ()) != null) {
            return zzdc.zzi;
        }
        BillingResult billingResultZzay = zzay();
        zzbs(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 16, billingResultZzay);
        return billingResultZzay;
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showExternalOfferInformationDialog(final Activity activity, final ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!zzbk(3000L)) {
            zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzdc.zzj;
            zzbs(zzjdVar, 25, billingResult);
            return billingResult;
        }
        if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current Play Store version doesn't support external offer.");
            zzjd zzjdVar2 = zzjd.EXTERNAL_OFFER_NOT_SUPPORTED;
            BillingResult billingResult2 = zzdc.zzt;
            zzbs(zzjdVar2, 25, billingResult2);
            return billingResult2;
        }
        Handler handler = this.zze;
        final zzbp zzbpVar = new zzbp(this, handler, externalOfferInformationDialogListener);
        if (zzK(new Callable() { // from class: com.android.billingclient.api.zzbc
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzF(this.zza, externalOfferInformationDialogListener, activity, zzbpVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbd
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaX(externalOfferInformationDialogListener, zzdc.zzk, zzjd.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, handler, zzJ()) != null) {
            return zzdc.zzi;
        }
        BillingResult billingResultZzay = zzay();
        zzbs(zzjd.MISSING_RESULT_FROM_EXECUTE_ASYNC, 25, billingResultZzay);
        return billingResultZzay;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!zzbk(3000L)) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Service disconnected.");
            return zzdc.zzj;
        }
        if (!this.zzq) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzdc.zzs;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        IBinder windowToken = viewFindViewById.getWindowToken();
        Rect rect = new Rect();
        viewFindViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.zzc);
        String str = this.zzd;
        if (str != null) {
            bundle.putString("playBillingLibraryWrapperVersion", str);
        }
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.zza());
        Handler handler = this.zze;
        final zzbn zzbnVar = new zzbn(this, handler, inAppMessageResponseListener);
        zzK(new Callable() { // from class: com.android.billingclient.api.zzbh
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzv(this.zza, bundle, activity, zzbnVar);
                return null;
            }
        }, 5000L, null, handler, zzJ());
        return zzdc.zzi;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void startConnection(BillingClientStateListener billingClientStateListener) {
        zzbi(billingClientStateListener, 0);
    }

    final synchronized ExecutorService zzJ() {
        if (this.zzI == null) {
            this.zzI = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zzc.zza, new zzbl(this));
        }
        return this.zzI;
    }

    public final void zzao(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.zze.post(runnable);
        }
    }

    final zzcg zzh(QueryProductDetailsParams queryProductDetailsParams) throws JSONException {
        com.google.android.gms.internal.play_billing.zzap zzapVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strZzb = queryProductDetailsParams.zzb();
        com.google.android.gms.internal.play_billing.zzbw zzbwVarZza = queryProductDetailsParams.zza();
        int size = zzbwVarZza.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList<QueryProductDetailsParams.Product> arrayList3 = new ArrayList(zzbwVarZza.subList(i, i2 > size ? size : i2));
            ArrayList<String> arrayList4 = new ArrayList<>();
            int size2 = arrayList3.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList4.add(((QueryProductDetailsParams.Product) arrayList3.get(i3)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList4);
            String str = this.zzc;
            bundle.putString("playBillingLibraryVersion", str);
            try {
                synchronized (this.zza) {
                    zzapVar = this.zzi;
                }
                if (zzapVar == null) {
                    return zzaw(zzdc.zzj, zzjd.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                }
                boolean z = this.zzw && this.zzE.isEnabledForPrepaidPlans();
                zzaD(queryProductDetailsParams);
                zzaD(queryProductDetailsParams);
                zzaD(queryProductDetailsParams);
                zzaD(queryProductDetailsParams);
                Bundle bundleZzj = zzapVar.zzj(true != this.zzx ? 17 : 20, this.zzg.getPackageName(), strZzb, bundle, com.google.android.gms.internal.play_billing.zzc.zzg(str, this.zzd, arrayList3, null, null, com.google.android.gms.internal.play_billing.zza.zza(z, true, true, true, false, true), this.zzJ.longValue()));
                if (bundleZzj == null) {
                    return zzaw(zzdc.zzA, zzjd.NULL_BUNDLE_FROM_GET_SKU_DETAILS_SERVICE_CALL, "queryProductDetailsAsync got empty product details response.", null);
                }
                if (!bundleZzj.containsKey("DETAILS_LIST")) {
                    int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundleZzj, "BillingClient");
                    String strZzk = com.google.android.gms.internal.play_billing.zzc.zzk(bundleZzj, "BillingClient");
                    if (iZzb == 0) {
                        return zzaw(zzdc.zza(6, strZzk), zzjd.MISSING_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                    }
                    return zzaw(zzdc.zza(iZzb, strZzk), zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY, "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + iZzb, null);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return zzaw(zzdc.zzA, zzjd.NULL_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "queryProductDetailsAsync got null response list", null);
                }
                ArrayList arrayList5 = new ArrayList();
                int size3 = stringArrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    try {
                        ProductDetails productDetails = new ProductDetails(stringArrayList.get(i4));
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Got product details: ".concat(productDetails.toString()));
                        arrayList5.add(productDetails);
                    } catch (JSONException e) {
                        return zzaw(zzdc.zza(6, "Error trying to decode SkuDetails."), zzjd.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                    }
                }
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("UNFETCHED_PRODUCT_LIST");
                new ArrayList();
                try {
                    ArrayList arrayList6 = new ArrayList();
                    if (stringArrayList2 == null) {
                        for (QueryProductDetailsParams.Product product : arrayList3) {
                            Iterator it = arrayList5.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    arrayList6.add(new UnfetchedProduct(new JSONObject().put("productId", product.zza()).put("type", product.zzb()).put("statusCode", 0).toString()));
                                    break;
                                }
                                ProductDetails productDetails2 = (ProductDetails) it.next();
                                if (!product.zza().equals(productDetails2.getProductId()) || !product.zzb().equals(productDetails2.getProductType())) {
                                }
                            }
                        }
                    } else {
                        Iterator<String> it2 = stringArrayList2.iterator();
                        while (it2.hasNext()) {
                            UnfetchedProduct unfetchedProduct = new UnfetchedProduct(it2.next());
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Got unfetchedProduct: ".concat(unfetchedProduct.toString()));
                            arrayList6.add(unfetchedProduct);
                        }
                    }
                    arrayList.addAll(arrayList5);
                    arrayList2.addAll(arrayList6);
                    i = i2;
                } catch (JSONException e2) {
                    return zzaw(zzdc.zza(6, "Error trying to decode SkuDetails."), zzjd.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode UnfetchedProduct. \n Exception: ", e2);
                }
            } catch (DeadObjectException e3) {
                return zzaw(zzdc.zzj, zzjd.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e3);
            } catch (Exception e4) {
                return zzaw(zzdc.zzh, zzjd.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e4);
            }
        }
        return new zzcg(0, "", arrayList, arrayList2);
    }

    final zzcz zzk() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final BillingResult zzn(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zze.post(new Runnable() { // from class: com.android.billingclient.api.zzan
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzV(this.zza, billingResult);
            }
        });
        return billingResult;
    }
}
