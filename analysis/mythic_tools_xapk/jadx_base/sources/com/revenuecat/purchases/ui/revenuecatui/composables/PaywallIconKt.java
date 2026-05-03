package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallIcon.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"PaywallIcon", "", "icon", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/PaywallIconName;", "modifier", "Landroidx/compose/ui/Modifier;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "PaywallIcon-FNF3uiM", "(Lcom/revenuecat/purchases/ui/revenuecatui/composables/PaywallIconName;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "PaywallIconPreview", "(Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallIconKt {
    /* JADX INFO: renamed from: PaywallIcon-FNF3uiM, reason: not valid java name */
    public static final void m10655PaywallIconFNF3uiM(final PaywallIconName icon, Modifier modifier, final long j, Composer composer, final int i, final int i2) {
        int i3;
        long j2;
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer composerStartRestartGroup = composer.startRestartGroup(269660957);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallIcon)P(!,2:c#ui.graphics.Color)29@1034L37,24@895L244:PaywallIcon.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(icon) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
            j2 = j;
        } else {
            j2 = j;
            if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
            }
        }
        if ((i3 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(269660957, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIcon (PaywallIcon.kt:23)");
            }
            IconKt.m3735Iconww6aTOc(PainterResources_androidKt.painterResource(icon.drawable$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 0), (String) null, SizeKt.fillMaxSize$default(AspectRatioKt.aspectRatio$default(Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, 1, null).then(modifier), j2, composerStartRestartGroup, ((i3 << 3) & 7168) | 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconKt$PaywallIcon$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    PaywallIconKt.m10655PaywallIconFNF3uiM(icon, modifier2, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final void PaywallIconPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1356053803);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallIconPreview)153@4483L219,153@4429L273:PaywallIcon.kt#51odh9");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1356053803, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconPreview (PaywallIcon.kt:150)");
            }
            final PaywallIconName[] paywallIconNameArrValues = PaywallIconName.values();
            GridCells.Adaptive adaptive = new GridCells.Adaptive(Dp.m9114constructorimpl(40.0f), null);
            composerStartRestartGroup.startReplaceGroup(914039657);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PaywallIcon.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(paywallIconNameArrValues);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<LazyGridScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconKt$PaywallIconPreview$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LazyGridScope lazyGridScope) {
                        invoke2(lazyGridScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LazyGridScope LazyVerticalGrid) {
                        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
                        int length = paywallIconNameArrValues.length;
                        final PaywallIconName[] paywallIconNameArr = paywallIconNameArrValues;
                        LazyGridScope.items$default(LazyVerticalGrid, length, null, null, null, ComposableLambdaKt.composableLambdaInstance(-320278688, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconKt$PaywallIconPreview$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer2, Integer num2) {
                                invoke(lazyGridItemScope, num.intValue(), composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LazyGridItemScope items, int i2, Composer composer2, int i3) {
                                int i4;
                                Intrinsics.checkNotNullParameter(items, "$this$items");
                                ComposerKt.sourceInformation(composer2, "C155@4525L161:PaywallIcon.kt#51odh9");
                                if ((i3 & 48) == 0) {
                                    i4 = i3 | (composer2.changed(i2) ? 32 : 16);
                                } else {
                                    i4 = i3;
                                }
                                if ((i4 & 145) == 144 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-320278688, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconPreview.<anonymous>.<anonymous>.<anonymous> (PaywallIcon.kt:155)");
                                }
                                Modifier modifierM1495borderxT4_qwU$default = BorderKt.m1495borderxT4_qwU$default(BackgroundKt.m1483backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m6362getWhite0d7_KjU(), null, 2, null), Dp.m9114constructorimpl(1.0f), Color.INSTANCE.m6351getBlack0d7_KjU(), null, 4, null);
                                PaywallIconName[] paywallIconNameArr2 = paywallIconNameArr;
                                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1495borderxT4_qwU$default);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 787960675, "C156@4618L54:PaywallIcon.kt#51odh9");
                                PaywallIconKt.m10655PaywallIconFNF3uiM(paywallIconNameArr2[i2], null, Color.INSTANCE.m6351getBlack0d7_KjU(), composer2, 384, 2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 14, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            LazyGridDslKt.LazyVerticalGrid(adaptive, null, null, null, false, null, null, null, false, (Function1) objRememberedValue, composerStartRestartGroup, 0, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PaywallIconKt.PaywallIconPreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    PaywallIconKt.PaywallIconPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
