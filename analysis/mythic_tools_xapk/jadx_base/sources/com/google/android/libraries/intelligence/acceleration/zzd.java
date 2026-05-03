package com.google.android.libraries.intelligence.acceleration;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdv;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbew;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbkr;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzblq;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd {
    public static zzbkr zza() {
        byte[] bArrGetDeviceInfo = AndroidSystemDetectionJNI.GetDeviceInfo();
        if (bArrGetDeviceInfo == null) {
            return null;
        }
        try {
            return zzbkr.zze(bArrGetDeviceInfo, zzbdv.zza());
        } catch (zzbew e) {
            throw new zzc(zzbkr.class.getName(), e);
        }
    }

    public static zzblq zzb() {
        byte[] bArrGetNNAPIInfo = AndroidSystemDetectionJNI.GetNNAPIInfo();
        if (bArrGetNNAPIInfo == null) {
            return null;
        }
        try {
            return zzblq.zze(bArrGetNNAPIInfo, zzbdv.zza());
        } catch (zzbew e) {
            throw new zzc(zzblq.class.getName(), e);
        }
    }
}
