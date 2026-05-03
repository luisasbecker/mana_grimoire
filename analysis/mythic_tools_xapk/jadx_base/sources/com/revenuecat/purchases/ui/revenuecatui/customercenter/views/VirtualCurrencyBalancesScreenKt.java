package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigDataExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.VirtualCurrencyBalancesScreenViewModel;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.VirtualCurrencyBalancesScreenViewModelFactory;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenViewState;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.icons.WarningKt;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrency;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: VirtualCurrencyBalancesScreen.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0006\u001a/\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\f\u001a1\u0010\r\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0016\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0012\u001a!\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u001a¨\u0006\u001b²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002"}, d2 = {"EmptyStateView", "", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "InternalVirtualCurrencyBalancesScreen", "appearance", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;", "viewState", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState;", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "VirtualCurrencyBalancesScreen", "viewModel", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/VirtualCurrencyBalancesScreenViewModel;", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/VirtualCurrencyBalancesScreenViewModel;Landroidx/compose/runtime/Composer;II)V", "VirtualCurrencyBalancesScreenErrorPreview", "(Landroidx/compose/runtime/Composer;I)V", "VirtualCurrencyBalancesScreenLoaded0VCsPreview", "VirtualCurrencyBalancesScreenLoaded4VCsPreview", "VirtualCurrencyBalancesScreenLoadedVCsPreview", "VirtualCurrencyBalancesScreenLoadingPreview", "getVirtualCurrencyBalancesScreenViewModel", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/VirtualCurrencyBalancesScreenViewModel;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/viewmodel/VirtualCurrencyBalancesScreenViewModel;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrencyBalancesScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void EmptyStateView(final CustomerCenterConfigData.Localization localization, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-34838374);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EmptyStateView)142@6332L774:VirtualCurrencyBalancesScreen.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(localization) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) == 18 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-34838374, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.EmptyStateView (VirtualCurrencyBalancesScreen.kt:141)");
                }
                Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), Dp.m9114constructorimpl(32.0f));
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1371900388, "C152@6664L11,149@6551L197,155@6757L39,160@7027L10,156@6805L295:VirtualCurrencyBalancesScreen.kt#870w7w");
                IconKt.m3736Iconww6aTOc(WarningKt.getWarning(), (String) null, SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(48.0f)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant(), composerStartRestartGroup, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
                SpacerKt.Spacer(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(16.0f)), composerStartRestartGroup, 6);
                modifier3 = modifier4;
                TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.NO_VIRTUAL_CURRENCY_BALANCES_FOUND), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, 0, 0, 65022);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.EmptyStateView.2
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
                        VirtualCurrencyBalancesScreenKt.EmptyStateView(localization, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) == 18) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier modifierM2037padding3ABfNKs2 = PaddingKt.m2037padding3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), Dp.m9114constructorimpl(32.0f));
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center2, centerHorizontally2, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2037padding3ABfNKs2);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1371900388, "C152@6664L11,149@6551L197,155@6757L39,160@7027L10,156@6805L295:VirtualCurrencyBalancesScreen.kt#870w7w");
                IconKt.m3736Iconww6aTOc(WarningKt.getWarning(), (String) null, SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(48.0f)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant(), composerStartRestartGroup, Videoio.CAP_PROP_XI_DECIMATION_VERTICAL, 0);
                SpacerKt.Spacer(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(16.0f)), composerStartRestartGroup, 6);
                modifier3 = modifier4;
                TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.NO_VIRTUAL_CURRENCY_BALANCES_FOUND), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8992getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, 0, 0, 65022);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void InternalVirtualCurrencyBalancesScreen(final CustomerCenterConfigData.Appearance appearance, final CustomerCenterConfigData.Localization localization, final VirtualCurrencyBalancesScreenViewState virtualCurrencyBalancesScreenViewState, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Color colorForTheme;
        boolean zChangedInstance;
        Object objRememberedValue;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1969482204);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InternalVirtualCurrencyBalancesScreen)P(!2,3)66@3134L21,73@3336L2852,69@3234L2954:VirtualCurrencyBalancesScreen.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(appearance) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(localization) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(virtualCurrencyBalancesScreenViewState) : composerStartRestartGroup.changedInstance(virtualCurrencyBalancesScreenViewState) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1969482204, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.InternalVirtualCurrencyBalancesScreen (VirtualCurrencyBalancesScreen.kt:65)");
                }
                z = false;
                colorForTheme = CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0), new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$textColor$1
                    @Override // kotlin.jvm.functions.Function1
                    public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getTextColor();
                    }
                });
                Modifier modifierM2037padding3ABfNKs = PaddingKt.m2037padding3ABfNKs(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Dp.m9114constructorimpl(16.0f));
                composerStartRestartGroup.startReplaceGroup(-186439756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VirtualCurrencyBalancesScreen.kt#9igjgp");
                if ((i3 & 896) != 256 || ((i3 & 512) != 0 && composerStartRestartGroup.changedInstance(virtualCurrencyBalancesScreenViewState))) {
                    z = true;
                }
                zChangedInstance = z | composerStartRestartGroup.changedInstance(localization) | composerStartRestartGroup.changed(colorForTheme) | composerStartRestartGroup.changedInstance(appearance);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                            invoke2(lazyListScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyListScope LazyColumn) {
                            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                            VirtualCurrencyBalancesScreenViewState virtualCurrencyBalancesScreenViewState2 = virtualCurrencyBalancesScreenViewState;
                            if (virtualCurrencyBalancesScreenViewState2 instanceof VirtualCurrencyBalancesScreenViewState.Loading) {
                                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$VirtualCurrencyBalancesScreenKt.INSTANCE.m10728getLambda1$revenuecatui_defaultsBc8Release(), 3, null);
                                return;
                            }
                            if (!(virtualCurrencyBalancesScreenViewState2 instanceof VirtualCurrencyBalancesScreenViewState.Loaded)) {
                                if (virtualCurrencyBalancesScreenViewState2 instanceof VirtualCurrencyBalancesScreenViewState.Error) {
                                    final VirtualCurrencyBalancesScreenViewState virtualCurrencyBalancesScreenViewState3 = virtualCurrencyBalancesScreenViewState;
                                    LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1044805064, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1.5
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                            invoke(lazyItemScope, composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer composer2, int i5) {
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation(composer2, "C130@6073L67:VirtualCurrencyBalancesScreen.kt#870w7w");
                                            if ((i5 & 17) == 16 && composer2.getSkipping()) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1044805064, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.InternalVirtualCurrencyBalancesScreen.<anonymous>.<anonymous>.<anonymous> (VirtualCurrencyBalancesScreen.kt:130)");
                                            }
                                            CustomerCenterErrorViewKt.CustomerCenterErrorView(new CustomerCenterState.Error(((VirtualCurrencyBalancesScreenViewState.Error) virtualCurrencyBalancesScreenViewState3).getError()), composer2, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), 3, null);
                                    return;
                                }
                                return;
                            }
                            final List<VirtualCurrency> virtualCurrencyBalanceData = ((VirtualCurrencyBalancesScreenViewState.Loaded) virtualCurrencyBalancesScreenViewState2).getVirtualCurrencyBalanceData();
                            if (virtualCurrencyBalanceData.isEmpty()) {
                                final CustomerCenterConfigData.Localization localization2 = localization;
                                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1955047837, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1.4
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                        invoke(lazyItemScope, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer composer2, int i5) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation(composer2, "C122@5812L98:VirtualCurrencyBalancesScreen.kt#870w7w");
                                        if ((i5 & 17) == 16 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1955047837, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.InternalVirtualCurrencyBalancesScreen.<anonymous>.<anonymous>.<anonymous> (VirtualCurrencyBalancesScreen.kt:122)");
                                        }
                                        VirtualCurrencyBalancesScreenKt.EmptyStateView(localization2, null, composer2, 0, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), 3, null);
                                return;
                            }
                            final CustomerCenterConfigData.Localization localization3 = localization;
                            final Color color = colorForTheme;
                            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-853776436, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int i5) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation(composer2, "C89@4129L10,84@3801L541:VirtualCurrencyBalancesScreen.kt#870w7w");
                                    if ((i5 & 17) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-853776436, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.InternalVirtualCurrencyBalancesScreen.<anonymous>.<anonymous>.<anonymous> (VirtualCurrencyBalancesScreen.kt:84)");
                                    }
                                    String strCommonLocalizedString = localization3.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.VIRTUAL_CURRENCY_BALANCES_SCREEN_HEADER);
                                    TextStyle headlineSmall = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getHeadlineSmall();
                                    Color color2 = color;
                                    composer2.startReplaceGroup(58225184);
                                    ComposerKt.sourceInformation(composer2, "90@4218L11");
                                    long onBackground = color2 == null ? MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnBackground() : color2.m6335unboximpl();
                                    composer2.endReplaceGroup();
                                    TextKt.m4286Text4IGK_g(strCommonLocalizedString, PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(16.0f), 7, null), onBackground, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, headlineSmall, composer2, 48, 0, 65528);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            final AnonymousClass2 anonymousClass2 = new Function2<Integer, VirtualCurrency, Object>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1.2
                                public final Object invoke(int i5, VirtualCurrency virtualCurrency) {
                                    Intrinsics.checkNotNullParameter(virtualCurrency, "virtualCurrency");
                                    return virtualCurrency.getCode() + '_' + virtualCurrency.getName() + '_' + i5;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Integer num, VirtualCurrency virtualCurrency) {
                                    return invoke(num.intValue(), virtualCurrency);
                                }
                            };
                            final CustomerCenterConfigData.Appearance appearance2 = appearance;
                            final CustomerCenterConfigData.Localization localization4 = localization;
                            LazyColumn.items(virtualCurrencyBalanceData.size(), anonymousClass2 != null ? new Function1<Integer, Object>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1$invoke$$inlined$itemsIndexed$default$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final Object invoke(int i5) {
                                    return anonymousClass2.invoke(Integer.valueOf(i5), virtualCurrencyBalanceData.get(i5));
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                    return invoke(num.intValue());
                                }
                            } : null, new Function1<Integer, Object>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1$invoke$$inlined$itemsIndexed$default$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final Object invoke(int i5) {
                                    virtualCurrencyBalanceData.get(i5);
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                    return invoke(num.intValue());
                                }
                            }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1$invoke$$inlined$itemsIndexed$default$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer2, int i6) {
                                    int i7;
                                    ComposerKt.sourceInformation(composer2, "C188@8866L26:LazyDsl.kt#428nma");
                                    if ((i6 & 6) == 0) {
                                        i7 = (composer2.changed(lazyItemScope) ? 4 : 2) | i6;
                                    } else {
                                        i7 = i6;
                                    }
                                    if ((i6 & 48) == 0) {
                                        i7 |= composer2.changed(i5) ? 32 : 16;
                                    }
                                    if ((i7 & 147) == 146 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1091073711, i7, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                                    }
                                    VirtualCurrency virtualCurrency = (VirtualCurrency) virtualCurrencyBalanceData.get(i5);
                                    composer2.startReplaceGroup(1805699008);
                                    ComposerKt.sourceInformation(composer2, "C*113@5446L267:VirtualCurrencyBalancesScreen.kt#870w7w");
                                    composer2.startReplaceGroup(58247682);
                                    ComposerKt.sourceInformation(composer2, "103@4936L78");
                                    if (i5 > 0) {
                                        SpacerKt.Spacer(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, CustomerCenterConstants.Layout.INSTANCE.m10699getITEMS_SPACINGD9Ej5fM()), composer2, 6);
                                    }
                                    composer2.endReplaceGroup();
                                    VirtualCurrenciesListViewKt.VirtualCurrencyRow(appearance2, localization4, virtualCurrency, virtualCurrencyBalanceData.size() == 1 ? ButtonPosition.SINGLE : i5 == 0 ? ButtonPosition.FIRST : i5 == virtualCurrencyBalanceData.size() - 1 ? ButtonPosition.LAST : ButtonPosition.MIDDLE, null, composer2, 0, 16);
                                    composer2.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier4 = companion;
                LazyDslKt.LazyColumn(modifierM2037padding3ABfNKs, null, null, false, null, null, null, false, (Function1) objRememberedValue, composerStartRestartGroup, 0, 254);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.InternalVirtualCurrencyBalancesScreen.2
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
                        VirtualCurrencyBalancesScreenKt.InternalVirtualCurrencyBalancesScreen(appearance, localization, virtualCurrencyBalancesScreenViewState, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) == 1170) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            z = false;
            colorForTheme = CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0), new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$textColor$1
                @Override // kotlin.jvm.functions.Function1
                public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getTextColor();
                }
            });
            Modifier modifierM2037padding3ABfNKs2 = PaddingKt.m2037padding3ABfNKs(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Dp.m9114constructorimpl(16.0f));
            composerStartRestartGroup.startReplaceGroup(-186439756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VirtualCurrencyBalancesScreen.kt#9igjgp");
            if ((i3 & 896) != 256) {
                z = true;
                zChangedInstance = z | composerStartRestartGroup.changedInstance(localization) | composerStartRestartGroup.changed(colorForTheme) | composerStartRestartGroup.changedInstance(appearance);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = (Function1) new Function1<LazyListScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                            invoke2(lazyListScope);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyListScope LazyColumn) {
                            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                            VirtualCurrencyBalancesScreenViewState virtualCurrencyBalancesScreenViewState2 = virtualCurrencyBalancesScreenViewState;
                            if (virtualCurrencyBalancesScreenViewState2 instanceof VirtualCurrencyBalancesScreenViewState.Loading) {
                                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$VirtualCurrencyBalancesScreenKt.INSTANCE.m10728getLambda1$revenuecatui_defaultsBc8Release(), 3, null);
                                return;
                            }
                            if (!(virtualCurrencyBalancesScreenViewState2 instanceof VirtualCurrencyBalancesScreenViewState.Loaded)) {
                                if (virtualCurrencyBalancesScreenViewState2 instanceof VirtualCurrencyBalancesScreenViewState.Error) {
                                    final VirtualCurrencyBalancesScreenViewState virtualCurrencyBalancesScreenViewState3 = virtualCurrencyBalancesScreenViewState;
                                    LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1044805064, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1.5
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                            invoke(lazyItemScope, composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope item, Composer composer2, int i5) {
                                            Intrinsics.checkNotNullParameter(item, "$this$item");
                                            ComposerKt.sourceInformation(composer2, "C130@6073L67:VirtualCurrencyBalancesScreen.kt#870w7w");
                                            if ((i5 & 17) == 16 && composer2.getSkipping()) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1044805064, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.InternalVirtualCurrencyBalancesScreen.<anonymous>.<anonymous>.<anonymous> (VirtualCurrencyBalancesScreen.kt:130)");
                                            }
                                            CustomerCenterErrorViewKt.CustomerCenterErrorView(new CustomerCenterState.Error(((VirtualCurrencyBalancesScreenViewState.Error) virtualCurrencyBalancesScreenViewState3).getError()), composer2, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), 3, null);
                                    return;
                                }
                                return;
                            }
                            final List virtualCurrencyBalanceData = ((VirtualCurrencyBalancesScreenViewState.Loaded) virtualCurrencyBalancesScreenViewState2).getVirtualCurrencyBalanceData();
                            if (virtualCurrencyBalanceData.isEmpty()) {
                                final CustomerCenterConfigData.Localization localization2 = localization;
                                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1955047837, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1.4
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                        invoke(lazyItemScope, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope item, Composer composer2, int i5) {
                                        Intrinsics.checkNotNullParameter(item, "$this$item");
                                        ComposerKt.sourceInformation(composer2, "C122@5812L98:VirtualCurrencyBalancesScreen.kt#870w7w");
                                        if ((i5 & 17) == 16 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1955047837, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.InternalVirtualCurrencyBalancesScreen.<anonymous>.<anonymous>.<anonymous> (VirtualCurrencyBalancesScreen.kt:122)");
                                        }
                                        VirtualCurrencyBalancesScreenKt.EmptyStateView(localization2, null, composer2, 0, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), 3, null);
                                return;
                            }
                            final CustomerCenterConfigData.Localization localization3 = localization;
                            final Color color = colorForTheme;
                            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-853776436, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int i5) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    ComposerKt.sourceInformation(composer2, "C89@4129L10,84@3801L541:VirtualCurrencyBalancesScreen.kt#870w7w");
                                    if ((i5 & 17) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-853776436, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.InternalVirtualCurrencyBalancesScreen.<anonymous>.<anonymous>.<anonymous> (VirtualCurrencyBalancesScreen.kt:84)");
                                    }
                                    String strCommonLocalizedString = localization3.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.VIRTUAL_CURRENCY_BALANCES_SCREEN_HEADER);
                                    TextStyle headlineSmall = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getHeadlineSmall();
                                    Color color2 = color;
                                    composer2.startReplaceGroup(58225184);
                                    ComposerKt.sourceInformation(composer2, "90@4218L11");
                                    long onBackground = color2 == null ? MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnBackground() : color2.m6335unboximpl();
                                    composer2.endReplaceGroup();
                                    TextKt.m4286Text4IGK_g(strCommonLocalizedString, PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(16.0f), 7, null), onBackground, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, headlineSmall, composer2, 48, 0, 65528);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                            final Function2 anonymousClass2 = new Function2<Integer, VirtualCurrency, Object>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1.2
                                public final Object invoke(int i5, VirtualCurrency virtualCurrency) {
                                    Intrinsics.checkNotNullParameter(virtualCurrency, "virtualCurrency");
                                    return virtualCurrency.getCode() + '_' + virtualCurrency.getName() + '_' + i5;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Integer num, VirtualCurrency virtualCurrency) {
                                    return invoke(num.intValue(), virtualCurrency);
                                }
                            };
                            final CustomerCenterConfigData.Appearance appearance2 = appearance;
                            final CustomerCenterConfigData.Localization localization4 = localization;
                            LazyColumn.items(virtualCurrencyBalanceData.size(), anonymousClass2 != null ? new Function1<Integer, Object>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1$invoke$$inlined$itemsIndexed$default$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final Object invoke(int i5) {
                                    return anonymousClass2.invoke(Integer.valueOf(i5), virtualCurrencyBalanceData.get(i5));
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                    return invoke(num.intValue());
                                }
                            } : null, new Function1<Integer, Object>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1$invoke$$inlined$itemsIndexed$default$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final Object invoke(int i5) {
                                    virtualCurrencyBalanceData.get(i5);
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                    return invoke(num.intValue());
                                }
                            }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt$InternalVirtualCurrencyBalancesScreen$1$1$invoke$$inlined$itemsIndexed$default$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer2, int i6) {
                                    int i7;
                                    ComposerKt.sourceInformation(composer2, "C188@8866L26:LazyDsl.kt#428nma");
                                    if ((i6 & 6) == 0) {
                                        i7 = (composer2.changed(lazyItemScope) ? 4 : 2) | i6;
                                    } else {
                                        i7 = i6;
                                    }
                                    if ((i6 & 48) == 0) {
                                        i7 |= composer2.changed(i5) ? 32 : 16;
                                    }
                                    if ((i7 & 147) == 146 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1091073711, i7, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                                    }
                                    VirtualCurrency virtualCurrency = (VirtualCurrency) virtualCurrencyBalanceData.get(i5);
                                    composer2.startReplaceGroup(1805699008);
                                    ComposerKt.sourceInformation(composer2, "C*113@5446L267:VirtualCurrencyBalancesScreen.kt#870w7w");
                                    composer2.startReplaceGroup(58247682);
                                    ComposerKt.sourceInformation(composer2, "103@4936L78");
                                    if (i5 > 0) {
                                        SpacerKt.Spacer(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, CustomerCenterConstants.Layout.INSTANCE.m10699getITEMS_SPACINGD9Ej5fM()), composer2, 6);
                                    }
                                    composer2.endReplaceGroup();
                                    VirtualCurrenciesListViewKt.VirtualCurrencyRow(appearance2, localization4, virtualCurrency, virtualCurrencyBalanceData.size() == 1 ? ButtonPosition.SINGLE : i5 == 0 ? ButtonPosition.FIRST : i5 == virtualCurrencyBalanceData.size() - 1 ? ButtonPosition.LAST : ButtonPosition.MIDDLE, null, composer2, 0, 16);
                                    composer2.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier42 = companion;
                    LazyDslKt.LazyColumn(modifierM2037padding3ABfNKs2, null, null, false, null, null, null, false, (Function1) objRememberedValue, composerStartRestartGroup, 0, 254);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void VirtualCurrencyBalancesScreen(final CustomerCenterConfigData.Appearance appearance, final CustomerCenterConfigData.Localization localization, Modifier modifier, VirtualCurrencyBalancesScreenViewModel virtualCurrencyBalancesScreenViewModel, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        VirtualCurrencyBalancesScreenViewModel virtualCurrencyBalancesScreenViewModel2;
        int i4;
        final Modifier modifier3;
        VirtualCurrencyBalancesScreenViewModel virtualCurrencyBalancesScreenViewModel3;
        final VirtualCurrencyBalancesScreenViewModel virtualCurrencyBalancesScreenViewModel4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1764738181);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VirtualCurrencyBalancesScreen)47@2599L29,49@2634L174:VirtualCurrencyBalancesScreen.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(appearance) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(localization) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    virtualCurrencyBalancesScreenViewModel2 = virtualCurrencyBalancesScreenViewModel;
                    int i6 = composerStartRestartGroup.changed(virtualCurrencyBalancesScreenViewModel2) ? 2048 : 1024;
                    i3 |= i6;
                } else {
                    virtualCurrencyBalancesScreenViewModel2 = virtualCurrencyBalancesScreenViewModel;
                }
                i3 |= i6;
            } else {
                virtualCurrencyBalancesScreenViewModel2 = virtualCurrencyBalancesScreenViewModel;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "45@2509L43");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 8) == 0) {
                        Modifier modifier4 = companion;
                        i4 = i3 & (-7169);
                        modifier3 = modifier4;
                        virtualCurrencyBalancesScreenViewModel3 = getVirtualCurrencyBalancesScreenViewModel(null, null, composerStartRestartGroup, 0, 3);
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1764738181, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreen (VirtualCurrencyBalancesScreen.kt:46)");
                        }
                        InternalVirtualCurrencyBalancesScreen(appearance, localization, VirtualCurrencyBalancesScreen$lambda$0(FlowExtKt.collectAsStateWithLifecycle(virtualCurrencyBalancesScreenViewModel3.getViewState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7)), modifier3, composerStartRestartGroup, (i4 & 126) | ((i4 << 3) & 7168), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        virtualCurrencyBalancesScreenViewModel4 = virtualCurrencyBalancesScreenViewModel3;
                    } else {
                        Modifier modifier5 = companion;
                        i4 = i3;
                        modifier3 = modifier5;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    i4 = i3;
                    modifier3 = modifier2;
                }
                virtualCurrencyBalancesScreenViewModel3 = virtualCurrencyBalancesScreenViewModel2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                InternalVirtualCurrencyBalancesScreen(appearance, localization, VirtualCurrencyBalancesScreen$lambda$0(FlowExtKt.collectAsStateWithLifecycle(virtualCurrencyBalancesScreenViewModel3.getViewState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7)), modifier3, composerStartRestartGroup, (i4 & 126) | ((i4 << 3) & 7168), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                virtualCurrencyBalancesScreenViewModel4 = virtualCurrencyBalancesScreenViewModel3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                virtualCurrencyBalancesScreenViewModel4 = virtualCurrencyBalancesScreenViewModel2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreen.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i7) {
                        VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreen(appearance, localization, modifier3, virtualCurrencyBalancesScreenViewModel4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) != 0) {
        }
        if ((i3 & 1171) == 1170) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "45@2509L43");
            if ((i & 1) != 0) {
                if (i5 == 0) {
                }
                if ((i2 & 8) == 0) {
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final VirtualCurrencyBalancesScreenViewState VirtualCurrencyBalancesScreen$lambda$0(State<? extends VirtualCurrencyBalancesScreenViewState> state) {
        return state.getValue();
    }

    public static final void VirtualCurrencyBalancesScreenErrorPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-508614020);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VirtualCurrencyBalancesScreenErrorPreview)254@10209L519:VirtualCurrencyBalancesScreen.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-508614020, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenErrorPreview (VirtualCurrencyBalancesScreen.kt:253)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableSingletons$VirtualCurrencyBalancesScreenKt.INSTANCE.m10733getLambda6$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenErrorPreview.1
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
                    VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenErrorPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void VirtualCurrencyBalancesScreenLoaded0VCsPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(800159975);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VirtualCurrencyBalancesScreenLoaded0VCsPreview)190@8014L340:VirtualCurrencyBalancesScreen.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(800159975, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenLoaded0VCsPreview (VirtualCurrencyBalancesScreen.kt:189)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableSingletons$VirtualCurrencyBalancesScreenKt.INSTANCE.m10729getLambda2$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoaded0VCsPreview.1
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
                    VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoaded0VCsPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void VirtualCurrencyBalancesScreenLoaded4VCsPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1776254187);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VirtualCurrencyBalancesScreenLoaded4VCsPreview)205@8517L455:VirtualCurrencyBalancesScreen.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1776254187, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenLoaded4VCsPreview (VirtualCurrencyBalancesScreen.kt:204)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableSingletons$VirtualCurrencyBalancesScreenKt.INSTANCE.m10730getLambda3$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoaded4VCsPreview.1
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
                    VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoaded4VCsPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void VirtualCurrencyBalancesScreenLoadedVCsPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1774472093);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VirtualCurrencyBalancesScreenLoadedVCsPreview)222@9134L455:VirtualCurrencyBalancesScreen.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1774472093, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenLoadedVCsPreview (VirtualCurrencyBalancesScreen.kt:221)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableSingletons$VirtualCurrencyBalancesScreenKt.INSTANCE.m10731getLambda4$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoadedVCsPreview.1
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
                    VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoadedVCsPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void VirtualCurrencyBalancesScreenLoadingPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(126970760);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VirtualCurrencyBalancesScreenLoadingPreview)239@9737L328:VirtualCurrencyBalancesScreen.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(126970760, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenLoadingPreview (VirtualCurrencyBalancesScreen.kt:238)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableSingletons$VirtualCurrencyBalancesScreenKt.INSTANCE.m10732getLambda5$revenuecatui_defaultsBc8Release(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoadingPreview.1
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
                    VirtualCurrencyBalancesScreenKt.VirtualCurrencyBalancesScreenLoadingPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final VirtualCurrencyBalancesScreenViewModel getVirtualCurrencyBalancesScreenViewModel(PurchasesType purchasesType, VirtualCurrencyBalancesScreenViewModel virtualCurrencyBalancesScreenViewModel, Composer composer, int i, int i2) {
        Composer composer2;
        composer.startReplaceGroup(-1589946380);
        ComposerKt.sourceInformation(composer, "C(getVirtualCurrencyBalancesScreenViewModel)175@7618L167:VirtualCurrencyBalancesScreen.kt#870w7w");
        if ((i2 & 1) != 0) {
            purchasesType = new PurchasesImpl(null, 1, 0 == true ? 1 : 0);
        }
        if ((i2 & 2) != 0) {
            VirtualCurrencyBalancesScreenViewModelFactory virtualCurrencyBalancesScreenViewModelFactory = new VirtualCurrencyBalancesScreenViewModelFactory(purchasesType);
            composer.startReplaceableGroup(1729797275);
            ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            composer2 = composer;
            ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(VirtualCurrencyBalancesScreenViewModel.class), current, (String) null, virtualCurrencyBalancesScreenViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composer2, 0, 0);
            composer2.endReplaceableGroup();
            virtualCurrencyBalancesScreenViewModel = (VirtualCurrencyBalancesScreenViewModel) viewModel;
        } else {
            composer2 = composer;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1589946380, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.getVirtualCurrencyBalancesScreenViewModel (VirtualCurrencyBalancesScreen.kt:180)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceGroup();
        return virtualCurrencyBalancesScreenViewModel;
    }
}
