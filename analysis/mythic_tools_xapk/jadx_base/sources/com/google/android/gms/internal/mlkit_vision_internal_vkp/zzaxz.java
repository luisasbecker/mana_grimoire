package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaxz {
    private static zzkz zza;
    private static final zzlb zzb = zzlb.zzc("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzaxs zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;

    public zzaxz(Context context, final SharedPrefManager sharedPrefManager, zzaxs zzaxsVar, String str) {
        new HashMap();
        new HashMap();
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzaxsVar;
        zzayn.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        Objects.requireNonNull(sharedPrefManager);
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxy
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return sharedPrefManager.getMlSdkInstanceId();
            }
        });
        zzlb zzlbVar = zzb;
        this.zzj = zzlbVar.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzlbVar.get(str)) : -1;
    }

    private static synchronized zzkz zze() {
        zzkz zzkzVar = zza;
        if (zzkzVar != null) {
            return zzkzVar;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        zzkw zzkwVar = new zzkw();
        for (int i = 0; i < locales.size(); i++) {
            zzkwVar.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
        }
        zzkz zzkzVarZzc = zzkwVar.zzc();
        zza = zzkzVarZzc;
        return zzkzVarZzc;
    }

    final /* synthetic */ String zza() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    final /* synthetic */ void zzb(zzaxr zzaxrVar, zzary zzaryVar, String str) {
        zzaxrVar.zza(zzaryVar);
        String strZzc = zzaxrVar.zzc();
        zzavq zzavqVar = new zzavq();
        zzavqVar.zzb(this.zzc);
        zzavqVar.zzc(this.zzd);
        zzavqVar.zzh(zze());
        zzavqVar.zzg(true);
        zzavqVar.zzl(strZzc);
        zzavqVar.zzj(str);
        zzavqVar.zzi(this.zzh.isSuccessful() ? (String) this.zzh.getResult() : this.zzf.getMlSdkInstanceId());
        zzavqVar.zzd(10);
        zzavqVar.zzk(Integer.valueOf(this.zzj));
        zzaxrVar.zzb(zzavqVar);
        this.zze.zza(zzaxrVar);
    }

    public final void zzc(zzaxr zzaxrVar, zzary zzaryVar) throws Throwable {
        String version;
        if (this.zzg.isSuccessful()) {
            version = (String) this.zzg.getResult();
        } else {
            version = LibraryVersion.getInstance().getVersion(this.zzi);
        }
        zzd(zzaxrVar, zzaryVar, version);
    }

    public final void zzd(final zzaxr zzaxrVar, final zzary zzaryVar, final String str) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxw
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(zzaxrVar, zzaryVar, str);
            }
        });
    }
}
