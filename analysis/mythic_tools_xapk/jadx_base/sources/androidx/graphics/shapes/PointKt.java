package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Point.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a6\u0010\b\u001a\u00060\u0002j\u0002`\u00032\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\n\u0010\n\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a&\u0010\u000e\u001a\u00020\u000f*\u00060\u0002j\u0002`\u00032\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a2\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0016\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0017\u001a\u00020\u0001H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u001a\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a*\u0010\u001a\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u001e\u0010!\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001a\u0010$\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010\u0005\u001a\u001a\u0010&\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b'\u0010\u0005\u001a+\u0010(\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a+\u0010+\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010*\u001a'\u0010-\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0017\u001a\u00020\u0001H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010\u0019\u001a'\u0010/\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0017\u001a\u00020\u0001H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0019\u001a&\u00101\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u00102\u001a\u000203H\u0000ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a\u001f\u00106\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b7\u0010#\"\u001c\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005*\f\b\u0000\u00108\"\u00020\u00022\u00020\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"x", "", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "getX-DnnuFBc", "(J)F", "y", "getY-DnnuFBc", "interpolate", "start", "stop", "fraction", "interpolate-dLqxh1s", "(JJF)J", "clockwise", "", "other", "clockwise-ybeJwSQ", "(JJ)Z", "copy", "copy-5P9i7ZU", "(JFF)J", "div", "operand", "div-so9K2fw", "(JF)J", "dotProduct", "dotProduct-ybeJwSQ", "(JJ)F", "otherX", "otherY", "dotProduct-5P9i7ZU", "(JFF)F", "getDirection", "getDirection-DnnuFBc", "(J)J", "getDistance", "getDistance-DnnuFBc", "getDistanceSquared", "getDistanceSquared-DnnuFBc", "minus", "minus-ybeJwSQ", "(JJ)J", "plus", "plus-ybeJwSQ", "rem", "rem-so9K2fw", "times", "times-so9K2fw", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "transformed-so9K2fw", "(JLandroidx/graphics/shapes/PointTransformer;)J", "unaryMinus", "unaryMinus-DnnuFBc", "Point", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PointKt {
    /* JADX INFO: renamed from: clockwise-ybeJwSQ, reason: not valid java name */
    public static final boolean m9686clockwiseybeJwSQ(long j, long j2) {
        return (m9695getXDnnuFBc(j) * m9696getYDnnuFBc(j2)) - (m9696getYDnnuFBc(j) * m9695getXDnnuFBc(j2)) > 0.0f;
    }

    /* JADX INFO: renamed from: copy-5P9i7ZU, reason: not valid java name */
    public static final long m9687copy5P9i7ZU(long j, float f, float f2) {
        return FloatFloatPair.m1231constructorimpl(f, f2);
    }

    /* JADX INFO: renamed from: copy-5P9i7ZU$default, reason: not valid java name */
    public static /* synthetic */ long m9688copy5P9i7ZU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f2 = Float.intBitsToFloat((int) (MuxerUtil.UNSIGNED_INT_MAX_VALUE & j));
        }
        return m9687copy5P9i7ZU(j, f, f2);
    }

    /* JADX INFO: renamed from: div-so9K2fw, reason: not valid java name */
    public static final long m9689divso9K2fw(long j, float f) {
        return FloatFloatPair.m1231constructorimpl(m9695getXDnnuFBc(j) / f, m9696getYDnnuFBc(j) / f);
    }

    /* JADX INFO: renamed from: dotProduct-5P9i7ZU, reason: not valid java name */
    public static final float m9690dotProduct5P9i7ZU(long j, float f, float f2) {
        return (m9695getXDnnuFBc(j) * f) + (m9696getYDnnuFBc(j) * f2);
    }

    /* JADX INFO: renamed from: dotProduct-ybeJwSQ, reason: not valid java name */
    public static final float m9691dotProductybeJwSQ(long j, long j2) {
        return (m9695getXDnnuFBc(j) * m9695getXDnnuFBc(j2)) + (m9696getYDnnuFBc(j) * m9696getYDnnuFBc(j2));
    }

    /* JADX INFO: renamed from: getDirection-DnnuFBc, reason: not valid java name */
    public static final long m9692getDirectionDnnuFBc(long j) {
        float fM9693getDistanceDnnuFBc = m9693getDistanceDnnuFBc(j);
        if (fM9693getDistanceDnnuFBc > 0.0f) {
            return m9689divso9K2fw(j, fM9693getDistanceDnnuFBc);
        }
        throw new IllegalArgumentException("Can't get the direction of a 0-length vector".toString());
    }

    /* JADX INFO: renamed from: getDistance-DnnuFBc, reason: not valid java name */
    public static final float m9693getDistanceDnnuFBc(long j) {
        return (float) Math.sqrt((m9695getXDnnuFBc(j) * m9695getXDnnuFBc(j)) + (m9696getYDnnuFBc(j) * m9696getYDnnuFBc(j)));
    }

    /* JADX INFO: renamed from: getDistanceSquared-DnnuFBc, reason: not valid java name */
    public static final float m9694getDistanceSquaredDnnuFBc(long j) {
        return (m9695getXDnnuFBc(j) * m9695getXDnnuFBc(j)) + (m9696getYDnnuFBc(j) * m9696getYDnnuFBc(j));
    }

    /* JADX INFO: renamed from: getX-DnnuFBc, reason: not valid java name */
    public static final float m9695getXDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getY-DnnuFBc, reason: not valid java name */
    public static final float m9696getYDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    /* JADX INFO: renamed from: interpolate-dLqxh1s, reason: not valid java name */
    public static final long m9697interpolatedLqxh1s(long j, long j2, float f) {
        return FloatFloatPair.m1231constructorimpl(Utils.interpolate(m9695getXDnnuFBc(j), m9695getXDnnuFBc(j2), f), Utils.interpolate(m9696getYDnnuFBc(j), m9696getYDnnuFBc(j2), f));
    }

    /* JADX INFO: renamed from: minus-ybeJwSQ, reason: not valid java name */
    public static final long m9698minusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m1231constructorimpl(m9695getXDnnuFBc(j) - m9695getXDnnuFBc(j2), m9696getYDnnuFBc(j) - m9696getYDnnuFBc(j2));
    }

    /* JADX INFO: renamed from: plus-ybeJwSQ, reason: not valid java name */
    public static final long m9699plusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m1231constructorimpl(m9695getXDnnuFBc(j) + m9695getXDnnuFBc(j2), m9696getYDnnuFBc(j) + m9696getYDnnuFBc(j2));
    }

    /* JADX INFO: renamed from: rem-so9K2fw, reason: not valid java name */
    public static final long m9700remso9K2fw(long j, float f) {
        return FloatFloatPair.m1231constructorimpl(m9695getXDnnuFBc(j) % f, m9696getYDnnuFBc(j) % f);
    }

    /* JADX INFO: renamed from: times-so9K2fw, reason: not valid java name */
    public static final long m9701timesso9K2fw(long j, float f) {
        return FloatFloatPair.m1231constructorimpl(m9695getXDnnuFBc(j) * f, m9696getYDnnuFBc(j) * f);
    }

    /* JADX INFO: renamed from: transformed-so9K2fw, reason: not valid java name */
    public static final long m9702transformedso9K2fw(long j, PointTransformer f) {
        Intrinsics.checkNotNullParameter(f, "f");
        long jMo9704transformXgqJiTY = f.mo9704transformXgqJiTY(m9695getXDnnuFBc(j), m9696getYDnnuFBc(j));
        return FloatFloatPair.m1231constructorimpl(Float.intBitsToFloat((int) (jMo9704transformXgqJiTY >> 32)), Float.intBitsToFloat((int) (jMo9704transformXgqJiTY & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
    }

    /* JADX INFO: renamed from: unaryMinus-DnnuFBc, reason: not valid java name */
    public static final long m9703unaryMinusDnnuFBc(long j) {
        return FloatFloatPair.m1231constructorimpl(-m9695getXDnnuFBc(j), -m9696getYDnnuFBc(j));
    }
}
