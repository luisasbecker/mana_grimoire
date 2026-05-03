package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u001aE\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001aj\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\u001a\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a;\u0010\u001f\u001a\u00020\u0001*\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0004\b#\u0010$\u001aO\u0010%\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b&\u0010'\u001aY\u0010%\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b(\u0010)\u001aA\u0010%\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b*\u0010+\u001aK\u0010%\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b,\u0010-\u001aI\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b&\u0010.\u001a5\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000fH\u0007¢\u0006\u0004\b/\u00100\u001a-\u0010%\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000fH\u0007¢\u0006\u0004\b1\u00102\u001a3\u00103\u001a\u00020\u0001*\u00020\u00122\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b8\u00109\u001a#\u0010:\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b;\u0010<\u001a3\u0010=\u001a\u00020\u0001*\u00020\u00122\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b>\u00109\u001a;\u0010?\u001a\u00020\u0001*\u00020\u00122\u0006\u00104\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b@\u0010A\"\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E\"\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bG\u0010E\"\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010E\"\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bK\u0010E\"\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010E\"\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bO\u0010E\"\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010E\"\u0016\u0010R\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\bS\u0010T\"\u0016\u0010V\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\bW\u0010T\"\u0016\u0010X\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\bY\u0010T\"\u0016\u0010Z\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\b[\u0010T\"\u000e\u0010\\\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010^\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010_\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010`\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010a\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010b\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010c\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010d\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010f\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010i\"\u0014\u0010j\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010i\"\u000e\u0010l\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010m\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010n\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010o\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010p\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010q\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"LinearProgressIndicator", "", "progress", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "LinearProgressIndicator-_5eSR-E", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "gapSize", "Landroidx/compose/ui/unit/Dp;", "drawStopIndicator", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "LinearProgressIndicator-GJbTh5U", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJIFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-rIrjwxo", "(Landroidx/compose/ui/Modifier;JJIFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "drawLinearIndicator", "startFraction", "endFraction", "strokeWidth", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "CircularProgressIndicator", "CircularProgressIndicator-DUhRLBM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-IyT6zlY", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJIFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-4lLiAd8", "(Landroidx/compose/ui/Modifier;JFJIFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "circularIndeterminateGlobalRotationAnimationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "getCircularIndeterminateGlobalRotationAnimationSpec", "()Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "circularIndeterminateRotationAnimationSpec", "getCircularIndeterminateRotationAnimationSpec", "circularIndeterminateProgressAnimationSpec", "getCircularIndeterminateProgressAnimationSpec", "linearIndeterminateFirstLineHeadAnimationSpec", "getLinearIndeterminateFirstLineHeadAnimationSpec", "linearIndeterminateFirstLineTailAnimationSpec", "getLinearIndeterminateFirstLineTailAnimationSpec", "linearIndeterminateSecondLineHeadAnimationSpec", "getLinearIndeterminateSecondLineHeadAnimationSpec", "linearIndeterminateSecondLineTailAnimationSpec", "getLinearIndeterminateSecondLineTailAnimationSpec", "LinearIndicatorWidth", "getLinearIndicatorWidth", "()F", "F", "LinearIndicatorHeight", "getLinearIndicatorHeight", "StopIndicatorTrailingSpace", "getStopIndicatorTrailingSpace", "CircularIndicatorDiameter", "getCircularIndicatorDiameter", "LinearAnimationDuration", "", "FirstLineHeadDuration", "FirstLineTailDuration", "SecondLineHeadDuration", "SecondLineTailDuration", "FirstLineHeadDelay", "FirstLineTailDelay", "SecondLineHeadDelay", "SecondLineTailDelay", "LinearIndeterminateProgressEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getLinearIndeterminateProgressEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "CircularProgressEasing", "getCircularProgressEasing", "CircularIndeterminateMinProgress", "CircularIndeterminateMaxProgress", "CircularAnimationProgressDuration", "CircularAnimationAdditionalRotationDelay", "CircularAnimationAdditionalRotationDuration", "CircularAdditionalRotationDegreesTarget", "CircularGlobalRotationDegreesTarget", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ProgressIndicatorKt {
    public static final float CircularAdditionalRotationDegreesTarget = 360.0f;
    public static final int CircularAnimationAdditionalRotationDelay = 1500;
    public static final int CircularAnimationAdditionalRotationDuration = 300;
    public static final int CircularAnimationProgressDuration = 6000;
    public static final float CircularGlobalRotationDegreesTarget = 1080.0f;
    public static final float CircularIndeterminateMaxProgress = 0.87f;
    public static final float CircularIndeterminateMinProgress = 0.1f;
    public static final int FirstLineHeadDelay = 0;
    public static final int FirstLineHeadDuration = 1000;
    public static final int FirstLineTailDelay = 250;
    public static final int FirstLineTailDuration = 1000;
    public static final int LinearAnimationDuration = 1750;
    public static final int SecondLineHeadDelay = 650;
    public static final int SecondLineHeadDuration = 850;
    public static final int SecondLineTailDelay = 900;
    public static final int SecondLineTailDuration = 850;
    private static final float LinearIndicatorWidth = Dp.m9114constructorimpl(240.0f);
    private static final float LinearIndicatorHeight = LinearProgressIndicatorTokens.INSTANCE.m5084getHeightD9Ej5fM();
    private static final float StopIndicatorTrailingSpace = Dp.m9114constructorimpl(6.0f);
    private static final float CircularIndicatorDiameter = CircularProgressIndicatorTokens.INSTANCE.m4793getSizeD9Ej5fM();
    private static final CubicBezierEasing LinearIndeterminateProgressEasing = MotionTokens.INSTANCE.getEasingEmphasizedAccelerateCubicBezier();
    private static final CubicBezierEasing CircularProgressEasing = MotionTokens.INSTANCE.getEasingStandardCubicBezier();

    /* JADX WARN: Removed duplicated region for block: B:143:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cf  */
    /* JADX INFO: renamed from: CircularProgressIndicator-4lLiAd8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3943CircularProgressIndicator4lLiAd8(Modifier modifier, long j, float f, long j2, int i, float f2, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long circularColor;
        float fM3939getCircularStrokeWidthD9Ej5fM;
        long j3;
        int i5;
        int iM3937getCircularIndeterminateStrokeCapKaPHkGw;
        int i6;
        float f3;
        Composer composer2;
        final Modifier modifier3;
        final long j4;
        final float f4;
        final float f5;
        final int i7;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long circularIndeterminateTrackColor;
        final float fM3938getCircularIndicatorTrackGapSizeD9Ej5fM;
        final int i8;
        final long j6;
        final long j7;
        final float f6;
        Composer composerStartRestartGroup = composer.startRestartGroup(333154241);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)N(modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap,gapSize:c#ui.unit.Dp)631@26690L7,633@26785L28,636@26938L195,644@27283L193,653@27649L216,659@27940L734,659@27871L803:ProgressIndicator.kt#uh7d8r");
        int i9 = i3 & 1;
        if (i9 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            circularColor = j;
            i4 |= ((i3 & 2) == 0 && composerStartRestartGroup.changed(circularColor)) ? 32 : 16;
        } else {
            circularColor = j;
        }
        int i10 = i3 & 4;
        if (i10 != 0) {
            i4 |= 384;
        } else {
            if ((i2 & 384) == 0) {
                fM3939getCircularStrokeWidthD9Ej5fM = f;
                i4 |= composerStartRestartGroup.changed(fM3939getCircularStrokeWidthD9Ej5fM) ? 256 : 128;
            }
            if ((i2 & 3072) != 0) {
                j3 = j2;
                i4 |= ((i3 & 8) == 0 && composerStartRestartGroup.changed(j3)) ? 2048 : 1024;
            } else {
                j3 = j2;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    iM3937getCircularIndeterminateStrokeCapKaPHkGw = i;
                    i4 |= composerStartRestartGroup.changed(iM3937getCircularIndeterminateStrokeCapKaPHkGw) ? 16384 : 8192;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f3 = f2;
                } else {
                    f3 = f2;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= composerStartRestartGroup.changed(f3) ? 131072 : 65536;
                    }
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 74899) != 74898, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "625@26324L13,627@26458L31");
                    if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        companion = i9 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i3 & 2) != 0) {
                            circularColor = ProgressIndicatorDefaults.INSTANCE.getCircularColor(composerStartRestartGroup, 6);
                            i4 &= -113;
                        }
                        if (i10 != 0) {
                            fM3939getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3939getCircularStrokeWidthD9Ej5fM();
                        }
                        if ((i3 & 8) != 0) {
                            circularIndeterminateTrackColor = ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateTrackColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            circularIndeterminateTrackColor = j3;
                        }
                        if (i5 != 0) {
                            iM3937getCircularIndeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3937getCircularIndeterminateStrokeCapKaPHkGw();
                        }
                        fM3938getCircularIndicatorTrackGapSizeD9Ej5fM = i6 != 0 ? ProgressIndicatorDefaults.INSTANCE.m3938getCircularIndicatorTrackGapSizeD9Ej5fM() : f3;
                        i8 = iM3937getCircularIndeterminateStrokeCapKaPHkGw;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 2) != 0) {
                            i4 &= -113;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                        companion = modifier2;
                        fM3938getCircularIndicatorTrackGapSizeD9Ej5fM = f3;
                        i8 = iM3937getCircularIndeterminateStrokeCapKaPHkGw;
                        circularIndeterminateTrackColor = j3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(333154241, i4, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:630)");
                    }
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Stroke stroke = new Stroke(((Density) objConsume).mo1624toPx0680j_4(fM3939getCircularStrokeWidthD9Ej5fM), 0.0f, i8, 0, null, 26, null);
                    InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
                    final State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1080.0f, getCircularIndeterminateGlobalRotationAnimationSpec(), null, composerStartRestartGroup, InfiniteTransition.$stable | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL | (InfiniteRepeatableSpec.$stable << 9), 8);
                    final State<Float> stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 360.0f, getCircularIndeterminateRotationAnimationSpec(), null, composerStartRestartGroup, InfiniteTransition.$stable | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL | (InfiniteRepeatableSpec.$stable << 9), 8);
                    final State<Float> stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.1f, 0.87f, getCircularIndeterminateProgressAnimationSpec(), null, composerStartRestartGroup, InfiniteTransition.$stable | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL | (InfiniteRepeatableSpec.$stable << 9), 8);
                    Modifier modifierM2083size3ABfNKs = SizeKt.m2083size3ABfNKs(ProgressSemanticsKt.progressSemantics(companion), CircularIndicatorDiameter);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1961263937, "CC(remember):ProgressIndicator.kt#9igjgp");
                    Modifier modifier4 = companion;
                    boolean zChanged = ((57344 & i4) == 16384) | composerStartRestartGroup.changed(stateAnimateFloat3) | ((458752 & i4) == 131072) | ((i4 & 896) == 256) | composerStartRestartGroup.changed(stateAnimateFloat) | composerStartRestartGroup.changed(stateAnimateFloat2) | ((((i4 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(circularIndeterminateTrackColor)) || (i4 & 3072) == 2048) | composerStartRestartGroup.changedInstance(stroke) | ((((i4 & 112) ^ 48) > 32 && composerStartRestartGroup.changed(circularColor)) || (i4 & 48) == 32);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        j6 = circularIndeterminateTrackColor;
                        j7 = circularColor;
                        f6 = fM3939getCircularStrokeWidthD9Ej5fM;
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda28
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ProgressIndicatorKt.CircularProgressIndicator_4lLiAd8$lambda$34$lambda$33(stateAnimateFloat3, i8, fM3938getCircularIndicatorTrackGapSizeD9Ej5fM, f6, stateAnimateFloat, stateAnimateFloat2, j6, stroke, j7, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        j6 = circularIndeterminateTrackColor;
                        j7 = circularColor;
                        f6 = fM3939getCircularStrokeWidthD9Ej5fM;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierM2083size3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    composer2 = composerStartRestartGroup;
                    i7 = i8;
                    f4 = fM3938getCircularIndicatorTrackGapSizeD9Ej5fM;
                    f5 = f6;
                    j5 = j6;
                    j4 = j7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j4 = circularColor;
                    f4 = f3;
                    f5 = fM3939getCircularStrokeWidthD9Ej5fM;
                    i7 = iM3937getCircularIndeterminateStrokeCapKaPHkGw;
                    j5 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ProgressIndicatorKt.CircularProgressIndicator_4lLiAd8$lambda$35(modifier3, j4, f5, j5, i7, f4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            iM3937getCircularIndeterminateStrokeCapKaPHkGw = i;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 74899) != 74898, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        fM3939getCircularStrokeWidthD9Ej5fM = f;
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 != 0) {
        }
        iM3937getCircularIndeterminateStrokeCapKaPHkGw = i;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 74899) != 74898, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cf  */
    @Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @ReplaceWith(expression = "CircularProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\nstrokeWidth = strokeWidth,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* JADX INFO: renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3944CircularProgressIndicatorDUhRLBM(final float f, Modifier modifier, long j, float f2, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long circularColor;
        int i5;
        float fM3939getCircularStrokeWidthD9Ej5fM;
        long circularTrackColor;
        int i6;
        int i7;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final float f3;
        final long j4;
        final int i8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int iM3936getCircularDeterminateStrokeCapKaPHkGw;
        boolean z;
        float f4;
        long j5;
        int i9;
        Modifier modifier4;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1472321743);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)706@29604L12,705@29558L216:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    circularColor = j;
                    int i11 = composerStartRestartGroup.changed(circularColor) ? 256 : 128;
                    i4 |= i11;
                } else {
                    circularColor = j;
                }
                i4 |= i11;
            } else {
                circularColor = j;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    fM3939getCircularStrokeWidthD9Ej5fM = f2;
                    i4 |= composerStartRestartGroup.changed(fM3939getCircularStrokeWidthD9Ej5fM) ? 2048 : 1024;
                }
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        circularTrackColor = j2;
                        int i12 = composerStartRestartGroup.changed(circularTrackColor) ? 16384 : 8192;
                        i4 |= i12;
                    } else {
                        circularTrackColor = j2;
                    }
                    i4 |= i12;
                } else {
                    circularTrackColor = j2;
                }
                i6 = i3 & 32;
                if (i6 == 0) {
                    if ((196608 & i2) == 0) {
                        i7 = i;
                        i4 |= composerStartRestartGroup.changed(i7) ? 131072 : 65536;
                    }
                    if (composerStartRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        j3 = circularColor;
                        f3 = fM3939getCircularStrokeWidthD9Ej5fM;
                        j4 = circularTrackColor;
                        i8 = i7;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "700@29313L13,702@29447L18");
                        if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                circularColor = ProgressIndicatorDefaults.INSTANCE.getCircularColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if (i5 != 0) {
                                fM3939getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3939getCircularStrokeWidthD9Ej5fM();
                            }
                            if ((i3 & 16) != 0) {
                                circularTrackColor = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            }
                            if (i6 != 0) {
                                iM3936getCircularDeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3936getCircularDeterminateStrokeCapKaPHkGw();
                                z = false;
                                f4 = fM3939getCircularStrokeWidthD9Ej5fM;
                                j5 = circularTrackColor;
                                i9 = -1472321743;
                                modifier4 = modifier2;
                            }
                            long j6 = circularColor;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:705)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1856924995, "CC(remember):ProgressIndicator.kt#9igjgp");
                            if ((i4 & 14) == 4) {
                                z = true;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda21
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(ProgressIndicatorKt.CircularProgressIndicator_DUhRLBM$lambda$37$lambda$36(f));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            m3946CircularProgressIndicatorIyT6zlY((Function0) objRememberedValue, modifier4, j6, f4, j5, iM3936getCircularDeterminateStrokeCapKaPHkGw, 0.0f, composer2, i4 & 524272, 64);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            j3 = j6;
                            f3 = f4;
                            j4 = j5;
                            i8 = iM3936getCircularDeterminateStrokeCapKaPHkGw;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                        }
                        f4 = fM3939getCircularStrokeWidthD9Ej5fM;
                        z = false;
                        i9 = -1472321743;
                        modifier4 = modifier2;
                        iM3936getCircularDeterminateStrokeCapKaPHkGw = i7;
                        j5 = circularTrackColor;
                        long j62 = circularColor;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1856924995, "CC(remember):ProgressIndicator.kt#9igjgp");
                        if ((i4 & 14) == 4) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda21
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(ProgressIndicatorKt.CircularProgressIndicator_DUhRLBM$lambda$37$lambda$36(f));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            m3946CircularProgressIndicatorIyT6zlY((Function0) objRememberedValue, modifier4, j62, f4, j5, iM3936getCircularDeterminateStrokeCapKaPHkGw, 0.0f, composer2, i4 & 524272, 64);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier4;
                            j3 = j62;
                            f3 = f4;
                            j4 = j5;
                            i8 = iM3936getCircularDeterminateStrokeCapKaPHkGw;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ProgressIndicatorKt.CircularProgressIndicator_DUhRLBM$lambda$38(f, modifier3, j3, f3, j4, i8, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i7 = i;
                if (composerStartRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            fM3939getCircularStrokeWidthD9Ej5fM = f2;
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 == 0) {
            }
            i7 = i;
            if (composerStartRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        fM3939getCircularStrokeWidthD9Ej5fM = f2;
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 == 0) {
        }
        i7 = i;
        if (composerStartRestartGroup.shouldExecute((i4 & 74899) == 74898, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c9  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyCircularProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "CircularProgressIndicator(progress, modifier, color, strokeWidth, trackColor, strokeCap, gapSize)", imports = {}))
    /* JADX INFO: renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3945CircularProgressIndicatorDUhRLBM(final Function0 function0, Modifier modifier, long j, float f, long j2, int i, Composer composer, final int i2, final int i3) {
        Function0 function02;
        int i4;
        Modifier modifier2;
        long circularColor;
        int i5;
        float fM3939getCircularStrokeWidthD9Ej5fM;
        long circularDeterminateTrackColor;
        int i6;
        int i7;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final float f2;
        final long j4;
        final int i8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long j5;
        int iM3936getCircularDeterminateStrokeCapKaPHkGw;
        Modifier modifier4;
        long j6;
        float f3;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-761680467);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)481@19831L218:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i2 & 6) == 0) {
                i4 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    circularColor = j;
                    int i11 = composerStartRestartGroup.changed(circularColor) ? 256 : 128;
                    i4 |= i11;
                } else {
                    circularColor = j;
                }
                i4 |= i11;
            } else {
                circularColor = j;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i2 & 3072) == 0) {
                    fM3939getCircularStrokeWidthD9Ej5fM = f;
                    i4 |= composerStartRestartGroup.changed(fM3939getCircularStrokeWidthD9Ej5fM) ? 2048 : 1024;
                }
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        circularDeterminateTrackColor = j2;
                        int i12 = composerStartRestartGroup.changed(circularDeterminateTrackColor) ? 16384 : 8192;
                        i4 |= i12;
                    } else {
                        circularDeterminateTrackColor = j2;
                    }
                    i4 |= i12;
                } else {
                    circularDeterminateTrackColor = j2;
                }
                i6 = i3 & 32;
                if (i6 == 0) {
                    if ((196608 & i2) == 0) {
                        i7 = i;
                        i4 |= composerStartRestartGroup.changed(i7) ? 131072 : 65536;
                    }
                    if (composerStartRestartGroup.shouldExecute((74899 & i4) == 74898, i4 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        j3 = circularColor;
                        f2 = fM3939getCircularStrokeWidthD9Ej5fM;
                        j4 = circularDeterminateTrackColor;
                        i8 = i7;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "476@19575L13,478@19709L29");
                        if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                            if ((i3 & 4) != 0) {
                                circularColor = ProgressIndicatorDefaults.INSTANCE.getCircularColor(composerStartRestartGroup, 6);
                                i4 &= -897;
                            }
                            if (i5 != 0) {
                                fM3939getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3939getCircularStrokeWidthD9Ej5fM();
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                                circularDeterminateTrackColor = ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateTrackColor(composerStartRestartGroup, 6);
                            }
                            if (i6 != 0) {
                                iM3936getCircularDeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3936getCircularDeterminateStrokeCapKaPHkGw();
                                f3 = fM3939getCircularStrokeWidthD9Ej5fM;
                                j5 = circularDeterminateTrackColor;
                                modifier4 = companion;
                                j6 = circularColor;
                            } else {
                                j5 = circularDeterminateTrackColor;
                                iM3936getCircularDeterminateStrokeCapKaPHkGw = i7;
                                modifier4 = companion;
                                j6 = circularColor;
                                f3 = fM3939getCircularStrokeWidthD9Ej5fM;
                            }
                            i9 = -761680467;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                            j5 = circularDeterminateTrackColor;
                            iM3936getCircularDeterminateStrokeCapKaPHkGw = i7;
                            i9 = -761680467;
                            modifier4 = modifier2;
                            j6 = circularColor;
                            f3 = fM3939getCircularStrokeWidthD9Ej5fM;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i9, i4, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:480)");
                        }
                        composer2 = composerStartRestartGroup;
                        m3946CircularProgressIndicatorIyT6zlY(function02, modifier4, j6, f3, j5, iM3936getCircularDeterminateStrokeCapKaPHkGw, ProgressIndicatorDefaults.INSTANCE.m3938getCircularIndicatorTrackGapSizeD9Ej5fM(), composer2, (i4 & 14) | 1572864 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (i4 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        j3 = j6;
                        f2 = f3;
                        j4 = j5;
                        i8 = iM3936getCircularDeterminateStrokeCapKaPHkGw;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ProgressIndicatorKt.CircularProgressIndicator_DUhRLBM$lambda$20(function0, modifier3, j3, f2, j4, i8, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i7 = i;
                if (composerStartRestartGroup.shouldExecute((74899 & i4) == 74898, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            fM3939getCircularStrokeWidthD9Ej5fM = f;
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 == 0) {
            }
            i7 = i;
            if (composerStartRestartGroup.shouldExecute((74899 & i4) == 74898, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        fM3939getCircularStrokeWidthD9Ej5fM = f;
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 == 0) {
        }
        i7 = i;
        if (composerStartRestartGroup.shouldExecute((74899 & i4) == 74898, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e8  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: CircularProgressIndicator-IyT6zlY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3946CircularProgressIndicatorIyT6zlY(final Function0<Float> function0, Modifier modifier, long j, float f, long j2, int i, float f2, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long circularColor;
        int i5;
        float fM3939getCircularStrokeWidthD9Ej5fM;
        long j3;
        int i6;
        int iM3936getCircularDeterminateStrokeCapKaPHkGw;
        int i7;
        float f3;
        final long j4;
        final float f4;
        final float fM3938getCircularIndicatorTrackGapSizeD9Ej5fM;
        final int i8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long circularDeterminateTrackColor;
        boolean z;
        Object objRememberedValue;
        final Function0 function02;
        final Stroke stroke;
        boolean zChanged;
        Object objRememberedValue2;
        boolean zChanged2;
        Object objRememberedValue3;
        final long j5;
        final long j6;
        final float f5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1798883595);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap,gapSize:c#ui.unit.Dp)527@22030L35,528@22101L7,531@22243L241,537@22536L693,529@22170L1059:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i9 = i3 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                circularColor = j;
                i4 |= ((i3 & 4) == 0 && composerStartRestartGroup.changed(circularColor)) ? 256 : 128;
            } else {
                circularColor = j;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 3072) == 0) {
                    fM3939getCircularStrokeWidthD9Ej5fM = f;
                    i4 |= composerStartRestartGroup.changed(fM3939getCircularStrokeWidthD9Ej5fM) ? 2048 : 1024;
                }
                if ((i2 & 24576) == 0) {
                    j3 = j2;
                    i4 |= ((i3 & 16) == 0 && composerStartRestartGroup.changed(j3)) ? 16384 : 8192;
                } else {
                    j3 = j2;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    iM3936getCircularDeterminateStrokeCapKaPHkGw = i;
                } else {
                    iM3936getCircularDeterminateStrokeCapKaPHkGw = i;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= composerStartRestartGroup.changed(iM3936getCircularDeterminateStrokeCapKaPHkGw) ? 131072 : 65536;
                    }
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                    f3 = f2;
                } else {
                    f3 = f2;
                    if ((i2 & 1572864) == 0) {
                        i4 |= composerStartRestartGroup.changed(f3) ? 1048576 : 524288;
                    }
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "521@21677L13,523@21811L29");
                    if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            circularColor = ProgressIndicatorDefaults.INSTANCE.getCircularColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if (i5 != 0) {
                            fM3939getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3939getCircularStrokeWidthD9Ej5fM();
                        }
                        if ((i3 & 16) != 0) {
                            circularDeterminateTrackColor = ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateTrackColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            circularDeterminateTrackColor = j3;
                        }
                        if (i6 != 0) {
                            iM3936getCircularDeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3936getCircularDeterminateStrokeCapKaPHkGw();
                        }
                        if (i7 != 0) {
                            fM3938getCircularIndicatorTrackGapSizeD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3938getCircularIndicatorTrackGapSizeD9Ej5fM();
                        }
                        i8 = iM3936getCircularDeterminateStrokeCapKaPHkGw;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1798883595, i4, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:526)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2144702904, "CC(remember):ProgressIndicator.kt#9igjgp");
                        z = (i4 & 14) != 4;
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda24
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(ProgressIndicatorKt.CircularProgressIndicator_IyT6zlY$lambda$22$lambda$21(function0));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function02 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        stroke = new Stroke(((Density) objConsume).mo1624toPx0680j_4(fM3939getCircularStrokeWidthD9Ej5fM), 0.0f, i8, 0, null, 26, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2144709926, "CC(remember):ProgressIndicator.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(function02);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda25
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ProgressIndicatorKt.CircularProgressIndicator_IyT6zlY$lambda$26$lambda$25(function02, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierM2083size3ABfNKs = SizeKt.m2083size3ABfNKs(SemanticsModifierKt.semantics(modifier2, true, (Function1) objRememberedValue2), CircularIndicatorDiameter);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2144719754, "CC(remember):ProgressIndicator.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(function02) | ((458752 & i4) != 131072) | ((3670016 & i4) != 1048576) | ((i4 & 7168) != 2048) | ((((57344 & i4) ^ 24576) <= 16384 && composerStartRestartGroup.changed(circularDeterminateTrackColor)) || (i4 & 24576) == 16384) | composerStartRestartGroup.changedInstance(stroke) | ((((i4 & 896) ^ 384) > 256 && composerStartRestartGroup.changed(circularColor)) || (i4 & 384) == 256);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            j5 = circularDeterminateTrackColor;
                            j6 = circularColor;
                            f5 = fM3939getCircularStrokeWidthD9Ej5fM;
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda26
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ProgressIndicatorKt.CircularProgressIndicator_IyT6zlY$lambda$28$lambda$27(function02, i8, fM3938getCircularIndicatorTrackGapSizeD9Ej5fM, f5, j5, stroke, j6, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            j5 = circularDeterminateTrackColor;
                            j6 = circularColor;
                            f5 = fM3939getCircularStrokeWidthD9Ej5fM;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierM2083size3ABfNKs, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f4 = f5;
                        j3 = j5;
                        j4 = j6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                        }
                        circularDeterminateTrackColor = j3;
                    }
                    fM3938getCircularIndicatorTrackGapSizeD9Ej5fM = f3;
                    i8 = iM3936getCircularDeterminateStrokeCapKaPHkGw;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2144702904, "CC(remember):ProgressIndicator.kt#9igjgp");
                    if ((i4 & 14) != 4) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda24
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(ProgressIndicatorKt.CircularProgressIndicator_IyT6zlY$lambda$22$lambda$21(function0));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        function02 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        stroke = new Stroke(((Density) objConsume2).mo1624toPx0680j_4(fM3939getCircularStrokeWidthD9Ej5fM), 0.0f, i8, 0, null, 26, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2144709926, "CC(remember):ProgressIndicator.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(function02);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda25
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ProgressIndicatorKt.CircularProgressIndicator_IyT6zlY$lambda$26$lambda$25(function02, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierM2083size3ABfNKs2 = SizeKt.m2083size3ABfNKs(SemanticsModifierKt.semantics(modifier2, true, (Function1) objRememberedValue2), CircularIndicatorDiameter);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2144719754, "CC(remember):ProgressIndicator.kt#9igjgp");
                            if (((57344 & i4) ^ 24576) <= 16384) {
                                if (((i4 & 896) ^ 384) > 256) {
                                    zChanged2 = composerStartRestartGroup.changed(function02) | ((458752 & i4) != 131072) | ((3670016 & i4) != 1048576) | ((i4 & 7168) != 2048) | ((((57344 & i4) ^ 24576) <= 16384 && composerStartRestartGroup.changed(circularDeterminateTrackColor)) || (i4 & 24576) == 16384) | composerStartRestartGroup.changedInstance(stroke) | ((((i4 & 896) ^ 384) > 256 && composerStartRestartGroup.changed(circularColor)) || (i4 & 384) == 256);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged2) {
                                        j5 = circularDeterminateTrackColor;
                                        j6 = circularColor;
                                        f5 = fM3939getCircularStrokeWidthD9Ej5fM;
                                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda26
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return ProgressIndicatorKt.CircularProgressIndicator_IyT6zlY$lambda$28$lambda$27(function02, i8, fM3938getCircularIndicatorTrackGapSizeD9Ej5fM, f5, j5, stroke, j6, (DrawScope) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        CanvasKt.Canvas(modifierM2083size3ABfNKs2, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        f4 = f5;
                                        j3 = j5;
                                        j4 = j6;
                                    }
                                } else {
                                    zChanged2 = composerStartRestartGroup.changed(function02) | ((458752 & i4) != 131072) | ((3670016 & i4) != 1048576) | ((i4 & 7168) != 2048) | ((((57344 & i4) ^ 24576) <= 16384 && composerStartRestartGroup.changed(circularDeterminateTrackColor)) || (i4 & 24576) == 16384) | composerStartRestartGroup.changedInstance(stroke) | ((((i4 & 896) ^ 384) > 256 && composerStartRestartGroup.changed(circularColor)) || (i4 & 384) == 256);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged2) {
                                    }
                                }
                            }
                        }
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    j4 = circularColor;
                    f4 = fM3939getCircularStrokeWidthD9Ej5fM;
                    fM3938getCircularIndicatorTrackGapSizeD9Ej5fM = f3;
                    i8 = iM3936getCircularDeterminateStrokeCapKaPHkGw;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    final long j7 = j3;
                    final int i10 = i8;
                    final float f6 = fM3938getCircularIndicatorTrackGapSizeD9Ej5fM;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ProgressIndicatorKt.CircularProgressIndicator_IyT6zlY$lambda$29(function0, modifier3, j4, f4, j7, i10, f6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 3072;
            fM3939getCircularStrokeWidthD9Ej5fM = f;
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i3 & 64;
            if (i7 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 != 0) {
        }
        fM3939getCircularStrokeWidthD9Ej5fM = f;
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i3 & 64;
        if (i7 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0150  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`", replaceWith = @ReplaceWith(expression = "CircularProgressIndicator(modifier, color, strokeWidth, trackColor, strokeCap, gapSize)", imports = {}))
    /* JADX INFO: renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3947CircularProgressIndicatorLxG7B9w(Modifier modifier, long j, float f, long j2, int i, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long circularColor;
        float fM3939getCircularStrokeWidthD9Ej5fM;
        long circularIndeterminateTrackColor;
        int i5;
        int i6;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final float f2;
        final long j4;
        final int i7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float f3;
        int iM3937getCircularIndeterminateStrokeCapKaPHkGw;
        Modifier modifier4;
        long j5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-115871647);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)N(modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)594@24879L258:ProgressIndicator.kt#uh7d8r");
        int i8 = i3 & 1;
        if (i8 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            if ((i3 & 2) == 0) {
                circularColor = j;
                int i9 = composerStartRestartGroup.changed(circularColor) ? 32 : 16;
                i4 |= i9;
            } else {
                circularColor = j;
            }
            i4 |= i9;
        } else {
            circularColor = j;
        }
        int i10 = i3 & 4;
        if (i10 != 0) {
            i4 |= 384;
        } else {
            if ((i2 & 384) == 0) {
                fM3939getCircularStrokeWidthD9Ej5fM = f;
                i4 |= composerStartRestartGroup.changed(fM3939getCircularStrokeWidthD9Ej5fM) ? 256 : 128;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    circularIndeterminateTrackColor = j2;
                    int i11 = composerStartRestartGroup.changed(circularIndeterminateTrackColor) ? 2048 : 1024;
                    i4 |= i11;
                } else {
                    circularIndeterminateTrackColor = j2;
                }
                i4 |= i11;
            } else {
                circularIndeterminateTrackColor = j2;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    i6 = i;
                    i4 |= composerStartRestartGroup.changed(i6) ? 16384 : 8192;
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "589@24619L13,591@24753L31");
                    if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i3 & 2) != 0) {
                            circularColor = ProgressIndicatorDefaults.INSTANCE.getCircularColor(composerStartRestartGroup, 6);
                            i4 &= -113;
                        }
                        if (i10 != 0) {
                            fM3939getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3939getCircularStrokeWidthD9Ej5fM();
                        }
                        if ((i3 & 8) != 0) {
                            circularIndeterminateTrackColor = ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateTrackColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            iM3937getCircularIndeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3937getCircularIndeterminateStrokeCapKaPHkGw();
                            f3 = fM3939getCircularStrokeWidthD9Ej5fM;
                            j5 = circularIndeterminateTrackColor;
                            modifier4 = companion;
                            long j6 = circularColor;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-115871647, i4, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:594)");
                            }
                            composer2 = composerStartRestartGroup;
                            m3943CircularProgressIndicator4lLiAd8(modifier4, j6, f3, j5, iM3937getCircularIndeterminateStrokeCapKaPHkGw, ProgressIndicatorDefaults.INSTANCE.m3938getCircularIndicatorTrackGapSizeD9Ej5fM(), composer2, (i4 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            j3 = j6;
                            f2 = f3;
                            j4 = j5;
                            i7 = iM3937getCircularIndeterminateStrokeCapKaPHkGw;
                        } else {
                            f3 = fM3939getCircularStrokeWidthD9Ej5fM;
                            iM3937getCircularIndeterminateStrokeCapKaPHkGw = i6;
                            modifier4 = companion;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 2) != 0) {
                            i4 &= -113;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                        f3 = fM3939getCircularStrokeWidthD9Ej5fM;
                        iM3937getCircularIndeterminateStrokeCapKaPHkGw = i6;
                        modifier4 = modifier2;
                    }
                    j5 = circularIndeterminateTrackColor;
                    long j62 = circularColor;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = composerStartRestartGroup;
                    m3943CircularProgressIndicator4lLiAd8(modifier4, j62, f3, j5, iM3937getCircularIndeterminateStrokeCapKaPHkGw, ProgressIndicatorDefaults.INSTANCE.m3938getCircularIndicatorTrackGapSizeD9Ej5fM(), composer2, (i4 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier4;
                    j3 = j62;
                    f2 = f3;
                    j4 = j5;
                    i7 = iM3937getCircularIndeterminateStrokeCapKaPHkGw;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = circularColor;
                    f2 = fM3939getCircularStrokeWidthD9Ej5fM;
                    j4 = circularIndeterminateTrackColor;
                    i7 = i6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$30(modifier3, j3, f2, j4, i7, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            i6 = i;
            if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        fM3939getCircularStrokeWidthD9Ej5fM = f;
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 != 0) {
        }
        i6 = i;
        if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3948CircularProgressIndicatorMBs18nI(final float f, Modifier modifier, long j, float f2, Composer composer, final int i, final int i2) {
        float f3;
        int i3;
        Modifier modifier2;
        long circularColor;
        int i4;
        float f4;
        final Modifier modifier3;
        final long j2;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM3939getCircularStrokeWidthD9Ej5fM;
        long j3;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(402841196);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp)728@30267L18,723@30121L247:ProgressIndicator.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            f3 = f;
        } else if ((i & 6) == 0) {
            f3 = f;
            i3 = (composerStartRestartGroup.changed(f3) ? 4 : 2) | i;
        } else {
            f3 = f;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                circularColor = j;
                i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(circularColor)) ? 256 : 128;
            } else {
                circularColor = j;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    f4 = f2;
                    i3 |= composerStartRestartGroup.changed(f4) ? 2048 : 1024;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "720@30029L13");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            circularColor = ProgressIndicatorDefaults.INSTANCE.getCircularColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        fM3939getCircularStrokeWidthD9Ej5fM = i4 != 0 ? ProgressIndicatorDefaults.INSTANCE.m3939getCircularStrokeWidthD9Ej5fM() : f4;
                        j3 = circularColor;
                        modifier4 = companion;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        modifier4 = modifier2;
                        fM3939getCircularStrokeWidthD9Ej5fM = f4;
                        j3 = circularColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(402841196, i3, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:723)");
                    }
                    float f6 = fM3939getCircularStrokeWidthD9Ej5fM;
                    m3944CircularProgressIndicatorDUhRLBM(f3, modifier4, j3, f6, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(composerStartRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m3936getCircularDeterminateStrokeCapKaPHkGw(), composerStartRestartGroup, (i3 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    j2 = j3;
                    f5 = f6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    j2 = circularColor;
                    f5 = f4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ProgressIndicatorKt.CircularProgressIndicator_MBs18nI$lambda$39(f, modifier3, j2, f5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 3072;
            f4 = f2;
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        f4 = f2;
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3949CircularProgressIndicatoraMcp0Q(Modifier modifier, long j, float f, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long circularColor;
        float f2;
        final Modifier modifier3;
        final long j2;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM3939getCircularStrokeWidthD9Ej5fM;
        long j3;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(947193756);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)N(modifier,color:c#ui.graphics.Color,strokeWidth:c#ui.unit.Dp)744@30822L18,740@30694L231:ProgressIndicator.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            circularColor = j;
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(circularColor)) ? 32 : 16;
        } else {
            circularColor = j;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = circularColor;
                f3 = f2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "737@30602L13");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        circularColor = ProgressIndicatorDefaults.INSTANCE.getCircularColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    fM3939getCircularStrokeWidthD9Ej5fM = i5 != 0 ? ProgressIndicatorDefaults.INSTANCE.m3939getCircularStrokeWidthD9Ej5fM() : f2;
                    j3 = circularColor;
                    modifier4 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    fM3939getCircularStrokeWidthD9Ej5fM = f2;
                    j3 = circularColor;
                    modifier4 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(947193756, i3, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:740)");
                }
                m3943CircularProgressIndicator4lLiAd8(modifier4, j3, fM3939getCircularStrokeWidthD9Ej5fM, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(composerStartRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m3937getCircularIndeterminateStrokeCapKaPHkGw(), 0.0f, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896), 32);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j2 = j3;
                f3 = fM3939getCircularStrokeWidthD9Ej5fM;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ProgressIndicatorKt.CircularProgressIndicator_aM_cp0Q$lambda$40(modifier3, j2, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        f2 = f;
        if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit CircularProgressIndicator_4lLiAd8$lambda$34$lambda$33(State state, int i, float f, float f2, State state2, State state3, long j, Stroke stroke, long j2, DrawScope drawScope) {
        float fFloatValue = ((Number) state.getValue()).floatValue() * 360.0f;
        if (!StrokeCap.m6695equalsimpl0(i, StrokeCap.INSTANCE.m6699getButtKaPHkGw()) && Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) <= Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32))) {
            f = Dp.m9114constructorimpl(f + f2);
        }
        float f3 = (f / ((float) (((double) drawScope.mo1620toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)))) * 3.141592653589793d))) * 360.0f;
        float fFloatValue2 = ((Number) state2.getValue()).floatValue() + ((Number) state3.getValue()).floatValue();
        long jMo6898getCenterF1C5BW0 = drawScope.mo6898getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6820getSizeNHjbRc = drawContext.mo6820getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6826rotateUv8p0NA(fFloatValue2, jMo6898getCenterF1C5BW0);
            m3957drawCircularIndicator42QJj7c(drawScope, fFloatValue + Math.min(fFloatValue, f3), (360.0f - fFloatValue) - (Math.min(fFloatValue, f3) * 2.0f), j, stroke);
            m3959drawDeterminateCircularIndicator42QJj7c(drawScope, 0.0f, fFloatValue, j2, stroke);
            drawContext.getCanvas().restore();
            drawContext.mo6821setSizeuvyYCjk(jMo6820getSizeNHjbRc);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            drawContext.getCanvas().restore();
            drawContext.mo6821setSizeuvyYCjk(jMo6820getSizeNHjbRc);
            throw th;
        }
    }

    static final Unit CircularProgressIndicator_4lLiAd8$lambda$35(Modifier modifier, long j, float f, long j2, int i, float f2, int i2, int i3, Composer composer, int i4) {
        m3943CircularProgressIndicator4lLiAd8(modifier, j, f, j2, i, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit CircularProgressIndicator_DUhRLBM$lambda$20(Function0 function0, Modifier modifier, long j, float f, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m3945CircularProgressIndicatorDUhRLBM(function0, modifier, j, f, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final float CircularProgressIndicator_DUhRLBM$lambda$37$lambda$36(float f) {
        return f;
    }

    static final Unit CircularProgressIndicator_DUhRLBM$lambda$38(float f, Modifier modifier, long j, float f2, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m3944CircularProgressIndicatorDUhRLBM(f, modifier, j, f2, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final float CircularProgressIndicator_IyT6zlY$lambda$22$lambda$21(Function0 function0) {
        float fFloatValue = ((Number) function0.invoke()).floatValue();
        if (fFloatValue < 0.0f) {
            fFloatValue = 0.0f;
        }
        if (fFloatValue > 1.0f) {
            return 1.0f;
        }
        return fFloatValue;
    }

    static final Unit CircularProgressIndicator_IyT6zlY$lambda$26$lambda$25(Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Object objInvoke = function0.invoke();
        if (Float.isNaN(((Number) objInvoke).floatValue())) {
            objInvoke = null;
        }
        Float f = (Float) objInvoke;
        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(f != null ? f.floatValue() : 0.0f, RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
        return Unit.INSTANCE;
    }

    static final Unit CircularProgressIndicator_IyT6zlY$lambda$28$lambda$27(Function0 function0, int i, float f, float f2, long j, Stroke stroke, long j2, DrawScope drawScope) {
        float fFloatValue = ((Number) function0.invoke()).floatValue() * 360.0f;
        if (!StrokeCap.m6695equalsimpl0(i, StrokeCap.INSTANCE.m6699getButtKaPHkGw()) && Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) <= Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32))) {
            f = Dp.m9114constructorimpl(f + f2);
        }
        float f3 = (f / ((float) (((double) drawScope.mo1620toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)))) * 3.141592653589793d))) * 360.0f;
        m3957drawCircularIndicator42QJj7c(drawScope, 270.0f + fFloatValue + Math.min(fFloatValue, f3), (360.0f - fFloatValue) - (Math.min(fFloatValue, f3) * 2.0f), j, stroke);
        m3959drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, fFloatValue, j2, stroke);
        return Unit.INSTANCE;
    }

    static final Unit CircularProgressIndicator_IyT6zlY$lambda$29(Function0 function0, Modifier modifier, long j, float f, long j2, int i, float f2, int i2, int i3, Composer composer, int i4) {
        m3946CircularProgressIndicatorIyT6zlY(function0, modifier, j, f, j2, i, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit CircularProgressIndicator_LxG7B9w$lambda$30(Modifier modifier, long j, float f, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m3947CircularProgressIndicatorLxG7B9w(modifier, j, f, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit CircularProgressIndicator_MBs18nI$lambda$39(float f, Modifier modifier, long j, float f2, int i, int i2, Composer composer, int i3) {
        m3948CircularProgressIndicatorMBs18nI(f, modifier, j, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit CircularProgressIndicator_aM_cp0Q$lambda$40(Modifier modifier, long j, float f, int i, int i2, Composer composer, int i3) {
        m3949CircularProgressIndicatoraMcp0Q(modifier, j, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyIndeterminateLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "LinearProgressIndicator(modifier, color, trackColor, strokeCap, gapSize)", imports = {}))
    /* JADX INFO: renamed from: LinearProgressIndicator-2cYBFYY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3950LinearProgressIndicator2cYBFYY(Modifier modifier, long j, long j2, int i, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long linearColor;
        long linearTrackColor;
        int i5;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final int i6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long j5;
        int iM3941getLinearStrokeCapKaPHkGw;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-476865359);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)N(modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)220@9927L175:ProgressIndicator.kt#uh7d8r");
        int i7 = i3 & 1;
        if (i7 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            if ((i3 & 2) == 0) {
                linearColor = j;
                int i8 = composerStartRestartGroup.changed(linearColor) ? 32 : 16;
                i4 |= i8;
            } else {
                linearColor = j;
            }
            i4 |= i8;
        } else {
            linearColor = j;
        }
        if ((i2 & 384) == 0) {
            linearTrackColor = j2;
            i4 |= ((i3 & 4) == 0 && composerStartRestartGroup.changed(linearTrackColor)) ? 256 : 128;
        } else {
            linearTrackColor = j2;
        }
        int i9 = i3 & 8;
        if (i9 == 0) {
            if ((i2 & 3072) == 0) {
                i5 = i;
                i4 |= composerStartRestartGroup.changed(i5) ? 2048 : 1024;
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 1171) == 1170, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = linearColor;
                j4 = linearTrackColor;
                i6 = i5;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "216@9768L11,217@9831L16");
                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i3 & 2) != 0) {
                        linearColor = ProgressIndicatorDefaults.INSTANCE.getLinearColor(composerStartRestartGroup, 6);
                        i4 &= -113;
                    }
                    if ((i3 & 4) != 0) {
                        linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(composerStartRestartGroup, 6);
                        i4 &= -897;
                    }
                    if (i9 != 0) {
                        iM3941getLinearStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3941getLinearStrokeCapKaPHkGw();
                        j5 = linearTrackColor;
                    } else {
                        j5 = linearTrackColor;
                        iM3941getLinearStrokeCapKaPHkGw = i5;
                    }
                    modifier4 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 2) != 0) {
                        i4 &= -113;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    j5 = linearTrackColor;
                    iM3941getLinearStrokeCapKaPHkGw = i5;
                    modifier4 = modifier2;
                }
                long j6 = linearColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-476865359, i4, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:219)");
                }
                m3956LinearProgressIndicatorrIrjwxo(modifier4, j6, j5, iM3941getLinearStrokeCapKaPHkGw, ProgressIndicatorDefaults.INSTANCE.m3940getLinearIndicatorTrackGapSizeD9Ej5fM(), composerStartRestartGroup, (i4 & 14) | 24576 | (i4 & 112) | (i4 & 896) | (i4 & 7168), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j3 = j6;
                j4 = j5;
                i6 = iM3941getLinearStrokeCapKaPHkGw;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ProgressIndicatorKt.LinearProgressIndicator_2cYBFYY$lambda$11(modifier3, j3, j4, i6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i4 |= 3072;
        i5 = i;
        if (composerStartRestartGroup.shouldExecute((i4 & 1171) == 1170, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:192:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e4  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: LinearProgressIndicator-GJbTh5U, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3951LinearProgressIndicatorGJbTh5U(final Function0<Float> function0, Modifier modifier, long j, long j2, int i, float f, Function1<? super DrawScope, Unit> function1, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        final long linearColor;
        long linearTrackColor;
        int i5;
        int i6;
        int i7;
        float fM3940getLinearIndicatorTrackGapSizeD9Ej5fM;
        final float f2;
        Modifier.Companion companion;
        final int i8;
        final long j3;
        final Function1<? super DrawScope, Unit> function12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function1<? super DrawScope, Unit> function13;
        final float f3;
        final int i9;
        final Function1<? super DrawScope, Unit> function14;
        final long j4;
        final long j5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-339970038);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap,gapSize:c#ui.unit.Dp,drawStopIndicator)154@7102L35,158@7266L241,164@7577L806,155@7142L1241:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                linearColor = j;
                i4 |= ((i3 & 4) == 0 && composerStartRestartGroup.changed(linearColor)) ? 256 : 128;
            } else {
                linearColor = j;
            }
            if ((i2 & 3072) != 0) {
                linearTrackColor = j2;
                i4 |= ((i3 & 8) == 0 && composerStartRestartGroup.changed(linearTrackColor)) ? 2048 : 1024;
            } else {
                linearTrackColor = j2;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    i6 = i;
                    i4 |= composerStartRestartGroup.changed(i6) ? 16384 : 8192;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    fM3940getLinearIndicatorTrackGapSizeD9Ej5fM = f;
                } else {
                    fM3940getLinearIndicatorTrackGapSizeD9Ej5fM = f;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= composerStartRestartGroup.changed(fM3940getLinearIndicatorTrackGapSizeD9Ej5fM) ? 131072 : 65536;
                    }
                }
                if ((i2 & 1572864) == 0) {
                    i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changedInstance(function1)) ? 1048576 : 524288;
                }
                boolean z = true;
                if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "141@6585L11,142@6648L16,145@6855L215");
                    if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i3 & 4) != 0) {
                            linearColor = ProgressIndicatorDefaults.INSTANCE.getLinearColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        final int iM3941getLinearStrokeCapKaPHkGw = i5 != 0 ? ProgressIndicatorDefaults.INSTANCE.m3941getLinearStrokeCapKaPHkGw() : i6;
                        if (i7 != 0) {
                            fM3940getLinearIndicatorTrackGapSizeD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3940getLinearIndicatorTrackGapSizeD9Ej5fM();
                        }
                        if ((i3 & 64) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -293677151, "CC(remember):ProgressIndicator.kt#9igjgp");
                            boolean z2 = ((((i4 & 896) ^ 384) > 256 && composerStartRestartGroup.changed(linearColor)) || (i4 & 384) == 256) | ((57344 & i4) == 16384);
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ProgressIndicatorKt.LinearProgressIndicator_GJbTh5U$lambda$2$lambda$1(linearColor, iM3941getLinearStrokeCapKaPHkGw, (DrawScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function13 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i4 &= -3670017;
                        } else {
                            function13 = function1;
                        }
                        f3 = fM3940getLinearIndicatorTrackGapSizeD9Ej5fM;
                        i9 = iM3941getLinearStrokeCapKaPHkGw;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                        }
                        function13 = function1;
                        f3 = fM3940getLinearIndicatorTrackGapSizeD9Ej5fM;
                        companion = modifier2;
                        i9 = i6;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-339970038, i4, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:153)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -293669427, "CC(remember):ProgressIndicator.kt#9igjgp");
                    boolean z3 = (i4 & 14) == 4;
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(ProgressIndicatorKt.LinearProgressIndicator_GJbTh5U$lambda$4$lambda$3(function0));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final Function0 function02 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierThen = companion.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -293663973, "CC(remember):ProgressIndicator.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(function02);
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ProgressIndicatorKt.LinearProgressIndicator_GJbTh5U$lambda$7$lambda$6(function02, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM2085sizeVpY3zN4 = SizeKt.m2085sizeVpY3zN4(SemanticsModifierKt.semantics(modifierThen, true, (Function1) objRememberedValue3), LinearIndicatorWidth, LinearIndicatorHeight);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -293653456, "CC(remember):ProgressIndicator.kt#9igjgp");
                    boolean zChanged2 = ((57344 & i4) == 16384) | ((458752 & i4) == 131072) | composerStartRestartGroup.changed(function02) | ((((i4 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(linearTrackColor)) || (i4 & 3072) == 2048) | ((((i4 & 896) ^ 384) > 256 && composerStartRestartGroup.changed(linearColor)) || (i4 & 384) == 256);
                    if ((((3670016 & i4) ^ 1572864) <= 1048576 || !composerStartRestartGroup.changed(function13)) && (i4 & 1572864) != 1048576) {
                        z = false;
                    }
                    boolean z4 = z | zChanged2;
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        function14 = function13;
                        j4 = linearColor;
                        j5 = linearTrackColor;
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ProgressIndicatorKt.LinearProgressIndicator_GJbTh5U$lambda$9$lambda$8(i9, f3, function02, j5, j4, function14, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        function14 = function13;
                        j4 = linearColor;
                        j5 = linearTrackColor;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierM2085sizeVpY3zN4, (Function1) objRememberedValue4, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i8 = i9;
                    f2 = f3;
                    linearTrackColor = j5;
                    j3 = j4;
                    function12 = function14;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f2 = fM3940getLinearIndicatorTrackGapSizeD9Ej5fM;
                    companion = modifier2;
                    i8 = i6;
                    j3 = linearColor;
                    function12 = function1;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    final long j6 = linearTrackColor;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ProgressIndicatorKt.LinearProgressIndicator_GJbTh5U$lambda$10(function0, modifier3, j3, j6, i8, f2, function12, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            i6 = i;
            i7 = i3 & 32;
            if (i7 != 0) {
            }
            if ((i2 & 1572864) == 0) {
            }
            boolean z5 = true;
            if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 != 0) {
        }
        i6 = i;
        i7 = i3 & 32;
        if (i7 != 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        boolean z52 = true;
        if (composerStartRestartGroup.shouldExecute((i4 & 599187) != 599186, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ void m3952LinearProgressIndicatorRIQooxk(Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long linearColor;
        long linearTrackColor;
        final Modifier modifier3;
        final long j3;
        final long j4;
        long j5;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(585576195);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)N(modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color)391@16079L146:ProgressIndicator.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                linearColor = j;
                int i5 = composerStartRestartGroup.changed(linearColor) ? 32 : 16;
                i3 |= i5;
            } else {
                linearColor = j;
            }
            i3 |= i5;
        } else {
            linearColor = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                linearTrackColor = j2;
                int i6 = composerStartRestartGroup.changed(linearTrackColor) ? 256 : 128;
                i3 |= i6;
            } else {
                linearTrackColor = j2;
            }
            i3 |= i6;
        } else {
            linearTrackColor = j2;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "388@15990L11,389@16053L16");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    linearColor = ProgressIndicatorDefaults.INSTANCE.getLinearColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                j5 = linearTrackColor;
                modifier4 = companion;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                j5 = linearTrackColor;
                modifier4 = modifier2;
            }
            long j6 = linearColor;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585576195, i3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:391)");
            }
            m3956LinearProgressIndicatorrIrjwxo(modifier4, j6, j5, ProgressIndicatorDefaults.INSTANCE.m3941getLinearStrokeCapKaPHkGw(), 0.0f, composerStartRestartGroup, (i3 & 14) | 3072 | (i3 & 112) | (i3 & 896), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j3 = j6;
            j4 = j5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = linearColor;
            j4 = linearTrackColor;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProgressIndicatorKt.LinearProgressIndicator_RIQooxk$lambda$19(modifier3, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0153  */
    @Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @ReplaceWith(expression = "LinearProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* JADX INFO: renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3953LinearProgressIndicator_5eSRE(final float f, Modifier modifier, long j, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long linearColor;
        long linearTrackColor;
        int i5;
        int i6;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final int i7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int iM3941getLinearStrokeCapKaPHkGw;
        boolean z;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(905419617);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)360@15142L12,359@15098L179:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                linearColor = j;
                i4 |= ((i3 & 4) == 0 && composerStartRestartGroup.changed(linearColor)) ? 256 : 128;
            } else {
                linearColor = j;
            }
            if ((i2 & 3072) != 0) {
                linearTrackColor = j2;
                i4 |= ((i3 & 8) == 0 && composerStartRestartGroup.changed(linearTrackColor)) ? 2048 : 1024;
            } else {
                linearTrackColor = j2;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    i6 = i;
                    i4 |= composerStartRestartGroup.changed(i6) ? 16384 : 8192;
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "355@14939L11,356@15002L16");
                    if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            linearColor = ProgressIndicatorDefaults.INSTANCE.getLinearColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            iM3941getLinearStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3941getLinearStrokeCapKaPHkGw();
                        }
                        long j5 = linearTrackColor;
                        long j6 = linearColor;
                        Modifier modifier4 = modifier2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(905419617, i4, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:359)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1770084819, "CC(remember):ProgressIndicator.kt#9igjgp");
                        z = (i4 & 14) == 4;
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(ProgressIndicatorKt.LinearProgressIndicator__5eSR_E$lambda$16$lambda$15(f));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        m3951LinearProgressIndicatorGJbTh5U((Function0) objRememberedValue, modifier4, j6, j5, iM3941getLinearStrokeCapKaPHkGw, 0.0f, null, composer2, i4 & 65520, 96);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        j3 = j6;
                        j4 = j5;
                        i7 = iM3941getLinearStrokeCapKaPHkGw;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                    }
                    iM3941getLinearStrokeCapKaPHkGw = i6;
                    long j52 = linearTrackColor;
                    long j62 = linearColor;
                    Modifier modifier42 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1770084819, "CC(remember):ProgressIndicator.kt#9igjgp");
                    if ((i4 & 14) == 4) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(ProgressIndicatorKt.LinearProgressIndicator__5eSR_E$lambda$16$lambda$15(f));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        m3951LinearProgressIndicatorGJbTh5U((Function0) objRememberedValue, modifier42, j62, j52, iM3941getLinearStrokeCapKaPHkGw, 0.0f, null, composer2, i4 & 65520, 96);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier42;
                        j3 = j62;
                        j4 = j52;
                        i7 = iM3941getLinearStrokeCapKaPHkGw;
                    }
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = linearColor;
                    j4 = linearTrackColor;
                    i7 = i6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ProgressIndicatorKt.LinearProgressIndicator__5eSR_E$lambda$17(f, modifier3, j3, j4, i7, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            i6 = i;
            if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 != 0) {
        }
        i6 = i;
        if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0150  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize` and `drawStopIndicator`, see `LegacyLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "LinearProgressIndicator(progress, modifier, color, trackColor, strokeCap, gapSize, drawStopIndicator)", imports = {}))
    /* JADX INFO: renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3954LinearProgressIndicator_5eSRE(final Function0 function0, Modifier modifier, long j, long j2, int i, Composer composer, final int i2, final int i3) {
        Function0 function02;
        int i4;
        Modifier modifier2;
        long j3;
        long linearTrackColor;
        int i5;
        int i6;
        Composer composer2;
        final Modifier modifier3;
        final long j4;
        final long j5;
        final int i7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long linearColor;
        long j6;
        int iM3941getLinearStrokeCapKaPHkGw;
        Modifier modifier4;
        long j7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1796992155);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap)101@4670L193:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i2 & 6) == 0) {
                i4 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    int i9 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                    i4 |= i9;
                } else {
                    j3 = j;
                }
                i4 |= i9;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                linearTrackColor = j2;
                i4 |= ((i3 & 8) == 0 && composerStartRestartGroup.changed(linearTrackColor)) ? 2048 : 1024;
            } else {
                linearTrackColor = j2;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    i6 = i;
                    i4 |= composerStartRestartGroup.changed(i6) ? 16384 : 8192;
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "97@4511L11,98@4574L16");
                    if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i3 & 4) != 0) {
                            linearColor = ProgressIndicatorDefaults.INSTANCE.getLinearColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        } else {
                            linearColor = j3;
                        }
                        if ((i3 & 8) != 0) {
                            linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            iM3941getLinearStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3941getLinearStrokeCapKaPHkGw();
                            j6 = linearTrackColor;
                        } else {
                            j6 = linearTrackColor;
                            iM3941getLinearStrokeCapKaPHkGw = i6;
                        }
                        modifier4 = companion;
                        j7 = linearColor;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                        j6 = linearTrackColor;
                        iM3941getLinearStrokeCapKaPHkGw = i6;
                        modifier4 = modifier2;
                        j7 = j3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1796992155, i4, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:100)");
                    }
                    composer2 = composerStartRestartGroup;
                    m3951LinearProgressIndicatorGJbTh5U(function02, modifier4, j7, j6, iM3941getLinearStrokeCapKaPHkGw, ProgressIndicatorDefaults.INSTANCE.m3940getLinearIndicatorTrackGapSizeD9Ej5fM(), null, composer2, (i4 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (i4 & 57344), 64);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    j4 = j7;
                    j5 = j6;
                    i7 = iM3941getLinearStrokeCapKaPHkGw;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j4 = j3;
                    j5 = linearTrackColor;
                    i7 = i6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ProgressIndicatorKt.LinearProgressIndicator__5eSR_E$lambda$0(function0, modifier3, j4, j5, i7, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            i6 = i;
            if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 != 0) {
        }
        i6 = i;
        if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3955LinearProgressIndicatoreaDK9VM(final float f, Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        float f2;
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        final Modifier modifier3;
        final long j5;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long linearColor;
        long linearTrackColor;
        Modifier modifier4;
        long j7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-372717133);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color)376@15619L164:ProgressIndicator.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            f2 = f;
        } else {
            f2 = f;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(f2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    int i5 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                    i3 |= i5;
                } else {
                    j3 = j;
                }
                i3 |= i5;
            } else {
                j3 = j;
            }
            if ((i & 3072) != 0) {
                j4 = j2;
                i3 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(j4)) ? 2048 : 1024;
            } else {
                j4 = j2;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j5 = j3;
                j6 = j4;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "373@15530L11,374@15593L16");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 4) != 0) {
                        linearColor = ProgressIndicatorDefaults.INSTANCE.getLinearColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        linearColor = j3;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        modifier4 = companion;
                        j7 = linearColor;
                        linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(composerStartRestartGroup, 6);
                    } else {
                        linearTrackColor = j4;
                        modifier4 = companion;
                        j7 = linearColor;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    linearTrackColor = j4;
                    modifier4 = modifier2;
                    j7 = j3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-372717133, i3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:376)");
                }
                m3953LinearProgressIndicator_5eSRE(f2, modifier4, j7, linearTrackColor, ProgressIndicatorDefaults.INSTANCE.m3941getLinearStrokeCapKaPHkGw(), composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j5 = j7;
                j6 = linearTrackColor;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ProgressIndicatorKt.LinearProgressIndicator_eaDK9VM$lambda$18(f, modifier3, j5, j6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f2  */
    /* JADX INFO: renamed from: LinearProgressIndicator-rIrjwxo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3956LinearProgressIndicatorrIrjwxo(Modifier modifier, long j, long j2, int i, float f, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long linearColor;
        long linearTrackColor;
        int iM3941getLinearStrokeCapKaPHkGw;
        int i5;
        final float f2;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final int i6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final float fM3940getLinearIndicatorTrackGapSizeD9Ej5fM;
        final int i7;
        final State<Float> stateAnimateFloat;
        final State<Float> stateAnimateFloat2;
        final State<Float> stateAnimateFloat3;
        final State<Float> stateAnimateFloat4;
        boolean zChanged;
        Object objRememberedValue;
        final long j5;
        final long j6;
        Composer composerStartRestartGroup = composer.startRestartGroup(567589233);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)N(modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,strokeCap:c#ui.graphics.StrokeCap,gapSize:c#ui.unit.Dp)255@11480L28,257@11560L159,263@11771L159,269@11983L160,275@12196L160,285@12539L1839,280@12361L2017:ProgressIndicator.kt#uh7d8r");
        int i8 = i3 & 1;
        if (i8 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            linearColor = j;
            i4 |= ((i3 & 2) == 0 && composerStartRestartGroup.changed(linearColor)) ? 32 : 16;
        } else {
            linearColor = j;
        }
        if ((i2 & 384) == 0) {
            linearTrackColor = j2;
            i4 |= ((i3 & 4) == 0 && composerStartRestartGroup.changed(linearTrackColor)) ? 256 : 128;
        } else {
            linearTrackColor = j2;
        }
        int i9 = i3 & 8;
        if (i9 != 0) {
            i4 |= 3072;
        } else {
            if ((i2 & 3072) == 0) {
                iM3941getLinearStrokeCapKaPHkGw = i;
                i4 |= composerStartRestartGroup.changed(iM3941getLinearStrokeCapKaPHkGw) ? 2048 : 1024;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    f2 = f;
                    i4 |= composerStartRestartGroup.changed(f2) ? 16384 : 8192;
                }
                if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "250@11223L11,251@11286L16");
                    if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i3 & 2) != 0) {
                            linearColor = ProgressIndicatorDefaults.INSTANCE.getLinearColor(composerStartRestartGroup, 6);
                            i4 &= -113;
                        }
                        if ((i3 & 4) != 0) {
                            linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(composerStartRestartGroup, 6);
                            i4 &= -897;
                        }
                        if (i9 != 0) {
                            iM3941getLinearStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m3941getLinearStrokeCapKaPHkGw();
                        }
                        if (i5 != 0) {
                            fM3940getLinearIndicatorTrackGapSizeD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m3940getLinearIndicatorTrackGapSizeD9Ej5fM();
                        }
                        i7 = iM3941getLinearStrokeCapKaPHkGw;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(567589233, i4, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:254)");
                        }
                        InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
                        stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, getLinearIndeterminateFirstLineHeadAnimationSpec(), null, composerStartRestartGroup, InfiniteTransition.$stable | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL | (InfiniteRepeatableSpec.$stable << 9), 8);
                        stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, getLinearIndeterminateFirstLineTailAnimationSpec(), null, composerStartRestartGroup, InfiniteTransition.$stable | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL | (InfiniteRepeatableSpec.$stable << 9), 8);
                        stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, getLinearIndeterminateSecondLineHeadAnimationSpec(), null, composerStartRestartGroup, InfiniteTransition.$stable | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL | (InfiniteRepeatableSpec.$stable << 9), 8);
                        stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, getLinearIndeterminateSecondLineTailAnimationSpec(), null, composerStartRestartGroup, InfiniteTransition.$stable | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL | (InfiniteRepeatableSpec.$stable << 9), 8);
                        composer2 = composerStartRestartGroup;
                        Modifier modifierM2085sizeVpY3zN4 = SizeKt.m2085sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(companion.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds())), LinearIndicatorWidth, LinearIndicatorHeight);
                        ComposerKt.sourceInformationMarkerStart(composer2, -7544576, "CC(remember):ProgressIndicator.kt#9igjgp");
                        zChanged = ((57344 & i4) != 16384) | ((i4 & 7168) != 2048) | composer2.changed(stateAnimateFloat) | ((((i4 & 896) ^ 384) <= 256 && composer2.changed(linearTrackColor)) || (i4 & 384) == 256) | composer2.changed(stateAnimateFloat2) | ((((i4 & 112) ^ 48) > 32 && composer2.changed(linearColor)) || (i4 & 48) == 32) | composer2.changed(stateAnimateFloat3) | composer2.changed(stateAnimateFloat4);
                        objRememberedValue = composer2.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            j5 = linearColor;
                            j6 = linearTrackColor;
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ProgressIndicatorKt.LinearProgressIndicator_rIrjwxo$lambda$13$lambda$12(i7, fM3940getLinearIndicatorTrackGapSizeD9Ej5fM, stateAnimateFloat, j6, stateAnimateFloat2, j5, stateAnimateFloat3, stateAnimateFloat4, (DrawScope) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            j5 = linearColor;
                            j6 = linearTrackColor;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        CanvasKt.Canvas(modifierM2085sizeVpY3zN4, (Function1) objRememberedValue, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        i6 = i7;
                        f2 = fM3940getLinearIndicatorTrackGapSizeD9Ej5fM;
                        j4 = j6;
                        j3 = j5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 2) != 0) {
                            i4 &= -113;
                        }
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        companion = modifier2;
                    }
                    fM3940getLinearIndicatorTrackGapSizeD9Ej5fM = f2;
                    i7 = iM3941getLinearStrokeCapKaPHkGw;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1);
                    stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, getLinearIndeterminateFirstLineHeadAnimationSpec(), null, composerStartRestartGroup, InfiniteTransition.$stable | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL | (InfiniteRepeatableSpec.$stable << 9), 8);
                    stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, getLinearIndeterminateFirstLineTailAnimationSpec(), null, composerStartRestartGroup, InfiniteTransition.$stable | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL | (InfiniteRepeatableSpec.$stable << 9), 8);
                    stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, getLinearIndeterminateSecondLineHeadAnimationSpec(), null, composerStartRestartGroup, InfiniteTransition.$stable | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL | (InfiniteRepeatableSpec.$stable << 9), 8);
                    stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, getLinearIndeterminateSecondLineTailAnimationSpec(), null, composerStartRestartGroup, InfiniteTransition.$stable | Videoio.CAP_PROP_XI_DECIMATION_VERTICAL | (InfiniteRepeatableSpec.$stable << 9), 8);
                    composer2 = composerStartRestartGroup;
                    Modifier modifierM2085sizeVpY3zN42 = SizeKt.m2085sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(companion.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds())), LinearIndicatorWidth, LinearIndicatorHeight);
                    ComposerKt.sourceInformationMarkerStart(composer2, -7544576, "CC(remember):ProgressIndicator.kt#9igjgp");
                    if ((i4 & 7168) != 2048) {
                    }
                    if (((i4 & 896) ^ 384) <= 256) {
                        if (((i4 & 112) ^ 48) > 32) {
                            zChanged = ((57344 & i4) != 16384) | ((i4 & 7168) != 2048) | composer2.changed(stateAnimateFloat) | ((((i4 & 896) ^ 384) <= 256 && composer2.changed(linearTrackColor)) || (i4 & 384) == 256) | composer2.changed(stateAnimateFloat2) | ((((i4 & 112) ^ 48) > 32 && composer2.changed(linearColor)) || (i4 & 48) == 32) | composer2.changed(stateAnimateFloat3) | composer2.changed(stateAnimateFloat4);
                            objRememberedValue = composer2.rememberedValue();
                            if (zChanged) {
                                j5 = linearColor;
                                j6 = linearTrackColor;
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ProgressIndicatorKt.LinearProgressIndicator_rIrjwxo$lambda$13$lambda$12(i7, fM3940getLinearIndicatorTrackGapSizeD9Ej5fM, stateAnimateFloat, j6, stateAnimateFloat2, j5, stateAnimateFloat3, stateAnimateFloat4, (DrawScope) obj);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                CanvasKt.Canvas(modifierM2085sizeVpY3zN42, (Function1) objRememberedValue, composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier3 = companion;
                                i6 = i7;
                                f2 = fM3940getLinearIndicatorTrackGapSizeD9Ej5fM;
                                j4 = j6;
                                j3 = j5;
                            }
                        } else {
                            zChanged = ((57344 & i4) != 16384) | ((i4 & 7168) != 2048) | composer2.changed(stateAnimateFloat) | ((((i4 & 896) ^ 384) <= 256 && composer2.changed(linearTrackColor)) || (i4 & 384) == 256) | composer2.changed(stateAnimateFloat2) | ((((i4 & 112) ^ 48) > 32 && composer2.changed(linearColor)) || (i4 & 48) == 32) | composer2.changed(stateAnimateFloat3) | composer2.changed(stateAnimateFloat4);
                            objRememberedValue = composer2.rememberedValue();
                            if (zChanged) {
                            }
                        }
                    }
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = linearColor;
                    j4 = linearTrackColor;
                    i6 = iM3941getLinearStrokeCapKaPHkGw;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ProgressIndicatorKt.LinearProgressIndicator_rIrjwxo$lambda$14(modifier3, j3, j4, i6, f2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            f2 = f;
            if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        iM3941getLinearStrokeCapKaPHkGw = i;
        i5 = i3 & 16;
        if (i5 != 0) {
        }
        f2 = f;
        if (composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit LinearProgressIndicator_2cYBFYY$lambda$11(Modifier modifier, long j, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m3950LinearProgressIndicator2cYBFYY(modifier, j, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_GJbTh5U$lambda$10(Function0 function0, Modifier modifier, long j, long j2, int i, float f, Function1 function1, int i2, int i3, Composer composer, int i4) {
        m3951LinearProgressIndicatorGJbTh5U(function0, modifier, j, j2, i, f, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_GJbTh5U$lambda$2$lambda$1(long j, int i, DrawScope drawScope) {
        ProgressIndicatorDefaults.INSTANCE.m3935drawStopIndicatorEgI2THU(drawScope, ProgressIndicatorDefaults.INSTANCE.m3942getLinearTrackStopIndicatorSizeD9Ej5fM(), j, i);
        return Unit.INSTANCE;
    }

    static final float LinearProgressIndicator_GJbTh5U$lambda$4$lambda$3(Function0 function0) {
        float fFloatValue = ((Number) function0.invoke()).floatValue();
        if (fFloatValue < 0.0f) {
            fFloatValue = 0.0f;
        }
        if (fFloatValue > 1.0f) {
            return 1.0f;
        }
        return fFloatValue;
    }

    static final Unit LinearProgressIndicator_GJbTh5U$lambda$7$lambda$6(Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Object objInvoke = function0.invoke();
        if (Float.isNaN(((Number) objInvoke).floatValue())) {
            objInvoke = null;
        }
        Float f = (Float) objInvoke;
        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(f != null ? f.floatValue() : 0.0f, RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_GJbTh5U$lambda$9$lambda$8(int i, float f, Function0 function0, long j, long j2, Function1 function1, DrawScope drawScope) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        if (!StrokeCap.m6695equalsimpl0(i, StrokeCap.INSTANCE.m6699getButtKaPHkGw()) && Float.intBitsToFloat((int) (MuxerUtil.UNSIGNED_INT_MAX_VALUE & drawScope.mo6899getSizeNHjbRc())) <= Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32))) {
            f = Dp.m9114constructorimpl(f + drawScope.mo1620toDpu2uoSUM(fIntBitsToFloat));
        }
        float f2 = f / drawScope.mo1620toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)));
        float fFloatValue = ((Number) function0.invoke()).floatValue();
        float fMin = fFloatValue + Math.min(fFloatValue, f2);
        if (fMin <= 1.0f) {
            m3961drawLinearIndicatorqYKTg0g(drawScope, fMin, 1.0f, j, fIntBitsToFloat, i);
        }
        m3961drawLinearIndicatorqYKTg0g(drawScope, 0.0f, fFloatValue, j2, fIntBitsToFloat, i);
        function1.invoke(drawScope);
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_RIQooxk$lambda$19(Modifier modifier, long j, long j2, int i, int i2, Composer composer, int i3) {
        m3952LinearProgressIndicatorRIQooxk(modifier, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator__5eSR_E$lambda$0(Function0 function0, Modifier modifier, long j, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m3954LinearProgressIndicator_5eSRE(function0, modifier, j, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final float LinearProgressIndicator__5eSR_E$lambda$16$lambda$15(float f) {
        return f;
    }

    static final Unit LinearProgressIndicator__5eSR_E$lambda$17(float f, Modifier modifier, long j, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m3953LinearProgressIndicator_5eSRE(f, modifier, j, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_eaDK9VM$lambda$18(float f, Modifier modifier, long j, long j2, int i, int i2, Composer composer, int i3) {
        m3955LinearProgressIndicatoreaDK9VM(f, modifier, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_rIrjwxo$lambda$13$lambda$12(int i, float f, State state, long j, State state2, long j2, State state3, State state4, DrawScope drawScope) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        if (!StrokeCap.m6695equalsimpl0(i, StrokeCap.INSTANCE.m6699getButtKaPHkGw()) && Float.intBitsToFloat((int) (MuxerUtil.UNSIGNED_INT_MAX_VALUE & drawScope.mo6899getSizeNHjbRc())) <= Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32))) {
            f = Dp.m9114constructorimpl(f + drawScope.mo1620toDpu2uoSUM(fIntBitsToFloat));
        }
        float f2 = f / drawScope.mo1620toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)));
        if (((Number) state.getValue()).floatValue() < 1.0f - f2) {
            m3961drawLinearIndicatorqYKTg0g(drawScope, ((Number) state.getValue()).floatValue() > 0.0f ? ((Number) state.getValue()).floatValue() + f2 : 0.0f, 1.0f, j, fIntBitsToFloat, i);
        }
        if (((Number) state.getValue()).floatValue() - ((Number) state2.getValue()).floatValue() > 0.0f) {
            m3961drawLinearIndicatorqYKTg0g(drawScope, ((Number) state.getValue()).floatValue(), ((Number) state2.getValue()).floatValue(), j2, fIntBitsToFloat, i);
        }
        if (((Number) state2.getValue()).floatValue() > f2) {
            m3961drawLinearIndicatorqYKTg0g(drawScope, ((Number) state3.getValue()).floatValue() > 0.0f ? ((Number) state3.getValue()).floatValue() + f2 : 0.0f, ((Number) state2.getValue()).floatValue() < 1.0f ? ((Number) state2.getValue()).floatValue() - f2 : 1.0f, j, fIntBitsToFloat, i);
        }
        if (((Number) state3.getValue()).floatValue() - ((Number) state4.getValue()).floatValue() > 0.0f) {
            m3961drawLinearIndicatorqYKTg0g(drawScope, ((Number) state3.getValue()).floatValue(), ((Number) state4.getValue()).floatValue(), j2, fIntBitsToFloat, i);
        }
        if (((Number) state4.getValue()).floatValue() > f2) {
            m3961drawLinearIndicatorqYKTg0g(drawScope, 0.0f, ((Number) state4.getValue()).floatValue() < 1.0f ? ((Number) state4.getValue()).floatValue() - f2 : 1.0f, j, fIntBitsToFloat, i);
        }
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicator_rIrjwxo$lambda$14(Modifier modifier, long j, long j2, int i, float f, int i2, int i3, Composer composer, int i4) {
        m3956LinearProgressIndicatorrIrjwxo(modifier, j, j2, i, f, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit _get_circularIndeterminateProgressAnimationSpec_$lambda$42(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(6000);
        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.87f), 3000), CircularProgressEasing);
        keyframesSpecConfig.at(Float.valueOf(0.1f), 6000);
        return Unit.INSTANCE;
    }

    static final Unit _get_circularIndeterminateRotationAnimationSpec_$lambda$41(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(6000);
        Float fValueOf = Float.valueOf(90.0f);
        keyframesSpecConfig.using(keyframesSpecConfig.at(fValueOf, 300), MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier());
        keyframesSpecConfig.at(fValueOf, 1500);
        Float fValueOf2 = Float.valueOf(180.0f);
        keyframesSpecConfig.at(fValueOf2, Videoio.CAP_GSTREAMER);
        keyframesSpecConfig.at(fValueOf2, 3000);
        Float fValueOf3 = Float.valueOf(270.0f);
        keyframesSpecConfig.at(fValueOf3, 3300);
        keyframesSpecConfig.at(fValueOf3, 4500);
        Float fValueOf4 = Float.valueOf(360.0f);
        keyframesSpecConfig.at(fValueOf4, 4800);
        keyframesSpecConfig.at(fValueOf4, 6000);
        return Unit.INSTANCE;
    }

    static final Unit _get_linearIndeterminateFirstLineHeadAnimationSpec_$lambda$43(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(LinearAnimationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 0), LinearIndeterminateProgressEasing);
        keyframesSpecConfig.at(Float.valueOf(1.0f), 1000);
        return Unit.INSTANCE;
    }

    static final Unit _get_linearIndeterminateFirstLineTailAnimationSpec_$lambda$44(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(LinearAnimationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 250), LinearIndeterminateProgressEasing);
        keyframesSpecConfig.at(Float.valueOf(1.0f), 1250);
        return Unit.INSTANCE;
    }

    static final Unit _get_linearIndeterminateSecondLineHeadAnimationSpec_$lambda$45(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(LinearAnimationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), SecondLineHeadDelay), LinearIndeterminateProgressEasing);
        keyframesSpecConfig.at(Float.valueOf(1.0f), 1500);
        return Unit.INSTANCE;
    }

    static final Unit _get_linearIndeterminateSecondLineTailAnimationSpec_$lambda$46(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(LinearAnimationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 900), LinearIndeterminateProgressEasing);
        keyframesSpecConfig.at(Float.valueOf(1.0f), LinearAnimationDuration);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m3957drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float width = stroke.getWidth() / 2.0f;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)) - (2.0f * width);
        DrawScope.m6878drawArcyD3GUKo$default(drawScope, j, f, f2, false, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(width)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(width) << 32)), Size.m6140constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: renamed from: drawCircularIndicatorTrack-bw27NRU, reason: not valid java name */
    private static final void m3958drawCircularIndicatorTrackbw27NRU(DrawScope drawScope, long j, Stroke stroke) {
        m3957drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j, stroke);
    }

    /* JADX INFO: renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m3959drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m3957drawCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* JADX INFO: renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    private static final void m3960drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        m3957drawCircularIndicator42QJj7c(drawScope, f + (StrokeCap.m6695equalsimpl0(stroke.getCap(), StrokeCap.INSTANCE.m6699getButtKaPHkGw()) ? 0.0f : ((f2 / Dp.m9114constructorimpl(CircularIndicatorDiameter / 2.0f)) * 57.29578f) / 2.0f), Math.max(f3, 0.1f), j, stroke);
    }

    /* JADX INFO: renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    private static final void m3961drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, float f2, long j, float f3, int i) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        float f4 = fIntBitsToFloat2 / 2.0f;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        float f5 = (z ? f : 1.0f - f2) * fIntBitsToFloat;
        float f6 = (z ? f2 : 1.0f - f) * fIntBitsToFloat;
        if (StrokeCap.m6695equalsimpl0(i, StrokeCap.INSTANCE.m6699getButtKaPHkGw()) || fIntBitsToFloat2 > fIntBitsToFloat) {
            DrawScope.m6885drawLineNGM6Ib0$default(drawScope, j, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f4)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f4)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), f3, 0, null, 0.0f, null, 0, 496, null);
            return;
        }
        float f7 = f3 / 2.0f;
        float f8 = fIntBitsToFloat - f7;
        if (f5 < f7) {
            f5 = f7;
        }
        if (f5 > f8) {
            f5 = f8;
        }
        if (f6 < f7) {
            f6 = f7;
        }
        if (f6 <= f8) {
            f8 = f6;
        }
        if (Math.abs(f2 - f) > 0.0f) {
            DrawScope.m6885drawLineNGM6Ib0$default(drawScope, j, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f4)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f8)) << 32) | (((long) Float.floatToRawIntBits(f4)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), f3, i, null, 0.0f, null, 0, 480, null);
        }
    }

    public static final InfiniteRepeatableSpec<Float> getCircularIndeterminateGlobalRotationAnimationSpec() {
        return AnimationSpecKt.m1391infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6000, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null);
    }

    public static final InfiniteRepeatableSpec<Float> getCircularIndeterminateProgressAnimationSpec() {
        return AnimationSpecKt.m1391infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt._get_circularIndeterminateProgressAnimationSpec_$lambda$42((KeyframesSpec.KeyframesSpecConfig) obj);
            }
        }), null, 0L, 6, null);
    }

    public static final InfiniteRepeatableSpec<Float> getCircularIndeterminateRotationAnimationSpec() {
        return AnimationSpecKt.m1391infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt._get_circularIndeterminateRotationAnimationSpec_$lambda$41((KeyframesSpec.KeyframesSpecConfig) obj);
            }
        }), null, 0L, 6, null);
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }

    public static final CubicBezierEasing getCircularProgressEasing() {
        return CircularProgressEasing;
    }

    public static final InfiniteRepeatableSpec<Float> getLinearIndeterminateFirstLineHeadAnimationSpec() {
        return AnimationSpecKt.m1391infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt._get_linearIndeterminateFirstLineHeadAnimationSpec_$lambda$43((KeyframesSpec.KeyframesSpecConfig) obj);
            }
        }), null, 0L, 6, null);
    }

    public static final InfiniteRepeatableSpec<Float> getLinearIndeterminateFirstLineTailAnimationSpec() {
        return AnimationSpecKt.m1391infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt._get_linearIndeterminateFirstLineTailAnimationSpec_$lambda$44((KeyframesSpec.KeyframesSpecConfig) obj);
            }
        }), null, 0L, 6, null);
    }

    public static final CubicBezierEasing getLinearIndeterminateProgressEasing() {
        return LinearIndeterminateProgressEasing;
    }

    public static final InfiniteRepeatableSpec<Float> getLinearIndeterminateSecondLineHeadAnimationSpec() {
        return AnimationSpecKt.m1391infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt._get_linearIndeterminateSecondLineHeadAnimationSpec_$lambda$45((KeyframesSpec.KeyframesSpecConfig) obj);
            }
        }), null, 0L, 6, null);
    }

    public static final InfiniteRepeatableSpec<Float> getLinearIndeterminateSecondLineTailAnimationSpec() {
        return AnimationSpecKt.m1391infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt._get_linearIndeterminateSecondLineTailAnimationSpec_$lambda$46((KeyframesSpec.KeyframesSpecConfig) obj);
            }
        }), null, 0L, 6, null);
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }

    public static final float getStopIndicatorTrailingSpace() {
        return StopIndicatorTrailingSpace;
    }
}
