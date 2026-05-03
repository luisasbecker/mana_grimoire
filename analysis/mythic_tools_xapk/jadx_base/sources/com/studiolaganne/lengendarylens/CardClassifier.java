package com.studiolaganne.lengendarylens;

import ai.onnxruntime.OnnxTensor;
import ai.onnxruntime.OnnxTensorLike;
import ai.onnxruntime.OnnxValue;
import ai.onnxruntime.OrtEnvironment;
import ai.onnxruntime.OrtException;
import ai.onnxruntime.OrtSession;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CardClassifier.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 82\u00020\u0001:\u000289B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0002J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u000eH\u0002J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0017J\u0012\u0010/\u001a\u0004\u0018\u00010\u00172\u0006\u0010.\u001a\u00020\u0017H\u0002J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\u0017H\u0002J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020\u0014H\u0002J\u0010\u00104\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0017H\u0002J\u0010\u00105\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u0017H\u0002J\u0010\u00106\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0014H\u0002J\u0006\u00107\u001a\u00020(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\"\u0010$\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006:"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardClassifier;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "ortEnvironment", "Lai/onnxruntime/OrtEnvironment;", "ortSession", "Lai/onnxruntime/OrtSession;", "inputName", "", "outputName", "imageSize", "", "floatBuffer", "Ljava/nio/FloatBuffer;", "pixelArray", "", "expArray", "", "softmaxArray", "reusableOutputBitmap", "Landroid/graphics/Bitmap;", "reusableCanvas", "Landroid/graphics/Canvas;", "classLabels", "", "imageMean", "imageStd", "scale", "", "value", "", "isReady", "()Z", "initializationError", "getInitializationError", "()Ljava/lang/String;", "initializeBuffers", "", "initializeModel", "createEqualDistributionArray", "size", "classify", "Lcom/studiolaganne/lengendarylens/CardClassifier$ClassificationResult;", "cardBitmap", "prepareModelInputBitmapOptimized", "preprocessOptimized", "bitmap", "softmaxOptimized", "logits", "prepareModelInputBitmap", "preprocess", "softmax", "close", "Companion", "ClassificationResult", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardClassifier {
    private static final String TAG = "CardClassifier";
    private final List<String> classLabels;
    private final Context context;
    private float[] expArray;
    private FloatBuffer floatBuffer;
    private final float[] imageMean;
    private final int imageSize;
    private final float[] imageStd;
    private String initializationError;
    private final String inputName;
    private boolean isReady;
    private final OrtEnvironment ortEnvironment;
    private OrtSession ortSession;
    private final String outputName;
    private int[] pixelArray;
    private Canvas reusableCanvas;
    private Bitmap reusableOutputBitmap;
    private final float scale;
    private float[] softmaxArray;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CardClassifier.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardClassifier$ClassificationResult;", "", "classLabel", "", "confidence", "", "allProbabilities", "", "<init>", "(Ljava/lang/String;FLjava/util/Map;)V", "getClassLabel", "()Ljava/lang/String;", "getConfidence", "()F", "getAllProbabilities", "()Ljava/util/Map;", InAppPurchaseConstants.METHOD_TO_STRING, "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ClassificationResult {
        public static final int $stable = 8;
        private final Map<String, Float> allProbabilities;
        private final String classLabel;
        private final float confidence;

        public ClassificationResult(String classLabel, float f, Map<String, Float> allProbabilities) {
            Intrinsics.checkNotNullParameter(classLabel, "classLabel");
            Intrinsics.checkNotNullParameter(allProbabilities, "allProbabilities");
            this.classLabel = classLabel;
            this.confidence = f;
            this.allProbabilities = allProbabilities;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ClassificationResult copy$default(ClassificationResult classificationResult, String str, float f, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = classificationResult.classLabel;
            }
            if ((i & 2) != 0) {
                f = classificationResult.confidence;
            }
            if ((i & 4) != 0) {
                map = classificationResult.allProbabilities;
            }
            return classificationResult.copy(str, f, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getClassLabel() {
            return this.classLabel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getConfidence() {
            return this.confidence;
        }

        public final Map<String, Float> component3() {
            return this.allProbabilities;
        }

        public final ClassificationResult copy(String classLabel, float confidence, Map<String, Float> allProbabilities) {
            Intrinsics.checkNotNullParameter(classLabel, "classLabel");
            Intrinsics.checkNotNullParameter(allProbabilities, "allProbabilities");
            return new ClassificationResult(classLabel, confidence, allProbabilities);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClassificationResult)) {
                return false;
            }
            ClassificationResult classificationResult = (ClassificationResult) other;
            return Intrinsics.areEqual(this.classLabel, classificationResult.classLabel) && Float.compare(this.confidence, classificationResult.confidence) == 0 && Intrinsics.areEqual(this.allProbabilities, classificationResult.allProbabilities);
        }

        public final Map<String, Float> getAllProbabilities() {
            return this.allProbabilities;
        }

        public final String getClassLabel() {
            return this.classLabel;
        }

        public final float getConfidence() {
            return this.confidence;
        }

        public int hashCode() {
            return (((this.classLabel.hashCode() * 31) + Float.hashCode(this.confidence)) * 31) + this.allProbabilities.hashCode();
        }

        public String toString() {
            String str = this.classLabel;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(this.confidence * 100.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            return "Class: " + str + ", Confidence: " + str2 + "%";
        }
    }

    public CardClassifier(Context context) throws OrtException {
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
        this.inputName = "input";
        this.outputName = "output";
        this.imageSize = 480;
        this.classLabels = CollectionsKt.listOf((Object[]) new String[]{"aftermath", "battle", "normal", "split_card", "token"});
        this.imageMean = new float[]{0.485f, 0.456f, 0.406f};
        this.imageStd = new float[]{0.229f, 0.224f, 0.225f};
        this.scale = 0.003921569f;
        initializeBuffers();
        initializeModel();
    }

    private final float[] createEqualDistributionArray(int size) {
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = 1.0f / size;
        }
        return fArr;
    }

    private final void initializeBuffers() {
        try {
            int i = this.imageSize;
            this.floatBuffer = FloatBuffer.allocate(i * 3 * i);
            int i2 = this.imageSize;
            this.pixelArray = new int[i2 * i2];
            this.expArray = new float[5];
            this.softmaxArray = new float[5];
            this.reusableOutputBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
            Bitmap bitmap = this.reusableOutputBitmap;
            Intrinsics.checkNotNull(bitmap);
            this.reusableCanvas = new Canvas(bitmap);
        } catch (OutOfMemoryError e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("android_cardclassifier_buffers_oom", null);
            this.initializationError = "Insufficient memory for card classifier buffers";
            e.printStackTrace();
        }
    }

    private final void initializeModel() throws OrtException {
        if (this.ortEnvironment == null) {
            Log.w(TAG, "Skipping model initialization - ONNX environment not available");
            return;
        }
        GenericDBHelper genericDBHelper = new GenericDBHelper(this.context, "model_card_classifier", ".onnx");
        if (!genericDBHelper.isValid()) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("dbType", genericDBHelper.getDbType());
            firebaseAnalytics.logEvent("android_model_load_failure", bundle);
            this.initializationError = "Card classifier model not found";
            return;
        }
        File currentFile = genericDBHelper.getCurrentFile();
        OrtSession.SessionOptions sessionOptions = new OrtSession.SessionOptions();
        sessionOptions.addXnnpack(MapsKt.mapOf(TuplesKt.to("intra_op_num_threads", ExifInterface.GPS_MEASUREMENT_2D)));
        try {
            OrtSession ortSessionCreateSession = this.ortEnvironment.createSession(currentFile.getPath(), sessionOptions);
            Intrinsics.checkNotNullExpressionValue(ortSessionCreateSession, "createSession(...)");
            this.ortSession = ortSessionCreateSession;
            if (this.floatBuffer == null || this.initializationError != null) {
                return;
            }
            this.isReady = true;
        } catch (Exception e) {
            this.initializationError = "Failed to load card classifier model";
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
            Bundle bundle2 = new Bundle();
            bundle2.putString("dbType", genericDBHelper.getDbType());
            firebaseAnalytics2.logEvent("android_model_load_failure_oom", bundle2);
            this.initializationError = "Insufficient memory to load card classifier model";
            e2.printStackTrace();
        }
    }

    private final Bitmap prepareModelInputBitmap(Bitmap cardBitmap) {
        int i;
        int i2;
        int i3 = this.imageSize;
        float width = cardBitmap.getWidth() / cardBitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(-16777216);
        if (width > 1.0f) {
            i2 = (int) (i3 / width);
            i = i3;
        } else {
            i = (int) (i3 * width);
            i2 = i3;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(cardBitmap, i, i2, true);
        canvas.drawBitmap(bitmapCreateScaledBitmap, (i3 - i) / 2, (i3 - i2) / 2, (Paint) null);
        if (!Intrinsics.areEqual(bitmapCreateScaledBitmap, cardBitmap)) {
            bitmapCreateScaledBitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    private final Bitmap prepareModelInputBitmapOptimized(Bitmap cardBitmap) {
        Canvas canvas;
        int i;
        int i2;
        int i3 = this.imageSize;
        float width = cardBitmap.getWidth() / cardBitmap.getHeight();
        Bitmap bitmap = this.reusableOutputBitmap;
        if (bitmap == null || (canvas = this.reusableCanvas) == null) {
            return null;
        }
        canvas.drawColor(-16777216);
        if (width > 1.0f) {
            i2 = (int) (i3 / width);
            i = i3;
        } else {
            i = (int) (i3 * width);
            i2 = i3;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(cardBitmap, i, i2, true);
        canvas.drawBitmap(bitmapCreateScaledBitmap, (i3 - i) / 2, (i3 - i2) / 2, (Paint) null);
        if (!Intrinsics.areEqual(bitmapCreateScaledBitmap, cardBitmap)) {
            bitmapCreateScaledBitmap.recycle();
        }
        return bitmap;
    }

    private final FloatBuffer preprocess(Bitmap bitmap) {
        int i = this.imageSize;
        FloatBuffer floatBufferAllocate = FloatBuffer.allocate(i * 3 * i);
        int i2 = this.imageSize;
        int i3 = i2 * i2;
        bitmap.getPixels(new int[i3], 0, i2, 0, 0, i2, i2);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            floatBufferAllocate.put(i6, ((((r2[i5] >> 16) & 255) * 0.003921569f) - this.imageMean[0]) / this.imageStd[0]);
            i5++;
            i6++;
        }
        int i7 = 0;
        while (i7 < i3) {
            floatBufferAllocate.put(i6, ((((r2[i7] >> 8) & 255) * 0.003921569f) - this.imageMean[1]) / this.imageStd[1]);
            i7++;
            i6++;
        }
        while (i4 < i3) {
            floatBufferAllocate.put(i6, (((r2[i4] & 255) * 0.003921569f) - this.imageMean[2]) / this.imageStd[2]);
            i4++;
            i6++;
        }
        Intrinsics.checkNotNull(floatBufferAllocate);
        return floatBufferAllocate;
    }

    private final void preprocessOptimized(Bitmap bitmap) {
        FloatBuffer floatBuffer;
        int[] iArr = this.pixelArray;
        if (iArr == null || (floatBuffer = this.floatBuffer) == null) {
            return;
        }
        int i = this.imageSize;
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i);
        floatBuffer.clear();
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            floatBuffer.put(i4, ((((iArr[i3] >> 16) & 255) * this.scale) - this.imageMean[0]) / this.imageStd[0]);
            i3++;
            i4++;
        }
        int i5 = 0;
        while (i5 < length) {
            floatBuffer.put(i4, ((((iArr[i5] >> 8) & 255) * this.scale) - this.imageMean[1]) / this.imageStd[1]);
            i5++;
            i4++;
        }
        while (i2 < length) {
            floatBuffer.put(i4, (((iArr[i2] & 255) * this.scale) - this.imageMean[2]) / this.imageStd[2]);
            i2++;
            i4++;
        }
    }

    private final float[] softmax(float[] logits) {
        float f = logits[0];
        int length = logits.length;
        for (int i = 1; i < length; i++) {
            float f2 = logits[i];
            if (f2 > f) {
                f = f2;
            }
        }
        float[] fArr = new float[logits.length];
        int length2 = logits.length;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < length2; i2++) {
            float fExp = (float) Math.exp(logits[i2] - f);
            fArr[i2] = fExp;
            f3 += fExp;
        }
        float[] fArr2 = new float[logits.length];
        int length3 = logits.length;
        for (int i3 = 0; i3 < length3; i3++) {
            fArr2[i3] = fArr[i3] / f3;
        }
        return fArr2;
    }

    private final void softmaxOptimized(float[] logits) {
        float[] fArr;
        float[] fArr2 = this.softmaxArray;
        if (fArr2 == null || (fArr = this.expArray) == null) {
            return;
        }
        int iMin = Math.min(logits.length, fArr2.length);
        float f = logits[0];
        for (int i = 1; i < iMin; i++) {
            float f2 = logits[i];
            if (f2 > f) {
                f = f2;
            }
        }
        float f3 = 0.0f;
        for (int i2 = 0; i2 < iMin; i2++) {
            float fExp = (float) Math.exp(logits[i2] - f);
            fArr[i2] = fExp;
            f3 += fExp;
        }
        for (int i3 = 0; i3 < iMin; i3++) {
            fArr2[i3] = fArr[i3] / f3;
        }
    }

    public final ClassificationResult classify(Bitmap cardBitmap) throws Exception {
        FloatBuffer floatBuffer;
        Bitmap bitmapPrepareModelInputBitmapOptimized;
        float[] fArrCreateEqualDistributionArray;
        Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
        List<String> list = this.classLabels;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(obj, Float.valueOf(1.0f / this.classLabels.size()));
        }
        ClassificationResult classificationResult = new ClassificationResult("normal", 0.0f, linkedHashMap);
        if (!this.isReady || this.ortSession == null || this.ortEnvironment == null || (floatBuffer = this.floatBuffer) == null || (bitmapPrepareModelInputBitmapOptimized = prepareModelInputBitmapOptimized(cardBitmap)) == null) {
            return classificationResult;
        }
        preprocessOptimized(bitmapPrepareModelInputBitmapOptimized);
        int i = this.imageSize;
        floatBuffer.rewind();
        OnnxTensor onnxTensorCreateTensor = OnnxTensor.createTensor(this.ortEnvironment, floatBuffer, new long[]{1, 3, i, i});
        Map<String, ? extends OnnxTensorLike> mapMapOf = MapsKt.mapOf(TuplesKt.to(this.inputName, onnxTensorCreateTensor));
        OrtSession.Result resultRun = onnxTensorCreateTensor;
        try {
            OnnxTensor onnxTensor = resultRun;
            OrtSession ortSession = this.ortSession;
            if (ortSession == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ortSession");
                ortSession = null;
            }
            resultRun = ortSession.run(mapMapOf);
            try {
                Optional<OnnxValue> optional = resultRun.get(this.outputName);
                if (optional == null || !optional.isPresent()) {
                    fArrCreateEqualDistributionArray = createEqualDistributionArray(this.classLabels.size());
                } else {
                    OnnxValue onnxValue = optional.get();
                    Intrinsics.checkNotNullExpressionValue(onnxValue, "get(...)");
                    OnnxValue onnxValue2 = onnxValue;
                    if (onnxValue2 instanceof OnnxTensor) {
                        try {
                            fArrCreateEqualDistributionArray = ((OnnxTensor) onnxValue2).getFloatBuffer().array();
                        } catch (Exception unused) {
                            Object value = ((OnnxTensor) onnxValue2).getValue();
                            if (!(value instanceof Object[])) {
                                fArrCreateEqualDistributionArray = value instanceof float[] ? (float[]) value : createEqualDistributionArray(this.classLabels.size());
                            } else if ((((Object[]) value).length == 0) || !(((Object[]) value)[0] instanceof float[])) {
                                fArrCreateEqualDistributionArray = createEqualDistributionArray(this.classLabels.size());
                            } else {
                                Object obj2 = ((Object[]) value)[0];
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.FloatArray");
                                fArrCreateEqualDistributionArray = (float[]) obj2;
                            }
                        }
                    } else {
                        fArrCreateEqualDistributionArray = createEqualDistributionArray(this.classLabels.size());
                    }
                }
                Intrinsics.checkNotNull(fArrCreateEqualDistributionArray);
                softmaxOptimized(fArrCreateEqualDistributionArray);
                float[] fArr = this.softmaxArray;
                if (fArr != null) {
                    float f = fArr[0];
                    int length = fArr.length;
                    int i2 = 0;
                    for (int i3 = 1; i3 < length; i3++) {
                        float f2 = fArr[i3];
                        if (f2 > f) {
                            f = f2;
                            i2 = i3;
                        }
                    }
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    int length2 = fArr.length;
                    for (int i4 = 0; i4 < length2; i4++) {
                        if (i4 < this.classLabels.size()) {
                            linkedHashMap2.put(this.classLabels.get(i4), Float.valueOf(fArr[i4]));
                        }
                    }
                    classificationResult = new ClassificationResult(this.classLabels.get(i2), f, linkedHashMap2);
                }
                AutoCloseableKt.closeFinally(resultRun, null);
                AutoCloseableKt.closeFinally(resultRun, null);
                return classificationResult;
            } finally {
            }
        } finally {
        }
    }

    public final void close() throws OrtException {
        Bitmap bitmap = this.reusableOutputBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        OrtSession ortSession = null;
        this.reusableOutputBitmap = null;
        this.reusableCanvas = null;
        OrtSession ortSession2 = this.ortSession;
        if (ortSession2 != null) {
            if (ortSession2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ortSession");
            } else {
                ortSession = ortSession2;
            }
            ortSession.close();
        }
        OrtEnvironment ortEnvironment = this.ortEnvironment;
        if (ortEnvironment != null) {
            ortEnvironment.close();
        }
    }

    public final String getInitializationError() {
        return this.initializationError;
    }

    /* JADX INFO: renamed from: isReady, reason: from getter */
    public final boolean getIsReady() {
        return this.isReady;
    }
}
