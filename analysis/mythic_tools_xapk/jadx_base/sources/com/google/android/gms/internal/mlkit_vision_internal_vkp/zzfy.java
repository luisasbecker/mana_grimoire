package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.work.PeriodicWorkRequest;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfy {
    public static final zziy zza;
    private static final zzkz zzb;

    static {
        zziv zzivVarZza = zziy.zza();
        zzivVarZza.zzb("");
        zza = (zziy) zzivVarZza.zzv();
        zzb = zzkz.zzi("/m/0jbk");
    }

    public static com.google.android.libraries.vision.visionkit.pipeline.zzdr zza(Context context, boolean z, zzhp zzhpVar, zziy zziyVar, zzbhv zzbhvVar) {
        com.google.android.libraries.vision.visionkit.pipeline.zzdr zzdrVarZza = com.google.android.libraries.vision.visionkit.pipeline.zzdu.zza();
        zzdrVarZza.zzb(zzg(zzi(context.getAssets(), zzhpVar), zziyVar, z, zzbhvVar, 0));
        String strZze = zze(context);
        if (strZze != null) {
            zzdrVarZza.zzd(strZze);
            zzdrVarZza.zze(strZze);
        }
        return zzdrVarZza;
    }

    public static com.google.android.libraries.vision.visionkit.pipeline.zzdr zzb(Context context, boolean z, zzhp zzhpVar, zziy zziyVar, long j, zzbhx zzbhxVar) {
        zzbsm zzbsmVarZzi = zzi(context.getAssets(), zzhpVar);
        String strZze = zze(context);
        com.google.android.libraries.vision.visionkit.pipeline.zzdr zzdrVarZza = com.google.android.libraries.vision.visionkit.pipeline.zzdu.zza();
        com.google.android.libraries.vision.visionkit.pipeline.zzeb zzebVarZza = com.google.android.libraries.vision.visionkit.pipeline.zzec.zza();
        com.google.android.libraries.vision.visionkit.pipeline.zzco zzcoVarZza = com.google.android.libraries.vision.visionkit.pipeline.zzcv.zza();
        com.google.android.libraries.vision.visionkit.pipeline.zzcp zzcpVarZza = com.google.android.libraries.vision.visionkit.pipeline.zzcu.zza();
        zzcpVarZza.zza("MobileObjectLocalizerV3_1TfLiteClient");
        zzcpVarZza.zzb(PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        zzcoVarZza.zza(zzcpVarZza);
        zzebVarZza.zza((com.google.android.libraries.vision.visionkit.pipeline.zzcv) zzcoVarZza.zzv());
        zzdrVarZza.zzh((com.google.android.libraries.vision.visionkit.pipeline.zzec) zzebVarZza.zzv());
        if (strZze != null) {
            zzdrVarZza.zzd(strZze);
            zzdrVarZza.zze(strZze);
        }
        if (zzbhxVar != null) {
            zzdrVarZza.zzc(zzbhxVar);
        }
        int iZzf = zzf(z);
        zzdrVarZza.zzf(true);
        zzdrVarZza.zzi(zzjy.zzc());
        com.google.android.libraries.vision.visionkit.pipeline.zzbw zzbwVarZza = com.google.android.libraries.vision.visionkit.pipeline.zzby.zza();
        zzbwVarZza.zzc(false);
        zzbwVarZza.zzb(iZzf);
        zzbwVarZza.zzd(0.2f);
        zzbwVarZza.zza(0.0f);
        zzbwVarZza.zze(3);
        zzdrVarZza.zzg(zzbwVarZza);
        zzdrVarZza.zzb(zzg(zzbsmVarZzi, zziyVar, z, zzbhv.zze(), 0));
        return zzdrVarZza;
    }

    public static zziy zzc(Context context, zzhp zzhpVar, String str, float f, int i) throws IOException {
        zziv zzivVarZza = zziy.zza();
        zzhl zzhlVarZza = zzhm.zza();
        zzhlVarZza.zzb(zzhpVar);
        zzivVarZza.zze(zzhlVarZza);
        zzivVarZza.zzd(i);
        if (f >= 0.0f) {
            zzivVarZza.zzg(f);
        }
        if (!str.isEmpty()) {
            zzhl zzhlVarZza2 = zzhm.zza();
            zzhlVarZza2.zza(zzbdd.zzp(context.getAssets().open(str)));
            zzivVarZza.zzh(zzhlVarZza2);
        }
        return (zziy) zzivVarZza.zzv();
    }

    public static zziy zzd(zzhp zzhpVar, zzbhv zzbhvVar) {
        zzhl zzhlVarZza = zzhm.zza();
        zzhlVarZza.zzb(zzhpVar);
        zzhm zzhmVar = (zzhm) zzhlVarZza.zzv();
        zziv zzivVarZza = zziy.zza();
        zzivVarZza.zza(zzb);
        zzivVarZza.zzc(zzbhvVar);
        zzivVarZza.zzf(zzhmVar);
        return (zziy) zzivVarZza.zzv();
    }

    public static String zze(Context context) {
        File file = new File(context.getCodeCacheDir(), "odt/v1");
        if (file.mkdirs() || file.exists()) {
            return file.toString();
        }
        Log.e("MlKitObjectsConfigs", "Unable to create accelerator directory ".concat(file.toString()));
        return null;
    }

    private static int zzf(boolean z) {
        return z ? 5 : 1;
    }

    private static com.google.android.libraries.vision.visionkit.pipeline.zzao zzg(zzbsm zzbsmVar, zziy zziyVar, boolean z, zzbhv zzbhvVar, int i) {
        com.google.android.libraries.vision.visionkit.pipeline.zzao zzaoVarZza = com.google.android.libraries.vision.visionkit.pipeline.zzap.zza();
        zzaoVarZza.zzd(true);
        zzbsk zzbskVarZzc = zzbsq.zzc();
        zzbskVarZzc.zzd("MobileSSDTfLiteClient");
        zzbskVarZzc.zza(true);
        zzbskVarZzc.zzc(zzbsmVar);
        zzbskVarZzc.zzb(zzbhvVar);
        zzaoVarZza.zzc((zzbsq) zzbskVarZzc.zzv());
        zzaoVarZza.zzb(zziyVar);
        zzhf zzhfVarZza = zzhg.zza();
        zzhc zzhcVarZza = zzhd.zza();
        zzhcVarZza.zza("/m/0bl9f");
        zzhcVarZza.zzb(0.46f);
        zzhfVarZza.zza(zzhcVarZza);
        zzaoVarZza.zza(zzhfVarZza);
        zzaoVarZza.zzh(!z);
        zzaoVarZza.zzf(zzf(z));
        zzaoVarZza.zze(0.6f);
        zzaoVarZza.zzg(0);
        return zzaoVarZza;
    }

    private static zzbdd zzh(AssetManager assetManager, String str, String str2) throws IOException {
        return zzbdd.zzp(assetManager.open("mlkit_odt_localizer/".concat(str2)));
    }

    private static zzbsm zzi(AssetManager assetManager, zzhp zzhpVar) {
        try {
            zzbsn zzbsnVarZzc = zzbso.zzc();
            zzbsnVarZzc.zza(zzhpVar.zza());
            zzbsnVarZzc.zzc(zzhpVar.zzd());
            zzbsnVarZzc.zzb(zzhpVar.zzc());
            zzbso zzbsoVar = (zzbso) zzbsnVarZzc.zzv();
            zzbsl zzbslVarZzc = zzbsm.zzc();
            zzbslVarZzc.zzc(zzbsoVar);
            zzbslVarZzc.zzb(zzh(assetManager, "mlkit_odt_localizer", "mobile_object_localizer_labelmap"));
            zzbslVarZzc.zza(zzh(assetManager, "mlkit_odt_localizer", "mobile_object_localizer_3_1_anchors.pb"));
            return (zzbsm) zzbslVarZzc.zzv();
        } catch (IOException e) {
            Log.e("MlKitObjectsConfigs", "Failed to create detector client options: ", e);
            return zzbsm.zzf();
        }
    }
}
