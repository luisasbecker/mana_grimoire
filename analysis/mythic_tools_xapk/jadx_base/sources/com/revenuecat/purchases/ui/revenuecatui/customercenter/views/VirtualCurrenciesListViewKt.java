package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import android.icu.number.NumberFormatter;
import android.os.Build;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
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
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigDataExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.LocaleHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.icons.KeyboardArrowRightKt;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrency;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirtualCurrenciesListView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000b\u001aC\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0013\u001a7\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"MAX_NUMBER_OF_ROWS", "", "ShowAllVirtualCurrenciesRow", "", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "onAction", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/actions/CustomerCenterAction;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "VirtualCurrenciesListView", "virtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "appearance", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;", "(Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "VirtualCurrenciesListView_4_VCs_Preview", "(Landroidx/compose/runtime/Composer;I)V", "VirtualCurrenciesListView_5_VCs_Preview", "VirtualCurrencyRow", "virtualCurrency", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrency;", "position", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/ButtonPosition;", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrency;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/ButtonPosition;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrenciesListViewKt {
    private static final int MAX_NUMBER_OF_ROWS = 4;

    /* JADX INFO: compiled from: VirtualCurrenciesListView.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonPosition.values().length];
            try {
                iArr[ButtonPosition.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonPosition.FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonPosition.LAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonPosition.MIDDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ShowAllVirtualCurrenciesRow(final CustomerCenterConfigData.Localization localization, final Function1<? super CustomerCenterAction, Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(977423978);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShowAllVirtualCurrenciesRow)P(!1,2)194@7978L11,195@8058L11,196@8087L998,186@7556L1529:VirtualCurrenciesListView.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(localization) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(977423978, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ShowAllVirtualCurrenciesRow (VirtualCurrenciesListView.kt:185)");
                }
                Modifier modifier4 = companion;
                SurfaceKt.m4145SurfaceT9BRK9s(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), RoundedCornerShapeKt.m2346RoundedCornerShapea9UjIt4(CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM()), ColorSchemeKt.m3492surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable), Dp.m9114constructorimpl(2.0f)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-906812433, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.ShowAllVirtualCurrenciesRow.1
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

                    public final void invoke(Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C200@8193L62,197@8097L982:VirtualCurrenciesListView.kt#870w7w");
                        if ((i5 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-906812433, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ShowAllVirtualCurrenciesRow.<anonymous> (VirtualCurrenciesListView.kt:197)");
                        }
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        composer2.startReplaceGroup(160480015);
                        ComposerKt.sourceInformation(composer2, "CC(remember):VirtualCurrenciesListView.kt#9igjgp");
                        boolean zChanged = composer2.changed(function1);
                        final Function1<CustomerCenterAction, Unit> function12 = function1;
                        Object objRememberedValue = composer2.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt$ShowAllVirtualCurrenciesRow$1$1$1
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
                                    function12.invoke(CustomerCenterAction.ShowVirtualCurrencyBalances.INSTANCE);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        composer2.endReplaceGroup();
                        Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(ClickableKt.m1516clickableXHw0xAI$default(modifierFillMaxWidth$default, false, null, null, (Function0) objRememberedValue, 7, null), CustomerCenterConstants.Card.INSTANCE.m10691getCARD_PADDINGD9Ej5fM(), Dp.m9114constructorimpl(12.0f));
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        CustomerCenterConfigData.Localization localization2 = localization;
                        ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer2, 54);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2038paddingVpY3zN4);
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
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -2138390985, "C212@8791L10,213@8852L11,208@8561L325,218@9035L11,215@8899L170:VirtualCurrenciesListView.kt#870w7w");
                        TextKt.m4286Text4IGK_g(localization2.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.SEE_ALL_VIRTUAL_CURRENCIES), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 0, 0, 65530);
                        IconKt.m3736Iconww6aTOc(KeyboardArrowRightKt.getKeyboardArrowRight(), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary(), composer2, 48, 4);
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
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 112);
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.ShowAllVirtualCurrenciesRow.2
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

                    public final void invoke(Composer composer2, int i5) {
                        VirtualCurrenciesListViewKt.ShowAllVirtualCurrenciesRow(localization, function1, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & 147) == 146) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier modifier42 = companion;
            SurfaceKt.m4145SurfaceT9BRK9s(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), RoundedCornerShapeKt.m2346RoundedCornerShapea9UjIt4(CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM()), ColorSchemeKt.m3492surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable), Dp.m9114constructorimpl(2.0f)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-906812433, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.ShowAllVirtualCurrenciesRow.1
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

                public final void invoke(Composer composer2, int i5) {
                    ComposerKt.sourceInformation(composer2, "C200@8193L62,197@8097L982:VirtualCurrenciesListView.kt#870w7w");
                    if ((i5 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-906812433, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ShowAllVirtualCurrenciesRow.<anonymous> (VirtualCurrenciesListView.kt:197)");
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    composer2.startReplaceGroup(160480015);
                    ComposerKt.sourceInformation(composer2, "CC(remember):VirtualCurrenciesListView.kt#9igjgp");
                    boolean zChanged = composer2.changed(function1);
                    final Function1<? super CustomerCenterAction, Unit> function12 = function1;
                    Object objRememberedValue = composer2.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt$ShowAllVirtualCurrenciesRow$1$1$1
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
                                function12.invoke(CustomerCenterAction.ShowVirtualCurrencyBalances.INSTANCE);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    composer2.endReplaceGroup();
                    Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(ClickableKt.m1516clickableXHw0xAI$default(modifierFillMaxWidth$default, false, null, null, (Function0) objRememberedValue, 7, null), CustomerCenterConstants.Card.INSTANCE.m10691getCARD_PADDINGD9Ej5fM(), Dp.m9114constructorimpl(12.0f));
                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    CustomerCenterConfigData.Localization localization2 = localization;
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer2, 54);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2038paddingVpY3zN4);
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
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -2138390985, "C212@8791L10,213@8852L11,208@8561L325,218@9035L11,215@8899L170:VirtualCurrenciesListView.kt#870w7w");
                    TextKt.m4286Text4IGK_g(localization2.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.SEE_ALL_VIRTUAL_CURRENCIES), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 0, 0, 65530);
                    IconKt.m3736Iconww6aTOc(KeyboardArrowRightKt.getKeyboardArrowRight(), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary(), composer2, 48, 4);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 112);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier42;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void VirtualCurrenciesListView(final VirtualCurrencies virtualCurrencies, final CustomerCenterConfigData.Appearance appearance, final CustomerCenterConfigData.Localization localization, final Function1<? super CustomerCenterAction, Unit> onAction, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(virtualCurrencies, "virtualCurrencies");
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(882153333);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VirtualCurrenciesListView)P(4!2,3)64@3020L1705:VirtualCurrenciesListView.kt#870w7w");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(virtualCurrencies) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(appearance) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(localization) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onAction) ? 2048 : 1024;
        }
        int i4 = i2 & 16;
        if (i4 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((i3 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(882153333, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListView (VirtualCurrenciesListView.kt:47)");
                }
                if (!virtualCurrencies.getAll().isEmpty()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final Modifier modifier4 = companion;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.VirtualCurrenciesListView.1
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

                            public final void invoke(Composer composer3, int i5) {
                                VirtualCurrenciesListViewKt.VirtualCurrenciesListView(virtualCurrencies, appearance, localization, onAction, modifier4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                Modifier modifier5 = companion;
                List listSortedWith = CollectionsKt.sortedWith(virtualCurrencies.getAll().values(), new Comparator() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt$VirtualCurrenciesListView$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((VirtualCurrency) t2).getBalance()), Integer.valueOf(((VirtualCurrency) t).getBalance()));
                    }
                });
                List listTake = listSortedWith.size() <= 4 ? listSortedWith : CollectionsKt.take(listSortedWith, 3);
                int i5 = listSortedWith.size() > 4 ? 1 : 0;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null);
                Alignment.Horizontal start = Alignment.INSTANCE.getStart();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -596226986, "C73@3375L10,74@3432L11,69@3148L458:VirtualCurrenciesListView.kt#870w7w");
                int i6 = i3;
                int i7 = 1;
                TextKt.m4286Text4IGK_g(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.VIRTUAL_CURRENCY_BALANCES_SCREEN_HEADER), PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, CustomerCenterConstants.Layout.INSTANCE.m10701getSECTION_TITLE_BOTTOM_PADDINGD9Ej5fM(), 7, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge(), composerStartRestartGroup, 48, 0, 65528);
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(1781897041);
                ComposerKt.sourceInformation(composer2, "*93@4226L207");
                int i8 = 0;
                for (Object obj : listTake) {
                    int i9 = i8 + 1;
                    if (i8 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    VirtualCurrency virtualCurrency = (VirtualCurrency) obj;
                    composer2.startReplaceGroup(1781898119);
                    ComposerKt.sourceInformation(composer2, "82@3724L78");
                    if (i8 > 0) {
                        SpacerKt.Spacer(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, CustomerCenterConstants.Layout.INSTANCE.m10699getITEMS_SPACINGD9Ej5fM()), composer2, 6);
                    }
                    composer2.endReplaceGroup();
                    Composer composer3 = composer2;
                    VirtualCurrencyRow(appearance, localization, virtualCurrency, listTake.size() + i5 == i7 ? ButtonPosition.SINGLE : i8 == 0 ? ButtonPosition.FIRST : (i8 == listTake.size() - i7 && i5 == 0) ? ButtonPosition.LAST : ButtonPosition.MIDDLE, null, composer3, (i6 >> 3) & 126, 16);
                    composer2 = composer3;
                    i8 = i9;
                    i7 = i7;
                }
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(1781922644);
                ComposerKt.sourceInformation(composer2, "102@4493L78,104@4585L124");
                if (i5 != 0) {
                    SpacerKt.Spacer(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, CustomerCenterConstants.Layout.INSTANCE.m10699getITEMS_SPACINGD9Ej5fM()), composer2, 6);
                    ShowAllVirtualCurrenciesRow(localization, onAction, null, composer2, (i6 >> 6) & 126, 4);
                }
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.VirtualCurrenciesListView.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        invoke(composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i10) {
                        VirtualCurrenciesListViewKt.VirtualCurrenciesListView(virtualCurrencies, appearance, localization, onAction, modifier3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((i3 & 9363) == 9362) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (!virtualCurrencies.getAll().isEmpty()) {
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VirtualCurrenciesListView_4_VCs_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1658158529);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VirtualCurrenciesListView_4_VCs_Preview)237@9537L287,237@9510L314:VirtualCurrenciesListView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1658158529, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListView_4_VCs_Preview (VirtualCurrenciesListView.kt:234)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(1130083298, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.VirtualCurrenciesListView_4_VCs_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C238@9547L271:VirtualCurrenciesListView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1130083298, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListView_4_VCs_Preview.<anonymous> (VirtualCurrenciesListView.kt:238)");
                    }
                    VirtualCurrenciesListViewKt.VirtualCurrenciesListView(CustomerCenterConfigTestData.INSTANCE.getFourVirtualCurrencies(), CustomerCenterConfigTestData.INSTANCE.getStandardAppearance(), customerCenterConfigDataCustomerCenterData$default.getLocalization(), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.VirtualCurrenciesListView_4_VCs_Preview.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                            invoke2(customerCenterAction);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, null, composer2, 3072, 16);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.VirtualCurrenciesListView_4_VCs_Preview.2
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
                    VirtualCurrenciesListViewKt.VirtualCurrenciesListView_4_VCs_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VirtualCurrenciesListView_5_VCs_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1017072386);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VirtualCurrenciesListView_5_VCs_Preview)260@10276L287,260@10249L314:VirtualCurrenciesListView.kt#870w7w");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1017072386, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListView_5_VCs_Preview (VirtualCurrenciesListView.kt:257)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.rememberComposableLambda(488997155, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.VirtualCurrenciesListView_5_VCs_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C261@10286L271:VirtualCurrenciesListView.kt#870w7w");
                    if ((i2 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(488997155, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListView_5_VCs_Preview.<anonymous> (VirtualCurrenciesListView.kt:261)");
                    }
                    VirtualCurrenciesListViewKt.VirtualCurrenciesListView(CustomerCenterConfigTestData.INSTANCE.getFiveVirtualCurrencies(), CustomerCenterConfigTestData.INSTANCE.getStandardAppearance(), customerCenterConfigDataCustomerCenterData$default.getLocalization(), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.VirtualCurrenciesListView_5_VCs_Preview.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(CustomerCenterAction customerCenterAction) {
                            invoke2(customerCenterAction);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }
                    }, null, composer2, 3072, 16);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.VirtualCurrenciesListView_5_VCs_Preview.2
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
                    VirtualCurrenciesListViewKt.VirtualCurrenciesListView_5_VCs_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void VirtualCurrencyRow(final CustomerCenterConfigData.Appearance appearance, final CustomerCenterConfigData.Localization localization, final VirtualCurrency virtualCurrency, final ButtonPosition position, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean zChanged;
        Object objRememberedValue;
        int i4;
        RoundedCornerShape roundedCornerShapeM2345RoundedCornerShape0680j_4;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(virtualCurrency, "virtualCurrency");
        Intrinsics.checkNotNullParameter(position, "position");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1795037180);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VirtualCurrencyRow)P(!2,4,3)120@5018L358,148@6346L21,154@6591L11,155@6671L11,156@6700L653,151@6485L868:VirtualCurrenciesListView.kt#870w7w");
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
            i3 |= composerStartRestartGroup.changedInstance(virtualCurrency) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(position) ? 2048 : 1024;
        }
        int i5 = i2 & 16;
        if (i5 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((i3 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1795037180, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyRow (VirtualCurrenciesListView.kt:119)");
                }
                int balance = virtualCurrency.getBalance();
                composerStartRestartGroup.startReplaceGroup(-328888874);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VirtualCurrenciesListView.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(balance);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = Build.VERSION.SDK_INT < 30 ? NumberFormatter.with().locale(LocaleHelpersKt.createLocaleFromString(localization.getLocale())).format(Integer.valueOf(virtualCurrency.getBalance())).toString() : String.valueOf(virtualCurrency.getBalance());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final String str = (String) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                Intrinsics.checkNotNullExpressionValue(str, "remember(virtualCurrency…oString()\n        }\n    }");
                i4 = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
                if (i4 != 1) {
                    roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM());
                } else if (i4 == 2) {
                    roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2346RoundedCornerShapea9UjIt4(CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM());
                } else if (i4 == 3) {
                    roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2346RoundedCornerShapea9UjIt4(CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10693getROUNDED_CORNER_SIZED9Ej5fM());
                } else {
                    if (i4 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(CustomerCenterConstants.Card.INSTANCE.m10692getMIDDLE_CORNER_SIZED9Ej5fM());
                }
                Color colorForTheme = CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0), new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt$VirtualCurrencyRow$textColor$1
                    @Override // kotlin.jvm.functions.Function1
                    public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getTextColor();
                    }
                });
                composerStartRestartGroup.startReplaceGroup(-328845301);
                ComposerKt.sourceInformation(composerStartRestartGroup, "149@6458L11");
                final long onSurface = colorForTheme != null ? MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface() : colorForTheme.m6335unboximpl();
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier4 = companion;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4145SurfaceT9BRK9s(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), roundedCornerShapeM2345RoundedCornerShape0680j_4, ColorSchemeKt.m3492surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable), Dp.m9114constructorimpl(2.0f)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1744786209, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.VirtualCurrencyRow.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i6) {
                        ComposerKt.sourceInformation(composer3, "C157@6710L637:VirtualCurrenciesListView.kt#870w7w");
                        if ((i6 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1744786209, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyRow.<anonymous> (VirtualCurrenciesListView.kt:157)");
                        }
                        Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(Modifier.INSTANCE, CustomerCenterConstants.Card.INSTANCE.m10691getCARD_PADDINGD9Ej5fM(), Dp.m9114constructorimpl(12.0f));
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        VirtualCurrency virtualCurrency2 = virtualCurrency;
                        long j = onSurface;
                        String str2 = str;
                        ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer3, 54);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM2038paddingVpY3zN4);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer3);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 727204667, "C165@7023L205,172@7242L95:VirtualCurrenciesListView.kt#870w7w");
                        TextKt.m4286Text4IGK_g(virtualCurrency2.getName() + " (" + virtualCurrency2.getCode() + ')', (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8997getStarte0LSkKk()), 0L, 0, false, 2, 0, (Function1) null, (TextStyle) null, composer3, 0, 3072, 122362);
                        TextKt.m4286Text4IGK_g(str2, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composer2, 12582912, 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.VirtualCurrencyRow.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i6) {
                        VirtualCurrenciesListViewKt.VirtualCurrencyRow(appearance, localization, virtualCurrency, position, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((i3 & 9363) == 9362) {
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int balance2 = virtualCurrency.getBalance();
            composerStartRestartGroup.startReplaceGroup(-328888874);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VirtualCurrenciesListView.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(balance2);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = Build.VERSION.SDK_INT < 30 ? NumberFormatter.with().locale(LocaleHelpersKt.createLocaleFromString(localization.getLocale())).format(Integer.valueOf(virtualCurrency.getBalance())).toString() : String.valueOf(virtualCurrency.getBalance());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                final String str2 = (String) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                Intrinsics.checkNotNullExpressionValue(str2, "remember(virtualCurrency…oString()\n        }\n    }");
                i4 = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
                if (i4 != 1) {
                }
                Color colorForTheme2 = CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0), new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt$VirtualCurrencyRow$textColor$1
                    @Override // kotlin.jvm.functions.Function1
                    public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getTextColor();
                    }
                });
                composerStartRestartGroup.startReplaceGroup(-328845301);
                ComposerKt.sourceInformation(composerStartRestartGroup, "149@6458L11");
                if (colorForTheme2 != null) {
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier42 = companion;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4145SurfaceT9BRK9s(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), roundedCornerShapeM2345RoundedCornerShape0680j_4, ColorSchemeKt.m3492surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable), Dp.m9114constructorimpl(2.0f)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1744786209, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrenciesListViewKt.VirtualCurrencyRow.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i6) {
                        ComposerKt.sourceInformation(composer3, "C157@6710L637:VirtualCurrenciesListView.kt#870w7w");
                        if ((i6 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1744786209, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyRow.<anonymous> (VirtualCurrenciesListView.kt:157)");
                        }
                        Modifier modifierM2038paddingVpY3zN4 = PaddingKt.m2038paddingVpY3zN4(Modifier.INSTANCE, CustomerCenterConstants.Card.INSTANCE.m10691getCARD_PADDINGD9Ej5fM(), Dp.m9114constructorimpl(12.0f));
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        VirtualCurrency virtualCurrency2 = virtualCurrency;
                        long j = onSurface;
                        String str22 = str2;
                        ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer3, 54);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM2038paddingVpY3zN4);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer3);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 727204667, "C165@7023L205,172@7242L95:VirtualCurrenciesListView.kt#870w7w");
                        TextKt.m4286Text4IGK_g(virtualCurrency2.getName() + " (" + virtualCurrency2.getCode() + ')', (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m8985boximpl(TextAlign.INSTANCE.m8997getStarte0LSkKk()), 0L, 0, false, 2, 0, (Function1) null, (TextStyle) null, composer3, 0, 3072, 122362);
                        TextKt.m4286Text4IGK_g(str22, (Modifier) null, j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer3, 0, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composer2, 12582912, 112);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42;
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
