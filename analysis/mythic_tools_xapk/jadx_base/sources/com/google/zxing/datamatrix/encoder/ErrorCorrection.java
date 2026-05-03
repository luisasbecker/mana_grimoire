package com.google.zxing.datamatrix.encoder;

import androidx.media3.muxer.WebmConstants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.mlkit.common.MlKitException;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videoio;

/* JADX INFO: loaded from: classes5.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, WebmConstants.MkvEbmlElement.BLOCK_MORE, 223, Imgcodecs.IMWRITE_PNG_ALL_FILTERS, 116, 255, Videoio.CAP_PROP_OPENNI2_SYNC, 61}, new int[]{175, 138, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, Imgproc.COLOR_RGBA2YUV_YVYU, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{WebmConstants.MkvEbmlElement.FLAG_LACING, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, WebmConstants.MkvEbmlElement.PIXEL_HEIGHT, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION, 213, 109, 129, 94, 254, WebmConstants.MkvEbmlElement.AUDIO, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, WebmConstants.MkvEbmlElement.BLOCK_GROUP, Imgproc.COLOR_RGBA2YUV_YVYU, 145, 253, 79, 108, 82, 27, WebmConstants.MkvEbmlElement.TRACK_ENTRY, WebmConstants.MkvEbmlElement.PIXEL_HEIGHT, 172}, new int[]{52, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 88, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 109, 39, WebmConstants.MkvEbmlElement.PIXEL_WIDTH, 21, 155, 197, WebmConstants.MkvEbmlElement.REFERENCE_BLOCK, 223, 155, 21, 5, 172, 254, 124, 12, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY, 184, 96, 50, 193}, new int[]{211, WebmConstants.MkvEbmlElement.TIMESTAMP, 43, 97, 71, 96, 103, WebmConstants.MkvEbmlElement.TRACK_ENTRY, 37, 151, 170, 53, 75, 34, 249, Imgproc.COLOR_YUV2RGBA_YVYU, 17, 138, Videoio.CAP_PROP_OPENNI2_SYNC, 213, 141, 136, 120, 151, 233, 168, 93, 255}, new int[]{245, 127, 242, 218, 130, 250, 162, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY, 102, 120, 84, WebmConstants.MkvEbmlElement.CUE_TIME, 220, WebmConstants.MkvEbmlElement.REFERENCE_BLOCK, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, WebmConstants.MkvEbmlElement.AUDIO, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, Imgproc.COLOR_RGBA2YUV_YVYU, WebmConstants.MkvEbmlElement.CUE_TRACK, 105, Imgproc.COLOR_YUV2BGRA_YVYU, 2, 245, Imgproc.COLOR_RGBA2YUV_YV12, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, Imgproc.COLOR_YUV2RGBA_YVYU, 21, 1, 253, 57, 54, 101, Imgcodecs.IMWRITE_PNG_ALL_FILTERS, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, Imgproc.COLOR_BGR2YUV_YV12, 172, 223, 96, 32, Imgproc.COLOR_YUV2RGB_YVYU, 22, WebmConstants.MkvEbmlElement.BLOCK_ADD_ID, Imgproc.COLOR_RGBA2YUV_YV12, WebmConstants.MkvEbmlElement.BLOCK_ADD_ID, WebmConstants.MkvEbmlElement.TIMESTAMP, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 188, 237, 87, 191, 106, 16, 147, Imgproc.COLOR_YUV2BGR_YVYU, 23, 37, 90, 170, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 131, 88, 120, 100, 66, 138, WebmConstants.MkvEbmlElement.PIXEL_HEIGHT, 240, 82, 44, WebmConstants.MkvEbmlElement.PIXEL_WIDTH, 87, WebmConstants.MkvEbmlElement.CUE_POINT, 147, WebmConstants.MkvEbmlElement.BLOCK_GROUP, 175, 69, 213, 92, 253, WebmConstants.MkvEbmlElement.AUDIO, 19}, new int[]{175, 9, 223, WebmConstants.MkvEbmlElement.BLOCK_ADD_ID, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, WebmConstants.MkvEbmlElement.TRACK_NUMBER, 235, 150, WebmConstants.MkvEbmlElement.CHANNELS, 36, 223, 38, 200, Imgproc.COLOR_BGR2YUV_YV12, 54, 228, 146, 218, 234, Imgproc.COLOR_YUV2RGB_YVYU, 203, 29, 232, 144, WebmConstants.MkvEbmlElement.BLOCK_ADD_ID, 22, 150, 201, Imgproc.COLOR_YUV2RGB_YVYU, 62, 207, 164, 13, 137, 245, 127, 67, WebmConstants.MkvEbmlElement.CUE_TRACK, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, Imgproc.COLOR_YUV2BGR_YVYU, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 250, 106, 185, 221, 175, 64, 114, 71, WebmConstants.MkvEbmlElement.BLOCK, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, WebmConstants.MkvEbmlElement.SIMPLE_BLOCK, 31, WebmConstants.MkvEbmlElement.PIXEL_WIDTH, 170, 4, 107, 232, 7, 94, WebmConstants.MkvEbmlElement.BLOCK_MORE, WebmConstants.MkvEbmlElement.VIDEO, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, WebmConstants.MkvEbmlElement.REFERENCE_BLOCK, Imgproc.COLOR_RGB2YUV_YVYU, WebmConstants.MkvEbmlElement.CHANNELS, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, Imgcodecs.IMWRITE_PNG_ALL_FILTERS, SensibleDefaults.X_OFFSET, 234, 197, 158, 177, 68, Imgproc.COLOR_YUV2BGRA_YVYU, 93, 213, 15, WebmConstants.MkvEbmlElement.BLOCK_GROUP, 227, WebmConstants.MkvEbmlElement.VOID, 66, 139, Imgproc.COLOR_RGBA2YUV_YVYU, 185, 202, 167, WebmConstants.MkvEbmlElement.CUE_TIME, 25, 220, 232, 96, 210, WebmConstants.MkvEbmlElement.TIMESTAMP, 136, 223, 239, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY, WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, Imgproc.COLOR_RGBA2YUV_YVYU, Imgproc.COLOR_BGR2YUV_YV12, 63, 96, 103, 82, WebmConstants.MkvEbmlElement.PIXEL_HEIGHT}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i *= 2;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        int i2;
        int i3;
        int i4 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i4 >= iArr.length) {
                i4 = -1;
                break;
            }
            if (iArr[i4] == i) {
                break;
            }
            i4++;
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i);
        }
        int[] iArr2 = FACTORS[i4];
        char[] cArr = new char[i];
        for (int i5 = 0; i5 < i; i5++) {
            cArr[i5] = 0;
        }
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            int i7 = i - 1;
            int iCharAt = cArr[i7] ^ charSequence.charAt(i6);
            while (i7 > 0) {
                if (iCharAt == 0 || (i3 = iArr2[i7]) == 0) {
                    cArr[i7] = cArr[i7 - 1];
                } else {
                    char c = cArr[i7 - 1];
                    int[] iArr3 = ALOG;
                    int[] iArr4 = LOG;
                    cArr[i7] = (char) (iArr3[(iArr4[iCharAt] + iArr4[i3]) % 255] ^ c);
                }
                i7--;
            }
            if (iCharAt == 0 || (i2 = iArr2[0]) == 0) {
                cArr[0] = 0;
            } else {
                int[] iArr5 = ALOG;
                int[] iArr6 = LOG;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[i2]) % 255];
            }
        }
        char[] cArr2 = new char[i];
        for (int i8 = 0; i8 < i; i8++) {
            cArr2[i8] = cArr[(i - i8) - 1];
        }
        return String.valueOf(cArr2);
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int i = 0;
            while (i < interleavedBlockCount) {
                int i2 = i + 1;
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                i = i2;
            }
            for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                    sb2.append(str.charAt(i4));
                }
                String strCreateECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                int i5 = 0;
                int i6 = i3;
                while (i6 < iArr2[i3] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i6, strCreateECCBlock.charAt(i5));
                    i6 += interleavedBlockCount;
                    i5++;
                }
            }
        }
        return sb.toString();
    }
}
