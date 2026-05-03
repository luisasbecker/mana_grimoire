package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Cubic.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ?2\u00020\u0001:\u0001?B7\b\u0010\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0007\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\bB\u0011\b\u0000\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ!\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J\u0011\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\rH\u0086\u0002J\u0011\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(H\u0086\u0002J\u0013\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010+\u001a\u00020(H\u0016J\u0011\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0000H\u0086\u0002J!\u0010.\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010/\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J\u0006\u00102\u001a\u00020\u0000J\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000042\u0006\u0010/\u001a\u00020\rJ\u0011\u00105\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\rH\u0086\u0002J\u0011\u00105\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(H\u0086\u0002J\b\u00106\u001a\u000207H\u0016J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\rH\u0002J\r\u0010=\u001a\u00020$H\u0000¢\u0006\u0002\b>R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\u001a\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000fR\u0011\u0010\u001c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000fR\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006@"}, d2 = {"Landroidx/graphics/shapes/Cubic;", "", "anchor0", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "control0", "control1", "anchor1", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "points", "", "([F)V", "anchor0X", "", "getAnchor0X", "()F", "anchor0Y", "getAnchor0Y", "anchor1X", "getAnchor1X", "anchor1Y", "getAnchor1Y", "control0X", "getControl0X", "control0Y", "getControl0Y", "control1X", "getControl1X", "control1Y", "getControl1Y", "getPoints$graphics_shapes_release", "()[F", "calculateBounds", "", "bounds", "approximate", "", "calculateBounds$graphics_shapes_release", "div", "x", "", "equals", "other", "hashCode", "plus", "o", "pointOnCurve", "t", "pointOnCurve-OOQOV4g$graphics_shapes_release", "(F)J", "reverse", "split", "Lkotlin/Pair;", "times", InAppPurchaseConstants.METHOD_TO_STRING, "", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "zeroIsh", "value", "zeroLength", "zeroLength$graphics_shapes_release", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class Cubic {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float[] points;

    /* JADX INFO: compiled from: Cubic.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J(\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Landroidx/graphics/shapes/Cubic$Companion;", "", "()V", "circularArc", "Landroidx/graphics/shapes/Cubic;", "centerX", "", "centerY", "x0", "y0", "x1", "y1", "straightLine", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Cubic circularArc(float centerX, float centerY, float x0, float y0, float x1, float y1) {
            float f = x0 - centerX;
            float f2 = y0 - centerY;
            long jDirectionVector = Utils.directionVector(f, f2);
            float f3 = x1 - centerX;
            float f4 = y1 - centerY;
            long jDirectionVector2 = Utils.directionVector(f3, f4);
            long jM9716rotate90DnnuFBc = Utils.m9716rotate90DnnuFBc(jDirectionVector);
            long jM9716rotate90DnnuFBc2 = Utils.m9716rotate90DnnuFBc(jDirectionVector2);
            boolean z = PointKt.m9690dotProduct5P9i7ZU(jM9716rotate90DnnuFBc, f3, f4) >= 0.0f;
            float fM9691dotProductybeJwSQ = PointKt.m9691dotProductybeJwSQ(jDirectionVector, jDirectionVector2);
            if (fM9691dotProductybeJwSQ > 0.999f) {
                return straightLine(x0, y0, x1, y1);
            }
            float fDistance = ((((Utils.distance(f, f2) * 4.0f) / 3.0f) * (((float) Math.sqrt(2.0f * r5)) - ((float) Math.sqrt(1.0f - (fM9691dotProductybeJwSQ * fM9691dotProductybeJwSQ))))) / (1.0f - fM9691dotProductybeJwSQ)) * (z ? 1.0f : -1.0f);
            return CubicKt.Cubic(x0, y0, (PointKt.m9695getXDnnuFBc(jM9716rotate90DnnuFBc) * fDistance) + x0, (PointKt.m9696getYDnnuFBc(jM9716rotate90DnnuFBc) * fDistance) + y0, x1 - (PointKt.m9695getXDnnuFBc(jM9716rotate90DnnuFBc2) * fDistance), y1 - (PointKt.m9696getYDnnuFBc(jM9716rotate90DnnuFBc2) * fDistance), x1, y1);
        }

        @JvmStatic
        public final Cubic straightLine(float x0, float y0, float x1, float y1) {
            return CubicKt.Cubic(x0, y0, Utils.interpolate(x0, x1, 0.33333334f), Utils.interpolate(y0, y1, 0.33333334f), Utils.interpolate(x0, x1, 0.6666667f), Utils.interpolate(y0, y1, 0.6666667f), x1, y1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Cubic() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private Cubic(long j, long j2, long j3, long j4) {
        this(new float[]{PointKt.m9695getXDnnuFBc(j), PointKt.m9696getYDnnuFBc(j), PointKt.m9695getXDnnuFBc(j2), PointKt.m9696getYDnnuFBc(j2), PointKt.m9695getXDnnuFBc(j3), PointKt.m9696getYDnnuFBc(j3), PointKt.m9695getXDnnuFBc(j4), PointKt.m9696getYDnnuFBc(j4)});
    }

    public /* synthetic */ Cubic(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    public Cubic(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        this.points = points;
        if (points.length != 8) {
            throw new IllegalArgumentException("Points array size should be 8".toString());
        }
    }

    public /* synthetic */ Cubic(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new float[8] : fArr);
    }

    public static /* synthetic */ void calculateBounds$graphics_shapes_release$default(Cubic cubic, float[] fArr, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateBounds");
        }
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        if ((i & 2) != 0) {
            z = false;
        }
        cubic.calculateBounds$graphics_shapes_release(fArr, z);
    }

    @JvmStatic
    public static final Cubic circularArc(float f, float f2, float f3, float f4, float f5, float f6) {
        return INSTANCE.circularArc(f, f2, f3, f4, f5, f6);
    }

    @JvmStatic
    public static final Cubic straightLine(float f, float f2, float f3, float f4) {
        return INSTANCE.straightLine(f, f2, f3, f4);
    }

    private final boolean zeroIsh(float value) {
        return Math.abs(value) < 1.0E-4f;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c9 A[PHI: r0 r7
      0x01c9: PHI (r0v2 float) = (r0v1 float), (r0v3 float) binds: [B:83:0x0216, B:61:0x01c7] A[DONT_GENERATE, DONT_INLINE]
      0x01c9: PHI (r7v9 float) = (r7v4 float), (r7v10 float) binds: [B:83:0x0216, B:61:0x01c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void calculateBounds$graphics_shapes_release(float[] bounds, boolean approximate) {
        char c;
        char c2;
        char c3;
        char c4;
        float control0Y;
        float fM9696getYDnnuFBc;
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (zeroLength$graphics_shapes_release()) {
            bounds[0] = getAnchor0X();
            bounds[1] = getAnchor0Y();
            bounds[2] = getAnchor0X();
            bounds[3] = getAnchor0Y();
            return;
        }
        float fMin = Math.min(getAnchor0X(), getAnchor1X());
        float fMin2 = Math.min(getAnchor0Y(), getAnchor1Y());
        float fMax = Math.max(getAnchor0X(), getAnchor1X());
        float fMax2 = Math.max(getAnchor0Y(), getAnchor1Y());
        if (approximate) {
            bounds[0] = Math.min(fMin, Math.min(getControl0X(), getControl1X()));
            bounds[1] = Math.min(fMin2, Math.min(getControl0Y(), getControl1Y()));
            bounds[2] = Math.max(fMax, Math.max(getControl0X(), getControl1X()));
            bounds[3] = Math.max(fMax2, Math.max(getControl0Y(), getControl1Y()));
            return;
        }
        float control0X = (((-getAnchor0X()) + (getControl0X() * 3.0f)) - (getControl1X() * 3.0f)) + getAnchor1X();
        float anchor0X = ((getAnchor0X() * 2.0f) - (getControl0X() * 4.0f)) + (getControl1X() * 2.0f);
        float control0X2 = (-getAnchor0X()) + getControl0X();
        if (!zeroIsh(control0X)) {
            float f = (anchor0X * anchor0X) - ((4.0f * control0X) * control0X2);
            if (f >= 0.0f) {
                float f2 = -anchor0X;
                c = 3;
                c2 = 2;
                double d = f;
                c3 = 1;
                c4 = 0;
                float f3 = control0X * 2.0f;
                float fSqrt = (((float) Math.sqrt(d)) + f2) / f3;
                if (0.0f <= fSqrt && fSqrt <= 1.0f) {
                    float fM9695getXDnnuFBc = PointKt.m9695getXDnnuFBc(m9683pointOnCurveOOQOV4g$graphics_shapes_release(fSqrt));
                    if (fM9695getXDnnuFBc < fMin) {
                        fMin = fM9695getXDnnuFBc;
                    }
                    if (fM9695getXDnnuFBc > fMax) {
                        fMax = fM9695getXDnnuFBc;
                    }
                }
                float fSqrt2 = (f2 - ((float) Math.sqrt(d))) / f3;
                if (0.0f <= fSqrt2 && fSqrt2 <= 1.0f) {
                    float fM9695getXDnnuFBc2 = PointKt.m9695getXDnnuFBc(m9683pointOnCurveOOQOV4g$graphics_shapes_release(fSqrt2));
                    if (fM9695getXDnnuFBc2 < fMin) {
                        fMin = fM9695getXDnnuFBc2;
                    }
                    if (fM9695getXDnnuFBc2 > fMax) {
                        fMax = fM9695getXDnnuFBc2;
                    }
                }
            }
            control0Y = (((-getAnchor0Y()) + (getControl0Y() * 3.0f)) - (3.0f * getControl1Y())) + getAnchor1Y();
            float anchor0Y = ((getAnchor0Y() * 2.0f) - (getControl0Y() * 4.0f)) + (getControl1Y() * 2.0f);
            float control0Y2 = (-getAnchor0Y()) + getControl0Y();
            if (zeroIsh(control0Y)) {
                float f4 = (anchor0Y * anchor0Y) - ((4.0f * control0Y) * control0Y2);
                if (f4 >= 0.0f) {
                    float f5 = -anchor0Y;
                    double d2 = f4;
                    float f6 = 2.0f * control0Y;
                    float fSqrt3 = (((float) Math.sqrt(d2)) + f5) / f6;
                    if (0.0f <= fSqrt3 && fSqrt3 <= 1.0f) {
                        float fM9696getYDnnuFBc2 = PointKt.m9696getYDnnuFBc(m9683pointOnCurveOOQOV4g$graphics_shapes_release(fSqrt3));
                        if (fM9696getYDnnuFBc2 < fMin2) {
                            fMin2 = fM9696getYDnnuFBc2;
                        }
                        if (fM9696getYDnnuFBc2 > fMax2) {
                            fMax2 = fM9696getYDnnuFBc2;
                        }
                    }
                    float fSqrt4 = (f5 - ((float) Math.sqrt(d2))) / f6;
                    if (0.0f <= fSqrt4 && fSqrt4 <= 1.0f) {
                        fM9696getYDnnuFBc = PointKt.m9696getYDnnuFBc(m9683pointOnCurveOOQOV4g$graphics_shapes_release(fSqrt4));
                        if (fM9696getYDnnuFBc < fMin2) {
                            fMin2 = fM9696getYDnnuFBc;
                        }
                        if (fM9696getYDnnuFBc > fMax2) {
                        }
                    }
                }
            } else if (anchor0Y != 0.0f) {
                float f7 = (2.0f * control0Y2) / ((-2.0f) * anchor0Y);
                if (0.0f <= f7 && f7 <= 1.0f) {
                    fM9696getYDnnuFBc = PointKt.m9696getYDnnuFBc(m9683pointOnCurveOOQOV4g$graphics_shapes_release(f7));
                    if (fM9696getYDnnuFBc < fMin2) {
                        fMin2 = fM9696getYDnnuFBc;
                    }
                    if (fM9696getYDnnuFBc > fMax2) {
                        fMax2 = fM9696getYDnnuFBc;
                    }
                }
            }
            bounds[c4] = fMin;
            bounds[c3] = fMin2;
            bounds[c2] = fMax;
            bounds[c] = fMax2;
        }
        if (anchor0X != 0.0f) {
            float f8 = (control0X2 * 2.0f) / (anchor0X * (-2.0f));
            if (0.0f <= f8 && f8 <= 1.0f) {
                float fM9695getXDnnuFBc3 = PointKt.m9695getXDnnuFBc(m9683pointOnCurveOOQOV4g$graphics_shapes_release(f8));
                if (fM9695getXDnnuFBc3 < fMin) {
                    fMin = fM9695getXDnnuFBc3;
                }
                if (fM9695getXDnnuFBc3 > fMax) {
                    fMax = fM9695getXDnnuFBc3;
                }
            }
        }
        c = 3;
        c2 = 2;
        c3 = 1;
        c4 = 0;
        control0Y = (((-getAnchor0Y()) + (getControl0Y() * 3.0f)) - (3.0f * getControl1Y())) + getAnchor1Y();
        float anchor0Y2 = ((getAnchor0Y() * 2.0f) - (getControl0Y() * 4.0f)) + (getControl1Y() * 2.0f);
        float control0Y22 = (-getAnchor0Y()) + getControl0Y();
        if (zeroIsh(control0Y)) {
        }
        bounds[c4] = fMin;
        bounds[c3] = fMin2;
        bounds[c2] = fMax;
        bounds[c] = fMax2;
    }

    public final Cubic div(float x) {
        return times(1.0f / x);
    }

    public final Cubic div(int x) {
        return div(x);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Cubic) {
            return Arrays.equals(this.points, ((Cubic) other).points);
        }
        return false;
    }

    public final float getAnchor0X() {
        return this.points[0];
    }

    public final float getAnchor0Y() {
        return this.points[1];
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    public final float getControl0X() {
        return this.points[2];
    }

    public final float getControl0Y() {
        return this.points[3];
    }

    public final float getControl1X() {
        return this.points[4];
    }

    public final float getControl1Y() {
        return this.points[5];
    }

    /* JADX INFO: renamed from: getPoints$graphics_shapes_release, reason: from getter */
    public final float[] getPoints() {
        return this.points;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    public final Cubic plus(Cubic o) {
        Intrinsics.checkNotNullParameter(o, "o");
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = this.points[i] + o.points[i];
        }
        return new Cubic(fArr);
    }

    /* JADX INFO: renamed from: pointOnCurve-OOQOV4g$graphics_shapes_release, reason: not valid java name */
    public final long m9683pointOnCurveOOQOV4g$graphics_shapes_release(float t) {
        float f = 1.0f - t;
        float f2 = f * f * f;
        float f3 = 3.0f * t;
        float f4 = f3 * f * f;
        float f5 = f3 * t * f;
        float f6 = t * t * t;
        return FloatFloatPair.m1231constructorimpl((getAnchor0X() * f2) + (getControl0X() * f4) + (getControl1X() * f5) + (getAnchor1X() * f6), (getAnchor0Y() * f2) + (getControl0Y() * f4) + (getControl1Y() * f5) + (getAnchor1Y() * f6));
    }

    public final Cubic reverse() {
        return CubicKt.Cubic(getAnchor1X(), getAnchor1Y(), getControl1X(), getControl1Y(), getControl0X(), getControl0Y(), getAnchor0X(), getAnchor0Y());
    }

    public final Pair<Cubic, Cubic> split(float t) {
        float f = 1.0f - t;
        long jM9683pointOnCurveOOQOV4g$graphics_shapes_release = m9683pointOnCurveOOQOV4g$graphics_shapes_release(t);
        float f2 = f * f;
        float f3 = 2.0f * f * t;
        float f4 = t * t;
        return TuplesKt.to(CubicKt.Cubic(getAnchor0X(), getAnchor0Y(), (getAnchor0X() * f) + (getControl0X() * t), (getAnchor0Y() * f) + (getControl0Y() * t), (getAnchor0X() * f2) + (getControl0X() * f3) + (getControl1X() * f4), (getAnchor0Y() * f2) + (getControl0Y() * f3) + (getControl1Y() * f4), PointKt.m9695getXDnnuFBc(jM9683pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m9696getYDnnuFBc(jM9683pointOnCurveOOQOV4g$graphics_shapes_release)), CubicKt.Cubic(PointKt.m9695getXDnnuFBc(jM9683pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m9696getYDnnuFBc(jM9683pointOnCurveOOQOV4g$graphics_shapes_release), (getControl0X() * f2) + (getControl1X() * f3) + (getAnchor1X() * f4), (getControl0Y() * f2) + (getControl1Y() * f3) + (getAnchor1Y() * f4), (getControl1X() * f) + (getAnchor1X() * t), (getControl1Y() * f) + (getAnchor1Y() * t), getAnchor1X(), getAnchor1Y()));
    }

    public final Cubic times(float x) {
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = this.points[i] * x;
        }
        return new Cubic(fArr);
    }

    public final Cubic times(int x) {
        return times(x);
    }

    public String toString() {
        return "anchor0: (" + getAnchor0X() + ", " + getAnchor0Y() + ") control0: (" + getControl0X() + ", " + getControl0Y() + "), control1: (" + getControl1X() + ", " + getControl1Y() + "), anchor1: (" + getAnchor1X() + ", " + getAnchor1Y() + ')';
    }

    public final Cubic transformed(PointTransformer f) {
        Intrinsics.checkNotNullParameter(f, "f");
        MutableCubic mutableCubic = new MutableCubic();
        ArraysKt.copyInto$default(this.points, mutableCubic.getPoints(), 0, 0, 0, 14, (Object) null);
        mutableCubic.transform(f);
        return mutableCubic;
    }

    public final boolean zeroLength$graphics_shapes_release() {
        return Math.abs(getAnchor0X() - getAnchor1X()) < 1.0E-4f && Math.abs(getAnchor0Y() - getAnchor1Y()) < 1.0E-4f;
    }
}
