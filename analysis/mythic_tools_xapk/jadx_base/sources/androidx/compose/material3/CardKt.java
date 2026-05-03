package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Card.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001aS\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001a\u001aw\u0010\u0019\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001b\u001a]\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0081\u0001\u0010\u001c\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u001d"}, d2 = {"Card", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/CardColors;", "elevation", "Landroidx/compose/material3/CardElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "onClick", "Lkotlin/Function0;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedCard", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedCard", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CardKt {
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Card(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevationM3361cardElevationaqJV_2Y;
        BorderStroke borderStroke2;
        final Modifier modifier3;
        final Shape shape3;
        final CardColors cardColors3;
        final CardElevation cardElevation2;
        final BorderStroke borderStroke3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape shape4;
        CardColors cardColors4;
        boolean z;
        Modifier modifier4;
        CardElevation cardElevation3;
        BorderStroke borderStroke4;
        Shape shape5;
        Composer composerStartRestartGroup = composer.startRestartGroup(1359693790);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Card)N(modifier,shape,colors,elevation,border,content)92@4165L57,94@4261L41,87@3953L349:Card.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                int i5 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i3 |= i5;
            } else {
                shape2 = shape;
            }
            i3 |= i5;
        } else {
            shape2 = shape;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                int i6 = composerStartRestartGroup.changed(cardColors2) ? 256 : 128;
                i3 |= i6;
            } else {
                cardColors2 = cardColors;
            }
            i3 |= i6;
        } else {
            cardColors2 = cardColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                cardElevationM3361cardElevationaqJV_2Y = cardElevation;
                int i7 = composerStartRestartGroup.changed(cardElevationM3361cardElevationaqJV_2Y) ? 2048 : 1024;
                i3 |= i7;
            } else {
                cardElevationM3361cardElevationaqJV_2Y = cardElevation;
            }
            i3 |= i7;
        } else {
            cardElevationM3361cardElevationaqJV_2Y = cardElevation;
        }
        int i8 = i2 & 16;
        if (i8 == 0) {
            if ((i & 24576) == 0) {
                borderStroke2 = borderStroke;
                i3 |= composerStartRestartGroup.changed(borderStroke2) ? 16384 : 8192;
            }
            if ((i2 & 32) == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                shape3 = shape2;
                cardColors3 = cardColors2;
                cardElevation2 = cardElevationM3361cardElevationaqJV_2Y;
                borderStroke3 = borderStroke;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "81@3742L5,82@3787L12,83@3845L15");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        shape4 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -113;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 4) != 0) {
                        cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        cardColors4 = cardColors2;
                    }
                    if ((i2 & 8) != 0) {
                        z = true;
                        cardElevationM3361cardElevationaqJV_2Y = CardDefaults.INSTANCE.m3361cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -7169;
                    } else {
                        z = true;
                    }
                    CardElevation cardElevation4 = cardElevationM3361cardElevationaqJV_2Y;
                    modifier4 = companion;
                    cardElevation3 = cardElevation4;
                    if (i8 != 0) {
                        shape5 = shape4;
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                        shape5 = shape4;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    cardElevation3 = cardElevationM3361cardElevationaqJV_2Y;
                    borderStroke4 = borderStroke2;
                    modifier4 = modifier2;
                    shape5 = shape2;
                    cardColors4 = cardColors2;
                    z = true;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1359693790, i3, -1, "androidx.compose.material3.Card (Card.kt:86)");
                }
                SurfaceKt.m4145SurfaceT9BRK9s(modifier4, shape5, cardColors4.m3353containerColorvNxB06k$material3(z), cardColors4.m3354contentColorvNxB06k$material3(z), 0.0f, cardElevation3.shadowElevation$material3(z, null, composerStartRestartGroup, ((i3 >> 3) & 896) | 54).getValue().m9128unboximpl(), borderStroke4, ComposableLambdaKt.rememberComposableLambda(-97109725, z, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.Card.1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        ComposerKt.sourceInformation(composer2, "C95@4271L25:Card.kt#uh7d8r");
                        if (!composer2.shouldExecute((i9 & 3) != 2, i9 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-97109725, i9, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:95)");
                        }
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion2);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                        function32.invoke(ColumnScopeInstance.INSTANCE, composer2, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (3670016 & (i3 << 6)), 16);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                cardColors3 = cardColors4;
                shape3 = shape5;
                borderStroke3 = borderStroke4;
                cardElevation2 = cardElevation3;
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.Card$lambda$0(modifier3, shape3, cardColors3, cardElevation2, borderStroke3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 24576;
        borderStroke2 = borderStroke;
        if ((i2 & 32) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Card(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        CardColors cardColors2;
        int i5;
        BorderStroke borderStroke2;
        int i6;
        Composer composer2;
        final CardElevation cardElevation2;
        final Modifier modifier3;
        final boolean z3;
        final Shape shape3;
        final CardColors cardColors3;
        final BorderStroke borderStroke3;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        CardColors cardColors4;
        Composer composer3;
        boolean z4;
        int i7;
        CardElevation cardElevationM3361cardElevationaqJV_2Y;
        Modifier modifier4;
        Shape shape4;
        BorderStroke borderStroke4;
        int i8;
        boolean z5;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        Composer composerStartRestartGroup = composer.startRestartGroup(2136075085);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Card)N(onClick,modifier,enabled,shape,colors,elevation,border,interactionSource,content)155@7038L43,158@7167L41,148@6786L422:Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
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
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i10 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i10;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i10;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColors2 = cardColors;
                        int i11 = composerStartRestartGroup.changed(cardColors2) ? 16384 : 8192;
                        i3 |= i11;
                    } else {
                        cardColors2 = cardColors;
                    }
                    i3 |= i11;
                } else {
                    cardColors2 = cardColors;
                }
                if ((196608 & i) == 0) {
                    i3 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(cardElevation)) ? 131072 : 65536;
                }
                i5 = i2 & 64;
                if (i5 == 0) {
                    if ((1572864 & i) == 0) {
                        borderStroke2 = borderStroke;
                        i3 |= composerStartRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                    }
                    if ((i2 & 256) == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                    }
                    if (composerStartRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        cardElevation2 = cardElevation;
                        modifier3 = modifier2;
                        z3 = z2;
                        shape3 = shape2;
                        cardColors3 = cardColors2;
                        borderStroke3 = borderStroke;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "139@6397L5,140@6442L12,141@6500L15");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 16) != 0) {
                                cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                cardColors4 = cardColors2;
                            }
                            if ((i2 & 32) != 0) {
                                z4 = true;
                                i7 = i6;
                                cardElevationM3361cardElevationaqJV_2Y = CardDefaults.INSTANCE.m3361cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                                composer3 = composerStartRestartGroup;
                                i3 &= -458753;
                            } else {
                                composer3 = composerStartRestartGroup;
                                z4 = true;
                                i7 = i6;
                                cardElevationM3361cardElevationaqJV_2Y = cardElevation;
                            }
                            BorderStroke borderStroke5 = i5 != 0 ? null : borderStroke;
                            if (i7 != 0) {
                                Modifier modifier5 = modifier2;
                                i8 = i3;
                                mutableInteractionSource3 = null;
                                modifier4 = modifier5;
                                shape4 = shape2;
                                borderStroke4 = borderStroke5;
                                z5 = z2;
                                composer3.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2136075085, i8, -1, "androidx.compose.material3.Card (Card.kt:145)");
                                }
                                if (mutableInteractionSource3 != null) {
                                    composer3.startReplaceGroup(1577885006);
                                    ComposerKt.sourceInformation(composer3, "147@6742L39");
                                    ComposerKt.sourceInformationMarkerStart(composer3, -226195148, "CC(remember):Card.kt#9igjgp");
                                    Object objRememberedValue = composer3.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer3.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceGroup();
                                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    composer3.startReplaceGroup(-226195799);
                                    composer3.endReplaceGroup();
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                }
                                composer2 = composer3;
                                SurfaceKt.m4148Surfaceo_FOJdg(function0, modifier4, z5, shape4, cardColors4.m3353containerColorvNxB06k$material3(z5), cardColors4.m3354contentColorvNxB06k$material3(z5), 0.0f, cardElevationM3361cardElevationaqJV_2Y.shadowElevation$material3(z5, mutableInteractionSource4, composer3, ((i8 >> 6) & 14) | ((i8 >> 9) & 896)).getValue().m9128unboximpl(), borderStroke4, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1347531112, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.Card.3
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i12) {
                                        ComposerKt.sourceInformation(composer4, "C159@7177L25:Card.kt#uh7d8r");
                                        if (!composer4.shouldExecute((i12 & 3) != 2, i12 & 1)) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1347531112, i12, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:159)");
                                        }
                                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                        ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, companion);
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
                                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer4, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                                        function32.invoke(ColumnScopeInstance.INSTANCE, composer4, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer3, 54), composer2, (i8 & 8190) | ((i8 << 6) & 234881024), 6, 64);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                cardColors3 = cardColors4;
                                cardElevation2 = cardElevationM3361cardElevationaqJV_2Y;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                modifier3 = modifier4;
                                z3 = z5;
                                shape3 = shape4;
                                borderStroke3 = borderStroke4;
                            } else {
                                modifier4 = modifier2;
                                shape4 = shape2;
                                borderStroke4 = borderStroke5;
                                i8 = i3;
                                z5 = z2;
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
                            shape4 = shape2;
                            cardColors4 = cardColors2;
                            z4 = true;
                            borderStroke4 = borderStroke2;
                            composer3 = composerStartRestartGroup;
                            modifier4 = modifier2;
                            z5 = z2;
                            cardElevationM3361cardElevationaqJV_2Y = cardElevation;
                            i8 = i3;
                        }
                        mutableInteractionSource3 = mutableInteractionSource;
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (mutableInteractionSource3 != null) {
                        }
                        composer2 = composer3;
                        SurfaceKt.m4148Surfaceo_FOJdg(function0, modifier4, z5, shape4, cardColors4.m3353containerColorvNxB06k$material3(z5), cardColors4.m3354contentColorvNxB06k$material3(z5), 0.0f, cardElevationM3361cardElevationaqJV_2Y.shadowElevation$material3(z5, mutableInteractionSource4, composer3, ((i8 >> 6) & 14) | ((i8 >> 9) & 896)).getValue().m9128unboximpl(), borderStroke4, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1347531112, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.Card.3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i12) {
                                ComposerKt.sourceInformation(composer4, "C159@7177L25:Card.kt#uh7d8r");
                                if (!composer4.shouldExecute((i12 & 3) != 2, i12 & 1)) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1347531112, i12, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:159)");
                                }
                                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                                Modifier.Companion companion = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, companion);
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
                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                                function32.invoke(ColumnScopeInstance.INSTANCE, composer4, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer2, (i8 & 8190) | ((i8 << 6) & 234881024), 6, 64);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        cardColors3 = cardColors4;
                        cardElevation2 = cardElevationM3361cardElevationaqJV_2Y;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        modifier3 = modifier4;
                        z3 = z5;
                        shape3 = shape4;
                        borderStroke3 = borderStroke4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CardKt.Card$lambda$2(function0, modifier3, z3, shape3, cardColors3, cardElevation2, borderStroke3, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 1572864;
                borderStroke2 = borderStroke;
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                if ((i2 & 256) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
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
            if (i5 == 0) {
            }
            borderStroke2 = borderStroke;
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            if ((i2 & 256) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
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
        if (i5 == 0) {
        }
        borderStroke2 = borderStroke;
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        if ((i2 & 256) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((38347923 & i3) == 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit Card$lambda$0(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, Function3 function3, int i, int i2, Composer composer, int i3) {
        Card(modifier, shape, cardColors, cardElevation, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Card$lambda$2(Function0 function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        Card(function0, modifier, z, shape, cardColors, cardElevation, borderStroke, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedCard(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape3;
        final CardColors cardColors3;
        final CardElevation cardElevation3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape elevatedShape;
        CardColors cardColorsElevatedCardColors;
        Composer composer3;
        Shape shape4;
        CardColors cardColors4;
        CardElevation cardElevationM3363elevatedCardElevationaqJV_2Y;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1464672362);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ElevatedCard)N(modifier,shape,colors,elevation,content)197@8874L169:Card.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                int i5 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i3 |= i5;
            } else {
                shape2 = shape;
            }
            i3 |= i5;
        } else {
            shape2 = shape;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                int i6 = composerStartRestartGroup.changed(cardColors2) ? 256 : 128;
                i3 |= i6;
            } else {
                cardColors2 = cardColors;
            }
            i3 |= i6;
        } else {
            cardColors2 = cardColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                cardElevation2 = cardElevation;
                int i7 = composerStartRestartGroup.changed(cardElevation2) ? 2048 : 1024;
                i3 |= i7;
            } else {
                cardElevation2 = cardElevation;
            }
            i3 |= i7;
        } else {
            cardElevation2 = cardElevation;
        }
        if ((i2 & 16) == 0) {
            if ((i & 24576) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                shape3 = shape2;
                cardColors3 = cardColors2;
                cardElevation3 = cardElevation2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "192@8673L13,193@8726L20,194@8792L23");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        i3 &= -113;
                    } else {
                        elevatedShape = shape2;
                    }
                    if ((i2 & 4) != 0) {
                        cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        cardColorsElevatedCardColors = cardColors2;
                    }
                    if ((i2 & 8) != 0) {
                        composer3 = composerStartRestartGroup;
                        i3 &= -7169;
                        modifier4 = companion;
                        shape4 = elevatedShape;
                        cardColors4 = cardColorsElevatedCardColors;
                        cardElevationM3363elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m3363elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                        shape4 = elevatedShape;
                        cardColors4 = cardColorsElevatedCardColors;
                        cardElevationM3363elevatedCardElevationaqJV_2Y = cardElevation2;
                        modifier4 = companion;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    shape4 = shape2;
                    cardColors4 = cardColors2;
                    cardElevationM3363elevatedCardElevationaqJV_2Y = cardElevation2;
                    composer3 = composerStartRestartGroup;
                    modifier4 = modifier2;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1464672362, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:197)");
                }
                Composer composer4 = composer3;
                Card(modifier4, shape4, cardColors4, cardElevationM3363elevatedCardElevationaqJV_2Y, null, function3, composer4, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
                composer2 = composer4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                shape3 = shape4;
                cardColors3 = cardColors4;
                cardElevation3 = cardElevationM3363elevatedCardElevationaqJV_2Y;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.ElevatedCard$lambda$3(modifier3, shape3, cardColors3, cardElevation3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 24576;
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedCard(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape elevatedShape;
        CardColors cardColors2;
        CardElevation cardElevationM3363elevatedCardElevationaqJV_2Y;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z3;
        final Shape shape2;
        final CardColors cardColors3;
        final CardElevation cardElevation2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        CardColors cardColorsElevatedCardColors;
        Composer composer3;
        CardColors cardColors4;
        boolean z4;
        Shape shape3;
        CardElevation cardElevation3;
        Composer composer4;
        MutableInteractionSource mutableInteractionSource4;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-129138571);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ElevatedCard)N(onClick,modifier,enabled,shape,colors,elevation,interactionSource,content)250@11337L270:Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else if ((i & 6) == 0) {
            function02 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
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
                        elevatedShape = shape;
                        int i7 = composerStartRestartGroup.changed(elevatedShape) ? 2048 : 1024;
                        i3 |= i7;
                    } else {
                        elevatedShape = shape;
                    }
                    i3 |= i7;
                } else {
                    elevatedShape = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColors2 = cardColors;
                        int i8 = composerStartRestartGroup.changed(cardColors2) ? 16384 : 8192;
                        i3 |= i8;
                    } else {
                        cardColors2 = cardColors;
                    }
                    i3 |= i8;
                } else {
                    cardColors2 = cardColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        cardElevationM3363elevatedCardElevationaqJV_2Y = cardElevation;
                        int i9 = composerStartRestartGroup.changed(cardElevationM3363elevatedCardElevationaqJV_2Y) ? 131072 : 65536;
                        i3 |= i9;
                    } else {
                        cardElevationM3363elevatedCardElevationaqJV_2Y = cardElevation;
                    }
                    i3 |= i9;
                } else {
                    cardElevationM3363elevatedCardElevationaqJV_2Y = cardElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else {
                    if ((i & 1572864) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                    }
                    if ((i2 & 128) != 0) {
                        if ((i & 12582912) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                        }
                        if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "244@11079L13,245@11132L20,246@11198L23");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i6 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 16) != 0) {
                                    cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                                    i3 &= -57345;
                                } else {
                                    cardColorsElevatedCardColors = cardColors2;
                                }
                                if ((i2 & 32) != 0) {
                                    composer3 = composerStartRestartGroup;
                                    i3 &= -458753;
                                    cardElevationM3363elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m3363elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                                } else {
                                    composer3 = composerStartRestartGroup;
                                }
                                if (i5 != 0) {
                                    cardColors4 = cardColorsElevatedCardColors;
                                    z4 = z2;
                                    shape3 = elevatedShape;
                                    cardElevation3 = cardElevationM3363elevatedCardElevationaqJV_2Y;
                                    composer4 = composer3;
                                    mutableInteractionSource4 = null;
                                } else {
                                    cardColors4 = cardColorsElevatedCardColors;
                                    z4 = z2;
                                    shape3 = elevatedShape;
                                    cardElevation3 = cardElevationM3363elevatedCardElevationaqJV_2Y;
                                    composer4 = composer3;
                                    mutableInteractionSource4 = mutableInteractionSource;
                                }
                                modifier4 = modifier2;
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
                                composer4 = composerStartRestartGroup;
                                shape3 = elevatedShape;
                                cardColors4 = cardColors2;
                                cardElevation3 = cardElevationM3363elevatedCardElevationaqJV_2Y;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                modifier4 = modifier2;
                                z4 = z2;
                            }
                            composer4.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-129138571, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:250)");
                            }
                            int i10 = i3 << 3;
                            Card(function02, modifier4, z4, shape3, cardColors4, cardElevation3, null, mutableInteractionSource4, function3, composer4, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i10) | (i10 & 234881024), 0);
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                            composer2 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource3 = mutableInteractionSource5;
                            modifier3 = modifier4;
                            z3 = z4;
                            shape2 = shape3;
                            cardColors3 = cardColors4;
                            cardElevation2 = cardElevation3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            z3 = z2;
                            shape2 = elevatedShape;
                            cardColors3 = cardColors2;
                            cardElevation2 = cardElevationM3363elevatedCardElevationaqJV_2Y;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CardKt.ElevatedCard$lambda$4(function0, modifier3, z3, shape2, cardColors3, cardElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 12582912;
                    if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 128) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
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
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
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
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit ElevatedCard$lambda$3(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, Function3 function3, int i, int i2, Composer composer, int i3) {
        ElevatedCard(modifier, shape, cardColors, cardElevation, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit ElevatedCard$lambda$4(Function0 function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        ElevatedCard(function0, modifier, z, shape, cardColors, cardElevation, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedCard(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevationM3365outlinedCardElevationaqJV_2Y;
        BorderStroke borderStroke2;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape3;
        final CardColors cardColors3;
        final CardElevation cardElevation2;
        final BorderStroke borderStroke3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape outlinedShape;
        CardColors cardColorsOutlinedCardColors;
        boolean z;
        int i4;
        Composer composer3;
        BorderStroke borderStroke4;
        Modifier modifier4;
        Shape shape4;
        CardColors cardColors4;
        CardElevation cardElevation3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1945643296);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedCard)N(modifier,shape,colors,elevation,border,content)298@13425L171:Card.kt#uh7d8r");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                int i6 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i3 |= i6;
            } else {
                shape2 = shape;
            }
            i3 |= i6;
        } else {
            shape2 = shape;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                int i7 = composerStartRestartGroup.changed(cardColors2) ? 256 : 128;
                i3 |= i7;
            } else {
                cardColors2 = cardColors;
            }
            i3 |= i7;
        } else {
            cardColors2 = cardColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                cardElevationM3365outlinedCardElevationaqJV_2Y = cardElevation;
                int i8 = composerStartRestartGroup.changed(cardElevationM3365outlinedCardElevationaqJV_2Y) ? 2048 : 1024;
                i3 |= i8;
            } else {
                cardElevationM3365outlinedCardElevationaqJV_2Y = cardElevation;
            }
            i3 |= i8;
        } else {
            cardElevationM3365outlinedCardElevationaqJV_2Y = cardElevation;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                borderStroke2 = borderStroke;
                int i9 = composerStartRestartGroup.changed(borderStroke2) ? 16384 : 8192;
                i3 |= i9;
            } else {
                borderStroke2 = borderStroke;
            }
            i3 |= i9;
        } else {
            borderStroke2 = borderStroke;
        }
        if ((i2 & 32) == 0) {
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                shape3 = shape2;
                cardColors3 = cardColors2;
                cardElevation2 = cardElevationM3365outlinedCardElevationaqJV_2Y;
                borderStroke3 = borderStroke;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "292@13162L13,293@13215L20,294@13281L23,295@13346L20");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        i3 &= -113;
                    } else {
                        outlinedShape = shape2;
                    }
                    if ((i2 & 4) != 0) {
                        cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        cardColorsOutlinedCardColors = cardColors2;
                    }
                    if ((i2 & 8) != 0) {
                        z = false;
                        composer3 = composerStartRestartGroup;
                        i3 &= -7169;
                        i4 = 1;
                        cardElevationM3365outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m3365outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                    } else {
                        z = false;
                        i4 = 1;
                        composer3 = composerStartRestartGroup;
                    }
                    if ((i2 & 16) != 0) {
                        BorderStroke borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z, composer3, 48, i4);
                        i3 &= -57345;
                        modifier4 = companion;
                        shape4 = outlinedShape;
                        cardColors4 = cardColorsOutlinedCardColors;
                        borderStroke4 = borderStrokeOutlinedCardBorder;
                    } else {
                        borderStroke4 = borderStroke;
                        modifier4 = companion;
                        shape4 = outlinedShape;
                        cardColors4 = cardColorsOutlinedCardColors;
                    }
                    cardElevation3 = cardElevationM3365outlinedCardElevationaqJV_2Y;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    shape4 = shape2;
                    cardColors4 = cardColors2;
                    cardElevation3 = cardElevationM3365outlinedCardElevationaqJV_2Y;
                    borderStroke4 = borderStroke2;
                    composer3 = composerStartRestartGroup;
                    modifier4 = modifier2;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1945643296, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:298)");
                }
                Composer composer4 = composer3;
                Card(modifier4, shape4, cardColors4, cardElevation3, borderStroke4, function3, composer4, 524286 & i3, 0);
                composer2 = composer4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                shape3 = shape4;
                cardColors3 = cardColors4;
                cardElevation2 = cardElevation3;
                borderStroke3 = borderStroke4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.OutlinedCard$lambda$5(modifier3, shape3, cardColors3, cardElevation2, borderStroke3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedCard(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape outlinedShape;
        CardColors cardColorsOutlinedCardColors;
        CardElevation cardElevationM3365outlinedCardElevationaqJV_2Y;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z3;
        final Shape shape2;
        final CardColors cardColors2;
        final CardElevation cardElevation2;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composer3;
        int i6;
        int i7;
        BorderStroke borderStrokeOutlinedCardBorder;
        MutableInteractionSource mutableInteractionSource4;
        BorderStroke borderStroke3;
        Modifier modifier4;
        boolean z4;
        Shape shape3;
        CardColors cardColors3;
        CardElevation cardElevation3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1401605899);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedCard)N(onClick,modifier,enabled,shape,colors,elevation,border,interactionSource,content)353@16051L272:Card.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
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
                        outlinedShape = shape;
                        int i9 = composerStartRestartGroup.changed(outlinedShape) ? 2048 : 1024;
                        i3 |= i9;
                    } else {
                        outlinedShape = shape;
                    }
                    i3 |= i9;
                } else {
                    outlinedShape = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColorsOutlinedCardColors = cardColors;
                        int i10 = composerStartRestartGroup.changed(cardColorsOutlinedCardColors) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        cardColorsOutlinedCardColors = cardColors;
                    }
                    i3 |= i10;
                } else {
                    cardColorsOutlinedCardColors = cardColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        cardElevationM3365outlinedCardElevationaqJV_2Y = cardElevation;
                        int i11 = composerStartRestartGroup.changed(cardElevationM3365outlinedCardElevationaqJV_2Y) ? 131072 : 65536;
                        i3 |= i11;
                    } else {
                        cardElevationM3365outlinedCardElevationaqJV_2Y = cardElevation;
                    }
                    i3 |= i11;
                } else {
                    cardElevationM3365outlinedCardElevationaqJV_2Y = cardElevation;
                }
                if ((1572864 & i) == 0) {
                    i3 |= ((i2 & 64) == 0 && composerStartRestartGroup.changed(borderStroke)) ? 1048576 : 524288;
                }
                i5 = i2 & 128;
                if (i5 != 0) {
                    i3 |= 12582912;
                } else {
                    if ((12582912 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 8388608 : 4194304;
                    }
                    if ((i2 & 256) != 0) {
                        if ((i & 100663296) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "346@15724L13,347@15777L20,348@15843L23,349@15908L27");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i8 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i6 = 0;
                                    i7 = i5;
                                    composer3 = composerStartRestartGroup;
                                    i3 &= -458753;
                                    cardElevationM3365outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m3365outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                                } else {
                                    composer3 = composerStartRestartGroup;
                                    i6 = 0;
                                    i7 = i5;
                                }
                                if ((i2 & 64) != 0) {
                                    borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, i6);
                                    i3 &= -3670017;
                                } else {
                                    borderStrokeOutlinedCardBorder = borderStroke;
                                }
                                if (i7 != 0) {
                                    borderStroke3 = borderStrokeOutlinedCardBorder;
                                    mutableInteractionSource4 = null;
                                } else {
                                    mutableInteractionSource4 = mutableInteractionSource;
                                    borderStroke3 = borderStrokeOutlinedCardBorder;
                                }
                                modifier4 = modifier2;
                                z4 = z2;
                                shape3 = outlinedShape;
                                cardColors3 = cardColorsOutlinedCardColors;
                                cardElevation3 = cardElevationM3365outlinedCardElevationaqJV_2Y;
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
                                borderStroke3 = borderStroke;
                                composer3 = composerStartRestartGroup;
                                modifier4 = modifier2;
                                z4 = z2;
                                cardColors3 = cardColorsOutlinedCardColors;
                                cardElevation3 = cardElevationM3365outlinedCardElevationaqJV_2Y;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                shape3 = outlinedShape;
                            }
                            composer3.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1401605899, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:353)");
                            }
                            composer2 = composer3;
                            Card(function0, modifier4, z4, shape3, cardColors3, cardElevation3, borderStroke3, mutableInteractionSource4, function3, composer2, i3 & 268435454, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z3 = z4;
                            shape2 = shape3;
                            cardColors2 = cardColors3;
                            cardElevation2 = cardElevation3;
                            borderStroke2 = borderStroke3;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            z3 = z2;
                            shape2 = outlinedShape;
                            cardColors2 = cardColorsOutlinedCardColors;
                            cardElevation2 = cardElevationM3365outlinedCardElevationaqJV_2Y;
                            borderStroke2 = borderStroke;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CardKt.OutlinedCard$lambda$6(function0, modifier3, z3, shape2, cardColors2, cardElevation2, borderStroke2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 100663296;
                    if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 256) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
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
            if ((1572864 & i) == 0) {
            }
            i5 = i2 & 128;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 256) != 0) {
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
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        i5 = i2 & 128;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 256) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit OutlinedCard$lambda$5(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, Function3 function3, int i, int i2, Composer composer, int i3) {
        OutlinedCard(modifier, shape, cardColors, cardElevation, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit OutlinedCard$lambda$6(Function0 function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        OutlinedCard(function0, modifier, z, shape, cardColors, cardElevation, borderStroke, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }
}
