package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001e"}, d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ButtonColors;", "elevation", "Landroidx/compose/material3/ButtonElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ButtonColors;Landroidx/compose/material3/ButtonElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedButton", "FilledTonalButton", "OutlinedButton", "TextButton", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ButtonKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0101  */
    /* JADX WARN: Type inference failed for: r12v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4, types: [androidx.compose.foundation.interaction.MutableInteractionSource] */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [androidx.compose.foundation.interaction.MutableInteractionSource] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Button(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        int i4;
        boolean z2;
        Shape shape2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevationM3341buttonElevationR_JCAzs;
        int i5;
        BorderStroke borderStroke2;
        int i6;
        int i7;
        int i8;
        int i9;
        final Modifier modifier2;
        final boolean z3;
        final Shape shape3;
        Composer composer2;
        final ButtonColors buttonColors3;
        final ButtonElevation buttonElevation2;
        final BorderStroke borderStroke3;
        final PaddingValues paddingValues2;
        final ?? r9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape shape4;
        ButtonColors buttonColors4;
        Modifier modifier3;
        boolean z4;
        BorderStroke borderStroke4;
        int i10;
        final PaddingValues contentPadding;
        BorderStroke borderStroke5;
        boolean z5;
        Object obj;
        int i11;
        Shape shape5;
        int i12;
        Modifier modifier4;
        ?? r12;
        ?? r24;
        State<Dp> stateShadowElevation$material3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1310015664);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Button)N(onClick,modifier,enabled,shape,colors,elevation,border,contentPadding,interactionSource,content)129@6472L22,137@6736L590,127@6398L928:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i14 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i14;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i14;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        int i15 = composerStartRestartGroup.changed(buttonColors2) ? 16384 : 8192;
                        i3 |= i15;
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i3 |= i15;
                } else {
                    buttonColors2 = buttonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        buttonElevationM3341buttonElevationR_JCAzs = buttonElevation;
                        int i16 = composerStartRestartGroup.changed(buttonElevationM3341buttonElevationR_JCAzs) ? 131072 : 65536;
                        i3 |= i16;
                    } else {
                        buttonElevationM3341buttonElevationR_JCAzs = buttonElevation;
                    }
                    i3 |= i16;
                } else {
                    buttonElevationM3341buttonElevationR_JCAzs = buttonElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else {
                    if ((1572864 & i) == 0) {
                        borderStroke2 = borderStroke;
                        i3 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                        i7 = i13;
                    } else {
                        i7 = i13;
                        if ((i & 12582912) == 0) {
                            i3 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i2 & 256;
                    if (i8 != 0) {
                        if ((i & 100663296) == 0) {
                            i9 = i8;
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                        }
                        if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "114@5728L5,115@5777L14,116@5842L17");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier;
                                boolean z6 = i4 != 0 ? true : z2;
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    shape4 = ButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                } else {
                                    shape4 = shape2;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    buttonColors4 = ButtonDefaults.INSTANCE.buttonColors(composerStartRestartGroup, 6);
                                } else {
                                    buttonColors4 = buttonColors2;
                                }
                                int i17 = i3;
                                if ((i2 & 32) != 0) {
                                    modifier3 = companion;
                                    z4 = true;
                                    borderStroke4 = null;
                                    buttonElevationM3341buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3341buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                    i10 = i17 & (-458753);
                                } else {
                                    modifier3 = companion;
                                    z4 = true;
                                    borderStroke4 = null;
                                    i10 = i17;
                                }
                                if (i5 != 0) {
                                    borderStroke2 = borderStroke4;
                                }
                                contentPadding = i6 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                boolean z7 = z6;
                                borderStroke5 = borderStroke2;
                                z5 = z7;
                                obj = i9 != 0 ? borderStroke4 : mutableInteractionSource;
                                i11 = i10;
                                buttonColors2 = buttonColors4;
                                shape5 = shape4;
                                i12 = -1310015664;
                                modifier4 = modifier3;
                                r12 = z4;
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
                                i11 = i3;
                                r12 = 1;
                                shape5 = shape2;
                                borderStroke5 = borderStroke2;
                                modifier4 = modifier;
                                contentPadding = paddingValues;
                                obj = mutableInteractionSource;
                                z5 = z2;
                                i12 = -1310015664;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.material3.Button (Button.kt:121)");
                            }
                            if (obj == null) {
                                composerStartRestartGroup.startReplaceGroup(1691738187);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "123@6150L39");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -499617129, "CC(remember):Button.kt#9igjgp");
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endReplaceGroup();
                                r24 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-499617780);
                                composerStartRestartGroup.endReplaceGroup();
                                r24 = obj;
                            }
                            long jM3333containerColorvNxB06k$material3 = buttonColors2.m3333containerColorvNxB06k$material3(z5);
                            Modifier modifier5 = modifier4;
                            final long jM3334contentColorvNxB06k$material3 = buttonColors2.m3334contentColorvNxB06k$material3(z5);
                            if (buttonElevationM3341buttonElevationR_JCAzs == null) {
                                composerStartRestartGroup.startReplaceGroup(1691921830);
                                composerStartRestartGroup.endReplaceGroup();
                                stateShadowElevation$material3 = null;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-499611205);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "126@6335L43");
                                stateShadowElevation$material3 = buttonElevationM3341buttonElevationR_JCAzs.shadowElevation$material3(z5, (InteractionSource) r24, composerStartRestartGroup, ((i11 >> 6) & 14) | ((i11 >> 9) & 896));
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            float fM9128unboximpl = stateShadowElevation$material3 != null ? stateShadowElevation$material3.getValue().m9128unboximpl() : Dp.m9114constructorimpl(0.0f);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -499606842, "CC(remember):Button.kt#9igjgp");
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return ButtonKt.Button$lambda$2$lambda$1((SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Object obj2 = obj;
                            SurfaceKt.m4148Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier5, false, (Function1) objRememberedValue2, r12, null), z5, shape5, jM3333containerColorvNxB06k$material3, jM3334contentColorvNxB06k$material3, 0.0f, fM9128unboximpl, borderStroke5, r24, ComposableLambdaKt.rememberComposableLambda(-535639973, r12, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt.Button.2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i18) {
                                    ComposerKt.sourceInformation(composer3, "C140@6855L10,141@6888L432,138@6746L574:Button.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i18 & 3) != 2, i18 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-535639973, i18, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:138)");
                                    }
                                    long j = jM3334contentColorvNxB06k$material3;
                                    TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                                    final PaddingValues paddingValues3 = contentPadding;
                                    final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    ProvideContentColorTextStyleKt.m4595ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.rememberComposableLambda(417635459, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt.Button.2.1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i19) {
                                            ComposerKt.sourceInformation(composer4, "C142@6902L408:Button.kt#uh7d8r");
                                            if (!composer4.shouldExecute((i19 & 3) != 2, i19 & 1)) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(417635459, i19, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:142)");
                                            }
                                            Modifier modifierPadding = PaddingKt.padding(SizeKt.m2067defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m3349getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m3348getMinHeightD9Ej5fM()), paddingValues3);
                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                            ComposerKt.sourceInformationMarkerStart(composer4, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierPadding);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                            if (!(composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer4);
                                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer4, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                                            function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer3, 54), composer3, 384);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i11 & 8078) | (234881024 & (i11 << 6)), 6, 64);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = composerStartRestartGroup;
                            buttonColors3 = buttonColors2;
                            z3 = z5;
                            shape3 = shape5;
                            borderStroke3 = borderStroke5;
                            paddingValues2 = contentPadding;
                            modifier2 = modifier5;
                            buttonElevation2 = buttonElevationM3341buttonElevationR_JCAzs;
                            r9 = obj2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            z3 = z2;
                            shape3 = shape2;
                            composer2 = composerStartRestartGroup;
                            buttonColors3 = buttonColors2;
                            buttonElevation2 = buttonElevationM3341buttonElevationR_JCAzs;
                            borderStroke3 = borderStroke2;
                            paddingValues2 = paddingValues;
                            r9 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj3, Object obj4) {
                                    return ButtonKt.Button$lambda$3(function0, modifier2, z3, shape3, buttonColors3, buttonElevation2, borderStroke3, paddingValues2, r9, function3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 100663296;
                    i9 = i8;
                    if ((i2 & 512) != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                borderStroke2 = borderStroke;
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                }
                i9 = i8;
                if ((i2 & 512) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            borderStroke2 = borderStroke;
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i8 = i2 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            if ((i2 & 512) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        borderStroke2 = borderStroke;
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i8 = i2 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        if ((i2 & 512) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((306783379 & i3) != 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit Button$lambda$2$lambda$1(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8327getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Button$lambda$3(Function0 function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        Button(function0, modifier, z, shape, buttonColors, buttonElevation, borderStroke, paddingValues, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevationM3343elevatedButtonElevationR_JCAzs;
        int i5;
        BorderStroke borderStroke2;
        int i6;
        int i7;
        int i8;
        final Modifier modifier3;
        final boolean z3;
        final Shape shape3;
        Composer composer2;
        final ButtonColors buttonColors3;
        final ButtonElevation buttonElevation2;
        final BorderStroke borderStroke3;
        final PaddingValues paddingValues2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape elevatedShape;
        ButtonColors buttonColorsElevatedButtonColors;
        BorderStroke borderStroke4;
        boolean z4;
        Shape shape4;
        ButtonColors buttonColors4;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        PaddingValues paddingValues3;
        ButtonElevation buttonElevation3;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1943994298);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ElevatedButton)N(onClick,modifier,enabled,shape,colors,elevation,border,contentPadding,interactionSource,content)215@10659L315:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i11 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        int i12 = composerStartRestartGroup.changed(buttonColors2) ? 16384 : 8192;
                        i3 |= i12;
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i3 |= i12;
                } else {
                    buttonColors2 = buttonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        buttonElevationM3343elevatedButtonElevationR_JCAzs = buttonElevation;
                        int i13 = composerStartRestartGroup.changed(buttonElevationM3343elevatedButtonElevationR_JCAzs) ? 131072 : 65536;
                        i3 |= i13;
                    } else {
                        buttonElevationM3343elevatedButtonElevationR_JCAzs = buttonElevation;
                    }
                    i3 |= i13;
                } else {
                    buttonElevationM3343elevatedButtonElevationR_JCAzs = buttonElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else {
                    if ((1572864 & i) == 0) {
                        borderStroke2 = borderStroke;
                        i3 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i8 = i7;
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        if ((i2 & 512) == 0) {
                            if ((i & 805306368) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                            }
                            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                z3 = z2;
                                shape3 = shape2;
                                composer2 = composerStartRestartGroup;
                                buttonColors3 = buttonColors2;
                                buttonElevation2 = buttonElevationM3343elevatedButtonElevationR_JCAzs;
                                borderStroke3 = borderStroke2;
                                paddingValues2 = paddingValues;
                                mutableInteractionSource2 = mutableInteractionSource;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "207@10290L13,208@10347L22,209@10420L25");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                                    boolean z5 = i4 == 0 ? z2 : true;
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                        elevatedShape = ButtonDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                                    } else {
                                        elevatedShape = shape2;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                        buttonColorsElevatedButtonColors = ButtonDefaults.INSTANCE.elevatedButtonColors(composerStartRestartGroup, 6);
                                    } else {
                                        buttonColorsElevatedButtonColors = buttonColors2;
                                    }
                                    int i14 = i3;
                                    if ((i2 & 32) != 0) {
                                        buttonElevationM3343elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3343elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                        i3 = i14 & (-458753);
                                    } else {
                                        i3 = i14;
                                    }
                                    if (i5 != 0) {
                                        borderStroke2 = null;
                                    }
                                    PaddingValues contentPadding = i6 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                    borderStroke4 = borderStroke2;
                                    z4 = z5;
                                    shape4 = elevatedShape;
                                    if (i8 != 0) {
                                        buttonColors4 = buttonColorsElevatedButtonColors;
                                        modifier4 = companion;
                                        mutableInteractionSource3 = null;
                                    } else {
                                        buttonColors4 = buttonColorsElevatedButtonColors;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        modifier4 = companion;
                                    }
                                    paddingValues3 = contentPadding;
                                    buttonElevation3 = buttonElevationM3343elevatedButtonElevationR_JCAzs;
                                    i9 = -1943994298;
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
                                    paddingValues3 = paddingValues;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    z4 = z2;
                                    shape4 = shape2;
                                    buttonColors4 = buttonColors2;
                                    buttonElevation3 = buttonElevationM3343elevatedButtonElevationR_JCAzs;
                                    borderStroke4 = borderStroke2;
                                    i9 = -1943994298;
                                    modifier4 = modifier2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material3.ElevatedButton (Button.kt:215)");
                                }
                                Button(function02, modifier4, z4, shape4, buttonColors4, buttonElevation3, borderStroke4, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 2147483646, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = composerStartRestartGroup;
                                modifier3 = modifier4;
                                z3 = z4;
                                shape3 = shape4;
                                buttonColors3 = buttonColors4;
                                buttonElevation2 = buttonElevation3;
                                borderStroke3 = borderStroke4;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ButtonKt.ElevatedButton$lambda$4(function0, modifier3, z3, shape3, buttonColors3, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 805306368;
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i8 = i7;
                    if ((i2 & 512) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                borderStroke2 = borderStroke;
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i2 & 512) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            borderStroke2 = borderStroke;
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i2 & 512) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        borderStroke2 = borderStroke;
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i2 & 512) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit ElevatedButton$lambda$4(Function0 function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        ElevatedButton(function0, modifier, z, shape, buttonColors, buttonElevation, borderStroke, paddingValues, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledTonalButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevationM3345filledTonalButtonElevationR_JCAzs;
        int i5;
        BorderStroke borderStroke2;
        int i6;
        int i7;
        int i8;
        final Modifier modifier3;
        final boolean z3;
        final Shape shape3;
        Composer composer2;
        final ButtonColors buttonColors3;
        final ButtonElevation buttonElevation2;
        final BorderStroke borderStroke3;
        final PaddingValues paddingValues2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape filledTonalShape;
        ButtonColors buttonColorsFilledTonalButtonColors;
        BorderStroke borderStroke4;
        boolean z4;
        Shape shape4;
        ButtonColors buttonColors4;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        PaddingValues paddingValues3;
        ButtonElevation buttonElevation3;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-102343472);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilledTonalButton)N(onClick,modifier,enabled,shape,colors,elevation,border,contentPadding,interactionSource,content)288@14374L315:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i11 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        int i12 = composerStartRestartGroup.changed(buttonColors2) ? 16384 : 8192;
                        i3 |= i12;
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i3 |= i12;
                } else {
                    buttonColors2 = buttonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        buttonElevationM3345filledTonalButtonElevationR_JCAzs = buttonElevation;
                        int i13 = composerStartRestartGroup.changed(buttonElevationM3345filledTonalButtonElevationR_JCAzs) ? 131072 : 65536;
                        i3 |= i13;
                    } else {
                        buttonElevationM3345filledTonalButtonElevationR_JCAzs = buttonElevation;
                    }
                    i3 |= i13;
                } else {
                    buttonElevationM3345filledTonalButtonElevationR_JCAzs = buttonElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else {
                    if ((1572864 & i) == 0) {
                        borderStroke2 = borderStroke;
                        i3 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i8 = i7;
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        if ((i2 & 512) == 0) {
                            if ((i & 805306368) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                            }
                            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                z3 = z2;
                                shape3 = shape2;
                                composer2 = composerStartRestartGroup;
                                buttonColors3 = buttonColors2;
                                buttonElevation2 = buttonElevationM3345filledTonalButtonElevationR_JCAzs;
                                borderStroke3 = borderStroke2;
                                paddingValues2 = paddingValues;
                                mutableInteractionSource2 = mutableInteractionSource;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "280@13996L16,281@14056L25,282@14132L28");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                                    boolean z5 = i4 == 0 ? z2 : true;
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                        filledTonalShape = ButtonDefaults.INSTANCE.getFilledTonalShape(composerStartRestartGroup, 6);
                                    } else {
                                        filledTonalShape = shape2;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                        buttonColorsFilledTonalButtonColors = ButtonDefaults.INSTANCE.filledTonalButtonColors(composerStartRestartGroup, 6);
                                    } else {
                                        buttonColorsFilledTonalButtonColors = buttonColors2;
                                    }
                                    int i14 = i3;
                                    if ((i2 & 32) != 0) {
                                        buttonElevationM3345filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3345filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                        i3 = i14 & (-458753);
                                    } else {
                                        i3 = i14;
                                    }
                                    if (i5 != 0) {
                                        borderStroke2 = null;
                                    }
                                    PaddingValues contentPadding = i6 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                    borderStroke4 = borderStroke2;
                                    z4 = z5;
                                    shape4 = filledTonalShape;
                                    if (i8 != 0) {
                                        buttonColors4 = buttonColorsFilledTonalButtonColors;
                                        modifier4 = companion;
                                        mutableInteractionSource3 = null;
                                    } else {
                                        buttonColors4 = buttonColorsFilledTonalButtonColors;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        modifier4 = companion;
                                    }
                                    paddingValues3 = contentPadding;
                                    buttonElevation3 = buttonElevationM3345filledTonalButtonElevationR_JCAzs;
                                    i9 = -102343472;
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
                                    paddingValues3 = paddingValues;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    z4 = z2;
                                    shape4 = shape2;
                                    buttonColors4 = buttonColors2;
                                    buttonElevation3 = buttonElevationM3345filledTonalButtonElevationR_JCAzs;
                                    borderStroke4 = borderStroke2;
                                    i9 = -102343472;
                                    modifier4 = modifier2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material3.FilledTonalButton (Button.kt:288)");
                                }
                                Button(function02, modifier4, z4, shape4, buttonColors4, buttonElevation3, borderStroke4, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i3 & 2147483646, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = composerStartRestartGroup;
                                modifier3 = modifier4;
                                z3 = z4;
                                shape3 = shape4;
                                buttonColors3 = buttonColors4;
                                buttonElevation2 = buttonElevation3;
                                borderStroke3 = borderStroke4;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ButtonKt.FilledTonalButton$lambda$5(function0, modifier3, z3, shape3, buttonColors3, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 805306368;
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i8 = i7;
                    if ((i2 & 512) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                borderStroke2 = borderStroke;
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i2 & 512) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            borderStroke2 = borderStroke;
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i2 & 512) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        borderStroke2 = borderStroke;
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i2 & 512) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit FilledTonalButton$lambda$5(Function0 function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        FilledTonalButton(function0, modifier, z, shape, buttonColors, buttonElevation, borderStroke, paddingValues, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        int i4;
        boolean z2;
        Shape shape2;
        ButtonColors buttonColors2;
        int i5;
        ButtonElevation buttonElevation2;
        BorderStroke borderStroke2;
        int i6;
        int i7;
        int i8;
        Composer composer2;
        final Modifier modifier2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z3;
        final Shape shape3;
        final ButtonColors buttonColors3;
        final ButtonElevation buttonElevation3;
        final BorderStroke borderStroke3;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape outlinedShape;
        ButtonColors buttonColorsOutlinedButtonColors;
        BorderStroke borderStrokeOutlinedButtonBorder;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        ButtonColors buttonColors4;
        BorderStroke borderStroke4;
        Shape shape4;
        boolean z4;
        PaddingValues paddingValues3;
        ButtonElevation buttonElevation4;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(399974542);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedButton)N(onClick,modifier,enabled,shape,colors,elevation,border,contentPadding,interactionSource,content)360@17981L315:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i11 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        int i12 = composerStartRestartGroup.changed(buttonColors2) ? 16384 : 8192;
                        i3 |= i12;
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i3 |= i12;
                } else {
                    buttonColors2 = buttonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i) == 0) {
                        buttonElevation2 = buttonElevation;
                        i3 |= composerStartRestartGroup.changed(buttonElevation2) ? 131072 : 65536;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            borderStroke2 = borderStroke;
                            int i13 = composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                            i3 |= i13;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        i3 |= i13;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i8 = i7;
                            i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        if ((i2 & 512) == 0) {
                            if ((i & 805306368) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                            }
                            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = modifier;
                                mutableInteractionSource2 = mutableInteractionSource;
                                z3 = z2;
                                shape3 = shape2;
                                buttonColors3 = buttonColors2;
                                buttonElevation3 = buttonElevation2;
                                borderStroke3 = borderStroke2;
                                paddingValues2 = paddingValues;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "352@17608L13,353@17665L22,355@17772L29");
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier;
                                    if (i4 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 8) != 0) {
                                        outlinedShape = ButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                                        i3 &= -7169;
                                    } else {
                                        outlinedShape = shape2;
                                    }
                                    if ((i2 & 16) != 0) {
                                        buttonColorsOutlinedButtonColors = ButtonDefaults.INSTANCE.outlinedButtonColors(composerStartRestartGroup, 6);
                                        i3 &= -57345;
                                    } else {
                                        buttonColorsOutlinedButtonColors = buttonColors2;
                                    }
                                    if (i5 != 0) {
                                        buttonElevation2 = null;
                                    }
                                    if ((i2 & 64) != 0) {
                                        borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z2, composerStartRestartGroup, ((i3 >> 6) & 14) | 48, 0);
                                        i3 &= -3670017;
                                    } else {
                                        borderStrokeOutlinedButtonBorder = borderStroke2;
                                    }
                                    PaddingValues contentPadding = i6 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                    if (i8 != 0) {
                                        modifier3 = companion;
                                        buttonColors4 = buttonColorsOutlinedButtonColors;
                                        borderStroke4 = borderStrokeOutlinedButtonBorder;
                                        shape4 = outlinedShape;
                                        z4 = z2;
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        modifier3 = companion;
                                        buttonColors4 = buttonColorsOutlinedButtonColors;
                                        borderStroke4 = borderStrokeOutlinedButtonBorder;
                                        shape4 = outlinedShape;
                                        z4 = z2;
                                    }
                                    paddingValues3 = contentPadding;
                                    buttonElevation4 = buttonElevation2;
                                    i9 = 399974542;
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
                                    paddingValues3 = paddingValues;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    z4 = z2;
                                    shape4 = shape2;
                                    buttonColors4 = buttonColors2;
                                    buttonElevation4 = buttonElevation2;
                                    borderStroke4 = borderStroke2;
                                    i9 = 399974542;
                                    modifier3 = modifier;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material3.OutlinedButton (Button.kt:360)");
                                }
                                composer2 = composerStartRestartGroup;
                                Button(function02, modifier3, z4, shape4, buttonColors4, buttonElevation4, borderStroke4, paddingValues3, mutableInteractionSource3, function3, composer2, i3 & 2147483646, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                z3 = z4;
                                shape3 = shape4;
                                buttonColors3 = buttonColors4;
                                buttonElevation3 = buttonElevation4;
                                borderStroke3 = borderStroke4;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ButtonKt.OutlinedButton$lambda$6(function0, modifier2, z3, shape3, buttonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 805306368;
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i8 = i7;
                    if ((i2 & 512) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                buttonElevation2 = buttonElevation;
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i2 & 512) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            buttonElevation2 = buttonElevation;
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i2 & 512) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        buttonElevation2 = buttonElevation;
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i2 & 512) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit OutlinedButton$lambda$6(Function0 function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        OutlinedButton(function0, modifier, z, shape, buttonColors, buttonElevation, borderStroke, paddingValues, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape textShape;
        ButtonColors buttonColorsTextButtonColors;
        int i5;
        ButtonElevation buttonElevation2;
        int i6;
        BorderStroke borderStroke2;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z3;
        final Shape shape2;
        final ButtonColors buttonColors2;
        final ButtonElevation buttonElevation3;
        final BorderStroke borderStroke3;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        BorderStroke borderStroke4;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        PaddingValues paddingValues3;
        Modifier modifier4;
        Shape shape3;
        ButtonColors buttonColors3;
        ButtonElevation buttonElevation4;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1061374109);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextButton)N(onClick,modifier,enabled,shape,colors,elevation,border,contentPadding,interactionSource,content)429@21385L315:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    z2 = z;
                    i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        textShape = shape;
                        int i13 = composerStartRestartGroup.changed(textShape) ? 2048 : 1024;
                        i3 |= i13;
                    } else {
                        textShape = shape;
                    }
                    i3 |= i13;
                } else {
                    textShape = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColorsTextButtonColors = buttonColors;
                        int i14 = composerStartRestartGroup.changed(buttonColorsTextButtonColors) ? 16384 : 8192;
                        i3 |= i14;
                    } else {
                        buttonColorsTextButtonColors = buttonColors;
                    }
                    i3 |= i14;
                } else {
                    buttonColorsTextButtonColors = buttonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((196608 & i) == 0) {
                        buttonElevation2 = buttonElevation;
                        i3 |= composerStartRestartGroup.changed(buttonElevation2) ? 131072 : 65536;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else {
                        if ((1572864 & i) == 0) {
                            borderStroke2 = borderStroke;
                            i3 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                        }
                        i7 = i2 & 128;
                        if (i7 != 0) {
                            i3 |= 12582912;
                        } else {
                            if ((i & 12582912) == 0) {
                                i8 = i7;
                                i3 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                            }
                            i9 = i2 & 256;
                            if (i9 == 0) {
                                i3 |= 100663296;
                            } else {
                                if ((i & 100663296) == 0) {
                                    i10 = i9;
                                    i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                                }
                                if ((i2 & 512) == 0) {
                                    if ((i & 805306368) == 0) {
                                        i3 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                                    }
                                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                        composer2 = composerStartRestartGroup;
                                        composer2.skipToGroupEnd();
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        modifier3 = modifier2;
                                        z3 = z2;
                                        shape2 = textShape;
                                        buttonColors2 = buttonColorsTextButtonColors;
                                        buttonElevation3 = buttonElevation2;
                                        borderStroke3 = borderStroke2;
                                        paddingValues2 = paddingValues;
                                    } else {
                                        composerStartRestartGroup.startDefaults();
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "421@21050L9,422@21103L18");
                                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                            if (i12 != 0) {
                                                modifier2 = Modifier.INSTANCE;
                                            }
                                            boolean z5 = i4 == 0 ? z2 : true;
                                            if ((i2 & 8) != 0) {
                                                i3 &= -7169;
                                                textShape = ButtonDefaults.INSTANCE.getTextShape(composerStartRestartGroup, 6);
                                            }
                                            if ((i2 & 16) != 0) {
                                                i3 &= -57345;
                                                buttonColorsTextButtonColors = ButtonDefaults.INSTANCE.textButtonColors(composerStartRestartGroup, 6);
                                            }
                                            if (i5 != 0) {
                                                buttonElevation2 = null;
                                            }
                                            if (i6 != 0) {
                                                borderStroke2 = null;
                                            }
                                            PaddingValues textButtonContentPadding = i8 != 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues;
                                            if (i10 != 0) {
                                                boolean z6 = z5;
                                                borderStroke4 = borderStroke2;
                                                z4 = z6;
                                                mutableInteractionSource3 = null;
                                            } else {
                                                boolean z7 = z5;
                                                borderStroke4 = borderStroke2;
                                                z4 = z7;
                                                mutableInteractionSource3 = mutableInteractionSource;
                                            }
                                            paddingValues3 = textButtonContentPadding;
                                            modifier4 = modifier2;
                                            shape3 = textShape;
                                            buttonColors3 = buttonColorsTextButtonColors;
                                            buttonElevation4 = buttonElevation2;
                                            i11 = -1061374109;
                                        } else {
                                            composerStartRestartGroup.skipToGroupEnd();
                                            if ((i2 & 8) != 0) {
                                                i3 &= -7169;
                                            }
                                            if ((i2 & 16) != 0) {
                                                i3 &= -57345;
                                            }
                                            paddingValues3 = paddingValues;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                            modifier4 = modifier2;
                                            shape3 = textShape;
                                            buttonColors3 = buttonColorsTextButtonColors;
                                            buttonElevation4 = buttonElevation2;
                                            borderStroke4 = borderStroke2;
                                            i11 = -1061374109;
                                            z4 = z2;
                                        }
                                        composerStartRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(i11, i3, -1, "androidx.compose.material3.TextButton (Button.kt:429)");
                                        }
                                        composer2 = composerStartRestartGroup;
                                        Button(function02, modifier4, z4, shape3, buttonColors3, buttonElevation4, borderStroke4, paddingValues3, mutableInteractionSource3, function3, composer2, i3 & 2147483646, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier3 = modifier4;
                                        z3 = z4;
                                        shape2 = shape3;
                                        buttonColors2 = buttonColors3;
                                        buttonElevation3 = buttonElevation4;
                                        borderStroke3 = borderStroke4;
                                        paddingValues2 = paddingValues3;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup == null) {
                                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda4
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                return ButtonKt.TextButton$lambda$7(function0, modifier3, z3, shape2, buttonColors2, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i3 |= 805306368;
                                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                }
                            }
                            i10 = i9;
                            if ((i2 & 512) == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i8 = i7;
                        i9 = i2 & 256;
                        if (i9 == 0) {
                        }
                        i10 = i9;
                        if ((i2 & 512) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    borderStroke2 = borderStroke;
                    i7 = i2 & 128;
                    if (i7 != 0) {
                    }
                    i8 = i7;
                    i9 = i2 & 256;
                    if (i9 == 0) {
                    }
                    i10 = i9;
                    if ((i2 & 512) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                buttonElevation2 = buttonElevation;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                borderStroke2 = borderStroke;
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                i8 = i7;
                i9 = i2 & 256;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i2 & 512) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            buttonElevation2 = buttonElevation;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            borderStroke2 = borderStroke;
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i2 & 256;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i2 & 512) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        buttonElevation2 = buttonElevation;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        borderStroke2 = borderStroke;
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i2 & 256;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i2 & 512) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit TextButton$lambda$7(Function0 function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        TextButton(function0, modifier, z, shape, buttonColors, buttonElevation, borderStroke, paddingValues, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }
}
