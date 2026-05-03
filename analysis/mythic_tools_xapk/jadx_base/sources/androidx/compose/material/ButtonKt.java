package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
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
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "elevation", "Landroidx/compose/material/ButtonElevation;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ButtonColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/ButtonElevation;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ButtonColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedButton", "TextButton", "material", "contentColor", "Landroidx/compose/ui/graphics/Color;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:106:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0116  */
    /* JADX WARN: Type inference failed for: r6v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Button(final Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        ButtonElevation buttonElevationM2946elevationR_JCAzs;
        int i6;
        int i7;
        int i8;
        int i9;
        Composer composer2;
        final Shape shape2;
        final BorderStroke borderStroke2;
        final Modifier modifier3;
        final boolean z3;
        final MutableInteractionSource mutableInteractionSource3;
        final ButtonElevation buttonElevation2;
        final ButtonColors buttonColors2;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        MutableInteractionSource mutableInteractionSource4;
        CornerBasedShape small;
        Composer composer3;
        boolean z4;
        int i10;
        ButtonColors buttonColorsM2945buttonColorsro_MJ88;
        final PaddingValues contentPadding;
        Shape shape3;
        BorderStroke borderStroke3;
        boolean z5;
        int i11;
        ?? r6;
        MutableInteractionSource mutableInteractionSource5;
        State<Dp> stateElevation;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1084573925);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Button)N(onClick,modifier,enabled,interactionSource,elevation,shape,border,colors,contentPadding,content)108@5157L21,111@5257L22,114@5354L24,119@5603L646,109@5183L1066:Button.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
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
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            buttonElevationM2946elevationR_JCAzs = buttonElevation;
                            int i13 = composerStartRestartGroup.changed(buttonElevationM2946elevationR_JCAzs) ? 16384 : 8192;
                            i3 |= i13;
                        } else {
                            buttonElevationM2946elevationR_JCAzs = buttonElevation;
                        }
                        i3 |= i13;
                    } else {
                        buttonElevationM2946elevationR_JCAzs = buttonElevation;
                    }
                    if ((196608 & i) == 0) {
                        i3 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(shape)) ? 131072 : 65536;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changed(borderStroke) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) == 0) {
                        i3 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(buttonColors)) ? 8388608 : 4194304;
                    }
                    i7 = i2 & 256;
                    if (i7 != 0) {
                        if ((i & 100663296) == 0) {
                            i8 = i7;
                            i3 |= composerStartRestartGroup.changed(paddingValues) ? 67108864 : 33554432;
                        }
                        if ((i & 805306368) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                        }
                        i9 = i3;
                        if (composerStartRestartGroup.shouldExecute((i9 & 306783379) != 306783378, i9 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i12 != 0 ? Modifier.INSTANCE : modifier2;
                                boolean z6 = i4 != 0 ? true : z2;
                                mutableInteractionSource4 = i5 != 0 ? null : mutableInteractionSource2;
                                if ((i2 & 16) != 0) {
                                    i9 &= -57345;
                                    buttonElevationM2946elevationR_JCAzs = ButtonDefaults.INSTANCE.m2946elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i9 &= -458753;
                                } else {
                                    small = shape;
                                }
                                int i14 = i9;
                                BorderStroke borderStroke4 = i6 != 0 ? null : borderStroke;
                                if ((i2 & 128) != 0) {
                                    i10 = i8;
                                    z4 = true;
                                    buttonColorsM2945buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2945buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    composer3 = composerStartRestartGroup;
                                    i14 &= -29360129;
                                } else {
                                    composer3 = composerStartRestartGroup;
                                    z4 = true;
                                    i10 = i8;
                                    buttonColorsM2945buttonColorsro_MJ88 = buttonColors;
                                }
                                int i15 = i14;
                                contentPadding = i10 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke4;
                                z5 = z6;
                                modifier2 = companion;
                                i11 = i15;
                                r6 = z4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i9 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i9 &= -458753;
                                }
                                if ((i2 & 128) != 0) {
                                    i9 &= -29360129;
                                }
                                shape3 = shape;
                                borderStroke3 = borderStroke;
                                contentPadding = paddingValues;
                                z5 = z2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                r6 = 1;
                                i11 = i9;
                                composer3 = composerStartRestartGroup;
                                buttonColorsM2945buttonColorsro_MJ88 = buttonColors;
                            }
                            composer3.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1084573925, i11, -1, "androidx.compose.material.Button (Button.kt:105)");
                            }
                            if (mutableInteractionSource4 == null) {
                                composer3.startReplaceGroup(497721888);
                                ComposerKt.sourceInformation(composer3, "107@5086L39");
                                ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                                Object objRememberedValue = composer3.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer3.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceGroup();
                                mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                composer3.startReplaceGroup(1401528215);
                                composer3.endReplaceGroup();
                                mutableInteractionSource5 = mutableInteractionSource4;
                            }
                            int i16 = i11 >> 6;
                            int i17 = (i16 & 14) | ((i11 >> 18) & 112);
                            final State<Color> stateContentColor = buttonColorsM2945buttonColorsro_MJ88.contentColor(z5, composer3, i17);
                            ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue2, r6, null);
                            long jM6335unboximpl = buttonColorsM2945buttonColorsro_MJ88.backgroundColor(z5, composer3, i17).getValue().m6335unboximpl();
                            long jM6324copywmQWz5c$default = Color.m6324copywmQWz5c$default(Button$lambda$1(stateContentColor), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            if (buttonElevationM2946elevationR_JCAzs == null) {
                                composer3.startReplaceGroup(498128545);
                                composer3.endReplaceGroup();
                                stateElevation = null;
                            } else {
                                composer3.startReplaceGroup(1401541984);
                                ComposerKt.sourceInformation(composer3, "117@5496L37");
                                stateElevation = buttonElevationM2946elevationR_JCAzs.elevation(z5, mutableInteractionSource5, composer3, i16 & Videoio.CAP_OPENNI_ASUS);
                                composer3.endReplaceGroup();
                            }
                            Composer composer4 = composer3;
                            SurfaceKt.m3173SurfaceLPr_se0(function0, modifierSemantics$default, z5, shape3, jM6335unboximpl, jM6324copywmQWz5c$default, borderStroke3, stateElevation != null ? stateElevation.getValue().m9128unboximpl() : Dp.m9114constructorimpl(0.0f), mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ButtonKt.Button$lambda$3(stateContentColor, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54), composer4, (i11 & 14) | 805306368 | (i11 & 896) | (i16 & 7168) | (i11 & 3670016), 0);
                            composer2 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            buttonColors2 = buttonColorsM2945buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM2946elevationR_JCAzs;
                            shape2 = shape3;
                            borderStroke2 = borderStroke3;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            paddingValues2 = contentPadding;
                            modifier3 = modifier2;
                            z3 = z5;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            shape2 = shape;
                            borderStroke2 = borderStroke;
                            modifier3 = modifier2;
                            z3 = z2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            buttonElevation2 = buttonElevationM2946elevationR_JCAzs;
                            buttonColors2 = buttonColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ButtonKt.Button$lambda$4(function0, modifier3, z3, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 100663296;
                    i8 = i7;
                    if ((i & 805306368) == 0) {
                    }
                    i9 = i3;
                    if (composerStartRestartGroup.shouldExecute((i9 & 306783379) != 306783378, i9 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) == 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & 256;
                if (i7 != 0) {
                }
                i8 = i7;
                if ((i & 805306368) == 0) {
                }
                i9 = i3;
                if (composerStartRestartGroup.shouldExecute((i9 & 306783379) != 306783378, i9 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z2 = z;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) == 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & 256;
            if (i7 != 0) {
            }
            i8 = i7;
            if ((i & 805306368) == 0) {
            }
            i9 = i3;
            if (composerStartRestartGroup.shouldExecute((i9 & 306783379) != 306783378, i9 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) == 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & 256;
        if (i7 != 0) {
        }
        i8 = i7;
        if ((i & 805306368) == 0) {
        }
        i9 = i3;
        if (composerStartRestartGroup.shouldExecute((i9 & 306783379) != 306783378, i9 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final long Button$lambda$1(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Button$lambda$2$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8327getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Button$lambda$3(State state, final PaddingValues paddingValues, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C120@5685L558,120@5613L630:Button.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-20345758, i, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:120)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6327getAlphaimpl(Button$lambda$1(state)))), ComposableLambdaKt.rememberComposableLambda(-869936862, true, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonKt.Button$lambda$3$0(paddingValues, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Button$lambda$3$0(final PaddingValues paddingValues, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C121@5738L10,121@5757L476,121@5699L534:Button.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-869936862, i, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:121)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getButton(), ComposableLambdaKt.rememberComposableLambda(165539859, true, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonKt.Button$lambda$3$0$0(paddingValues, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Button$lambda$3$0$0(PaddingValues paddingValues, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C122@5775L444:Button.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(165539859, i, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:122)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.m2067defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m2951getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2950getMinHeightD9Ej5fM()), paddingValues);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
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

    static final Unit Button$lambda$4(Function0 function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3 function3, int i, int i2, Composer composer, int i3) {
        Button(function0, modifier, z, mutableInteractionSource, buttonElevation, shape, borderStroke, buttonColors, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void OutlinedButton(Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1445054947, "C(OutlinedButton)N(onClick,modifier,enabled,interactionSource,elevation,shape,border,colors,contentPadding,content)175@8304L6,176@8361L14,177@8419L22,181@8564L315:Button.kt#jmzs0o");
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        MutableInteractionSource mutableInteractionSource2 = (i2 & 8) != 0 ? null : mutableInteractionSource;
        ButtonElevation buttonElevation2 = (i2 & 16) != 0 ? null : buttonElevation;
        Shape small = (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape;
        BorderStroke outlinedBorder = (i2 & 64) != 0 ? ButtonDefaults.INSTANCE.getOutlinedBorder(composer, 6) : borderStroke;
        ButtonColors buttonColorsM2953outlinedButtonColorsRGew2ao = (i2 & 128) != 0 ? ButtonDefaults.INSTANCE.m2953outlinedButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors;
        PaddingValues contentPadding = (i2 & 256) != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1445054947, i, -1, "androidx.compose.material.OutlinedButton (Button.kt:181)");
        }
        Button(function0, modifier2, z2, mutableInteractionSource2, buttonElevation2, small, outlinedBorder, buttonColorsM2953outlinedButtonColorsRGew2ao, contentPadding, function3, composer, i & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final void TextButton(Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 724562088, "C(TextButton)N(onClick,modifier,enabled,interactionSource,elevation,shape,border,colors,contentPadding,content)232@10929L6,234@11019L18,238@11170L315:Button.kt#jmzs0o");
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        MutableInteractionSource mutableInteractionSource2 = (i2 & 8) != 0 ? null : mutableInteractionSource;
        ButtonElevation buttonElevation2 = (i2 & 16) != 0 ? null : buttonElevation;
        Shape small = (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape;
        BorderStroke borderStroke2 = (i2 & 64) != 0 ? null : borderStroke;
        ButtonColors buttonColorsM2954textButtonColorsRGew2ao = (i2 & 128) != 0 ? ButtonDefaults.INSTANCE.m2954textButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors;
        PaddingValues textButtonContentPadding = (i2 & 256) != 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(724562088, i, -1, "androidx.compose.material.TextButton (Button.kt:238)");
        }
        Button(function0, modifier2, z2, mutableInteractionSource2, buttonElevation2, small, borderStroke2, buttonColorsM2954textButtonColorsRGew2ao, textButtonContentPadding, function3, composer, i & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }
}
