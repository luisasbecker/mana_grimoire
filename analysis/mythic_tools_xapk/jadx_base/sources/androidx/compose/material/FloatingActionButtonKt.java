package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
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
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001an\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0085\u0001\u0010\u0013\u001a\u00020\u00012\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00102\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\"\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001c\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001d\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001e"}, d2 = {"FloatingActionButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "FloatingActionButton-bogVsAg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ExtendedFloatingActionButton", "text", "icon", "ExtendedFloatingActionButton-wqdebIU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Landroidx/compose/runtime/Composer;II)V", "FabSize", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabSize", "ExtendedFabIconPadding", "ExtendedFabTextPadding", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FloatingActionButtonKt {
    private static final float FabSize = Dp.m9114constructorimpl(56.0f);
    private static final float ExtendedFabSize = Dp.m9114constructorimpl(48.0f);
    private static final float ExtendedFabIconPadding = Dp.m9114constructorimpl(12.0f);
    private static final float ExtendedFabTextPadding = Dp.m9114constructorimpl(20.0f);

    /* JADX WARN: Removed duplicated region for block: B:147:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0110  */
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3063ExtendedFloatingActionButtonwqdebIU(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Shape shapeCopy;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final Modifier modifier3;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final MutableInteractionSource mutableInteractionSource3;
        final Shape shape2;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        long jM2985getSecondary0d7_KjU;
        long jM3001contentColorForek8zF_U;
        Composer composer3;
        MutableInteractionSource mutableInteractionSource4;
        FloatingActionButtonElevation floatingActionButtonElevationM3058elevationxZ9QkE;
        long j5;
        long j6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1506973027);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExtendedFloatingActionButton)N(text,onClick,modifier,icon,interactionSource,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation)168@7792L442,160@7463L771:FloatingActionButton.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
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
                    function23 = function22;
                    i3 |= composerStartRestartGroup.changedInstance(function23) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            shapeCopy = shape;
                            int i8 = composerStartRestartGroup.changed(shapeCopy) ? 131072 : 65536;
                            i3 |= i8;
                        } else {
                            shapeCopy = shape;
                        }
                        i3 |= i8;
                    } else {
                        shapeCopy = shape;
                    }
                    if ((1572864 & i) == 0) {
                        i3 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(j)) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) == 0) {
                        i3 |= ((i2 & 128) == 0 && composerStartRestartGroup.changed(j2)) ? 8388608 : 4194304;
                    }
                    if ((100663296 & i) != 0) {
                        if ((i2 & 256) == 0) {
                            floatingActionButtonElevation2 = floatingActionButtonElevation;
                            int i9 = composerStartRestartGroup.changed(floatingActionButtonElevation2) ? 67108864 : 33554432;
                            i3 |= i9;
                        } else {
                            floatingActionButtonElevation2 = floatingActionButtonElevation;
                        }
                        i3 |= i9;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        composer2 = composerStartRestartGroup;
                        function24 = function23;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape2 = shapeCopy;
                        j3 = j;
                        j4 = j2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "155@7200L6,156@7288L6,157@7332L32,158@7442L11");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function23 = null;
                            }
                            if (i5 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                shapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            }
                            if ((i2 & 64) != 0) {
                                i6 = i3 & (-3670017);
                                jM2985getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2985getSecondary0d7_KjU();
                            } else {
                                i6 = i3;
                                jM2985getSecondary0d7_KjU = j;
                            }
                            if ((i2 & 128) != 0) {
                                jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(jM2985getSecondary0d7_KjU, composerStartRestartGroup, (i6 >> 18) & 14);
                                i6 &= -29360129;
                            } else {
                                jM3001contentColorForek8zF_U = j2;
                            }
                            if ((i2 & 256) != 0) {
                                composer3 = composerStartRestartGroup;
                                i6 &= -234881025;
                                floatingActionButtonElevationM3058elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3058elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                                mutableInteractionSource4 = mutableInteractionSource2;
                            } else {
                                composer3 = composerStartRestartGroup;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                floatingActionButtonElevationM3058elevationxZ9QkE = floatingActionButtonElevation2;
                            }
                            j5 = jM3001contentColorForek8zF_U;
                            j6 = jM2985getSecondary0d7_KjU;
                            i3 = i6;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                            }
                            j6 = j;
                            j5 = j2;
                            composer3 = composerStartRestartGroup;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            floatingActionButtonElevationM3058elevationxZ9QkE = floatingActionButtonElevation2;
                        }
                        Shape shape3 = shapeCopy;
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1506973027, i3, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:159)");
                        }
                        float f = ExtendedFabSize;
                        int i10 = i3 >> 6;
                        m3064FloatingActionButtonbogVsAg(function0, SizeKt.m2087sizeInqDBjuR0$default(modifier2, f, f, 0.0f, 0.0f, 12, null), mutableInteractionSource4, shape3, j6, j5, floatingActionButtonElevationM3058elevationxZ9QkE, ComposableLambdaKt.rememberComposableLambda(-555697957, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$0(function23, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54), composer3, 12582912 | ((i3 >> 3) & 14) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (i10 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        composer2 = composer3;
                        function24 = function23;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        shape2 = shape3;
                        j3 = j6;
                        j4 = j5;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM3058elevationxZ9QkE;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FloatingActionButtonKt.ExtendedFloatingActionButton_wqdebIU$lambda$1(function2, function0, modifier3, function24, mutableInteractionSource3, shape2, j3, j4, floatingActionButtonElevation2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                if ((1572864 & i) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((100663296 & i) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function23 = function22;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((100663296 & i) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function23 = function22;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((100663296 & i) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit ExtendedFloatingActionButton_wqdebIU$lambda$0(Function2 function2, Function2 function22, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C170@7898L330:FloatingActionButton.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-555697957, i, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:169)");
            }
            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, function2 == null ? ExtendedFabTextPadding : ExtendedFabIconPadding, 0.0f, ExtendedFabTextPadding, 0.0f, 10, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
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
            ComposerKt.sourceInformationMarkerStart(composer, 185594530, "C178@8212L6:FloatingActionButton.kt#jmzs0o");
            if (function2 != null) {
                composer.startReplaceGroup(185611238);
                ComposerKt.sourceInformation(composer, "175@8116L6,176@8139L46");
                function2.invoke(composer, 0);
                SpacerKt.Spacer(SizeKt.m2088width3ABfNKs(Modifier.INSTANCE, ExtendedFabIconPadding), composer, 6);
            } else {
                composer.startReplaceGroup(177573899);
            }
            composer.endReplaceGroup();
            function22.invoke(composer, 0);
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

    static final Unit ExtendedFloatingActionButton_wqdebIU$lambda$1(Function2 function2, Function0 function0, Modifier modifier, Function2 function22, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, int i, int i2, Composer composer, int i3) {
        m3063ExtendedFloatingActionButtonwqdebIU(function2, function0, modifier, function22, mutableInteractionSource, shape, j, j2, floatingActionButtonElevation, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f6  */
    /* JADX INFO: renamed from: FloatingActionButton-bogVsAg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3064FloatingActionButtonbogVsAg(final Function0<Unit> function0, Modifier modifier, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape2;
        long j3;
        final long jM3001contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        final Modifier modifier2;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource3;
        final Shape shape3;
        final long j4;
        final long j5;
        final FloatingActionButtonElevation floatingActionButtonElevation3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        CornerBasedShape cornerBasedShapeCopy;
        long jM2985getSecondary0d7_KjU;
        Composer composer3;
        long j6;
        FloatingActionButtonElevation floatingActionButtonElevationM3058elevationxZ9QkE;
        int i5;
        Shape shape4;
        boolean z;
        MutableInteractionSource mutableInteractionSource4;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-482679837);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FloatingActionButton)N(onClick,modifier,interactionSource,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,content)95@4354L22,99@4501L28,101@4590L420,93@4280L730:FloatingActionButton.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i7 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i7;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i7;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j3 = j;
                        int i8 = composerStartRestartGroup.changed(j3) ? 16384 : 8192;
                        i3 |= i8;
                    } else {
                        j3 = j;
                    }
                    i3 |= i8;
                } else {
                    j3 = j;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        jM3001contentColorForek8zF_U = j2;
                        int i9 = composerStartRestartGroup.changed(jM3001contentColorForek8zF_U) ? 131072 : 65536;
                        i3 |= i9;
                    } else {
                        jM3001contentColorForek8zF_U = j2;
                    }
                    i3 |= i9;
                } else {
                    jM3001contentColorForek8zF_U = j2;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                        int i10 = composerStartRestartGroup.changed(floatingActionButtonElevation2) ? 1048576 : 524288;
                        i3 |= i10;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    i3 |= i10;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                if ((i & 12582912) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "85@3859L6,86@3947L6,87@3991L32,88@4101L11");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        companion = i6 != 0 ? Modifier.INSTANCE : modifier;
                        if (i4 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 8) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -7169;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            jM2985getSecondary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2985getSecondary0d7_KjU();
                            i3 &= -57345;
                        } else {
                            jM2985getSecondary0d7_KjU = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM3001contentColorForek8zF_U = ColorsKt.m3001contentColorForek8zF_U(jM2985getSecondary0d7_KjU, composerStartRestartGroup, (i3 >> 12) & 14);
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            floatingActionButtonElevationM3058elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3058elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            shape4 = cornerBasedShapeCopy;
                            j6 = jM2985getSecondary0d7_KjU;
                            z = false;
                        } else {
                            composer3 = composerStartRestartGroup;
                            j6 = jM2985getSecondary0d7_KjU;
                            floatingActionButtonElevationM3058elevationxZ9QkE = floatingActionButtonElevation2;
                            i5 = -482679837;
                            shape4 = cornerBasedShapeCopy;
                            z = false;
                            composer3.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i5, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:90)");
                            }
                            if (mutableInteractionSource2 != null) {
                                composer3.startReplaceGroup(36032728);
                                ComposerKt.sourceInformation(composer3, "92@4236L39");
                                ComposerKt.sourceInformationMarkerStart(composer3, 1162346, "CC(remember):FloatingActionButton.kt#9igjgp");
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceGroup();
                                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                            } else {
                                composer3.startReplaceGroup(1161695);
                                composer3.endReplaceGroup();
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            ComposerKt.sourceInformationMarkerStart(composer3, 1166105, "CC(remember):FloatingActionButton.kt#9igjgp");
                            objRememberedValue = composer3.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$1$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            long j7 = jM3001contentColorForek8zF_U;
                            SurfaceKt.m3173SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(companion, z, (Function1) objRememberedValue, 1, null), false, shape4, j6, j7, null, floatingActionButtonElevationM3058elevationxZ9QkE.elevation(mutableInteractionSource4, composer3, (i3 >> 15) & 112).getValue().m9128unboximpl(), mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1823447062, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$2(jM3001contentColorForek8zF_U, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54), composer3, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (i3 & 458752), 68);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = companion;
                            floatingActionButtonElevation3 = floatingActionButtonElevationM3058elevationxZ9QkE;
                            composer2 = composer3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape3 = shape4;
                            j4 = j6;
                            j5 = j7;
                        }
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
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        companion = modifier;
                        composer3 = composerStartRestartGroup;
                        j6 = j3;
                        floatingActionButtonElevationM3058elevationxZ9QkE = floatingActionButtonElevation2;
                        z = false;
                        shape4 = shape2;
                    }
                    i5 = -482679837;
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (mutableInteractionSource2 != null) {
                    }
                    ComposerKt.sourceInformationMarkerStart(composer3, 1166105, "CC(remember):FloatingActionButton.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    long j72 = jM3001contentColorForek8zF_U;
                    SurfaceKt.m3173SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(companion, z, (Function1) objRememberedValue, 1, null), false, shape4, j6, j72, null, floatingActionButtonElevationM3058elevationxZ9QkE.elevation(mutableInteractionSource4, composer3, (i3 >> 15) & 112).getValue().m9128unboximpl(), mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1823447062, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$2(jM3001contentColorForek8zF_U, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer3, (i3 & 14) | 805306368 | (i3 & 7168) | (57344 & i3) | (i3 & 458752), 68);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = companion;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3058elevationxZ9QkE;
                    composer2 = composer3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = shape4;
                    j4 = j6;
                    j5 = j72;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    composer2 = composerStartRestartGroup;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = shape2;
                    j4 = j3;
                    j5 = jM3001contentColorForek8zF_U;
                    floatingActionButtonElevation3 = floatingActionButtonElevation2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$3(function0, modifier2, mutableInteractionSource3, shape3, j4, j5, floatingActionButtonElevation3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_bogVsAg$lambda$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8346setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8327getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit FloatingActionButton_bogVsAg$lambda$2(long j, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C102@4672L332,102@4600L404:FloatingActionButton.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1823447062, i, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:102)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6327getAlphaimpl(j))), ComposableLambdaKt.rememberComposableLambda(-1072292694, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$2$0(function2, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final Unit FloatingActionButton_bogVsAg$lambda$2$0(final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C103@4717L10,103@4736L258,103@4686L308:FloatingActionButton.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1072292694, i, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:103)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getButton(), ComposableLambdaKt.rememberComposableLambda(-1686273317, true, new Function2() { // from class: androidx.compose.material.FloatingActionButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.FloatingActionButton_bogVsAg$lambda$2$0$0(function2, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final Unit FloatingActionButton_bogVsAg$lambda$2$0$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C104@4754L226:FloatingActionButton.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1686273317, i, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:104)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f = FabSize;
            Modifier modifierM2067defaultMinSizeVpY3zN4 = SizeKt.m2067defaultMinSizeVpY3zN4(companion, f, f);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2067defaultMinSizeVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(composer, -344600103, "C108@4953L9:FloatingActionButton.kt#jmzs0o");
            function2.invoke(composer, 0);
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

    static final Unit FloatingActionButton_bogVsAg$lambda$3(Function0 function0, Modifier modifier, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, Function2 function2, int i, int i2, Composer composer, int i3) {
        m3064FloatingActionButtonbogVsAg(function0, modifier, mutableInteractionSource, shape, j, j2, floatingActionButtonElevation, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }
}
