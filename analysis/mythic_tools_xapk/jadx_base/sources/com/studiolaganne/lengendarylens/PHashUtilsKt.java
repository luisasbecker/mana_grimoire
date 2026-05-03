package com.studiolaganne.lengendarylens;

import android.graphics.Bitmap;
import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.UStringsKt;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: pHashUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005\u001a\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e\u001a\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e\u001a\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e¨\u0006\u0015"}, d2 = {"median", "", "mat", "Lorg/opencv/core/Mat;", "computePhash", "", "bitmap", "Landroid/graphics/Bitmap;", "weightedHammingDistance", "hash1", "hash2", "hammingDistance", "", "hexPhash1", "", "hexPhash2", "levenshteinDistance", "a", "b", "levenshteinScore", "", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PHashUtilsKt {
    public static final long computePhash(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Mat mat = new Mat();
        Utils.bitmapToMat(bitmap, mat);
        Mat mat2 = new Mat(32, 32, CvType.CV_8UC3);
        Imgproc.resize(mat, mat2, new Size(32.0d, 32.0d), AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 1);
        Mat mat3 = new Mat();
        Imgproc.cvtColor(mat2, mat3, 6);
        Mat mat4 = new Mat();
        mat3.convertTo(mat4, CvType.CV_32FC1);
        Mat mat5 = new Mat();
        Core.dct(mat4, mat5);
        Mat mat6 = new Mat(8, 8, CvType.CV_32FC1);
        mat5.submat(0, 8, 0, 8).copyTo(mat6);
        int i = (int) (Core.sumElems(mat6).val[0] / 64.0d);
        Mat mat7 = new Mat();
        mat6.convertTo(mat7, 4);
        long j = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                if (((int) mat7.get(i2, i3)[0]) > i) {
                    j |= 1 << (63 - ((i2 * 8) + i3));
                }
            }
        }
        return j;
    }

    public static final int hammingDistance(String hexPhash1, String hexPhash2) {
        Intrinsics.checkNotNullParameter(hexPhash1, "hexPhash1");
        Intrinsics.checkNotNullParameter(hexPhash2, "hexPhash2");
        if (hexPhash1.length() == 0 || hexPhash2.length() == 0) {
            return 64;
        }
        String strSubstring = hexPhash1.substring(2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = hexPhash2.substring(2);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return Long.bitCount(UStringsKt.toULong(strSubstring2, 16) ^ UStringsKt.toULong(strSubstring, 16));
    }

    public static final int levenshteinDistance(String a2, String b) {
        int iMin;
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        int length = a2.length() + 1;
        int[][] iArr = new int[length][];
        for (int i = 0; i < length; i++) {
            iArr[i] = new int[b.length() + 1];
        }
        int length2 = a2.length();
        if (length2 >= 0) {
            int i2 = 0;
            while (true) {
                int length3 = b.length();
                if (length3 >= 0) {
                    int i3 = 0;
                    while (true) {
                        if (i2 == 0) {
                            iArr[i2][i3] = i3;
                        } else if (i3 == 0) {
                            iArr[i2][i3] = i2;
                        } else {
                            int[] iArr2 = iArr[i2];
                            int i4 = i2 - 1;
                            int i5 = i3 - 1;
                            if (a2.charAt(i4) == b.charAt(i5)) {
                                iMin = iArr[i4][i5];
                            } else {
                                int[] iArr3 = iArr[i4];
                                iMin = Math.min(iArr3[i3], Math.min(iArr[i2][i5], iArr3[i5])) + 1;
                            }
                            iArr2[i3] = iMin;
                        }
                        if (i3 == length3) {
                            break;
                        }
                        i3++;
                    }
                }
                if (i2 == length2) {
                    break;
                }
                i2++;
            }
        }
        return iArr[a2.length()][b.length()];
    }

    public static final float levenshteinScore(String a2, String b) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        if (a2.length() == 0 || b.length() == 0) {
            return 0.0f;
        }
        return RangesKt.coerceIn(1.0f - (levenshteinDistance(a2, b) / Math.max(a2.length(), b.length())), 0.0f, 1.0f);
    }

    private static final double median(Mat mat) {
        ArrayList arrayList = new ArrayList();
        int iRows = mat.rows();
        for (int i = 0; i < iRows; i++) {
            int iCols = mat.cols();
            for (int i2 = 0; i2 < iCols; i2++) {
                arrayList.add(Double.valueOf(mat.get(i, i2)[0]));
            }
        }
        CollectionsKt.sort(arrayList);
        int size = arrayList.size() / 2;
        return arrayList.size() % 2 == 0 ? (((Number) arrayList.get(size - 1)).doubleValue() + ((Number) arrayList.get(size)).doubleValue()) / 2.0d : ((Number) arrayList.get(size)).doubleValue();
    }

    public static final double weightedHammingDistance(long j, long j2) {
        long j3 = j ^ j2;
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        int i = 0;
        while (i < 64) {
            d += ((j3 >> i) & 1) * (i < 16 ? 2.0d : i < 32 ? 1.5d : i < 48 ? 1.0d : 0.5d);
            i++;
        }
        return d;
    }
}
