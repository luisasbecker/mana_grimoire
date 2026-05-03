package com.revenuecat.purchases.ui.revenuecatui;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: PaywallFooter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001a<\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"OriginalTemplatePaywallFooter", "", "options", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "condensed", "", "mainContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "Landroidx/compose/runtime/Composable;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "PaywallFooter", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallFooterKt {
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OriginalTemplatePaywallFooter(final PaywallOptions options, boolean z, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        final boolean z2;
        int i4;
        Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(options, "options");
        Composer composerStartRestartGroup = composer.startRestartGroup(-626652099);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OriginalTemplatePaywallFooter)P(2)55@2476L185:PaywallFooter.kt#ao8ymz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(options) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function32 = function3;
                    i3 |= composerStartRestartGroup.changedInstance(function32) ? 256 : 128;
                }
                if ((i3 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                } else {
                    if (i5 != 0) {
                        z2 = false;
                    }
                    if (i4 != 0) {
                        function32 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-626652099, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.OriginalTemplatePaywallFooter (PaywallFooter.kt:54)");
                    }
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1974808778, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallFooterKt$OriginalTemplatePaywallFooter$paywallComposable$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i6) {
                            ComposerKt.sourceInformation(composer2, "C56@2486L169:PaywallFooter.kt#ao8ymz");
                            if ((i6 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1974808778, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.OriginalTemplatePaywallFooter.<anonymous> (PaywallFooter.kt:56)");
                            }
                            PaywallKt.Paywall(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(options, null, false, null, null, null, PaywallMode.INSTANCE.footerMode(z2), null, null, null, Videoio.CAP_PROP_XI_GAMMAC, null), composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54);
                    if (function32 != null) {
                        composerStartRestartGroup.startReplaceGroup(-576046574);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "64@2701L103");
                        Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, 3, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWrapContentHeight$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -740843816, "C65@2775L19:PaywallFooter.kt#ao8ymz");
                        composableLambdaRememberComposableLambda.invoke(composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-575904377);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "68@2826L690");
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(Dp.m9114constructorimpl(-UIConstant.INSTANCE.m10450getDefaultCornerRadiusD9Ej5fM()));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
                        Updater.m5603setimpl(composerM5595constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -740364308, "C75@3251L223,82@3487L19:PaywallFooter.kt#ao8ymz");
                        Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor3);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1237983561, "C80@3393L67:PaywallFooter.kt#ao8ymz");
                        function32.invoke(PaddingKt.m2034PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, UIConstant.INSTANCE.m10450getDefaultCornerRadiusD9Ej5fM(), 7, null), composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 112));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composableLambdaRememberComposableLambda.invoke(composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33 = function32;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final boolean z3 = z2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallFooterKt.OriginalTemplatePaywallFooter.3
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

                        public final void invoke(Composer composer2, int i6) {
                            PaywallFooterKt.OriginalTemplatePaywallFooter(options, z3, function33, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 384;
            function32 = function3;
            if ((i3 & 147) == 146) {
                if (i5 != 0) {
                }
                if (i4 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1974808778, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallFooterKt$OriginalTemplatePaywallFooter$paywallComposable$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        ComposerKt.sourceInformation(composer2, "C56@2486L169:PaywallFooter.kt#ao8ymz");
                        if ((i6 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1974808778, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.OriginalTemplatePaywallFooter.<anonymous> (PaywallFooter.kt:56)");
                        }
                        PaywallKt.Paywall(PaywallOptions.copy$revenuecatui_defaultsBc8Release$default(options, null, false, null, null, null, PaywallMode.INSTANCE.footerMode(z2), null, null, null, Videoio.CAP_PROP_XI_GAMMAC, null), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54);
                if (function32 != null) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function332 = function32;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        z2 = z;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        function32 = function3;
        if ((i3 & 147) == 146) {
        }
        final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3322 = function32;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    @Deprecated(message = "Use OriginalTemplatePaywallFooter instead", replaceWith = @ReplaceWith(expression = "OriginalTemplatePaywallFooter(options, condensed, mainContent)", imports = {}))
    public static final void PaywallFooter(final PaywallOptions options, boolean z, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Composer composer2;
        final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32;
        final boolean z2;
        Intrinsics.checkNotNullParameter(options, "options");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1966106382);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallFooter)P(2)35@1512L62:PaywallFooter.kt#ao8ymz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(options) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            z2 = z;
            composer2 = composerStartRestartGroup;
            function32 = function3;
        } else {
            boolean z3 = i4 != 0 ? false : z;
            Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33 = i5 != 0 ? null : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1966106382, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallFooter (PaywallFooter.kt:34)");
            }
            int i6 = i3 & 1022;
            Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function34 = function33;
            boolean z4 = z3;
            OriginalTemplatePaywallFooter(options, z4, function34, composerStartRestartGroup, i6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composerStartRestartGroup;
            function32 = function34;
            z2 = z4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallFooterKt.PaywallFooter.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i7) {
                    PaywallFooterKt.PaywallFooter(options, z2, function32, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
