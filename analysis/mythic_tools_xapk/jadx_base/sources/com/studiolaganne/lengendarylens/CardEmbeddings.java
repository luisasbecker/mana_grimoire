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
import androidx.media3.muxer.WebmConstants;
import com.getkeepsafe.relinker.ReLinker;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CardEmbeddings.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\u000e\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0015J\u0010\u0010+\u001a\u0004\u0018\u00010\u00132\u0006\u0010*\u001a\u00020\u0015J\u0018\u0010,\u001a\u00020-2\u0006\u0010*\u001a\u00020\u00152\b\b\u0002\u0010.\u001a\u00020\u0007J\b\u0010/\u001a\u0004\u0018\u00010\u0015J\u0010\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u0015H\u0002J\u0010\u00102\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0015H\u0002J\u0006\u00103\u001a\u00020'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\"\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u001e\u001a\u0004\u0018\u00010\"@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00065"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardEmbeddings;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "INPUT_SIZE", "", "ortEnvironment", "Lai/onnxruntime/OrtEnvironment;", "ortSession", "Lai/onnxruntime/OrtSession;", "embeddingsManager", "Lcom/studiolaganne/lengendarylens/EmbeddingsManager;", "inputBuffer", "Ljava/nio/FloatBuffer;", "pixelArray", "", "embedding", "", "debugArtworkBitmap", "Landroid/graphics/Bitmap;", "meanR", "", "meanG", "meanB", "stdR", "stdG", "stdB", "scale", "value", "", "isReady", "()Z", "", "initializationError", "getInitializationError", "()Ljava/lang/String;", "initializeBuffers", "", "initializeModel", "extractArtwork", "cardBitmap", "generateEmbedding", "findSimilarCards", "Lcom/studiolaganne/lengendarylens/SimilaritySearchResult;", "topK", "getDebugArtworkBitmap", "preprocessImageOptimized", "bitmap", "preprocessImage", "close", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardEmbeddings {
    private static final String TAG = "CardEmbeddings";
    private static volatile boolean relinkerAttempted;
    private final int INPUT_SIZE;
    private final Context context;
    private Bitmap debugArtworkBitmap;
    private float[] embedding;
    private final EmbeddingsManager embeddingsManager;
    private String initializationError;
    private FloatBuffer inputBuffer;
    private boolean isReady;
    private final float meanB;
    private final float meanG;
    private final float meanR;
    private final OrtEnvironment ortEnvironment;
    private OrtSession ortSession;
    private int[] pixelArray;
    private final float scale;
    private final float stdB;
    private final float stdG;
    private final float stdR;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CardEmbeddings.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardEmbeddings$Companion;", "", "<init>", "()V", "TAG", "", "relinkerAttempted", "", "tryPreloadNativeLibraries", "", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized void tryPreloadNativeLibraries(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (CardEmbeddings.relinkerAttempted) {
                return;
            }
            CardEmbeddings.relinkerAttempted = true;
            try {
                ReLinker.loadLibrary(context, "onnxruntime");
                ReLinker.loadLibrary(context, "onnxruntime4j_jni");
                Log.d(CardEmbeddings.TAG, "ONNX native libraries pre-loaded successfully via ReLinker");
            } catch (Exception e) {
                Log.w(CardEmbeddings.TAG, "ReLinker pre-load encountered unexpected error", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.w(CardEmbeddings.TAG, "ReLinker pre-load failed, will rely on ONNX's own loading", e2);
            }
        }
    }

    public CardEmbeddings(Context context) throws OrtException {
        OrtEnvironment environment;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.INPUT_SIZE = WebmConstants.MkvEbmlElement.VIDEO;
        INSTANCE.tryPreloadNativeLibraries(this.context);
        try {
            environment = OrtEnvironment.getEnvironment();
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "OrtEnvironment.getEnvironment() failed", e);
            this.initializationError = "ONNX Runtime native library not available";
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Bundle bundle = new Bundle();
            String message = e.getMessage();
            bundle.putString("error", message != null ? StringsKt.take(message, 100) : null);
            Unit unit = Unit.INSTANCE;
            firebaseAnalytics.logEvent("onnx_env_load_failed", bundle);
            environment = null;
        }
        this.ortEnvironment = environment;
        EmbeddingsManager embeddingsManager = new EmbeddingsManager(this.context);
        this.embeddingsManager = embeddingsManager;
        this.meanR = 0.485f;
        this.meanG = 0.456f;
        this.meanB = 0.406f;
        this.stdR = 0.229f;
        this.stdG = 0.224f;
        this.stdB = 0.225f;
        this.scale = 0.003921569f;
        initializeBuffers();
        initializeModel();
        if (!embeddingsManager.loadEmbeddingsFromAssets() || embeddingsManager.size() == 0) {
            this.isReady = false;
            if (this.initializationError == null) {
                this.initializationError = "Failed to load card artwork embeddings data";
            }
        }
    }

    public static /* synthetic */ SimilaritySearchResult findSimilarCards$default(CardEmbeddings cardEmbeddings, Bitmap bitmap, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 5;
        }
        return cardEmbeddings.findSimilarCards(bitmap, i);
    }

    private final void initializeBuffers() {
        try {
            int i = this.INPUT_SIZE;
            this.inputBuffer = FloatBuffer.allocate(i * 3 * i);
            int i2 = this.INPUT_SIZE;
            this.pixelArray = new int[i2 * i2];
            this.embedding = new float[CardEmbeddingsKt.EMBEDDING_SIZE];
        } catch (OutOfMemoryError e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("android_cardembeddings_buffers_oom", null);
            this.initializationError = "Insufficient memory for card embeddings buffers";
            e.printStackTrace();
        }
    }

    private final void initializeModel() throws OrtException {
        if (this.ortEnvironment == null) {
            Log.w(TAG, "Skipping model initialization - ONNX environment not available");
            return;
        }
        GenericDBHelper genericDBHelper = new GenericDBHelper(this.context, "model_card_art", ".onnx");
        if (!genericDBHelper.isValid()) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("dbType", genericDBHelper.getDbType());
            firebaseAnalytics.logEvent("android_model_load_failure", bundle);
            this.initializationError = "Card embeddings model not found";
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
            this.initializationError = "Failed to load card embeddings model";
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
            Bundle bundle2 = new Bundle();
            bundle2.putString("dbType", genericDBHelper.getDbType());
            firebaseAnalytics2.logEvent("android_model_load_failure_oom", bundle2);
            this.initializationError = "Insufficient memory to load card embeddings model";
            e2.printStackTrace();
        }
    }

    private final FloatBuffer preprocessImage(Bitmap bitmap) {
        int i = this.INPUT_SIZE;
        FloatBuffer floatBufferAllocate = FloatBuffer.allocate(i * 3 * i);
        int i2 = this.INPUT_SIZE;
        int i3 = i2 * i2;
        bitmap.getPixels(new int[i3], 0, i2, 0, 0, i2, i2);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            floatBufferAllocate.put(i6, ((((r2[i5] >> 16) & 255) / 255.0f) - 0.485f) / 0.229f);
            i5++;
            i6++;
        }
        int i7 = 0;
        while (i7 < i3) {
            floatBufferAllocate.put(i6, ((((r2[i7] >> 8) & 255) / 255.0f) - 0.456f) / 0.224f);
            i7++;
            i6++;
        }
        while (i4 < i3) {
            floatBufferAllocate.put(i6, (((r2[i4] & 255) / 255.0f) - 0.406f) / 0.225f);
            i4++;
            i6++;
        }
        Intrinsics.checkNotNull(floatBufferAllocate);
        return floatBufferAllocate;
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
            floatBuffer.put(i4, ((((iArr[i3] >> 16) & 255) * this.scale) - this.meanR) / this.stdR);
            i3++;
            i4++;
        }
        int i5 = 0;
        while (i5 < length) {
            floatBuffer.put(i4, ((((iArr[i5] >> 8) & 255) * this.scale) - this.meanG) / this.stdG);
            i5++;
            i4++;
        }
        while (i2 < length) {
            floatBuffer.put(i4, (((iArr[i2] & 255) * this.scale) - this.meanB) / this.stdB);
            i2++;
            i4++;
        }
    }

    public final void close() throws OrtException {
        OrtSession ortSession = this.ortSession;
        if (ortSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ortSession");
            ortSession = null;
        }
        ortSession.close();
    }

    public final Bitmap extractArtwork(Bitmap cardBitmap) {
        Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
        int width = cardBitmap.getWidth();
        int height = cardBitmap.getHeight();
        double d = height;
        int i = (int) (0.1d * d);
        int iMin = (int) (d * 0.55d);
        if (iMin <= i) {
            iMin = Math.min(i + 100, height);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(cardBitmap, 0, i, width, iMin - i);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        try {
            int i2 = this.INPUT_SIZE;
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, i2, i2, true);
            if (CombinedAnalyzerKt.getDEBUG_VIEWFINDER()) {
                Bitmap bitmap = this.debugArtworkBitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                this.debugArtworkBitmap = bitmapCreateScaledBitmap.copy(Bitmap.Config.ARGB_8888, false);
            }
            return bitmapCreateScaledBitmap;
        } finally {
            bitmapCreateBitmap.recycle();
        }
    }

    public final SimilaritySearchResult findSimilarCards(Bitmap cardBitmap, int topK) throws Throwable {
        Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
        float[] fArrGenerateEmbedding = generateEmbedding(cardBitmap);
        if (fArrGenerateEmbedding != null) {
            return new SimilaritySearchResult(fArrGenerateEmbedding, this.embeddingsManager.findSimilarCards(fArrGenerateEmbedding, topK));
        }
        System.out.println((Object) "Failed to generate embedding for the card image");
        return new SimilaritySearchResult(new float[0], CollectionsKt.emptyList());
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[] generateEmbedding(Bitmap cardBitmap) throws Throwable {
        Bitmap bitmapExtractArtwork;
        float[] fArr;
        Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
        Bitmap bitmap = null;
        try {
            try {
                if (this.isReady && this.ortSession != null && this.ortEnvironment != null) {
                    FloatBuffer floatBuffer = this.inputBuffer;
                    if (floatBuffer == null || (fArr = this.embedding) == null) {
                        return null;
                    }
                    bitmapExtractArtwork = extractArtwork(cardBitmap);
                    try {
                        preprocessImageOptimized(bitmapExtractArtwork);
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
                                ((OnnxTensor) onnxValue).getFloatBuffer().get(fArr);
                                float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
                                Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(...)");
                                AutoCloseableKt.closeFinally(resultCreateTensor, null);
                                AutoCloseableKt.closeFinally(resultCreateTensor, null);
                                if (bitmapExtractArtwork != null) {
                                    bitmapExtractArtwork.recycle();
                                }
                                return fArrCopyOf;
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (bitmapExtractArtwork != null) {
                            bitmapExtractArtwork.recycle();
                        }
                        return null;
                    }
                }
                Log.d(TAG, "ORT session/environment not initialized");
                return null;
            } catch (Throwable th) {
                th = th;
                bitmap = cardBitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bitmapExtractArtwork = null;
        } catch (Throwable th2) {
            th = th2;
            if (bitmap != null) {
            }
            throw th;
        }
    }

    public final Bitmap getDebugArtworkBitmap() {
        return this.debugArtworkBitmap;
    }

    public final String getInitializationError() {
        return this.initializationError;
    }

    /* JADX INFO: renamed from: isReady, reason: from getter */
    public final boolean getIsReady() {
        return this.isReady;
    }
}
