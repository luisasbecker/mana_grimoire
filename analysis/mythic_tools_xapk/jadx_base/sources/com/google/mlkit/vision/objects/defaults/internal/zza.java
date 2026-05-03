package com.google.mlkit.vision.objects.defaults.internal;

import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzoz;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzpa;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzpb;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzpc;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzrm;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzvf;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzvi;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzvq;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator;
import com.google.mlkit.vision.objects.defaults.ObjectDetectorOptions;
import com.google.mlkit.vision.objects.internal.ObjectDetectorImpl;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes5.dex */
final class zza implements MultiFlavorDetectorCreator.DetectorCreator {
    private final zzb zza;
    private final zzvf zzb;
    private final ExecutorSelector zzc;

    zza(zzb zzbVar, ExecutorSelector executorSelector) {
        zzvf zzvfVarZzb = zzvq.zzb("object-detection");
        this.zza = zzbVar;
        this.zzb = zzvfVarZzb;
        this.zzc = executorSelector;
    }

    @Override // com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator.DetectorCreator
    public final /* bridge */ /* synthetic */ MultiFlavorDetectorCreator.MultiFlavorDetector create(MultiFlavorDetectorCreator.DetectorOptions detectorOptions) {
        ObjectDetectorOptions objectDetectorOptions = (ObjectDetectorOptions) detectorOptions;
        zzpc zzpcVar = new zzpc();
        zzpcVar.zze(zzoz.TYPE_THICK);
        zzrm zzrmVar = new zzrm();
        zzrmVar.zzb(zzi.zzb(objectDetectorOptions));
        zzrmVar.zzc(zzpa.NO_ERROR);
        zzpcVar.zzg(zzrmVar.zzd());
        this.zzb.zzd(zzvi.zzg(zzpcVar, 1), zzpb.ON_DEVICE_OBJECT_CREATE);
        return ObjectDetectorImpl.newInstance((MLTask) this.zza.get(objectDetectorOptions), this.zzc.getExecutorToUse(objectDetectorOptions.getExecutor()));
    }
}
