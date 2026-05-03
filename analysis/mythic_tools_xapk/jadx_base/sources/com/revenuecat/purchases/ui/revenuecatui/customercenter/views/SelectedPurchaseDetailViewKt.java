package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.profileinstaller.ProfileVerifier;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectedPurchaseDetailView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aS\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000eH\u0001¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"SelectedPurchaseDetailView", "", "contactEmail", "", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "purchaseInformation", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "supportedPaths", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "modifier", "Landroidx/compose/ui/Modifier;", "onAction", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/actions/CustomerCenterAction;", "(Ljava/lang/String;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "SelectedPurchaseDetailViewPreview", "(Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectedPurchaseDetailViewKt {
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x024e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SelectedPurchaseDetailView(final String str, final CustomerCenterConfigData.Localization localization, final PurchaseInformation purchaseInformation, final List<CustomerCenterConfigData.HelpPath> supportedPaths, Modifier modifier, final Function1<? super CustomerCenterAction, Unit> onAction, Composer composer, final int i, final int i2) {
        String str2;
        int i3;
        Modifier modifier2;
        int i4;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(purchaseInformation, "purchaseInformation");
        Intrinsics.checkNotNullParameter(supportedPaths, "supportedPaths");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1921516837);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectedPurchaseDetailView)P(!2,4,5)34@1633L21,31@1542L1037:SelectedPurchaseDetailView.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(localization) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(purchaseInformation) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(supportedPaths) ? 2048 : 1024;
        }
        int i5 = i2 & 16;
        if (i5 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((i2 & 32) == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(onAction) ? 131072 : 65536;
            }
            i4 = i3;
            if ((74899 & i4) == 74898 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1921516837, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailView (SelectedPurchaseDetailView.kt:30)");
                }
                Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), 0.0f, CustomerCenterConstants.Layout.INSTANCE.m10702getTOP_PADDING_AFTER_TOP_BARD9Ej5fM(), 0.0f, 0.0f, 13, null);
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1902791187, "C38@1818L401,49@2229L344:SelectedPurchaseDetailView.kt#870w7w");
                int i6 = i4 >> 6;
                PurchaseInformationCardViewKt.PurchaseInformationCardView(purchaseInformation, localization, PaddingKt.m2039paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), CustomerCenterConstants.Layout.INSTANCE.m10698getHORIZONTAL_PADDINGD9Ej5fM(), 0.0f, 2, null), ButtonPosition.SINGLE, true, null, composerStartRestartGroup, (i6 & 14) | 224640 | (i4 & 112), 0);
                int i7 = i4 << 3;
                ManageSubscriptionsButtonsViewKt.ManageSubscriptionsButtonsView(purchaseInformation, supportedPaths, localization, str2, purchaseInformation.getStore() == Store.PLAY_STORE, false, onAction, composerStartRestartGroup, (i6 & 126) | (i7 & 896) | ((i4 << 9) & 7168) | (i7 & 3670016), 32);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailViewKt.SelectedPurchaseDetailView.2
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

                    public final void invoke(Composer composer3, int i8) {
                        SelectedPurchaseDetailViewKt.SelectedPurchaseDetailView(str, localization, purchaseInformation, supportedPaths, modifier3, onAction, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((i2 & 32) == 0) {
        }
        i4 = i3;
        if ((74899 & i4) == 74898) {
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier modifierM2041paddingqDBjuR0$default2 = PaddingKt.m2041paddingqDBjuR0$default(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), 0.0f, CustomerCenterConstants.Layout.INSTANCE.m10702getTOP_PADDING_AFTER_TOP_BARD9Ej5fM(), 0.0f, 0.0f, 13, null);
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1902791187, "C38@1818L401,49@2229L344:SelectedPurchaseDetailView.kt#870w7w");
                int i62 = i4 >> 6;
                PurchaseInformationCardViewKt.PurchaseInformationCardView(purchaseInformation, localization, PaddingKt.m2039paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), CustomerCenterConstants.Layout.INSTANCE.m10698getHORIZONTAL_PADDINGD9Ej5fM(), 0.0f, 2, null), ButtonPosition.SINGLE, true, null, composerStartRestartGroup, (i62 & 14) | 224640 | (i4 & 112), 0);
                int i72 = i4 << 3;
                ManageSubscriptionsButtonsViewKt.ManageSubscriptionsButtonsView(purchaseInformation, supportedPaths, localization, str2, purchaseInformation.getStore() == Store.PLAY_STORE, false, onAction, composerStartRestartGroup, (i62 & 126) | (i72 & 896) | ((i4 << 9) & 7168) | (i72 & 3670016), 32);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier4;
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectedPurchaseDetailViewPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1898383606);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectedPurchaseDetailViewPreview)71@3063L282,71@3036L309:SelectedPurchaseDetailView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1898383606, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailViewPreview (SelectedPurchaseDetailView.kt:67)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            final PurchaseInformation purchaseInformationMonthlyRenewing = CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationMonthlyRenewing();
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(1713352777, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailViewKt.SelectedPurchaseDetailViewPreview.1
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
                    ComposerKt.sourceInformation(composer2, "C72@3073L266:SelectedPurchaseDetailView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1713352777, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailViewPreview.<anonymous> (SelectedPurchaseDetailView.kt:72)");
                    }
                    SelectedPurchaseDetailViewKt.SelectedPurchaseDetailView(customerCenterConfigDataCustomerCenterData$default.getSupport().getEmail(), customerCenterConfigDataCustomerCenterData$default.getLocalization(), purchaseInformationMonthlyRenewing, screen2.getPaths(), null, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailViewKt.SelectedPurchaseDetailViewPreview.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                            invoke2(customerCenterAction);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SelectedPurchaseDetailViewKt.SelectedPurchaseDetailViewPreview.2
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
                    SelectedPurchaseDetailViewKt.SelectedPurchaseDetailViewPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
