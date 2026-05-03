package androidx.compose.material3;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.material3.tokens.ProgressIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0019¢\u0006\u0004\b6\u00107R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0018\u001a\u00020\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001d\u001a\u00020\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\u001f\u001a\u00020\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u001e\u0010!\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u0016R\u001e\u0010$\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\u0016R\u001e\u0010'\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\u0016R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u00068"}, d2 = {"Landroidx/compose/material3/ProgressIndicatorDefaults;", "", "<init>", "()V", "linearColor", "Landroidx/compose/ui/graphics/Color;", "getLinearColor", "(Landroidx/compose/runtime/Composer;I)J", "circularColor", "getCircularColor", "linearTrackColor", "getLinearTrackColor", "circularTrackColor", "getCircularTrackColor$annotations", "getCircularTrackColor", "circularDeterminateTrackColor", "getCircularDeterminateTrackColor", "circularIndeterminateTrackColor", "getCircularIndeterminateTrackColor", "CircularStrokeWidth", "Landroidx/compose/ui/unit/Dp;", "getCircularStrokeWidth-D9Ej5fM", "()F", "F", "LinearStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getLinearStrokeCap-KaPHkGw", "()I", "I", "CircularDeterminateStrokeCap", "getCircularDeterminateStrokeCap-KaPHkGw", "CircularIndeterminateStrokeCap", "getCircularIndeterminateStrokeCap-KaPHkGw", "LinearTrackStopIndicatorSize", "getLinearTrackStopIndicatorSize-D9Ej5fM$annotations", "getLinearTrackStopIndicatorSize-D9Ej5fM", "LinearIndicatorTrackGapSize", "getLinearIndicatorTrackGapSize-D9Ej5fM$annotations", "getLinearIndicatorTrackGapSize-D9Ej5fM", "CircularIndicatorTrackGapSize", "getCircularIndicatorTrackGapSize-D9Ej5fM$annotations", "getCircularIndicatorTrackGapSize-D9Ej5fM", "ProgressAnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "getProgressAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "drawStopIndicator", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "stopSize", "color", "strokeCap", "drawStopIndicator-EgI2THU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJI)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProgressIndicatorDefaults {
    public static final int $stable = 0;
    public static final ProgressIndicatorDefaults INSTANCE = new ProgressIndicatorDefaults();
    private static final float CircularStrokeWidth = CircularProgressIndicatorTokens.INSTANCE.m4795getTrackThicknessD9Ej5fM();
    private static final int LinearStrokeCap = StrokeCap.INSTANCE.m6700getRoundKaPHkGw();
    private static final int CircularDeterminateStrokeCap = StrokeCap.INSTANCE.m6700getRoundKaPHkGw();
    private static final int CircularIndeterminateStrokeCap = StrokeCap.INSTANCE.m6700getRoundKaPHkGw();
    private static final float LinearTrackStopIndicatorSize = LinearProgressIndicatorTokens.INSTANCE.m5086getStopSizeD9Ej5fM();
    private static final float LinearIndicatorTrackGapSize = LinearProgressIndicatorTokens.INSTANCE.m5088getTrackActiveSpaceD9Ej5fM();
    private static final float CircularIndicatorTrackGapSize = CircularProgressIndicatorTokens.INSTANCE.m4794getTrackActiveSpaceD9Ej5fM();
    private static final SpringSpec<Float> ProgressAnimationSpec = new SpringSpec<>(1.0f, 50.0f, Float.valueOf(0.001f));

    private ProgressIndicatorDefaults() {
    }

    private static final void drawStopIndicator_EgI2THU$drawIndicator(DrawScope drawScope, int i, long j, float f, float f2) {
        if (StrokeCap.m6695equalsimpl0(i, StrokeCap.INSTANCE.m6700getRoundKaPHkGw())) {
            float f3 = f / 2.0f;
            float fIntBitsToFloat = (Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)) - f3) - f2;
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) / 2.0f;
            DrawScope.m6880drawCircleVaOC9Bg$default(drawScope, j, f3, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (MuxerUtil.UNSIGNED_INT_MAX_VALUE & ((long) Float.floatToRawIntBits(fIntBitsToFloat2)))), 0.0f, null, null, 0, 120, null);
            return;
        }
        float fIntBitsToFloat3 = (Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)) - f) - f2;
        float fIntBitsToFloat4 = (Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) - f) / 2.0f;
        DrawScope.m6893drawRectnJ9OG0$default(drawScope, j, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat3)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat4)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Size.m6140constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (MuxerUtil.UNSIGNED_INT_MAX_VALUE & ((long) Float.floatToRawIntBits(f)))), 0.0f, null, null, 0, 120, null);
    }

    /* JADX INFO: renamed from: getCircularIndicatorTrackGapSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3932getCircularIndicatorTrackGapSizeD9Ej5fM$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to circularDeterminateTrackColor or circularIndeterminateTrackColor", replaceWith = @ReplaceWith(expression = "ProgressIndicatorDefaults.circularIndeterminateTrackColor", imports = {}))
    public static /* synthetic */ void getCircularTrackColor$annotations() {
    }

    /* JADX INFO: renamed from: getLinearIndicatorTrackGapSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3933getLinearIndicatorTrackGapSizeD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getLinearTrackStopIndicatorSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3934getLinearTrackStopIndicatorSizeD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: drawStopIndicator-EgI2THU, reason: not valid java name */
    public final void m3935drawStopIndicatorEgI2THU(DrawScope drawScope, float stopSize, long color, int strokeCap) {
        float fMin = Math.min(drawScope.mo1624toPx0680j_4(stopSize), Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        float f = drawScope.mo1624toPx0680j_4(ProgressIndicatorKt.getStopIndicatorTrailingSpace());
        float fIntBitsToFloat = (Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) - fMin) / 2.0f;
        float f2 = fIntBitsToFloat > f ? f : fIntBitsToFloat;
        if (drawScope.getLayoutDirection() != LayoutDirection.Rtl) {
            drawStopIndicator_EgI2THU$drawIndicator(drawScope, strokeCap, color, fMin, f2);
            return;
        }
        long jMo6898getCenterF1C5BW0 = drawScope.mo6898getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6820getSizeNHjbRc = drawContext.mo6820getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6827scale0AR0LA0(-1.0f, 1.0f, jMo6898getCenterF1C5BW0);
            drawStopIndicator_EgI2THU$drawIndicator(drawScope, strokeCap, color, fMin, f2);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6821setSizeuvyYCjk(jMo6820getSizeNHjbRc);
        }
    }

    public final long getCircularColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1803349725, "C(<get-circularColor>)817@33505L5:ProgressIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1803349725, i, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularColor> (ProgressIndicator.kt:817)");
        }
        long value = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getActiveIndicatorColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getCircularDeterminateStrokeCap-KaPHkGw, reason: not valid java name */
    public final int m3936getCircularDeterminateStrokeCapKaPHkGw() {
        return CircularDeterminateStrokeCap;
    }

    public final long getCircularDeterminateTrackColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2143778381, "C(<get-circularDeterminateTrackColor>)834@34237L5:ProgressIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2143778381, i, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularDeterminateTrackColor> (ProgressIndicator.kt:834)");
        }
        long value = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getTrackColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getCircularIndeterminateStrokeCap-KaPHkGw, reason: not valid java name */
    public final int m3937getCircularIndeterminateStrokeCapKaPHkGw() {
        return CircularIndeterminateStrokeCap;
    }

    public final long getCircularIndeterminateTrackColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1947901123, "C(<get-circularIndeterminateTrackColor>):ProgressIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1947901123, i, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularIndeterminateTrackColor> (ProgressIndicator.kt:838)");
        }
        long jM6360getTransparent0d7_KjU = Color.INSTANCE.m6360getTransparent0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM6360getTransparent0d7_KjU;
    }

    /* JADX INFO: renamed from: getCircularIndicatorTrackGapSize-D9Ej5fM, reason: not valid java name */
    public final float m3938getCircularIndicatorTrackGapSizeD9Ej5fM() {
        return CircularIndicatorTrackGapSize;
    }

    /* JADX INFO: renamed from: getCircularStrokeWidth-D9Ej5fM, reason: not valid java name */
    public final float m3939getCircularStrokeWidthD9Ej5fM() {
        return CircularStrokeWidth;
    }

    public final long getCircularTrackColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -404222247, "C(<get-circularTrackColor>):ProgressIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-404222247, i, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-circularTrackColor> (ProgressIndicator.kt:830)");
        }
        long jM6360getTransparent0d7_KjU = Color.INSTANCE.m6360getTransparent0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM6360getTransparent0d7_KjU;
    }

    public final long getLinearColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -914312983, "C(<get-linearColor>)813@33336L5:ProgressIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-914312983, i, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-linearColor> (ProgressIndicator.kt:813)");
        }
        long value = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getActiveIndicatorColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getLinearIndicatorTrackGapSize-D9Ej5fM, reason: not valid java name */
    public final float m3940getLinearIndicatorTrackGapSizeD9Ej5fM() {
        return LinearIndicatorTrackGapSize;
    }

    /* JADX INFO: renamed from: getLinearStrokeCap-KaPHkGw, reason: not valid java name */
    public final int m3941getLinearStrokeCapKaPHkGw() {
        return LinearStrokeCap;
    }

    public final long getLinearTrackColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1677541593, "C(<get-linearTrackColor>)821@33671L5:ProgressIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1677541593, i, -1, "androidx.compose.material3.ProgressIndicatorDefaults.<get-linearTrackColor> (ProgressIndicator.kt:821)");
        }
        long value = ColorSchemeKt.getValue(ProgressIndicatorTokens.INSTANCE.getTrackColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getLinearTrackStopIndicatorSize-D9Ej5fM, reason: not valid java name */
    public final float m3942getLinearTrackStopIndicatorSizeD9Ej5fM() {
        return LinearTrackStopIndicatorSize;
    }

    public final SpringSpec<Float> getProgressAnimationSpec() {
        return ProgressAnimationSpec;
    }
}
