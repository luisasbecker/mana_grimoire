package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.credentials.provider.CredentialEntry;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzabw;
import com.google.android.gms.internal.measurement.zzabx;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.time.DurationKt;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzlj extends zzg {
    protected zzky zza;
    final zzx zzb;
    protected boolean zzc;
    private zzjp zzd;
    private final Set zze;
    private boolean zzf;
    private final AtomicReference zzg;
    private final Object zzh;
    private boolean zzi;
    private int zzj;
    private zzaz zzk;
    private zzaz zzl;
    private PriorityQueue zzm;
    private zzjl zzn;
    private final AtomicLong zzo;
    private long zzp;
    private zzaz zzq;
    private SharedPreferences.OnSharedPreferenceChangeListener zzr;
    private zzaz zzs;
    private final zzpo zzt;

    protected zzlj(zzic zzicVar) {
        super(zzicVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzi = false;
        this.zzj = 1;
        this.zzc = true;
        this.zzt = new zzkn(this);
        this.zzg = new AtomicReference();
        this.zzn = zzjl.zza;
        this.zzp = -1L;
        this.zzo = new AtomicLong(0L);
        this.zzb = new zzx(zzicVar);
    }

    private final zzlr zzap(final zzom zzomVar) {
        try {
            URL url = new URI(zzomVar.zzc).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String strZzl = this.zzu.zzv().zzl();
            zzic zzicVar = this.zzu;
            zzgs zzgsVarZzk = zzicVar.zzaW().zzk();
            Long lValueOf = Long.valueOf(zzomVar.zza);
            zzgsVarZzk.zzd("[sgtm] Uploading data from app. row_id, url, uncompressed size", lValueOf, zzomVar.zzc, Integer.valueOf(zzomVar.zzb.length));
            if (!TextUtils.isEmpty(zzomVar.zzg)) {
                zzicVar.zzaW().zzk().zzc("[sgtm] Uploading data from app. row_id", lValueOf, zzomVar.zzg);
            }
            HashMap map = new HashMap();
            Bundle bundle = zzomVar.zzd;
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    map.put(str, string);
                }
            }
            zzlo zzloVarZzn = zzicVar.zzn();
            byte[] bArr = zzomVar.zzb;
            zzll zzllVar = new zzll() { // from class: com.google.android.gms.measurement.internal.zzkz
                /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
                @Override // com.google.android.gms.measurement.internal.zzll
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final /* synthetic */ void zza(String str2, int i, Throwable th, byte[] bArr2, Map map2) {
                    zzlr zzlrVar;
                    zzlj zzljVar = this.zza;
                    zzljVar.zzg();
                    zzom zzomVar2 = zzomVar;
                    if (i != 200 && i != 204) {
                        if (i == 304) {
                            i = 304;
                            if (th != null) {
                            }
                        }
                        zzljVar.zzu.zzaW().zze().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzomVar2.zza), Integer.valueOf(i), th);
                        if (!Arrays.asList(((String) zzfy.zzt.zzb(null)).split(",")).contains(String.valueOf(i))) {
                        }
                    } else if (th != null) {
                        zzljVar.zzu.zzaW().zzk().zzb("[sgtm] Upload succeeded for row_id", Long.valueOf(zzomVar2.zza));
                        zzlrVar = zzlr.SUCCESS;
                    } else {
                        zzljVar.zzu.zzaW().zze().zzd("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzomVar2.zza), Integer.valueOf(i), th);
                        zzlrVar = !Arrays.asList(((String) zzfy.zzt.zzb(null)).split(",")).contains(String.valueOf(i)) ? zzlr.BACKOFF : zzlr.FAILURE;
                    }
                    AtomicReference atomicReference2 = atomicReference;
                    zznl zznlVarZzt = zzljVar.zzu.zzt();
                    long j = zzomVar2.zza;
                    zznlVarZzt.zzy(new zzaf(j, zzlrVar.zza(), zzomVar2.zzf));
                    zzljVar.zzu.zzaW().zzk().zzc("[sgtm] Updated status for row_id", Long.valueOf(j), zzlrVar);
                    synchronized (atomicReference2) {
                        atomicReference2.set(zzlrVar);
                        atomicReference2.notifyAll();
                    }
                }
            };
            zzloVarZzn.zzw();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(zzllVar);
            zzloVarZzn.zzu.zzaX().zzm(new zzln(zzloVarZzn, strZzl, url, bArr, map, zzllVar));
            try {
                zzic zzicVar2 = zzicVar.zzk().zzu;
                long jCurrentTimeMillis = zzicVar2.zzba().currentTimeMillis();
                long j = jCurrentTimeMillis + DurationKt.MILLIS_IN_MINUTE;
                synchronized (atomicReference) {
                    for (long jCurrentTimeMillis2 = DurationKt.MILLIS_IN_MINUTE; atomicReference.get() == null && jCurrentTimeMillis2 > 0; jCurrentTimeMillis2 = j - zzicVar2.zzba().currentTimeMillis()) {
                        atomicReference.wait(jCurrentTimeMillis2);
                    }
                }
            } catch (InterruptedException unused) {
                this.zzu.zzaW().zze().zza("[sgtm] Interrupted waiting for uploading batch");
            }
            return atomicReference.get() == null ? zzlr.UNKNOWN : (zzlr) atomicReference.get();
        } catch (MalformedURLException | URISyntaxException e) {
            this.zzu.zzaW().zzb().zzd("[sgtm] Bad upload url for row_id", zzomVar.zzc, Long.valueOf(zzomVar.zza), e);
            return zzlr.FAILURE;
        }
    }

    private final void zzaq(Boolean bool, boolean z) {
        zzg();
        zzb();
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzj().zzb("Setting app measurement enabled (FE)", bool);
        zzicVar.zzd().zzh(bool);
        if (z) {
            zzhh zzhhVarZzd = zzicVar.zzd();
            zzic zzicVar2 = zzhhVarZzd.zzu;
            zzhhVarZzd.zzg();
            SharedPreferences.Editor editorEdit = zzhhVarZzd.zzd().edit();
            if (bool != null) {
                editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit.remove("measurement_enabled_from_api");
            }
            editorEdit.apply();
        }
        if (this.zzu.zzE() || !(bool == null || bool.booleanValue())) {
            zzak();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzar, reason: merged with bridge method [inline-methods] */
    public final void zzak() {
        zzlj zzljVar;
        zzg();
        zzic zzicVar = this.zzu;
        String strZza = zzicVar.zzd().zzh.zza();
        if (strZza == null) {
            zzljVar = this;
        } else if ("unset".equals(strZza)) {
            zzljVar = this;
            zzljVar.zzM(AndroidContextPlugin.APP_KEY, "_npa", null, zzicVar.zzba().currentTimeMillis());
        } else {
            zzljVar = this;
            zzljVar.zzM(AndroidContextPlugin.APP_KEY, "_npa", Long.valueOf(true != "true".equals(strZza) ? 0L : 1L), zzicVar.zzba().currentTimeMillis());
        }
        if (!zzljVar.zzu.zzB() || !zzljVar.zzc) {
            zzicVar.zzaW().zzj().zza("Updating Scion state (FE)");
            zzljVar.zzu.zzt().zzi();
        } else {
            zzicVar.zzaW().zzj().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzljVar.zzT();
            zzljVar.zzu.zzh().zza.zza();
            zzicVar.zzaX().zzj(new zzjz(zzljVar));
        }
    }

    public final void zzA(String str, String str2, Bundle bundle) {
        zzic zzicVar = this.zzu;
        zzB(str, str2, bundle, true, true, zzicVar.zzba().currentTimeMillis(), zzicVar.zzc().zzp(null, zzfy.zzbe) ? zzicVar.zzba().elapsedRealtime() : 0L);
    }

    public final void zzB(String str, String str2, Bundle bundle, boolean z, boolean z2, long j, long j2) {
        long j3;
        zzmb zzmbVar;
        long j4;
        Bundle bundle2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle3 = bundle;
        if (!Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            boolean z3 = !z2 || this.zzd == null || zzpp.zzac(str2);
            if (str == null) {
                str = AndroidContextPlugin.APP_KEY;
            }
            zzI(str, str2, j, true != this.zzu.zzc().zzp(null, zzfy.zzbe) ? 0L : j2, bundle3, z2, z3, z, null);
            return;
        }
        zzic zzicVar = this.zzu;
        zzic zzicVar2 = this.zzu;
        zzmb zzmbVarZzs = zzicVar.zzs();
        if (true != zzicVar2.zzc().zzp(null, zzfy.zzbe)) {
            j3 = 0;
            j4 = j;
            bundle2 = bundle3;
            zzmbVar = zzmbVarZzs;
        } else {
            j3 = j2;
            zzmbVar = zzmbVarZzs;
            j4 = j;
            bundle2 = bundle3;
        }
        zzmbVar.zzj(bundle2, j4, j3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzC() {
        zzod zzodVar;
        zzabx zzabxVar;
        zzg();
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzj().zza("Handle tcf update.");
        SharedPreferences sharedPreferencesZze = zzicVar.zzd().zze();
        int i = zzof.zzb;
        zzabw zzabwVar = zzabw.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        zzoe zzoeVar = zzoe.CONSENT;
        zzabw zzabwVar2 = zzabw.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
        zzoe zzoeVar2 = zzoe.FLEXIBLE_LEGITIMATE_INTEREST;
        ImmutableMap immutableMapOf = ImmutableMap.of(zzabwVar, zzoeVar, zzabwVar2, zzoeVar2, zzabw.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE, zzoeVar, zzabw.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS, zzoeVar, zzabw.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE, zzoeVar2, zzabw.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, zzoeVar2, zzabw.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, zzoeVar2);
        ImmutableSet immutableSetOf = ImmutableSet.of("CH");
        char[] cArr = new char[5];
        boolean zContains = sharedPreferencesZze.contains("IABTCF_TCString");
        int iZzb = zzof.zzb(sharedPreferencesZze, "IABTCF_CmpSdkID");
        int iZzb2 = zzof.zzb(sharedPreferencesZze, "IABTCF_PolicyVersion");
        int iZzb3 = zzof.zzb(sharedPreferencesZze, "IABTCF_gdprApplies");
        int iZzb4 = zzof.zzb(sharedPreferencesZze, "IABTCF_PurposeOneTreatment");
        int iZzb5 = zzof.zzb(sharedPreferencesZze, "IABTCF_EnableAdvertiserConsentMode");
        String strZza = zzof.zza(sharedPreferencesZze, "IABTCF_PublisherCC");
        ImmutableMap.Builder builder = ImmutableMap.builder();
        UnmodifiableIterator it = immutableMapOf.keySet().iterator();
        while (it.hasNext()) {
            zzabw zzabwVar3 = (zzabw) it.next();
            int iZza = zzabwVar3.zza();
            StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 28);
            sb.append("IABTCF_PublisherRestrictions");
            sb.append(iZza);
            String strZza2 = zzof.zza(sharedPreferencesZze, sb.toString());
            if (TextUtils.isEmpty(strZza2) || strZza2.length() < 755) {
                zzabxVar = zzabx.PURPOSE_RESTRICTION_UNDEFINED;
            } else {
                int iDigit = Character.digit(strZza2.charAt(754), 10);
                zzabxVar = (iDigit < 0 || iDigit > zzabx.values().length || iDigit == 0) ? zzabx.PURPOSE_RESTRICTION_NOT_ALLOWED : iDigit != 1 ? iDigit != 2 ? zzabx.PURPOSE_RESTRICTION_UNDEFINED : zzabx.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST : zzabx.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
            }
            builder.put(zzabwVar3, zzabxVar);
        }
        ImmutableMap immutableMapBuildOrThrow = builder.buildOrThrow();
        String strZza3 = zzof.zza(sharedPreferencesZze, "IABTCF_PurposeConsents");
        String strZza4 = zzof.zza(sharedPreferencesZze, "IABTCF_VendorConsents");
        boolean z = !TextUtils.isEmpty(strZza4) && strZza4.length() >= 755 && strZza4.charAt(754) == '1';
        String strZza5 = zzof.zza(sharedPreferencesZze, "IABTCF_PurposeLegitimateInterests");
        String strZza6 = zzof.zza(sharedPreferencesZze, "IABTCF_VendorLegitimateInterests");
        boolean z2 = !TextUtils.isEmpty(strZza6) && strZza6.length() >= 755 && strZza6.charAt(754) == '1';
        cArr[0] = '2';
        zzod zzodVar2 = new zzod(zzof.zzd(immutableMapOf, immutableMapBuildOrThrow, immutableSetOf, cArr, iZzb, iZzb5, iZzb3, iZzb2, iZzb4, strZza, strZza3, strZza5, z, z2, zContains));
        zzicVar.zzaW().zzk().zzb("Tcf preferences read", zzodVar2);
        zzhh zzhhVarZzd = zzicVar.zzd();
        zzhhVarZzd.zzg();
        String string = zzhhVarZzd.zzd().getString("stored_tcf_param", "");
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(string)) {
            zzodVar = new zzod(map);
        } else {
            for (String str : string.split(";")) {
                String[] strArrSplit = str.split("=");
                if (strArrSplit.length >= 2 && zzof.zza.contains(strArrSplit[0])) {
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
            zzodVar = new zzod(map);
        }
        zzhh zzhhVarZzd2 = zzicVar.zzd();
        zzhhVarZzd2.zzg();
        String string2 = zzhhVarZzd2.zzd().getString("stored_tcf_param", "");
        String strZza7 = zzodVar2.zza();
        if (strZza7.equals(string2)) {
            return;
        }
        SharedPreferences.Editor editorEdit = zzhhVarZzd2.zzd().edit();
        editorEdit.putString("stored_tcf_param", strZza7);
        editorEdit.apply();
        Bundle bundleZzb = zzodVar2.zzb();
        zzicVar.zzaW().zzk().zzb("Consent generated from Tcf", bundleZzb);
        if (bundleZzb != Bundle.EMPTY) {
            zzp(bundleZzb, -30, zzicVar.zzba().currentTimeMillis());
        }
        Bundle bundle = new Bundle();
        bundle.putString("_tcfm", zzodVar2.zzd(zzodVar));
        bundle.putString("_tcfd2", zzodVar2.zzc());
        bundle.putString("_tcfd", zzodVar2.zze());
        zzE(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_tcf", bundle);
    }

    public final void zzD() {
        zzg();
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzj().zza("Register tcfPrefChangeListener.");
        if (this.zzr == null) {
            this.zzs = new zzkb(this, this.zzu);
            this.zzr = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzle
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    this.zza.zzaf(sharedPreferences, str);
                }
            };
        }
        zzicVar.zzd().zze().registerOnSharedPreferenceChangeListener(this.zzr);
    }

    final void zzE(String str, String str2, Bundle bundle) {
        zzg();
        zzic zzicVar = this.zzu;
        zzF(str, str2, zzicVar.zzba().currentTimeMillis(), zzicVar.zzc().zzp(null, zzfy.zzbe) ? zzicVar.zzba().elapsedRealtime() : 0L, bundle);
    }

    final void zzF(String str, String str2, long j, long j2, Bundle bundle) {
        zzg();
        boolean z = true;
        if (this.zzd != null && !zzpp.zzac(str2)) {
            z = false;
        }
        zzG(str, str2, j, j2, bundle, true, z, true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void zzG(String str, String str2, long j, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        char c;
        boolean z4;
        int i;
        long j3;
        boolean z5;
        long j4;
        String str4;
        ArrayList arrayList;
        zzlj zzljVar;
        int size;
        int i2;
        int i3;
        Bundle[] bundleArr;
        int i4;
        String str5 = str;
        Preconditions.checkNotEmpty(str5);
        Preconditions.checkNotNull(bundle);
        zzg();
        zzb();
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzB()) {
            this.zzu.zzaW().zzj().zza("Event not sent since app measurement is disabled");
            return;
        }
        List listZzp = this.zzu.zzv().zzp();
        if (listZzp != null && !listZzp.contains(str2)) {
            this.zzu.zzaW().zzj().zzc("Dropping non-safelisted event. event name, origin", str2, str5);
            return;
        }
        if (!this.zzf) {
            this.zzf = true;
            try {
                try {
                    (!zzicVar.zzp() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.zzu.zzaZ().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, this.zzu.zzaZ());
                } catch (Exception e) {
                    this.zzu.zzaW().zze().zzb("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                this.zzu.zzaW().zzi().zza("Tag Manager is not found and thus will not be used");
            }
        }
        zzic zzicVar2 = this.zzu;
        if (!zzicVar2.zzc().zzp(null, zzfy.zzaZ) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2) && bundle.containsKey("gclid")) {
            zzicVar2.zzaV();
            zzM(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lgclid", bundle.getString("gclid"), zzicVar2.zzba().currentTimeMillis());
        }
        zzicVar2.zzaV();
        if (z && zzpp.zzai(str2)) {
            zzicVar2.zzk().zzK(bundle, zzicVar2.zzd().zzt.zza());
        }
        if (!z3) {
            zzicVar2.zzaV();
            if ("_iap".equals(str2)) {
                c = 2;
            } else {
                zzic zzicVar3 = this.zzu;
                zzpp zzppVarZzk = zzicVar3.zzk();
                if (zzppVarZzk.zzk(NotificationCompat.CATEGORY_EVENT, str2)) {
                    zzic zzicVar4 = zzppVarZzk.zzu;
                    c = 2;
                    if (zzppVarZzk.zzm(NotificationCompat.CATEGORY_EVENT, zzjm.zza, zzicVar4.zzc().zzp(null, zzfy.zzbf) ? zzjm.zzc : zzjm.zzb, str2)) {
                        zzicVar4.zzc();
                        i4 = !zzppVarZzk.zzn(NotificationCompat.CATEGORY_EVENT, 40, str2) ? 2 : 0;
                    } else {
                        i4 = 13;
                    }
                } else {
                    i4 = 2;
                    c = 2;
                }
                if (i4 != 0) {
                    zzicVar2.zzaW().zzd().zzb("Invalid public event name. Event will not be logged (FE)", zzicVar2.zzl().zza(str2));
                    zzpp zzppVarZzk2 = zzicVar3.zzk();
                    zzicVar3.zzc();
                    zzicVar3.zzk().zzP(this.zzt, null, i4, "_ev", zzppVarZzk2.zzE(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        zzicVar2.zzaV();
        zzic zzicVar5 = this.zzu;
        zzlu zzluVarZzh = zzicVar5.zzs().zzh(false);
        if (zzluVarZzh != null && !bundle.containsKey("_sc")) {
            zzluVarZzh.zzd = true;
        }
        zzpp.zzay(zzluVarZzh, bundle, z && !z3);
        boolean zEquals = "am".equals(str5);
        boolean zZzac = zzpp.zzac(str2);
        if (!z || this.zzd == null || zZzac) {
            z4 = zEquals;
        } else {
            if (!zEquals) {
                zzicVar2.zzaW().zzj().zzc("Passing event to registered event handler (FE)", zzicVar2.zzl().zza(str2), zzicVar2.zzl().zze(bundle));
                Preconditions.checkNotNull(this.zzd);
                this.zzd.interceptEvent(str5, str2, bundle, j);
                return;
            }
            z4 = true;
        }
        zzic zzicVar6 = this.zzu;
        if (zzicVar6.zzH()) {
            int iZzp = zzicVar2.zzk().zzp(str2);
            if (iZzp != 0) {
                zzicVar2.zzaW().zzd().zzb("Invalid event name. Event will not be logged (FE)", zzicVar2.zzl().zza(str2));
                zzpp zzppVarZzk3 = zzicVar2.zzk();
                zzicVar2.zzc();
                zzicVar6.zzk().zzP(this.zzt, str3, iZzp, "_ev", zzppVarZzk3.zzE(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            String[] strArr = new String[4];
            strArr[0] = "_o";
            strArr[1] = "_sn";
            strArr[c] = "_sc";
            strArr[3] = "_si";
            Bundle bundleZzH = zzicVar2.zzk().zzH(str3, str2, bundle, CollectionUtils.listOf((Object[]) strArr), z3);
            Preconditions.checkNotNull(bundleZzH);
            zzicVar2.zzaV();
            if (zzicVar5.zzs().zzh(false) == null || !"_ae".equals(str2)) {
                i = 0;
                j3 = 0;
            } else {
                zzoa zzoaVar = zzicVar5.zzh().zzb;
                j3 = 0;
                long jElapsedRealtime = zzoaVar.zzc.zzu.zzba().elapsedRealtime();
                i = 0;
                long j5 = jElapsedRealtime - zzoaVar.zzb;
                zzoaVar.zzb = jElapsedRealtime;
                if (j5 > 0) {
                    zzicVar2.zzk().zzan(bundleZzH, j5);
                }
            }
            if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(str5) && "_ssr".equals(str2)) {
                zzpp zzppVarZzk4 = zzicVar2.zzk();
                String string = bundleZzH.getString("_ffr");
                if (Strings.isEmptyOrWhitespace(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                zzic zzicVar7 = zzppVarZzk4.zzu;
                if (Objects.equals(string, zzicVar7.zzd().zzq.zza())) {
                    zzicVar7.zzaW().zzj().zza("Not logging duplicate session_start_with_rollout event");
                    return;
                }
                zzicVar7.zzd().zzq.zzb(string);
            } else if ("_ae".equals(str2)) {
                String strZza = zzicVar2.zzk().zzu.zzd().zzq.zza();
                if (!TextUtils.isEmpty(strZza)) {
                    bundleZzH.putString("_ffr", strZza);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(bundleZzH);
            boolean zZzi = zzicVar2.zzc().zzp(null, zzfy.zzaS) ? zzicVar5.zzh().zzi() : zzicVar2.zzd().zzn.zza();
            if (zzicVar2.zzd().zzk.zza() > j3) {
                arrayList = arrayList2;
                if (zzicVar2.zzd().zzo(j) && zZzi) {
                    zzicVar2.zzaW().zzk().zza("Current session is expired, remove the session number, ID, and engagement time");
                    z5 = z4;
                    j4 = j3;
                    str4 = "_ae";
                    zzM(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", null, zzicVar2.zzba().currentTimeMillis());
                    zzM(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sno", null, zzicVar2.zzba().currentTimeMillis());
                    zzM(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_se", null, zzicVar2.zzba().currentTimeMillis());
                    zzljVar = this;
                    zzicVar2.zzd().zzl.zzb(j4);
                    if (bundleZzH.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j4) == 1) {
                        zzicVar2.zzaW().zzk().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                        zzicVar6.zzh().zza.zzb(j, j2, true);
                    }
                    ArrayList arrayList3 = new ArrayList(bundleZzH.keySet());
                    Collections.sort(arrayList3);
                    size = arrayList3.size();
                    for (i2 = i; i2 < size; i2++) {
                        String str6 = (String) arrayList3.get(i2);
                        if (str6 != null) {
                            zzicVar2.zzk();
                            Object obj = bundleZzH.get(str6);
                            if (obj instanceof Bundle) {
                                bundleArr = new Bundle[1];
                                bundleArr[i] = (Bundle) obj;
                            } else if (obj instanceof Parcelable[]) {
                                Parcelable[] parcelableArr = (Parcelable[]) obj;
                                bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                            } else if (obj instanceof ArrayList) {
                                ArrayList arrayList4 = (ArrayList) obj;
                                bundleArr = (Bundle[]) arrayList4.toArray(new Bundle[arrayList4.size()]);
                            } else {
                                bundleArr = null;
                            }
                            if (bundleArr != null) {
                                bundleZzH.putParcelableArray(str6, bundleArr);
                            }
                        }
                    }
                    i3 = i;
                    while (i3 < arrayList.size()) {
                        ArrayList arrayList5 = arrayList;
                        Bundle bundleZzae = (Bundle) arrayList5.get(i3);
                        String str7 = i3 != 0 ? "_ep" : str2;
                        bundleZzae.putString("_o", str5);
                        if (z2) {
                            bundleZzae = zzicVar2.zzk().zzae(bundleZzae, null);
                        }
                        Bundle bundle2 = bundleZzae;
                        zzicVar5.zzt().zzn(new zzbh(str7, new zzbf(bundleZzae), str5, j, j2), str3);
                        if (!z5) {
                            Iterator it = zzljVar.zze.iterator();
                            while (it.hasNext()) {
                                ((zzjq) it.next()).onEvent(str, str2, new Bundle(bundle2), j);
                            }
                        }
                        i3++;
                        str5 = str;
                        arrayList = arrayList5;
                    }
                    zzicVar2.zzaV();
                    if (zzicVar5.zzs().zzh(i) == null && str4.equals(str2)) {
                        zzicVar5.zzh().zzb.zzd(true, true, zzicVar2.zzba().elapsedRealtime());
                        return;
                    }
                }
                z5 = z4;
                j4 = j3;
                str4 = "_ae";
            } else {
                z5 = z4;
                j4 = j3;
                str4 = "_ae";
                arrayList = arrayList2;
            }
            zzljVar = this;
            if (bundleZzH.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j4) == 1) {
            }
            ArrayList arrayList32 = new ArrayList(bundleZzH.keySet());
            Collections.sort(arrayList32);
            size = arrayList32.size();
            while (i2 < size) {
            }
            i3 = i;
            while (i3 < arrayList.size()) {
            }
            zzicVar2.zzaV();
            if (zzicVar5.zzs().zzh(i) == null) {
            }
        }
    }

    public final void zzH(String str, String str2, Bundle bundle, String str3) {
        zzic.zzL();
        zzic zzicVar = this.zzu;
        zzI(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str2, zzicVar.zzba().currentTimeMillis(), zzicVar.zzc().zzp(null, zzfy.zzbe) ? zzicVar.zzba().elapsedRealtime() : 0L, bundle, false, true, true, str3);
    }

    protected final void zzI(String str, String str2, long j, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        int i = zzpp.zza;
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i2 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i2 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i2];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelable);
                        }
                        i2++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i2 < list.size()) {
                        Object obj2 = list.get(i2);
                        if (obj2 instanceof Bundle) {
                            list.set(i2, new Bundle((Bundle) obj2));
                        }
                        i2++;
                    }
                }
            }
        }
        this.zzu.zzaX().zzj(new zzkc(this, str, str2, j, j2, bundle2, z, z2, z3, str3));
    }

    public final void zzJ(String str, String str2, Object obj, boolean z) {
        zzK(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ldl", obj, true, this.zzu.zzba().currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzK(String str, String str2, Object obj, boolean z, long j) {
        int iZzs;
        if (z) {
            iZzs = this.zzu.zzk().zzs(str2);
        } else {
            zzpp zzppVarZzk = this.zzu.zzk();
            if (zzppVarZzk.zzk("user property", str2)) {
                if (zzppVarZzk.zzm("user property", zzjo.zza, null, str2)) {
                    zzppVarZzk.zzu.zzc();
                    iZzs = !zzppVarZzk.zzn("user property", 24, str2) ? 6 : 0;
                } else {
                    iZzs = 15;
                }
            }
        }
        if (iZzs != 0) {
            zzic zzicVar = this.zzu;
            zzpp zzppVarZzk2 = zzicVar.zzk();
            zzicVar.zzc();
            this.zzu.zzk().zzP(this.zzt, null, iZzs, "_ev", zzppVarZzk2.zzE(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        String str3 = str == null ? AndroidContextPlugin.APP_KEY : str;
        if (obj == null) {
            zzL(str3, str2, j, null);
            return;
        }
        zzic zzicVar2 = this.zzu;
        int iZzM = zzicVar2.zzk().zzM(str2, obj);
        if (iZzM == 0) {
            Object objZzN = zzicVar2.zzk().zzN(str2, obj);
            if (objZzN != null) {
                zzL(str3, str2, j, objZzN);
                return;
            }
            return;
        }
        zzpp zzppVarZzk3 = zzicVar2.zzk();
        zzicVar2.zzc();
        this.zzu.zzk().zzP(this.zzt, null, iZzM, "_ev", zzppVarZzk3.zzE(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? obj.toString().length() : 0);
    }

    final void zzL(String str, String str2, long j, Object obj) {
        this.zzu.zzaX().zzj(new zzkd(this, str, str2, obj, j));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzM(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzb();
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (TextUtils.isEmpty(str3)) {
                    if (obj == null) {
                        this.zzu.zzd().zzh.zzb("unset");
                    }
                    this.zzu.zzaW().zzk().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
                } else {
                    String lowerCase = str3.toLowerCase(Locale.ENGLISH);
                    String str4 = CredentialEntry.FALSE_STRING;
                    long j2 = true != CredentialEntry.FALSE_STRING.equals(lowerCase) ? 0L : 1L;
                    zzic zzicVar = this.zzu;
                    Long lValueOf = Long.valueOf(j2);
                    zzhg zzhgVar = zzicVar.zzd().zzh;
                    if (lValueOf.longValue() == 1) {
                        str4 = "true";
                    }
                    zzhgVar.zzb(str4);
                    obj = lValueOf;
                }
                str2 = "_npa";
                this.zzu.zzaW().zzk().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
            }
        }
        String str5 = str2;
        Object obj2 = obj;
        zzic zzicVar2 = this.zzu;
        if (!zzicVar2.zzB()) {
            this.zzu.zzaW().zzk().zza("User property not set since app measurement is disabled");
        } else if (zzicVar2.zzH()) {
            this.zzu.zzt().zzA(new zzpl(str5, j, obj2, str));
        }
    }

    public final List zzN(boolean z) {
        zzb();
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzk().zza("Getting user properties (FE)");
        if (zzicVar.zzaX().zze()) {
            zzicVar.zzaW().zzb().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        zzicVar.zzaV();
        if (zzae.zza()) {
            zzicVar.zzaW().zzb().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzaX().zzk(atomicReference, 5000L, "get user properties", new zzkf(this, atomicReference, z));
        List list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzicVar.zzaW().zzb().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
        return Collections.emptyList();
    }

    public final Map zzO(String str, String str2, boolean z) {
        zzic zzicVar = this.zzu;
        if (zzicVar.zzaX().zze()) {
            zzicVar.zzaW().zzb().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        zzicVar.zzaV();
        if (zzae.zza()) {
            zzicVar.zzaW().zzb().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzaX().zzk(atomicReference, 5000L, "get user properties", new zzkl(this, atomicReference, null, str, str2, z));
        List<zzpl> list = (List) atomicReference.get();
        if (list == null) {
            zzicVar.zzaW().zzb().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzpl zzplVar : list) {
            Object objZza = zzplVar.zza();
            if (objZza != null) {
                arrayMap.put(zzplVar.zzb, objZza);
            }
        }
        return arrayMap;
    }

    public final String zzP() {
        return (String) this.zzg.get();
    }

    final void zzQ(String str) {
        this.zzg.set(str);
    }

    public final void zzR() {
        zzg();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzd().zzo.zza()) {
            zzicVar.zzaW().zzj().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jZza = zzicVar.zzd().zzp.zza();
        zzicVar.zzd().zzp.zzb(1 + jZza);
        zzicVar.zzc();
        if (jZza >= 5) {
            zzicVar.zzaW().zze().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzicVar.zzd().zzo.zzb(true);
        } else {
            if (this.zzq == null) {
                this.zzq = new zzkg(this, this.zzu);
            }
            this.zzq.zzb(0L);
        }
    }

    public final void zzS(long j, long j2) {
        this.zzg.set(null);
        this.zzu.zzaX().zzj(new zzkh(this, j));
    }

    public final void zzT() {
        zzg();
        zzb();
        if (this.zzu.zzH()) {
            zzic zzicVar = this.zzu;
            zzal zzalVarZzc = zzicVar.zzc();
            zzalVarZzc.zzu.zzaV();
            Boolean boolZzr = zzalVarZzc.zzr("google_analytics_deferred_deep_link_enabled");
            if (boolZzr != null && boolZzr.booleanValue()) {
                zzicVar.zzaW().zzj().zza("Deferred Deep Link feature enabled.");
                zzicVar.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlh
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzR();
                    }
                });
            }
            this.zzu.zzt().zzE();
            this.zzc = false;
            zzhh zzhhVarZzd = zzicVar.zzd();
            zzhhVarZzd.zzg();
            String string = zzhhVarZzd.zzd().getString("previous_os_version", null);
            zzhhVarZzd.zzu.zzu().zzw();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = zzhhVarZzd.zzd().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            zzicVar.zzu().zzw();
            if (string.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            zzE(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
        }
    }

    public final void zzU(zzjp zzjpVar) {
        zzjp zzjpVar2;
        zzg();
        zzb();
        if (zzjpVar != null && zzjpVar != (zzjpVar2 = this.zzd)) {
            Preconditions.checkState(zzjpVar2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzjpVar;
    }

    public final void zzV(zzjq zzjqVar) {
        zzb();
        Preconditions.checkNotNull(zzjqVar);
        if (this.zze.add(zzjqVar)) {
            return;
        }
        this.zzu.zzaW().zze().zza("OnEventListener already registered");
    }

    public final void zzW(zzjq zzjqVar) {
        zzb();
        Preconditions.checkNotNull(zzjqVar);
        if (this.zze.remove(zzjqVar)) {
            return;
        }
        this.zzu.zzaW().zze().zza("OnEventListener had not been registered");
    }

    public final int zzX(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzu.zzc();
        return 25;
    }

    public final void zzY(Bundle bundle) {
        zzZ(bundle, this.zzu.zzba().currentTimeMillis());
    }

    public final void zzZ(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzu.zzaW().zze().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzjh.zzb(bundle2, "app_id", String.class, null);
        zzjh.zzb(bundle2, "origin", String.class, null);
        zzjh.zzb(bundle2, "name", String.class, null);
        zzjh.zzb(bundle2, "value", Object.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        zzic zzicVar = this.zzu;
        if (zzicVar.zzk().zzs(string) != 0) {
            zzicVar.zzaW().zzb().zzb("Invalid conditional user property name", zzicVar.zzl().zzc(string));
            return;
        }
        if (zzicVar.zzk().zzM(string, obj) != 0) {
            zzicVar.zzaW().zzb().zzc("Invalid conditional user property value", zzicVar.zzl().zzc(string), obj);
            return;
        }
        Object objZzN = zzicVar.zzk().zzN(string, obj);
        if (objZzN == null) {
            zzicVar.zzaW().zzb().zzc("Unable to normalize conditional user property value", zzicVar.zzl().zzc(string), obj);
            return;
        }
        zzjh.zza(bundle2, objZzN);
        long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
        if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
            zzicVar.zzc();
            if (j2 > 15552000000L || j2 < 1) {
                zzicVar.zzaW().zzb().zzc("Invalid conditional user property timeout", zzicVar.zzl().zzc(string), Long.valueOf(j2));
                return;
            }
        }
        long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
        zzicVar.zzc();
        if (j3 > 15552000000L || j3 < 1) {
            zzicVar.zzaW().zzb().zzc("Invalid conditional user property time to live", zzicVar.zzl().zzc(string), Long.valueOf(j3));
        } else {
            zzicVar.zzaX().zzj(new zzki(this, bundle2));
        }
    }

    public final void zzaa(String str, String str2, Bundle bundle) {
        zzic zzicVar = this.zzu;
        long jCurrentTimeMillis = zzicVar.zzba().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzicVar.zzaX().zzj(new zzkj(this, bundle2));
    }

    public final ArrayList zzab(String str, String str2) {
        zzic zzicVar = this.zzu;
        if (zzicVar.zzaX().zze()) {
            zzicVar.zzaW().zzb().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        zzicVar.zzaV();
        if (zzae.zza()) {
            zzicVar.zzaW().zzb().zza("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzaX().zzk(atomicReference, 5000L, "get conditional user properties", new zzkk(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzpp.zzav(list);
        }
        zzicVar.zzaW().zzb().zzb("Timed out waiting for get conditional user properties", null);
        return new ArrayList();
    }

    public final String zzac() {
        zzlu zzluVarZzl = this.zzu.zzs().zzl();
        if (zzluVarZzl != null) {
            return zzluVarZzl.zza;
        }
        return null;
    }

    public final String zzad() {
        zzlu zzluVarZzl = this.zzu.zzs().zzl();
        if (zzluVarZzl != null) {
            return zzluVarZzl.zzb;
        }
        return null;
    }

    public final String zzae() {
        try {
            return zzlt.zza(this.zzu.zzaZ(), "google_app_id", this.zzu.zzq());
        } catch (IllegalStateException e) {
            this.zzu.zzaW().zzb().zzb("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    final /* synthetic */ void zzaf(SharedPreferences sharedPreferences, String str) {
        if (Objects.equals(str, "IABTCF_TCString") || Objects.equals(str, "IABTCF_gdprApplies") || Objects.equals(str, "IABTCF_EnableAdvertiserConsentMode")) {
            this.zzu.zzaW().zzk().zza("IABTCF_TCString change picked up in listener.");
            ((zzaz) Preconditions.checkNotNull(this.zzs)).zzb(500L);
        }
    }

    final /* synthetic */ void zzag(Bundle bundle) {
        int i;
        if (!bundle.isEmpty()) {
            zzic zzicVar = this.zzu;
            Bundle bundle2 = new Bundle(zzicVar.zzd().zzt.zza());
            Iterator<String> it = bundle.keySet().iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Object obj = bundle.get(next);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    if (zzicVar.zzk().zzz(obj)) {
                        zzicVar.zzk().zzP(this.zzt, null, 27, null, null, 0);
                    }
                    zzicVar.zzaW().zzh().zzc("Invalid default event parameter type. Name, value", next, obj);
                } else if (zzpp.zzac(next)) {
                    zzicVar.zzaW().zzh().zzb("Invalid default event parameter name. Name", next);
                } else if (obj == null) {
                    bundle2.remove(next);
                } else if (zzicVar.zzk().zzA("param", next, zzicVar.zzc().zze(null, false), obj)) {
                    zzicVar.zzk().zzO(bundle2, next, obj);
                }
            }
            zzicVar.zzk();
            int iZzc = zzicVar.zzc().zzc();
            if (bundle2.size() > iZzc) {
                for (String str : new TreeSet(bundle2.keySet())) {
                    i++;
                    if (i > iZzc) {
                        bundle2.remove(str);
                    }
                }
                zzicVar.zzk().zzP(this.zzt, null, 26, null, null, 0);
                zzicVar.zzaW().zzh().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            bundle = bundle2;
        }
        this.zzu.zzd().zzt.zzb(bundle);
        this.zzu.zzt().zzH(bundle);
    }

    final /* synthetic */ void zzah(int i) {
        if (this.zzk == null) {
            this.zzk = new zzjx(this, this.zzu);
        }
        this.zzk.zzb(((long) i) * 1000);
    }

    final /* synthetic */ void zzai(Boolean bool, boolean z) {
        zzaq(bool, true);
    }

    final /* synthetic */ void zzaj(zzjl zzjlVar, long j, boolean z, boolean z2) {
        zzg();
        zzb();
        zzic zzicVar = this.zzu;
        zzjl zzjlVarZzl = zzicVar.zzd().zzl();
        if (j <= this.zzp && zzjl.zzu(zzjlVarZzl.zzb(), zzjlVar.zzb())) {
            zzicVar.zzaW().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzjlVar);
            return;
        }
        zzhh zzhhVarZzd = zzicVar.zzd();
        zzic zzicVar2 = zzhhVarZzd.zzu;
        zzhhVarZzd.zzg();
        int iZzb = zzjlVar.zzb();
        if (!zzhhVarZzd.zzk(iZzb)) {
            zzicVar.zzaW().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjlVar.zzb()));
            return;
        }
        zzic zzicVar3 = this.zzu;
        SharedPreferences.Editor editorEdit = zzhhVarZzd.zzd().edit();
        editorEdit.putString("consent_settings", zzjlVar.zzl());
        editorEdit.putInt("consent_source", iZzb);
        editorEdit.apply();
        zzicVar.zzaW().zzk().zzb("Setting storage consent(FE)", zzjlVar);
        this.zzp = j;
        if (zzicVar3.zzt().zzP()) {
            zzicVar3.zzt().zzk(z);
        } else {
            zzicVar3.zzt().zzj(z);
        }
        if (z2) {
            zzicVar3.zzt().zzC(new AtomicReference());
        }
    }

    final /* synthetic */ void zzal(boolean z) {
        this.zzi = false;
    }

    final /* synthetic */ int zzam() {
        return this.zzj;
    }

    final /* synthetic */ void zzan(int i) {
        this.zzj = i;
    }

    final /* synthetic */ zzaz zzao() {
        return this.zzq;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final void zzh() {
        zzic zzicVar = this.zzu;
        if (!(zzicVar.zzaZ().getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) zzicVar.zzaZ().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzu.zzaX().zzk(atomicReference, 15000L, "boolean test flag value", new zzke(this, atomicReference));
    }

    public final String zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzu.zzaX().zzk(atomicReference, 15000L, "String test flag value", new zzko(this, atomicReference));
    }

    public final Long zzk() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzu.zzaX().zzk(atomicReference, 15000L, "long test flag value", new zzkp(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzu.zzaX().zzk(atomicReference, 15000L, "int test flag value", new zzkq(this, atomicReference));
    }

    public final Double zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzu.zzaX().zzk(atomicReference, 15000L, "double test flag value", new zzkr(this, atomicReference));
    }

    public final void zzn(Boolean bool) {
        zzb();
        this.zzu.zzaX().zzj(new zzks(this, bool));
    }

    final void zzp(Bundle bundle, int i, long j) {
        Object obj;
        String string;
        zzb();
        zzjl zzjlVar = zzjl.zza;
        zzjk[] zzjkVarArrZzb = zzjj.STORAGE.zzb();
        int length = zzjkVarArrZzb.length;
        int i2 = 0;
        while (true) {
            obj = null;
            if (i2 >= length) {
                break;
            }
            String str = zzjkVarArrZzb[i2].zze;
            if (bundle.containsKey(str) && (string = bundle.getString(str)) != null) {
                if (string.equals("granted")) {
                    obj = true;
                } else if (string.equals("denied")) {
                    obj = false;
                }
                if (obj == null) {
                    obj = string;
                    break;
                }
            }
            i2++;
        }
        if (obj != null) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zzh().zzb("Ignoring invalid consent setting", obj);
            zzicVar.zzaW().zzh().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zZze = this.zzu.zzaX().zze();
        zzjl zzjlVarZze = zzjl.zze(bundle, i);
        if (zzjlVarZze.zzc()) {
            zzs(zzjlVarZze, zZze);
        }
        zzba zzbaVarZzh = zzba.zzh(bundle, i);
        if (zzbaVarZzh.zzd()) {
            zzq(zzbaVarZzh, zZze);
        }
        Boolean boolZzi = zzba.zzi(bundle);
        if (boolZzi != null) {
            String str2 = i == -30 ? "tcf" : AndroidContextPlugin.APP_KEY;
            if (zZze) {
                zzM(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, boolZzi.toString(), j);
            } else {
                zzK(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, boolZzi.toString(), false, j);
            }
        }
    }

    final void zzq(zzba zzbaVar, boolean z) {
        zzkt zzktVar = new zzkt(this, zzbaVar);
        if (!z) {
            this.zzu.zzaX().zzj(zzktVar);
        } else {
            zzg();
            zzktVar.run();
        }
    }

    public final void zzs(zzjl zzjlVar, boolean z) {
        boolean z2;
        boolean zZzr;
        boolean z3;
        zzjl zzjlVar2;
        zzb();
        int iZzb = zzjlVar.zzb();
        if (iZzb != -10) {
            zzji zzjiVarZzp = zzjlVar.zzp();
            zzji zzjiVar = zzji.UNINITIALIZED;
            if (zzjiVarZzp == zzjiVar && zzjlVar.zzq() == zzjiVar) {
                this.zzu.zzaW().zzh().zza("Ignoring empty consent settings");
                return;
            }
        }
        synchronized (this.zzh) {
            z2 = false;
            if (zzjl.zzu(iZzb, this.zzn.zzb())) {
                zZzr = zzjlVar.zzr(this.zzn);
                zzjk zzjkVar = zzjk.ANALYTICS_STORAGE;
                if (zzjlVar.zzo(zzjkVar) && !this.zzn.zzo(zzjkVar)) {
                    z2 = true;
                }
                zzjlVar = zzjlVar.zzt(this.zzn);
                this.zzn = zzjlVar;
                z3 = z2;
                z2 = true;
            } else {
                zZzr = false;
                z3 = false;
            }
            zzjlVar2 = zzjlVar;
        }
        if (!z2) {
            this.zzu.zzaW().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzjlVar2);
            return;
        }
        long andIncrement = this.zzo.getAndIncrement();
        if (zZzr) {
            this.zzg.set(null);
            zzku zzkuVar = new zzku(this, zzjlVar2, andIncrement, z3);
            if (!z) {
                this.zzu.zzaX().zzl(zzkuVar);
                return;
            } else {
                zzg();
                zzkuVar.run();
                return;
            }
        }
        zzkv zzkvVar = new zzkv(this, zzjlVar2, andIncrement, z3);
        if (z) {
            zzg();
            zzkvVar.run();
        } else if (iZzb == 30 || iZzb == -10) {
            this.zzu.zzaX().zzl(zzkvVar);
        } else {
            this.zzu.zzaX().zzj(zzkvVar);
        }
    }

    final void zzt(Runnable runnable) {
        zzb();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzaX().zze()) {
            zzicVar.zzaW().zzb().zza("Cannot retrieve and upload batches from analytics worker thread");
            return;
        }
        if (zzicVar.zzaX().zzf()) {
            zzicVar.zzaW().zzb().zza("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        zzicVar.zzaV();
        if (zzae.zza()) {
            zzicVar.zzaW().zzb().zza("Cannot retrieve and upload batches from main thread");
            return;
        }
        zzicVar.zzaW().zzk().zza("[sgtm] Started client-side batch upload work.");
        boolean z = false;
        int size = 0;
        int i = 0;
        while (!z) {
            zzicVar.zzaW().zzk().zza("[sgtm] Getting upload batches from service (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzicVar.zzaX().zzk(atomicReference, 10000L, "[sgtm] Getting upload batches", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzli
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzu.zzt().zzx(atomicReference, zzoo.zza(zzls.SGTM_CLIENT));
                }
            });
            zzoq zzoqVar = (zzoq) atomicReference.get();
            if (zzoqVar == null) {
                break;
            }
            List list = zzoqVar.zza;
            if (!list.isEmpty()) {
                zzicVar.zzaW().zzk().zzb("[sgtm] Retrieved upload batches. count", Integer.valueOf(list.size()));
                size += list.size();
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    zzlr zzlrVarZzap = zzap((zzom) it.next());
                    if (zzlrVarZzap == zzlr.SUCCESS) {
                        i++;
                    } else if (zzlrVarZzap == zzlr.BACKOFF) {
                        z = true;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        zzicVar.zzaW().zzk().zzc("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(size), Integer.valueOf(i));
        runnable.run();
    }

    final void zzu(long j) {
        zzg();
        if (this.zzl == null) {
            this.zzl = new zzju(this, this.zzu);
        }
        this.zzl.zzb(j);
    }

    final void zzv() {
        zzg();
        zzaz zzazVar = this.zzl;
        if (zzazVar != null) {
            zzazVar.zzd();
        }
    }

    final void zzw() {
        zzaif.zza();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzc().zzp(null, zzfy.zzaP)) {
            if (zzicVar.zzaX().zze()) {
                zzicVar.zzaW().zzb().zza("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            zzicVar.zzaV();
            if (zzae.zza()) {
                zzicVar.zzaW().zzb().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzb();
            zzicVar.zzaW().zzk().zza("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzicVar.zzaX().zzk(atomicReference, 10000L, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzla
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzlj zzljVar = this.zza;
                    zzljVar.zzu.zzt().zzw(atomicReference, zzljVar.zzu.zzd().zzi.zza());
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                zzicVar.zzaW().zzd().zza("Timed out waiting for get trigger URIs");
            } else {
                zzicVar.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlb
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzlj zzljVar = this.zza;
                        zzljVar.zzg();
                        if (Build.VERSION.SDK_INT < 30) {
                            return;
                        }
                        List<zzoh> list2 = list;
                        SparseArray sparseArrayZzf = zzljVar.zzu.zzd().zzf();
                        for (zzoh zzohVar : list2) {
                            int i = zzohVar.zzc;
                            if (!sparseArrayZzf.contains(i) || ((Long) sparseArrayZzf.get(i)).longValue() < zzohVar.zzb) {
                                zzljVar.zzx().add(zzohVar);
                            }
                        }
                        zzljVar.zzy();
                    }
                });
            }
        }
    }

    final PriorityQueue zzx() {
        if (this.zzm == null) {
            this.zzm = new PriorityQueue(Comparator.comparing(zzlc.zza, zzld.zza));
        }
        return this.zzm;
    }

    final void zzy() {
        zzoh zzohVar;
        zzg();
        if (zzx().isEmpty() || this.zzi || (zzohVar = (zzoh) zzx().poll()) == null) {
            return;
        }
        zzic zzicVar = this.zzu;
        MeasurementManagerFutures measurementManagerFuturesZzV = zzicVar.zzk().zzV();
        if (measurementManagerFuturesZzV != null) {
            this.zzi = true;
            zzgs zzgsVarZzk = zzicVar.zzaW().zzk();
            String str = zzohVar.zza;
            zzgsVarZzk.zzb("Registering trigger URI", str);
            ListenableFuture<Unit> listenableFutureRegisterTriggerAsync = measurementManagerFuturesZzV.registerTriggerAsync(Uri.parse(str));
            if (listenableFutureRegisterTriggerAsync != null) {
                Futures.addCallback(listenableFutureRegisterTriggerAsync, new zzjw(this, zzohVar), new zzjv(this));
            } else {
                this.zzi = false;
                zzx().add(zzohVar);
            }
        }
    }

    final void zzz(zzjl zzjlVar) {
        zzg();
        boolean z = (zzjlVar.zzo(zzjk.ANALYTICS_STORAGE) && zzjlVar.zzo(zzjk.AD_STORAGE)) || this.zzu.zzt().zzO();
        zzic zzicVar = this.zzu;
        if (z != zzicVar.zzE()) {
            zzicVar.zzD(z);
            zzhh zzhhVarZzd = this.zzu.zzd();
            zzic zzicVar2 = zzhhVarZzd.zzu;
            zzhhVarZzd.zzg();
            Boolean boolValueOf = zzhhVarZzd.zzd().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzhhVarZzd.zzd().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || boolValueOf == null || boolValueOf.booleanValue()) {
                zzaq(Boolean.valueOf(z), false);
            }
        }
    }
}
