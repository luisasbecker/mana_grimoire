package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
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

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001aÆ\u0001\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00192\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u001c\"\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010 \u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010!\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010\"\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u000e\u0010#\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010&\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020)X\u008a\u0084\u0002"}, d2 = {"Chip", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingIconStartSpacing", "LeadingIconEndSpacing", "TrailingIconSpacing", "SurfaceOverlayOpacity", "", "SelectedOverlayOpacity", "SelectedIconContainerSize", "material", "contentColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconContentColor"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ChipKt {
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    private static final float HorizontalPadding = Dp.m9114constructorimpl(12.0f);
    private static final float LeadingIconStartSpacing = Dp.m9114constructorimpl(4.0f);
    private static final float LeadingIconEndSpacing = Dp.m9114constructorimpl(8.0f);
    private static final float TrailingIconSpacing = Dp.m9114constructorimpl(8.0f);
    private static final float SelectedIconContainerSize = Dp.m9114constructorimpl(24.0f);

    /* JADX WARN: Removed duplicated region for block: B:143:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011d  */
    /* JADX WARN: Type inference failed for: r6v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Chip(final Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, ChipColors chipColors, Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape2;
        int i6;
        BorderStroke borderStroke2;
        ChipColors chipColorsM2962chipColors5tl4gsc;
        int i7;
        int i8;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        final Modifier modifier3;
        final boolean z3;
        final MutableInteractionSource mutableInteractionSource3;
        final Shape shape3;
        final BorderStroke borderStroke3;
        final ChipColors chipColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        CornerBasedShape cornerBasedShapeCopy;
        Composer composer3;
        boolean z4;
        boolean z5;
        Shape shape4;
        ChipColors chipColors3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        BorderStroke borderStroke4;
        boolean z6;
        MutableInteractionSource mutableInteractionSource4;
        ?? r6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1232125330);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Chip)N(onClick,modifier,enabled,interactionSource,shape,border,colors,leadingIcon,content)100@4561L21,103@4661L22,106@4758L24,110@4916L1391,101@4587L1720:Chip.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
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
                            shape2 = shape;
                            int i10 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                            i3 |= i10;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i10;
                    } else {
                        shape2 = shape;
                    }
                    i6 = i2 & 32;
                    if (i6 != 0) {
                        if ((196608 & i) == 0) {
                            borderStroke2 = borderStroke;
                            i3 |= composerStartRestartGroup.changed(borderStroke2) ? 131072 : 65536;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                chipColorsM2962chipColors5tl4gsc = chipColors;
                                int i11 = composerStartRestartGroup.changed(chipColorsM2962chipColors5tl4gsc) ? 1048576 : 524288;
                                i3 |= i11;
                            } else {
                                chipColorsM2962chipColors5tl4gsc = chipColors;
                            }
                            i3 |= i11;
                        } else {
                            chipColorsM2962chipColors5tl4gsc = chipColors;
                        }
                        i7 = i2 & 128;
                        if (i7 != 0) {
                            i3 |= 12582912;
                            i8 = i6;
                        } else {
                            i8 = i6;
                            if ((i & 12582912) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                            }
                        }
                        if ((i & 100663296) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i9 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if (i5 != 0) {
                                    mutableInteractionSource2 = null;
                                }
                                if ((i2 & 16) != 0) {
                                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    cornerBasedShapeCopy = shape2;
                                }
                                BorderStroke borderStroke5 = i8 != 0 ? null : borderStroke2;
                                if ((i2 & 64) != 0) {
                                    z4 = true;
                                    z5 = false;
                                    composer3 = composerStartRestartGroup;
                                    i3 &= -3670017;
                                    chipColorsM2962chipColors5tl4gsc = ChipDefaults.INSTANCE.m2962chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                } else {
                                    composer3 = composerStartRestartGroup;
                                    z4 = true;
                                    z5 = false;
                                }
                                ChipColors chipColors4 = chipColorsM2962chipColors5tl4gsc;
                                shape4 = cornerBasedShapeCopy;
                                chipColors3 = chipColors4;
                                function23 = i7 != 0 ? null : function2;
                                borderStroke4 = borderStroke5;
                                z6 = z2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                r6 = z4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                mutableInteractionSource4 = mutableInteractionSource2;
                                r6 = 1;
                                borderStroke4 = borderStroke2;
                                chipColors3 = chipColorsM2962chipColors5tl4gsc;
                                z5 = false;
                                z6 = z2;
                                shape4 = shape2;
                                composer3 = composerStartRestartGroup;
                                function23 = function2;
                            }
                            composer3.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                            }
                            int i12 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                            final State<Color> stateContentColor = chipColors3.contentColor(z6, composer3, i12);
                            ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                            Object objRememberedValue = composer3.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            final ChipColors chipColors5 = chipColors3;
                            final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                            final boolean z7 = z6;
                            composer2 = composer3;
                            SurfaceKt.m3173SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r6, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i12).getValue().m6335unboximpl(), Color.m6324copywmQWz5c$default(Chip$lambda$0(stateContentColor), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke4, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r6, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ChipKt.Chip$lambda$2(stateContentColor, function24, chipColors5, z7, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            chipColors2 = chipColors3;
                            function22 = function24;
                            modifier3 = modifier2;
                            z3 = z6;
                            shape3 = shape4;
                            borderStroke3 = borderStroke4;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function22 = function2;
                            modifier3 = modifier2;
                            z3 = z2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape3 = shape2;
                            borderStroke3 = borderStroke2;
                            chipColors2 = chipColorsM2962chipColors5tl4gsc;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ChipKt.Chip$lambda$3(function0, modifier3, z3, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function22, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    borderStroke2 = borderStroke;
                    if ((1572864 & i) == 0) {
                    }
                    i7 = i2 & 128;
                    if (i7 != 0) {
                    }
                    if ((i & 100663296) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 24576) != 0) {
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                }
                borderStroke2 = borderStroke;
                if ((1572864 & i) == 0) {
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
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
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            borderStroke2 = borderStroke;
            if ((1572864 & i) == 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
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
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        borderStroke2 = borderStroke;
        if ((1572864 & i) == 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final long Chip$lambda$0(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Chip$lambda$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8327getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Chip$lambda$2(State state, final Function2 function2, final ChipColors chipColors, final boolean z, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C111@4998L1303,111@4926L1375:Chip.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849195083, i, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:111)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6327getAlphaimpl(Chip$lambda$0(state)))), ComposableLambdaKt.rememberComposableLambda(1808091765, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.Chip$lambda$2$0(function2, chipColors, z, function3, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final Unit Chip$lambda$2$0(final Function2 function2, final ChipColors chipColors, final boolean z, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C112@5051L10,112@5069L1222,112@5012L1279:Chip.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1808091765, i, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:112)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2(), ComposableLambdaKt.rememberComposableLambda(1507027814, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.Chip$lambda$2$0$0(function2, chipColors, z, function3, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final Unit Chip$lambda$2$0$0(Function2 function2, ChipColors chipColors, boolean z, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C113@5087L1190:Chip.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1507027814, i, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:113)");
            }
            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SizeKt.m2068defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ChipDefaults.INSTANCE.m2965getMinHeightD9Ej5fM(), 1, null), function2 == null ? HorizontalPadding : Dp.m9114constructorimpl(0.0f), 0.0f, HorizontalPadding, 0.0f, 10, null);
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2041paddingqDBjuR0$default);
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
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1856957913, "C135@6250L9:Chip.kt#jmzs0o");
            if (function2 != null) {
                composer.startReplaceGroup(1856981007);
                ComposerKt.sourceInformation(composer, "126@5702L47,127@5812L32,128@5869L268,133@6162L45");
                SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, LeadingIconStartSpacing), composer, 6);
                State<Color> stateLeadingIconContentColor = chipColors.leadingIconContentColor(z, composer, 0);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(Chip$lambda$2$0$0$0$0(stateLeadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6327getAlphaimpl(Chip$lambda$2$0$0$0$0(stateLeadingIconContentColor))))}, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
                SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, LeadingIconEndSpacing), composer, 6);
            } else {
                composer.startReplaceGroup(1851332280);
            }
            composer.endReplaceGroup();
            function3.invoke(rowScopeInstance, composer, 6);
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

    private static final long Chip$lambda$2$0$0$0$0(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    static final Unit Chip$lambda$3(Function0 function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, ChipColors chipColors, Function2 function2, Function3 function3, int i, int i2, Composer composer, int i3) {
        Chip(function0, modifier, z, mutableInteractionSource, shape, borderStroke, chipColors, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilterChip(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, SelectableChipColors selectableChipColors, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        CornerBasedShape cornerBasedShapeCopy;
        int i7;
        BorderStroke borderStroke2;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final SelectableChipColors selectableChipColors2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Shape shape2;
        final BorderStroke borderStroke3;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i15;
        Modifier modifier4;
        int i16;
        int i17;
        int i18;
        SelectableChipColors selectableChipColorsM2963filterChipColorsJ08w3E;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        MutableInteractionSource mutableInteractionSource3;
        int i19;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Modifier modifier5;
        int i20;
        Composer composerStartRestartGroup = composer.startRestartGroup(69602198);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilterChip)N(selected,onClick,modifier,enabled,interactionSource,shape,border,colors,leadingIcon,selectedIcon,trailingIcon,content)196@9190L31,200@9329L24,203@9428L34,207@9602L3857,197@9226L4233:Chip.kt#jmzs0o");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i21 = i3 & 4;
        if (i21 != 0) {
            i4 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    i4 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        cornerBasedShapeCopy = shape;
                        i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(cornerBasedShapeCopy)) ? 131072 : 65536;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                        borderStroke2 = borderStroke;
                    } else {
                        borderStroke2 = borderStroke;
                        if ((i & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                        }
                    }
                    if ((i & 12582912) == 0) {
                        if ((i3 & 128) != 0) {
                            i20 = 4194304;
                            i4 |= i20;
                        } else {
                            if ((16777216 & i) == 0 ? composerStartRestartGroup.changed(selectableChipColors) : composerStartRestartGroup.changedInstance(selectableChipColors)) {
                                i20 = 8388608;
                            }
                            i4 |= i20;
                        }
                    }
                    i8 = i3 & 256;
                    if (i8 == 0) {
                        i4 |= 100663296;
                        function24 = function2;
                    } else {
                        function24 = function2;
                        if ((i & 100663296) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function24) ? 67108864 : 33554432;
                        }
                    }
                    i9 = i3 & 512;
                    if (i9 != 0) {
                        if ((i & 805306368) == 0) {
                            i10 = i9;
                            i4 |= composerStartRestartGroup.changedInstance(function22) ? 536870912 : 268435456;
                        }
                        i11 = i3 & 1024;
                        if (i11 != 0) {
                            i13 = i2 | 6;
                            i12 = i11;
                        } else if ((i2 & 6) == 0) {
                            i12 = i11;
                            i13 = i2 | (composerStartRestartGroup.changedInstance(function23) ? 4 : 2);
                        } else {
                            i12 = i11;
                            i13 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            i13 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
                        }
                        i14 = i13;
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i14 & 19) == 18) ? false : true, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i21 != 0 ? Modifier.INSTANCE : modifier2;
                                boolean z5 = i5 != 0 ? true : z3;
                                MutableInteractionSource mutableInteractionSource4 = i6 != 0 ? null : mutableInteractionSource;
                                if ((i3 & 32) != 0) {
                                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i4 &= -458753;
                                }
                                int i22 = i4;
                                Shape shape3 = cornerBasedShapeCopy;
                                BorderStroke borderStroke4 = i7 != 0 ? null : borderStroke2;
                                if ((i3 & 128) != 0) {
                                    i17 = i10;
                                    i18 = i12;
                                    i16 = i8;
                                    i15 = i14;
                                    modifier4 = companion;
                                    selectableChipColorsM2963filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2963filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    i22 &= -29360129;
                                } else {
                                    i15 = i14;
                                    modifier4 = companion;
                                    i16 = i8;
                                    i17 = i10;
                                    i18 = i12;
                                    selectableChipColorsM2963filterChipColorsJ08w3E = selectableChipColors;
                                }
                                if (i16 != 0) {
                                    function24 = null;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function211 = i17 != 0 ? null : function22;
                                if (i18 != 0) {
                                    function29 = function211;
                                    z3 = z5;
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                    cornerBasedShapeCopy = shape3;
                                    i19 = i22;
                                    borderStroke2 = borderStroke4;
                                    function28 = null;
                                } else {
                                    function28 = function23;
                                    function29 = function211;
                                    z3 = z5;
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                    cornerBasedShapeCopy = shape3;
                                    i19 = i22;
                                    borderStroke2 = borderStroke4;
                                }
                                function210 = function24;
                                modifier5 = modifier4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                mutableInteractionSource3 = mutableInteractionSource;
                                function29 = function22;
                                function28 = function23;
                                i15 = i14;
                                function210 = function24;
                                modifier5 = modifier2;
                                i19 = i4;
                                selectableChipColorsM2963filterChipColorsJ08w3E = selectableChipColors;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(69602198, i19, i15, "androidx.compose.material.FilterChip (Chip.kt:194)");
                            }
                            int i23 = i19 << 3;
                            int i24 = ((i19 >> 9) & 14) | (i23 & 112) | ((i19 >> 15) & 896);
                            final State<Color> stateContentColor = selectableChipColorsM2963filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i24);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final Function2<? super Composer, ? super Integer, Unit> function212 = function210;
                            Shape shape4 = cornerBasedShapeCopy;
                            final SelectableChipColors selectableChipColors3 = selectableChipColorsM2963filterChipColorsJ08w3E;
                            final Function2<? super Composer, ? super Integer, Unit> function213 = function29;
                            final Function2<? super Composer, ? super Integer, Unit> function214 = function28;
                            final boolean z6 = z3;
                            Modifier modifier6 = modifier5;
                            SurfaceKt.m3174SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier5, false, (Function1) objRememberedValue, 1, null), z6, shape4, selectableChipColorsM2963filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i24).getValue().m6335unboximpl(), Color.m6324copywmQWz5c$default(stateContentColor.getValue().m6335unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ChipKt.FilterChip$lambda$1(stateContentColor, function212, z, function213, function214, function3, selectableChipColors3, z6, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i23 & 29360128) | ((i19 << 15) & 1879048192), 6, 256);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape2 = shape4;
                            borderStroke3 = borderStroke2;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            selectableChipColors2 = selectableChipColors3;
                            function27 = function212;
                            function25 = function213;
                            function26 = function214;
                            z4 = z6;
                            modifier3 = modifier6;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            selectableChipColors2 = selectableChipColors;
                            function25 = function22;
                            function26 = function23;
                            shape2 = cornerBasedShapeCopy;
                            borderStroke3 = borderStroke2;
                            modifier3 = modifier2;
                            function27 = function24;
                            z4 = z3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z4, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function27, function25, function26, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 805306368;
                    i10 = i9;
                    i11 = i3 & 1024;
                    if (i11 != 0) {
                    }
                    if ((i2 & 48) == 0) {
                    }
                    i14 = i13;
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i14 & 19) == 18) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i8 = i3 & 256;
                if (i8 == 0) {
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                }
                i10 = i9;
                i11 = i3 & 1024;
                if (i11 != 0) {
                }
                if ((i2 & 48) == 0) {
                }
                i14 = i13;
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i14 & 19) == 18) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z3 = z2;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i8 = i3 & 256;
            if (i8 == 0) {
            }
            i9 = i3 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i3 & 1024;
            if (i11 != 0) {
            }
            if ((i2 & 48) == 0) {
            }
            i14 = i13;
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i14 & 19) == 18) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z3 = z2;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i3 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i3 & 1024;
        if (i11 != 0) {
        }
        if ((i2 & 48) == 0) {
        }
        i14 = i13;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i14 & 19) == 18) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterChip$lambda$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8329getCheckboxo7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit FilterChip$lambda$1(final State state, final Function2 function2, final boolean z, final Function2 function22, final Function2 function23, final Function3 function3, final SelectableChipColors selectableChipColors, final boolean z2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C208@9690L3763,208@9612L3841:Chip.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-60565717, i, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:208)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6327getAlphaimpl(((Color) state.getValue()).m6335unboximpl()))), ComposableLambdaKt.rememberComposableLambda(-773543317, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.FilterChip$lambda$1$0(function2, z, function22, function23, function3, selectableChipColors, z2, state, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final Unit FilterChip$lambda$1$0(final Function2 function2, final boolean z, final Function2 function22, final Function2 function23, final Function3 function3, final SelectableChipColors selectableChipColors, final boolean z2, final State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C209@9743L10,209@9761L3682,209@9704L3739:Chip.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-773543317, i, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:209)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2(), ComposableLambdaKt.rememberComposableLambda(-44453990, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.FilterChip$lambda$1$0$0(function2, z, function22, function23, function3, selectableChipColors, z2, state, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final Unit FilterChip$lambda$1$0$0(Function2 function2, boolean z, Function2 function22, Function2 function23, Function3 function3, SelectableChipColors selectableChipColors, boolean z2, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C210@9779L3650:Chip.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-44453990, i, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:210)");
            }
            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SizeKt.m2068defaultMinSizeVpY3zN4$default(IntrinsicKt.width(Modifier.INSTANCE, IntrinsicSize.Max), 0.0f, ChipDefaults.INSTANCE.m2965getMinHeightD9Ej5fM(), 1, null), (function2 != null || (z && function22 != null)) ? Dp.m9114constructorimpl(0.0f) : HorizontalPadding, 0.0f, function23 == null ? HorizontalPadding : Dp.m9114constructorimpl(0.0f), 0.0f, 10, null);
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2041paddingqDBjuR0$default);
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
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1505315515, "C268@12902L264:Chip.kt#jmzs0o");
            if (function2 != null || (z && function22 != null)) {
                composer.startReplaceGroup(-1505271403);
                ComposerKt.sourceInformation(composer, "231@10804L47,232@10876L1913,266@12814L45");
                SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, LeadingIconStartSpacing), composer, 6);
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer);
                Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -2077321583, "C:Chip.kt#jmzs0o");
                if (function2 != null) {
                    composer.startReplaceGroup(-2077339967);
                    ComposerKt.sourceInformation(composer, "234@10999L35,235@11067L298");
                    State<Color> stateLeadingIconColor = selectableChipColors.leadingIconColor(z2, z, composer, 0);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(stateLeadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6327getAlphaimpl(stateLeadingIconColor.getValue().m6335unboximpl())))}, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
                } else {
                    composer.startReplaceGroup(-2088202739);
                }
                composer.endReplaceGroup();
                if (!z || function22 == null) {
                    composer.startReplaceGroup(-2088202739);
                } else {
                    composer.startReplaceGroup(-2076791112);
                    ComposerKt.sourceInformation(composer, "255@12280L453");
                    Modifier.Companion companionClip = Modifier.INSTANCE;
                    long jM6335unboximpl = ((Color) state.getValue()).m6335unboximpl();
                    if (function2 != null) {
                        composer.startReplaceGroup(-2076615869);
                        ComposerKt.sourceInformation(composer, "253@12173L34");
                        companionClip = ClipKt.clip(BackgroundKt.m1482backgroundbw27NRU(SizeKt.m2075requiredSize3ABfNKs(Modifier.INSTANCE, SelectedIconContainerSize), ((Color) state.getValue()).m6335unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                        jM6335unboximpl = selectableChipColors.backgroundColor(z2, z, composer, 0).getValue().m6335unboximpl();
                    } else {
                        composer.startReplaceGroup(-2088202739);
                    }
                    composer.endReplaceGroup();
                    Alignment center = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, companionClip);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor3);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer);
                    Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer, 1681585881, "C259@12494L205:Chip.kt#jmzs0o");
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(jM6335unboximpl)), (Function2<? super Composer, ? super Integer, Unit>) function22, composer, ProvidedValue.$stable);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                }
                composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, LeadingIconEndSpacing), composer, 6);
            } else {
                composer.startReplaceGroup(-1516029364);
            }
            composer.endReplaceGroup();
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            Arrangement.Horizontal start2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(start2, centerVertically2, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composer);
            Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM5595constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM5595constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (function23 != null) {
                composer.startReplaceGroup(-1502914938);
                ComposerKt.sourceInformation(composer, "275@13239L43,276@13307L14,277@13346L43");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                float f = TrailingIconSpacing;
                SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(companion2, f), composer, 6);
                function23.invoke(composer, 0);
                SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, f), composer, 6);
            } else {
                composer.startReplaceGroup(-1516029364);
            }
            composer.endReplaceGroup();
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

    static final Unit FilterChip$lambda$2(boolean z, Function0 function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, SelectableChipColors selectableChipColors, Function2 function2, Function2 function22, Function2 function23, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        FilterChip(z, function0, modifier, z2, mutableInteractionSource, shape, borderStroke, selectableChipColors, function2, function22, function23, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }
}
