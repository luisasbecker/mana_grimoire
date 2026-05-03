package com.google.mlkit.vision.objects.defaults.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzan;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzaq;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzek;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzem;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzog;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzoh;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzon;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzoz;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzpa;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzpb;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzpc;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzpl;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzpm;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzrs;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzrt;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzrw;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzuv;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzvf;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzvh;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzvi;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzvq;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzwa;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;
import com.google.mlkit.vision.objects.DetectedObject;
import com.google.mlkit.vision.objects.defaults.ObjectDetectorOptions;
import com.google.mlkit.vision.objects.defaults.PredefinedCategory;
import com.google.mlkit.vision.vkp.PipelineManager;
import com.google.mlkit.vision.vkp.VkpDetectedObject;
import com.google.mlkit.vision.vkp.VkpObjectDetectorOptions;
import com.google.mlkit.vision.vkp.VkpResults;
import com.google.mlkit.vision.vkp.VkpStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes5.dex */
public final class zze extends MLTask {
    private static final ImageUtils zzb = ImageUtils.getInstance();
    final zzrs zza;
    private final ObjectDetectorOptions zzc;
    private final MlKitContext zzd;
    private final zzvf zze;
    private final zzvh zzf;
    private final zzwa zzg;
    private PipelineManager zzh;
    private boolean zzi;

