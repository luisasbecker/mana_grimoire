package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.muxer.MuxerUtil;
import androidx.media3.muxer.WebmConstants;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001aO\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\u0016\u001a3\u0010\u0017\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a;\u0010!\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)\"\u000e\u0010*\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00101\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00102\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00103\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00104\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100¨\u00065²\u0006\n\u00106\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u00107\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001aX\u008a\u0084\u0002"}, d2 = {"Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/CheckboxColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "TriStateCheckbox", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material/CheckDrawingCache;)V", "BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxRippleRadius", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxDefaultPadding", "CheckboxSize", "StrokeWidth", "RadiusSize", "material", "checkDrawFraction", "checkCenterGravitationShiftFraction"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxRippleRadius = Dp.m9114constructorimpl(24.0f);
    private static final float CheckboxDefaultPadding = Dp.m9114constructorimpl(2.0f);
    private static final float CheckboxSize = Dp.m9114constructorimpl(20.0f);
    private static final float StrokeWidth = Dp.m9114constructorimpl(2.0f);
    private static final float RadiusSize = Dp.m9114constructorimpl(2.0f);

    /* JADX INFO: compiled from: Checkbox.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Checkbox(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        CheckboxColors checkboxColors2;
        final Modifier modifier3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean z5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2118660998);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Checkbox)N(checked,onCheckedChange,modifier,enabled,interactionSource,colors)91@4126L325:Checkbox.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
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
                            checkboxColors2 = checkboxColors;
                            int i7 = composerStartRestartGroup.changed(checkboxColors2) ? 131072 : 65536;
                            i3 |= i7;
                        } else {
                            checkboxColors2 = checkboxColors;
                        }
                        i3 |= i7;
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4108L8");
                        Function0 function0 = null;
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                            boolean z6 = i4 != 0 ? true : z3;
                            MutableInteractionSource mutableInteractionSource3 = i5 != 0 ? null : mutableInteractionSource2;
                            if ((i2 & 32) != 0) {
                                CheckboxColors checkboxColorsM2958colorszjMxDiM = CheckboxDefaults.INSTANCE.m2958colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                composerStartRestartGroup = composerStartRestartGroup;
                                i3 &= -458753;
                                modifier4 = companion;
                                z5 = z6;
                                checkboxColors2 = checkboxColorsM2958colorszjMxDiM;
                            } else {
                                modifier4 = companion;
                                z5 = z6;
                            }
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            z5 = z3;
                            modifier4 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2118660998, i3, -1, "androidx.compose.material.Checkbox (Checkbox.kt:90)");
                        }
                        ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                        if (function1 != null) {
                            composerStartRestartGroup.startReplaceGroup(1809972427);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "95@4263L29");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -218707913, "CC(remember):Checkbox.kt#9igjgp");
                            boolean z7 = ((i3 & 112) == 32) | ((i3 & 14) == 4);
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z7 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CheckboxKt.Checkbox$lambda$0$0(function1, z);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function0 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1810037123);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        TriStateCheckbox(ToggleableState, function0, modifier4, z5, mutableInteractionSource2, checkboxColors2, composerStartRestartGroup, i3 & 524160, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z4 = z5;
                    }
                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                    final CheckboxColors checkboxColors3 = checkboxColors2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CheckboxKt.Checkbox$lambda$1(z, function1, modifier3, z4, mutableInteractionSource4, checkboxColors3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                final CheckboxColors checkboxColors32 = checkboxColors2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
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
            if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            final MutableInteractionSource mutableInteractionSource422 = mutableInteractionSource2;
            final CheckboxColors checkboxColors322 = checkboxColors2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
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
        if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        final MutableInteractionSource mutableInteractionSource4222 = mutableInteractionSource2;
        final CheckboxColors checkboxColors3222 = checkboxColors2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$0$0(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    static final Unit Checkbox$lambda$1(boolean z, Function1 function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, int i, int i2, Composer composer, int i3) {
        Checkbox(z, function1, modifier, z2, mutableInteractionSource, checkboxColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void CheckboxImpl(boolean z, final ToggleableState toggleableState, Modifier modifier, final CheckboxColors checkboxColors, Composer composer, final int i) {
        int i2;
        boolean z2;
        Modifier modifier2;
        Transition transition;
        float f;
        Float f2;
        String str;
        int i3;
        float f3;
        final State stateCreateTransitionAnimation;
        int i4;
        int i5;
        float f4;
        int i6;
        final State stateCreateTransitionAnimation2;
        Object objRememberedValue;
        final CheckDrawingCache checkDrawingCache;
        final State<Color> stateCheckmarkColor;
        final State<Color> stateBoxColor;
        final State<Color> stateBorderColor;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2118895727);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CheckboxImpl)N(enabled,value,modifier,colors)257@10849L23,259@10921L499,276@11488L514,291@12024L32,292@12086L21,293@12135L24,294@12190L27,295@12300L510,295@12222L588:Checkbox.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(toggleableState.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(checkboxColors) ? 2048 : 1024;
        }
        int i7 = i2;
        if (composerStartRestartGroup.shouldExecute((i7 & 1171) != 1170, i7 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2118895727, i7, -1, "androidx.compose.material.CheckboxImpl (Checkbox.kt:256)");
            }
            int i8 = i7 >> 3;
            int i9 = i8 & 14;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(toggleableState, (String) null, composerStartRestartGroup, i9, 2);
            Function3 function3 = new Function3() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CheckboxKt.CheckboxImpl$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            ToggleableState toggleableState2 = (ToggleableState) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(-1798345588);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                transition = transitionUpdateTransition;
                ComposerKt.traceEventStart(-1798345588, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:268)");
            } else {
                transition = transitionUpdateTransition;
            }
            int i10 = WhenMappings.$EnumSwitchMapping$0[toggleableState2.ordinal()];
            float f5 = 0.0f;
            if (i10 == 1) {
                f = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                Float fValueOf = Float.valueOf(f);
                ToggleableState toggleableState3 = (ToggleableState) transition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(-1798345588);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                    f2 = fValueOf;
                    str = "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli";
                    ComposerKt.traceEventStart(-1798345588, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:268)");
                } else {
                    f2 = fValueOf;
                    str = "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli";
                }
                i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState3.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        f3 = 0.0f;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Transition transition2 = transition;
                        stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition2, f2, Float.valueOf(f3), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function3 function32 = new Function3() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CheckboxKt.CheckboxImpl$lambda$3((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                        TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, str);
                        ToggleableState toggleableState4 = (ToggleableState) transition2.getCurrentState();
                        composerStartRestartGroup.startReplaceGroup(-2098942571);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2098942571, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:285)");
                        }
                        i4 = WhenMappings.$EnumSwitchMapping$0[toggleableState4.ordinal()];
                        if (i4 != 1 || i4 == 2) {
                            i5 = 3;
                            f4 = 0.0f;
                        } else {
                            i5 = 3;
                            if (i4 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            f4 = 1.0f;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Float fValueOf2 = Float.valueOf(f4);
                        ToggleableState toggleableState5 = (ToggleableState) transition2.getTargetState();
                        composerStartRestartGroup.startReplaceGroup(-2098942571);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2098942571, 0, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:285)");
                        }
                        i6 = WhenMappings.$EnumSwitchMapping$0[toggleableState5.ordinal()];
                        if (i6 != 1 && i6 != 2) {
                            if (i6 == i5) {
                                throw new NoWhenBranchMatchedException();
                            }
                            f5 = 1.0f;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transition2, fValueOf2, Float.valueOf(f5), (FiniteAnimationSpec) function32.invoke(transition2.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "FloatAnimation", composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -444253071, "CC(remember):Checkbox.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new CheckDrawingCache(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        checkDrawingCache = (CheckDrawingCache) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        stateCheckmarkColor = checkboxColors.checkmarkColor(toggleableState, composerStartRestartGroup, i9 | ((i7 >> 6) & 112));
                        int i11 = (i8 & 896) | (i7 & 126);
                        z2 = z;
                        stateBoxColor = checkboxColors.boxColor(z2, toggleableState, composerStartRestartGroup, i11);
                        stateBorderColor = checkboxColors.borderColor(z2, toggleableState, composerStartRestartGroup, i11);
                        modifier2 = modifier;
                        Modifier modifierM2075requiredSize3ABfNKs = SizeKt.m2075requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier2, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -444243761, "CC(remember):Checkbox.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(stateBoxColor) | composerStartRestartGroup.changed(stateBorderColor) | composerStartRestartGroup.changed(stateCheckmarkColor) | composerStartRestartGroup.changed(stateCreateTransitionAnimation) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CheckboxKt.CheckboxImpl$lambda$10$0(checkDrawingCache, stateBoxColor, stateBorderColor, stateCheckmarkColor, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierM2075requiredSize3ABfNKs, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else if (i3 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                f3 = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceGroup();
                Transition transition22 = transition;
                stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition22, f2, Float.valueOf(f3), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function3 function322 = new Function3() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CheckboxKt.CheckboxImpl$lambda$3((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter22 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, str);
                ToggleableState toggleableState42 = (ToggleableState) transition22.getCurrentState();
                composerStartRestartGroup.startReplaceGroup(-2098942571);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                }
                i4 = WhenMappings.$EnumSwitchMapping$0[toggleableState42.ordinal()];
                if (i4 != 1) {
                    i5 = 3;
                    f4 = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Float fValueOf22 = Float.valueOf(f4);
                    ToggleableState toggleableState52 = (ToggleableState) transition22.getTargetState();
                    composerStartRestartGroup.startReplaceGroup(-2098942571);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i6 = WhenMappings.$EnumSwitchMapping$0[toggleableState52.ordinal()];
                    if (i6 != 1) {
                        if (i6 == i5) {
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transition22, fValueOf22, Float.valueOf(f5), (FiniteAnimationSpec) function322.invoke(transition22.getSegment(), composerStartRestartGroup, 0), vectorConverter22, "FloatAnimation", composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -444253071, "CC(remember):Checkbox.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    checkDrawingCache = (CheckDrawingCache) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    stateCheckmarkColor = checkboxColors.checkmarkColor(toggleableState, composerStartRestartGroup, i9 | ((i7 >> 6) & 112));
                    int i112 = (i8 & 896) | (i7 & 126);
                    z2 = z;
                    stateBoxColor = checkboxColors.boxColor(z2, toggleableState, composerStartRestartGroup, i112);
                    stateBorderColor = checkboxColors.borderColor(z2, toggleableState, composerStartRestartGroup, i112);
                    modifier2 = modifier;
                    Modifier modifierM2075requiredSize3ABfNKs2 = SizeKt.m2075requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier2, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -444243761, "CC(remember):Checkbox.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateBoxColor) | composerStartRestartGroup.changed(stateBorderColor) | composerStartRestartGroup.changed(stateCheckmarkColor) | composerStartRestartGroup.changed(stateCreateTransitionAnimation) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CheckboxKt.CheckboxImpl$lambda$10$0(checkDrawingCache, stateBoxColor, stateBorderColor, stateCheckmarkColor, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierM2075requiredSize3ABfNKs2, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                }
            } else if (i10 != 2) {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceGroup();
                Float fValueOf3 = Float.valueOf(f);
                ToggleableState toggleableState32 = (ToggleableState) transition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(-1798345588);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                }
                i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState32.ordinal()];
                if (i3 != 1) {
                }
                f3 = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceGroup();
                Transition transition222 = transition;
                stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition222, f2, Float.valueOf(f3), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function3 function3222 = new Function3() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CheckboxKt.CheckboxImpl$lambda$3((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter222 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, str);
                ToggleableState toggleableState422 = (ToggleableState) transition222.getCurrentState();
                composerStartRestartGroup.startReplaceGroup(-2098942571);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                }
                i4 = WhenMappings.$EnumSwitchMapping$0[toggleableState422.ordinal()];
                if (i4 != 1) {
                }
            } else {
                f = 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceGroup();
                Float fValueOf32 = Float.valueOf(f);
                ToggleableState toggleableState322 = (ToggleableState) transition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(-1798345588);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                }
                i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState322.ordinal()];
                if (i3 != 1) {
                }
                f3 = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceGroup();
                Transition transition2222 = transition;
                stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition2222, f2, Float.valueOf(f3), (FiniteAnimationSpec) function3.invoke(transition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function3 function32222 = new Function3() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CheckboxKt.CheckboxImpl$lambda$3((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2222 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, str);
                ToggleableState toggleableState4222 = (ToggleableState) transition2222.getCurrentState();
                composerStartRestartGroup.startReplaceGroup(-2098942571);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                }
                i4 = WhenMappings.$EnumSwitchMapping$0[toggleableState4222.ordinal()];
                if (i4 != 1) {
                }
            }
        } else {
            z2 = z;
            modifier2 = modifier;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z3 = z2;
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxKt.CheckboxImpl$lambda$11(z3, toggleableState, modifier3, checkboxColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final FiniteAnimationSpec CheckboxImpl$lambda$0(Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(-1707702900);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1707702900, i, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:261)");
        }
        SpringSpec springSpecTween$default = segment.getInitialState() == ToggleableState.Off ? AnimationSpecKt.tween$default(100, 0, null, 6, null) : segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return springSpecTween$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxImpl$lambda$10$0(CheckDrawingCache checkDrawingCache, State state, State state2, State state3, State state4, State state5, DrawScope drawScope) {
        float fFloor = (float) Math.floor(drawScope.mo1624toPx0680j_4(StrokeWidth));
        m2960drawBox1wkBAMs(drawScope, CheckboxImpl$lambda$8(state), CheckboxImpl$lambda$9(state2), drawScope.mo1624toPx0680j_4(RadiusSize), fFloor);
        m2961drawCheck3IgeMak(drawScope, CheckboxImpl$lambda$7(state3), CheckboxImpl$lambda$2(state4), CheckboxImpl$lambda$5(state5), fFloor, checkDrawingCache);
        return Unit.INSTANCE;
    }

    static final Unit CheckboxImpl$lambda$11(boolean z, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, int i, Composer composer, int i2) {
        CheckboxImpl(z, toggleableState, modifier, checkboxColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final float CheckboxImpl$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    static final FiniteAnimationSpec CheckboxImpl$lambda$3(Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(1075283605);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1075283605, i, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:278)");
        }
        TweenSpec tweenSpecSnap$default = segment.getInitialState() == ToggleableState.Off ? AnimationSpecKt.snap$default(0, 1, null) : segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecSnap$default;
    }

    private static final float CheckboxImpl$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long CheckboxImpl$lambda$7(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    private static final long CheckboxImpl$lambda$8(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    private static final long CheckboxImpl$lambda$9(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TriStateCheckbox(final ToggleableState toggleableState, final Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        CheckboxColors checkboxColorsM2958colorszjMxDiM;
        Composer composer2;
        final Modifier modifier3;
        final boolean z3;
        final CheckboxColors checkboxColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Modifier modifier4;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        Modifier.Companion companionM2320triStateToggleableO2vRcR0;
        Composer composerStartRestartGroup = composer.startRestartGroup(2031255194);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TriStateCheckbox)N(state,onClick,modifier,enabled,interactionSource,colors)152@6815L461:Checkbox.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(toggleableState.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
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
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            checkboxColorsM2958colorszjMxDiM = checkboxColors;
                            int i8 = composerStartRestartGroup.changed(checkboxColorsM2958colorszjMxDiM) ? 131072 : 65536;
                            i3 |= i8;
                        } else {
                            checkboxColorsM2958colorszjMxDiM = checkboxColors;
                        }
                        i3 |= i8;
                    } else {
                        checkboxColorsM2958colorszjMxDiM = checkboxColors;
                    }
                    if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z3 = z2;
                        checkboxColors2 = checkboxColorsM2958colorszjMxDiM;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "137@6355L8");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                            boolean z5 = i4 != 0 ? true : z2;
                            MutableInteractionSource mutableInteractionSource4 = i5 != 0 ? null : mutableInteractionSource2;
                            if ((i2 & 32) != 0) {
                                composer2 = composerStartRestartGroup;
                                i6 = i3 & (-458753);
                                modifier4 = companion;
                                z4 = z5;
                                checkboxColorsM2958colorszjMxDiM = CheckboxDefaults.INSTANCE.m2958colorszjMxDiM(0L, 0L, 0L, 0L, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                composer2 = composerStartRestartGroup;
                                i6 = i3;
                                modifier4 = companion;
                                z4 = z5;
                            }
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            i6 = i3;
                            composer2 = composerStartRestartGroup;
                            z4 = z2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier2;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2031255194, i6, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:138)");
                        }
                        if (function0 != null) {
                            boolean z6 = z4;
                            companionM2320triStateToggleableO2vRcR0 = ToggleableKt.m2320triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource3, RippleKt.m3125rippleH2RKhps$default(false, CheckboxRippleRadius, 0L, 4, null), z6, Role.m8320boximpl(Role.INSTANCE.m8329getCheckboxo7Vup1c()), function0);
                            mutableInteractionSource2 = mutableInteractionSource3;
                            z4 = z6;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource3;
                            companionM2320triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                        }
                        CheckboxColors checkboxColors3 = checkboxColorsM2958colorszjMxDiM;
                        CheckboxImpl(z4, toggleableState, PaddingKt.m2037padding3ABfNKs(modifier4.then(function0 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companionM2320triStateToggleableO2vRcR0), CheckboxDefaultPadding), checkboxColors3, composer2, ((i6 >> 9) & 14) | ((i6 << 3) & 112) | ((i6 >> 6) & 7168));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        checkboxColors2 = checkboxColors3;
                        modifier3 = modifier4;
                        z3 = z4;
                    }
                    final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.CheckboxKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CheckboxKt.TriStateCheckbox$lambda$0(toggleableState, function0, modifier3, z3, mutableInteractionSource5, checkboxColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                final MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            final MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((196608 & i) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        final MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit TriStateCheckbox$lambda$0(ToggleableState toggleableState, Function0 function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, int i, int i2, Composer composer, int i3) {
        TriStateCheckbox(toggleableState, function0, modifier, z, mutableInteractionSource, checkboxColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawBox-1wkBAMs, reason: not valid java name */
    private static final void m2960drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        float f3 = f2 / 2.0f;
        Stroke stroke = new Stroke(f2, 0.0f, 0, 0, null, 30, null);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32));
        if (Color.m6326equalsimpl0(j, j2)) {
            DrawScope.m6895drawRoundRectuAw5IA$default(drawScope, j, 0L, Size.m6140constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), CornerRadius.m6034constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Fill.INSTANCE, 0.0f, null, 0, 226, null);
            return;
        }
        long jM6072constructorimpl = Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        float f4 = fIntBitsToFloat - (2.0f * f2);
        long jM6140constructorimpl = Size.m6140constructorimpl((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f4)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        float fMax = Math.max(0.0f, f - f2);
        DrawScope.m6895drawRoundRectuAw5IA$default(drawScope, j, jM6072constructorimpl, jM6140constructorimpl, CornerRadius.m6034constructorimpl((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Fill.INSTANCE, 0.0f, null, 0, WebmConstants.MkvEbmlElement.VIDEO, null);
        float f5 = fIntBitsToFloat - f2;
        float f6 = f - f3;
        DrawScope.m6895drawRoundRectuAw5IA$default(drawScope, j2, Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE)), Size.m6140constructorimpl((((long) Float.floatToRawIntBits(f5)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(f5) << 32)), CornerRadius.m6034constructorimpl((((long) Float.floatToRawIntBits(f6)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(f6) << 32)), stroke, 0.0f, null, 0, WebmConstants.MkvEbmlElement.VIDEO, null);
    }

    /* JADX INFO: renamed from: drawCheck-3IgeMak, reason: not valid java name */
    private static final void m2961drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, float f3, CheckDrawingCache checkDrawingCache) {
        Stroke stroke = new Stroke(f3, 0.0f, StrokeCap.INSTANCE.m6701getSquareKaPHkGw(), 0, null, 26, null);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32));
        float fLerp = MathHelpersKt.lerp(0.4f, 0.5f, f2);
        float fLerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f2);
        float fLerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f2);
        float fLerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f2);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * fIntBitsToFloat, fLerp3 * fIntBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(fLerp * fIntBitsToFloat, fLerp2 * fIntBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(0.8f * fIntBitsToFloat, fIntBitsToFloat * fLerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.m6889drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }
}
