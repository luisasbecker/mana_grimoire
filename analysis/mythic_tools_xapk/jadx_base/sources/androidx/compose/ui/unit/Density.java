package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.media3.muxer.MuxerUtil;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;

/* JADX INFO: compiled from: Density.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0013\u0010\b\u001a\u00020\u0003*\u00020\tH\u0017¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r*\u00020\tH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\b\u001a\u00020\u0003*\u00020\u0010H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\f\u001a\u00020\r*\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\t*\u00020\rH\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u0010*\u00020\rH\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0015\u001a\u00020\t*\u00020\u0003H\u0017¢\u0006\u0004\b\u0016\u0010\u000bJ\u0013\u0010\u0018\u001a\u00020\u0010*\u00020\u0003H\u0017¢\u0006\u0004\b\u0019\u0010\u001bJ\f\u0010\u001c\u001a\u00020\u001d*\u00020\u001eH\u0017J\u0013\u0010\u001f\u001a\u00020 *\u00020!H\u0017¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020!*\u00020 H\u0017¢\u0006\u0004\b%\u0010#R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "", "getDensity$annotations", "()V", "getDensity", "()F", "toPx", "Landroidx/compose/ui/unit/Dp;", "toPx-0680j_4", "(F)F", "roundToPx", "", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "toPx--R2X_6o", "(J)F", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/unit/DpSize;", "toSize-XkaWNTQ", "(J)J", "toDpSize", "toDpSize-k-rfVVM", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Density extends FontScaling {

    /* JADX INFO: compiled from: Density.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m9100roundToPxR2X_6o(Density density, long j) {
            return Density.super.mo1617roundToPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m9101roundToPx0680j_4(Density density, float f) {
            return Density.super.mo1618roundToPx0680j_4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m9102toDpGaN1DYA(Density density, long j) {
            return Density.super.mo1619toDpGaN1DYA(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m9103toDpu2uoSUM(Density density, float f) {
            return Density.super.mo1620toDpu2uoSUM(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m9104toDpu2uoSUM(Density density, int i) {
            return Density.super.mo1621toDpu2uoSUM(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m9105toDpSizekrfVVM(Density density, long j) {
            return Density.super.mo1622toDpSizekrfVVM(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m9106toPxR2X_6o(Density density, long j) {
            return Density.super.mo1623toPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m9107toPx0680j_4(Density density, float f) {
            return Density.super.mo1624toPx0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(Density density, DpRect dpRect) {
            return Density.super.toRect(dpRect);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m9108toSizeXkaWNTQ(Density density, long j) {
            return Density.super.mo1625toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m9109toSp0xMU5do(Density density, float f) {
            return Density.super.mo1626toSp0xMU5do(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m9110toSpkPz2Gy4(Density density, float f) {
            return Density.super.mo1627toSpkPz2Gy4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m9111toSpkPz2Gy4(Density density, int i) {
            return Density.super.mo1628toSpkPz2Gy4(i);
        }
    }

    float getDensity();

    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    default int mo1617roundToPxR2X_6o(long j) {
        return Math.round(mo1623toPxR2X_6o(j));
    }

    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    default int mo1618roundToPx0680j_4(float f) {
        float fMo1624toPx0680j_4 = mo1624toPx0680j_4(f);
        if (Float.isInfinite(fMo1624toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(fMo1624toPx0680j_4);
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo1620toDpu2uoSUM(float f) {
        return Dp.m9114constructorimpl(f / getDensity());
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo1621toDpu2uoSUM(int i) {
        return Dp.m9114constructorimpl(i / getDensity());
    }

    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    default long mo1622toDpSizekrfVVM(long j) {
        return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? DpKt.m9136DpSizeYgX7TsA(mo1620toDpu2uoSUM(Float.intBitsToFloat((int) (j >> 32))), mo1620toDpu2uoSUM(Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) : DpSize.INSTANCE.m9221getUnspecifiedMYxV2XQ();
    }

    /* JADX INFO: renamed from: toPx--R2X_6o */
    default float mo1623toPxR2X_6o(long j) {
        if (!TextUnitType.m9336equalsimpl0(TextUnit.m9307getTypeUIouoOA(j), TextUnitType.INSTANCE.m9341getSpUIouoOA())) {
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        }
        return mo1624toPx0680j_4(mo1619toDpGaN1DYA(j));
    }

    /* JADX INFO: renamed from: toPx-0680j_4 */
    default float mo1624toPx0680j_4(float f) {
        return f * getDensity();
    }

    default Rect toRect(DpRect dpRect) {
        return new Rect(mo1624toPx0680j_4(dpRect.m9197getLeftD9Ej5fM()), mo1624toPx0680j_4(dpRect.m9199getTopD9Ej5fM()), mo1624toPx0680j_4(dpRect.m9198getRightD9Ej5fM()), mo1624toPx0680j_4(dpRect.m9196getBottomD9Ej5fM()));
    }

    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    default long mo1625toSizeXkaWNTQ(long j) {
        if (j == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            return Size.INSTANCE.m6157getUnspecifiedNHjbRc();
        }
        float fMo1624toPx0680j_4 = mo1624toPx0680j_4(DpSize.m9212getWidthD9Ej5fM(j));
        float fMo1624toPx0680j_42 = mo1624toPx0680j_4(DpSize.m9210getHeightD9Ej5fM(j));
        return Size.m6140constructorimpl((((long) Float.floatToRawIntBits(fMo1624toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo1624toPx0680j_42)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo1627toSpkPz2Gy4(float f) {
        return mo1626toSp0xMU5do(mo1620toDpu2uoSUM(f));
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo1628toSpkPz2Gy4(int i) {
        return mo1626toSp0xMU5do(mo1621toDpu2uoSUM(i));
    }
}
