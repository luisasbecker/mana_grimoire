package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.profileinstaller.ProfileVerifier;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterUIConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonConfig;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonStyle;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PathUtils;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManageSubscriptionsButtonsView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a_\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000fH\u0001¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"ManageSubscriptionsButtonsView", "", "associatedPurchaseInformation", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "supportedPaths", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "contactEmail", "", "addContactButton", "", "addCreateTicketButton", "onAction", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/actions/CustomerCenterAction;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;Ljava/util/List;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Ljava/lang/String;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ManageSubscriptionsButtonsViewKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ManageSubscriptionsButtonsView(final PurchaseInformation purchaseInformation, final List<CustomerCenterConfigData.HelpPath> supportedPaths, final CustomerCenterConfigData.Localization localization, final String str, boolean z, boolean z2, final Function1<? super CustomerCenterAction, Unit> onAction, Composer composer, final int i, final int i2) {
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        boolean z5;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Iterator it;
        final boolean z6;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(supportedPaths, "supportedPaths");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2097060024);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ManageSubscriptionsButtonsView)P(2,6,4,3)29@1606L1804:ManageSubscriptionsButtonsView.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(purchaseInformation) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(supportedPaths) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(localization) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 2048 : 1024;
        }
        int i5 = i2 & 16;
        if (i5 != 0) {
            i3 |= 24576;
        } else {
            if ((i & 24576) == 0) {
                z3 = z;
                i3 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    z4 = z2;
                    i3 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(onAction) ? 1048576 : 524288;
                }
                if ((599187 & i3) == 599186 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    z7 = z4;
                } else {
                    boolean z8 = i5 == 0 ? false : z3;
                    z5 = i4 == 0 ? false : z4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2097060024, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ManageSubscriptionsButtonsView (ManageSubscriptionsButtonsView.kt:28)");
                    }
                    DefaultConstructorMarker defaultConstructorMarker = null;
                    Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), 0.0f, 2, null), 0.0f, CustomerCenterConstants.Layout.INSTANCE.m10697getBUTTONS_TOP_PADDINGD9Ej5fM(), 0.0f, CustomerCenterConstants.Layout.INSTANCE.m10695getBUTTONS_BOTTOM_PADDINGD9Ej5fM(), 5, null);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(CustomerCenterConstants.Layout.INSTANCE.m10696getBUTTONS_SPACINGD9Ej5fM());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1626750321, "C:ManageSubscriptionsButtonsView.kt#870w7w");
                    composerStartRestartGroup.startReplaceGroup(1437949818);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*42@2268L31,41@2226L236");
                    it = PathUtils.INSTANCE.sortPathsByButtonPriority(supportedPaths).iterator();
                    while (it.hasNext()) {
                        CustomerCenterConfigData.HelpPath helpPath = (CustomerCenterConfigData.HelpPath) it.next();
                        final CustomerCenterAction.PathButtonPressed pathButtonPressed = new CustomerCenterAction.PathButtonPressed(helpPath, purchaseInformation);
                        String title = helpPath.getTitle();
                        SettingsButtonStyle buttonStyleForPath = PathUtils.INSTANCE.getButtonStyleForPath(helpPath);
                        Iterator it2 = it;
                        SettingsButtonConfig settingsButtonConfig = new SettingsButtonConfig(false, false, 3, defaultConstructorMarker);
                        composerStartRestartGroup.startReplaceGroup(1763889156);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ManageSubscriptionsButtonsView.kt#9igjgp");
                        boolean zChangedInstance = ((i3 & 3670016) == 1048576) | composerStartRestartGroup.changedInstance(pathButtonPressed);
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ManageSubscriptionsButtonsViewKt$ManageSubscriptionsButtonsView$1$1$1$1
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
                                    onAction.invoke(pathButtonPressed);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        SettingsButtonKt.SettingsButton(title, (Function0) objRememberedValue, settingsButtonConfig, null, buttonStyleForPath, composerStartRestartGroup, 0, 8);
                        it = it2;
                        defaultConstructorMarker = defaultConstructorMarker;
                    }
                    DefaultConstructorMarker defaultConstructorMarker2 = defaultConstructorMarker;
                    composerStartRestartGroup.endReplaceGroup();
                    if (!z5) {
                        composerStartRestartGroup.startReplaceGroup(1627209368);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "51@2565L60,50@2523L396");
                        String strCommonLocalizedString = localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.CONTACT_SUPPORT);
                        SettingsButtonStyle settingsButtonStyle = SettingsButtonStyle.OUTLINED;
                        SettingsButtonConfig settingsButtonConfig2 = new SettingsButtonConfig(false, false, 3, defaultConstructorMarker2);
                        composerStartRestartGroup.startReplaceGroup(1437965378);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ManageSubscriptionsButtonsView.kt#9igjgp");
                        boolean z9 = (i3 & 3670016) == 1048576;
                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z9 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ManageSubscriptionsButtonsViewKt$ManageSubscriptionsButtonsView$1$2$1
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
                                    onAction.invoke(CustomerCenterAction.ShowSupportTicketCreation.INSTANCE);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        SettingsButtonKt.SettingsButton(strCommonLocalizedString, (Function0) objRememberedValue2, settingsButtonConfig2, null, settingsButtonStyle, composerStartRestartGroup, 24576, 8);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (!z8 || str == null) {
                        composerStartRestartGroup.startReplaceGroup(1628084188);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1627677685);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "60@3037L63,59@2995L399");
                        String strCommonLocalizedString2 = localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.CONTACT_SUPPORT);
                        SettingsButtonStyle settingsButtonStyle2 = SettingsButtonStyle.OUTLINED;
                        SettingsButtonConfig settingsButtonConfig3 = new SettingsButtonConfig(false, false, 3, defaultConstructorMarker2);
                        composerStartRestartGroup.startReplaceGroup(1437980485);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ManageSubscriptionsButtonsView.kt#9igjgp");
                        boolean z10 = ((i3 & 7168) == 2048) | ((i3 & 3670016) == 1048576);
                        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (z10 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ManageSubscriptionsButtonsViewKt$ManageSubscriptionsButtonsView$1$3$1
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
                                    onAction.invoke(new CustomerCenterAction.ContactSupport(str));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        SettingsButtonKt.SettingsButton(strCommonLocalizedString2, (Function0) objRememberedValue3, settingsButtonConfig3, null, settingsButtonStyle2, composerStartRestartGroup, 24576, 8);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z8;
                    z7 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ManageSubscriptionsButtonsViewKt.ManageSubscriptionsButtonsView.2
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
                            ManageSubscriptionsButtonsViewKt.ManageSubscriptionsButtonsView(purchaseInformation, supportedPaths, localization, str, z6, z7, onAction, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z4 = z2;
            if ((i2 & 64) != 0) {
            }
            if ((599187 & i3) == 599186) {
                if (i5 == 0) {
                }
                if (i4 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                DefaultConstructorMarker defaultConstructorMarker3 = null;
                Modifier modifierM2041paddingqDBjuR0$default2 = PaddingKt.m2041paddingqDBjuR0$default(PaddingKt.m2039paddingVpY3zN4$default(Modifier.INSTANCE, CustomerCenterUIConstants.INSTANCE.m10707getManagementViewHorizontalPaddingD9Ej5fM(), 0.0f, 2, null), 0.0f, CustomerCenterConstants.Layout.INSTANCE.m10697getBUTTONS_TOP_PADDINGD9Ej5fM(), 0.0f, CustomerCenterConstants.Layout.INSTANCE.m10695getBUTTONS_BOTTOM_PADDINGD9Ej5fM(), 5, null);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_42 = Arrangement.INSTANCE.m1907spacedBy0680j_4(CustomerCenterConstants.Layout.INSTANCE.m10696getBUTTONS_SPACINGD9Ej5fM());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_42, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1626750321, "C:ManageSubscriptionsButtonsView.kt#870w7w");
                    composerStartRestartGroup.startReplaceGroup(1437949818);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*42@2268L31,41@2226L236");
                    it = PathUtils.INSTANCE.sortPathsByButtonPriority(supportedPaths).iterator();
                    while (it.hasNext()) {
                    }
                    DefaultConstructorMarker defaultConstructorMarker22 = defaultConstructorMarker3;
                    composerStartRestartGroup.endReplaceGroup();
                    if (!z5) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z6 = z8;
                    z7 = z5;
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        z3 = z;
        i4 = i2 & 32;
        if (i4 != 0) {
        }
        z4 = z2;
        if ((i2 & 64) != 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
