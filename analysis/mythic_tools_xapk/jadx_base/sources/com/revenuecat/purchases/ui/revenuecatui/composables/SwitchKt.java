package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.Shapes;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BorderKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001al\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0015\b\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001d¢\u0006\u0002\b\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00172\b\b\u0002\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0001¢\u0006\u0002\u0010$\u001aR\u0010%\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001d¢\u0006\u0002\b\u001e2\u0006\u0010\"\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010(\u001a\u0019\u0010)\u001a\u00020\r*\u00020*2\u0006\u0010\f\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010+\u001a\u0014\u0010)\u001a\u00020\u0011*\u00020,2\u0006\u0010\f\u001a\u00020\u0012H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0010\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0010\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0010\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0010\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0018\u0010\f\u001a\u00020\r*\u00020\u000e8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0018\u0010\f\u001a\u00020\u0011*\u00020\u00128CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0013¨\u0006-"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "SnapSpec", "Landroidx/compose/animation/core/SnapSpec;", "SwitchHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchWidth", "ThumbDiameter", "ThumbPadding", "UncheckedThumbDiameter", "value", "Landroidx/compose/ui/graphics/Color;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/ColorSchemeKeyTokens;", "getValue", "(Lcom/revenuecat/purchases/ui/revenuecatui/composables/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "Landroidx/compose/ui/graphics/Shape;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/ShapeKeyTokens;", "(Lcom/revenuecat/purchases/ui/revenuecatui/composables/ShapeKeyTokens;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLcom/revenuecat/purchases/ui/revenuecatui/composables/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "(Landroidx/compose/ui/Modifier;ZZLcom/revenuecat/purchases/ui/revenuecatui/composables/SwitchColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "fromToken", "Landroidx/compose/material3/ColorScheme;", "(Landroidx/compose/material3/ColorScheme;Lcom/revenuecat/purchases/ui/revenuecatui/composables/ColorSchemeKeyTokens;)J", "Landroidx/compose/material3/Shapes;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final SnapSpec<Float> SnapSpec;
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDiameter;
    private static final float ThumbPadding;
    private static final float UncheckedThumbDiameter;

    /* JADX INFO: compiled from: Switch.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ShapeKeyTokens.values().length];
            try {
                iArr[ShapeKeyTokens.CornerFull.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ColorSchemeKeyTokens.values().length];
            try {
                iArr2[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ColorSchemeKeyTokens.OnSurface.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ColorSchemeKeyTokens.Outline.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ColorSchemeKeyTokens.Primary.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ColorSchemeKeyTokens.Surface.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ColorSchemeKeyTokens.SurfaceContainerHighest.ordinal()] = 7;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        float fM10672getSelectedHandleWidthD9Ej5fM = SwitchTokens.INSTANCE.m10672getSelectedHandleWidthD9Ej5fM();
        ThumbDiameter = fM10672getSelectedHandleWidthD9Ej5fM;
        UncheckedThumbDiameter = SwitchTokens.INSTANCE.m10677getUnselectedHandleWidthD9Ej5fM();
        SwitchWidth = SwitchTokens.INSTANCE.m10676getTrackWidthD9Ej5fM();
        float fM10674getTrackHeightD9Ej5fM = SwitchTokens.INSTANCE.m10674getTrackHeightD9Ej5fM();
        SwitchHeight = fM10674getTrackHeightD9Ej5fM;
        ThumbPadding = Dp.m9114constructorimpl(Dp.m9114constructorimpl(fM10674getTrackHeightD9Ej5fM - fM10672getSelectedHandleWidthD9Ej5fM) / 2.0f);
        SnapSpec = new SnapSpec<>(0, 1, null);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Switch(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z2, SwitchColors switchColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function22;
        int i5;
        boolean z3;
        SwitchColors switchColors2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource3;
        SwitchColors switchColorsM10670colorslRJcREg;
        MutableInteractionSource mutableInteractionSource4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        boolean z4;
        SwitchColors switchColors3;
        int i7;
        Modifier modifier3;
        MutableInteractionSource mutableInteractionSource5;
        MutableInteractionSource mutableInteractionSource6;
        boolean z5;
        MutableInteractionSource mutableInteractionSource7;
        Modifier.Companion companionM2314toggleableO2vRcR0;
        Composer composer3;
        final boolean z6;
        final Modifier modifier4;
        final SwitchColors switchColors4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final MutableInteractionSource mutableInteractionSource8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1449171266);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Switch)P(!1,5,4,6,2)94@3954L5,84@3595L408:Switch.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
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
                    function22 = function2;
                    i3 |= composerStartRestartGroup.changedInstance(function22) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z2;
                        i3 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            switchColors2 = switchColors;
                            int i9 = composerStartRestartGroup.changed(switchColors2) ? 131072 : 65536;
                            i3 |= i9;
                        } else {
                            switchColors2 = switchColors;
                        }
                        i3 |= i9;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i6 = i2 & 64;
                    if (i6 != 0) {
                        if ((1572864 & i) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                        }
                        if ((599187 & i3) == 599186 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            function24 = function22;
                            z6 = z3;
                            switchColors4 = switchColors2;
                            mutableInteractionSource8 = mutableInteractionSource2;
                            composer3 = composerStartRestartGroup;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "62@2895L8");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i8 == 0 ? Modifier.INSTANCE : modifier2;
                                Function2<? super Composer, ? super Integer, Unit> function25 = i4 == 0 ? null : function22;
                                boolean z7 = i5 == 0 ? true : z3;
                                if ((i2 & 32) == 0) {
                                    mutableInteractionSource3 = null;
                                    switchColorsM10670colorslRJcREg = SwitchDefaults.INSTANCE.m10670colorslRJcREg(null, null, null, 0L, null, null, null, 0L, null, null, null, 0L, null, null, null, 0L, composerStartRestartGroup, 0, 1572864, 65535);
                                    composer2 = composerStartRestartGroup;
                                    i3 &= -458753;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    mutableInteractionSource3 = null;
                                    switchColorsM10670colorslRJcREg = switchColors2;
                                }
                                mutableInteractionSource4 = i6 == 0 ? mutableInteractionSource3 : mutableInteractionSource;
                                function23 = function25;
                                z4 = z7;
                                switchColors3 = switchColorsM10670colorslRJcREg;
                                i7 = i3;
                                modifier3 = companion;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                i7 = i3;
                                modifier3 = modifier2;
                                z4 = z3;
                                switchColors3 = switchColors2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                function23 = function22;
                                composer2 = composerStartRestartGroup;
                                mutableInteractionSource3 = null;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1449171266, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Switch (Switch.kt:64)");
                            }
                            composer2.startReplaceGroup(-1205391263);
                            ComposerKt.sourceInformation(composer2, "66@3047L39");
                            if (mutableInteractionSource4 != null) {
                                composer2.startReplaceGroup(-1205390612);
                                ComposerKt.sourceInformation(composer2, "CC(remember):Switch.kt#9igjgp");
                                Object objRememberedValue = composer2.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue;
                                composer2.endReplaceGroup();
                            } else {
                                mutableInteractionSource5 = mutableInteractionSource4;
                            }
                            composer2.endReplaceGroup();
                            if (function1 == null) {
                                mutableInteractionSource6 = mutableInteractionSource5;
                                z5 = z4;
                                mutableInteractionSource7 = mutableInteractionSource3;
                                companionM2314toggleableO2vRcR0 = ToggleableKt.m2314toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE), z, mutableInteractionSource6, null, z5, Role.m8320boximpl(Role.INSTANCE.m8333getSwitcho7Vup1c()), function1);
                            } else {
                                mutableInteractionSource6 = mutableInteractionSource5;
                                z5 = z4;
                                mutableInteractionSource7 = mutableInteractionSource3;
                                companionM2314toggleableO2vRcR0 = Modifier.INSTANCE;
                            }
                            int i10 = i7 << 3;
                            int i11 = i7 >> 6;
                            Composer composer4 = composer2;
                            SwitchImpl(SizeKt.m2077requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(companionM2314toggleableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, mutableInteractionSource7), SwitchWidth, SwitchHeight), z, z5, switchColors3, function23, mutableInteractionSource6, getValue(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), composer4, (i10 & 112) | (i11 & 896) | (i11 & 7168) | (i10 & 57344));
                            composer3 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            modifier4 = modifier3;
                            switchColors4 = switchColors3;
                            function24 = function23;
                            mutableInteractionSource8 = mutableInteractionSource4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SwitchKt.Switch.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer5, int i12) {
                                    SwitchKt.Switch(z, function1, modifier4, function24, z6, switchColors4, mutableInteractionSource8, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 1572864;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((599187 & i3) == 599186) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@2895L8");
                        if ((i & 1) != 0) {
                            if (i8 == 0) {
                            }
                            if (i4 == 0) {
                            }
                            if (i5 == 0) {
                            }
                            if ((i2 & 32) == 0) {
                            }
                            if (i6 == 0) {
                            }
                            function23 = function25;
                            z4 = z7;
                            switchColors3 = switchColorsM10670colorslRJcREg;
                            i7 = i3;
                            modifier3 = companion;
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2.startReplaceGroup(-1205391263);
                            ComposerKt.sourceInformation(composer2, "66@3047L39");
                            if (mutableInteractionSource4 != null) {
                            }
                            composer2.endReplaceGroup();
                            if (function1 == null) {
                            }
                            int i102 = i7 << 3;
                            int i112 = i7 >> 6;
                            Composer composer42 = composer2;
                            SwitchImpl(SizeKt.m2077requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(companionM2314toggleableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, mutableInteractionSource7), SwitchWidth, SwitchHeight), z, z5, switchColors3, function23, mutableInteractionSource6, getValue(SwitchTokens.INSTANCE.getHandleShape(), composer2, 6), composer42, (i102 & 112) | (i112 & 896) | (i112 & 7168) | (i102 & 57344));
                            composer3 = composer42;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            z6 = z5;
                            modifier4 = modifier3;
                            switchColors4 = switchColors3;
                            function24 = function23;
                            mutableInteractionSource8 = mutableInteractionSource4;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z3 = z2;
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((599187 & i3) == 599186) {
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function22 = function2;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z2;
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((599187 & i3) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function22 = function2;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z2;
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((599187 & i3) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchImpl(final Modifier modifier, final boolean z, final boolean z2, final SwitchColors switchColors, final Function2<? super Composer, ? super Integer, Unit> function2, final InteractionSource interactionSource, final Shape shape, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(871043204);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchImpl)P(4!1,2!1,5)259@12112L5,261@12123L1052:Switch.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
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
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 1048576 : 524288;
        }
        if ((599187 & i2) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(871043204, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.SwitchImpl (Switch.kt:256)");
            }
            ColorStyle colorStyleTrackColor$revenuecatui_defaultsBc8Release = switchColors.trackColor$revenuecatui_defaultsBc8Release(z2, z);
            ColorStyle colorStyleThumbColor$revenuecatui_defaultsBc8Release = switchColors.thumbColor$revenuecatui_defaultsBc8Release(z2, z);
            Shape value = getValue(SwitchTokens.INSTANCE.getTrackShape(), composerStartRestartGroup, 6);
            Modifier modifierBackground = BackgroundKt.background(BorderKt.m10497borderziNgDLE(modifier, SwitchTokens.INSTANCE.m10675getTrackOutlineWidthD9Ej5fM(), switchColors.borderColor$revenuecatui_defaultsBc8Release(z2, z), value), colorStyleTrackColor$revenuecatui_defaultsBc8Release, value);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = i2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 358720601, "C266@12299L870:Switch.kt#51odh9");
            Modifier modifierBackground2 = BackgroundKt.background(IndicationKt.indication(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart()).then(new ThumbElement(interactionSource, z)), interactionSource, RippleKt.m3978rippleH2RKhps$default(false, Dp.m9114constructorimpl(SwitchTokens.INSTANCE.m10673getStateLayerSizeD9Ej5fM() / 2.0f), 0L, 4, null)), colorStyleThumbColor$revenuecatui_defaultsBc8Release, shape);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1851286062, "C:Switch.kt#51odh9");
            composerStartRestartGroup.startReplaceGroup(-1860834223);
            ComposerKt.sourceInformation(composerStartRestartGroup, "284@13000L145");
            if (function2 != null) {
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(switchColors.m10669iconColorWaAFU9c$revenuecatui_defaultsBc8Release(z2, z))), function2, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 9) & 112));
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SwitchKt.SwitchImpl.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    SwitchKt.SwitchImpl(modifier, z, z2, switchColors, function2, interactionSource, shape, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final long fromToken(ColorScheme colorScheme, ColorSchemeKeyTokens colorSchemeKeyTokens) {
        switch (WhenMappings.$EnumSwitchMapping$1[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.getOnPrimary();
            case 2:
                return colorScheme.getOnPrimaryContainer();
            case 3:
                return colorScheme.getOnSurface();
            case 4:
                return colorScheme.getOutline();
            case 5:
                return colorScheme.getPrimary();
            case 6:
                return colorScheme.getSurface();
            case 7:
                return colorScheme.getSurfaceContainerHighest();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final Shape fromToken(Shapes shapes, ShapeKeyTokens shapeKeyTokens) {
        if (WhenMappings.$EnumSwitchMapping$0[shapeKeyTokens.ordinal()] == 1) {
            return RoundedCornerShapeKt.getCircleShape();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getValue(ColorSchemeKeyTokens colorSchemeKeyTokens, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -323273324, "C(<get-value>)468@19569L11:Switch.kt#51odh9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-323273324, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.<get-value> (Switch.kt:468)");
        }
        long jFromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable), colorSchemeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jFromToken;
    }

    private static final Shape getValue(ShapeKeyTokens shapeKeyTokens, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2130513227, "C(<get-value>)464@19437L6:Switch.kt#51odh9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2130513227, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.<get-value> (Switch.kt:464)");
        }
        Shape shapeFromToken = fromToken(MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable), shapeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shapeFromToken;
    }
}
