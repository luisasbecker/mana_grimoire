package com.google.mlkit.vision.face.internal;

import android.content.Context;
import android.media.Image;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_face.zzks;
import com.google.android.gms.internal.mlkit_vision_face.zzoc;
import com.google.android.gms.internal.mlkit_vision_face.zzp;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.1.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzm implements zzb {
    private boolean zza;
    private final Context zzb;
    private final FaceDetectorOptions zzc;
    private final int zzd;
    private final zzoc zze;
    private com.google.android.gms.internal.mlkit_vision_face.zzj zzf;
    private com.google.android.gms.internal.mlkit_vision_face.zzj zzg;

    zzm(Context context, FaceDetectorOptions faceDetectorOptions, zzoc zzocVar) {
        this.zzb = context;
        this.zzc = faceDetectorOptions;
        this.zzd = GoogleApiAvailabilityLight.getInstance().getApkVersion(context);
        this.zze = zzocVar;
    }

    static int zzc(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Invalid classification type: " + i);
    }

    static int zze(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Invalid landmark type: " + i);
    }

    private static int zzf(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Invalid mode type: " + i);
    }

    private final List zzg(com.google.android.gms.internal.mlkit_vision_face.zzj zzjVar, InputImage inputImage) throws MlKitException {
        com.google.android.gms.internal.mlkit_vision_face.zzf[] zzfVarArrZze;
        try {
            zzp zzpVar = new zzp(inputImage.getWidth(), inputImage.getHeight(), 0, SystemClock.elapsedRealtime(), CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees()));
            if (inputImage.getFormat() != 35 || this.zzd < 201500000) {
                zzfVarArrZze = zzjVar.zze(ObjectWrapper.wrap(ImageConvertUtils.getInstance().convertToNv21Buffer(inputImage, false)), zzpVar);
            } else {
                Image.Plane[] planeArr = (Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes());
                zzfVarArrZze = zzjVar.zzf(ObjectWrapper.wrap(planeArr[0].getBuffer()), ObjectWrapper.wrap(planeArr[1].getBuffer()), ObjectWrapper.wrap(planeArr[2].getBuffer()), planeArr[0].getPixelStride(), planeArr[1].getPixelStride(), planeArr[2].getPixelStride(), planeArr[0].getRowStride(), planeArr[1].getRowStride(), planeArr[2].getRowStride(), zzpVar);
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.mlkit_vision_face.zzf zzfVar : zzfVarArrZze) {
                arrayList.add(new Face(zzfVar, inputImage.getCoordinatesMatrix()));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new MlKitException("Failed to detect with legacy face detector", 13, e);
        }
    }

    @Override // com.google.mlkit.vision.face.internal.zzb
    public final Pair zza(InputImage inputImage) throws MlKitException {
        List listZzg;
        if (this.zzf == null && this.zzg == null) {
            zzd();
        }
        com.google.android.gms.internal.mlkit_vision_face.zzj zzjVar = this.zzf;
        if (zzjVar == null && this.zzg == null) {
            throw new MlKitException("Waiting for the face detection module to be downloaded. Please wait.", 14);
        }
        List listZzg2 = null;
        if (zzjVar != null) {
            listZzg = zzg(zzjVar, inputImage);
            if (!this.zzc.zzg()) {
                zzh.zzf(listZzg);
            }
        } else {
            listZzg = null;
        }
        com.google.android.gms.internal.mlkit_vision_face.zzj zzjVar2 = this.zzg;
        if (zzjVar2 != null) {
            listZzg2 = zzg(zzjVar2, inputImage);
            zzh.zzf(listZzg2);
        }
        return new Pair(listZzg, listZzg2);
    }

    @Override // com.google.mlkit.vision.face.internal.zzb
    public final void zzb() {
        com.google.android.gms.internal.mlkit_vision_face.zzj zzjVar = this.zzf;
        if (zzjVar != null) {
            try {
                zzjVar.zzd();
            } catch (RemoteException e) {
                Log.e("LegacyFaceDelegate", "Failed to release legacy face detector.", e);
            }
            this.zzf = null;
        }
        com.google.android.gms.internal.mlkit_vision_face.zzj zzjVar2 = this.zzg;
        if (zzjVar2 != null) {
            try {
                zzjVar2.zzd();
            } catch (RemoteException e2) {
                Log.e("LegacyFaceDelegate", "Failed to release legacy face detector.", e2);
            }
            this.zzg = null;
        }
    }

    @Override // com.google.mlkit.vision.face.internal.zzb
    public final boolean zzd() throws MlKitException {
        if (this.zzf != null || this.zzg != null) {
            return false;
        }
        try {
            com.google.android.gms.internal.mlkit_vision_face.zzm zzmVarZza = com.google.android.gms.internal.mlkit_vision_face.zzl.zza(DynamiteModule.load(this.zzb, DynamiteModule.PREFER_REMOTE, OptionalModuleUtils.DEPRECATED_DYNAMITE_MODULE_ID).instantiate("com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator"));
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(this.zzb);
            if (this.zzc.zzc() == 2) {
                if (this.zzg == null) {
                    this.zzg = zzmVarZza.zzd(iObjectWrapperWrap, new com.google.android.gms.internal.mlkit_vision_face.zzh(2, 2, 0, true, false, this.zzc.zza()));
                }
                if ((this.zzc.zzd() == 2 || this.zzc.zzb() == 2 || this.zzc.zze() == 2) && this.zzf == null) {
                    this.zzf = zzmVarZza.zzd(iObjectWrapperWrap, new com.google.android.gms.internal.mlkit_vision_face.zzh(zzf(this.zzc.zze()), zze(this.zzc.zzd()), zzc(this.zzc.zzb()), false, this.zzc.zzg(), this.zzc.zza()));
                }
            } else if (this.zzf == null) {
                this.zzf = zzmVarZza.zzd(iObjectWrapperWrap, new com.google.android.gms.internal.mlkit_vision_face.zzh(zzf(this.zzc.zze()), zze(this.zzc.zzd()), zzc(this.zzc.zzb()), false, this.zzc.zzg(), this.zzc.zza()));
            }
            if (this.zzf == null && this.zzg == null && !this.zza) {
                Log.d("LegacyFaceDelegate", "Request face optional module download.");
                OptionalModuleUtils.requestDownload(this.zzb, OptionalModuleUtils.BARCODE);
                this.zza = true;
            }
            zzj.zzc(this.zze, false, zzks.NO_ERROR);
            return false;
        } catch (RemoteException e) {
            throw new MlKitException("Failed to create legacy face detector.", 13, e);
        } catch (DynamiteModule.LoadingException e2) {
            throw new MlKitException("Failed to load deprecated vision dynamite module.", 13, e2);
        }
    }
}
