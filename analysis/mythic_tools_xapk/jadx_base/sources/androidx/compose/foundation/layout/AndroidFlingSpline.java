package androidx.compose.foundation.layout;

import androidx.media3.muxer.MuxerUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline;", "", "<init>", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "flingPosition", "Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "time", "", "flingPosition-LfoxSSI", "(F)J", "deceleration", "", "velocity", "friction", "FlingResult", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidFlingSpline {
    private static final int NbSamples = 100;
    public static final AndroidFlingSpline INSTANCE = new AndroidFlingSpline();
    private static final float[] SplinePositions = new float[101];
    private static final float[] SplineTimes = new float[101];

    /* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "", "packedValue", "", "constructor-impl", "(J)J", "distanceCoefficient", "", "getDistanceCoefficient-impl", "(J)F", "velocityCoefficient", "getVelocityCoefficient-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class FlingResult {
        private final long packedValue;

        private /* synthetic */ FlingResult(long j) {
            this.packedValue = j;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ FlingResult m1898boximpl(long j) {
            return new FlingResult(j);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m1899constructorimpl(long j) {
            return j;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m1900equalsimpl(long j, Object obj) {
            return (obj instanceof FlingResult) && j == ((FlingResult) obj).getPackedValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m1901equalsimpl0(long j, long j2) {
            return j == j2;
        }

        /* JADX INFO: renamed from: getDistanceCoefficient-impl, reason: not valid java name */
        public static final float m1902getDistanceCoefficientimpl(long j) {
            return Float.intBitsToFloat((int) (j >> 32));
        }

        /* JADX INFO: renamed from: getVelocityCoefficient-impl, reason: not valid java name */
        public static final float m1903getVelocityCoefficientimpl(long j) {
            return Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m1904hashCodeimpl(long j) {
            return Long.hashCode(j);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m1905toStringimpl(long j) {
            return "FlingResult(packedValue=" + j + ')';
        }

        public boolean equals(Object obj) {
            return m1900equalsimpl(this.packedValue, obj);
        }

        public int hashCode() {
            return m1904hashCodeimpl(this.packedValue);
        }

        public String toString() {
            return m1905toStringimpl(this.packedValue);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ long getPackedValue() {
            return this.packedValue;
        }
    }

    static {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10 = 0.0f;
        int i = 0;
        float f11 = 0.0f;
        while (true) {
            float f12 = 1.0f;
            if (i >= 100) {
                SplineTimes[100] = 1.0f;
                SplinePositions[100] = 1.0f;
                return;
            }
            float f13 = i / 100.0f;
            float f14 = 1.0f;
            while (true) {
                f = ((f14 - f10) / 2.0f) + f10;
                f2 = f12 - f;
                f3 = f * 3.0f * f2;
                f4 = f * f * f;
                float f15 = (((f2 * 0.175f) + (f * 0.35000002f)) * f3) + f4;
                f5 = f12;
                float f16 = f14;
                if (Math.abs(f15 - f13) < 1.0E-5d) {
                    break;
                }
                if (f15 > f13) {
                    f14 = f;
                    f12 = f5;
                } else {
                    f10 = f;
                    f12 = f5;
                    f14 = f16;
                }
            }
            float f17 = 0.5f;
            SplinePositions[i] = (f3 * ((f2 * 0.5f) + f)) + f4;
            float f18 = f5;
            while (true) {
                f6 = ((f18 - f11) / 2.0f) + f11;
                f7 = f5 - f6;
                f8 = f6 * 3.0f * f7;
                f9 = f6 * f6 * f6;
                float f19 = (((f7 * f17) + f6) * f8) + f9;
                if (Math.abs(f19 - f13) >= 1.0E-5d) {
                    if (f19 > f13) {
                        f18 = f6;
                    } else {
                        f11 = f6;
                    }
                    f17 = 0.5f;
                }
            }
            SplineTimes[i] = (f8 * ((f7 * 0.175f) + (f6 * 0.35000002f))) + f9;
            i++;
        }
    }

    private AndroidFlingSpline() {
    }

    public final double deceleration(float velocity, float friction) {
        return Math.log(((double) (Math.abs(velocity) * 0.35f)) / ((double) friction));
    }

    /* JADX INFO: renamed from: flingPosition-LfoxSSI, reason: not valid java name */
    public final long m1897flingPositionLfoxSSI(float time) {
        float f;
        float f2;
        int i = (int) (100.0f * time);
        if (i < 100) {
            float f3 = i / 100.0f;
            int i2 = i + 1;
            float[] fArr = SplinePositions;
            float f4 = fArr[i];
            f2 = (fArr[i2] - f4) / ((i2 / 100.0f) - f3);
            f = f4 + ((time - f3) * f2);
        } else {
            f = 1.0f;
            f2 = 0.0f;
        }
        return FlingResult.m1899constructorimpl((((long) Float.floatToRawIntBits(f2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(f) << 32));
    }
}
