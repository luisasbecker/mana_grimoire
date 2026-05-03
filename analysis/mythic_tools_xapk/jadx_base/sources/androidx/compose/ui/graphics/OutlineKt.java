package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.media3.muxer.MuxerUtil;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Outline.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001aK\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012\u001aK\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u00020\u0018*\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001a\u001a\u0011\u0010\u001b\u001a\u00020\u001c*\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001a\u001a\u0011\u0010\u0017\u001a\u00020\u0018*\u00020\u001dH\u0002¢\u0006\u0002\u0010\u001e\u001a\u0011\u0010\u001b\u001a\u00020\u001c*\u00020\u001dH\u0002¢\u0006\u0002\u0010\u001e\u001a\u009f\u0001\u0010\u001f\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042,\u0010 \u001a(\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b%2,\u0010&\u001a(\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b%2,\u0010(\u001a(\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b%H\u0082\b\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020*2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,\u001a\f\u0010-\u001a\u00020.*\u00020\u001dH\u0002¨\u0006/"}, d2 = {"addOutline", "", "Landroidx/compose/ui/graphics/Path;", "outline", "Landroidx/compose/ui/graphics/Outline;", "drawOutline", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawOutline-wDX37Ww", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "drawOutline-hn5TExg", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;)J", "size", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/geometry/RoundRect;", "(Landroidx/compose/ui/geometry/RoundRect;)J", "drawOutlineHelper", "drawRectBlock", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "rect", "Lkotlin/ExtensionFunctionType;", "drawRoundedRectBlock", "rrect", "drawPathBlock", "path", "Landroidx/compose/ui/graphics/Canvas;", "paint", "Landroidx/compose/ui/graphics/Paint;", "hasSameCornerRadius", "", "ui-graphics"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OutlineKt {
    public static final void addOutline(Path path, Outline outline) {
        if (outline instanceof Outline.Rectangle) {
            Path.addRect$default(path, ((Outline.Rectangle) outline).getRect(), null, 2, null);
        } else if (outline instanceof Outline.Rounded) {
            Path.addRoundRect$default(path, ((Outline.Rounded) outline).getRoundRect(), null, 2, null);
        } else {
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            Path.m6609addPathUv8p0NA$default(path, ((Outline.Generic) outline).getPath(), 0L, 2, null);
        }
    }

    public static final void drawOutline(Canvas canvas, Outline outline, Paint paint) {
        if (outline instanceof Outline.Rectangle) {
            canvas.drawRect(((Outline.Rectangle) outline).getRect(), paint);
            return;
        }
        if (!(outline instanceof Outline.Rounded)) {
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            canvas.drawPath(((Outline.Generic) outline).getPath(), paint);
        } else {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            Path roundRectPath = rounded.getRoundRectPath();
            if (roundRectPath != null) {
                canvas.drawPath(roundRectPath, paint);
            } else {
                canvas.drawRoundRect(rounded.getRoundRect().getLeft(), rounded.getRoundRect().getTop(), rounded.getRoundRect().getRight(), rounded.getRoundRect().getBottom(), Float.intBitsToFloat((int) (rounded.getRoundRect().m6128getBottomLeftCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (rounded.getRoundRect().m6128getBottomLeftCornerRadiuskKHJgLs() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), paint);
            }
        }
    }

    /* JADX INFO: renamed from: drawOutline-hn5TExg, reason: not valid java name */
    public static final void m6595drawOutlinehn5TExg(DrawScope drawScope, Outline outline, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawScope.mo6811drawRectAsUm42w(brush, topLeft(rect), size(rect), f, drawStyle, colorFilter, i);
            return;
        }
        if (!(outline instanceof Outline.Rounded)) {
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            drawScope.mo6807drawPathGBMwjPU(((Outline.Generic) outline).getPath(), brush, f, drawStyle, colorFilter, i);
            return;
        }
        Outline.Rounded rounded = (Outline.Rounded) outline;
        Path roundRectPath = rounded.getRoundRectPath();
        if (roundRectPath != null) {
            drawScope.mo6807drawPathGBMwjPU(roundRectPath, brush, f, drawStyle, colorFilter, i);
            return;
        }
        RoundRect roundRect = rounded.getRoundRect();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (roundRect.m6128getBottomLeftCornerRadiuskKHJgLs() >> 32));
        drawScope.mo6813drawRoundRectZuiqVtQ(brush, topLeft(roundRect), size(roundRect), CornerRadius.m6034constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), f, drawStyle, colorFilter, i);
    }

    /* JADX INFO: renamed from: drawOutline-hn5TExg$default, reason: not valid java name */
    public static /* synthetic */ void m6596drawOutlinehn5TExg$default(DrawScope drawScope, Outline outline, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i2 & 32) != 0) {
            i = DrawScope.INSTANCE.m6901getDefaultBlendMode0nO6VwU();
        }
        m6595drawOutlinehn5TExg(drawScope, outline, brush, f2, drawStyle2, colorFilter2, i);
    }

    /* JADX INFO: renamed from: drawOutline-wDX37Ww, reason: not valid java name */
    public static final void m6597drawOutlinewDX37Ww(DrawScope drawScope, Outline outline, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawScope.mo6812drawRectnJ9OG0(j, topLeft(rect), size(rect), f, drawStyle, colorFilter, i);
            return;
        }
        if (!(outline instanceof Outline.Rounded)) {
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            drawScope.mo6808drawPathLG529CI(((Outline.Generic) outline).getPath(), j, f, drawStyle, colorFilter, i);
            return;
        }
        Outline.Rounded rounded = (Outline.Rounded) outline;
        Path roundRectPath = rounded.getRoundRectPath();
        if (roundRectPath != null) {
            drawScope.mo6808drawPathLG529CI(roundRectPath, j, f, drawStyle, colorFilter, i);
            return;
        }
        RoundRect roundRect = rounded.getRoundRect();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (roundRect.m6128getBottomLeftCornerRadiuskKHJgLs() >> 32));
        drawScope.mo6814drawRoundRectuAw5IA(j, topLeft(roundRect), size(roundRect), CornerRadius.m6034constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), drawStyle, f, colorFilter, i);
    }

    /* JADX INFO: renamed from: drawOutline-wDX37Ww$default, reason: not valid java name */
    public static /* synthetic */ void m6598drawOutlinewDX37Ww$default(DrawScope drawScope, Outline outline, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        m6597drawOutlinewDX37Ww(drawScope, outline, j, f2, drawStyle2, colorFilter, (i2 & 32) != 0 ? DrawScope.INSTANCE.m6901getDefaultBlendMode0nO6VwU() : i);
    }

    private static final void drawOutlineHelper(DrawScope drawScope, Outline outline, Function2<? super DrawScope, ? super Rect, Unit> function2, Function2<? super DrawScope, ? super RoundRect, Unit> function22, Function2<? super DrawScope, ? super Path, Unit> function23) {
        if (outline instanceof Outline.Rectangle) {
            function2.invoke(drawScope, ((Outline.Rectangle) outline).getRect());
            return;
        }
        if (!(outline instanceof Outline.Rounded)) {
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            function23.invoke(drawScope, ((Outline.Generic) outline).getPath());
        } else {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            Path roundRectPath = rounded.getRoundRectPath();
            if (roundRectPath != null) {
                function23.invoke(drawScope, roundRectPath);
            } else {
                function22.invoke(drawScope, rounded.getRoundRect());
            }
        }
    }

    private static final boolean hasSameCornerRadius(RoundRect roundRect) {
        return ((Float.intBitsToFloat((int) (roundRect.m6128getBottomLeftCornerRadiuskKHJgLs() >> 32)) > Float.intBitsToFloat((int) (roundRect.m6129getBottomRightCornerRadiuskKHJgLs() >> 32)) ? 1 : (Float.intBitsToFloat((int) (roundRect.m6128getBottomLeftCornerRadiuskKHJgLs() >> 32)) == Float.intBitsToFloat((int) (roundRect.m6129getBottomRightCornerRadiuskKHJgLs() >> 32)) ? 0 : -1)) == 0 && (Float.intBitsToFloat((int) (roundRect.m6129getBottomRightCornerRadiuskKHJgLs() >> 32)) > Float.intBitsToFloat((int) (roundRect.m6131getTopRightCornerRadiuskKHJgLs() >> 32)) ? 1 : (Float.intBitsToFloat((int) (roundRect.m6129getBottomRightCornerRadiuskKHJgLs() >> 32)) == Float.intBitsToFloat((int) (roundRect.m6131getTopRightCornerRadiuskKHJgLs() >> 32)) ? 0 : -1)) == 0 && (Float.intBitsToFloat((int) (roundRect.m6131getTopRightCornerRadiuskKHJgLs() >> 32)) > Float.intBitsToFloat((int) (roundRect.m6130getTopLeftCornerRadiuskKHJgLs() >> 32)) ? 1 : (Float.intBitsToFloat((int) (roundRect.m6131getTopRightCornerRadiuskKHJgLs() >> 32)) == Float.intBitsToFloat((int) (roundRect.m6130getTopLeftCornerRadiuskKHJgLs() >> 32)) ? 0 : -1)) == 0) && ((Float.intBitsToFloat((int) (roundRect.m6128getBottomLeftCornerRadiuskKHJgLs() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) > Float.intBitsToFloat((int) (roundRect.m6129getBottomRightCornerRadiuskKHJgLs() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) ? 1 : (Float.intBitsToFloat((int) (roundRect.m6128getBottomLeftCornerRadiuskKHJgLs() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) == Float.intBitsToFloat((int) (roundRect.m6129getBottomRightCornerRadiuskKHJgLs() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) ? 0 : -1)) == 0 && (Float.intBitsToFloat((int) (roundRect.m6129getBottomRightCornerRadiuskKHJgLs() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) > Float.intBitsToFloat((int) (roundRect.m6131getTopRightCornerRadiuskKHJgLs() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) ? 1 : (Float.intBitsToFloat((int) (roundRect.m6129getBottomRightCornerRadiuskKHJgLs() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) == Float.intBitsToFloat((int) (roundRect.m6131getTopRightCornerRadiuskKHJgLs() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) ? 0 : -1)) == 0 && (Float.intBitsToFloat((int) (roundRect.m6131getTopRightCornerRadiuskKHJgLs() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) > Float.intBitsToFloat((int) (roundRect.m6130getTopLeftCornerRadiuskKHJgLs() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) ? 1 : (Float.intBitsToFloat((int) (roundRect.m6131getTopRightCornerRadiuskKHJgLs() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) == Float.intBitsToFloat((int) (roundRect.m6130getTopLeftCornerRadiuskKHJgLs() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) ? 0 : -1)) == 0);
    }

    private static final long size(Rect rect) {
        float right = rect.getRight() - rect.getLeft();
        return Size.m6140constructorimpl((((long) Float.floatToRawIntBits(rect.getBottom() - rect.getTop())) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(right) << 32));
    }

    private static final long size(RoundRect roundRect) {
        float width = roundRect.getWidth();
        float height = roundRect.getHeight();
        return Size.m6140constructorimpl((((long) Float.floatToRawIntBits(width)) << 32) | (((long) Float.floatToRawIntBits(height)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    private static final long topLeft(Rect rect) {
        float left = rect.getLeft();
        float top = rect.getTop();
        return Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(left)) << 32) | (((long) Float.floatToRawIntBits(top)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }

    private static final long topLeft(RoundRect roundRect) {
        float left = roundRect.getLeft();
        float top = roundRect.getTop();
        return Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(left)) << 32) | (((long) Float.floatToRawIntBits(top)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
    }
}
