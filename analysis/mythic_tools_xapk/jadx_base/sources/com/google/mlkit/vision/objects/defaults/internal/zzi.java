package com.google.mlkit.vision.objects.defaults.internal;

import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzan;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzaq;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzrp;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzrq;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzrs;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzsq;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzsr;
import com.google.mlkit.vision.objects.defaults.ObjectDetectorOptions;
import com.google.mlkit.vision.vkp.VkpStatus;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzi {
    public static zzaq zza(VkpStatus vkpStatus) {
        zzan zzanVar = new zzan();
        for (VkpStatus.VkpError vkpError : vkpStatus.getErrors()) {
            zzsq zzsqVar = new zzsq();
            zzsqVar.zzb(zzsr.zzb(vkpError.getErrorSpaceNumber()));
            zzsqVar.zza(Integer.valueOf(vkpError.getErrorCode()));
            zzanVar.zzb(zzsqVar.zzd());
        }
        return zzanVar.zzc();
    }

    public static zzrs zzb(ObjectDetectorOptions objectDetectorOptions) {
        zzrq zzrqVar;
        zzrp zzrpVar = new zzrp();
        int detectorMode = objectDetectorOptions.getDetectorMode();
        if (detectorMode == 1) {
            zzrqVar = zzrq.STREAM;
        } else if (detectorMode != 2) {
            Log.e("ObjectsLoggingUtils", "Unexpected detector mode: " + detectorMode);
            zzrqVar = zzrq.MODE_UNSPECIFIED;
        } else {
            zzrqVar = zzrq.SINGLE_IMAGE;
        }
        zzrpVar.zzb(zzrqVar);
        zzrpVar.zzc(Boolean.valueOf(objectDetectorOptions.isMultipleObjectsEnabled()));
        zzrpVar.zza(Boolean.valueOf(objectDetectorOptions.isClassificationEnabled()));
        return zzrpVar.zze();
    }
}
