package com.google.mlkit.vision.vkp;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.Image;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzary;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzawp;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxz;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaya;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzayj;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhv;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbhx;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbky;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzblb;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzblh;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbli;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzcq;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzfx;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzfy;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzgp;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzha;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzhl;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzhm;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzho;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzhp;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzit;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zziv;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zziy;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzjn;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzjq;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzki;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkw;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzlc;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzld;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzt;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzun;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzuo;
import com.google.android.libraries.intelligence.acceleration.ProcessStateObserver;
import com.google.android.libraries.vision.visionkit.pipeline.PipelineException;
import com.google.android.libraries.vision.visionkit.pipeline.zzag;
import com.google.android.libraries.vision.visionkit.pipeline.zzam;
import com.google.android.libraries.vision.visionkit.pipeline.zzbg;
import com.google.android.libraries.vision.visionkit.pipeline.zzcf;
import com.google.android.libraries.vision.visionkit.pipeline.zzcg;
import com.google.android.libraries.vision.visionkit.pipeline.zzdf;
import com.google.android.libraries.vision.visionkit.pipeline.zzdr;
import com.google.android.libraries.vision.visionkit.pipeline.zzf;
import com.google.android.libraries.vision.visionkit.pipeline.zzfh;
import com.google.android.libraries.vision.visionkit.pipeline.zzfi;
import com.google.android.libraries.vision.visionkit.pipeline.zzg;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.internal.model.ModelUtils;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.common.sdkinternal.Constants;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes5.dex */
public class PipelineManager {
    private final Context zza;
    private final zzc zzb;
    private final boolean zzc;
    private final zzaxz zzg;
    private final zzawp zzh;
    private zzd zzi;
    private boolean zzj;
    private final List zzd = new ArrayList();
    private final List zze = new ArrayList();
    private final com.google.android.libraries.intelligence.acceleration.zzb zzf = new com.google.android.libraries.intelligence.acceleration.zzb(10);
    private boolean zzk = true;
    private long zzl = -1;

    static {
        System.loadLibrary("mlkitcommonpipeline");
    }

    PipelineManager(Context context, zzc zzcVar, boolean z, zzaxz zzaxzVar, zzawp zzawpVar) {
        this.zza = context;
        this.zzb = zzcVar;
        this.zzc = z;
        this.zzg = zzaxzVar;
        this.zzh = zzawpVar;
    }

    public static PipelineManager newInstanceForImageLabeling(Context context, VkpImageLabelerOptions vkpImageLabelerOptions) {
        return new PipelineManager(context, vkpImageLabelerOptions, false, zzayj.zzb("vision-internal-vkp"), (zzawp) Preconditions.checkNotNull(zzawp.zza(context)));
    }

    public static PipelineManager newInstanceForObjectDetection(Context context, VkpObjectDetectorOptions vkpObjectDetectorOptions) {
        return new PipelineManager(context, vkpObjectDetectorOptions, vkpObjectDetectorOptions.zzi(), zzayj.zzb("vision-internal-vkp"), (zzawp) Preconditions.checkNotNull(zzawp.zza(context)));
    }

    private final zzhp zzb(String str) throws IOException {
        AssetFileDescriptor assetFileDescriptorOpenFd = this.zza.getAssets().openFd(str);
        this.zze.add(assetFileDescriptorOpenFd);
        zzho zzhoVarZze = zzhp.zze();
        zzhoVarZze.zza(((AssetFileDescriptor) Preconditions.checkNotNull(assetFileDescriptorOpenFd)).getParcelFileDescriptor().getFd());
        zzhoVarZze.zzc(((AssetFileDescriptor) Preconditions.checkNotNull(assetFileDescriptorOpenFd)).getStartOffset());
        zzhoVarZze.zzb(((AssetFileDescriptor) Preconditions.checkNotNull(assetFileDescriptorOpenFd)).getLength());
        return (zzhp) zzhoVarZze.zzv();
    }

    private final zzhp zzc(Uri uri) throws IOException {
        List list = this.zze;
        AssetFileDescriptor assetFileDescriptorZza = zzt.zza(this.zza, uri, "r");
        list.add(assetFileDescriptorZza);
        if (assetFileDescriptorZza == null) {
            throw new IOException("Failed to open URI ".concat(String.valueOf(String.valueOf(uri))));
        }
        zzho zzhoVarZze = zzhp.zze();
        zzhoVarZze.zza(((AssetFileDescriptor) Preconditions.checkNotNull(assetFileDescriptorZza)).getParcelFileDescriptor().getFd());
        zzhoVarZze.zzc(((AssetFileDescriptor) Preconditions.checkNotNull(assetFileDescriptorZza)).getStartOffset());
        zzhoVarZze.zzb(((AssetFileDescriptor) Preconditions.checkNotNull(assetFileDescriptorZza)).getLength());
        return (zzhp) zzhoVarZze.zzv();
    }

