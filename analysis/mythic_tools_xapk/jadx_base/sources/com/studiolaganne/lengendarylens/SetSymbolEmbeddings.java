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
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.io.File;
import java.nio.FloatBuffer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SetSymbolsEmbeddings.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rJ\u0010\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010 \u001a\u00020\rJ\u0010\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010 \u001a\u00020\rJ\u001e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u000fJ\b\u0010)\u001a\u0004\u0018\u00010\rJ\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\rH\u0002J\u0006\u0010,\u001a\u00020\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006."}, d2 = {"Lcom/studiolaganne/lengendarylens/SetSymbolEmbeddings;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "ortEnvironment", "Lai/onnxruntime/OrtEnvironment;", "ortSession", "Lai/onnxruntime/OrtSession;", "embeddingsManager", "Lcom/studiolaganne/lengendarylens/SetEmbeddingsManager;", "debugSetSymbolBitmap", "Landroid/graphics/Bitmap;", "INPUT_SIZE", "", "inputBuffer", "Ljava/nio/FloatBuffer;", "pixelArray", "", "value", "", "isReady", "()Z", "", "initializationError", "getInitializationError", "()Ljava/lang/String;", "initializeBuffers", "", "initializeModel", "processSetSymbol", "setSymbolBitmap", "generateEmbedding", "", "generateSetSymbolEmbedding", "calculateSimilarityToCard", "", "setSymbolEmbedding", "scryfallId", OptionalModuleUtils.FACE, "getDebugSetSymbolBitmap", "preprocessImageOptimized", "bitmap", "close", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetSymbolEmbeddings {
    private static final String TAG = "SetSymbolEmbeddings";
    private final int INPUT_SIZE;
    private final Context context;
    private Bitmap debugSetSymbolBitmap;
    private final SetEmbeddingsManager embeddingsManager;
    private String initializationError;
    private FloatBuffer inputBuffer;
    private boolean isReady;
    private final OrtEnvironment ortEnvironment;
    private OrtSession ortSession;
    private int[] pixelArray;
    public static final int $stable = 8;

    public SetSymbolEmbeddings(Context context) throws OrtException {
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
        SetEmbeddingsManager setEmbeddingsManager = new SetEmbeddingsManager(this.context);
        this.embeddingsManager = setEmbeddingsManager;
        this.INPUT_SIZE = 128;
        initializeBuffers();
        initializeModel();
        if (!setEmbeddingsManager.loadEmbeddingsFromAssets() || setEmbeddingsManager.size() == 0) {
            this.isReady = false;
            if (this.initializationError == null) {
                this.initializationError = "Failed to load set symbol embeddings data";
            }
        }
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
            firebaseAnalytics.logEvent("android_setsymbol_buffers_oom", null);
            this.initializationError = "Insufficient memory for set symbol buffers";
            e.printStackTrace();
        }
    }

    private final void initializeModel() throws OrtException {
        if (this.ortEnvironment == null) {
            Log.w(TAG, "Skipping model initialization - ONNX environment not available");
            return;
        }
        GenericDBHelper genericDBHelper = new GenericDBHelper(this.context, "model_set_symbols", ".onnx");
        if (!genericDBHelper.isValid()) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("dbType", genericDBHelper.getDbType());
            firebaseAnalytics.logEvent("android_model_load_failure", bundle);
            this.initializationError = "Set symbol model not found";
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
            this.initializationError = "Failed to load set symbol model";
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
            Bundle bundle2 = new Bundle();
            bundle2.putString("dbType", genericDBHelper.getDbType());
            firebaseAnalytics2.logEvent("android_model_load_failure_oom", bundle2);
            this.initializationError = "Insufficient memory to load set symbol model";
            e2.printStackTrace();
        }
    }

    private final void preprocessImageOptimized(Bitmap bitmap) {
        FloatBuffer floatBuffer;
        int[] iArr = this.pixelArray;
        if (iArr == null || (floatBuffer = this.inputBuffer) == null) {
            return;
        }
        int i = this.INPUT_SIZE;
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i);
        floatBuffer.clear();
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            floatBuffer.put(i4, ((((iArr[i3] >> 16) & 255) / 255.0f) - 0.485f) / 0.229f);
            i3++;
            i4++;
        }
        int i5 = 0;
        while (i5 < length) {
            floatBuffer.put(i4, ((((iArr[i5] >> 8) & 255) / 255.0f) - 0.456f) / 0.224f);
            i5++;
            i4++;
        }
        while (i2 < length) {
            floatBuffer.put(i4, (((iArr[i2] & 255) / 255.0f) - 0.406f) / 0.225f);
            i2++;
            i4++;
        }
    }

    public final double calculateSimilarityToCard(float[] setSymbolEmbedding, String scryfallId, int face) {
        Intrinsics.checkNotNullParameter(setSymbolEmbedding, "setSymbolEmbedding");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        return this.embeddingsManager.calculateSimilarityToCard(setSymbolEmbedding, scryfallId, face);
    }

    public final void close() throws OrtException {
        OrtSession ortSession = this.ortSession;
        if (ortSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ortSession");
            ortSession = null;
        }
        ortSession.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[] generateEmbedding(Bitmap setSymbolBitmap) throws Throwable {
        Bitmap bitmapProcessSetSymbol;
        FloatBuffer floatBuffer;
        Intrinsics.checkNotNullParameter(setSymbolBitmap, "setSymbolBitmap");
        Bitmap bitmap = null;
        try {
            try {
                if (!this.isReady || this.ortSession == null || this.ortEnvironment == null || (floatBuffer = this.inputBuffer) == null) {
                    return null;
                }
                bitmapProcessSetSymbol = processSetSymbol(setSymbolBitmap);
                try {
                    preprocessImageOptimized(bitmapProcessSetSymbol);
                    int i = this.INPUT_SIZE;
                    floatBuffer.rewind();
                    OrtSession.Result resultCreateTensor = OnnxTensor.createTensor(this.ortEnvironment, floatBuffer, new long[]{1, 3, i, i});
                    try {
                        Map<String, ? extends OnnxTensorLike> mapMapOf = MapsKt.mapOf(TuplesKt.to("input", resultCreateTensor));
                        OrtSession ortSession = this.ortSession;
                        if (ortSession == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("ortSession");
                            ortSession = null;
                        }
                        resultCreateTensor = ortSession.run(mapMapOf);
                        try {
                            OnnxValue onnxValue = resultCreateTensor.get(0);
                            Intrinsics.checkNotNull(onnxValue, "null cannot be cast to non-null type ai.onnxruntime.OnnxTensor");
                            FloatBuffer floatBuffer2 = ((OnnxTensor) onnxValue).getFloatBuffer();
                            float[] fArr = new float[SetSymbolsEmbeddingsKt.SET_EMBEDDING_SIZE];
                            floatBuffer2.get(fArr);
                            AutoCloseableKt.closeFinally(resultCreateTensor, null);
                            AutoCloseableKt.closeFinally(resultCreateTensor, null);
                            if (bitmapProcessSetSymbol != null) {
                                bitmapProcessSetSymbol.recycle();
                            }
                            return fArr;
                        } finally {
                        }
                    } finally {
                    }
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
                bitmap = setSymbolBitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bitmapProcessSetSymbol = null;
        } catch (Throwable th2) {
            th = th2;
            if (bitmap != null) {
            }
            throw th;
        }
        e.printStackTrace();
        if (bitmapProcessSetSymbol != null) {
            bitmapProcessSetSymbol.recycle();
        }
        return null;
    }

    public final float[] generateSetSymbolEmbedding(Bitmap setSymbolBitmap) {
        Intrinsics.checkNotNullParameter(setSymbolBitmap, "setSymbolBitmap");
        return generateEmbedding(setSymbolBitmap);
    }

    public final Bitmap getDebugSetSymbolBitmap() {
        return this.debugSetSymbolBitmap;
    }

    public final String getInitializationError() {
        return this.initializationError;
    }

    /* JADX INFO: renamed from: isReady, reason: from getter */
    public final boolean getIsReady() {
        return this.isReady;
    }

    public final Bitmap processSetSymbol(Bitmap setSymbolBitmap) {
        Intrinsics.checkNotNullParameter(setSymbolBitmap, "setSymbolBitmap");
        int i = this.INPUT_SIZE;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(setSymbolBitmap, i, i, true);
        if (CombinedAnalyzerKt.getDEBUG_VIEWFINDER()) {
            Bitmap bitmap = this.debugSetSymbolBitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.debugSetSymbolBitmap = bitmapCreateScaledBitmap.copy(Bitmap.Config.ARGB_8888, false);
        }
        return bitmapCreateScaledBitmap;
    }
}
