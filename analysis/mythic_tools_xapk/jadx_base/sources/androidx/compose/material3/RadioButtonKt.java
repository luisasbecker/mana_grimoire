package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010\"\u0010\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010\"\u0010\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0013"}, d2 = {"RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "RadioButtonPadding", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonDotSize", "RadioStrokeWidth", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RadioButtonKt {
    private static final float RadioButtonPadding = Dp.m9114constructorimpl(2.0f);
    private static final float RadioButtonDotSize = Dp.m9114constructorimpl(12.0f);
    private static final float RadioStrokeWidth = Dp.m9114constructorimpl(2.0f);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RadioButton(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, RadioButtonColors radioButtonColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        RadioButtonColors radioButtonColorsColors;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z4;
        final RadioButtonColors radioButtonColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i6;
        boolean z5;
        RadioButtonColors radioButtonColors3;
        MutableInteractionSource mutableInteractionSource4;
        final State<Dp> stateM1380animateDpAsStateAjpBEmI;
        final State<Color> stateRadioColor$material3;
        Modifier modifier4;
        RadioButtonColors radioButtonColors4;
        Modifier.Companion companionM2307selectableO2vRcR0;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(408580840);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RadioButton)N(selected,onClick,modifier,enabled,colors,interactionSource)85@4070L7,82@3836L252,87@4117L29,114@5028L416,101@4610L834:RadioButton.kt#uh7d8r");
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
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
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
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        radioButtonColorsColors = radioButtonColors;
                        int i8 = composerStartRestartGroup.changed(radioButtonColorsColors) ? 16384 : 8192;
                        i3 |= i8;
                    } else {
                        radioButtonColorsColors = radioButtonColors;
                    }
                    i3 |= i8;
                } else {
                    radioButtonColorsColors = radioButtonColors;
                }
                i5 = i2 & 32;
                if (i5 == 0) {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    }
                    if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z3;
                        radioButtonColors2 = radioButtonColorsColors;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "78@3737L8");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                radioButtonColorsColors = RadioButtonDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            }
                            i6 = i3;
                            z5 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                            if (i5 != 0) {
                                mutableInteractionSource4 = null;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(408580840, i6, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:80)");
                            }
                            stateM1380animateDpAsStateAjpBEmI = AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(!z ? Dp.m9114constructorimpl(RadioButtonDotSize / 2.0f) : Dp.m9114constructorimpl(0.0f), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                            stateRadioColor$material3 = radioButtonColors3.radioColor$material3(z5, z, composerStartRestartGroup, ((i6 >> 6) & 896) | ((i6 >> 9) & 14) | ((i6 << 3) & 112));
                            if (function0 == null) {
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                int iM8332getRadioButtono7Vup1c = Role.INSTANCE.m8332getRadioButtono7Vup1c();
                                IndicationNodeFactory indicationNodeFactoryM3978rippleH2RKhps$default = RippleKt.m3978rippleH2RKhps$default(false, Dp.m9114constructorimpl(RadioButtonTokens.INSTANCE.m5289getStateLayerSizeD9Ej5fM() / 2.0f), 0L, 4, null);
                                Role roleM8320boximpl = Role.m8320boximpl(iM8332getRadioButtono7Vup1c);
                                radioButtonColors4 = radioButtonColors3;
                                modifier4 = companion;
                                z4 = z5;
                                companionM2307selectableO2vRcR0 = SelectableKt.m2307selectableO2vRcR0(companion2, z, mutableInteractionSource4, indicationNodeFactoryM3978rippleH2RKhps$default, z4, roleM8320boximpl, function0);
                            } else {
                                modifier4 = companion;
                                radioButtonColors4 = radioButtonColors3;
                                z4 = z5;
                                companionM2307selectableO2vRcR0 = Modifier.INSTANCE;
                            }
                            Modifier modifierM2075requiredSize3ABfNKs = SizeKt.m2075requiredSize3ABfNKs(PaddingKt.m2037padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(function0 == null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companionM2307selectableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m5288getIconSizeD9Ej5fM());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804211304, "CC(remember):RadioButton.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(stateRadioColor$material3) | composerStartRestartGroup.changed(stateM1380animateDpAsStateAjpBEmI);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return RadioButtonKt.RadioButton$lambda$1$lambda$0(stateRadioColor$material3, stateM1380animateDpAsStateAjpBEmI, (DrawScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CanvasKt.Canvas(modifierM2075requiredSize3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource3 = mutableInteractionSource4;
                            radioButtonColors2 = radioButtonColors4;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            i6 = i3;
                            companion = modifier2;
                            z5 = z3;
                            radioButtonColors3 = radioButtonColorsColors;
                        }
                        mutableInteractionSource4 = mutableInteractionSource2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        stateM1380animateDpAsStateAjpBEmI = AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(!z ? Dp.m9114constructorimpl(RadioButtonDotSize / 2.0f) : Dp.m9114constructorimpl(0.0f), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
                        stateRadioColor$material3 = radioButtonColors3.radioColor$material3(z5, z, composerStartRestartGroup, ((i6 >> 6) & 896) | ((i6 >> 9) & 14) | ((i6 << 3) & 112));
                        if (function0 == null) {
                        }
                        Modifier modifierM2075requiredSize3ABfNKs2 = SizeKt.m2075requiredSize3ABfNKs(PaddingKt.m2037padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(function0 == null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companionM2307selectableO2vRcR0), Alignment.INSTANCE.getCenter(), false, 2, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m5288getIconSizeD9Ej5fM());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804211304, "CC(remember):RadioButton.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(stateRadioColor$material3) | composerStartRestartGroup.changed(stateM1380animateDpAsStateAjpBEmI);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return RadioButtonKt.RadioButton$lambda$1$lambda$0(stateRadioColor$material3, stateM1380animateDpAsStateAjpBEmI, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CanvasKt.Canvas(modifierM2075requiredSize3ABfNKs2, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mutableInteractionSource3 = mutableInteractionSource4;
                            radioButtonColors2 = radioButtonColors4;
                            modifier3 = modifier4;
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.RadioButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return RadioButtonKt.RadioButton$lambda$2(z, function0, modifier3, z4, radioButtonColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z2;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z2;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit RadioButton$lambda$1$lambda$0(State state, State state2, DrawScope drawScope) {
        float f = drawScope.mo1624toPx0680j_4(RadioStrokeWidth);
        float f2 = f / 2.0f;
        DrawScope.m6880drawCircleVaOC9Bg$default(drawScope, ((Color) state.getValue()).m6335unboximpl(), drawScope.mo1624toPx0680j_4(Dp.m9114constructorimpl(RadioButtonTokens.INSTANCE.m5288getIconSizeD9Ej5fM() / 2.0f)) - f2, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
        if (Dp.m9113compareTo0680j_4(((Dp) state2.getValue()).m9128unboximpl(), Dp.m9114constructorimpl(0.0f)) > 0) {
            DrawScope.m6880drawCircleVaOC9Bg$default(drawScope, ((Color) state.getValue()).m6335unboximpl(), drawScope.mo1624toPx0680j_4(((Dp) state2.getValue()).m9128unboximpl()) - f2, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
        }
        return Unit.INSTANCE;
    }

    static final Unit RadioButton$lambda$2(boolean z, Function0 function0, Modifier modifier, boolean z2, RadioButtonColors radioButtonColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        RadioButton(z, function0, modifier, z2, radioButtonColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }
}