    private final String[] zzd(LocalModel localModel, boolean z) throws IOException {
        String string;
        String string2 = z ? (String) Preconditions.checkNotNull(localModel.getAssetFilePath()) : (String) Preconditions.checkNotNull(localModel.getAbsoluteFilePath());
        if (localModel.isManifestFile()) {
            ModelUtils.AutoMLManifest manifestFile = ModelUtils.parseManifestFile(string2, z, this.zza);
            if (manifestFile == null) {
                throw new IOException("Failed to parse manifest file.");
            }
            Preconditions.checkState(Constants.AUTOML_IMAGE_LABELING_MODEL_TYPE.equals(manifestFile.getModelType()), "Model type should be: %s.", Constants.AUTOML_IMAGE_LABELING_MODEL_TYPE);
            string2 = new File(new File(string2).getParent(), manifestFile.getModelFile()).toString();
            string = new File(new File(string2).getParent(), manifestFile.getLabelsFile()).toString();
        } else {
            string = "";
        }
        return new String[]{string2, string};
    }

    public VkpResults process(InputImage inputImage, VisionImageMetadataParcel visionImageMetadataParcel) throws Throwable {
        VkpStatus vkpStatusZzb;
        zzki zzkiVarZzc;
        boolean z;
        Boolean bool;
        if (this.zzc) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.zzl;
            if (j <= 0 || jElapsedRealtime - j <= 300) {
                this.zzl = jElapsedRealtime;
                vkpStatusZzb = VkpStatus.zzb();
            } else {
                Log.w("PipelineManager", "Pipeline is reset.");
                stop();
                vkpStatusZzb = start();
            }
        } else {
            vkpStatusZzb = VkpStatus.zzb();
        }
        if (!vkpStatusZzb.isSuccess()) {
            return VkpResults.zza(vkpStatusZzb);
        }
        try {
            if (inputImage.getFormat() == -1) {
                Bitmap bitmapCopy = (Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal());
                if (bitmapCopy.getConfig() != Bitmap.Config.ARGB_8888) {
                    Log.d("PipelineManager", "Input bitmap is not ARGB_8888 config. Converting it to ARGB_8888 from " + String.valueOf(bitmapCopy.getConfig()));
                    bitmapCopy = bitmapCopy.copy(Bitmap.Config.ARGB_8888, bitmapCopy.isMutable());
                }
                zzkiVarZzc = ((zzd) Preconditions.checkNotNull(this.zzi)).zzj(SystemClock.elapsedRealtime() * 1000, bitmapCopy, zze.zza(visionImageMetadataParcel.rotation));
            } else if (inputImage.getFormat() == 35) {
                Image.Plane[] planeArr = (Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes());
                zzkiVarZzc = ((zzd) Preconditions.checkNotNull(this.zzi)).zzk(SystemClock.elapsedRealtime() * 1000, ((Image.Plane) Preconditions.checkNotNull(planeArr[0])).getBuffer(), ((Image.Plane) Preconditions.checkNotNull(planeArr[1])).getBuffer(), ((Image.Plane) Preconditions.checkNotNull(planeArr[2])).getBuffer(), inputImage.getWidth(), inputImage.getHeight(), ((Image.Plane) Preconditions.checkNotNull(planeArr[0])).getRowStride(), ((Image.Plane) Preconditions.checkNotNull(planeArr[1])).getRowStride(), ((Image.Plane) Preconditions.checkNotNull(planeArr[1])).getPixelStride(), zze.zza(visionImageMetadataParcel.rotation));
            } else {
                ByteBuffer byteBufferConvertToNv21Buffer = ImageConvertUtils.getInstance().convertToNv21Buffer(inputImage, true);
                zzd zzdVar = (zzd) Preconditions.checkNotNull(this.zzi);
                zzbg zzbgVar = new zzbg();
                zzbgVar.zza(byteBufferConvertToNv21Buffer.array());
                zzbgVar.zzf(zze.zza(visionImageMetadataParcel.rotation));
                zzbgVar.zzb(new zzcq(visionImageMetadataParcel.width, visionImageMetadataParcel.height));
                zzbgVar.zzc(visionImageMetadataParcel.timestampMillis * 1000);
                zzbgVar.zze(2);
                zzkiVarZzc = zzdVar.zzc(zzbgVar.zzd());
            }
            if (!zzkiVarZzc.zzc()) {
                return VkpResults.zza(new AutoValue_VkpStatus(false, null, zzld.zzj()));
            }
            com.google.android.libraries.vision.visionkit.pipeline.zzc zzcVar = (com.google.android.libraries.vision.visionkit.pipeline.zzc) ((com.google.android.libraries.vision.visionkit.pipeline.zzd) ((zzd) Preconditions.checkNotNull(this.zzi)).zzb().zzb(com.google.android.libraries.vision.visionkit.pipeline.zzd.zzd())).zzC();
            zzcVar.zza(this.zzd);
            com.google.android.libraries.vision.visionkit.pipeline.zzd zzdVar2 = (com.google.android.libraries.vision.visionkit.pipeline.zzd) zzcVar.zzv();
            this.zzd.clear();
            List listZza = this.zzf.zza(zzdVar2.zzf());
            if (!listZza.isEmpty()) {
                zzaxz zzaxzVar = this.zzg;
                zzun zzunVarZza = zzuo.zza();
                zzunVarZza.zza(listZza);
                zzaxzVar.zzc(zzaya.zze(zzunVarZza), zzary.ACCELERATION_ANALYTICS);
            }
            zzdf zzdfVar = (zzdf) zzkiVarZzc.zza();
            Matrix uprightRotationMatrix = visionImageMetadataParcel.getUprightRotationMatrix();
            boolean z2 = this.zzk;
            if (zzdVar2.zza() == 0) {
                bool = null;
            } else {
                Iterator it = zzdVar2.zzf().iterator();
                boolean z3 = false;
                while (true) {
                    if (it.hasNext()) {
                        zzblb zzblbVarZze = ((zzbli) it.next()).zze();
                        zzbky zzbkyVarZze = zzblbVarZze.zze();
                        if (zzblbVarZze.zzh() == 4) {
                            if (zzblbVarZze.zzi() == 2 && zzblbVarZze.zzc().zzf().zzf() == 2 && zzbkyVarZze.zzi() && !zzbkyVarZze.zzc().zzf() && !zzbkyVarZze.zzc().zzg() && !zzbkyVarZze.zzh() && !zzbkyVarZze.zzg()) {
                                break;
                            }
                            z3 = true;
                        }
                    } else {
                        z = z3 ? false : true;
                    }
                }
                bool = z;
            }
            zzkw zzkwVar = new zzkw();
            zzjq zzjqVarZzf = zzdfVar.zzf();
            for (int i = 0; i < zzjqVarZzf.zza(); i++) {
                zzjn zzjnVarZzc = zzjqVarZzf.zzc(i);
                zzgp zzgpVarZzd = zzjnVarZzc.zzd();
                RectF rectF = new RectF(zzgpVarZzd.zzc(), zzgpVarZzd.zzd(), zzgpVarZzd.zzc() + zzgpVarZzd.zze(), zzgpVarZzd.zzd() + zzgpVarZzd.zza());
                if (uprightRotationMatrix != null) {
                    uprightRotationMatrix.mapRect(rectF);
                }
                Rect rect = new Rect();
                rectF.round(rect);
                Integer numValueOf = zzjnVarZzc.zzg() ? Integer.valueOf((int) zzjnVarZzc.zzc()) : null;
                zzkw zzkwVar2 = new zzkw();
                for (int i2 = 0; i2 < zzjnVarZzc.zza(); i2++) {
                    zzkwVar2.zzb(VkpImageLabel.zza(zzjnVarZzc.zze(i2)));
                }
                zzkwVar.zzb(new AutoValue_VkpDetectedObject(rect, numValueOf, zzkwVar2.zzc()));
            }
            zzkw zzkwVar3 = new zzkw();
            Iterator it2 = zzdfVar.zze().zzd().iterator();
            while (it2.hasNext()) {
                Iterator it3 = ((zzit) it2.next()).zzc().iterator();
                while (it3.hasNext()) {
                    zzkwVar3.zzb(VkpImageLabel.zza((zzha) it3.next()));
                }
            }
            AutoValue_VkpResults autoValue_VkpResults = new AutoValue_VkpResults(VkpStatus.zzb(), zzkwVar.zzc(), zzkwVar3.zzc(), z2, bool);
            this.zzk = false;
            return autoValue_VkpResults;
        } catch (MlKitException e) {
            return VkpResults.zza(VkpStatus.zza(e));
        }
    }

    public VkpStatus start() {
        zziy zziyVarZzc;
        zzbhx zzbhxVarZzc;
        zzcg zzcgVarZzb;
        if (this.zzj) {
            return VkpStatus.zzb();
        }
        if (this.zzi == null) {
            try {
                zzc zzcVar = this.zzb;
                if (zzcVar instanceof VkpImageLabelerOptions) {
                    VkpImageLabelerOptions vkpImageLabelerOptions = (VkpImageLabelerOptions) zzcVar;
                    float fZza = vkpImageLabelerOptions.zza();
                    int iZzb = vkpImageLabelerOptions.zzb();
                    LocalModel localModelZzc = vkpImageLabelerOptions.zzc();
                    if (localModelZzc == null) {
                        zzcgVarZzb = zzfx.zzc(this.zza, fZza, iZzb);
                    } else if (localModelZzc.getAssetFilePath() != null) {
                        String[] strArrZzd = zzd(localModelZzc, true);
                        zzcgVarZzb = zzfx.zzb(zzb(strArrZzd[0]), fZza, iZzb, strArrZzd[1], this.zza);
                    } else if (localModelZzc.getAbsoluteFilePath() != null) {
                        String[] strArrZzd2 = zzd(localModelZzc, false);
                        zzcgVarZzb = zzfx.zza(strArrZzd2[0], fZza, iZzb, strArrZzd2[1]);
                    } else {
                        zzcgVarZzb = zzfx.zzb(zzc((Uri) Preconditions.checkNotNull(localModelZzc.getUri())), fZza, iZzb, "", this.zza);
                    }
                } else {
                    VkpObjectDetectorOptions vkpObjectDetectorOptions = (VkpObjectDetectorOptions) zzcVar;
                    float fZza2 = vkpObjectDetectorOptions.zza();
                    int iZzb2 = vkpObjectDetectorOptions.zzb();
                    LocalModel localModelZzc2 = vkpObjectDetectorOptions.zzc();
                    if (!vkpObjectDetectorOptions.zzg()) {
                        zziyVarZzc = zzfy.zza;
                    } else if (localModelZzc2 == null) {
                        zziy zziyVar = zzfy.zza;
                        zziyVarZzc = zzfy.zzd(zzb("mlkit_odt_default_classifier/labeler_with_validation.tflite"), zzbhv.zze());
                    } else if (localModelZzc2.getAssetFilePath() != null) {
                        String[] strArrZzd3 = zzd(localModelZzc2, true);
                        zziyVarZzc = zzfy.zzc(this.zza, zzb(strArrZzd3[0]), strArrZzd3[1], fZza2, iZzb2);
                    } else if (localModelZzc2.getAbsoluteFilePath() != null) {
                        String[] strArrZzd4 = zzd(localModelZzc2, false);
                        String str = strArrZzd4[0];
                        String str2 = strArrZzd4[1];
                        zziy zziyVar2 = zzfy.zza;
                        zziv zzivVarZza = zziy.zza();
                        zzhl zzhlVarZza = zzhm.zza();
                        zzhlVarZza.zzc(str);
                        zzivVarZza.zze(zzhlVarZza);
                        zzivVarZza.zzd(iZzb2);
                        if (fZza2 >= 0.0f) {
                            zzivVarZza.zzg(fZza2);
                        }
                        if (!str2.isEmpty()) {
                            zzhl zzhlVarZza2 = zzhm.zza();
                            zzhlVarZza2.zzc(str2);
                            zzivVarZza.zzh(zzhlVarZza2);
                        }
                        zziyVarZzc = (zziy) zzivVarZza.zzv();
                    } else {
                        zziyVarZzc = zzfy.zzc(this.zza, zzc((Uri) Preconditions.checkNotNull(localModelZzc2.getUri())), "", fZza2, iZzb2);
                    }
                    zziy zziyVar3 = zziyVarZzc;
                    int i = true != vkpObjectDetectorOptions.zzf() ? 3 : 2;
                    zzhp zzhpVarZzb = zzb("mlkit_odt_localizer/localizer_with_validation.tflite");
                    if (vkpObjectDetectorOptions.zzf()) {
                        zzbhxVarZzc = this.zzh.zzc(vkpObjectDetectorOptions.zzd(), vkpObjectDetectorOptions.zze(), "com.google.perception", 2);
                        Log.i("PipelineManager", "Fetching acceleration allowlist");
                        this.zzh.zzb(vkpObjectDetectorOptions.zzd(), vkpObjectDetectorOptions.zze(), "com.google.perception", 2);
                    } else {
                        zzbhxVarZzc = null;
                    }
                    zzbhx zzbhxVar = zzbhxVarZzc;
                    boolean zZzi = vkpObjectDetectorOptions.zzi();
                    Context context = this.zza;
                    if (zZzi) {
                        zzdr zzdrVarZzb = zzfy.zzb(context, vkpObjectDetectorOptions.zzh(), zzhpVarZzb, zziyVar3, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS, zzbhxVar);
                        zzdrVarZzb.zzj(i);
                        zzcf zzcfVarZzc = zzcg.zzc();
                        zzcfVarZzc.zzc(zzdrVarZzb);
                        zzfh zzfhVarZza = zzfi.zza();
                        zzfhVarZza.zza(true);
                        zzfhVarZza.zzb(1);
                        zzcfVarZzc.zzd(zzfhVarZza);
                        zzcgVarZzb = (zzcg) zzcfVarZzc.zzv();
                    } else {
                        zzdr zzdrVarZza = zzfy.zza(context, vkpObjectDetectorOptions.zzh(), zzhpVarZzb, zziyVar3, zzbhv.zze());
                        zzdrVarZza.zzj(i);
                        if (zzbhxVar != null) {
                            zzdrVarZza.zzc(zzbhxVar);
                        }
                        zzcf zzcfVarZzc2 = zzcg.zzc();
                        zzcfVarZzc2.zzc(zzdrVarZza);
                        zzfh zzfhVarZza2 = zzfi.zza();
                        zzfhVarZza2.zzb(2);
                        zzcfVarZzc2.zzd(zzfhVarZza2);
                        zzcgVarZzb = (zzcg) zzcfVarZzc2.zzv();
                    }
                }
                zzcf zzcfVar = (zzcf) zzcgVarZzb.zzC();
                zzf zzfVarZza = zzg.zza();
                zzfVarZza.zza(true);
                File file = new File(this.zza.getFilesDir(), "com.google.mlkit.acceleration");
                if (!file.exists() && !file.mkdir()) {
                    List list = this.zzd;
                    zzblh zzblhVarZzf = zzbli.zzf();
                    zzblhVarZzf.zza(3);
                    list.add((zzbli) zzblhVarZzf.zzv());
                    Log.e("PipelineManager", "Failed to create acceleration storage dir");
                }
                zzfVarZza.zzb(file.getAbsolutePath());
                zzcfVar.zza(zzfVarZza);
                this.zzi = new zzd((zzcg) zzcfVar.zzv());
            } catch (IOException e) {
                zza();
                return VkpStatus.zza(new MlKitException("Failed to initialize detector. ", 5, e));
            }
        }
        try {
            try {
                this.zzi.zzh();
                zza();
                ProcessStateObserver.zza().zzb();
                this.zzj = true;
                return VkpStatus.zzb();
            } catch (PipelineException e2) {
                MlKitException mlKitException = new MlKitException("Failed to initialize detector. " + ((String) e2.getRootCauseMessage().zzb("")), 3);
                zzlc zzlcVar = new zzlc();
                zzlcVar.zzb(new AutoValue_VkpStatus_VkpError(1, e2.getStatusCode().ordinal()));
                Iterator<zzag> it = e2.getComponentStatuses().iterator();
                while (it.hasNext()) {
                    for (zzam zzamVar : it.next().zzc()) {
                        zzlcVar.zzb(new AutoValue_VkpStatus_VkpError(true != "tflite::support::TfLiteSupportStatus".equals(zzamVar.zzd()) ? 0 : 3, zzamVar.zza()));
                    }
                }
                AutoValue_VkpStatus autoValue_VkpStatus = new AutoValue_VkpStatus(false, mlKitException, zzlcVar.zzc());
                zza();
                return autoValue_VkpStatus;
            }
        } catch (Throwable th) {
            zza();
            throw th;
        }
    }

    public void stop() {
        zzd zzdVar = this.zzi;
        if (zzdVar != null) {
            if (this.zzj) {
                zzdVar.zzi();
            }
            this.zzi.zzd();
            this.zzi = null;
        }
        this.zzj = false;
        this.zzk = true;
        this.zzl = -1L;
        zza();
    }

    final void zza() {
        for (AssetFileDescriptor assetFileDescriptor : this.zze) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException e) {
                    Log.e("PipelineManager", "Failed to close asset model file.", e);
                }
            }
        }
        this.zze.clear();
    }
}
