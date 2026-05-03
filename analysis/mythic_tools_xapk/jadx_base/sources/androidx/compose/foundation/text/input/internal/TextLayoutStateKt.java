package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextLayoutState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000b\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\f\u0010\n\u001a\u001b\u0010\r\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000e\u0010\n\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0010"}, d2 = {"coerceIn", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "fromTextLayoutToCore", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", TypedValues.CycleType.S_WAVE_OFFSET, "fromTextLayoutToCore-Uv8p0NA", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;J)J", "fromDecorationToTextLayout", "fromDecorationToTextLayout-Uv8p0NA", "fromWindowToDecoration", "fromWindowToDecoration-Uv8p0NA", "fromTextLayoutToDecoration", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextLayoutStateKt {
    /* JADX INFO: renamed from: coerceIn-3MmeM6k, reason: not valid java name */
    public static final long m2672coerceIn3MmeM6k(long j, Rect rect) {
        int i = (int) (j >> 32);
        float left = Float.intBitsToFloat(i) < rect.getLeft() ? rect.getLeft() : Float.intBitsToFloat(i) > rect.getRight() ? rect.getRight() : Float.intBitsToFloat(i);
        int i2 = (int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        return Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(left)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat(i2) < rect.getTop() ? rect.getTop() : Float.intBitsToFloat(i2) > rect.getBottom() ? rect.getBottom() : Float.intBitsToFloat(i2))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    /* JADX INFO: renamed from: fromDecorationToTextLayout-Uv8p0NA, reason: not valid java name */
    public static final long m2673fromDecorationToTextLayoutUv8p0NA(TextLayoutState textLayoutState, long j) {
        Offset offsetM6069boximpl;
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            LayoutCoordinates decoratorNodeCoordinates = textLayoutState.getDecoratorNodeCoordinates();
            if (decoratorNodeCoordinates != null) {
                offsetM6069boximpl = Offset.m6069boximpl((textLayoutNodeCoordinates.isAttached() && decoratorNodeCoordinates.isAttached()) ? textLayoutNodeCoordinates.mo7778localPositionOfR5De75A(decoratorNodeCoordinates, j) : j);
            } else {
                offsetM6069boximpl = null;
            }
            if (offsetM6069boximpl != null) {
                return offsetM6069boximpl.m6090unboximpl();
            }
        }
        return j;
    }

    /* JADX INFO: renamed from: fromTextLayoutToCore-Uv8p0NA, reason: not valid java name */
    public static final long m2674fromTextLayoutToCoreUv8p0NA(TextLayoutState textLayoutState, long j) {
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            Offset offsetM6069boximpl = null;
            if (!textLayoutNodeCoordinates.isAttached()) {
                textLayoutNodeCoordinates = null;
            }
            if (textLayoutNodeCoordinates != null) {
                LayoutCoordinates coreNodeCoordinates = textLayoutState.getCoreNodeCoordinates();
                if (coreNodeCoordinates != null) {
                    if (!coreNodeCoordinates.isAttached()) {
                        coreNodeCoordinates = null;
                    }
                    if (coreNodeCoordinates != null) {
                        offsetM6069boximpl = Offset.m6069boximpl(coreNodeCoordinates.mo7778localPositionOfR5De75A(textLayoutNodeCoordinates, j));
                    }
                }
                if (offsetM6069boximpl != null) {
                    return offsetM6069boximpl.m6090unboximpl();
                }
            }
        }
        return j;
    }

    public static final Rect fromTextLayoutToDecoration(TextLayoutState textLayoutState, Rect rect) {
        LayoutCoordinates decoratorNodeCoordinates;
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            if (!textLayoutNodeCoordinates.isAttached()) {
                textLayoutNodeCoordinates = null;
            }
            if (textLayoutNodeCoordinates != null && (decoratorNodeCoordinates = textLayoutState.getDecoratorNodeCoordinates()) != null) {
                LayoutCoordinates layoutCoordinates = decoratorNodeCoordinates.isAttached() ? decoratorNodeCoordinates : null;
                if (layoutCoordinates != null) {
                    return rect.m6117translatek4lQ0M(layoutCoordinates.localBoundingBoxOf(textLayoutNodeCoordinates, false).m6115getTopLeftF1C5BW0());
                }
            }
        }
        return rect;
    }

    /* JADX INFO: renamed from: fromWindowToDecoration-Uv8p0NA, reason: not valid java name */
    public static final long m2675fromWindowToDecorationUv8p0NA(TextLayoutState textLayoutState, long j) {
        LayoutCoordinates decoratorNodeCoordinates = textLayoutState.getDecoratorNodeCoordinates();
        return (decoratorNodeCoordinates == null || !decoratorNodeCoordinates.isAttached()) ? j : decoratorNodeCoordinates.mo7786windowToLocalMKHz9U(j);
    }
}
