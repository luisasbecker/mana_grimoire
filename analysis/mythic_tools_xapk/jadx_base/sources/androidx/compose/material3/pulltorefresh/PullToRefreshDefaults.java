package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MotionSchemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PullToRefresh.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jo\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010(\u001a\u00020\u00152\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 0*¢\u0006\u0002\b,¢\u0006\u0002\b-H\u0007¢\u0006\u0004\b.\u0010/JG\u00100\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u00101\u001a\u00020\f2\b\b\u0002\u0010'\u001a\u00020\u0015H\u0007¢\u0006\u0004\b2\u00103R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0014\u001a\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u001b\u001a\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\u001d\u001a\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0017¨\u00064"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape$annotations", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "indicatorShape", "getIndicatorShape", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor$annotations", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "indicatorContainerColor", "getIndicatorContainerColor", "indicatorColor", "getIndicatorColor", "PositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "getPositionalThreshold-D9Ej5fM", "()F", "F", "IndicatorMaxDistance", "getIndicatorMaxDistance-D9Ej5fM", "Elevation", "getElevation-D9Ej5fM", "LoadingIndicatorElevation", "getLoadingIndicatorElevation-D9Ej5fM", "IndicatorBox", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "isRefreshing", "", "modifier", "Landroidx/compose/ui/Modifier;", "maxDistance", "elevation", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "IndicatorBox-1CPYgEU", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZLandroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;JFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Indicator", "color", "Indicator-2poqoh4", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZLandroidx/compose/ui/Modifier;JJFLandroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PullToRefreshDefaults {
    public static final int $stable = 0;
    private static final float Elevation;
    private static final float IndicatorMaxDistance;
    private static final float LoadingIndicatorElevation;
    private static final float PositionalThreshold;
    public static final PullToRefreshDefaults INSTANCE = new PullToRefreshDefaults();
    private static final Shape shape = RoundedCornerShapeKt.getCircleShape();
    private static final Shape indicatorShape = RoundedCornerShapeKt.getCircleShape();

    static {
        float fM9114constructorimpl = Dp.m9114constructorimpl(80.0f);
        PositionalThreshold = fM9114constructorimpl;
        IndicatorMaxDistance = fM9114constructorimpl;
        Elevation = ElevationTokens.INSTANCE.m4949getLevel2D9Ej5fM();
        LoadingIndicatorElevation = ElevationTokens.INSTANCE.m4947getLevel0D9Ej5fM();
    }

    private PullToRefreshDefaults() {
    }

    static final Unit IndicatorBox_1CPYgEU$lambda$2$lambda$1(ContentDrawScope contentDrawScope) {
        int iM6314getIntersectrtfAjoo = ClipOp.INSTANCE.m6314getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope.getDrawContext();
        long jMo6820getSizeNHjbRc = drawContext.mo6820getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6823clipRectN_I0leg(-3.4028235E38f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE, iM6314getIntersectrtfAjoo);
            contentDrawScope.drawContent();
            drawContext.getCanvas().restore();
            drawContext.mo6821setSizeuvyYCjk(jMo6820getSizeNHjbRc);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            drawContext.getCanvas().restore();
            drawContext.mo6821setSizeuvyYCjk(jMo6820getSizeNHjbRc);
            throw th;
        }
    }

    static final MeasureResult IndicatorBox_1CPYgEU$lambda$6$lambda$5(final PullToRefreshState pullToRefreshState, final boolean z, final float f, final float f2, final Shape shape2, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(measureScope, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$6$lambda$5$lambda$4(placeableMo7769measureBRTryo0, pullToRefreshState, z, f, f2, shape2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit IndicatorBox_1CPYgEU$lambda$6$lambda$5$lambda$4(Placeable placeable, final PullToRefreshState pullToRefreshState, final boolean z, final float f, final float f2, final Shape shape2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, 0, 0.0f, new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$6$lambda$5$lambda$4$lambda$3(pullToRefreshState, z, f, f2, shape2, (GraphicsLayerScope) obj);
            }
        }, 4, (Object) null);
        return Unit.INSTANCE;
    }

    static final Unit IndicatorBox_1CPYgEU$lambda$6$lambda$5$lambda$4$lambda$3(PullToRefreshState pullToRefreshState, boolean z, float f, float f2, Shape shape2, GraphicsLayerScope graphicsLayerScope) {
        boolean z2 = pullToRefreshState.getDistanceFraction() > 0.0f || z;
        graphicsLayerScope.setTranslationY((pullToRefreshState.getDistanceFraction() * graphicsLayerScope.mo1618roundToPx0680j_4(f)) - Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
        graphicsLayerScope.setShadowElevation(z2 ? graphicsLayerScope.mo1624toPx0680j_4(f2) : 0.0f);
        graphicsLayerScope.setShape(shape2);
        graphicsLayerScope.setClip(true);
        return Unit.INSTANCE;
    }

    static final Unit IndicatorBox_1CPYgEU$lambda$7(PullToRefreshDefaults pullToRefreshDefaults, PullToRefreshState pullToRefreshState, boolean z, Modifier modifier, float f, Shape shape2, long j, float f2, Function3 function3, int i, int i2, Composer composer, int i3) {
        pullToRefreshDefaults.m4685IndicatorBox1CPYgEU(pullToRefreshState, z, modifier, f, shape2, j, f2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Indicator_2poqoh4$lambda$8(PullToRefreshDefaults pullToRefreshDefaults, PullToRefreshState pullToRefreshState, boolean z, Modifier modifier, long j, long j2, float f, int i, int i2, Composer composer, int i3) {
        pullToRefreshDefaults.m4684Indicator2poqoh4(pullToRefreshState, z, modifier, j, j2, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Use indicatorContainerColor instead", replaceWith = @ReplaceWith(expression = "indicatorContainerColor", imports = {}))
    public static /* synthetic */ void getContainerColor$annotations() {
    }

    @Deprecated(message = "Use indicatorShape instead", replaceWith = @ReplaceWith(expression = "indicatorShape", imports = {}))
    public static /* synthetic */ void getShape$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX INFO: renamed from: Indicator-2poqoh4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4684Indicator2poqoh4(final PullToRefreshState pullToRefreshState, final boolean z, Modifier modifier, long j, long j2, float f, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long indicatorColor;
        final float f2;
        final Modifier modifier3;
        final long j4;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long indicatorContainerColor;
        int i4;
        float f3;
        final long j6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1076870256);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Indicator)N(state,isRefreshing,modifier,containerColor:c#ui.graphics.Color,color:c#ui.graphics.Color,maxDistance:c#ui.unit.Dp)522@20382L755,516@20173L964:PullToRefresh.kt#djiw08");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(pullToRefreshState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    j3 = j;
                    int i6 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i3 |= i6;
                } else {
                    j3 = j;
                }
                i3 |= i6;
            } else {
                j3 = j;
            }
            if ((i & 24576) != 0) {
                indicatorColor = j2;
                i3 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(indicatorColor)) ? 16384 : 8192;
            } else {
                indicatorColor = j2;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    f2 = f;
                    int i7 = composerStartRestartGroup.changed(f2) ? 131072 : 65536;
                    i3 |= i7;
                } else {
                    f2 = f;
                }
                i3 |= i7;
            } else {
                f2 = f;
            }
            if ((i2 & 64) == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= composerStartRestartGroup.changed(this) ? 1048576 : 524288;
            }
            if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j4 = j3;
                j5 = indicatorColor;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "512@20040L23,513@20093L14");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 8) != 0) {
                        indicatorContainerColor = getIndicatorContainerColor(composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -7169;
                    } else {
                        indicatorContainerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        indicatorColor = getIndicatorColor(composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i4 = i3 & (-458753);
                        f3 = IndicatorMaxDistance;
                    } else {
                        i4 = i3;
                        f3 = f2;
                    }
                    j6 = indicatorColor;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    companion = modifier2;
                    indicatorContainerColor = j3;
                    j6 = indicatorColor;
                    i4 = i3;
                    f3 = f2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1076870256, i4, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator (PullToRefresh.kt:515)");
                }
                int i8 = (i4 & 14) | 12582912 | (i4 & 112) | (i4 & 896) | ((i4 >> 6) & 7168);
                int i9 = i4 << 6;
                int i10 = i8 | (458752 & i9) | (i9 & 234881024);
                Modifier modifier4 = companion;
                m4685IndicatorBox1CPYgEU(pullToRefreshState, z, modifier4, f3, null, indicatorContainerColor, 0.0f, ComposableLambdaKt.rememberComposableLambda(298232649, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1

                    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: PullToRefresh.kt */
                    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                    static final class AnonymousClass1 implements Function3<Boolean, Composer, Integer, Unit> {
                        final /* synthetic */ long $color;
                        final /* synthetic */ PullToRefreshState $state;

                        AnonymousClass1(long j, PullToRefreshState pullToRefreshState) {
                            this.$color = j;
                            this.$state = pullToRefreshState;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer, Integer num) {
                            invoke(bool.booleanValue(), composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z, Composer composer, int i) {
                            ComposerKt.sourceInformation(composer, "CN(refreshing):PullToRefresh.kt#djiw08");
                            if ((i & 6) == 0) {
                                i |= composer.changed(z) ? 4 : 2;
                            }
                            if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2064098104, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous>.<anonymous> (PullToRefresh.kt:528)");
                            }
                            if (z) {
                                composer.startReplaceGroup(-499784343);
                                ComposerKt.sourceInformation(composer, "529@20693L201");
                                ProgressIndicatorKt.m3943CircularProgressIndicator4lLiAd8(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, PullToRefreshKt.getSpinnerSize()), this.$color, PullToRefreshKt.StrokeWidth, 0L, 0, 0.0f, composer, 390, 56);
                                composer.endReplaceGroup();
                            } else {
                                composer.startReplaceGroup(-499540745);
                                ComposerKt.sourceInformation(composer, "536@21007L26,535@20940L155");
                                ComposerKt.sourceInformationMarkerStart(composer, 676625122, "CC(remember):PullToRefresh.kt#9igjgp");
                                boolean zChanged = composer.changed(this.$state);
                                final PullToRefreshState pullToRefreshState = this.$state;
                                Object objRememberedValue = composer.rememberedValue();
                                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x008f: CONSTRUCTOR (r14v3 'objRememberedValue' java.lang.Object) = (r13v2 'pullToRefreshState' androidx.compose.material3.pulltorefresh.PullToRefreshState A[DONT_INLINE]) A[MD:(androidx.compose.material3.pulltorefresh.PullToRefreshState):void (m)] call: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1$$ExternalSyntheticLambda0.<init>(androidx.compose.material3.pulltorefresh.PullToRefreshState):void type: CONSTRUCTOR in method: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1.1.invoke(boolean, androidx.compose.runtime.Composer, int):void, file: classes2.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 31 more
                                        */
                                    /*
                                        this = this;
                                        java.lang.String r0 = "CN(refreshing):PullToRefresh.kt#djiw08"
                                        androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
                                        r0 = r14 & 6
                                        if (r0 != 0) goto L13
                                        boolean r0 = r13.changed(r12)
                                        if (r0 == 0) goto L11
                                        r0 = 4
                                        goto L12
                                    L11:
                                        r0 = 2
                                    L12:
                                        r14 = r14 | r0
                                    L13:
                                        r0 = r14 & 19
                                        r1 = 18
                                        r2 = 0
                                        if (r0 == r1) goto L1c
                                        r0 = 1
                                        goto L1d
                                    L1c:
                                        r0 = r2
                                    L1d:
                                        r1 = r14 & 1
                                        boolean r0 = r13.shouldExecute(r0, r1)
                                        if (r0 == 0) goto Lac
                                        boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                        if (r0 == 0) goto L34
                                        r0 = -1
                                        java.lang.String r1 = "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous>.<anonymous> (PullToRefresh.kt:528)"
                                        r3 = -2064098104(0xffffffff84f85cc8, float:-5.8389726E-36)
                                        androidx.compose.runtime.ComposerKt.traceEventStart(r3, r14, r0, r1)
                                    L34:
                                        if (r12 == 0) goto L63
                                        r12 = -499784343(0xffffffffe235e569, float:-8.3884786E20)
                                        r13.startReplaceGroup(r12)
                                        java.lang.String r12 = "529@20693L201"
                                        androidx.compose.runtime.ComposerKt.sourceInformation(r13, r12)
                                        float r3 = androidx.compose.material3.pulltorefresh.PullToRefreshKt.access$getStrokeWidth$p()
                                        androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.INSTANCE
                                        androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
                                        float r14 = androidx.compose.material3.pulltorefresh.PullToRefreshKt.getSpinnerSize()
                                        androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m2083size3ABfNKs(r12, r14)
                                        long r1 = r11.$color
                                        r9 = 390(0x186, float:5.47E-43)
                                        r10 = 56
                                        r4 = 0
                                        r6 = 0
                                        r7 = 0
                                        r8 = r13
                                        androidx.compose.material3.ProgressIndicatorKt.m3943CircularProgressIndicator4lLiAd8(r0, r1, r3, r4, r6, r7, r8, r9, r10)
                                        r8.endReplaceGroup()
                                        goto La2
                                    L63:
                                        r8 = r13
                                        r12 = -499540745(0xffffffffe2399cf7, float:-8.5598954E20)
                                        r8.startReplaceGroup(r12)
                                        java.lang.String r12 = "536@21007L26,535@20940L155"
                                        androidx.compose.runtime.ComposerKt.sourceInformation(r8, r12)
                                        r12 = 676625122(0x28547ae2, float:1.179501E-14)
                                        java.lang.String r13 = "CC(remember):PullToRefresh.kt#9igjgp"
                                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r12, r13)
                                        androidx.compose.material3.pulltorefresh.PullToRefreshState r12 = r11.$state
                                        boolean r12 = r8.changed(r12)
                                        androidx.compose.material3.pulltorefresh.PullToRefreshState r13 = r11.$state
                                        java.lang.Object r14 = r8.rememberedValue()
                                        if (r12 != 0) goto L8d
                                        androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.INSTANCE
                                        java.lang.Object r12 = r12.getEmpty()
                                        if (r14 != r12) goto L95
                                    L8d:
                                        androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1$$ExternalSyntheticLambda0 r14 = new androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1$$ExternalSyntheticLambda0
                                        r14.<init>(r13)
                                        r8.updateRememberedValue(r14)
                                    L95:
                                        androidx.compose.material3.internal.FloatProducer r14 = (androidx.compose.material3.internal.FloatProducer) r14
                                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
                                        long r11 = r11.$color
                                        androidx.compose.material3.pulltorefresh.PullToRefreshKt.m4692access$CircularArrowProgressIndicatorRPmYEkk(r14, r11, r8, r2)
                                        r8.endReplaceGroup()
                                    La2:
                                        boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                        if (r11 == 0) goto Lab
                                        androidx.compose.runtime.ComposerKt.traceEventEnd()
                                    Lab:
                                        return
                                    Lac:
                                        r8 = r13
                                        r8.skipToGroupEnd()
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1.AnonymousClass1.invoke(boolean, androidx.compose.runtime.Composer, int):void");
                                }
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                                invoke(boxScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(BoxScope boxScope, Composer composer2, int i11) {
                                ComposerKt.sourceInformation(composer2, "C526@20600L7,527@20623L504,524@20476L651:PullToRefresh.kt#djiw08");
                                if (!composer2.shouldExecute((i11 & 17) != 16, i11 & 1)) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(298232649, i11, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous> (PullToRefresh.kt:524)");
                                }
                                CrossfadeKt.Crossfade(Boolean.valueOf(z), (Modifier) null, (FiniteAnimationSpec<Float>) MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer2, 6), (String) null, ComposableLambdaKt.rememberComposableLambda(-2064098104, true, new AnonymousClass1(j6, pullToRefreshState), composer2, 54), composer2, 24576, 10);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, i10, 80);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f2 = f3;
                        j4 = indicatorContainerColor;
                        j5 = j6;
                        modifier3 = modifier4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PullToRefreshDefaults.Indicator_2poqoh4$lambda$8(this.f$0, pullToRefreshState, z, modifier3, j4, j5, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 384;
                modifier2 = modifier;
                if ((i & 3072) != 0) {
                }
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((599187 & i3) == 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:100:0x011f  */
            /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
            /* JADX WARN: Removed duplicated region for block: B:104:0x012b  */
            /* JADX WARN: Removed duplicated region for block: B:192:0x033a  */
            /* JADX WARN: Removed duplicated region for block: B:195:0x0349  */
            /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
            /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
            /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
            /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
            /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
            /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
            /* JADX WARN: Removed duplicated region for block: B:80:0x00e4  */
            /* JADX WARN: Removed duplicated region for block: B:89:0x00f8  */
            /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
            /* JADX INFO: renamed from: IndicatorBox-1CPYgEU, reason: not valid java name */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void m4685IndicatorBox1CPYgEU(final PullToRefreshState pullToRefreshState, final boolean z, Modifier modifier, float f, Shape shape2, long j, float f2, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
                int i3;
                boolean z2;
                int i4;
                Modifier modifier2;
                float f3;
                int i5;
                long jM6361getUnspecified0d7_KjU;
                float f4;
                final Shape shape3;
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
                Shape shape4;
                Composer composerStartRestartGroup = composer.startRestartGroup(-1341144489);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(IndicatorBox)N(state,isRefreshing,modifier,maxDistance:c#ui.unit.Dp,shape,containerColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,content)461@17782L372,471@18183L951,457@17644L1652:PullToRefresh.kt#djiw08");
                if ((i2 & 1) != 0) {
                    i3 = i | 6;
                } else if ((i & 6) == 0) {
                    i3 = (composerStartRestartGroup.changed(pullToRefreshState) ? 4 : 2) | i;
                } else {
                    i3 = i;
                }
                if ((i2 & 2) != 0) {
                    i3 |= 48;
                } else {
                    if ((i & 48) == 0) {
                        z2 = z;
                        i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
                    }
                    i4 = i2 & 4;
                    if (i4 == 0) {
                        i3 |= 384;
                    } else {
                        if ((i & 384) == 0) {
                            modifier2 = modifier;
                            i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                        }
                        if ((i & 3072) == 0) {
                            if ((i2 & 8) == 0) {
                                f3 = f;
                                int i6 = composerStartRestartGroup.changed(f3) ? 2048 : 1024;
                                i3 |= i6;
                            } else {
                                f3 = f;
                            }
                            i3 |= i6;
                        } else {
                            f3 = f;
                        }
                        if ((i & 24576) == 0) {
                            i3 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(shape2)) ? 16384 : 8192;
                        }
                        i5 = i2 & 32;
                        if (i5 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            jM6361getUnspecified0d7_KjU = j;
                        } else {
                            jM6361getUnspecified0d7_KjU = j;
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i3 |= composerStartRestartGroup.changed(jM6361getUnspecified0d7_KjU) ? 131072 : 65536;
                            }
                        }
                        if ((i & 1572864) == 0) {
                            f4 = f2;
                            i3 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(f4)) ? 1048576 : 524288;
                        } else {
                            f4 = f2;
                        }
                        if ((i2 & 128) != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                        }
                        if ((i2 & 256) == 0) {
                            if ((100663296 & i) == 0) {
                                i3 |= composerStartRestartGroup.changed(this) ? 67108864 : 33554432;
                            }
                            boolean z3 = true;
                            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                shape3 = shape2;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i4 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                        f3 = IndicatorMaxDistance;
                                    }
                                    if ((i2 & 16) != 0) {
                                        shape4 = indicatorShape;
                                        i3 = (-57345) & i3;
                                    } else {
                                        shape4 = shape2;
                                    }
                                    if (i5 != 0) {
                                        jM6361getUnspecified0d7_KjU = Color.INSTANCE.m6361getUnspecified0d7_KjU();
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                        f4 = Elevation;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                    }
                                    shape4 = shape2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1341144489, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.IndicatorBox (PullToRefresh.kt:456)");
                                }
                                Modifier modifierM2083size3ABfNKs = SizeKt.m2083size3ABfNKs(modifier2, PullToRefreshKt.getSpinnerContainerSize());
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -349648245, "CC(remember):PullToRefresh.kt#9igjgp");
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$2$lambda$1((ContentDrawScope) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Modifier modifierDrawWithContent = DrawModifierKt.drawWithContent(modifierM2083size3ABfNKs, (Function1) objRememberedValue);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -349634834, "CC(remember):PullToRefresh.kt#9igjgp");
                                boolean z4 = ((i3 & 14) == 4) | ((i3 & 112) == 32) | ((((i3 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(f3)) || (i3 & 3072) == 2048) | ((((3670016 & i3) ^ 1572864) > 1048576 && composerStartRestartGroup.changed(f4)) || (i3 & 1572864) == 1048576);
                                if ((((57344 & i3) ^ 24576) <= 16384 || !composerStartRestartGroup.changed(shape4)) && (i3 & 24576) != 16384) {
                                    z3 = false;
                                }
                                boolean z5 = z4 | z3;
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (z5 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    final Shape shape5 = shape4;
                                    final boolean z6 = z2;
                                    final float f5 = f3;
                                    final float f6 = f4;
                                    objRememberedValue2 = new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$6$lambda$5(pullToRefreshState, z6, f5, f6, shape5, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Modifier modifierM1482backgroundbw27NRU = BackgroundKt.m1482backgroundbw27NRU(LayoutModifierKt.layout(modifierDrawWithContent, (Function3) objRememberedValue2), jM6361getUnspecified0d7_KjU, shape4);
                                Alignment center = Alignment.INSTANCE.getCenter();
                                int i7 = ((i3 >> 12) & 7168) | 48;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                                Shape shape6 = shape4;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1482backgroundbw27NRU);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(constructor);
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                function3.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i7 >> 6) & 112) | 6));
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                shape3 = shape6;
                            }
                            final Modifier modifier3 = modifier2;
                            final float f7 = f3;
                            final long j2 = jM6361getUnspecified0d7_KjU;
                            final float f8 = f4;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$7(this.f$0, pullToRefreshState, z, modifier3, f7, shape3, j2, f8, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 100663296;
                        boolean z32 = true;
                        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                        }
                        final Modifier modifier32 = modifier2;
                        final float f72 = f3;
                        final long j22 = jM6361getUnspecified0d7_KjU;
                        final float f82 = f4;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    modifier2 = modifier;
                    if ((i & 3072) == 0) {
                    }
                    if ((i & 24576) == 0) {
                    }
                    i5 = i2 & 32;
                    if (i5 != 0) {
                    }
                    if ((i & 1572864) == 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if ((i2 & 256) == 0) {
                    }
                    boolean z322 = true;
                    if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                    }
                    final Modifier modifier322 = modifier2;
                    final float f722 = f3;
                    final long j222 = jM6361getUnspecified0d7_KjU;
                    final float f822 = f4;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z2 = z;
                i4 = i2 & 4;
                if (i4 == 0) {
                }
                modifier2 = modifier;
                if ((i & 3072) == 0) {
                }
                if ((i & 24576) == 0) {
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if ((i2 & 256) == 0) {
                }
                boolean z3222 = true;
                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                }
                final Modifier modifier3222 = modifier2;
                final float f7222 = f3;
                final long j2222 = jM6361getUnspecified0d7_KjU;
                final float f8222 = f4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }

            public final long getContainerColor(Composer composer, int i) {
                ComposerKt.sourceInformationMarkerStart(composer, 1066257972, "C(<get-containerColor>)405@15435L11:PullToRefresh.kt#djiw08");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1066257972, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-containerColor> (PullToRefresh.kt:405)");
                }
                long surfaceContainerHigh = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurfaceContainerHigh();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return surfaceContainerHigh;
            }

            /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
            public final float m4686getElevationD9Ej5fM() {
                return Elevation;
            }

            public final long getIndicatorColor(Composer composer, int i) {
                ComposerKt.sourceInformationMarkerStart(composer, -1441334156, "C(<get-indicatorColor>)413@15766L11:PullToRefresh.kt#djiw08");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1441334156, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-indicatorColor> (PullToRefresh.kt:413)");
                }
                long onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getOnSurfaceVariant();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return onSurfaceVariant;
            }

            public final long getIndicatorContainerColor(Composer composer, int i) {
                ComposerKt.sourceInformationMarkerStart(composer, -80510850, "C(<get-indicatorContainerColor>)409@15605L11:PullToRefresh.kt#djiw08");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-80510850, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-indicatorContainerColor> (PullToRefresh.kt:409)");
                }
                long surfaceContainerHigh = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurfaceContainerHigh();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return surfaceContainerHigh;
            }

            /* JADX INFO: renamed from: getIndicatorMaxDistance-D9Ej5fM, reason: not valid java name */
            public final float m4687getIndicatorMaxDistanceD9Ej5fM() {
                return IndicatorMaxDistance;
            }

            public final Shape getIndicatorShape() {
                return indicatorShape;
            }

            /* JADX INFO: renamed from: getLoadingIndicatorElevation-D9Ej5fM, reason: not valid java name */
            public final float m4688getLoadingIndicatorElevationD9Ej5fM() {
                return LoadingIndicatorElevation;
            }

            /* JADX INFO: renamed from: getPositionalThreshold-D9Ej5fM, reason: not valid java name */
            public final float m4689getPositionalThresholdD9Ej5fM() {
                return PositionalThreshold;
            }

            public final Shape getShape() {
                return shape;
            }
        }
