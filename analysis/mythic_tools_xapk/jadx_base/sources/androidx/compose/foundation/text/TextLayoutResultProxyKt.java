package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextLayoutResultProxy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"coerceIn", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextLayoutResultProxyKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: coerceIn-3MmeM6k, reason: not valid java name */
    public static final long m2515coerceIn3MmeM6k(long j, Rect rect) {
        int i = (int) (j >> 32);
        float left = Float.intBitsToFloat(i) < rect.getLeft() ? rect.getLeft() : Float.intBitsToFloat(i) > rect.getRight() ? rect.getRight() : Float.intBitsToFloat(i);
        int i2 = (int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
        return Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(left)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat(i2) < rect.getTop() ? rect.getTop() : Float.intBitsToFloat(i2) > rect.getBottom() ? rect.getBottom() : Float.intBitsToFloat(i2))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }
}
