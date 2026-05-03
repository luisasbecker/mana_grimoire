package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a?\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\t\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\"\u0016\u0010\u001d\u001a\u00020\u001eX\u0080\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 \"\u0016\u0010\"\u001a\u00020\u001eX\u0080\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b#\u0010 \"\u0016\u0010$\u001a\u00020\u001eX\u0080\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b%\u0010 \"\u0010\u0010&\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010'\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010(\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010)\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010*\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120,X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010-\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u0010\u0010.\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u000e\u0010/\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00100\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!¨\u00061²\u0006\n\u00102\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\u0018\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005X\u008a\u0084\u0002²\u0006\n\u00104\u001a\u00020\u0003X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Lkotlin/Function0;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "TrackWidth", "Landroidx/compose/ui/unit/Dp;", "getTrackWidth", "()F", "F", "TrackStrokeWidth", "getTrackStrokeWidth", "ThumbDiameter", "getThumbDiameter", "ThumbRippleRadius", "DefaultSwitchPadding", "SwitchWidth", "SwitchHeight", "ThumbPathLength", "AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "ThumbDefaultElevation", "ThumbPressedElevation", "SwitchPositionalThreshold", "SwitchVelocityThreshold", "material", "forceAnimationCheck", "currentOnCheckedChange", "currentChecked", "thumbColor", "resolvedThumbColor"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float DefaultSwitchPadding;
    private static final float SwitchHeight;
    private static final float SwitchPositionalThreshold = 0.7f;
    private static final float SwitchVelocityThreshold;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation;
    private static final float ThumbDiameter;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float ThumbRippleRadius;
    private static final float TrackStrokeWidth;
    private static final float TrackWidth;

    static {
        float fM9114constructorimpl = Dp.m9114constructorimpl(34.0f);
        TrackWidth = fM9114constructorimpl;
        TrackStrokeWidth = Dp.m9114constructorimpl(14.0f);
        float fM9114constructorimpl2 = Dp.m9114constructorimpl(20.0f);
        ThumbDiameter = fM9114constructorimpl2;
        ThumbRippleRadius = Dp.m9114constructorimpl(24.0f);
        DefaultSwitchPadding = Dp.m9114constructorimpl(2.0f);
        SwitchWidth = fM9114constructorimpl;
        SwitchHeight = fM9114constructorimpl2;
        ThumbPathLength = Dp.m9114constructorimpl(fM9114constructorimpl - fM9114constructorimpl2);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
        ThumbDefaultElevation = Dp.m9114constructorimpl(1.0f);
        ThumbPressedElevation = Dp.m9114constructorimpl(6.0f);
        SwitchVelocityThreshold = Dp.m9114constructorimpl(125.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Switch(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, SwitchColors switchColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        SwitchColors switchColors2;
        int i6;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource3;
        final SwitchColors switchColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        MutableInteractionSource mutableInteractionSource4;
        SnapshotMutationPolicy snapshotMutationPolicy;
        boolean z5;
        SwitchColors switchColors4;
        int i7;
        MutableInteractionSource mutableInteractionSource5;
        AnchoredDraggableState anchoredDraggableState;
        Object obj;
        Object obj2;
        AnchoredDraggableState anchoredDraggableState2;
        Object obj3;
        MutableInteractionSource mutableInteractionSource6;
        int i8;
        boolean z6;
        Modifier.Companion companionM2314toggleableO2vRcR0;
        Composer composerStartRestartGroup = composer.startRestartGroup(25866825);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Switch)N(checked,onCheckedChange,modifier,enabled,interactionSource,colors)103@4720L7,108@5102L34,109@5191L7,111@5276L524,124@5835L37,125@5899L29,126@5972L315,126@5933L354,135@6337L133,135@6292L178,140@6508L7,155@6950L1052:Switch.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    i3 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            switchColors2 = switchColors;
                            int i10 = composerStartRestartGroup.changed(switchColors2) ? 131072 : 65536;
                            i3 |= i10;
                        } else {
                            switchColors2 = switchColors;
                        }
                        i3 |= i10;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i6 = i3;
                    if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i6 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        switchColors3 = switchColors2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "98@4526L8");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i9 != 0 ? Modifier.INSTANCE : modifier2;
                            boolean z7 = i4 != 0 ? true : z3;
                            mutableInteractionSource4 = i5 != 0 ? null : mutableInteractionSource2;
                            if ((i2 & 32) != 0) {
                                snapshotMutationPolicy = null;
                                z5 = false;
                                SwitchColors switchColorsM3184colorsSQMK_m0 = SwitchDefaults.INSTANCE.m3184colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                                composerStartRestartGroup = composerStartRestartGroup;
                                i7 = i6 & (-458753);
                                z3 = z7;
                                switchColors4 = switchColorsM3184colorsSQMK_m0;
                                modifier2 = companion;
                            } else {
                                snapshotMutationPolicy = null;
                                z5 = false;
                                modifier2 = companion;
                                z3 = z7;
                                switchColors4 = switchColors2;
                                i7 = i6;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i7 = i6 & (-458753);
                                mutableInteractionSource4 = mutableInteractionSource2;
                                switchColors4 = switchColors2;
                                snapshotMutationPolicy = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                                switchColors4 = switchColors2;
                                snapshotMutationPolicy = null;
                                i7 = i6;
                            }
                            z5 = false;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(25866825, i7, -1, "androidx.compose.material.Switch (Switch.kt:99)");
                        }
                        if (mutableInteractionSource4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1799771122);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "101@4621L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911774192, "CC(remember):Switch.kt#9igjgp");
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-911774843);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource5 = mutableInteractionSource4;
                        }
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fMo1624toPx0680j_4 = ((Density) objConsume).mo1624toPx0680j_4(ThumbPathLength);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911758805, "CC(remember):Switch.kt#9igjgp");
                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z5), snapshotMutationPolicy, 2, snapshotMutationPolicy);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        MutableState mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float fMo1624toPx0680j_42 = ((Density) objConsume2).mo1624toPx0680j_4(SwitchVelocityThreshold);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911752747, "CC(remember):Switch.kt#9igjgp");
                        boolean zChanged = composerStartRestartGroup.changed(fMo1624toPx0680j_4) | composerStartRestartGroup.changed(fMo1624toPx0680j_42);
                        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            final float f = 0.0f;
                            objRememberedValue3 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj4) {
                                    return SwitchKt.Switch$lambda$6$0(f, fMo1624toPx0680j_4, (DraggableAnchorsConfig) obj4);
                                }
                            }), new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj4) {
                                    return Float.valueOf(SwitchKt.Switch$lambda$6$1(((Float) obj4).floatValue()));
                                }
                            }, new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(SwitchKt.Switch$lambda$6$2(fMo1624toPx0680j_42));
                                }
                            }, AnimationSpec, null, 32, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        AnchoredDraggableState anchoredDraggableState3 = (AnchoredDraggableState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i11 = i7 >> 3;
                        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, i11 & 14);
                        int i12 = i7 & 14;
                        State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), composerStartRestartGroup, i12);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911730684, "CC(remember):Switch.kt#9igjgp");
                        boolean zChanged2 = composerStartRestartGroup.changed(anchoredDraggableState3) | composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            Object switchKt$Switch$1$1 = new SwitchKt$Switch$1$1(anchoredDraggableState3, stateRememberUpdatedState2, stateRememberUpdatedState, mutableState, null);
                            anchoredDraggableState = anchoredDraggableState3;
                            obj = (Function2) switchKt$Switch$1$1;
                            composerStartRestartGroup.updateRememberedValue(obj);
                        } else {
                            obj = objRememberedValue4;
                            anchoredDraggableState = anchoredDraggableState3;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(anchoredDraggableState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) obj, composerStartRestartGroup, z5 ? 1 : 0);
                        Boolean boolValueOf = Boolean.valueOf(z);
                        Boolean boolValueOf2 = Boolean.valueOf(Switch$lambda$3(mutableState));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -911719186, "CC(remember):Switch.kt#9igjgp");
                        boolean zChanged3 = (i12 == 4) | composerStartRestartGroup.changed(anchoredDraggableState);
                        Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (zChanged3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            obj2 = null;
                            objRememberedValue5 = (Function2) new SwitchKt$Switch$2$1(z, anchoredDraggableState, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            obj2 = null;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf, boolValueOf2, (Function2) objRememberedValue5, composerStartRestartGroup, i12);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        boolean z8 = objConsume3 == LayoutDirection.Rtl;
                        if (function1 != null) {
                            anchoredDraggableState2 = anchoredDraggableState;
                            obj3 = obj2;
                            z4 = z3;
                            mutableInteractionSource6 = mutableInteractionSource5;
                            i8 = 2;
                            z6 = false;
                            companionM2314toggleableO2vRcR0 = ToggleableKt.m2314toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource6, null, z4, Role.m8320boximpl(Role.INSTANCE.m8333getSwitcho7Vup1c()), function1);
                        } else {
                            anchoredDraggableState2 = anchoredDraggableState;
                            obj3 = obj2;
                            z4 = z3;
                            mutableInteractionSource6 = mutableInteractionSource5;
                            i8 = 2;
                            z6 = false;
                            companionM2314toggleableO2vRcR0 = Modifier.INSTANCE;
                        }
                        Modifier modifierThen = modifier2.then(function1 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companionM2314toggleableO2vRcR0);
                        boolean z9 = z6;
                        final AnchoredDraggableState anchoredDraggableState4 = anchoredDraggableState2;
                        Modifier modifierM2077requiredSizeVpY3zN4 = SizeKt.m2077requiredSizeVpY3zN4(PaddingKt.m2037padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifierThen, anchoredDraggableState2, Orientation.Horizontal, (!z4 || function1 == null) ? z6 : true, z8, mutableInteractionSource6, false), Alignment.INSTANCE.getCenter(), z9, i8, obj3), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z9);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, z9 ? 1 : 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2077requiredSizeVpY3zN4);
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
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 351089009, "C181@7892L42,177@7737L259:Switch.kt#jmzs0o");
                        boolean zBooleanValue = ((Boolean) anchoredDraggableState4.getTargetValue()).booleanValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1928332455, "CC(remember):Switch.kt#9igjgp");
                        boolean zChanged4 = composerStartRestartGroup.changed(anchoredDraggableState4);
                        Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (zChanged4 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function0() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(anchoredDraggableState4.requireOffset());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifier4 = modifier2;
                        SwitchImpl(boxScopeInstance, zBooleanValue, z4, switchColors4, (Function0) objRememberedValue6, mutableInteractionSource6, composerStartRestartGroup, (i11 & 896) | 6 | ((i7 >> 6) & 7168));
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        switchColors3 = switchColors4;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj4, Object obj5) {
                                return SwitchKt.Switch$lambda$12(z, function1, modifier3, z4, mutableInteractionSource3, switchColors3, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((196608 & i) != 0) {
                }
                i6 = i3;
                if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i6 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z2;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) != 0) {
            }
            i6 = i3;
            if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i6 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z2;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((196608 & i) != 0) {
        }
        i6 = i3;
        if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit Switch$lambda$12(boolean z, Function1 function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, SwitchColors switchColors, int i, int i2, Composer composer, int i3) {
        Switch(z, function1, modifier, z2, mutableInteractionSource, switchColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Switch$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Switch$lambda$6$0(float f, float f2, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(false, f);
        draggableAnchorsConfig.at(true, f2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Switch$lambda$6$1(float f) {
        return f * 0.7f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Switch$lambda$6$2(float f) {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Boolean, Unit> Switch$lambda$7(State<? extends Function1<? super Boolean, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX WARN: Failed to inline method: androidx.compose.ui.draw.ShadowKt.shadow-s4CzXII$default(androidx.compose.ui.Modifier, float, androidx.compose.ui.graphics.Shape, boolean, long, long, int, java.lang.Object):androidx.compose.ui.Modifier */
    /* JADX WARN: Not passed register '(r4v7 'fM9114constructorimpl' float)' in method call: androidx.compose.ui.draw.ShadowKt.shadow-s4CzXII$default(androidx.compose.ui.Modifier, float, androidx.compose.ui.graphics.Shape, boolean, long, long, int, java.lang.Object):androidx.compose.ui.Modifier */
    private static final void SwitchImpl(final BoxScope boxScope, final boolean z, final boolean z2, final SwitchColors switchColors, final Function0<Float> function0, final InteractionSource interactionSource, Composer composer, final int i) {
        int i2;
        String str;
        boolean z3;
        long jSwitchImpl$lambda$4;
        Composer composerStartRestartGroup = composer.startRestartGroup(70908914);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchImpl)N(checked,enabled,colors,thumbValue,interactionSource)220@9074L46,222@9160L614,222@9126L648,242@10001L28,243@10089L81,243@10034L136,246@10200L28,247@10278L7,248@10337L7,251@10460L6,250@10395L252,259@10726L43,257@10652L455:Switch.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(switchColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        int i3 = i2;
        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70908914, i3, -1, "androidx.compose.material.SwitchImpl (Switch.kt:219)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -576004160, "CC(remember):Switch.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -576000840, "CC(remember):Switch.kt#9igjgp");
            boolean z4 = (458752 & i3) == 131072;
            SwitchKt$SwitchImpl$1$1 switchKt$SwitchImpl$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4 || switchKt$SwitchImpl$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                switchKt$SwitchImpl$1$1RememberedValue = new SwitchKt$SwitchImpl$1$1(interactionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(switchKt$SwitchImpl$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) switchKt$SwitchImpl$1$1RememberedValue, composerStartRestartGroup, (i3 >> 15) & 14);
            float f = !snapshotStateList.isEmpty() ? ThumbPressedElevation : ThumbDefaultElevation;
            int i4 = ((i3 >> 6) & 14) | (i3 & 112) | ((i3 >> 3) & 896);
            final State<Color> stateTrackColor = switchColors.trackColor(z2, z, composerStartRestartGroup, i4);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -575971645, "CC(remember):Switch.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateTrackColor);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SwitchKt.SwitchImpl$lambda$3$0(stateTrackColor, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierFillMaxSize$default, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            State<Color> stateThumbColor = switchColors.thumbColor(z2, z, composerStartRestartGroup, i4);
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ElevationOverlay elevationOverlay = (ElevationOverlay) objConsume;
            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fM9114constructorimpl = Dp.m9114constructorimpl(((Dp) objConsume2).m9128unboximpl() + f);
            if (!Color.m6326equalsimpl0(SwitchImpl$lambda$4(stateThumbColor), MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2987getSurface0d7_KjU()) || elevationOverlay == null) {
                str = "CC(remember):Switch.kt#9igjgp";
                z3 = true;
                composerStartRestartGroup.startReplaceGroup(-674751066);
                composerStartRestartGroup.endReplaceGroup();
                jSwitchImpl$lambda$4 = SwitchImpl$lambda$4(stateThumbColor);
            } else {
                composerStartRestartGroup.startReplaceGroup(-674840005);
                ComposerKt.sourceInformation(composerStartRestartGroup, "252@10539L36");
                str = "CC(remember):Switch.kt#9igjgp";
                z3 = true;
                jSwitchImpl$lambda$4 = elevationOverlay.mo3014apply7g2Lkgo(SwitchImpl$lambda$4(stateThumbColor), fM9114constructorimpl, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            State<Color> stateM1353animateColorAsStateeuL9pac = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(jSwitchImpl$lambda$4, null, null, null, composerStartRestartGroup, 0, 14);
            composerStartRestartGroup = composerStartRestartGroup;
            Modifier modifierAlign = boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -575951299, str);
            boolean z5 = (57344 & i3) == 16384 ? z3 : false;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SwitchKt.SwitchImpl$lambda$6$0(function0, (Density) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(BackgroundKt.m1482backgroundbw27NRU(ShadowKt.m5923shadows4CzXII$default(SizeKt.m2075requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(modifierAlign, (Function1) objRememberedValue3), interactionSource, RippleKt.m3125rippleH2RKhps$default(false, ThumbRippleRadius, 0L, 4, null)), ThumbDiameter), f, RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), SwitchImpl$lambda$5(stateM1353animateColorAsStateeuL9pac), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SwitchKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SwitchKt.SwitchImpl$lambda$7(boxScope, z, z2, switchColors, function0, interactionSource, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final long SwitchImpl$lambda$2(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchImpl$lambda$3$0(State state, DrawScope drawScope) {
        m3186drawTrackRPmYEkk(drawScope, SwitchImpl$lambda$2(state), drawScope.mo1624toPx0680j_4(TrackWidth), drawScope.mo1624toPx0680j_4(TrackStrokeWidth));
        return Unit.INSTANCE;
    }

    private static final long SwitchImpl$lambda$4(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    private static final long SwitchImpl$lambda$5(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset SwitchImpl$lambda$6$0(Function0 function0, Density density) {
        return IntOffset.m9233boximpl(IntOffset.m9236constructorimpl(((long) MathKt.roundToInt(((Number) function0.invoke()).floatValue())) << 32));
    }

    static final Unit SwitchImpl$lambda$7(BoxScope boxScope, boolean z, boolean z2, SwitchColors switchColors, Function0 function0, InteractionSource interactionSource, int i, Composer composer, int i2) {
        SwitchImpl(boxScope, z, z2, switchColors, function0, interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    private static final void m3186drawTrackRPmYEkk(DrawScope drawScope, long j, float f, float f2) {
        float f3 = f2 / 2.0f;
        DrawScope.m6885drawLineNGM6Ib0$default(drawScope, j, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(f3) << 32)), Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6898getCenterF1C5BW0() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(f - f3) << 32)), f2, StrokeCap.INSTANCE.m6700getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }
}
