package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;

/* JADX INFO: compiled from: IntSize.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\n¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u00020\u000b*\u00020\u0001H\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\u0001H\u0007¢\u0006\u0004\b\u0016\u0010\u0013\u001a\u0013\u0010\u0017\u001a\u00020\u0001*\u00020\u0015H\u0007¢\u0006\u0004\b\u0018\u0010\u0013\u001a\u0013\u0010\u0019\u001a\u00020\u0001*\u00020\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u0013\"\u001e\u0010\u000e\u001a\u00020\u000f*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"IntSize", "Landroidx/compose/ui/unit/IntSize;", "width", "", "height", "(II)J", "times", "size", "times-O0kMr_c", "(IJ)J", "toIntRect", "Landroidx/compose/ui/unit/IntRect;", "toIntRect-ozmzZPI", "(J)Landroidx/compose/ui/unit/IntRect;", "center", "Landroidx/compose/ui/unit/IntOffset;", "getCenter-ozmzZPI$annotations", "(J)V", "getCenter-ozmzZPI", "(J)J", "toSize", "Landroidx/compose/ui/geometry/Size;", "toSize-ozmzZPI", "toIntSize", "toIntSize-uvyYCjk", "roundToIntSize", "roundToIntSize-uvyYCjk", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IntSizeKt {
    public static final long IntSize(int i, int i2) {
        return IntSize.m9280constructorimpl((((long) i2) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) i) << 32));
    }

    /* JADX INFO: renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m9291getCenterozmzZPI(long j) {
        return IntOffset.m9236constructorimpl((((j << 32) >> 33) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | ((j >> 33) << 32));
    }

    /* JADX INFO: renamed from: getCenter-ozmzZPI$annotations, reason: not valid java name */
    public static /* synthetic */ void m9292getCenterozmzZPI$annotations(long j) {
    }

    /* JADX INFO: renamed from: roundToIntSize-uvyYCjk, reason: not valid java name */
    public static final long m9293roundToIntSizeuvyYCjk(long j) {
        int iRound = Math.round(Float.intBitsToFloat((int) (j >> 32)));
        return IntSize.m9280constructorimpl((((long) Math.round(Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) iRound) << 32));
    }

    /* JADX INFO: renamed from: times-O0kMr_c, reason: not valid java name */
    public static final long m9294timesO0kMr_c(int i, long j) {
        return IntSize.m9287timesYEO4UFw(j, i);
    }

    /* JADX INFO: renamed from: toIntRect-ozmzZPI, reason: not valid java name */
    public static final IntRect m9295toIntRectozmzZPI(long j) {
        return IntRectKt.m9275IntRectVbeCjmY(IntOffset.INSTANCE.m9253getZeronOccac(), j);
    }

    /* JADX INFO: renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m9296toIntSizeuvyYCjk(long j) {
        int iIntBitsToFloat = (int) Float.intBitsToFloat((int) (j >> 32));
        return IntSize.m9280constructorimpl((((long) ((int) Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) iIntBitsToFloat) << 32));
    }

    /* JADX INFO: renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m9297toSizeozmzZPI(long j) {
        float f = (int) (j >> 32);
        return Size.m6140constructorimpl((((long) Float.floatToRawIntBits((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(f) << 32));
    }
}
