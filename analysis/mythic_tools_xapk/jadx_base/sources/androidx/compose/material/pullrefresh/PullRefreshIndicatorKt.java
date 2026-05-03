package androidx.compose.material.pullrefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ElevationOverlay;
import androidx.compose.material.ElevationOverlayKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PullRefreshIndicator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a;\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\"\u000e\u0010 \u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010(\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010)\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010*\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010+\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010,\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u000e\u0010-\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001500X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061²\u0006\n\u00102\u001a\u00020\u0003X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"PullRefreshIndicator", "", "refreshing", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material/pullrefresh/PullRefreshState;", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "scale", "PullRefreshIndicator-jB83MbM", "(ZLandroidx/compose/material/pullrefresh/PullRefreshState;Landroidx/compose/ui/Modifier;JJZLandroidx/compose/runtime/Composer;II)V", "CircularArrowIndicator", "color", "CircularArrowIndicator-iJQMabo", "(Landroidx/compose/material/pullrefresh/PullRefreshState;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ArrowValues", "Landroidx/compose/material/pullrefresh/ArrowValues;", "progress", "", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "drawArrow-Bx497Mc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material/pullrefresh/ArrowValues;)V", "CrossfadeDurationMs", "", "MaxProgressArc", "IndicatorSize", "Landroidx/compose/ui/unit/Dp;", "F", "SpinnerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "ArcRadius", "StrokeWidth", "ArrowWidth", "ArrowHeight", "Elevation", "MinAlpha", "MaxAlpha", "AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "material", "showElevation", "targetAlpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PullRefreshIndicatorKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float IndicatorSize = Dp.m9114constructorimpl(40.0f);
    private static final RoundedCornerShape SpinnerShape = RoundedCornerShapeKt.getCircleShape();
    private static final float ArcRadius = Dp.m9114constructorimpl(7.5f);
    private static final float StrokeWidth = Dp.m9114constructorimpl(2.5f);
    private static final float ArrowWidth = Dp.m9114constructorimpl(10.0f);
    private static final float ArrowHeight = Dp.m9114constructorimpl(5.0f);
    private static final float Elevation = Dp.m9114constructorimpl(6.0f);
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null);

    private static final ArrowValues ArrowValues(float f) {
        float fMax = (Math.max(Math.min(1.0f, f) - 0.4f, 0.0f) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f) - 1.0f;
        float f2 = fAbs >= 0.0f ? fAbs : 0.0f;
        if (f2 > 2.0f) {
            f2 = 2.0f;
        }
        float fPow = (((0.4f * fMax) - 0.25f) + (f2 - (((float) Math.pow(f2, 2.0d)) / 4.0f))) * 0.5f;
        return new ArrowValues(fPow, fPow * 360.0f, ((0.8f * fMax) + fPow) * 360.0f, Math.min(1.0f, fMax));
    }

    /* JADX INFO: renamed from: CircularArrowIndicator-iJQMabo, reason: not valid java name */
    private static final void m3249CircularArrowIndicatoriJQMabo(final PullRefreshState pullRefreshState, final long j, final Modifier modifier, Composer composer, final int i) {
        int i2;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-486016981);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularArrowIndicator)N(state,color:c#ui.graphics.Color,modifier)125@5306L61,128@5400L87,130@5510L74,133@5649L2,133@5653L950,133@5623L980:PullRefreshIndicator.kt#t44y28");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(pullRefreshState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-486016981, i2, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:124)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1089119880, "CC(remember):PullRefreshIndicator.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Object obj = objRememberedValue;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Path Path = AndroidPath_androidKt.Path();
                Path.mo6215setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m6621getEvenOddRgk1Os());
                composerStartRestartGroup.updateRememberedValue(Path);
                obj = Path;
            }
            final Path path = (Path) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1089122914, "CC(remember):PullRefreshIndicator.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(pullRefreshState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(PullRefreshIndicatorKt.CircularArrowIndicator_iJQMabo$lambda$1$0(pullRefreshState));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowIndicator_iJQMabo$lambda$2((State) objRememberedValue2), AlphaTween, 0.0f, null, null, composerStartRestartGroup, 48, 28);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1089130797, "CC(remember):PullRefreshIndicator.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PullRefreshIndicatorKt.CircularArrowIndicator_iJQMabo$lambda$3$0((SemanticsPropertyReceiver) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue3, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1089131873, "CC(remember):PullRefreshIndicator.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(pullRefreshState) | composerStartRestartGroup.changed(stateAnimateFloatAsState) | ((i2 & 112) == 32) | composerStartRestartGroup.changedInstance(path);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                i3 = 0;
                Function1 function1 = new Function1() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PullRefreshIndicatorKt.CircularArrowIndicator_iJQMabo$lambda$4$0(pullRefreshState, stateAnimateFloatAsState, j, path, (DrawScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function1);
                objRememberedValue4 = function1;
            } else {
                i3 = 0;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierSemantics$default, (Function1) objRememberedValue4, composerStartRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PullRefreshIndicatorKt.CircularArrowIndicator_iJQMabo$lambda$5(pullRefreshState, j, modifier, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularArrowIndicator_iJQMabo$lambda$1$0(PullRefreshState pullRefreshState) {
        return pullRefreshState.getProgress() >= 1.0f ? 1.0f : 0.3f;
    }

    private static final float CircularArrowIndicator_iJQMabo$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularArrowIndicator_iJQMabo$lambda$3$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularArrowIndicator_iJQMabo$lambda$4$0(PullRefreshState pullRefreshState, State state, long j, Path path, DrawScope drawScope) throws Throwable {
        DrawContext drawContext;
        long j2;
        ArrowValues ArrowValues = ArrowValues(pullRefreshState.getProgress());
        float fFloatValue = ((Number) state.getValue()).floatValue();
        float rotation = ArrowValues.getRotation();
        long jMo6898getCenterF1C5BW0 = drawScope.mo6898getCenterF1C5BW0();
        DrawContext drawContext2 = drawScope.getDrawContext();
        long jMo6820getSizeNHjbRc = drawContext2.mo6820getSizeNHjbRc();
        drawContext2.getCanvas().save();
        try {
            drawContext2.getTransform().mo6826rotateUv8p0NA(rotation, jMo6898getCenterF1C5BW0);
            float f = drawScope.mo1624toPx0680j_4(ArcRadius);
            float f2 = StrokeWidth;
            float f3 = f + (drawScope.mo1624toPx0680j_4(f2) / 2.0f);
            Rect rect = new Rect(Float.intBitsToFloat((int) (SizeKt.m6159getCenteruvyYCjk(drawScope.mo6899getSizeNHjbRc()) >> 32)) - f3, Float.intBitsToFloat((int) (SizeKt.m6159getCenteruvyYCjk(drawScope.mo6899getSizeNHjbRc()) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) - f3, Float.intBitsToFloat((int) (SizeKt.m6159getCenteruvyYCjk(drawScope.mo6899getSizeNHjbRc()) >> 32)) + f3, Float.intBitsToFloat((int) (SizeKt.m6159getCenteruvyYCjk(drawScope.mo6899getSizeNHjbRc()) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) + f3);
            try {
                j2 = jMo6820getSizeNHjbRc;
                try {
                    try {
                        DrawScope.m6878drawArcyD3GUKo$default(drawScope, j, ArrowValues.getStartAngle(), ArrowValues.getEndAngle() - ArrowValues.getStartAngle(), false, rect.m6115getTopLeftF1C5BW0(), rect.m6113getSizeNHjbRc(), fFloatValue, new Stroke(drawScope.mo1624toPx0680j_4(f2), 0.0f, StrokeCap.INSTANCE.m6701getSquareKaPHkGw(), 0, null, 26, null), null, 0, 768, null);
                        m3251drawArrowBx497Mc(drawScope, path, rect, j, fFloatValue, ArrowValues);
                        drawContext2.getCanvas().restore();
                        drawContext2.mo6821setSizeuvyYCjk(j2);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        drawContext = drawContext2;
                        j2 = j2;
                        drawContext.getCanvas().restore();
                        drawContext.mo6821setSizeuvyYCjk(j2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    drawContext = drawContext2;
                }
            } catch (Throwable th3) {
                th = th3;
                drawContext = drawContext2;
                j2 = jMo6820getSizeNHjbRc;
            }
        } catch (Throwable th4) {
            th = th4;
            drawContext = drawContext2;
            j2 = jMo6820getSizeNHjbRc;
        }
    }

    static final Unit CircularArrowIndicator_iJQMabo$lambda$5(PullRefreshState pullRefreshState, long j, Modifier modifier, int i, Composer composer, int i2) {
        m3249CircularArrowIndicatoriJQMabo(pullRefreshState, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to inline method: androidx.compose.ui.draw.ShadowKt.shadow-s4CzXII$default(androidx.compose.ui.Modifier, float, androidx.compose.ui.graphics.Shape, boolean, long, long, int, java.lang.Object):androidx.compose.ui.Modifier */
    /* JADX WARN: Not passed register '(r4v7 'fM9114constructorimpl' float)' in method call: androidx.compose.ui.draw.ShadowKt.shadow-s4CzXII$default(androidx.compose.ui.Modifier, float, androidx.compose.ui.graphics.Shape, boolean, long, long, int, java.lang.Object):androidx.compose.ui.Modifier */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0133  */
    /* JADX INFO: renamed from: PullRefreshIndicator-jB83MbM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3250PullRefreshIndicatorjB83MbM(final boolean z, final PullRefreshState pullRefreshState, Modifier modifier, long j, long j2, boolean z2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long jM2987getSurface0d7_KjU;
        long j3;
        int i4;
        boolean z3;
        final Modifier modifier3;
        final long j4;
        final long j5;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i5;
        final long j6;
        boolean z5;
        boolean zChanged;
        Object objRememberedValue;
        ElevationOverlay elevationOverlay;
        long j7;
        Color colorM6315boximpl;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Composer composerStartRestartGroup = composer.startRestartGroup(308716636);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PullRefreshIndicator)N(refreshing,state,modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,scale)83@3565L86,88@3936L7,92@4064L1050:PullRefreshIndicator.kt#t44y28");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(pullRefreshState) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    jM2987getSurface0d7_KjU = j;
                    int i7 = composerStartRestartGroup.changed(jM2987getSurface0d7_KjU) ? 2048 : 1024;
                    i3 |= i7;
                } else {
                    jM2987getSurface0d7_KjU = j;
                }
                i3 |= i7;
            } else {
                jM2987getSurface0d7_KjU = j;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    j3 = j2;
                    int i8 = composerStartRestartGroup.changed(j3) ? 16384 : 8192;
                    i3 |= i8;
                } else {
                    j3 = j2;
                }
                i3 |= i8;
            } else {
                j3 = j2;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    z3 = z2;
                    i3 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
                }
                if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "78@3424L6,79@3466L32");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            jM2987getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2987getSurface0d7_KjU();
                        }
                        if ((i2 & 16) != 0) {
                            long jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(jM2987getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                            j3 = jM3001contentColorForek8zF_U;
                        }
                        if (i4 != 0) {
                            long j8 = j3;
                            i5 = i3;
                            j6 = j8;
                            z5 = false;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(308716636, i5, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator (PullRefreshIndicator.kt:81)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 323953426, "CC(remember):PullRefreshIndicator.kt#9igjgp");
                        int i9 = i5 & 14;
                        zChanged = (i9 != 4) | composerStartRestartGroup.changed(pullRefreshState);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Boolean.valueOf(PullRefreshIndicatorKt.PullRefreshIndicator_jB83MbM$lambda$0$0(z, pullRefreshState));
                                }
                            });
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        State state = (State) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localElevationOverlay);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        elevationOverlay = (ElevationOverlay) objConsume;
                        if (elevationOverlay != null) {
                            composerStartRestartGroup.startReplaceGroup(1453038224);
                            composerStartRestartGroup.endReplaceGroup();
                            j7 = jM2987getSurface0d7_KjU;
                            colorM6315boximpl = null;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(323966865);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "90@3986L53");
                            long j9 = jM2987getSurface0d7_KjU;
                            long jMo3014apply7g2Lkgo = elevationOverlay.mo3014apply7g2Lkgo(j9, Elevation, composerStartRestartGroup, ((i5 >> 9) & 14) | 48);
                            j7 = j9;
                            composerStartRestartGroup.endReplaceGroup();
                            colorM6315boximpl = Color.m6315boximpl(jMo3014apply7g2Lkgo);
                        }
                        long jM6335unboximpl = colorM6315boximpl == null ? colorM6315boximpl.m6335unboximpl() : j7;
                        Modifier modifierPullRefreshIndicatorTransform = PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(androidx.compose.foundation.layout.SizeKt.m2083size3ABfNKs(modifier2, IndicatorSize), pullRefreshState, z5);
                        float fM9114constructorimpl = !PullRefreshIndicator_jB83MbM$lambda$1(state) ? Elevation : Dp.m9114constructorimpl(0.0f);
                        RoundedCornerShape roundedCornerShape = SpinnerShape;
                        Modifier modifierM1482backgroundbw27NRU = BackgroundKt.m1482backgroundbw27NRU(ShadowKt.m5923shadows4CzXII$default(modifierPullRefreshIndicatorTransform, fM9114constructorimpl, roundedCornerShape, true, 0L, 0L, 24, null), jM6335unboximpl, roundedCornerShape);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1482backgroundbw27NRU);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.useNode();
                        } else {
                            composerStartRestartGroup.createNode(constructor);
                        }
                        composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424656180, "C103@4511L597,100@4379L729:PullRefreshIndicator.kt#t44y28");
                        CrossfadeKt.Crossfade(Boolean.valueOf(z), (Modifier) null, AnimationSpecKt.tween$default(100, 0, null, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1853731063, true, new Function3() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullRefreshIndicatorKt.PullRefreshIndicator_jB83MbM$lambda$2$0(j6, pullRefreshState, ((Boolean) obj).booleanValue(), (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, i9 | 24960, 10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        long j10 = j6;
                        modifier3 = modifier2;
                        j5 = j10;
                        z4 = z5;
                        j4 = j7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                    }
                    long j11 = j3;
                    i5 = i3;
                    j6 = j11;
                    z5 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 323953426, "CC(remember):PullRefreshIndicator.kt#9igjgp");
                    int i92 = i5 & 14;
                    zChanged = (i92 != 4) | composerStartRestartGroup.changed(pullRefreshState);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(PullRefreshIndicatorKt.PullRefreshIndicator_jB83MbM$lambda$0$0(z, pullRefreshState));
                            }
                        });
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        State state2 = (State) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay2 = ElevationOverlayKt.getLocalElevationOverlay();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localElevationOverlay2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        elevationOverlay = (ElevationOverlay) objConsume2;
                        if (elevationOverlay != null) {
                        }
                        if (colorM6315boximpl == null) {
                        }
                        Modifier modifierPullRefreshIndicatorTransform2 = PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(androidx.compose.foundation.layout.SizeKt.m2083size3ABfNKs(modifier2, IndicatorSize), pullRefreshState, z5);
                        float fM9114constructorimpl2 = !PullRefreshIndicator_jB83MbM$lambda$1(state2) ? Elevation : Dp.m9114constructorimpl(0.0f);
                        RoundedCornerShape roundedCornerShape2 = SpinnerShape;
                        Modifier modifierM1482backgroundbw27NRU2 = BackgroundKt.m1482backgroundbw27NRU(ShadowKt.m5923shadows4CzXII$default(modifierPullRefreshIndicatorTransform2, fM9114constructorimpl2, roundedCornerShape2, true, 0L, 0L, 24, null), jM6335unboximpl, roundedCornerShape2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1482backgroundbw27NRU2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                        }
                        composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5595constructorimpl.getInserting()) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424656180, "C103@4511L597,100@4379L729:PullRefreshIndicator.kt#t44y28");
                            CrossfadeKt.Crossfade(Boolean.valueOf(z), (Modifier) null, AnimationSpecKt.tween$default(100, 0, null, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1853731063, true, new Function3() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullRefreshIndicatorKt.PullRefreshIndicator_jB83MbM$lambda$2$0(j6, pullRefreshState, ((Boolean) obj).booleanValue(), (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, i92 | 24960, 10);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            long j102 = j6;
                            modifier3 = modifier2;
                            j5 = j102;
                            z4 = z5;
                            j4 = j7;
                        }
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    j4 = jM2987getSurface0d7_KjU;
                    j5 = j3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullRefreshIndicatorKt.PullRefreshIndicator_jB83MbM$lambda$3(z, pullRefreshState, modifier3, j4, j5, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z2;
            if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        i4 = i2 & 32;
        if (i4 != 0) {
        }
        z3 = z2;
        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PullRefreshIndicator_jB83MbM$lambda$0$0(boolean z, PullRefreshState pullRefreshState) {
        return z || pullRefreshState.getPosition$material() > 0.5f;
    }

    private static final boolean PullRefreshIndicator_jB83MbM$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PullRefreshIndicator_jB83MbM$lambda$2$0(long j, PullRefreshState pullRefreshState, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(refreshing)104@4539L559:PullRefreshIndicator.kt#t44y28");
        if ((i & 6) == 0) {
            i |= composer.changed(z) ? 4 : 2;
        }
        if (composer.shouldExecute((i & 19) != 18, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1853731063, i, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator.<anonymous>.<anonymous> (PullRefreshIndicator.kt:104)");
            }
            Modifier modifierFillMaxSize$default = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1916688881, "C:PullRefreshIndicator.kt#t44y28");
            float f = ArcRadius;
            float f2 = StrokeWidth;
            float fM9114constructorimpl = Dp.m9114constructorimpl(Dp.m9114constructorimpl(f + f2) * 2.0f);
            if (z) {
                composer.startReplaceGroup(-1916589279);
                ComposerKt.sourceInformation(composer, "108@4741L208");
                ProgressIndicatorKt.m3107CircularProgressIndicatorLxG7B9w(androidx.compose.foundation.layout.SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, fM9114constructorimpl), j, f2, 0L, 0, composer, 390, 24);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1916362142);
                ComposerKt.sourceInformation(composer, "114@4995L71");
                m3249CircularArrowIndicatoriJQMabo(pullRefreshState, j, androidx.compose.foundation.layout.SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, fM9114constructorimpl), composer, 384);
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit PullRefreshIndicator_jB83MbM$lambda$3(boolean z, PullRefreshState pullRefreshState, Modifier modifier, long j, long j2, boolean z2, int i, int i2, Composer composer, int i3) {
        m3250PullRefreshIndicatorjB83MbM(z, pullRefreshState, modifier, j, j2, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawArrow-Bx497Mc, reason: not valid java name */
    private static final void m3251drawArrowBx497Mc(DrawScope drawScope, Path path, Rect rect, long j, float f, ArrowValues arrowValues) {
        path.reset();
        path.moveTo(0.0f, 0.0f);
        float f2 = ArrowWidth;
        path.lineTo(drawScope.mo1624toPx0680j_4(f2) * arrowValues.getScale(), 0.0f);
        path.lineTo((drawScope.mo1624toPx0680j_4(f2) * arrowValues.getScale()) / 2.0f, drawScope.mo1624toPx0680j_4(ArrowHeight) * arrowValues.getScale());
        float fMin = ((Math.min(rect.getRight() - rect.getLeft(), rect.getBottom() - rect.getTop()) / 2.0f) + Float.intBitsToFloat((int) (rect.m6110getCenterF1C5BW0() >> 32))) - ((drawScope.mo1624toPx0680j_4(f2) * arrowValues.getScale()) / 2.0f);
        path.mo6217translatek4lQ0M(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (rect.m6110getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) + (drawScope.mo1624toPx0680j_4(StrokeWidth) / 2.0f))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fMin) << 32)));
        path.close();
        float endAngle = arrowValues.getEndAngle();
        long jMo6898getCenterF1C5BW0 = drawScope.mo6898getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6820getSizeNHjbRc = drawContext.mo6820getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6826rotateUv8p0NA(endAngle, jMo6898getCenterF1C5BW0);
            DrawScope.m6889drawPathLG529CI$default(drawScope, path, j, f, null, null, 0, 56, null);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6821setSizeuvyYCjk(jMo6820getSizeNHjbRc);
        }
    }
}
