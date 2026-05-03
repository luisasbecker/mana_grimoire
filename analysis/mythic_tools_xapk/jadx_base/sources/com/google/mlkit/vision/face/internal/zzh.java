package com.google.mlkit.vision.face.internal;

import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_face.zzdk;
import com.google.android.gms.internal.mlkit_vision_face.zzdl;
import com.google.android.gms.internal.mlkit_vision_face.zzdn;
import com.google.android.gms.internal.mlkit_vision_face.zzjv;
import com.google.android.gms.internal.mlkit_vision_face.zzke;
import com.google.android.gms.internal.mlkit_vision_face.zzkf;
import com.google.android.gms.internal.mlkit_vision_face.zzkj;
import com.google.android.gms.internal.mlkit_vision_face.zzkr;
import com.google.android.gms.internal.mlkit_vision_face.zzks;
import com.google.android.gms.internal.mlkit_vision_face.zzkt;
import com.google.android.gms.internal.mlkit_vision_face.zzku;
import com.google.android.gms.internal.mlkit_vision_face.zzlj;
import com.google.android.gms.internal.mlkit_vision_face.zzll;
import com.google.android.gms.internal.mlkit_vision_face.zznr;
import com.google.android.gms.internal.mlkit_vision_face.zzoa;
import com.google.android.gms.internal.mlkit_vision_face.zzoc;
import com.google.android.gms.internal.mlkit_vision_face.zzoe;
import com.google.android.gms.internal.mlkit_vision_face.zzof;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.BitmapInStreamingChecker;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.1.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzh extends MLTask {
    static final AtomicBoolean zza = new AtomicBoolean(true);
    private static final ImageUtils zzb = ImageUtils.getInstance();
    private final FaceDetectorOptions zzc;
    private final zzoc zzd;
    private final zzoe zze;
    private final zzb zzf;
    private boolean zzg;
    private final BitmapInStreamingChecker zzh = new BitmapInStreamingChecker();

    public zzh(zzoc zzocVar, FaceDetectorOptions faceDetectorOptions, zzb zzbVar) {
        Preconditions.checkNotNull(faceDetectorOptions, "FaceDetectorOptions can not be null");
        this.zzc = faceDetectorOptions;
        this.zzd = zzocVar;
        this.zzf = zzbVar;
        this.zze = zzoe.zza(MlKitContext.getInstance().getApplicationContext());
    }

    static void zzf(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Face) it.next()).zzc(-1);
        }
    }

    private final synchronized void zzg(final zzks zzksVar, long j, final InputImage inputImage, final int i, final int i2) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zzd.zzf(new zzoa() { // from class: com.google.mlkit.vision.face.internal.zzf
            @Override // com.google.android.gms.internal.mlkit_vision_face.zzoa
            public final zznr zza() {
                return this.zza.zzc(jElapsedRealtime, zzksVar, i, i2, inputImage);
            }
        }, zzkt.ON_DEVICE_FACE_DETECT);
        zzdl zzdlVar = new zzdl();
        zzdlVar.zzc(zzksVar);
        zzdlVar.zzd(Boolean.valueOf(zza.get()));
        zzdlVar.zza(Integer.valueOf(i));
        zzdlVar.zze(Integer.valueOf(i2));
        zzdlVar.zzb(zzj.zza(this.zzc));
        final zzdn zzdnVarZzf = zzdlVar.zzf();
        final zzg zzgVar = new zzg(this);
        final zzoc zzocVar = this.zzd;
        final zzkt zzktVar = zzkt.AGGREGATED_ON_DEVICE_FACE_DETECTION;
        final byte[] bArr = null;
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(zzktVar, zzdnVarZzf, jElapsedRealtime, zzgVar, bArr) { // from class: com.google.android.gms.internal.mlkit_vision_face.zzny
            public final /* synthetic */ zzkt zzb;
            public final /* synthetic */ Object zzc;
            public final /* synthetic */ long zzd;
            public final /* synthetic */ com.google.mlkit.vision.face.internal.zzg zze;

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzh(this.zzb, this.zzc, this.zzd, this.zze);
            }
        });
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.zze.zzc(true != this.zzg ? 24303 : 24304, zzksVar.zza(), jCurrentTimeMillis - jElapsedRealtime, jCurrentTimeMillis);
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void load() throws MlKitException {
        this.zzg = this.zzf.zzd();
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void release() {
        this.zzf.zzb();
        zza.set(true);
        zzoc zzocVar = this.zzd;
        zzku zzkuVar = new zzku();
        zzkuVar.zze(this.zzg ? zzkr.TYPE_THICK : zzkr.TYPE_THIN);
        zzocVar.zzd(zzof.zzf(zzkuVar), zzkt.ON_DEVICE_FACE_CLOSE);
    }

    final /* synthetic */ zznr zzc(long j, zzks zzksVar, int i, int i2, InputImage inputImage) {
        zzlj zzljVar = new zzlj();
        zzkj zzkjVar = new zzkj();
        zzkjVar.zzc(Long.valueOf(j));
        zzkjVar.zzd(zzksVar);
        zzkjVar.zze(Boolean.valueOf(zza.get()));
        zzkjVar.zza(true);
        zzkjVar.zzb(true);
        zzljVar.zzg(zzkjVar.zzf());
        zzljVar.zze(zzj.zza(this.zzc));
        zzljVar.zzd(Integer.valueOf(i));
        zzljVar.zzh(Integer.valueOf(i2));
        ImageUtils imageUtils = zzb;
        int mobileVisionImageFormat = imageUtils.getMobileVisionImageFormat(inputImage);
        int mobileVisionImageSize = imageUtils.getMobileVisionImageSize(inputImage);
        zzke zzkeVar = new zzke();
        zzkeVar.zza(mobileVisionImageFormat != -1 ? mobileVisionImageFormat != 35 ? mobileVisionImageFormat != 842094169 ? mobileVisionImageFormat != 16 ? mobileVisionImageFormat != 17 ? zzkf.UNKNOWN_FORMAT : zzkf.NV21 : zzkf.NV16 : zzkf.YV12 : zzkf.YUV_420_888 : zzkf.BITMAP);
        zzkeVar.zzb(Integer.valueOf(mobileVisionImageSize));
        zzljVar.zzf(zzkeVar.zzd());
        zzll zzllVarZzi = zzljVar.zzi();
        zzku zzkuVar = new zzku();
        zzkuVar.zze(this.zzg ? zzkr.TYPE_THICK : zzkr.TYPE_THIN);
        zzkuVar.zzg(zzllVarZzi);
        return zzof.zzf(zzkuVar);
    }

    final /* synthetic */ zznr zzd(zzdn zzdnVar, int i, zzjv zzjvVar) {
        zzku zzkuVar = new zzku();
        zzkuVar.zze(this.zzg ? zzkr.TYPE_THICK : zzkr.TYPE_THIN);
        zzdk zzdkVar = new zzdk();
        zzdkVar.zza(Integer.valueOf(i));
        zzdkVar.zzc(zzdnVar);
        zzdkVar.zzb(zzjvVar);
        zzkuVar.zzd(zzdkVar.zze());
        return zzof.zzf(zzkuVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0102 A[Catch: MlKitException -> 0x011d, all -> 0x0136, TryCatch #0 {MlKitException -> 0x011d, blocks: (B:5:0x000e, B:9:0x0021, B:10:0x002a, B:12:0x002d, B:38:0x00fc, B:46:0x0112, B:45:0x010c, B:41:0x0102, B:15:0x003b, B:16:0x0042, B:17:0x004b, B:19:0x0051, B:20:0x005c, B:22:0x0062, B:24:0x006e, B:26:0x0074, B:28:0x0082, B:30:0x00d3, B:32:0x00de, B:35:0x00eb, B:37:0x00f4), top: B:59:0x000e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010c A[Catch: MlKitException -> 0x011d, all -> 0x0136, TryCatch #0 {MlKitException -> 0x011d, blocks: (B:5:0x000e, B:9:0x0021, B:10:0x002a, B:12:0x002d, B:38:0x00fc, B:46:0x0112, B:45:0x010c, B:41:0x0102, B:15:0x003b, B:16:0x0042, B:17:0x004b, B:19:0x0051, B:20:0x005c, B:22:0x0062, B:24:0x006e, B:26:0x0074, B:28:0x0082, B:30:0x00d3, B:32:0x00de, B:35:0x00eb, B:37:0x00f4), top: B:59:0x000e, outer: #1 }] */
    @Override // com.google.mlkit.common.sdkinternal.MLTask
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized List run(InputImage inputImage) throws MlKitException {
        List list;
        List arrayList;
        List list2;
        List list3;
        List list4;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.zzh.check(inputImage);
        try {
            Pair pairZza = this.zzf.zza(inputImage);
            List<Face> list5 = (List) pairZza.first;
            List<Face> list6 = (List) pairZza.second;
            if (list5 == null && list6 == null) {
                throw new MlKitException("No detector is enabled", 13);
            }
            if (list5 == null) {
                list4 = (List) Preconditions.checkNotNull(list6);
            } else if (list6 == null) {
                list4 = (List) Preconditions.checkNotNull(list5);
            } else {
                HashSet hashSet = new HashSet();
                for (Face face : list6) {
                    boolean z = false;
                    for (Face face2 : list5) {
                        if (face.getBoundingBox() == null || face2.getBoundingBox() == null) {
                            list3 = list6;
                        } else {
                            Rect boundingBox = face.getBoundingBox();
                            Rect boundingBox2 = face2.getBoundingBox();
                            if (boundingBox.intersect(boundingBox2)) {
                                list3 = list6;
                                double dMin = (Math.min(boundingBox.right, boundingBox2.right) - Math.max(boundingBox.left, boundingBox2.left)) * (Math.min(boundingBox.bottom, boundingBox2.bottom) - Math.max(boundingBox.top, boundingBox2.top));
                                if (dMin / ((((double) ((boundingBox.right - boundingBox.left) * (boundingBox.bottom - boundingBox.top))) + ((double) ((boundingBox2.right - boundingBox2.left) * (boundingBox2.bottom - boundingBox2.top)))) - dMin) > 0.6d) {
                                    face2.zzb(face.zza());
                                    z = true;
                                }
                            }
                        }
                        hashSet.add(face2);
                        list6 = list3;
                    }
                    List list7 = list6;
                    if (!z) {
                        hashSet.add(face);
                    }
                    list6 = list7;
                }
                list = list6;
                arrayList = new ArrayList(hashSet);
                list2 = list5;
                zzg(zzks.NO_ERROR, jElapsedRealtime, inputImage, list != null ? 0 : list.size(), list2 != null ? 0 : list2.size());
                zza.set(false);
            }
            list = list6;
            list2 = list5;
            arrayList = list4;
            zzg(zzks.NO_ERROR, jElapsedRealtime, inputImage, list != null ? 0 : list.size(), list2 != null ? 0 : list2.size());
            zza.set(false);
        } catch (MlKitException e) {
            zzg(e.getErrorCode() == 14 ? zzks.MODEL_NOT_DOWNLOADED : zzks.UNKNOWN_ERROR, jElapsedRealtime, inputImage, 0, 0);
            throw e;
        }
        return arrayList;
    }
}
