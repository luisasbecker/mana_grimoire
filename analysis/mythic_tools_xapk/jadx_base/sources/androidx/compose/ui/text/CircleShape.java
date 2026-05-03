package androidx.compose.ui.text;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.muxer.MuxerUtil;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import kotlin.Metadata;

/* JADX INFO: compiled from: Bullet.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/CircleShape;", "Landroidx/compose/ui/graphics/Shape;", "<init>", "()V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", AndroidContextPlugin.SCREEN_DENSITY_KEY, "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CircleShape implements Shape {
    public static final CircleShape INSTANCE = new CircleShape();

    private CircleShape() {
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public Outline mo1539createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        float fM6148getMinDimensionimpl = Size.m6148getMinDimensionimpl(size) / 2.0f;
        long jM6034constructorimpl = CornerRadius.m6034constructorimpl((((long) Float.floatToRawIntBits(fM6148getMinDimensionimpl)) << 32) | (((long) Float.floatToRawIntBits(fM6148getMinDimensionimpl)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        return new Outline.Rounded(RoundRectKt.m6132RoundRectZAM2FJo(SizeKt.m6170toRectuvyYCjk(size), jM6034constructorimpl, jM6034constructorimpl, jM6034constructorimpl, jM6034constructorimpl));
    }
}
