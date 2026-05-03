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
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: CardDetector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0016\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\u0018\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u0004\u0018\u00010\u001aJ\b\u0010-\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010.\u001a\u00020%2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+H\u0002JF\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020+2\u0006\u00108\u001a\u000209H\u0002J\u001c\u0010:\u001a\b\u0012\u0004\u0012\u000201002\f\u0010;\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u000201002\f\u0010=\u001a\b\u0012\u0004\u0012\u00020100H\u0002J&\u0010>\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a2\f\u0010;\u001a\b\u0012\u0004\u0012\u000201002\u0006\u0010*\u001a\u00020+H\u0002J\u0016\u0010?\u001a\u00020\u001d2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u0018\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u0002012\u0006\u0010C\u001a\u000201H\u0002J \u0010D\u001a\u00020A2\u0006\u0010B\u001a\u0002012\u0006\u0010C\u001a\u0002012\u0006\u0010E\u001a\u000201H\u0002J\u0016\u0010F\u001a\u00020A2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u0006\u0010G\u001a\u00020%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001c\u001a\u0004\u0018\u00010 @BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006I"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardDetector;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "ortEnvironment", "Lai/onnxruntime/OrtEnvironment;", "ortSession", "Lai/onnxruntime/OrtSession;", "inputBuffer", "Ljava/nio/FloatBuffer;", "pixelArray", "", "maskCoeffs", "", "confidences", "rowBuffer", "", "mask", "", "[[F", "binaryMask", "", "[[Z", "debugPreprocessedBitmap", "Landroid/graphics/Bitmap;", "debugMaskBitmap", "value", "", "isReady", "()Z", "", "initializationError", "getInitializationError", "()Ljava/lang/String;", "initializeBuffers", "", "initializeModel", "detectCard", "Lcom/studiolaganne/lengendarylens/CardSegmentation;", "bitmap", "rotationDegrees", "", "getDebugPreprocessedBitmap", "getDebugMaskBitmap", "preprocessImage", "processSegmentationMask", "", "Landroid/graphics/PointF;", "detectionData", "maskData", "bestIdx", "numDetections", "imageWidth", "imageHeight", "maskShape", "", "getCardCorners", "polygonPoints", "orderPoints", "points", "extractCardFromPolygon", "isValidCardShape", "distance", "", "p1", "p2", "getAngle", "p3", "calculatePolygonArea", "close", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardDetector {
    private static final String TAG = "CardDetector";
    private boolean[][] binaryMask;
    private float[] confidences;
    private final Context context;
    private Bitmap debugMaskBitmap;
    private Bitmap debugPreprocessedBitmap;
    private String initializationError;
    private FloatBuffer inputBuffer;
    private boolean isReady;
    private float[][] mask;
    private float[] maskCoeffs;
    private final OrtEnvironment ortEnvironment;
    private OrtSession ortSession;
    private int[] pixelArray;
    private byte[] rowBuffer;
    public static final int $stable = 8;

    public CardDetector(Context context) throws OrtException {
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
        initializeBuffers();
        initializeModel();
    }

    private final float calculatePolygonArea(List<? extends PointF> points) {
        int size = points.size();
        float f = 0.0f;
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            int i3 = i2 % size;
            f = (f + (points.get(i).x * points.get(i3).y)) - (points.get(i3).x * points.get(i).y);
            i = i2;
        }
        return Math.abs(f) / 2.0f;
    }

    private final float distance(PointF p1, PointF p2) {
        float f = p2.x - p1.x;
        float f2 = p2.y - p1.y;
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    private final Bitmap extractCardFromPolygon(Bitmap bitmap, List<? extends PointF> polygonPoints, int rotationDegrees) {
        List<PointF> cardCorners = getCardCorners(polygonPoints);
        int height = (rotationDegrees == 90 || rotationDegrees == 270) ? bitmap.getHeight() : bitmap.getWidth();
        int width = (rotationDegrees == 90 || rotationDegrees == 270) ? bitmap.getWidth() : bitmap.getHeight();
        int iMin = Math.min(height, width);
        int i = (height - iMin) / 2;
        int i2 = (width - iMin) / 2;
        float f = iMin / 480.0f;
        List<PointF> list = cardCorners;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (PointF pointF : list) {
            float f2 = (pointF.x * f) + i;
            float f3 = (pointF.y * f) + i2;
            if (rotationDegrees == 90) {
                float f4 = height - f2;
                f2 = f3;
                f3 = f4;
            } else if (rotationDegrees == 180) {
                f2 = height - f2;
                f3 = width - f3;
            } else if (rotationDegrees == 270) {
                float f5 = width - f3;
                f3 = f2;
                f2 = f5;
            }
            arrayList.add(new PointF(f2, f3));
        }
        ArrayList arrayList2 = arrayList;
        float[] fArr = {0.0f, 0.0f, 750.0f, 0.0f, 750.0f, 1050.0f, 0.0f, 1050.0f};
        float[] fArr2 = new float[8];
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = i3 * 2;
            fArr2[i4] = ((PointF) arrayList2.get(i3)).x;
            fArr2[i4 + 1] = ((PointF) arrayList2.get(i3)).y;
        }
        Matrix matrix = new Matrix();
        matrix.setPolyToPoly(fArr2, 0, fArr, 0, 4);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(750, 1050, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, matrix, new Paint(2));
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 18, 26, 714, DescriptorProtos.Edition.EDITION_PROTO2_VALUE);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(...)");
        bitmapCreateBitmap.recycle();
        return bitmapCreateBitmap2;
    }

    private final float getAngle(PointF p1, PointF p2, PointF p3) {
        float degrees = (float) Math.toDegrees(Math.atan2(p1.y - p2.y, p1.x - p2.x) - Math.atan2(p3.y - p2.y, p3.x - p2.x));
        return degrees < 0.0f ? degrees + 360.0f : degrees;
    }

    private final List<PointF> getCardCorners(List<? extends PointF> polygonPoints) {
        Object next;
        Object next2;
        Object next3;
        if (polygonPoints.size() == 4) {
            return orderPoints(polygonPoints);
        }
        List<? extends PointF> list = polygonPoints;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((PointF) it.next()).x));
        }
        float fAverageOfFloat = (float) CollectionsKt.averageOfFloat(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Float.valueOf(((PointF) it2.next()).y));
        }
        float fAverageOfFloat2 = (float) CollectionsKt.averageOfFloat(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list) {
            PointF pointF = (PointF) obj;
            if (pointF.x <= fAverageOfFloat && pointF.y <= fAverageOfFloat2) {
                arrayList3.add(obj);
            }
        }
        Iterator it3 = arrayList3.iterator();
        Object next4 = null;
        if (it3.hasNext()) {
            next = it3.next();
            if (it3.hasNext()) {
                PointF pointF2 = (PointF) next;
                float f = pointF2.x + pointF2.y;
                do {
                    Object next5 = it3.next();
                    PointF pointF3 = (PointF) next5;
                    float f2 = pointF3.x + pointF3.y;
                    if (Float.compare(f, f2) > 0) {
                        next = next5;
                        f = f2;
                    }
                } while (it3.hasNext());
            }
        } else {
            next = null;
        }
        PointF pointF4 = (PointF) next;
        if (pointF4 == null) {
            pointF4 = polygonPoints.get(0);
        }
        PointF pointF5 = pointF4;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list) {
            PointF pointF6 = (PointF) obj2;
            if (pointF6.x >= fAverageOfFloat && pointF6.y <= fAverageOfFloat2) {
                arrayList4.add(obj2);
            }
        }
        Iterator it4 = arrayList4.iterator();
        if (it4.hasNext()) {
            next2 = it4.next();
            if (it4.hasNext()) {
                PointF pointF7 = (PointF) next2;
                float f3 = (-pointF7.x) + pointF7.y;
                do {
                    Object next6 = it4.next();
                    PointF pointF8 = (PointF) next6;
                    float f4 = (-pointF8.x) + pointF8.y;
                    if (Float.compare(f3, f4) > 0) {
                        next2 = next6;
                        f3 = f4;
                    }
                } while (it4.hasNext());
            }
        } else {
            next2 = null;
        }
        PointF pointF9 = (PointF) next2;
        if (pointF9 == null) {
            pointF9 = polygonPoints.get(0);
        }
        PointF pointF10 = pointF9;
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : list) {
            PointF pointF11 = (PointF) obj3;
            if (pointF11.x >= fAverageOfFloat && pointF11.y >= fAverageOfFloat2) {
                arrayList5.add(obj3);
            }
        }
        Iterator it5 = arrayList5.iterator();
        if (it5.hasNext()) {
            next3 = it5.next();
            if (it5.hasNext()) {
                PointF pointF12 = (PointF) next3;
                float f5 = (-pointF12.x) - pointF12.y;
                do {
                    Object next7 = it5.next();
                    PointF pointF13 = (PointF) next7;
                    float f6 = (-pointF13.x) - pointF13.y;
                    if (Float.compare(f5, f6) > 0) {
                        next3 = next7;
                        f5 = f6;
                    }
                } while (it5.hasNext());
            }
        } else {
            next3 = null;
        }
        PointF pointF14 = (PointF) next3;
        if (pointF14 == null) {
            pointF14 = polygonPoints.get(0);
        }
        PointF pointF15 = pointF14;
        ArrayList arrayList6 = new ArrayList();
        for (Object obj4 : list) {
            PointF pointF16 = (PointF) obj4;
            if (pointF16.x <= fAverageOfFloat && pointF16.y >= fAverageOfFloat2) {
                arrayList6.add(obj4);
            }
        }
        Iterator it6 = arrayList6.iterator();
        if (it6.hasNext()) {
            next4 = it6.next();
            if (it6.hasNext()) {
                PointF pointF17 = (PointF) next4;
                float f7 = pointF17.x - pointF17.y;
                do {
                    Object next8 = it6.next();
                    PointF pointF18 = (PointF) next8;
                    float f8 = pointF18.x - pointF18.y;
                    if (Float.compare(f7, f8) > 0) {
                        next4 = next8;
                        f7 = f8;
                    }
                } while (it6.hasNext());
            }
        }
        PointF pointF19 = (PointF) next4;
        if (pointF19 == null) {
            pointF19 = polygonPoints.get(0);
        }
        return CollectionsKt.listOf((Object[]) new PointF[]{pointF5, pointF10, pointF15, pointF19});
    }

    private final void initializeBuffers() {
        try {
            this.inputBuffer = FloatBuffer.allocate(691200);
            this.pixelArray = new int[230400];
            this.maskCoeffs = new float[32];
            this.confidences = new float[8400];
            this.rowBuffer = new byte[WebmConstants.MkvEbmlElement.BLOCK_GROUP];
            float[][] fArr = new float[WebmConstants.MkvEbmlElement.BLOCK_GROUP][];
            for (int i = 0; i < 160; i++) {
                fArr[i] = new float[WebmConstants.MkvEbmlElement.BLOCK_GROUP];
            }
            this.mask = fArr;
            boolean[][] zArr = new boolean[WebmConstants.MkvEbmlElement.BLOCK_GROUP][];
            for (int i2 = 0; i2 < 160; i2++) {
                zArr[i2] = new boolean[WebmConstants.MkvEbmlElement.BLOCK_GROUP];
            }
            this.binaryMask = zArr;
        } catch (OutOfMemoryError e) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("android_carddetector_buffers_oom", null);
            this.initializationError = "Insufficient memory for card detection buffers";
            e.printStackTrace();
        }
    }

    private final void initializeModel() throws OrtException {
        if (this.ortEnvironment == null) {
            Log.w(TAG, "Skipping model initialization - ONNX environment not available");
            return;
        }
        GenericDBHelper genericDBHelper = new GenericDBHelper(this.context, "model_card_detection", ".onnx");
        if (!genericDBHelper.isValid()) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            Bundle bundle = new Bundle();
            bundle.putString("dbType", genericDBHelper.getDbType());
            firebaseAnalytics.logEvent("android_model_load_failure", bundle);
            this.initializationError = "Card detection model not found";
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
            this.initializationError = "Failed to load card detection model";
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(this.context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
            Bundle bundle2 = new Bundle();
            bundle2.putString("dbType", genericDBHelper.getDbType());
            firebaseAnalytics2.logEvent("android_model_load_failure_oom", bundle2);
            this.initializationError = "Insufficient memory to load card detection model";
            e2.printStackTrace();
        }
    }

    private final boolean isValidCardShape(List<? extends PointF> points) {
        if (points.size() < 4) {
            return false;
        }
        List<PointF> cardCorners = getCardCorners(points);
        double dMax = Math.max(distance(cardCorners.get(0), cardCorners.get(3)), distance(cardCorners.get(1), cardCorners.get(2))) / Math.max(distance(cardCorners.get(0), cardCorners.get(1)), distance(cardCorners.get(3), cardCorners.get(2)));
        if (dMax < 1.0499999821186066d || dMax > 1.7499999701976776d) {
            return false;
        }
        int i = 0;
        while (i < 4) {
            int i2 = i + 1;
            float angle = getAngle(cardCorners.get(i), cardCorners.get(i2 % 4), cardCorners.get((i + 2) % 4));
            if (angle < 60.0f || angle > 120.0f) {
                return false;
            }
            i = i2;
        }
        return calculatePolygonArea(cardCorners) / 230400.0f >= 0.1f;
    }

    private final List<PointF> orderPoints(List<? extends PointF> points) {
        Object next;
        Object next2;
        Object next3;
        List<? extends PointF> list = points;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((PointF) it.next()).x));
        }
        float fAverageOfFloat = (float) CollectionsKt.averageOfFloat(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Float.valueOf(((PointF) it2.next()).y));
        }
        float fAverageOfFloat2 = (float) CollectionsKt.averageOfFloat(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list) {
            PointF pointF = (PointF) obj;
            if (pointF.x <= fAverageOfFloat && pointF.y <= fAverageOfFloat2) {
                arrayList3.add(obj);
            }
        }
        Iterator it3 = arrayList3.iterator();
        Object next4 = null;
        if (it3.hasNext()) {
            next = it3.next();
            if (it3.hasNext()) {
                PointF pointF2 = (PointF) next;
                float f = pointF2.x + pointF2.y;
                do {
                    Object next5 = it3.next();
                    PointF pointF3 = (PointF) next5;
                    float f2 = pointF3.x + pointF3.y;
                    if (Float.compare(f, f2) > 0) {
                        next = next5;
                        f = f2;
                    }
                } while (it3.hasNext());
            }
        } else {
            next = null;
        }
        PointF pointF4 = (PointF) next;
        if (pointF4 == null) {
            pointF4 = points.get(0);
        }
        PointF pointF5 = pointF4;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list) {
            PointF pointF6 = (PointF) obj2;
            if (pointF6.x >= fAverageOfFloat && pointF6.y <= fAverageOfFloat2) {
                arrayList4.add(obj2);
            }
        }
        Iterator it4 = arrayList4.iterator();
        if (it4.hasNext()) {
            next2 = it4.next();
            if (it4.hasNext()) {
                PointF pointF7 = (PointF) next2;
                float f3 = (-pointF7.x) + pointF7.y;
                do {
                    Object next6 = it4.next();
                    PointF pointF8 = (PointF) next6;
                    float f4 = (-pointF8.x) + pointF8.y;
                    if (Float.compare(f3, f4) > 0) {
                        next2 = next6;
                        f3 = f4;
                    }
                } while (it4.hasNext());
            }
        } else {
            next2 = null;
        }
        PointF pointF9 = (PointF) next2;
        if (pointF9 == null) {
            pointF9 = points.get(1);
        }
        PointF pointF10 = pointF9;
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : list) {
            PointF pointF11 = (PointF) obj3;
            if (pointF11.x >= fAverageOfFloat && pointF11.y >= fAverageOfFloat2) {
                arrayList5.add(obj3);
            }
        }
        Iterator it5 = arrayList5.iterator();
        if (it5.hasNext()) {
            next3 = it5.next();
            if (it5.hasNext()) {
                PointF pointF12 = (PointF) next3;
                float f5 = (-pointF12.x) - pointF12.y;
                do {
                    Object next7 = it5.next();
                    PointF pointF13 = (PointF) next7;
                    float f6 = (-pointF13.x) - pointF13.y;
                    if (Float.compare(f5, f6) > 0) {
                        next3 = next7;
                        f5 = f6;
                    }
                } while (it5.hasNext());
            }
        } else {
            next3 = null;
        }
        PointF pointF14 = (PointF) next3;
        if (pointF14 == null) {
            pointF14 = points.get(2);
        }
        PointF pointF15 = pointF14;
        ArrayList arrayList6 = new ArrayList();
        for (Object obj4 : list) {
            PointF pointF16 = (PointF) obj4;
            if (pointF16.x <= fAverageOfFloat && pointF16.y >= fAverageOfFloat2) {
                arrayList6.add(obj4);
            }
        }
        Iterator it6 = arrayList6.iterator();
        if (it6.hasNext()) {
            next4 = it6.next();
            if (it6.hasNext()) {
                PointF pointF17 = (PointF) next4;
                float f7 = pointF17.x - pointF17.y;
                do {
                    Object next8 = it6.next();
                    PointF pointF18 = (PointF) next8;
                    float f8 = pointF18.x - pointF18.y;
                    if (Float.compare(f7, f8) > 0) {
                        next4 = next8;
                        f7 = f8;
                    }
                } while (it6.hasNext());
            }
        }
        PointF pointF19 = (PointF) next4;
        if (pointF19 == null) {
            pointF19 = points.get(3);
        }
        return CollectionsKt.listOf((Object[]) new PointF[]{pointF5, pointF10, pointF15, pointF19});
    }

    private final void preprocessImage(Bitmap bitmap, int rotationDegrees) {
        FloatBuffer floatBuffer;
        int[] iArr = this.pixelArray;
        if (iArr == null || (floatBuffer = this.inputBuffer) == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (rotationDegrees != 0) {
            matrix.postRotate(rotationDegrees);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMin = Math.min(width, height);
        float f = 480.0f / iMin;
        matrix.postScale(f, f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (width - iMin) / 2, (height - iMin) / 2, iMin, iMin, matrix, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        try {
            int i = 0;
            if (CombinedAnalyzerKt.getDEBUG_VIEWFINDER()) {
                Bitmap bitmap2 = this.debugPreprocessedBitmap;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                this.debugPreprocessedBitmap = bitmapCreateBitmap.copy(Bitmap.Config.ARGB_8888, false);
            }
            bitmapCreateBitmap.getPixels(iArr, 0, 480, 0, 0, 480, 480);
            floatBuffer.clear();
            int length = iArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                floatBuffer.put(i3, ((iArr[i2] >> 16) & 255) * 0.003921569f);
                i2++;
                i3++;
            }
            int i4 = 0;
            while (i4 < length) {
                floatBuffer.put(i3, ((iArr[i4] >> 8) & 255) * 0.003921569f);
                i4++;
                i3++;
            }
            while (i < length) {
                int i5 = i3 + 1;
                floatBuffer.put(i3, (iArr[i] & 255) * 0.003921569f);
                i++;
                i3 = i5;
            }
        } finally {
            bitmapCreateBitmap.recycle();
        }
    }

    private final List<PointF> processSegmentationMask(FloatBuffer detectionData, FloatBuffer maskData, int bestIdx, int numDetections, int imageWidth, int imageHeight, long[] maskShape) {
        float[][] fArr;
        boolean[][] zArr;
        byte[] bArr;
        int i;
        Object obj;
        List<PointF> listEmptyList;
        float[] fArr2 = this.maskCoeffs;
        if (fArr2 != null && (fArr = this.mask) != null && (zArr = this.binaryMask) != null && (bArr = this.rowBuffer) != null) {
            int i2 = 0;
            while (true) {
                i = 32;
                if (i2 >= 32) {
                    break;
                }
                try {
                    detectionData.position(((i2 + 5) * numDetections) + bestIdx);
                    fArr2[i2] = detectionData.get();
                    i2++;
                } catch (Exception e) {
                    e.printStackTrace();
                    return CollectionsKt.emptyList();
                }
                e.printStackTrace();
                return CollectionsKt.emptyList();
            }
            int i3 = (int) maskShape[2];
            int i4 = (int) maskShape[3];
            for (int i5 = 0; i5 < i3; i5++) {
                for (int i6 = 0; i6 < i4; i6++) {
                    fArr[i5][i6] = 0.0f;
                }
            }
            int i7 = 0;
            while (i7 < i3) {
                int i8 = 0;
                while (i8 < i4) {
                    int i9 = 0;
                    while (i9 < i) {
                        maskData.position((i9 * i3 * i4) + (i7 * i4) + i8);
                        float f = maskData.get();
                        float[] fArr3 = fArr[i7];
                        fArr3[i8] = fArr3[i8] + (fArr2[i9] * f);
                        i9++;
                        i = 32;
                    }
                    fArr[i7][i8] = 1.0f / (((float) Math.exp(-r14[i8])) + 1.0f);
                    i8++;
                    i = 32;
                }
                i7++;
                i = 32;
            }
            for (int i10 = 0; i10 < i3; i10++) {
                for (int i11 = 0; i11 < i4; i11++) {
                    zArr[i10][i11] = fArr[i10][i11] > 0.5f;
                }
            }
            Mat mat = new Mat(i3, i4, CvType.CV_8UC1);
            Mat mat2 = new Mat();
            for (int i12 = 0; i12 < i3; i12++) {
                for (int i13 = 0; i13 < i4; i13++) {
                    try {
                        bArr[i13] = zArr[i12][i13] ? (byte) -1 : (byte) 0;
                    } finally {
                        mat.release();
                        mat2.release();
                    }
                }
                mat.put(i12, 0, bArr);
            }
            Imgproc.threshold(mat, mat2, 127.5d, 255.0d, 0);
            if (CombinedAnalyzerKt.getDEBUG_VIEWFINDER()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, i3, Bitmap.Config.ARGB_8888);
                Mat mat3 = new Mat();
                try {
                    Imgproc.cvtColor(mat2, mat3, 9);
                    Utils.matToBitmap(mat3, bitmapCreateBitmap);
                    Bitmap bitmap = this.debugMaskBitmap;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    this.debugMaskBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, imageWidth, imageHeight, true);
                    mat3.release();
                    bitmapCreateBitmap.recycle();
                } catch (Throwable th) {
                    mat3.release();
                    bitmapCreateBitmap.recycle();
                    throw th;
                }
            }
            Mat mat4 = new Mat();
            Mat mat5 = new Mat();
            try {
                Imgproc.resize(mat2, mat4, new Size(imageWidth, imageHeight));
                ArrayList arrayList = new ArrayList();
                Imgproc.findContours(mat4, arrayList, mat5, 0, 2);
                if (arrayList.isEmpty()) {
                    listEmptyList = CollectionsKt.emptyList();
                    mat4.release();
                    mat5.release();
                } else {
                    Iterator it = arrayList.iterator();
                    if (it.hasNext()) {
                        Object next = it.next();
                        if (it.hasNext()) {
                            double dContourArea = Imgproc.contourArea((MatOfPoint) next);
                            do {
                                Object next2 = it.next();
                                double dContourArea2 = Imgproc.contourArea((MatOfPoint) next2);
                                if (Double.compare(dContourArea, dContourArea2) < 0) {
                                    next = next2;
                                    dContourArea = dContourArea2;
                                }
                            } while (it.hasNext());
                        }
                        obj = next;
                    } else {
                        obj = null;
                    }
                    MatOfPoint matOfPoint = (MatOfPoint) obj;
                    if (matOfPoint != null) {
                        MatOfPoint2f matOfPoint2f = new MatOfPoint2f();
                        MatOfPoint2f matOfPoint2f2 = new MatOfPoint2f();
                        try {
                            matOfPoint.convertTo(matOfPoint2f, CvType.CV_32FC2);
                            Imgproc.approxPolyDP(matOfPoint2f, matOfPoint2f2, Imgproc.arcLength(matOfPoint2f, true) * 0.01d, true);
                            Point[] array = matOfPoint2f2.toArray();
                            Intrinsics.checkNotNull(array);
                            ArrayList arrayList2 = new ArrayList(array.length);
                            for (Point point : array) {
                                arrayList2.add(new PointF((float) point.x, (float) point.y));
                            }
                            ArrayList arrayList3 = arrayList2;
                            matOfPoint2f.release();
                            matOfPoint2f2.release();
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                ((MatOfPoint) it2.next()).release();
                            }
                            return arrayList3;
                        } catch (Throwable th2) {
                            matOfPoint2f.release();
                            matOfPoint2f2.release();
                            Iterator it3 = arrayList.iterator();
                            while (it3.hasNext()) {
                                ((MatOfPoint) it3.next()).release();
                            }
                            throw th2;
                        }
                    }
                    listEmptyList = CollectionsKt.emptyList();
                }
                return listEmptyList;
            } finally {
                mat4.release();
                mat5.release();
            }
        }
        return CollectionsKt.emptyList();
    }

    public final void close() throws OrtException {
        OrtSession ortSession = this.ortSession;
        if (ortSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ortSession");
            ortSession = null;
        }
        ortSession.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CardSegmentation detectCard(Bitmap bitmap, int rotationDegrees) {
        FloatBuffer floatBuffer;
        CardSegmentation cardSegmentation;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        try {
            if (!this.isReady || this.ortSession == null || this.ortEnvironment == null || (floatBuffer = this.inputBuffer) == null) {
                return null;
            }
            preprocessImage(bitmap, rotationDegrees);
            floatBuffer.rewind();
            OrtSession.Result resultCreateTensor = OnnxTensor.createTensor(this.ortEnvironment, floatBuffer, new long[]{1, 3, 480, 480});
            try {
                Map<String, ? extends OnnxTensorLike> mapMapOf = MapsKt.mapOf(TuplesKt.to("images", resultCreateTensor));
                OrtSession ortSession = this.ortSession;
                if (ortSession == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ortSession");
                    ortSession = null;
                }
                resultCreateTensor = ortSession.run(mapMapOf);
                try {
                    OrtSession.Result result = resultCreateTensor;
                    OnnxValue onnxValue = result.get(0);
                    Intrinsics.checkNotNull(onnxValue, "null cannot be cast to non-null type ai.onnxruntime.OnnxTensor");
                    OnnxTensor onnxTensor = (OnnxTensor) onnxValue;
                    OnnxValue onnxValue2 = result.get(1);
                    Intrinsics.checkNotNull(onnxValue2, "null cannot be cast to non-null type ai.onnxruntime.OnnxTensor");
                    OnnxTensor onnxTensor2 = (OnnxTensor) onnxValue2;
                    FloatBuffer floatBuffer2 = onnxTensor.getFloatBuffer();
                    int i = (int) onnxTensor.getInfo().getShape()[2];
                    float[] fArr = this.confidences;
                    if (fArr == null) {
                        cardSegmentation = null;
                    } else {
                        floatBuffer2.position(i * 4);
                        floatBuffer2.get(fArr, 0, i);
                        int i2 = -1;
                        float f = 0.0f;
                        for (int i3 = 0; i3 < i; i3++) {
                            float fExp = 1.0f / (((float) Math.exp(-fArr[i3])) + 1.0f);
                            if (fExp > f) {
                                i2 = i3;
                                f = fExp;
                            }
                        }
                        if (i2 >= 0 && f >= 0.5f) {
                            floatBuffer2.position(0);
                            floatBuffer2.get(i2);
                            floatBuffer2.position(i);
                            floatBuffer2.get(i2);
                            floatBuffer2.position(i * 2);
                            floatBuffer2.get(i2);
                            floatBuffer2.position(i * 3);
                            floatBuffer2.get(i2);
                            Intrinsics.checkNotNull(floatBuffer2);
                            FloatBuffer floatBuffer3 = onnxTensor2.getFloatBuffer();
                            Intrinsics.checkNotNullExpressionValue(floatBuffer3, "getFloatBuffer(...)");
                            long[] shape = onnxTensor2.getInfo().getShape();
                            Intrinsics.checkNotNullExpressionValue(shape, "getShape(...)");
                            List<PointF> listProcessSegmentationMask = processSegmentationMask(floatBuffer2, floatBuffer3, i2, i, 480, 480, shape);
                            if (!listProcessSegmentationMask.isEmpty() && isValidCardShape(listProcessSegmentationMask)) {
                                cardSegmentation = new CardSegmentation(f, listProcessSegmentationMask, getCardCorners(listProcessSegmentationMask), extractCardFromPolygon(bitmap, listProcessSegmentationMask, rotationDegrees), null, "", 0L, null, null, null, null, 1920, null);
                            }
                        }
                    }
                    AutoCloseableKt.closeFinally(resultCreateTensor, null);
                    AutoCloseableKt.closeFinally(resultCreateTensor, null);
                    return cardSegmentation;
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Bitmap getDebugMaskBitmap() {
        return this.debugMaskBitmap;
    }

    public final Bitmap getDebugPreprocessedBitmap() {
        return this.debugPreprocessedBitmap;
    }

    public final String getInitializationError() {
        return this.initializationError;
    }

    /* JADX INFO: renamed from: isReady, reason: from getter */
    public final boolean getIsReady() {
        return this.isReady;
    }
}
