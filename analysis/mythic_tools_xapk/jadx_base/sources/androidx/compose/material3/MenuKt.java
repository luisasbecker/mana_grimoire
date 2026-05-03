package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0082\u0001\u0010\u001c\u001a\u00020\u00012\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0013\u0010 \u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e¢\u0006\u0002\b\u00182\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e¢\u0006\u0002\b\u00182\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0001¢\u0006\u0002\u0010)\u001a\u001d\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0000¢\u0006\u0002\u0010.\"\u0016\u0010/\u001a\u00020\u0011X\u0080\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101\"\u0010\u00103\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00104\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0016\u00105\u001a\u00020\u0011X\u0080\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\b6\u00101\"\u0010\u00107\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00108\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u000e\u00109\u001a\u00020:X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020:X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020:X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020:X\u0080T¢\u0006\u0002\n\u0000¨\u0006>²\u0006\n\u0010?\u001a\u00020:X\u008a\u0084\u0002²\u0006\n\u0010@\u001a\u00020:X\u008a\u0084\u0002"}, d2 = {"DropdownMenuContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "expandedState", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenuContent-Qj0Zi0g", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "DropdownMenuItemContent", "text", "Lkotlin/Function0;", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "calculateTransformOrigin", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "MenuVerticalMargin", "getMenuVerticalMargin", "()F", "F", "MenuListItemContainerHeight", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemDefaultMaxWidth", "ExpandedScaleTarget", "", "ClosedScaleTarget", "ExpandedAlphaTarget", "ClosedAlphaTarget", "material3", "scale", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MenuKt {
    public static final float ClosedAlphaTarget = 0.0f;
    public static final float ClosedScaleTarget = 0.8f;
    public static final float ExpandedAlphaTarget = 1.0f;
    public static final float ExpandedScaleTarget = 1.0f;
    private static final float MenuVerticalMargin = Dp.m9114constructorimpl(48.0f);
    private static final float MenuListItemContainerHeight = Dp.m9114constructorimpl(48.0f);
    private static final float DropdownMenuItemHorizontalPadding = Dp.m9114constructorimpl(12.0f);
    private static final float DropdownMenuVerticalPadding = Dp.m9114constructorimpl(8.0f);
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m9114constructorimpl(112.0f);
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m9114constructorimpl(280.0f);

    /* JADX INFO: renamed from: DropdownMenuContent-Qj0Zi0g, reason: not valid java name */
    public static final void m3824DropdownMenuContentQj0Zi0g(final Modifier modifier, final MutableTransitionState<Boolean> mutableTransitionState, final MutableState<TransformOrigin> mutableState, final ScrollState scrollState, final Shape shape, final long j, final float f, final float f2, final BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        boolean z;
        Float f3;
        Object obj;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(848986741);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuContent)N(modifier,expandedState,transformOriginState,scrollState,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)371@17333L47,373@17516L14,374@17594L14,376@17645L146,381@17829L146,385@18020L7,388@18095L587,405@18854L277,386@18032L1099:Menu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(mutableTransitionState) : composerStartRestartGroup.changedInstance(mutableTransitionState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(scrollState) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= composerStartRestartGroup.changed(borderStroke) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 306783379) != 306783378, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(848986741, i2, -1, "androidx.compose.material3.DropdownMenuContent (Menu.kt:369)");
            }
            Transition transitionUpdateTransition = TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, "DropDownMenu", composerStartRestartGroup, MutableTransitionState.$stable | 48 | ((i2 >> 3) & 14), 0);
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            Function3 function32 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$scale$2
                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer3, int i4) {
                    composer3.startReplaceGroup(-745957716);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-745957716, i4, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:376)");
                    }
                    FiniteAnimationSpec<Float> finiteAnimationSpec = finiteAnimationSpecValue;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return finiteAnimationSpec;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            boolean zBooleanValue = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(143964305);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(expanded):Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(143964305, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:377)");
            }
            float f4 = zBooleanValue ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf = Float.valueOf(f4);
            boolean zBooleanValue2 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(143964305);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(expanded):Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                z = zBooleanValue2;
                f3 = fValueOf;
                ComposerKt.traceEventStart(143964305, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:377)");
            } else {
                z = zBooleanValue2;
                f3 = fValueOf;
            }
            float f5 = z ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            final State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, f3, Float.valueOf(f5), (FiniteAnimationSpec) function32.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function3 function33 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$alpha$2
                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer3, int i4) {
                    composer3.startReplaceGroup(2839488);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2839488, i4, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:381)");
                    }
                    FiniteAnimationSpec<Float> finiteAnimationSpec = finiteAnimationSpecValue2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return finiteAnimationSpec;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer3, Integer num) {
                    return invoke(segment, composer3, num.intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            boolean zBooleanValue3 = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(892761509);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(expanded):Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(892761509, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:382)");
            }
            float f6 = zBooleanValue3 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf2 = Float.valueOf(f6);
            boolean zBooleanValue4 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(892761509);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(expanded):Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(892761509, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:382)");
            }
            float f7 = zBooleanValue4 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            final State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f7), (FiniteAnimationSpec) function33.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "FloatAnimation", composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Boolean> localInspectionMode = InspectionModeKt.getLocalInspectionMode();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localInspectionMode);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final boolean zBooleanValue5 = ((Boolean) objConsume).booleanValue();
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -167488352, "CC(remember):Menu.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(zBooleanValue5) | composerStartRestartGroup.changed(stateCreateTransitionAnimation) | ((i2 & 112) == 32 || ((i2 & 64) != 0 && composerStartRestartGroup.changedInstance(mutableTransitionState))) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                i3 = i2;
                obj = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$5$lambda$4(zBooleanValue5, mutableTransitionState, mutableState, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, (GraphicsLayerScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue;
                i3 = i2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i4 = i3 >> 9;
            int i5 = i3 >> 6;
            SurfaceKt.m4145SurfaceT9BRK9s(GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) obj), shape, j, 0L, f, f2, borderStroke, ComposableLambdaKt.rememberComposableLambda(-1463404422, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    ComposerKt.sourceInformation(composer3, "C406@18864L261:Menu.kt#uh7d8r");
                    if (!composer3.shouldExecute((i6 & 3) != 2, i6 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1463404422, i6, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:406)");
                    }
                    Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(IntrinsicKt.width(PaddingKt.m2039paddingVpY3zN4$default(modifier, 0.0f, MenuKt.getDropdownMenuVerticalPadding(), 1, null), IntrinsicSize.Max), scrollState, false, null, false, 14, null);
                    Function3<ColumnScope, Composer, Integer, Unit> function34 = function3;
                    ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierVerticalScroll$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer3);
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    function34.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 896) | (i4 & 112) | 12582912 | (57344 & i5) | (458752 & i5) | (i5 & 3670016), 8);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$6(modifier, mutableTransitionState, mutableState, scrollState, shape, j, f, f2, borderStroke, function3, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final float DropdownMenuContent_Qj0Zi0g$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float DropdownMenuContent_Qj0Zi0g$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    static final Unit DropdownMenuContent_Qj0Zi0g$lambda$5$lambda$4(boolean z, MutableTransitionState mutableTransitionState, MutableState mutableState, State state, State state2, GraphicsLayerScope graphicsLayerScope) {
        float fDropdownMenuContent_Qj0Zi0g$lambda$1 = 0.8f;
        float fDropdownMenuContent_Qj0Zi0g$lambda$3 = 1.0f;
        graphicsLayerScope.setScaleX(!z ? DropdownMenuContent_Qj0Zi0g$lambda$1(state) : ((Boolean) mutableTransitionState.getTargetState()).booleanValue() ? 1.0f : 0.8f);
        if (!z) {
            fDropdownMenuContent_Qj0Zi0g$lambda$1 = DropdownMenuContent_Qj0Zi0g$lambda$1(state);
        } else if (((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
            fDropdownMenuContent_Qj0Zi0g$lambda$1 = 1.0f;
        }
        graphicsLayerScope.setScaleY(fDropdownMenuContent_Qj0Zi0g$lambda$1);
        if (!z) {
            fDropdownMenuContent_Qj0Zi0g$lambda$3 = DropdownMenuContent_Qj0Zi0g$lambda$3(state2);
        } else if (!((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
            fDropdownMenuContent_Qj0Zi0g$lambda$3 = 0.0f;
        }
        graphicsLayerScope.setAlpha(fDropdownMenuContent_Qj0Zi0g$lambda$3);
        graphicsLayerScope.mo6526setTransformOrigin__ExYCQ(((TransformOrigin) mutableState.getValue()).getPackedValue());
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenuContent_Qj0Zi0g$lambda$6(Modifier modifier, MutableTransitionState mutableTransitionState, MutableState mutableState, ScrollState scrollState, Shape shape, long j, float f, float f2, BorderStroke borderStroke, Function3 function3, int i, Composer composer, int i2) {
        m3824DropdownMenuContentQj0Zi0g(modifier, mutableTransitionState, mutableState, scrollState, shape, j, f, f2, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DropdownMenuItemContent(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final boolean z, final MenuItemColors menuItemColors, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i2;
        Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        MenuItemColors menuItemColors2;
        MutableInteractionSource mutableInteractionSource2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1325192924);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItemContent)N(text,onClick,modifier,leadingIcon,trailingIcon,enabled,colors,contentPadding,interactionSource)429@19500L2499:Menu.kt#uh7d8r");
        if ((i & 6) == 0) {
            function24 = function2;
            i2 = (composerStartRestartGroup.changedInstance(function24) ? 4 : 2) | i;
        } else {
            function24 = function2;
            i2 = i;
        }
        if ((i & 48) == 0) {
            function02 = function0;
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function25 = function22;
            i2 |= composerStartRestartGroup.changedInstance(function25) ? 2048 : 1024;
        } else {
            function25 = function22;
        }
        if ((i & 24576) == 0) {
            function26 = function23;
            i2 |= composerStartRestartGroup.changedInstance(function26) ? 16384 : 8192;
        } else {
            function26 = function23;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            menuItemColors2 = menuItemColors;
            i2 |= composerStartRestartGroup.changed(menuItemColors2) ? 1048576 : 524288;
        } else {
            menuItemColors2 = menuItemColors;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            mutableInteractionSource2 = mutableInteractionSource;
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1325192924, i2, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:428)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.m2087sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m1514clickableO2vRcR0$default(modifier, mutableInteractionSource2, RippleKt.m3978rippleH2RKhps$default(true, 0.0f, 0L, 6, null), z, null, null, function02, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, MenuListItemContainerHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 35357496, "C449@20357L10,449@20380L1613,449@20326L1667:Menu.kt#uh7d8r");
            final Function2<? super Composer, ? super Integer, Unit> function27 = function24;
            final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
            final MenuItemColors menuItemColors3 = menuItemColors2;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function25;
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getLabelLarge(), ComposableLambdaKt.rememberComposableLambda(865999929, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C459@20844L764,459@20765L843:Menu.kt#uh7d8r");
                    if (!composer2.shouldExecute((i3 & 3) != 2, i3 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(865999929, i3, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:450)");
                    }
                    if (function29 != null) {
                        composer2.startReplaceGroup(-864613220);
                        ComposerKt.sourceInformation(composer2, "453@20561L177,451@20437L301");
                        ProvidedValue<Color> providedValueProvides = ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(menuItemColors3.m3821leadingIconColorvNxB06k$material3(z)));
                        final Function2<Composer, Integer, Unit> function210 = function29;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(1241781204, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i4) {
                                ComposerKt.sourceInformation(composer3, "C454@20583L137:Menu.kt#uh7d8r");
                                if (!composer3.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1241781204, i4, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:454)");
                                }
                                Modifier modifierM2068defaultMinSizeVpY3zN4$default = SizeKt.m2068defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, ListTokens.INSTANCE.m5097getListItemLeadingIconSizeD9Ej5fM(), 0.0f, 2, null);
                                Function2<Composer, Integer, Unit> function211 = function210;
                                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM2068defaultMinSizeVpY3zN4$default);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer3);
                                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -1523115460, "C455@20685L13:Menu.kt#uh7d8r");
                                function211.invoke(composer3, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-864293207);
                        composer2.endReplaceGroup();
                    }
                    ProvidedValue<Color> providedValueProvides2 = ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(menuItemColors3.m3822textColorvNxB06k$material3(z)));
                    final RowScope rowScope = rowScopeInstance;
                    final Function2<Composer, Integer, Unit> function211 = function29;
                    final Function2<Composer, Integer, Unit> function212 = function28;
                    final Function2<Composer, Integer, Unit> function213 = function27;
                    CompositionLocalKt.CompositionLocalProvider(providedValueProvides2, ComposableLambdaKt.rememberComposableLambda(-893579015, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i4) {
                            ComposerKt.sourceInformation(composer3, "C460@20862L732:Menu.kt#uh7d8r");
                            if (!composer3.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-893579015, i4, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:460)");
                            }
                            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), function211 != null ? MenuKt.DropdownMenuItemHorizontalPadding : Dp.m9114constructorimpl(0.0f), 0.0f, function212 != null ? MenuKt.DropdownMenuItemHorizontalPadding : Dp.m9114constructorimpl(0.0f), 0.0f, 10, null);
                            Function2<Composer, Integer, Unit> function214 = function213;
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM2041paddingqDBjuR0$default);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor2);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer3);
                            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -192291042, "C477@21570L6:Menu.kt#uh7d8r");
                            function214.invoke(composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                    if (function28 != null) {
                        composer2.startReplaceGroup(-863394951);
                        ComposerKt.sourceInformation(composer2, "483@21790L179,481@21665L304");
                        ProvidedValue<Color> providedValueProvides3 = ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(menuItemColors3.m3823trailingIconColorvNxB06k$material3(z)));
                        final Function2<Composer, Integer, Unit> function214 = function28;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides3, ComposableLambdaKt.rememberComposableLambda(-782441013, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i4) {
                                ComposerKt.sourceInformation(composer3, "C484@21812L139:Menu.kt#uh7d8r");
                                if (!composer3.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-782441013, i4, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:484)");
                                }
                                Modifier modifierM2068defaultMinSizeVpY3zN4$default = SizeKt.m2068defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, ListTokens.INSTANCE.m5105getListItemTrailingIconSizeD9Ej5fM(), 0.0f, 2, null);
                                Function2<Composer, Integer, Unit> function215 = function214;
                                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM2068defaultMinSizeVpY3zN4$default);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer3);
                                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -845165948, "C485@21915L14:Menu.kt#uh7d8r");
                                function215.invoke(composer3, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-863072055);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.DropdownMenuItemContent$lambda$8(function2, function0, modifier, function22, function23, z, menuItemColors, paddingValues, mutableInteractionSource, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DropdownMenuItemContent$lambda$8(Function2 function2, Function0 function0, Modifier modifier, Function2 function22, Function2 function23, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, Composer composer, int i2) {
        DropdownMenuItemContent(function2, function0, modifier, function22, function23, z, menuItemColors, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long calculateTransformOrigin(IntRect intRect, IntRect intRect2) {
        float fMax;
        float fMax2;
        if (intRect2.getLeft() < intRect.getRight()) {
            fMax = intRect2.getRight() <= intRect.getLeft() ? 1.0f : intRect2.getWidth() == 0 ? 0.0f : (((Math.max(intRect.getLeft(), intRect2.getLeft()) + Math.min(intRect.getRight(), intRect2.getRight())) / 2) - intRect2.getLeft()) / intRect2.getWidth();
        }
        if (intRect2.getTop() < intRect.getBottom()) {
            fMax2 = intRect2.getBottom() > intRect.getTop() ? intRect2.getHeight() == 0 ? 0.0f : (((Math.max(intRect.getTop(), intRect2.getTop()) + Math.min(intRect.getBottom(), intRect2.getBottom())) / 2) - intRect2.getTop()) / intRect2.getHeight() : 1.0f;
        }
        return TransformOriginKt.TransformOrigin(fMax, fMax2);
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }
}
