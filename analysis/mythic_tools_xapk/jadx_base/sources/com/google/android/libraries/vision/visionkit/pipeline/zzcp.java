package com.google.android.libraries.vision.visionkit.pipeline;

import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbef;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcp extends zzbef implements zzbft {
    private zzcp() {
        throw null;
    }

    /* synthetic */ zzcp(zzcn zzcnVar) {
        super(zzcu.zzb);
    }

    public final zzcp zza(String str) {
        zzy();
        zzcu.zzd((zzcu) this.zza, "MobileObjectLocalizerV3_1TfLiteClient");
        return this;
    }

    public final zzcp zzb(long j) {
        zzy();
        zzcu.zze((zzcu) this.zza, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        return this;
    }
}