    zze(MlKitContext mlKitContext, ObjectDetectorOptions objectDetectorOptions) {
        zzvf zzvfVarZzb = zzvq.zzb("object-detection");
        Preconditions.checkNotNull(mlKitContext, "Context can not be null");
        Preconditions.checkNotNull(objectDetectorOptions, "ObjectDetectorOptions can not be null");
        this.zze = zzvfVarZzb;
        this.zzf = zzvh.zza(mlKitContext.getApplicationContext());
        this.zzc = objectDetectorOptions;
        this.zzd = mlKitContext;
        this.zza = zzi.zzb(objectDetectorOptions);
        this.zzg = zzwa.zzf(mlKitContext.getApplicationContext());
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.google.mlkit.vision.objects.defaults.internal.zzd] */
    private final void zze(zzpa zzpaVar, VkpStatus vkpStatus, InputImage inputImage, List list, boolean z, Boolean bool, long j) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zze.zzh(new zzc(this, list, jElapsedRealtime, zzpaVar, vkpStatus, z, bool, inputImage), zzpb.ON_DEVICE_OBJECT_INFERENCE);
        zzek zzekVar = new zzek();
        zzekVar.zza(this.zza);
        zzekVar.zzb(zzpaVar);
        zzekVar.zzd(Boolean.valueOf(z));
        zzekVar.zzc(Boolean.valueOf(!list.isEmpty()));
        final zzem zzemVarZze = zzekVar.zze();
        final ?? r2 = new Object() { // from class: com.google.mlkit.vision.objects.defaults.internal.zzd
        };
        final zzpb zzpbVar = zzpb.AGGREGATED_ON_DEVICE_OBJECT_INFERENCE;
        Executor executorWorkerThreadExecutor = MLTaskExecutor.workerThreadExecutor();
        final zzvf zzvfVar = this.zze;
        executorWorkerThreadExecutor.execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzve
            @Override // java.lang.Runnable
            public final void run() {
                zzvfVar.zzg(zzpbVar, zzemVarZze, jElapsedRealtime, r2);
            }
        });
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.zzf.zzc(24310, zzpaVar.zza(), jCurrentTimeMillis - jElapsedRealtime, jCurrentTimeMillis);
    }

    private final void zzf(zzpa zzpaVar, VkpStatus vkpStatus, long j) {
        zzpc zzpcVar = new zzpc();
        zzpcVar.zze(zzoz.TYPE_THICK);
        zzrw zzrwVar = new zzrw();
        zzrwVar.zzd(this.zza);
        zzrwVar.zzg(Long.valueOf(j));
        zzrwVar.zze(zzpaVar);
        zzrwVar.zzf(zzi.zza(vkpStatus));
        zzpcVar.zzi(zzrwVar.zzh());
        this.zze.zzd(zzvi.zzf(zzpcVar), zzpb.ON_DEVICE_OBJECT_LOAD);
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void load() throws MlKitException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.zzg.zzk("object-detection:".concat(String.valueOf(LibraryVersion.getInstance().getVersion("object-detection"))));
        try {
            Tasks.await(this.zzg.zzb());
        } catch (InterruptedException | ExecutionException e) {
            Log.e("BundledODTTask", "remoteConfig.loadAndActivate failed: ".concat(String.valueOf(e.getLocalizedMessage())));
        }
        this.zzi = Boolean.parseBoolean(this.zzg.zzh("vision_object_detection_enable_acceleration"));
        if (Log.isLoggable("BundledODTTask", 4)) {
            Log.i("BundledODTTask", "isRemoteConfigAccelerationEnabled = " + this.zzi);
        }
        this.zzg.zza(zzwa.zza);
        if (this.zzh == null) {
            MlKitContext mlKitContext = this.zzd;
            ObjectDetectorOptions objectDetectorOptions = this.zzc;
            Context applicationContext = mlKitContext.getApplicationContext();
            int detectorMode = objectDetectorOptions.getDetectorMode();
            boolean zIsMultipleObjectsEnabled = objectDetectorOptions.isMultipleObjectsEnabled();
            boolean zIsClassificationEnabled = objectDetectorOptions.isClassificationEnabled();
            boolean z = this.zzi;
            boolean z2 = true;
            if (detectorMode != 1) {
                z2 = false;
            }
            this.zzh = PipelineManager.newInstanceForObjectDetection(applicationContext, VkpObjectDetectorOptions.from(z2, zIsMultipleObjectsEnabled, zIsClassificationEnabled, z, 0.0f, 1, null));
        }
        VkpStatus vkpStatusStart = this.zzh.start();
        if (vkpStatusStart.isSuccess()) {
            zzf(zzpa.NO_ERROR, vkpStatusStart, SystemClock.elapsedRealtime() - jElapsedRealtime);
        } else {
            zzf(zzpa.NO_VALID_MODEL, vkpStatusStart, SystemClock.elapsedRealtime() - jElapsedRealtime);
            vkpStatusStart.throwsMlKitExceptionIfPresent();
        }
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void release() {
        PipelineManager pipelineManager = this.zzh;
        if (pipelineManager != null) {
            pipelineManager.stop();
            this.zzh = null;
        }
        zzvf zzvfVar = this.zze;
        zzpc zzpcVar = new zzpc();
        zzpcVar.zze(zzoz.TYPE_THICK);
        zzvfVar.zzd(zzvi.zzf(zzpcVar), zzpb.ON_DEVICE_OBJECT_CLOSE);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final /* synthetic */ zzuv zzc(List list, long j, zzpa zzpaVar, VkpStatus vkpStatus, boolean z, Boolean bool, InputImage inputImage) {
        zzpm zzpmVar;
        zzan zzanVar = new zzan();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DetectedObject detectedObject = (DetectedObject) it.next();
            zzpl zzplVar = new zzpl();
            if (!detectedObject.getLabels().isEmpty()) {
                DetectedObject.Label label = detectedObject.getLabels().get(0);
                String text = label.getText();
                switch (text.hashCode()) {
                    case -958563771:
                        if (!text.equals(PredefinedCategory.FASHION_GOOD)) {
                            Log.e("ObjectsLoggingUtils", "Unexpected category: ".concat(String.valueOf(text)));
                            zzpmVar = zzpm.CATEGORY_UNKNOWN;
                        } else {
                            zzpmVar = zzpm.CATEGORY_FASHION_GOOD;
                        }
                        break;
                    case -231354562:
                        if (text.equals(PredefinedCategory.HOME_GOOD)) {
                            zzpmVar = zzpm.CATEGORY_HOME_GOOD;
                            break;
                        }
                        break;
                    case 2195582:
                        if (text.equals(PredefinedCategory.FOOD)) {
                            zzpmVar = zzpm.CATEGORY_FOOD;
                            break;
                        }
                        break;
                    case 77195495:
                        if (text.equals(PredefinedCategory.PLACE)) {
                            zzpmVar = zzpm.CATEGORY_PLACE;
                            break;
                        }
                        break;
                    case 77195851:
                        if (text.equals(PredefinedCategory.PLANT)) {
                            zzpmVar = zzpm.CATEGORY_PLANT;
                            break;
                        }
                        break;
                }
                zzplVar.zza(zzpmVar);
                zzplVar.zzb(Float.valueOf(label.getConfidence()));
            }
            Integer trackingId = detectedObject.getTrackingId();
            if (trackingId != null) {
                zzplVar.zzc(trackingId);
            }
            zzanVar.zzb(zzplVar.zze());
        }
        zzon zzonVar = new zzon();
        zzonVar.zzd(Long.valueOf(j));
        zzonVar.zze(zzpaVar);
        zzonVar.zzh(zzi.zza(vkpStatus));
        zzonVar.zzg(Boolean.valueOf(z));
        zzonVar.zzb(true);
        zzonVar.zzc(true);
        zzonVar.zzi(Boolean.valueOf(this.zzi));
        if (bool != null) {
            zzonVar.zzf(bool);
        }
        zzpc zzpcVar = new zzpc();
        zzpcVar.zze(zzoz.TYPE_THICK);
        zzrt zzrtVar = new zzrt();
        zzrtVar.zzg(zzonVar.zzj());
        ImageUtils imageUtils = zzb;
        int mobileVisionImageFormat = imageUtils.getMobileVisionImageFormat(inputImage);
        int mobileVisionImageSize = imageUtils.getMobileVisionImageSize(inputImage);
        zzog zzogVar = new zzog();
        zzogVar.zza(mobileVisionImageFormat != -1 ? mobileVisionImageFormat != 35 ? mobileVisionImageFormat != 842094169 ? mobileVisionImageFormat != 16 ? mobileVisionImageFormat != 17 ? zzoh.UNKNOWN_FORMAT : zzoh.NV21 : zzoh.NV16 : zzoh.YV12 : zzoh.YUV_420_888 : zzoh.BITMAP);
        zzogVar.zzb(Integer.valueOf(mobileVisionImageSize));
        zzrtVar.zzf(zzogVar.zzd());
        zzrtVar.zze(this.zza);
        zzrtVar.zzh(zzanVar.zzc());
        zzpcVar.zzh(zzrtVar.zzi());
        return zzvi.zzf(zzpcVar);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0163  */
    @Override // com.google.mlkit.common.sdkinternal.MLTask
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized List run(InputImage inputImage) throws MlKitException {
        ArrayList arrayList;
        String str;
        Preconditions.checkNotNull(inputImage, "Mobile vision input can not be null");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzh == null) {
            Log.e("BundledODTTask", "Object detector is not initialized.");
            return new ArrayList();
        }
        VkpResults vkpResultsProcess = ((PipelineManager) Preconditions.checkNotNull(this.zzh)).process(inputImage.getFormat() == 35 ? InputImage.fromByteBuffer(ImageConvertUtils.getInstance().convertToNv21Buffer(inputImage, true), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees(), 17) : inputImage, new VisionImageMetadataParcel(inputImage.getWidth(), inputImage.getHeight(), 0, SystemClock.elapsedRealtime(), CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees())));
        VkpStatus status = vkpResultsProcess.getStatus();
        if (!status.isSuccess()) {
            zze(zzpa.UNKNOWN_ERROR, status, inputImage, zzaq.zzh(), vkpResultsProcess.isFromColdCall(), vkpResultsProcess.isAccelerated(), jElapsedRealtime);
            status.throwsMlKitExceptionIfPresent();
            return new ArrayList();
        }
        List<VkpDetectedObject> detectedObjects = vkpResultsProcess.getDetectedObjects();
        Matrix coordinatesMatrix = inputImage.getCoordinatesMatrix();
        if (detectedObjects.isEmpty()) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList();
            for (VkpDetectedObject vkpDetectedObject : detectedObjects) {
                ArrayList arrayList2 = new ArrayList();
                if (!vkpDetectedObject.getLabels().isEmpty()) {
                    int i = 0;
                    String className = vkpDetectedObject.getLabels().get(0).getClassName();
                    switch (className.hashCode()) {
                        case -584479206:
                            str = className.equals("/g/11g0srqwrg") ? PredefinedCategory.HOME_GOOD : null;
                            break;
                        case -584453279:
                            if (className.equals("/g/11g0srrsqr")) {
                                str = PredefinedCategory.FASHION_GOOD;
                                break;
                            }
                            break;
                        case -347133297:
                            if (className.equals("/m/02wbm")) {
                                str = PredefinedCategory.FOOD;
                                break;
                            }
                            break;
                        case -347049250:
                            if (className.equals("/m/05s2s")) {
                                str = PredefinedCategory.PLANT;
                                break;
                            }
                            break;
                        case 286374479:
                            if (className.equals("/g/11fhycwtxg")) {
                                str = PredefinedCategory.PLACE;
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                    if (str != null) {
                        float score = vkpDetectedObject.getLabels().get(0).getScore();
                        switch (str.hashCode()) {
                            case -958563771:
                                if (!str.equals(PredefinedCategory.FASHION_GOOD)) {
                                    i = -1;
                                }
                                break;
                            case -231354562:
                                if (str.equals(PredefinedCategory.HOME_GOOD)) {
                                    i = 1;
                                    break;
                                }
                                break;
                            case 2195582:
                                if (str.equals(PredefinedCategory.FOOD)) {
                                    i = 2;
                                    break;
                                }
                                break;
                            case 77195495:
                                if (str.equals(PredefinedCategory.PLACE)) {
                                    i = 3;
                                    break;
                                }
                                break;
                            case 77195851:
                                if (str.equals(PredefinedCategory.PLANT)) {
                                    i = 4;
                                    break;
                                }
                                break;
                            default:
                                i = -1;
                                break;
                        }
                        arrayList2.add(new DetectedObject.Label(str, score, i));
                    }
                }
                Rect boundingBox = vkpDetectedObject.getBoundingBox();
                if (coordinatesMatrix != null) {
                    CommonConvertUtils.transformRect(boundingBox, coordinatesMatrix);
                }
                arrayList.add(new DetectedObject(boundingBox, vkpDetectedObject.getTrackingId(), arrayList2));
            }
        }
        zze(zzpa.NO_ERROR, status, inputImage, arrayList, vkpResultsProcess.isFromColdCall(), vkpResultsProcess.isAccelerated(), jElapsedRealtime);
        return arrayList;
    }
}
