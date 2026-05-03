package com.google.mlkit.vision.objects.defaults.internal;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.objects.defaults.ObjectDetectorOptions;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzb extends LazyInstanceMap {
    private final MlKitContext zza;

    zzb(MlKitContext mlKitContext) {
        this.zza = mlKitContext;
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        return new zze(this.zza, (ObjectDetectorOptions) obj);
    }
}
