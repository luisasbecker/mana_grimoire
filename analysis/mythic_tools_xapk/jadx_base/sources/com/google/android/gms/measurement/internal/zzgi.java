package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.internal.measurement.zzaja;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgi extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private final long zzh;
    private List zzi;
    private String zzj;
    private final String zzk;
    private int zzl;
    private String zzm;
    private String zzn;
    private long zzo;
    private String zzp;

    zzgi(zzic zzicVar, long j, long j2, String str) {
        super(zzicVar);
        this.zzo = 0L;
        this.zzp = null;
        this.zzg = j;
        this.zzh = j2;
        this.zzk = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:0|2|(1:4)(19:85|6|(1:10)(2:11|(1:13))|87|14|(4:16|(1:18)(1:20)|81|21)|26|(2:28|(2:30|(2:32|(2:34|(2:36|(2:38|(1:40)(1:41))(1:42))(1:43))(1:44))(1:45))(1:46))(1:47)|48|83|49|(1:51)(1:52)|53|(1:55)(1:56)|57|(1:59)|63|(2:66|(1:68)(4:69|(3:72|(1:90)(1:91)|70)|89|75))(1:75)|(2:77|78)(2:79|80))|5|26|(0)(0)|48|83|49|(0)(0)|53|(0)(0)|57|(0)|63|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a3, code lost:
    
        r11.zzu.zzaW().zzb().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r1), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0176 A[Catch: IllegalStateException -> 0x01a2, TryCatch #1 {IllegalStateException -> 0x01a2, blocks: (B:49:0x016d, B:53:0x0184, B:57:0x018c, B:59:0x0190, B:52:0x0176), top: B:83:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0190 A[Catch: IllegalStateException -> 0x01a2, TRY_LEAVE, TryCatch #1 {IllegalStateException -> 0x01a2, blocks: (B:49:0x016d, B:53:0x0184, B:57:0x018c, B:59:0x0190, B:52:0x0176), top: B:83:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020b  */
    @Override // com.google.android.gms.measurement.internal.zzg
    @EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void zzf() {
        String str;
        String string;
        int iZzC;
        List listZzs;
        String strZza;
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzk().zzc("sdkVersion bundled with app, dynamiteVersion", Long.valueOf(this.zzh), Long.valueOf(this.zzg));
        String packageName = zzicVar.zzaZ().getPackageName();
        PackageManager packageManager = zzicVar.zzaZ().getPackageManager();
        String str2 = "";
        int i = Integer.MIN_VALUE;
        String str3 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String installerPackageName = "unknown";
        if (packageManager != null) {
            try {
                installerPackageName = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                this.zzu.zzaW().zzb().zzb("Error retrieving app installer package name. appId", zzgu.zzl(packageName));
            }
            if (installerPackageName == null) {
                installerPackageName = "manual_install";
            } else if ("com.android.vending".equals(installerPackageName)) {
                installerPackageName = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(this.zzu.zzaZ().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    try {
                        str3 = packageInfo.versionName;
                        i = packageInfo.versionCode;
                    } catch (PackageManager.NameNotFoundException unused2) {
                        str = str3;
                        str3 = string;
                        this.zzu.zzaW().zzb().zzc("Error retrieving package info. appId, appName", zzgu.zzl(packageName), str3);
                        string = str3;
                        str3 = str;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused3) {
                str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            this.zza = packageName;
            this.zzd = installerPackageName;
            this.zzb = str3;
            this.zzc = i;
            this.zze = string;
            this.zzf = 0L;
            zzic zzicVar2 = this.zzu;
            iZzC = zzicVar2.zzC();
            if (iZzC != 0) {
                this.zzu.zzaW().zzk().zza("App measurement collection enabled");
            } else if (iZzC == 1) {
                this.zzu.zzaW().zzi().zza("App measurement deactivated via the manifest");
            } else if (iZzC == 3) {
                this.zzu.zzaW().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
            } else if (iZzC == 4) {
                this.zzu.zzaW().zzi().zza("App measurement disabled via the manifest");
            } else if (iZzC == 6) {
                this.zzu.zzaW().zzh().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
            } else if (iZzC == 7) {
                this.zzu.zzaW().zzi().zza("App measurement disabled via the global data collection setting");
            } else if (iZzC != 8) {
                zzic zzicVar3 = this.zzu;
                zzicVar3.zzaW().zzi().zza("App measurement disabled");
                zzicVar3.zzaW().zzc().zza("Invalid scion state in identity");
            } else {
                this.zzu.zzaW().zzi().zza("App measurement disabled due to denied storage consent");
            }
            this.zzm = "";
            zzic zzicVar4 = this.zzu;
            zzicVar4.zzaV();
            strZza = this.zzk;
            if (!TextUtils.isEmpty(strZza)) {
                strZza = zzlt.zza(zzicVar4.zzaZ(), "google_app_id", zzicVar2.zzq());
            }
            if (TextUtils.isEmpty(strZza)) {
                str2 = strZza;
            }
            this.zzm = str2;
            if (iZzC == 0) {
                zzicVar4.zzaW().zzk().zzc("App measurement enabled for app package, google app id", this.zza, this.zzm);
            }
            this.zzi = null;
            zzic zzicVar5 = this.zzu;
            zzicVar5.zzaV();
            listZzs = zzicVar5.zzc().zzs("analytics.safelisted_events");
            if (listZzs == null) {
                this.zzi = listZzs;
            } else if (listZzs.isEmpty()) {
                zzicVar5.zzaW().zzh().zza("Safelisted event list is empty. Ignoring");
            } else {
                Iterator it = listZzs.iterator();
                while (it.hasNext()) {
                    if (!zzicVar5.zzk().zzl("safelisted event", (String) it.next())) {
                        break;
                    }
                }
                this.zzi = listZzs;
            }
            if (packageManager == null) {
                this.zzl = InstantApps.isInstantApp(zzicVar5.zzaZ()) ? 1 : 0;
                return;
            } else {
                this.zzl = 0;
                return;
            }
        }
        zzicVar.zzaW().zzb().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzgu.zzl(packageName));
        string = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        this.zza = packageName;
        this.zzd = installerPackageName;
        this.zzb = str3;
        this.zzc = i;
        this.zze = string;
        this.zzf = 0L;
        zzic zzicVar22 = this.zzu;
        iZzC = zzicVar22.zzC();
        if (iZzC != 0) {
        }
        this.zzm = "";
        zzic zzicVar42 = this.zzu;
        zzicVar42.zzaV();
        strZza = this.zzk;
        if (!TextUtils.isEmpty(strZza)) {
        }
        if (TextUtils.isEmpty(strZza)) {
        }
        this.zzm = str2;
        if (iZzC == 0) {
        }
        this.zzi = null;
        zzic zzicVar52 = this.zzu;
        zzicVar52.zzaV();
        listZzs = zzicVar52.zzc().zzs("analytics.safelisted_events");
        if (listZzs == null) {
        }
        if (packageManager == null) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzr zzh(String str) {
        long j;
        String str2;
        String str3;
        Class<?> clsLoadClass;
        String str4;
        long j2;
        long jMin;
        long j3;
        String str5;
        boolean z;
        int i;
        long j4;
        ApplicationInfo applicationInfo;
        zzg();
        String strZzj = zzj();
        String strZzk = zzk();
        zzb();
        String str6 = this.zzb;
        zzb();
        long j5 = this.zzc;
        zzb();
        Preconditions.checkNotNull(this.zzd);
        String str7 = this.zzd;
        zzic zzicVar = this.zzu;
        zzicVar.zzc().zzi();
        zzb();
        zzg();
        long j6 = this.zzf;
        if (j6 == 0) {
            zzpp zzppVarZzk = this.zzu.zzk();
            Context contextZzaZ = zzicVar.zzaZ();
            String packageName = zzicVar.zzaZ().getPackageName();
            zzppVarZzk.zzg();
            Preconditions.checkNotNull(contextZzaZ);
            Preconditions.checkNotEmpty(packageName);
            PackageManager packageManager = contextZzaZ.getPackageManager();
            MessageDigest messageDigestZzQ = zzpp.zzQ();
            long jZzR = -1;
            if (messageDigestZzQ == null) {
                zzppVarZzk.zzu.zzaW().zzb().zza("Could not get MD5 instance");
                j = 0;
            } else {
                if (packageManager != null) {
                    try {
                        if (zzppVarZzk.zzag(contextZzaZ, packageName)) {
                            j = 0;
                            jZzR = 0;
                        } else {
                            PackageManagerWrapper packageManagerWrapperPackageManager = Wrappers.packageManager(contextZzaZ);
                            zzic zzicVar2 = zzppVarZzk.zzu;
                            j = 0;
                            try {
                                PackageInfo packageInfo = packageManagerWrapperPackageManager.getPackageInfo(zzicVar2.zzaZ().getPackageName(), 64);
                                if (packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                                    zzicVar2.zzaW().zze().zza("Could not get signatures");
                                } else {
                                    jZzR = zzpp.zzR(messageDigestZzQ.digest(packageInfo.signatures[0].toByteArray()));
                                }
                            } catch (PackageManager.NameNotFoundException e) {
                                e = e;
                                zzppVarZzk.zzu.zzaW().zzb().zzb("Package name not found", e);
                                j6 = j;
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                        e = e2;
                        j = 0;
                    }
                } else {
                    j = 0;
                }
                j6 = j;
                this.zzf = j6;
            }
            j6 = jZzR;
            this.zzf = j6;
        } else {
            j = 0;
        }
        long j7 = j6;
        zzic zzicVar3 = this.zzu;
        zzic zzicVar4 = this.zzu;
        boolean zZzB = zzicVar3.zzB();
        boolean z2 = !zzicVar4.zzd().zzm;
        zzg();
        if (zzicVar3.zzB()) {
            zzaja.zza();
            if (zzicVar4.zzc().zzp(null, zzfy.zzaH)) {
                this.zzu.zzaW().zzk().zza("Disabled IID for tests.");
            } else {
                try {
                    clsLoadClass = zzicVar4.zzaZ().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                } catch (ClassNotFoundException unused) {
                }
                if (clsLoadClass != null) {
                    try {
                        Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, this.zzu.zzaZ());
                        if (objInvoke == null) {
                            str2 = strZzj;
                        } else {
                            str2 = strZzj;
                            try {
                                str3 = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                            } catch (Exception unused2) {
                                this.zzu.zzaW().zzh().zza("Failed to retrieve Firebase Instance Id");
                                str3 = null;
                            }
                        }
                    } catch (Exception unused3) {
                        str2 = strZzj;
                        this.zzu.zzaW().zzf().zza("Failed to obtain Firebase Analytics instance");
                    }
                    str3 = null;
                }
            }
            str2 = strZzj;
            str3 = null;
        } else {
            str2 = strZzj;
            str3 = null;
        }
        zzic zzicVar5 = this.zzu;
        long jZza = zzicVar5.zzd().zzc.zza();
        if (jZza == j) {
            jMin = zzicVar5.zza;
            str4 = str6;
            j2 = j5;
        } else {
            str4 = str6;
            j2 = j5;
            jMin = Math.min(zzicVar5.zza, jZza);
        }
        zzb();
        int i2 = this.zzl;
        zzic zzicVar6 = this.zzu;
        boolean zZzu = zzicVar6.zzc().zzu();
        zzhh zzhhVarZzd = zzicVar6.zzd();
        zzhhVarZzd.zzg();
        long j8 = jMin;
        boolean z3 = zzhhVarZzd.zzd().getBoolean("deferred_analytics_collection", false);
        boolean z4 = zzicVar6.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true) != zzji.GRANTED;
        long j9 = this.zzg;
        Boolean boolValueOf = Boolean.valueOf(z4);
        List list = this.zzi;
        String strZzl = zzicVar6.zzd().zzl().zzl();
        if (this.zzj == null) {
            this.zzj = zzicVar6.zzk().zzaz();
        }
        String str8 = this.zzj;
        if (zzicVar6.zzd().zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
            zzg();
            j3 = j9;
            if (this.zzo != j) {
                long jCurrentTimeMillis = zzicVar6.zzba().currentTimeMillis() - this.zzo;
                if (this.zzn != null && jCurrentTimeMillis > 86400000 && this.zzp == null) {
                    zzi();
                }
            }
            if (this.zzn == null) {
                zzi();
            }
            str5 = this.zzn;
        } else {
            j3 = j9;
            str5 = null;
        }
        boolean zZzx = zzicVar6.zzc().zzx();
        zzpp zzppVarZzk2 = zzicVar6.zzk();
        String strZzj2 = zzj();
        zzic zzicVar7 = zzppVarZzk2.zzu;
        if (zzicVar7.zzaZ().getPackageManager() == null) {
            z = zZzx;
            j4 = j;
        } else {
            try {
                z = zZzx;
                i = 0;
                try {
                    applicationInfo = Wrappers.packageManager(zzicVar7.zzaZ()).getApplicationInfo(strZzj2, 0);
                } catch (PackageManager.NameNotFoundException unused4) {
                    zzic zzicVar8 = zzppVarZzk2.zzu;
                    zzicVar8.zzaV();
                    zzicVar8.zzaW().zzi().zzb("PackageManager failed to find running app: app_id", strZzj2);
                }
            } catch (PackageManager.NameNotFoundException unused5) {
                z = zZzx;
                i = 0;
            }
            int i3 = applicationInfo != null ? applicationInfo.targetSdkVersion : i;
            j4 = i3;
        }
        zzic zzicVar9 = this.zzu;
        int iZzb = zzicVar9.zzd().zzl().zzb();
        String strZze = zzicVar9.zzd().zzj().zze();
        zzaif.zza();
        zzal zzalVarZzc = zzicVar9.zzc();
        String str9 = str5;
        zzfx zzfxVar = zzfy.zzaP;
        long j10 = j4;
        int iZzW = zzalVarZzc.zzp(null, zzfxVar) ? zzicVar9.zzk().zzW() : 0;
        zzaif.zza();
        long jZzX = zzicVar9.zzc().zzp(null, zzfxVar) ? zzicVar9.zzk().zzX() : j;
        String strZzz = zzicVar9.zzc().zzz();
        int i4 = iZzW;
        String strZzb = new zze(zzicVar9.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true)).zzb();
        zzic zzicVar10 = this.zzu;
        return new zzr(str2, strZzk, str4, j2, str7, 161000L, j7, str, zZzB, z2, str3, j8, i2, zZzu, z3, boolValueOf, j3, list, strZzl, str8, str9, z, j10, iZzb, strZze, i4, jZzX, strZzz, strZzb, zzicVar10.zza, this.zzu.zzx().zzj().zza(), zzicVar9.zzc().zzp(null, zzfy.zzbe) ? zzicVar10.zzb : j);
    }

    final void zzi() {
        String str;
        zzg();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzd().zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            zzicVar.zzk().zzf().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            zzicVar.zzaW().zzj().zza("Analytics Storage consent is not granted");
            str = null;
        }
        zzicVar.zzaW().zzj().zza(String.format("Resetting session stitching token to %s", str == null ? AbstractJsonLexerKt.NULL : "not null"));
        this.zzn = str;
        this.zzo = zzicVar.zzba().currentTimeMillis();
    }

    final String zzj() {
        zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    final String zzk() {
        zzg();
        zzb();
        Preconditions.checkNotNull(this.zzm);
        return this.zzm;
    }

    final String zzl() {
        zzb();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    final int zzm() {
        zzb();
        return this.zzc;
    }

    final long zzn() {
        return this.zzh;
    }

    final int zzo() {
        zzb();
        return this.zzl;
    }

    final List zzp() {
        return this.zzi;
    }

    final boolean zzq(String str) {
        String str2 = this.zzp;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzp = str;
        return z;
    }
}
