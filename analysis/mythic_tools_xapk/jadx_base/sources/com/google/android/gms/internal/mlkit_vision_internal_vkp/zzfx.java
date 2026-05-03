package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfx {
    public static com.google.android.libraries.vision.visionkit.pipeline.zzcg zza(String str, float f, int i, String str2) {
        zzhl zzhlVarZza;
        zzhl zzhlVarZza2 = zzhm.zza();
        zzhlVarZza2.zzc(str);
        if (str2.isEmpty()) {
            zzhlVarZza = null;
        } else {
            zzhlVarZza = zzhm.zza();
            zzhlVarZza.zzc(str2);
        }
        return zzd(zzhlVarZza2, f, i, zzhlVarZza);
    }

    public static com.google.android.libraries.vision.visionkit.pipeline.zzcg zzb(zzhp zzhpVar, float f, int i, String str, Context context) throws IOException {
        zzhl zzhlVarZza;
        zzhl zzhlVarZza2 = zzhm.zza();
        zzhlVarZza2.zzb(zzhpVar);
        if (str.isEmpty()) {
            zzhlVarZza = null;
        } else {
            zzhlVarZza = zzhm.zza();
            zzhlVarZza.zza(zzbdd.zzp(context.getAssets().open(str)));
        }
        return zzd(zzhlVarZza2, f, i, zzhlVarZza);
    }

    public static com.google.android.libraries.vision.visionkit.pipeline.zzcg zzc(Context context, float f, int i) throws IOException {
        zzhl zzhlVarZza = zzhm.zza();
        zzhlVarZza.zza(zzbdd.zzp(context.getAssets().open("mlkit_label_default_model/mobile_ica_8bit_with_metadata_tflite")));
        return zzd(zzhlVarZza, f, i, null);
    }

    private static com.google.android.libraries.vision.visionkit.pipeline.zzcg zzd(zzhl zzhlVar, float f, int i, zzhl zzhlVar2) {
        zziv zzivVarZza = zziy.zza();
        zzivVarZza.zze(zzhlVar);
        zzivVarZza.zzd(i);
        if (f >= 0.0f) {
            zzivVarZza.zzg(f);
        }
        if (zzhlVar2 != null) {
            zzivVarZza.zzh(zzhlVar2);
        }
        com.google.android.libraries.vision.visionkit.pipeline.zzcf zzcfVarZzc = com.google.android.libraries.vision.visionkit.pipeline.zzcg.zzc();
        com.google.android.libraries.vision.visionkit.pipeline.zzdr zzdrVarZza = com.google.android.libraries.vision.visionkit.pipeline.zzdu.zza();
        zzdrVarZza.zza(zzivVarZza);
        zzdrVarZza.zzf(true);
        zzcfVarZzc.zzc(zzdrVarZza);
        com.google.android.libraries.vision.visionkit.pipeline.zzfh zzfhVarZza = com.google.android.libraries.vision.visionkit.pipeline.zzfi.zza();
        zzfhVarZza.zzb(2);
        zzcfVarZzc.zzd(zzfhVarZza);
        com.google.android.libraries.vision.visionkit.pipeline.zzi zziVarZza = com.google.android.libraries.vision.visionkit.pipeline.zzj.zza();
        zziVarZza.zza(2);
        zzcfVarZzc.zzb(zziVarZza);
        return (com.google.android.libraries.vision.visionkit.pipeline.zzcg) zzcfVarZzc.zzv();
    }
}
