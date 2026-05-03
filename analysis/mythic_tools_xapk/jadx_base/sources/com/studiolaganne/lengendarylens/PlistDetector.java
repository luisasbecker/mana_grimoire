package com.studiolaganne.lengendarylens;

import ai.onnxruntime.OnnxTensor;
import ai.onnxruntime.OnnxTensorLike;
import ai.onnxruntime.OnnxValue;
import ai.onnxruntime.OrtEnvironment;
import ai.onnxruntime.OrtException;
import ai.onnxruntime.OrtSession;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PListDetector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bJ\u001a\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u0016J\u001a\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u0016H\u0002J\u0016\u0010'\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0019J\u0006\u0010)\u001a\u00020\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlistDetector;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "ortEnvironment", "Lai/onnxruntime/OrtEnvironment;", "ortSession", "Lai/onnxruntime/OrtSession;", "debugPlistRegionBitmap", "Landroid/graphics/Bitmap;", "INPUT_SIZE", "", "REGION_SIZE_PERCENT", "", "CONFIDENCE_THRESHOLD", "inputBuffer", "Ljava/nio/FloatBuffer;", "pixelArray", "", "value", "", "isReady", "()Z", "", "initializationError", "getInitializationError", "()Ljava/lang/String;", "initializeBuffers", "", "initializeModel", "extractPlistRegion", "cardBitmap", "detectPlist", "Lcom/studiolaganne/lengendarylens/PlistDetectionResult;", "enableDebug", "preprocessImageOptimized", "bitmap", "saveDebugBitmap", "filename", "close", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlistDetector {
    private static final String TAG = "PlistDetector";
    private final float CONFIDENCE_THRESHOLD;
    private final int INPUT_SIZE;
    private final float REGION_SIZE_PERCENT;
    private final Context context;
    private Bitmap debugPlistRegionBitmap;
    private String initializationError;
    private FloatBuffer inputBuffer;
    private boolean isReady;
    private final OrtEnvironment ortEnvironment;
    private OrtSession ortSession;
    private int[] pixelArray;
    public static final int $stable = 8;

    public PlistDetector(Context context) throws OrtException {
        OrtEnvironment environment;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        CardEmbeddings.INSTANCE.tryPreloadNativeLibraries(this.context);
        try {
            environment = OrtEnvironment.getEnvironment();
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "OrtEnvironment.getEnvironment() failed", e);
            this.initializationError = "ONNX Runtime native library not available";
            environment = null;
        }
        this.ortEnvironment = environment;
        this.INPUT_SIZE = 64;
        this.REGION_SIZE_PERCENT = 0.1f;
        this.CONFIDENCE_THRESHOLD = 0.1f;
        initializeBuffers();
        initializeModel();
    }

    public static /* synthetic */ PlistDetectionResult detectPlist$default(PlistDetector plistDetector, Bitmap bitmap, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return plistDetector.detectPlist(bitmap, z);
    }

    private final void initializeBuffers() {
        try {
            int i = this.INPUT_SIZE;
            this.inputBuffer = FloatBuffer.allocate(i * 3 * i);
            int i2 = this.INPUT_SIZE;
            this.pixelArray = new int[i2 * i2];
        } catch (OutOfMemoryError e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("android_plistdetector_buffers_oom", null);
            this.initializationError = "Insufficient memory for plist detector buffers";
            e.printStackTrace();
        }
    }

    private final void initializeModel() throws OrtException {
        if (this.ortEnvironment == null) {
            Log.w(TAG, "Skipping model initialization - ONNX environment not available");
            return;
        }
        GenericDBHelper genericDBHelper = new GenericDBHelper(this.context, "model_plist_detector", ".onnx");
        if (!genericDBHelper.isValid()) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("dbType", genericDBHelper.getDbType());
            firebaseAnalytics.logEvent("android_model_load_failure", bundle);
            this.initializationError = "Plist detector model not found";
            return;
        }
        File currentFile = genericDBHelper.getCurrentFile();
        OrtSession.SessionOptions sessionOptions = new OrtSession.SessionOptions();
        sessionOptions.addXnnpack(MapsKt.mapOf(TuplesKt.to("intra_op_num_threads", ExifInterface.GPS_MEASUREMENT_2D)));
        try {
            OrtSession ortSessionCreateSession = this.ortEnvironment.createSession(currentFile.getPath(), sessionOptions);
            Intrinsics.checkNotNullExpressionValue(ortSessionCreateSession, "createSession(...)");
            this.ortSession = ortSessionCreateSession;
            if (this.inputBuffer == null || this.initializationError != null) {
                return;
            }
            this.isReady = true;
        } catch (Exception e) {
            this.initializationError = "Failed to load plist detector model";
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
            Bundle bundle2 = new Bundle();
            bundle2.putString("dbType", genericDBHelper.getDbType());
            firebaseAnalytics2.logEvent("android_model_load_failure_oom", bundle2);
            this.initializationError = "Insufficient memory to load plist detector model";
            e2.printStackTrace();
        }
    }

    private final void preprocessImageOptimized(Bitmap bitmap, boolean enableDebug) {
        FloatBuffer floatBuffer;
        int[] iArr = this.pixelArray;
        if (iArr == null || (floatBuffer = this.inputBuffer) == null) {
            return;
        }
        int i = this.INPUT_SIZE;
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i);
        floatBuffer.clear();
        if (enableDebug) {
            System.out.println((Object) "=== PREPROCESSING DEBUG ===");
            System.out.println((Object) ("Bitmap size: " + bitmap.getWidth() + "x" + bitmap.getHeight()));
            System.out.println((Object) ("Pixels array size: " + iArr.length));
            System.out.println((Object) "First 5 raw pixels (ARGB):");
            for (int i2 = 0; i2 < 5; i2++) {
                int i3 = iArr[i2];
                int i4 = (i3 >> 8) & 255;
                System.out.println((Object) ("Pixel " + i2 + ": A=" + ((i3 >> 24) & 255) + " R=" + i4 + " G=" + i4 + " B=" + (i3 & 255)));
            }
        }
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            floatBuffer.put(i6, ((((iArr[i5] >> 16) & 255) / 255.0f) - 0.485f) / 0.229f);
            i5++;
            i6++;
        }
        int i7 = 0;
        while (i7 < length) {
            floatBuffer.put(i6, ((((iArr[i7] >> 8) & 255) / 255.0f) - 0.456f) / 0.224f);
            i7++;
            i6++;
        }
        int i8 = 0;
        while (i8 < length) {
            floatBuffer.put(i6, (((iArr[i8] & 255) / 255.0f) - 0.406f) / 0.225f);
            i8++;
            i6++;
        }
        if (enableDebug) {
            floatBuffer.rewind();
            System.out.println((Object) "First 3 normalized R values:");
            for (int i9 = 0; i9 < 3; i9++) {
                System.out.print((Object) (floatBuffer.get(i9) + " "));
            }
            System.out.println();
            System.out.println((Object) "First 3 normalized G values:");
            int i10 = length + 3;
            for (int i11 = length; i11 < i10; i11++) {
                System.out.print((Object) (floatBuffer.get(i11) + " "));
            }
            System.out.println();
            System.out.println((Object) "First 3 normalized B values:");
            int i12 = length * 2;
            int i13 = i12 + 3;
            while (i12 < i13) {
                System.out.print((Object) (floatBuffer.get(i12) + " "));
                i12++;
            }
            System.out.println();
            System.out.println((Object) "=== END PREPROCESSING DEBUG ===");
        }
    }

    static /* synthetic */ void preprocessImageOptimized$default(PlistDetector plistDetector, Bitmap bitmap, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        plistDetector.preprocessImageOptimized(bitmap, z);
    }

    public final void close() throws OrtException {
        OrtSession ortSession = this.ortSession;
        if (ortSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ortSession");
            ortSession = null;
        }
        ortSession.close();
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x02a1: MOVE (r9 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:79:0x02a1 */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final PlistDetectionResult detectPlist(Bitmap cardBitmap, boolean enableDebug) throws Throwable {
        Bitmap bitmapExtractPlistRegion;
        Bitmap bitmap;
        FloatBuffer floatBuffer;
        Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
        Bitmap bitmap2 = null;
        try {
            try {
                if (!this.isReady || this.ortSession == null || this.ortEnvironment == null || (floatBuffer = this.inputBuffer) == null) {
                    return null;
                }
                bitmapExtractPlistRegion = extractPlistRegion(cardBitmap);
                if (enableDebug) {
                    try {
                        System.out.println((Object) "=== PLIST DETECTION DEBUG ===");
                        System.out.println((Object) ("Card size: " + cardBitmap.getWidth() + "x" + cardBitmap.getHeight()));
                        System.out.println((Object) ("Region size: " + bitmapExtractPlistRegion.getWidth() + "x" + bitmapExtractPlistRegion.getHeight()));
                        System.out.println((Object) ("Region config: " + bitmapExtractPlistRegion.getConfig()));
                    } catch (Exception e) {
                        e = e;
                    }
                }
                preprocessImageOptimized(bitmapExtractPlistRegion, enableDebug);
                int i = this.INPUT_SIZE;
                long[] jArr = {1, 3, i, i};
                floatBuffer.rewind();
                OnnxTensor onnxTensorCreateTensor = OnnxTensor.createTensor(this.ortEnvironment, floatBuffer, jArr);
                if (enableDebug) {
                    String string = Arrays.toString(jArr);
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    System.out.println((Object) ("Tensor shape: " + string));
                    System.out.println((Object) ("Input buffer size: " + floatBuffer.capacity()));
                    floatBuffer.rewind();
                    System.out.println((Object) "First 10 input values:");
                    for (int i2 = 0; i2 < 10; i2++) {
                        System.out.print((Object) (floatBuffer.get(i2) + " "));
                    }
                    System.out.println();
                    floatBuffer.rewind();
                    int iCapacity = floatBuffer.capacity();
                    float f = Float.MAX_VALUE;
                    float f2 = Float.MIN_VALUE;
                    for (int i3 = 0; i3 < iCapacity; i3++) {
                        float f3 = floatBuffer.get(i3);
                        if (f3 < f) {
                            f = f3;
                        }
                        if (f3 > f2) {
                            f2 = f3;
                        }
                    }
                    System.out.println((Object) ("Input range: " + f + " to " + f2));
                }
                OrtSession.Result resultRun = onnxTensorCreateTensor;
                try {
                    Map<String, ? extends OnnxTensorLike> mapMapOf = MapsKt.mapOf(TuplesKt.to("input", resultRun));
                    OrtSession ortSession = this.ortSession;
                    if (ortSession == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ortSession");
                        ortSession = null;
                    }
                    resultRun = ortSession.run(mapMapOf);
                    try {
                        OrtSession.Result result = resultRun;
                        OnnxValue onnxValue = result.get(0);
                        Intrinsics.checkNotNull(onnxValue, "null cannot be cast to non-null type ai.onnxruntime.OnnxTensor");
                        OnnxTensor onnxTensor = (OnnxTensor) onnxValue;
                        float f4 = onnxTensor.getFloatBuffer().get(0);
                        if (enableDebug) {
                            System.out.println((Object) ("Raw model output: " + f4));
                            String string2 = Arrays.toString(onnxTensor.getInfo().getShape());
                            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                            System.out.println((Object) ("Model output shape: " + string2));
                            System.out.println((Object) ("Number of outputs: " + result.size()));
                            int size = result.size();
                            for (int i4 = 0; i4 < size; i4++) {
                                OnnxValue onnxValue2 = result.get(i4);
                                Intrinsics.checkNotNull(onnxValue2, "null cannot be cast to non-null type ai.onnxruntime.OnnxTensor");
                                String string3 = Arrays.toString(((OnnxTensor) onnxValue2).getInfo().getShape());
                                Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                                System.out.println((Object) ("Output " + i4 + " shape: " + string3));
                            }
                        }
                        float f5 = this.CONFIDENCE_THRESHOLD;
                        boolean z = f4 >= f5;
                        if (enableDebug) {
                            System.out.println((Object) ("Final decision: " + z + " (threshold: " + f5 + ")"));
                            System.out.println((Object) "=== END DEBUG ===");
                        }
                        PlistDetectionResult plistDetectionResult = new PlistDetectionResult(z, f4);
                        AutoCloseableKt.closeFinally(resultRun, null);
                        AutoCloseableKt.closeFinally(resultRun, null);
                        if (bitmapExtractPlistRegion != null) {
                            bitmapExtractPlistRegion.recycle();
                        }
                        return plistDetectionResult;
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                th = th;
                bitmap2 = bitmap;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bitmapExtractPlistRegion = null;
        } catch (Throwable th2) {
            th = th2;
            if (bitmap2 != null) {
            }
            throw th;
        }
        e.printStackTrace();
        if (bitmapExtractPlistRegion != null) {
            bitmapExtractPlistRegion.recycle();
        }
        return null;
    }

    public final Bitmap extractPlistRegion(Bitmap cardBitmap) {
        Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
        int width = cardBitmap.getWidth();
        int height = cardBitmap.getHeight();
        int i = (int) (width * this.REGION_SIZE_PERCENT);
        int iCoerceAtLeast = RangesKt.coerceAtLeast(height - i, 0);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(cardBitmap, 0, iCoerceAtLeast, i, height - iCoerceAtLeast);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        int i2 = this.INPUT_SIZE;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, i2, i2, true);
        bitmapCreateBitmap.recycle();
        this.debugPlistRegionBitmap = bitmapCreateScaledBitmap.copy(Bitmap.Config.ARGB_8888, false);
        return bitmapCreateScaledBitmap;
    }

    public final String getInitializationError() {
        return this.initializationError;
    }

    /* JADX INFO: renamed from: isReady, reason: from getter */
    public final boolean getIsReady() {
        return this.isReady;
    }

    public final boolean saveDebugBitmap(Bitmap bitmap, String filename) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(filename, "filename");
        try {
            File file = new File(this.context.getExternalFilesDir(null), filename + ".png");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            System.out.println((Object) ("Debug bitmap saved to: " + file.getAbsolutePath()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
