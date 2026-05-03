package com.studiolaganne.lengendarylens;

import android.graphics.Bitmap;
import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: MTGBorderColorDetector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGBorderColorDetector;", "", "<init>", "()V", "detectBorderColor", "Lcom/studiolaganne/lengendarylens/BorderColorResult;", "cardBitmap", "Landroid/graphics/Bitmap;", "createBorderMask", "", "width", "", "height", "mask", "Lorg/opencv/core/Mat;", "classifyBorderColor", "Lkotlin/Pair;", "Lcom/studiolaganne/lengendarylens/BorderColor;", "", "brightness", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTGBorderColorDetector {
    public static final int $stable = 0;
    private static final float BLACK_WHITE_BOUNDARY = 100.0f;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Mat hsvMat;
    private static Mat mask;
    private static Mat rgbMat;
    private static Mat rgbaMat;

    /* JADX INFO: compiled from: MTGBorderColorDetector.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGBorderColorDetector$Companion;", "", "<init>", "()V", "BLACK_WHITE_BOUNDARY", "", "rgbaMat", "Lorg/opencv/core/Mat;", "rgbMat", "hsvMat", "mask", "cleanup", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void cleanup() {
            Mat mat = MTGBorderColorDetector.rgbaMat;
            if (mat != null) {
                mat.release();
            }
            Mat mat2 = MTGBorderColorDetector.rgbMat;
            if (mat2 != null) {
                mat2.release();
            }
            Mat mat3 = MTGBorderColorDetector.hsvMat;
            if (mat3 != null) {
                mat3.release();
            }
            Mat mat4 = MTGBorderColorDetector.mask;
            if (mat4 != null) {
                mat4.release();
            }
            MTGBorderColorDetector.rgbaMat = null;
            MTGBorderColorDetector.rgbMat = null;
            MTGBorderColorDetector.hsvMat = null;
            MTGBorderColorDetector.mask = null;
        }
    }

    private final Pair<BorderColor, Float> classifyBorderColor(float brightness) {
        if (brightness < BLACK_WHITE_BOUNDARY) {
            return new Pair<>(BorderColor.BLACK, Float.valueOf(RangesKt.coerceIn((BLACK_WHITE_BOUNDARY - brightness) / BLACK_WHITE_BOUNDARY, 0.0f, 1.0f)));
        }
        return new Pair<>(BorderColor.WHITE, Float.valueOf(RangesKt.coerceIn((brightness - BLACK_WHITE_BOUNDARY) / 155.0f, 0.0f, 1.0f)));
    }

    private final void createBorderMask(int width, int height, Mat mask2) {
        mask2.setTo(new Scalar(AudioStats.AUDIO_AMPLITUDE_NONE));
        double d = width;
        int iCoerceAtMost = RangesKt.coerceAtMost(RangesKt.coerceAtLeast((int) (0.04d * d), 8), 40);
        int i = (int) (d * 0.02d);
        int i2 = (int) (((double) height) * 0.5d);
        int i3 = height - i2;
        Imgproc.rectangle(mask2, new Rect(i, i2, iCoerceAtMost, i3), new Scalar(255.0d), -1);
        Imgproc.rectangle(mask2, new Rect((width - iCoerceAtMost) - i, i2, iCoerceAtMost, i3), new Scalar(255.0d), -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0025 A[Catch: Exception -> 0x00b4, TryCatch #0 {Exception -> 0x00b4, blocks: (B:3:0x0005, B:5:0x0011, B:7:0x001a, B:10:0x004d, B:9:0x0025), top: B:14:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final BorderColorResult detectBorderColor(Bitmap cardBitmap) {
        Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
        try {
            int width = cardBitmap.getWidth();
            int height = cardBitmap.getHeight();
            Mat mat = rgbaMat;
            if (mat != null) {
                Intrinsics.checkNotNull(mat);
                if (mat.rows() == height) {
                    Mat mat2 = rgbaMat;
                    Intrinsics.checkNotNull(mat2);
                    if (mat2.cols() != width) {
                        INSTANCE.cleanup();
                        rgbaMat = new Mat(height, width, CvType.CV_8UC4);
                        rgbMat = new Mat(height, width, CvType.CV_8UC3);
                        hsvMat = new Mat(height, width, CvType.CV_8UC3);
                        mask = Mat.zeros(height, width, CvType.CV_8UC1);
                    }
                }
            }
            Mat mat3 = rgbaMat;
            Intrinsics.checkNotNull(mat3);
            Utils.bitmapToMat(cardBitmap, mat3);
            Mat mat4 = rgbaMat;
            Intrinsics.checkNotNull(mat4);
            Mat mat5 = rgbMat;
            Intrinsics.checkNotNull(mat5);
            Imgproc.cvtColor(mat4, mat5, 1);
            Mat mat6 = mask;
            Intrinsics.checkNotNull(mat6);
            createBorderMask(width, height, mat6);
            Mat mat7 = rgbMat;
            Intrinsics.checkNotNull(mat7);
            Mat mat8 = hsvMat;
            Intrinsics.checkNotNull(mat8);
            Imgproc.cvtColor(mat7, mat8, 41);
            Mat mat9 = hsvMat;
            Intrinsics.checkNotNull(mat9);
            Mat mat10 = mask;
            Intrinsics.checkNotNull(mat10);
            Scalar scalarMean = Core.mean(mat9, mat10);
            float f = (float) scalarMean.val[0];
            float f2 = (float) scalarMean.val[1];
            float f3 = (float) scalarMean.val[2];
            Pair<BorderColor, Float> pairClassifyBorderColor = classifyBorderColor(f3);
            return new BorderColorResult(pairClassifyBorderColor.component1(), pairClassifyBorderColor.component2().floatValue(), f, f2, f3);
        } catch (Exception unused) {
            return new BorderColorResult(BorderColor.UNKNOWN, 0.0f, 0.0f, 0.0f, 0.0f, 28, null);
        }
    }
}
