package androidx.camera.video;

import android.util.Size;
import androidx.media3.common.PlaybackException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.opencv.imgcodecs.Imgcodecs;

/* JADX INFO: loaded from: classes.dex */
public class Quality {
    public static final Quality FHD;
    public static final Quality HD;
    public static final Quality HIGHEST;
    public static final Quality LOWEST;
    static final Quality NONE;
    private static final Set<Quality> QUALITIES;
    private static final List<Quality> QUALITIES_ORDER_BY_SIZE;
    public static final int QUALITY_SOURCE_HIGH_SPEED = 2;
    public static final int QUALITY_SOURCE_REGULAR = 1;
    public static final Quality SD;
    public static final Quality UHD;

    public static abstract class ConstantQuality extends Quality {
        public ConstantQuality() {
            super();
        }

        static ConstantQuality of(int i, int i2, String str, List<Size> list) {
            return new AutoValue_Quality_ConstantQuality(i, i2, str, list);
        }

        abstract int getHighSpeedValue();

        public abstract String getName();

        public int getQualityValue(int i) {
            if (i == 1) {
                return getValue();
            }
            if (i == 2) {
                return getHighSpeedValue();
            }
            throw new AssertionError("Unknown quality source: " + i);
        }

        public abstract List<Size> getTypicalSizes();

        abstract int getValue();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface QualitySource {
    }

    static {
        ConstantQuality constantQualityOf = ConstantQuality.of(4, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT, "SD", Collections.unmodifiableList(Arrays.asList(new Size(720, 480), new Size(Imgcodecs.IMWRITE_JPEGXL_QUALITY, 480))));
        SD = constantQualityOf;
        ConstantQuality constantQualityOf2 = ConstantQuality.of(5, PlaybackException.ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE, "HD", Collections.singletonList(new Size(1280, 720)));
        HD = constantQualityOf2;
        ConstantQuality constantQualityOf3 = ConstantQuality.of(6, PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS, "FHD", Collections.singletonList(new Size(1920, 1080)));
        FHD = constantQualityOf3;
        ConstantQuality constantQualityOf4 = ConstantQuality.of(8, PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND, "UHD", Collections.singletonList(new Size(3840, 2160)));
        UHD = constantQualityOf4;
        ConstantQuality constantQualityOf5 = ConstantQuality.of(0, 2000, "LOWEST", Collections.emptyList());
        LOWEST = constantQualityOf5;
        ConstantQuality constantQualityOf6 = ConstantQuality.of(1, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED, "HIGHEST", Collections.emptyList());
        HIGHEST = constantQualityOf6;
        NONE = ConstantQuality.of(-1, -1, "NONE", Collections.emptyList());
        QUALITIES = new HashSet(Arrays.asList(constantQualityOf5, constantQualityOf6, constantQualityOf, constantQualityOf2, constantQualityOf3, constantQualityOf4));
        QUALITIES_ORDER_BY_SIZE = Arrays.asList(constantQualityOf4, constantQualityOf3, constantQualityOf2, constantQualityOf);
    }

    private Quality() {
    }

    static boolean containsQuality(Quality quality) {
        return QUALITIES.contains(quality);
    }

    public static List<Quality> getSortedQualities() {
        return new ArrayList(QUALITIES_ORDER_BY_SIZE);
    }
}
