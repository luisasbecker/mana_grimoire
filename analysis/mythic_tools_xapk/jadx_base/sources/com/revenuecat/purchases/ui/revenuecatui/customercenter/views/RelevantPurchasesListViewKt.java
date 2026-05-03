package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.profileinstaller.ProfileVerifier;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterUIConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RelevantPurchasesListView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a?\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\rH\u0003¢\u0006\u0002\u0010\u000e\u001a\u0089\u0001\u0010\u000f\u001a\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0001¢\u0006\u0002\u0010\u001f\u001a\r\u0010 \u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010!\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\"\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010#\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010$\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002¨\u0006%"}, d2 = {"NoActiveSubscriptionsViewNoDescription_Preview", "", "(Landroidx/compose/runtime/Composer;I)V", "NoActiveSubscriptionsViewPreview", "PurchaseListSection", "purchases", "", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "totalPurchaseCount", "", "onPurchaseSelect", "Lkotlin/Function1;", "(Ljava/util/Set;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "RelevantPurchasesListView", "supportedPaths", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "contactEmail", "", "virtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "appearance", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;", "supportTickets", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;", "onAction", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/actions/CustomerCenterAction;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/List;Ljava/lang/String;Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Ljava/util/List;Landroidx/compose/runtime/Composer;II)V", "RelevantPurchasesListViewPreview", "RelevantPurchasesListViewWithLifetimePurchasePreview", "RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview", "RelevantPurchasesListViewWithMultiplePurchasesPreview", "RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RelevantPurchasesListViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void NoActiveSubscriptionsViewNoDescription_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-611911312);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoActiveSubscriptionsViewNoDescription_Preview)254@10496L522,254@10469L549:RelevantPurchasesListView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-611911312, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveSubscriptionsViewNoDescription_Preview (RelevantPurchasesListView.kt:250)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screenCopy$default = CustomerCenterConfigData.Screen.copy$default(screen, null, null, null, null, null, 27, null);
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(1539230767, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.NoActiveSubscriptionsViewNoDescription_Preview.1
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
                    ComposerKt.sourceInformation(composer2, "C255@10506L506:RelevantPurchasesListView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1539230767, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveSubscriptionsViewNoDescription_Preview.<anonymous> (RelevantPurchasesListView.kt:255)");
                    }
                    CustomerCenterConfigData.Screen screen2 = screenCopy$default;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
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
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1404524168, "C256@10527L475:RelevantPurchasesListView.kt#870w7w");
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(screen2.getPaths(), "support@revenuecat.com", null, customerCenterConfigData.getAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$NoActiveSubscriptionsViewNoDescription_Preview$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PurchaseInformation purchaseInformation) {
                            invoke2(purchaseInformation);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$NoActiveSubscriptionsViewNoDescription_Preview$1$1$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                            invoke2(customerCenterAction);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, null, CollectionsKt.emptyList(), composer2, 819462576, 256);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.NoActiveSubscriptionsViewNoDescription_Preview.2
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
                    RelevantPurchasesListViewKt.NoActiveSubscriptionsViewNoDescription_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NoActiveSubscriptionsViewPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1881756972);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoActiveSubscriptionsViewPreview)181@7463L522,181@7436L549:RelevantPurchasesListView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1881756972, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveSubscriptionsViewPreview (RelevantPurchasesListView.kt:178)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(329820115, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.NoActiveSubscriptionsViewPreview.1
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
                    ComposerKt.sourceInformation(composer2, "C182@7473L506:RelevantPurchasesListView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(329820115, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveSubscriptionsViewPreview.<anonymous> (RelevantPurchasesListView.kt:182)");
                    }
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
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
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -395343420, "C183@7494L475:RelevantPurchasesListView.kt#870w7w");
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(screen3.getPaths(), "support@revenuecat.com", null, customerCenterConfigData.getAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$NoActiveSubscriptionsViewPreview$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PurchaseInformation purchaseInformation) {
                            invoke2(purchaseInformation);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$NoActiveSubscriptionsViewPreview$1$1$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                            invoke2(customerCenterAction);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, null, CollectionsKt.emptyList(), composer2, 819462576, 256);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.NoActiveSubscriptionsViewPreview.2
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
                    RelevantPurchasesListViewKt.NoActiveSubscriptionsViewPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PurchaseListSection(final Set<PurchaseInformation> set, final CustomerCenterConfigData.Localization localization, final int i, final Function1<? super PurchaseInformation, Unit> function1, Composer composer, final int i2) {
        char c;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1017442857);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PurchaseListSection)P(2!1,3)*131@5530L568:RelevantPurchasesListView.kt#870w7w");
        int i3 = (i2 & 6) == 0 ? (composerStartRestartGroup.changedInstance(set) ? 4 : 2) | i2 : i2;
        CustomerCenterConfigData.Localization localization2 = localization;
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(localization2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1017442857, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseListSection (RelevantPurchasesListView.kt:118)");
            }
            if (!set.isEmpty()) {
                int i4 = 0;
                for (Object obj : set) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    final PurchaseInformation purchaseInformation = (PurchaseInformation) obj;
                    composerStartRestartGroup.startReplaceGroup(-980519695);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "122@5151L78");
                    if (i4 > 0) {
                        SpacerKt.Spacer(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, CustomerCenterConstants.Layout.INSTANCE.m10699getITEMS_SPACINGD9Ej5fM()), composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ButtonPosition buttonPosition = set.size() == 1 ? ButtonPosition.SINGLE : i4 == 0 ? ButtonPosition.FIRST : i4 == set.size() - 1 ? ButtonPosition.LAST : ButtonPosition.MIDDLE;
                    Function0 function0 = null;
                    Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), CustomerCenterConstants.Layout.INSTANCE.m10698getHORIZONTAL_PADDINGD9Ej5fM(), 0.0f, 2, null);
                    boolean z = i == 1;
                    composerStartRestartGroup.startReplaceGroup(-980493404);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "140@5989L26");
                    if (i > 1) {
                        composerStartRestartGroup.startReplaceGroup(-917850771);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):RelevantPurchasesListView.kt#9igjgp");
                        boolean zChangedInstance = ((i3 & 7168) == 2048) | composerStartRestartGroup.changedInstance(purchaseInformation);
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$PurchaseListSection$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(purchaseInformation);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        function0 = (Function0) objRememberedValue;
                        c = 2048;
                    } else {
                        c = 2048;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    PurchaseInformationCardViewKt.PurchaseInformationCardView(purchaseInformation, localization2, modifierM2039paddingVpY3zN4$default, buttonPosition, z, function0, composerStartRestartGroup, (i3 & 112) | 384, 0);
                    localization2 = localization;
                    i4 = i5;
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.PurchaseListSection.2
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
                    RelevantPurchasesListViewKt.PurchaseListSection(set, localization, i, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RelevantPurchasesListView(final List<CustomerCenterConfigData.HelpPath> supportedPaths, final String str, final VirtualCurrencies virtualCurrencies, final CustomerCenterConfigData.Appearance appearance, final CustomerCenterConfigData.Localization localization, final CustomerCenterConfigData.Support.SupportTickets supportTickets, final Function1<? super PurchaseInformation, Unit> onPurchaseSelect, final Function1<? super CustomerCenterAction, Unit> onAction, Modifier modifier, List<PurchaseInformation> list, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        List<PurchaseInformation> list2;
        int currentCompositeKeyHash;
        Modifier modifier3;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Set set;
        int i5;
        int i6;
        PurchaseInformation purchaseInformation;
        PurchaseInformation purchaseInformation2;
        int i7;
        Composer composer2;
        final List<PurchaseInformation> list3;
        int i8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(supportedPaths, "supportedPaths");
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(supportTickets, "supportTickets");
        Intrinsics.checkNotNullParameter(onPurchaseSelect, "onPurchaseSelect");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(898239225);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RelevantPurchasesListView)P(8,1,9!2,7,5,4)44@2254L21,41@2163L2626:RelevantPurchasesListView.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(supportedPaths) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(virtualCurrencies) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(appearance) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(localization) ? 16384 : 8192;
        }
        if ((i2 & 32) != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(supportTickets) ? 131072 : 65536;
        }
        if ((i2 & 64) != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onPurchaseSelect) ? 1048576 : 524288;
        }
        if ((i2 & 128) != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onAction) ? 8388608 : 4194304;
        }
        int i9 = i2 & 256;
        if (i9 == 0) {
            if ((100663296 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 67108864 : 33554432;
            }
            i4 = i2 & 512;
            if (i4 == 0) {
                i3 |= 805306368;
                list2 = list;
            } else {
                list2 = list;
                if ((i & 805306368) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(list2) ? 536870912 : 268435456;
                }
            }
            if ((i3 & 306783379) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i9 == 0 ? Modifier.INSTANCE : modifier2;
                List<PurchaseInformation> listEmptyList = i4 == 0 ? CollectionsKt.emptyList() : list2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(898239225, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListView (RelevantPurchasesListView.kt:40)");
                }
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
                Alignment.Horizontal start = Alignment.INSTANCE.getStart();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                modifier3 = companion;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(constructor);
                }
                composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 705286324, "C50@2484L208,96@4241L542:RelevantPurchasesListView.kt#870w7w");
                List<PurchaseInformation> list4 = listEmptyList;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list4) {
                    if (((PurchaseInformation) obj).isSubscription()) {
                        arrayList.add(obj);
                    }
                }
                Set set2 = CollectionsKt.toSet(arrayList);
                set = CollectionsKt.toSet(CollectionsKt.minus((Iterable) list4, (Iterable) set2));
                Composer composer3 = composerStartRestartGroup;
                int i10 = (i3 >> 9) & 7280;
                int i11 = i3;
                PurchaseListSection(set2, localization, listEmptyList.size(), onPurchaseSelect, composer3, i10);
                composer3.startReplaceGroup(-669975493);
                ComposerKt.sourceInformation(composer3, "58@2751L80,72@3347L231");
                if (set.isEmpty()) {
                    SpacerKt.Spacer(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, CustomerCenterConstants.Layout.INSTANCE.m10700getSECTION_SPACINGD9Ej5fM()), composer3, 6);
                    composer3.startReplaceGroup(-669971315);
                    ComposerKt.sourceInformation(composer3, "63@2983L10,64@3048L11,61@2895L424");
                    if (set2.isEmpty()) {
                        purchaseInformation = null;
                        i8 = 2;
                    } else {
                        purchaseInformation = null;
                        i8 = 2;
                        TextKt.m4286Text4IGK_g("Purchases", PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), 0.0f, 0.0f, CustomerCenterConstants.Layout.INSTANCE.m10701getSECTION_TITLE_BOTTOM_PADDINGD9Ej5fM(), 6, null), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleLarge(), composer3, 54, 0, 65528);
                    }
                    composer3.endReplaceGroup();
                    i6 = i8;
                    i5 = 6;
                    PurchaseListSection(set, localization, listEmptyList.size(), onPurchaseSelect, composer3, i10);
                } else {
                    i5 = 6;
                    i6 = 2;
                    purchaseInformation = null;
                }
                composer3.endReplaceGroup();
                composer3.startReplaceGroup(-669946485);
                ComposerKt.sourceInformation(composer3, "");
                if (virtualCurrencies != null) {
                    purchaseInformation2 = purchaseInformation;
                    i7 = 1;
                } else {
                    composer3.startReplaceGroup(-669945937);
                    ComposerKt.sourceInformation(composer3, "82@3693L80,84@3791L416");
                    if (virtualCurrencies.getAll().isEmpty()) {
                        purchaseInformation2 = purchaseInformation;
                        i7 = 1;
                    } else {
                        SpacerKt.Spacer(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, CustomerCenterConstants.Layout.INSTANCE.m10700getSECTION_SPACINGD9Ej5fM()), composer3, i5);
                        Modifier modifierM2039paddingVpY3zN4$default = PaddingKt.m2039paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, purchaseInformation), CustomerCenterConstants.Layout.INSTANCE.m10698getHORIZONTAL_PADDINGD9Ej5fM(), 0.0f, i6, purchaseInformation);
                        int i12 = i11 >> 6;
                        int i13 = (i12 & 896) | (i12 & 14) | 24576 | (i12 & 112) | ((i11 >> 12) & 7168);
                        purchaseInformation2 = purchaseInformation;
                        i7 = 1;
                        VirtualCurrenciesListViewKt.VirtualCurrenciesListView(virtualCurrencies, appearance, localization, onAction, modifierM2039paddingVpY3zN4$default, composer3, i13, 0);
                        composer3 = composer3;
                    }
                    composer3.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                composer3.endReplaceGroup();
                Composer composer4 = composer3;
                ManageSubscriptionsButtonsViewKt.ManageSubscriptionsButtonsView(listEmptyList.size() != i7 ? (PurchaseInformation) CollectionsKt.first((List) listEmptyList) : purchaseInformation2, supportedPaths, localization, str, supportTickets.allowsActiveCustomers(), (supportTickets.getAllowCreation() || !supportTickets.allowsActiveCustomers()) ? 0 : i7, onAction, composer4, ((i11 << 3) & 112) | ((i11 >> 6) & 896) | ((i11 << 6) & 7168) | ((i11 >> 3) & 3670016), 0);
                composer2 = composer4;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                list3 = listEmptyList;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
                list3 = list2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final Modifier modifier4 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListView.2
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

                    public final void invoke(Composer composer5, int i14) {
                        RelevantPurchasesListViewKt.RelevantPurchasesListView(supportedPaths, str, virtualCurrencies, appearance, localization, supportTickets, onPurchaseSelect, onAction, modifier4, list3, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 100663296;
        modifier2 = modifier;
        i4 = i2 & 512;
        if (i4 == 0) {
        }
        if ((i3 & 306783379) == 306783378) {
            if (i9 == 0) {
            }
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier modifierVerticalScroll$default2 = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
            Alignment.Horizontal start2 = Alignment.INSTANCE.getStart();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            modifier3 = companion;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5595constructorimpl.getInserting()) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 705286324, "C50@2484L208,96@4241L542:RelevantPurchasesListView.kt#870w7w");
                List<PurchaseInformation> list42 = listEmptyList;
                ArrayList arrayList2 = new ArrayList();
                while (r2.hasNext()) {
                }
                Set set22 = CollectionsKt.toSet(arrayList2);
                set = CollectionsKt.toSet(CollectionsKt.minus((Iterable) list42, (Iterable) set22));
                Composer composer32 = composerStartRestartGroup;
                int i102 = (i3 >> 9) & 7280;
                int i112 = i3;
                PurchaseListSection(set22, localization, listEmptyList.size(), onPurchaseSelect, composer32, i102);
                composer32.startReplaceGroup(-669975493);
                ComposerKt.sourceInformation(composer32, "58@2751L80,72@3347L231");
                if (set.isEmpty()) {
                }
                composer32.endReplaceGroup();
                composer32.startReplaceGroup(-669946485);
                ComposerKt.sourceInformation(composer32, "");
                if (virtualCurrencies != null) {
                }
                composer32.endReplaceGroup();
                if (listEmptyList.size() != i7) {
                }
                if (supportTickets.getAllowCreation()) {
                    Composer composer42 = composer32;
                    ManageSubscriptionsButtonsViewKt.ManageSubscriptionsButtonsView(listEmptyList.size() != i7 ? (PurchaseInformation) CollectionsKt.first((List) listEmptyList) : purchaseInformation2, supportedPaths, localization, str, supportTickets.allowsActiveCustomers(), (supportTickets.getAllowCreation() || !supportTickets.allowsActiveCustomers()) ? 0 : i7, onAction, composer42, ((i112 << 3) & 112) | ((i112 >> 6) & 896) | ((i112 << 6) & 7168) | ((i112 >> 3) & 3670016), 0);
                    composer2 = composer42;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    list3 = listEmptyList;
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RelevantPurchasesListViewPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-29475920);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RelevantPurchasesListViewPreview)159@6510L616,159@6483L643:RelevantPurchasesListView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-29475920, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewPreview (RelevantPurchasesListView.kt:156)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(-2112866129, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewPreview.1
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
                    ComposerKt.sourceInformation(composer2, "C160@6520L600:RelevantPurchasesListView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2112866129, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewPreview.<anonymous> (RelevantPurchasesListView.kt:160)");
                    }
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, 1860506378, "C161@6573L537:RelevantPurchasesListView.kt#870w7w");
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(screen3.getPaths(), "support@revenuecat.com", null, customerCenterConfigData.getAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewPreview$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PurchaseInformation purchaseInformation) {
                            invoke2(purchaseInformation);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewPreview$1$1$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                            invoke2(customerCenterAction);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, null, CollectionsKt.listOf(CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationMonthlyRenewing()), composer2, 14156208, 256);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewPreview.2
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
                    RelevantPurchasesListViewKt.RelevantPurchasesListViewPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RelevantPurchasesListViewWithLifetimePurchasePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1781255744);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RelevantPurchasesListViewWithLifetimePurchasePreview)203@8345L616,203@8318L643:RelevantPurchasesListView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1781255744, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithLifetimePurchasePreview (RelevantPurchasesListView.kt:200)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(623687999, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithLifetimePurchasePreview.1
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
                    ComposerKt.sourceInformation(composer2, "C204@8355L600:RelevantPurchasesListView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(623687999, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithLifetimePurchasePreview.<anonymous> (RelevantPurchasesListView.kt:204)");
                    }
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
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
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -196708486, "C205@8376L569:RelevantPurchasesListView.kt#870w7w");
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(screen3.getPaths(), "support@revenuecat.com", null, customerCenterConfigData.getAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithLifetimePurchasePreview$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PurchaseInformation purchaseInformation) {
                            invoke2(purchaseInformation);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithLifetimePurchasePreview$1$1$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                            invoke2(customerCenterAction);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, null, CollectionsKt.listOf(CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationLifetime()), composer2, 14156208, 256);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithLifetimePurchasePreview.2
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
                    RelevantPurchasesListViewKt.RelevantPurchasesListViewWithLifetimePurchasePreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(531462629);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview)311@12579L747,311@12552L774:RelevantPurchasesListView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(531462629, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview (RelevantPurchasesListView.kt:308)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(1494673350, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview.1
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
                    ComposerKt.sourceInformation(composer2, "C312@12589L731:RelevantPurchasesListView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1494673350, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview.<anonymous> (RelevantPurchasesListView.kt:312)");
                    }
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
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
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -275583718, "C313@12610L700:RelevantPurchasesListView.kt#870w7w");
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(screen3.getPaths(), "support@revenuecat.com", CustomerCenterConfigTestData.INSTANCE.getFiveVirtualCurrencies(), customerCenterConfigData.getAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PurchaseInformation purchaseInformation) {
                            invoke2(purchaseInformation);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview$1$1$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                            invoke2(customerCenterAction);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, null, CollectionsKt.listOf((Object[]) new PurchaseInformation[]{CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationMonthlyRenewing(), CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationLifetime()}), composer2, 14155824, 256);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview.2
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
                    RelevantPurchasesListViewKt.RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RelevantPurchasesListViewWithMultiplePurchasesPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(666289000);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RelevantPurchasesListViewWithMultiplePurchasesPreview)281@11435L707,281@11408L734:RelevantPurchasesListView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(666289000, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithMultiplePurchasesPreview (RelevantPurchasesListView.kt:278)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(-2089866295, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithMultiplePurchasesPreview.1
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
                    ComposerKt.sourceInformation(composer2, "C282@11445L691:RelevantPurchasesListView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2089866295, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithMultiplePurchasesPreview.<anonymous> (RelevantPurchasesListView.kt:282)");
                    }
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
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
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 214690335, "C283@11466L660:RelevantPurchasesListView.kt#870w7w");
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(screen3.getPaths(), "support@revenuecat.com", null, customerCenterConfigData.getAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithMultiplePurchasesPreview$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PurchaseInformation purchaseInformation) {
                            invoke2(purchaseInformation);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithMultiplePurchasesPreview$1$1$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                            invoke2(customerCenterAction);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, null, CollectionsKt.listOf((Object[]) new PurchaseInformation[]{CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationMonthlyRenewing(), CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationYearlyExpiring()}), composer2, 14156208, 256);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithMultiplePurchasesPreview.2
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
                    RelevantPurchasesListViewKt.RelevantPurchasesListViewWithMultiplePurchasesPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-577177921);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview)227@9337L785,227@9310L812:RelevantPurchasesListView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-577177921, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview (RelevantPurchasesListView.kt:224)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(1430822974, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview.1
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
                    ComposerKt.sourceInformation(composer2, "C228@9347L769:RelevantPurchasesListView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1430822974, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview.<anonymous> (RelevantPurchasesListView.kt:228)");
                    }
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
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
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1182031058, "C229@9368L738:RelevantPurchasesListView.kt#870w7w");
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(screen3.getPaths(), "support@revenuecat.com", null, customerCenterConfigData.getAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PurchaseInformation purchaseInformation) {
                            invoke2(purchaseInformation);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview$1$1$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                            invoke2(customerCenterAction);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, null, CollectionsKt.listOf((Object[]) new PurchaseInformation[]{CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationMonthlyRenewing(), CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationYearlyExpiring(), CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationLifetime()}), composer2, 14156208, 256);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview.2
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
                    RelevantPurchasesListViewKt.RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
